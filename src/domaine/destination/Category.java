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
    protected Integer capacity;
    protected Integer price;
    protected Long id;

    public Category(String designation, Integer capacity, Integer price){
        this.rooms = new ArrayList<>();
        this.capacity = capacity;
        this.price = price;
        this.designation = designation;
        id = 0L;
    }

    @Override
    public String toString() {
        return "Categorie " + designation + "(capacité: "+ capacity + ", prix: " + price + ")";
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



    public Integer numberOfRooms(){
        return rooms.size();
    }

    public Room roomAt(Integer index){
        return rooms.get(index);
    }

    public void addRoom(Room room){
        //TODO Duplicated ?
        rooms.add(room);
    }

    public void createAndAddRoom(){
        Room room = new Room();
        // TODO Insert BDD
        addRoom(room);
    }

    public void deleteRoom(Room room){
        //TODO not here ?
        rooms.remove(room);
        //TODO BDD Delete ?
    }

    public void delete(){
        rooms = null;
    }
}

