package gui.actionPanels;

import javax.swing.*;

/**
 * Created by JeCisC on 16/12/2015.
 */
public class StandardButtonsBar extends JPanel {

    protected StandardButtonsUsers listener;

    public StandardButtonsBar(StandardButtonsUsers listener) {
        initAddButton();
        initDeleteButton();
        this.listener = listener;
    }

    public void initDeleteButton() {
        JButton button = createButton("Delete", "Permet de supprimer un élément.");
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
}
