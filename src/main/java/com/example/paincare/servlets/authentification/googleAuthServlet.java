package com.example.paincare.servlets.authentification;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.example.paincare.Bean.userBean;

import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.userdao.userDaoImpl;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.paincare.dao.userdao.userDao;
public class googleAuthServlet extends HttpServlet {
    private userDao userDao;
    private authentification auth;
    private googleAuth google_auth;
    public void init() {
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.google_auth = googleAuth.getInstance();
        this.auth = new authentification();
        this.userDao = new userDaoImpl(dao_Factory);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Forward the request to the JSP page for creating a new user
        String code = request.getParameter("code");
        ArrayList<String> tokens = this.google_auth.getToken(code);
        HttpRequest user_request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=" + tokens.get(0)))
                .header("Authorization", "Bearer" + tokens.get(1))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> user_response = null;
        try {
            user_response = HttpClient.newHttpClient().send(user_request, HttpResponse.BodyHandlers.ofString());

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(user_response.body());
            String nom = (String) obj.get("family_name");
            String prenom = (String) obj.get("given_name");
            String email = (String) obj.get("email");
            String pass = this.auth.hash("DEFAULT_PASSWORD".toCharArray());
            userBean user = userDao.findByEmail(email);
            if( user == null) {
                userBean newUser = new userBean();
                newUser.setNom(nom);
                newUser.setPrenom(prenom);
                newUser.setEmail(email);
                newUser.setPassword(pass);
                userDao.create(newUser);
                userBean user1 = userDao.findByEmail(email);
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("id", user1.getId());
                // Redirect to the /users page after successful creation
                response.sendRedirect(request.getContextPath() + "/dashboard");
            } else {
                    HttpSession session = request.getSession();

                    session.setAttribute("email", email);
                    session.setAttribute("id", user.getId());

                    // Redirect to the /users page after successful creation
                    response.sendRedirect(request.getContextPath() + "/dashboard");

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ParseException pe) {
            throw new RuntimeException(pe);
        }

    }
}

