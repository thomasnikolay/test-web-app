/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.enums;

/**
 *
 * @author tnikolay
 */
public enum Constant {
      ONLY_MODIFY, ONLY_READ, ALL;
  
  public boolean isReadAllowed(){
    return this.equals(ALL) || this.equals(ONLY_READ);
  }
  
  public boolean isModifyAllowed(){
    return this.equals(ALL) || this.equals(ONLY_MODIFY);
  }
}
