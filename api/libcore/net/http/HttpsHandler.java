package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class HttpsHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.478 -0400", hash_original_method = "C844A911E2153F94DB6E5F7227FA1E87", hash_generated_method = "C844A911E2153F94DB6E5F7227FA1E87")
    public HttpsHandler ()
    {
        
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.478 -0400", hash_original_method = "73E17AE58A6A937F64FCB115DB865949", hash_generated_method = "7E705ED59D5E5977B6EB3948EBDD1092")
    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        addTaint(url.getTaint());
URLConnection varBA8A9176E727F2E36F4E493298853752_625814439 =         new HttpsURLConnectionImpl(url, getDefaultPort());
        varBA8A9176E727F2E36F4E493298853752_625814439.addTaint(taint);
        return varBA8A9176E727F2E36F4E493298853752_625814439;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.479 -0400", hash_original_method = "E70DBB8BFBA86836115ED4E124721B04", hash_generated_method = "159A49762B65B17CE783886489F2D216")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        addTaint(url.getTaint());
    if(url == null || proxy == null)        
        {
            IllegalArgumentException var180E1357F474E7208A2DB6FF80901B51_1277236292 = new IllegalArgumentException("url == null || proxy == null");
            var180E1357F474E7208A2DB6FF80901B51_1277236292.addTaint(taint);
            throw var180E1357F474E7208A2DB6FF80901B51_1277236292;
        } 
URLConnection varA37437EC48028164887E5E01FD5F901A_1328011769 =         new HttpsURLConnectionImpl(url, getDefaultPort(), proxy);
        varA37437EC48028164887E5E01FD5F901A_1328011769.addTaint(taint);
        return varA37437EC48028164887E5E01FD5F901A_1328011769;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.479 -0400", hash_original_method = "843384DDAB18A0CAED63C378A0D0642B", hash_generated_method = "EEB6B44ECBDFD2DD4D8C1E7D693E6919")
    @Override
    protected int getDefaultPort() {
        int var13F3CF8C531952D72E5847C4183E6910_17007945 = (443);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1341296706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1341296706;
        
        
    }

    
}

