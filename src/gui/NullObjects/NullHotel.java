package gui.NullObjects;

import domaine.destination.Category;
import domaine.destination.City;
import domaine.destination.Hotel;

import javax.swing.*;

/**
 * Created by JeCisC on 24/12/2015.
 */
public class NullHotel extends Hotel {

    protected JComponent owner;

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

    @Override
    public void createAndAddCategory(String designation, Integer capacity, Integer price){
        if(owner != null){
            JOptionPane.showMessageDialog(owner, "Veuillez selectionner un Hotel avant d'ajouter une categorie.");
        }
    }

    public void setOwner(JComponent owner) {
        this.owner = owner;
    }
}
