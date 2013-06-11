package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface Principal {
    
    public boolean equals( Object obj );

    
    public String getName();

    
    public int hashCode();

    
    public String toString();
}

