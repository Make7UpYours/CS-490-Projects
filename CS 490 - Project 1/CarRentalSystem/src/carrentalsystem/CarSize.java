/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

/**
 *
 * @author William J. Freeman
 */
public enum CarSize {
    SMALL("Small"),MIDSIZE("Midsize"),LARGE("Large");
    
    private String value;
    
    CarSize(String value){
        this.value = value;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
