package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1Enumerated;
import org.apache.harmony.security.asn1.ASN1Type;

public final class ReasonCode extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.253 -0400", hash_original_field = "C13367945D5D4C91047B3B50234AA7AB", hash_generated_field = "38BD380FAFFB7B224FC85C442EDC81E3")

    private byte code;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.254 -0400", hash_original_method = "82F7372CC184C4A16042B3B65BCB1447", hash_generated_method = "DEE2F064406DCFE3BA4877D17EF1ADBE")
    public  ReasonCode(byte[] encoding) throws IOException {
        super(encoding);
        this.code = ((byte[]) ASN1.decode(encoding))[0];
        // ---------- Original Method ----------
        //this.code = ((byte[]) ASN1.decode(encoding))[0];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.254 -0400", hash_original_method = "410E015295E6E50D0A716577DAE7F9D9", hash_generated_method = "0D548A862740AC19879E03BB89A49586")
    @Override
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(new byte[] { code });
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1416001025 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_723806664 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_723806664;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(new byte[] { code });
        //}
        //return encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_method = "12E79139137D00D785F5C6D5EDD972F8", hash_generated_method = "E8462291E6A8AE6A49DF0459F9F11A76")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("Reason Code: [ ");
switch(code){
        case UNSPECIFIED:
        sb.append("unspecified");
        break;
        case KEY_COMPROMISE:
        sb.append("keyCompromise");
        break;
        case CA_COMPROMISE:
        sb.append("cACompromise");
        break;
        case AFFILIATION_CHANGED:
        sb.append("affiliationChanged");
        break;
        case SUPERSEDED:
        sb.append("superseded");
        break;
        case CESSATION_OF_OPERATION:
        sb.append("cessationOfOperation");
        break;
        case CERTIFICATE_HOLD:
        sb.append("certificateHold");
        break;
        case REMOVE_FROM_CRL:
        sb.append("removeFromCRL");
        break;
        case PRIVILEGE_WITHDRAWN:
        sb.append("privilegeWithdrawn");
        break;
        case AA_COMPROMISE:
        sb.append("aACompromise");
        break;
}        sb.append(" ]\n");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "4EE4A4B247B4B40455CE06FEEEC11975", hash_generated_field = "FC9B9354EEC4DDC14F6C969560681A6C")

    public static final byte UNSPECIFIED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "5B4D8B0205B9E511EE03B8A81D582AED", hash_generated_field = "57753DF43B94713A71E3FED437583FD7")

    public static final byte KEY_COMPROMISE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "19933BF9AC28EFB0288D1522393A3BE2", hash_generated_field = "06909C5AF2A63D587073F1A46DC9C51A")

    public static final byte CA_COMPROMISE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "9444353BAB0CCCEE0CD6EFDCECA8EB2E", hash_generated_field = "DC5D635D8C5080986F86797396F3F90A")

    public static final byte AFFILIATION_CHANGED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "2080FAC566F81E6873D9D0E138727D6A", hash_generated_field = "713395AB4EA284591E642556D26A3288")

    public static final byte SUPERSEDED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "1AC9A4B17B405C6CCBD9AA5A07957DAB", hash_generated_field = "FFB0D097194866B6C27F979225C7A60B")

    public static final byte CESSATION_OF_OPERATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "C7C9A5BE6047E0B6FAA35B73F321078A", hash_generated_field = "5BA983A7D28016C12332BEC19DC1198F")

    public static final byte CERTIFICATE_HOLD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "6FC1B4E966810E1A8C0B5280D89BEA37", hash_generated_field = "3A87D7BBDAFC3B4B671B1E694BDE6D46")

    public static final byte REMOVE_FROM_CRL = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "A5F310778A013CEE835920B3DC16B758", hash_generated_field = "1180757F90A87B0B34CE627BB704EC5E")

    public static final byte PRIVILEGE_WITHDRAWN = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.255 -0400", hash_original_field = "BF95526EDC07E5EECAF19A55F0787176", hash_generated_field = "5282872BE9B89D0419CDE70E41F096CB")

    public static final byte AA_COMPROMISE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.256 -0400", hash_original_field = "D53FC8D7EF52DFD901E45D14FC8F1972", hash_generated_field = "36DF4BBF2E7BB18F36AA22BFE20AF0DE")

    public static final ASN1Type ASN1 = ASN1Enumerated.getInstance();
}

