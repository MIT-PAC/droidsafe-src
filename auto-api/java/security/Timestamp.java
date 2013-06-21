package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.security.cert.CertPath;
import java.util.Date;

public final class Timestamp implements Serializable {
    private Date timestamp;
    private CertPath signerCertPath;
    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.609 -0400", hash_original_method = "AAE6CDDCBB2AA770835AE5337F9257E2", hash_generated_method = "F9A3CA19A3BA5C013DA17E4EEB5DCC86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Timestamp(Date timestamp, CertPath signerCertPath) {
        dsTaint.addTaint(signerCertPath.dsTaint);
        dsTaint.addTaint(timestamp.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("timestamp == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("signerCertPath == null");
        } //End block
        this.timestamp = new Date(timestamp.getTime());
        // ---------- Original Method ----------
        //if (timestamp == null) {
            //throw new NullPointerException("timestamp == null");
        //}
        //if (signerCertPath == null) {
            //throw new NullPointerException("signerCertPath == null");
        //}
        //this.timestamp = new Date(timestamp.getTime());
        //this.signerCertPath = signerCertPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.609 -0400", hash_original_method = "5EC26C09389FD151E3B15C0B386F0A3D", hash_generated_method = "EE7D7E9251E6C229EFABAC9E1D3D1195")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1427880389 = (obj == this);
        } //End collapsed parenthetic
        {
            Timestamp that;
            that = (Timestamp) obj;
            boolean var2709CFC34CE811BA8682DC086775E595_1265006247 = (timestamp.equals(that.timestamp)
                    && signerCertPath.equals(that.signerCertPath));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj == this) {
            //return true;
        //}
        //if (obj instanceof Timestamp) {
            //Timestamp that = (Timestamp) obj;
            //return timestamp.equals(that.timestamp)
                    //&& signerCertPath.equals(that.signerCertPath);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.609 -0400", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "10249873DB56B4BE457F4CC4915F987A")
    @DSModeled(DSC.SAFE)
    public CertPath getSignerCertPath() {
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return signerCertPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.609 -0400", hash_original_method = "9F5E9DF58C2165A57C2B03C2ABFACB32", hash_generated_method = "B48AE7756FB3ACB69B56F2E42B7E9147")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Date getTimestamp() {
        Date varBAF0C49874063365A02D9D07F48E0DE0_1704663481 = ((Date) timestamp.clone());
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Date) timestamp.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.609 -0400", hash_original_method = "31DF5B7E8A0074E9903AAC481766C16B", hash_generated_method = "A5136DF418EFCE53ECC1393B6E7894D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        {
            hash = timestamp.hashCode() ^ signerCertPath.hashCode();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (hash == 0) {
            //hash = timestamp.hashCode() ^ signerCertPath.hashCode();
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.610 -0400", hash_original_method = "515CC78E7249E5726FD47C9B8B62F1A0", hash_generated_method = "C38091963A33AB64516DCB3B334583E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder buf;
        buf = new StringBuilder(256);
        buf.append("Timestamp [").append(timestamp).append(" certPath=");
        buf.append(signerCertPath.getCertificates().get(0)).append("]");
        String var0C174602EFE4BFBCB80A7056CFA680FB_729648608 = (buf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder(256);
        //buf.append("Timestamp [").append(timestamp).append(" certPath=");
        //buf.append(signerCertPath.getCertificates().get(0)).append("]");
        //return buf.toString();
    }

    
    private static final long serialVersionUID = -5502683707821851294L;
}

