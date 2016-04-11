/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

import java.util.LinkedList;

/**
 *
 * @author Dan
 */
public class Movie {
    public enum Rating{ G, PG, PG13, R};
    public enum Genre{ Drama, Horror, Comedy, Action, Romance };
    
    private Rating rating;
    private Genre genre;
    private int year;
    private String name;
    private LinkedList<Actor> actors;
    private LinkedList<Keyword> keywords;

    public Movie(Rating rating, Genre genre, int year, String name, 
            LinkedList<Actor> actors, LinkedList<Keyword> keywords) {
        this.rating = rating;
        this.genre = genre;
        this.year = year;
        this.name = name;
        this.actors = actors;
        this.keywords = keywords;
        addActorMovie(actors);
        addKeywordMovie(keywords);
    }
    private void addActorMovie(LinkedList<Actor> actors) {
        for (Actor actor : actors) {
            actor.addPerformance(this);
        }
    }
    
    private void addKeywordMovie(LinkedList<Keyword> keywords) {
        for (Keyword keyword : keywords) {
            keyword.addMovie(this);
        }
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
}
