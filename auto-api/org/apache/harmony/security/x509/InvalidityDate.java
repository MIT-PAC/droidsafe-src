package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Date;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Type;

public final class InvalidityDate extends ExtensionValue {
    private Date date;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.816 -0400", hash_original_method = "98A9E577A59DEA03C0EE49B7902CB339", hash_generated_method = "A75765771F4E58661FCFC5431C899823")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidityDate(byte[] encoding) throws IOException {
        super(encoding);
        dsTaint.addTaint(encoding[0]);
        date = (Date) ASN1.decode(encoding);
        // ---------- Original Method ----------
        //date = (Date) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.817 -0400", hash_original_method = "0B806974B94533A41261B38C9B34792D", hash_generated_method = "B70B46BB43479D57100F1DB9A5EEAA4B")
    @DSModeled(DSC.SAFE)
    public Date getDate() {
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return date;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.819 -0400", hash_original_method = "B06BF934ECBF90D26364500F0540AD98", hash_generated_method = "259D1F185CCDF556CA92E5EFBE9E2747")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(date);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(date);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.820 -0400", hash_original_method = "CC2AAAF6B06623B04694869CF132851E", hash_generated_method = "1CF0374B51176FA489408ED9AC8EC8AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("Invalidity Date: [ ").append(date).append(" ]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("Invalidity Date: [ ").append(date).append(" ]\n");
    }

    
    public static final ASN1Type ASN1 = ASN1GeneralizedTime.getInstance();
}

