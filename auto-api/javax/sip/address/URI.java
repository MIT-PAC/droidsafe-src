package javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public interface URI extends Cloneable, Serializable {
    String getScheme();
    boolean isSipURI();

    Object clone();
    String toString();
}
