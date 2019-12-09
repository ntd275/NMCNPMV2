/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author minhh
 */
public class Validator {
    
    public boolean validateForm(String name, String email,
                        String phone,String address){
        if(!isValid(email)) return true;
        
        return false;
    }
    public boolean validateQuantity(String ProductId, String quantity){
        if (Integer.parseInt(quantity) < 0) return true;
        return false;
    }
    
    static boolean isValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
}
