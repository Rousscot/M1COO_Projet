package gui.actionPanels;

import dao.exception.DAOException;
import domaine.destination.City;
import domaine.exception.CityNotFoundException;
import domaine.exception.DuplicatedCityException;
import factory.Agency;
import gui.model.CitiesDataSource;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class CityManagerPanel extends JPanel implements StandardButtonsUsers {

    protected JList<City> jList;
    protected CityForm form;
    protected StandardButtonsBar buttonsBar;
    protected Agency controller;

    public CityManagerPanel(Agency controller) {
        setBackground(Color.PINK);
        this.controller = controller;
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
        jList = new JList<>(new CitiesDataSource(controller));
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void initComponents() {
        initJList();
        form = new CityForm();
        buttonsBar = new StandardButtonsBar(this);
    }

    @Override
    public void createItem() {
        //TODO Check that the field is not empty
        try {
            controller.createAndAddCity(cityName());
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard.");
        } catch (DuplicatedCityException e) {
            JOptionPane.showMessageDialog(this, "Cette Ville existe déjà.");
        }
        cleanFields();
        refresh();
    }

    public void refresh() {
        jList.revalidate();
        jList.repaint();
        jList.setModel(new CitiesDataSource(controller)); // I don't know why the repaint doesn't work :(

    }

    public String cityName() {
        return form.cityName();
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
            } catch ( DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard.");
            } catch (CityNotFoundException e) {
                JOptionPane.showMessageDialog(this, "La ville selectionnée a déjà été supprimée.");
            }
        }
    }

    public void cleanFields() {
        form.clean();
    }
}
