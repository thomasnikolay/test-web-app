package net.tn.examples.inheritance.equals;

import java.util.Objects;


public class ObjectEquals {

    private String test = "a";

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.test);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObjectEquals other = (ObjectEquals) obj;
        if (!Objects.equals(this.test, other.test)) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        ObjectEquals a = new ObjectEquals();
        ObjectEquals b = new ObjectEquals();
        System.out.println(a.equals(b));
    }

}
