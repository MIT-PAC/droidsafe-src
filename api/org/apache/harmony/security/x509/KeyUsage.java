package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Type;






public final class KeyUsage extends ExtensionValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.011 -0500", hash_original_field = "8FE132A8681ACFA2876A03B7FB1C08C4", hash_generated_field = "830B315CB33B2EEE4101ABD18F32DE61")

    private static final String[] USAGES = {
        "digitalSignature",
        "nonRepudiation",
        "keyEncipherment",
        "dataEncipherment",
        "keyAgreement",
        "keyCertSign",
        "cRLSign",
        "encipherOnly",
        "decipherOnly",
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.026 -0500", hash_original_field = "DB9DE36ECE519AB9B29E8EC1F979FFDE", hash_generated_field = "4E02BB773E266ED5A03D43D3E2D818EF")

    private static final ASN1Type ASN1 = new ASN1BitString.ASN1NamedBitList(9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.013 -0500", hash_original_field = "897E439B15C131A3FA7BEC4524A38C16", hash_generated_field = "C6468962076BC1172F0F351DE545D4EE")

    private  boolean[] keyUsage;

    /**
     * Creates the extension object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.016 -0500", hash_original_method = "DB6BBF789AE77B5AE6E5E06EC389C87F", hash_generated_method = "0C5447B0DE727866D45AF7AE8D3E7ED1")
    
public KeyUsage(byte[] encoding) throws IOException {
        super(encoding);
        this.keyUsage = (boolean[]) ASN1.decode(encoding);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.018 -0500", hash_original_method = "14A58386ABBA8977CF43289C95A15404", hash_generated_method = "A881DD27DDF692EADB3DB6785C6FA2C5")
    
public boolean[] getKeyUsage() {
        return keyUsage;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.021 -0500", hash_original_method = "F00F1E8212387BCE78D166E85787DB94", hash_generated_method = "272D2970411221B6D7F5EA0347D0178D")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(keyUsage);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.023 -0500", hash_original_method = "C3D25371DA677875302E0FC1058C6A6C", hash_generated_method = "5AF59B14A1AA43977725F1B6AF7AD005")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("KeyUsage [\n");
        for (int i = 0; i < keyUsage.length; i++) {
            if (keyUsage[i]) {
                sb.append(prefix).append("  ").append(USAGES[i]).append('\n');
            }
        }
        sb.append(prefix).append("]\n");
    }
}

