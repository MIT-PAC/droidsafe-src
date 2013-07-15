package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import libcore.net.MimeUtils;

class DefaultFileNameMap implements FileNameMap {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.605 -0400", hash_original_method = "967DDE3A9286E19D23037DF9EB0654B3", hash_generated_method = "967DDE3A9286E19D23037DF9EB0654B3")
    public DefaultFileNameMap ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.606 -0400", hash_original_method = "CD3BB5C1D36DDF595D7942DB441DE716", hash_generated_method = "D0D4C8AC6D512725AD6E45E0F600EB3E")
    public String getContentTypeFor(String filename) {
        addTaint(filename.getTaint());
    if(filename.endsWith("/"))        
        {
String varFFB0A94021F9EAA0E57D20606DA1549E_1196706964 =             MimeUtils.guessMimeTypeFromExtension("html");
            varFFB0A94021F9EAA0E57D20606DA1549E_1196706964.addTaint(taint);
            return varFFB0A94021F9EAA0E57D20606DA1549E_1196706964;
        } //End block
        int lastCharInExtension = filename.lastIndexOf('#');
    if(lastCharInExtension < 0)        
        {
            lastCharInExtension = filename.length();
        } //End block
        int firstCharInExtension = filename.lastIndexOf('.') + 1;
        String ext = "";
    if(firstCharInExtension > filename.lastIndexOf('/'))        
        {
            ext = filename.substring(firstCharInExtension, lastCharInExtension);
        } //End block
String var70816CE115E885350FDEF9844DE4A2F8_1456710561 =         MimeUtils.guessMimeTypeFromExtension(ext.toLowerCase(Locale.US));
        var70816CE115E885350FDEF9844DE4A2F8_1456710561.addTaint(taint);
        return var70816CE115E885350FDEF9844DE4A2F8_1456710561;
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

