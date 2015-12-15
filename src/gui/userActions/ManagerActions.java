package gui.userActions;

import gui.actionPanels.DestinationManagementPanel;

import javax.swing.*;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class ManagerActions extends JList<JPanel>{

    protected DefaultListModel<JPanel> model;

    public ManagerActions(){
        model = new DefaultListModel<>();
        setModel(model);
        initializeActions();
    }

    public void initializeActions() {
        model.addElement(new DestinationManagementPanel());
    }

    public String toString(){
        return "Manager";
    }

}
