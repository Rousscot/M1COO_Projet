package gui;

import gui.userActions.EmployeeActions;
import gui.userActions.ManagerActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class ActionPanel extends JPanel implements ItemListener {

    protected JComboBox<JList> userManager;

    protected JList actions;

    public ActionPanel() {
        setLayout(new BorderLayout());
        initializeComboBox();
        initializeActionList();
    }

    public void initializeActionList() {
        // I don't have the time to remove this cast.
        JList list = (JList) userManager.getSelectedItem();
        if(list != null){
            actions = list;
            add(actions, BorderLayout.CENTER);
        }

    }

    public void initializeComboBox() {
        userManager = new JComboBox<>();
        initUserManagerContent();
        userManager.setSelectedIndex(0);
        userManager.addItemListener(this);
        add(userManager, BorderLayout.NORTH);
    }

    public void initUserManagerContent() {
        userManager.addItem(new ManagerActions());
        userManager.addItem(new EmployeeActions());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // I don't have the time to remove this cast.
        if (actions != null) {
            remove(actions);
        }
        actions = (JList) e.getItem();
        add(actions, BorderLayout.CENTER);
        actions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        revalidate();
        repaint();
    }
}
