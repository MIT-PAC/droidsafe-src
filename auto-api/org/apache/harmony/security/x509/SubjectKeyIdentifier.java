package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.utils.Array;

public final class SubjectKeyIdentifier extends ExtensionValue {
    private byte[] keyIdentifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.919 -0400", hash_original_method = "98097DD6E6764877F7A5356FC5E050F1", hash_generated_method = "32075530775AAC27E59E770F7FB3CB4C")
    @DSModeled(DSC.SAFE)
    public SubjectKeyIdentifier(byte[] keyIdentifier) {
        dsTaint.addTaint(keyIdentifier[0]);
        // ---------- Original Method ----------
        //this.keyIdentifier = keyIdentifier;
    }

    
        public static SubjectKeyIdentifier decode(byte[] encoding) throws IOException {
        SubjectKeyIdentifier res = new SubjectKeyIdentifier((byte[])
                ASN1OctetString.getInstance().decode(encoding));
        res.encoding = encoding;
        return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.919 -0400", hash_original_method = "17F99A1E4EF8655788B38E4E26DB47E6", hash_generated_method = "118E1EC4EB2D874E8236BF2BD6FBD036")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1OctetString.getInstance().encode(keyIdentifier);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1OctetString.getInstance().encode(keyIdentifier);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.920 -0400", hash_original_method = "0AA50EADEBB05513FDAD39FEE021DBF0", hash_generated_method = "41658B33DD2CD85388079F4C3994B626")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("SubjectKeyIdentifier: [\n");
        sb.append(Array.toString(keyIdentifier, prefix));
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("SubjectKeyIdentifier: [\n");
        //sb.append(Array.toString(keyIdentifier, prefix));
        //sb.append(prefix).append("]\n");
    }

    
}

