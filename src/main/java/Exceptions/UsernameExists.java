/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Marc Serrano, Dani Yearwood, David Medina
 */
public class UsernameExists extends Exception{
    /**
     * control if the id already exist
     * @param message 
     */
    public UsernameExists(String message) {
        super (message);
    }
}
