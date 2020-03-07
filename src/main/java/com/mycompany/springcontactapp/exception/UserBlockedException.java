package com.mycompany.springcontactapp.exception;

/**
 *
 * @author Nisha
 */
public class UserBlockedException extends Exception{
 public UserBlockedException(){
 }
 public UserBlockedException(String errDesc){
  super(errDesc);
 }
}
