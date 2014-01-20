package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.StringTokenizer;

import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

public class RFC2965PortAttributeHandler implements CookieAttributeHandler {

    /**
     * Parses the given Port attribute value (e.g. "8000,8001,8002")
     * into an array of ports.
     *
     * @param portValue port attribute value
     * @return parsed array of ports
     * @throws MalformedCookieException if there is a problem in
     *          parsing due to invalid portValue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.207 -0500", hash_original_method = "B760B570F2C2CE8C78B1C4B9AE67037F", hash_generated_method = "F657FCFE78415ACE6587EA6D62EB320C")
    
private static int[] parsePortAttribute(final String portValue)
            throws MalformedCookieException {
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

    /**
     * Returns <tt>true</tt> if the given port exists in the given
     * ports list.
     *
     * @param port port of host where cookie was received from or being sent to.
     * @param ports port list
     * @return true returns <tt>true</tt> if the given port exists in
     *         the given ports list; <tt>false</tt> otherwise.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.209 -0500", hash_original_method = "0B3635DA28D858C95C4C22FD8015492F", hash_generated_method = "5295B2FA1B13FD60058F0714D4624A49")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.204 -0500", hash_original_method = "E334DF66885CCF73C2314DA776277136", hash_generated_method = "D94E788DC5A68180A8234C1DA7C81D8C")
    
public RFC2965PortAttributeHandler() {
        super();
    }

    /**
     * Parse cookie port attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.212 -0500", hash_original_method = "681AF804F244AC355854B5C9066D8457", hash_generated_method = "75B8F32279746472E2F7526E56846850")
    
public void parse(final SetCookie cookie, final String portValue)
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookie instanceof SetCookie2) {
            SetCookie2 cookie2 = (SetCookie2) cookie;
            if (portValue != null && portValue.trim().length() > 0) {
                int[] ports = parsePortAttribute(portValue);
                cookie2.setPorts(ports);
            }
        }
    }

    /**
     * Validate cookie port attribute. If the Port attribute was specified
     * in header, the request port must be in cookie's port list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.215 -0500", hash_original_method = "9E12D702FFAE2715567401C9ACEBCA90", hash_generated_method = "8358D50C4B7C04EB808FFE375B4844F2")
    
public void validate(final Cookie cookie, final CookieOrigin origin)
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        int port = origin.getPort();
        if (cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR)) {
            if (!portMatch(port, cookie.getPorts())) {
                throw new MalformedCookieException(
                        "Port attribute violates RFC 2965: "
                        + "Request port not found in cookie's port list.");
            }
        }
    }

    /**
     * Match cookie port attribute. If the Port attribute is not specified
     * in header, the cookie can be sent to any port. Otherwise, the request port
     * must be in the cookie's port list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.218 -0500", hash_original_method = "DF68EC2DBEDB1856460C90C9AF4C7622", hash_generated_method = "B64734F5844BCD4345193A892466A394")
    
public boolean match(final Cookie cookie, final CookieOrigin origin) {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        int port = origin.getPort();
        if (cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR)) {
            if (cookie.getPorts() == null) {
                // Invalid cookie state: port not specified
                return false;
            }
            if (!portMatch(port, cookie.getPorts())) {
                return false;
            }
        }
        return true;
    }
    
}

