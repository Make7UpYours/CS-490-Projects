package business_logic;

import java.util.Iterator;
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
    
    private ItemList<Customer> customers;
    private ItemList<DVD> dvds;
    private ItemList<Actor> actors;
    private ItemList<Keyword> keywords;
    
    private Controller() {
        customers = new ItemList<Customer>();
        dvds = new ItemList<DVD>();
        actors = new ItemList<Actor>();
        keywords = new ItemList<Keyword>();
    }
    
    public static Controller Instance() {
        if(singleton == null) {
            singleton = new Controller();
        }
        return singleton;
    }
    
    public void addDVD(String ID, Movie movie) {
        dvds.addItem(new DVD(ID, movie));
    }
    
    public void addCustomer(String ID, String email, String address, String phone, String pw, String name) {
        customers.addItem(new Customer(ID, email, address, phone, pw, name));
    }
    
    public void addActor(String ID, String name, Actor.Gender gender) {
        actors.addItem(new Actor(ID, name, gender));
    }
    
    public void addKeyword(String ID, String name) {
        keywords.addItem(new Keyword(ID, name));
    }
    
    public Actor findActorByID(String ID) {
        return actors.findByID(ID);
    }
    
    public Keyword findKeywordByID(String ID) {
        return keywords.findByID(ID);
    }
    
    public Iterator<DVD> getDVDs() {
        return dvds.getItems();
    }
    
}
