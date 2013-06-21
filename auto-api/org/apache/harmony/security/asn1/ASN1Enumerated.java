package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;

public final class ASN1Enumerated extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.938 -0400", hash_original_method = "AA03F41F75612EB5366E32BDDDAEA1AC", hash_generated_method = "11C6DEF098A19B58952BF9C0E3E54B4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Enumerated() {
        super(TAG_ENUM);
        // ---------- Original Method ----------
    }

    
        public static ASN1Enumerated getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.938 -0400", hash_original_method = "810B1EC4B5D81C8B87770AF406E0EFF5", hash_generated_method = "F45301AF1E41C1E9955DA5533DC05C44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readEnumerated();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_1398876640 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readEnumerated();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.938 -0400", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "D117F4DD5129EAC33E9A94A2AD8BF65C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        Object var0EEE625DA49755ABC57881FA721DED7B_976427818 = (Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.939 -0400", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "A59C0D05F7EFCB81EEB267F4EF2C6BDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeInteger();
        // ---------- Original Method ----------
        //out.encodeInteger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.939 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "5880804059FB3DAF2086019E77E60A22")
    @DSModeled(DSC.SAFE)
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
    private static final ASN1Enumerated ASN1 = new ASN1Enumerated();
}

