package libcore.net.url;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class JarHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.021 -0400", hash_original_method = "0A284EE1D1173C3D5D1EE186B211FF85", hash_generated_method = "0A284EE1D1173C3D5D1EE186B211FF85")
    public JarHandler ()
    {
        
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.022 -0400", hash_original_method = "BD0D54E815B3E8434D2BE4AD1DDC7411", hash_generated_method = "6F8022D6E8C552FB7BB2192388996C99")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        addTaint(u.getTaint());
URLConnection varBC9830C330B4B1BAF8EE432E94D30CE4_848329010 =         new JarURLConnectionImpl(u);
        varBC9830C330B4B1BAF8EE432E94D30CE4_848329010.addTaint(taint);
        return varBC9830C330B4B1BAF8EE432E94D30CE4_848329010;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.024 -0400", hash_original_method = "57C5D17E5E318F4D460452A0FAAB1E77", hash_generated_method = "B59F23773568468B2EC6536F9C67AD24")
    @Override
    protected void parseURL(URL url, String spec, int start, int limit) {
        addTaint(limit);
        addTaint(start);
        addTaint(spec.getTaint());
        addTaint(url.getTaint());
        String file = url.getFile();
    if(file == null)        
        {
            file = "";
        } 
    if(limit > start)        
        {
            spec = spec.substring(start, limit);
        } 
        else
        {
            spec = "";
        } 
    if(spec.indexOf("!/") == -1 && (file.indexOf("!/") == -1))        
        {
            NullPointerException var075CFF3EB490981A8C60E519EA96B814_895068997 = new NullPointerException("Cannot find \"!/\"");
            var075CFF3EB490981A8C60E519EA96B814_895068997.addTaint(taint);
            throw var075CFF3EB490981A8C60E519EA96B814_895068997;
        } 
    if(file.isEmpty())        
        {
            file = spec;
        } 
        else
    if(spec.charAt(0) == '/')        
        {
            file = file.substring(0, file.indexOf('!') + 1) + spec;
        } 
        else
        {
            int idx = file.indexOf('!');
            String tmpFile = file.substring(idx + 1, file.lastIndexOf('/') + 1) + spec;
            tmpFile = UrlUtils.canonicalizePath(tmpFile, true);
            file = file.substring(0, idx + 1) + tmpFile;
        } 
        try 
        {
            new URL(file);
        } 
        catch (MalformedURLException e)
        {
            NullPointerException var5806EDD1B41BE5211379EE89A3B93889_2049227130 = new NullPointerException(e.toString());
            var5806EDD1B41BE5211379EE89A3B93889_2049227130.addTaint(taint);
            throw var5806EDD1B41BE5211379EE89A3B93889_2049227130;
        } 
        setURL(url, "jar", "", -1, null, null, file, null, null);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.025 -0400", hash_original_method = "F692A804EFA22D479A24DA08ED26F838", hash_generated_method = "33716B123F6946D77DBAA1AD8C9C95A5")
    @Override
    protected String toExternalForm(URL url) {
        addTaint(url.getTaint());
        StringBuilder sb = new StringBuilder();
        sb.append("jar:");
        sb.append(url.getFile());
        String ref = url.getRef();
    if(ref != null)        
        {
            sb.append(ref);
        } 
String var2460B846747F8B22185AD8BE722266A5_407690457 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_407690457.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_407690457;
        
        
        
        
        
        
            
        
        
    }

    
}

