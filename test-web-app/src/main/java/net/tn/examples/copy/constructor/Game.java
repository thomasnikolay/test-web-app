/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.copy.constructor;

/**
 *
 * @author tnikolay
 */
public class Game {
    private String name;
    private String genre;
    private String price;

    public Game(String name, String genre, String price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public Game(Game game){
        this(game.name, game.genre, game.price);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" + "name=" + name + "genre=" + genre + "price=" + price + '}';
    }

    


    public static void main(String[] args) {
        Game game = new Game("FF7", "RPG", "50€");
        Game game2 = new Game(game);
        System.out.println("game1: "+game);
        System.out.println("game2: "+game2);
    }


}
