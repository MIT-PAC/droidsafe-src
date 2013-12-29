package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.utils.Array;






public final class SubjectKeyIdentifier extends ExtensionValue {

    /**
     * Creates an object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.589 -0500", hash_original_method = "D7BFACA82671057310D9C36F7CB9679A", hash_generated_method = "75384C91D2280B56E0B05ACDF140B3B6")
    public static SubjectKeyIdentifier decode(byte[] encoding)
            throws IOException {
        SubjectKeyIdentifier res = new SubjectKeyIdentifier((byte[])
                ASN1OctetString.getInstance().decode(encoding));
        res.encoding = encoding;
        return res;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.587 -0500", hash_original_field = "006F8ED4DDFE79900363291BA15E74FC", hash_generated_field = "8624F6D40EA85567CEFE871C2375AD75")

    private  byte[] keyIdentifier;

    /**
     * Creates the object on the base of the value of key identifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.588 -0500", hash_original_method = "98097DD6E6764877F7A5356FC5E050F1", hash_generated_method = "34F7F61637DBA8B7EB4DE3C660C7B1B6")
    public SubjectKeyIdentifier(byte[] keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.590 -0500", hash_original_method = "17F99A1E4EF8655788B38E4E26DB47E6", hash_generated_method = "38288AA2E9620D0D5ABDEDEE6B2C8B72")
    @Override
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1OctetString.getInstance().encode(keyIdentifier);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.590 -0500", hash_original_method = "0AA50EADEBB05513FDAD39FEE021DBF0", hash_generated_method = "C160BB75C8922D77374A78FD3B7E467A")
    @Override
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("SubjectKeyIdentifier: [\n");
        sb.append(Array.toString(keyIdentifier, prefix));
        sb.append(prefix).append("]\n");
    }

    
}

