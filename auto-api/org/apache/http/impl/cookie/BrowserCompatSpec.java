package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.366 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.372 -0400", hash_original_method = "6F0554959345610814E9AA8C15D0E733", hash_generated_method = "FB01414D4358F515FB9F201F8E643B3E")
    public  BrowserCompatSpec(final String[] datepatterns) {
        super();
        {
            this.datepatterns = datepatterns.clone();
        } //End block
        {
            this.datepatterns = DATE_PATTERNS;
        } //End block
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new BasicDomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                this.datepatterns));
        // ---------- Original Method ----------
        //if (datepatterns != null) {
            //this.datepatterns = datepatterns.clone();
        //} else {
            //this.datepatterns = DATE_PATTERNS;
        //}
        //registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        //registerAttribHandler(ClientCookie.DOMAIN_ATTR, new BasicDomainHandler());
        //registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        //registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        //registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        //registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                //this.datepatterns));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.373 -0400", hash_original_method = "C508CCBAE435AF6EA5073D1CDD101081", hash_generated_method = "E42222EFF27A1027FCCB81D80EC19544")
    public  BrowserCompatSpec() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.375 -0400", hash_original_method = "D6912D1F98189529AD0F723836603277", hash_generated_method = "EB7769CF39892F05C867232C489C4ED7")
    public List<Cookie> parse(final Header header, final CookieOrigin origin) throws MalformedCookieException {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1274028229 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        String headervalue;
        headervalue = header.getValue();
        boolean isNetscapeCookie;
        isNetscapeCookie = false;
        int i1;
        i1 = headervalue.toLowerCase(Locale.ENGLISH).indexOf("expires=");
        {
            i1 += "expires=".length();
            int i2;
            i2 = headervalue.indexOf(';', i1);
            {
                i2 = headervalue.length();
            } //End block
            try 
            {
                DateUtils.parseDate(headervalue.substring(i1, i2), this.datepatterns);
                isNetscapeCookie = true;
            } //End block
            catch (DateParseException e)
            { }
        } //End block
        HeaderElement[] elems;
        elems = null;
        {
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
            elems = new HeaderElement[] { parser.parseHeader(buffer, cursor) };
        } //End block
        {
            elems = header.getElements();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1274028229 = parse(elems, origin);
        addTaint(header.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1274028229.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1274028229;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.386 -0400", hash_original_method = "A80B57E4EF4EED165A6AA62FBF374996", hash_generated_method = "BC742D0EDB0E5CDEE802C7AD1ED7801A")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_326646399 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookies may not be null");
        } //End block
        {
            boolean var054F663771300FA8A13A91F733F5D6CB_1963398981 = (cookies.isEmpty());
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
            boolean varE9AF3BEAEA8CF5406F5AC5D6F9EE8F57_1623110805 = (i < cookies.size());
            {
                Cookie cookie;
                cookie = cookies.get(i);
                {
                    buffer.append("; ");
                } //End block
                buffer.append(cookie.getName());
                buffer.append("=");
                String s;
                s = cookie.getValue();
                {
                    buffer.append(s);
                } //End block
            } //End block
        } //End collapsed parenthetic
        List<Header> headers;
        headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
        varB4EAC82CA7396A68D541C85D26508E83_326646399 = headers;
        addTaint(cookies.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_326646399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_326646399;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.392 -0400", hash_original_method = "F5A7F7B6DBF07E93DFA757749FB9F06B", hash_generated_method = "63F002BAACAF5A36C7EE7EAECBEC4C58")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876714300 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_876714300;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.393 -0400", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "2AAE7FDE69927615DB90D0C8ACFAE67B")
    public Header getVersionHeader() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1024273773 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1024273773 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1024273773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1024273773;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.397 -0400", hash_original_field = "6EB8F596E5B4290D58EA6D0E959CFB4C", hash_generated_field = "07580E77A4298C6BBE845E0F387F7210")

    protected static String[] DATE_PATTERNS = new String[] {
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
}

