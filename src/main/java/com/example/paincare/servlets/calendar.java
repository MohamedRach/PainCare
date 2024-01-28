package com.example.paincare.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "calendar", value = "/calendar")
public class calendar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String day = "28";
        String month = "1";
        String year = "2024";
        String eventName = "gog";
        String eventFrom = "12:00 PM";
        String eventTo = "13:00 PM";

        RequestDispatcher dispatcher = request.getRequestDispatcher("calendar.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String eventName = request.getParameter("eventName");
        String eventFrom = request.getParameter("eventFrom");
        String eventTo = request.getParameter("eventTo");
        System.out.println(year);
        System.out.println(day);
        System.out.println(month);
        System.out.println(eventName);
        System.out.println(eventFrom);
        System.out.println(eventTo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("calendar.jsp");
        dispatcher.forward(request, response);
    }
}