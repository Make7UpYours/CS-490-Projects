/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

import business_logic.Searchable;

/**
 *
 * @author Dan
 */
public class DVD implements Searchable {
    private String serialNo;
    private boolean lost;
    private Movie specs;
    private boolean available;
    
    public DVD(String serialNo, Movie specs) {
        this.serialNo = serialNo;
        this.lost = false;
        this.specs = specs;
        this.available = true;
    }
    
    public boolean isAvailable() {
        return available;
    }

    public void toggleAvailability() {
        available = (available) ? false : true;
    }

    @Override
    public boolean contains(String text) {
        return this.specs.contains(text);
    }

    @Override
    public boolean matches(String ID) {
        return this.serialNo.equals(ID);
    }
    
    public Movie getMovie() {
        return this.specs;
    }
    
    public String getSerialNo() {
        return this.serialNo;
    }
}
