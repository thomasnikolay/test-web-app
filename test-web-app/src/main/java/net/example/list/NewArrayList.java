/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.example.list;

import java.util.ArrayList;

/**
 *
 * @author tnikolay
 */
public class NewArrayList {
    
    public static void main(String[] args) {
        
        ArrayList<Auto> test1 = new ArrayList<Auto>();
        
        test1.add(new Auto(2000, 1000));
        test1.add(new Auto(3000, 2000));
        
        ArrayList<Auto> test2 = new ArrayList<>(test1);
        
        test2.get(0).setPrice(9999);
        
        System.out.println("test1");
        for (Auto auto : test1) {
            System.err.println(auto.toString());
        }
        
        System.out.println("");
        System.out.println("test2");
        
        for (Auto auto : test2) {
            System.err.println(auto.toString());
        }
        
        byte b = 40;
        byte c = 30;
        
        byte a = (byte) (b + c);
        

        
    }
    
    public static class Auto{
        int weight;
        int price;

        public Auto(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
        
        

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Auto{" + "weight=" + weight + ", price=" + price + '}';
        }
        
        
        
    }
    
}
