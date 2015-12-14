package gui.userActions;

import javax.swing.*;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class EmployeeActions extends JList{

    protected DefaultListModel model;

    public EmployeeActions(){
        model = new DefaultListModel();
        setModel(model);
        initializeActions();
    }

    public void initializeActions() {
        //TODO
        model.addElement("MockAction");
    }

    public String toString(){
        return "Employé";
    }

}
