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
    protected Integer number;
    protected Category category;

    public Room(Category category, Integer number){
       this(0L, category, number);
    }

    public Room(Long id, Category category, Integer number){
        isBusy = false;
        this.category = category;
        this.number = number;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Chambre " + number;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
