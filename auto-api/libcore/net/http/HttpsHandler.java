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

public final class HttpsHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.502 -0400", hash_original_method = "73E17AE58A6A937F64FCB115DB865949", hash_generated_method = "BD2C11C9D1D19A129C345C5CBD4AE64E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        dsTaint.addTaint(url.dsTaint);
        URLConnection varA6AF7B62DC99110E18DC15E270D37C12_826872678 = (new HttpsURLConnectionImpl(url, getDefaultPort()));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new HttpsURLConnectionImpl(url, getDefaultPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.502 -0400", hash_original_method = "E70DBB8BFBA86836115ED4E124721B04", hash_generated_method = "A268707D4E345CE7D4B49578996F5F1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } //End block
        URLConnection var05F6197B5CD02372425C96CFEF614B03_654941527 = (new HttpsURLConnectionImpl(url, getDefaultPort(), proxy));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.502 -0400", hash_original_method = "843384DDAB18A0CAED63C378A0D0642B", hash_generated_method = "D49EAF7D90DA49EC07FF3AAF72C63F41")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getDefaultPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 443;
    }

    
}


