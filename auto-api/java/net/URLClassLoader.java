package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.868 -0400", hash_original_field = "B29D73214A4D23ADA5B59B6F71D732DF", hash_generated_field = "8493272A5AB4A77AB209F22490E9A299")

    ArrayList<URL> originalUrls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.868 -0400", hash_original_field = "583BE25E7B8F5E9B4CF06A08F494F4E5", hash_generated_field = "6EEE0C60179788AF966E079989CB5CB3")

    List<URL> searchList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.868 -0400", hash_original_field = "A12AB4D5BFE9F5C0714A5AC8F9CC246A", hash_generated_field = "018DFABF07E4A0807227E840C28DF558")

    ArrayList<URLHandler> handlerList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.868 -0400", hash_original_field = "C7A9E9C96BAE4B4D941CA4F6492C31FF", hash_generated_field = "83210D660C03E6C9492E92BD982991A6")

    Map<URL, URLHandler> handlerMap = new HashMap<URL, URLHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.869 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "E43CA7AA04ACD2FE8928E03B47B06D76")

    private URLStreamHandlerFactory factory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.869 -0400", hash_original_method = "223BBDDFA8D7BCBDBB892F093839C31A", hash_generated_method = "7574BADAD0DECFD730EB097F2190D40F")
    public  URLClassLoader(URL[] urls) {
        this(urls, ClassLoader.getSystemClassLoader(), null);
        addTaint(urls[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.893 -0400", hash_original_method = "2C1F233833FFEC69CE12E7A0069A8B49", hash_generated_method = "36B94FD949236AA62E1679990C9E0F97")
    public  URLClassLoader(URL[] urls, ClassLoader parent) {
        this(urls, parent, null);
        addTaint(urls[0].getTaint());
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.895 -0400", hash_original_method = "9F92FD383D821F82B2A5EE941293558A", hash_generated_method = "51AF40EE4F6C33761D4AD204AC0153B1")
    public  URLClassLoader(URL[] searchUrls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(parent);
        this.factory = factory;
        int nbUrls;
        nbUrls = searchUrls.length;
        originalUrls = new ArrayList<URL>(nbUrls);
        handlerList = new ArrayList<URLHandler>(nbUrls);
        searchList = Collections.synchronizedList(new ArrayList<URL>(nbUrls));
        {
            int i;
            i = 0;
            {
                originalUrls.add(searchUrls[i]);
                try 
                {
                    searchList.add(createSearchURL(searchUrls[i]));
                } //End block
                catch (MalformedURLException e)
                { }
            } //End block
        } //End collapsed parenthetic
        addTaint(searchUrls[0].getTaint());
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
        //this.factory = factory;
        //int nbUrls = searchUrls.length;
        //originalUrls = new ArrayList<URL>(nbUrls);
        //handlerList = new ArrayList<URLHandler>(nbUrls);
        //searchList = Collections.synchronizedList(new ArrayList<URL>(nbUrls));
        //for (int i = 0; i < nbUrls; i++) {
            //originalUrls.add(searchUrls[i]);
            //try {
                //searchList.add(createSearchURL(searchUrls[i]));
            //} catch (MalformedURLException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.896 -0400", hash_original_method = "8767B0DB3A608CD14EAA847CE6E9F597", hash_generated_method = "3834D3634E44E0F2A447C4EBFBE4F5C8")
    protected void addURL(URL url) {
        try 
        {
            originalUrls.add(url);
            searchList.add(createSearchURL(url));
        } //End block
        catch (MalformedURLException e)
        { }
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //try {
            //originalUrls.add(url);
            //searchList.add(createSearchURL(url));
        //} catch (MalformedURLException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.916 -0400", hash_original_method = "E35E96FBBA5328024F5002F5E092C0FA", hash_generated_method = "A346EB616F1A4BBE33A1FC327029B57D")
    @Override
    public Enumeration<URL> findResources(final String name) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_621004010 = null; //Variable for return #1
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_1522026705 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_621004010 = null;
        } //End block
        ArrayList<URL> result;
        result = new ArrayList<URL>();
        int n;
        n = 0;
        {
            URLHandler handler;
            handler = getHandler(n++);
            handler.findResources(name, result);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1522026705 = Collections.enumeration(result);
        addTaint(name.getTaint());
        Enumeration<URL> varA7E53CE21691AB073D9660D615818899_900819010; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_900819010 = varB4EAC82CA7396A68D541C85D26508E83_621004010;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_900819010 = varB4EAC82CA7396A68D541C85D26508E83_1522026705;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_900819010.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_900819010;
        // ---------- Original Method ----------
        //if (name == null) {
            //return null;
        //}
        //ArrayList<URL> result = new ArrayList<URL>();
        //int n = 0;
        //while (true) {
            //URLHandler handler = getHandler(n++);
            //if (handler == null) {
                //break;
            //}
            //handler.findResources(name, result);
        //}
        //return Collections.enumeration(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.917 -0400", hash_original_method = "B4723E664A18325BA87109668B89BB4C", hash_generated_method = "C624BE5F56AB8DEFE9678D5E9A56122F")
    @Override
    protected PermissionCollection getPermissions(final CodeSource codesource) {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_648309921 = null; //Variable for return #1
        PermissionCollection pc;
        pc = super.getPermissions(codesource);
        URL u;
        u = codesource.getLocation();
        {
            boolean var0D3DCE32DE3636DD78A2BE6460215DDE_1334061124 = (u.getProtocol().equals("jar"));
            {
                try 
                {
                    u = ((JarURLConnection) u.openConnection()).getJarFileURL();
                } //End block
                catch (IOException e)
                { }
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4D320D496AF3A7A0362D9991BB7F9187_2039973709 = (u.getProtocol().equals("file"));
            {
                String path;
                path = u.getFile();
                String host;
                host = u.getHost();
                {
                    boolean var2D544DB6C0FDD148F3E57369E992EC16_1814401094 = (host != null && host.length() > 0);
                    {
                        path = "//" + host + path;
                    } //End block
                } //End collapsed parenthetic
                {
                    path = path.replace('/', File.separatorChar);
                } //End block
                {
                    boolean varC84208C3E0250C4294B433F1E7B244E4_966597966 = (isDirectory(u));
                    {
                        pc.add(new FilePermission(path + "-", "read"));
                    } //End block
                    {
                        pc.add(new FilePermission(path, "read"));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                String host;
                host = u.getHost();
                {
                    boolean varC53ECC4BC21F90A0F577E60A03E6C413_2066066866 = (host.length() == 0);
                    {
                        host = "localhost";
                    } //End block
                } //End collapsed parenthetic
                pc.add(new SocketPermission(host, "connect, accept"));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_648309921 = pc;
        addTaint(codesource.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_648309921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_648309921;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.918 -0400", hash_original_method = "E74D6D295FD8DF7C4B8AB85761E02982", hash_generated_method = "C4354A54884D72248E6C3B83BA894014")
    public URL[] getURLs() {
        URL[] varB4EAC82CA7396A68D541C85D26508E83_1687721810 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1687721810 = originalUrls.toArray(new URL[originalUrls.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1687721810.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1687721810;
        // ---------- Original Method ----------
        //return originalUrls.toArray(new URL[originalUrls.size()]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.925 -0400", hash_original_method = "BAA63B0BE9A75DDAC07B90D04DE61F0B", hash_generated_method = "B228F5809D2753CDDC6B2CAD0440478B")
    @Override
    protected Class<?> findClass(final String className) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_106478032 = null; //Variable for return #1
        String partialName;
        partialName = className.replace('.', '/');
        String classFileName;
        classFileName = new StringBuilder(partialName).append(".class").toString();
        String packageName;
        packageName = null;
        int position;
        position = partialName.lastIndexOf('/');
        {
            boolean var3E1D041C4A1A150031AEB32E198BD1A9_128753434 = ((position = partialName.lastIndexOf('/')) != -1);
            {
                packageName = partialName.substring(0, position);
            } //End block
        } //End collapsed parenthetic
        int n;
        n = 0;
        {
            URLHandler handler;
            handler = getHandler(n++);
            Class<?> res;
            res = handler.findClass(packageName, classFileName, className);
            {
                varB4EAC82CA7396A68D541C85D26508E83_106478032 = res;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(className);
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_106478032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_106478032;
        // ---------- Original Method ----------
        //String partialName = className.replace('.', '/');
        //final String classFileName = new StringBuilder(partialName).append(".class").toString();
        //String packageName = null;
        //int position = partialName.lastIndexOf('/');
        //if ((position = partialName.lastIndexOf('/')) != -1) {
            //packageName = partialName.substring(0, position);
        //}
        //int n = 0;
        //while (true) {
            //URLHandler handler = getHandler(n++);
            //if (handler == null) {
                //break;
            //}
            //Class<?> res = handler.findClass(packageName, classFileName, className);
            //if (res != null) {
                //return res;
            //}
        //}
        //throw new ClassNotFoundException(className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.952 -0400", hash_original_method = "75025FE733C588323FB29CA64B72756D", hash_generated_method = "A3512291321142490478830664F1F937")
    private URL createSearchURL(URL url) throws MalformedURLException {
        URL varB4EAC82CA7396A68D541C85D26508E83_316181743 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_2075175673 = null; //Variable for return #2
        URL varB4EAC82CA7396A68D541C85D26508E83_20892759 = null; //Variable for return #3
        URL varB4EAC82CA7396A68D541C85D26508E83_325240476 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_316181743 = url;
        } //End block
        String protocol;
        protocol = url.getProtocol();
        {
            boolean var6B09AA880739B965279245545031D717_1698996410 = (isDirectory(url) || protocol.equals("jar"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2075175673 = url;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_20892759 = new URL("jar", "",
                    -1, url.toString() + "!/");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_325240476 = new URL("jar", "",
                -1, url.toString() + "!/",
                factory.createURLStreamHandler("jar"));
        addTaint(url.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_653165172; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_653165172 = varB4EAC82CA7396A68D541C85D26508E83_316181743;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_653165172 = varB4EAC82CA7396A68D541C85D26508E83_2075175673;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_653165172 = varB4EAC82CA7396A68D541C85D26508E83_20892759;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_653165172 = varB4EAC82CA7396A68D541C85D26508E83_325240476;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_653165172.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_653165172;
        // ---------- Original Method ----------
        //if (url == null) {
            //return url;
        //}
        //String protocol = url.getProtocol();
        //if (isDirectory(url) || protocol.equals("jar")) {
            //return url;
        //}
        //if (factory == null) {
            //return new URL("jar", "",
                    //-1, url.toString() + "!/");
        //}
        //return new URL("jar", "",
                //-1, url.toString() + "!/",
                //factory.createURLStreamHandler("jar"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.953 -0400", hash_original_method = "36DCCA8214496CA792D9D415CCE3C1EC", hash_generated_method = "20518CB652ED4F1E8A245FC457FEF281")
    @Override
    public URL findResource(final String name) {
        URL varB4EAC82CA7396A68D541C85D26508E83_782668490 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_1721303566 = null; //Variable for return #2
        URL varB4EAC82CA7396A68D541C85D26508E83_1799224840 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_782668490 = null;
        } //End block
        int n;
        n = 0;
        {
            URLHandler handler;
            handler = getHandler(n++);
            URL res;
            res = handler.findResource(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1721303566 = res;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1799224840 = null;
        addTaint(name.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_584027197; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_584027197 = varB4EAC82CA7396A68D541C85D26508E83_782668490;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_584027197 = varB4EAC82CA7396A68D541C85D26508E83_1721303566;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_584027197 = varB4EAC82CA7396A68D541C85D26508E83_1799224840;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_584027197.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_584027197;
        // ---------- Original Method ----------
        //if (name == null) {
            //return null;
        //}
        //int n = 0;
        //while (true) {
            //URLHandler handler = getHandler(n++);
            //if (handler == null) {
                //break;
            //}
            //URL res = handler.findResource(name);
            //if (res != null) {
                //return res;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.957 -0400", hash_original_method = "CFA5B2A5119E9C6C6C6B8BDB54F0FFE4", hash_generated_method = "6BC536D321A940CA6D77F4F784F890B5")
    private URLHandler getHandler(int num) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_669908930 = null; //Variable for return #1
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_1993637362 = null; //Variable for return #2
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_1682258440 = null; //Variable for return #3
        {
            boolean varC6CBE7D489CE95B916048C828E20629B_976792025 = (num < handlerList.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_669908930 = handlerList.get(num);
            } //End block
        } //End collapsed parenthetic
        makeNewHandler();
        {
            boolean varC6CBE7D489CE95B916048C828E20629B_95011831 = (num < handlerList.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1993637362 = handlerList.get(num);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1682258440 = null;
        addTaint(num);
        URLHandler varA7E53CE21691AB073D9660D615818899_1032910499; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1032910499 = varB4EAC82CA7396A68D541C85D26508E83_669908930;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1032910499 = varB4EAC82CA7396A68D541C85D26508E83_1993637362;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1032910499 = varB4EAC82CA7396A68D541C85D26508E83_1682258440;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1032910499.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1032910499;
        // ---------- Original Method ----------
        //if (num < handlerList.size()) {
            //return handlerList.get(num);
        //}
        //makeNewHandler();
        //if (num < handlerList.size()) {
            //return handlerList.get(num);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.958 -0400", hash_original_method = "A878B5121D5BF1232029A8CDBC76BE45", hash_generated_method = "46B149359E7F393DB6E4599B1BF73CAD")
    private synchronized void makeNewHandler() {
        {
            boolean var056FE5D37761D5D3DC4B0CF57BDA52B0_1437270083 = (!searchList.isEmpty());
            {
                URL nextCandidate;
                nextCandidate = searchList.remove(0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("A URL is null");
                } //End block
                {
                    boolean var087B3C4559B5C5125F9C3E5F757C0545_348920553 = (!handlerMap.containsKey(nextCandidate));
                    {
                        URLHandler result;
                        String protocol;
                        protocol = nextCandidate.getProtocol();
                        {
                            boolean varB604F1DF8F50013B1F7F0E3AFFD2694D_913432364 = (protocol.equals("jar"));
                            {
                                result = createURLJarHandler(nextCandidate);
                            } //End block
                            {
                                boolean varC08545D58A986C9447AB113046FC989F_788264838 = (protocol.equals("file"));
                                {
                                    result = createURLFileHandler(nextCandidate);
                                } //End block
                                {
                                    result = createURLHandler(nextCandidate);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                        {
                            handlerMap.put(nextCandidate, result);
                            handlerList.add(result);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.959 -0400", hash_original_method = "15D2A778081BB97B4F5082C5EA9323F2", hash_generated_method = "158A6A51102199FA118C32FFA60452E4")
    private URLHandler createURLHandler(URL url) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_900589004 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_900589004 = new URLHandler(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_900589004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_900589004;
        // ---------- Original Method ----------
        //return new URLHandler(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.968 -0400", hash_original_method = "959FE775BCBFF6223F7FD94A4010D369", hash_generated_method = "5F4CA06577895BEB85841330A709E8D4")
    private URLHandler createURLFileHandler(URL url) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_2069687863 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2069687863 = new URLFileHandler(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2069687863.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2069687863;
        // ---------- Original Method ----------
        //return new URLFileHandler(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.970 -0400", hash_original_method = "93DBA576D247FBB46E5BCA4D9E3C8DFF", hash_generated_method = "EDA3EE8D154982B764FFB320E693D9E2")
    private URLHandler createURLJarHandler(URL url) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_154359852 = null; //Variable for return #1
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_726731263 = null; //Variable for return #2
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_1128418457 = null; //Variable for return #3
        String prefixName;
        String file;
        file = url.getFile();
        {
            boolean var5A4D7A486C11D5F49AB1CA63C5A4886E_559076593 = (url.getFile().endsWith("!/"));
            {
                prefixName = "";
            } //End block
            {
                int sepIdx;
                sepIdx = file.lastIndexOf("!/");
                {
                    varB4EAC82CA7396A68D541C85D26508E83_154359852 = null;
                } //End block
                sepIdx += 2;
                prefixName = file.substring(sepIdx);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            URL jarURL;
            jarURL = ((JarURLConnection) url
                    .openConnection()).getJarFileURL();
            JarURLConnection juc;
            juc = (JarURLConnection) new URL(
                    "jar", "",
                    jarURL.toExternalForm() + "!/").openConnection();
            JarFile jf;
            jf = juc.getJarFile();
            URLJarHandler jarH;
            jarH = new URLJarHandler(url, jarURL, jf, prefixName);
            {
                boolean varD44BF004E9F3CB1AD9A1AE5B28A8F27A_155513151 = (jarH.getIndex() == null);
                {
                    try 
                    {
                        Manifest manifest;
                        manifest = jf.getManifest();
                        {
                            String classpath;
                            classpath = manifest.getMainAttributes().getValue(
                                Attributes.Name.CLASS_PATH);
                            {
                                searchList.addAll(0, getInternalURLs(url, classpath));
                            } //End block
                        } //End block
                    } //End block
                    catch (IOException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_726731263 = jarH;
        } //End block
        catch (IOException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1128418457 = null;
        addTaint(url.getTaint());
        URLHandler varA7E53CE21691AB073D9660D615818899_1128469056; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1128469056 = varB4EAC82CA7396A68D541C85D26508E83_154359852;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1128469056 = varB4EAC82CA7396A68D541C85D26508E83_726731263;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1128469056 = varB4EAC82CA7396A68D541C85D26508E83_1128418457;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1128469056.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1128469056;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.994 -0400", hash_original_method = "1F20C74E5FA90998EED1F262145E5A78", hash_generated_method = "B126217B5694B51634A285CFB80BAA01")
    protected Package definePackage(String packageName, Manifest manifest,
                                    URL url) throws IllegalArgumentException {
        Package varB4EAC82CA7396A68D541C85D26508E83_1255913680 = null; //Variable for return #1
        Attributes mainAttributes;
        mainAttributes = manifest.getMainAttributes();
        String dirName;
        dirName = packageName.replace('.', '/') + "/";
        Attributes packageAttributes;
        packageAttributes = manifest.getAttributes(dirName);
        boolean noEntry;
        noEntry = false;
        {
            noEntry = true;
            packageAttributes = mainAttributes;
        } //End block
        String specificationTitle;
        specificationTitle = packageAttributes
                .getValue(Attributes.Name.SPECIFICATION_TITLE);
        {
            specificationTitle = mainAttributes
                    .getValue(Attributes.Name.SPECIFICATION_TITLE);
        } //End block
        String specificationVersion;
        specificationVersion = packageAttributes
                .getValue(Attributes.Name.SPECIFICATION_VERSION);
        {
            specificationVersion = mainAttributes
                    .getValue(Attributes.Name.SPECIFICATION_VERSION);
        } //End block
        String specificationVendor;
        specificationVendor = packageAttributes
                .getValue(Attributes.Name.SPECIFICATION_VENDOR);
        {
            specificationVendor = mainAttributes
                    .getValue(Attributes.Name.SPECIFICATION_VENDOR);
        } //End block
        String implementationTitle;
        implementationTitle = packageAttributes
                .getValue(Attributes.Name.IMPLEMENTATION_TITLE);
        {
            implementationTitle = mainAttributes
                    .getValue(Attributes.Name.IMPLEMENTATION_TITLE);
        } //End block
        String implementationVersion;
        implementationVersion = packageAttributes
                .getValue(Attributes.Name.IMPLEMENTATION_VERSION);
        {
            implementationVersion = mainAttributes
                    .getValue(Attributes.Name.IMPLEMENTATION_VERSION);
        } //End block
        String implementationVendor;
        implementationVendor = packageAttributes
                .getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
        {
            implementationVendor = mainAttributes
                    .getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1255913680 = definePackage(packageName, specificationTitle,
                specificationVersion, specificationVendor, implementationTitle,
                implementationVersion, implementationVendor, isSealed(manifest,
                dirName) ? url : null);
        addTaint(packageName.getTaint());
        addTaint(manifest.getTaint());
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1255913680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1255913680;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.994 -0400", hash_original_method = "F65716DA89135DC89A539D54ADB64D73", hash_generated_method = "D8F2A38ED878F412244C5A48ED27396F")
    private boolean isSealed(Manifest manifest, String dirName) {
        Attributes attributes;
        attributes = manifest.getAttributes(dirName);
        {
            String value;
            value = attributes.getValue(Attributes.Name.SEALED);
            {
                boolean varF9F03D746A978112631EA8BA624DD149_964474189 = (value.equalsIgnoreCase("true"));
            } //End block
        } //End block
        Attributes mainAttributes;
        mainAttributes = manifest.getMainAttributes();
        String value;
        value = mainAttributes.getValue(Attributes.Name.SEALED);
        boolean varE5C35E1E8162E6D042C52DDD4CF2D6AA_1825310502 = ((value != null && value.equalsIgnoreCase("true")));
        addTaint(manifest.getTaint());
        addTaint(dirName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034066232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034066232;
        // ---------- Original Method ----------
        //Attributes attributes = manifest.getAttributes(dirName);
        //if (attributes != null) {
            //String value = attributes.getValue(Attributes.Name.SEALED);
            //if (value != null) {
                //return value.equalsIgnoreCase("true");
            //}
        //}
        //Attributes mainAttributes = manifest.getMainAttributes();
        //String value = mainAttributes.getValue(Attributes.Name.SEALED);
        //return (value != null && value.equalsIgnoreCase("true"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.996 -0400", hash_original_method = "8DCFE07B381999C3DEF19ABA31EFB008", hash_generated_method = "14133B10CF8C58C587C356195EE38C5C")
    private ArrayList<URL> getInternalURLs(URL root, String classpath) {
        ArrayList<URL> varB4EAC82CA7396A68D541C85D26508E83_1059381464 = null; //Variable for return #1
        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(classpath);
        ArrayList<URL> addedURLs;
        addedURLs = new ArrayList<URL>();
        String file;
        file = root.getFile();
        int jarIndex;
        jarIndex = file.lastIndexOf("!/") - 1;
        int index;
        index = file.lastIndexOf("/", jarIndex) + 1;
        {
            index = file.lastIndexOf(
                    System.getProperty("file.separator"), jarIndex) + 1;
        } //End block
        file = file.substring(0, index);
        {
            boolean var2B5824909BF971CED0BAC391F81BF905_1687043488 = (tokenizer.hasMoreElements());
            {
                String element;
                element = tokenizer.nextToken();
                {
                    boolean varE66FC8B2A65C7CA819992997D34C4051_434726325 = (!element.isEmpty());
                    {
                        try 
                        {
                            URL url;
                            url = new URL(new URL(file), element);
                            addedURLs.add(createSearchURL(url));
                        } //End block
                        catch (MalformedURLException e)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1059381464 = addedURLs;
        addTaint(root.getTaint());
        addTaint(classpath.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1059381464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1059381464;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class IndexFile {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.996 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "8CA0A10A56B7E322DF59FAF09C201F44")

        private HashMap<String, ArrayList<URL>> map;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.996 -0400", hash_original_method = "379F12D2048DD620EF06C57D0B8DE6F0", hash_generated_method = "59D8AC312A7688B15BB683D206A79DB0")
        public  IndexFile(HashMap<String, ArrayList<URL>> map) {
            this.map = map;
            // ---------- Original Method ----------
            //this.map = map;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.998 -0400", hash_original_method = "8FF86E61D1723FF11EF08355D8ACABBC", hash_generated_method = "CC78AE36C0E20D3DC846528B5F08D0F1")
         ArrayList<URL> get(String name) {
            ArrayList<URL> varB4EAC82CA7396A68D541C85D26508E83_1852269534 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1852269534 = map.get(name);
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1852269534.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1852269534;
            // ---------- Original Method ----------
            //return map.get(name);
        }

        
    }


    
    class URLHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.998 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "D0C59163767519DDC23EEDD08636971F")

        URL url;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.998 -0400", hash_original_field = "6B41B640483CE6C30687EB43271D5F95", hash_generated_field = "CA61315DDA6019C64E03F42F9050F544")

        URL codeSourceUrl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.009 -0400", hash_original_method = "D5B6F191489E39FDFBD95ACBEEF6948D", hash_generated_method = "D13F0BDC7438F2204A7900E8E8D32315")
        public  URLHandler(URL url) {
            this.url = url;
            this.codeSourceUrl = url;
            // ---------- Original Method ----------
            //this.url = url;
            //this.codeSourceUrl = url;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.009 -0400", hash_original_method = "A27A46A41A88BA0FAAC7830FBD366ED6", hash_generated_method = "E5970EF9704A065E4DF1EAB8F6682C51")
         void findResources(String name, ArrayList<URL> resources) {
            URL res;
            res = findResource(name);
            {
                boolean varFC751D1AB3C4048454C180D236DA6858_489539477 = (res != null && !resources.contains(res));
                {
                    resources.add(res);
                } //End block
            } //End collapsed parenthetic
            addTaint(name.getTaint());
            addTaint(resources.getTaint());
            // ---------- Original Method ----------
            //URL res = findResource(name);
            //if (res != null && !resources.contains(res)) {
                //resources.add(res);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.010 -0400", hash_original_method = "DE45CDB737E4642285D570F5610849E6", hash_generated_method = "E314AB9D66B2BD21E83128280F6FC63A")
         Class<?> findClass(String packageName, String name, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1229237000 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1690663819 = null; //Variable for return #2
            URL resURL;
            resURL = targetURL(url, name);
            {
                try 
                {
                    InputStream is;
                    is = resURL.openStream();
                    varB4EAC82CA7396A68D541C85D26508E83_1229237000 = createClass(is, packageName, origName);
                } //End block
                catch (IOException e)
                { }
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1690663819 = null;
            addTaint(packageName.getTaint());
            addTaint(name.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_1949044793; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1949044793 = varB4EAC82CA7396A68D541C85D26508E83_1229237000;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1949044793 = varB4EAC82CA7396A68D541C85D26508E83_1690663819;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1949044793.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1949044793;
            // ---------- Original Method ----------
            //URL resURL = targetURL(url, name);
            //if (resURL != null) {
                //try {
                    //InputStream is = resURL.openStream();
                    //return createClass(is, packageName, origName);
                //} catch (IOException e) {
                //}
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.011 -0400", hash_original_method = "73460255618B48EEC6C92DAEEADA9765", hash_generated_method = "F350B1BBB99E2D21BAA9459D73A40C1C")
         Class<?> createClass(InputStream is, String packageName, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1422101309 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_450379669 = null; //Variable for return #2
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1551232211 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_1422101309 = null;
            } //End block
            byte[] clBuf;
            try 
            {
                clBuf = Streams.readFully(is);
            } //End block
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_450379669 = null;
            } //End block
            {
                String packageDotName;
                packageDotName = packageName.replace('/', '.');
                Package packageObj;
                packageObj = getPackage(packageDotName);
                {
                    definePackage(packageDotName, null, null,
                            null, null, null, null, null);
                } //End block
                {
                    {
                        boolean var46ECFB0AA0749BB31F7AC12ACED7FFF6_869418986 = (packageObj.isSealed());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SecurityException("Package is sealed");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1551232211 = defineClass(origName, clBuf, 0, clBuf.length, new CodeSource(codeSourceUrl, (Certificate[]) null));
            addTaint(is.getTaint());
            addTaint(packageName.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_58530871; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_58530871 = varB4EAC82CA7396A68D541C85D26508E83_1422101309;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_58530871 = varB4EAC82CA7396A68D541C85D26508E83_450379669;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_58530871 = varB4EAC82CA7396A68D541C85D26508E83_1551232211;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_58530871.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_58530871;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.012 -0400", hash_original_method = "127A00E2878A258FF82AAAD1F4FC3101", hash_generated_method = "FFCD34359A11BFCB78ECF3AAD3297DF8")
         URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_1111222073 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_301831107 = null; //Variable for return #2
            URL varB4EAC82CA7396A68D541C85D26508E83_1554902642 = null; //Variable for return #3
            URL varB4EAC82CA7396A68D541C85D26508E83_1911950478 = null; //Variable for return #4
            URL varB4EAC82CA7396A68D541C85D26508E83_1031111438 = null; //Variable for return #5
            URL resURL;
            resURL = targetURL(url, name);
            {
                try 
                {
                    URLConnection uc;
                    uc = resURL.openConnection();
                    uc.getInputStream().close();
                    {
                        boolean varE071FEB2BBC390EE5432466A982988A9_1035636385 = (!resURL.getProtocol().equals("http"));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1111222073 = resURL;
                        } //End block
                    } //End collapsed parenthetic
                    int code;
                    {
                        boolean var691373D752CAE39EA2108E7727B5AEC9_478707899 = ((code = ((HttpURLConnection) uc).getResponseCode()) >= 200
                            && code < 300);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_301831107 = resURL;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (SecurityException e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1554902642 = null;
                } //End block
                catch (IOException e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1911950478 = null;
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1031111438 = null;
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_1584763191; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1584763191 = varB4EAC82CA7396A68D541C85D26508E83_1111222073;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1584763191 = varB4EAC82CA7396A68D541C85D26508E83_301831107;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_1584763191 = varB4EAC82CA7396A68D541C85D26508E83_1554902642;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_1584763191 = varB4EAC82CA7396A68D541C85D26508E83_1911950478;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1584763191 = varB4EAC82CA7396A68D541C85D26508E83_1031111438;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1584763191.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1584763191;
            // ---------- Original Method ----------
            //URL resURL = targetURL(url, name);
            //if (resURL != null) {
                //try {
                    //URLConnection uc = resURL.openConnection();
                    //uc.getInputStream().close();
                    //if (!resURL.getProtocol().equals("http")) {
                        //return resURL;
                    //}
                    //int code;
                    //if ((code = ((HttpURLConnection) uc).getResponseCode()) >= 200
                            //&& code < 300) {
                        //return resURL;
                    //}
                //} catch (SecurityException e) {
                    //return null;
                //} catch (IOException e) {
                    //return null;
                //}
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.013 -0400", hash_original_method = "0524D4A234DDE6E7BD7D4DF76408464F", hash_generated_method = "2F764533BBF3C63F1D5B87E10949B5E9")
         URL targetURL(URL base, String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_1425676144 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_804226466 = null; //Variable for return #2
            try 
            {
                StringBuilder fileBuilder;
                fileBuilder = new StringBuilder();
                fileBuilder.append(base.getFile());
                URI.PATH_ENCODER.appendEncoded(fileBuilder, name);
                String file;
                file = fileBuilder.toString();
                varB4EAC82CA7396A68D541C85D26508E83_1425676144 = new URL(base.getProtocol(), base.getHost(), base.getPort(), file, null);
            } //End block
            catch (MalformedURLException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_804226466 = null;
            } //End block
            addTaint(base.getTaint());
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_864244892; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_864244892 = varB4EAC82CA7396A68D541C85D26508E83_1425676144;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_864244892 = varB4EAC82CA7396A68D541C85D26508E83_804226466;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_864244892.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_864244892;
            // ---------- Original Method ----------
            //try {
                //StringBuilder fileBuilder = new StringBuilder();
                //fileBuilder.append(base.getFile());
                //URI.PATH_ENCODER.appendEncoded(fileBuilder, name);
                //String file = fileBuilder.toString();
                //return new URL(base.getProtocol(), base.getHost(), base.getPort(), file, null);
            //} catch (MalformedURLException e) {
                //return null;
            //}
        }

        
    }


    
    class URLJarHandler extends URLHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.019 -0400", hash_original_field = "FE0EC43CC4200E777AA2190ACE58E7B4", hash_generated_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62")

        JarFile jf;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.020 -0400", hash_original_field = "CFE0C7543E7741B6DE4C8FEFFE50B892", hash_generated_field = "C2C4984C490CB9B238D5B3903BFC80CB")

        String prefixName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.020 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "1CD0A34CFD9CFF5C38175C01E8A02107")

        IndexFile index;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.020 -0400", hash_original_field = "C6ADFED245A732099CF017E901933E62", hash_generated_field = "7C44F8438E081330364F46A075FCABB3")

        Map<URL, URLHandler> subHandlers = new HashMap<URL, URLHandler>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.025 -0400", hash_original_method = "5C0004D321A5570AF49FDFAA941E414F", hash_generated_method = "28CFB32950DBB539E67CA5F974F3C4CB")
        public  URLJarHandler(URL url, URL jarURL, JarFile jf, String prefixName) {
            super(url);
            this.jf = jf;
            this.prefixName = prefixName;
            this.codeSourceUrl = jarURL;
            JarEntry je;
            je = jf.getJarEntry("META-INF/INDEX.LIST");
            this.index = (je == null ? null : IndexFile.readIndexFile(jf, je, url));
            addTaint(jarURL.getTaint());
            // ---------- Original Method ----------
            //this.jf = jf;
            //this.prefixName = prefixName;
            //this.codeSourceUrl = jarURL;
            //final JarEntry je = jf.getJarEntry("META-INF/INDEX.LIST");
            //this.index = (je == null ? null : IndexFile.readIndexFile(jf, je, url));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.032 -0400", hash_original_method = "D582F40800649C185B2BDB76509EA85E", hash_generated_method = "406F0538DFEF93034D3A205963D40DD5")
        public  URLJarHandler(URL url, URL jarURL, JarFile jf, String prefixName, IndexFile index) {
            super(url);
            this.jf = jf;
            this.prefixName = prefixName;
            this.index = index;
            this.codeSourceUrl = jarURL;
            addTaint(url.getTaint());
            addTaint(jarURL.getTaint());
            // ---------- Original Method ----------
            //this.jf = jf;
            //this.prefixName = prefixName;
            //this.index = index;
            //this.codeSourceUrl = jarURL;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.033 -0400", hash_original_method = "2D62A5E011065AD5CA1BC3D6BB78BB91", hash_generated_method = "BE961F98FD17DE5E6D9F02A21C45A7E3")
         IndexFile getIndex() {
            IndexFile varB4EAC82CA7396A68D541C85D26508E83_1506283317 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1506283317 = index;
            varB4EAC82CA7396A68D541C85D26508E83_1506283317.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1506283317;
            // ---------- Original Method ----------
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.073 -0400", hash_original_method = "3BC222ED8E766AE357F97E5ED2C16BF7", hash_generated_method = "A9F1557A4F741BF1B68AF93B7035048E")
        @Override
         void findResources(String name, ArrayList<URL> resources) {
            URL res;
            res = findResourceInOwn(name);
            {
                boolean varFC751D1AB3C4048454C180D236DA6858_965674537 = (res != null && !resources.contains(res));
                {
                    resources.add(res);
                } //End block
            } //End collapsed parenthetic
            {
                int pos;
                pos = name.lastIndexOf("/");
                String indexedName;
                indexedName = name.substring(0, pos);
                indexedName = name;
                ArrayList<URL> urls;
                urls = index.get(indexedName);
                {
                    urls.remove(url);
                    {
                        Iterator<URL> varA1868600C8D23C84BF90B90E66B7DED1_74283737 = (urls).iterator();
                        varA1868600C8D23C84BF90B90E66B7DED1_74283737.hasNext();
                        URL url = varA1868600C8D23C84BF90B90E66B7DED1_74283737.next();
                        {
                            URLHandler h;
                            h = getSubHandler(url);
                            {
                                h.findResources(name, resources);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            addTaint(name.getTaint());
            addTaint(resources.getTaint());
            // ---------- Original Method ----------
            //URL res = findResourceInOwn(name);
            //if (res != null && !resources.contains(res)) {
                //resources.add(res);
            //}
            //if (index != null) {
                //int pos = name.lastIndexOf("/");
                //String indexedName = (pos > 0) ? name.substring(0, pos) : name;
                //ArrayList<URL> urls = index.get(indexedName);
                //if (urls != null) {
                    //urls.remove(url);
                    //for (URL url : urls) {
                        //URLHandler h = getSubHandler(url);
                        //if (h != null) {
                            //h.findResources(name, resources);
                        //}
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.091 -0400", hash_original_method = "A33B0C1225B85366B8FACC1A747264F5", hash_generated_method = "584569AF1FA094B975318E1A075A282B")
        @Override
         Class<?> findClass(String packageName, String name, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_649740530 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1693870288 = null; //Variable for return #2
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1132571755 = null; //Variable for return #3
            String entryName;
            entryName = prefixName + name;
            JarEntry entry;
            entry = jf.getJarEntry(entryName);
            {
                try 
                {
                    Manifest manifest;
                    manifest = jf.getManifest();
                    varB4EAC82CA7396A68D541C85D26508E83_649740530 = createClass(entry, manifest, packageName, origName);
                } //End block
                catch (IOException e)
                { }
            } //End block
            {
                ArrayList<URL> urls;
                {
                    urls = index.get(name);
                } //End block
                {
                    urls = index.get(packageName);
                } //End block
                {
                    urls.remove(url);
                    {
                        Iterator<URL> varA1868600C8D23C84BF90B90E66B7DED1_1272113191 = (urls).iterator();
                        varA1868600C8D23C84BF90B90E66B7DED1_1272113191.hasNext();
                        URL url = varA1868600C8D23C84BF90B90E66B7DED1_1272113191.next();
                        {
                            URLHandler h;
                            h = getSubHandler(url);
                            {
                                Class<?> res;
                                res = h.findClass(packageName, name, origName);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1693870288 = res;
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1132571755 = null;
            addTaint(packageName.getTaint());
            addTaint(name.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_209333669; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_209333669 = varB4EAC82CA7396A68D541C85D26508E83_649740530;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_209333669 = varB4EAC82CA7396A68D541C85D26508E83_1693870288;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_209333669 = varB4EAC82CA7396A68D541C85D26508E83_1132571755;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_209333669.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_209333669;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.106 -0400", hash_original_method = "0997311DA5151313F3B17639635BC461", hash_generated_method = "98598C90CD3EC128F9ED6C2448ABD384")
        private Class<?> createClass(JarEntry entry, Manifest manifest, String packageName, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1600664693 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_440270982 = null; //Variable for return #2
            byte[] clBuf;
            try 
            {
                InputStream is;
                is = jf.getInputStream(entry);
                clBuf = Streams.readFully(is);
            } //End block
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1600664693 = null;
            } //End block
            {
                String packageDotName;
                packageDotName = packageName.replace('/', '.');
                Package packageObj;
                packageObj = getPackage(packageDotName);
                {
                    {
                        definePackage(packageDotName, manifest,
                                codeSourceUrl);
                    } //End block
                    {
                        definePackage(packageDotName, null, null,
                                null, null, null, null, null);
                    } //End block
                } //End block
                {
                    boolean exception;
                    exception = packageObj.isSealed();
                    {
                        {
                            boolean var430A4EB459A125FCCE6A1B2B0A7A99BF_1684002715 = (isSealed(manifest, packageName + "/"));
                            {
                                exception = !packageObj
                                    .isSealed(codeSourceUrl);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SecurityException(String.format("Package %s is sealed",
                                packageName));
                    } //End block
                } //End block
            } //End block
            CodeSource codeS;
            codeS = new CodeSource(codeSourceUrl, entry.getCertificates());
            varB4EAC82CA7396A68D541C85D26508E83_440270982 = defineClass(origName, clBuf, 0, clBuf.length, codeS);
            addTaint(entry.getTaint());
            addTaint(manifest.getTaint());
            addTaint(packageName.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_749426429; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_749426429 = varB4EAC82CA7396A68D541C85D26508E83_1600664693;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_749426429 = varB4EAC82CA7396A68D541C85D26508E83_440270982;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_749426429.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_749426429;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.110 -0400", hash_original_method = "BEAE23CC7138835BB0FEF01D26145FD9", hash_generated_method = "9DA508D6792A8CEF5CB3ADE484CCDC9C")
         URL findResourceInOwn(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_1809941793 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_641038126 = null; //Variable for return #2
            String entryName;
            entryName = prefixName + name;
            {
                boolean var970A0F969D5FE2206AF80ED83FDD2671_313711720 = (jf.getEntry(entryName) != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1809941793 = targetURL(url, name);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_641038126 = null;
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_714828171; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_714828171 = varB4EAC82CA7396A68D541C85D26508E83_1809941793;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_714828171 = varB4EAC82CA7396A68D541C85D26508E83_641038126;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_714828171.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_714828171;
            // ---------- Original Method ----------
            //String entryName = prefixName + name;
            //if (jf.getEntry(entryName) != null) {
                //return targetURL(url, name);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.150 -0400", hash_original_method = "7546D3992FBBAF86B12F0B740620B74B", hash_generated_method = "B52A622E3B0C4CCED6AE62EC2CF00353")
        @Override
         URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_130182224 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_130615545 = null; //Variable for return #2
            URL varB4EAC82CA7396A68D541C85D26508E83_1395768309 = null; //Variable for return #3
            URL res;
            res = findResourceInOwn(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_130182224 = res;
            } //End block
            {
                int pos;
                pos = name.lastIndexOf("/");
                String indexedName;
                indexedName = name.substring(0, pos);
                indexedName = name;
                ArrayList<URL> urls;
                urls = index.get(indexedName);
                {
                    urls.remove(url);
                    {
                        Iterator<URL> varA1868600C8D23C84BF90B90E66B7DED1_1225306007 = (urls).iterator();
                        varA1868600C8D23C84BF90B90E66B7DED1_1225306007.hasNext();
                        URL url = varA1868600C8D23C84BF90B90E66B7DED1_1225306007.next();
                        {
                            URLHandler h;
                            h = getSubHandler(url);
                            {
                                res = h.findResource(name);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_130615545 = res;
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1395768309 = null;
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_262507514; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_262507514 = varB4EAC82CA7396A68D541C85D26508E83_130182224;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_262507514 = varB4EAC82CA7396A68D541C85D26508E83_130615545;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_262507514 = varB4EAC82CA7396A68D541C85D26508E83_1395768309;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_262507514.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_262507514;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.160 -0400", hash_original_method = "47CD540256D0F2B23AE4D5BB7E445858", hash_generated_method = "F56B574213FA33096F4D946A56A4AF30")
        private synchronized URLHandler getSubHandler(URL url) {
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_250999436 = null; //Variable for return #1
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_170050579 = null; //Variable for return #2
            URLHandler sub;
            sub = subHandlers.get(url);
            {
                varB4EAC82CA7396A68D541C85D26508E83_250999436 = sub;
            } //End block
            String protocol;
            protocol = url.getProtocol();
            {
                boolean varFE0A78E78A02221C3A8F7118E438EAB7_869993802 = (protocol.equals("jar"));
                {
                    sub = createURLJarHandler(url);
                } //End block
                {
                    boolean var07199D08C001E96CE71D5573EC1F815A_2011047529 = (protocol.equals("file"));
                    {
                        sub = createURLSubJarHandler(url);
                    } //End block
                    {
                        sub = createURLHandler(url);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                subHandlers.put(url, sub);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_170050579 = sub;
            addTaint(url.getTaint());
            URLHandler varA7E53CE21691AB073D9660D615818899_478365002; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_478365002 = varB4EAC82CA7396A68D541C85D26508E83_250999436;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_478365002 = varB4EAC82CA7396A68D541C85D26508E83_170050579;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_478365002.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_478365002;
            // ---------- Original Method ----------
            //URLHandler sub = subHandlers.get(url);
            //if (sub != null) {
                //return sub;
            //}
            //String protocol = url.getProtocol();
            //if (protocol.equals("jar")) {
                //sub = createURLJarHandler(url);
            //} else if (protocol.equals("file")) {
                //sub = createURLSubJarHandler(url);
            //} else {
                //sub = createURLHandler(url);
            //}
            //if (sub != null) {
                //subHandlers.put(url, sub);
            //}
            //return sub;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.162 -0400", hash_original_method = "CC5C093E882DD207DA9222EBC985A361", hash_generated_method = "845DB1E6504C2C280420B5DA44A7B358")
        private URLHandler createURLSubJarHandler(URL url) {
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_1576046312 = null; //Variable for return #1
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_438509906 = null; //Variable for return #2
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_73891370 = null; //Variable for return #3
            String prefixName;
            String file;
            file = url.getFile();
            {
                boolean var7356D1B77839B718E750922987458DE7_157503708 = (url.getFile().endsWith("!/"));
                {
                    prefixName = "";
                } //End block
                {
                    int sepIdx;
                    sepIdx = file.lastIndexOf("!/");
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1576046312 = null;
                    } //End block
                    sepIdx += 2;
                    prefixName = file.substring(sepIdx);
                } //End block
            } //End collapsed parenthetic
            try 
            {
                URL jarURL;
                jarURL = ((JarURLConnection) url
                        .openConnection()).getJarFileURL();
                JarURLConnection juc;
                juc = (JarURLConnection) new URL(
                        "jar", "",
                        jarURL.toExternalForm() + "!/").openConnection();
                JarFile jf;
                jf = juc.getJarFile();
                URLJarHandler jarH;
                jarH = new URLJarHandler(url, jarURL, jf, prefixName, null);
                varB4EAC82CA7396A68D541C85D26508E83_438509906 = jarH;
            } //End block
            catch (IOException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_73891370 = null;
            addTaint(url.getTaint());
            URLHandler varA7E53CE21691AB073D9660D615818899_1427208808; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1427208808 = varB4EAC82CA7396A68D541C85D26508E83_1576046312;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1427208808 = varB4EAC82CA7396A68D541C85D26508E83_438509906;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1427208808 = varB4EAC82CA7396A68D541C85D26508E83_73891370;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1427208808.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1427208808;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class URLFileHandler extends URLHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.162 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

        private String prefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.163 -0400", hash_original_method = "748B8F1639705FB8AE66EE4520D13BFB", hash_generated_method = "C86A945C7936AF00DAF2DA8309FD034F")
        public  URLFileHandler(URL url) {
            super(url);
            String baseFile;
            baseFile = url.getFile();
            String host;
            host = url.getHost();
            int hostLength;
            hostLength = 0;
            {
                hostLength = host.length();
            } //End block
            StringBuilder buf;
            buf = new StringBuilder(2 + hostLength
                    + baseFile.length());
            {
                buf.append("//").append(host);
            } //End block
            buf.append(baseFile);
            prefix = buf.toString();
            addTaint(url.getTaint());
            // ---------- Original Method ----------
            //String baseFile = url.getFile();
            //String host = url.getHost();
            //int hostLength = 0;
            //if (host != null) {
                //hostLength = host.length();
            //}
            //StringBuilder buf = new StringBuilder(2 + hostLength
                    //+ baseFile.length());
            //if (hostLength > 0) {
                //buf.append("//").append(host);
            //}
            //buf.append(baseFile);
            //prefix = buf.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.174 -0400", hash_original_method = "459A43E8A29596EEF0DEE6D3A05FE74A", hash_generated_method = "6F8BD48510FF77106E695B59AF15999A")
        @Override
         Class<?> findClass(String packageName, String name, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1851168902 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1111652498 = null; //Variable for return #2
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1630696066 = null; //Variable for return #3
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_246413953 = null; //Variable for return #4
            String filename;
            filename = prefix + name;
            try 
            {
                filename = URLDecoder.decode(filename, "UTF-8");
            } //End block
            catch (IllegalArgumentException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1851168902 = null;
            } //End block
            catch (UnsupportedEncodingException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1111652498 = null;
            } //End block
            File file;
            file = new File(filename);
            {
                boolean var59AA0F7651ECC78FBF1607A856F762E1_1924910993 = (file.exists());
                {
                    try 
                    {
                        InputStream is;
                        is = new FileInputStream(file);
                        varB4EAC82CA7396A68D541C85D26508E83_1630696066 = createClass(is, packageName, origName);
                    } //End block
                    catch (FileNotFoundException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_246413953 = null;
            addTaint(packageName.getTaint());
            addTaint(name.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_1101178568; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1101178568 = varB4EAC82CA7396A68D541C85D26508E83_1851168902;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1101178568 = varB4EAC82CA7396A68D541C85D26508E83_1111652498;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_1101178568 = varB4EAC82CA7396A68D541C85D26508E83_1630696066;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1101178568 = varB4EAC82CA7396A68D541C85D26508E83_246413953;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1101178568.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1101178568;
            // ---------- Original Method ----------
            //String filename = prefix + name;
            //try {
                //filename = URLDecoder.decode(filename, "UTF-8");
            //} catch (IllegalArgumentException e) {
                //return null;
            //} catch (UnsupportedEncodingException e) {
                //return null;
            //}
            //File file = new File(filename);
            //if (file.exists()) {
                //try {
                    //InputStream is = new FileInputStream(file);
                    //return createClass(is, packageName, origName);
                //} catch (FileNotFoundException e) {
                //}
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.181 -0400", hash_original_method = "5954C39BABA19C5921C727F17BF4740B", hash_generated_method = "F1A649C327F7B7E6906F556B66750663")
        @Override
         URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_486075442 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_578596713 = null; //Variable for return #2
            URL varB4EAC82CA7396A68D541C85D26508E83_697848560 = null; //Variable for return #3
            int idx;
            idx = 0;
            String filename;
            {
                boolean var23EFF342BB8E7FE0217A53D321A1C78E_1447671112 = (idx < name.length() &&
                   ((name.charAt(idx) == '/') || (name.charAt(idx) == '\\')));
            } //End collapsed parenthetic
            {
                name = name.substring(idx);
            } //End block
            try 
            {
                filename = URLDecoder.decode(prefix, "UTF-8") + name;
                {
                    boolean varBF735348FCCFEB4D8EC418F0236B8831_754640556 = (new File(filename).exists());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_486075442 = targetURL(url, name);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_578596713 = null;
            } //End block
            catch (IllegalArgumentException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_697848560 = null;
            } //End block
            catch (UnsupportedEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
            } //End block
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_1387351193; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1387351193 = varB4EAC82CA7396A68D541C85D26508E83_486075442;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1387351193 = varB4EAC82CA7396A68D541C85D26508E83_578596713;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1387351193 = varB4EAC82CA7396A68D541C85D26508E83_697848560;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1387351193.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1387351193;
            // ---------- Original Method ----------
            //int idx = 0;
            //String filename;
            //while (idx < name.length() &&
                   //((name.charAt(idx) == '/') || (name.charAt(idx) == '\\'))) {
                //idx++;
            //}
            //if (idx > 0) {
                //name = name.substring(idx);
            //}
            //try {
                //filename = URLDecoder.decode(prefix, "UTF-8") + name;
                //if (new File(filename).exists()) {
                    //return targetURL(url, name);
                //}
                //return null;
            //} catch (IllegalArgumentException e) {
                //return null;
            //} catch (UnsupportedEncodingException e) {
                //throw new AssertionError(e);
            //}
        }

        
    }


    
}

