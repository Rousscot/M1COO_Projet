package domaine.destination;

import javax.tools.JavaCompiler;
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
    protected Integer resignationDays;

    public Hotel(String name, Integer resignationDays){
        this.categories = new ArrayList<>();
        this.resignationDays = resignationDays;
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

    public Integer getResignationDays() {
        return resignationDays;
    }

    public void setResignationDays(Integer resignationDays) {
        this.resignationDays = resignationDays;
    }



    public Integer numberOfCategories(){
        return categories.size();
    }

    public Category categoryAt(Integer index){
        return categories.get(index);
    }

    public void addCategory(Category category){
        //TODO Duplicated ?
        categories.add(category);
    }

    public void createAndAddCategory(String designation, Integer capacity, Integer price){
        Category category = new Category(designation, capacity, price);
        //TODO BDD, insert
        addCategory(category);
    }

    public void deleteCategory(Category category){
        //TODO not here ?
        categories.remove(category);
        category.delete();
        //TODO BDD Delete ?
    }

    public void delete(){
        categories.forEach(cat -> cat.delete());
        categories = null;
    }

}
