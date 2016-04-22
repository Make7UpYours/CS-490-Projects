/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

import business_logic.ItemList;
import business_logic.Searchable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Dan
 */
public class Movie implements Searchable {

    public enum Rating{ G, PG, PG13, R };
    public enum Genre{ Drama, Horror, Comedy, Action, Romance };
    
    private Rating rating;
    private Genre genre;
    private int year;
    private String name;
    private LinkedList<Actor> actors;
    private LinkedList<Keyword> keywords;
    private LinkedList<DVD> dvds;

    public Movie(Rating rating, Genre genre, int year, String name, 
            LinkedList<Actor> actors, LinkedList<Keyword> keywords) {
        this.rating = rating;
        this.genre = genre;
        this.year = year;
        this.name = name;
        this.actors = actors;
        this.keywords = keywords;
        this.dvds = new LinkedList();
    }
    
    public void addDVD(String serialNo) {
        dvds.add(new DVD(serialNo, this));
    }
    
    public DVD getAvailableDVD() {
        for (DVD dvd : dvds) {
            if (dvd.isAvailable()) {
                return dvd;
            }
        }
        return null;
    }
    
    public Rating getRating() {
        return rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
    
     @Override
    public boolean matches(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean contains(String text) {
        String info = (name + " " + genre + " " + year + " " + rating).toLowerCase();
        text = text.toLowerCase();
        if (info.contains(text)) {
            return true;
        }
        for (Actor actor : actors) {
            if (actor.contains(text)){
                return true;
            }
        }
        for (Keyword keyword : keywords) {
            if (keyword.contains(text)){
                return true;
            }
        }
        return false;
    }
}
