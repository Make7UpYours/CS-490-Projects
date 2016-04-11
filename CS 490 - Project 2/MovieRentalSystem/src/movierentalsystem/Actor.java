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
public class Actor implements Searchable {
    public enum Gender{ M, F };
    private String ID;
    private String name;
    private Gender gender;
    private LinkedList<Movie> performances;

    public Actor(String ID, String name, Gender gender) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.performances = new LinkedList<Movie>();
    }
    
    public void addPerformance(Movie movie) {
        performances.add(movie);
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
