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
public class Payment {
    private final int ONE_WEEK_RENTAL = 2;
    private double amount;
    
    // Do not worry about returning change for this simulation
    
    public Payment(double amount) {
        this.amount = amount;
    }
    
    public boolean paySuccess() {
        return amount >= ONE_WEEK_RENTAL;
    }
}
