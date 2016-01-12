package gui.editableListPanels;

import domaine.Fly;
import domaine.destination.City;
import factory.Agency;
import gui.model.CitiesDataSource;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Created by ferlicotdelbe on 07/01/16.
 */
public class FlyForm extends AbstractForm<Fly> {

    public Agency cityController;
    protected JList<City> origins;
    protected JList<City> destinations;
    protected JComboBox<DayOfWeek> day;
    protected JComboBox<Integer> hour;
    protected JTextField duration;
    protected JTextField firstClassCapacity;
    protected JTextField secondClassCapacity;
    protected JTextField daysOfRetractation;
    protected JTextField firstClassPrice;
    protected JTextField secondClassPrice;

    public FlyForm() {
        super();
        initSeparators();
    }

    @Override
    public LayoutManager getFormLayout() {
        return new GridBagLayout();
    }

    public void initSeparators() {
        //Between the two lists
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        this.add(new JPanel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JPanel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JPanel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JPanel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JPanel(), gridBagConstraints);
    }

    @Override
    public void initTextFields() {
        initTabbedPanels();

        initDayField();
        initHourField();
        initDurationField();
        initFirstCapacityField();
        initSecondCapacityField();
        initFirstPriceField();
        initSecondPriceField();
        initResignationField();

    }

    public void initSecondPriceField() {
        JTabbedPane secondPriceTab = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(secondPriceTab, gridBagConstraints);
        JPanel secondPricePanel = new JPanel();
        secondPricePanel.setLayout(new GridBagLayout());
        secondPriceTab.addTab("Prix (2ème classe)", secondPricePanel);
        secondClassPrice = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        secondPricePanel.add(secondClassPrice, gridBagConstraints);

    }

    public void initFirstPriceField() {
        JTabbedPane firstPriceTab = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(firstPriceTab, gridBagConstraints);
        JPanel firstPricePanel = new JPanel();
        firstPricePanel.setLayout(new GridBagLayout());
        firstPriceTab.addTab("Prix (1er classe)", firstPricePanel);
        firstClassPrice = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        firstPricePanel.add(firstClassPrice, gridBagConstraints);
    }

    public void initResignationField() {
        GridBagConstraints gridBagConstraints;
        JTabbedPane resignationTab = new JTabbedPane();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(resignationTab, gridBagConstraints);
        JPanel resignationPanel = new JPanel();
        resignationPanel.setLayout(new GridBagLayout());
        resignationTab.addTab("Temps de retractation", resignationPanel);
        daysOfRetractation = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        resignationPanel.add(daysOfRetractation, gridBagConstraints);
    }

    public void initSecondCapacityField() {
        GridBagConstraints gridBagConstraints;
        JTabbedPane secondCapacityTab = new JTabbedPane();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(secondCapacityTab, gridBagConstraints);
        JPanel secondCapacityPanel = new JPanel();
        secondCapacityPanel.setLayout(new GridBagLayout());
        secondCapacityTab.addTab("Capacité (2ème classe)", secondCapacityPanel);
        secondClassCapacity = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        secondCapacityPanel.add(secondClassCapacity, gridBagConstraints);
    }

    public void initFirstCapacityField() {
        GridBagConstraints gridBagConstraints;
        JTabbedPane firstCapacityTab = new JTabbedPane();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(firstCapacityTab, gridBagConstraints);
        JPanel firstCapacityPanel = new JPanel();
        firstCapacityPanel.setLayout(new GridBagLayout());
        firstCapacityTab.addTab("Capacité (1er classe)", firstCapacityPanel);
        firstClassCapacity = new JTextField();
        firstClassCapacity.setEditable(true);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        firstCapacityPanel.add(firstClassCapacity, gridBagConstraints);
    }

    public void initDurationField() {

        GridBagConstraints gridBagConstraints;
        JTabbedPane durationTab = new JTabbedPane();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(durationTab, gridBagConstraints);
        JPanel durationPanel = new JPanel();
        durationPanel.setLayout(new GridBagLayout());
        durationTab.addTab("Durée (min)", durationPanel);

        duration = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        durationPanel.add(duration, gridBagConstraints);
    }

    public void initHourField() {
        JTabbedPane hourTab = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(hourTab, gridBagConstraints);
        JPanel hourPanel = new JPanel();
        hourPanel.setLayout(new GridBagLayout());
        hourTab.addTab("Heure de départ", hourPanel);

        //I don't know if there is a class as Interval in java and I don't have the time to check so I do this horrible initialization.
        Integer[] hours = new Integer[24];
        for (Integer i = 0; i < 24; i++) {
            hours[i] = i;
        }

        hour = new JComboBox<>(hours);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        hourPanel.add(hour, gridBagConstraints);
    }

    public void initDayField() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        JTabbedPane dayTab = new JTabbedPane();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(dayTab, gridBagConstraints);
        JPanel dayPanel = new JPanel();
        dayPanel.setLayout(new GridBagLayout());
        dayTab.addTab("Jour de départ", dayPanel);

