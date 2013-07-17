package javax.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;

public abstract class Certificate {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.174 -0400", hash_original_method = "EF3B6A1B9C3991494D57A734B30AC9EA", hash_generated_method = "FB5E7E56595969C0BB651408CEF0619D")
    public  Certificate() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.174 -0400", hash_original_method = "7638A14848B991538FCB5E98A2110811", hash_generated_method = "1211A1394726117F6D41395F03854537")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_605589752 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_614887387 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_614887387;
        } //End block
        if(!(obj instanceof Certificate))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1690159263 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637184312 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637184312;
        } //End block
        Certificate object = (Certificate) obj;
        try 
        {
            boolean var7C9514009008E5FF807700D3B8C514B2_2080625592 = (Arrays.equals(getEncoded(), object.getEncoded()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857016663 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_857016663;
        } //End block
        catch (CertificateEncodingException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_539412690 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079255767 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079255767;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.175 -0400", hash_original_method = "694012085EC68335A49724253FE100EC", hash_generated_method = "CD24FACB822283F09E454F0EC254ABFF")
    public int hashCode() {
        int res = 0;
        try 
        {
            byte[] array = getEncoded();
for(int i=0;i<array.length;i++)
            {
                res += array[i];
            } //End block
        } //End block
        catch (CertificateEncodingException e)
        {
        } //End block
        int var9B207167E5381C47682C6B4F58A623FB_1031357892 = (res);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191348024 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191348024;
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

