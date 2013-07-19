package libcore.net.http;

// Droidsafe Imports
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class HttpsHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.594 -0400", hash_original_method = "C844A911E2153F94DB6E5F7227FA1E87", hash_generated_method = "C844A911E2153F94DB6E5F7227FA1E87")
    public HttpsHandler ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.594 -0400", hash_original_method = "73E17AE58A6A937F64FCB115DB865949", hash_generated_method = "6905173B259EF19B6C1774EA23BCB77F")
    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        addTaint(url.getTaint());
URLConnection varBA8A9176E727F2E36F4E493298853752_2036074019 =         new HttpsURLConnectionImpl(url, getDefaultPort());
        varBA8A9176E727F2E36F4E493298853752_2036074019.addTaint(taint);
        return varBA8A9176E727F2E36F4E493298853752_2036074019;
        // ---------- Original Method ----------
        //return new HttpsURLConnectionImpl(url, getDefaultPort());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.594 -0400", hash_original_method = "E70DBB8BFBA86836115ED4E124721B04", hash_generated_method = "98AE93C503939599A3149245BFB18893")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        addTaint(url.getTaint());
        if(url == null || proxy == null)        
        {
            IllegalArgumentException var180E1357F474E7208A2DB6FF80901B51_1867269120 = new IllegalArgumentException("url == null || proxy == null");
            var180E1357F474E7208A2DB6FF80901B51_1867269120.addTaint(taint);
            throw var180E1357F474E7208A2DB6FF80901B51_1867269120;
        } //End block
URLConnection varA37437EC48028164887E5E01FD5F901A_2041560292 =         new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
        varA37437EC48028164887E5E01FD5F901A_2041560292.addTaint(taint);
        return varA37437EC48028164887E5E01FD5F901A_2041560292;
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.595 -0400", hash_original_method = "843384DDAB18A0CAED63C378A0D0642B", hash_generated_method = "CA69830991E7C3F15E8A08E75AE94853")
    @Override
    protected int getDefaultPort() {
        int var13F3CF8C531952D72E5847C4183E6910_1328822938 = (443);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420386536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420386536;
        // ---------- Original Method ----------
        //return 443;
    }

    
}

