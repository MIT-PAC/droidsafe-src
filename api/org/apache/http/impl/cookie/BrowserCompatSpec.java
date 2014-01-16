package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

public class BrowserCompatSpec extends CookieSpecBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.844 -0500", hash_original_field = "4F30D7346FE9603EC1B9A123868D0324", hash_generated_field = "0A51A84F6A48C700CC30A9F8BE2AB7A0")

    protected static final String[] DATE_PATTERNS = new String[] {
            DateUtils.PATTERN_RFC1123,
            DateUtils.PATTERN_RFC1036,
            DateUtils.PATTERN_ASCTIME,
            "EEE, dd-MMM-yyyy HH:mm:ss z",
            "EEE, dd-MMM-yyyy HH-mm-ss z",
            "EEE, dd MMM yy HH:mm:ss z",
            "EEE dd-MMM-yyyy HH:mm:ss z",
            "EEE dd MMM yyyy HH:mm:ss z",
            "EEE dd-MMM-yyyy HH-mm-ss z",
            "EEE dd-MMM-yy HH:mm:ss z",
            "EEE dd MMM yy HH:mm:ss z",
            "EEE,dd-MMM-yy HH:mm:ss z",
            "EEE,dd-MMM-yyyy HH:mm:ss z",
            "EEE, dd-MM-yyyy HH:mm:ss z",                
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.847 -0500", hash_original_field = "6ECCC683F151EE6CE57F2B5BB3F18FF6", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private  String[] datepatterns;
    
    /** Default constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.850 -0500", hash_original_method = "6F0554959345610814E9AA8C15D0E733", hash_generated_method = "7D8D35CA9F2F06B4FCE9AD644D24968B")
    
public BrowserCompatSpec(final String[] datepatterns) {
        super();
        if (datepatterns != null) {
            this.datepatterns = datepatterns.clone();
        } else {
            this.datepatterns = DATE_PATTERNS;
        }
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new BasicDomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                this.datepatterns));
    }

    /** Default constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.853 -0500", hash_original_method = "C508CCBAE435AF6EA5073D1CDD101081", hash_generated_method = "90648FA6E43E44AA1A60F2B9ED760AA9")
    
public BrowserCompatSpec() {
        this(null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.856 -0500", hash_original_method = "D6912D1F98189529AD0F723836603277", hash_generated_method = "423FB13D3B3CCF4008E87254998EB146")
    
public List<Cookie> parse(final Header header, final CookieOrigin origin) 
            throws MalformedCookieException {
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        String headervalue = header.getValue();
        boolean isNetscapeCookie = false; 
        int i1 = headervalue.toLowerCase(Locale.ENGLISH).indexOf("expires=");
        if (i1 != -1) {
            i1 += "expires=".length();
            int i2 = headervalue.indexOf(';', i1);
            if (i2 == -1) {
                i2 = headervalue.length(); 
            }
            try {
                DateUtils.parseDate(headervalue.substring(i1, i2), this.datepatterns);
                isNetscapeCookie = true; 
            } catch (DateParseException e) {
                // Does not look like a valid expiry date
            }
        }
        HeaderElement[] elems = null;
        if (isNetscapeCookie) {
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
            elems = new HeaderElement[] { parser.parseHeader(buffer, cursor) };
        } else {
            elems = header.getElements();
        }
        return parse(elems, origin);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.859 -0500", hash_original_method = "A80B57E4EF4EED165A6AA62FBF374996", hash_generated_method = "2E0AC1ABFBAB890FFE89F47381577C85")
    
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
            buffer.append("=");
            String s = cookie.getValue();
            if (s != null) {
                buffer.append(s);
            }
        }
        List<Header> headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
        return headers;
    }

    @DSSource({DSSourceKind.BROWSER_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.861 -0500", hash_original_method = "F5A7F7B6DBF07E93DFA757749FB9F06B", hash_generated_method = "4F2143F4EC2E36A2DC294CA599F7593F")
    
public int getVersion() {
        return 0;
    }

    @DSSource({DSSourceKind.BROWSER_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.863 -0500", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "1B200382D02120253E20B1BF08CC95D3")
    
public Header getVersionHeader() {
        return null;
    }
}

