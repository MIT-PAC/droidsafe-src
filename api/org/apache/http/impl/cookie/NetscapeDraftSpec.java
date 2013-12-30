package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.709 -0500", hash_original_field = "58B1B294299E8BE67E1770D5041C7BC1", hash_generated_field = "75A930ACC00C38EA525AA6DCE1798995")


    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.712 -0500", hash_original_field = "6ECCC683F151EE6CE57F2B5BB3F18FF6", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    
    private  String[] datepatterns; 
    
    /** Default constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.715 -0500", hash_original_method = "9A47B9CC7B92F95BCFF768FA5CC6D454", hash_generated_method = "41DF984CF2CD34095E4F4DDB90CA83E8")
    
public NetscapeDraftSpec(final String[] datepatterns) {
        super();
        if (datepatterns != null) {
            this.datepatterns = datepatterns.clone();
        } else {
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

    /** Default constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.717 -0500", hash_original_method = "6C3990D1C0CF4149D1074399C8EE261A", hash_generated_method = "5B163E0752DF35376C5CABAC764B2B58")
    
public NetscapeDraftSpec() {
        this(null);
    }
    
    /**
      * Parses the Set-Cookie value into an array of <tt>Cookie</tt>s.
      *
      * <p>Syntax of the Set-Cookie HTTP Response Header:</p>
      * 
      * <p>This is the format a CGI script would use to add to 
      * the HTTP headers a new piece of data which is to be stored by 
      * the client for later retrieval.</p>
      *  
      * <PRE>
      *  Set-Cookie: NAME=VALUE; expires=DATE; path=PATH; domain=DOMAIN_NAME; secure
      * </PRE>
      *
      * <p>Please note that Netscape draft specification does not fully 
      * conform to the HTTP header format. Netscape draft does not specify 
      * whether multiple cookies may be sent in one header. Hence, comma 
      * character may be present in unquoted cookie value or unquoted 
      * parameter value.</p>
      * 
      * @see <a href="http://wp.netscape.com/newsref/std/cookie_spec.html">
      *  The Cookie Spec.</a>
      *
      * @param header the <tt>Set-Cookie</tt> received from the server
      * @return an array of <tt>Cookie</tt>s parsed from the Set-Cookie value
      * @throws MalformedCookieException if an exception occurs during parsing
      */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.720 -0500", hash_original_method = "4C234501C46CBF19AFF354B62202B78D", hash_generated_method = "CD0E8E2F59AC2669FD1A64098554D833")
    
public List<Cookie> parse(final Header header, final CookieOrigin origin) 
            throws MalformedCookieException {
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        NetscapeDraftHeaderParser parser = NetscapeDraftHeaderParser.DEFAULT;
        CharArrayBuffer buffer;
        ParserCursor cursor;
        if (header instanceof FormattedHeader) {
            buffer = ((FormattedHeader) header).getBuffer();
            cursor = new ParserCursor(
                    ((FormattedHeader) header).getValuePos(), 
                    buffer.length());
        } else {
            String s = header.getValue();
            if (s == null) {
                throw new MalformedCookieException("Header value is null");
            }
            buffer = new CharArrayBuffer(s.length());
            buffer.append(s);
            cursor = new ParserCursor(0, buffer.length());
        }
        return parse(new HeaderElement[] { parser.parseHeader(buffer, cursor) }, origin);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.722 -0500", hash_original_method = "A256F1B3B1422E7AF6F0628F304CDE1F", hash_generated_method = "DC03863846FF9DF6A7D7A324BEF7C4EE")
    
public List<Header> formatCookies(final List<Cookie> cookies) {
        if (cookies == null) {
            throw new IllegalArgumentException("List of cookies may not be null");
        }
        if (cookies.isEmpty()) {
            throw new IllegalArgumentException("List of cookies may not be empty");
        }
        CharArrayBuffer buffer = new CharArrayBuffer(20 * cookies.size());
        buffer.append(SM.COOKIE);
        buffer.append(": ");
        for (int i = 0; i < cookies.size(); i++) {
            Cookie cookie = cookies.get(i);
            if (i > 0) {
                buffer.append("; ");
            }
            buffer.append(cookie.getName());
            String s = cookie.getValue();
            if (s != null) {
                buffer.append("=");
                buffer.append(s);
            }
        }
        List<Header> headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
        return headers;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.725 -0500", hash_original_method = "F5A7F7B6DBF07E93DFA757749FB9F06B", hash_generated_method = "4F2143F4EC2E36A2DC294CA599F7593F")
    
public int getVersion() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.727 -0500", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "1B200382D02120253E20B1BF08CC95D3")
    
public Header getVersionHeader() {
        return null;
    }
}

