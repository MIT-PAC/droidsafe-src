package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.605 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.605 -0400", hash_original_method = "244ADEDBEBB96EF97070F535965BB014", hash_generated_method = "091FFA48FFD653C349D8D45027C4C179")
    protected  Certificate(String type) {
        this.type = type;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.605 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "EBE0EFFD687F30D53036E78D72CADC12")
    public final String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_462534867 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_462534867.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_462534867;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.606 -0400", hash_original_method = "34CF5F66357C97013C2BECCDE3CD7868", hash_generated_method = "60BB8190A328ABB7602D3145F993CC7B")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(this == other)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1247057391 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327416529 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327416529;
        } 
    if(other instanceof Certificate)        
        {
            try 
            {
                boolean var4103D3053CD784E62668680AA7D2BA51_2117297814 = (Arrays.equals(this.getEncoded(),
                        ((Certificate)other).getEncoded()));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302721946 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_302721946;
            } 
            catch (CertificateEncodingException e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_2037699955 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_2037699955.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_2037699955;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1741674357 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500118821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_500118821;
        
        
            
        
        
            
                
                        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.607 -0400", hash_original_method = "4607E15AFDECFF486998F7FDB6C49986", hash_generated_method = "97E0E8D013199A734E3B7C1A59963397")
    public int hashCode() {
        try 
        {
            byte[] encoded = getEncoded();
            int hash = 0;
for(int i=0;i<encoded.length;i++)
            {
                hash += i*encoded[i];
            } 
            int var0800FC577294C34E0B28AD2839435945_1922674690 = (hash);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_687013322 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_687013322;
        } 
        catch (CertificateEncodingException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_825850947 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_825850947.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_825850947;
        } 
        
        
            
            
            
                
            
            
        
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.608 -0400", hash_original_method = "99E789CC29F8A2F97D8F3F24132FD9A6", hash_generated_method = "6608CCD91BB96C5DBF9AE1FE0979F508")
    protected Object writeReplace() throws ObjectStreamException {
        try 
        {
Object varA4927F1440786F4D2449DB9A7837689C_2090865940 =             new CertificateRep(getType(), getEncoded());
            varA4927F1440786F4D2449DB9A7837689C_2090865940.addTaint(taint);
            return varA4927F1440786F4D2449DB9A7837689C_2090865940;
        } 
        catch (CertificateEncodingException e)
        {
            NotSerializableException varD10E63AB14446D5829D48417DD9728EF_432626177 = new NotSerializableException("Could not create serialization object: " + e);
            varD10E63AB14446D5829D48417DD9728EF_432626177.addTaint(taint);
            throw varD10E63AB14446D5829D48417DD9728EF_432626177;
        } 
        
        
            
        
            
        
    }

    
    protected static class CertificateRep implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.609 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.609 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.609 -0400", hash_original_method = "D627339278E2A38DCC6197D27B1C70B7", hash_generated_method = "55F6196FF50C3DD7ADA6E33F2AD1B31C")
        protected  CertificateRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.610 -0400", hash_original_method = "4FCDFCCBC9683C8411983C8346CDCC6D", hash_generated_method = "047B6D888C0458E9FD89A2937C906F78")
        protected Object readResolve() throws ObjectStreamException {
            try 
            {
                CertificateFactory cf = CertificateFactory.getInstance(type);
Object varD5B1E3A57F58153FF178493DE243F922_1679012166 =                 cf.generateCertificate(new ByteArrayInputStream(data));
                varD5B1E3A57F58153FF178493DE243F922_1679012166.addTaint(taint);
                return varD5B1E3A57F58153FF178493DE243F922_1679012166;
            } 
            catch (Throwable t)
            {
                NotSerializableException var94D0FAB119F18D6D8D1335EC6968AA1A_1148293927 = new NotSerializableException("Could not resolve certificate: " + t);
                var94D0FAB119F18D6D8D1335EC6968AA1A_1148293927.addTaint(taint);
                throw var94D0FAB119F18D6D8D1335EC6968AA1A_1148293927;
            } 
            
            
                
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.610 -0400", hash_original_field = "C67BEA3C27E872799CA2A3F4BF7600DF", hash_generated_field = "945034F4E24059F289CC97EFC7BB0CA4")

        private static final long serialVersionUID = -8563758940495660020L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.610 -0400", hash_original_field = "B0A20FC242DEEE0C0792909819F416AA", hash_generated_field = "AB4D6C645AC4B18232ECD0062FB68685")

        private static final ObjectStreamField[] serialPersistentFields = {
             new ObjectStreamField("type", String.class),
             new ObjectStreamField("data", byte[].class, true)
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.610 -0400", hash_original_field = "FCAEC767E7CCF2D06EA44AB29A7557F6", hash_generated_field = "F128B9ED7E1B9361939A91BA465EE1B0")

    private static final long serialVersionUID = -3585440601605666277L;
}

