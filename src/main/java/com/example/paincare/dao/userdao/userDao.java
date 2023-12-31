package com.example.paincare.dao.userdao;
import java.util.ArrayList;

import com.example.paincare.Bean.userBean;
import com.example.paincare.dao.DAOException;
public interface userDao {
    void create( userBean user ) throws DAOException;
    void update(userBean user) throws DAOException;
    void delete(int id) throws DAOException;
    userBean find(int id) throws DAOException;
    userBean findByEmail(String email) throws DAOException;
    ArrayList<userBean> getAllUsers() throws DAOException;
}

