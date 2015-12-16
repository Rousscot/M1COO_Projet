package gui.userActions;

import factory.Agency;
import gui.actionPanels.DestinationManagementPanel;

import javax.swing.*;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class ManagerActions extends JList<JPanel>{

    protected DefaultListModel<JPanel> model;

    public ManagerActions(Agency controller){
        model = new DefaultListModel<>();
        setModel(model);
        initializeActions(controller);
    }

    public void initializeActions(Agency controller) {
        model.addElement(new DestinationManagementPanel(controller));
    }

    public String toString(){
        return "Manager";
    }

}
