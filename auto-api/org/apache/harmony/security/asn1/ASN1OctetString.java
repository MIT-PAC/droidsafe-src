package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.util.Arrays;

public class ASN1OctetString extends ASN1StringType {
    private static final ASN1OctetString ASN1 = new ASN1OctetString();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.640 -0400", hash_original_method = "FE8C061A61754FEAD4E80D2F91CDD232", hash_generated_method = "458EC4E691B95F16A781CF9DE069FD97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1OctetString() {
        super(TAG_OCTETSTRING);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.640 -0400", hash_original_method = "F77C5F3582B223C2ECF09C45F802AA0C", hash_generated_method = "374FB482A9F4BD4CF808640CD919DEF5")
    public static ASN1OctetString getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.640 -0400", hash_original_method = "28376DFC29A2213C4817BE9D28454968", hash_generated_method = "B7530E4217B3D5A89A7C27E93C4EDF1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readOctetString();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_632258730 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readOctetString();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.640 -0400", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "5DD247CB27A9C979AF5B9B69FC9344C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        Object var0EEE625DA49755ABC57881FA721DED7B_1043715055 = (Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.640 -0400", hash_original_method = "612A16573B17613AF81AE7469C8D7FB4", hash_generated_method = "140EB748B05DF3462C640679E7D59DAA")
    @DSModeled(DSC.SAFE)
    @Override
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeOctetString();
        // ---------- Original Method ----------
        //out.encodeOctetString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.640 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "EFF16A0211337515B52297AC0AFA60A9")
    @DSModeled(DSC.SAFE)
    @Override
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
}


