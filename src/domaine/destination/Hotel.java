package domaine.destination;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * I am a class that describe a Hotel.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Hotel {

    protected List<Category> categories;
    protected String name;
    protected Long id;

    public Hotel(String name){
        this.categories = new ArrayList<>();
        this.name = name;
        id = 0L;
    }



    @Override
    public String toString() {
        return "Hotel " + name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
