package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class NetscapeDraftSpec extends CookieSpecBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.246 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.247 -0400", hash_original_method = "9A47B9CC7B92F95BCFF768FA5CC6D454", hash_generated_method = "874522903A4C8F0A3D48F796F56235A7")
    public  NetscapeDraftSpec(final String[] datepatterns) {
        super();
        {
            this.datepatterns = datepatterns.clone();
        } 
        {
            this.datepatterns = new String[] { EXPIRES_PATTERN };
        } 
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new NetscapeDomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                this.datepatterns));
        
        
            
        
            
        
        
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.247 -0400", hash_original_method = "6C3990D1C0CF4149D1074399C8EE261A", hash_generated_method = "F26D5995B8A8A9F5B2F2F2A5E9F900D8")
    public  NetscapeDraftSpec() {
        this(null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.247 -0400", hash_original_method = "4C234501C46CBF19AFF354B62202B78D", hash_generated_method = "3ECBB252D38C6F8EE6C27509BD140925")
    public List<Cookie> parse(final Header header, final CookieOrigin origin) throws MalformedCookieException {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1551555254 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } 
        NetscapeDraftHeaderParser parser = NetscapeDraftHeaderParser.DEFAULT;
        CharArrayBuffer buffer;
        ParserCursor cursor;
        {
            buffer = ((FormattedHeader) header).getBuffer();
            cursor = new ParserCursor(
                    ((FormattedHeader) header).getValuePos(), 
                    buffer.length());
        } 
        {
            String s = header.getValue();
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Header value is null");
            } 
            buffer = new CharArrayBuffer(s.length());
            buffer.append(s);
            cursor = new ParserCursor(0, buffer.length());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1551555254 = parse(new HeaderElement[] { parser.parseHeader(buffer, cursor) }, origin);
        addTaint(header.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1551555254.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1551555254;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.250 -0400", hash_original_method = "A256F1B3B1422E7AF6F0628F304CDE1F", hash_generated_method = "B10157E6584B1FBE3C827346A0B643DE")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_85087765 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookies may not be null");
        } 
        {
            boolean var054F663771300FA8A13A91F733F5D6CB_641356580 = (cookies.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookies may not be empty");
            } 
        } 
        CharArrayBuffer buffer = new CharArrayBuffer(20 * cookies.size());
        buffer.append(SM.COOKIE);
        buffer.append(": ");
        {
            int i = 0;
            boolean varE9AF3BEAEA8CF5406F5AC5D6F9EE8F57_1668704456 = (i < cookies.size());
            {
                Cookie cookie = cookies.get(i);
                {
                    buffer.append("; ");
                } 
                buffer.append(cookie.getName());
                String s = cookie.getValue();
                {
                    buffer.append("=");
                    buffer.append(s);
                } 
            } 
        } 
        List<Header> headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
        varB4EAC82CA7396A68D541C85D26508E83_85087765 = headers;
        addTaint(cookies.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_85087765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_85087765;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.252 -0400", hash_original_method = "F5A7F7B6DBF07E93DFA757749FB9F06B", hash_generated_method = "78637125CCD795AC030598C398B6B1BE")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651176144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651176144;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.253 -0400", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "B58FC8BAD20B05254B8B5FBF5AF93390")
    public Header getVersionHeader() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1526629702 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1526629702 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1526629702.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1526629702;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.253 -0400", hash_original_field = "75C758E6AD4D039ECEF0019A9E74D3BE", hash_generated_field = "75A930ACC00C38EA525AA6DCE1798995")

    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";
}

