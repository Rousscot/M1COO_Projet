package gui.actionPanels;

import factory.Agency;
import gui.model.CitiesDataSource;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class CityManagerPanel extends JPanel implements StandardButtonsUsers {

    protected JList jList; //TODO parameter
    protected JPanel form;//TODO Use another Panel :(
    protected StandardButtonsBar buttonsBar; //TODO
    protected Agency controller;

    public CityManagerPanel(Agency controller){
        setBackground(Color.PINK);
        this.controller = controller;
        initComponents();
        addPanels();
    }

    public void addPanels() {
        setLayout(new BorderLayout());
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(250, 250));
        add("North", jScrollPane);
        add("Center", form);
        add("South", buttonsBar);
    }

    public void initJList() {
        jList = new JList<>();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setModel(new CitiesDataSource(controller));
    }

    public void initComponents() {
        initJList();
        form = new JPanel(); //TODO use real panel.
        buttonsBar = new StandardButtonsBar(this); //TODO use real panel.
    }

    @Override
    public void createItem() {
        //TODO
        System.out.println("add");
    }

    @Override
    public void deleteItem() {
        //TODO
        System.out.println("delete");
    }
}
