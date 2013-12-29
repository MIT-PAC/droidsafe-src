package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;





public class ASN1SequenceOf extends ASN1ValueCollection {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.247 -0500", hash_original_method = "21EE3E508EAE978A6E4C8F66A4495FB2", hash_generated_method = "28F0507C604F5C4BE98AE0CA1099D33F")
    public ASN1SequenceOf(ASN1Type type) {
        super(TAG_SEQUENCE, type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.248 -0500", hash_original_method = "1210CAF0851F865D477F96ED0B5EA47B", hash_generated_method = "CF5C0F855DCE81C9078A88235FF086BB")
    public Object decode(BerInputStream in) throws IOException {
        in.readSequenceOf(this);

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.249 -0500", hash_original_method = "501E4537A812C53E7A97F9D07A5FDD79", hash_generated_method = "077A0FAA50EB2178BACD7C41ECD63043")
    public final void encodeContent(BerOutputStream out) {
        out.encodeSequenceOf(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.250 -0500", hash_original_method = "7ECE29473F04DAB7CB66888A658BFD1F", hash_generated_method = "202739F43D683D12F71DF173F0563480")
    public final void setEncodingContent(BerOutputStream out) {
        out.getSequenceOfLength(this);
    }

    
}

