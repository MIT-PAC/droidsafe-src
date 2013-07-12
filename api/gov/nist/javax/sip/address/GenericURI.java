package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.address.URI;

public class GenericURI extends NetObject implements javax.sip.address.URI {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.057 -0400", hash_original_field = "ACD4CFB867E9014EB5553B665A7654E7", hash_generated_field = "84466DD07DFFDD9FDE6D988F4E83ECAA")

    protected String uriString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.057 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.058 -0400", hash_original_method = "523B0443B4AA531D1FAD6DE404409AD6", hash_generated_method = "6DA1D92CCB90E95FA80352986AB46076")
    protected  GenericURI() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.059 -0400", hash_original_method = "7FD69531AE924D3F151616E62ADFB396", hash_generated_method = "5BA175EAFD3AE5623A4B57EAD4F5CCAC")
    public  GenericURI(String uriString) throws ParseException {
        try 
        {
            this.uriString = uriString;
            int i = uriString.indexOf(":");
            scheme = uriString.substring(0, i);
        } //End block
        catch (Exception e)
        {
            ParseException var3ABBBA86BF87822CF0B972769AEFB7C7_1569629180 = new ParseException("GenericURI, Bad URI format", 0);
            var3ABBBA86BF87822CF0B972769AEFB7C7_1569629180.addTaint(taint);
            throw var3ABBBA86BF87822CF0B972769AEFB7C7_1569629180;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.060 -0400", hash_original_method = "82D33A5986E24A5B49AA621812B7822B", hash_generated_method = "C7E1D7B677E06243F273B36460FF1DE2")
    public String encode() {
String varA4F4B44693A1936015581C1F7D6F4DAF_460354654 =         uriString;
        varA4F4B44693A1936015581C1F7D6F4DAF_460354654.addTaint(taint);
        return varA4F4B44693A1936015581C1F7D6F4DAF_460354654;
        // ---------- Original Method ----------
        //return uriString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.060 -0400", hash_original_method = "054F173715F55BDEA2A1E3378F0F2AB7", hash_generated_method = "AA554ADE28F37AA61953AD48868F1652")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer varF6413B9B0E7E2F46B03F689845D050B5_631095691 =         buffer.append(uriString);
        varF6413B9B0E7E2F46B03F689845D050B5_631095691.addTaint(taint);
        return varF6413B9B0E7E2F46B03F689845D050B5_631095691;
        // ---------- Original Method ----------
        //return buffer.append(uriString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.060 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "DB98E7ABCA5E20A74CBD52536A531335")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_361875861 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_361875861.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_361875861;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.061 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "F288A0CCE7A39F2295AFE9C86EAC0BF0")
    public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_143294473 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_143294473.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_143294473;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.061 -0400", hash_original_method = "B3806A07425B89767F09A244B77901C0", hash_generated_method = "84ED8AD2228A8DD3B90DD63BDF66C8AC")
    public boolean isSipURI() {
        boolean var223EE2316B20EDC6AC0AB79DDD935082_1482563668 = (this instanceof SipUri);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1069156359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1069156359;
        // ---------- Original Method ----------
        //return this instanceof SipUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.062 -0400", hash_original_method = "7E429DD6D2D2C657A6046B8560CB3B06", hash_generated_method = "14AE0D260E941035A9F2DBC1FD488F5F")
    public boolean equals(Object that) {
        addTaint(that.getTaint());
    if(this==that)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1261803826 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981403208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981403208;
        }
        else
    if(that instanceof URI)        
        {
            final URI o = (URI) that;
            boolean varB771248EBC1F05C3AE5A13A6E23B9B28_422741576 = (this.toString().equalsIgnoreCase( o.toString() ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313553987 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_313553987;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_640001797 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265616614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_265616614;
        // ---------- Original Method ----------
        //if (this==that) return true;
        //else if (that instanceof URI) {
            //final URI o = (URI) that;
            //return this.toString().equalsIgnoreCase( o.toString() );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.062 -0400", hash_original_method = "52D4A3951B7E10EC34FBEDB345A7DD44", hash_generated_method = "A370CC3872FA71D308DA8875ED23DAD4")
    public int hashCode() {
        int varF69BA08EDCBBC4B1AB26B0553043CBEF_685597719 = (this.toString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077554349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077554349;
        // ---------- Original Method ----------
        //return this.toString().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.063 -0400", hash_original_field = "D75906B4137235E375B161FD9179A94A", hash_generated_field = "EC361B7FD77B4BC364A1EB7C2877B905")

    private static final long serialVersionUID = 3237685256878068790L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.063 -0400", hash_original_field = "93BE28658AD4F57CAEF4C99309DD680B", hash_generated_field = "EEAFD83E34DAB045B8C66FD91A97048B")

    public static final String SIP = ParameterNames.SIP_URI_SCHEME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.063 -0400", hash_original_field = "A3FF814C5B899AAE43A55130FBAC83DA", hash_generated_field = "D788E10BE3C933BF303C8CC2B6AE6852")

    public static final String SIPS = ParameterNames.SIPS_URI_SCHEME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.063 -0400", hash_original_field = "670927254660094F889F11FE03C8F520", hash_generated_field = "B9419126FB04B629003988675563E593")

    public static final String TEL = ParameterNames.TEL_URI_SCHEME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.063 -0400", hash_original_field = "13676743B8CCEF8A0CECCD0CDF51C553", hash_generated_field = "33B083E54AD9AB28718C43BD92A5BF45")

    public static final String POSTDIAL = ParameterNames.POSTDIAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.063 -0400", hash_original_field = "4E1C64A690AE4FC999D3FF79EBA16307", hash_generated_field = "DCED896575F535A60C867F6A2BB7A46D")

    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.063 -0400", hash_original_field = "E1395FADF83CF9E216CA887474E37A18", hash_generated_field = "D9810B9C1A17DB225FD610E39C79F114")

    public static final String ISUB = ParameterNames.ISUB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.063 -0400", hash_original_field = "A30338A2F4E641B2C31254F899FC388F", hash_generated_field = "65F9B05DBA88014AE89FA722A56F2E43")

    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
}

