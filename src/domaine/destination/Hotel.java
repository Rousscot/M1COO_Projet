package domaine.destination;

import dao.exception.DAOException;
import dao.implement.CategoryDAO;
import domaine.DAOSerializable;
import domaine.exception.CategoryNotFoundException;
import domaine.exception.DuplicatedCategoryException;

import javax.tools.JavaCompiler;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * I am a class that describe a Hotel.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Hotel implements DAOSerializable {

    protected List<Category> categories;
    protected String name;
    protected Long id;
    protected Integer resignationDays;
    protected City city;
    protected CategoryDAO dao;

    public Hotel(String name, Integer resignationDays, City city){
        this(0L, name, resignationDays, city);
    }

    public Hotel(Long id, String name, Integer resignationDays, City city){
        this.categories = new ArrayList<>();
        this.resignationDays = resignationDays;
        this.name = name;
        this.city = city;
        this.id = id;
        dao = new CategoryDAO();
    }

    @Override
    public String toString() {
        return "Hotel " + name;
    }

    public List<Category> getCategories() throws DAOException {
        if(categories == null){
            categories = dao.allCategoriesForId(getId());
        }
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

    public Integer getResignationDays() {
        return resignationDays;
    }

    public void setResignationDays(Integer resignationDays) {
        this.resignationDays = resignationDays;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public Integer numberOfCategories() throws DAOException {
        return getCategories().size();
    }

    public Category categoryAt(Integer index) throws DAOException {
        return getCategories().get(index);
    }

    public void addCategory(Category category) throws DuplicatedCategoryException, DAOException {
        if(getCategories().contains(category)){
            throw new DuplicatedCategoryException(category);
        }
        getCategories().add(category);
    }

    public void createAndAddCategory(String designation, Integer capacity, Integer price) throws DuplicatedCategoryException, DAOException {
        //TODO check if when we get a Duplicated exception this add the category to the database. If yes, throw the exception before we add it.
        addCategory(dao.create(new Category(designation, capacity, price, this)));
    }

    public void deleteCategory(Category category) throws DAOException, CategoryNotFoundException {
        if(!getCategories().contains(category)){
            throw new CategoryNotFoundException(category);
        }
        dao.delete(category);
        getCategories().remove(category);
    }

    public long getCityId() {
        return this.getCity().getId();
    }

    public void deleteAllCategories() throws CategoryNotFoundException, DAOException {
        for(Category category : getCategories()) {
            deleteCategory(category);
        }
    }
}
