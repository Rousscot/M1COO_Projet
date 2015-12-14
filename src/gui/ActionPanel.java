package gui;

import domaine.destination.City;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class ActionPanel extends JPanel implements ItemListener {

    protected JComboBox userManager;

    protected JList actions;

    public ActionPanel(){
        setLayout(new BorderLayout());
        initializeComboBox();
    }

    public void initializeComboBox() {
        userManager = new JComboBox();
        initUserManagerContent();
        userManager.setSelectedIndex(1);
        userManager.addItemListener(this);
        add(userManager, BorderLayout.NORTH);
    }

    public void initUserManagerContent() {
        //TODO
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //TODO
    }
}
