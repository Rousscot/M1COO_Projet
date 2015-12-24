package gui.NullObjects;

import domaine.destination.Category;
import domaine.destination.Hotel;
import domaine.destination.Room;

/**
 * Created by JeCisC on 24/12/2015.
 */
public class NullCategory extends Category {

    public NullCategory(String designation, Integer capacity, Integer price, Hotel hotel) {
        super(designation, capacity, price, hotel);
    }

    @Override
    public Integer numberOfRooms(){
        return 0;
    }

    @Override
    public Room roomAt(Integer index){
        return null;
    }

}
