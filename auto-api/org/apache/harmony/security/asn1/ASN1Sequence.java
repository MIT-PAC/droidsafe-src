package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ASN1Sequence extends ASN1TypeCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.996 -0400", hash_original_method = "610127CDCC1D4C9ACAEBD8E4C31C3ADC", hash_generated_method = "4A70BE5110974C466F0C9AF22C33F354")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Sequence(ASN1Type[] type) {
        super(TAG_SEQUENCE, type);
        dsTaint.addTaint(type[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.996 -0400", hash_original_method = "C5F60D3147ABDE99A60159C3AF8B464E", hash_generated_method = "54BEF3BC60C2856D4BA8CEFD3FE36FA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readSequence(this);
        Object var883E4A51D9FE1FCA5622395E00C94DE9_1854608040 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readSequence(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.997 -0400", hash_original_method = "939BEAD5C5B494829F962DC4CEF2A705", hash_generated_method = "129F8A284AAB24B7B0A0A17726CABD0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeSequence(this);
        // ---------- Original Method ----------
        //out.encodeSequence(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.997 -0400", hash_original_method = "1B7230BCE7873794BACD95464198B69E", hash_generated_method = "F9344AF5D22B9C91CABFCBD59088F95F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.getSequenceLength(this);
        // ---------- Original Method ----------
        //out.getSequenceLength(this);
    }

    
}

