package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class JarHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.324 -0400", hash_original_method = "0A284EE1D1173C3D5D1EE186B211FF85", hash_generated_method = "0A284EE1D1173C3D5D1EE186B211FF85")
    public JarHandler ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.325 -0400", hash_original_method = "BD0D54E815B3E8434D2BE4AD1DDC7411", hash_generated_method = "689204F9794709363BC4139FB0066FA9")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        addTaint(u.getTaint());
URLConnection varBC9830C330B4B1BAF8EE432E94D30CE4_932355748 =         new JarURLConnectionImpl(u);
        varBC9830C330B4B1BAF8EE432E94D30CE4_932355748.addTaint(taint);
        return varBC9830C330B4B1BAF8EE432E94D30CE4_932355748;
        // ---------- Original Method ----------
        //return new JarURLConnectionImpl(u);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.327 -0400", hash_original_method = "57C5D17E5E318F4D460452A0FAAB1E77", hash_generated_method = "52F7D06F01DE2F1B4CE25E1BAC7B0747")
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
        } //End block
        if(limit > start)        
        {
            spec = spec.substring(start, limit);
        } //End block
        else
        {
            spec = "";
        } //End block
        if(spec.indexOf("!/") == -1 && (file.indexOf("!/") == -1))        
        {
            NullPointerException var075CFF3EB490981A8C60E519EA96B814_383516115 = new NullPointerException("Cannot find \"!/\"");
            var075CFF3EB490981A8C60E519EA96B814_383516115.addTaint(taint);
            throw var075CFF3EB490981A8C60E519EA96B814_383516115;
        } //End block
        if(file.isEmpty())        
        {
            file = spec;
        } //End block
        else
        if(spec.charAt(0) == '/')        
        {
            file = file.substring(0, file.indexOf('!') + 1) + spec;
        } //End block
        else
        {
            int idx = file.indexOf('!');
            String tmpFile = file.substring(idx + 1, file.lastIndexOf('/') + 1) + spec;
            tmpFile = UrlUtils.canonicalizePath(tmpFile, true);
            file = file.substring(0, idx + 1) + tmpFile;
        } //End block
        try 
        {
            new URL(file);
        } //End block
        catch (MalformedURLException e)
        {
            NullPointerException var5806EDD1B41BE5211379EE89A3B93889_1509129767 = new NullPointerException(e.toString());
            var5806EDD1B41BE5211379EE89A3B93889_1509129767.addTaint(taint);
            throw var5806EDD1B41BE5211379EE89A3B93889_1509129767;
        } //End block
        setURL(url, "jar", "", -1, null, null, file, null, null);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.328 -0400", hash_original_method = "F692A804EFA22D479A24DA08ED26F838", hash_generated_method = "E4A84F165325C6C8EA6E3FF5DE3691C3")
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
        } //End block
String var2460B846747F8B22185AD8BE722266A5_524910826 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_524910826.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_524910826;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("jar:");
        //sb.append(url.getFile());
        //String ref = url.getRef();
        //if (ref != null) {
            //sb.append(ref);
        //}
        //return sb.toString();
    }

    
}

