package gui.editableListPanels;

import domaine.Fly;
import factory.Agency;

/**
 * Created by ferlicotdelbe on 07/01/16.
 */
public class FlyManagementPanel extends AbstractManagementPanel<Agency, Fly, FlyForm> {

    public FlyManagementPanel(Agency controller) {
        super(controller);
        selectFirstIfPossible();
    }

    @Override
    protected void listSelectionChanged() {

    }

    @Override
    public void setModelOfList() {

    }

    @Override
    public void initForm() {

    }

    @Override
    public void createItem() {

    }

    @Override
    public void deleteItem() {

    }

    public String toString(){
        return "Gestion des vols";
    }
}
