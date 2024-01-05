package com.example.paincare.dao.painDao;

import com.example.paincare.Bean.painBean;
import com.example.paincare.Bean.testBean;
import com.example.paincare.dao.DAOException;

public interface painTestDao {
    void create( testBean test ) throws DAOException;
    testBean find(int user_id) throws DAOException;

}
