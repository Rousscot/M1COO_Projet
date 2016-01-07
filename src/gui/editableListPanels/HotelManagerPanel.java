package gui.editableListPanels;

import dao.exception.DAOException;
import domaine.destination.City;
import domaine.destination.Hotel;
import domaine.exception.DuplicatedHotelException;
import domaine.exception.HotelNotFoundException;
import gui.HotelSelectionListener;
import gui.model.HotelsDataSource;

import javax.swing.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class HotelManagerPanel extends AbstractManagementPanel<City, Hotel, HotelForm> {

    protected HotelSelectionListener owner;

    public HotelManagerPanel(HotelSelectionListener owner) {
        super();
        this.owner = owner;
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
    public void initButtonsBar() {
        buttonsBar = new StandardButtonsBar(this, true);
    }

    @Override
    public void listSelectionChanged() {
        super.listSelectionChanged();
        owner.hotelSelected(jList.getSelectedValue());
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
            JOptionPane.showMessageDialog(this, "Pas d'hôtel selectionnée.");
            refresh();
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

    @Override
    public void updateItem(){
        if(jList.getSelectedValue().getName().equals(hotelName())){
            try {
                jList.getSelectedValue().updateWith(dayOfResignations());
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
            }
        }else{
            JOptionPane.showMessageDialog(this, "Veuillez ne pas changer le nom de l'hôtel.");
        }
    }

    public String hotelName() {
        return form.hotelName();
    }

    public Integer dayOfResignations() throws NumberFormatException {
        return form.dayOfResignation();
    }
}
