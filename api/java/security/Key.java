package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public interface Key extends Serializable {

    
    public static final long serialVersionUID = 6603384152749567654L;

    
    public String getAlgorithm();

    
    public String getFormat();

    
    public byte[] getEncoded();
}
