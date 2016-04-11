/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierentalsystem;

import java.util.Date;

/**
 *
 * @author Dan
 */
public class Request {
    public enum Status{ AVAILABLE, WAIT, NEW_ORDER, DENIED };
    public enum Type{ PICKUP, MAIL }
    private Date requestDate;
    private Date responseDate;
    private Status status;
    private Type type;

    public Request(Date requestDate, Date responseDate, Status status, Type type) {
        this.requestDate = requestDate;
        this.responseDate = responseDate;
        this.status = status;
        this.type = type;
    }
    
}
