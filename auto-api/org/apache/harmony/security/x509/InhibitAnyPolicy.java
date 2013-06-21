package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Integer;

public final class InhibitAnyPolicy extends ExtensionValue {
    private int skipCerts;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.812 -0400", hash_original_method = "1933FA0EC9823F8DA6E27E5F5995EEC8", hash_generated_method = "790F70C9136EFCB7EA4339E571071241")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InhibitAnyPolicy(byte[] encoding) throws IOException {
        super(encoding);
        dsTaint.addTaint(encoding[0]);
        this.skipCerts = new BigInteger((byte[])
                ASN1Integer.getInstance().decode(encoding)).intValue();
        // ---------- Original Method ----------
        //this.skipCerts = new BigInteger((byte[])
                //ASN1Integer.getInstance().decode(encoding)).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.813 -0400", hash_original_method = "3EBD51C43A05A1E4C8002DD6E78AE310", hash_generated_method = "3F86704036EFDE3975F74F5C37CD4305")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1Integer.getInstance()
                .encode(ASN1Integer.fromIntValue(skipCerts));
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1Integer.getInstance()
                //.encode(ASN1Integer.fromIntValue(skipCerts));
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.813 -0400", hash_original_method = "25B8E258E2717A4BB370159BACC96911", hash_generated_method = "95153004C00292ACA214D1BFF7C3DBE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("Inhibit Any-Policy: ").append(skipCerts).append('\n');
        // ---------- Original Method ----------
        //sb.append(prefix).append("Inhibit Any-Policy: ").append(skipCerts).append('\n');
    }

    
}

