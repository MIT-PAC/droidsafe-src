package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class OIDTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.899 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "D745B114B0A51171DAD36F87C0CC38B4")

    private String oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.899 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.900 -0400", hash_original_method = "88D58AFE0405FCD9AB8F5CA4BE2D1534", hash_generated_method = "6B1A3C9995A277DCE6532E1EED87F5DC")
    public  OIDTokenizer(
        String oid) {
        this.oid = oid;
        this.index = 0;
        // ---------- Original Method ----------
        //this.oid = oid;
        //this.index = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.900 -0400", hash_original_method = "F35D489C40702BC97B5927032D797DB7", hash_generated_method = "F117DDA1102100228CB77E91145A78BF")
    public boolean hasMoreTokens() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658420558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658420558;
        // ---------- Original Method ----------
        //return (index != -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.901 -0400", hash_original_method = "4BAC87A2A9C681CC296BE2241CAA6D87", hash_generated_method = "9819042F4BF993786953AD93132227BC")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_2020665835 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2131253558 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1904617652 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_2020665835 = null;
        } //End block
        String token;
        int end = oid.indexOf('.', index);
        {
            token = oid.substring(index);
            index = -1;
            varB4EAC82CA7396A68D541C85D26508E83_2131253558 = token;
        } //End block
        token = oid.substring(index, end);
        index = end + 1;
        varB4EAC82CA7396A68D541C85D26508E83_1904617652 = token;
        String varA7E53CE21691AB073D9660D615818899_418841245; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_418841245 = varB4EAC82CA7396A68D541C85D26508E83_2020665835;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_418841245 = varB4EAC82CA7396A68D541C85D26508E83_2131253558;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_418841245 = varB4EAC82CA7396A68D541C85D26508E83_1904617652;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_418841245.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_418841245;
        // ---------- Original Method ----------
        //if (index == -1)
        //{
            //return null;
        //}
        //String  token;
        //int     end = oid.indexOf('.', index);
        //if (end == -1)
        //{
            //token = oid.substring(index);
            //index = -1;
            //return token;
        //}
        //token = oid.substring(index, end);
        //index = end + 1;
        //return token;
    }

    
}

