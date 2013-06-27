package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.security.cert.CertPath;

public final class CodeSigner implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.920 -0400", hash_original_field = "6E0FA7FC9CEF8E5B39B9BB28B636A6B5", hash_generated_field = "FC883EA50AB2FDD2C3073E407E6CEA66")

    private CertPath signerCertPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.928 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "0D494C7F1B090A9E890D8617AD65E8BA")

    private Timestamp timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.928 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.929 -0400", hash_original_method = "2D1A8E0F0018E23D2016EEE74572794C", hash_generated_method = "C8B133EEC32CA51343F6384E9CF4D2D9")
    public  CodeSigner(CertPath signerCertPath, Timestamp timestamp) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("signerCertPath == null");
        } //End block
        this.signerCertPath = signerCertPath;
        this.timestamp = timestamp;
        // ---------- Original Method ----------
        //if (signerCertPath == null) {
            //throw new NullPointerException("signerCertPath == null");
        //}
        //this.signerCertPath = signerCertPath;
        //this.timestamp = timestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.930 -0400", hash_original_method = "9391ADEEB71A28BB26D9308D62C031F2", hash_generated_method = "063AD49344423D2604AE689170D2E243")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1021057565 = (obj == this);
        } //End collapsed parenthetic
        {
            CodeSigner that;
            that = (CodeSigner) obj;
            {
                boolean var2A88F9031A1725B008B9DA1DBED8F875_1867916511 = (!signerCertPath.equals(that.signerCertPath));
            } //End collapsed parenthetic
            {
                Object varAC213430F859BD4A0A5A3A3CA0FDA1B9_1075476752 = (timestamp
                    .equals(that.timestamp));
            } //End flattened ternary
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541651949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_541651949;
        // ---------- Original Method ----------
        //if (obj == this) {
            //return true;
        //}
        //if (obj instanceof CodeSigner) {
            //CodeSigner that = (CodeSigner) obj;
            //if (!signerCertPath.equals(that.signerCertPath)) {
                //return false;
            //}
            //return timestamp == null ? that.timestamp == null : timestamp
                    //.equals(that.timestamp);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.930 -0400", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "D97ADF11C84FBAFAB064A6B4688401B2")
    public CertPath getSignerCertPath() {
        CertPath varB4EAC82CA7396A68D541C85D26508E83_1139623099 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1139623099 = signerCertPath;
        varB4EAC82CA7396A68D541C85D26508E83_1139623099.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1139623099;
        // ---------- Original Method ----------
        //return signerCertPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.931 -0400", hash_original_method = "F117DFA1A6EB777CC4A763885DD30F8B", hash_generated_method = "396616B4A61F13CF17B107C997AC9E58")
    public Timestamp getTimestamp() {
        Timestamp varB4EAC82CA7396A68D541C85D26508E83_1529034829 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1529034829 = timestamp;
        varB4EAC82CA7396A68D541C85D26508E83_1529034829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1529034829;
        // ---------- Original Method ----------
        //return timestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.935 -0400", hash_original_method = "4C01119C48849B3B8C0F3B7EFA427DC4", hash_generated_method = "97005DE59C58D609E1379487FA558726")
    @Override
    public int hashCode() {
        {
            hash = signerCertPath.hashCode()
                    ^ (timestamp == null ? 0 : timestamp.hashCode());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130523230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2130523230;
        // ---------- Original Method ----------
        //if (hash == 0) {
            //hash = signerCertPath.hashCode()
                    //^ (timestamp == null ? 0 : timestamp.hashCode());
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.938 -0400", hash_original_method = "9AD37782FDC32A71B028636E3AD750B0", hash_generated_method = "F6BB97E91C60BED2F35E46EADDB423F9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_768813970 = null; //Variable for return #1
        StringBuilder buf;
        buf = new StringBuilder(256);
        buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
        {
            buf.append("; ").append(timestamp);
        } //End block
        buf.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_768813970 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_768813970.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_768813970;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder(256);
        //buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
        //if( timestamp != null ) {
            //buf.append("; ").append(timestamp);
        //}
        //buf.append("]");
        //return buf.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.938 -0400", hash_original_field = "30C3C6CD6B540195EBC607DF05762D73", hash_generated_field = "63805C0BF5341DC3FF46292EF6267744")

    private static long serialVersionUID = 6819288105193937581L;
}

