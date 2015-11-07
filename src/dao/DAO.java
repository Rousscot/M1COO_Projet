package dao;

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
    public abstract boolean create(T obj);

    /**
     * todo
     *
     * @param obj
     * @return
     */
    public abstract boolean delete(T obj);

    /**
     * todo
     *
     * @param obj
     * @return
     */
    public abstract boolean update(T obj);

    /**
     * TODO
     *
     * @param id
     * @return
     * @throws DAONotFoundException
     */
    public abstract T find(Integer id) throws DAONotFoundException;

}