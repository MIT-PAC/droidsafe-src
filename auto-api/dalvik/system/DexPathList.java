package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.526 -0400", hash_original_field = "A2C9CF9447D978C776C79B242368B7FE", hash_generated_field = "C26455FF0303CF3616EEE8FEAA4F7A0F")

    private ClassLoader definingContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.526 -0400", hash_original_field = "97F48307FDC20679621A3A171AEF734A", hash_generated_field = "A7619B7365AE4C331D989E49ADBEFBCB")

    private Element[] dexElements;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.526 -0400", hash_original_field = "76035906E4CB2898CB1ABDF661AC6DCE", hash_generated_field = "AE1EF9991574B5A7C61DD485E05882A3")

    private File[] nativeLibraryDirectories;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.527 -0400", hash_original_method = "391CC1D8031EEADD5869B9B2E6DEDA56", hash_generated_method = "0FF639C10C834403733180873E006032")
    public  DexPathList(ClassLoader definingContext, String dexPath,
            String libraryPath, File optimizedDirectory) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("definingContext == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("dexPath == null");
        } //End block
        {
            {
                boolean varD93CE39D5961AECAA042D96C165FFDC0_1322523381 = (!optimizedDirectory.exists());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "optimizedDirectory doesn't exist: "
                        + optimizedDirectory);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF3D464DBA78635702CCAB9C7B75BD5C3_1821337507 = (!(optimizedDirectory.canRead()
                            && optimizedDirectory.canWrite()));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "optimizedDirectory not readable/writable: "
                        + optimizedDirectory);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.577 -0400", hash_original_method = "D0077BF0C677FC7F0C28C59D93206805", hash_generated_method = "DEF5264D40E2C1FC0664F085AB4839C2")
    public Class findClass(String name) {
        Class varB4EAC82CA7396A68D541C85D26508E83_540871107 = null; //Variable for return #1
        Class varB4EAC82CA7396A68D541C85D26508E83_190465963 = null; //Variable for return #2
        {
            Element element = dexElements[0];
            {
                DexFile dex;
                dex = element.dexFile;
                {
                    Class clazz;
                    clazz = dex.loadClassBinaryName(name, definingContext);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_540871107 = clazz;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_190465963 = null;
        addTaint(name.getTaint());
        Class varA7E53CE21691AB073D9660D615818899_1129273311; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1129273311 = varB4EAC82CA7396A68D541C85D26508E83_540871107;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1129273311 = varB4EAC82CA7396A68D541C85D26508E83_190465963;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1129273311.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1129273311;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.607 -0400", hash_original_method = "5F5378C3BB7399B364C8BA4B56CD7FC5", hash_generated_method = "11BD2BA0BADA6EA3A1DEA83E83DEF974")
    public URL findResource(String name) {
        URL varB4EAC82CA7396A68D541C85D26508E83_1045372690 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_1597044328 = null; //Variable for return #2
        {
            Element element = dexElements[0];
            {
                URL url;
                url = element.findResource(name);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1045372690 = url;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1597044328 = null;
        addTaint(name.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_127033478; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_127033478 = varB4EAC82CA7396A68D541C85D26508E83_1045372690;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_127033478 = varB4EAC82CA7396A68D541C85D26508E83_1597044328;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_127033478.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_127033478;
        // ---------- Original Method ----------
        //for (Element element : dexElements) {
            //URL url = element.findResource(name);
            //if (url != null) {
                //return url;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.610 -0400", hash_original_method = "804A7034A2DFDDBE0ECC495815CB31BB", hash_generated_method = "11C5101F5BABC58F6371FF724C12C8D8")
    public Enumeration<URL> findResources(String name) {
        Enumeration<URL> varB4EAC82CA7396A68D541C85D26508E83_1646615725 = null; //Variable for return #1
        ArrayList<URL> result;
        result = new ArrayList<URL>();
        {
            Iterator<Element> varF1D603C6DC3EACB73DA0406834E64496_1588040555 = (dexElements).iterator();
            varF1D603C6DC3EACB73DA0406834E64496_1588040555.hasNext();
            Element element = varF1D603C6DC3EACB73DA0406834E64496_1588040555.next();
            {
                URL url;
                url = element.findResource(name);
                {
                    result.add(url);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1646615725 = Collections.enumeration(result);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1646615725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1646615725;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.694 -0400", hash_original_method = "240DC3968F2BE784AD66FA40662DC8EC", hash_generated_method = "74A790995D10841395646B4CABF59A33")
    public String findLibrary(String libraryName) {
        String varB4EAC82CA7396A68D541C85D26508E83_520330964 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_295517244 = null; //Variable for return #2
        String fileName;
        fileName = System.mapLibraryName(libraryName);
        {
            File directory = nativeLibraryDirectories[0];
            {
                File file;
                file = new File(directory, fileName);
                {
                    boolean varC7394EA2DBCB91C973A311E8518DD73C_678208633 = (file.exists() && file.isFile() && file.canRead());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_520330964 = file.getPath();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_295517244 = null;
        addTaint(libraryName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1445287539; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1445287539 = varB4EAC82CA7396A68D541C85D26508E83_520330964;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1445287539 = varB4EAC82CA7396A68D541C85D26508E83_295517244;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1445287539.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1445287539;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.699 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "2F2F994FE64CD70831C1033A4A29832A")

        public File file;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.699 -0400", hash_original_field = "85B746DE3B5C6F50B7F3A33A94BD4DBE", hash_generated_field = "8D3206573610C2D0826105B08DB3519F")

        public ZipFile zipFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.699 -0400", hash_original_field = "07711BC335994A9454983BFAB25063AA", hash_generated_field = "605FB7C70C2875B1FD6B68477587F1B5")

        public DexFile dexFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.700 -0400", hash_original_method = "6D7B88020BD7097C5D3BFE418F13B214", hash_generated_method = "D256E2B985F1BE23E6B46E6D305762AC")
        public  Element(File file, ZipFile zipFile, DexFile dexFile) {
            this.file = file;
            this.zipFile = zipFile;
            this.dexFile = dexFile;
            // ---------- Original Method ----------
            //this.file = file;
            //this.zipFile = zipFile;
            //this.dexFile = dexFile;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.700 -0400", hash_original_method = "853A43CB46D2A1F46888921026F3A6BF", hash_generated_method = "6CF2FAD2307BB1A8F218A100390ADC34")
        public URL findResource(String name) {
            URL varB4EAC82CA7396A68D541C85D26508E83_2043721458 = null; //Variable for return #1
            URL varB4EAC82CA7396A68D541C85D26508E83_1574884848 = null; //Variable for return #2
            {
                boolean var42372B44F4C376120C0651D6EE365C60_2051234326 = ((zipFile == null) || (zipFile.getEntry(name) == null));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2043721458 = null;
                } //End block
            } //End collapsed parenthetic
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1574884848 = new URL("jar:" + file.toURL() + "!/" + name);
            } //End block
            catch (MalformedURLException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            addTaint(name.getTaint());
            URL varA7E53CE21691AB073D9660D615818899_1421009449; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1421009449 = varB4EAC82CA7396A68D541C85D26508E83_2043721458;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1421009449 = varB4EAC82CA7396A68D541C85D26508E83_1574884848;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1421009449.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1421009449;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.700 -0400", hash_original_field = "BC6C75D8F878544D55CA796D95026124", hash_generated_field = "D86914CBE9196AE0FECF9CB4D76A1118")

    private static String DEX_SUFFIX = ".dex";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.700 -0400", hash_original_field = "06FB4DCCFD53A4A1F3A18E020F026F35", hash_generated_field = "A3EAC6173EC8888778BFF1DE7FA1FE7D")

    private static String JAR_SUFFIX = ".jar";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.700 -0400", hash_original_field = "7AC17D63B2FCD25FA6ABF6002E877D0C", hash_generated_field = "8FA3EAA7C9AAFA3BBBA958F6CDAA8C31")

    private static String ZIP_SUFFIX = ".zip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.701 -0400", hash_original_field = "DA2A78C7A359D1C9A401E9408106FDFD", hash_generated_field = "3269558108C0F3522B3F908AE1F5457A")

    private static String APK_SUFFIX = ".apk";
}

