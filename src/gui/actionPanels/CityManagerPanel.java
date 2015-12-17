package gui.actionPanels;

import factory.Agency;
import gui.model.CitiesDataSource;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class CityManagerPanel extends JPanel implements StandardButtonsUsers {

    protected JList jList;
    protected CityForm form;
    protected StandardButtonsBar buttonsBar;
    protected Agency controller;

    public CityManagerPanel(Agency controller){
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
        jList = new JList<>();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setModel(new CitiesDataSource(controller));
    }

    public void initComponents() {
        initJList();
        form = new CityForm();
        buttonsBar = new StandardButtonsBar(this);
    }

    @Override
    public void createItem() {

            //TODO Check that the field is not empty
            controller.createAndAddCity(cityName());
            cleanFields();
            refresh();
        /*} catch (EntryInsertException e) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard.");
        } catch (DuplicateEntryException e) {
            JOptionPane.showMessageDialog(this, "Ce contact existe déjà.");
        }*/ //TODO Errors
    }

    public void refresh() {
        //TODO
    }

    public String cityName() {
        return form.cityName();
    }

    @Override
    public void deleteItem() {
        //TODO
        System.out.println("delete");
    }

    public void cleanFields(){
        form.clean();
    }
}
