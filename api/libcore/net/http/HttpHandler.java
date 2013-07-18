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

public final class HttpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.284 -0400", hash_original_method = "19FB70242B210A6BA2C2EBCBFA2BC8EA", hash_generated_method = "19FB70242B210A6BA2C2EBCBFA2BC8EA")
    public HttpHandler ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.284 -0400", hash_original_method = "36344CA950B2A976BD9D30B58C91386F", hash_generated_method = "78B429AF6FB5482B60F278D71F518145")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        addTaint(u.getTaint());
URLConnection var0CE870C292B30B6835AB9F24F9C87407_2146638780 =         new HttpURLConnectionImpl(u, getDefaultPort());
        var0CE870C292B30B6835AB9F24F9C87407_2146638780.addTaint(taint);
        return var0CE870C292B30B6835AB9F24F9C87407_2146638780;
        // ---------- Original Method ----------
        //return new HttpURLConnectionImpl(u, getDefaultPort());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.284 -0400", hash_original_method = "1382348F6F5129438828F631F9FA5282", hash_generated_method = "CD08C7CF52988606A760F28C3DCE0ED3")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        addTaint(url.getTaint());
        if(url == null || proxy == null)        
        {
            IllegalArgumentException var180E1357F474E7208A2DB6FF80901B51_1825950110 = new IllegalArgumentException("url == null || proxy == null");
            var180E1357F474E7208A2DB6FF80901B51_1825950110.addTaint(taint);
            throw var180E1357F474E7208A2DB6FF80901B51_1825950110;
        } //End block
URLConnection var7ACE3BB648BA8E90CB3292E2E8EF04FA_1245305999 =         new HttpURLConnectionImpl(url, getDefaultPort(), proxy);
        var7ACE3BB648BA8E90CB3292E2E8EF04FA_1245305999.addTaint(taint);
        return var7ACE3BB648BA8E90CB3292E2E8EF04FA_1245305999;
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:25.285 -0400", hash_original_method = "FEEAB6915C12BF9E3FEC7C9D98366E77", hash_generated_method = "0E368F81C58285962066C1A4459FE021")
    @Override
    protected int getDefaultPort() {
        int varF033AB37C30201F73F142449D037028D_139647241 = (80);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900055087 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1900055087;
        // ---------- Original Method ----------
        //return 80;
    }

    
}

