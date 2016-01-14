package gui.editableListPanels;

import javax.swing.*;

/**
 * Created by JeCisC on 14/01/2016.
 */
public class NextButtonBar extends JPanel {

    protected NextButtonUser listener;

    public NextButtonBar(NextButtonUser listener) {
        initButton();
        this.listener = listener;
    }

    public void initButton() {
        JButton button = new JButton("Suivant");
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setToolTipText("Continuer au panneau suivant");
        button.addActionListener(e -> nextAction());
        add(button);
    }

    public void nextAction() {
        listener.nextAction();
    }
}
