package gui.actionPanels;

import domaine.destination.City;
import domaine.destination.Hotel;
import factory.Agency;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 15/12/2015.
 */
public class DestinationManagementPanel extends JPanel implements CitySelectionListener, HotelSelectionListener {

    protected CityManagerPanel cityPanel;
    protected HotelManagerPanel hotelPanel;
    protected CategoryManagerPanel categoryPanel;
    protected JPanel roomPanel;

    public DestinationManagementPanel(Agency controller){
        initializePanel();
        initializePanels(controller);
    }

    public void initializePanel() {
        setLayout(new GridLayout(1, 4));
    }

    public void initializePanels(Agency controller) {
        categoryPanel = new CategoryManagerPanel();
        hotelPanel = new HotelManagerPanel(this);
        cityPanel = new CityManagerPanel(controller, this);
        add(cityPanel);
        add(hotelPanel);
        add(categoryPanel);
        //TODO
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
}
