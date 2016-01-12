package gui;

import factory.Agency;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class AgencyGUI extends JFrame {

    protected ActionPanel actionManager;

    protected JPanel mainPanel;

    public AgencyGUI(Agency controller) {
        initFrame();
        initPanels(controller);
        setVisible(true);
    }

    public void initPanels(Agency controller) {
        mainPanel = new JPanel(); //I set it to a JPanel to be able to remove it without a NilCheck.

        actionManager = new ActionPanel(this, controller);
        this.add(actionManager, BorderLayout.WEST);
 }

    public void initFrame() {
        this.setTitle("Agency TP");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);
        this.setMinimumSize(new Dimension(1500,768));
        setLayout(new BorderLayout());
    }

    public void setMainPanelWith(JPanel panel){
        remove(mainPanel);
        mainPanel = panel;
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        revalidate();
        repaint();
    }
}
