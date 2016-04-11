/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

import business_logic.Searchable;

/**
 *
 * @author Dan
 */
public class DVD implements Searchable {
    private String serialNo;
    private boolean lost;
    private Movie specs;
    
    public DVD(String serialNo, Movie specs) {
        this.serialNo = serialNo;
        this.lost = false;
        this.specs = specs;
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
        return this.serialNo;
    }
}
