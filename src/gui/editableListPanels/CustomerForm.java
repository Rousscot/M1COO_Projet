package gui.editableListPanels;

import domaine.Customer;
import domaine.destination.City;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

/**
 * Created by aurelien on 10/01/2016.
 */
public class CustomerForm extends AbstractForm<Customer> {

    protected static final String FNLABEL = "Prénom :";
    protected JTextField firstNameField;
    protected static final String LNLABEL = "Nom :";
    protected JTextField lastNameField;
    protected static final String CLABEL = "Ville :";
    protected JTextField cityField;


    protected JPanel birthdayPanel;
    protected static final String BDLABEL = "Jour de naissance :";
    protected JTextField dayField;
    protected static final String BMLABEL = "Mois de naissance :";
    protected JTextField monthField;
    protected static final String BYLABEL = "Année de naissance :";
    protected JTextField yearField;

    public CustomerForm(){
        super();
    }

    @Override
    //TODO
    protected LayoutManager getFormLayout() {
        return new GridLayout(1, 7);
    }

    protected void initPanel(){
        birthdayPanel = new JPanel();
        birthdayPanel.setLayout(new GridLayout(3,1));
        JLabel bdLabel = new JLabel(CustomerForm.BDLABEL);
        JLabel bmLabel = new JLabel(CustomerForm.BMLABEL);
        JLabel byLabel = new JLabel(CustomerForm.BYLABEL);
        birthdayPanel.add(bdLabel);
        birthdayPanel.add(dayField);
        birthdayPanel.add(bmLabel);
        birthdayPanel.add(monthField);
        birthdayPanel.add(byLabel);
        birthdayPanel.add(yearField);
    }

    @Override
    protected void initLabels() {
        JLabel fnLabel = new JLabel(CustomerForm.FNLABEL);
        JLabel lnLabel = new JLabel(CustomerForm.LNLABEL);
        JLabel cLabel = new JLabel(CustomerForm.CLABEL);
        initPanel();

        add(fnLabel);
        add(firstNameField);
        add(lnLabel);
        add(lastNameField);
        add(cLabel);
        add(cityField);
        add(birthdayPanel);
    }

    @Override
    protected void initTextFields() {
        firstNameField = new JTextField();
        firstNameField.setColumns(10);
        lastNameField = new JTextField();
        lastNameField.setColumns(10);
        cityField = new JTextField();
        cityField.setColumns(10);
        dayField = new JTextField();
        dayField.setColumns(10);
        monthField = new JTextField();
        monthField.setColumns(10);
        yearField = new JTextField();
        yearField.setColumns(10);
    }

    @Override
    public void clean() {
        firstNameField.setText("");
        lastNameField.setText("");
        cityField.setText("");
        dayField.setText("");
        monthField.setText("");
        yearField.setText("");
    }

    @Override
    public void setWithNotNull(Customer controller) {

    }

    public City city(){
        //TODO
        return null;
    }

    public LocalDate birthday(){
        //TODO
        return null;
    }

    public String firstName(){
        return firstNameField.getText().trim();
    }

    public String lastName(){
        return lastNameField.getText().trim();
    }
}
