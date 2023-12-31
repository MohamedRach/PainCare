package com.example.paincare.dao.painDao;

import com.example.paincare.Bean.painBean;
import com.example.paincare.dao.DAOException;

import java.util.ArrayList;

public interface painDao {
    void create( painBean pain ) throws DAOException;
    void update(painBean pain) throws DAOException;
    void delete(int id) throws DAOException;
    painBean find(int id) throws DAOException;
    ArrayList<painBean> getAllPains(int id) throws DAOException;
}
