package javax.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;

public abstract class Certificate {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.825 -0400", hash_original_method = "EF3B6A1B9C3991494D57A734B30AC9EA", hash_generated_method = "FB5E7E56595969C0BB651408CEF0619D")
    public  Certificate() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.826 -0400", hash_original_method = "7638A14848B991538FCB5E98A2110811", hash_generated_method = "607D924FD1BBEE759E867565F82E1C81")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1366901651 = (obj == this);
        } //End collapsed parenthetic
        Certificate object;
        object = (Certificate) obj;
        try 
        {
            boolean var11CA5AEA54F4207F410C305432479276_283356583 = (Arrays.equals(getEncoded(), object.getEncoded()));
        } //End block
        catch (CertificateEncodingException e)
        { }
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286767644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286767644;
        // ---------- Original Method ----------
        //if (obj == this) {
            //return true;
        //}
        //if (!(obj instanceof Certificate)) {
            //return false;
        //}
        //Certificate object = (Certificate) obj;
        //try {
            //return Arrays.equals(getEncoded(), object.getEncoded());
        //} catch (CertificateEncodingException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.826 -0400", hash_original_method = "694012085EC68335A49724253FE100EC", hash_generated_method = "EBFE897AF863F61F940AAA5DE88769F0")
    public int hashCode() {
        int res;
        res = 0;
        try 
        {
            byte[] array;
            array = getEncoded();
            {
                int i;
                i = 0;
                {
                    res += array[i];
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (CertificateEncodingException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851585354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851585354;
        // ---------- Original Method ----------
        //int res = 0;
        //try {
            //byte[] array = getEncoded();
            //for (int i=0; i<array.length; i++) {
                //res += array[i];
            //}
        //} catch (CertificateEncodingException e) {
        //}
        //return res;
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

