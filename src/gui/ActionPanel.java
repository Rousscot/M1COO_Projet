package gui;

import gui.userActions.EmployeeActions;
import gui.userActions.ManagerActions;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * //TODO
 */
public class ActionPanel extends JPanel implements ItemListener, ListSelectionListener {

    protected JComboBox<JList<JPanel>> userManager;

    protected JList<JPanel> actions;

    protected AgencyGUI owner;

    public ActionPanel(AgencyGUI owner) {
        this.owner = owner;
        setLayout(new BorderLayout());
        initializeComboBox();
        initializeActionList();
    }

    public void initializeActionList() {
        // I don't have the time to remove this cast.
        JList list = (JList<JPanel>) userManager.getSelectedItem();
        if(list != null){
            setNewActionListWith(list);
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
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            remove(actions);
            // I don't have the time to remove this cast.
            setNewActionListWith((JList<JPanel>) e.getItem());
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()){
            setMainPanelWith(actions.getSelectedValue());
        }
    }

    public void setNewActionListWith(JList<JPanel> list) {
        actions = list;
        add(actions, BorderLayout.CENTER);
        actions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        actions.setSelectedIndex(0);
        actions.addListSelectionListener(this);
        revalidate();
        repaint();
        setMainPanelWith(actions.getSelectedValue()); //The list should not be empty.
    }

    public void setMainPanelWith(JPanel panel) {
        getOwner().setMainPanelWith(panel);
    }

    public AgencyGUI getOwner() {
        return owner;
    }
}
