package gui.actionPanels;

import domaine.destination.Category;
import domaine.destination.City;
import domaine.destination.Hotel;
import factory.Agency;
import gui.CategorySelectionListener;
import gui.CitySelectionListener;
import gui.HotelSelectionListener;
import gui.editableListPanels.CategoryManagerPanel;
import gui.editableListPanels.CityManagerPanel;
import gui.editableListPanels.HotelManagerPanel;
import gui.editableListPanels.RoomManagerPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 15/12/2015.
 */
public class DestinationManagementPanel extends JPanel implements CitySelectionListener, HotelSelectionListener, CategorySelectionListener {

    protected CityManagerPanel cityPanel;
    protected HotelManagerPanel hotelPanel;
    protected CategoryManagerPanel categoryPanel;
    protected RoomManagerPanel roomPanel;

    public DestinationManagementPanel(Agency controller){
        initializePanel();
        initializePanels(controller);
    }

    public void initializePanel() {
        setLayout(new GridLayout(1, 4));
    }

    public void initializePanels(Agency controller) {
        roomPanel = new RoomManagerPanel();
        categoryPanel = new CategoryManagerPanel(this);
        hotelPanel = new HotelManagerPanel(this);
        cityPanel = new CityManagerPanel(controller, this);
        add(cityPanel);
        add(hotelPanel);
        add(categoryPanel);
        add(roomPanel);
    }

    public String toString(){
        return "Gestion des destinations";
    }

    @Override
    public void citySelected(City city) {
        hotelPanel.setController(city);
    }

    @Override
    public void hotelSelected(Hotel hotel) {
        categoryPanel.setController(hotel);
    }

    @Override
    public void categorySelected(Category category) {
       roomPanel.setController(category);
    }
}
