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
public class Customer implements Searchable {
    private String ID;
    private String email;
    private String address;
    private String phone;
    private String password;
    private String name;

    public Customer(String ID, String email, String address, String phone, String password, String name) {
        this.ID = ID;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.name = name;
    }

    @Override
    public boolean contains(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] info() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getID() {
        return this.ID;
    }
    
}
