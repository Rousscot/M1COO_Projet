package gui.model;

import dao.exception.DAOException;
import domaine.Customer;
import factory.Agency;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by aurelien on 10/01/2016.
 */
public class CustomerDataSource extends AbstractListModel<Customer> {

    protected Agency agency;

    public CustomerDataSource(Agency agency){
        this.agency = agency;
    }

    @Override
    public int getSize() {
        try {
            return agency.numberOfCustomers();
        } catch (DAOException e) {
            //TODO raise a message of error
        }
        return 0;
    }

    @Override
    public Customer getElementAt(int index) {
        try{
            return agency.customerAt(index);
        } catch (SQLException e){
            // TODO raise a message of error
        }
        return null;
    }
}
