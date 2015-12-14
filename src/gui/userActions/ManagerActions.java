package gui.userActions;

import javax.swing.*;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class ManagerActions extends JList{

    protected DefaultListModel model;

    public ManagerActions(){
        model = new DefaultListModel();
        setModel(model);
        initializeActions();
    }

    public void initializeActions() {
        //TODO
        model.addElement("MockAction");
    }

    public String toString(){
        return "Manager";
    }

}
