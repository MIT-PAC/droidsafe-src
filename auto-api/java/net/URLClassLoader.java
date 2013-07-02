package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charsets;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.SecureClassLoader;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import libcore.io.IoUtils;
import libcore.io.Streams;

public class URLClassLoader extends SecureClassLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.452 -0400", hash_original_field = "B29D73214A4D23ADA5B59B6F71D732DF", hash_generated_field = "8493272A5AB4A77AB209F22490E9A299")

    ArrayList<URL> originalUrls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.452 -0400", hash_original_field = "583BE25E7B8F5E9B4CF06A08F494F4E5", hash_generated_field = "6EEE0C60179788AF966E079989CB5CB3")

    List<URL> searchList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.452 -0400", hash_original_field = "A12AB4D5BFE9F5C0714A5AC8F9CC246A", hash_generated_field = "018DFABF07E4A0807227E840C28DF558")

    ArrayList<URLHandler> handlerList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.452 -0400", hash_original_field = "C7A9E9C96BAE4B4D941CA4F6492C31FF", hash_generated_field = "83210D660C03E6C9492E92BD982991A6")

    Map<URL, URLHandler> handlerMap = new HashMap<URL, URLHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.452 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "E43CA7AA04ACD2FE8928E03B47B06D76")

    private URLStreamHandlerFactory factory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.453 -0400", hash_original_method = "223BBDDFA8D7BCBDBB892F093839C31A", hash_generated_method = "7574BADAD0DECFD730EB097F2190D40F")
    public  URLClassLoader(URL[] urls) {
        this(urls, ClassLoader.getSystemClassLoader(), null);
        addTaint(urls[0].getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.453 -0400", hash_original_method = "2C1F233833FFEC69CE12E7A0069A8B49", hash_generated_method = "36B94FD949236AA62E1679990C9E0F97")
    public  URLClassLoader(URL[] urls, ClassLoader parent) {
        this(urls, parent, null);
        addTaint(urls[0].getTaint());
        addTaint(parent.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.453 -0400", hash_original_method = "9F92FD383D821F82B2A5EE941293558A", hash_generated_method = "743B795C8A623FB17FB7B1D3A7655EBC")
    public  URLClassLoader(URL[] searchUrls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(parent);
        this.factory = factory;
        int nbUrls = searchUrls.length;
        originalUrls = new ArrayList<URL>(nbUrls);
        handlerList = new ArrayList<URLHandler>(nbUrls);
        searchList = Collections.synchronizedList(new ArrayList<URL>(nbUrls));
        {
            int i = 0;
            {
                originalUrls.add(searchUrls[i]);
                try 
                {
                    searchList.add(createSearchURL(searchUrls[i]));
                } 
                catch (MalformedURLException e)
                { }
            } 
        } 
        addTaint(searchUrls[0].getTaint());
        addTaint(parent.getTaint());
        
        
        
        
        
        
        
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.453 -0400", hash_original_method = "8767B0DB3A608CD14EAA847CE6E9F597", hash_generated_method = "3834D3634E44E0F2A447C4EBFBE4F5C8")
    protected void addURL(URL url) {
        try 
        {
            originalUrls.add(url);
            searchList.add(createSearchURL(url));
        } 
        catch (MalformedURLException e)
        { }
        addTaint(url.getTaint());
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.454 -0400", hash_original_method = "E35E96FBBA5328024F5002F5E092C0FA", hash_generated_method = "C38627B5197DD9D2A602AADFA2872615")
    @Override
    public Enumeration<URL> findResources(final String name) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_278765660 = null; 
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_147994823 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_278765660 = null;
        } 
        ArrayList<URL> result = new ArrayList<URL>();
        int n = 0;
        {
            URLHandler handler = getHandler(n++);
            handler.findResources(name, result);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_147994823 = Collections.enumeration(result);
        addTaint(name.getTaint());
        Enumeration<URL> varA7E53CE21691AB073D9660D615818899_130929277; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_130929277 = varB4EAC82CA7396A68D541C85D26508E83_278765660;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_130929277 = varB4EAC82CA7396A68D541C85D26508E83_147994823;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_130929277.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_130929277;
        
        
            
        
        
        
        
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.455 -0400", hash_original_method = "B4723E664A18325BA87109668B89BB4C", hash_generated_method = "4485DEEF59DB60851871FC8AFF68069A")
    @Override
    protected PermissionCollection getPermissions(final CodeSource codesource) {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_1469771215 = null; 
        PermissionCollection pc = super.getPermissions(codesource);
        URL u = codesource.getLocation();
        {
            boolean var0D3DCE32DE3636DD78A2BE6460215DDE_1937765214 = (u.getProtocol().equals("jar"));
            {
                try 
                {
                    u = ((JarURLConnection) u.openConnection()).getJarFileURL();
                } 
                catch (IOException e)
                { }
            } 
        } 
        {
            boolean var4D320D496AF3A7A0362D9991BB7F9187_806814246 = (u.getProtocol().equals("file"));
            {
                String path = u.getFile();
                String host = u.getHost();
                {
                    boolean var2D544DB6C0FDD148F3E57369E992EC16_875059800 = (host != null && host.length() > 0);
                    {
                        path = "//" + host + path;
                    } 
                } 
                {
                    path = path.replace('/', File.separatorChar);
                } 
                {
                    boolean varC84208C3E0250C4294B433F1E7B244E4_538269821 = (isDirectory(u));
                    {
                        pc.add(new FilePermission(path + "-", "read"));
                    } 
                    {
                        pc.add(new FilePermission(path, "read"));
                    } 
                } 
            } 
            {
                String host = u.getHost();
                {
                    boolean varC53ECC4BC21F90A0F577E60A03E6C413_1168121767 = (host.length() == 0);
                    {
                        host = "localhost";
                    } 
                } 
                pc.add(new SocketPermission(host, "connect, accept"));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1469771215 = pc;
        addTaint(codesource.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1469771215.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1469771215;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.457 -0400", hash_original_method = "E74D6D295FD8DF7C4B8AB85761E02982", hash_generated_method = "DA7CE01421491E4E04BEEE143C44409C")
    public URL[] getURLs() {
        URL[] varB4EAC82CA7396A68D541C85D26508E83_68744225 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_68744225 = originalUrls.toArray(new URL[originalUrls.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_68744225.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_68744225;
        
        
    }

    
    private static boolean isDirectory(URL url) {
        String file = url.getFile();
        return (file.length() > 0 && file.charAt(file.length() - 1) == '/');
    }

    
    public static URLClassLoader newInstance(final URL[] urls) {
        return new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
    }

    
    public static URLClassLoader newInstance(final URL[] urls, final ClassLoader parentCl) {
        return new URLClassLoader(urls, parentCl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.459 -0400", hash_original_method = "BAA63B0BE9A75DDAC07B90D04DE61F0B", hash_generated_method = "04BFD091AAD76FD51786219CDF7750CE")
    @Override
    protected Class<?> findClass(final String className) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1116515182 = null; 
        String partialName = className.replace('.', '/');
        final String classFileName = new StringBuilder(partialName).append(".class").toString();
        String packageName = null;
        int position = partialName.lastIndexOf('/');
        {
            boolean var3E1D041C4A1A150031AEB32E198BD1A9_970204060 = ((position = partialName.lastIndexOf('/')) != -1);
            {
                packageName = partialName.substring(0, position);
            } 
        } 
        int n = 0;
        {
            URLHandler handler = getHandler(n++);
            Class<?> res = handler.findClass(packageName, classFileName, className);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1116515182 = res;
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(className);
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1116515182.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1116515182;
        
        
        
        
        
        
            
        
        
        
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.459 -0400", hash_original_method = "75025FE733C588323FB29CA64B72756D", hash_generated_method = "A4EFF457BB9BEA5BAF7463CE8A73F46D")
    private URL createSearchURL(URL url) throws MalformedURLException {
        URL varB4EAC82CA7396A68D541C85D26508E83_1571246232 = null; 
        URL varB4EAC82CA7396A68D541C85D26508E83_250169586 = null; 
        URL varB4EAC82CA7396A68D541C85D26508E83_932032919 = null; 
        URL varB4EAC82CA7396A68D541C85D26508E83_783993553 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1571246232 = url;
        } 
        String protocol = url.getProtocol();
        {
            boolean var6B09AA880739B965279245545031D717_44106199 = (isDirectory(url) || protocol.equals("jar"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_250169586 = url;
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_932032919 = new URL("jar", "",
                    -1, url.toString() + "!/");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_783993553 = new URL("jar", "",
                -1, url.toString() + "!/",
                factory.createURLStreamHandler("jar"));
        addTaint(url.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_317291614; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_317291614 = varB4EAC82CA7396A68D541C85D26508E83_1571246232;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_317291614 = varB4EAC82CA7396A68D541C85D26508E83_250169586;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_317291614 = varB4EAC82CA7396A68D541C85D26508E83_932032919;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_317291614 = varB4EAC82CA7396A68D541C85D26508E83_783993553;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_317291614.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_317291614;
        
        
            
        
        
        
            
        
        
            
                    
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.460 -0400", hash_original_method = "36DCCA8214496CA792D9D415CCE3C1EC", hash_generated_method = "BF843FBEFA951F468555FAA99D635808")
    @Override
    public URL findResource(final String name) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1127491112 = null; 
        URL varB4EAC82CA7396A68D541C85D26508E83_1492311888 = null; 
        URL varB4EAC82CA7396A68D541C85D26508E83_548584730 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1127491112 = null;
        } 
        int n = 0;
        {
            URLHandler handler = getHandler(n++);
            URL res = handler.findResource(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1492311888 = res;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_548584730 = null;
        addTaint(name.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_32316178; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_32316178 = varB4EAC82CA7396A68D541C85D26508E83_1127491112;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_32316178 = varB4EAC82CA7396A68D541C85D26508E83_1492311888;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_32316178 = varB4EAC82CA7396A68D541C85D26508E83_548584730;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_32316178.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_32316178;
        
        
            
        
        
        
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.461 -0400", hash_original_method = "CFA5B2A5119E9C6C6C6B8BDB54F0FFE4", hash_generated_method = "4B7C27B6897F3466C64F292FE3C31564")
    private URLHandler getHandler(int num) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_1298434714 = null; 
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_1437116598 = null; 
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_421352991 = null; 
        {
            boolean varC6CBE7D489CE95B916048C828E20629B_1937134681 = (num < handlerList.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1298434714 = handlerList.get(num);
            } 
        } 
        makeNewHandler();
        {
            boolean varC6CBE7D489CE95B916048C828E20629B_10344645 = (num < handlerList.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1437116598 = handlerList.get(num);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_421352991 = null;
        addTaint(num);
        URLHandler varA7E53CE21691AB073D9660D615818899_587607160; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_587607160 = varB4EAC82CA7396A68D541C85D26508E83_1298434714;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_587607160 = varB4EAC82CA7396A68D541C85D26508E83_1437116598;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_587607160 = varB4EAC82CA7396A68D541C85D26508E83_421352991;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_587607160.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_587607160;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.461 -0400", hash_original_method = "A878B5121D5BF1232029A8CDBC76BE45", hash_generated_method = "E40D12F35DDEF84D2943294A4D741FEC")
    private synchronized void makeNewHandler() {
        {
            boolean var056FE5D37761D5D3DC4B0CF57BDA52B0_1528666134 = (!searchList.isEmpty());
            {
                URL nextCandidate = searchList.remove(0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("A URL is null");
                } 
                {
                    boolean var087B3C4559B5C5125F9C3E5F757C0545_346743781 = (!handlerMap.containsKey(nextCandidate));
                    {
                        URLHandler result;
                        String protocol = nextCandidate.getProtocol();
                        {
                            boolean varB604F1DF8F50013B1F7F0E3AFFD2694D_1557056858 = (protocol.equals("jar"));
                            {
                                result = createURLJarHandler(nextCandidate);
                            } 
                            {
                                boolean varC08545D58A986C9447AB113046FC989F_168421775 = (protocol.equals("file"));
                                {
                                    result = createURLFileHandler(nextCandidate);
                                } 
                                {
                                    result = createURLHandler(nextCandidate);
                                } 
                            } 
                        } 
                        {
                            handlerMap.put(nextCandidate, result);
                            handlerList.add(result);
                        } 
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.462 -0400", hash_original_method = "15D2A778081BB97B4F5082C5EA9323F2", hash_generated_method = "0D973D9D805C148615CE3D9DFFE6C0F6")
    private URLHandler createURLHandler(URL url) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_797412355 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_797412355 = new URLHandler(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_797412355.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_797412355;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.462 -0400", hash_original_method = "959FE775BCBFF6223F7FD94A4010D369", hash_generated_method = "11EED8684F5324F87F55ADF62724460E")
    private URLHandler createURLFileHandler(URL url) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_667970577 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_667970577 = new URLFileHandler(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_667970577.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_667970577;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.463 -0400", hash_original_method = "93DBA576D247FBB46E5BCA4D9E3C8DFF", hash_generated_method = "B3F819F33E8FD81898F8BA74B764D597")
    private URLHandler createURLJarHandler(URL url) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_1713070424 = null; 
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_630319617 = null; 
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_1531694341 = null; 
        String prefixName;
        String file = url.getFile();
        {
            boolean var5A4D7A486C11D5F49AB1CA63C5A4886E_814055721 = (url.getFile().endsWith("!/"));
            {
                prefixName = "";
            } 
            {
                int sepIdx = file.lastIndexOf("!/");
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1713070424 = null;
                } 
                sepIdx += 2;
                prefixName = file.substring(sepIdx);
            } 
        } 
        try 
        {
            URL jarURL = ((JarURLConnection) url
                    .openConnection()).getJarFileURL();
            JarURLConnection juc = (JarURLConnection) new URL(
                    "jar", "",
                    jarURL.toExternalForm() + "!/").openConnection();
            JarFile jf = juc.getJarFile();
            URLJarHandler jarH = new URLJarHandler(url, jarURL, jf, prefixName);
            {
                boolean varD44BF004E9F3CB1AD9A1AE5B28A8F27A_1848990338 = (jarH.getIndex() == null);
                {
                    try 
                    {
                        Manifest manifest = jf.getManifest();
                        {
                            String classpath = manifest.getMainAttributes().getValue(
                                Attributes.Name.CLASS_PATH);
                            {
                                searchList.addAll(0, getInternalURLs(url, classpath));
                            } 
                        } 
                    } 
                    catch (IOException e)
                    { }
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_630319617 = jarH;
        } 
        catch (IOException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1531694341 = null;
        addTaint(url.getTaint());
        URLHandler varA7E53CE21691AB073D9660D615818899_721676681; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_721676681 = varB4EAC82CA7396A68D541C85D26508E83_1713070424;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_721676681 = varB4EAC82CA7396A68D541C85D26508E83_630319617;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_721676681 = varB4EAC82CA7396A68D541C85D26508E83_1531694341;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_721676681.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_721676681;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.464 -0400", hash_original_method = "1F20C74E5FA90998EED1F262145E5A78", hash_generated_method = "C6BE60648CF3CB8C7281658263C760D8")
    protected Package definePackage(String packageName, Manifest manifest,
                                    URL url) throws IllegalArgumentException {
        Package varB4EAC82CA7396A68D541C85D26508E83_900355427 = null; 
        Attributes mainAttributes = manifest.getMainAttributes();
        String dirName = packageName.replace('.', '/') + "/";
        Attributes packageAttributes = manifest.getAttributes(dirName);
        boolean noEntry = false;
        {
            noEntry = true;
            packageAttributes = mainAttributes;
        } 
        String specificationTitle = packageAttributes
                .getValue(Attributes.Name.SPECIFICATION_TITLE);
        {
            specificationTitle = mainAttributes
                    .getValue(Attributes.Name.SPECIFICATION_TITLE);
        } 
        String specificationVersion = packageAttributes
                .getValue(Attributes.Name.SPECIFICATION_VERSION);
        {
            specificationVersion = mainAttributes
                    .getValue(Attributes.Name.SPECIFICATION_VERSION);
        } 
        String specificationVendor = packageAttributes
                .getValue(Attributes.Name.SPECIFICATION_VENDOR);
        {
            specificationVendor = mainAttributes
                    .getValue(Attributes.Name.SPECIFICATION_VENDOR);
        } 
        String implementationTitle = packageAttributes
                .getValue(Attributes.Name.IMPLEMENTATION_TITLE);
        {
            implementationTitle = mainAttributes
                    .getValue(Attributes.Name.IMPLEMENTATION_TITLE);
        } 
        String implementationVersion = packageAttributes
                .getValue(Attributes.Name.IMPLEMENTATION_VERSION);
        {
            implementationVersion = mainAttributes
                    .getValue(Attributes.Name.IMPLEMENTATION_VERSION);
        } 
        String implementationVendor = packageAttributes
                .getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
        {
            implementationVendor = mainAttributes
                    .getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_900355427 = definePackage(packageName, specificationTitle,
                specificationVersion, specificationVendor, implementationTitle,
                implementationVersion, implementationVendor, isSealed(manifest,
                dirName) ? url : null);
        addTaint(packageName.getTaint());
        addTaint(manifest.getTaint());
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_900355427.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_900355427;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.465 -0400", hash_original_method = "F65716DA89135DC89A539D54ADB64D73", hash_generated_method = "35096B28DA86F673BA58D21A1125084E")
    private boolean isSealed(Manifest manifest, String dirName) {
        Attributes attributes = manifest.getAttributes(dirName);
        {
            String value = attributes.getValue(Attributes.Name.SEALED);
            {
                boolean varF9F03D746A978112631EA8BA624DD149_197087263 = (value.equalsIgnoreCase("true"));
            } 
        } 
        Attributes mainAttributes = manifest.getMainAttributes();
        String value = mainAttributes.getValue(Attributes.Name.SEALED);
        boolean varE5C35E1E8162E6D042C52DDD4CF2D6AA_1862673952 = ((value != null && value.equalsIgnoreCase("true")));
        addTaint(manifest.getTaint());
        addTaint(dirName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908874968 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_908874968;
        
        
        
            
            
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.468 -0400", hash_original_method = "8DCFE07B381999C3DEF19ABA31EFB008", hash_generated_method = "93CC9DC68CD5B397855A7AC1BA05E3A7")
    private ArrayList<URL> getInternalURLs(URL root, String classpath) {
        ArrayList<URL> varB4EAC82CA7396A68D541C85D26508E83_843476901 = null; 
        StringTokenizer tokenizer = new StringTokenizer(classpath);
        ArrayList<URL> addedURLs = new ArrayList<URL>();
        String file = root.getFile();
        int jarIndex = file.lastIndexOf("!/") - 1;
        int index = file.lastIndexOf("/", jarIndex) + 1;
        {
            index = file.lastIndexOf(
                    System.getProperty("file.separator"), jarIndex) + 1;
        } 
        file = file.substring(0, index);
        {
            boolean var2B5824909BF971CED0BAC391F81BF905_1208264869 = (tokenizer.hasMoreElements());
            {
                String element = tokenizer.nextToken();
                {
                    boolean varE66FC8B2A65C7CA819992997D34C4051_504436662 = (!element.isEmpty());
                    {
                        try 
                        {
                            URL url = new URL(new URL(file), element);
                            addedURLs.add(createSearchURL(url));
                        } 
                        catch (MalformedURLException e)
                        { }
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_843476901 = addedURLs;
        addTaint(root.getTaint());
        addTaint(classpath.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_843476901.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_843476901;
        
        
    }

    
    static class IndexFile {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.468 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "8CA0A10A56B7E322DF59FAF09C201F44")

        private HashMap<String, ArrayList<URL>> map;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.469 -0400", hash_original_method = "379F12D2048DD620EF06C57D0B8DE6F0", hash_generated_method = "59D8AC312A7688B15BB683D206A79DB0")
        public  IndexFile(HashMap<String, ArrayList<URL>> map) {
            this.map = map;
            
            
        }

        
        static IndexFile readIndexFile(JarFile jf, JarEntry indexEntry, URL url) {
            BufferedReader in = null;
            InputStream is = null;
            try {
                String parentURLString = getParentURL(url).toExternalForm();
                String prefix = "jar:" + parentURLString + "/";
                is = jf.getInputStream(indexEntry);
                in = new BufferedReader(new InputStreamReader(is, Charsets.UTF_8));
                HashMap<String, ArrayList<URL>> pre_map = new HashMap<String, ArrayList<URL>>();
                if (in.readLine() == null) return null;
                if (in.readLine() == null) return null;
                TOP_CYCLE:
                while (true) {
                    String line = in.readLine();
                    if (line == null) {
                        break;
                    }
                    URL jar = new URL(prefix + line + "!/");
                    while (true) {
                        line = in.readLine();
                        if (line == null) {
                            break TOP_CYCLE;
                        }
                        if (line.isEmpty()) {
                            break;
                        }
                        ArrayList<URL> list;
                        if (pre_map.containsKey(line)) {
                            list = pre_map.get(line);
                        } else {
                            list = new ArrayList<URL>();
                            pre_map.put(line, list);
                        }
                        list.add(jar);
                    }
                }
                if (!pre_map.isEmpty()) {
                    return new IndexFile(pre_map);
                }
            } catch (MalformedURLException e) {
            } catch (IOException e) {
            } finally {
                IoUtils.closeQuietly(in);
                IoUtils.closeQuietly(is);
            }
            return null;
        }

        
        private static URL getParentURL(URL url) throws IOException {
            URL fileURL = ((JarURLConnection) url.openConnection()).getJarFileURL();
            String file = fileURL.getFile();
            String parentFile = new File(file).getParent();
            parentFile = parentFile.replace(File.separatorChar, '/');
            if (parentFile.charAt(0) != '/') {
                parentFile = "/" + parentFile;
            }
            URL parentURL = new URL(fileURL.getProtocol(), fileURL
                    .getHost(), fileURL.getPort(), parentFile);
            return parentURL;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.471 -0400", hash_original_method = "8FF86E61D1723FF11EF08355D8ACABBC", hash_generated_method = "D642AF1FE59331B61D6AD07609FB8E25")
         ArrayList<URL> get(String name) {
            ArrayList<URL> varB4EAC82CA7396A68D541C85D26508E83_166823181 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_166823181 = map.get(name);
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_166823181.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_166823181;
            
            
        }

        
    }


    
    class URLHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.471 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "D0C59163767519DDC23EEDD08636971F")

        URL url;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.471 -0400", hash_original_field = "6B41B640483CE6C30687EB43271D5F95", hash_generated_field = "CA61315DDA6019C64E03F42F9050F544")

        URL codeSourceUrl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.472 -0400", hash_original_method = "D5B6F191489E39FDFBD95ACBEEF6948D", hash_generated_method = "D13F0BDC7438F2204A7900E8E8D32315")
        public  URLHandler(URL url) {
            this.url = url;
            this.codeSourceUrl = url;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.472 -0400", hash_original_method = "A27A46A41A88BA0FAAC7830FBD366ED6", hash_generated_method = "2D78808B52BB676163E503999DDA836F")
         void findResources(String name, ArrayList<URL> resources) {
            URL res = findResource(name);
            {
                boolean varFC751D1AB3C4048454C180D236DA6858_1795767467 = (res != null && !resources.contains(res));
                {
                    resources.add(res);
                } 
            } 
            addTaint(name.getTaint());
            addTaint(resources.getTaint());
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.473 -0400", hash_original_method = "DE45CDB737E4642285D570F5610849E6", hash_generated_method = "A46F815B48A14ED6EB5FE5D9B3BAF370")
         Class<?> findClass(String packageName, String name, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1436416062 = null; 
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_2113765943 = null; 
            URL resURL = targetURL(url, name);
            {
                try 
                {
                    InputStream is = resURL.openStream();
                    varB4EAC82CA7396A68D541C85D26508E83_1436416062 = createClass(is, packageName, origName);
                } 
                catch (IOException e)
                { }
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2113765943 = null;
            addTaint(packageName.getTaint());
            addTaint(name.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_365685353; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_365685353 = varB4EAC82CA7396A68D541C85D26508E83_1436416062;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_365685353 = varB4EAC82CA7396A68D541C85D26508E83_2113765943;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_365685353.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_365685353;
            
            
            
                
                    
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.477 -0400", hash_original_method = "73460255618B48EEC6C92DAEEADA9765", hash_generated_method = "B9FC3791CA77CB6491230A2E1E9B4896")
         Class<?> createClass(InputStream is, String packageName, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1902810149 = null; 
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1007646401 = null; 
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1038208492 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1902810149 = null;
            } 
            byte[] clBuf = null;
            try 
            {
                clBuf = Streams.readFully(is);
            } 
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1007646401 = null;
            } 
            {
                String packageDotName = packageName.replace('/', '.');
                Package packageObj = getPackage(packageDotName);
                {
                    definePackage(packageDotName, null, null,
                            null, null, null, null, null);
                } 
                {
                    {
                        boolean var46ECFB0AA0749BB31F7AC12ACED7FFF6_109845558 = (packageObj.isSealed());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SecurityException("Package is sealed");
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1038208492 = defineClass(origName, clBuf, 0, clBuf.length, new CodeSource(codeSourceUrl, (Certificate[]) null));
            addTaint(is.getTaint());
            addTaint(packageName.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_1689692753; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1689692753 = varB4EAC82CA7396A68D541C85D26508E83_1902810149;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1689692753 = varB4EAC82CA7396A68D541C85D26508E83_1007646401;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1689692753 = varB4EAC82CA7396A68D541C85D26508E83_1038208492;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1689692753.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1689692753;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.480 -0400", hash_original_method = "127A00E2878A258FF82AAAD1F4FC3101", hash_generated_method = "1C662FF3365BA14C29529480838B2802")
         URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_3321543 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_1507138148 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_1107056213 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_352248814 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_1706221811 = null; 
            URL resURL = targetURL(url, name);
            {
                try 
                {
                    URLConnection uc = resURL.openConnection();
                    uc.getInputStream().close();
                    {
                        boolean varE071FEB2BBC390EE5432466A982988A9_1901473710 = (!resURL.getProtocol().equals("http"));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_3321543 = resURL;
                        } 
                    } 
                    int code;
                    {
                        boolean var691373D752CAE39EA2108E7727B5AEC9_997194875 = ((code = ((HttpURLConnection) uc).getResponseCode()) >= 200
                            && code < 300);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1507138148 = resURL;
                        } 
                    } 
                } 
                catch (SecurityException e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1107056213 = null;
                } 
                catch (IOException e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_352248814 = null;
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1706221811 = null;
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_114629209; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_114629209 = varB4EAC82CA7396A68D541C85D26508E83_3321543;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_114629209 = varB4EAC82CA7396A68D541C85D26508E83_1507138148;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_114629209 = varB4EAC82CA7396A68D541C85D26508E83_1107056213;
                    break;
                case 4: 
                    varA7E53CE21691AB073D9660D615818899_114629209 = varB4EAC82CA7396A68D541C85D26508E83_352248814;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_114629209 = varB4EAC82CA7396A68D541C85D26508E83_1706221811;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_114629209.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_114629209;
            
            
            
                
                    
                    
                    
                        
                    
                    
                    
                            
                        
                    
                
                    
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.483 -0400", hash_original_method = "0524D4A234DDE6E7BD7D4DF76408464F", hash_generated_method = "5B6B1BFEF26A581CFD63094CECA11EA8")
         URL targetURL(URL base, String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_875100832 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_264134264 = null; 
            try 
            {
                StringBuilder fileBuilder = new StringBuilder();
                fileBuilder.append(base.getFile());
                URI.PATH_ENCODER.appendEncoded(fileBuilder, name);
                String file = fileBuilder.toString();
                varB4EAC82CA7396A68D541C85D26508E83_875100832 = new URL(base.getProtocol(), base.getHost(), base.getPort(), file, null);
            } 
            catch (MalformedURLException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_264134264 = null;
            } 
            addTaint(base.getTaint());
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_875500336; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_875500336 = varB4EAC82CA7396A68D541C85D26508E83_875100832;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_875500336 = varB4EAC82CA7396A68D541C85D26508E83_264134264;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_875500336.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_875500336;
            
            
                
                
                
                
                
            
                
            
        }

        
    }


    
    class URLJarHandler extends URLHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.483 -0400", hash_original_field = "FE0EC43CC4200E777AA2190ACE58E7B4", hash_generated_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62")

        JarFile jf;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.484 -0400", hash_original_field = "CFE0C7543E7741B6DE4C8FEFFE50B892", hash_generated_field = "C2C4984C490CB9B238D5B3903BFC80CB")

        String prefixName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.484 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "1CD0A34CFD9CFF5C38175C01E8A02107")

        IndexFile index;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.484 -0400", hash_original_field = "C6ADFED245A732099CF017E901933E62", hash_generated_field = "1E63D5B05AD896CB7F2DEBE9E3B81004")

        final Map<URL, URLHandler> subHandlers = new HashMap<URL, URLHandler>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.484 -0400", hash_original_method = "5C0004D321A5570AF49FDFAA941E414F", hash_generated_method = "386E17EE490645A8AF339FECE0F0B838")
        public  URLJarHandler(URL url, URL jarURL, JarFile jf, String prefixName) {
            super(url);
            this.jf = jf;
            this.prefixName = prefixName;
            this.codeSourceUrl = jarURL;
            final JarEntry je = jf.getJarEntry("META-INF/INDEX.LIST");
            this.index = (je == null ? null : IndexFile.readIndexFile(jf, je, url));
            addTaint(jarURL.getTaint());
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.485 -0400", hash_original_method = "D582F40800649C185B2BDB76509EA85E", hash_generated_method = "406F0538DFEF93034D3A205963D40DD5")
        public  URLJarHandler(URL url, URL jarURL, JarFile jf, String prefixName, IndexFile index) {
            super(url);
            this.jf = jf;
            this.prefixName = prefixName;
            this.index = index;
            this.codeSourceUrl = jarURL;
            addTaint(url.getTaint());
            addTaint(jarURL.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.485 -0400", hash_original_method = "2D62A5E011065AD5CA1BC3D6BB78BB91", hash_generated_method = "1332E72F6FE485FF92045FBF511933F0")
         IndexFile getIndex() {
            IndexFile varB4EAC82CA7396A68D541C85D26508E83_679436838 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_679436838 = index;
            varB4EAC82CA7396A68D541C85D26508E83_679436838.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_679436838;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.493 -0400", hash_original_method = "3BC222ED8E766AE357F97E5ED2C16BF7", hash_generated_method = "26FE00B55F3D73D057D6AEC0728AA16D")
        @Override
         void findResources(String name, ArrayList<URL> resources) {
            URL res = findResourceInOwn(name);
            {
                boolean varFC751D1AB3C4048454C180D236DA6858_935013562 = (res != null && !resources.contains(res));
                {
                    resources.add(res);
                } 
            } 
            {
                int pos = name.lastIndexOf("/");
                String indexedName;
                indexedName = name.substring(0, pos);
                indexedName = name;
                ArrayList<URL> urls = index.get(indexedName);
                {
                    urls.remove(url);
                    {
                        Iterator<URL> varA1868600C8D23C84BF90B90E66B7DED1_1631902374 = (urls).iterator();
                        varA1868600C8D23C84BF90B90E66B7DED1_1631902374.hasNext();
                        URL url = varA1868600C8D23C84BF90B90E66B7DED1_1631902374.next();
                        {
                            URLHandler h = getSubHandler(url);
                            {
                                h.findResources(name, resources);
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(name.getTaint());
            addTaint(resources.getTaint());
            
            
            
                
            
            
                
                
                
                
                    
                    
                        
                        
                            
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.497 -0400", hash_original_method = "A33B0C1225B85366B8FACC1A747264F5", hash_generated_method = "1A965E60B470A81DDE20F437D4DC15F1")
        @Override
         Class<?> findClass(String packageName, String name, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_203220726 = null; 
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_704217555 = null; 
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1900647193 = null; 
            String entryName = prefixName + name;
            JarEntry entry = jf.getJarEntry(entryName);
            {
                try 
                {
                    Manifest manifest = jf.getManifest();
                    varB4EAC82CA7396A68D541C85D26508E83_203220726 = createClass(entry, manifest, packageName, origName);
                } 
                catch (IOException e)
                { }
            } 
            {
                ArrayList<URL> urls;
                {
                    urls = index.get(name);
                } 
                {
                    urls = index.get(packageName);
                } 
                {
                    urls.remove(url);
                    {
                        Iterator<URL> varA1868600C8D23C84BF90B90E66B7DED1_1657654094 = (urls).iterator();
                        varA1868600C8D23C84BF90B90E66B7DED1_1657654094.hasNext();
                        URL url = varA1868600C8D23C84BF90B90E66B7DED1_1657654094.next();
                        {
                            URLHandler h = getSubHandler(url);
                            {
                                Class<?> res = h.findClass(packageName, name, origName);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_704217555 = res;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1900647193 = null;
            addTaint(packageName.getTaint());
            addTaint(name.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_1486781752; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1486781752 = varB4EAC82CA7396A68D541C85D26508E83_203220726;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1486781752 = varB4EAC82CA7396A68D541C85D26508E83_704217555;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1486781752 = varB4EAC82CA7396A68D541C85D26508E83_1900647193;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1486781752.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1486781752;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.501 -0400", hash_original_method = "0997311DA5151313F3B17639635BC461", hash_generated_method = "F3126E4E686D1C6625640BB91E6B03F7")
        private Class<?> createClass(JarEntry entry, Manifest manifest, String packageName, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1630366679 = null; 
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1117475615 = null; 
            byte[] clBuf = null;
            try 
            {
                InputStream is = jf.getInputStream(entry);
                clBuf = Streams.readFully(is);
            } 
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1630366679 = null;
            } 
            {
                String packageDotName = packageName.replace('/', '.');
                Package packageObj = getPackage(packageDotName);
                {
                    {
                        definePackage(packageDotName, manifest,
                                codeSourceUrl);
                    } 
                    {
                        definePackage(packageDotName, null, null,
                                null, null, null, null, null);
                    } 
                } 
                {
                    boolean exception = packageObj.isSealed();
                    {
                        {
                            boolean var430A4EB459A125FCCE6A1B2B0A7A99BF_1777077057 = (isSealed(manifest, packageName + "/"));
                            {
                                exception = !packageObj
                                    .isSealed(codeSourceUrl);
                            } 
                        } 
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SecurityException(String.format("Package %s is sealed",
                                packageName));
                    } 
                } 
            } 
            CodeSource codeS = new CodeSource(codeSourceUrl, entry.getCertificates());
            varB4EAC82CA7396A68D541C85D26508E83_1117475615 = defineClass(origName, clBuf, 0, clBuf.length, codeS);
            addTaint(entry.getTaint());
            addTaint(manifest.getTaint());
            addTaint(packageName.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_685406638; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_685406638 = varB4EAC82CA7396A68D541C85D26508E83_1630366679;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_685406638 = varB4EAC82CA7396A68D541C85D26508E83_1117475615;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_685406638.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_685406638;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.505 -0400", hash_original_method = "BEAE23CC7138835BB0FEF01D26145FD9", hash_generated_method = "439DBAC353949FCC43BF38C7B047FB49")
         URL findResourceInOwn(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_895804505 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_134027674 = null; 
            String entryName = prefixName + name;
            {
                boolean var970A0F969D5FE2206AF80ED83FDD2671_566665123 = (jf.getEntry(entryName) != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_895804505 = targetURL(url, name);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_134027674 = null;
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_102276412; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_102276412 = varB4EAC82CA7396A68D541C85D26508E83_895804505;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_102276412 = varB4EAC82CA7396A68D541C85D26508E83_134027674;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_102276412.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_102276412;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.512 -0400", hash_original_method = "7546D3992FBBAF86B12F0B740620B74B", hash_generated_method = "1BF7806D2EFF8F6B6AC734F96D1879B6")
        @Override
         URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_2080631803 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_384119243 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_1429830723 = null; 
            URL res = findResourceInOwn(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2080631803 = res;
            } 
            {
                int pos = name.lastIndexOf("/");
                String indexedName;
                indexedName = name.substring(0, pos);
                indexedName = name;
                ArrayList<URL> urls = index.get(indexedName);
                {
                    urls.remove(url);
                    {
                        Iterator<URL> varA1868600C8D23C84BF90B90E66B7DED1_737811077 = (urls).iterator();
                        varA1868600C8D23C84BF90B90E66B7DED1_737811077.hasNext();
                        URL url = varA1868600C8D23C84BF90B90E66B7DED1_737811077.next();
                        {
                            URLHandler h = getSubHandler(url);
                            {
                                res = h.findResource(name);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_384119243 = res;
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1429830723 = null;
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_540337772; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_540337772 = varB4EAC82CA7396A68D541C85D26508E83_2080631803;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_540337772 = varB4EAC82CA7396A68D541C85D26508E83_384119243;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_540337772 = varB4EAC82CA7396A68D541C85D26508E83_1429830723;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_540337772.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_540337772;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.514 -0400", hash_original_method = "47CD540256D0F2B23AE4D5BB7E445858", hash_generated_method = "7FB6B82232022E45AB66F44C415367C2")
        private synchronized URLHandler getSubHandler(URL url) {
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_706953382 = null; 
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_936059375 = null; 
            URLHandler sub = subHandlers.get(url);
            {
                varB4EAC82CA7396A68D541C85D26508E83_706953382 = sub;
            } 
            String protocol = url.getProtocol();
            {
                boolean varFE0A78E78A02221C3A8F7118E438EAB7_1326666827 = (protocol.equals("jar"));
                {
                    sub = createURLJarHandler(url);
                } 
                {
                    boolean var07199D08C001E96CE71D5573EC1F815A_90246403 = (protocol.equals("file"));
                    {
                        sub = createURLSubJarHandler(url);
                    } 
                    {
                        sub = createURLHandler(url);
                    } 
                } 
            } 
            {
                subHandlers.put(url, sub);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_936059375 = sub;
            addTaint(url.getTaint());
            URLHandler varA7E53CE21691AB073D9660D615818899_1012224796; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1012224796 = varB4EAC82CA7396A68D541C85D26508E83_706953382;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1012224796 = varB4EAC82CA7396A68D541C85D26508E83_936059375;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1012224796.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1012224796;
            
            
            
                
            
            
            
                
            
                
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.515 -0400", hash_original_method = "CC5C093E882DD207DA9222EBC985A361", hash_generated_method = "FFF9E56F38E1C1CEAF9AC16B71C227E2")
        private URLHandler createURLSubJarHandler(URL url) {
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_148828846 = null; 
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_1220034582 = null; 
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_1994603850 = null; 
            String prefixName;
            String file = url.getFile();
            {
                boolean var7356D1B77839B718E750922987458DE7_358526114 = (url.getFile().endsWith("!/"));
                {
                    prefixName = "";
                } 
                {
                    int sepIdx = file.lastIndexOf("!/");
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_148828846 = null;
                    } 
                    sepIdx += 2;
                    prefixName = file.substring(sepIdx);
                } 
            } 
            try 
            {
                URL jarURL = ((JarURLConnection) url
                        .openConnection()).getJarFileURL();
                JarURLConnection juc = (JarURLConnection) new URL(
                        "jar", "",
                        jarURL.toExternalForm() + "!/").openConnection();
                JarFile jf = juc.getJarFile();
                URLJarHandler jarH = new URLJarHandler(url, jarURL, jf, prefixName, null);
                varB4EAC82CA7396A68D541C85D26508E83_1220034582 = jarH;
            } 
            catch (IOException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_1994603850 = null;
            addTaint(url.getTaint());
            URLHandler varA7E53CE21691AB073D9660D615818899_55994053; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_55994053 = varB4EAC82CA7396A68D541C85D26508E83_148828846;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_55994053 = varB4EAC82CA7396A68D541C85D26508E83_1220034582;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_55994053 = varB4EAC82CA7396A68D541C85D26508E83_1994603850;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_55994053.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_55994053;
            
            
        }

        
    }


    
    class URLFileHandler extends URLHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.516 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

        private String prefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.517 -0400", hash_original_method = "748B8F1639705FB8AE66EE4520D13BFB", hash_generated_method = "583CF17B417EDC8B0628C50C40F2FCCA")
        public  URLFileHandler(URL url) {
            super(url);
            String baseFile = url.getFile();
            String host = url.getHost();
            int hostLength = 0;
            {
                hostLength = host.length();
            } 
            StringBuilder buf = new StringBuilder(2 + hostLength
                    + baseFile.length());
            {
                buf.append("//").append(host);
            } 
            buf.append(baseFile);
            prefix = buf.toString();
            addTaint(url.getTaint());
            
            
            
            
            
                
            
            
                    
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.518 -0400", hash_original_method = "459A43E8A29596EEF0DEE6D3A05FE74A", hash_generated_method = "658988EBE1035A5979A2CC1D606C6B7F")
        @Override
         Class<?> findClass(String packageName, String name, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1551255691 = null; 
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1585845241 = null; 
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1986686828 = null; 
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1732662915 = null; 
            String filename = prefix + name;
            try 
            {
                filename = URLDecoder.decode(filename, "UTF-8");
            } 
            catch (IllegalArgumentException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1551255691 = null;
            } 
            catch (UnsupportedEncodingException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1585845241 = null;
            } 
            File file = new File(filename);
            {
                boolean var59AA0F7651ECC78FBF1607A856F762E1_618016064 = (file.exists());
                {
                    try 
                    {
                        InputStream is = new FileInputStream(file);
                        varB4EAC82CA7396A68D541C85D26508E83_1986686828 = createClass(is, packageName, origName);
                    } 
                    catch (FileNotFoundException e)
                    { }
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1732662915 = null;
            addTaint(packageName.getTaint());
            addTaint(name.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_948596736; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_948596736 = varB4EAC82CA7396A68D541C85D26508E83_1551255691;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_948596736 = varB4EAC82CA7396A68D541C85D26508E83_1585845241;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_948596736 = varB4EAC82CA7396A68D541C85D26508E83_1986686828;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_948596736 = varB4EAC82CA7396A68D541C85D26508E83_1732662915;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_948596736.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_948596736;
            
            
            
                
            
                
            
                
            
            
            
                
                    
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.520 -0400", hash_original_method = "5954C39BABA19C5921C727F17BF4740B", hash_generated_method = "7BDBB2E33C32B752DEC687D4666778F4")
        @Override
         URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_899011330 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_1398380035 = null; 
            URL varB4EAC82CA7396A68D541C85D26508E83_1911553334 = null; 
            int idx = 0;
            String filename;
            {
                boolean var23EFF342BB8E7FE0217A53D321A1C78E_1740151218 = (idx < name.length() &&
                   ((name.charAt(idx) == '/') || (name.charAt(idx) == '\\')));
            } 
            {
                name = name.substring(idx);
            } 
            try 
            {
                filename = URLDecoder.decode(prefix, "UTF-8") + name;
                {
                    boolean varBF735348FCCFEB4D8EC418F0236B8831_34259067 = (new File(filename).exists());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_899011330 = targetURL(url, name);
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1398380035 = null;
            } 
            catch (IllegalArgumentException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1911553334 = null;
            } 
            catch (UnsupportedEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
            } 
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_1313776356; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1313776356 = varB4EAC82CA7396A68D541C85D26508E83_899011330;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1313776356 = varB4EAC82CA7396A68D541C85D26508E83_1398380035;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1313776356 = varB4EAC82CA7396A68D541C85D26508E83_1911553334;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1313776356.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1313776356;
            
            
            
            
                   
                
            
            
                
            
            
                
                
                    
                
                
            
                
            
                
            
        }

        
    }


    
}

