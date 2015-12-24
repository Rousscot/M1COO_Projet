package gui.NullObjects;

import domaine.destination.Category;
import domaine.destination.City;
import domaine.destination.Hotel;

/**
 * Created by JeCisC on 24/12/2015.
 */
public class NullHotel extends Hotel {


    public NullHotel(String name, Integer resignationDays, City city) {
        super(name, resignationDays, city);
    }

    @Override
    public Integer numberOfCategories(){
        return 0;
    }

    @Override
    public Category categoryAt(Integer index){
        return null;
    }

}
