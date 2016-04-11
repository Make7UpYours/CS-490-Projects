/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

/**
 *
 * @author Dan
 */
public class Customer {
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
    
}
