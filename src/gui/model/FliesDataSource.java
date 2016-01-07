package gui.model;

import domaine.Fly;
import domaine.destination.Category;
import domaine.destination.Room;
import factory.Agency;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by JeCisC on 13/12/2015.
 */
public class FliesDataSource extends AbstractListModel<Fly> {

    protected Agency agency;

    public FliesDataSource(Agency agency){
        this.agency = agency;
    }

    @Override
    public Fly getElementAt(int index) {
        try {
            return agency.flyAt(index);
        } catch (SQLException e) {
           //TODO Raise a message of error.
        }
        return null; //TODO will stay ?
    }

    @Override
    public int getSize() {
        try {
            return agency.numberOfFlies();
        } catch (SQLException e) {
            //TODO Raise a message of error
        }
        return 0; //TODO will stay ?
    }
}
