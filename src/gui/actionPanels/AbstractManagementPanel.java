package gui.actionPanels;

import gui.model.CitiesDataSource;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 17/12/2015.
 */
public abstract class AbstractManagementPanel<C, T, F extends AbstractForm> extends JPanel implements StandardButtonsUsers  {

    protected JList<T> jList;
    protected F form;
    protected StandardButtonsBar buttonsBar;
    protected C controller;

    public AbstractManagementPanel(C controller) {
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
        setModelOfList();
        jList.addListSelectionListener(e -> listSelectionChanged());
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    protected abstract void listSelectionChanged();

    public abstract void setModelOfList();

    public void initComponents() {
        initJList();
        initForm();
        buttonsBar = new StandardButtonsBar(this);
    }

    public abstract void initForm();


    @Override
    public abstract void createItem();

    public void refresh() {
        jList.revalidate();
        jList.repaint();
        setModelOfList(); // I don't know why the repaint doesn't work :(
    }

    @Override
    public abstract void deleteItem();

    @Override
    public void cleanFields() {
        form.clean();
    }

    public void selectFirstIfPossible(){
        if (jList.getModel().getSize() > 0) {
            jList.setSelectedIndex(0);
        }
    }

    public void setController(C controller){
        this.controller = controller;
        refresh();
    }

}
