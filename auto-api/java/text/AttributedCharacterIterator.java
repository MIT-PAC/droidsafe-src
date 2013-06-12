package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;

public interface AttributedCharacterIterator extends CharacterIterator {

    
    public static class Attribute implements Serializable {

        private static final long serialVersionUID = -9142742483513960612L;

        
        public static final Attribute INPUT_METHOD_SEGMENT = new Attribute("input_method_segment");

        
        public static final Attribute LANGUAGE = new Attribute("language");

        
        public static final Attribute READING = new Attribute("reading");

        private String name;

        
        protected Attribute(String name) {
            this.name = name;
        }

        
        @Override
        public final boolean equals(Object object) {
            return this == object;
        }

        
        protected String getName() {
            return name;
        }

        
        @Override
        public final int hashCode() {
            return super.hashCode();
        }

        
        protected Object readResolve() throws InvalidObjectException {
            
            try {
                for (Field field : getClass().getFields()) {
                    if (field.getType() == getClass() && Modifier.isStatic(field.getModifiers())) {
                        Attribute candidate = (Attribute) field.get(null);
                        if (name.equals(candidate.name)) {
                            return candidate;
                        }
                    }
                }
            } catch (IllegalAccessException e) {
            }
            throw new InvalidObjectException("Failed to resolve " + this);
        }

        
        @Override
        public String toString() {
            return getClass().getName() + '(' + getName() + ')';
        }
    }

    
    public Set<Attribute> getAllAttributeKeys();

    
    public Object getAttribute(Attribute attribute);

    
    public Map<Attribute, Object> getAttributes();

    
    public int getRunLimit();

    
    public int getRunLimit(Attribute attribute);

    
    public int getRunLimit(Set<? extends Attribute> attributes);

    
    public int getRunStart();

    
    public int getRunStart(Attribute attribute);

    
    public int getRunStart(Set<? extends Attribute> attributes);
}

