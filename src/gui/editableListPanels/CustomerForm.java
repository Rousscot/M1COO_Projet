package gui.editableListPanels;

import domaine.Customer;
import domaine.destination.City;
import domaine.exception.BirthdayFormatException;
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

    public CustomerForm() {
        super();
    }

    @Override
    //TODO
    protected LayoutManager getFormLayout() {
        return new GridLayout(1, 1);
    }

    /**
     * initialize the birthday panel
     */
    protected void initPanel() {
        birthdayPanel = new JPanel();
        birthdayPanel.setLayout(new GridLayout(3, 1));
        configureBirthdayTabbedPanel();
    }

    @Override
    protected void initLabels() {
        initPanel();
        configureNameTabbedPanel();
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
        selectFirstElementIfPossible(list);
    }

    /**
     * initialize and add the city tabbedPane to the main panel
     */
    public void initCityTap() {
        JTabbedPane cityTabbedPanel = new JTabbedPane();
        this.add(cityTabbedPanel);
        JPanel cityPanel = new JPanel();
        cityPanel.setLayout(new BorderLayout(0, 0));
        cityTabbedPanel.addTab("Ville :", cityPanel);
        JScrollPane cityScrollPane = new JScrollPane();
        cityPanel.add(cityScrollPane, BorderLayout.CENTER);
        cities = new JList<>();
        cityScrollPane.setViewportView(cities);
    }

    /**
     * initialize and add the name tabbed panes to the main panel
     */
    public void configureNameTabbedPanel() {
        JTabbedPane fnTabbedPanel = new JTabbedPane();
        this.add(fnTabbedPanel);
        firstNameField = new JTextField();
        fnTabbedPanel.addTab(FNLABEL, firstNameField);

        JTabbedPane lnTabbedPanel = new JTabbedPane();
        this.add(lnTabbedPanel);
        lastNameField = new JTextField();
        lnTabbedPanel.addTab(LNLABEL, lastNameField);
    }

    /**
     * initialize and add the birthday tabbed panes to the Birthaday pannel
     */
    public void configureBirthdayTabbedPanel() {
        JTabbedPane bdTabbedPanel = new JTabbedPane();
        birthdayPanel.add(bdTabbedPanel);
        dayField = new JTextField();
        bdTabbedPanel.addTab(BDLABEL, dayField);

        JTabbedPane bmTabbedPanel = new JTabbedPane();
        birthdayPanel.add(bmTabbedPanel);
        monthField = new JTextField();
        bmTabbedPanel.addTab(BMLABEL, monthField);

        JTabbedPane byTabbedPanel = new JTabbedPane();
        birthdayPanel.add(byTabbedPanel);
        yearField = new JTextField();
        byTabbedPanel.addTab(BYLABEL, yearField);

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
        //TODO selectionne la ville du customer
        cities.setSelectedValue(controller.getCity(), true);
        String year = controller.getBirthday().getYear() + "";
        String month = controller.getBirthday().getMonthValue() + "";
        String day = controller.getBirthday().getDayOfMonth() + "";
        dayField.setText(day);
        monthField.setText(month);
        yearField.setText(year);
    }

    /**
     * @return the selected City
     */
    public City city() {
        return cities.getSelectedValue();
    }

    /**
     * @return the filled birthday
     * @throws BirthdayFormatException is raised when there's an error with the filled birthday
     */
    public LocalDate birthday() throws BirthdayFormatException {
        int year = year();
        int month = month();
        int day = day();
        return LocalDate.of(year, month, day);
    }

    /**
     * @return the firstName filled in the firstNameField
     */
    public String firstName() {
        return firstNameField.getText().trim();
    }

    /**
     * @return the lastName filled in the lastNameField
     */
    public String lastName() {
        return lastNameField.getText().trim();
    }

    /**
     * @return the year filled in the yearField
     * @throws NumberFormatException   is raised when we don't fill a integer
     * @throws BirthdayFormatException is raised when the year is not valid (age <100)
     */
    public int year() throws NumberFormatException, BirthdayFormatException {
        int year = Integer.parseInt(yearField.getText());
        int currentYear = LocalDate.now().getYear();
        if (year < (currentYear - 100) || year > currentYear) {
            throw new BirthdayFormatException("L'année de naissance doit être comprise entre " + (currentYear - 100) + " et " + currentYear);
        }
        return year;
    }

    /**
     * @return the month filled in the monthField
     * @throws NumberFormatException   is raised when we don't fill an integer
     * @throws BirthdayFormatException is raised when the month is not valid (1to12)
     */
    public int month() throws NumberFormatException, BirthdayFormatException {
        int month = Integer.parseInt(monthField.getText());
        if (month < 1 || month > 12) {
            throw new BirthdayFormatException("Le mois de naissance doit être compris entre 1 et 12");
        }
        return month;
    }

    /**
     * @return the day filled in the dayField
     * @throws NumberFormatException   is raised when we don't fill an integer
     * @throws BirthdayFormatException is raised when the day is not valid (1to31)
     */
    public int day() throws NumberFormatException, BirthdayFormatException {
        int day = Integer.parseInt(dayField.getText());
        if (day < 1 || day > 31) {
            throw new BirthdayFormatException("Le jour de naissance doit être compris entre 1 et 31");
        }
        return day;
    }

}
