package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class HttpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.308 -0400", hash_original_method = "19FB70242B210A6BA2C2EBCBFA2BC8EA", hash_generated_method = "19FB70242B210A6BA2C2EBCBFA2BC8EA")
    public HttpHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.309 -0400", hash_original_method = "36344CA950B2A976BD9D30B58C91386F", hash_generated_method = "36DA6BA2578691A660272BD538B04B35")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        addTaint(u.getTaint());
URLConnection var0CE870C292B30B6835AB9F24F9C87407_1176982158 =         new HttpURLConnectionImpl(u, getDefaultPort());
        var0CE870C292B30B6835AB9F24F9C87407_1176982158.addTaint(taint);
        return var0CE870C292B30B6835AB9F24F9C87407_1176982158;
        // ---------- Original Method ----------
        //return new HttpURLConnectionImpl(u, getDefaultPort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.309 -0400", hash_original_method = "1382348F6F5129438828F631F9FA5282", hash_generated_method = "E19D6E861B668AA2BC93E956F73338B1")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        addTaint(url.getTaint());
    if(url == null || proxy == null)        
        {
            IllegalArgumentException var180E1357F474E7208A2DB6FF80901B51_2118827595 = new IllegalArgumentException("url == null || proxy == null");
            var180E1357F474E7208A2DB6FF80901B51_2118827595.addTaint(taint);
            throw var180E1357F474E7208A2DB6FF80901B51_2118827595;
        } //End block
URLConnection var7ACE3BB648BA8E90CB3292E2E8EF04FA_598102067 =         new HttpURLConnectionImpl(url, getDefaultPort(), proxy);
        var7ACE3BB648BA8E90CB3292E2E8EF04FA_598102067.addTaint(taint);
        return var7ACE3BB648BA8E90CB3292E2E8EF04FA_598102067;
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new HttpURLConnectionImpl(url, getDefaultPort(), proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.310 -0400", hash_original_method = "FEEAB6915C12BF9E3FEC7C9D98366E77", hash_generated_method = "CF1E74F16B880A59063C777A7BB7E914")
    @Override
    protected int getDefaultPort() {
        int varF033AB37C30201F73F142449D037028D_1267077308 = (80);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117591299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117591299;
        // ---------- Original Method ----------
        //return 80;
    }

    
}

