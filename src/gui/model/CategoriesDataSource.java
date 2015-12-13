package gui.model;

import domaine.destination.Category;
import domaine.destination.Hotel;
import domaine.destination.Room;

import java.sql.SQLException;
import java.util.AbstractList;

/**
 * Created by JeCisC on 13/12/2015.
 */
public class CategoriesDataSource extends AbstractList<Category> {

    protected Hotel hotel;

    public CategoriesDataSource(Hotel hotel){
        this.hotel = hotel;
    }

    @Override
    public Category get(int index) {
        try {
            return hotel.categoryAt(index);
        } catch (SQLException e) {
           //TODO Raise a message of error.
        }
        return null; //TODO will stay ?
    }

    @Override
    public int size() {
        try {
            return hotel.numberOfCategories();
        } catch (SQLException e) {
            //TODO Raise a message of error
        }
        return 0; //TODO will stay ?
    }
}
