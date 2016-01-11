package gui.editableListPanels;

import domaine.destination.City;
import factory.Agency;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Created by ferlicotdelbe on 07/01/16.
 */
public class FlyForm extends AbstractForm<Agency> {

    protected JList<City> origins;

    protected JList<City> destinations;

    protected JComboBox day;

    protected JComboBox hour;

    protected JTextField duration;

    protected JTextField firstClassCapacity;

    protected JTextField secondClassCapacity;

    protected JTextField daysOfRetractation;

    public FlyForm(){
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
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JPanel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JPanel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JPanel(), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(new JPanel(), gridBagConstraints);
    }

    @Override
    public void initTextFields() {
        initTabbedPanels();

        day = new JComboBox();
        day.setModel(new DefaultComboBoxModel());
        day.setToolTipText("Selectionnez le jour du vol");
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(day, gridBagConstraints);

        hour = new JComboBox();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(hour, gridBagConstraints);

        duration = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(duration, gridBagConstraints);

        firstClassCapacity = new JTextField();
        firstClassCapacity.setEditable(true);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(firstClassCapacity, gridBagConstraints);

        secondClassCapacity = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(secondClassCapacity, gridBagConstraints);

        daysOfRetractation = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        this.add(daysOfRetractation, gridBagConstraints);

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
        destinations = new JList();
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
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Jour de départ"), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Heure de départ"), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Durée (Minutes)"), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Capacité (première classe)"), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Capacité (deuxième classe)"), gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        this.add(new JLabel("Temps de retractation (jour)"), gridBagConstraints);
    }

    @Override
    public void clean() {

    }

    @Override
    public void setWithNotNull(Agency controller) {

    }

    public City flyOrigin() {
        return origins.getSelectedValue();
    }

    public City flyDestination() {
        return destinations.getSelectedValue();
    }

    public DayOfWeek flyDay() {
        return null;
    }

    public LocalTime flyHour() {
        return null;
    }

    public Integer flyDuration() throws NumberFormatException{
        return null;
    }

    public Integer flyFirstTimeCapacity() throws NumberFormatException{
        return null;
    }

    public Integer flySecondClassCapacity() throws NumberFormatException{
        return null;
    }

    public Integer flyDaysOfResignation() throws NumberFormatException{
        return null;
    }
}
