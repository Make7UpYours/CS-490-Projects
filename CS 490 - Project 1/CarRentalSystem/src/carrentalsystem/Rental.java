/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Dan
 */
public class Rental {
    
    private Calendar rentDate;
    private Calendar returnDate;
    private RentalStatus status;
    private String carID;
    private String customerName;

    public Rental(String carID, String customerName) {
        this.rentDate = Calendar.getInstance();
        this.status = RentalStatus.RENTED;
        this.carID = carID;
        this.customerName = customerName;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getRentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String time = sdf.format(rentDate.getTime());
        return time;
    }

    public void setRentDate(Calendar rentDate) {
        this.rentDate = rentDate;
    }

    public String getReturnDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String time = sdf.format(returnDate.getTime());
        return time;
    }

    public void setReturnDate(Calendar returnDate) {
        this.returnDate = returnDate;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }
    
}
