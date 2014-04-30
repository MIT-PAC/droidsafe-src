package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

public class NetscapeDraftSpecFactory implements CookieSpecFactory {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.990 -0400", hash_original_method = "E0E1E20239023582A4617467D7E49523", hash_generated_method = "E0E1E20239023582A4617467D7E49523")
    public NetscapeDraftSpecFactory ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.153 -0500", hash_original_method = "34FA08500657FDD515515AEEA52740F3", hash_generated_method = "0723E57BBF022B1A11EA4A04625C0410")
    
public CookieSpec newInstance(final HttpParams params) {
        if (params != null) {
            return new NetscapeDraftSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS));
        } else {
            return new NetscapeDraftSpec();
        }
    }
    
}

