/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.lambda.expression;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tnikolay
 */
public class LambdaExpression {
    
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abcdef");
        list.add("a12");
        
        list.forEach((String element) -> System.out.println(element));
    }
    
}
