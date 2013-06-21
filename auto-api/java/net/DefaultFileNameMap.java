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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.794 -0400", hash_original_method = "9C28A2B06989A22D0B953AC33B6A05EB", hash_generated_method = "9C28A2B06989A22D0B953AC33B6A05EB")
        public DefaultFileNameMap ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.794 -0400", hash_original_method = "CD3BB5C1D36DDF595D7942DB441DE716", hash_generated_method = "7AEE50477BCB421A9EE6968F3AEEB659")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentTypeFor(String filename) {
        dsTaint.addTaint(filename);
        {
            boolean varDB28DC1C749FDA3584072746EEA389AD_1056439329 = (filename.endsWith("/"));
            {
                String var55B2BE827978B1B6D021FE19F111723A_1577066596 = (MimeUtils.guessMimeTypeFromExtension("html"));
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
            boolean var43A12D607FFEF29BA4F75A2F9A359902_748430287 = (firstCharInExtension > filename.lastIndexOf('/'));
            {
                ext = filename.substring(firstCharInExtension, lastCharInExtension);
            } //End block
        } //End collapsed parenthetic
        String var1281BD8EAF418685BB2D8C3739FB4B38_850721730 = (MimeUtils.guessMimeTypeFromExtension(ext.toLowerCase(Locale.US)));
        return dsTaint.getTaintString();
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

