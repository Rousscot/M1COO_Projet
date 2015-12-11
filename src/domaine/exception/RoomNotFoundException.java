package domaine.exception;

import domaine.destination.Room;

/**
 * I am an exception raised when a Room is not found.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class RoomNotFoundException extends Exception {

    /**
     * The room not found.
     */
    protected final Room room;

    /**
     * I am the constructor of the exception.
     *
     * @param room the room needed to find.
     */
    public RoomNotFoundException(Room room) {
        this.room = room;
    }

    /**
     * I am a getter that allow to get the id.
     *
     * @return the room of the object that the DAO wanted to find.
     */
    public Room getRoom() {
        return room;
    }

}
