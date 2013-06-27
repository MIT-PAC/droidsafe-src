package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface CertSelector extends Cloneable {

    
    public Object clone();

    
    public boolean match(Certificate cert);
}
