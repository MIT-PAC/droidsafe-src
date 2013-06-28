package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1Enumerated;
import org.apache.harmony.security.asn1.ASN1Type;

public final class ReasonCode extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.306 -0400", hash_original_field = "C13367945D5D4C91047B3B50234AA7AB", hash_generated_field = "38BD380FAFFB7B224FC85C442EDC81E3")

    private byte code;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_method = "82F7372CC184C4A16042B3B65BCB1447", hash_generated_method = "DEE2F064406DCFE3BA4877D17EF1ADBE")
    public  ReasonCode(byte[] encoding) throws IOException {
        super(encoding);
        this.code = ((byte[]) ASN1.decode(encoding))[0];
        // ---------- Original Method ----------
        //this.code = ((byte[]) ASN1.decode(encoding))[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_method = "410E015295E6E50D0A716577DAE7F9D9", hash_generated_method = "02CCE4D110C3D2E0C391CC3735249094")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(new byte[] { code });
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1783814426 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1783814426;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(new byte[] { code });
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_method = "12E79139137D00D785F5C6D5EDD972F8", hash_generated_method = "DF5BBAFDB60D24D8D0B762BAD015047F")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Reason Code: [ ");
        //Begin case UNSPECIFIED 
        sb.append("unspecified");
        //End case UNSPECIFIED 
        //Begin case KEY_COMPROMISE 
        sb.append("keyCompromise");
        //End case KEY_COMPROMISE 
        //Begin case CA_COMPROMISE 
        sb.append("cACompromise");
        //End case CA_COMPROMISE 
        //Begin case AFFILIATION_CHANGED 
        sb.append("affiliationChanged");
        //End case AFFILIATION_CHANGED 
        //Begin case SUPERSEDED 
        sb.append("superseded");
        //End case SUPERSEDED 
        //Begin case CESSATION_OF_OPERATION 
        sb.append("cessationOfOperation");
        //End case CESSATION_OF_OPERATION 
        //Begin case CERTIFICATE_HOLD 
        sb.append("certificateHold");
        //End case CERTIFICATE_HOLD 
        //Begin case REMOVE_FROM_CRL 
        sb.append("removeFromCRL");
        //End case REMOVE_FROM_CRL 
        //Begin case PRIVILEGE_WITHDRAWN 
        sb.append("privilegeWithdrawn");
        //End case PRIVILEGE_WITHDRAWN 
        //Begin case AA_COMPROMISE 
        sb.append("aACompromise");
        //End case AA_COMPROMISE 
        sb.append(" ]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "4EE4A4B247B4B40455CE06FEEEC11975", hash_generated_field = "FC9B9354EEC4DDC14F6C969560681A6C")

    public static final byte UNSPECIFIED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "5B4D8B0205B9E511EE03B8A81D582AED", hash_generated_field = "57753DF43B94713A71E3FED437583FD7")

    public static final byte KEY_COMPROMISE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "19933BF9AC28EFB0288D1522393A3BE2", hash_generated_field = "06909C5AF2A63D587073F1A46DC9C51A")

    public static final byte CA_COMPROMISE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "9444353BAB0CCCEE0CD6EFDCECA8EB2E", hash_generated_field = "DC5D635D8C5080986F86797396F3F90A")

    public static final byte AFFILIATION_CHANGED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "2080FAC566F81E6873D9D0E138727D6A", hash_generated_field = "713395AB4EA284591E642556D26A3288")

    public static final byte SUPERSEDED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "1AC9A4B17B405C6CCBD9AA5A07957DAB", hash_generated_field = "FFB0D097194866B6C27F979225C7A60B")

    public static final byte CESSATION_OF_OPERATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "C7C9A5BE6047E0B6FAA35B73F321078A", hash_generated_field = "5BA983A7D28016C12332BEC19DC1198F")

    public static final byte CERTIFICATE_HOLD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "6FC1B4E966810E1A8C0B5280D89BEA37", hash_generated_field = "3A87D7BBDAFC3B4B671B1E694BDE6D46")

    public static final byte REMOVE_FROM_CRL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "A5F310778A013CEE835920B3DC16B758", hash_generated_field = "1180757F90A87B0B34CE627BB704EC5E")

    public static final byte PRIVILEGE_WITHDRAWN = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "BF95526EDC07E5EECAF19A55F0787176", hash_generated_field = "5282872BE9B89D0419CDE70E41F096CB")

    public static final byte AA_COMPROMISE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.307 -0400", hash_original_field = "D53FC8D7EF52DFD901E45D14FC8F1972", hash_generated_field = "36DF4BBF2E7BB18F36AA22BFE20AF0DE")

    public static final ASN1Type ASN1 = ASN1Enumerated.getInstance();
}

