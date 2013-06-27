package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;

public abstract class Certificate implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.426 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.429 -0400", hash_original_method = "244ADEDBEBB96EF97070F535965BB014", hash_generated_method = "091FFA48FFD653C349D8D45027C4C179")
    protected  Certificate(String type) {
        this.type = type;
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.439 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "CE4AE0928B4CFAE4892CFED0281CCD7E")
    public final String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_656173958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_656173958 = type;
        varB4EAC82CA7396A68D541C85D26508E83_656173958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_656173958;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.439 -0400", hash_original_method = "34CF5F66357C97013C2BECCDE3CD7868", hash_generated_method = "93C8613413359848B302F0B5805C8043")
    public boolean equals(Object other) {
        {
            try 
            {
                boolean var4B38EF159D3F0D18D03DD6C018FE1989_1381754287 = (Arrays.equals(this.getEncoded(),
                        ((Certificate)other).getEncoded()));
            } //End block
            catch (CertificateEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } //End block
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570662848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570662848;
        // ---------- Original Method ----------
        //if (this == other) {
            //return true;
        //}
        //if (other instanceof Certificate) {
            //try {
                //return Arrays.equals(this.getEncoded(),
                        //((Certificate)other).getEncoded());
            //} catch (CertificateEncodingException e) {
                //throw new RuntimeException(e);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.440 -0400", hash_original_method = "4607E15AFDECFF486998F7FDB6C49986", hash_generated_method = "E579813BBFA46700A3E748D0E9B3359D")
    public int hashCode() {
        try 
        {
            byte[] encoded;
            encoded = getEncoded();
            int hash;
            hash = 0;
            {
                int i;
                i = 0;
                {
                    hash += i*encoded[i];
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (CertificateEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445267558 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445267558;
        // ---------- Original Method ----------
        //try {
            //byte[] encoded = getEncoded();
            //int hash = 0;
            //for (int i=0; i<encoded.length; i++) {
                //hash += i*encoded[i];
            //}
            //return hash;
        //} catch (CertificateEncodingException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    public abstract byte[] getEncoded() throws CertificateEncodingException;

    
    public abstract void verify(PublicKey key)
        throws CertificateException,
               NoSuchAlgorithmException,
               InvalidKeyException,
               NoSuchProviderException,
               SignatureException;

    
    public abstract void verify(PublicKey key, String sigProvider)
        throws CertificateException,
               NoSuchAlgorithmException,
               InvalidKeyException,
               NoSuchProviderException,
               SignatureException;

    
    public abstract String toString();

    
    public abstract PublicKey getPublicKey();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.446 -0400", hash_original_method = "99E789CC29F8A2F97D8F3F24132FD9A6", hash_generated_method = "B2C471ABA55C96D9D844DE2FA961F73E")
    protected Object writeReplace() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1597737519 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1597737519 = new CertificateRep(getType(), getEncoded());
        } //End block
        catch (CertificateEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not create serialization object: " + e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1597737519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597737519;
        // ---------- Original Method ----------
        //try {
            //return new CertificateRep(getType(), getEncoded());
        //} catch (CertificateEncodingException e) {
            //throw new NotSerializableException("Could not create serialization object: " + e);
        //}
    }

    
    protected static class CertificateRep implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.446 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.446 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.446 -0400", hash_original_method = "D627339278E2A38DCC6197D27B1C70B7", hash_generated_method = "55F6196FF50C3DD7ADA6E33F2AD1B31C")
        protected  CertificateRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
            // ---------- Original Method ----------
            //this.type = type;
            //this.data = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.447 -0400", hash_original_method = "4FCDFCCBC9683C8411983C8346CDCC6D", hash_generated_method = "E0DA1F0AC2812FA326454D8097F08B2D")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_647630424 = null; //Variable for return #1
            try 
            {
                CertificateFactory cf;
                cf = CertificateFactory.getInstance(type);
                varB4EAC82CA7396A68D541C85D26508E83_647630424 = cf.generateCertificate(new ByteArrayInputStream(data));
            } //End block
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not resolve certificate: " + t);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_647630424.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_647630424;
            // ---------- Original Method ----------
            //try {
                //CertificateFactory cf = CertificateFactory.getInstance(type);
                //return cf.generateCertificate(new ByteArrayInputStream(data));
            //} catch (Throwable t) {
                //throw new NotSerializableException("Could not resolve certificate: " + t);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.447 -0400", hash_original_field = "C67BEA3C27E872799CA2A3F4BF7600DF", hash_generated_field = "1BE121CE0572D54F341EB3985ACD22CE")

        private static long serialVersionUID = -8563758940495660020L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.447 -0400", hash_original_field = "B0A20FC242DEEE0C0792909819F416AA", hash_generated_field = "DF3B779AC65293AACA2C768A9CD43464")

        private static ObjectStreamField[] serialPersistentFields = ;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.447 -0400", hash_original_field = "FCAEC767E7CCF2D06EA44AB29A7557F6", hash_generated_field = "535B362E877C920C6E64EB8E54D5FD72")

    private static long serialVersionUID = -3585440601605666277L;
}

