package org.apache.http.client.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HttpContext;

public class ResponseProcessCookies implements HttpResponseInterceptor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.949 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.950 -0400", hash_original_method = "4D600FAEAE45D81498CB22DB2E88FC55", hash_generated_method = "24DEF7D8C332AA18A2A34FD1AC38543A")
    public  ResponseProcessCookies() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.950 -0400", hash_original_method = "DEAF5EA61A5D1778D6CCA56F636FFAFD", hash_generated_method = "D02F6F82AC73128B4F09454D6B63CC3D")
    public void process(final HttpResponse response, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } 
        CookieStore cookieStore = (CookieStore) context.getAttribute(
                ClientContext.COOKIE_STORE);
        {
            this.log.info("Cookie store not available in HTTP context");
        } 
        CookieSpec cookieSpec = (CookieSpec) context.getAttribute(
                ClientContext.COOKIE_SPEC);
        {
            this.log.info("CookieSpec not available in HTTP context");
        } 
        CookieOrigin cookieOrigin = (CookieOrigin) context.getAttribute(
                ClientContext.COOKIE_ORIGIN);
        {
            this.log.info("CookieOrigin not available in HTTP context");
        } 
        HeaderIterator it = response.headerIterator(SM.SET_COOKIE);
        processCookies(it, cookieSpec, cookieOrigin, cookieStore);
        {
            boolean var2A413FC23D37E9130A24B941ADD873A1_1607137463 = (cookieSpec.getVersion() > 0);
            {
                it = response.headerIterator(SM.SET_COOKIE2);
                processCookies(it, cookieSpec, cookieOrigin, cookieStore);
            } 
        } 
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.960 -0400", hash_original_method = "91DFC6E3C42B7F0C9ED2CF0B4905D6AD", hash_generated_method = "E12FD2FDA318A34A2761138B404E87E1")
    private void processCookies(
            final HeaderIterator iterator, 
            final CookieSpec cookieSpec,
            final CookieOrigin cookieOrigin,
            final CookieStore cookieStore) {
        {
            boolean var15F7FE2AD7E10C613CA4B915023EF041_1129713640 = (iterator.hasNext());
            {
                Header header = iterator.nextHeader();
                try 
                {
                    List<Cookie> cookies = cookieSpec.parse(header, cookieOrigin);
                    {
                        Iterator<Cookie> var122FD713E52C825D20E0B3FA83D127D8_989703613 = (cookies).iterator();
                        var122FD713E52C825D20E0B3FA83D127D8_989703613.hasNext();
                        Cookie cookie = var122FD713E52C825D20E0B3FA83D127D8_989703613.next();
                        {
                            try 
                            {
                                cookieSpec.validate(cookie, cookieOrigin);
                                cookieStore.addCookie(cookie);
                                {
                                    boolean var3DF9FAF67937974C7A395023CF7157D0_1251309860 = (this.log.isDebugEnabled());
                                    {
                                        this.log.debug("Cookie accepted: \""
                                    + cookieToString(cookie) + "\". ");
                                    } 
                                } 
                            } 
                            catch (MalformedCookieException ex)
                            {
                                {
                                    boolean var98AE6279036784B25F38A97DC5F00031_2113360529 = (this.log.isWarnEnabled());
                                    {
                                        this.log.warn("Cookie rejected: \""
                                    + cookieToString(cookie) + "\". " + ex.getMessage());
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                catch (MalformedCookieException ex)
                {
                    {
                        boolean varD29FD34C323BA0A83865093467758E81_853545640 = (this.log.isWarnEnabled());
                        {
                            this.log.warn("Invalid cookie header: \""
                            + header + "\". " + ex.getMessage());
                        } 
                    } 
                } 
            } 
        } 
        addTaint(iterator.getTaint());
        addTaint(cookieSpec.getTaint());
        addTaint(cookieOrigin.getTaint());
        addTaint(cookieStore.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.961 -0400", hash_original_method = "7F26B81C9250A7120577E4D4C011F353", hash_generated_method = "8C3FB63A0C9317BC76307D342E454818")
    private String cookieToString(Cookie cookie) {
        String varB4EAC82CA7396A68D541C85D26508E83_568111336 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_568111336 = cookie.getClass().getSimpleName()
                + "[version=" + cookie.getVersion()
                + ",name=" + cookie.getName()
                + ",domain=" + cookie.getDomain()
                + ",path=" + cookie.getPath()
                + ",expiry=" + cookie.getExpiryDate()
                + "]";
        addTaint(cookie.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_568111336.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_568111336;
        
        
                
                
                
                
                
                
    }

    
}

