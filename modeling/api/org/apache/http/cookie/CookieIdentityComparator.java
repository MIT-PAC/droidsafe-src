package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Comparator;

public class CookieIdentityComparator implements Serializable, Comparator<Cookie> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.247 -0500", hash_original_field = "E373645DFE2FDC39F894931394DAEC93", hash_generated_field = "D3FD79FDAFB7FA673E2878DF81465E57")

    private static final long serialVersionUID = 4466565437490631532L;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.115 -0400", hash_original_method = "4E7102072F2E26643CD713A2D98D9246", hash_generated_method = "4E7102072F2E26643CD713A2D98D9246")
    public CookieIdentityComparator ()
    {
        //Synthesized constructor
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.250 -0500", hash_original_method = "74E51A596EC4BD1E3C9EC5F43F5A06D0", hash_generated_method = "CA5FBB7B3879E9736CF1F1254D32F1AA")
    
public int compare(final Cookie c1, final Cookie c2) {
        int res = c1.getName().compareTo(c2.getName());
        if (res == 0) {
            // do not differentiate empty and null domains 
            String d1 = c1.getDomain();
            if (d1 == null) {
                d1 = "";
            }
            String d2 = c2.getDomain();
            if (d2 == null) {
                d2 = "";
            }
            res = d1.compareToIgnoreCase(d2);
        }
        return res;
    }
}

