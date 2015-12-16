package gui.model;

import domaine.destination.Category;
import domaine.destination.Room;

import javax.swing.*;
import java.sql.SQLException;
import java.util.AbstractList;

/**
 * Created by JeCisC on 13/12/2015.
 */
public class RoomsDataSource extends AbstractListModel<Room> {

    protected Category category;

    public RoomsDataSource(Category category){
        this.category = category;
    }

    @Override
    public Room getElementAt(int index) {
        try {
            return category.roomAt(index);
        } catch (SQLException e) {
           //TODO Raise a message of error.
        }
        return null; //TODO will stay ?
    }

    @Override
    public int getSize() {
        try {
            return category.numberOfRooms();
        } catch (SQLException e) {
            //TODO Raise a message of error
        }
        return 0; //TODO will stay ?
    }
}
