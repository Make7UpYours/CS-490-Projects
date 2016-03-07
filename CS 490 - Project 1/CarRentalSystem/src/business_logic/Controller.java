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
    
    private static Controller singleton;
    
    private Controller(){
        customers = new LinkedList<Customer>();
        cars = new LinkedList<Car>();
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
}
