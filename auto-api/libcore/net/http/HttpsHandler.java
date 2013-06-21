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

public final class HttpsHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.328 -0400", hash_original_method = "911EFE4A96B9C70E7C6F6062E857970E", hash_generated_method = "911EFE4A96B9C70E7C6F6062E857970E")
        public HttpsHandler ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.328 -0400", hash_original_method = "73E17AE58A6A937F64FCB115DB865949", hash_generated_method = "6680CF99BEFA97534375B15B0F335A01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        dsTaint.addTaint(url.dsTaint);
        URLConnection varA6AF7B62DC99110E18DC15E270D37C12_1852987919 = (new HttpsURLConnectionImpl(url, getDefaultPort()));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new HttpsURLConnectionImpl(url, getDefaultPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.328 -0400", hash_original_method = "E70DBB8BFBA86836115ED4E124721B04", hash_generated_method = "FF9A30050DE0036CB1DD3D61FC90BD39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } //End block
        URLConnection var05F6197B5CD02372425C96CFEF614B03_669251103 = (new HttpsURLConnectionImpl(url, getDefaultPort(), proxy));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.328 -0400", hash_original_method = "843384DDAB18A0CAED63C378A0D0642B", hash_generated_method = "6723E52692828CF76DFB3E9505C5A177")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getDefaultPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 443;
    }

    
}

