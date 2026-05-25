// interfacepkg/CRUD.java
package interfacepkg;

import javax.swing.table.DefaultTableModel;

public interface CRUD<T> {
    void insert(T entity);
    void update(T entity);
    void delete(int id);
    DefaultTableModel getData();
}