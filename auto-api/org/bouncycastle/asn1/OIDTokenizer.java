package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class OIDTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.459 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "D745B114B0A51171DAD36F87C0CC38B4")

    private String oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.459 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.490 -0400", hash_original_method = "88D58AFE0405FCD9AB8F5CA4BE2D1534", hash_generated_method = "6B1A3C9995A277DCE6532E1EED87F5DC")
    public  OIDTokenizer(
        String oid) {
        this.oid = oid;
        this.index = 0;
        // ---------- Original Method ----------
        //this.oid = oid;
        //this.index = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.491 -0400", hash_original_method = "F35D489C40702BC97B5927032D797DB7", hash_generated_method = "E536FCE1C881139AE615924A5FC5E6B9")
    public boolean hasMoreTokens() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_654226842 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_654226842;
        // ---------- Original Method ----------
        //return (index != -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.491 -0400", hash_original_method = "4BAC87A2A9C681CC296BE2241CAA6D87", hash_generated_method = "B3CB806AA05D87A992B17F8262BA1AC7")
    public String nextToken() {
        String varB4EAC82CA7396A68D541C85D26508E83_1817378756 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_984262228 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1050939741 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1817378756 = null;
        } //End block
        String token;
        int end;
        end = oid.indexOf('.', index);
        {
            token = oid.substring(index);
            index = -1;
            varB4EAC82CA7396A68D541C85D26508E83_984262228 = token;
        } //End block
        token = oid.substring(index, end);
        index = end + 1;
        varB4EAC82CA7396A68D541C85D26508E83_1050939741 = token;
        String varA7E53CE21691AB073D9660D615818899_162236638; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_162236638 = varB4EAC82CA7396A68D541C85D26508E83_1817378756;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_162236638 = varB4EAC82CA7396A68D541C85D26508E83_984262228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_162236638 = varB4EAC82CA7396A68D541C85D26508E83_1050939741;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_162236638.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_162236638;
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

