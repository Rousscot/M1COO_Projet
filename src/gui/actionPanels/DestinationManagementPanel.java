package gui.actionPanels;

import domaine.destination.City;
import factory.Agency;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 15/12/2015.
 */
public class DestinationManagementPanel extends JPanel implements CitySelectionListener {

    protected CityManagerPanel cityPanel;
    protected HotelManagerPanel hotelPanel;
    protected JPanel categoryPanel;
    protected JPanel roomPanel;

    public DestinationManagementPanel(Agency controller){
        initializePanel();
        initializePanels(controller);
    }

    public void initializePanel() {
        setLayout(new GridLayout(1, 4));
    }

    public void initializePanels(Agency controller) {
        hotelPanel = new HotelManagerPanel();
        cityPanel = new CityManagerPanel(controller, this);
        add(cityPanel);
        add(hotelPanel);
        //TODO
    }

    public String toString(){
        return "Gestion des destinations";
    }

    @Override
    public void citySelected(City city) {
        hotelPanel.setController(city);
    }
}
