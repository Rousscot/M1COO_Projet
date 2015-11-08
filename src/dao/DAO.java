package dao;

import dao.exception.DAOCannotInsertException;
import dao.exception.DAONotFoundException;

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
    public abstract void delete(T obj);

    /**
     * todo
     *
     * @param obj
     * @return
     */
    public abstract T update(T obj);

    /**
     * TODO
     *
     * @param id
     * @return
     * @throws DAONotFoundException
     */
    public abstract T find(Long id) throws DAONotFoundException;

}