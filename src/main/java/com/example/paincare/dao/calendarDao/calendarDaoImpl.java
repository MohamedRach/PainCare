package com.example.paincare.dao.calendarDao;

import com.example.paincare.Bean.blogBean;
import com.example.paincare.Bean.calendarBean;
import com.example.paincare.dao.DAOException;
import com.example.paincare.dao.daoFacroty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class calendarDaoImpl implements calendarDao {

    private daoFacroty DAO;
    public calendarDaoImpl(daoFacroty daoFacroty) {this.DAO = daoFacroty;};

    private calendarBean map(ResultSet resultSet) throws SQLException {
        calendarBean event = new calendarBean();
        event.setDay(resultSet.getInt("day"));
        event.setMonth(resultSet.getInt("month"));
        event.setYear(resultSet.getInt("year"));
        event.setEventName(resultSet.getString("eventName"));
        event.setEventFrom(resultSet.getString("eventFrom"));
        event.setEventTo(resultSet.getString("eventTo"));
        event.setUser_id(resultSet.getInt("user_id"));

        return event;
    }

    public static PreparedStatement initRequestPrepare(Connection connexion, String sql, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }

    public ArrayList<calendarBean> getEvents(Integer id) throws DAOException {
        final String SQL_QUERY = "SELECT * FROM calendar where user_id =" + id;
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        calendarBean event = null;
        ArrayList<calendarBean> array = new ArrayList<calendarBean>();
        try {
            connexion = daoFacroty.getConnection();
            preparedStatement = initRequestPrepare(connexion, SQL_QUERY);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                event = map(resultSet);
                array.add(event);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return array;
    }

    public void create(calendarBean event) throws DAOException {
        final String SQL_INSERT = "INSERT INTO calendar (day,month, year,eventName, eventFrom, eventTo, user_id ) VALUES (?,?, ? ,?,?,?,?)";

        try (Connection connexion = daoFacroty.getConnection();
             PreparedStatement preparedStatement = initRequestPrepare(connexion, SQL_INSERT,event.getDay(), event.getMonth(), event.getYear(),event.getEventName(), event.getEventFrom(), event.getEventTo(), event.getUser_id())) {

            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOException("Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table.");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
