package gui.NullObjects;

import domaine.destination.Category;
import domaine.destination.Hotel;
import domaine.destination.Room;
import gui.exception.ControllerNotFound;

import javax.swing.*;

/**
 * Created by JeCisC on 24/12/2015.
 */
public class NullCategory extends Category {

    protected JComponent owner;

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

    @Override
    public void createAndAddRoom(Integer number){
        if(owner != null){
            JOptionPane.showMessageDialog(owner, "Veuillez selectionner une catégorie avant d'ajouter une chambre.");
        }
    }

    public void setOwner(JComponent owner) {
        this.owner = owner;
    }
}
