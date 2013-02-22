/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.pattern.factory;

/**
 *
 * @author tnikolay
 */
public class CarFactory {

    public enum CarClasses{
        superCar, lowCar, noCar
    }

    private CarFactory() {
        super();
    }

    public static Car getCar(CarClasses carClasses){
        switch(carClasses){
            case superCar: return new Car(Car.Manufacturer.Audi, Car.Color.red, 12520);
            case lowCar: return new Car(Car.Manufacturer.BMW, Car.Color.black, 362000);
            case noCar: return new Car(Car.Manufacturer.Toyota, Car.Color.green, 36220025);
            default: return null;
        }

    }

}
