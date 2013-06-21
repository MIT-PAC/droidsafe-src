package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;

public class ASN1OctetString extends ASN1StringType {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.975 -0400", hash_original_method = "FE8C061A61754FEAD4E80D2F91CDD232", hash_generated_method = "D6ED9BA2FC4CE32BD81039A4C8CEA95C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1OctetString() {
        super(TAG_OCTETSTRING);
        // ---------- Original Method ----------
    }

    
        public static ASN1OctetString getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.975 -0400", hash_original_method = "28376DFC29A2213C4817BE9D28454968", hash_generated_method = "030FF35DA2683FBAACAF11F622E7DAFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readOctetString();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_245454356 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readOctetString();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.975 -0400", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "4D7921B516A35E26F53682159A19E8EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        Object var0EEE625DA49755ABC57881FA721DED7B_36179911 = (Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.976 -0400", hash_original_method = "612A16573B17613AF81AE7469C8D7FB4", hash_generated_method = "C241418038C05D3E5824A97F3BD74BDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeOctetString();
        // ---------- Original Method ----------
        //out.encodeOctetString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.976 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "8641F9D51EB2475C7912B8F2206581D6")
    @DSModeled(DSC.SAFE)
    @Override
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
    private static final ASN1OctetString ASN1 = new ASN1OctetString();
}

