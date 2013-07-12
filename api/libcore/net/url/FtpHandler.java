package libcore.net.url;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class FtpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.902 -0400", hash_original_method = "D147DA8ADE52659E6B675F3FCB66ABA5", hash_generated_method = "D147DA8ADE52659E6B675F3FCB66ABA5")
    public FtpHandler ()
    {
        
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.902 -0400", hash_original_method = "3C5B2D25E22696E048ED7556D298C58C", hash_generated_method = "EB57CB9585DBCA86AE876AE03E990F8A")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        addTaint(u.getTaint());
URLConnection var66D3170B0CAFB63BFA8B8A0D23096F3D_1566723653 =         new FtpURLConnection(u);
        var66D3170B0CAFB63BFA8B8A0D23096F3D_1566723653.addTaint(taint);
        return var66D3170B0CAFB63BFA8B8A0D23096F3D_1566723653;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.903 -0400", hash_original_method = "1D737A935EF21FF08B15C0F0950C4FF6", hash_generated_method = "BA4E8FF6AC466C2DF7B985F109A6E144")
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        addTaint(url.getTaint());
    if(url == null || proxy == null)        
        {
            IllegalArgumentException var180E1357F474E7208A2DB6FF80901B51_2094662445 = new IllegalArgumentException("url == null || proxy == null");
            var180E1357F474E7208A2DB6FF80901B51_2094662445.addTaint(taint);
            throw var180E1357F474E7208A2DB6FF80901B51_2094662445;
        } 
URLConnection varE1935BC5A46185F4F0C5FA8D5BF30C37_255747242 =         new FtpURLConnection(url, proxy);
        varE1935BC5A46185F4F0C5FA8D5BF30C37_255747242.addTaint(taint);
        return varE1935BC5A46185F4F0C5FA8D5BF30C37_255747242;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.903 -0400", hash_original_method = "EEF2A707E6AE293A2B045747E5BC7948", hash_generated_method = "8D6F2C97295F3AEDCF4A67FC65536D24")
    @Override
    protected int getDefaultPort() {
        int var3C59DC048E8850243BE8079A5C74D079_1163140745 = (21);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767586147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767586147;
        
        
    }

    
}

