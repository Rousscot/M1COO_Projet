package gui.model;

import domaine.destination.City;
import domaine.destination.Hotel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.AbstractList;

/**
 * Created by JeCisC on 13/12/2015.
 */
public class HotelsDataSource extends AbstractListModel<Hotel> {

    protected City city;

    public HotelsDataSource(City city){
        this.city = city;
    }

    @Override
    public Hotel getElementAt(int index) {
        try {
            return city.hotelAt(index);
        } catch (SQLException e) {
           //TODO Raise a message of error.
        }
        return null; //TODO will stay ?
    }

    @Override
    public int getSize() {
        try {
            return city.numberOfHotels();
        } catch (SQLException e) {
            //TODO Raise a message of error
        }
        return 0; //TODO will stay ?
    }
}