        day = new JComboBox<>(DayOfWeek.values());
        day.setToolTipText("Selectionnez le jour du vol");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        dayPanel.add(day, gridBagConstraints);
    }

    public void initTabbedPanels() {
        initOriginTap();
        initDestinationTab();
    }

    public void initDestinationTab() {
        JTabbedPane destinationTabbedPanel = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(destinationTabbedPanel, gridBagConstraints);
        JPanel destinationPanel = new JPanel();
        destinationPanel.setLayout(new BorderLayout(0, 0));
        destinationTabbedPanel.addTab("Destination", destinationPanel);
        JScrollPane destinationScrollPane = new JScrollPane();
        destinationPanel.add(destinationScrollPane, BorderLayout.CENTER);
        destinations = new JList<>();
        //DefaultListModel defaultListModel2 = new DefaultListModel();
        //destinations.setModel(defaultListModel2);
        destinationScrollPane.setViewportView(destinations);
    }

    public void initOriginTap() {
        JTabbedPane originTabbedPanel = new JTabbedPane();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(originTabbedPanel, gridBagConstraints);
        JPanel originPanel = new JPanel();
        originPanel.setLayout(new BorderLayout(0, 0));
        originTabbedPanel.addTab("Origine", originPanel);
        JScrollPane originScrollPane = new JScrollPane();
        originPanel.add(originScrollPane, BorderLayout.CENTER);
        origins = new JList();
        //final DefaultListModel defaultListModel1 = new DefaultListModel();
        //origins.setModel(defaultListModel1);
        //origins.setSelectionMode(0);
        originScrollPane.setViewportView(origins);
    }

    @Override
    public void initLabels() {

    }

    @Override
    public void clean() {
        selectFirstElementIfPossible(origins);
        selectFirstElementIfPossible(destinations);
        day.setSelectedIndex(0);
        hour.setSelectedIndex(0);
        duration.setText("");
        firstClassCapacity.setText("");
        secondClassCapacity.setText("");
        daysOfRetractation.setText("");
        firstClassPrice.setText("");
        secondClassPrice.setText("");
    }

    @Override
    public void setWithNotNull(Fly controller) {
        refresh();
        day.getModel().setSelectedItem(controller.getDay());
        hour.getModel().setSelectedItem(controller.getHour());
        duration.setText(controller.getDuration().toString());
        firstClassCapacity.setText(controller.getFirstClassCapacity().toString());
        firstClassPrice.setText(controller.getFirstClassPrice().toString());
        secondClassCapacity.setText(controller.getSecondClassCapacity().toString());
        secondClassPrice.setText(controller.getSecondClassPrice().toString());
        daysOfRetractation.setText(controller.getDaysOfResignation().toString());
    }

    public void setCityController(Agency cityController) {
        this.cityController = cityController;
        refresh();
    }

    public void refresh() {
        if (cityController != null) {
            refreshList(origins);
            refreshList(destinations);
        }
    }

    public void refreshList(JList list) {
        list.setModel(new CitiesDataSource(cityController));
        //list.revalidate();
        //list.repaint(); // I don't know why the repaint doesn't work :(
        selectFirstElementIfPossible(list);
    }

    public void selectFirstElementIfPossible(JList list) {
        if (list.getModel().getSize() > 0) {
            list.setSelectedIndex(0);
        }
    }

    @Override
    public void revalidate() {
        super.revalidate();
        if (cityController != null) {
            refresh();
        }
    }

    public City flyOrigin() {
        return origins.getSelectedValue();
    }

    public City flyDestination() {
        return destinations.getSelectedValue();
    }

    public DayOfWeek flyDay() {
        return (DayOfWeek) day.getSelectedItem(); //Dunno why I have to cast since day is a JComboBox<DayOfWeek>
    }

    public LocalTime flyHour() {
        return LocalTime.of((Integer) hour.getSelectedItem(), 0, 0); //Idem
    }

    public Integer flyDuration() throws NumberFormatException {
        return Integer.parseInt(duration.getText().trim());
    }

    public Integer flyFirstTimeCapacity() throws NumberFormatException {
        return Integer.parseInt(firstClassCapacity.getText().trim());
    }

    public Integer flySecondClassCapacity() throws NumberFormatException {
        return Integer.parseInt(secondClassCapacity.getText().trim());
    }

    public Integer flyDaysOfResignation() throws NumberFormatException {
        return Integer.parseInt(daysOfRetractation.getText().trim());
    }

    public Integer flySecondClassPrice() throws NumberFormatException {
        return Integer.parseInt(secondClassPrice.getText().trim());
    }

    public Integer flyFirstClassPrice() throws NumberFormatException {
        return Integer.parseInt(firstClassPrice.getText().trim());
    }
}
