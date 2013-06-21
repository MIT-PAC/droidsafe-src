package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ASN1SequenceOf extends ASN1ValueCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.998 -0400", hash_original_method = "21EE3E508EAE978A6E4C8F66A4495FB2", hash_generated_method = "A4784DEB061AD35BD46C54A7A3E5463D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1SequenceOf(ASN1Type type) {
        super(TAG_SEQUENCE, type);
        dsTaint.addTaint(type.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.998 -0400", hash_original_method = "1210CAF0851F865D477F96ED0B5EA47B", hash_generated_method = "44730A7E135246CCD96A46B60C3DA0DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readSequenceOf(this);
        Object var883E4A51D9FE1FCA5622395E00C94DE9_5081414 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readSequenceOf(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.998 -0400", hash_original_method = "501E4537A812C53E7A97F9D07A5FDD79", hash_generated_method = "8DDA688FFB474999DAC50E2F6FA9B82E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeSequenceOf(this);
        // ---------- Original Method ----------
        //out.encodeSequenceOf(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.998 -0400", hash_original_method = "7ECE29473F04DAB7CB66888A658BFD1F", hash_generated_method = "677D5C998CDAF28173F780141C83DF44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.getSequenceOfLength(this);
        // ---------- Original Method ----------
        //out.getSequenceOfLength(this);
    }

    
}

