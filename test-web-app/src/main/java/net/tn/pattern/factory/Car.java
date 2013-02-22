/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.pattern.factory;

/**
 *
 * @author tnikolay
 */
public class Car {

    private Color color = null;
    private Manufacturer manufacturere = null;
    private int miles;

    public enum Color{
        red, green, white, black
    }

    public enum Manufacturer {
        BMW, Audi, Toyota
    }

    public Car(Manufacturer manufacturer, Color color, int miles) {
        this.miles = miles;
        this.manufacturere = manufacturer;
        this.color = color;
    }    

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Manufacturer getManufacturere() {
        return manufacturere;
    }

    public void setManufacturere(Manufacturer manufacturere) {
        this.manufacturere = manufacturere;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    @Override
    public String toString() {
        return "you have a car with with following parameters: "+ manufacturere.name() +" " + color.name() + " " + miles;
    }



}
