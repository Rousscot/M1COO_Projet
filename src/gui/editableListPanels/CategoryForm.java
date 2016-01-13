package gui.editableListPanels;

import domaine.destination.Category;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public class CategoryForm extends AbstractForm<Category> {

    protected JTextField designationField;
    protected JTextField capacityField;
    protected JTextField priceField;
    protected static final String LABEL = "Designation :";
    protected static final String LABEL2 = "Capacité :";
    protected static final String LABEL3 = "Prix :";
    protected JPanel categoryPanel;

    public CategoryForm(){
        super();
    }

    @Override
    public LayoutManager getFormLayout(){
        return new GridLayout(1,1);
    }

    @Override
    public void initLabels() {
        initPanel();
        add(categoryPanel);
    }

    public void initPanel(){
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(3,1));
        configureCategoryTabbedPane();
    }

    private void configureCategoryTabbedPane() {
        JTabbedPane designationTabbedPanel = new JTabbedPane();
        categoryPanel.add(designationTabbedPanel);
        designationField = new JTextField();
        designationTabbedPanel.addTab(LABEL, designationField);

        JTabbedPane capacityTabbedPanel = new JTabbedPane();
        categoryPanel.add(capacityTabbedPanel);
        capacityField = new JTextField();
        capacityTabbedPanel.addTab(LABEL2, capacityField);

        JTabbedPane priceTabbedPanel = new JTabbedPane();
        categoryPanel.add(priceTabbedPanel);
        priceField = new JTextField();
        priceTabbedPanel.addTab(LABEL3, priceField);
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

    @Override
    public void setWithNotNull(Category controller) {
        designationField.setText(controller.getDesignation());
        capacityField.setText(controller.getCapacity().toString());
        priceField.setText(controller.getPrice().toString());
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
