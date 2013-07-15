package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.890 -0400", hash_original_method = "0C9AFF04E5BAABEBA18893034F65C0B5", hash_generated_method = "ED8461C5C758500E2E57B09EC8299F41")
    public  RFC2965Spec() {
        this(null, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.891 -0400", hash_original_method = "ACE780060B747E0E2CD86A0260ED3969", hash_generated_method = "D4B6452AC00A2CECCC77D22C5A107025")
    public  RFC2965Spec(final String[] datepatterns, boolean oneHeader) {
        super(datepatterns, oneHeader);
        addTaint(oneHeader);
        addTaint(datepatterns[0].getTaint());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new RFC2965DomainAttributeHandler());
        registerAttribHandler(ClientCookie.PORT_ATTR, new RFC2965PortAttributeHandler());
        registerAttribHandler(ClientCookie.COMMENTURL_ATTR, new RFC2965CommentUrlAttributeHandler());
        registerAttribHandler(ClientCookie.DISCARD_ATTR, new RFC2965DiscardAttributeHandler());
        registerAttribHandler(ClientCookie.VERSION_ATTR, new RFC2965VersionAttributeHandler());
        // ---------- Original Method ----------
        //registerAttribHandler(ClientCookie.DOMAIN_ATTR, new RFC2965DomainAttributeHandler());
        //registerAttribHandler(ClientCookie.PORT_ATTR, new RFC2965PortAttributeHandler());
        //registerAttribHandler(ClientCookie.COMMENTURL_ATTR, new RFC2965CommentUrlAttributeHandler());
        //registerAttribHandler(ClientCookie.DISCARD_ATTR, new RFC2965DiscardAttributeHandler());
        //registerAttribHandler(ClientCookie.VERSION_ATTR, new RFC2965VersionAttributeHandler());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.891 -0400", hash_original_method = "4409F0FE45DA6FEDE61567597482D361", hash_generated_method = "1EF37EEA2D42BBCF5DE0E0E4C990ECAD")
    private BasicClientCookie createCookie(
            final String name, final String value, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setPath(getDefaultPath(origin));
        cookie.setDomain(getDefaultDomain(origin));
BasicClientCookie varB4C6ADEB9C3E8E55D6C4EB3F341D441E_1431246374 =         cookie;
        varB4C6ADEB9C3E8E55D6C4EB3F341D441E_1431246374.addTaint(taint);
        return varB4C6ADEB9C3E8E55D6C4EB3F341D441E_1431246374;
        // ---------- Original Method ----------
        //BasicClientCookie cookie = new BasicClientCookie(name, value);
        //cookie.setPath(getDefaultPath(origin));
        //cookie.setDomain(getDefaultDomain(origin));
        //return cookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.891 -0400", hash_original_method = "C203D6CC66BEDFCF9DF77F8143966D25", hash_generated_method = "0BD9A6B573B6A6FB875D2C0C8DE43182")
    private BasicClientCookie createCookie2(
            final String name, final String value, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        BasicClientCookie2 cookie = new BasicClientCookie2(name, value);
        cookie.setPath(getDefaultPath(origin));
        cookie.setDomain(getDefaultDomain(origin));
        cookie.setPorts(new int [] { origin.getPort() });
BasicClientCookie varB4C6ADEB9C3E8E55D6C4EB3F341D441E_165458513 =         cookie;
        varB4C6ADEB9C3E8E55D6C4EB3F341D441E_165458513.addTaint(taint);
        return varB4C6ADEB9C3E8E55D6C4EB3F341D441E_165458513;
        // ---------- Original Method ----------
        //BasicClientCookie2 cookie = new BasicClientCookie2(name, value);
        //cookie.setPath(getDefaultPath(origin));
        //cookie.setDomain(getDefaultDomain(origin));
        //cookie.setPorts(new int [] { origin.getPort() });
        //return cookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.893 -0400", hash_original_method = "63E6AFA36A40CA79A5C09930028E525A", hash_generated_method = "124FE90C3CE35FB2667569DB3AF92F2B")
    @Override
    public List<Cookie> parse(
            final Header header, 
            CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(header.getTaint());
    if(header == null)        
        {
            IllegalArgumentException var655E57DE77F969F763516260E292795B_1673774176 = new IllegalArgumentException("Header may not be null");
            var655E57DE77F969F763516260E292795B_1673774176.addTaint(taint);
            throw var655E57DE77F969F763516260E292795B_1673774176;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_35912101 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_35912101.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_35912101;
        } //End block
        origin = adjustEffectiveHost(origin);
        HeaderElement[] elems = header.getElements();
        List<Cookie> cookies = new ArrayList<Cookie>(elems.length);
for(HeaderElement headerelement : elems)
        {
            String name = headerelement.getName();
            String value = headerelement.getValue();
    if(name == null || name.length() == 0)            
            {
                MalformedCookieException varAF01CFF0F91F0FF1D49FEB435A288F00_1713225135 = new MalformedCookieException("Cookie name may not be empty");
                varAF01CFF0F91F0FF1D49FEB435A288F00_1713225135.addTaint(taint);
                throw varAF01CFF0F91F0FF1D49FEB435A288F00_1713225135;
            } //End block
            BasicClientCookie cookie;
    if(header.getName().equals(SM.SET_COOKIE2))            
            {
                cookie = createCookie2(name, value, origin);
            } //End block
            else
            {
                cookie = createCookie(name, value, origin);
            } //End block
            NameValuePair[] attribs = headerelement.getParameters();
            Map<String, NameValuePair> attribmap = new HashMap<String, NameValuePair>(attribs.length);
for(int j = attribs.length - 1;j >= 0;j--)
            {
                NameValuePair param = attribs[j];
                attribmap.put(param.getName().toLowerCase(Locale.ENGLISH), param);
            } //End block
for(Map.Entry<String, NameValuePair> entry : attribmap.entrySet())
            {
                NameValuePair attrib = entry.getValue();
                String s = attrib.getName().toLowerCase(Locale.ENGLISH);
                cookie.setAttribute(s, attrib.getValue());
                CookieAttributeHandler handler = findAttribHandler(s);
    if(handler != null)                
                {
                    handler.parse(cookie, attrib.getValue());
                } //End block
            } //End block
            cookies.add(cookie);
        } //End block
List<Cookie> var7A32AB0BC299936B4ABF6C972D767041_275101268 =         cookies;
        var7A32AB0BC299936B4ABF6C972D767041_275101268.addTaint(taint);
        return var7A32AB0BC299936B4ABF6C972D767041_275101268;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.894 -0400", hash_original_method = "67EA3E91E653DB3E455D1CE08BD1E58C", hash_generated_method = "512EE121164FA526DC6F2A9BD4C20735")
    @Override
    public void validate(final Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1976139666 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1976139666.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1976139666;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_712948773 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_712948773.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_712948773;
        } //End block
        origin = adjustEffectiveHost(origin);
        super.validate(cookie, origin);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.895 -0400", hash_original_method = "6825BB2CF6533B26EC949D0ED0CB3EFF", hash_generated_method = "FF0535FBF7F6853A6CD5E5C109A06D0D")
    @Override
    public boolean match(final Cookie cookie, CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_2010958627 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_2010958627.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_2010958627;
        } //End block
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1947723314 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1947723314.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1947723314;
        } //End block
        origin = adjustEffectiveHost(origin);
        boolean varE92E72DDB1FE536FA8D55D87A2797528_1002233778 = (super.match(cookie, origin));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1027315608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1027315608;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.895 -0400", hash_original_method = "BB37CE4D8DBA00C0591EE6D75240E9EE", hash_generated_method = "63EEAF6397A88AB99C4A369500D67A57")
    @Override
    protected void formatCookieAsVer(final CharArrayBuffer buffer, 
            final Cookie cookie, int version) {
        addTaint(version);
        addTaint(cookie.getTaint());
        addTaint(buffer.getTaint());
        super.formatCookieAsVer(buffer, cookie, version);
    if(cookie instanceof ClientCookie)        
        {
            String s = ((ClientCookie) cookie).getAttribute(ClientCookie.PORT_ATTR);
    if(s != null)            
            {
                buffer.append("; $Port");
                buffer.append("=\"");
    if(s.trim().length() > 0)                
                {
                    int[] ports = cookie.getPorts();
    if(ports != null)                    
                    {
for(int i = 0, len = ports.length;i < len;i++)
                        {
    if(i > 0)                            
                            {
                                buffer.append(",");
                            } //End block
                            buffer.append(Integer.toString(ports[i]));
                        } //End block
                    } //End block
                } //End block
                buffer.append("\"");
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.897 -0400", hash_original_method = "48398E54A721F2ABBD2AD2C5ED75FBF5", hash_generated_method = "38F409CDB9978DF094B4DAF259207920")
    @Override
    public int getVersion() {
        int varC4CA4238A0B923820DCC509A6F75849B_1501726528 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330402359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330402359;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.898 -0400", hash_original_method = "135D9D751A7E49D965B3B7FE1A189F11", hash_generated_method = "8A330EDFBCCE01913132081C7735B0D6")
    @Override
    public Header getVersionHeader() {
        CharArrayBuffer buffer = new CharArrayBuffer(40);
        buffer.append(SM.COOKIE2);
        buffer.append(": ");
        buffer.append("$Version=");
        buffer.append(Integer.toString(getVersion()));
Header varA538F19AF489509DED0A3819B3004747_1727745612 =         new BufferedHeader(buffer);
        varA538F19AF489509DED0A3819B3004747_1727745612.addTaint(taint);
        return varA538F19AF489509DED0A3819B3004747_1727745612;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(40);
        //buffer.append(SM.COOKIE2);
        //buffer.append(": ");
        //buffer.append("$Version=");
        //buffer.append(Integer.toString(getVersion()));
        //return new BufferedHeader(buffer);
    }

    
}

