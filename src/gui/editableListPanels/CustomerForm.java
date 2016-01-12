package gui.editableListPanels;

import domaine.Customer;
import domaine.destination.City;
import factory.Agency;
import gui.model.CitiesDataSource;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

/**
 * Created by aurelien on 10/01/2016.
 */
public class CustomerForm extends AbstractForm<Customer> {

    public Agency agency;

    protected static final String FNLABEL = "Prénom :";
    protected JTextField firstNameField;
    protected static final String LNLABEL = "Nom :";
    protected JTextField lastNameField;
    protected JList<City> cities;


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

        configureTabbedPanel(dayField, BDLABEL, birthdayPanel);
        configureTabbedPanel(monthField, BMLABEL, birthdayPanel);
        configureTabbedPanel(yearField, BYLABEL, birthdayPanel);
/*
        JLabel bdLabel = new JLabel(CustomerForm.BDLABEL);
        JLabel bmLabel = new JLabel(CustomerForm.BMLABEL);
        JLabel byLabel = new JLabel(CustomerForm.BYLABEL);
        birthdayPanel.add(bdLabel);
        birthdayPanel.add(dayField);
        birthdayPanel.add(bmLabel);
        birthdayPanel.add(monthField);
        birthdayPanel.add(byLabel);
        birthdayPanel.add(yearField);
*/
    }

    @Override
    protected void initLabels() {
        initPanel();
        configureTabbedPanel(firstNameField, FNLABEL);
        configureTabbedPanel(lastNameField, LNLABEL);
        initCityTap();
        add(birthdayPanel);
    }

    @Override
    protected void initTextFields() {
        lastNameField = new JTextField();
        lastNameField.setColumns(10);

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
        selectFirstElementIfPossible(cities);
        dayField.setText("");
        monthField.setText("");
        yearField.setText("");
    }

    public void selectFirstElementIfPossible(JList list) {
        if (list.getModel().getSize() > 0) {
            list.setSelectedIndex(0);
        }
    }

    public void setCustomerController(Agency agency) {
        this.agency = agency;
        refresh();
    }

    public void refresh() {
        if (agency != null) {
            refreshList(cities);
        }
    }

    public void refreshList(JList list) {
        list.setModel(new CitiesDataSource(agency));
        //list.revalidate();
        //list.repaint(); // I don't know why the repaint doesn't work :(
        selectFirstElementIfPossible(list);
    }

    public void initCityTap() {
        System.out.println(); //TODO retirer affichage
        JTabbedPane cityTabbedPanel = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(cityTabbedPanel, gridBagConstraints);
        JPanel cityPanel = new JPanel();
        cityPanel.setLayout(new BorderLayout(0, 0));
        cityTabbedPanel.addTab("Ville", cityPanel);
        JScrollPane cityScrollPane = new JScrollPane();
        cityPanel.add(cityScrollPane, BorderLayout.CENTER);
        cities = new JList();
        //final DefaultListModel defaultListModel1 = new DefaultListModel();
        //origins.setModel(defaultListModel1);
        //origins.setSelectionMode(0);
        cityScrollPane.setViewportView(cities);
    }


    public void configureTabbedPanel(JTextField jTextField, String label){
        JTabbedPane fsTabbedPanel = new JTabbedPane();
        this.add(fsTabbedPanel);
        jTextField = new JTextField();
        fsTabbedPanel.addTab(label, jTextField);
    }

    public void configureTabbedPanel(JTextField jTextField, String label, JPanel panel){
        JTabbedPane fsTabbedPanel = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        panel.add(fsTabbedPanel, gridBagConstraints);
        jTextField = new JTextField();
        fsTabbedPanel.addTab(label, jTextField);
    }

    @Override
    public void revalidate() {
        super.revalidate();
        if (agency != null) {
            refresh();
        }
    }



    @Override
    public void setWithNotNull(Customer controller) {
        refresh();
    }

    public City city(){
        return cities.getSelectedValue();
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
