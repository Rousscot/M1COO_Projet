package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 14/12/2015.
 */
public class AgencyGUI extends JFrame {

    protected ActionPanel actionManager;

    protected JPanel mainPanel;

    public AgencyGUI() {
        initFrame();
        initPanels();
        setVisible(true);
    }

    public void initPanels() {
        mainPanel = new JPanel(); //I set it to a JPanel to be able to remove it without a NilCheck.

        actionManager = new ActionPanel(this);
        this.add(actionManager, BorderLayout.WEST);
 }

    public void initFrame() {
        this.setTitle("Agency TP");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);
        this.setMinimumSize(new Dimension(700,500));
        setLayout(new BorderLayout());
    }

    public void setMainPanelWith(JPanel panel){
        remove(mainPanel);
        mainPanel = panel;
        add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
