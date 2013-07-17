package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class ASN1SequenceOf extends ASN1ValueCollection {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.401 -0400", hash_original_method = "21EE3E508EAE978A6E4C8F66A4495FB2", hash_generated_method = "6AA343111503CCCABA03EAC384BEDE01")
    public  ASN1SequenceOf(ASN1Type type) {
        super(TAG_SEQUENCE, type);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.402 -0400", hash_original_method = "1210CAF0851F865D477F96ED0B5EA47B", hash_generated_method = "7347DCC564B36B118762B4CE3A33D466")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readSequenceOf(this);
        if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_59996230 =             null;
            var540C13E9E156B687226421B24F2DF178_59996230.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_59996230;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_548480596 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_548480596.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_548480596;
        // ---------- Original Method ----------
        //in.readSequenceOf(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.402 -0400", hash_original_method = "501E4537A812C53E7A97F9D07A5FDD79", hash_generated_method = "0404CCD9D88D7E2A0382C7DBBA0D1DA1")
    public final void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeSequenceOf(this);
        // ---------- Original Method ----------
        //out.encodeSequenceOf(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.403 -0400", hash_original_method = "7ECE29473F04DAB7CB66888A658BFD1F", hash_generated_method = "3C20C50823DEA2B45F6495384CAC5A52")
    public final void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.getSequenceOfLength(this);
        // ---------- Original Method ----------
        //out.getSequenceOfLength(this);
    }

    
}

