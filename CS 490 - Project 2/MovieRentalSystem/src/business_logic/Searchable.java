/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

/**
 *
 * @author Dan
 */
public interface Searchable {
    public boolean contains(String text);
    public String[] info();
    public String getID();
}
