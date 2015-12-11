package domaine.exception;

import domaine.destination.Category;

/**
 * Created by JeCisC on 06/12/2015.
 */
public class DuplicatedCategoryException extends Exception {

    protected Category category;

    public DuplicatedCategoryException(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return this.category;
    }

}
