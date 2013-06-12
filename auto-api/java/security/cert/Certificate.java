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
    private static final long serialVersionUID = -3585440601605666277L;
    private  String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.187 -0400", hash_original_method = "244ADEDBEBB96EF97070F535965BB014", hash_generated_method = "0438A18F45C59EEF58E2C6F18D7E099B")
    @DSModeled(DSC.SAFE)
    protected Certificate(String type) {
        dsTaint.addTaint(type);
          // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.188 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "C33423799F46A4D983B8408DB9A92B86")
    @DSModeled(DSC.SAFE)
    public final String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.593 -0400",hash_original_method="4FCDFCCBC9683C8411983C8346CDCC6D",hash_generated_method="A5CEB9E7F02AB7B2D0FD22A81DEF3BCD")
public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            try 
            {
                boolean var4B38EF159D3F0D18D03DD6C018FE1989_1594960761 = (Arrays.equals(this.getEncoded(),
                        ((Certificate)other).getEncoded()));
            } //End block
            catch (CertificateEncodingException e)
            {
                throw new RuntimeException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.189 -0400", hash_original_method = "4607E15AFDECFF486998F7FDB6C49986", hash_generated_method = "6BCE348DC039B7425D322E4C09343571")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.593 -0400",hash_original_method="4FCDFCCBC9683C8411983C8346CDCC6D",hash_generated_method="A5CEB9E7F02AB7B2D0FD22A81DEF3BCD")
protected Object writeReplace() throws ObjectStreamException {
        try 
        {
            Object varF23AD4F891D39C8A76F1BF958063D6D0_1837745347 = (new CertificateRep(getType(), getEncoded()));
        } //End block
        catch (CertificateEncodingException e)
        {
            throw new NotSerializableException("Could not create serialization object: " + e);
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
        private static final long serialVersionUID = -8563758940495660020L;
        private  String type;
        private  byte[] data;
        private static final ObjectStreamField[] serialPersistentFields = {
             new ObjectStreamField("type", String.class),
             new ObjectStreamField("data", byte[].class, true)
        };
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:54.203 -0400", hash_original_method = "D627339278E2A38DCC6197D27B1C70B7", hash_generated_method = "1E82B3987B0E3EDDF973C218ACB73B08")
        @DSModeled(DSC.SAFE)
        protected CertificateRep(String type, byte[] data) {
            dsTaint.addTaint(data);
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
            //this.type = type;
            //this.data = data;
        }

        
        @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.593 -0400",hash_original_method="4FCDFCCBC9683C8411983C8346CDCC6D",hash_generated_method="A5CEB9E7F02AB7B2D0FD22A81DEF3BCD")
protected Object readResolve() throws ObjectStreamException {
            try 
            {
                CertificateFactory cf;
                cf = CertificateFactory.getInstance(type);
                Object var898435BA3E378976DA7CE7E87BF7861A_517426307 = (cf.generateCertificate(new ByteArrayInputStream(data)));
            } //End block
            catch (Throwable t)
            {
                throw new NotSerializableException("Could not resolve certificate: " + t);
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

        
    }


    
}


//DSFIXME:  CODE0011:  Unresolved legacy methods exist in original model
/*

*/
