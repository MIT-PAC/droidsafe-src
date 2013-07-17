package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

public abstract class CookieSpecBase extends AbstractCookieSpec {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.806 -0400", hash_original_method = "934E7FA8F396BCCDD4329254EAF6D731", hash_generated_method = "934E7FA8F396BCCDD4329254EAF6D731")
    public CookieSpecBase ()
    {
        //Synthesized constructor
    }


    protected static String getDefaultPath(final CookieOrigin origin) {
        String defaultPath = origin.getPath();
        int lastSlashIndex = defaultPath.lastIndexOf('/');
        if (lastSlashIndex >= 0) {
            if (lastSlashIndex == 0) {
                lastSlashIndex = 1;
            }
            defaultPath = defaultPath.substring(0, lastSlashIndex);
        }
        return defaultPath;
    }

    
    protected static String getDefaultDomain(final CookieOrigin origin) {
        return origin.getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.807 -0400", hash_original_method = "A25C1D1A915416DA39EA69206340D62E", hash_generated_method = "EE04773A865E1F9E38D7F00DA8B18DB2")
    protected List<Cookie> parse(final HeaderElement[] elems, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(elems[0].getTaint());
        List<Cookie> cookies = new ArrayList<Cookie>(elems.length);
for(HeaderElement headerelement : elems)
        {
            String name = headerelement.getName();
            String value = headerelement.getValue();
            if(name == null || name.length() == 0)            
            {
                MalformedCookieException varAF01CFF0F91F0FF1D49FEB435A288F00_56889004 = new MalformedCookieException("Cookie name may not be empty");
                varAF01CFF0F91F0FF1D49FEB435A288F00_56889004.addTaint(taint);
                throw varAF01CFF0F91F0FF1D49FEB435A288F00_56889004;
            } //End block
            BasicClientCookie cookie = new BasicClientCookie(name, value);
            cookie.setPath(getDefaultPath(origin));
            cookie.setDomain(getDefaultDomain(origin));
            NameValuePair[] attribs = headerelement.getParameters();
for(int j = attribs.length - 1;j >= 0;j--)
            {
                NameValuePair attrib = attribs[j];
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
List<Cookie> var7A32AB0BC299936B4ABF6C972D767041_642057507 =         cookies;
        var7A32AB0BC299936B4ABF6C972D767041_642057507.addTaint(taint);
        return var7A32AB0BC299936B4ABF6C972D767041_642057507;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.807 -0400", hash_original_method = "CBCF0FF7E443EB1D3CDD692C0A263FBB", hash_generated_method = "19A2C95C5EE7638342CD18AAB2A962B6")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_642951419 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_642951419.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_642951419;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1036430382 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1036430382.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1036430382;
        } //End block
for(CookieAttributeHandler handler : getAttribHandlers())
        {
            handler.validate(cookie, origin);
        } //End block
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //for (CookieAttributeHandler handler: getAttribHandlers()) {
            //handler.validate(cookie, origin);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.808 -0400", hash_original_method = "23DBABC8C5DB2B0DC00C6D6715BA125E", hash_generated_method = "DD556F4E053E2AEC9A6760497BCCBE0A")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_1831618989 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_1831618989.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_1831618989;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1011361722 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1011361722.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1011361722;
        } //End block
for(CookieAttributeHandler handler : getAttribHandlers())
        {
            if(!handler.match(cookie, origin))            
            {
                boolean var68934A3E9455FA72420237EB05902327_647851769 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830821520 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_830821520;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1043246858 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_746012981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_746012981;
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //for (CookieAttributeHandler handler: getAttribHandlers()) {
            //if (!handler.match(cookie, origin)) {
                //return false;
            //}
        //}
        //return true;
    }

    
}

