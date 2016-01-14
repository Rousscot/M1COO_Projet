package gui.userActions;

import factory.Agency;
import gui.actionPanels.JourneyManagementPanel;

import javax.swing.*;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class EmployeeActions extends JList<JPanel>{

    protected DefaultListModel<JPanel> model;

    public EmployeeActions(Agency controller){
        model = new DefaultListModel<>();
        setModel(model);
        initializeActions(controller);
    }

    public void initializeActions(Agency controller) {
        model.addElement(new JourneyManagementPanel(controller));
    }

    public String toString(){
        return "Employé";
    }

}
