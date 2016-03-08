/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import business_logic.*;
import java.util.List;

/**
 *
 * @author wjfkc2
 */
public class Customer implements Searchable {
    private String name;
    private String phone;
    private String address;
    
    public Customer(String name, String phone, String address){
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public boolean contains(String text) {
        String searchInfo = name + phone + address;
        return searchInfo.trim().toUpperCase().contains(text.trim().toUpperCase());
    }

    @Override
    public String[] info() {
        return new String[]{this.name, this.phone, this.address};
    }
}
