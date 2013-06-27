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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.099 -0400", hash_original_field = "9F0DD5628B477CA3A412BD884083C065", hash_generated_field = "8624F6D40EA85567CEFE871C2375AD75")

    private byte[] keyIdentifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.100 -0400", hash_original_method = "98097DD6E6764877F7A5356FC5E050F1", hash_generated_method = "A27868715BD106CD9EA123F3B6E524D5")
    public  SubjectKeyIdentifier(byte[] keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
        // ---------- Original Method ----------
        //this.keyIdentifier = keyIdentifier;
    }

    
        public static SubjectKeyIdentifier decode(byte[] encoding) throws IOException {
        SubjectKeyIdentifier res = new SubjectKeyIdentifier((byte[])
                ASN1OctetString.getInstance().decode(encoding));
        res.encoding = encoding;
        return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.109 -0400", hash_original_method = "17F99A1E4EF8655788B38E4E26DB47E6", hash_generated_method = "27B00685BB8F28BFC8FEA5A5D77F348F")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1OctetString.getInstance().encode(keyIdentifier);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_298695354 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_298695354;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1OctetString.getInstance().encode(keyIdentifier);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.109 -0400", hash_original_method = "0AA50EADEBB05513FDAD39FEE021DBF0", hash_generated_method = "2E0D1CDFC6F61539DA7624D40975E87E")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("SubjectKeyIdentifier: [\n");
        sb.append(Array.toString(keyIdentifier, prefix));
        sb.append(prefix).append("]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //sb.append(prefix).append("SubjectKeyIdentifier: [\n");
        //sb.append(Array.toString(keyIdentifier, prefix));
        //sb.append(prefix).append("]\n");
    }

    
}

