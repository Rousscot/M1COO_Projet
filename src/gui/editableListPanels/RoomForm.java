package gui.editableListPanels;

import domaine.destination.Room;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public class RoomForm extends AbstractForm<Room> {

    protected static final String LABEL = "Numéro :";
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
        numberField = new JTextField();
        fsTabbedPanel.addTab(label, numberField);
    }

    @Override
    public void clean() {
        numberField.setText("");
    }

    @Override
    public void setWithNotNull(Room controller) {
        numberField.setText(controller.getNumber().toString());
    }

    public Integer roomNumber() {
        return Integer.parseInt(numberField.getText().trim());
    }
}
