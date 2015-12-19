package gui.editableListPanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public class RoomForm extends AbstractForm {

    protected JTextField numberField;
    protected static final String LABEL = "Number :";

    public RoomForm(){
        super();
    }

    @Override
    public LayoutManager getFormLayout(){
        return new GridLayout(1, 2, 0, 5);
    }

    @Override
    public void initLabels() {
        JLabel label = new JLabel(RoomForm.LABEL);
        add(label);
        add(numberField);
    }

    @Override
    public void initTextFields() {
        numberField = new JTextField();
        numberField.setColumns(2);
    }

    @Override
    public void clean() {
        numberField.setText("");
    }

    public Integer roomNumber() {
        return Integer.parseInt(numberField.getText().trim());
    }
}
