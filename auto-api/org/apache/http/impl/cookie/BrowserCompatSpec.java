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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.585 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.586 -0400", hash_original_method = "6F0554959345610814E9AA8C15D0E733", hash_generated_method = "FB01414D4358F515FB9F201F8E643B3E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.586 -0400", hash_original_method = "C508CCBAE435AF6EA5073D1CDD101081", hash_generated_method = "E42222EFF27A1027FCCB81D80EC19544")
    public  BrowserCompatSpec() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.591 -0400", hash_original_method = "D6912D1F98189529AD0F723836603277", hash_generated_method = "7EFEB247FC44C5F973D36C477BDE5A65")
    public List<Cookie> parse(final Header header, final CookieOrigin origin) throws MalformedCookieException {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_646855237 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_646855237 = parse(elems, origin);
        addTaint(header.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_646855237.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_646855237;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.607 -0400", hash_original_method = "A80B57E4EF4EED165A6AA62FBF374996", hash_generated_method = "95D3FC1CF5FC94BAE3CBB1E5D8BF55FA")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_1694041841 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookies may not be null");
        } //End block
        {
            boolean var054F663771300FA8A13A91F733F5D6CB_537696945 = (cookies.isEmpty());
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
            boolean varE9AF3BEAEA8CF5406F5AC5D6F9EE8F57_1710967153 = (i < cookies.size());
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
        varB4EAC82CA7396A68D541C85D26508E83_1694041841 = headers;
        addTaint(cookies.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1694041841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1694041841;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.607 -0400", hash_original_method = "F5A7F7B6DBF07E93DFA757749FB9F06B", hash_generated_method = "C81F1A691812E4A6CD01878B20DA77F3")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975480891 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975480891;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.610 -0400", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "FC3E5A060723F130C978365C59B99940")
    public Header getVersionHeader() {
        Header varB4EAC82CA7396A68D541C85D26508E83_768015412 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_768015412 = null;
        varB4EAC82CA7396A68D541C85D26508E83_768015412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_768015412;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.611 -0400", hash_original_field = "6EB8F596E5B4290D58EA6D0E959CFB4C", hash_generated_field = "07580E77A4298C6BBE845E0F387F7210")

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

