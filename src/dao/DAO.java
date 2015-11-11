package dao;

import dao.exception.DAOCannotInsertException;
import dao.exception.DAONotFoundException;
import dao.exception.DAOUpdateFailedException;
import dao.exception.delete.CustomerDeleteException;

import java.sql.Connection;

/**
 * TODO
 *
 * @param <T>
 * @autor
 */
public abstract class DAO<T> {

    protected Connection connection = null;

    /**
     * TODO
     *
     * @param connection
     */
    public DAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * TODO
     *
     * @param obj
     * @return
     */
    public abstract T create(T obj) throws DAOCannotInsertException;

    /**
     * todo
     *
     * @param obj
     * @return
     */
    public abstract void delete(T obj) throws CustomerDeleteException;

    /**
     * todo
     *
     * @param obj
     * @return
     */
    public abstract T update(T obj) throws DAOUpdateFailedException;

    /**
     * TODO
     *
     * @param id
     * @return
     * @throws DAONotFoundException
     */
    public abstract T find(Long id) throws DAONotFoundException;

}