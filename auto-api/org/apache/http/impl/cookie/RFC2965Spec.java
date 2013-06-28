package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;

public class RFC2965Spec extends RFC2109Spec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.495 -0400", hash_original_method = "0C9AFF04E5BAABEBA18893034F65C0B5", hash_generated_method = "ED8461C5C758500E2E57B09EC8299F41")
    public  RFC2965Spec() {
        this(null, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.496 -0400", hash_original_method = "ACE780060B747E0E2CD86A0260ED3969", hash_generated_method = "949480FDE45EA50307EAFAD969F9B712")
    public  RFC2965Spec(final String[] datepatterns, boolean oneHeader) {
        super(datepatterns, oneHeader);
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new RFC2965DomainAttributeHandler());
        registerAttribHandler(ClientCookie.PORT_ATTR, new RFC2965PortAttributeHandler());
        registerAttribHandler(ClientCookie.COMMENTURL_ATTR, new RFC2965CommentUrlAttributeHandler());
        registerAttribHandler(ClientCookie.DISCARD_ATTR, new RFC2965DiscardAttributeHandler());
        registerAttribHandler(ClientCookie.VERSION_ATTR, new RFC2965VersionAttributeHandler());
        addTaint(datepatterns[0].getTaint());
        addTaint(oneHeader);
        // ---------- Original Method ----------
        //registerAttribHandler(ClientCookie.DOMAIN_ATTR, new RFC2965DomainAttributeHandler());
        //registerAttribHandler(ClientCookie.PORT_ATTR, new RFC2965PortAttributeHandler());
        //registerAttribHandler(ClientCookie.COMMENTURL_ATTR, new RFC2965CommentUrlAttributeHandler());
        //registerAttribHandler(ClientCookie.DISCARD_ATTR, new RFC2965DiscardAttributeHandler());
        //registerAttribHandler(ClientCookie.VERSION_ATTR, new RFC2965VersionAttributeHandler());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.496 -0400", hash_original_method = "4409F0FE45DA6FEDE61567597482D361", hash_generated_method = "870520A37E59E6363D426056AB638B05")
    private BasicClientCookie createCookie(
            final String name, final String value, final CookieOrigin origin) {
        BasicClientCookie varB4EAC82CA7396A68D541C85D26508E83_784779668 = null; //Variable for return #1
        BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setPath(getDefaultPath(origin));
        cookie.setDomain(getDefaultDomain(origin));
        varB4EAC82CA7396A68D541C85D26508E83_784779668 = cookie;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_784779668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_784779668;
        // ---------- Original Method ----------
        //BasicClientCookie cookie = new BasicClientCookie(name, value);
        //cookie.setPath(getDefaultPath(origin));
        //cookie.setDomain(getDefaultDomain(origin));
        //return cookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.497 -0400", hash_original_method = "C203D6CC66BEDFCF9DF77F8143966D25", hash_generated_method = "D2B25DDC4CD0FC0E618BD11FFFDB013F")
    private BasicClientCookie createCookie2(
            final String name, final String value, final CookieOrigin origin) {
        BasicClientCookie varB4EAC82CA7396A68D541C85D26508E83_1608804050 = null; //Variable for return #1
        BasicClientCookie2 cookie = new BasicClientCookie2(name, value);
        cookie.setPath(getDefaultPath(origin));
        cookie.setDomain(getDefaultDomain(origin));
        cookie.setPorts(new int [] { origin.getPort() });
        varB4EAC82CA7396A68D541C85D26508E83_1608804050 = cookie;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1608804050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1608804050;
        // ---------- Original Method ----------
        //BasicClientCookie2 cookie = new BasicClientCookie2(name, value);
        //cookie.setPath(getDefaultPath(origin));
        //cookie.setDomain(getDefaultDomain(origin));
        //cookie.setPorts(new int [] { origin.getPort() });
        //return cookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.501 -0400", hash_original_method = "63E6AFA36A40CA79A5C09930028E525A", hash_generated_method = "7A1D832F6543BDA375B41ED7B12FF502")
    @Override
    public List<Cookie> parse(
            final Header header, 
            CookieOrigin origin) throws MalformedCookieException {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1728093860 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        origin = adjustEffectiveHost(origin);
        HeaderElement[] elems = header.getElements();
        List<Cookie> cookies = new ArrayList<Cookie>(elems.length);
        {
            Iterator<HeaderElement> var64E4248F3E9583EF9C3B3FA1CE66BA8F_678914486 = (elems).iterator();
            var64E4248F3E9583EF9C3B3FA1CE66BA8F_678914486.hasNext();
            HeaderElement headerelement = var64E4248F3E9583EF9C3B3FA1CE66BA8F_678914486.next();
            {
                String name = headerelement.getName();
                String value = headerelement.getValue();
                {
                    boolean var4461637DABA130E2A1B9BDCB33E9CE15_1407052474 = (name == null || name.length() == 0);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Cookie name may not be empty");
                    } //End block
                } //End collapsed parenthetic
                BasicClientCookie cookie;
                {
                    boolean var6AAE77C4B9E15A12E99793AA7DBB24FF_1570857165 = (header.getName().equals(SM.SET_COOKIE2));
                    {
                        cookie = createCookie2(name, value, origin);
                    } //End block
                    {
                        cookie = createCookie(name, value, origin);
                    } //End block
                } //End collapsed parenthetic
                NameValuePair[] attribs = headerelement.getParameters();
                Map<String, NameValuePair> attribmap = new HashMap<String, NameValuePair>(attribs.length);
                {
                    int j = attribs.length - 1;
                    {
                        NameValuePair param = attribs[j];
                        attribmap.put(param.getName().toLowerCase(Locale.ENGLISH), param);
                    } //End block
                } //End collapsed parenthetic
                {
                    Iterator<Map.Entry<String, NameValuePair>> var31E344CB7BBCC0B9BB8B4730C2B3AB1B_1363022324 = (attribmap.entrySet()).iterator();
                    var31E344CB7BBCC0B9BB8B4730C2B3AB1B_1363022324.hasNext();
                    Map.Entry<String, NameValuePair> entry = var31E344CB7BBCC0B9BB8B4730C2B3AB1B_1363022324.next();
                    {
                        NameValuePair attrib = entry.getValue();
                        String s = attrib.getName().toLowerCase(Locale.ENGLISH);
                        cookie.setAttribute(s, attrib.getValue());
                        CookieAttributeHandler handler = findAttribHandler(s);
                        {
                            handler.parse(cookie, attrib.getValue());
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                cookies.add(cookie);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1728093860 = cookies;
        addTaint(header.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1728093860.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1728093860;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.502 -0400", hash_original_method = "67EA3E91E653DB3E455D1CE08BD1E58C", hash_generated_method = "6DAEEE5A57DA55FF7C8331C27469CFC9")
    @Override
    public void validate(final Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        origin = adjustEffectiveHost(origin);
        super.validate(cookie, origin);
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //origin = adjustEffectiveHost(origin);
        //super.validate(cookie, origin);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.502 -0400", hash_original_method = "6825BB2CF6533B26EC949D0ED0CB3EFF", hash_generated_method = "B9038B11BB895A6237BE62D39F47179D")
    @Override
    public boolean match(final Cookie cookie, CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        origin = adjustEffectiveHost(origin);
        boolean var4646C80192E3B5F87999DDAAB5D6A6A4_829891725 = (super.match(cookie, origin));
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1293079565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1293079565;
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //origin = adjustEffectiveHost(origin);
        //return super.match(cookie, origin);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.503 -0400", hash_original_method = "BB37CE4D8DBA00C0591EE6D75240E9EE", hash_generated_method = "05B0961D312990045F1E01186A2CC54B")
    @Override
    protected void formatCookieAsVer(final CharArrayBuffer buffer, 
            final Cookie cookie, int version) {
        super.formatCookieAsVer(buffer, cookie, version);
        {
            String s = ((ClientCookie) cookie).getAttribute(ClientCookie.PORT_ATTR);
            {
                buffer.append("; $Port");
                buffer.append("=\"");
                {
                    boolean var581DBC2523087AD4616EE4691A0BEDAF_1715586788 = (s.trim().length() > 0);
                    {
                        int[] ports = cookie.getPorts();
                        {
                            {
                                int i = 0;
                                int len = ports.length;
                                {
                                    {
                                        buffer.append(",");
                                    } //End block
                                    buffer.append(Integer.toString(ports[i]));
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                buffer.append("\"");
            } //End block
        } //End block
        addTaint(buffer.getTaint());
        addTaint(cookie.getTaint());
        addTaint(version);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static CookieOrigin adjustEffectiveHost(final CookieOrigin origin) {
        String host = origin.getHost();
        boolean isLocalHost = true;
        for (int i = 0; i < host.length(); i++) {
            char ch = host.charAt(i);
            if (ch == '.' || ch == ':') {
                isLocalHost = false;
                break;
            }
        }
        if (isLocalHost) {
            host += ".local";
            return new CookieOrigin(
                    host, 
                    origin.getPort(), 
                    origin.getPath(), 
                    origin.isSecure());
        } else {
            return origin;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.503 -0400", hash_original_method = "48398E54A721F2ABBD2AD2C5ED75FBF5", hash_generated_method = "2C19428A78044BCEA1DF839955B3D13F")
    @Override
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900821254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900821254;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.504 -0400", hash_original_method = "135D9D751A7E49D965B3B7FE1A189F11", hash_generated_method = "F3D73CCFD16B539E7A27503C081D5C74")
    @Override
    public Header getVersionHeader() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1073416693 = null; //Variable for return #1
        CharArrayBuffer buffer = new CharArrayBuffer(40);
        buffer.append(SM.COOKIE2);
        buffer.append(": ");
        buffer.append("$Version=");
        buffer.append(Integer.toString(getVersion()));
        varB4EAC82CA7396A68D541C85D26508E83_1073416693 = new BufferedHeader(buffer);
        varB4EAC82CA7396A68D541C85D26508E83_1073416693.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1073416693;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(40);
        //buffer.append(SM.COOKIE2);
        //buffer.append(": ");
        //buffer.append("$Version=");
        //buffer.append(Integer.toString(getVersion()));
        //return new BufferedHeader(buffer);
    }

    
}

