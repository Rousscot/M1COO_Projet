package gui.editableListPanels;

import domaine.Customer;
import domaine.destination.City;
import domaine.exception.BirthdayFormatException;
import factory.Agency;
import gui.model.CitiesDataSource;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Properties;

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

    protected JDatePickerImpl birthdayField;
    protected static final String LABELBIRTHDAY = "Date de naissance";


    public CustomerForm() {
        super();
        initSpacers();
    }

    public void initSpacers() {
        GridBagConstraints gbc;
        JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer1, gbc);
        JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer2, gbc);
        JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(spacer3, gbc);
    }

    @Override
    //TODO
    protected LayoutManager getFormLayout() {
        return new GridBagLayout();
    }

    @Override
    protected void initLabels() {
    }

    @Override
    protected void initTextFields() {
        JTabbedPane fnTabbedPanel = new JTabbedPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(fnTabbedPanel, gbc);
        firstNameField = new JTextField();
        fnTabbedPanel.addTab(FNLABEL, firstNameField);

        JTabbedPane lnTabbedPanel = new JTabbedPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(lnTabbedPanel, gbc);
        lastNameField = new JTextField();
        lnTabbedPanel.addTab(LNLABEL, lastNameField);

        initCityTap();

        JTabbedPane bdTabbedPanel = new JTabbedPane();
        JPanel birthdayPanel = new JPanel();
        bdTabbedPanel.addTab(LABELBIRTHDAY, birthdayPanel);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(bdTabbedPanel, gbc);
        birthdayPanel.setLayout(new BorderLayout());
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        birthdayField = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        birthdayPanel.add(birthdayField);

    }

    @Override
    public void clean() {
        firstNameField.setText("");
        lastNameField.setText("");
        selectFirstElementIfPossible(cities);
        birthdayField.getModel().setDate(1, 1, 2000);
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
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(cityTabbedPanel, gbc);
        JPanel cityPanel = new JPanel();
        cityPanel.setLayout(new BorderLayout(0, 0));
        cityTabbedPanel.addTab("Ville :", cityPanel);
        JScrollPane cityScrollPane = new JScrollPane();
        cityPanel.add(cityScrollPane, BorderLayout.CENTER);
        cities = new JList<>();
        cityScrollPane.setViewportView(cities);
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
        firstNameField.setText(controller.getFirstName());
        lastNameField.setText(controller.getLastName());
        cities.setSelectedValue(controller.getCity(), true);
        birthdayField.getModel().setDate(controller.getBirthday().getYear(), controller.getBirthday().getMonthValue(), controller.getBirthday().getDayOfYear() );
    }


    public City city() {
        return cities.getSelectedValue();
    }

    public LocalDate birthday() throws BirthdayFormatException {
        return LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(birthdayField.getModel().getValue()));
    }

    public String firstName() {
        return firstNameField.getText().trim();
    }

    public String lastName() {
        return lastNameField.getText().trim();
    }

}
