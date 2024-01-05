package com.example.paincare.dao.blogs;

import com.example.paincare.Bean.commentBean;
import com.example.paincare.dao.DAOException;

import java.util.ArrayList;

public interface commentDao {
    public void create (commentBean comment) throws DAOException;
    public ArrayList<commentBean> comments(int blog_id) throws DAOException;
}
