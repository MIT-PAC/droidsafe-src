package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.943 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.944 -0400", hash_original_method = "244ADEDBEBB96EF97070F535965BB014", hash_generated_method = "091FFA48FFD653C349D8D45027C4C179")
    protected  Certificate(String type) {
        this.type = type;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.944 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "6F6B30863382FC352D5048ACE5D20BB2")
    public final String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_37888412 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_37888412 = type;
        varB4EAC82CA7396A68D541C85D26508E83_37888412.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_37888412;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.944 -0400", hash_original_method = "34CF5F66357C97013C2BECCDE3CD7868", hash_generated_method = "FA0E6DE1FB18771CF5975426062D8F14")
    public boolean equals(Object other) {
        {
            try 
            {
                boolean var4B38EF159D3F0D18D03DD6C018FE1989_901649905 = (Arrays.equals(this.getEncoded(),
                        ((Certificate)other).getEncoded()));
            } 
            catch (CertificateEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951940463 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951940463;
        
        
            
        
        
            
                
                        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.945 -0400", hash_original_method = "4607E15AFDECFF486998F7FDB6C49986", hash_generated_method = "0ED3A29EE54640083A7A5E95252A968E")
    public int hashCode() {
        try 
        {
            byte[] encoded = getEncoded();
            int hash = 0;
            {
                int i = 0;
                {
                    hash += i*encoded[i];
                } 
            } 
        } 
        catch (CertificateEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588745937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588745937;
        
        
            
            
            
                
            
            
        
            
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.946 -0400", hash_original_method = "99E789CC29F8A2F97D8F3F24132FD9A6", hash_generated_method = "FDADFE31C0B5754F7B4838A599D9F73F")
    protected Object writeReplace() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_826953531 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_826953531 = new CertificateRep(getType(), getEncoded());
        } 
        catch (CertificateEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not create serialization object: " + e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_826953531.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_826953531;
        
        
            
        
            
        
    }

    
    protected static class CertificateRep implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.947 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.947 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.947 -0400", hash_original_method = "D627339278E2A38DCC6197D27B1C70B7", hash_generated_method = "55F6196FF50C3DD7ADA6E33F2AD1B31C")
        protected  CertificateRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.948 -0400", hash_original_method = "4FCDFCCBC9683C8411983C8346CDCC6D", hash_generated_method = "20590C7020D5E358D9FC52CEA37DB429")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1185002597 = null; 
            try 
            {
                CertificateFactory cf = CertificateFactory.getInstance(type);
                varB4EAC82CA7396A68D541C85D26508E83_1185002597 = cf.generateCertificate(new ByteArrayInputStream(data));
            } 
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not resolve certificate: " + t);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1185002597.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1185002597;
            
            
                
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.948 -0400", hash_original_field = "C67BEA3C27E872799CA2A3F4BF7600DF", hash_generated_field = "945034F4E24059F289CC97EFC7BB0CA4")

        private static final long serialVersionUID = -8563758940495660020L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.948 -0400", hash_original_field = "B0A20FC242DEEE0C0792909819F416AA", hash_generated_field = "AB4D6C645AC4B18232ECD0062FB68685")

        private static final ObjectStreamField[] serialPersistentFields = {
             new ObjectStreamField("type", String.class),
             new ObjectStreamField("data", byte[].class, true)
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.948 -0400", hash_original_field = "FCAEC767E7CCF2D06EA44AB29A7557F6", hash_generated_field = "F128B9ED7E1B9361939A91BA465EE1B0")

    private static final long serialVersionUID = -3585440601605666277L;
}

