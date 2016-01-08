package gui.editableListPanels;

import domaine.destination.City;
import factory.Agency;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Created by ferlicotdelbe on 07/01/16.
 */
public class FlyForm extends AbstractForm<Agency> {

    protected JList<City> origins;

    protected JList<City> detinations;



    @Override
    protected LayoutManager getFormLayout() {
        return null;
    }

    @Override
    protected void initTextFields() {

    }

    @Override
    protected void initLabels() {

    }

    @Override
    public void clean() {

    }

    @Override
    public void setWithNotNull(Agency controller) {

    }

    public City flyOrigin() {
    }

    public City flyDestination() {
    }

    public DayOfWeek flyDay() {
    }

    public LocalTime flyHour() {
    }

    public Integer flyDuration() throws NumberFormatException{ {
    }

    public Integer flyFirstTimeCapacity() throws NumberFormatException{ {
    }

    public Integer flySecondClassCapacity() throws NumberFormatException{ {
    }

    public Integer flyDaysOfResignation() throws NumberFormatException{ {
    }
}
