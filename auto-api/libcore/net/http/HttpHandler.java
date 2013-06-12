package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class HttpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.502 -0400", hash_original_method = "36344CA950B2A976BD9D30B58C91386F", hash_generated_method = "E92A8C04F45FE5D6F93C14CD77CD6665")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        dsTaint.addTaint(u.dsTaint);
        URLConnection varD70C8AD4140E0950033F58B7F7A40958_585037146 = (new HttpURLConnectionImpl(u, getDefaultPort()));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new HttpURLConnectionImpl(u, getDefaultPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.502 -0400", hash_original_method = "1382348F6F5129438828F631F9FA5282", hash_generated_method = "AF71B894141F3A1783DFDD77B854757D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } //End block
        URLConnection var68ED555109D3FE3AC060547D491F640B_1886906955 = (new HttpURLConnectionImpl(url, getDefaultPort(), proxy));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.502 -0400", hash_original_method = "FEEAB6915C12BF9E3FEC7C9D98366E77", hash_generated_method = "E6FD90B7A98B3D46A8E9CD058595D308")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getDefaultPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 80;
    }

    
}


