package business_logic;

import java.util.Date;
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
    
    public boolean removeMovie(String ID){
        return movies.removeItem(ID);
    }
    
    public void addCustomer(String ID, String email, String address, String phone, String pw, String name) {
        customers.addItem(new Customer(ID, email, address, phone, pw, name));
    }
    
    public boolean removeCustomer(String ID){
        return customers.removeItem(ID);
    }
    
    public void addActor(String ID, String name, Actor.Gender gender) {
        actors.addItem(new Actor(ID, name, gender));
    }
    
    public boolean removeActor(String ID){
        return actors.removeItem(ID);
    }
    
    public void addKeyword(String ID, String name) {
        keywords.addItem(new Keyword(ID, name));
    }
    
    public boolean removeKeyword(String ID){
        return keywords.removeItem(ID);
    }
    
    public Actor findActorByID(String ID) {
        return actors.findByID(ID);
    }
    
    public Keyword findKeywordByID(String ID) {
        return keywords.findByID(ID);
    }
    
    public DVD findDVDByID(String ID) {
        Iterator<Movie> itr = movies.getItems();
        //Search through each movie for the specified DVD
        while(itr.hasNext()){
            Movie movie = itr.next();
            DVD dvd = movie.findDVD(ID);
            if(dvd != null){
                return dvd;
            }
        }
        return null;
    }
    
    public boolean removeDVD(String ID){
        Iterator<Movie> itr = movies.getItems();
        //Search through each movie for the specified DVD
        while(itr.hasNext()){
            Movie movie = itr.next();
            if(movie.removeDVD(ID)){
                return true;
            }
        }
        return false;
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
    
    public boolean returnMovie(DVD dvd, Rental rental, Date returnDate){
        //Only return rentals with rented status
        if(rental.getStatus() == Rental.Status.RENTED){
            dvd.toggleAvailability();
            rental.setReturnDate(returnDate);
            rental.returnDVD();
            return true;
        }
        return false;
    }
}
