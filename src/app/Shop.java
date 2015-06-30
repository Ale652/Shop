/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.oracle.jrockit.jfr.Producer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ale
 */
public class Shop {
    
    
    public static void main(String args[]) throws InterruptedException{
        
        Random rand = new Random();
        
        //PRODUCTS PART
        //number of items
        int  nrProd = rand.nextInt(15) + 1;
        //create the Array of Products
        ArrayList<Product> productsList = new ArrayList<Product>();
        //populate the list of products
        int price, stock, total = 0;// price && numer of items of this product in stock in the shop
        for(int i =0; i<nrProd; i++){
            price = rand.nextInt(1000)+1;
            stock = rand.nextInt(10)+1;
            Product prod = new Product(i, price, stock);
            productsList.add(prod);
            total+=price*stock;
        }
            System.out.println(productsList);
        
        //output the inventory at the start of the day 
            System.out.println("Inventory at the start of the day: "+total);
            
          
            
        //CUSTOMERS PART
        //number of customers
        int  nrCust = rand.nextInt(15) + 1;
         //create the Array of Customers
        ArrayList<Customer> customersList = new ArrayList<Customer>();
        //populate the list of customers
        int amount;
        for(int i =0; i<nrCust; i++){
            amount = rand.nextInt(100000)+1;//the amount that customer i can use to buy
            Customer cust = new Customer(i, amount);
            customersList.add(cust);
        }
            System.out.println(customersList); 
            
            
        
            
        //Activity in the SHOP
        int inventoryFin = 0;
        long x = System.currentTimeMillis();
        while(System.currentTimeMillis()-x<15000){
            //a customer who buys
            int customerNr = rand.nextInt(nrCust) ;
            //the product that he wants to buy
            int prodNr = rand.nextInt(nrProd)  ;
            //number of product nrProd that he wants to buy - maximum 3
            int nr = rand.nextInt(3)+1;
            
            //veryfy if the transaction can be done
            Customer cust = customersList.get(customerNr);
            Product prod = productsList.get(prodNr);
            if(prod.number>nr && cust.amount> nr*prod.price){
                prod.number-=nr;
                cust.amount-=nr*prod.price;
                inventoryFin+=nr*prod.price;
                System.out.println(nr+" productes of the productID "+prod.id+" to customerID "+cust.id);
                
            }
            Thread.sleep(3000);
        }
        
        System.out.println(inventoryFin);
        
    }
}
