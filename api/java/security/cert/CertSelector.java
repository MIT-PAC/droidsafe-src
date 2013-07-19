package java.security.cert;

// Droidsafe Imports

public interface CertSelector extends Cloneable {

    
    public Object clone();

    
    public boolean match(Certificate cert);
}
