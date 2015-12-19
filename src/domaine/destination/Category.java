package domaine.destination;

import dao.exception.DAOException;
import dao.implement.RoomDAO;
import domaine.DAOSerializable;
import domaine.exception.DuplicatedRoomException;
import domaine.exception.RoomNotFoundException;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * I am a class that describe a Category.
 *
 * If you extend me, be careful if you add some rooms with the constructor because I do not check if all rooms are created on the DAO.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Category implements DAOSerializable {

    protected List<Room> rooms;
    protected String designation;
    protected Integer capacity;
    protected Integer price;
    protected Long id;
    protected Hotel hotel;
    protected RoomDAO dao;

    public Category(String designation, Integer capacity, Integer price, Hotel hotel) {
        this(0L, designation, capacity, price, hotel);
    }


    public Category(Long id, String designation, Integer capacity, Integer price, Hotel hotel) {
        this.capacity = capacity;
        this.price = price;
        this.designation = designation;
        this.hotel = hotel;
        this.id = id;
        dao = new RoomDAO();
    }

    @Override
    public String toString() {
        return "Categorie " + designation + "(capacité: " + capacity + ", prix: " + price + ")";
    }

    public List<Room> getRooms() throws DAOException {
        if(rooms == null){
                rooms = dao.allRoomsForId(getId());
        }
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


    public Integer numberOfRooms() throws SQLException {
        return getRooms().size();
    }

    public Room roomAt(Integer index) throws SQLException {
        return getRooms().get(index);
    }

    public void addRoom(Room room) throws DuplicatedRoomException, DAOException {
        if(getRooms().contains(room)){
            throw new DuplicatedRoomException(room);
        }
        getRooms().add(room);
    }

    public void createAndAddRoom(Integer number) throws DAOException, DuplicatedRoomException {
        //TODO check if when we get a Duplicated exception this add the room to the database. If yes, throw the exception before we add it.
        addRoom(dao.create(new Room(this, number)));
    }

    public void deleteRoom(Room room) throws RoomNotFoundException, DAOException {
       //Maybe check if there is a busy room inside ?
        if(!getRooms().contains(room)){
           throw new RoomNotFoundException(room);
       }
        dao.delete(room);
        getRooms().remove(room);
    }

    public long getHotelId() {
        return this.getHotel().getId();
    }

    public void deleteAllRooms() throws SQLException, RoomNotFoundException {
        for(Room room : getRooms()) {
            deleteRoom(room);
        }
    }
}

