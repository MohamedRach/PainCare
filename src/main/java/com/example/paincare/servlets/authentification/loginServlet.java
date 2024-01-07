package com.example.paincare.servlets.authentification;

import com.example.paincare.dao.DAOException;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.paincare.Bean.userBean;

import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.userdao.userDaoImpl;
import com.example.paincare.dao.userdao.userDao;
public class loginServlet extends HttpServlet {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Extract user data from the form
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (type != null) {
            String url = google_auth.generateUrl();
            response.sendRedirect(request.getContextPath() + url);
        } else {
            try {
                // find the user in the database
                userBean User = userDao.findByEmail(email);
                boolean auth_success = this.auth.authenticate(password.toCharArray(), User.getPassword());
                if(auth_success) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", User.getId());
                    session.setAttribute("email", email);
                    // Redirect to the /users page after successful creation
                    response.sendRedirect(request.getContextPath() + "/dashboard");
                } else {
                    System.out.println("unauthorized");
                }

            } catch (DAOException e) {
                // Handle errors (you might want to display an error message or log the exception)
                e.printStackTrace();
                response.getWriter().println("Error creating user");
            }
        }






    }
}
