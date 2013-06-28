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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.128 -0400", hash_original_field = "6E0FA7FC9CEF8E5B39B9BB28B636A6B5", hash_generated_field = "FC883EA50AB2FDD2C3073E407E6CEA66")

    private CertPath signerCertPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.128 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "0D494C7F1B090A9E890D8617AD65E8BA")

    private Timestamp timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.128 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.128 -0400", hash_original_method = "2D1A8E0F0018E23D2016EEE74572794C", hash_generated_method = "C8B133EEC32CA51343F6384E9CF4D2D9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.129 -0400", hash_original_method = "9391ADEEB71A28BB26D9308D62C031F2", hash_generated_method = "695FB2A583BB615AEDE4A2E89680AA80")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_376909339 = (obj == this);
        } //End collapsed parenthetic
        {
            CodeSigner that = (CodeSigner) obj;
            {
                boolean var2A88F9031A1725B008B9DA1DBED8F875_1641638916 = (!signerCertPath.equals(that.signerCertPath));
            } //End collapsed parenthetic
            {
                Object varAC213430F859BD4A0A5A3A3CA0FDA1B9_1118701041 = (timestamp
                    .equals(that.timestamp));
            } //End flattened ternary
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584714440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_584714440;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.130 -0400", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "4D91B981C5963E6024507CBD76781020")
    public CertPath getSignerCertPath() {
        CertPath varB4EAC82CA7396A68D541C85D26508E83_1058464365 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1058464365 = signerCertPath;
        varB4EAC82CA7396A68D541C85D26508E83_1058464365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1058464365;
        // ---------- Original Method ----------
        //return signerCertPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.130 -0400", hash_original_method = "F117DFA1A6EB777CC4A763885DD30F8B", hash_generated_method = "D9BDA99A6790427C1063EAA0C2500B77")
    public Timestamp getTimestamp() {
        Timestamp varB4EAC82CA7396A68D541C85D26508E83_992708654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_992708654 = timestamp;
        varB4EAC82CA7396A68D541C85D26508E83_992708654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_992708654;
        // ---------- Original Method ----------
        //return timestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.131 -0400", hash_original_method = "4C01119C48849B3B8C0F3B7EFA427DC4", hash_generated_method = "A8C736B870598A99BF3F07EB4482C448")
    @Override
    public int hashCode() {
        {
            hash = signerCertPath.hashCode()
                    ^ (timestamp == null ? 0 : timestamp.hashCode());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464494913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464494913;
        // ---------- Original Method ----------
        //if (hash == 0) {
            //hash = signerCertPath.hashCode()
                    //^ (timestamp == null ? 0 : timestamp.hashCode());
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.132 -0400", hash_original_method = "9AD37782FDC32A71B028636E3AD750B0", hash_generated_method = "22E63D059A56A95CA36829E42BAD3A71")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_173213002 = null; //Variable for return #1
        StringBuilder buf = new StringBuilder(256);
        buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
        {
            buf.append("; ").append(timestamp);
        } //End block
        buf.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_173213002 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_173213002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_173213002;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder(256);
        //buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
        //if( timestamp != null ) {
            //buf.append("; ").append(timestamp);
        //}
        //buf.append("]");
        //return buf.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.132 -0400", hash_original_field = "30C3C6CD6B540195EBC607DF05762D73", hash_generated_field = "29E3705B91FEE287C2335C4D8AA59C47")

    private static final long serialVersionUID = 6819288105193937581L;
}

