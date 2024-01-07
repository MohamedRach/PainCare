package com.example.paincare.servlets.blogs;

import com.example.paincare.Bean.blogBean;
import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.blogs.blogDao;
import com.example.paincare.dao.blogs.blogDaoImpl;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import com.example.paincare.dao.DAOException;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.paincare.Bean.userBean;

import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.userdao.userDaoImpl;
import com.example.paincare.dao.userdao.userDao;

@WebServlet(name = "viewblog", value = { "/viewblog" })
public class viewblog extends HttpServlet {
    private userDao userDAO;
    private blogDao blogDAO;

    public void init() throws ServletException {
        daoFacroty daoFactory = daoFacroty.getInstance();
        this.userDAO = new userDaoImpl(daoFactory);
        this.blogDAO = new blogDaoImpl(daoFactory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<blogBean> blogs = blogDAO.getBlogs();
        request.setAttribute("blog", blogs);
        getServletContext().getRequestDispatcher("/viewblog.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Gérer les actions POST si nécessaire
        doGet(request, response);
    }
}
