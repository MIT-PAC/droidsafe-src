package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface CertSelector extends Cloneable {

    
    public Object clone();

    
    public boolean match(Certificate cert);
}
