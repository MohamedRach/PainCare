package com.example.paincare.servlets.blogs;

import com.example.paincare.Bean.commentBean;
import com.example.paincare.dao.blogs.blogDaoImpl;
import com.example.paincare.dao.blogs.commentDaoImpl;
import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.blogs.commentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.example.paincare.Bean.blogBean;
import com.example.paincare.dao.blogs.blogDao;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "blog", value = "/blog")
@MultipartConfig
public class addblog extends HttpServlet {
    private blogDao dao;

    private static final String WEB_CONTENT_DIR   = "C:/Users/User0/Desktop/projet jee/PainCare/src/main/webapp";

    private static final String BLOGS_IMAGES_DIR = "/posts/";

    private commentDao commentDao;
    public void init() {
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.dao = new blogDaoImpl(dao_Factory);
        this.commentDao = new commentDaoImpl(dao_Factory);

    }
    private static String getMeidaExt(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");

                return filename.substring(filename.lastIndexOf('.') + 1);
            }
        }
        return null;
    }
    private static String savePart(Part image) {
        long id = System.currentTimeMillis();
        String ext = getMeidaExt(image);
        String uploadPath = WEB_CONTENT_DIR + BLOGS_IMAGES_DIR + id + "." + ext;

        try (InputStream input = image.getInputStream();
             OutputStream output = new FileOutputStream(uploadPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BLOGS_IMAGES_DIR + id + "." + ext;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("id") == null){
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            ArrayList<blogBean> blogs = dao.getBlogs();
            request.setAttribute("blogs", blogs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/addblog.jsp");
            dispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("id"); // Assurez-vous que "userId" est correctement défini dans votre application.


        blogBean blog = new blogBean();
        String title = request.getParameter("title");
        Part image = request.getPart("image");
        System.out.println("**********************"+title);
        String description = request.getParameter("description");
        String imageLink = savePart(image);

        blog.setTitle(title);
        blog.setDescription(description);
        blog.setUser_id(userId);
        blog.setImageLink(imageLink);
        dao.create(blog);
        response.sendRedirect(request.getContextPath() + "/blog");




    }
}