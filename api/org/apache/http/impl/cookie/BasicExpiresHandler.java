package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicExpiresHandler extends AbstractCookieAttributeHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.612 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.613 -0400", hash_original_method = "E41CF253A9B9B5C6E744E06930B5B074", hash_generated_method = "78B95E8B765F371241B1FD410CBA1E0B")
    public  BasicExpiresHandler(final String[] datepatterns) {
        if(datepatterns == null)        
        {
            IllegalArgumentException var600C82C6EC93A77239214F22A32CCB46_721209808 = new IllegalArgumentException("Array of date patterns may not be null");
            var600C82C6EC93A77239214F22A32CCB46_721209808.addTaint(taint);
            throw var600C82C6EC93A77239214F22A32CCB46_721209808;
        } //End block
        this.datepatterns = datepatterns;
        // ---------- Original Method ----------
        //if (datepatterns == null) {
            //throw new IllegalArgumentException("Array of date patterns may not be null");
        //}
        //this.datepatterns = datepatterns;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.614 -0400", hash_original_method = "E5515B48EDFE7B38CBDC32E74DAEC7F0", hash_generated_method = "E67109A27FA80A270156564345482E68")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1340534194 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1340534194.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1340534194;
        } //End block
        if(value == null)        
        {
            MalformedCookieException var3A3CEB57EAC3D650F76EA92E658CB669_1830204738 = new MalformedCookieException("Missing value for expires attribute");
            var3A3CEB57EAC3D650F76EA92E658CB669_1830204738.addTaint(taint);
            throw var3A3CEB57EAC3D650F76EA92E658CB669_1830204738;
        } //End block
        try 
        {
            cookie.setExpiryDate(DateUtils.parseDate(value, this.datepatterns));
        } //End block
        catch (DateParseException dpe)
        {
            MalformedCookieException var36A2A0FD39C70C07A3CF6C79005BEC31_889243437 = new MalformedCookieException("Unable to parse expires attribute: " 
                + value);
            var36A2A0FD39C70C07A3CF6C79005BEC31_889243437.addTaint(taint);
            throw var36A2A0FD39C70C07A3CF6C79005BEC31_889243437;
        } //End block
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null) {
            //throw new MalformedCookieException("Missing value for expires attribute");
        //}
        //try {
            //cookie.setExpiryDate(DateUtils.parseDate(value, this.datepatterns));
        //} catch (DateParseException dpe) {
            //throw new MalformedCookieException("Unable to parse expires attribute: " 
                //+ value);
        //}
    }

    
}

