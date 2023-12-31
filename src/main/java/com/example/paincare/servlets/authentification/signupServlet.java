package com.example.paincare.servlets.authentification;
import java.io.IOException;

import com.example.paincare.Bean.userBean;

import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.userdao.userDaoImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.paincare.dao.userdao.userDao;

public class signupServlet extends HttpServlet {
    private userDao userDao;
    private authentification auth;
    public void init() {
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.userDao = new userDaoImpl(dao_Factory);
        this.auth = new authentification();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Forward the request to the JSP page for creating a new user
        RequestDispatcher dispatcher = request.getRequestDispatcher("/signup.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Extract user data from the form
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String pass = this.auth.hash(password.toCharArray());
        userBean user = userDao.findByEmail(email);
        if (user == null) {
            try {

                userBean newUser = new userBean();
                newUser.setNom(nom);
                newUser.setPrenom(prenom);
                newUser.setEmail(email);
                newUser.setPassword(pass);
                userDao.create(newUser);
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                // Redirect to the /users page after successful creation
                response.sendRedirect(request.getContextPath() + "/users");


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }




    }




}