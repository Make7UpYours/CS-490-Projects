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

    public Actor(String ID, String name, Gender gender) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
    }
    
    @Override
    public boolean contains(String text) {
        return this.name.toLowerCase().contains(text.toLowerCase());
    }

    @Override
    public boolean matches(String ID) {
        return this.ID.equals(ID);
    }
      
}
