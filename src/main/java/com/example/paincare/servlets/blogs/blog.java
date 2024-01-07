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
import com.example.paincare.Bean.blogBean;
import com.example.paincare.dao.blogs.blogDao;

@WebServlet(name = "blog", value = "/blog")
public class blog extends HttpServlet {
    private blogDao dao;
    private commentDao commentDao;
    public void init() {
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.dao = new blogDaoImpl(dao_Factory);
        this.commentDao = new commentDaoImpl(dao_Factory);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/createBlog.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("hidden") != null) {
            commentBean comment = new commentBean();
            String content = request.getParameter("comment");
            comment.setComment(content);
            comment.setBlog_id(1);
            comment.setUser_id(1);
            commentDao.create(comment);

        } else {
            blogBean blog = new blogBean();
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            blog.setTitle(title);
            blog.setDescription(description);
            blog.setUser_id(1);
            dao.create(blog);
        }


    }
}