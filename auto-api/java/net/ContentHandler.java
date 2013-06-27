package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class ContentHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.145 -0400", hash_original_method = "34235149EC6F1F14A33FF6A78502D340", hash_generated_method = "34235149EC6F1F14A33FF6A78502D340")
    public ContentHandler ()
    {
        //Synthesized constructor
    }


    public abstract Object getContent(URLConnection uConn) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.145 -0400", hash_original_method = "8659195BC6B56411F2DC6C9C918B5FC3", hash_generated_method = "2478681B337BCA5D6F69F13BDB3A1251")
    @SuppressWarnings("unchecked")
    public Object getContent(URLConnection uConn, Class[] types) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1424018236 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1168940160 = null; //Variable for return #2
        Object content;
        content = getContent(uConn);
        {
            int i;
            i = 0;
            {
                {
                    boolean varD335B318B75970DDE3AA8452F6D1E99A_1322857246 = (types[i].isInstance(content));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1424018236 = content;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1168940160 = null;
        addTaint(uConn.getTaint());
        addTaint(types[0].getTaint());
        Object varA7E53CE21691AB073D9660D615818899_110552376; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_110552376 = varB4EAC82CA7396A68D541C85D26508E83_1424018236;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_110552376 = varB4EAC82CA7396A68D541C85D26508E83_1168940160;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_110552376.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_110552376;
        // ---------- Original Method ----------
        //Object content = getContent(uConn);
        //for (int i = 0; i < types.length; i++) {
            //if (types[i].isInstance(content)) {
                //return content;
            //}
        //}
        //return null;
    }

    
}

