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
    protected String uriString;
    protected String scheme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.378 -0400", hash_original_method = "523B0443B4AA531D1FAD6DE404409AD6", hash_generated_method = "6DA1D92CCB90E95FA80352986AB46076")
    @DSModeled(DSC.SAFE)
    protected GenericURI() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.378 -0400", hash_original_method = "7FD69531AE924D3F151616E62ADFB396", hash_generated_method = "669CE4654DE6042A61AB5E138F8A91AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GenericURI(String uriString) throws ParseException {
        dsTaint.addTaint(uriString);
        try 
        {
            int i;
            i = uriString.indexOf(":");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.378 -0400", hash_original_method = "82D33A5986E24A5B49AA621812B7822B", hash_generated_method = "DC95E7FE24D590E647C1E79D2368806B")
    @DSModeled(DSC.SAFE)
    public String encode() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return uriString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.378 -0400", hash_original_method = "054F173715F55BDEA2A1E3378F0F2AB7", hash_generated_method = "430E33CB1CE4763F92F9412A2C102B79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        StringBuffer var0CA9F87EDD4D3485D615C601A26A9EB9_2138696423 = (buffer.append(uriString));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return buffer.append(uriString);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.379 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "202FB7D0EE64F927A0A4F37E4AC537C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var002E8E97D996E9DD2E7B0E1B0BD6187C_111950087 = (this.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.379 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "FA0BB2BEE07FE20A886DD0258ABDE91D")
    @DSModeled(DSC.SAFE)
    public String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.379 -0400", hash_original_method = "B3806A07425B89767F09A244B77901C0", hash_generated_method = "5629864AEADC5268DCA305AC60FFF15F")
    @DSModeled(DSC.SAFE)
    public boolean isSipURI() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this instanceof SipUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.379 -0400", hash_original_method = "7E429DD6D2D2C657A6046B8560CB3B06", hash_generated_method = "2990C6A37B7C5621DCB90BBFE54A6910")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object that) {
        dsTaint.addTaint(that.dsTaint);
        {
            URI o;
            o = (URI) that;
            boolean var80EE1F5DDFAF552DE51611741111EDF7_169246678 = (this.toString().equalsIgnoreCase( o.toString() ));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this==that) return true;
        //else if (that instanceof URI) {
            //final URI o = (URI) that;
            //return this.toString().equalsIgnoreCase( o.toString() );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.379 -0400", hash_original_method = "52D4A3951B7E10EC34FBEDB345A7DD44", hash_generated_method = "493906AC167405BD25086F7A70E2625B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int var03F05849217D7FDC84918CB4CE10B2CC_973559142 = (this.toString().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.toString().hashCode();
    }

    
    private static final long serialVersionUID = 3237685256878068790L;
    public static final String SIP = ParameterNames.SIP_URI_SCHEME;
    public static final String SIPS = ParameterNames.SIPS_URI_SCHEME;
    public static final String TEL = ParameterNames.TEL_URI_SCHEME;
    public static final String POSTDIAL = ParameterNames.POSTDIAL;
    public static final String PHONE_CONTEXT_TAG =
        ParameterNames.PHONE_CONTEXT_TAG;
    public static final String ISUB = ParameterNames.ISUB;
    public static final String PROVIDER_TAG = ParameterNames.PROVIDER_TAG;
}

