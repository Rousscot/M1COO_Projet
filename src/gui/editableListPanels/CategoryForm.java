package gui.editableListPanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public class CategoryForm extends AbstractForm {

    protected JTextField designationField;
    protected JTextField capacityField;
    protected JTextField priceField;
    protected static final String LABEL = "Designation :";
    protected static final String LABEL2 = "Capacité :";
    protected static final String LABEL3 = "Prix :";

    public CategoryForm(){
        super();
    }

    @Override
    public LayoutManager getFormLayout(){
        return new GridLayout(3, 2, 0, 5);
    }

    @Override
    public void initLabels() {
        JLabel label = new JLabel(CategoryForm.LABEL);
        JLabel label2 = new JLabel(CategoryForm.LABEL2);
        JLabel label3 = new JLabel(CategoryForm.LABEL3);
        add(label);
        add(designationField);
        add(label2);
        add(capacityField);
        add(label3);
        add(priceField);
    }

    @Override
    public void initTextFields() {
        designationField = new JTextField();
        capacityField = new JTextField();
        priceField = new JTextField();
    }

    @Override
    public void clean() {
        designationField.setText("");
        capacityField.setText("");
        priceField.setText("");
    }

    public String categoryDesignation() {
        return designationField.getText();
    }

    public Integer categoryCapacity() throws NumberFormatException{
        return Integer.parseInt(capacityField.getText().trim());
    }

    public Integer categoryPrice() throws NumberFormatException{
        return Integer.parseInt(priceField.getText().trim());
    }
}
