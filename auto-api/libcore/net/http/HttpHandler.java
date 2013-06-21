package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class HttpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.211 -0400", hash_original_method = "2AEBFCBB5963D191E9003ACE28268EE6", hash_generated_method = "2AEBFCBB5963D191E9003ACE28268EE6")
        public HttpHandler ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.212 -0400", hash_original_method = "36344CA950B2A976BD9D30B58C91386F", hash_generated_method = "400EB96A575ECF74148BDB3B9E1F3F57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        dsTaint.addTaint(u.dsTaint);
        URLConnection varD70C8AD4140E0950033F58B7F7A40958_1074797802 = (new HttpURLConnectionImpl(u, getDefaultPort()));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new HttpURLConnectionImpl(u, getDefaultPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.212 -0400", hash_original_method = "1382348F6F5129438828F631F9FA5282", hash_generated_method = "0F542448DEA475F3A12E73EC7C832652")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } //End block
        URLConnection var68ED555109D3FE3AC060547D491F640B_778329211 = (new HttpURLConnectionImpl(url, getDefaultPort(), proxy));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.212 -0400", hash_original_method = "FEEAB6915C12BF9E3FEC7C9D98366E77", hash_generated_method = "CFECB6501FBD8E2DF00BC08F09F4B6DD")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getDefaultPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 80;
    }

    
}

