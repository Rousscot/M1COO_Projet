package gui.userActions;

import gui.actionPanels.JourneyManagementPanel;

import javax.swing.*;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class EmployeeActions extends JList<JPanel>{

    protected DefaultListModel<JPanel> model;

    public EmployeeActions(){
        model = new DefaultListModel<>();
        setModel(model);
        initializeActions();
    }

    public void initializeActions() {
        model.addElement(new JourneyManagementPanel());
    }

    public String toString(){
        return "Employé";
    }

}
