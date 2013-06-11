package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public final class ASN1Boolean extends ASN1Primitive {
    private static final ASN1Boolean ASN1 = new ASN1Boolean();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.625 -0400", hash_original_method = "FD99504F4E1A7A3268A56063556CF13F", hash_generated_method = "11D717513AFD4FC38994A89AA7CC2CFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Boolean() {
        super(TAG_BOOLEAN);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.625 -0400", hash_original_method = "D432504F1C834D9908D88CC415EEDF53", hash_generated_method = "90B125D538BA019B71FDE7D679B840FD")
    public static ASN1Boolean getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.625 -0400", hash_original_method = "4CABEEE4334687B876309AFB865CC60D", hash_generated_method = "BA8155F07283A462A7E310C3BD076FBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readBoolean();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_817818572 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readBoolean();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.625 -0400", hash_original_method = "61E80FB6E60B72FAF41ECC8283C8390E", hash_generated_method = "8ED5241A0EBA7528360C64EB7BEA8BAD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.625 -0400", hash_original_method = "6CB7A1753C32BDECF173E6F0AF328B6D", hash_generated_method = "EA1D6DC7E6B71C077BFB09B901A41CBA")
    @DSModeled(DSC.SAFE)
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeBoolean();
        // ---------- Original Method ----------
        //out.encodeBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.625 -0400", hash_original_method = "E10D3150F01479FE85EBF9E119EE1844", hash_generated_method = "777286E9DF5FFF34F939862BD6E2E9F1")
    @DSModeled(DSC.SAFE)
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.length = 1;
        // ---------- Original Method ----------
        //out.length = 1;
    }

    
}


