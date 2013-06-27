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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "AC50B8E8CEC0F955316DE9A8EC0AB5AE")

    private String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "F51DF048A4B5B6B4A61A3652544F4757")

    private int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    private String file;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "18389A4A9AD5795744699CFF0BA66C15", hash_generated_field = "4B296BDB98B3E9CBEDF6971A25928318")

    private String ref;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    private transient String userInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    private transient String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    private transient String query;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "F0507048B87501EB491B247BC9108E5B", hash_generated_field = "9DB4BB741418299310AFA5D983E7DA2C")

    transient URLStreamHandler streamHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.338 -0400", hash_original_field = "550D1CC054A1B23A411DDDA46FD64811", hash_generated_field = "24254DF41EE7E0D088838123A7BE5D39")

    private transient int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.339 -0400", hash_original_method = "121BE8263BD1C356B2FE90A678407E92", hash_generated_method = "13BE7CC69BC37CEBA9C3D962CB708488")
    public  URL(String spec) throws MalformedURLException {
        this((URL) null, spec, null);
        addTaint(spec.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.342 -0400", hash_original_method = "472053565B13D456EDCEBEA98F287F95", hash_generated_method = "71DD2369D80E2E36230A7D9D3C989329")
    public  URL(URL context, String spec) throws MalformedURLException {
        this(context, spec, null);
        addTaint(context.getTaint());
        addTaint(spec.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.344 -0400", hash_original_method = "D8E146F1F2E4ED207D7672129A3654D5", hash_generated_method = "72268EAC112824CF240BE6B40FB36360")
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
            boolean var8B6DA5DD718D9B05B4E0F7B3F188798E_920541751 = (protocol != null && context != null && !protocol.equals(context.protocol));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.345 -0400", hash_original_method = "216BAC89605FCA377BB0AADBB6E2A8AC", hash_generated_method = "C2AAA4AA560A90F89C17F9784727A05A")
    public  URL(String protocol, String host, String file) throws MalformedURLException {
        this(protocol, host, -1, file, null);
        addTaint(protocol.getTaint());
        addTaint(host.getTaint());
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.345 -0400", hash_original_method = "9AD76E183D70EDC4767A9EAC128427AE", hash_generated_method = "B6D3A3819105CC81972FE9984358EBB4")
    public  URL(String protocol, String host, int port, String file) throws MalformedURLException {
        this(protocol, host, port, file, null);
        addTaint(protocol.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.364 -0400", hash_original_method = "D56485CA0554FF67A28005CBDB936EDB", hash_generated_method = "6CCB2433185C8CDF0C5BDBAFC9101A02")
    public  URL(String protocol, String host, int port, String file,
            URLStreamHandler handler) throws MalformedURLException {
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedURLException("port < -1: " + port);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("protocol == null");
        } //End block
        {
            boolean var20EB247AB3D5F30E2BA7C7D6D1CF238E_284956998 = (host != null && host.contains(":") && host.charAt(0) != '[');
            {
                host = "[" + host + "]";
            } //End block
        } //End collapsed parenthetic
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        file = UrlUtils.authoritySafePath(host, file);
        int hash;
        hash = file.indexOf("#");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.378 -0400", hash_original_method = "0200B051ED19728512FC68E42BCAEC0F", hash_generated_method = "CB888C70B448C7BDBDA44FD07089FF1B")
     void fixURL(boolean fixHost) {
        int index;
        {
            boolean var6988708993DD24B87D8382C4CEDB2255_970864081 = (host != null && host.length() > 0);
            {
                authority = host;
                {
                    authority = authority + ":" + port;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var053492750823D0DDC9DDDC734C27B1DE_1803186380 = (host != null && (index = host.lastIndexOf('@')) > -1);
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
            boolean var8F7388E3209FBE07887D8522BDA96A9A_225052726 = (file != null && (index = file.indexOf('?')) > -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.378 -0400", hash_original_method = "2A0889AB616D5EC9F0D1FFB4406777A2", hash_generated_method = "5E4CFA0519BF304E5AADFD2960AB2E39")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.379 -0400", hash_original_method = "90B240523657DD4FC87B9440FE931EC1", hash_generated_method = "0D1776160C5D77D6890E4B6F4324AB92")
    @Override
    public boolean equals(Object o) {
        {
            boolean var87693CD490A8CD06F7E7327B7EEC47F9_1304538564 = (this.getClass() != o.getClass());
        } //End collapsed parenthetic
        boolean varD1686DF20B64D1720E650E2D4C23617C_2014560978 = (streamHandler.equals(this, (URL) o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2042685468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2042685468;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.379 -0400", hash_original_method = "0A94C2599C7A34FBFDE0162C017FE126", hash_generated_method = "53994F3491FA99348FA9907580D1E58E")
    public boolean sameFile(URL otherURL) {
        boolean var4FA74F36F035176E103629A4C18DAE47_1411386131 = (streamHandler.sameFile(this, otherURL));
        addTaint(otherURL.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523100095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523100095;
        // ---------- Original Method ----------
        //return streamHandler.sameFile(this, otherURL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.379 -0400", hash_original_method = "83584D9C6686BC529C911ABE882D39AB", hash_generated_method = "B3B2364F3F6CA8CB48E9C787BE46684B")
    @Override
    public int hashCode() {
        {
            hashCode = streamHandler.hashCode(this);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172591392 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172591392;
        // ---------- Original Method ----------
        //if (hashCode == 0) {
            //hashCode = streamHandler.hashCode(this);
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.506 -0400", hash_original_method = "7ED1A4A4DB26C9983DC69C2C091F1C50", hash_generated_method = "D9B5D5A01F318D9E6301F0548A5F1B89")
     void setupStreamHandler() {
        streamHandler = streamHandlers.get(protocol);
        {
            streamHandler = streamHandlerFactory.createURLStreamHandler(protocol);
            {
                streamHandlers.put(protocol, streamHandler);
            } //End block
        } //End block
        String packageList;
        packageList = System.getProperty("java.protocol.handler.pkgs");
        ClassLoader contextClassLoader;
        contextClassLoader = Thread.currentThread().getContextClassLoader();
        {
            {
                Iterator<String> varF7DDCB99A797792EC7DC3A4DAAF9383E_72513448 = (packageList.split("\\|")).iterator();
                varF7DDCB99A797792EC7DC3A4DAAF9383E_72513448.hasNext();
                String packageName = varF7DDCB99A797792EC7DC3A4DAAF9383E_72513448.next();
                {
                    String className;
                    className = packageName + "." + protocol + ".Handler";
                    try 
                    {
                        Class<?> c;
                        c = contextClassLoader.loadClass(className);
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
            boolean varD3586967695E598A11CD279A31554640_781419117 = (protocol.equals("file"));
            {
                streamHandler = new FileHandler();
            } //End block
            {
                boolean var01B3067594838BB58C65DAFC7EEFAD50_1297222467 = (protocol.equals("ftp"));
                {
                    streamHandler = new FtpHandler();
                } //End block
                {
                    boolean var6570A536ED54883FA06D64B8BBF6ECAB_1592491809 = (protocol.equals("http"));
                    {
                        streamHandler = new HttpHandler();
                    } //End block
                    {
                        boolean varEE30D610179EA8038CD08747183F4F7A_646697618 = (protocol.equals("https"));
                        {
                            streamHandler = new HttpsHandler();
                        } //End block
                        {
                            boolean varB604F1DF8F50013B1F7F0E3AFFD2694D_946984647 = (protocol.equals("jar"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.506 -0400", hash_original_method = "D20F85DA45DCC6A1B9E0395104EBE2B6", hash_generated_method = "7BA8A253CFA4E52223240C3DB5CE60D4")
    public final Object getContent() throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1402699574 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1402699574 = openConnection().getContent();
        varB4EAC82CA7396A68D541C85D26508E83_1402699574.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1402699574;
        // ---------- Original Method ----------
        //return openConnection().getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.522 -0400", hash_original_method = "D92AC8AC4808B4044341B9D346CCCA3C", hash_generated_method = "413243E1559F4515712AAD1182B1EBF0")
    @SuppressWarnings("unchecked")
    public final Object getContent(Class[] types) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1199990547 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1199990547 = openConnection().getContent(types);
        addTaint(types[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1199990547.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1199990547;
        // ---------- Original Method ----------
        //return openConnection().getContent(types);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.522 -0400", hash_original_method = "EA6B256CF4DB87F83CFE1379BEA78831", hash_generated_method = "610816F35CE982F0A77FDB7424411D05")
    public final InputStream openStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_886970953 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_886970953 = openConnection().getInputStream();
        varB4EAC82CA7396A68D541C85D26508E83_886970953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_886970953;
        // ---------- Original Method ----------
        //return openConnection().getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.523 -0400", hash_original_method = "DDCF57687ACF51357E563F1083DC4261", hash_generated_method = "AC9A19416A809BF82F9121427AD535E3")
    public URLConnection openConnection() throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_109822076 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_109822076 = streamHandler.openConnection(this);
        varB4EAC82CA7396A68D541C85D26508E83_109822076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_109822076;
        // ---------- Original Method ----------
        //return streamHandler.openConnection(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.525 -0400", hash_original_method = "CB72409718452D46955A0A85FC179645", hash_generated_method = "D5F1D1B09CCD26346C7930C2F8A792E4")
    public URLConnection openConnection(Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_2053701902 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("proxy == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2053701902 = streamHandler.openConnection(this, proxy);
        addTaint(proxy.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2053701902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2053701902;
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException("proxy == null");
        //}
        //return streamHandler.openConnection(this, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.525 -0400", hash_original_method = "1E43ADB2B24E4AEE234C287749830ABE", hash_generated_method = "8CFEAE77321CAC6BA61EAD025A3B13D6")
    public URI toURI() throws URISyntaxException {
        URI varB4EAC82CA7396A68D541C85D26508E83_1043780187 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1043780187 = new URI(toExternalForm());
        varB4EAC82CA7396A68D541C85D26508E83_1043780187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1043780187;
        // ---------- Original Method ----------
        //return new URI(toExternalForm());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.543 -0400", hash_original_method = "9819CA3EECC28CF10D8C0CAB99E6CDCB", hash_generated_method = "F3172E86FD4AA93B713A0209485466FC")
    public URI toURILenient() throws URISyntaxException {
        URI varB4EAC82CA7396A68D541C85D26508E83_1532530809 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(protocol);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1532530809 = new URI(streamHandler.toExternalForm(this, true));
        varB4EAC82CA7396A68D541C85D26508E83_1532530809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1532530809;
        // ---------- Original Method ----------
        //if (streamHandler == null) {
            //throw new IllegalStateException(protocol);
        //}
        //return new URI(streamHandler.toExternalForm(this, true));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.543 -0400", hash_original_method = "9D75BD75136BEBAB4AE2F806E85803AD", hash_generated_method = "B6239BF33658082A106E6DB8A45049B7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1558881510 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1558881510 = toExternalForm();
        varB4EAC82CA7396A68D541C85D26508E83_1558881510.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1558881510;
        // ---------- Original Method ----------
        //return toExternalForm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.544 -0400", hash_original_method = "6763BB94BC9C65378EF7195BF94F5BED", hash_generated_method = "36E4B0571BAC7802321E4883A8250330")
    public String toExternalForm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1971802087 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_706412092 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1971802087 = "unknown protocol(" + protocol + ")://" + host + file;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_706412092 = streamHandler.toExternalForm(this);
        String varA7E53CE21691AB073D9660D615818899_1593584824; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1593584824 = varB4EAC82CA7396A68D541C85D26508E83_1971802087;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1593584824 = varB4EAC82CA7396A68D541C85D26508E83_706412092;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1593584824.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1593584824;
        // ---------- Original Method ----------
        //if (streamHandler == null) {
            //return "unknown protocol(" + protocol + ")://" + host + file;
        //}
        //return streamHandler.toExternalForm(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.546 -0400", hash_original_method = "75E256B9492C6227D987E1CACFC70E15", hash_generated_method = "C35C9E993B73CDDD7624A0B08C1B63FA")
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
                    boolean varF9FE0E6B7AE8AAABB9E093B0AF022E54_2048196765 = ((index = authority.lastIndexOf('@')) > -1);
                    {
                        userInfo = authority.substring(0, index);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varF84173E21F456ED190E029514974D05F_672504188 = (file != null && (index = file.indexOf('?')) > -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.546 -0400", hash_original_method = "CCBF13D66B2182AA6C1A2589205C2944", hash_generated_method = "90B32B2F317F21BFF15F42D428F3ED2C")
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //s.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.560 -0400", hash_original_method = "89A7E9DBD8F7AF35FA9A39C4922A8C55", hash_generated_method = "DFB3DFAFA43368B9549BAB3E6EFF4104")
    public int getEffectivePort() {
        int varDAC3D556A5ED3DAF733060E2ACC01201_172350105 = (URI.getEffectivePort(protocol, port));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808890366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808890366;
        // ---------- Original Method ----------
        //return URI.getEffectivePort(protocol, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.561 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "778D1CBBEDAA309CC359E37757F536C5")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1458299807 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1458299807 = protocol;
        varB4EAC82CA7396A68D541C85D26508E83_1458299807.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1458299807;
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.562 -0400", hash_original_method = "36971585CF0AC7121D34C5DBA5E7B5AD", hash_generated_method = "5DC07E554D65C7974975CDDEB37D30A0")
    public String getAuthority() {
        String varB4EAC82CA7396A68D541C85D26508E83_272076704 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_272076704 = authority;
        varB4EAC82CA7396A68D541C85D26508E83_272076704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_272076704;
        // ---------- Original Method ----------
        //return authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.563 -0400", hash_original_method = "C7599F6C2A9D16B1F9E84177D4C93D75", hash_generated_method = "17C72712792F085B448F3AC5E716C343")
    public String getUserInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_1260827565 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1260827565 = userInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1260827565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1260827565;
        // ---------- Original Method ----------
        //return userInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.564 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "525016021F3D23EA2C6893CF38C3DF04")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1518788166 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1518788166 = host;
        varB4EAC82CA7396A68D541C85D26508E83_1518788166.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1518788166;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.564 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "09A996504215F06789CFA54A5DFE5B56")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173084912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173084912;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.564 -0400", hash_original_method = "7E7EF83BCD62492BD0A03823F89518D0", hash_generated_method = "6B37A4DC5003F9108481682813B4F477")
    public int getDefaultPort() {
        int varC72F0348D2F1E173A8A2C8031FD4BB9C_233576904 = (streamHandler.getDefaultPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555233600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555233600;
        // ---------- Original Method ----------
        //return streamHandler.getDefaultPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.568 -0400", hash_original_method = "D4C7450F6A022BC4DF89D66487C9A55A", hash_generated_method = "F588F550060C9E865F205D22B0BB5553")
    public String getFile() {
        String varB4EAC82CA7396A68D541C85D26508E83_185204550 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_185204550 = file;
        varB4EAC82CA7396A68D541C85D26508E83_185204550.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_185204550;
        // ---------- Original Method ----------
        //return file;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.580 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "580B055CE5A06750AA52B5DE3062E874")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_51741286 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_51741286 = path;
        varB4EAC82CA7396A68D541C85D26508E83_51741286.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_51741286;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.581 -0400", hash_original_method = "1E279BC97111B7B33A732EF157351512", hash_generated_method = "BD8042EF63A64DE0588A9EAF37428590")
    public String getQuery() {
        String varB4EAC82CA7396A68D541C85D26508E83_1628074729 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1628074729 = query;
        varB4EAC82CA7396A68D541C85D26508E83_1628074729.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1628074729;
        // ---------- Original Method ----------
        //return query;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.581 -0400", hash_original_method = "3AAC0179CDFA195C747754E7ED20A392", hash_generated_method = "188116D747F9884BAD1F151EB8DE18C7")
    public String getRef() {
        String varB4EAC82CA7396A68D541C85D26508E83_1141349526 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1141349526 = ref;
        varB4EAC82CA7396A68D541C85D26508E83_1141349526.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1141349526;
        // ---------- Original Method ----------
        //return ref;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.582 -0400", hash_original_method = "1BAF8E8ECD99ADEA9022FFFFA6473F49", hash_generated_method = "8E5133AFDC9A97CDB014A3269BDCBA86")
    protected void set(String protocol, String host, int port, String authority, String userInfo,
            String path, String query, String ref) {
        String file;
        file = path;
        {
            boolean var5BAAB4912CDBF34FB484A7C75259848C_919138136 = (query != null && !query.isEmpty());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.582 -0400", hash_original_field = "C22D4AF53333AE18B0F8405C700A3CD9", hash_generated_field = "DFA90A58F1C56FA84A37761A66E90E55")

    private static long serialVersionUID = -7627629688361524110L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.582 -0400", hash_original_field = "6824D48C614C929FBCD354F1F146A997", hash_generated_field = "7C5EE8C1A882C933CC017CE2A46222A0")

    private static URLStreamHandlerFactory streamHandlerFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.582 -0400", hash_original_field = "C51FCA48EDF9E5102BD4313C897B9579", hash_generated_field = "422053152F15891715509C55AF44D0AA")

    private static Hashtable<String, URLStreamHandler> streamHandlers = new Hashtable<String, URLStreamHandler>();
}

