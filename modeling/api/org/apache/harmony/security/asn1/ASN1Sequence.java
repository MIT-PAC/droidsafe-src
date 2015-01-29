package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class ASN1Sequence extends ASN1TypeCollection {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.270 -0500", hash_original_method = "610127CDCC1D4C9ACAEBD8E4C31C3ADC", hash_generated_method = "E3D9E781E2F6BEA87826AFD0C7A39EA9")
    
public ASN1Sequence(ASN1Type[] type) {
        super(TAG_SEQUENCE, type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.273 -0500", hash_original_method = "C5F60D3147ABDE99A60159C3AF8B464E", hash_generated_method = "A068864BF14240390E3EBF33D80A73F8")
    
public Object decode(BerInputStream in) throws IOException {
        in.readSequence(this);

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.275 -0500", hash_original_method = "939BEAD5C5B494829F962DC4CEF2A705", hash_generated_method = "4C19B4B0C016FD2B7508D6CE873C49D2")
    
public final void encodeContent(BerOutputStream out) {
        out.encodeSequence(this);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.277 -0500", hash_original_method = "1B7230BCE7873794BACD95464198B69E", hash_generated_method = "320D19F1A70738F13D82D9CFAD821FA5")
    
public final void setEncodingContent(BerOutputStream out) {
        out.getSequenceLength(this);
    }
    
}

