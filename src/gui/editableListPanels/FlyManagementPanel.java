package gui.editableListPanels;

import dao.exception.DAOException;
import domaine.Fly;
import domaine.destination.City;
import domaine.exception.DuplicatedFlyException;
import domaine.exception.FlyNotFoundException;
import factory.Agency;
import gui.model.FliesDataSource;

import javax.swing.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Created by ferlicotdelbe on 07/01/16.
 */
public class FlyManagementPanel extends AbstractManagementPanel<Agency, Fly, FlyForm> {

    public FlyManagementPanel(Agency controller) {
        super(controller);
        selectFirstIfPossible();
        form.setCityController(controller);
    }

    @Override
    public void setModelOfList() {
        jList.setModel(new FliesDataSource(getController()));
    }

    @Override
    public void initForm() {
        form = new FlyForm();
    }

    @Override
    public void initButtonsBar() {
        buttonsBar = new StandardButtonsBar(this, true);
    }

    @Override
    public void createItem() {
        //TODO Check that the field is not empty
        if (flyOrigin().equals(flyDestination())) {
            JOptionPane.showMessageDialog(this, "Les deux villes doivent être différentes.");
        } else {
            try {
                getController().createAndAddFly(flyOrigin(), flyDestination(), flyDay(), flyHour(), flyDuration(), flyFirstClassCapacity(), flyFirstClassPrice(), flySecondClassCapacity(), flySecondClassPrice(), flyDaysOfResignation());
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
            } catch (DuplicatedFlyException e) {
                JOptionPane.showMessageDialog(this, e.getFly().toString() + " existe déjà.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "L'heure, les capacités et le nombre de jours avant resignation devraient être des nombres. (bitch).");
            }
            cleanFields();
            refresh();
        }

    }

    @Override
    public void deleteItem() {
        Fly fly = jList.getSelectedValue();
        if (fly == null) {
            JOptionPane.showMessageDialog(this, "Pas de vol selectionné.");
        } else {
            try {
                getController().deleteFly(fly);
                refresh();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
            } catch (FlyNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.getFly().toString() + " a déjà été supprimée.");
            }
        }
    }

    /*@Override
    public void updateItem() {
        if (jList.getSelectedValue().getDesignation().equals(categoryDesignation())) {
            try {
                jList.getSelectedValue().updateWith(categoryCapacity(), categoryPrice());
                refresh();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez ne pas changer le nom de la désignation.");
        }
    }*/

    @Override
    public String toString() {
        return "Gestion des vols";
    }

    public City flyOrigin() {
        return form.flyOrigin();
    }

    public City flyDestination() {
        return form.flyDestination();
    }

    public DayOfWeek flyDay() {
        return form.flyDay();
    }

    public LocalTime flyHour() {
        return form.flyHour();
    }

    public Integer flyDuration() throws NumberFormatException {
        return form.flyDuration();
    }

    public Integer flyFirstClassCapacity() throws NumberFormatException {
        return form.flyFirstTimeCapacity();
    }

    public Integer flySecondClassCapacity() throws NumberFormatException {
        return form.flySecondClassCapacity();
    }

    public Integer flyDaysOfResignation() throws NumberFormatException {
        return form.flyDaysOfResignation();
    }

    public  Integer flySecondClassPrice()  throws NumberFormatException {
        return form.flySecondClassPrice();
    }

    public Integer flyFirstClassPrice() throws NumberFormatException  {
        return form.flyFirstClassPrice();
    }

    @Override
    public void revalidate() {
        super.revalidate();
        if (form != null) {
            form.revalidate();
        }
    }

}
