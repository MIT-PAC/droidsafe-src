package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;






public final class ExtendedKeyUsage extends ExtensionValue {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.100 -0400", hash_original_field = "1C1534A2AA96342A497C51FF8E5360A5", hash_generated_field = "BF598BD805210074FAC5B7D06116F7DE")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(new ASN1Oid() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.294 -0500", hash_original_method = "324291EB7FC29F938FF2822490185CEC", hash_generated_method = "E684176ABDB941BE65FB64FA8A7929E1")
        public Object getDecodedObject(BerInputStream in) throws IOException {
            int[] oid = (int[]) super.getDecodedObject(in);
            return ObjectIdentifier.toString(oid);
        }
    });
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.289 -0500", hash_original_field = "EE4C3C9982A0696F6D933CC866CBC1C1", hash_generated_field = "B63F3A923567277A38E2C25A71F126D8")

    private List<String> keys;

    /**
     * Creates the extension object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.290 -0500", hash_original_method = "52F4822F456F1C9559212854B99C1B20", hash_generated_method = "5073F3D81BF13EE6AD09EC1D7AF1BEE0")
    public ExtendedKeyUsage(byte[] encoding) {
        super(encoding);
    }

    /**
     * Returns the list of string representation of OIDs corresponding
     * to key purpose IDs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.291 -0500", hash_original_method = "EC4A736D051BE2AF82868DFFF88ACC79", hash_generated_method = "C08D8A14C95987A92F34DDD9738ABC4F")
    public List<String> getExtendedKeyUsage() throws IOException {
        if (keys == null) {
            keys = (List<String>) ASN1.decode(getEncoded());
        }
        return keys;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.292 -0500", hash_original_method = "63AFE39A4816AB8A1F7656BFDDDB680C", hash_generated_method = "C47EC007E48BAD93DD250D3352564B1E")
    @Override
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(keys);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:07.293 -0500", hash_original_method = "4F87579E7E9CA4B1B17B20CD410B3E10", hash_generated_method = "76915DB22A600812D57900C98F3F664F")
    @Override
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Extended Key Usage: ");
        if (keys == null) {
            try {
                keys = getExtendedKeyUsage();
            } catch (IOException e) {
                // incorrect extension value encoding
                super.dumpValue(sb);
                return;
            }
        }
        sb.append('[');
        for (Iterator<?> it = keys.iterator(); it.hasNext();) {
            sb.append(" \"").append(it.next()).append('"');
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(" ]\n");
    }
}

