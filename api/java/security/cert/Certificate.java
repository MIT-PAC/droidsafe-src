package java.security.cert;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.637 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.637 -0400", hash_original_method = "244ADEDBEBB96EF97070F535965BB014", hash_generated_method = "091FFA48FFD653C349D8D45027C4C179")
    protected  Certificate(String type) {
        this.type = type;
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.638 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "A567F2208A15FC4117DFC4AB0ED6FBEE")
    public final String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_553003702 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_553003702.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_553003702;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.638 -0400", hash_original_method = "34CF5F66357C97013C2BECCDE3CD7868", hash_generated_method = "06DF8E3C6C21E9B78E878DD45E73632B")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(this == other)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1937269872 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144180002 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_144180002;
        } //End block
        if(other instanceof Certificate)        
        {
            try 
            {
                boolean var4103D3053CD784E62668680AA7D2BA51_465306879 = (Arrays.equals(this.getEncoded(),
                        ((Certificate)other).getEncoded()));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981111149 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_981111149;
            } //End block
            catch (CertificateEncodingException e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_275897582 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_275897582.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_275897582;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1026610859 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2038218579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2038218579;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.639 -0400", hash_original_method = "4607E15AFDECFF486998F7FDB6C49986", hash_generated_method = "9373100289BB25E4AC4439406406AD85")
    public int hashCode() {
        try 
        {
            byte[] encoded = getEncoded();
            int hash = 0;
for(int i=0;i<encoded.length;i++)
            {
                hash += i*encoded[i];
            } //End block
            int var0800FC577294C34E0B28AD2839435945_1319340596 = (hash);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507719045 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_507719045;
        } //End block
        catch (CertificateEncodingException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_190544709 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_190544709.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_190544709;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    public abstract byte[] getEncoded() throws CertificateEncodingException;

    
    @DSModeled(DSC.SAFE)
    public abstract void verify(PublicKey key)
        throws CertificateException,
               NoSuchAlgorithmException,
               InvalidKeyException,
               NoSuchProviderException,
               SignatureException;

    
    @DSModeled(DSC.SAFE)
    public abstract void verify(PublicKey key, String sigProvider)
        throws CertificateException,
               NoSuchAlgorithmException,
               InvalidKeyException,
               NoSuchProviderException,
               SignatureException;

    
    @DSModeled(DSC.SAFE)
    public abstract String toString();

    
    @DSModeled(DSC.SAFE)
    public abstract PublicKey getPublicKey();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.640 -0400", hash_original_method = "99E789CC29F8A2F97D8F3F24132FD9A6", hash_generated_method = "B5567D1914BA13E58705629B2329EEA5")
    protected Object writeReplace() throws ObjectStreamException {
        try 
        {
Object varA4927F1440786F4D2449DB9A7837689C_647093254 =             new CertificateRep(getType(), getEncoded());
            varA4927F1440786F4D2449DB9A7837689C_647093254.addTaint(taint);
            return varA4927F1440786F4D2449DB9A7837689C_647093254;
        } //End block
        catch (CertificateEncodingException e)
        {
            NotSerializableException varD10E63AB14446D5829D48417DD9728EF_1441760007 = new NotSerializableException("Could not create serialization object: " + e);
            varD10E63AB14446D5829D48417DD9728EF_1441760007.addTaint(taint);
            throw varD10E63AB14446D5829D48417DD9728EF_1441760007;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return new CertificateRep(getType(), getEncoded());
        //} catch (CertificateEncodingException e) {
            //throw new NotSerializableException("Could not create serialization object: " + e);
        //}
    }

    
    protected static class CertificateRep implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.640 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.640 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private byte[] data;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.641 -0400", hash_original_method = "D627339278E2A38DCC6197D27B1C70B7", hash_generated_method = "55F6196FF50C3DD7ADA6E33F2AD1B31C")
        protected  CertificateRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
            // ---------- Original Method ----------
            //this.type = type;
            //this.data = data;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.641 -0400", hash_original_method = "4FCDFCCBC9683C8411983C8346CDCC6D", hash_generated_method = "BFAC3201266653780201832FE22C27A0")
        protected Object readResolve() throws ObjectStreamException {
            try 
            {
                CertificateFactory cf = CertificateFactory.getInstance(type);
Object varD5B1E3A57F58153FF178493DE243F922_753933644 =                 cf.generateCertificate(new ByteArrayInputStream(data));
                varD5B1E3A57F58153FF178493DE243F922_753933644.addTaint(taint);
                return varD5B1E3A57F58153FF178493DE243F922_753933644;
            } //End block
            catch (Throwable t)
            {
                NotSerializableException var94D0FAB119F18D6D8D1335EC6968AA1A_1162759093 = new NotSerializableException("Could not resolve certificate: " + t);
                var94D0FAB119F18D6D8D1335EC6968AA1A_1162759093.addTaint(taint);
                throw var94D0FAB119F18D6D8D1335EC6968AA1A_1162759093;
            } //End block
            // ---------- Original Method ----------
            //try {
                //CertificateFactory cf = CertificateFactory.getInstance(type);
                //return cf.generateCertificate(new ByteArrayInputStream(data));
            //} catch (Throwable t) {
                //throw new NotSerializableException("Could not resolve certificate: " + t);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.641 -0400", hash_original_field = "C67BEA3C27E872799CA2A3F4BF7600DF", hash_generated_field = "945034F4E24059F289CC97EFC7BB0CA4")

        private static final long serialVersionUID = -8563758940495660020L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.641 -0400", hash_original_field = "B0A20FC242DEEE0C0792909819F416AA", hash_generated_field = "AB4D6C645AC4B18232ECD0062FB68685")

        private static final ObjectStreamField[] serialPersistentFields = {
             new ObjectStreamField("type", String.class),
             new ObjectStreamField("data", byte[].class, true)
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.642 -0400", hash_original_field = "FCAEC767E7CCF2D06EA44AB29A7557F6", hash_generated_field = "F128B9ED7E1B9361939A91BA465EE1B0")

    private static final long serialVersionUID = -3585440601605666277L;
}

