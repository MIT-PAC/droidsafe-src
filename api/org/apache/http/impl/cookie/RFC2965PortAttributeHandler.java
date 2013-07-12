package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.StringTokenizer;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

public class RFC2965PortAttributeHandler implements CookieAttributeHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.865 -0400", hash_original_method = "E334DF66885CCF73C2314DA776277136", hash_generated_method = "4761D766B683CA7DF86AA940A4C091A8")
    public  RFC2965PortAttributeHandler() {
        super();
        
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

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.866 -0400", hash_original_method = "681AF804F244AC355854B5C9066D8457", hash_generated_method = "59DA821BF406930AE460DEE8A8C5D8E5")
    public void parse(final SetCookie cookie, final String portValue) throws MalformedCookieException {
        addTaint(portValue.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_247077293 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_247077293.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_247077293;
        } 
    if(cookie instanceof SetCookie2)        
        {
            SetCookie2 cookie2 = (SetCookie2) cookie;
    if(portValue != null && portValue.trim().length() > 0)            
            {
                int[] ports = parsePortAttribute(portValue);
                cookie2.setPorts(ports);
            } 
        } 
        
        
            
        
        
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.866 -0400", hash_original_method = "9E12D702FFAE2715567401C9ACEBCA90", hash_generated_method = "54B0A9CAF095FB2CE31D448DB1833CC3")
    public void validate(final Cookie cookie, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_424908788 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_424908788.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_424908788;
        } 
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_671621279 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_671621279.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_671621279;
        } 
        int port = origin.getPort();
    if(cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR))        
        {
    if(!portMatch(port, cookie.getPorts()))            
            {
                MalformedCookieException varED3CE662B780B57CAE13C75D2F7FA436_1887598160 = new MalformedCookieException(
                        "Port attribute violates RFC 2965: "
                        + "Request port not found in cookie's port list.");
                varED3CE662B780B57CAE13C75D2F7FA436_1887598160.addTaint(taint);
                throw varED3CE662B780B57CAE13C75D2F7FA436_1887598160;
            } 
        } 
        
        
            
        
        
            
        
        
        
                
            
                
                        
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.867 -0400", hash_original_method = "DF68EC2DBEDB1856460C90C9AF4C7622", hash_generated_method = "FB2E7380F60392B7AC05A3F11665C0CF")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
    if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_500366747 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_500366747.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_500366747;
        } 
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_325809648 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_325809648.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_325809648;
        } 
        int port = origin.getPort();
    if(cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR))        
        {
    if(cookie.getPorts() == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1592369321 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676243910 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_676243910;
            } 
    if(!portMatch(port, cookie.getPorts()))            
            {
                boolean var68934A3E9455FA72420237EB05902327_887044309 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157980597 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_157980597;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_880444334 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1860315874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1860315874;
        
        
            
        
        
            
        
        
        
                
            
                
            
            
                
            
        
        
    }

    
}

