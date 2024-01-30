package com.example.paincare.servlets;

import com.example.paincare.Bean.calendarBean;
import com.example.paincare.dao.calendarDao.calendarDao;
import com.example.paincare.dao.calendarDao.calendarDaoImpl;
import com.example.paincare.dao.daoFacroty;
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


@WebServlet(name = "calendarData", value = "/calendarData")
public class calendarData extends HttpServlet {
    private calendarDao dao;
    public void init(){
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.dao = new calendarDaoImpl(dao_Factory);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("id");
        ArrayList<calendarBean> events = dao.getEvents(userId);
        JSONArray eventsArray = new JSONArray();
        for (int i = 0; i < events.size(); i++){
            JSONObject event1 = new JSONObject();
            event1.put("day", events.get(i).getDay());
            event1.put("month", events.get(i).getMonth());
            event1.put("year", events.get(i).getYear());
            JSONArray subEventsArray1 = new JSONArray();
            JSONObject subEvent1 = new JSONObject();
            subEvent1.put("title", events.get(i).getEventName());
            subEvent1.put("time", events.get(i).getEventFrom() +"-" + events.get(i).getEventTo());
            subEventsArray1.add(subEvent1);
            event1.put("events", subEventsArray1);
            eventsArray.add(event1);
        }
        String jsonString = eventsArray.toJSONString();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        System.out.println(jsonString);
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}