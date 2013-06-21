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
    private CertPath signerCertPath;
    private Timestamp timestamp;
    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.311 -0400", hash_original_method = "2D1A8E0F0018E23D2016EEE74572794C", hash_generated_method = "B92F2A468B1B57CD5001E6BFE728EDC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CodeSigner(CertPath signerCertPath, Timestamp timestamp) {
        dsTaint.addTaint(timestamp.dsTaint);
        dsTaint.addTaint(signerCertPath.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("signerCertPath == null");
        } //End block
        // ---------- Original Method ----------
        //if (signerCertPath == null) {
            //throw new NullPointerException("signerCertPath == null");
        //}
        //this.signerCertPath = signerCertPath;
        //this.timestamp = timestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.313 -0400", hash_original_method = "9391ADEEB71A28BB26D9308D62C031F2", hash_generated_method = "7CD9DDFDEC1967329B8C5F7BFE90E640")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_264209724 = (obj == this);
        } //End collapsed parenthetic
        {
            CodeSigner that;
            that = (CodeSigner) obj;
            {
                boolean var2A88F9031A1725B008B9DA1DBED8F875_987624137 = (!signerCertPath.equals(that.signerCertPath));
            } //End collapsed parenthetic
            {
                Object varAC213430F859BD4A0A5A3A3CA0FDA1B9_1668759111 = (timestamp
                    .equals(that.timestamp));
            } //End flattened ternary
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.314 -0400", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "10249873DB56B4BE457F4CC4915F987A")
    @DSModeled(DSC.SAFE)
    public CertPath getSignerCertPath() {
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return signerCertPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.314 -0400", hash_original_method = "F117DFA1A6EB777CC4A763885DD30F8B", hash_generated_method = "083A951A1791ACEA92D912CF21240A40")
    @DSModeled(DSC.SAFE)
    public Timestamp getTimestamp() {
        return (Timestamp)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return timestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.314 -0400", hash_original_method = "4C01119C48849B3B8C0F3B7EFA427DC4", hash_generated_method = "B7004488E0C103D7F4CC805C137E19C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        {
            hash = signerCertPath.hashCode()
                    ^ (timestamp == null ? 0 : timestamp.hashCode());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (hash == 0) {
            //hash = signerCertPath.hashCode()
                    //^ (timestamp == null ? 0 : timestamp.hashCode());
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.314 -0400", hash_original_method = "9AD37782FDC32A71B028636E3AD750B0", hash_generated_method = "FA9465366EBE4670A254D22817FFE887")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder buf;
        buf = new StringBuilder(256);
        buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
        {
            buf.append("; ").append(timestamp);
        } //End block
        buf.append("]");
        String var0C174602EFE4BFBCB80A7056CFA680FB_403965459 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder(256);
        //buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
        //if( timestamp != null ) {
            //buf.append("; ").append(timestamp);
        //}
        //buf.append("]");
        //return buf.toString();
    }

    
    private static final long serialVersionUID = 6819288105193937581L;
}

