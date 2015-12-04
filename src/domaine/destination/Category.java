package domaine.destination;

import java.util.ArrayList;
import java.util.List;

/**
 * I am a class that describe a Category.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Category {

    protected List<Room> rooms;
    protected String designation;
    protected Long id;

    public Category(String designation){
        this.rooms = new ArrayList<>();
        this.designation = designation;
        id = 0L;
    }

    @Override
    public String toString() {
        return "Categorie " + designation;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

