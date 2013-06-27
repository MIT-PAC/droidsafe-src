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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.731 -0400", hash_original_method = "0C9AFF04E5BAABEBA18893034F65C0B5", hash_generated_method = "ED8461C5C758500E2E57B09EC8299F41")
    public  RFC2965Spec() {
        this(null, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.731 -0400", hash_original_method = "ACE780060B747E0E2CD86A0260ED3969", hash_generated_method = "949480FDE45EA50307EAFAD969F9B712")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.732 -0400", hash_original_method = "4409F0FE45DA6FEDE61567597482D361", hash_generated_method = "2F0484DC5473C84CCECFB588E74F0D27")
    private BasicClientCookie createCookie(
            final String name, final String value, final CookieOrigin origin) {
        BasicClientCookie varB4EAC82CA7396A68D541C85D26508E83_1559256132 = null; //Variable for return #1
        BasicClientCookie cookie;
        cookie = new BasicClientCookie(name, value);
        cookie.setPath(getDefaultPath(origin));
        cookie.setDomain(getDefaultDomain(origin));
        varB4EAC82CA7396A68D541C85D26508E83_1559256132 = cookie;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1559256132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1559256132;
        // ---------- Original Method ----------
        //BasicClientCookie cookie = new BasicClientCookie(name, value);
        //cookie.setPath(getDefaultPath(origin));
        //cookie.setDomain(getDefaultDomain(origin));
        //return cookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.732 -0400", hash_original_method = "C203D6CC66BEDFCF9DF77F8143966D25", hash_generated_method = "E81767E3B3DBFD5CC6E8AE4B22342B38")
    private BasicClientCookie createCookie2(
            final String name, final String value, final CookieOrigin origin) {
        BasicClientCookie varB4EAC82CA7396A68D541C85D26508E83_702441488 = null; //Variable for return #1
        BasicClientCookie2 cookie;
        cookie = new BasicClientCookie2(name, value);
        cookie.setPath(getDefaultPath(origin));
        cookie.setDomain(getDefaultDomain(origin));
        cookie.setPorts(new int [] { origin.getPort() });
        varB4EAC82CA7396A68D541C85D26508E83_702441488 = cookie;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_702441488.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_702441488;
        // ---------- Original Method ----------
        //BasicClientCookie2 cookie = new BasicClientCookie2(name, value);
        //cookie.setPath(getDefaultPath(origin));
        //cookie.setDomain(getDefaultDomain(origin));
        //cookie.setPorts(new int [] { origin.getPort() });
        //return cookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.755 -0400", hash_original_method = "63E6AFA36A40CA79A5C09930028E525A", hash_generated_method = "CF63DAB33A48A76B42681CE26DA03210")
    @Override
    public List<Cookie> parse(
            final Header header, 
            CookieOrigin origin) throws MalformedCookieException {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1236709223 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        origin = adjustEffectiveHost(origin);
        HeaderElement[] elems;
        elems = header.getElements();
        List<Cookie> cookies;
        cookies = new ArrayList<Cookie>(elems.length);
        {
            Iterator<HeaderElement> var64E4248F3E9583EF9C3B3FA1CE66BA8F_1823856244 = (elems).iterator();
            var64E4248F3E9583EF9C3B3FA1CE66BA8F_1823856244.hasNext();
            HeaderElement headerelement = var64E4248F3E9583EF9C3B3FA1CE66BA8F_1823856244.next();
            {
                String name;
                name = headerelement.getName();
                String value;
                value = headerelement.getValue();
                {
                    boolean var4461637DABA130E2A1B9BDCB33E9CE15_782478829 = (name == null || name.length() == 0);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException("Cookie name may not be empty");
                    } //End block
                } //End collapsed parenthetic
                BasicClientCookie cookie;
                {
                    boolean var6AAE77C4B9E15A12E99793AA7DBB24FF_1222034649 = (header.getName().equals(SM.SET_COOKIE2));
                    {
                        cookie = createCookie2(name, value, origin);
                    } //End block
                    {
                        cookie = createCookie(name, value, origin);
                    } //End block
                } //End collapsed parenthetic
                NameValuePair[] attribs;
                attribs = headerelement.getParameters();
                Map<String, NameValuePair> attribmap;
                attribmap = new HashMap<String, NameValuePair>(attribs.length);
                {
                    int j;
                    j = attribs.length - 1;
                    {
                        NameValuePair param;
                        param = attribs[j];
                        attribmap.put(param.getName().toLowerCase(Locale.ENGLISH), param);
                    } //End block
                } //End collapsed parenthetic
                {
                    Iterator<Map.Entry<String, NameValuePair>> var31E344CB7BBCC0B9BB8B4730C2B3AB1B_1767135360 = (attribmap.entrySet()).iterator();
                    var31E344CB7BBCC0B9BB8B4730C2B3AB1B_1767135360.hasNext();
                    Map.Entry<String, NameValuePair> entry = var31E344CB7BBCC0B9BB8B4730C2B3AB1B_1767135360.next();
                    {
                        NameValuePair attrib;
                        attrib = entry.getValue();
                        String s;
                        s = attrib.getName().toLowerCase(Locale.ENGLISH);
                        cookie.setAttribute(s, attrib.getValue());
                        CookieAttributeHandler handler;
                        handler = findAttribHandler(s);
                        {
                            handler.parse(cookie, attrib.getValue());
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                cookies.add(cookie);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1236709223 = cookies;
        addTaint(header.getTaint());
        addTaint(origin.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1236709223.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1236709223;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.756 -0400", hash_original_method = "67EA3E91E653DB3E455D1CE08BD1E58C", hash_generated_method = "6DAEEE5A57DA55FF7C8331C27469CFC9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.756 -0400", hash_original_method = "6825BB2CF6533B26EC949D0ED0CB3EFF", hash_generated_method = "D6F05C9219FAC2D5A89E0046BF889132")
    @Override
    public boolean match(final Cookie cookie, CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        origin = adjustEffectiveHost(origin);
        boolean var4646C80192E3B5F87999DDAAB5D6A6A4_1526154505 = (super.match(cookie, origin));
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745815609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745815609;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.770 -0400", hash_original_method = "BB37CE4D8DBA00C0591EE6D75240E9EE", hash_generated_method = "C2B2A24C07C6441E0AECF49849455124")
    @Override
    protected void formatCookieAsVer(final CharArrayBuffer buffer, 
            final Cookie cookie, int version) {
        super.formatCookieAsVer(buffer, cookie, version);
        {
            String s;
            s = ((ClientCookie) cookie).getAttribute(ClientCookie.PORT_ATTR);
            {
                buffer.append("; $Port");
                buffer.append("=\"");
                {
                    boolean var581DBC2523087AD4616EE4691A0BEDAF_1379078000 = (s.trim().length() > 0);
                    {
                        int[] ports;
                        ports = cookie.getPorts();
                        {
                            {
                                int i, len;
                                i = 0;
                                len = ports.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.770 -0400", hash_original_method = "48398E54A721F2ABBD2AD2C5ED75FBF5", hash_generated_method = "C959D62A73E1B4B291ED4B04E452A7D1")
    @Override
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181776970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181776970;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.772 -0400", hash_original_method = "135D9D751A7E49D965B3B7FE1A189F11", hash_generated_method = "35B91E56DFEA37D282F05E15393BB4EF")
    @Override
    public Header getVersionHeader() {
        Header varB4EAC82CA7396A68D541C85D26508E83_108869026 = null; //Variable for return #1
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(40);
        buffer.append(SM.COOKIE2);
        buffer.append(": ");
        buffer.append("$Version=");
        buffer.append(Integer.toString(getVersion()));
        varB4EAC82CA7396A68D541C85D26508E83_108869026 = new BufferedHeader(buffer);
        varB4EAC82CA7396A68D541C85D26508E83_108869026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_108869026;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(40);
        //buffer.append(SM.COOKIE2);
        //buffer.append(": ");
        //buffer.append("$Version=");
        //buffer.append(Integer.toString(getVersion()));
        //return new BufferedHeader(buffer);
    }

    
}

