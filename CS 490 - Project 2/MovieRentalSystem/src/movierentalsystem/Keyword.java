/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

import business_logic.Searchable;
import java.util.LinkedList;

/**
 *
 * @author Dan
 */
public class Keyword implements Searchable {
    private String ID;
    private String name;
    private LinkedList<Movie> movies;
    
    public Keyword(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.movies = new LinkedList<Movie>();
    }
    
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public boolean contains(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] info() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getID() {
        return this.ID;
    }
}
