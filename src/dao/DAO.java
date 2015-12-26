package dao;

import dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * I am an Abstract class to define an implementation of a DAO class.
 * I describe how an Object interact with the Database.
 * <p>
 * I use a ConnectionBdd to act.
 *
 * @param <T> I am the class that the DAO need to manage.
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public abstract class DAO<T> {

    /**
     * I am the connection use by the DAO to communicate with the database.
     */
    protected Connection connection = null;

    /**
     * I am an constructor. I initialize the connection.
     */
    public DAO() {
        this.connection = ConnectionBdd.current().getConnection();
    }

    /**
     * I am a method to insert an Object into a database.
     *
     * @param obj the object I need to add to the database.
     * @return the same object with some modification if needed. For example the method can add an id to the object.
     * @throws DAOException I am raise if the method cannot insert the object into the database.
     */
    public abstract T create(T obj) throws DAOException;

    /**
     * I am a method that delete an object from the database.
     *
     * @param obj the object to delete.
     * @throws DAOException I am raise if the method cannot delete the object from the database.
     */
    public abstract void delete(T obj) throws DAOException;


    /**
     * I am a method to update an object into the database.
     *
     * @param obj the object to update.
     * @return the object updated.
     * @throws DAOException I am raise if the method cannot update the object.
     */
    public abstract T update(T obj) throws DAOException;

    /**
     * I am a method to create a new object from the data of the database from his id.
     *
     * @param id the id of the object.
     * @return the object created from the id.
     * @throws DAOException I am raise if the method cannot find the object.
     */
    public abstract T find(Long id) throws DAOException;

    /**
     * I allow to get all the id named idFieldFame in a table call tableName where the id equals the field name idContainerFieldName.
     *
     * @param idFieldName the name of the field that contains the id to fetch.
     * @param tableName the name of the table where to get the id to fetch.
     * @param idContainerFieldName the name of the container's id field.
     * @param id the id of the container.
     * @return the list of ids.
     * @throws DAOException is raise if there is a problem with the database.
     */
    public List<T> listOfAllObject(String idFieldName, String tableName, String idContainerFieldName, Long id) throws DAOException {
        //TODO Maybe include a retry with  a time out in case of SQLException
        List<T> list = new ArrayList<>();
        String request = "SELECT " + idFieldName + " FROM " + tableName + " WHERE " + idContainerFieldName + "  = ? ";
        try {
            PreparedStatement statement = this.connection.prepareStatement(request);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                list.add(find(result.getLong(idFieldName)));
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return list;

    }

}