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
    private ItemList<Movie> movies;
    private ItemList<Actor> actors;
    private ItemList<Keyword> keywords;
    
    private Controller() {
        customers = new ItemList<Customer>();
        movies = new ItemList<Movie>();
        actors = new ItemList<Actor>();
        keywords = new ItemList<Keyword>();
    }
    
    public static Controller Instance() {
        if(singleton == null) {
            singleton = new Controller();
        }
        return singleton;
    }
    
    public void addMovie(Movie movie) {
        movies.addItem(movie);
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
    
    public Keyword findDVDByID(String ID) {
        return keywords.findByID(ID);
    }
    
    public Customer findCustomerByID(String ID) {
        return customers.findByID(ID);
    }
    
    public Iterator<Movie> findMovies(String text) {
        return movies.findByContent(text);
    }
    
    public DVD getAvailableDVD(Movie movie) {
        return movie.getAvailableDVD();
    }
    
    public boolean makePayment(double amount) {
        Payment payment = new Payment(amount);
        return payment.paySuccess();
    }
    
    public void rentMovie(DVD dvd, Customer customer) {
        dvd.toggleAvailability();
        customer.addRental(new Rental(dvd.getSerialNo(), customer.getID()));
    }
}
