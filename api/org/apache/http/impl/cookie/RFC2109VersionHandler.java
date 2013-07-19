package org.apache.http.impl.cookie;

// Droidsafe Imports
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

import droidsafe.annotations.DSGenerator;

public class RFC2109VersionHandler extends AbstractCookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.128 -0400", hash_original_method = "A02637D5820C2A953A6FE290A5D120D8", hash_generated_method = "78C075841E7848E13CAEA65D188AF82D")
    public  RFC2109VersionHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.129 -0400", hash_original_method = "5A56CF450872EBA5B862F4919DADFF98", hash_generated_method = "63AFC4F73222EB0685118F55FC25461C")
    public void parse(final SetCookie cookie, final String value) throws MalformedCookieException {
        addTaint(value.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_571530608 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_571530608.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_571530608;
        } //End block
        if(value == null)        
        {
            MalformedCookieException var34DCCD1FCF80B922AD071CE3DF09605E_1807231510 = new MalformedCookieException("Missing value for version attribute");
            var34DCCD1FCF80B922AD071CE3DF09605E_1807231510.addTaint(taint);
            throw var34DCCD1FCF80B922AD071CE3DF09605E_1807231510;
        } //End block
        if(value.trim().length() == 0)        
        {
            MalformedCookieException var9E0821B05EC087926FE26754E9A6E8A9_1761820162 = new MalformedCookieException("Blank value for version attribute");
            var9E0821B05EC087926FE26754E9A6E8A9_1761820162.addTaint(taint);
            throw var9E0821B05EC087926FE26754E9A6E8A9_1761820162;
        } //End block
        try 
        {
            cookie.setVersion(Integer.parseInt(value));
        } //End block
        catch (NumberFormatException e)
        {
            MalformedCookieException varD51889F56C9974850BF557D7DEBC7B9B_655484528 = new MalformedCookieException("Invalid version: " 
                + e.getMessage());
            varD51889F56C9974850BF557D7DEBC7B9B_655484528.addTaint(taint);
            throw varD51889F56C9974850BF557D7DEBC7B9B_655484528;
        } //End block
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (value == null) {
            //throw new MalformedCookieException("Missing value for version attribute");
        //}
        //if (value.trim().length() == 0) {
            //throw new MalformedCookieException("Blank value for version attribute");
        //}
        //try {
           //cookie.setVersion(Integer.parseInt(value));
        //} catch (NumberFormatException e) {
            //throw new MalformedCookieException("Invalid version: " 
                //+ e.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.130 -0400", hash_original_method = "6D2DDC2021E2B84F83821AD58F1A72CF", hash_generated_method = "36816904646311FEBDA8CA2F0D21B39F")
    @Override
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1537005428 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1537005428.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1537005428;
        } //End block
        if(cookie.getVersion() < 0)        
        {
            MalformedCookieException var7050461944FAC111CDEC8166970ACF79_1089597752 = new MalformedCookieException("Cookie version may not be negative");
            var7050461944FAC111CDEC8166970ACF79_1089597752.addTaint(taint);
            throw var7050461944FAC111CDEC8166970ACF79_1089597752;
        } //End block
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (cookie.getVersion() < 0) {
            //throw new MalformedCookieException("Cookie version may not be negative");
        //}
    }

    
}

