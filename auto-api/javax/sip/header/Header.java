package javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public interface Header extends Cloneable, Serializable {
    String getName();

    Object clone();
    boolean equals(Object obj);
    int hashCode();
    String toString();
}
