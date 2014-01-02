package java.security.interfaces;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

public interface RSAPrivateCrtKey extends RSAPrivateKey {

    
    public static final long serialVersionUID = -5682214253527700368L;

    
    public BigInteger getCrtCoefficient();

    
    public BigInteger getPrimeP();

    
    public BigInteger getPrimeQ();

    
    public BigInteger getPrimeExponentP();

    
    public BigInteger getPrimeExponentQ();

    
    public BigInteger getPublicExponent();
}
