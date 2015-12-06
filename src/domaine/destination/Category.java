package domaine.destination;

import dao.exception.DAOException;
import dao.implement.RoomDAO;
import domaine.exception.DuplicatedRoomException;
import domaine.exception.RoomNotFoundException;

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
    protected Hotel hotel;
    protected RoomDAO dao;

    public Category(String designation, Integer capacity, Integer price, Hotel hotel) {
        this.rooms = new ArrayList<>();
        this.capacity = capacity;
        this.price = price;
        this.designation = designation;
        this.hotel = hotel;
        dao = new RoomDAO();
        id = 0L;
    }

    @Override
    public String toString() {
        return "Categorie " + designation + "(capacité: " + capacity + ", prix: " + price + ")";
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


    public Integer numberOfRooms() {
        return rooms.size();
    }

    public Room roomAt(Integer index) {
        return rooms.get(index);
    }

    public void addRoom(Room room) throws DuplicatedRoomException {
        if(rooms.contains(room)){
            throw new DuplicatedRoomException(room);
        }
        rooms.add(room);
    }

    public void createAndAddRoom() throws DAOException, DuplicatedRoomException {
        //TODO check if when we get a Duplicated exception this add the room to the database. If yes, throw the exception before we add it.
        addRoom(dao.create(new Room(this)));
    }

    public void deleteRoom(Room room) throws RoomNotFoundException, DAOException {
       if(!rooms.contains(room)){
           throw new RoomNotFoundException(room);
       }
        dao.delete(room);
        rooms.remove(room);
    }

    public void delete() {
        rooms = null;
    }
}

