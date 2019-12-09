/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.SanPham;
import javax.ejb.EJB;
import session_bean.ProductSessionBean;

/**
 *
 * @author minhh
 */
public class Validator {

    @EJB
    private ProductSessionBean productSB;

    public boolean validateForm(String name, String email,
            String phone, String address) {
        if (!isValidEmail(email)) {
            return true;
        }
        if(!isValidPhone(phone)){
            return true;
        }
        return false;
    }

    public boolean validateQuantity(String ProductId, String quantity) {
        if (Integer.parseInt(quantity) < 0) {
            return true;
        }
        SanPham product = productSB.FindByID(ProductId);
        if (Integer.parseInt(quantity) > product.getSoLuong()) {
            return true;
        }
        return false;
    }

    static boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    static boolean isValidPhone(String phone){
        String regex = "(0/91)?[7-9][0-9]{9}";
        return phone.matches(regex);
    }
}
