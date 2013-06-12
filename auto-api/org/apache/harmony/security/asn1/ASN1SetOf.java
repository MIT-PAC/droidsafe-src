package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public class ASN1SetOf extends ASN1ValueCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.653 -0400", hash_original_method = "49B473C463A20ED93456B0E252B9BBF0", hash_generated_method = "CA58B537B847630A65BC46A8E9326D5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1SetOf(ASN1Type type) {
        super(TAG_SETOF, type);
        dsTaint.addTaint(type.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.653 -0400", hash_original_method = "F57C1115BE0470F5CDF9CC2B3F700EBD", hash_generated_method = "E39F48605D77D4B91544C60D1DB195BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readSetOf(this);
        Object var883E4A51D9FE1FCA5622395E00C94DE9_740007687 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readSetOf(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.653 -0400", hash_original_method = "4C2F70C283FCFB9FEA82A949984FC67E", hash_generated_method = "7911A3B248EAF6830A00BAFDD73666EF")
    @DSModeled(DSC.SAFE)
    public final void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeSetOf(this);
        // ---------- Original Method ----------
        //out.encodeSetOf(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.653 -0400", hash_original_method = "0CA5076CBF895038CB7C559B8AB50108", hash_generated_method = "18E3A0BF6ABE26B8801BEC8F1D129FE2")
    @DSModeled(DSC.SAFE)
    public final void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.getSetOfLength(this);
        // ---------- Original Method ----------
        //out.getSetOfLength(this);
    }

    
}


