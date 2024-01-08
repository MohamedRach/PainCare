package com.example.paincare.servlets.pain;

import com.example.paincare.Bean.painBean;
import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.painDao.painDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.paincare.dao.painDao.painDao;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "painCare", value = "/painCare")
public class painCare extends HttpServlet {
    private painDao painDao;
    public void init() {
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.painDao = new painDaoImpl(dao_Factory);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("id") == null){
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/addPain.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String level = request.getParameter("level");
        String location = request.getParameter("location");
        String symptoms = request.getParameter("symptoms");
        String painWorse = request.getParameter("painWorse");
        String feeling = request.getParameter("feeling");
        painBean pain = new painBean();
        System.out.println(level);
        pain.setLevel(Integer.parseInt(level));
        pain.setLocation(location);
        pain.setSymptoms(symptoms);
        pain.setPainWorse(painWorse);
        pain.setFeeling(feeling);
        pain.setId_user((int) session.getAttribute("id"));
        painDao.create(pain);
        response.sendRedirect(request.getContextPath() + "/dashboard");
    }
}