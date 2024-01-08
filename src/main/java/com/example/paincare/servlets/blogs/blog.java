package com.example.paincare.servlets.blogs;

import com.example.paincare.Bean.commentBean;
import com.example.paincare.Bean.userBean;
import com.example.paincare.dao.blogs.blogDaoImpl;
import com.example.paincare.dao.blogs.commentDaoImpl;
import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.userdao.userDao;
import com.example.paincare.dao.blogs.commentDao;
import com.example.paincare.dao.userdao.userDaoImpl;
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
public class blog extends HttpServlet {
    private blogDao dao;
    private commentDao commentDao;
    private userDao userDao;
    public void init() {
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.dao = new blogDaoImpl(dao_Factory);
        this.commentDao = new commentDaoImpl(dao_Factory);
        this.userDao = new userDaoImpl(dao_Factory);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("id") == null){
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            if (request.getParameter("id") != null) {
                ArrayList<commentBean> comments = commentDao.comments(Integer.parseInt(request.getParameter("id")));
                blogBean blog = dao.find(Integer.parseInt(request.getParameter("id")));

                ArrayList<userBean> users = new ArrayList<>();
                for (commentBean comment : comments) {
                    ArrayList<Object> usersComments = new ArrayList<>();
                    userBean user = userDao.find(comment.getUser_id());
                    users.add(user);
                }


                request.setAttribute("comments", comments);
                request.setAttribute("users", users);


                request.setAttribute("blog", blog);
                RequestDispatcher dispatcher = request.getRequestDispatcher("blog.jsp");
                dispatcher.forward(request, response);
            } else {
                ArrayList<blogBean> blogs = dao.getBlogs();
                request.setAttribute("blogs", blogs);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/blogs.jsp");
                dispatcher.forward(request, response);


            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            int id = ( int) session.getAttribute("id");
            if(request.getParameter("hidden") != null) {
                commentBean comment = new commentBean();
                String content = request.getParameter("comment");
                comment.setComment(content);
                comment.setBlog_id(Integer.parseInt(request.getParameter("blogId")));
                comment.setUser_id(id);
                commentDao.create(comment);
                response.sendRedirect(request.getContextPath() + "/blog?id=" + Integer.parseInt(request.getParameter("blogId")));

            } else {
                blogBean blog = new blogBean();

                String title = request.getParameter("title");
                String description = request.getParameter("description");
                blog.setTitle(title);
                blog.setDescription(description);
                blog.setUser_id(id);
                dao.create(blog);
                response.sendRedirect(request.getContextPath() + "/blog");
            }






    }
}