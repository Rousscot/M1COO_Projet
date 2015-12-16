package gui.actionPanels;

import factory.Agency;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 15/12/2015.
 */
public class DestinationManagementPanel extends JPanel {

    protected JPanel cityPanel;
    protected JPanel hotelPanel;
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
        cityPanel = new CityManagerPanel(controller);
        add(cityPanel);
        //TODO
    }

    public String toString(){
        return "Gestion des destinations";
    }

}
