package com.example.paincare.servlets.blogs;

import com.example.paincare.Bean.commentBean;
import com.example.paincare.dao.blogs.blogDaoImpl;
import com.example.paincare.dao.blogs.commentDaoImpl;
import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.blogs.commentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import com.example.paincare.Bean.blogBean;
import com.example.paincare.dao.blogs.blogDao;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "blog", value = "/blog")
public class addblog extends HttpServlet {
    private blogDao dao;
    private commentDao commentDao;
    public void init() {
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.dao = new blogDaoImpl(dao_Factory);
        this.commentDao = new commentDaoImpl(dao_Factory);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<blogBean> blogs =dao.getBlogs();
        request.setAttribute("blogs", blogs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addblog.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId"); // Assurez-vous que "userId" est correctement défini dans votre application.
        Integer blogId = (Integer) session.getAttribute("blogId"); // Assurez-vous que "blogId" est correctement défini dans votre application.
        if(request.getParameter("hidden") != null) {
            commentBean comment = new commentBean();
            String content = request.getParameter("comment");
            comment.setComment(content);
            comment.setBlog_id(blogId);
            comment.setUser_id(userId);
            commentDao.create(comment);

        } else {
            blogBean blog = new blogBean();
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            blog.setTitle(title);
            blog.setDescription(description);
            blog.setUser_id(userId);
            dao.create(blog);
        }


    }
}