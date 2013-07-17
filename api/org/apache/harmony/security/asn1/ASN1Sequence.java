package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class ASN1Sequence extends ASN1TypeCollection {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.392 -0400", hash_original_method = "610127CDCC1D4C9ACAEBD8E4C31C3ADC", hash_generated_method = "C9229CAEBA7F81F1D78AC10A5D9D4E4F")
    public  ASN1Sequence(ASN1Type[] type) {
        super(TAG_SEQUENCE, type);
        addTaint(type[0].getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.392 -0400", hash_original_method = "C5F60D3147ABDE99A60159C3AF8B464E", hash_generated_method = "7808BB0A1A5EC32EB9BA591528282247")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readSequence(this);
        if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_1734367433 =             null;
            var540C13E9E156B687226421B24F2DF178_1734367433.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1734367433;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_525141774 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_525141774.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_525141774;
        // ---------- Original Method ----------
        //in.readSequence(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.393 -0400", hash_original_method = "939BEAD5C5B494829F962DC4CEF2A705", hash_generated_method = "2C846557EE6FACBF489DA44D3B902A9F")
    public final void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeSequence(this);
        // ---------- Original Method ----------
        //out.encodeSequence(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.393 -0400", hash_original_method = "1B7230BCE7873794BACD95464198B69E", hash_generated_method = "324232287A29C836CCDED2FD9198C552")
    public final void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.getSequenceLength(this);
        // ---------- Original Method ----------
        //out.getSequenceLength(this);
    }

    
}

