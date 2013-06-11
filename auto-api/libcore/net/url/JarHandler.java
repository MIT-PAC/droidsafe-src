package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class JarHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.523 -0400", hash_original_method = "BD0D54E815B3E8434D2BE4AD1DDC7411", hash_generated_method = "1F7FE6D4E058A52E09A33891D647E3DF")
    @DSModeled(DSC.SAFE)
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        dsTaint.addTaint(u.dsTaint);
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new JarURLConnectionImpl(u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.523 -0400", hash_original_method = "57C5D17E5E318F4D460452A0FAAB1E77", hash_generated_method = "1B10FA15A93A9A4B0F541F936820E90B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void parseURL(URL url, String spec, int start, int limit) {
        dsTaint.addTaint(spec);
        dsTaint.addTaint(limit);
        dsTaint.addTaint(start);
        dsTaint.addTaint(url.dsTaint);
        String file;
        file = url.getFile();
        {
            file = "";
        } //End block
        {
            spec = spec.substring(start, limit);
        } //End block
        {
            spec = "";
        } //End block
        {
            boolean var3948E0BE2774036E4123DB53B312CCF1_1682119586 = (spec.indexOf("!/") == -1 && (file.indexOf("!/") == -1));
            {
                throw new NullPointerException("Cannot find \"!/\"");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var663670DD1E5C39043C69A7F64A2C1292_1356436942 = (file.isEmpty());
            {
                file = spec;
            } //End block
            {
                boolean varE8C8F246188348661A8B133D5E9D1FF7_886320143 = (spec.charAt(0) == '/');
                {
                    file = file.substring(0, file.indexOf('!') + 1) + spec;
                } //End block
                {
                    int idx;
                    idx = file.indexOf('!');
                    String tmpFile;
                    tmpFile = file.substring(idx + 1, file.lastIndexOf('/') + 1) + spec;
                    tmpFile = UrlUtils.canonicalizePath(tmpFile, true);
                    file = file.substring(0, idx + 1) + tmpFile;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        try 
        {
            new URL(file);
        } //End block
        catch (MalformedURLException e)
        {
            throw new NullPointerException(e.toString());
        } //End block
        setURL(url, "jar", "", -1, null, null, file, null, null);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.523 -0400", hash_original_method = "F692A804EFA22D479A24DA08ED26F838", hash_generated_method = "22CA9F42041E64820F5EDE1B44FA3876")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected String toExternalForm(URL url) {
        dsTaint.addTaint(url.dsTaint);
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("jar:");
        sb.append(url.getFile());
        String ref;
        ref = url.getRef();
        {
            sb.append(ref);
        } //End block
        String var806458D832AB974D230FEE4CBBDBD390_614108391 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("jar:");
        //sb.append(url.getFile());
        //String ref = url.getRef();
        //if (ref != null) {
            //sb.append(ref);
        //}
        //return sb.toString();
    }

    
}


