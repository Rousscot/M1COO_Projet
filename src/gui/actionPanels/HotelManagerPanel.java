package gui.actionPanels;

import dao.exception.DAOException;
import domaine.destination.City;
import domaine.destination.Hotel;
import domaine.exception.DuplicatedHotelException;
import domaine.exception.HotelNotFoundException;
import gui.model.HotelsDataSource;

import javax.swing.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class HotelManagerPanel extends AbstractManagementPanel<City, Hotel, HotelForm> {

    public HotelManagerPanel(City controller) {
        super(controller);
        //this.owner = owner;
        selectFirstIfPossible();
    }

    @Override
    public void setModelOfList() {
        jList.setModel(new HotelsDataSource(controller));
    }

    @Override
    public void initForm() {
        form = new HotelForm();
    }

    @Override
    public void listSelectionChanged() {
        //TODO
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

    @Override
    public void deleteItem() {
        Hotel hotel = jList.getSelectedValue();
        if (hotel == null) {
            JOptionPane.showMessageDialog(this, "Pas de ville selectionnée.");
        } else {
            try {
                controller.deleteHotel(hotel);
                refresh();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
            } catch (HotelNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.getHotel().toString() + " a déjà été supprimée.");
            }
        }
    }

    public String hotelName() {
        return form.hotelName();
    }

    public Integer dayOfResignations() throws NumberFormatException {
        return form.dayOfResignation();
    }
}
