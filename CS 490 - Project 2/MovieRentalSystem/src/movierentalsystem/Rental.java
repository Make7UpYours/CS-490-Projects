/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Dan
 */
public class Rental {
    public final int ONE_WEEK = 7;
    public enum Status{ RETURNED, RENTED };
    private Date rentDate;
    private Date returnDate;
    private Status status;
    private String dvdSerialNo;
    private String customerID;

    public Rental(String dvdSerialNo, String customerID) {
        this.rentDate = new Date();
        this.status = Status.RENTED;
        this.dvdSerialNo = dvdSerialNo;
        this.customerID = customerID;
        setReturnDate();
    }
    
    public String getDVDSerialNo() {
        return dvdSerialNo;
    }

    public String getCustomerID() {
        return customerID;
    }
    
    public String getRentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String time = sdf.format(rentDate.getTime());
        return time;
    }
    
    private void setReturnDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(rentDate);
        calendar.add(Calendar.DATE, ONE_WEEK);
        returnDate = calendar.getTime();
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

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Status getStatus() {
        return status;
    }
    
    public void returnDVD() {
        this.status = Status.RETURNED;
    }
}
