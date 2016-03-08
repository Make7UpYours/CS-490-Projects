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
    private Car car;
    private String customerName;

    public Rental(Car car, String customerName) {
        this.rentDate = Calendar.getInstance();
        this.status = RentalStatus.RENTED;
        this.car = car;
        this.customerName = customerName;
    }

    public Car getCar() {
        return car;
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

    public String getReturnDate() {
        if (returnDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String time = sdf.format(returnDate.getTime());
            return time;
        }
        else {
            return "N/A";
        }
    }

    public void setReturnDate(Calendar returnDate) {
        this.returnDate = returnDate;
    }

    public RentalStatus getStatus() {
        return status;
    }
    
    public void returnCar() {
        this.status = RentalStatus.RETURNED;
        this.returnDate = Calendar.getInstance();
    }
    
    public String[] info() {
        return new String[]{ this.getRentDate(), this.getReturnDate(), this.status.toString() };
    }
    
}
