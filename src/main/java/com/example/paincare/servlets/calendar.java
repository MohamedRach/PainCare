package com.example.paincare.servlets;

import com.example.paincare.Bean.calendarBean;
import com.example.paincare.dao.calendarDao.calendarDao;
import com.example.paincare.dao.calendarDao.calendarDaoImpl;
import com.example.paincare.dao.daoFacroty;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "calendar", value = "/calendar")
public class calendar extends HttpServlet {

    private calendarDao dao;
    public void init(){
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.dao = new calendarDaoImpl(dao_Factory);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("calendar.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("id");
        int day = Integer.parseInt(request.getParameter("day"));
        int month = Integer.parseInt(request.getParameter("month"));
        int year = Integer.parseInt(request.getParameter("year"));
        String eventName = request.getParameter("eventName");
        String eventFrom = request.getParameter("eventFrom");
        String eventTo = request.getParameter("eventTo");
        calendarBean event = new calendarBean();
        event.setDay(day);
        event.setMonth(month);
        event.setYear(year);
        event.setEventName(eventName);
        event.setEventTo(eventTo);
        event.setEventFrom(eventFrom);
        event.setUser_id(userId);
        dao.create(event);
        RequestDispatcher dispatcher = request.getRequestDispatcher("calendar.jsp");
        dispatcher.forward(request, response);
    }
}