package java.security.cert;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface CertSelector extends Cloneable {

    
    public Object clone();

    
    public boolean match(Certificate cert);
}
