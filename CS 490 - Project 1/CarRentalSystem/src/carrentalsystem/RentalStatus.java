/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

/**
 *
 * @author Dan
 */
public enum RentalStatus {
    RENTED("Rented"), RETURNED("Returned");
    
    private String value;
    
    RentalStatus(String value){
        this.value = value;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
