package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

public class RFC2965PortAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.473 -0400", hash_original_method = "E334DF66885CCF73C2314DA776277136", hash_generated_method = "4761D766B683CA7DF86AA940A4C091A8")
    public  RFC2965PortAttributeHandler() {
        super();
        // ---------- Original Method ----------
    }

    
    private static int[] parsePortAttribute(final String portValue) throws MalformedCookieException {
        StringTokenizer st = new StringTokenizer(portValue, ",");
        int[] ports = new int[st.countTokens()];
        try {
            int i = 0;
            while(st.hasMoreTokens()) {
                ports[i] = Integer.parseInt(st.nextToken().trim());
                if (ports[i] < 0) {
                  throw new MalformedCookieException ("Invalid Port attribute.");
                }
                ++i;
            }
        } catch (NumberFormatException e) {
            throw new MalformedCookieException ("Invalid Port "
                                                + "attribute: " + e.getMessage());
        }
        return ports;
    }

    
    private static boolean portMatch(int port, int[] ports) {
        boolean portInList = false;
        for (int i = 0, len = ports.length; i < len; i++) {
            if (port == ports[i]) {
                portInList = true;
                break;
            }
        }
        return portInList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.475 -0400", hash_original_method = "681AF804F244AC355854B5C9066D8457", hash_generated_method = "E7A31D0833F986FD3A29A4E2EB5B973C")
    public void parse(final SetCookie cookie, final String portValue) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            SetCookie2 cookie2 = (SetCookie2) cookie;
            {
                boolean var86A8FFF96C7F683CE3CBC2F88023AC58_1041204668 = (portValue != null && portValue.trim().length() > 0);
                {
                    int[] ports = parsePortAttribute(portValue);
                    cookie2.setPorts(ports);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(cookie.getTaint());
        addTaint(portValue.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (cookie instanceof SetCookie2) {
            //SetCookie2 cookie2 = (SetCookie2) cookie;
            //if (portValue != null && portValue.trim().length() > 0) {
                //int[] ports = parsePortAttribute(portValue);
                //cookie2.setPorts(ports);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.477 -0400", hash_original_method = "9E12D702FFAE2715567401C9ACEBCA90", hash_generated_method = "9111D76DB5BD194E5EC27C79D484FA62")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        int port = origin.getPort();
        {
            boolean var5612C47998A5419B8EEB60E3F3947730_467023662 = (cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR));
            {
                {
                    boolean varE5D61C63A1F61CB1025C19159B89B5F3_1594700542 = (!portMatch(port, cookie.getPorts()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new MalformedCookieException(
                        "Port attribute violates RFC 2965: "
                        + "Request port not found in cookie's port list.");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //int port = origin.getPort();
        //if (cookie instanceof ClientCookie 
                //&& ((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR)) {
            //if (!portMatch(port, cookie.getPorts())) {
                //throw new MalformedCookieException(
                        //"Port attribute violates RFC 2965: "
                        //+ "Request port not found in cookie's port list.");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.479 -0400", hash_original_method = "DF68EC2DBEDB1856460C90C9AF4C7622", hash_generated_method = "CBABEB14806DA100A7A623DCF78D1BD7")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        int port = origin.getPort();
        {
            boolean var5612C47998A5419B8EEB60E3F3947730_1294767400 = (cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR));
            {
                {
                    boolean var4EF3EE66FBE764604CEF811F8CF3E1EE_106334846 = (cookie.getPorts() == null);
                } //End collapsed parenthetic
                {
                    boolean varE5D61C63A1F61CB1025C19159B89B5F3_696612248 = (!portMatch(port, cookie.getPorts()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_46492116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_46492116;
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //int port = origin.getPort();
        //if (cookie instanceof ClientCookie 
                //&& ((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR)) {
            //if (cookie.getPorts() == null) {
                //return false;
            //}
            //if (!portMatch(port, cookie.getPorts())) {
                //return false;
            //}
        //}
        //return true;
    }

    
}

