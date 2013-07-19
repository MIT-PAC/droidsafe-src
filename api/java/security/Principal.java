package java.security;

// Droidsafe Imports

public interface Principal {
    
    public boolean equals( Object obj );

    
    public String getName();

    
    public int hashCode();

    
    public String toString();
}
