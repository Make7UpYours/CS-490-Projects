/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import business_logic.Controller;
import gui.CustomerSearch;

/**
 *
 * @author wjfkc2
 */
public class CarRental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller = Controller.instance();
        
        CarSpec civic2007 = new CarSpec("Honda", "Civic", 2007, CarSize.SMALL);
        CarSpec ram2004 = new CarSpec("Dodge", "Ram", 2004, CarSize.LARGE);
        CarSpec fusion2015 = new CarSpec("Ford", "Fusion", 2015, CarSize.MIDSIZE);
        
        // Add Customers
        controller.addCustomer("William Freeman", "816-520-5206",
                "6636 NW Hidden Valley Rd.");
        controller.addCustomer("Kyle Smith", "816-555-6249",
                "7309 Candy Cane Ln.");
        controller.addCustomer("Joe Schmo", "256-984-1685",
                "1683 Somewhere St.");
        controller.addCustomer("Joe Rogan", "946-285-5849",
                "168 16th St.");
        controller.addCustomer("Frank Scott", "123-456-7890",
                "3790 Wall St.");
        
        //Add Cars
        controller.addCar("12345", civic2007);
        controller.addCar("54321", civic2007);
        controller.addCar("98765", ram2004);
        controller.addCar("56789", fusion2015);
        
        CustomerSearch frame = new CustomerSearch(controller);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
