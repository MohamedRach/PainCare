package com.example.paincare.servlets.pain;

import com.example.paincare.Bean.testBean;
import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.painDao.painDaoImpl;
import com.example.paincare.dao.painDao.painTestDaoImpl;
import com.example.paincare.dao.painDao.painTestDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "painTest", value = "/painTest")
public class painTest extends HttpServlet {
    private painTestDao painTestDao;
    public void init() {
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.painTestDao = new painTestDaoImpl(dao_Factory);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/painTest.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float startPeriod =Float.parseFloat(request.getParameter("startPeriod"));
        float menstrualCycle =Float.parseFloat(request.getParameter("menstrualCycle"));
        float endometriosis =Float.parseFloat(request.getParameter("endometriosis"));
        float giveBirth =Float.parseFloat(request.getParameter("giveBirth"));
        float pregnancyTroubles =Float.parseFloat(request.getParameter("pregnancyTroubles"));
        float weight =Float.parseFloat(request.getParameter("weight"));
        float height =Float.parseFloat(request.getParameter("height"));
        float painIntensity =Float.parseFloat(request.getParameter("painIntensity"));
        float pelvicPain =Float.parseFloat(request.getParameter("pelvicPain"));
        float intercoursePain =Float.parseFloat(request.getParameter("intercoursePain"));
        float painWorse =Float.parseFloat(request.getParameter("painWorse"));
        float periodDuration =Float.parseFloat(request.getParameter("periodDuration"));
        float periodNature =Float.parseFloat(request.getParameter("periodNature"));
        float cyclePattern =Float.parseFloat(request.getParameter("cyclePattern"));
        float having =Float.parseFloat(request.getParameter("having"));
        float victim =Float.parseFloat(request.getParameter("victim"));

        float bmi = weight / (float) Math.pow(height/100, 2);

        float indice =  startPeriod + menstrualCycle + endometriosis + giveBirth + pregnancyTroubles + painIntensity + pelvicPain + intercoursePain + painWorse + periodDuration + periodNature + cyclePattern + having + victim;
        String result;
        if (bmi >= 25 || bmi <= 18.5) {
            indice += 2;
        }

        if (indice >= 20) {
            result = "High";
        } else if (indice <12) {
            result = "Low";
        } else {
            result = "Moderate";
        }

        testBean bean = new testBean();
        bean.setResult(result);
        bean.setUser_id(1);

        painTestDao.create(bean);

    }
}