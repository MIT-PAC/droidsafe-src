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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.756 -0400", hash_original_field = "B29D73214A4D23ADA5B59B6F71D732DF", hash_generated_field = "8493272A5AB4A77AB209F22490E9A299")

    ArrayList<URL> originalUrls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.756 -0400", hash_original_field = "583BE25E7B8F5E9B4CF06A08F494F4E5", hash_generated_field = "6EEE0C60179788AF966E079989CB5CB3")

    List<URL> searchList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.756 -0400", hash_original_field = "A12AB4D5BFE9F5C0714A5AC8F9CC246A", hash_generated_field = "018DFABF07E4A0807227E840C28DF558")

    ArrayList<URLHandler> handlerList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.756 -0400", hash_original_field = "C7A9E9C96BAE4B4D941CA4F6492C31FF", hash_generated_field = "83210D660C03E6C9492E92BD982991A6")

    Map<URL, URLHandler> handlerMap = new HashMap<URL, URLHandler>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.756 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "E43CA7AA04ACD2FE8928E03B47B06D76")

    private URLStreamHandlerFactory factory;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.760 -0400", hash_original_method = "223BBDDFA8D7BCBDBB892F093839C31A", hash_generated_method = "7574BADAD0DECFD730EB097F2190D40F")
    public  URLClassLoader(URL[] urls) {
        this(urls, ClassLoader.getSystemClassLoader(), null);
        addTaint(urls[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.761 -0400", hash_original_method = "2C1F233833FFEC69CE12E7A0069A8B49", hash_generated_method = "36B94FD949236AA62E1679990C9E0F97")
    public  URLClassLoader(URL[] urls, ClassLoader parent) {
        this(urls, parent, null);
        addTaint(urls[0].getTaint());
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.771 -0400", hash_original_method = "9F92FD383D821F82B2A5EE941293558A", hash_generated_method = "51AF40EE4F6C33761D4AD204AC0153B1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.771 -0400", hash_original_method = "8767B0DB3A608CD14EAA847CE6E9F597", hash_generated_method = "3834D3634E44E0F2A447C4EBFBE4F5C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.773 -0400", hash_original_method = "E35E96FBBA5328024F5002F5E092C0FA", hash_generated_method = "BF1F4B7188E0B5B350FF12FBAC240B5F")
    @Override
    public Enumeration<URL> findResources(final String name) throws IOException {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_1774964319 = null; //Variable for return #1
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_298452530 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1774964319 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_298452530 = Collections.enumeration(result);
        addTaint(name.getTaint());
        Enumeration<URL> varA7E53CE21691AB073D9660D615818899_112494131; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_112494131 = varB4EAC82CA7396A68D541C85D26508E83_1774964319;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_112494131 = varB4EAC82CA7396A68D541C85D26508E83_298452530;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_112494131.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_112494131;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.788 -0400", hash_original_method = "B4723E664A18325BA87109668B89BB4C", hash_generated_method = "100CA53DFE624AFC466E5F8604CAFE38")
    @Override
    protected PermissionCollection getPermissions(final CodeSource codesource) {
        PermissionCollection varB4EAC82CA7396A68D541C85D26508E83_1236152318 = null; //Variable for return #1
        PermissionCollection pc;
        pc = super.getPermissions(codesource);
        URL u;
        u = codesource.getLocation();
        {
            boolean var0D3DCE32DE3636DD78A2BE6460215DDE_1144955829 = (u.getProtocol().equals("jar"));
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
            boolean var4D320D496AF3A7A0362D9991BB7F9187_2086251019 = (u.getProtocol().equals("file"));
            {
                String path;
                path = u.getFile();
                String host;
                host = u.getHost();
                {
                    boolean var2D544DB6C0FDD148F3E57369E992EC16_739963909 = (host != null && host.length() > 0);
                    {
                        path = "//" + host + path;
                    } //End block
                } //End collapsed parenthetic
                {
                    path = path.replace('/', File.separatorChar);
                } //End block
                {
                    boolean varC84208C3E0250C4294B433F1E7B244E4_992761606 = (isDirectory(u));
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
                    boolean varC53ECC4BC21F90A0F577E60A03E6C413_1565106305 = (host.length() == 0);
                    {
                        host = "localhost";
                    } //End block
                } //End collapsed parenthetic
                pc.add(new SocketPermission(host, "connect, accept"));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1236152318 = pc;
        addTaint(codesource.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1236152318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1236152318;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.789 -0400", hash_original_method = "E74D6D295FD8DF7C4B8AB85761E02982", hash_generated_method = "C732134B6719A48396F7B18FC3D46E4C")
    public URL[] getURLs() {
        URL[] varB4EAC82CA7396A68D541C85D26508E83_1007756216 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1007756216 = originalUrls.toArray(new URL[originalUrls.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1007756216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1007756216;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.807 -0400", hash_original_method = "BAA63B0BE9A75DDAC07B90D04DE61F0B", hash_generated_method = "FF24FB20323030A5F98D3D8BC12F96B8")
    @Override
    protected Class<?> findClass(final String className) throws ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_370948662 = null; //Variable for return #1
        String partialName;
        partialName = className.replace('.', '/');
        String classFileName;
        classFileName = new StringBuilder(partialName).append(".class").toString();
        String packageName;
        packageName = null;
        int position;
        position = partialName.lastIndexOf('/');
        {
            boolean var3E1D041C4A1A150031AEB32E198BD1A9_1149403629 = ((position = partialName.lastIndexOf('/')) != -1);
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
                varB4EAC82CA7396A68D541C85D26508E83_370948662 = res;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(className);
        addTaint(className.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_370948662.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_370948662;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.809 -0400", hash_original_method = "75025FE733C588323FB29CA64B72756D", hash_generated_method = "03FDCC1B110390C091E0A15A5A1B3604")
    private URL createSearchURL(URL url) throws MalformedURLException {
        URL varB4EAC82CA7396A68D541C85D26508E83_1991800731 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_1194875842 = null; //Variable for return #2
        URL varB4EAC82CA7396A68D541C85D26508E83_698503948 = null; //Variable for return #3
        URL varB4EAC82CA7396A68D541C85D26508E83_1827245966 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1991800731 = url;
        } //End block
        String protocol;
        protocol = url.getProtocol();
        {
            boolean var6B09AA880739B965279245545031D717_1297624079 = (isDirectory(url) || protocol.equals("jar"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1194875842 = url;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_698503948 = new URL("jar", "",
                    -1, url.toString() + "!/");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1827245966 = new URL("jar", "",
                -1, url.toString() + "!/",
                factory.createURLStreamHandler("jar"));
        addTaint(url.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_2078809570; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2078809570 = varB4EAC82CA7396A68D541C85D26508E83_1991800731;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2078809570 = varB4EAC82CA7396A68D541C85D26508E83_1194875842;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2078809570 = varB4EAC82CA7396A68D541C85D26508E83_698503948;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2078809570 = varB4EAC82CA7396A68D541C85D26508E83_1827245966;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2078809570.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2078809570;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.810 -0400", hash_original_method = "36DCCA8214496CA792D9D415CCE3C1EC", hash_generated_method = "1CCED3B188C4334AD7306E070855FFEA")
    @Override
    public URL findResource(final String name) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1888293660 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_1187385292 = null; //Variable for return #2
        URL varB4EAC82CA7396A68D541C85D26508E83_791606257 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1888293660 = null;
        } //End block
        int n;
        n = 0;
        {
            URLHandler handler;
            handler = getHandler(n++);
            URL res;
            res = handler.findResource(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1187385292 = res;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_791606257 = null;
        addTaint(name.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_23988428; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_23988428 = varB4EAC82CA7396A68D541C85D26508E83_1888293660;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_23988428 = varB4EAC82CA7396A68D541C85D26508E83_1187385292;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_23988428 = varB4EAC82CA7396A68D541C85D26508E83_791606257;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_23988428.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_23988428;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.811 -0400", hash_original_method = "CFA5B2A5119E9C6C6C6B8BDB54F0FFE4", hash_generated_method = "7FDE3532DF436697707BA0AA8B719FE2")
    private URLHandler getHandler(int num) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_923421621 = null; //Variable for return #1
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_95916652 = null; //Variable for return #2
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_133082041 = null; //Variable for return #3
        {
            boolean varC6CBE7D489CE95B916048C828E20629B_1262119966 = (num < handlerList.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_923421621 = handlerList.get(num);
            } //End block
        } //End collapsed parenthetic
        makeNewHandler();
        {
            boolean varC6CBE7D489CE95B916048C828E20629B_1842694319 = (num < handlerList.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_95916652 = handlerList.get(num);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_133082041 = null;
        addTaint(num);
        URLHandler varA7E53CE21691AB073D9660D615818899_1473568219; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1473568219 = varB4EAC82CA7396A68D541C85D26508E83_923421621;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1473568219 = varB4EAC82CA7396A68D541C85D26508E83_95916652;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1473568219 = varB4EAC82CA7396A68D541C85D26508E83_133082041;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1473568219.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1473568219;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.811 -0400", hash_original_method = "A878B5121D5BF1232029A8CDBC76BE45", hash_generated_method = "DF9D142B9268D24683372BD1BD0FE21F")
    private synchronized void makeNewHandler() {
        {
            boolean var056FE5D37761D5D3DC4B0CF57BDA52B0_1134374984 = (!searchList.isEmpty());
            {
                URL nextCandidate;
                nextCandidate = searchList.remove(0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("A URL is null");
                } //End block
                {
                    boolean var087B3C4559B5C5125F9C3E5F757C0545_868061749 = (!handlerMap.containsKey(nextCandidate));
                    {
                        URLHandler result;
                        String protocol;
                        protocol = nextCandidate.getProtocol();
                        {
                            boolean varB604F1DF8F50013B1F7F0E3AFFD2694D_1835550961 = (protocol.equals("jar"));
                            {
                                result = createURLJarHandler(nextCandidate);
                            } //End block
                            {
                                boolean varC08545D58A986C9447AB113046FC989F_590145489 = (protocol.equals("file"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.812 -0400", hash_original_method = "15D2A778081BB97B4F5082C5EA9323F2", hash_generated_method = "C4E26A12666124FD9056B1386DE6BB8F")
    private URLHandler createURLHandler(URL url) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_538819763 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_538819763 = new URLHandler(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_538819763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_538819763;
        // ---------- Original Method ----------
        //return new URLHandler(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.812 -0400", hash_original_method = "959FE775BCBFF6223F7FD94A4010D369", hash_generated_method = "7BCA246F3D65CE544CCAAA42AEFDB214")
    private URLHandler createURLFileHandler(URL url) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_728857703 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_728857703 = new URLFileHandler(url);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_728857703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_728857703;
        // ---------- Original Method ----------
        //return new URLFileHandler(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.830 -0400", hash_original_method = "93DBA576D247FBB46E5BCA4D9E3C8DFF", hash_generated_method = "B5F39330D8AB1ED7AE55175CAFA27412")
    private URLHandler createURLJarHandler(URL url) {
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_233799180 = null; //Variable for return #1
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_73260348 = null; //Variable for return #2
        URLHandler varB4EAC82CA7396A68D541C85D26508E83_1891709522 = null; //Variable for return #3
        String prefixName;
        String file;
        file = url.getFile();
        {
            boolean var5A4D7A486C11D5F49AB1CA63C5A4886E_1633436181 = (url.getFile().endsWith("!/"));
            {
                prefixName = "";
            } //End block
            {
                int sepIdx;
                sepIdx = file.lastIndexOf("!/");
                {
                    varB4EAC82CA7396A68D541C85D26508E83_233799180 = null;
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
                boolean varD44BF004E9F3CB1AD9A1AE5B28A8F27A_482407693 = (jarH.getIndex() == null);
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
            varB4EAC82CA7396A68D541C85D26508E83_73260348 = jarH;
        } //End block
        catch (IOException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1891709522 = null;
        addTaint(url.getTaint());
        URLHandler varA7E53CE21691AB073D9660D615818899_651666658; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_651666658 = varB4EAC82CA7396A68D541C85D26508E83_233799180;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_651666658 = varB4EAC82CA7396A68D541C85D26508E83_73260348;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_651666658 = varB4EAC82CA7396A68D541C85D26508E83_1891709522;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_651666658.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_651666658;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.832 -0400", hash_original_method = "1F20C74E5FA90998EED1F262145E5A78", hash_generated_method = "66EA5CEE33A17722C45FC3E66CB4EBFD")
    protected Package definePackage(String packageName, Manifest manifest,
                                    URL url) throws IllegalArgumentException {
        Package varB4EAC82CA7396A68D541C85D26508E83_34177010 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_34177010 = definePackage(packageName, specificationTitle,
                specificationVersion, specificationVendor, implementationTitle,
                implementationVersion, implementationVendor, isSealed(manifest,
                dirName) ? url : null);
        addTaint(packageName.getTaint());
        addTaint(manifest.getTaint());
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_34177010.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_34177010;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.833 -0400", hash_original_method = "F65716DA89135DC89A539D54ADB64D73", hash_generated_method = "8062078B549D8BCB6DD3EE0133DE9F89")
    private boolean isSealed(Manifest manifest, String dirName) {
        Attributes attributes;
        attributes = manifest.getAttributes(dirName);
        {
            String value;
            value = attributes.getValue(Attributes.Name.SEALED);
            {
                boolean varF9F03D746A978112631EA8BA624DD149_915531240 = (value.equalsIgnoreCase("true"));
            } //End block
        } //End block
        Attributes mainAttributes;
        mainAttributes = manifest.getMainAttributes();
        String value;
        value = mainAttributes.getValue(Attributes.Name.SEALED);
        boolean varE5C35E1E8162E6D042C52DDD4CF2D6AA_822118534 = ((value != null && value.equalsIgnoreCase("true")));
        addTaint(manifest.getTaint());
        addTaint(dirName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953901913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_953901913;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.834 -0400", hash_original_method = "8DCFE07B381999C3DEF19ABA31EFB008", hash_generated_method = "6FA5DA6F14EB2798B7A077B6C8C0222D")
    private ArrayList<URL> getInternalURLs(URL root, String classpath) {
        ArrayList<URL> varB4EAC82CA7396A68D541C85D26508E83_1850707188 = null; //Variable for return #1
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
            boolean var2B5824909BF971CED0BAC391F81BF905_905706747 = (tokenizer.hasMoreElements());
            {
                String element;
                element = tokenizer.nextToken();
                {
                    boolean varE66FC8B2A65C7CA819992997D34C4051_464919599 = (!element.isEmpty());
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
        varB4EAC82CA7396A68D541C85D26508E83_1850707188 = addedURLs;
        addTaint(root.getTaint());
        addTaint(classpath.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1850707188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1850707188;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class IndexFile {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.835 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "8CA0A10A56B7E322DF59FAF09C201F44")

        private HashMap<String, ArrayList<URL>> map;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.835 -0400", hash_original_method = "379F12D2048DD620EF06C57D0B8DE6F0", hash_generated_method = "59D8AC312A7688B15BB683D206A79DB0")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.869 -0400", hash_original_method = "8FF86E61D1723FF11EF08355D8ACABBC", hash_generated_method = "8D5E445EF21E23288864C4DD7E49AF51")
         ArrayList<URL> get(String name) {
            ArrayList<URL> varB4EAC82CA7396A68D541C85D26508E83_504528941 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_504528941 = map.get(name);
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_504528941.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_504528941;
            // ---------- Original Method ----------
            //return map.get(name);
        }

        
    }


    
    class URLHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.869 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "D0C59163767519DDC23EEDD08636971F")

        URL url;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.869 -0400", hash_original_field = "6B41B640483CE6C30687EB43271D5F95", hash_generated_field = "CA61315DDA6019C64E03F42F9050F544")

        URL codeSourceUrl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.870 -0400", hash_original_method = "D5B6F191489E39FDFBD95ACBEEF6948D", hash_generated_method = "D13F0BDC7438F2204A7900E8E8D32315")
        public  URLHandler(URL url) {
            this.url = url;
            this.codeSourceUrl = url;
            // ---------- Original Method ----------
            //this.url = url;
            //this.codeSourceUrl = url;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.870 -0400", hash_original_method = "A27A46A41A88BA0FAAC7830FBD366ED6", hash_generated_method = "C25839AA201311F203128DF53994AE6A")
         void findResources(String name, ArrayList<URL> resources) {
            URL res;
            res = findResource(name);
            {
                boolean varFC751D1AB3C4048454C180D236DA6858_552063633 = (res != null && !resources.contains(res));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.871 -0400", hash_original_method = "DE45CDB737E4642285D570F5610849E6", hash_generated_method = "ED37D24DA31A60B48F8FC4164FCD5801")
         Class<?> findClass(String packageName, String name, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_134490760 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_220016656 = null; //Variable for return #2
            URL resURL;
            resURL = targetURL(url, name);
            {
                try 
                {
                    InputStream is;
                    is = resURL.openStream();
                    varB4EAC82CA7396A68D541C85D26508E83_134490760 = createClass(is, packageName, origName);
                } //End block
                catch (IOException e)
                { }
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_220016656 = null;
            addTaint(packageName.getTaint());
            addTaint(name.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_1394766195; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1394766195 = varB4EAC82CA7396A68D541C85D26508E83_134490760;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1394766195 = varB4EAC82CA7396A68D541C85D26508E83_220016656;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1394766195.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1394766195;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.879 -0400", hash_original_method = "73460255618B48EEC6C92DAEEADA9765", hash_generated_method = "A868B250449FA2C6D09CE3BCDDCA60CD")
         Class<?> createClass(InputStream is, String packageName, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1293307310 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_33836850 = null; //Variable for return #2
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1354492137 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_1293307310 = null;
            } //End block
            byte[] clBuf;
            try 
            {
                clBuf = Streams.readFully(is);
            } //End block
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_33836850 = null;
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
                        boolean var46ECFB0AA0749BB31F7AC12ACED7FFF6_529939024 = (packageObj.isSealed());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SecurityException("Package is sealed");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1354492137 = defineClass(origName, clBuf, 0, clBuf.length, new CodeSource(codeSourceUrl, (Certificate[]) null));
            addTaint(is.getTaint());
            addTaint(packageName.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_525224639; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_525224639 = varB4EAC82CA7396A68D541C85D26508E83_1293307310;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_525224639 = varB4EAC82CA7396A68D541C85D26508E83_33836850;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_525224639 = varB4EAC82CA7396A68D541C85D26508E83_1354492137;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_525224639.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_525224639;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.881 -0400", hash_original_method = "127A00E2878A258FF82AAAD1F4FC3101", hash_generated_method = "60B67B4B61FC23E429F185CFCAFE8818")
         URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_2057226023 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_996373587 = null; //Variable for return #2
            URL varB4EAC82CA7396A68D541C85D26508E83_1303842878 = null; //Variable for return #3
            URL varB4EAC82CA7396A68D541C85D26508E83_2112208919 = null; //Variable for return #4
            URL varB4EAC82CA7396A68D541C85D26508E83_1191946458 = null; //Variable for return #5
            URL resURL;
            resURL = targetURL(url, name);
            {
                try 
                {
                    URLConnection uc;
                    uc = resURL.openConnection();
                    uc.getInputStream().close();
                    {
                        boolean varE071FEB2BBC390EE5432466A982988A9_1878566970 = (!resURL.getProtocol().equals("http"));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_2057226023 = resURL;
                        } //End block
                    } //End collapsed parenthetic
                    int code;
                    {
                        boolean var691373D752CAE39EA2108E7727B5AEC9_446041030 = ((code = ((HttpURLConnection) uc).getResponseCode()) >= 200
                            && code < 300);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_996373587 = resURL;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (SecurityException e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1303842878 = null;
                } //End block
                catch (IOException e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2112208919 = null;
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1191946458 = null;
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_1402841756; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1402841756 = varB4EAC82CA7396A68D541C85D26508E83_2057226023;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1402841756 = varB4EAC82CA7396A68D541C85D26508E83_996373587;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_1402841756 = varB4EAC82CA7396A68D541C85D26508E83_1303842878;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_1402841756 = varB4EAC82CA7396A68D541C85D26508E83_2112208919;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1402841756 = varB4EAC82CA7396A68D541C85D26508E83_1191946458;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1402841756.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1402841756;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.890 -0400", hash_original_method = "0524D4A234DDE6E7BD7D4DF76408464F", hash_generated_method = "729C37C415AA82BFBFD5DB5DDD2CF085")
         URL targetURL(URL base, String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_1339842158 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_2037881398 = null; //Variable for return #2
            try 
            {
                StringBuilder fileBuilder;
                fileBuilder = new StringBuilder();
                fileBuilder.append(base.getFile());
                URI.PATH_ENCODER.appendEncoded(fileBuilder, name);
                String file;
                file = fileBuilder.toString();
                varB4EAC82CA7396A68D541C85D26508E83_1339842158 = new URL(base.getProtocol(), base.getHost(), base.getPort(), file, null);
            } //End block
            catch (MalformedURLException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_2037881398 = null;
            } //End block
            addTaint(base.getTaint());
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_2088179425; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2088179425 = varB4EAC82CA7396A68D541C85D26508E83_1339842158;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2088179425 = varB4EAC82CA7396A68D541C85D26508E83_2037881398;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2088179425.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2088179425;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.890 -0400", hash_original_field = "FE0EC43CC4200E777AA2190ACE58E7B4", hash_generated_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62")

        JarFile jf;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.890 -0400", hash_original_field = "CFE0C7543E7741B6DE4C8FEFFE50B892", hash_generated_field = "C2C4984C490CB9B238D5B3903BFC80CB")

        String prefixName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.890 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "1CD0A34CFD9CFF5C38175C01E8A02107")

        IndexFile index;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.890 -0400", hash_original_field = "C6ADFED245A732099CF017E901933E62", hash_generated_field = "7C44F8438E081330364F46A075FCABB3")

        Map<URL, URLHandler> subHandlers = new HashMap<URL, URLHandler>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.900 -0400", hash_original_method = "5C0004D321A5570AF49FDFAA941E414F", hash_generated_method = "28CFB32950DBB539E67CA5F974F3C4CB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.902 -0400", hash_original_method = "D582F40800649C185B2BDB76509EA85E", hash_generated_method = "406F0538DFEF93034D3A205963D40DD5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.903 -0400", hash_original_method = "2D62A5E011065AD5CA1BC3D6BB78BB91", hash_generated_method = "9032D4D1DB4FA4FD5372FA09C9EEE914")
         IndexFile getIndex() {
            IndexFile varB4EAC82CA7396A68D541C85D26508E83_1777795015 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1777795015 = index;
            varB4EAC82CA7396A68D541C85D26508E83_1777795015.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1777795015;
            // ---------- Original Method ----------
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.964 -0400", hash_original_method = "3BC222ED8E766AE357F97E5ED2C16BF7", hash_generated_method = "2A913F31B52EFF8D3462398902738AE2")
        @Override
         void findResources(String name, ArrayList<URL> resources) {
            URL res;
            res = findResourceInOwn(name);
            {
                boolean varFC751D1AB3C4048454C180D236DA6858_1219881693 = (res != null && !resources.contains(res));
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
                        Iterator<URL> varA1868600C8D23C84BF90B90E66B7DED1_1624818430 = (urls).iterator();
                        varA1868600C8D23C84BF90B90E66B7DED1_1624818430.hasNext();
                        URL url = varA1868600C8D23C84BF90B90E66B7DED1_1624818430.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.973 -0400", hash_original_method = "A33B0C1225B85366B8FACC1A747264F5", hash_generated_method = "6A6EF2266C9AC1080D802DE063B5EAD6")
        @Override
         Class<?> findClass(String packageName, String name, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_45731445 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_306331257 = null; //Variable for return #2
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_344818800 = null; //Variable for return #3
            String entryName;
            entryName = prefixName + name;
            JarEntry entry;
            entry = jf.getJarEntry(entryName);
            {
                try 
                {
                    Manifest manifest;
                    manifest = jf.getManifest();
                    varB4EAC82CA7396A68D541C85D26508E83_45731445 = createClass(entry, manifest, packageName, origName);
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
                        Iterator<URL> varA1868600C8D23C84BF90B90E66B7DED1_1642594151 = (urls).iterator();
                        varA1868600C8D23C84BF90B90E66B7DED1_1642594151.hasNext();
                        URL url = varA1868600C8D23C84BF90B90E66B7DED1_1642594151.next();
                        {
                            URLHandler h;
                            h = getSubHandler(url);
                            {
                                Class<?> res;
                                res = h.findClass(packageName, name, origName);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_306331257 = res;
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_344818800 = null;
            addTaint(packageName.getTaint());
            addTaint(name.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_798126416; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_798126416 = varB4EAC82CA7396A68D541C85D26508E83_45731445;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_798126416 = varB4EAC82CA7396A68D541C85D26508E83_306331257;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_798126416 = varB4EAC82CA7396A68D541C85D26508E83_344818800;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_798126416.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_798126416;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.992 -0400", hash_original_method = "0997311DA5151313F3B17639635BC461", hash_generated_method = "E07861BBEEE50199A837C70C1138496D")
        private Class<?> createClass(JarEntry entry, Manifest manifest, String packageName, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_325914640 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_2123128882 = null; //Variable for return #2
            byte[] clBuf;
            try 
            {
                InputStream is;
                is = jf.getInputStream(entry);
                clBuf = Streams.readFully(is);
            } //End block
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_325914640 = null;
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
                            boolean var430A4EB459A125FCCE6A1B2B0A7A99BF_301950930 = (isSealed(manifest, packageName + "/"));
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
            varB4EAC82CA7396A68D541C85D26508E83_2123128882 = defineClass(origName, clBuf, 0, clBuf.length, codeS);
            addTaint(entry.getTaint());
            addTaint(manifest.getTaint());
            addTaint(packageName.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_1616586591; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1616586591 = varB4EAC82CA7396A68D541C85D26508E83_325914640;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1616586591 = varB4EAC82CA7396A68D541C85D26508E83_2123128882;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1616586591.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1616586591;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.993 -0400", hash_original_method = "BEAE23CC7138835BB0FEF01D26145FD9", hash_generated_method = "D1ED96E4F3F36596872845BBD531EE3C")
         URL findResourceInOwn(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_1849402697 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_1137820342 = null; //Variable for return #2
            String entryName;
            entryName = prefixName + name;
            {
                boolean var970A0F969D5FE2206AF80ED83FDD2671_930559221 = (jf.getEntry(entryName) != null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1849402697 = targetURL(url, name);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1137820342 = null;
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_1040335535; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1040335535 = varB4EAC82CA7396A68D541C85D26508E83_1849402697;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1040335535 = varB4EAC82CA7396A68D541C85D26508E83_1137820342;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1040335535.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1040335535;
            // ---------- Original Method ----------
            //String entryName = prefixName + name;
            //if (jf.getEntry(entryName) != null) {
                //return targetURL(url, name);
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.025 -0400", hash_original_method = "7546D3992FBBAF86B12F0B740620B74B", hash_generated_method = "E68D8A2AC51FB7CFA1075614857C3A17")
        @Override
         URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_273475091 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_1098236419 = null; //Variable for return #2
            URL varB4EAC82CA7396A68D541C85D26508E83_980036717 = null; //Variable for return #3
            URL res;
            res = findResourceInOwn(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_273475091 = res;
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
                        Iterator<URL> varA1868600C8D23C84BF90B90E66B7DED1_432342846 = (urls).iterator();
                        varA1868600C8D23C84BF90B90E66B7DED1_432342846.hasNext();
                        URL url = varA1868600C8D23C84BF90B90E66B7DED1_432342846.next();
                        {
                            URLHandler h;
                            h = getSubHandler(url);
                            {
                                res = h.findResource(name);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1098236419 = res;
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_980036717 = null;
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_633425373; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_633425373 = varB4EAC82CA7396A68D541C85D26508E83_273475091;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_633425373 = varB4EAC82CA7396A68D541C85D26508E83_1098236419;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_633425373 = varB4EAC82CA7396A68D541C85D26508E83_980036717;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_633425373.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_633425373;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.036 -0400", hash_original_method = "47CD540256D0F2B23AE4D5BB7E445858", hash_generated_method = "3B53817F3B0518FDF6E38C70EDBAB17A")
        private synchronized URLHandler getSubHandler(URL url) {
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_206449440 = null; //Variable for return #1
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_55255910 = null; //Variable for return #2
            URLHandler sub;
            sub = subHandlers.get(url);
            {
                varB4EAC82CA7396A68D541C85D26508E83_206449440 = sub;
            } //End block
            String protocol;
            protocol = url.getProtocol();
            {
                boolean varFE0A78E78A02221C3A8F7118E438EAB7_1456540598 = (protocol.equals("jar"));
                {
                    sub = createURLJarHandler(url);
                } //End block
                {
                    boolean var07199D08C001E96CE71D5573EC1F815A_759756823 = (protocol.equals("file"));
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
            varB4EAC82CA7396A68D541C85D26508E83_55255910 = sub;
            addTaint(url.getTaint());
            URLHandler varA7E53CE21691AB073D9660D615818899_1944784880; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1944784880 = varB4EAC82CA7396A68D541C85D26508E83_206449440;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1944784880 = varB4EAC82CA7396A68D541C85D26508E83_55255910;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1944784880.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1944784880;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.037 -0400", hash_original_method = "CC5C093E882DD207DA9222EBC985A361", hash_generated_method = "DD29D73CEF66EBD20398492BB64A640A")
        private URLHandler createURLSubJarHandler(URL url) {
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_2140124435 = null; //Variable for return #1
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_808232791 = null; //Variable for return #2
            URLHandler varB4EAC82CA7396A68D541C85D26508E83_625248298 = null; //Variable for return #3
            String prefixName;
            String file;
            file = url.getFile();
            {
                boolean var7356D1B77839B718E750922987458DE7_1126285731 = (url.getFile().endsWith("!/"));
                {
                    prefixName = "";
                } //End block
                {
                    int sepIdx;
                    sepIdx = file.lastIndexOf("!/");
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2140124435 = null;
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
                varB4EAC82CA7396A68D541C85D26508E83_808232791 = jarH;
            } //End block
            catch (IOException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_625248298 = null;
            addTaint(url.getTaint());
            URLHandler varA7E53CE21691AB073D9660D615818899_999539798; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_999539798 = varB4EAC82CA7396A68D541C85D26508E83_2140124435;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_999539798 = varB4EAC82CA7396A68D541C85D26508E83_808232791;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_999539798 = varB4EAC82CA7396A68D541C85D26508E83_625248298;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_999539798.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_999539798;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    class URLFileHandler extends URLHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.037 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

        private String prefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.038 -0400", hash_original_method = "748B8F1639705FB8AE66EE4520D13BFB", hash_generated_method = "C86A945C7936AF00DAF2DA8309FD034F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.046 -0400", hash_original_method = "459A43E8A29596EEF0DEE6D3A05FE74A", hash_generated_method = "DE9A295157587D1484650852278D800A")
        @Override
         Class<?> findClass(String packageName, String name, String origName) {
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1774325837 = null; //Variable for return #1
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1215588147 = null; //Variable for return #2
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1142706426 = null; //Variable for return #3
            Class<?> varB4EAC82CA7396A68D541C85D26508E83_1742287210 = null; //Variable for return #4
            String filename;
            filename = prefix + name;
            try 
            {
                filename = URLDecoder.decode(filename, "UTF-8");
            } //End block
            catch (IllegalArgumentException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1774325837 = null;
            } //End block
            catch (UnsupportedEncodingException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1215588147 = null;
            } //End block
            File file;
            file = new File(filename);
            {
                boolean var59AA0F7651ECC78FBF1607A856F762E1_208701044 = (file.exists());
                {
                    try 
                    {
                        InputStream is;
                        is = new FileInputStream(file);
                        varB4EAC82CA7396A68D541C85D26508E83_1142706426 = createClass(is, packageName, origName);
                    } //End block
                    catch (FileNotFoundException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1742287210 = null;
            addTaint(packageName.getTaint());
            addTaint(name.getTaint());
            addTaint(origName.getTaint());
            Class<?> varA7E53CE21691AB073D9660D615818899_1610044123; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1610044123 = varB4EAC82CA7396A68D541C85D26508E83_1774325837;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1610044123 = varB4EAC82CA7396A68D541C85D26508E83_1215588147;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_1610044123 = varB4EAC82CA7396A68D541C85D26508E83_1142706426;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1610044123 = varB4EAC82CA7396A68D541C85D26508E83_1742287210;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1610044123.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1610044123;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.047 -0400", hash_original_method = "5954C39BABA19C5921C727F17BF4740B", hash_generated_method = "C02CF8393CDF4944E1562DDB46552F28")
        @Override
         URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_1676178483 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_1433683951 = null; //Variable for return #2
            URL varB4EAC82CA7396A68D541C85D26508E83_174513289 = null; //Variable for return #3
            int idx;
            idx = 0;
            String filename;
            {
                boolean var23EFF342BB8E7FE0217A53D321A1C78E_1105899033 = (idx < name.length() &&
                   ((name.charAt(idx) == '/') || (name.charAt(idx) == '\\')));
            } //End collapsed parenthetic
            {
                name = name.substring(idx);
            } //End block
            try 
            {
                filename = URLDecoder.decode(prefix, "UTF-8") + name;
                {
                    boolean varBF735348FCCFEB4D8EC418F0236B8831_518332336 = (new File(filename).exists());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1676178483 = targetURL(url, name);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1433683951 = null;
            } //End block
            catch (IllegalArgumentException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_174513289 = null;
            } //End block
            catch (UnsupportedEncodingException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
            } //End block
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_1419737737; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1419737737 = varB4EAC82CA7396A68D541C85D26508E83_1676178483;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1419737737 = varB4EAC82CA7396A68D541C85D26508E83_1433683951;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1419737737 = varB4EAC82CA7396A68D541C85D26508E83_174513289;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1419737737.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1419737737;
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

