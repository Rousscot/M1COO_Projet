package gui.actionPanels;

import domaine.Customer;
import domaine.destination.City;
import factory.Agency;
import gui.AgencyGUI;
import gui.editableListPanels.DateLabelFormatter;
import gui.editableListPanels.NextButtonBar;
import gui.editableListPanels.NextButtonUser;
import gui.model.CitiesDataSource;
import gui.model.CustomerDataSource;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Properties;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class JourneyManagementPanel extends JPanel implements NextButtonUser {

    protected JList<Customer> customerList;

    protected JList<City> originList;

    protected JList<City> destinationList;

    protected JDatePickerImpl firstDate;

    protected JDatePickerImpl secondDate;

    protected Agency controller;

    protected AgencyGUI owner;

    public JourneyManagementPanel(Agency controller, AgencyGUI owner) {
        super();
        this.controller = controller;
        this.owner = owner;
        this.setLayout(new GridBagLayout());
        initSpacers();
        initCustomerList(controller);
        initOriginList(controller);
        initDestinationList(controller);
        initFirstDatePanel();
        initSecondDatePanel();
        initButton();
    }

    public void initButton() {
        JPanel buttonPannel = new NextButtonBar(this);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        this.add(buttonPannel, gridBagConstraints);
    }

    public void initSecondDatePanel() {
        final JTabbedPane secondDateTab = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(secondDateTab, gridBagConstraints);
        final JPanel secondDatePanel = new JPanel();
        secondDatePanel.setLayout(new BorderLayout(0, 0));
        secondDateTab.addTab("Date de retour", secondDatePanel);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        secondDate = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        secondDatePanel.add(secondDate, BorderLayout.CENTER);
    }

    public void initFirstDatePanel() {
        final JTabbedPane firstDateTab = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(firstDateTab, gridBagConstraints);
        final JPanel firstDatePanel = new JPanel();
        firstDatePanel.setLayout(new BorderLayout(0, 0));
        firstDateTab.addTab("Date de depart", firstDatePanel);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        firstDate = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        firstDatePanel.add(firstDate, BorderLayout.CENTER);
    }

    public void initDestinationList(Agency controller) {
        final JTabbedPane destinationTab = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(destinationTab, gridBagConstraints);
        final JPanel destinationPanel = new JPanel();
        destinationPanel.setLayout(new BorderLayout(0, 0));
        destinationTab.addTab("Ville d'arrivée", destinationPanel);
        destinationList = new JList<>();
        customerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        destinationList.setModel(new CitiesDataSource(controller));
        destinationPanel.add(destinationList, BorderLayout.CENTER);
    }

    public void initOriginList(Agency controller) {
        final JTabbedPane originTab = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(originTab, gridBagConstraints);
        final JPanel originPanel = new JPanel();
        originPanel.setLayout(new BorderLayout(0, 0));
        originTab.addTab("Ville de départ", originPanel);
        originList = new JList<>();
        customerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        originList.setModel(new CitiesDataSource(controller));
        originPanel.add(originList, BorderLayout.CENTER);
    }

    public void initCustomerList(Agency controller) {
        JTabbedPane customerTab = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(customerTab, gridBagConstraints);

        final JPanel customerPanel = new JPanel();
        customerPanel.setLayout(new BorderLayout(0, 0));
        customerTab.addTab("Client", customerPanel);
        customerList = new JList<>();
        customerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        customerList.setModel(new CustomerDataSource(controller));
        customerPanel.add(customerList, BorderLayout.CENTER);
    }

    public void initSpacers() {
        JPanel spacer1 = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(spacer1, gbc);
        JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer2, gbc);
        JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer3, gbc);
    }

    @Override
    public String toString() {
        return "Gestion des voyages";
    }

    @Override
    public void nextAction() {
        try {
            if (getCustomer() == null || getDestination() == null) {
                throw new IllegalArgumentException();
            } else {
                if (getFirstDate().isAfter(getSecondDate()) || getFirstDate().isBefore(LocalDate.now())) {
                    JOptionPane.showMessageDialog(this, "Veuillez selectionner des dates valides.");
                } else {
                    if (getOrigin().equals(getDestination())) {
                        JOptionPane.showMessageDialog(this, "Veuillez selectionner deux villes différentes.");
                    } else {
                        owner.setMainPanelWith(new SelectFlightsPanel(this));
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner tous les champs necessaires.");
        }
    }

    public Customer getCustomer() {
        return customerList.getSelectedValue();
    }

    public City getOrigin() {
        if (originList.getSelectedValue() == null) {
            return getCustomer().getCity();
        }
        return originList.getSelectedValue();
    }

    public City getDestination() {
        return destinationList.getSelectedValue();
    }

    public LocalDate getFirstDate() throws IllegalArgumentException {
        return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(firstDate.getModel().getValue()));
    }

    public LocalDate getSecondDate() throws IllegalArgumentException {
        return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(secondDate.getModel().getValue()));
    }
}
