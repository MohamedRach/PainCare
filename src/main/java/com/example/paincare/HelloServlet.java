package com.example.paincare;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i< pains.size(); i++) {
            ArrayList<Object> p = new ArrayList<>();
            p.add(dateFormat.format(pains.get(i).getCreated_at()));
            p.add(pains.get(i).getLevel());
            data.add(p);

        }
        request.setAttribute("data", data);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}