package DAO;

import java.util.List;

public interface IDAO<T> {
    T create(T t); // Create a new object
    List<T> getAll();   // Get all objects
    T update(T t);  // Update an object
    T delete(T t);  // Delete an object

}
