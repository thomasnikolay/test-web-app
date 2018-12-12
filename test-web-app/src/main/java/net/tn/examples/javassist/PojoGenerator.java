package net.tn.examples.javassist;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

public class PojoGenerator {

  public static Class generate(String className, Map/*String, Class*/ properties, Map/*String, Object*/ propertyValues) throws NotFoundException,
  CannotCompileException {

ClassPool pool = ClassPool.getDefault();
CtClass cc = pool.makeClass(className);

// add this to define a super class to extend
// cc.setSuperclass(resolveCtClass(MySuperClass.class));

// add this to define an interface to implement
cc.addInterface(resolveCtClass(Serializable.class));
Iterator iterator = properties.entrySet().iterator();

while(iterator.hasNext()) {
  Entry entry = (Entry) iterator.next();
  
    CtField ctField = new CtField(resolveCtClass((Class)entry.getValue()), (String) entry.getKey(), cc);
    if(propertyValues.containsKey(entry.getKey())){
      Object value = propertyValues.get(entry.getKey());
      
      if(value instanceof String ){
          cc.addField(ctField, CtField.Initializer.constant((String)value));          
      } 
            
      
    }else{
        cc.addField(ctField);      
    }
  

  // add getter
  cc.addMethod(generateGetter(cc, (String) entry.getKey(), (Class)entry.getValue()));

  // add setter
  cc.addMethod(generateSetter(cc, (String) entry.getKey(), (Class)entry.getValue()));
}

return cc.toClass();
}

private static CtMethod generateGetter(CtClass declaringClass, String fieldName, Class fieldClass)
  throws CannotCompileException {

String getterName = "get" + fieldName.substring(0, 1).toUpperCase()
    + fieldName.substring(1);

StringBuffer sb = new StringBuffer();
sb.append("public ").append(fieldClass.getName()).append(" ")
    .append(getterName).append("(){").append("return this.")
    .append(fieldName).append(";").append("}");
return CtMethod.make(sb.toString(), declaringClass);
}

private static CtMethod generateSetter(CtClass declaringClass, String fieldName, Class fieldClass)
  throws CannotCompileException {

String setterName = "set" + fieldName.substring(0, 1).toUpperCase()
    + fieldName.substring(1);

StringBuffer sb = new StringBuffer();
sb.append("public void ").append(setterName).append("(")
    .append(fieldClass.getName()).append(" ").append(fieldName)
    .append(")").append("{").append("this.").append(fieldName)
    .append("=").append(fieldName).append(";").append("}");
return CtMethod.make(sb.toString(), declaringClass);
}

private static CtClass resolveCtClass(Class clazz) throws NotFoundException {
ClassPool pool = ClassPool.getDefault();
return pool.get(clazz.getName());
}


}
