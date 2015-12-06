package domaine.exception;

import domaine.destination.Room;

/**
 * Created by JeCisC on 06/12/2015.
 */
public class DuplicatedRoomException extends Exception {

    protected Room room;

    public DuplicatedRoomException(Room room){
        this.room = room;
    }

    public Room getRoom(){
        return this.room;
    }

}
