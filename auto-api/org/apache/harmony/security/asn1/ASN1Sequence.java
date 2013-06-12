package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public class ASN1Sequence extends ASN1TypeCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.651 -0400", hash_original_method = "610127CDCC1D4C9ACAEBD8E4C31C3ADC", hash_generated_method = "32342C3C24EB90A776E48242AABE87E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Sequence(ASN1Type[] type) {
        super(TAG_SEQUENCE, type);
        dsTaint.addTaint(type.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.651 -0400", hash_original_method = "C5F60D3147ABDE99A60159C3AF8B464E", hash_generated_method = "3605B4C83B2325C9254383ABBA7989F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readSequence(this);
        Object var883E4A51D9FE1FCA5622395E00C94DE9_95580872 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readSequence(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.651 -0400", hash_original_method = "939BEAD5C5B494829F962DC4CEF2A705", hash_generated_method = "2A40E3825667D08278830D30155BD2C5")
    @DSModeled(DSC.SAFE)
    public final void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeSequence(this);
        // ---------- Original Method ----------
        //out.encodeSequence(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.651 -0400", hash_original_method = "1B7230BCE7873794BACD95464198B69E", hash_generated_method = "9C6BC2C9807A15AB7BA6D6CE095CE78A")
    @DSModeled(DSC.SAFE)
    public final void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.getSequenceLength(this);
        // ---------- Original Method ----------
        //out.getSequenceLength(this);
    }

    
}


