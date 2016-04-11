/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

import java.util.Date;

/**
 *
 * @author Dan
 */
public class Rental {
    public enum Status{ AVAILABLE, RENTED, NOTSTOCKED };
    private Date rentDate;
    private Date returnDate;
    private Status status;

    public Rental(Date rentDate, Date returnDate, Status status) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.status = status;
    }
    
}
