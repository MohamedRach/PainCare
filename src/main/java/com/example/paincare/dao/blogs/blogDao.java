package com.example.paincare.dao.blogs;

import com.example.paincare.dao.DAOException;
import com.example.paincare.Bean.blogBean;

import java.util.ArrayList;

public interface blogDao {
    public void create(blogBean blog) throws DAOException;
    public ArrayList<blogBean> getBlogs() throws DAOException;

    public blogBean find(int id) throws DAOException;
}
