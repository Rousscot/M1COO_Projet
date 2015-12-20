package gui.editableListPanels;

import javax.swing.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class StandardButtonsBar extends JPanel {

    protected StandardButtonsUsers listener;

    public StandardButtonsBar(StandardButtonsUsers listener, Boolean shouldHaveAnUpdateButton) {
        initAddButton();
        initDeleteButton();
        initCleanButton();
        if(shouldHaveAnUpdateButton){
            initUpdateButton();
        }
        this.listener = listener;
    }

    public void initUpdateButton() {
        JButton button = createButton("Mise à Jour", "Permet de mettre à jour un élément.");
        button.addActionListener(e -> updateAction());
        add(button);
    }

    public void initCleanButton() {
        JButton button = createButton("Nettoyer", "Permet de nettoyer les champs.");
        button.addActionListener(e -> cleanAction());
        add(button);
    }

    public void initDeleteButton() {
        JButton button = createButton("Supprimer", "Permet de supprimer un élément.");
        button.addActionListener(e -> deleteAction());
        add(button);
    }

    public JButton createButton(String name, String help) {
        JButton button = new JButton(name);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setToolTipText(help);
        return button;
    }

    public void initAddButton() {
        JButton button = createButton("Ajouter", "Permet d'ajouter un élément.");
        button.addActionListener(e -> addAction());
        add(button);
    }

    public void addAction(){
        listener.createItem();
    }

    public void deleteAction(){
        listener.deleteItem();
    }

    public void cleanAction() {
        listener.cleanFields();
    }

    public void updateAction() {
        listener.updateItem();
    }

}
