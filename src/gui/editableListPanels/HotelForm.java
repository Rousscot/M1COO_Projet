package gui.editableListPanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public class HotelForm extends AbstractForm {

    protected JTextField nameField;
    protected JTextField resignationField;
    protected static final String LABEL = "Nom :";
    protected static final String LABEL2 = "Jours d'annulation :";

    public HotelForm(){
        super();
    }

    @Override
    public LayoutManager getFormLayout(){
        return new GridLayout(2, 2, 0, 5);
    }

    @Override
    public void initLabels() {
        JLabel label = new JLabel(HotelForm.LABEL);
        JLabel label2 = new JLabel(HotelForm.LABEL2);
        add(label);
        add(nameField);
        add(label2);
        add(resignationField);
    }

    @Override
    public void initTextFields() {
        nameField = new JTextField();
        resignationField = new JTextField();
    }

    @Override
    public void clean() {
        nameField.setText("");
        resignationField.setText("");
    }

    public String hotelName() {
        return nameField.getText();
    }

    public Integer dayOfResignation() throws NumberFormatException{
        return Integer.parseInt(resignationField.getText().trim());
    }
}
