package javax.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;

public abstract class Certificate {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.955 -0400", hash_original_method = "EF3B6A1B9C3991494D57A734B30AC9EA", hash_generated_method = "FB5E7E56595969C0BB651408CEF0619D")
    public  Certificate() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.956 -0400", hash_original_method = "7638A14848B991538FCB5E98A2110811", hash_generated_method = "67FF271B2D55D62198ECF9D568D4FCFA")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_337154212 = (obj == this);
        } 
        Certificate object = (Certificate) obj;
        try 
        {
            boolean var11CA5AEA54F4207F410C305432479276_147632990 = (Arrays.equals(getEncoded(), object.getEncoded()));
        } 
        catch (CertificateEncodingException e)
        { }
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44940076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_44940076;
        
        
            
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.957 -0400", hash_original_method = "694012085EC68335A49724253FE100EC", hash_generated_method = "F754D550EDF5D2E1757A55213E565808")
    public int hashCode() {
        int res = 0;
        try 
        {
            byte[] array = getEncoded();
            {
                int i = 0;
                {
                    res += array[i];
                } 
            } 
        } 
        catch (CertificateEncodingException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322142291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322142291;
        
        
        
            
            
                
            
        
        
        
    }

    
    public abstract byte[] getEncoded()
            throws CertificateEncodingException;

    
    public abstract void verify(PublicKey key)
            throws CertificateException, NoSuchAlgorithmException,
                   InvalidKeyException, NoSuchProviderException,
                   SignatureException;

    
    public abstract void verify(PublicKey key, String sigProvider)
            throws CertificateException, NoSuchAlgorithmException,
                   InvalidKeyException, NoSuchProviderException,
                   SignatureException;

    
    public abstract String toString();

    
    public abstract PublicKey getPublicKey();

    
}

