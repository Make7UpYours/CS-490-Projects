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
public class Keyword {
    private String name;
    private LinkedList<Movie> movies;
    
    public Keyword(String name) {
        this.name = name;
        this.movies = new LinkedList<Movie>();
    }
    
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
