package gui.editableListPanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JeCisC on 17/12/2015.
 * <p>
 * TODO
 * <p>
 * C is the type of the Panel controller.
 * T is the type of the elements of the list.
 * F is a type of form to use.
 */
public abstract class AbstractManagementPanel<C, T, F extends AbstractForm> extends JPanel implements StandardButtonsUsers {

    protected JList<T> jList;
    protected F form;
    protected StandardButtonsBar buttonsBar;
    protected C controller;

    public AbstractManagementPanel(C controller) {
        this.controller = controller;
        initComponents();
        addPanels();
    }

    public AbstractManagementPanel() {
        this(null);
    }

    public C getController() {
        return controller;
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
        //TODO 
        if (getController() != null) {
            setModelOfList();
        }
        jList.addListSelectionListener(e -> listSelectionChanged());
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    //HOOK
    protected void listSelectionChanged(){
        form.setWith(jList.getSelectedValue());
}

    public abstract void setModelOfList();

    public void initComponents() {
        initJList();
        initForm();
        initButtonsBar();
    }

    //Hook :)
    public void initButtonsBar() {
        buttonsBar = new StandardButtonsBar(this, false);
    }

    public abstract void initForm();

    @Override
    public abstract void createItem();

    public void refresh() {
        jList.revalidate();
        jList.repaint();
        setModelOfList(); // I don't know why the repaint doesn't work :(
        selectFirstIfPossible();
    }

    @Override
    public abstract void deleteItem();

    @Override
    public void updateItem() {
        //In most case I should not be call. If a class override #initButtonsBar I should maybe override this method. :)
    }

    @Override
    public void cleanFields() {
        form.clean();
    }

    public void selectFirstIfPossible() {
        if (jList.getModel().getSize() > 0) {
            jList.setSelectedIndex(0);
        }
    }

    public void setController(C controller) {
        this.controller = controller;
        refresh();
    }

}
