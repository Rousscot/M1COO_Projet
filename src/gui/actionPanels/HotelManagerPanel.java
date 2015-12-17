package gui.actionPanels;

import dao.exception.DAOException;
import domaine.destination.City;
import domaine.destination.Hotel;
import domaine.exception.CityNotFoundException;
import domaine.exception.DuplicatedCityException;
import domaine.exception.DuplicatedHotelException;
import domaine.exception.HotelNotFoundException;
import factory.Agency;
import gui.model.CitiesDataSource;
import gui.model.HotelsDataSource;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class HotelManagerPanel extends JPanel implements StandardButtonsUsers {

    protected JList<Hotel> jList;
    protected HotelForm form;
    protected StandardButtonsBar buttonsBar;
    protected City controller;

    public HotelManagerPanel() {
        initComponents();
        addPanels();
    }

    public void addPanels() {
        setLayout(new BorderLayout());
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(250, 250));
        add("North", jScrollPane);
        add("Center", form);
        add("South", buttonsBar);
    }

    public void initJList() {
        jList = new JList<>(new HotelsDataSource(controller));
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if(jList.getModel().getSize() > 0){
            jList.setSelectedIndex(0);
        }
    }

    public void initComponents() {
        initJList();
        form = new HotelForm();
        buttonsBar = new StandardButtonsBar(this);
    }

    @Override
    public void createItem() {
        //TODO Check that the field is not empty
        try {
            controller.createAndAddHotel(hotelName(), dayOfResignations());
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
        } catch (DuplicatedHotelException e) {
            JOptionPane.showMessageDialog(this, e.getHotel().toString() + " existe déjà.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Le nombre de jours de reservation devrait être un nombre.");
        }
        cleanFields();
        refresh();
    }

    public void refresh() {
        jList.revalidate();
        jList.repaint();
        jList.setModel(new HotelsDataSource(controller)); // I don't know why the repaint doesn't work :(

    }

    public String hotelName() {
        return form.hotelName();
    }

    public Integer dayOfResignations() throws NumberFormatException{
        return form.dayOfResignation();
    }

    @Override
    public void deleteItem() {
        Hotel hotel = jList.getSelectedValue();
        if (hotel == null) {
            JOptionPane.showMessageDialog(this, "Pas de ville selectionnée.");
        } else {
            try {
                controller.deleteHotel(hotel);
                refresh();
            } catch ( DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
            } catch (HotelNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.getHotel().toString() + " a déjà été supprimée.");
            }
        }
    }

    public void cleanFields() {
        form.clean();
    }

    public void setController(City controller){
        this.controller = controller;
        refresh();
    }
}
