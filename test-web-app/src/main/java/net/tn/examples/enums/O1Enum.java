/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tn.examples.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tnikolay
 */
public enum ESubystemType {
      POS_POS("pos-lob"), ESL_LOB("esl-lob"), ACCESS_VIA("accessvia"), SCALE("scale-lob");
  
  private final static Map<String, ESubystemType> values = new HashMap<String, ESubystemType>();
  
  static{
      for (ESubystemType subystemType : ESubystemType.values()) {
          values.put(subystemType.getSubsystemIdentifier(), subystemType);
      }
  }
  
  private final String subsystemIdentifier;
  
  private ESubystemType(String subsystemIdentifier) {
    this.subsystemIdentifier = subsystemIdentifier;    
  }

  public String getSubsystemIdentifier() {
    return subsystemIdentifier;
  }

}
