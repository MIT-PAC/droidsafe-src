package javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;

public interface Header extends Cloneable, Serializable {
    String getName();

    Object clone();
    boolean equals(Object obj);
    int hashCode();
    String toString();
}
