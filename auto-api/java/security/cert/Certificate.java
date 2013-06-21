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
    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.629 -0400", hash_original_method = "244ADEDBEBB96EF97070F535965BB014", hash_generated_method = "E82C868D059D96D95DD4C27FEE46721F")
    @DSModeled(DSC.SAFE)
    protected Certificate(String type) {
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.629 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "2AE4CD67D4DDBE32BC864794C06C4464")
    @DSModeled(DSC.SAFE)
    public final String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.630 -0400", hash_original_method = "34CF5F66357C97013C2BECCDE3CD7868", hash_generated_method = "053C203ECF687CA54A29CC213C510120")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            try 
            {
                boolean var4B38EF159D3F0D18D03DD6C018FE1989_296399393 = (Arrays.equals(this.getEncoded(),
                        ((Certificate)other).getEncoded()));
            } //End block
            catch (CertificateEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.630 -0400", hash_original_method = "4607E15AFDECFF486998F7FDB6C49986", hash_generated_method = "67C774F48B804E3360E13B4A368EA963")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.631 -0400", hash_original_method = "99E789CC29F8A2F97D8F3F24132FD9A6", hash_generated_method = "D5D9FA05B5EB47B04CA05E53F08905D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Object writeReplace() throws ObjectStreamException {
        try 
        {
            Object varF23AD4F891D39C8A76F1BF958063D6D0_1291336210 = (new CertificateRep(getType(), getEncoded()));
        } //End block
        catch (CertificateEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not create serialization object: " + e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return new CertificateRep(getType(), getEncoded());
        //} catch (CertificateEncodingException e) {
            //throw new NotSerializableException("Could not create serialization object: " + e);
        //}
    }

    
    protected static class CertificateRep implements Serializable {
        private String type;
        private byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.631 -0400", hash_original_method = "D627339278E2A38DCC6197D27B1C70B7", hash_generated_method = "4AA7E8952D12DC69AB50E1AD6384AFD4")
        @DSModeled(DSC.SAFE)
        protected CertificateRep(String type, byte[] data) {
            dsTaint.addTaint(data[0]);
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
            //this.type = type;
            //this.data = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.631 -0400", hash_original_method = "4FCDFCCBC9683C8411983C8346CDCC6D", hash_generated_method = "B8D8818127CB52A335CD421DB9B79777")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Object readResolve() throws ObjectStreamException {
            try 
            {
                CertificateFactory cf;
                cf = CertificateFactory.getInstance(type);
                Object var898435BA3E378976DA7CE7E87BF7861A_417387269 = (cf.generateCertificate(new ByteArrayInputStream(data)));
            } //End block
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not resolve certificate: " + t);
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //CertificateFactory cf = CertificateFactory.getInstance(type);
                //return cf.generateCertificate(new ByteArrayInputStream(data));
            //} catch (Throwable t) {
                //throw new NotSerializableException("Could not resolve certificate: " + t);
            //}
        }

        
        private static final long serialVersionUID = -8563758940495660020L;
        private static final ObjectStreamField[] serialPersistentFields = {
             new ObjectStreamField("type", String.class),
             new ObjectStreamField("data", byte[].class, true)
        };
    }


    
    private static final long serialVersionUID = -3585440601605666277L;
}

