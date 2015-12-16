package gui.model;

import domaine.destination.City;
import domaine.destination.Hotel;
import factory.Agency;

import javax.swing.*;
import java.sql.SQLException;
import java.util.AbstractList;

/**
 * Created by JeCisC on 13/12/2015.
 */
public class CitiesDataSource extends AbstractListModel<City> {

    protected Agency agency;

    public CitiesDataSource(Agency agency){
        this.agency = agency;
    }

    @Override
    public City getElementAt(int index) {
        try {
            return agency.cityAt(index);
        } catch (SQLException e) {
           //TODO Raise a message of error.
        }
        return null; //TODO will stay ?
    }

    @Override
    public int getSize() {
        try {
            return agency.numberOfCities();
        } catch (SQLException e) {
            //TODO Raise a message of error
        }
        return 0; //TODO will stay ?
    }
}
