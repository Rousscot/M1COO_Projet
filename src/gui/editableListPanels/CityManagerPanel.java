package gui.editableListPanels;

import dao.exception.DAOException;
import domaine.destination.City;
import domaine.exception.CityNotFoundException;
import domaine.exception.DuplicatedCityException;
import factory.Agency;
import gui.CitySelectionListener;
import gui.model.CitiesDataSource;

import javax.swing.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class CityManagerPanel extends AbstractManagementPanel<Agency, City, CityForm> {

    protected CitySelectionListener owner;

    public CityManagerPanel(Agency controller, CitySelectionListener owner) {
        super(controller);
        this.owner = owner;
        selectFirstIfPossible();
    }

    @Override
    public void setModelOfList() {
        jList.setModel(new CitiesDataSource(controller));
    }

    @Override
    public void initForm() {
        form = new CityForm();
    }

    @Override
    public void listSelectionChanged() {
        super.listSelectionChanged();
        owner.citySelected(jList.getSelectedValue());
    }

    @Override
    public void createItem() {
        //TODO Check that the field is not empty
        try {
            controller.createAndAddCity(cityName());
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
        } catch (DuplicatedCityException e) {
            JOptionPane.showMessageDialog(this, e.getCity().toString() + " existe déjà.");
        }
        cleanFields();
        refresh();
    }

    @Override
    public void deleteItem() {
        City city = jList.getSelectedValue();
        if (city == null) {
            JOptionPane.showMessageDialog(this, "Pas de ville selectionnée.");
        } else {
            try {
                controller.deleteCity(city);
                refresh();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
            } catch (CityNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.getCity().toString() + " a déjà été supprimée.");
            }
        }
    }

    public String cityName() {
        return form.cityName();
    }

}
