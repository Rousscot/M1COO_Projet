package gui.editableListPanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferlicotdelbe on 17/12/15.
 */
public abstract class AbstractForm extends JPanel {

    public AbstractForm(){
        setLayout(getFormLayout());
        initTextFields();
        initLabels();
    }

    protected abstract LayoutManager getFormLayout();

    protected abstract void initTextFields();

    protected abstract void initLabels();

    public abstract void clean();
    
}
