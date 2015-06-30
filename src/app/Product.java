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
public class Product {
    int id;
    int price;
    int number;// how many in stock
    
    Product(int id, int price, int number){
        this.id = id;
        this.price = price;
        this.number = number;
        
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", price=" + price + ", number=" + number + '}';
    }

    
    
}
