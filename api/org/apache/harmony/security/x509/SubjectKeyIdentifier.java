package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.utils.Array;

public final class SubjectKeyIdentifier extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.268 -0400", hash_original_field = "9F0DD5628B477CA3A412BD884083C065", hash_generated_field = "8624F6D40EA85567CEFE871C2375AD75")

    private byte[] keyIdentifier;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.268 -0400", hash_original_method = "98097DD6E6764877F7A5356FC5E050F1", hash_generated_method = "A27868715BD106CD9EA123F3B6E524D5")
    public  SubjectKeyIdentifier(byte[] keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
        // ---------- Original Method ----------
        //this.keyIdentifier = keyIdentifier;
    }

    
        @DSModeled(DSC.SAFE)
    public static SubjectKeyIdentifier decode(byte[] encoding) throws IOException {
        SubjectKeyIdentifier res = new SubjectKeyIdentifier((byte[])
                ASN1OctetString.getInstance().decode(encoding));
        res.encoding = encoding;
        return res;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.268 -0400", hash_original_method = "17F99A1E4EF8655788B38E4E26DB47E6", hash_generated_method = "C4E461A2334A87FD6DACE337EE7D2A49")
    @Override
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1OctetString.getInstance().encode(keyIdentifier);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_567301703 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1221948895 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1221948895;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1OctetString.getInstance().encode(keyIdentifier);
        //}
        //return encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.269 -0400", hash_original_method = "0AA50EADEBB05513FDAD39FEE021DBF0", hash_generated_method = "18FCB6843E56047CE4568CD41B944CC8")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("SubjectKeyIdentifier: [\n");
        sb.append(Array.toString(keyIdentifier, prefix));
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("SubjectKeyIdentifier: [\n");
        //sb.append(Array.toString(keyIdentifier, prefix));
        //sb.append(prefix).append("]\n");
    }

    
}

