package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "AC50B8E8CEC0F955316DE9A8EC0AB5AE")

    private String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "F51DF048A4B5B6B4A61A3652544F4757")

    private int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    private String file;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "18389A4A9AD5795744699CFF0BA66C15", hash_generated_field = "4B296BDB98B3E9CBEDF6971A25928318")

    private String ref;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    private transient String userInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    private transient String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    private transient String query;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "F0507048B87501EB491B247BC9108E5B", hash_generated_field = "9DB4BB741418299310AFA5D983E7DA2C")

    transient URLStreamHandler streamHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.241 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "24254DF41EE7E0D088838123A7BE5D39")

    private transient int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.242 -0400", hash_original_method = "121BE8263BD1C356B2FE90A678407E92", hash_generated_method = "13BE7CC69BC37CEBA9C3D962CB708488")
    public  URL(String spec) throws MalformedURLException {
        this((URL) null, spec, null);
        addTaint(spec.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.242 -0400", hash_original_method = "472053565B13D456EDCEBEA98F287F95", hash_generated_method = "71DD2369D80E2E36230A7D9D3C989329")
    public  URL(URL context, String spec) throws MalformedURLException {
        this(context, spec, null);
        addTaint(context.getTaint());
        addTaint(spec.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.243 -0400", hash_original_method = "D8E146F1F2E4ED207D7672129A3654D5", hash_generated_method = "022F4A8A89E5A62A0CD7C0255C3CBFC9")
    public  URL(URL context, String spec, URLStreamHandler handler) throws MalformedURLException {
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedURLException();
        } //End block
        {
            streamHandler = handler;
        } //End block
        spec = spec.trim();
        protocol = UrlUtils.getSchemePrefix(spec);
        int schemeSpecificPartStart;
        schemeSpecificPartStart = (protocol.length() + 1);
        schemeSpecificPartStart = 0;
        {
            boolean var8B6DA5DD718D9B05B4E0F7B3F188798E_910230245 = (protocol != null && context != null && !protocol.equals(context.protocol));
            {
                context = null;
            } //End block
        } //End collapsed parenthetic
        {
            set(context.protocol, context.getHost(), context.getPort(), context.getAuthority(),
                    context.getUserInfo(), context.getPath(), context.getQuery(),
                    context.getRef());
            {
                streamHandler = context.streamHandler;
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedURLException("Protocol not found: " + spec);
        } //End block
        {
            setupStreamHandler();
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedURLException("Unknown protocol: " + protocol);
            } //End block
        } //End block
        try 
        {
            streamHandler.parseURL(this, spec, schemeSpecificPartStart, spec.length());
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedURLException(e.toString());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.243 -0400", hash_original_method = "216BAC89605FCA377BB0AADBB6E2A8AC", hash_generated_method = "C2AAA4AA560A90F89C17F9784727A05A")
    public  URL(String protocol, String host, String file) throws MalformedURLException {
        this(protocol, host, -1, file, null);
        addTaint(protocol.getTaint());
        addTaint(host.getTaint());
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.243 -0400", hash_original_method = "9AD76E183D70EDC4767A9EAC128427AE", hash_generated_method = "B6D3A3819105CC81972FE9984358EBB4")
    public  URL(String protocol, String host, int port, String file) throws MalformedURLException {
        this(protocol, host, port, file, null);
        addTaint(protocol.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.244 -0400", hash_original_method = "D56485CA0554FF67A28005CBDB936EDB", hash_generated_method = "8C4F412158742586D0BAAE29F94D7DDA")
    public  URL(String protocol, String host, int port, String file,
            URLStreamHandler handler) throws MalformedURLException {
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedURLException("port < -1: " + port);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("protocol == null");
        } //End block
        {
            boolean var20EB247AB3D5F30E2BA7C7D6D1CF238E_1108489774 = (host != null && host.contains(":") && host.charAt(0) != '[');
            {
                host = "[" + host + "]";
            } //End block
        } //End collapsed parenthetic
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        file = UrlUtils.authoritySafePath(host, file);
        int hash = file.indexOf("#");
        {
            this.file = file.substring(0, hash);
            this.ref = file.substring(hash + 1);
        } //End block
        {
            this.file = file;
        } //End block
        fixURL(false);
        {
            setupStreamHandler();
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedURLException("Unknown protocol: " + protocol);
            } //End block
        } //End block
        {
            streamHandler = handler;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static synchronized void setURLStreamHandlerFactory(URLStreamHandlerFactory factory) {
        if (streamHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        streamHandlers.clear();
        streamHandlerFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.246 -0400", hash_original_method = "0200B051ED19728512FC68E42BCAEC0F", hash_generated_method = "E57909AFC42D580D9294EFC16AF346A1")
     void fixURL(boolean fixHost) {
        int index = 0;
        {
            boolean var6988708993DD24B87D8382C4CEDB2255_417686632 = (host != null && host.length() > 0);
            {
                authority = host;
                {
                    authority = authority + ":" + port;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var053492750823D0DDC9DDDC734C27B1DE_901121650 = (host != null && (index = host.lastIndexOf('@')) > -1);
                {
                    userInfo = host.substring(0, index);
                    host = host.substring(index + 1);
                } //End block
                {
                    userInfo = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var8F7388E3209FBE07887D8522BDA96A9A_157697039 = (file != null && (index = file.indexOf('?')) > -1);
            {
                query = file.substring(index + 1);
                path = file.substring(0, index);
            } //End block
            {
                query = null;
                path = file;
            } //End block
        } //End collapsed parenthetic
        addTaint(fixHost);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.247 -0400", hash_original_method = "2A0889AB616D5EC9F0D1FFB4406777A2", hash_generated_method = "5E4CFA0519BF304E5AADFD2960AB2E39")
    protected void set(String protocol, String host, int port, String file, String ref) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.247 -0400", hash_original_method = "90B240523657DD4FC87B9440FE931EC1", hash_generated_method = "0C716ED872448AC2887A88CE36C32F73")
    @Override
    public boolean equals(Object o) {
        {
            boolean var87693CD490A8CD06F7E7327B7EEC47F9_422464787 = (this.getClass() != o.getClass());
        } //End collapsed parenthetic
        boolean varD1686DF20B64D1720E650E2D4C23617C_471310825 = (streamHandler.equals(this, (URL) o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149234790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149234790;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.247 -0400", hash_original_method = "0A94C2599C7A34FBFDE0162C017FE126", hash_generated_method = "26310A4D404AEF76156499339D7366F9")
    public boolean sameFile(URL otherURL) {
        boolean var4FA74F36F035176E103629A4C18DAE47_1330356269 = (streamHandler.sameFile(this, otherURL));
        addTaint(otherURL.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954243808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954243808;
        // ---------- Original Method ----------
        //return streamHandler.sameFile(this, otherURL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.248 -0400", hash_original_method = "83584D9C6686BC529C911ABE882D39AB", hash_generated_method = "A2D5877B18FAE3C906FEE3D42D1B670B")
    @Override
    public int hashCode() {
        {
            hashCode = streamHandler.hashCode(this);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540760144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540760144;
        // ---------- Original Method ----------
        //if (hashCode == 0) {
            //hashCode = streamHandler.hashCode(this);
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.259 -0400", hash_original_method = "7ED1A4A4DB26C9983DC69C2C091F1C50", hash_generated_method = "AC92A4B12284C3B2E84B81C4CA54E272")
     void setupStreamHandler() {
        streamHandler = streamHandlers.get(protocol);
        {
            streamHandler = streamHandlerFactory.createURLStreamHandler(protocol);
            {
                streamHandlers.put(protocol, streamHandler);
            } //End block
        } //End block
        String packageList = System.getProperty("java.protocol.handler.pkgs");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        {
            {
                String packageName = packageList.split("\\|")[0];
                {
                    String className = packageName + "." + protocol + ".Handler";
                    try 
                    {
                        Class<?> c = contextClassLoader.loadClass(className);
                        streamHandler = (URLStreamHandler) c.newInstance();
                        {
                            streamHandlers.put(protocol, streamHandler);
                        } //End block
                    } //End block
                    catch (IllegalAccessException ignored)
                    { }
                    catch (InstantiationException ignored)
                    { }
                    catch (ClassNotFoundException ignored)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varD3586967695E598A11CD279A31554640_514757620 = (protocol.equals("file"));
            {
                streamHandler = new FileHandler();
            } //End block
            {
                boolean var01B3067594838BB58C65DAFC7EEFAD50_258656161 = (protocol.equals("ftp"));
                {
                    streamHandler = new FtpHandler();
                } //End block
                {
                    boolean var6570A536ED54883FA06D64B8BBF6ECAB_708094208 = (protocol.equals("http"));
                    {
                        streamHandler = new HttpHandler();
                    } //End block
                    {
                        boolean varEE30D610179EA8038CD08747183F4F7A_1134742783 = (protocol.equals("https"));
                        {
                            streamHandler = new HttpsHandler();
                        } //End block
                        {
                            boolean varB604F1DF8F50013B1F7F0E3AFFD2694D_1216549849 = (protocol.equals("jar"));
                            {
                                streamHandler = new JarHandler();
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            streamHandlers.put(protocol, streamHandler);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.260 -0400", hash_original_method = "D20F85DA45DCC6A1B9E0395104EBE2B6", hash_generated_method = "9D3169117687950E071B16D55687B08D")
    public final Object getContent() throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_433539387 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_433539387 = openConnection().getContent();
        varB4EAC82CA7396A68D541C85D26508E83_433539387.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_433539387;
        // ---------- Original Method ----------
        //return openConnection().getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.261 -0400", hash_original_method = "D92AC8AC4808B4044341B9D346CCCA3C", hash_generated_method = "3D65869BAE727558498C8A0504EE3890")
    @SuppressWarnings("unchecked")
    public final Object getContent(Class[] types) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_481555279 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_481555279 = openConnection().getContent(types);
        addTaint(types[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_481555279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_481555279;
        // ---------- Original Method ----------
        //return openConnection().getContent(types);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.261 -0400", hash_original_method = "EA6B256CF4DB87F83CFE1379BEA78831", hash_generated_method = "3D0A3FCA5F02B20CE2F5244697D1E920")
    public final InputStream openStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_726430273 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_726430273 = openConnection().getInputStream();
        varB4EAC82CA7396A68D541C85D26508E83_726430273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_726430273;
        // ---------- Original Method ----------
        //return openConnection().getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.262 -0400", hash_original_method = "DDCF57687ACF51357E563F1083DC4261", hash_generated_method = "CA3B08D433C20DF0FFEFEC87F252DB32")
    public URLConnection openConnection() throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_1035150427 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1035150427 = streamHandler.openConnection(this);
        varB4EAC82CA7396A68D541C85D26508E83_1035150427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1035150427;
        // ---------- Original Method ----------
        //return streamHandler.openConnection(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.263 -0400", hash_original_method = "CB72409718452D46955A0A85FC179645", hash_generated_method = "0B035512B744C270855E5DBE5113D852")
    public URLConnection openConnection(Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_415189914 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("proxy == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_415189914 = streamHandler.openConnection(this, proxy);
        addTaint(proxy.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_415189914.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_415189914;
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException("proxy == null");
        //}
        //return streamHandler.openConnection(this, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.264 -0400", hash_original_method = "1E43ADB2B24E4AEE234C287749830ABE", hash_generated_method = "02CC03F68600E9761FAD2A51CB6A72EF")
    public URI toURI() throws URISyntaxException {
        URI varB4EAC82CA7396A68D541C85D26508E83_918349637 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_918349637 = new URI(toExternalForm());
        varB4EAC82CA7396A68D541C85D26508E83_918349637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_918349637;
        // ---------- Original Method ----------
        //return new URI(toExternalForm());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.266 -0400", hash_original_method = "9819CA3EECC28CF10D8C0CAB99E6CDCB", hash_generated_method = "5B9C215F65D6E35E57455C77AA1E4AA6")
    public URI toURILenient() throws URISyntaxException {
        URI varB4EAC82CA7396A68D541C85D26508E83_11132083 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(protocol);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_11132083 = new URI(streamHandler.toExternalForm(this, true));
        varB4EAC82CA7396A68D541C85D26508E83_11132083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_11132083;
        // ---------- Original Method ----------
        //if (streamHandler == null) {
            //throw new IllegalStateException(protocol);
        //}
        //return new URI(streamHandler.toExternalForm(this, true));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.268 -0400", hash_original_method = "9D75BD75136BEBAB4AE2F806E85803AD", hash_generated_method = "F90719F0E1E822150212BA6115115269")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_424592091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_424592091 = toExternalForm();
        varB4EAC82CA7396A68D541C85D26508E83_424592091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_424592091;
        // ---------- Original Method ----------
        //return toExternalForm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.269 -0400", hash_original_method = "6763BB94BC9C65378EF7195BF94F5BED", hash_generated_method = "89B11600592C7FDEF2C92EFD59CE36C8")
    public String toExternalForm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1430906541 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_402207425 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1430906541 = "unknown protocol(" + protocol + ")://" + host + file;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_402207425 = streamHandler.toExternalForm(this);
        String varA7E53CE21691AB073D9660D615818899_816846823; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_816846823 = varB4EAC82CA7396A68D541C85D26508E83_1430906541;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_816846823 = varB4EAC82CA7396A68D541C85D26508E83_402207425;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_816846823.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_816846823;
        // ---------- Original Method ----------
        //if (streamHandler == null) {
            //return "unknown protocol(" + protocol + ")://" + host + file;
        //}
        //return streamHandler.toExternalForm(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.270 -0400", hash_original_method = "75E256B9492C6227D987E1CACFC70E15", hash_generated_method = "0B2C329C7EE0963C73742F4D6D5A9E79")
    private void readObject(ObjectInputStream stream) throws IOException {
        try 
        {
            stream.defaultReadObject();
            {
                fixURL(true);
            } //End block
            {
                int index;
                {
                    boolean varF9FE0E6B7AE8AAABB9E093B0AF022E54_768294265 = ((index = authority.lastIndexOf('@')) > -1);
                    {
                        userInfo = authority.substring(0, index);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varF84173E21F456ED190E029514974D05F_1178805493 = (file != null && (index = file.indexOf('?')) > -1);
                    {
                        query = file.substring(index + 1);
                        path = file.substring(0, index);
                    } //End block
                    {
                        path = file;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            setupStreamHandler();
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Unknown protocol: " + protocol);
            } //End block
            hashCode = 0;
        } //End block
        catch (ClassNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(e);
        } //End block
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.271 -0400", hash_original_method = "CCBF13D66B2182AA6C1A2589205C2944", hash_generated_method = "90B32B2F317F21BFF15F42D428F3ED2C")
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //s.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.272 -0400", hash_original_method = "89A7E9DBD8F7AF35FA9A39C4922A8C55", hash_generated_method = "AA0E0A4233E0E7AE91CC1B5B5ED04F60")
    public int getEffectivePort() {
        int varDAC3D556A5ED3DAF733060E2ACC01201_1488550439 = (URI.getEffectivePort(protocol, port));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264777399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264777399;
        // ---------- Original Method ----------
        //return URI.getEffectivePort(protocol, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.274 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "F63AAC0798E6F1A112A26F2276AC2BCF")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_851292383 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_851292383 = protocol;
        varB4EAC82CA7396A68D541C85D26508E83_851292383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_851292383;
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.276 -0400", hash_original_method = "36971585CF0AC7121D34C5DBA5E7B5AD", hash_generated_method = "FBECD49A26715DBFF3E53528E4CBA397")
    public String getAuthority() {
        String varB4EAC82CA7396A68D541C85D26508E83_1371292383 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1371292383 = authority;
        varB4EAC82CA7396A68D541C85D26508E83_1371292383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1371292383;
        // ---------- Original Method ----------
        //return authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.278 -0400", hash_original_method = "C7599F6C2A9D16B1F9E84177D4C93D75", hash_generated_method = "9A7B91F151C50BC178FE5660D8C61AFF")
    public String getUserInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_1342464095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1342464095 = userInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1342464095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1342464095;
        // ---------- Original Method ----------
        //return userInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.279 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "10B5FBD8DE32D9513CC77E1946000912")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1673324547 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1673324547 = host;
        varB4EAC82CA7396A68D541C85D26508E83_1673324547.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1673324547;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.280 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "ED2D8ECC3AE508FD8817037B4A9B78E0")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621029210 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621029210;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.280 -0400", hash_original_method = "7E7EF83BCD62492BD0A03823F89518D0", hash_generated_method = "B3BEBC4C0ACBF0BD553BF060A0E72FD1")
    public int getDefaultPort() {
        int varC72F0348D2F1E173A8A2C8031FD4BB9C_939325468 = (streamHandler.getDefaultPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759320838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759320838;
        // ---------- Original Method ----------
        //return streamHandler.getDefaultPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.281 -0400", hash_original_method = "D4C7450F6A022BC4DF89D66487C9A55A", hash_generated_method = "2CD86791DFC2F31FFD2DBDE12AFAE842")
    public String getFile() {
        String varB4EAC82CA7396A68D541C85D26508E83_574851308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_574851308 = file;
        varB4EAC82CA7396A68D541C85D26508E83_574851308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_574851308;
        // ---------- Original Method ----------
        //return file;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.282 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "D5862B3EF4978347A50936BC56474714")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_906121014 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_906121014 = path;
        varB4EAC82CA7396A68D541C85D26508E83_906121014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_906121014;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.283 -0400", hash_original_method = "1E279BC97111B7B33A732EF157351512", hash_generated_method = "DEBC600CEC86E62725664CE771A95EA1")
    public String getQuery() {
        String varB4EAC82CA7396A68D541C85D26508E83_1393552029 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1393552029 = query;
        varB4EAC82CA7396A68D541C85D26508E83_1393552029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393552029;
        // ---------- Original Method ----------
        //return query;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.284 -0400", hash_original_method = "3AAC0179CDFA195C747754E7ED20A392", hash_generated_method = "A3D92858A1816BFDC5722EE04D05DEEC")
    public String getRef() {
        String varB4EAC82CA7396A68D541C85D26508E83_977984815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_977984815 = ref;
        varB4EAC82CA7396A68D541C85D26508E83_977984815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_977984815;
        // ---------- Original Method ----------
        //return ref;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.285 -0400", hash_original_method = "1BAF8E8ECD99ADEA9022FFFFA6473F49", hash_generated_method = "125427B48545965D28CC09F9646165CB")
    protected void set(String protocol, String host, int port, String authority, String userInfo,
            String path, String query, String ref) {
        String file = path;
        {
            boolean var5BAAB4912CDBF34FB484A7C75259848C_467234837 = (query != null && !query.isEmpty());
            {
                file += "?" + query;
            } //End block
        } //End collapsed parenthetic
        set(protocol, host, port, file, ref);
        this.authority = authority;
        this.userInfo = userInfo;
        this.path = path;
        this.query = query;
        addTaint(protocol.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(ref.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.285 -0400", hash_original_field = "C22D4AF53333AE18B0F8405C700A3CD9", hash_generated_field = "8D4046C0B22D26C3D18782292CFAEA41")

    private static final long serialVersionUID = -7627629688361524110L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.285 -0400", hash_original_field = "6824D48C614C929FBCD354F1F146A997", hash_generated_field = "7C5EE8C1A882C933CC017CE2A46222A0")

    private static URLStreamHandlerFactory streamHandlerFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.285 -0400", hash_original_field = "C51FCA48EDF9E5102BD4313C897B9579", hash_generated_field = "16539CC8BECB892A33EEA156DBF8E5B0")

    private static final Hashtable<String, URLStreamHandler> streamHandlers = new Hashtable<String, URLStreamHandler>();
}

