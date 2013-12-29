package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.harmony.security.asn1.ASN1Integer;






public final class InhibitAnyPolicy extends ExtensionValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.838 -0500", hash_original_field = "E50BA320A230875E33FBEB8EC9831240", hash_generated_field = "34CEC7EBF0D69FDD5ECCA6C7F25F7FAF")

    private  int skipCerts;

    /**
     * Creates an object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.839 -0500", hash_original_method = "1933FA0EC9823F8DA6E27E5F5995EEC8", hash_generated_method = "06B1380EF934ABD70BE5159A4A384BE7")
    public InhibitAnyPolicy(byte[] encoding) throws IOException {
        super(encoding);
        this.skipCerts = new BigInteger((byte[])
                ASN1Integer.getInstance().decode(encoding)).intValue();
    }

    /**
     * Returns ASN.1 encoded form of the object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.840 -0500", hash_original_method = "3EBD51C43A05A1E4C8002DD6E78AE310", hash_generated_method = "93B1342ED85B3B9C4E78A3017E567EEB")
    @Override
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1Integer.getInstance()
                .encode(ASN1Integer.fromIntValue(skipCerts));
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:06.841 -0500", hash_original_method = "25B8E258E2717A4BB370159BACC96911", hash_generated_method = "5780D4B0AC51CDC952FBC456DCD1973E")
    @Override
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Inhibit Any-Policy: ").append(skipCerts).append('\n');
    }

    
}

