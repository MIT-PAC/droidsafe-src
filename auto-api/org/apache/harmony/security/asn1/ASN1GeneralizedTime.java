package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class ASN1GeneralizedTime extends ASN1Time {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.961 -0400", hash_original_method = "BB0F4D8A317B403CA2CD2FD0C74F8C92", hash_generated_method = "AB7ED863FCD9D63D36CDA59E2988CC10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1GeneralizedTime() {
        super(TAG_GENERALIZEDTIME);
        // ---------- Original Method ----------
    }

    
        public static ASN1GeneralizedTime getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.962 -0400", hash_original_method = "9601D88CE03A72C3505152153428ACD0", hash_generated_method = "AA88277850B1FDDAF24FC3551885B351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readGeneralizedTime();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_1457248392 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readGeneralizedTime();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.962 -0400", hash_original_method = "815E5B13588CE775C73F05D1D7B36D43", hash_generated_method = "3FE0DB6C722E34AF91910140C756DC95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeGeneralizedTime();
        // ---------- Original Method ----------
        //out.encodeGeneralizedTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.962 -0400", hash_original_method = "D33B8806BE3331999BE0A247A6FB02E4", hash_generated_method = "2E65E1A2DE030F21FDF5113908C211A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat(GEN_PATTERN);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String temp;
        temp = sdf.format(out.content);
        int nullId;
        int currLength;
        {
            boolean varEA3B2EF7AD4FD6854C0460808E435C91_1290383065 = (((nullId = temp.lastIndexOf('0', currLength = temp.length() - 1)) != -1)
                & (nullId == currLength));
            {
                temp = temp.substring(0, nullId);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var20645FD268BF4909ADE246C840DD0211_1411122905 = (temp.charAt(currLength) == '.');
            {
                temp = temp.substring(0, currLength);
            } //End block
        } //End collapsed parenthetic
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

    
    private static final ASN1GeneralizedTime ASN1 = new ASN1GeneralizedTime();
    private static final String GEN_PATTERN = "yyyyMMddHHmmss.SSS";
}

