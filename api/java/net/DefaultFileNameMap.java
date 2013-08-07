package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Locale;

import libcore.net.MimeUtils;


class DefaultFileNameMap implements FileNameMap {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.439 -0400", hash_original_method = "967DDE3A9286E19D23037DF9EB0654B3", hash_generated_method = "967DDE3A9286E19D23037DF9EB0654B3")
    public DefaultFileNameMap ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.439 -0400", hash_original_method = "CD3BB5C1D36DDF595D7942DB441DE716", hash_generated_method = "EC4477E342F5010EF08F63DE0BD27096")
    public String getContentTypeFor(String filename) {
        addTaint(filename.getTaint());
        if(filename.endsWith("/"))        
        {
String varFFB0A94021F9EAA0E57D20606DA1549E_1654427786 =             MimeUtils.guessMimeTypeFromExtension("html");
            varFFB0A94021F9EAA0E57D20606DA1549E_1654427786.addTaint(taint);
            return varFFB0A94021F9EAA0E57D20606DA1549E_1654427786;
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
String var70816CE115E885350FDEF9844DE4A2F8_1144958643 =         MimeUtils.guessMimeTypeFromExtension(ext.toLowerCase(Locale.US));
        var70816CE115E885350FDEF9844DE4A2F8_1144958643.addTaint(taint);
        return var70816CE115E885350FDEF9844DE4A2F8_1144958643;
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

