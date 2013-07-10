package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Principal {
    
    public boolean equals( Object obj );

    
    public String getName();

    
    public int hashCode();

    
    public String toString();
}
