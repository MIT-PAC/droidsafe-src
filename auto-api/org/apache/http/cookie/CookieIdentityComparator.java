package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.Comparator;

public class CookieIdentityComparator implements Serializable, Comparator<Cookie> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.502 -0400", hash_original_method = "4E7102072F2E26643CD713A2D98D9246", hash_generated_method = "4E7102072F2E26643CD713A2D98D9246")
    public CookieIdentityComparator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.502 -0400", hash_original_method = "74E51A596EC4BD1E3C9EC5F43F5A06D0", hash_generated_method = "5EAE944975FAEBCC108D755C2266BA2C")
    public int compare(final Cookie c1, final Cookie c2) {
        int res = c1.getName().compareTo(c2.getName());
        {
            String d1 = c1.getDomain();
            {
                d1 = "";
            } //End block
            String d2 = c2.getDomain();
            {
                d2 = "";
            } //End block
            res = d1.compareToIgnoreCase(d2);
        } //End block
        addTaint(c1.getTaint());
        addTaint(c2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625977909 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625977909;
        // ---------- Original Method ----------
        //int res = c1.getName().compareTo(c2.getName());
        //if (res == 0) {
            //String d1 = c1.getDomain();
            //if (d1 == null) {
                //d1 = "";
            //}
            //String d2 = c2.getDomain();
            //if (d2 == null) {
                //d2 = "";
            //}
            //res = d1.compareToIgnoreCase(d2);
        //}
        //return res;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.502 -0400", hash_original_field = "4DA255DBE83D131A84FE5201DE20E4F7", hash_generated_field = "D3FD79FDAFB7FA673E2878DF81465E57")

    private static final long serialVersionUID = 4466565437490631532L;
}

