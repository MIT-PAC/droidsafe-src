package org.apache.http.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;
import java.util.Comparator;

public class CookiePathComparator implements Serializable, Comparator<Cookie> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.520 -0400", hash_original_method = "29A50A9D1E136547D3D05BF6575A3E25", hash_generated_method = "29A50A9D1E136547D3D05BF6575A3E25")
    public CookiePathComparator ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.521 -0400", hash_original_method = "679ADE09B30DFC8534697854331FFCFD", hash_generated_method = "13595C6E0EB9E99A9E8BEDF1B4D89E90")
    private String normalizePath(final Cookie cookie) {
        String varB4EAC82CA7396A68D541C85D26508E83_2089015504 = null; 
        String path = cookie.getPath();
        {
            path = "/";
        } 
        {
            boolean varBB23901A8493ABD61472E931AAF204C3_889625978 = (!path.endsWith("/"));
            {
                path = path + '/';
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2089015504 = path;
        addTaint(cookie.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2089015504.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2089015504;
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.521 -0400", hash_original_method = "38114A956CA6EEFF2831D01642E4D39A", hash_generated_method = "C37423E73238A422173760653D1D9AA5")
    public int compare(final Cookie c1, final Cookie c2) {
        String path1 = normalizePath(c1);
        String path2 = normalizePath(c2);
        {
            boolean var0CB2E8E81DE73DB2B03BCB11AF1D6765_393059417 = (path1.equals(path2));
            {
                boolean varA1180DE4FDF24371C229B75A0E6ECA2A_850787990 = (path1.startsWith(path2));
                {
                    boolean varC27A2A885FF8387770C1D629049B5822_377634692 = (path2.startsWith(path1));
                } 
            } 
        } 
        addTaint(c1.getTaint());
        addTaint(c2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752068477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752068477;
        
        
        
        
            
        
            
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.521 -0400", hash_original_field = "0F87541D9DDA243624A2462D4F476B97", hash_generated_field = "72EE05E0928858A1E51BAE2345CB995B")

    private static final long serialVersionUID = 7523645369616405818L;
}

