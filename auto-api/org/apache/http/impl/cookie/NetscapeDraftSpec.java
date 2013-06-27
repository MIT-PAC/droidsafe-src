package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.703 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.704 -0400", hash_original_method = "9A47B9CC7B92F95BCFF768FA5CC6D454", hash_generated_method = "874522903A4C8F0A3D48F796F56235A7")
    public  NetscapeDraftSpec(final String[] datepatterns) {
        super();
        {
            this.datepatterns = datepatterns.clone();
        } //End block
        {
            this.datepatterns = new String[] { EXPIRES_PATTERN };
        } //End block
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new NetscapeDomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                this.datepatterns));
        // ---------- Original Method ----------
        //if (datepatterns != null) {
            //this.datepatterns = datepatterns.clone();
        //} else {
            //this.datepatterns = new String[] { EXPIRES_PATTERN };
        //}
        //registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        //registerAttribHandler(ClientCookie.DOMAIN_ATTR, new NetscapeDomainHandler());
        //registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        //registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        //registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        //registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                //this.datepatterns));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.712 -0400", hash_original_method = "6C3990D1C0CF4149D1074399C8EE261A", hash_generated_method = "F26D5995B8A8A9F5B2F2F2A5E9F900D8")
    public  NetscapeDraftSpec() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.714 -0400", hash_original_method = "4C234501C46CBF19AFF354B62202B78D", hash_generated_method = "4B38B707C17C2A21ED970283BB07DF13")
    public List<Cookie> parse(final Header header, final CookieOrigin origin) throws MalformedCookieException {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_123774548 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        NetscapeDraftHeaderParser parser;
        parser = NetscapeDraftHeaderParser.DEFAULT;
        CharArrayBuffer buffer;
        ParserCursor cursor;
        {
            buffer = ((FormattedHeader) header).getBuffer();
            cursor = new ParserCursor(
                    ((FormattedHeader) header).getValuePos(), 
                    buffer.length());
        } //End block
        {
            String s;
            s = header.getValue();
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Header value is null");
            } //End block
            buffer = new CharArrayBuffer(s.length());
            buffer.append(s);
            cursor = new ParserCursor(0, buffer.length());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_123774548 = parse(new HeaderElement[] { parser.parseHeader(buffer, cursor) }, origin);
        addTaint(header.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_123774548.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_123774548;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.728 -0400", hash_original_method = "A256F1B3B1422E7AF6F0628F304CDE1F", hash_generated_method = "FC3D53D3384C6181810D01064CB2C1DE")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_946277267 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookies may not be null");
        } //End block
        {
            boolean var054F663771300FA8A13A91F733F5D6CB_786284900 = (cookies.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookies may not be empty");
            } //End block
        } //End collapsed parenthetic
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(20 * cookies.size());
        buffer.append(SM.COOKIE);
        buffer.append(": ");
        {
            int i;
            i = 0;
            boolean varE9AF3BEAEA8CF5406F5AC5D6F9EE8F57_982064863 = (i < cookies.size());
            {
                Cookie cookie;
                cookie = cookies.get(i);
                {
                    buffer.append("; ");
                } //End block
                buffer.append(cookie.getName());
                String s;
                s = cookie.getValue();
                {
                    buffer.append("=");
                    buffer.append(s);
                } //End block
            } //End block
        } //End collapsed parenthetic
        List<Header> headers;
        headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
        varB4EAC82CA7396A68D541C85D26508E83_946277267 = headers;
        addTaint(cookies.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_946277267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946277267;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.728 -0400", hash_original_method = "F5A7F7B6DBF07E93DFA757749FB9F06B", hash_generated_method = "E14C86351B45C2C20BFC4CA8BCC861F0")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1741305306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1741305306;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.729 -0400", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "F0C863CC76BF73443162D379FA61A1C7")
    public Header getVersionHeader() {
        Header varB4EAC82CA7396A68D541C85D26508E83_574233409 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_574233409 = null;
        varB4EAC82CA7396A68D541C85D26508E83_574233409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_574233409;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.729 -0400", hash_original_field = "75C758E6AD4D039ECEF0019A9E74D3BE", hash_generated_field = "AE88123C2C84444ACAAE9EB976A983A0")

    protected static String EXPIRES_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";
}

