package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class ASN1GeneralizedTime extends ASN1Time {

    /**
     * Returns ASN.1 GeneralizedTime type default implementation
     *
     * The default implementation works with encoding
     * that is represented as Date object.
     *
     * @return ASN.1 GeneralizedTime type default implementation
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.047 -0500", hash_original_method = "8C714A8F61C5AA4D080377A3ECF44F36", hash_generated_method = "23CB860EA884CD854F12985D41D3CDB1")
    
public static ASN1GeneralizedTime getInstance() {
        return ASN1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.042 -0500", hash_original_field = "C37D96DDD2E632639E9745E4517FB7FE", hash_generated_field = "239E9CA407C152785E67097B54E8268F")

    private static final ASN1GeneralizedTime ASN1 = new ASN1GeneralizedTime();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.054 -0500", hash_original_field = "144ED8D455E2A7FA64D051C0A7B8F483", hash_generated_field = "91A8801F993CA23EA31856C634AC2077")

    //
    // According to X.680:
    // four digit year, seconds always presented
    // and fractional-seconds elements without
    // trailing 0's (must be cut later from content)
    private static final String GEN_PATTERN = "yyyyMMddHHmmss.SSS";

    /**
     * Constructs ASN.1 GeneralizedTime type
     *
     * The constructor is provided for inheritance purposes
     * when there is a need to create a custom ASN.1 GeneralizedTime type.
     * To get a default implementation it is recommended to use
     * getInstance() method.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.045 -0500", hash_original_method = "BB0F4D8A317B403CA2CD2FD0C74F8C92", hash_generated_method = "867C6ED7D91667F6ECC9996437FF15A5")
    
public ASN1GeneralizedTime() {
        super(TAG_GENERALIZEDTIME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.049 -0500", hash_original_method = "9601D88CE03A72C3505152153428ACD0", hash_generated_method = "0016126B69B7A43E346A7E14AC6C4091")
    
public Object decode(BerInputStream in) throws IOException {
        in.readGeneralizedTime();

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.052 -0500", hash_original_method = "815E5B13588CE775C73F05D1D7B36D43", hash_generated_method = "823C90829B0E887FFAB1B233DE0EF4A6")
    
public void encodeContent(BerOutputStream out) {
        out.encodeGeneralizedTime();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.057 -0500", hash_original_method = "D33B8806BE3331999BE0A247A6FB02E4", hash_generated_method = "339EC8F2E12EB153158245B8A7C0B1E2")
    
public void setEncodingContent(BerOutputStream out) {
        SimpleDateFormat sdf = new SimpleDateFormat(GEN_PATTERN);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String temp = sdf.format(out.content);
        // cut off trailing 0s
        int nullId;
        int currLength;
        while (((nullId = temp.lastIndexOf('0', currLength = temp.length() - 1)) != -1)
                & (nullId == currLength)) {
            temp = temp.substring(0, nullId);
        }
        // deal with point (cut off if it is last char)
        if (temp.charAt(currLength) == '.') {
            temp = temp.substring(0, currLength);
        }

        out.content = (temp + "Z").getBytes(Charsets.UTF_8);
        out.length = ((byte[]) out.content).length;
    }
}

