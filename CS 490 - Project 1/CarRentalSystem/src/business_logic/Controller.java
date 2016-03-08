/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

import carrentalsystem.*;
import java.util.LinkedList;

/**
 *
 * @author wjfkc2
 */
public class Controller {
    private LinkedList<Customer> customers;
    private LinkedList<Car> cars;
    private LinkedList<Rental> rentals;
    
    private static Controller singleton;
    
    private Controller(){
        customers = new LinkedList<Customer>();
        cars = new LinkedList<Car>();
        rentals = new LinkedList<Rental>();
    }
    
    public static Controller instance(){
        if(singleton == null){
            singleton = new Controller();
        }
        return singleton;
    }
    
    public void addCustomer(String name, String phone, String address){
        Customer cust = new Customer(name, phone, address);
        customers.add(cust);
    }
    
    public void addCar(String ID, CarSpec spec){
        Car car = new Car(ID, spec);
        cars.add(car);
    }
    
    public void addRental(String carID, String customerName) {
        Car car = findCar(carID);
        Rental rental = new Rental(car, customerName);
        rentals.add(rental);
    }
    
    public void addReturn(String carID, String customerName) {
        for(Rental rental : rentals) {
            if(rental.getCustomerName().equals(customerName) && rental.getCar().getID().equals(carID)){
                rental.returnCar();
            }
        }
    }
    
    public LinkedList<String[]> findCustomerRentedCars(String customerName){
        LinkedList<String[]> result = new LinkedList<String[]>();
        for(Rental rental : rentals){
            if(rental.getCustomerName().equals(customerName) && rental.getStatus() == RentalStatus.RENTED){
                // creates single array of format: 
                // { carID, carMake, carModel, carYear, carSize, rentalRentDate, rentalReturnDate, rentalStatus }
                result.add(concat(rental.getCar().info(), rental.info()));
            }
        }
        return result;
    }
    
    public LinkedList<String[]> findCustomerReturnedCars(String customerName){
        LinkedList<String[]> result = new LinkedList<String[]>();
        for(Rental rental : rentals){
            if(rental.getCustomerName().equals(customerName) && rental.getStatus() == RentalStatus.RETURNED){
                 // creates single array of format: 
                // { carID, carMake, carModel, carYear, carSize, rentalRentDate, rentalReturnDate, rentalStatus }
                result.add(concat(rental.getCar().info(), rental.info()));
            }
        }
        return result;
    }
    
    public LinkedList<String[]> searchCustomers(String text){
        LinkedList<String[]> result = new LinkedList<String[]>();
        for(Searchable customer:customers){
            if(customer.contains(text))
                result.add(customer.info());
        }
        return result;
    }
    
    public LinkedList<String[]> searchCars(String text){
        LinkedList<String[]> result = new LinkedList<String[]>();
        for(Searchable car:cars){
            if(car.contains(text))
                result.add(car.info());
        }
        return result;
    }
    
    private Car findCar(String carID) {
        for (Car car : cars) {
            if (car.getID().equals(carID)) {
                return car;
            }
        }
        return null;
    }
    
    private String[] concat(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;
        String[] result = new String[aLen + bLen];
        System.arraycopy(a, 0, result, 0, aLen);
        System.arraycopy(b, 0, result, aLen, bLen);
        return result;
    }
}
