package business_logic;

import java.util.LinkedList;
import movierentalsystem.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dan
 */
public class Controller {
    private static Controller singleton;
    
    private LinkedList<Customer> customers;
    private LinkedList<DVD> dvds;
    private LinkedList<Actor> actors;
    
    private Controller() {
        customers = new LinkedList<Customer>();
        dvds = new LinkedList<DVD>();
        actors = new LinkedList<Actor>();
    }
    
    public static Controller Instance() {
        if(singleton == null) {
            singleton = new Controller();
        }
        return singleton;
    }
    
    public void addDVD(String ID, Movie movie) {
        dvds.add(new DVD(ID, movie));
    }
    
    public void addCustomer(String ID, String email, String address, String phone, String pw, String name) {
        customers.add(new Customer(ID, email, address, phone, pw, name));
    }
    
    public void addActor(String ID, String name, Actor.Gender gender) {
        Actor actor = new Actor(ID, name, gender);
        actors.add(actor);
    }
    
    public DVD findDVDbyID(String ID) {
        for (DVD dvd : dvds) {
            if (dvd.getID().equals(ID)) {
                return dvd;
            }
        }
        return null;
    }
    
}
