package libcore.net.url;

// Droidsafe Imports
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class FtpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.195 -0400", hash_original_method = "D147DA8ADE52659E6B675F3FCB66ABA5", hash_generated_method = "D147DA8ADE52659E6B675F3FCB66ABA5")
    public FtpHandler ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.196 -0400", hash_original_method = "3C5B2D25E22696E048ED7556D298C58C", hash_generated_method = "1985B5C05DD4A9B2CBF948D428659B07")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        addTaint(u.getTaint());
URLConnection var66D3170B0CAFB63BFA8B8A0D23096F3D_185433124 =         new FtpURLConnection(u);
        var66D3170B0CAFB63BFA8B8A0D23096F3D_185433124.addTaint(taint);
        return var66D3170B0CAFB63BFA8B8A0D23096F3D_185433124;
        // ---------- Original Method ----------
        //return new FtpURLConnection(u);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.197 -0400", hash_original_method = "1D737A935EF21FF08B15C0F0950C4FF6", hash_generated_method = "C2629A148786FADAAAA3A42510FDE3BB")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        addTaint(url.getTaint());
        if(url == null || proxy == null)        
        {
            IllegalArgumentException var180E1357F474E7208A2DB6FF80901B51_445329248 = new IllegalArgumentException("url == null || proxy == null");
            var180E1357F474E7208A2DB6FF80901B51_445329248.addTaint(taint);
            throw var180E1357F474E7208A2DB6FF80901B51_445329248;
        } //End block
URLConnection varE1935BC5A46185F4F0C5FA8D5BF30C37_1085529299 =         new FtpURLConnection(url, proxy);
        varE1935BC5A46185F4F0C5FA8D5BF30C37_1085529299.addTaint(taint);
        return varE1935BC5A46185F4F0C5FA8D5BF30C37_1085529299;
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new FtpURLConnection(url, proxy);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.197 -0400", hash_original_method = "EEF2A707E6AE293A2B045747E5BC7948", hash_generated_method = "C250A6265EB29F8EB37DD6E7C152BB0C")
    @Override
    protected int getDefaultPort() {
        int var3C59DC048E8850243BE8079A5C74D079_1501890237 = (21);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254732518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254732518;
        // ---------- Original Method ----------
        //return 21;
    }

    
}

