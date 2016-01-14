package gui.editableListPanels;

import domaine.destination.Hotel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public class HotelForm extends AbstractForm<Hotel> {

    protected static final String LABEL = "Nom :";
    protected static final String LABEL2 = "Jours d'annulation :";
    protected JTextField nameField;
    protected JTextField resignationField;
    protected JPanel hotelPanel;

    public HotelForm() {
        super();
    }

    @Override
    public LayoutManager getFormLayout() {
        return new GridLayout(1,1);
    }

    /**
     * initialize the hotel tabbed panes and add them to the hotel panel
     */
    private void configureHotelTabbedPanel() {
        JTabbedPane nameTabbedPanel = new JTabbedPane();
        hotelPanel.add(nameTabbedPanel);
        nameField = new JTextField();
        nameTabbedPanel.addTab(LABEL, nameField);

        JTabbedPane resignationTabbedPanel = new JTabbedPane();
        hotelPanel.add(resignationTabbedPanel);
        resignationField = new JTextField();
        resignationTabbedPanel.addTab(LABEL2, resignationField);
    }

    @Override
    public void initTextFields() {
        hotelPanel = new JPanel();
        hotelPanel.setLayout(new GridLayout(2,1));
        configureHotelTabbedPanel();
        add(hotelPanel);
    }

    @Override
    public void clean() {
        nameField.setText("");
        resignationField.setText("");
    }

    @Override
    public void setWithNotNull(Hotel controller) {
        nameField.setText(controller.getName());
        resignationField.setText(controller.getResignationDays().toString());
    }

    public String hotelName() {
        return nameField.getText();
    }

    public Integer dayOfResignation() throws NumberFormatException {
        return Integer.parseInt(resignationField.getText().trim());
    }
}
