/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Dan
 */
public class ItemList<T extends Searchable> {
    private Collection<T> elements;
    
    public ItemList() {
        elements = new LinkedList<T>();
    }
    
    public T findByID(String ID) {
        for (T element : elements) {
            if (element.getID().equals(ID)) {
                return element;
            }
        }
        return null;
    }
    
    public void addItem(T item) {
        elements.add(item);
    }
    
    public boolean removeItem(String ID){
        T element = findByID(ID);
        if(element == null) 
            return false;
        return elements.remove(element);
    }
    
    public Iterator<T> getItems() {
        return elements.iterator();
    }

}
