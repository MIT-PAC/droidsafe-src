package org.apache.http.impl.cookie;

// Droidsafe Imports
import java.util.Date;

import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

import droidsafe.annotations.DSGenerator;

public class BasicMaxAgeHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.624 -0400", hash_original_method = "B0446CDE16622CCB68895B794F750D42", hash_generated_method = "DA4D840327CEBBF0C24EEEA6E9EA8A83")
    public  BasicMaxAgeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.626 -0400", hash_original_method = "A8EE51F3135F41C00ED9344CF5263715", hash_generated_method = "08C9E73F48C1A6D0327F606A7D176E79")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1930298691 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1930298691.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1930298691;
        } //End block
        if(value == null)        
        {
            MalformedCookieException var7E80DBB42F4525C9A30EA88126DE2542_1771805147 = new MalformedCookieException("Missing value for max-age attribute");
            var7E80DBB42F4525C9A30EA88126DE2542_1771805147.addTaint(taint);
            throw var7E80DBB42F4525C9A30EA88126DE2542_1771805147;
        } //End block
        int age;
        try 
        {
            age = Integer.parseInt(value);
        } //End block
        catch (NumberFormatException e)
        {
            MalformedCookieException var04DF44DFD86647B55E7E021E88CDCF07_232879549 = new MalformedCookieException ("Invalid max-age attribute: " 
                    + value);
            var04DF44DFD86647B55E7E021E88CDCF07_232879549.addTaint(taint);
            throw var04DF44DFD86647B55E7E021E88CDCF07_232879549;
        } //End block
        if(age < 0)        
        {
            MalformedCookieException varEDDA622198A28633992AAE2B8AC5B57B_216017716 = new MalformedCookieException ("Negative max-age attribute: " 
                    + value);
            varEDDA622198A28633992AAE2B8AC5B57B_216017716.addTaint(taint);
            throw varEDDA622198A28633992AAE2B8AC5B57B_216017716;
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

