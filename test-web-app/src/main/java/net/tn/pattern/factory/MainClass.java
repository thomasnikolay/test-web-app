/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.pattern.factory;

/**
 *
 * @author tnikolay
 */
public class MainClass {

    public static void main(String[] args) {

        if(args.length != 1){
            System.out.println("Error: please give one parameter carClasses!");
            return;
        }

        CarFactory.CarClasses input = null;
        try{
         input = CarFactory.CarClasses.valueOf(args[0]);
        }catch(IllegalArgumentException e){
            System.out.println("please give a correct carClasses: ");
            e.printStackTrace();
            return;
        }

        Car car = new Car(Car.Manufacturer.Audi, Car.Color.red, 120);
        System.out.println(car);
        car = CarFactory.getCar(CarFactory.CarClasses.lowCar);
        System.out.println(car);
        car = CarFactory.getCar(CarFactory.CarClasses.superCar);
        System.out.println(car);
        car = CarFactory.getCar(CarFactory.CarClasses.noCar);
        System.out.println(car);

        if(input != null){
        car = CarFactory.getCar(input);
        System.out.println(car);
        return;
        }
        
    }



}
