package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

final class DexPathList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.767 -0400", hash_original_field = "A2C9CF9447D978C776C79B242368B7FE", hash_generated_field = "C26455FF0303CF3616EEE8FEAA4F7A0F")

    private ClassLoader definingContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.768 -0400", hash_original_field = "97F48307FDC20679621A3A171AEF734A", hash_generated_field = "A7619B7365AE4C331D989E49ADBEFBCB")

    private Element[] dexElements;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.769 -0400", hash_original_field = "76035906E4CB2898CB1ABDF661AC6DCE", hash_generated_field = "AE1EF9991574B5A7C61DD485E05882A3")

    private File[] nativeLibraryDirectories;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.775 -0400", hash_original_method = "391CC1D8031EEADD5869B9B2E6DEDA56", hash_generated_method = "B3FA33FEFFBD5D8B4D2BE5CE102F8DD5")
    public  DexPathList(ClassLoader definingContext, String dexPath,
            String libraryPath, File optimizedDirectory) {
    if(definingContext == null)        
        {
            NullPointerException var952458ABE09734497891F39F52044D52_1717557615 = new NullPointerException("definingContext == null");
            var952458ABE09734497891F39F52044D52_1717557615.addTaint(taint);
            throw var952458ABE09734497891F39F52044D52_1717557615;
        } //End block
    if(dexPath == null)        
        {
            NullPointerException var37160EC520B086EBEBB9867ACDB6CFA7_1974257792 = new NullPointerException("dexPath == null");
            var37160EC520B086EBEBB9867ACDB6CFA7_1974257792.addTaint(taint);
            throw var37160EC520B086EBEBB9867ACDB6CFA7_1974257792;
        } //End block
    if(optimizedDirectory != null)        
        {
    if(!optimizedDirectory.exists())            
            {
                IllegalArgumentException varFE9A63280676E72D3ECD1690D27420E6_1799197778 = new IllegalArgumentException(
                        "optimizedDirectory doesn't exist: "
                        + optimizedDirectory);
                varFE9A63280676E72D3ECD1690D27420E6_1799197778.addTaint(taint);
                throw varFE9A63280676E72D3ECD1690D27420E6_1799197778;
            } //End block
    if(!(optimizedDirectory.canRead()
                            && optimizedDirectory.canWrite()))            
            {
                IllegalArgumentException var40695EF630B8E2354F86A2FCDA4A3895_596110216 = new IllegalArgumentException(
                        "optimizedDirectory not readable/writable: "
                        + optimizedDirectory);
                var40695EF630B8E2354F86A2FCDA4A3895_596110216.addTaint(taint);
                throw var40695EF630B8E2354F86A2FCDA4A3895_596110216;
            } //End block
        } //End block
        this.definingContext = definingContext;
        this.dexElements =
            makeDexElements(splitDexPath(dexPath), optimizedDirectory);
        this.nativeLibraryDirectories = splitLibraryPath(libraryPath);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static ArrayList<File> splitDexPath(String path) {
        return splitPaths(path, null, false);
    }

    
        private static File[] splitLibraryPath(String path) {
        ArrayList<File> result = splitPaths(
                path, System.getProperty("java.library.path", "."), true);
        return result.toArray(new File[result.size()]);
    }

    
        private static ArrayList<File> splitPaths(String path1, String path2,
            boolean wantDirectories) {
        ArrayList<File> result = new ArrayList<File>();
        splitAndAdd(path1, wantDirectories, result);
        splitAndAdd(path2, wantDirectories, result);
        return result;
    }

    
        private static void splitAndAdd(String path, boolean wantDirectories,
            ArrayList<File> resultList) {
        if (path == null) {
            return;
        }
        String[] strings = path.split(Pattern.quote(File.pathSeparator));
        for (String s : strings) {
            File file = new File(s);
            if (! (file.exists() && file.canRead())) {
                continue;
            }
            if (wantDirectories) {
                if (!file.isDirectory()) {
                    continue;
                }
            } else {
                if (!file.isFile()) {
                    continue;
                }
            }
            resultList.add(file);
        }
    }

    
        private static Element[] makeDexElements(ArrayList<File> files,
            File optimizedDirectory) {
        ArrayList<Element> elements = new ArrayList<Element>();
        for (File file : files) {
            ZipFile zip = null;
            DexFile dex = null;
            String name = file.getName();
            if (name.endsWith(DEX_SUFFIX)) {
                try {
                    dex = loadDexFile(file, optimizedDirectory);
                } catch (IOException ex) {
                    System.logE("Unable to load dex file: " + file, ex);
                }
            } else if (name.endsWith(APK_SUFFIX) || name.endsWith(JAR_SUFFIX)
                    || name.endsWith(ZIP_SUFFIX)) {
                try {
                    zip = new ZipFile(file);
                } catch (IOException ex) {
                    System.logE("Unable to open zip file: " + file, ex);
                }
                try {
                    dex = loadDexFile(file, optimizedDirectory);
                } catch (IOException ignored) {
                }
            } else {
                System.logW("Unknown file type for: " + file);
            }
            if ((zip != null) || (dex != null)) {
                elements.add(new Element(file, zip, dex));
            }
        }
        return elements.toArray(new Element[elements.size()]);
    }

    
        private static DexFile loadDexFile(File file, File optimizedDirectory) throws IOException {
        if (optimizedDirectory == null) {
            return new DexFile(file);
        } else {
            String optimizedPath = optimizedPathFor(file, optimizedDirectory);
            return DexFile.loadDex(file.getPath(), optimizedPath, 0);
        }
    }

    
        private static String optimizedPathFor(File path,
            File optimizedDirectory) {
        String fileName = path.getName();
        if (!fileName.endsWith(DEX_SUFFIX)) {
            int lastDot = fileName.lastIndexOf(".");
            if (lastDot < 0) {
                fileName += DEX_SUFFIX;
            } else {
                StringBuilder sb = new StringBuilder(lastDot + 4);
                sb.append(fileName, 0, lastDot);
                sb.append(DEX_SUFFIX);
                fileName = sb.toString();
            }
        }
        File result = new File(optimizedDirectory, fileName);
        return result.getPath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.793 -0400", hash_original_method = "D0077BF0C677FC7F0C28C59D93206805", hash_generated_method = "7536EF13133183E9C6FA0A986FA54355")
    public Class findClass(String name) {
        addTaint(name.getTaint());
for(Element element : dexElements)
        {
            DexFile dex = element.dexFile;
    if(dex != null)            
            {
                Class clazz = dex.loadClassBinaryName(name, definingContext);
    if(clazz != null)                
                {
Class var3E303968598B6EE307EE3739CE40F332_1137728930 =                     clazz;
                    var3E303968598B6EE307EE3739CE40F332_1137728930.addTaint(taint);
                    return var3E303968598B6EE307EE3739CE40F332_1137728930;
                } //End block
            } //End block
        } //End block
Class var540C13E9E156B687226421B24F2DF178_1065809304 =         null;
        var540C13E9E156B687226421B24F2DF178_1065809304.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1065809304;
        // ---------- Original Method ----------
        //for (Element element : dexElements) {
            //DexFile dex = element.dexFile;
            //if (dex != null) {
                //Class clazz = dex.loadClassBinaryName(name, definingContext);
                //if (clazz != null) {
                    //return clazz;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.799 -0400", hash_original_method = "5F5378C3BB7399B364C8BA4B56CD7FC5", hash_generated_method = "1335CF2635CAF888AA9C4A5035CE7523")
    public URL findResource(String name) {
        addTaint(name.getTaint());
for(Element element : dexElements)
        {
            URL url = element.findResource(name);
    if(url != null)            
            {
URL var4F9C62D322C7F68D5668056D4B193F9B_1494703774 =                 url;
                var4F9C62D322C7F68D5668056D4B193F9B_1494703774.addTaint(taint);
                return var4F9C62D322C7F68D5668056D4B193F9B_1494703774;
            } //End block
        } //End block
URL var540C13E9E156B687226421B24F2DF178_965109469 =         null;
        var540C13E9E156B687226421B24F2DF178_965109469.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_965109469;
        // ---------- Original Method ----------
        //for (Element element : dexElements) {
            //URL url = element.findResource(name);
            //if (url != null) {
                //return url;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.808 -0400", hash_original_method = "804A7034A2DFDDBE0ECC495815CB31BB", hash_generated_method = "38A57B1618390E1F81D76A18948826DA")
    public Enumeration<URL> findResources(String name) {
        addTaint(name.getTaint());
        ArrayList<URL> result = new ArrayList<URL>();
for(Element element : dexElements)
        {
            URL url = element.findResource(name);
    if(url != null)            
            {
                result.add(url);
            } //End block
        } //End block
Enumeration<URL> var286CA219AF9141A8529875BDEFF253E1_956129260 =         Collections.enumeration(result);
        var286CA219AF9141A8529875BDEFF253E1_956129260.addTaint(taint);
        return var286CA219AF9141A8529875BDEFF253E1_956129260;
        // ---------- Original Method ----------
        //ArrayList<URL> result = new ArrayList<URL>();
        //for (Element element : dexElements) {
            //URL url = element.findResource(name);
            //if (url != null) {
                //result.add(url);
            //}
        //}
        //return Collections.enumeration(result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.811 -0400", hash_original_method = "240DC3968F2BE784AD66FA40662DC8EC", hash_generated_method = "B03C93446C87318497DC226325AA118E")
    public String findLibrary(String libraryName) {
        addTaint(libraryName.getTaint());
        String fileName = System.mapLibraryName(libraryName);
for(File directory : nativeLibraryDirectories)
        {
            File file = new File(directory, fileName);
    if(file.exists() && file.isFile() && file.canRead())            
            {
String varD4A0F0F7EFBD18E8DFB61C75171645BB_923156960 =                 file.getPath();
                varD4A0F0F7EFBD18E8DFB61C75171645BB_923156960.addTaint(taint);
                return varD4A0F0F7EFBD18E8DFB61C75171645BB_923156960;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1773595931 =         null;
        var540C13E9E156B687226421B24F2DF178_1773595931.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1773595931;
        // ---------- Original Method ----------
        //String fileName = System.mapLibraryName(libraryName);
        //for (File directory : nativeLibraryDirectories) {
            //File file = new File(directory, fileName);
            //if (file.exists() && file.isFile() && file.canRead()) {
                //return file.getPath();
            //}
        //}
        //return null;
    }

    
    static class Element {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.816 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "2F2F994FE64CD70831C1033A4A29832A")

        public File file;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.817 -0400", hash_original_field = "85B746DE3B5C6F50B7F3A33A94BD4DBE", hash_generated_field = "8D3206573610C2D0826105B08DB3519F")

        public ZipFile zipFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.818 -0400", hash_original_field = "07711BC335994A9454983BFAB25063AA", hash_generated_field = "605FB7C70C2875B1FD6B68477587F1B5")

        public DexFile dexFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.822 -0400", hash_original_method = "6D7B88020BD7097C5D3BFE418F13B214", hash_generated_method = "D256E2B985F1BE23E6B46E6D305762AC")
        public  Element(File file, ZipFile zipFile, DexFile dexFile) {
            this.file = file;
            this.zipFile = zipFile;
            this.dexFile = dexFile;
            // ---------- Original Method ----------
            //this.file = file;
            //this.zipFile = zipFile;
            //this.dexFile = dexFile;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.831 -0400", hash_original_method = "853A43CB46D2A1F46888921026F3A6BF", hash_generated_method = "3236B6C844ABCCF27CACBAFF677AE900")
        public URL findResource(String name) {
            addTaint(name.getTaint());
    if((zipFile == null) || (zipFile.getEntry(name) == null))            
            {
URL var540C13E9E156B687226421B24F2DF178_1343319811 =                 null;
                var540C13E9E156B687226421B24F2DF178_1343319811.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1343319811;
            } //End block
            try 
            {
URL varDE4D4F9940645A2D29CB372F60F88A3A_1795437851 =                 new URL("jar:" + file.toURL() + "!/" + name);
                varDE4D4F9940645A2D29CB372F60F88A3A_1795437851.addTaint(taint);
                return varDE4D4F9940645A2D29CB372F60F88A3A_1795437851;
            } //End block
            catch (MalformedURLException ex)
            {
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_420218287 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_420218287.addTaint(taint);
                throw varF35D3C95F99DACEE8C542CF38D772C50_420218287;
            } //End block
            // ---------- Original Method ----------
            //if ((zipFile == null) || (zipFile.getEntry(name) == null)) {
                //return null;
            //}
            //try {
                //return new URL("jar:" + file.toURL() + "!/" + name);
            //} catch (MalformedURLException ex) {
                //throw new RuntimeException(ex);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.834 -0400", hash_original_field = "BC6C75D8F878544D55CA796D95026124", hash_generated_field = "37CF7DC6ED2CB6FBEB27D6CEFB2D68E1")

    private static final String DEX_SUFFIX = ".dex";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.836 -0400", hash_original_field = "06FB4DCCFD53A4A1F3A18E020F026F35", hash_generated_field = "3166419EC870FB1378EBC123F44480B1")

    private static final String JAR_SUFFIX = ".jar";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.837 -0400", hash_original_field = "7AC17D63B2FCD25FA6ABF6002E877D0C", hash_generated_field = "EF3CFC1323C1C36712EDA5211E4F7373")

    private static final String ZIP_SUFFIX = ".zip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.838 -0400", hash_original_field = "DA2A78C7A359D1C9A401E9408106FDFD", hash_generated_field = "37B170C5A677C2526C7FE461B48153B8")

    private static final String APK_SUFFIX = ".apk";
}

