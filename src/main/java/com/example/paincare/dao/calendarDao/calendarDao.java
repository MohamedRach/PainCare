package com.example.paincare.dao.calendarDao;

import com.example.paincare.Bean.calendarBean;
import com.example.paincare.dao.DAOException;

import java.util.ArrayList;

public interface calendarDao {

    public void create(calendarBean event) throws DAOException;
    public ArrayList<calendarBean> getEvents(Integer id) throws DAOException;

}
