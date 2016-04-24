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
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Dan
 */
public class Rental {
    public final int ONE_WEEK = 7;
    public enum Status{ RETURNED, RENTED, LATE };
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
    
    //Code obtained from http://stackoverflow.com/questions/1555262/calculating-the-difference-between-two-java-date-instances
    public long calculateRentalLength(TimeUnit timeUnit){
        long diffInMillies = returnDate.getTime() - rentDate.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
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
        //168 hours in a week
        if(this.calculateRentalLength(TimeUnit.HOURS) > 168){
            this.status = Status.LATE;
        }
        else{
            this.status = Status.RETURNED;
        }
    }
}
