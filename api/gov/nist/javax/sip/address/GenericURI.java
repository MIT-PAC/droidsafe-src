package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.address.URI;






public class GenericURI extends NetObject implements javax.sip.address.URI {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.017 -0400", hash_original_field = "ACD4CFB867E9014EB5553B665A7654E7", hash_generated_field = "84466DD07DFFDD9FDE6D988F4E83ECAA")

    protected String uriString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.017 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "24D7425D6BECD3F5F1DFFA7A7A9931FF")

    protected String scheme;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.018 -0400", hash_original_method = "523B0443B4AA531D1FAD6DE404409AD6", hash_generated_method = "6DA1D92CCB90E95FA80352986AB46076")
    protected  GenericURI() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.019 -0400", hash_original_method = "7FD69531AE924D3F151616E62ADFB396", hash_generated_method = "CB62C3292327AA7B5E832FF4C236D993")
    public  GenericURI(String uriString) throws ParseException {
        try 
        {
            this.uriString = uriString;
            int i = uriString.indexOf(":");
            scheme = uriString.substring(0, i);
        } //End block
        catch (Exception e)
        {
            ParseException var3ABBBA86BF87822CF0B972769AEFB7C7_1450259777 = new ParseException("GenericURI, Bad URI format", 0);
            var3ABBBA86BF87822CF0B972769AEFB7C7_1450259777.addTaint(taint);
            throw var3ABBBA86BF87822CF0B972769AEFB7C7_1450259777;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.019 -0400", hash_original_method = "82D33A5986E24A5B49AA621812B7822B", hash_generated_method = "8818A444B5379A121536A7FC37576978")
    public String encode() {
String varA4F4B44693A1936015581C1F7D6F4DAF_890299788 =         uriString;
        varA4F4B44693A1936015581C1F7D6F4DAF_890299788.addTaint(taint);
        return varA4F4B44693A1936015581C1F7D6F4DAF_890299788;
        // ---------- Original Method ----------
        //return uriString;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.020 -0400", hash_original_method = "054F173715F55BDEA2A1E3378F0F2AB7", hash_generated_method = "A9C53F1AB7264C1015FF5A2E7C6A2C99")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
StringBuffer varF6413B9B0E7E2F46B03F689845D050B5_208996485 =         buffer.append(uriString);
        varF6413B9B0E7E2F46B03F689845D050B5_208996485.addTaint(taint);
        return varF6413B9B0E7E2F46B03F689845D050B5_208996485;
        // ---------- Original Method ----------
        //return buffer.append(uriString);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.020 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "664AA0144C442B06AD3542A4E093D5C7")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_1556413752 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_1556413752.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_1556413752;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.021 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "6EE097233F9107937E4BB2AF7387A776")
    public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_1099718036 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_1099718036.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_1099718036;
        // ---------- Original Method ----------
        //return scheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.021 -0400", hash_original_method = "B3806A07425B89767F09A244B77901C0", hash_generated_method = "4BB3A3FCA5933E19D14F088D4769EE55")
    public boolean isSipURI() {
        boolean var223EE2316B20EDC6AC0AB79DDD935082_1014779965 = (this instanceof SipUri);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496315420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496315420;
        // ---------- Original Method ----------
        //return this instanceof SipUri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.022 -0400", hash_original_method = "7E429DD6D2D2C657A6046B8560CB3B06", hash_generated_method = "A6D4D4DA75B76B92AFA04798578720F8")
    public boolean equals(Object that) {
        addTaint(that.getTaint());
        if(this==that)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_89494095 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662161356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662161356;
        }
        else
        if(that instanceof URI)        
        {
            final URI o = (URI) that;
            boolean varB771248EBC1F05C3AE5A13A6E23B9B28_1204181504 = (this.toString().equalsIgnoreCase( o.toString() ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1528476740 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1528476740;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_887784772 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963570535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_963570535;
        // ---------- Original Method ----------
        //if (this==that) return true;
        //else if (that instanceof URI) {
            //final URI o = (URI) that;
            //return this.toString().equalsIgnoreCase( o.toString() );
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.023 -0400", hash_original_method = "52D4A3951B7E10EC34FBEDB345A7DD44", hash_generated_method = "4D2E4286C52962A164AB542F8323383E")
    public int hashCode() {
        int varF69BA08EDCBBC4B1AB26B0553043CBEF_1980141859 = (this.toString().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528846495 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528846495;
        // ---------- Original Method ----------
        //return this.toString().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.023 -0400", hash_original_field = "D75906B4137235E375B161FD9179A94A", hash_generated_field = "EC361B7FD77B4BC364A1EB7C2877B905")

    private static final long serialVersionUID = 3237685256878068790L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.023 -0400", hash_original_field = "93BE28658AD4F57CAEF4C99309DD680B", hash_generated_field = "EEAFD83E34DAB045B8C66FD91A97048B")

    public static final String SIP = ParameterNames.SIP_URI_SCHEME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.023 -0400", hash_original_field = "A3FF814C5B899AAE43A55130FBAC83DA", hash_generated_field = "D788E10BE3C933BF303C8CC2B6AE6852")

    public static final String SIPS = ParameterNames.SIPS_URI_SCHEME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.023 -0400", hash_original_field = "670927254660094F889F11FE03C8F520", hash_generated_field = "B9419126FB04B629003988675563E593")

    public static final String TEL = ParameterNames.TEL_URI_SCHEME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.023 -0400", hash_original_field = "13676743B8CCEF8A0CECCD0CDF51C553", hash_generated_field = "33B083E54AD9AB28718C43BD92A5BF45")

    public static final String POSTDIAL = ParameterNames.POSTDIAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.023 -0400", hash_original_field = "4E1C64A690AE4FC999D3FF79EBA16307", hash_generated_field = "DCED896575F535A60C867F6A2BB7A46D")

    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.023 -0400", hash_original_field = "E1395FADF83CF9E216CA887474E37A18", hash_generated_field = "D9810B9C1A17DB225FD610E39C79F114")

    public static final String ISUB = ParameterNames.ISUB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.023 -0400", hash_original_field = "A30338A2F4E641B2C31254F899FC388F", hash_generated_field = "65F9B05DBA88014AE89FA722A56F2E43")

    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
}

