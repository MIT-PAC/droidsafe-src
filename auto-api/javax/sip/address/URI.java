package javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public interface URI extends Cloneable, Serializable {
    String getScheme();
    boolean isSipURI();

    Object clone();
    String toString();
}
