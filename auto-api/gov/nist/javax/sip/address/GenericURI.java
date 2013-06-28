package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.address.URI;

public class GenericURI extends NetObject implements javax.sip.address.URI {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.226 -0400", hash_original_field = "ACD4CFB867E9014EB5553B665A7654E7", hash_generated_field = "84466DD07DFFDD9FDE6D988F4E83ECAA")

    protected String uriString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.226 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.226 -0400", hash_original_method = "523B0443B4AA531D1FAD6DE404409AD6", hash_generated_method = "6DA1D92CCB90E95FA80352986AB46076")
    protected  GenericURI() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.227 -0400", hash_original_method = "7FD69531AE924D3F151616E62ADFB396", hash_generated_method = "6E5514710117E7550B2007BE0854EF33")
    public  GenericURI(String uriString) throws ParseException {
        try 
        {
            this.uriString = uriString;
            int i = uriString.indexOf(":");
            scheme = uriString.substring(0, i);
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException("GenericURI, Bad URI format", 0);
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.uriString = uriString;
            //int i = uriString.indexOf(":");
            //scheme = uriString.substring(0, i);
        //} catch (Exception e) {
            //throw new ParseException("GenericURI, Bad URI format", 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.227 -0400", hash_original_method = "82D33A5986E24A5B49AA621812B7822B", hash_generated_method = "89A2A5C8B28223A55248BCB088FA2261")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_120070843 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_120070843 = uriString;
        varB4EAC82CA7396A68D541C85D26508E83_120070843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_120070843;
        // ---------- Original Method ----------
        //return uriString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.228 -0400", hash_original_method = "054F173715F55BDEA2A1E3378F0F2AB7", hash_generated_method = "A69439C5205639B2E8A9D2D573F5BD0F")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1985710455 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1985710455 = buffer.append(uriString);
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1985710455.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1985710455;
        // ---------- Original Method ----------
        //return buffer.append(uriString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.228 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "03CE9A9418D1B4F68093B68CB9F96617")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1367393486 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1367393486 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1367393486.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1367393486;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.229 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "BDDE8A1A99F2AE723A221CC44A22A101")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_1659999446 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1659999446 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_1659999446.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1659999446;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.229 -0400", hash_original_method = "B3806A07425B89767F09A244B77901C0", hash_generated_method = "5C18B2DFDD88CE4A112474965D85822C")
    public boolean isSipURI() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_808680855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_808680855;
        // ---------- Original Method ----------
        //return this instanceof SipUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.229 -0400", hash_original_method = "7E429DD6D2D2C657A6046B8560CB3B06", hash_generated_method = "86CCE13FCF7A6310CC3E5E11C290CD13")
    public boolean equals(Object that) {
        {
            final URI o = (URI) that;
            boolean var80EE1F5DDFAF552DE51611741111EDF7_2023368231 = (this.toString().equalsIgnoreCase( o.toString() ));
        } //End block
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840141758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_840141758;
        // ---------- Original Method ----------
        //if (this==that) return true;
        //else if (that instanceof URI) {
            //final URI o = (URI) that;
            //return this.toString().equalsIgnoreCase( o.toString() );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.230 -0400", hash_original_method = "52D4A3951B7E10EC34FBEDB345A7DD44", hash_generated_method = "5376404F0CB176E3FA01D99F98DA7DC1")
    public int hashCode() {
        int var03F05849217D7FDC84918CB4CE10B2CC_996294806 = (this.toString().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085126804 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085126804;
        // ---------- Original Method ----------
        //return this.toString().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.230 -0400", hash_original_field = "D75906B4137235E375B161FD9179A94A", hash_generated_field = "EC361B7FD77B4BC364A1EB7C2877B905")

    private static final long serialVersionUID = 3237685256878068790L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.230 -0400", hash_original_field = "93BE28658AD4F57CAEF4C99309DD680B", hash_generated_field = "EEAFD83E34DAB045B8C66FD91A97048B")

    public static final String SIP = ParameterNames.SIP_URI_SCHEME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.230 -0400", hash_original_field = "A3FF814C5B899AAE43A55130FBAC83DA", hash_generated_field = "D788E10BE3C933BF303C8CC2B6AE6852")

    public static final String SIPS = ParameterNames.SIPS_URI_SCHEME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.230 -0400", hash_original_field = "670927254660094F889F11FE03C8F520", hash_generated_field = "B9419126FB04B629003988675563E593")

    public static final String TEL = ParameterNames.TEL_URI_SCHEME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.230 -0400", hash_original_field = "13676743B8CCEF8A0CECCD0CDF51C553", hash_generated_field = "33B083E54AD9AB28718C43BD92A5BF45")

    public static final String POSTDIAL = ParameterNames.POSTDIAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.230 -0400", hash_original_field = "4E1C64A690AE4FC999D3FF79EBA16307", hash_generated_field = "DCED896575F535A60C867F6A2BB7A46D")

    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.230 -0400", hash_original_field = "E1395FADF83CF9E216CA887474E37A18", hash_generated_field = "D9810B9C1A17DB225FD610E39C79F114")

    public static final String ISUB = ParameterNames.ISUB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.230 -0400", hash_original_field = "A30338A2F4E641B2C31254F899FC388F", hash_generated_field = "65F9B05DBA88014AE89FA722A56F2E43")

    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
}

