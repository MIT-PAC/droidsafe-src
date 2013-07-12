package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Date;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class BasicMaxAgeHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.285 -0400", hash_original_method = "B0446CDE16622CCB68895B794F750D42", hash_generated_method = "DA4D840327CEBBF0C24EEEA6E9EA8A83")
    public  BasicMaxAgeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.287 -0400", hash_original_method = "A8EE51F3135F41C00ED9344CF5263715", hash_generated_method = "7EF1C7246E3CEB152AAAC54A3A28B419")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1448094268 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1448094268.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1448094268;
        } //End block
    if(value == null)        
        {
            MalformedCookieException var7E80DBB42F4525C9A30EA88126DE2542_1029448328 = new MalformedCookieException("Missing value for max-age attribute");
            var7E80DBB42F4525C9A30EA88126DE2542_1029448328.addTaint(taint);
            throw var7E80DBB42F4525C9A30EA88126DE2542_1029448328;
        } //End block
        int age;
        try 
        {
            age = Integer.parseInt(value);
        } //End block
        catch (NumberFormatException e)
        {
            MalformedCookieException var04DF44DFD86647B55E7E021E88CDCF07_1680079956 = new MalformedCookieException ("Invalid max-age attribute: " 
                    + value);
            var04DF44DFD86647B55E7E021E88CDCF07_1680079956.addTaint(taint);
            throw var04DF44DFD86647B55E7E021E88CDCF07_1680079956;
        } //End block
    if(age < 0)        
        {
            MalformedCookieException varEDDA622198A28633992AAE2B8AC5B57B_1589880840 = new MalformedCookieException ("Negative max-age attribute: " 
                    + value);
            varEDDA622198A28633992AAE2B8AC5B57B_1589880840.addTaint(taint);
            throw varEDDA622198A28633992AAE2B8AC5B57B_1589880840;
        } //End block
        cookie.setExpiryDate(new Date(System.currentTimeMillis() + age * 1000L));
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null) {
            //throw new MalformedCookieException("Missing value for max-age attribute");
        //}
        //int age;
        //try {
            //age = Integer.parseInt(value);
        //} catch (NumberFormatException e) {
            //throw new MalformedCookieException ("Invalid max-age attribute: " 
                    //+ value);
        //}
        //if (age < 0) {
            //throw new MalformedCookieException ("Negative max-age attribute: " 
                    //+ value);
        //}
        //cookie.setExpiryDate(new Date(System.currentTimeMillis() + age * 1000L));
    }

    
}

