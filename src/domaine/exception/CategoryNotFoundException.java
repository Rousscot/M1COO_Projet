package domaine.exception;

import domaine.destination.Category;
import domaine.destination.Room;

/**
 * I am an exception raised when a Category is not found.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class CategoryNotFoundException extends Exception {

    /**
     * The category not found.
     */
    protected final Category category;

    /**
     * I am the constructor of the exception.
     *
     * @param category the category needed to find.
     */
    public CategoryNotFoundException(Category category) {
        this.category = category;
    }

    /**
     * I am a getter that allow to get the id.
     *
     * @return the category of the object that the DAO wanted to find.
     */
    public Category getCategory() {
        return category;
    }

}
