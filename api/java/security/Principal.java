package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Principal {
    
    public boolean equals( Object obj );

    
    public String getName();

    
    public int hashCode();

    
    public String toString();
}
