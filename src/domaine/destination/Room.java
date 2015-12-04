package domaine.destination;

/**
 * I am a class that describe a room of a Hotel.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Room {


    protected Boolean isBusy;
    protected Long id;
    protected Category category;

    public Room(Category category){
        isBusy = false;
        this.category = category;
        id = 0L;
    }

    @Override
    public String toString() {
        return "Chambre " + id;
    }

    public Boolean isBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
