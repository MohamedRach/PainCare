package com.example.paincare.dao.blogs;

import com.example.paincare.dao.DAOException;
import com.example.paincare.dao.daoFacroty;
import com.example.paincare.Bean.blogBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class blogDaoImpl implements blogDao{

    private daoFacroty DAO;
    public blogDaoImpl(daoFacroty daoFacroty) {this.DAO = daoFacroty;};

    private blogBean map(ResultSet resultSet) throws SQLException {
        blogBean blogBean = new blogBean();
        blogBean.setId(resultSet.getInt("id"));
        blogBean.setDescription(resultSet.getString("description"));
        blogBean.setTitle(resultSet.getString("title"));

        return blogBean;
    }

    public static PreparedStatement initRequestPrepare(Connection connexion, String sql, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }

    @Override
    public ArrayList<blogBean> getBlogs() throws DAOException {
        final String SQL_QUERY = "SELECT * FROM blogs";
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        blogBean blogBean = null;
        ArrayList<blogBean> array = new ArrayList<blogBean>();
        try {
            connexion = daoFacroty.getConnection();
            preparedStatement = initRequestPrepare(connexion, SQL_QUERY);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                blogBean = map(resultSet);
                array.add(blogBean);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return array;
    }

    @Override
    public blogBean find(int id) throws DAOException {
        final String SQL_QUERY = "SELECT * FROM blogs where id = ?";
        blogBean bean = null;
        ResultSet resultSet = null;
        try (Connection connexion = daoFacroty.getConnection();
             PreparedStatement preparedStatement = initRequestPrepare(connexion, SQL_QUERY,id)) {

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                bean = map(resultSet);

            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return bean;
    }

    @Override
    public void create(blogBean blog) throws DAOException {
        final String SQL_INSERT = "INSERT INTO blogs (title,description, user_id,imageLink ) VALUES (?,?, ? ,?)";

        try (Connection connexion = daoFacroty.getConnection();
             PreparedStatement preparedStatement = initRequestPrepare(connexion, SQL_INSERT,blog.getTitle(), blog.getDescription(), blog.getUser_id(),blog.getImageLink())) {

            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
