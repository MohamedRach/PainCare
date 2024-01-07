package com.example.paincare;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.example.paincare.dao.daoFacroty;
import com.example.paincare.dao.painDao.painDaoImpl;
import com.example.paincare.dao.painDao.painTestDao;
import com.example.paincare.dao.painDao.painDao;
import com.example.paincare.dao.painDao.painTestDaoImpl;
import com.example.paincare.Bean.painBean;
import com.example.paincare.Bean.testBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/dashboard")
public class HelloServlet extends HttpServlet {
    private painTestDao painTestDao;
    private painDao painDao;
    public void init() {
        daoFacroty dao_Factory = daoFacroty.getInstance();
        this.painTestDao = new painTestDaoImpl(dao_Factory);
        this.painDao = new painDaoImpl(dao_Factory);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<painBean> pains = painDao.getAllPains(1);
        testBean test = painTestDao.find(1);
        ArrayList<Integer> data1 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,0));
        ArrayList<Integer> data2 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,0,0));
        ArrayList<Integer> data3 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,0,0));
        ArrayList<Integer> data4 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        ArrayList<Object> data5 = new ArrayList<>();
        Random random = new Random();
        switch (test.getResult()){
            case "Low":
                int randomNumber = random.nextInt(30  + 1) ;
                data5.add("Low");
                data5.add(randomNumber);
                break;
            case "Moderate":
                int randomNumber1 = random.nextInt(60 - 31  + 1) + 31 ;
                data5.add("Moderate");
                data5.add(randomNumber1);
                break;
            case "High":
                int randomNumber2 = random.nextInt(100 - 61  + 1) + 61 ;
                data5.add("High");
                data5.add(randomNumber2);
                break;
        }

        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i< pains.size(); i++) {
            ArrayList<Object> p = new ArrayList<>();
            p.add(dateFormat.format(pains.get(i).getCreated_at()));
            p.add(pains.get(i).getLevel());
            data.add(p);

            switch (pains.get(i).getLocation()){
                case "abdomen":
                    data1.set(0, data1.get(0) + 1);
                    break;
                case "back":
                    data1.set(1, data1.get(1) + 1);
                    break;
                case "chest":
                    data1.set(2, data1.get(2) + 1);
                    break;
                case "head":
                    data1.set(3, data1.get(3) + 1);
                    break;
                case "neck":
                    data1.set(4, data1.get(4) + 1);
                    break;
                case "hips":
                    data1.set(5, data1.get(5) + 1);
                    break;
            }
            switch (pains.get(i).getSymptoms()){
                case "cramps":
                    data2.set(0, data2.get(0) + 1);
                    break;
                case "tenderBreast":
                    data2.set(1, data2.get(1) + 1);
                    break;
                case "headache":
                    data2.set(2, data2.get(2) + 1);
                    break;
                case "acne":
                    data2.set(3, data2.get(3) + 1);
                    break;
                case "fatigue":
                    data2.set(4, data2.get(4) + 1);
                    break;
                case "bloating":
                    data2.set(5, data2.get(5) + 1);
                    break;
                case "craving":
                    data2.set(6, data2.get(6) + 1);
                    break;
            }
            switch (pains.get(i).getPainWorse()){
                case "lackOfSleep":
                    data3.set(0, data3.get(0) + 1);
                    break;
                case "sitting":
                    data3.set(1, data3.get(1) + 1);
                    break;
                case "standing":
                    data3.set(2, data3.get(2) + 1);
                    break;
                case "stress":
                    data3.set(3, data3.get(3) + 1);
                    break;
                case "walking":
                    data3.set(4, data3.get(4) + 1);
                    break;
                case "exercice":
                    data3.set(5, data3.get(5) + 1);
                    break;
                case "urination":
                    data3.set(6, data3.get(6) + 1);
                    break;
            }
            switch (pains.get(i).getFeeling()){
                case "anxious":
                    data4.set(0, data4.get(0) + 1);
                    break;
                case "depressed":
                    data4.set(1, data4.get(1) + 1);
                    break;
                case "dizzy":
                    data4.set(2, data4.get(2) + 1);
                    break;
                case "vomiting":
                    data4.set(3, data4.get(3) + 1);
                    break;
                case "diarrhea":
                    data4.set(4, data4.get(4) + 1);
                    break;
            }

        }

        request.setAttribute("data1", data1);
        request.setAttribute("data2", data2);
        request.setAttribute("data3", data3);
        request.setAttribute("data4", data4);
        request.setAttribute("data5", data5);
        request.setAttribute("data", data);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}