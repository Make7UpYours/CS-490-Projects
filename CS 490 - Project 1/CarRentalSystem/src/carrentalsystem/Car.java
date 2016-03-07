/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import business_logic.Searchable;

/**
 *
 * @author William J. Freeman
 */
public class Car implements Searchable{
    private String ID;
    private CarSpec spec;
    
    public Car(String ID, CarSpec spec){
        this.ID = ID;
        this.spec = spec;
    }
    
    @Override
    public boolean contains(String text) {
        String searchInfo = spec.getMake() + spec.getModel() 
                + Integer.toString(spec.getYear()) + spec.getSize().toString();
        return searchInfo.trim().toUpperCase().contains(text.trim().toUpperCase());
    }

    @Override
    public String[] info() {
        return new String[]{this.ID, this.spec.getMake(), this.spec.getModel(),
            Integer.toString(this.spec.getYear()), this.spec.getSize().toString()};
    }
    
}
