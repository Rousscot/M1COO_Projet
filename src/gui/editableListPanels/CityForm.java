package gui.editableListPanels;

import domaine.destination.City;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public class CityForm extends AbstractForm<City> {

    protected JTextField nameField;
    protected static final String LABEL = "Ville :";

    public CityForm(){
        super();
    }

    @Override
    public LayoutManager getFormLayout(){
        return new BorderLayout();
    }

    @Override
    public void initLabels() {
        configureTabbedPanel(LABEL);
    }

    @Override
    public void initTextFields() {
    }

    /**
     * initialize the city tabbed pane to the main panel
     * @param label the label to set to the tabbed pane
     */
    public void configureTabbedPanel(String label){
        JTabbedPane fsTabbedPanel = new JTabbedPane();
        this.add(fsTabbedPanel);
        nameField = new JTextField();
        fsTabbedPanel.addTab(label, nameField);
    }

    @Override
    public void clean() {
        nameField.setText("");
    }

    @Override
    public void setWithNotNull(City controller) {
        nameField.setText(controller.getName());
    }

    public String cityName() {
        return nameField.getText();
    }
}
