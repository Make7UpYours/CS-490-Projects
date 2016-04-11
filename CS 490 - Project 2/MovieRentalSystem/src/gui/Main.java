/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business_logic.Controller;
import java.util.Arrays;
import java.util.LinkedList;
import movierentalsystem.*;

/**
 *
 * @author Dan
 */
public class Main {
    
    public static void main(String[] args) {
        Controller controller = Controller.Instance();
        
        // Create actors
        Actor sharma = new Actor("1", "Suraj Sharma", Actor.Gender.M);
        Actor khan = new Actor("2", "Irrfan Khan", Actor.Gender.M);
        Actor watts = new Actor("3", "Naomi Watts", Actor.Gender.F);
        Actor mcgregor = new Actor("4", "Ewan McGregor", Actor.Gender.M);
        Actor smith = new Actor("5", "Will Smith", Actor.Gender.M);
        Actor jones = new Actor("6", "Tommy Lee Jones", Actor.Gender.M);
        Actor fiorentino = new Actor("7", "Linda Fiorentino", Actor.Gender.F);
        
        // Create keywords
        Keyword suspense = new Keyword("Suspenseful");
        Keyword breathtaking = new Keyword("Suspenseful");
        Keyword heartbreaking = new Keyword("Heartbreaking");
        Keyword funny = new Keyword("Funny");
        
        // Create movies
        Movie movie1 = new Movie(Movie.Rating.PG, Movie.Genre.Drama, 2012, "Life of Pi", 
            new LinkedList<Actor>(Arrays.asList(sharma, khan)), new LinkedList<Keyword>(Arrays.asList(suspense, heartbreaking)));
        Movie movie2 = new Movie(Movie.Rating.PG13, Movie.Genre.Drama, 2012, "The Impossible", 
            new LinkedList<Actor>(Arrays.asList(watts, mcgregor)), new LinkedList<Keyword>(Arrays.asList(suspense, breathtaking)));
        Movie movie3 = new Movie(Movie.Rating.PG13, Movie.Genre.Comedy, 1997, "Men in Black", 
            new LinkedList<Actor>(Arrays.asList(smith, jones, fiorentino)), new LinkedList<Keyword>(Arrays.asList(suspense, funny)));
        
        // Add DVDs
        controller.addDVD("1", movie1);
        controller.addDVD("2", movie2);
        controller.addDVD("3", movie3);
    }
}
