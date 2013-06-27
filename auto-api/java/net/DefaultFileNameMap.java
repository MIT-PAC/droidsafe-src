package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import libcore.net.MimeUtils;

class DefaultFileNameMap implements FileNameMap {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.229 -0400", hash_original_method = "967DDE3A9286E19D23037DF9EB0654B3", hash_generated_method = "967DDE3A9286E19D23037DF9EB0654B3")
    public DefaultFileNameMap ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.230 -0400", hash_original_method = "CD3BB5C1D36DDF595D7942DB441DE716", hash_generated_method = "DE13F69B1391114BD99A589318C38D41")
    public String getContentTypeFor(String filename) {
        String varB4EAC82CA7396A68D541C85D26508E83_972415549 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1990617221 = null; //Variable for return #2
        {
            boolean varDB28DC1C749FDA3584072746EEA389AD_1687216220 = (filename.endsWith("/"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_972415549 = MimeUtils.guessMimeTypeFromExtension("html");
            } //End block
        } //End collapsed parenthetic
        int lastCharInExtension;
        lastCharInExtension = filename.lastIndexOf('#');
        {
            lastCharInExtension = filename.length();
        } //End block
        int firstCharInExtension;
        firstCharInExtension = filename.lastIndexOf('.') + 1;
        String ext;
        ext = "";
        {
            boolean var43A12D607FFEF29BA4F75A2F9A359902_1509280687 = (firstCharInExtension > filename.lastIndexOf('/'));
            {
                ext = filename.substring(firstCharInExtension, lastCharInExtension);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1990617221 = MimeUtils.guessMimeTypeFromExtension(ext.toLowerCase(Locale.US));
        addTaint(filename.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2114971050; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2114971050 = varB4EAC82CA7396A68D541C85D26508E83_972415549;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2114971050 = varB4EAC82CA7396A68D541C85D26508E83_1990617221;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2114971050.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2114971050;
        // ---------- Original Method ----------
        //if (filename.endsWith("/")) {
            //return MimeUtils.guessMimeTypeFromExtension("html");
        //}
        //int lastCharInExtension = filename.lastIndexOf('#');
        //if (lastCharInExtension < 0) {
            //lastCharInExtension = filename.length();
        //}
        //int firstCharInExtension = filename.lastIndexOf('.') + 1;
        //String ext = "";
        //if (firstCharInExtension > filename.lastIndexOf('/')) {
            //ext = filename.substring(firstCharInExtension, lastCharInExtension);
        //}
        //return MimeUtils.guessMimeTypeFromExtension(ext.toLowerCase(Locale.US));
    }

    
}

