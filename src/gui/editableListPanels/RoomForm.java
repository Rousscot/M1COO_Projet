package gui.editableListPanels;

import domaine.destination.Room;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public class RoomForm extends AbstractForm<Room> {

    protected static final String LABEL = "Number :";
    protected JTextField numberField;

    public RoomForm() {
        super();
    }

    @Override
    public LayoutManager getFormLayout() {
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

    @Override
    public void setWithNotNull(Room controller) {
        numberField.setText(controller.getCategory().toString());
    }

    public Integer roomNumber() {
        return Integer.parseInt(numberField.getText().trim());
    }
}
