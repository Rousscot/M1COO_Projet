package gui.editableListPanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public class CityForm extends AbstractForm {

    protected JTextField nameField;
    protected static final String LABEL = "Ville :";

    public CityForm(){
        setLayout(new GridLayout(1, 2, 0, 5));
        initLabels();
        initTextFields();
    }

    public void initLabels() {
        JLabel label = new JLabel(CityForm.LABEL);
        add(label);
    }

    public void initTextFields() {
        nameField = new JTextField();
        nameField.setColumns(2);
        add(nameField);
    }

    @Override
    public void clean() {
        nameField.setText("");
    }

    public String cityName() {
        return nameField.getText();
    }
}
