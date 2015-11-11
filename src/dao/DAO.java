package dao;

import dao.exception.DAOCannotInsertException;
import dao.exception.DAONotFoundException;
import dao.exception.DAOUpdateFailedException;
import dao.exception.delete.CustomerDeleteException;

import java.sql.Connection;

/**
 * I am an Abstract class to define an implementation of a DAO class.
 * I describe how an Object interact with the Database.
 *
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
        this.connection = ConnectionBdd.current();
    }

    /**
     * I am a method to insert an Object into a database.
     *
     * @param obj the object I need to add to the database.
     * @return the same object with some modification if needed. For example the method can add an id to the object.
     * @throws DAOCannotInsertException I am raise if the method cannot insert the object into the database.
     */
    public abstract T create(T obj) throws DAOCannotInsertException;

    /**
     * I am a method that delete an object from the database.
     *
     * @param obj the object to delete.
     * @throws CustomerDeleteException I am raise if the method cannot delete the object from the database.
     */
    public abstract void delete(T obj) throws CustomerDeleteException;


    /**
     * I am a method to update an object into the database.
     *
     * @param obj the object to update.
     * @return the object updated.
     * @throws DAOUpdateFailedException I am raise if the method cannot update the object.
     */
    public abstract T update(T obj) throws DAOUpdateFailedException;

    /**
     * I am a method to create a new object from the data of the database from his id.
     *
     * @param id the id of the object.
     * @return the object created from the id.
     * @throws DAONotFoundException I am raise if the method cannot find the object.
     */
    public abstract T find(Long id) throws DAONotFoundException;

}