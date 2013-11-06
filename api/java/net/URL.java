package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;

import libcore.net.http.HttpHandler;
import libcore.net.http.HttpsHandler;
import libcore.net.url.FileHandler;
import libcore.net.url.FtpHandler;
import libcore.net.url.JarHandler;
import libcore.net.url.UrlUtils;





public final class URL implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.954 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    @DSVAModeled
    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "AC50B8E8CEC0F955316DE9A8EC0AB5AE")

    @DSVAModeled
    private String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    @DSVAModeled
    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "F51DF048A4B5B6B4A61A3652544F4757")

    private int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    @DSVAModeled
    private String file;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "18389A4A9AD5795744699CFF0BA66C15", hash_generated_field = "4B296BDB98B3E9CBEDF6971A25928318")

    @DSVAModeled
    private String ref;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    @DSVAModeled
    private transient String userInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    @DSVAModeled
    private transient String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    @DSVAModeled
    private transient String query;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "F0507048B87501EB491B247BC9108E5B", hash_generated_field = "9DB4BB741418299310AFA5D983E7DA2C")

    transient URLStreamHandler streamHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.955 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "24254DF41EE7E0D088838123A7BE5D39")

    private transient int hashCode;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.956 -0400", hash_original_method = "121BE8263BD1C356B2FE90A678407E92", hash_generated_method = "13BE7CC69BC37CEBA9C3D962CB708488")
    public  URL(String spec) throws MalformedURLException {
        this((URL) null, spec, null);
        addTaint(spec.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.956 -0400", hash_original_method = "472053565B13D456EDCEBEA98F287F95", hash_generated_method = "1FC82ED97C60498A8BEFE74ED7D4AD49")
    public  URL(URL context, String spec) throws MalformedURLException {
        this(context, spec, null);
        addTaint(spec.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.958 -0400", hash_original_method = "D8E146F1F2E4ED207D7672129A3654D5", hash_generated_method = "C0B7B7515CAC4FC5CFA7715468B22DB9")
    public  URL(URL context, String spec, URLStreamHandler handler) throws MalformedURLException {
        if(spec == null)        
        {
            MalformedURLException var21E10CD6C5DF9565D3549D417E79A72D_98390390 = new MalformedURLException();
            var21E10CD6C5DF9565D3549D417E79A72D_98390390.addTaint(taint);
            throw var21E10CD6C5DF9565D3549D417E79A72D_98390390;
        } //End block
        if(handler != null)        
        {
            streamHandler = handler;
        } //End block
        spec = spec.trim();
        protocol = UrlUtils.getSchemePrefix(spec);
        int schemeSpecificPartStart = protocol != null ? (protocol.length() + 1) : 0;
        if(protocol != null && context != null && !protocol.equals(context.protocol))        
        {
            context = null;
        } //End block
        if(context != null)        
        {
            set(context.protocol, context.getHost(), context.getPort(), context.getAuthority(),
                    context.getUserInfo(), context.getPath(), context.getQuery(),
                    context.getRef());
            if(streamHandler == null)            
            {
                streamHandler = context.streamHandler;
            } //End block
        } //End block
        else
        if(protocol == null)        
        {
            MalformedURLException var04557210FB08E0803E5BE7CAA3DD9CD2_168218538 = new MalformedURLException("Protocol not found: " + spec);
            var04557210FB08E0803E5BE7CAA3DD9CD2_168218538.addTaint(taint);
            throw var04557210FB08E0803E5BE7CAA3DD9CD2_168218538;
        } //End block
        if(streamHandler == null)        
        {
            setupStreamHandler();
            if(streamHandler == null)            
            {
                MalformedURLException var07B5C4E77556F57242026F1ADEC49249_2071969799 = new MalformedURLException("Unknown protocol: " + protocol);
                var07B5C4E77556F57242026F1ADEC49249_2071969799.addTaint(taint);
                throw var07B5C4E77556F57242026F1ADEC49249_2071969799;
            } //End block
        } //End block
        try 
        {
            streamHandler.parseURL(this, spec, schemeSpecificPartStart, spec.length());
        } //End block
        catch (Exception e)
        {
            MalformedURLException var3D13077A83788690F2B218CEE7D7BA6E_1351006460 = new MalformedURLException(e.toString());
            var3D13077A83788690F2B218CEE7D7BA6E_1351006460.addTaint(taint);
            throw var3D13077A83788690F2B218CEE7D7BA6E_1351006460;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.959 -0400", hash_original_method = "216BAC89605FCA377BB0AADBB6E2A8AC", hash_generated_method = "0E9F554FB84574D8E27EEE538B96C945")
    public  URL(String protocol, String host, String file) throws MalformedURLException {
        this(protocol, host, -1, file, null);
        addTaint(file.getTaint());
        addTaint(host.getTaint());
        addTaint(protocol.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.960 -0400", hash_original_method = "9AD76E183D70EDC4767A9EAC128427AE", hash_generated_method = "845FEDB43DB0FEF0ACD6E190FCBA2F87")
    public  URL(String protocol, String host, int port, String file) throws MalformedURLException {
        this(protocol, host, port, file, null);
        addTaint(file.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(protocol.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.963 -0400", hash_original_method = "D56485CA0554FF67A28005CBDB936EDB", hash_generated_method = "E928D41A7DD15A7B2279843394690596")
    public  URL(String protocol, String host, int port, String file,
            URLStreamHandler handler) throws MalformedURLException {
        if(port < -1)        
        {
            MalformedURLException var147D9A9055F6D2509E3DA0A51944CDF6_1342076925 = new MalformedURLException("port < -1: " + port);
            var147D9A9055F6D2509E3DA0A51944CDF6_1342076925.addTaint(taint);
            throw var147D9A9055F6D2509E3DA0A51944CDF6_1342076925;
        } //End block
        if(protocol == null)        
        {
            NullPointerException varBD82E106CDE34E01DCE92493FEC93362_179015874 = new NullPointerException("protocol == null");
            varBD82E106CDE34E01DCE92493FEC93362_179015874.addTaint(taint);
            throw varBD82E106CDE34E01DCE92493FEC93362_179015874;
        } //End block
        if(host != null && host.contains(":") && host.charAt(0) != '[')        
        {
            host = "[" + host + "]";
        } //End block
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        file = UrlUtils.authoritySafePath(host, file);
        int hash = file.indexOf("#");
        if(hash != -1)        
        {
            this.file = file.substring(0, hash);
            this.ref = file.substring(hash + 1);
        } //End block
        else
        {
            this.file = file;
        } //End block
        fixURL(false);
        if(handler == null)        
        {
            setupStreamHandler();
            if(streamHandler == null)            
            {
                MalformedURLException var07B5C4E77556F57242026F1ADEC49249_1561886769 = new MalformedURLException("Unknown protocol: " + protocol);
                var07B5C4E77556F57242026F1ADEC49249_1561886769.addTaint(taint);
                throw var07B5C4E77556F57242026F1ADEC49249_1561886769;
            } //End block
        } //End block
        else
        {
            streamHandler = handler;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    public static synchronized void setURLStreamHandlerFactory(URLStreamHandlerFactory factory) {
        if (streamHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        streamHandlers.clear();
        streamHandlerFactory = factory;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.966 -0400", hash_original_method = "0200B051ED19728512FC68E42BCAEC0F", hash_generated_method = "697FAB6A8DB5B2F1D870F4835D2B3AE3")
     void fixURL(boolean fixHost) {
        addTaint(fixHost);
        int index;
        if(host != null && host.length() > 0)        
        {
            authority = host;
            if(port != -1)            
            {
                authority = authority + ":" + port;
            } //End block
        } //End block
        if(fixHost)        
        {
            if(host != null && (index = host.lastIndexOf('@')) > -1)            
            {
                userInfo = host.substring(0, index);
                host = host.substring(index + 1);
            } //End block
            else
            {
                userInfo = null;
            } //End block
        } //End block
        if(file != null && (index = file.indexOf('?')) > -1)        
        {
            query = file.substring(index + 1);
            path = file.substring(0, index);
        } //End block
        else
        {
            query = null;
            path = file;
        } //End block
        // ---------- Original Method ----------
        //int index;
        //if (host != null && host.length() > 0) {
            //authority = host;
            //if (port != -1) {
                //authority = authority + ":" + port;
            //}
        //}
        //if (fixHost) {
            //if (host != null && (index = host.lastIndexOf('@')) > -1) {
                //userInfo = host.substring(0, index);
                //host = host.substring(index + 1);
            //} else {
                //userInfo = null;
            //}
        //}
        //if (file != null && (index = file.indexOf('?')) > -1) {
            //query = file.substring(index + 1);
            //path = file.substring(0, index);
        //} else {
            //query = null;
            //path = file;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.968 -0400", hash_original_method = "2A0889AB616D5EC9F0D1FFB4406777A2", hash_generated_method = "885E3D258598513E84F5DD5D07FD6D0C")
    protected void set(String protocol, String host, int port, String file, String ref) {
        if(this.protocol == null)        
        {
            this.protocol = protocol;
        } //End block
        this.host = host;
        this.file = file;
        this.port = port;
        this.ref = ref;
        hashCode = 0;
        fixURL(true);
        // ---------- Original Method ----------
        //if (this.protocol == null) {
            //this.protocol = protocol;
        //}
        //this.host = host;
        //this.file = file;
        //this.port = port;
        //this.ref = ref;
        //hashCode = 0;
        //fixURL(true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.969 -0400", hash_original_method = "90B240523657DD4FC87B9440FE931EC1", hash_generated_method = "3BC4C463C74503F0CF99105BB749A766")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_158164111 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2124429006 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2124429006;
        } //End block
        if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1053839405 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955363706 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955363706;
        } //End block
        if(this.getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1918081412 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1665755021 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1665755021;
        } //End block
        boolean var3097362AF7B4736FA4D68D8E0A865F72_1285454988 = (streamHandler.equals(this, (URL) o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916320389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_916320389;
        // ---------- Original Method ----------
        //if (o == null) {
            //return false;
        //}
        //if (this == o) {
            //return true;
        //}
        //if (this.getClass() != o.getClass()) {
            //return false;
        //}
        //return streamHandler.equals(this, (URL) o);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.969 -0400", hash_original_method = "0A94C2599C7A34FBFDE0162C017FE126", hash_generated_method = "2B62C4D4949BE47339B2D9102F6EC9DA")
    public boolean sameFile(URL otherURL) {
        addTaint(otherURL.getTaint());
        boolean varAE9A55027BF692184D897B10BAE44CDF_1424649467 = (streamHandler.sameFile(this, otherURL));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484057729 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484057729;
        // ---------- Original Method ----------
        //return streamHandler.sameFile(this, otherURL);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.970 -0400", hash_original_method = "83584D9C6686BC529C911ABE882D39AB", hash_generated_method = "89887402CB71CAD3413C7E9D77F1AA22")
    @Override
    public int hashCode() {
        if(hashCode == 0)        
        {
            hashCode = streamHandler.hashCode(this);
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_768251859 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280442489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280442489;
        // ---------- Original Method ----------
        //if (hashCode == 0) {
            //hashCode = streamHandler.hashCode(this);
        //}
        //return hashCode;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.973 -0400", hash_original_method = "7ED1A4A4DB26C9983DC69C2C091F1C50", hash_generated_method = "A2C53839A7F258C30A8E0D3B86BAAE4B")
     void setupStreamHandler() {
        streamHandler = streamHandlers.get(protocol);
        if(streamHandler != null)        
        {
            return;
        } //End block
        if(streamHandlerFactory != null)        
        {
            streamHandler = streamHandlerFactory.createURLStreamHandler(protocol);
            if(streamHandler != null)            
            {
                streamHandlers.put(protocol, streamHandler);
                return;
            } //End block
        } //End block
        String packageList = System.getProperty("java.protocol.handler.pkgs");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if(packageList != null && contextClassLoader != null)        
        {
for(String packageName : packageList.split("\\|"))
            {
                String className = packageName + "." + protocol + ".Handler";
                try 
                {
                    Class<?> c = contextClassLoader.loadClass(className);
                    streamHandler = (URLStreamHandler) c.newInstance();
                    if(streamHandler != null)                    
                    {
                        streamHandlers.put(protocol, streamHandler);
                    } //End block
                    return;
                } //End block
                catch (IllegalAccessException ignored)
                {
                } //End block
                catch (InstantiationException ignored)
                {
                } //End block
                catch (ClassNotFoundException ignored)
                {
                } //End block
            } //End block
        } //End block
        if(protocol.equals("file"))        
        {
            streamHandler = new FileHandler();
        } //End block
        else
        if(protocol.equals("ftp"))        
        {
            streamHandler = new FtpHandler();
        } //End block
        else
        if(protocol.equals("http"))        
        {
            streamHandler = new HttpHandler();
        } //End block
        else
        if(protocol.equals("https"))        
        {
            streamHandler = new HttpsHandler();
        } //End block
        else
        if(protocol.equals("jar"))        
        {
            streamHandler = new JarHandler();
        } //End block
        if(streamHandler != null)        
        {
            streamHandlers.put(protocol, streamHandler);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.973 -0400", hash_original_method = "D20F85DA45DCC6A1B9E0395104EBE2B6", hash_generated_method = "DCEEABF6D6C76E13AB5400933402D21E")
    public final Object getContent() throws IOException {
Object varB0F4ACE0BCE6830B8B39B3ED2F0664DB_1604793771 =         openConnection().getContent();
        varB0F4ACE0BCE6830B8B39B3ED2F0664DB_1604793771.addTaint(taint);
        return varB0F4ACE0BCE6830B8B39B3ED2F0664DB_1604793771;
        // ---------- Original Method ----------
        //return openConnection().getContent();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.973 -0400", hash_original_method = "D92AC8AC4808B4044341B9D346CCCA3C", hash_generated_method = "3121FB0D7CF7B880AEE328B81C825D6B")
    @SuppressWarnings("unchecked")
    public final Object getContent(Class[] types) throws IOException {
        addTaint(types[0].getTaint());
Object var6F18832B08F01BFE5F09D74E11F75FF3_2064874730 =         openConnection().getContent(types);
        var6F18832B08F01BFE5F09D74E11F75FF3_2064874730.addTaint(taint);
        return var6F18832B08F01BFE5F09D74E11F75FF3_2064874730;
        // ---------- Original Method ----------
        //return openConnection().getContent(types);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.974 -0400", hash_original_method = "EA6B256CF4DB87F83CFE1379BEA78831", hash_generated_method = "78801A6092FC374B64CA0EB1A9832472")
    public final InputStream openStream() throws IOException {
InputStream var87790969037245FCECE93EB13FB59F9E_458691682 =         openConnection().getInputStream();
        var87790969037245FCECE93EB13FB59F9E_458691682.addTaint(taint);
        return var87790969037245FCECE93EB13FB59F9E_458691682;
        // ---------- Original Method ----------
        //return openConnection().getInputStream();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.974 -0400", hash_original_method = "DDCF57687ACF51357E563F1083DC4261", hash_generated_method = "59A0D749A7D681DCF183E55E7A4985AB")
    public URLConnection openConnection() throws IOException {
URLConnection var8582ACACD5693CAF10280320B49B91CB_74152353 =         streamHandler.openConnection(this);
        var8582ACACD5693CAF10280320B49B91CB_74152353.addTaint(taint);
        return var8582ACACD5693CAF10280320B49B91CB_74152353;
        // ---------- Original Method ----------
        //return streamHandler.openConnection(this);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.974 -0400", hash_original_method = "CB72409718452D46955A0A85FC179645", hash_generated_method = "562A3F5A8E96C4C5ED979B90685726A4")
    public URLConnection openConnection(Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        if(proxy == null)        
        {
            IllegalArgumentException varA2CA76786F4D0E32C2985C5E02216614_1229883404 = new IllegalArgumentException("proxy == null");
            varA2CA76786F4D0E32C2985C5E02216614_1229883404.addTaint(taint);
            throw varA2CA76786F4D0E32C2985C5E02216614_1229883404;
        } //End block
URLConnection varA729B66CE0E41412E468FE52B258A462_1050846200 =         streamHandler.openConnection(this, proxy);
        varA729B66CE0E41412E468FE52B258A462_1050846200.addTaint(taint);
        return varA729B66CE0E41412E468FE52B258A462_1050846200;
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException("proxy == null");
        //}
        //return streamHandler.openConnection(this, proxy);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.974 -0400", hash_original_method = "1E43ADB2B24E4AEE234C287749830ABE", hash_generated_method = "56B278D83B0990C3BD022AFC4EDF3FCF")
    public URI toURI() throws URISyntaxException {
URI varABE6DEE154A7C8840C60A090742E451F_948675775 =         new URI(toExternalForm());
        varABE6DEE154A7C8840C60A090742E451F_948675775.addTaint(taint);
        return varABE6DEE154A7C8840C60A090742E451F_948675775;
        // ---------- Original Method ----------
        //return new URI(toExternalForm());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.974 -0400", hash_original_method = "9819CA3EECC28CF10D8C0CAB99E6CDCB", hash_generated_method = "61E6D29F4A01AF10B238288AC786F182")
    public URI toURILenient() throws URISyntaxException {
        if(streamHandler == null)        
        {
            IllegalStateException varB67EB4FE074D3BB8A5D6AA83D471E820_997052477 = new IllegalStateException(protocol);
            varB67EB4FE074D3BB8A5D6AA83D471E820_997052477.addTaint(taint);
            throw varB67EB4FE074D3BB8A5D6AA83D471E820_997052477;
        } //End block
URI var0E4EEE42069389967BAFD78A4351D211_204176553 =         new URI(streamHandler.toExternalForm(this, true));
        var0E4EEE42069389967BAFD78A4351D211_204176553.addTaint(taint);
        return var0E4EEE42069389967BAFD78A4351D211_204176553;
        // ---------- Original Method ----------
        //if (streamHandler == null) {
            //throw new IllegalStateException(protocol);
        //}
        //return new URI(streamHandler.toExternalForm(this, true));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.974 -0400", hash_original_method = "9D75BD75136BEBAB4AE2F806E85803AD", hash_generated_method = "EEF37F53EDEA99043DA9AEB95F169ED8")
    @Override
    public String toString() {
String varF1450660D1DB6B63C9B83A42FD23AFF4_1089094139 =         toExternalForm();
        varF1450660D1DB6B63C9B83A42FD23AFF4_1089094139.addTaint(taint);
        return varF1450660D1DB6B63C9B83A42FD23AFF4_1089094139;
        // ---------- Original Method ----------
        //return toExternalForm();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.975 -0400", hash_original_method = "6763BB94BC9C65378EF7195BF94F5BED", hash_generated_method = "ACF3E5B31DE51D0A38B73B367D8CC436")
    public String toExternalForm() {
        if(streamHandler == null)        
        {
String var4719CC78653EB410AA0D53C0ADA4DFAC_317018758 =             "unknown protocol(" + protocol + ")://" + host + file;
            var4719CC78653EB410AA0D53C0ADA4DFAC_317018758.addTaint(taint);
            return var4719CC78653EB410AA0D53C0ADA4DFAC_317018758;
        } //End block
String varDCCA36446C90D2AF904BB9935AD90339_445251136 =         streamHandler.toExternalForm(this);
        varDCCA36446C90D2AF904BB9935AD90339_445251136.addTaint(taint);
        return varDCCA36446C90D2AF904BB9935AD90339_445251136;
        // ---------- Original Method ----------
        //if (streamHandler == null) {
            //return "unknown protocol(" + protocol + ")://" + host + file;
        //}
        //return streamHandler.toExternalForm(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.975 -0400", hash_original_method = "75E256B9492C6227D987E1CACFC70E15", hash_generated_method = "ECA034582473802248444DA9346C43CD")
    private void readObject(ObjectInputStream stream) throws IOException {
        addTaint(stream.getTaint());
        try 
        {
            stream.defaultReadObject();
            if(host != null && authority == null)            
            {
                fixURL(true);
            } //End block
            else
            if(authority != null)            
            {
                int index;
                if((index = authority.lastIndexOf('@')) > -1)                
                {
                    userInfo = authority.substring(0, index);
                } //End block
                if(file != null && (index = file.indexOf('?')) > -1)                
                {
                    query = file.substring(index + 1);
                    path = file.substring(0, index);
                } //End block
                else
                {
                    path = file;
                } //End block
            } //End block
            setupStreamHandler();
            if(streamHandler == null)            
            {
                IOException varBE99800DB77FD16EF6EB16B9F3CFFF88_74872062 = new IOException("Unknown protocol: " + protocol);
                varBE99800DB77FD16EF6EB16B9F3CFFF88_74872062.addTaint(taint);
                throw varBE99800DB77FD16EF6EB16B9F3CFFF88_74872062;
            } //End block
            hashCode = 0;
        } //End block
        catch (ClassNotFoundException e)
        {
            IOException var0AFB0468CE17165C7EF7344B3E18B39B_730984192 = new IOException(e);
            var0AFB0468CE17165C7EF7344B3E18B39B_730984192.addTaint(taint);
            throw var0AFB0468CE17165C7EF7344B3E18B39B_730984192;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.976 -0400", hash_original_method = "CCBF13D66B2182AA6C1A2589205C2944", hash_generated_method = "459B5EABAB5975823B4693DE8F7B3CFD")
    private void writeObject(ObjectOutputStream s) throws IOException {
        addTaint(s.getTaint());
        s.defaultWriteObject();
        // ---------- Original Method ----------
        //s.defaultWriteObject();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.976 -0400", hash_original_method = "89A7E9DBD8F7AF35FA9A39C4922A8C55", hash_generated_method = "8F7B1D3003452A9A142C344C81F71116")
    public int getEffectivePort() {
        int varE15514297653782693CCA4CFFA420DFA_1753444195 = (URI.getEffectivePort(protocol, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418571792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418571792;
        // ---------- Original Method ----------
        //return URI.getEffectivePort(protocol, port);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.976 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "D8734FD61F76B4C1B1FCDC672E32B5D2")
    public String getProtocol() {
String varDD56EE388A0FA5696BF9686AC14D2DB9_1130296774 =         protocol;
        varDD56EE388A0FA5696BF9686AC14D2DB9_1130296774.addTaint(taint);
        return varDD56EE388A0FA5696BF9686AC14D2DB9_1130296774;
        // ---------- Original Method ----------
        //return protocol;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.976 -0400", hash_original_method = "36971585CF0AC7121D34C5DBA5E7B5AD", hash_generated_method = "6FF168DDD230213579EA93E43D2024F7")
    public String getAuthority() {
String var9A4A00E403B4898E9807F68E9EBE5A8B_368923552 =         authority;
        var9A4A00E403B4898E9807F68E9EBE5A8B_368923552.addTaint(taint);
        return var9A4A00E403B4898E9807F68E9EBE5A8B_368923552;
        // ---------- Original Method ----------
        //return authority;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.976 -0400", hash_original_method = "C7599F6C2A9D16B1F9E84177D4C93D75", hash_generated_method = "BDE25038957752C9D639FF066EE9C445")
    public String getUserInfo() {
String varBCE8ED9572054839A8E4DF19F3B230E6_1937916757 =         userInfo;
        varBCE8ED9572054839A8E4DF19F3B230E6_1937916757.addTaint(taint);
        return varBCE8ED9572054839A8E4DF19F3B230E6_1937916757;
        // ---------- Original Method ----------
        //return userInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.976 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "2197E5999B9D6AE6DB9C9E6AFDA791D3")
    public String getHost() {
String var872E07117C05F1A34EC24B57B694B8E3_1211680955 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_1211680955.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_1211680955;
        // ---------- Original Method ----------
        //return host;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.977 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "A7D83767E9408D17CA20E12D6433FC8B")
    public int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1550086011 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_42817125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_42817125;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.977 -0400", hash_original_method = "7E7EF83BCD62492BD0A03823F89518D0", hash_generated_method = "439CC37B3EF052676743A9626F820467")
    public int getDefaultPort() {
        int varF99D024E2841DC2797F7FC2BFC4F023E_2044476470 = (streamHandler.getDefaultPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131268360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131268360;
        // ---------- Original Method ----------
        //return streamHandler.getDefaultPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.977 -0400", hash_original_method = "D4C7450F6A022BC4DF89D66487C9A55A", hash_generated_method = "C6F010E71395B415DF29F8DA9CDDB3F1")
    public String getFile() {
String varADCB75793FA1DABACC5DEBFFAE466050_450321743 =         file;
        varADCB75793FA1DABACC5DEBFFAE466050_450321743.addTaint(taint);
        return varADCB75793FA1DABACC5DEBFFAE466050_450321743;
        // ---------- Original Method ----------
        //return file;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.977 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "B8153187DA53AD69BF3985481C72230C")
    public String getPath() {
String var535F4D9720F3B0C96D8143873CE0638C_1844985773 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1844985773.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1844985773;
        // ---------- Original Method ----------
        //return path;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.977 -0400", hash_original_method = "1E279BC97111B7B33A732EF157351512", hash_generated_method = "59E820923D0FB356AEDFDE512DF85B3C")
    public String getQuery() {
String varA8A0683638E4CE91D85122D8CD8F3BAC_694935162 =         query;
        varA8A0683638E4CE91D85122D8CD8F3BAC_694935162.addTaint(taint);
        return varA8A0683638E4CE91D85122D8CD8F3BAC_694935162;
        // ---------- Original Method ----------
        //return query;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.977 -0400", hash_original_method = "3AAC0179CDFA195C747754E7ED20A392", hash_generated_method = "5BE4C407405310F48D9F756575806DBD")
    public String getRef() {
String varEFC1DBC79AB9D4D6FF46C815132543A5_425696635 =         ref;
        varEFC1DBC79AB9D4D6FF46C815132543A5_425696635.addTaint(taint);
        return varEFC1DBC79AB9D4D6FF46C815132543A5_425696635;
        // ---------- Original Method ----------
        //return ref;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.978 -0400", hash_original_method = "1BAF8E8ECD99ADEA9022FFFFA6473F49", hash_generated_method = "28782146E8A5E535E621C73BE398F329")
    protected void set(String protocol, String host, int port, String authority, String userInfo,
            String path, String query, String ref) {
        addTaint(ref.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(protocol.getTaint());
        String file = path;
        if(query != null && !query.isEmpty())        
        {
            file += "?" + query;
        } //End block
        set(protocol, host, port, file, ref);
        this.authority = authority;
        this.userInfo = userInfo;
        this.path = path;
        this.query = query;
        // ---------- Original Method ----------
        //String file = path;
        //if (query != null && !query.isEmpty()) {
            //file += "?" + query;
        //}
        //set(protocol, host, port, file, ref);
        //this.authority = authority;
        //this.userInfo = userInfo;
        //this.path = path;
        //this.query = query;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.978 -0400", hash_original_field = "C22D4AF53333AE18B0F8405C700A3CD9", hash_generated_field = "8D4046C0B22D26C3D18782292CFAEA41")

    private static final long serialVersionUID = -7627629688361524110L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.978 -0400", hash_original_field = "6824D48C614C929FBCD354F1F146A997", hash_generated_field = "7C5EE8C1A882C933CC017CE2A46222A0")

    private static URLStreamHandlerFactory streamHandlerFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.978 -0400", hash_original_field = "C51FCA48EDF9E5102BD4313C897B9579", hash_generated_field = "16539CC8BECB892A33EEA156DBF8E5B0")

    private static final Hashtable<String, URLStreamHandler> streamHandlers = new Hashtable<String, URLStreamHandler>();
}

