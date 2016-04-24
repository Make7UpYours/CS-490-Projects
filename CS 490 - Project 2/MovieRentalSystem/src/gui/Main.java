/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business_logic.Controller;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import movierentalsystem.*;

/**
 *
 * @author Dan
 */
public class Main {
    
    public static void main(String[] args) {
        Controller controller = Controller.Instance();
        
        // Add actors to system
        controller.addActor("1", "Suraj Sharma", Actor.Gender.M);
        controller.addActor("2", "Irrfan Khan", Actor.Gender.M);
        controller.addActor("3", "Naomi Watts", Actor.Gender.F);
        controller.addActor("4", "Ewan McGregor", Actor.Gender.M);
        controller.addActor("5", "Will Smith", Actor.Gender.M);
        controller.addActor("6", "Tommy Lee Jones", Actor.Gender.M);
        controller.addActor("7", "Linda Fiorentino", Actor.Gender.F);
        
        // Add keywords to system
        controller.addKeyword("1", "Suspenseful");
        controller.addKeyword("2", "Breathtaking");
        controller.addKeyword("3", "Heartbreaking");
        controller.addKeyword("4", "Funny");
        
        // Create movies and add to system
        Movie movie1 = new Movie(Movie.Rating.PG, Movie.Genre.Drama, 2012, "Life of Pi", 
            new LinkedList<Actor>(Arrays.asList(controller.findActorByID("1"), controller.findActorByID("2"))), 
            new LinkedList<Keyword>(Arrays.asList(controller.findKeywordByID("1"), controller.findKeywordByID("3"))));
        Movie movie2 = new Movie(Movie.Rating.PG13, Movie.Genre.Drama, 2012, "The Impossible", 
            new LinkedList<Actor>(Arrays.asList(controller.findActorByID("3"), controller.findActorByID("4"))), 
            new LinkedList<Keyword>(Arrays.asList(controller.findKeywordByID("1"), controller.findKeywordByID("2"))));
        Movie movie3 = new Movie(Movie.Rating.PG13, Movie.Genre.Comedy, 1997, "Men in Black", 
            new LinkedList<Actor>(Arrays.asList(controller.findActorByID("5"), controller.findActorByID("6"), controller.findActorByID("7"))), 
            new LinkedList<Keyword>(Arrays.asList(controller.findKeywordByID("1"), controller.findKeywordByID("4")))); 
        
        controller.addMovie(movie1);
        controller.addMovie(movie2);
        controller.addMovie(movie3);
        
        // Add DVDs for movies
        movie1.addDVD("1");
        movie1.addDVD("2");
        movie2.addDVD("3");
        movie2.addDVD("4");
        movie3.addDVD("5");
        movie3.addDVD("6");
        if(controller.removeDVD("6")){
            System.out.println("Successfully removed DVD: 6");
            System.out.println();
        }
        
        // Add Customers to system
        controller.addCustomer("1", "example@example.com", "742 Ames", "6362094213", "password", "Dan Stucky");
        controller.addCustomer("2", "wjfkc2@mail.umkc.edu", "1234 St.", "987654321", "cheese", "William Freeman");
        Customer dan = controller.findCustomerByID("1");
        if(controller.removeCustomer("2")){
            System.out.println("Successfully removed customer: William");
            System.out.println();
        }
        
        // RENT MOVIE SIMULATION
        System.out.println("Rent DVD Simulation:");
        rentMovieSimulation(controller, dan, "will smith", 2);
        rentMovieSimulation(controller, dan, "Comedy", 2);
        rentMovieSimulation(controller, dan, "Pi", 1);
        
        //Movie return sim
        DVD dvd5 = controller.findDVDByID("5");
        DVD dvd1 = controller.findDVDByID("1");
        DVD dvdNone = controller.findDVDByID("6");
        System.out.println("Return DVD Simulation:");
        returnMovieSim(controller, dan, dvd5);
        returnMovieSim(controller, dan, dvdNone);
        returnMovieSim(controller, dan, dvd1);
        
        //Run rental sim again
        rentMovieSimulation(controller, dan, "Life", 2);
        
        //Run late sim
        returnMovieLateSim(controller, dan, dvd1);
    }
    
    private static void returnMovieLateSim(Controller controller, Customer customer, DVD dvd){
        Date returnDay = new Date();
        returnDay.setTime(new Date().getTime() + 864000000); // 10 days late, time in milliseconds
        if(dvd != null){
            LinkedList<Rental> rentals = customer.getRentals();
            for(Rental rental : rentals){
               if(rental.getDVDSerialNo() == dvd.getSerialNo()){
                    if(controller.returnMovie(dvd, rental, returnDay)){
                        System.out.println("Successful return.");
                        System.out.println("DVD Serial No: " + rental.getDVDSerialNo() +
                               "\tRental Status: " + rental.getStatus());
                        if(rental.getStatus() == Rental.Status.LATE){
                            System.out.println("DVD is late, calculating late fees");
                            //10 cents a day after a week
                            double lateFee = ((rental.calculateRentalLength(TimeUnit.HOURS) - 168) / 24) * .10;
                            System.out.println("You owe $" + lateFee);
                        }
                        System.out.println();
                        return;
                    }
               }
           }
           System.out.println("No rental found for Customer: " 
                   + customer.getName());
           System.out.println("DVD Serial No: " + dvd.getSerialNo());
        }
        else{
            System.out.println("Invalid dvd returned.");
        }
        System.out.println();
    }
    
    private static void returnMovieSim(Controller controller, Customer customer, DVD dvd){
        if(dvd != null){
            LinkedList<Rental> rentals = customer.getRentals();
            for(Rental rental : rentals){
               if(rental.getDVDSerialNo() == dvd.getSerialNo()){
                    if(controller.returnMovie(dvd, rental, new Date())){
                        System.out.println("Successful return.");
                        System.out.println("DVD Serial No: " + rental.getDVDSerialNo() +
                               "\tRental Status: " + rental.getStatus());
                        System.out.println();
                        return;
                    }
               }
           }
           System.out.println("No rental found for Customer: " 
                   + customer.getName());
           System.out.println("DVD Serial No: " + dvd.getSerialNo());
        }
        else{
            System.out.println("Invalid dvd returned.");
        }
        System.out.println();
    }
    
    private static void rentMovieSimulation(Controller controller, Customer customer, String searchText, double payAmount) {      
        // Customer searches movies based on any criteria
        Iterator<Movie> itr = controller.findMovies(searchText);
        // Just use first movie returned for this example
        Movie myMovie = itr.next();
        System.out.println(customer.getName() + " wants to rent " + myMovie.getName());
        // Customer selects a movie and system checks if it is available.
        DVD dvd = controller.getAvailableDVD(myMovie);
        if (dvd != null) {
            // Complete rental after payment successfully received
            if (controller.makePayment(payAmount)) {
                controller.rentMovie(dvd, customer);
                // Show rentals for proof it was added here
                System.out.println("Successful rental. Updated rentals for " + customer.getName() + ":");
                LinkedList<Rental> rentals = customer.getRentals();
                for (Rental rental : rentals) {
                    System.out.println("DVD Serial No: " + rental.getDVDSerialNo() + 
                            "\tRental Status: " + rental.getStatus());
                }
            }
            else {
                System.out.println("Invalid payment. Rental Cancelled.");
            }
        }
        else {
            System.out.println("No dvd available for that movie.");
        }
        System.out.println();
    }
}
