/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

/**
 *
 * @author Dan
 */
public class DVD {
    private String serialNo;
    private boolean lost;
    private Movie specs;
    
    public DVD(String serialNo, Movie specs) {
        this.serialNo = serialNo;
        this.lost = false;
        this.specs = specs;
    }
    
    public String getID() {
        return serialNo;
    }
}
