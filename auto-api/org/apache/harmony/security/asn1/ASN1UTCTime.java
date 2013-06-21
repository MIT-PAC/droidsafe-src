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

public final class ASN1UTCTime extends ASN1Time {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.025 -0400", hash_original_method = "26950815C4CFBBF28A3CFECAD840C50B", hash_generated_method = "EF7C489E04E77EFC692BF121C27E795F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1UTCTime() {
        super(TAG_UTCTIME);
        // ---------- Original Method ----------
    }

    
        public static ASN1UTCTime getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.025 -0400", hash_original_method = "A91CD5C6AC359830199B04A7EA591A03", hash_generated_method = "80F2B7B21282893DE9A9BFE0607709FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readUTCTime();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_1330825895 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readUTCTime();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.026 -0400", hash_original_method = "7E6261B78AC933A3E78C661A729AB3E3", hash_generated_method = "567C2026014B7AA3BEA60DAC4883C8F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeUTCTime();
        // ---------- Original Method ----------
        //out.encodeUTCTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.026 -0400", hash_original_method = "DF1F65526ADDCB7D66CE158126525DF9", hash_generated_method = "14D761525FCC81765ADD60A5781F47CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat(UTC_PATTERN);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        out.content = sdf.format(out.content).getBytes(Charsets.UTF_8);
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //SimpleDateFormat sdf = new SimpleDateFormat(UTC_PATTERN);
        //sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        //out.content = sdf.format(out.content).getBytes(Charsets.UTF_8);
        //out.length = ((byte[]) out.content).length;
    }

    
    public static final int UTC_HM = 11;
    public static final int UTC_HMS = 13;
    public static final int UTC_LOCAL_HM = 15;
    public static final int UTC_LOCAL_HMS = 17;
    private static final ASN1UTCTime ASN1 = new ASN1UTCTime();
    private static final String UTC_PATTERN = "yyMMddHHmmss'Z'";
}

