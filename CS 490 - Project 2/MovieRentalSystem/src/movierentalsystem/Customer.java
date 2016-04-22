/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

import business_logic.Searchable;
import java.util.LinkedList;

/**
 *
 * @author Dan
 */
public class Customer implements Searchable {
    private String ID;
    private String email;
    private String address;
    private String phone;
    private String password;
    private String name;
    private LinkedList<Rental> rentals;

    public Customer(String ID, String email, String address, String phone, String password, String name) {
        this.ID = ID;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.rentals = new LinkedList<>();
    }
    
    public void addRental(Rental rental) {
        rentals.add(rental);
    }
    
    @Override
    public boolean contains(String text) {
        String info = email + " " + address + " " + phone + " " + name;
        return info.toLowerCase().contains(text.toLowerCase());
    }

    @Override
    public boolean matches(String ID) {
        return this.ID.equals(ID);
    }
    
    public String getID() {
        return this.ID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public LinkedList<Rental> getRentals() {
        return this.rentals;
    }
    
}
