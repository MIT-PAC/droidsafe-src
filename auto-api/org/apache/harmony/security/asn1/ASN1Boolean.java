package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public final class ASN1Boolean extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.921 -0400", hash_original_method = "FD99504F4E1A7A3268A56063556CF13F", hash_generated_method = "02BFB4CEBA233BD3B2DAAA4AB6F0DE78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Boolean() {
        super(TAG_BOOLEAN);
        // ---------- Original Method ----------
    }

    
        public static ASN1Boolean getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.922 -0400", hash_original_method = "4CABEEE4334687B876309AFB865CC60D", hash_generated_method = "CCE4A1D863B462FC0EADBA1AF81EB07D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readBoolean();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_705559018 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readBoolean();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.922 -0400", hash_original_method = "61E80FB6E60B72FAF41ECC8283C8390E", hash_generated_method = "9976949BD98564C1F454553FBE92053F")
    @DSModeled(DSC.SAFE)
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (in.buffer[in.contentOffset] == 0) {
            //return Boolean.FALSE;
        //}
        //return Boolean.TRUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.922 -0400", hash_original_method = "6CB7A1753C32BDECF173E6F0AF328B6D", hash_generated_method = "A7640A387B09065F5DD56BD38C980F33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeBoolean();
        // ---------- Original Method ----------
        //out.encodeBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.922 -0400", hash_original_method = "E10D3150F01479FE85EBF9E119EE1844", hash_generated_method = "16E850C1E587B02AF022A056EFA2A8BE")
    @DSModeled(DSC.SAFE)
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.length = 1;
        // ---------- Original Method ----------
        //out.length = 1;
    }

    
    private static final ASN1Boolean ASN1 = new ASN1Boolean();
}

