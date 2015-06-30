/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author ale
 */
public class Customer {
    int id;
    int amount;
    
    Customer(int id, int amount){
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", amount=" + amount + '}';
    }
    
    
}
