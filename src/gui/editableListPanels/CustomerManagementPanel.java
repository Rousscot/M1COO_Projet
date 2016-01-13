package gui.editableListPanels;

import dao.exception.DAOException;
import domaine.Customer;
import domaine.destination.City;
import domaine.exception.CustomerNotFoundException;
import domaine.exception.DuplicatedCustomerException;
import factory.Agency;
import gui.model.CustomerDataSource;

import javax.swing.*;
import java.time.LocalDate;

/**
 * Created by aurelien on 10/01/2016.
 */
public class CustomerManagementPanel extends AbstractManagementPanel<Agency, Customer, CustomerForm>{

    public CustomerManagementPanel(Agency controller){
        super(controller);
        selectFirstIfPossible();
        form.setCustomerController(controller);
    }

    @Override
    public void setModelOfList() {
        jList.setModel(new CustomerDataSource(getController()));
    }

    @Override
    public void initForm() {
        form = new CustomerForm();
    }

    @Override
    public void initButtonsBar() {
        buttonsBar = new StandardButtonsBar(this, true);
    }

    @Override
    public void createItem() {
        // TODO check that the field is not empty
        try {
            getController().createAndAddCustomer(firstName(), lastName(), birthday(), city());
        } catch (DAOException e){
            JOptionPane.showMessageDialog(this, "Une erreur s'est produite. Veuillez réessayer plus tard." + e.toString());
        } catch (DuplicatedCustomerException e){
            JOptionPane.showMessageDialog(this, e.getCustomer().toString() + " existe déjà.");
        }
        cleanFields();
        refresh();
    }

    @Override
    public void deleteItem() {
        Customer customer = jList.getSelectedValue();
        if (customer==null){
            JOptionPane.showMessageDialog(this, "Pas de client selectionné.");
        } else {
            try {
                getController().deleteCustomer(customer);
                refresh();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite, veuillez réessayer plus tard: "+e.toString());
            } catch (CustomerNotFoundException e){
                JOptionPane.showMessageDialog(this, customer.getLastName() +" "+ customer.getFirstName()+ " a déjà été supprimé.");
            }
        }
    }

    @Override
    public void updateItem(){
        Customer customerBefore = jList.getSelectedValue();
        Customer customerAfter = new Customer(firstName(), lastName(), birthday(), city());
        if (customerBefore==null){
            JOptionPane.showMessageDialog(this, "Pas de client selectionné.");
        } else {
            try {
                getController().updateCustomer(customerBefore, customerAfter);
                refresh();
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Une erreur s'est produite, veuillez réessayer plus tard: "+e.toString());
            }
        }
    }

    private City city() {
        return form.city();
    }

    private LocalDate birthday() {
        return form.birthday();
    }

    private String lastName() {
        return form.lastName();
    }

    private String firstName() {
        return form.firstName();
    }

    public String toString(){
        return "Gestion des clients";
    }

    @Override
    public void revalidate() {
        super.revalidate();
        if (form != null) {
            form.revalidate();
        }
    }

}
