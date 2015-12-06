package domaine.destination;

import domaine.DAOSerializable;

/**
 * I am a class that describe a room of a Hotel.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Room implements DAOSerializable {


    protected Boolean isBusy;
    protected Long id;
    protected Category category;

    public Room(Category category){
       this(0L, category);
    }

    public Room(Long id, Category category){
        isBusy = false;
        this.category = category;
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public Long getCategoryId(){
        return this.getCategory().getId();
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
