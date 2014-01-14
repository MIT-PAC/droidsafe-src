package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Comparator;

public class CookiePathComparator implements Serializable, Comparator<Cookie> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.285 -0500", hash_original_field = "F9CD8031B020F5139FA72E3F6D9EDC41", hash_generated_field = "72EE05E0928858A1E51BAE2345CB995B")

    private static final long serialVersionUID = 7523645369616405818L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.138 -0400", hash_original_method = "29A50A9D1E136547D3D05BF6575A3E25", hash_generated_method = "29A50A9D1E136547D3D05BF6575A3E25")
    public CookiePathComparator ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.288 -0500", hash_original_method = "679ADE09B30DFC8534697854331FFCFD", hash_generated_method = "0270A918331D0D3909B48E87021C7770")
    
private String normalizePath(final Cookie cookie) {
        String path = cookie.getPath();
        if (path == null) {
            path = "/";
        }
        if (!path.endsWith("/")) {
            path = path + '/';
        }
        return path;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.290 -0500", hash_original_method = "38114A956CA6EEFF2831D01642E4D39A", hash_generated_method = "8FEACE0E0CF31016BAF0C982B6E3D548")
    
public int compare(final Cookie c1, final Cookie c2) {
        String path1 = normalizePath(c1);
        String path2 = normalizePath(c2);
        if (path1.equals(path2)) {
            return 0;
        } else if (path1.startsWith(path2)) {
            return -1;
        } else if (path2.startsWith(path1)) {
            return 1;
        } else {
            // Does not really matter
            return 0;
        }
    }
}

