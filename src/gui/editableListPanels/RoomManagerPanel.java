package gui.editableListPanels;

import dao.exception.DAOException;
import domaine.destination.Category;
import domaine.destination.Room;
import domaine.exception.DuplicatedRoomException;
import domaine.exception.RoomNotFoundException;
import gui.NullObjects.NullCategory;
import gui.model.RoomsDataSource;

import javax.swing.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class RoomManagerPanel extends AbstractManagementPanel<Category, Room, RoomForm> {

    public RoomManagerPanel() {
        super();
        selectFirstIfPossible();
    }

    @Override
    public Category getController(){
        if(this.controller == null){
            NullCategory category = new NullCategory(null, null, null, null);
            category.setOwner(this);
            this.controller = category;
        }
        return this.controller;
    }

    @Override
    public void setModelOfList() {
        jList.setModel(new RoomsDataSource(getController()));
    }

    @Override
    public void initForm() {
        form = new RoomForm();
    }

    @Override
    public void listSelectionChanged() {
        form.setWith(jList.getSelectedValue());
    }

    @Override
    public void createItem() {
        //TODO Check that the field is not empty
        try {
            getController().createAndAddRoom(roomNumber());
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
        } catch (DuplicatedRoomException e) {
            JOptionPane.showMessageDialog(this, e.getRoom().toString() + " existe déjà.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Le numero devrait être un nombre.");
        }
        cleanFields();
        refresh();
    }

    @Override
    public void deleteItem() {
        Room room = jList.getSelectedValue();
        if (room == null) {
            JOptionPane.showMessageDialog(this, "Pas de chambre selectionnée.");
        } else {
            try {
                getController().deleteRoom(room);
                refresh();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
            } catch (RoomNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.getRoom().toString() + " a déjà été supprimée.");
            }
        }
    }

    public Integer roomNumber()  throws NumberFormatException  {
        return form.roomNumber();
    }

}
