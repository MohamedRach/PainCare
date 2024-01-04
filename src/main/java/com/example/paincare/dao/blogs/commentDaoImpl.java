package com.example.paincare.dao.blogs;

import com.example.paincare.Bean.commentBean;
import com.example.paincare.Bean.painBean;
import com.example.paincare.dao.DAOException;
import com.example.paincare.dao.daoFacroty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class commentDaoImpl implements commentDao{
    private daoFacroty DAO;
    public commentDaoImpl(daoFacroty daoFacroty){this.DAO = daoFacroty;}

    public commentBean map(ResultSet resultSet) throws SQLException {
        commentBean comment = new commentBean();
        comment.setId(resultSet.getInt("id"));
        comment.setComment(resultSet.getString("content"));
        comment.setBlog_id(resultSet.getInt("blog_id"));
        comment.setUser_id(resultSet.getInt("user_id"));
        comment.setCreated_at(resultSet.getDate("created_at"));

        return comment;
    }

    public static PreparedStatement initRequestPrepare(Connection connexion, String sql, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
    public void create(commentBean comment) throws DAOException {
        final String SQL_INSERT = "INSERT INTO comments (content,blog_id, user_id) VALUES (?,?, ?)";

        try (Connection connexion = daoFacroty.getConnection();
             PreparedStatement preparedStatement = initRequestPrepare(connexion, SQL_INSERT,comment.getComment(), comment.getBlog_id(),  comment.getUser_id())) {

            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public ArrayList<commentBean> comments(int blog_id) throws DAOException {
        final String SQL_SELECT = "SELECT * FROM comments where blog_id = ?";
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        commentBean comment = null;
        ArrayList<commentBean> comments = new ArrayList<commentBean>();
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFacroty.getConnection();
            preparedStatement = initRequestPrepare( connexion, SQL_SELECT, blog_id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while ( resultSet.next() ) {

                comment = map( resultSet );
                comments.add(comment);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        }
        return comments;
    }
}
