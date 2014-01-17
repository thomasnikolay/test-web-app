/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tn.examples.ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 *
 * @author tnikolay
 */
public class TestOgnlExpressions {

    public static void main(String[] args) throws OgnlException {

        OgnlContext context = new OgnlContext();
        TestObject testObject = new TestObject();
        context.put("d", testObject);
        Object expression = Ognl.parseExpression("test2 > 4 ? 'test' : 'test2'");
        System.out.println(Ognl.getValue(expression, context, testObject).toString());

    }

  static class TestObject {

        public String test = "test";
        public int test2 =5;
       
    }
}
