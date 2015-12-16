package gui.actionPanels;

import factory.Agency;
import gui.model.CitiesDataSource;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class CityManagerPanel extends JPanel {

    protected JList jList; //TODO parameter
    protected Agency controller;

    public CityManagerPanel(Agency controller){
        setBackground(Color.PINK);
        this.controller = controller;
        initComponents();
        addPanels();
    }

    public void addPanels() {
        this.setLayout(new BorderLayout());
        add("North", jList);
        //add("Center", entryForm);
        //add("South", buttonsBar);
    }

    public void initJList() {
        jList = new JList<>();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setModel(new CitiesDataSource(controller));
    }

    public void initComponents() {
       initJList();
    }

}
