package javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public interface URI extends Cloneable, Serializable {
    String getScheme();
    boolean isSipURI();

    Object clone();
    String toString();
}
