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
        return new GridLayout(1, 2, 0, 5);
    }

    @Override
    public void initLabels() {
        JLabel label = new JLabel(CityForm.LABEL);
        add(label);
        add(nameField);
    }

    @Override
    public void initTextFields() {
        nameField = new JTextField();
        nameField.setColumns(2);
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
