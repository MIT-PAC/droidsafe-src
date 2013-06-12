package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public class ASN1SequenceOf extends ASN1ValueCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.652 -0400", hash_original_method = "21EE3E508EAE978A6E4C8F66A4495FB2", hash_generated_method = "6D93A09CEAB9B33A49730470058E469D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1SequenceOf(ASN1Type type) {
        super(TAG_SEQUENCE, type);
        dsTaint.addTaint(type.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.652 -0400", hash_original_method = "1210CAF0851F865D477F96ED0B5EA47B", hash_generated_method = "DB67E9BF360E20574D3BD6FE2322034A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readSequenceOf(this);
        Object var883E4A51D9FE1FCA5622395E00C94DE9_1009948825 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readSequenceOf(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.652 -0400", hash_original_method = "501E4537A812C53E7A97F9D07A5FDD79", hash_generated_method = "79151847A8054AFA704C7154BBB43DA4")
    @DSModeled(DSC.SAFE)
    public final void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeSequenceOf(this);
        // ---------- Original Method ----------
        //out.encodeSequenceOf(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.652 -0400", hash_original_method = "7ECE29473F04DAB7CB66888A658BFD1F", hash_generated_method = "A1D0A3D6E54ECA7707266EE9BBC24ABB")
    @DSModeled(DSC.SAFE)
    public final void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.getSequenceOfLength(this);
        // ---------- Original Method ----------
        //out.getSequenceOfLength(this);
    }

    
}


