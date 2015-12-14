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
        actionManager = new ActionPanel();
        this.add(actionManager, BorderLayout.WEST);

        mainPanel = new JPanel(); //Change to something else later :)
        add(mainPanel, BorderLayout.CENTER);
    }

    public void initFrame() {
        this.setTitle("Agency TP");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);
        this.setMinimumSize(new Dimension(700,500));
        setLayout(new BorderLayout());
    }
}
