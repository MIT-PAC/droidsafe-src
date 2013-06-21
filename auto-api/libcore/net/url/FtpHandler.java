package libcore.net.url;

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

public class FtpHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.579 -0400", hash_original_method = "E788A647CC7BF0DC1259CC67E769CE2E", hash_generated_method = "E788A647CC7BF0DC1259CC67E769CE2E")
        public FtpHandler ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.580 -0400", hash_original_method = "3C5B2D25E22696E048ED7556D298C58C", hash_generated_method = "A36A8BCFBD0BEA8BD9B0FCC19AAA861B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        dsTaint.addTaint(u.dsTaint);
        URLConnection varB071E169FB6AEFC8ADC6850774366DA6_135726398 = (new FtpURLConnection(u));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FtpURLConnection(u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.580 -0400", hash_original_method = "1D737A935EF21FF08B15C0F0950C4FF6", hash_generated_method = "496C0F1C5583262B629D80FEB48FE69D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null || proxy == null");
        } //End block
        URLConnection varFFBE35C25E43F019FC59009560CD580D_1808336181 = (new FtpURLConnection(url, proxy));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (url == null || proxy == null) {
            //throw new IllegalArgumentException("url == null || proxy == null");
        //}
        //return new FtpURLConnection(url, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.580 -0400", hash_original_method = "EEF2A707E6AE293A2B045747E5BC7948", hash_generated_method = "970AEE6575D726D05621C3BC9BF9780F")
    @DSModeled(DSC.SAFE)
    @Override
    protected int getDefaultPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 21;
    }

    
}

