package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class ASN1GeneralizedTime extends ASN1Time {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.600 -0400", hash_original_method = "BB0F4D8A317B403CA2CD2FD0C74F8C92", hash_generated_method = "AB7ED863FCD9D63D36CDA59E2988CC10")
    public  ASN1GeneralizedTime() {
        super(TAG_GENERALIZEDTIME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
    public static ASN1GeneralizedTime getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.601 -0400", hash_original_method = "9601D88CE03A72C3505152153428ACD0", hash_generated_method = "614855DCD582D8D5AE471FD5A709D178")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readGeneralizedTime();
    if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_751982900 =             null;
            var540C13E9E156B687226421B24F2DF178_751982900.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_751982900;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_1244638534 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_1244638534.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_1244638534;
        // ---------- Original Method ----------
        //in.readGeneralizedTime();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.601 -0400", hash_original_method = "815E5B13588CE775C73F05D1D7B36D43", hash_generated_method = "E719230D9A4ACB5C6353F15249002784")
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeGeneralizedTime();
        // ---------- Original Method ----------
        //out.encodeGeneralizedTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.602 -0400", hash_original_method = "D33B8806BE3331999BE0A247A6FB02E4", hash_generated_method = "2EBC5FAE5BFC613F29174250BED949C1")
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        SimpleDateFormat sdf = new SimpleDateFormat(GEN_PATTERN);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String temp = sdf.format(out.content);
        int nullId;
        int currLength;
        while
(((nullId = temp.lastIndexOf('0', currLength = temp.length() - 1)) != -1)
                & (nullId == currLength))        
        {
            temp = temp.substring(0, nullId);
        } //End block
    if(temp.charAt(currLength) == '.')        
        {
            temp = temp.substring(0, currLength);
        } //End block
        out.content = (temp + "Z").getBytes(Charsets.UTF_8);
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //SimpleDateFormat sdf = new SimpleDateFormat(GEN_PATTERN);
        //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        //String temp = sdf.format(out.content);
        //int nullId;
        //int currLength;
        //while (((nullId = temp.lastIndexOf('0', currLength = temp.length() - 1)) != -1)
                //& (nullId == currLength)) {
            //temp = temp.substring(0, nullId);
        //}
        //if (temp.charAt(currLength) == '.') {
            //temp = temp.substring(0, currLength);
        //}
        //out.content = (temp + "Z").getBytes(Charsets.UTF_8);
        //out.length = ((byte[]) out.content).length;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.602 -0400", hash_original_field = "0F3C7EF5E3C60EA92CED4C3504F2779F", hash_generated_field = "239E9CA407C152785E67097B54E8268F")

    private static final ASN1GeneralizedTime ASN1 = new ASN1GeneralizedTime();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.603 -0400", hash_original_field = "A2534DA841AAEDBC550D45A7FE68CB06", hash_generated_field = "23A74B159873D60AD28A6667478A53DA")

    private static final String GEN_PATTERN = "yyyyMMddHHmmss.SSS";
}

