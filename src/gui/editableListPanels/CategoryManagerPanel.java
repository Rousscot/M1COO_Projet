package gui.editableListPanels;

import dao.exception.DAOException;
import domaine.destination.Category;
import domaine.destination.Hotel;
import domaine.exception.CategoryNotFoundException;
import domaine.exception.DuplicatedCategoryException;
import gui.CategorySelectionListener;
import gui.NullObjects.NullHotel;
import gui.model.CategoriesDataSource;

import javax.swing.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class CategoryManagerPanel extends AbstractManagementPanel<Hotel, Category, CategoryForm> {
//TODO Manage the case where there is not hotel selected. Also the case where we add something where the previous is not selected.

    protected CategorySelectionListener owner;

    public CategoryManagerPanel(CategorySelectionListener owner) {
        super();
        this.owner = owner;
    }

    @Override
    public Hotel getController(){
        if(this.controller == null){
            this.controller = new NullHotel(null, null, null);
        }
        return this.controller;
    }

    @Override
    public void setModelOfList() {
        jList.setModel(new CategoriesDataSource(getController()));
    }

    @Override
    public void initForm() {
        form = new CategoryForm();
    }

    @Override
    public void initButtonsBar() {
        buttonsBar = new StandardButtonsBar(this, true);
    }
    @Override
    public void listSelectionChanged() {
        Category newSelection = jList.getSelectedValue();
        form.setWith(newSelection);
        owner.categorySelected(jList.getSelectedValue());
    }

    @Override
    public void createItem() {
        //TODO Check that the field is not empty
        try {
            getController().createAndAddCategory(categoryDesignation(), categoryCapacity(), categoryPrice());
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
        } catch (DuplicatedCategoryException e) {
            JOptionPane.showMessageDialog(this, e.getCategory().toString() + " existe déjà.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La capacité et le prix devraient être des nombres. (bitch).");
        }
        cleanFields();
        refresh();
    }

    @Override
    public void deleteItem() {
        Category category = jList.getSelectedValue();
        if (category == null) {
            JOptionPane.showMessageDialog(this, "Pas de category selectionnée.");
        } else {
            try {
                getController().deleteCategory(category);
                refresh();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
            } catch (CategoryNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.getCategory().toString() + " a déjà été supprimée.");
            }
        }
    }

    @Override
    public void updateItem(){
        //TODO
    }

    public String categoryDesignation() {
        return form.categoryDesignation();
    }

    public Integer categoryCapacity()  throws NumberFormatException  {
        return form.categoryCapacity();
    }

    public Integer categoryPrice()  throws NumberFormatException  {
        return form.categoryPrice();
    }

}
