package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookiePathComparator;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;

public class RFC2109Spec extends CookieSpecBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.384 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.384 -0400", hash_original_field = "1DC8E1B30B1B1279E15BB73B4101C43C", hash_generated_field = "E82ADEB303AC7BD75F069F4A1A160C67")

    private boolean oneHeader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.385 -0400", hash_original_method = "12A896738D34FDBE49C7AA7970841F81", hash_generated_method = "D7DE38ED26DC8EB30BFCFDCF88C9677C")
    public  RFC2109Spec(final String[] datepatterns, boolean oneHeader) {
        super();
        {
            this.datepatterns = datepatterns.clone();
        } //End block
        {
            this.datepatterns = DATE_PATTERNS;
        } //End block
        this.oneHeader = oneHeader;
        registerAttribHandler(ClientCookie.VERSION_ATTR, new RFC2109VersionHandler());
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new RFC2109DomainHandler());
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
        //this.oneHeader = oneHeader;
        //registerAttribHandler(ClientCookie.VERSION_ATTR, new RFC2109VersionHandler());
        //registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        //registerAttribHandler(ClientCookie.DOMAIN_ATTR, new RFC2109DomainHandler());
        //registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        //registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        //registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        //registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                //this.datepatterns));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.385 -0400", hash_original_method = "2854FB63A9A4FFE7625656D05E6D284B", hash_generated_method = "704B85C0725CE4A0C7BEC650B2E2F3CA")
    public  RFC2109Spec() {
        this(null, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.385 -0400", hash_original_method = "FE34B3C1E0CEB3E28830FDDDCE3EDCF4", hash_generated_method = "004129927B68BBC710475FF633C7E7BF")
    public List<Cookie> parse(final Header header, final CookieOrigin origin) throws MalformedCookieException {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_70552819 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        HeaderElement[] elems = header.getElements();
        varB4EAC82CA7396A68D541C85D26508E83_70552819 = parse(elems, origin);
        addTaint(header.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_70552819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_70552819;
        // ---------- Original Method ----------
        //if (header == null) {
            //throw new IllegalArgumentException("Header may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //HeaderElement[] elems = header.getElements();
        //return parse(elems, origin);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.386 -0400", hash_original_method = "FA8C9B830274A9DE10C31E9A8EA08163", hash_generated_method = "FB372BA4013A1C0972F5CBEFF2E7E9FA")
    @Override
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        String name = cookie.getName();
        {
            boolean varA47AE230FA2441FAC1468DEEF8EA4F22_1356132256 = (name.indexOf(' ') != -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Cookie name may not contain blanks");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFB51076FD2D8FE23400518D8B942E47F_38330930 = (name.startsWith("$"));
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Cookie name may not start with $");
            } //End block
        } //End collapsed parenthetic
        super.validate(cookie, origin);
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //String name = cookie.getName();
        //if (name.indexOf(' ') != -1) {
            //throw new MalformedCookieException("Cookie name may not contain blanks");
        //}
        //if (name.startsWith("$")) {
            //throw new MalformedCookieException("Cookie name may not start with $");
        //}
        //super.validate(cookie, origin);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.386 -0400", hash_original_method = "67F48779D521683257B0CC0E930A401A", hash_generated_method = "54CF64545C6727179EC8762E99A5F4FB")
    public List<Header> formatCookies(List<Cookie> cookies) {
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_601917426 = null; //Variable for return #1
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_1163527933 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookies may not be null");
        } //End block
        {
            boolean var054F663771300FA8A13A91F733F5D6CB_907838151 = (cookies.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookies may not be empty");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var054A148BA3E0A5CADFBB0495A82A778D_748874821 = (cookies.size() > 1);
            {
                cookies = new ArrayList<Cookie>(cookies);
                Collections.sort(cookies, PATH_COMPARATOR);
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_601917426 = doFormatOneHeader(cookies);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1163527933 = doFormatManyHeaders(cookies);
        } //End block
        addTaint(cookies.getTaint());
        List<Header> varA7E53CE21691AB073D9660D615818899_930306545; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_930306545 = varB4EAC82CA7396A68D541C85D26508E83_601917426;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_930306545 = varB4EAC82CA7396A68D541C85D26508E83_1163527933;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_930306545.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_930306545;
        // ---------- Original Method ----------
        //if (cookies == null) {
            //throw new IllegalArgumentException("List of cookies may not be null");
        //}
        //if (cookies.isEmpty()) {
            //throw new IllegalArgumentException("List of cookies may not be empty");
        //}
        //if (cookies.size() > 1) {
            //cookies = new ArrayList<Cookie>(cookies);
            //Collections.sort(cookies, PATH_COMPARATOR);
        //}
        //if (this.oneHeader) {
            //return doFormatOneHeader(cookies);
        //} else {
            //return doFormatManyHeaders(cookies);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.391 -0400", hash_original_method = "13FFFC492D1247BC18ED6817446ED518", hash_generated_method = "03DDA2BD5669CAD975BF12156670BFFF")
    private List<Header> doFormatOneHeader(final List<Cookie> cookies) {
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_1248234569 = null; //Variable for return #1
        int version = Integer.MAX_VALUE;
        {
            Iterator<Cookie> var122FD713E52C825D20E0B3FA83D127D8_328883484 = (cookies).iterator();
            var122FD713E52C825D20E0B3FA83D127D8_328883484.hasNext();
            Cookie cookie = var122FD713E52C825D20E0B3FA83D127D8_328883484.next();
            {
                {
                    boolean varC06D11AB8DE40C0800CE09D6D4EEFC3D_1640828581 = (cookie.getVersion() < version);
                    {
                        version = cookie.getVersion();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        CharArrayBuffer buffer = new CharArrayBuffer(40 * cookies.size());
        buffer.append(SM.COOKIE);
        buffer.append(": ");
        buffer.append("$Version=");
        buffer.append(Integer.toString(version));
        {
            Iterator<Cookie> varE008217F2893EAE5CBB37F8BD5F325EC_144735133 = (cookies).iterator();
            varE008217F2893EAE5CBB37F8BD5F325EC_144735133.hasNext();
            Cookie cooky = varE008217F2893EAE5CBB37F8BD5F325EC_144735133.next();
            {
                buffer.append("; ");
                Cookie cookie = cooky;
                formatCookieAsVer(buffer, cookie, version);
            } //End block
        } //End collapsed parenthetic
        List<Header> headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
        varB4EAC82CA7396A68D541C85D26508E83_1248234569 = headers;
        addTaint(cookies.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1248234569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1248234569;
        // ---------- Original Method ----------
        //int version = Integer.MAX_VALUE;
        //for (Cookie cookie : cookies) {
            //if (cookie.getVersion() < version) {
                //version = cookie.getVersion();
            //}
        //}
        //CharArrayBuffer buffer = new CharArrayBuffer(40 * cookies.size());
        //buffer.append(SM.COOKIE);
        //buffer.append(": ");
        //buffer.append("$Version=");
        //buffer.append(Integer.toString(version));
        //for (Cookie cooky : cookies) {
            //buffer.append("; ");
            //Cookie cookie = cooky;
            //formatCookieAsVer(buffer, cookie, version);
        //}
        //List<Header> headers = new ArrayList<Header>(1);
        //headers.add(new BufferedHeader(buffer));
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.392 -0400", hash_original_method = "8AE6C62AD6B7A2305FE4DC1EC3AC9430", hash_generated_method = "4A9A685D8449AD9135800F85FA823593")
    private List<Header> doFormatManyHeaders(final List<Cookie> cookies) {
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_1244531442 = null; //Variable for return #1
        List<Header> headers = new ArrayList<Header>(cookies.size());
        {
            Iterator<Cookie> var122FD713E52C825D20E0B3FA83D127D8_351365818 = (cookies).iterator();
            var122FD713E52C825D20E0B3FA83D127D8_351365818.hasNext();
            Cookie cookie = var122FD713E52C825D20E0B3FA83D127D8_351365818.next();
            {
                int version = cookie.getVersion();
                CharArrayBuffer buffer = new CharArrayBuffer(40);
                buffer.append("Cookie: ");
                buffer.append("$Version=");
                buffer.append(Integer.toString(version));
                buffer.append("; ");
                formatCookieAsVer(buffer, cookie, version);
                headers.add(new BufferedHeader(buffer));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1244531442 = headers;
        addTaint(cookies.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1244531442.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1244531442;
        // ---------- Original Method ----------
        //List<Header> headers = new ArrayList<Header>(cookies.size());
        //for (Cookie cookie : cookies) {
            //int version = cookie.getVersion();
            //CharArrayBuffer buffer = new CharArrayBuffer(40);
            //buffer.append("Cookie: ");
            //buffer.append("$Version=");
            //buffer.append(Integer.toString(version));
            //buffer.append("; ");
            //formatCookieAsVer(buffer, cookie, version);
            //headers.add(new BufferedHeader(buffer));
        //}
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.393 -0400", hash_original_method = "06F97D44B0AB130D85C55056AFD5C23B", hash_generated_method = "530A0F7E9FFDFE4615563C530E2C499C")
    protected void formatParamAsVer(final CharArrayBuffer buffer, 
            final String name, final String value, int version) {
        buffer.append(name);
        buffer.append("=");
        {
            {
                buffer.append('\"');
                buffer.append(value);
                buffer.append('\"');
            } //End block
            {
                buffer.append(value);
            } //End block
        } //End block
        addTaint(buffer.getTaint());
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        addTaint(version);
        // ---------- Original Method ----------
        //buffer.append(name);
        //buffer.append("=");
        //if (value != null) {
            //if (version > 0) {
                //buffer.append('\"');
                //buffer.append(value);
                //buffer.append('\"');
            //} else {
                //buffer.append(value);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.394 -0400", hash_original_method = "FCDC82ACC7F918D2268FA007BF779A17", hash_generated_method = "7D9259E409971829FB41C7ABF5A03429")
    protected void formatCookieAsVer(final CharArrayBuffer buffer, 
            final Cookie cookie, int version) {
        formatParamAsVer(buffer, cookie.getName(), cookie.getValue(), version);
        {
            boolean varB3B21D8027E3D75C2B690F9E379BC53C_295611329 = (cookie.getPath() != null);
            {
                {
                    boolean var648F670470B1F1D8F3C586A7C8C2A061_1916121767 = (cookie instanceof ClientCookie 
                    && ((ClientCookie) cookie).containsAttribute(ClientCookie.PATH_ATTR));
                    {
                        buffer.append("; ");
                        formatParamAsVer(buffer, "$Path", cookie.getPath(), version);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE610F1220ED23C08C43E52A8AECD8DEC_226573777 = (cookie.getDomain() != null);
            {
                {
                    boolean var4EE6B03A9B7367CB9BCF22A0992E55B2_19553654 = (cookie instanceof ClientCookie 
                    && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR));
                    {
                        buffer.append("; ");
                        formatParamAsVer(buffer, "$Domain", cookie.getDomain(), version);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer.getTaint());
        addTaint(cookie.getTaint());
        addTaint(version);
        // ---------- Original Method ----------
        //formatParamAsVer(buffer, cookie.getName(), cookie.getValue(), version);
        //if (cookie.getPath() != null) {
            //if (cookie instanceof ClientCookie 
                    //&& ((ClientCookie) cookie).containsAttribute(ClientCookie.PATH_ATTR)) {
                //buffer.append("; ");
                //formatParamAsVer(buffer, "$Path", cookie.getPath(), version);
            //}
        //}
        //if (cookie.getDomain() != null) {
            //if (cookie instanceof ClientCookie 
                    //&& ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR)) {
                //buffer.append("; ");
                //formatParamAsVer(buffer, "$Domain", cookie.getDomain(), version);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.394 -0400", hash_original_method = "48398E54A721F2ABBD2AD2C5ED75FBF5", hash_generated_method = "C9F2B974DDADA2FD24D211E7CDB83EE3")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076605137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076605137;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.395 -0400", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "8E3C28CEBB2AF3F97D042463A381ADBF")
    public Header getVersionHeader() {
        Header varB4EAC82CA7396A68D541C85D26508E83_234751376 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_234751376 = null;
        varB4EAC82CA7396A68D541C85D26508E83_234751376.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_234751376;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.395 -0400", hash_original_field = "ABFA51F6E4B6F45C0F10C82A927D071D", hash_generated_field = "858B7D4610C97949773EF50E93F05188")

    private final static CookiePathComparator PATH_COMPARATOR = new CookiePathComparator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.395 -0400", hash_original_field = "E3CDA0E427D73051E5F5FE32B9272277", hash_generated_field = "FBD8DD687539DFF4AAFA7EAA45AC1BE6")

    private final static String[] DATE_PATTERNS = {
        DateUtils.PATTERN_RFC1123,
        DateUtils.PATTERN_RFC1036,
        DateUtils.PATTERN_ASCTIME 
    };
}

