package gui.userActions;

import factory.Agency;
import gui.AgencyGUI;
import gui.actionPanels.JourneyManagementPanel;

import javax.swing.*;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class EmployeeActions extends JList<JPanel>{

    protected DefaultListModel<JPanel> model;

    protected AgencyGUI owner;

    public EmployeeActions(Agency controller, AgencyGUI owner){
        this.owner = owner;
        model = new DefaultListModel<>();
        setModel(model);
        initializeActions(controller);
    }

    public void initializeActions(Agency controller) {
        model.addElement(new JourneyManagementPanel(controller, owner));
    }

    public String toString(){
        return "Employé";
    }

}
