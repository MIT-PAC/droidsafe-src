package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.jar.JarFile;
import libcore.net.http.HttpHandler;
import libcore.net.http.HttpsHandler;
import libcore.net.url.FileHandler;
import libcore.net.url.FtpHandler;
import libcore.net.url.JarHandler;
import libcore.net.url.UrlUtils;

public final class URL implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.683 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.683 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "AC50B8E8CEC0F955316DE9A8EC0AB5AE")

    private String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.683 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.683 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "F51DF048A4B5B6B4A61A3652544F4757")

    private int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.683 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    private String file;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.683 -0400", hash_original_field = "18389A4A9AD5795744699CFF0BA66C15", hash_generated_field = "4B296BDB98B3E9CBEDF6971A25928318")

    private String ref;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.683 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    private transient String userInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.683 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    private transient String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.684 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    private transient String query;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.684 -0400", hash_original_field = "F0507048B87501EB491B247BC9108E5B", hash_generated_field = "9DB4BB741418299310AFA5D983E7DA2C")

    transient URLStreamHandler streamHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.684 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "24254DF41EE7E0D088838123A7BE5D39")

    private transient int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.684 -0400", hash_original_method = "121BE8263BD1C356B2FE90A678407E92", hash_generated_method = "13BE7CC69BC37CEBA9C3D962CB708488")
    public  URL(String spec) throws MalformedURLException {
        this((URL) null, spec, null);
        addTaint(spec.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.684 -0400", hash_original_method = "472053565B13D456EDCEBEA98F287F95", hash_generated_method = "1FC82ED97C60498A8BEFE74ED7D4AD49")
    public  URL(URL context, String spec) throws MalformedURLException {
        this(context, spec, null);
        addTaint(spec.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.686 -0400", hash_original_method = "D8E146F1F2E4ED207D7672129A3654D5", hash_generated_method = "08FA0B6D4641F97A4A109972255F336C")
    public  URL(URL context, String spec, URLStreamHandler handler) throws MalformedURLException {
    if(spec == null)        
        {
            MalformedURLException var21E10CD6C5DF9565D3549D417E79A72D_675274019 = new MalformedURLException();
            var21E10CD6C5DF9565D3549D417E79A72D_675274019.addTaint(taint);
            throw var21E10CD6C5DF9565D3549D417E79A72D_675274019;
        } 
    if(handler != null)        
        {
            streamHandler = handler;
        } 
        spec = spec.trim();
        protocol = UrlUtils.getSchemePrefix(spec);
        int schemeSpecificPartStart = protocol != null ? (protocol.length() + 1) : 0;
    if(protocol != null && context != null && !protocol.equals(context.protocol))        
        {
            context = null;
        } 
    if(context != null)        
        {
            set(context.protocol, context.getHost(), context.getPort(), context.getAuthority(),
                    context.getUserInfo(), context.getPath(), context.getQuery(),
                    context.getRef());
    if(streamHandler == null)            
            {
                streamHandler = context.streamHandler;
            } 
        } 
        else
    if(protocol == null)        
        {
            MalformedURLException var04557210FB08E0803E5BE7CAA3DD9CD2_613158642 = new MalformedURLException("Protocol not found: " + spec);
            var04557210FB08E0803E5BE7CAA3DD9CD2_613158642.addTaint(taint);
            throw var04557210FB08E0803E5BE7CAA3DD9CD2_613158642;
        } 
    if(streamHandler == null)        
        {
            setupStreamHandler();
    if(streamHandler == null)            
            {
                MalformedURLException var07B5C4E77556F57242026F1ADEC49249_818230725 = new MalformedURLException("Unknown protocol: " + protocol);
                var07B5C4E77556F57242026F1ADEC49249_818230725.addTaint(taint);
                throw var07B5C4E77556F57242026F1ADEC49249_818230725;
            } 
        } 
        try 
        {
            streamHandler.parseURL(this, spec, schemeSpecificPartStart, spec.length());
        } 
        catch (Exception e)
        {
            MalformedURLException var3D13077A83788690F2B218CEE7D7BA6E_122847849 = new MalformedURLException(e.toString());
            var3D13077A83788690F2B218CEE7D7BA6E_122847849.addTaint(taint);
            throw var3D13077A83788690F2B218CEE7D7BA6E_122847849;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.687 -0400", hash_original_method = "216BAC89605FCA377BB0AADBB6E2A8AC", hash_generated_method = "0E9F554FB84574D8E27EEE538B96C945")
    public  URL(String protocol, String host, String file) throws MalformedURLException {
        this(protocol, host, -1, file, null);
        addTaint(file.getTaint());
        addTaint(host.getTaint());
        addTaint(protocol.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.687 -0400", hash_original_method = "9AD76E183D70EDC4767A9EAC128427AE", hash_generated_method = "845FEDB43DB0FEF0ACD6E190FCBA2F87")
    public  URL(String protocol, String host, int port, String file) throws MalformedURLException {
        this(protocol, host, port, file, null);
        addTaint(file.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(protocol.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.690 -0400", hash_original_method = "D56485CA0554FF67A28005CBDB936EDB", hash_generated_method = "CF659BB4C22E1F664C8D7D30382E4C12")
    public  URL(String protocol, String host, int port, String file,
            URLStreamHandler handler) throws MalformedURLException {
    if(port < -1)        
        {
            MalformedURLException var147D9A9055F6D2509E3DA0A51944CDF6_1549006405 = new MalformedURLException("port < -1: " + port);
            var147D9A9055F6D2509E3DA0A51944CDF6_1549006405.addTaint(taint);
            throw var147D9A9055F6D2509E3DA0A51944CDF6_1549006405;
        } 
    if(protocol == null)        
        {
            NullPointerException varBD82E106CDE34E01DCE92493FEC93362_714353774 = new NullPointerException("protocol == null");
            varBD82E106CDE34E01DCE92493FEC93362_714353774.addTaint(taint);
            throw varBD82E106CDE34E01DCE92493FEC93362_714353774;
        } 
    if(host != null && host.contains(":") && host.charAt(0) != '[')        
        {
            host = "[" + host + "]";
        } 
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        file = UrlUtils.authoritySafePath(host, file);
        int hash = file.indexOf("#");
    if(hash != -1)        
        {
            this.file = file.substring(0, hash);
            this.ref = file.substring(hash + 1);
        } 
        else
        {
            this.file = file;
        } 
        fixURL(false);
    if(handler == null)        
        {
            setupStreamHandler();
    if(streamHandler == null)            
            {
                MalformedURLException var07B5C4E77556F57242026F1ADEC49249_1616867905 = new MalformedURLException("Unknown protocol: " + protocol);
                var07B5C4E77556F57242026F1ADEC49249_1616867905.addTaint(taint);
                throw var07B5C4E77556F57242026F1ADEC49249_1616867905;
            } 
        } 
        else
        {
            streamHandler = handler;
        } 
        
        
    }

    
        public static synchronized void setURLStreamHandlerFactory(URLStreamHandlerFactory factory) {
        if (streamHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        streamHandlers.clear();
        streamHandlerFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.693 -0400", hash_original_method = "0200B051ED19728512FC68E42BCAEC0F", hash_generated_method = "697FAB6A8DB5B2F1D870F4835D2B3AE3")
     void fixURL(boolean fixHost) {
        addTaint(fixHost);
        int index;
    if(host != null && host.length() > 0)        
        {
            authority = host;
    if(port != -1)            
            {
                authority = authority + ":" + port;
            } 
        } 
    if(fixHost)        
        {
    if(host != null && (index = host.lastIndexOf('@')) > -1)            
            {
                userInfo = host.substring(0, index);
                host = host.substring(index + 1);
            } 
            else
            {
                userInfo = null;
            } 
        } 
    if(file != null && (index = file.indexOf('?')) > -1)        
        {
            query = file.substring(index + 1);
            path = file.substring(0, index);
        } 
        else
        {
            query = null;
            path = file;
        } 
        
        
        
            
            
                
            
        
        
            
                
                
            
                
            
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.695 -0400", hash_original_method = "2A0889AB616D5EC9F0D1FFB4406777A2", hash_generated_method = "885E3D258598513E84F5DD5D07FD6D0C")
    protected void set(String protocol, String host, int port, String file, String ref) {
    if(this.protocol == null)        
        {
            this.protocol = protocol;
        } 
        this.host = host;
        this.file = file;
        this.port = port;
        this.ref = ref;
        hashCode = 0;
        fixURL(true);
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.696 -0400", hash_original_method = "90B240523657DD4FC87B9440FE931EC1", hash_generated_method = "3A788EB7ABC1AF0EF894271556ADD0CC")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_874604616 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1906605651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1906605651;
        } 
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_716750246 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059530547 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059530547;
        } 
    if(this.getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_2072535024 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_869876348 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_869876348;
        } 
        boolean var3097362AF7B4736FA4D68D8E0A865F72_1748677094 = (streamHandler.equals(this, (URL) o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982691686 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982691686;
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.697 -0400", hash_original_method = "0A94C2599C7A34FBFDE0162C017FE126", hash_generated_method = "830817A3A3EFD5FBEC94E746CF6D05FE")
    public boolean sameFile(URL otherURL) {
        addTaint(otherURL.getTaint());
        boolean varAE9A55027BF692184D897B10BAE44CDF_1399967410 = (streamHandler.sameFile(this, otherURL));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2090711758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2090711758;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.698 -0400", hash_original_method = "83584D9C6686BC529C911ABE882D39AB", hash_generated_method = "C531326B5769BD1788F3FF1C0993150C")
    @Override
    public int hashCode() {
    if(hashCode == 0)        
        {
            hashCode = streamHandler.hashCode(this);
        } 
        int var550D1CC054A1B23A411DDDA46FD64811_220183903 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999568282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_999568282;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.708 -0400", hash_original_method = "7ED1A4A4DB26C9983DC69C2C091F1C50", hash_generated_method = "A2C53839A7F258C30A8E0D3B86BAAE4B")
     void setupStreamHandler() {
        streamHandler = streamHandlers.get(protocol);
    if(streamHandler != null)        
        {
            return;
        } 
    if(streamHandlerFactory != null)        
        {
            streamHandler = streamHandlerFactory.createURLStreamHandler(protocol);
    if(streamHandler != null)            
            {
                streamHandlers.put(protocol, streamHandler);
                return;
            } 
        } 
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
                    } 
                    return;
                } 
                catch (IllegalAccessException ignored)
                {
                } 
                catch (InstantiationException ignored)
                {
                } 
                catch (ClassNotFoundException ignored)
                {
                } 
            } 
        } 
    if(protocol.equals("file"))        
        {
            streamHandler = new FileHandler();
        } 
        else
    if(protocol.equals("ftp"))        
        {
            streamHandler = new FtpHandler();
        } 
        else
    if(protocol.equals("http"))        
        {
            streamHandler = new HttpHandler();
        } 
        else
    if(protocol.equals("https"))        
        {
            streamHandler = new HttpsHandler();
        } 
        else
    if(protocol.equals("jar"))        
        {
            streamHandler = new JarHandler();
        } 
    if(streamHandler != null)        
        {
            streamHandlers.put(protocol, streamHandler);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.709 -0400", hash_original_method = "D20F85DA45DCC6A1B9E0395104EBE2B6", hash_generated_method = "C052AF35F49FD0C6024BDAACCC086D6B")
    public final Object getContent() throws IOException {
Object varB0F4ACE0BCE6830B8B39B3ED2F0664DB_866478963 =         openConnection().getContent();
        varB0F4ACE0BCE6830B8B39B3ED2F0664DB_866478963.addTaint(taint);
        return varB0F4ACE0BCE6830B8B39B3ED2F0664DB_866478963;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.709 -0400", hash_original_method = "D92AC8AC4808B4044341B9D346CCCA3C", hash_generated_method = "0DE31125019DAFC488F1909B1B00470E")
    @SuppressWarnings("unchecked")
    public final Object getContent(Class[] types) throws IOException {
        addTaint(types[0].getTaint());
Object var6F18832B08F01BFE5F09D74E11F75FF3_1622891008 =         openConnection().getContent(types);
        var6F18832B08F01BFE5F09D74E11F75FF3_1622891008.addTaint(taint);
        return var6F18832B08F01BFE5F09D74E11F75FF3_1622891008;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.710 -0400", hash_original_method = "EA6B256CF4DB87F83CFE1379BEA78831", hash_generated_method = "194F32FF670D4273B8ADECC9109FB271")
    public final InputStream openStream() throws IOException {
InputStream var87790969037245FCECE93EB13FB59F9E_748581088 =         openConnection().getInputStream();
        var87790969037245FCECE93EB13FB59F9E_748581088.addTaint(taint);
        return var87790969037245FCECE93EB13FB59F9E_748581088;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.710 -0400", hash_original_method = "DDCF57687ACF51357E563F1083DC4261", hash_generated_method = "54BAA54B735E9710130224DE75114FA6")
    public URLConnection openConnection() throws IOException {
URLConnection var8582ACACD5693CAF10280320B49B91CB_882327094 =         streamHandler.openConnection(this);
        var8582ACACD5693CAF10280320B49B91CB_882327094.addTaint(taint);
        return var8582ACACD5693CAF10280320B49B91CB_882327094;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.710 -0400", hash_original_method = "CB72409718452D46955A0A85FC179645", hash_generated_method = "EC9DE282DE60BAC0AEC65896F5A1B422")
    public URLConnection openConnection(Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
    if(proxy == null)        
        {
            IllegalArgumentException varA2CA76786F4D0E32C2985C5E02216614_881536532 = new IllegalArgumentException("proxy == null");
            varA2CA76786F4D0E32C2985C5E02216614_881536532.addTaint(taint);
            throw varA2CA76786F4D0E32C2985C5E02216614_881536532;
        } 
URLConnection varA729B66CE0E41412E468FE52B258A462_1617134805 =         streamHandler.openConnection(this, proxy);
        varA729B66CE0E41412E468FE52B258A462_1617134805.addTaint(taint);
        return varA729B66CE0E41412E468FE52B258A462_1617134805;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.711 -0400", hash_original_method = "1E43ADB2B24E4AEE234C287749830ABE", hash_generated_method = "88FCA175EB07FF87A1A2F13E3370C0B9")
    public URI toURI() throws URISyntaxException {
URI varABE6DEE154A7C8840C60A090742E451F_358152102 =         new URI(toExternalForm());
        varABE6DEE154A7C8840C60A090742E451F_358152102.addTaint(taint);
        return varABE6DEE154A7C8840C60A090742E451F_358152102;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.711 -0400", hash_original_method = "9819CA3EECC28CF10D8C0CAB99E6CDCB", hash_generated_method = "00058F7242FE59A76513679ECFA404C9")
    public URI toURILenient() throws URISyntaxException {
    if(streamHandler == null)        
        {
            IllegalStateException varB67EB4FE074D3BB8A5D6AA83D471E820_1013779266 = new IllegalStateException(protocol);
            varB67EB4FE074D3BB8A5D6AA83D471E820_1013779266.addTaint(taint);
            throw varB67EB4FE074D3BB8A5D6AA83D471E820_1013779266;
        } 
URI var0E4EEE42069389967BAFD78A4351D211_119732909 =         new URI(streamHandler.toExternalForm(this, true));
        var0E4EEE42069389967BAFD78A4351D211_119732909.addTaint(taint);
        return var0E4EEE42069389967BAFD78A4351D211_119732909;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.712 -0400", hash_original_method = "9D75BD75136BEBAB4AE2F806E85803AD", hash_generated_method = "02A9719775B26738CC1F6014606E4B2B")
    @Override
    public String toString() {
String varF1450660D1DB6B63C9B83A42FD23AFF4_611615391 =         toExternalForm();
        varF1450660D1DB6B63C9B83A42FD23AFF4_611615391.addTaint(taint);
        return varF1450660D1DB6B63C9B83A42FD23AFF4_611615391;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.712 -0400", hash_original_method = "6763BB94BC9C65378EF7195BF94F5BED", hash_generated_method = "756F8F905BE20D36C28BB61745633EF8")
    public String toExternalForm() {
    if(streamHandler == null)        
        {
String var4719CC78653EB410AA0D53C0ADA4DFAC_1175615624 =             "unknown protocol(" + protocol + ")://" + host + file;
            var4719CC78653EB410AA0D53C0ADA4DFAC_1175615624.addTaint(taint);
            return var4719CC78653EB410AA0D53C0ADA4DFAC_1175615624;
        } 
String varDCCA36446C90D2AF904BB9935AD90339_1358681858 =         streamHandler.toExternalForm(this);
        varDCCA36446C90D2AF904BB9935AD90339_1358681858.addTaint(taint);
        return varDCCA36446C90D2AF904BB9935AD90339_1358681858;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.714 -0400", hash_original_method = "75E256B9492C6227D987E1CACFC70E15", hash_generated_method = "3862BF96FD56FDB95E4CC8C91F183870")
    private void readObject(ObjectInputStream stream) throws IOException {
        addTaint(stream.getTaint());
        try 
        {
            stream.defaultReadObject();
    if(host != null && authority == null)            
            {
                fixURL(true);
            } 
            else
    if(authority != null)            
            {
                int index;
    if((index = authority.lastIndexOf('@')) > -1)                
                {
                    userInfo = authority.substring(0, index);
                } 
    if(file != null && (index = file.indexOf('?')) > -1)                
                {
                    query = file.substring(index + 1);
                    path = file.substring(0, index);
                } 
                else
                {
                    path = file;
                } 
            } 
            setupStreamHandler();
    if(streamHandler == null)            
            {
                IOException varBE99800DB77FD16EF6EB16B9F3CFFF88_309726684 = new IOException("Unknown protocol: " + protocol);
                varBE99800DB77FD16EF6EB16B9F3CFFF88_309726684.addTaint(taint);
                throw varBE99800DB77FD16EF6EB16B9F3CFFF88_309726684;
            } 
            hashCode = 0;
        } 
        catch (ClassNotFoundException e)
        {
            IOException var0AFB0468CE17165C7EF7344B3E18B39B_12518811 = new IOException(e);
            var0AFB0468CE17165C7EF7344B3E18B39B_12518811.addTaint(taint);
            throw var0AFB0468CE17165C7EF7344B3E18B39B_12518811;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.715 -0400", hash_original_method = "CCBF13D66B2182AA6C1A2589205C2944", hash_generated_method = "459B5EABAB5975823B4693DE8F7B3CFD")
    private void writeObject(ObjectOutputStream s) throws IOException {
        addTaint(s.getTaint());
        s.defaultWriteObject();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.715 -0400", hash_original_method = "89A7E9DBD8F7AF35FA9A39C4922A8C55", hash_generated_method = "E6B208C2CBA42A7574C2A832404786C5")
    public int getEffectivePort() {
        int varE15514297653782693CCA4CFFA420DFA_1438168607 = (URI.getEffectivePort(protocol, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423752086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423752086;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.715 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "025E4EBEDB7DAAFAF4BF77BDB998E9C4")
    public String getProtocol() {
String varDD56EE388A0FA5696BF9686AC14D2DB9_577842848 =         protocol;
        varDD56EE388A0FA5696BF9686AC14D2DB9_577842848.addTaint(taint);
        return varDD56EE388A0FA5696BF9686AC14D2DB9_577842848;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.716 -0400", hash_original_method = "36971585CF0AC7121D34C5DBA5E7B5AD", hash_generated_method = "A8D109BADDBE5829CE185817A209E476")
    public String getAuthority() {
String var9A4A00E403B4898E9807F68E9EBE5A8B_422789349 =         authority;
        var9A4A00E403B4898E9807F68E9EBE5A8B_422789349.addTaint(taint);
        return var9A4A00E403B4898E9807F68E9EBE5A8B_422789349;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.716 -0400", hash_original_method = "C7599F6C2A9D16B1F9E84177D4C93D75", hash_generated_method = "07A93642F9340B235CB898D1A139C666")
    public String getUserInfo() {
String varBCE8ED9572054839A8E4DF19F3B230E6_856925868 =         userInfo;
        varBCE8ED9572054839A8E4DF19F3B230E6_856925868.addTaint(taint);
        return varBCE8ED9572054839A8E4DF19F3B230E6_856925868;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.716 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "ED842AF5D195484C206BDAC974F05AC3")
    public String getHost() {
String var872E07117C05F1A34EC24B57B694B8E3_1244493231 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_1244493231.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_1244493231;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.717 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "71C7A1648D66E7016476A9BE4192A1FA")
    public int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_835458787 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205816056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205816056;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.717 -0400", hash_original_method = "7E7EF83BCD62492BD0A03823F89518D0", hash_generated_method = "6F1ADFEFBFF9649BA9E941683A3969DF")
    public int getDefaultPort() {
        int varF99D024E2841DC2797F7FC2BFC4F023E_239751749 = (streamHandler.getDefaultPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521910975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521910975;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.717 -0400", hash_original_method = "D4C7450F6A022BC4DF89D66487C9A55A", hash_generated_method = "8743A2B05399DF5EEB5525F619A2054A")
    public String getFile() {
String varADCB75793FA1DABACC5DEBFFAE466050_1878550918 =         file;
        varADCB75793FA1DABACC5DEBFFAE466050_1878550918.addTaint(taint);
        return varADCB75793FA1DABACC5DEBFFAE466050_1878550918;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.717 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "43B08A72B0BE67B21A17BDD8B6340B54")
    public String getPath() {
String var535F4D9720F3B0C96D8143873CE0638C_1643840546 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1643840546.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1643840546;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.718 -0400", hash_original_method = "1E279BC97111B7B33A732EF157351512", hash_generated_method = "EBF9E1D0836995F87981B0A62BA1EECF")
    public String getQuery() {
String varA8A0683638E4CE91D85122D8CD8F3BAC_1188394492 =         query;
        varA8A0683638E4CE91D85122D8CD8F3BAC_1188394492.addTaint(taint);
        return varA8A0683638E4CE91D85122D8CD8F3BAC_1188394492;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.718 -0400", hash_original_method = "3AAC0179CDFA195C747754E7ED20A392", hash_generated_method = "6D7EDF6F452BB2FC907965ABB1D68833")
    public String getRef() {
String varEFC1DBC79AB9D4D6FF46C815132543A5_2145506082 =         ref;
        varEFC1DBC79AB9D4D6FF46C815132543A5_2145506082.addTaint(taint);
        return varEFC1DBC79AB9D4D6FF46C815132543A5_2145506082;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.719 -0400", hash_original_method = "1BAF8E8ECD99ADEA9022FFFFA6473F49", hash_generated_method = "28782146E8A5E535E621C73BE398F329")
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
        } 
        set(protocol, host, port, file, ref);
        this.authority = authority;
        this.userInfo = userInfo;
        this.path = path;
        this.query = query;
        
        
        
            
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.720 -0400", hash_original_field = "C22D4AF53333AE18B0F8405C700A3CD9", hash_generated_field = "8D4046C0B22D26C3D18782292CFAEA41")

    private static final long serialVersionUID = -7627629688361524110L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.720 -0400", hash_original_field = "6824D48C614C929FBCD354F1F146A997", hash_generated_field = "7C5EE8C1A882C933CC017CE2A46222A0")

    private static URLStreamHandlerFactory streamHandlerFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.720 -0400", hash_original_field = "C51FCA48EDF9E5102BD4313C897B9579", hash_generated_field = "16539CC8BECB892A33EEA156DBF8E5B0")

    private static final Hashtable<String, URLStreamHandler> streamHandlers = new Hashtable<String, URLStreamHandler>();
}

