/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business_logic.Controller;
import business_logic.ItemList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import movierentalsystem.*;

/**
 *
 * @author Dan
 */
public class Main {
    
    public static void main(String[] args) {
        Controller controller = Controller.Instance();
        
        // Add actors
        controller.addActor("1", "Suraj Sharma", Actor.Gender.M);
        controller.addActor("2", "Irrfan Khan", Actor.Gender.M);
        controller.addActor("3", "Naomi Watts", Actor.Gender.F);
        controller.addActor("4", "Ewan McGregor", Actor.Gender.M);
        controller.addActor("5", "Will Smith", Actor.Gender.M);
        controller.addActor("6", "Tommy Lee Jones", Actor.Gender.M);
        controller.addActor("7", "Linda Fiorentino", Actor.Gender.F);
        
        // Add keywords
        controller.addKeyword("1", "Suspenseful");
        controller.addKeyword("2", "Breathtaking");
        controller.addKeyword("3", "Heartbreaking");
        controller.addKeyword("4", "Funny");
        
        // Create movies
        Movie movie1 = new Movie(Movie.Rating.PG, Movie.Genre.Drama, 2012, "Life of Pi", 
            new LinkedList<Actor>(Arrays.asList(controller.findActorByID("1"), controller.findActorByID("2"))), 
            new LinkedList<Keyword>(Arrays.asList(controller.findKeywordByID("1"), controller.findKeywordByID("3"))));
        Movie movie2 = new Movie(Movie.Rating.PG13, Movie.Genre.Drama, 2012, "The Impossible", 
            new LinkedList<Actor>(Arrays.asList(controller.findActorByID("3"), controller.findActorByID("4"))), 
            new LinkedList<Keyword>(Arrays.asList(controller.findKeywordByID("1"), controller.findKeywordByID("2"))));
        Movie movie3 = new Movie(Movie.Rating.PG13, Movie.Genre.Comedy, 1997, "Men in Black", 
            new LinkedList<Actor>(Arrays.asList(controller.findActorByID("5"), controller.findActorByID("6"), controller.findActorByID("7"))), 
            new LinkedList<Keyword>(Arrays.asList(controller.findKeywordByID("1"), controller.findKeywordByID("4")))); 
        
        // Add DVDs
        controller.addDVD("1", movie1);
        controller.addDVD("2", movie2);
        controller.addDVD("3", movie3);
        
        // Just demoing data retrieval here
        Iterator<DVD> itr = controller.getDVDs();
        while(itr.hasNext()) {
            System.out.println(itr.next().getID());
        }
    }
}
