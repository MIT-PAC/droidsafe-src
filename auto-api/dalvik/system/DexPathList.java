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
    private ClassLoader definingContext;
    private Element[] dexElements;
    private File[] nativeLibraryDirectories;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.247 -0400", hash_original_method = "391CC1D8031EEADD5869B9B2E6DEDA56", hash_generated_method = "5C0E2F6FC1FD42DF59F1F856DC1BE0A2")
    @DSModeled(DSC.BAN)
    public DexPathList(ClassLoader definingContext, String dexPath,
            String libraryPath, File optimizedDirectory) {
        dsTaint.addTaint(definingContext.dsTaint);
        dsTaint.addTaint(optimizedDirectory.dsTaint);
        dsTaint.addTaint(dexPath);
        dsTaint.addTaint(libraryPath);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("definingContext == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("dexPath == null");
        } //End block
        {
            {
                boolean varD93CE39D5961AECAA042D96C165FFDC0_2094966518 = (!optimizedDirectory.exists());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "optimizedDirectory doesn't exist: "
                        + optimizedDirectory);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF3D464DBA78635702CCAB9C7B75BD5C3_983366208 = (!(optimizedDirectory.canRead()
                            && optimizedDirectory.canWrite()));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "optimizedDirectory not readable/writable: "
                        + optimizedDirectory);
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.251 -0400", hash_original_method = "D0077BF0C677FC7F0C28C59D93206805", hash_generated_method = "66776CE3097E1BE8030296E38F3389B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class findClass(String name) {
        dsTaint.addTaint(name);
        {
            Element element = dexElements[0];
            {
                DexFile dex;
                dex = element.dexFile;
                {
                    Class clazz;
                    clazz = dex.loadClassBinaryName(name, definingContext);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Class)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.259 -0400", hash_original_method = "5F5378C3BB7399B364C8BA4B56CD7FC5", hash_generated_method = "4D180182CF0F141430BE93B08E896417")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL findResource(String name) {
        dsTaint.addTaint(name);
        {
            Element element = dexElements[0];
            {
                URL url;
                url = element.findResource(name);
            } //End block
        } //End collapsed parenthetic
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (Element element : dexElements) {
            //URL url = element.findResource(name);
            //if (url != null) {
                //return url;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.261 -0400", hash_original_method = "804A7034A2DFDDBE0ECC495815CB31BB", hash_generated_method = "01337AB4D972F44F630839C4997283AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<URL> findResources(String name) {
        dsTaint.addTaint(name);
        ArrayList<URL> result;
        result = new ArrayList<URL>();
        {
            Iterator<Element> varF1D603C6DC3EACB73DA0406834E64496_1507636950 = (dexElements).iterator();
            varF1D603C6DC3EACB73DA0406834E64496_1507636950.hasNext();
            Element element = varF1D603C6DC3EACB73DA0406834E64496_1507636950.next();
            {
                URL url;
                url = element.findResource(name);
                {
                    result.add(url);
                } //End block
            } //End block
        } //End collapsed parenthetic
        Enumeration<URL> var869F826C89C63069DDCF00C847A7B479_1947073066 = (Collections.enumeration(result));
        return (Enumeration<URL>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.266 -0400", hash_original_method = "240DC3968F2BE784AD66FA40662DC8EC", hash_generated_method = "408B738459EBB033421487BEF7FE1E20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String findLibrary(String libraryName) {
        dsTaint.addTaint(libraryName);
        String fileName;
        fileName = System.mapLibraryName(libraryName);
        {
            File directory = nativeLibraryDirectories[0];
            {
                File file;
                file = new File(directory, fileName);
                {
                    boolean varC7394EA2DBCB91C973A311E8518DD73C_79033136 = (file.exists() && file.isFile() && file.canRead());
                    {
                        String var8CBF9B921DBCA83C7BACA109D187B091_767481274 = (file.getPath());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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
        public File file;
        public ZipFile zipFile;
        public DexFile dexFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.266 -0400", hash_original_method = "6D7B88020BD7097C5D3BFE418F13B214", hash_generated_method = "311F63A729BCCC69D677BF7C5060A45C")
        @DSModeled(DSC.SAFE)
        public Element(File file, ZipFile zipFile, DexFile dexFile) {
            dsTaint.addTaint(zipFile.dsTaint);
            dsTaint.addTaint(file.dsTaint);
            dsTaint.addTaint(dexFile.dsTaint);
            // ---------- Original Method ----------
            //this.file = file;
            //this.zipFile = zipFile;
            //this.dexFile = dexFile;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.267 -0400", hash_original_method = "853A43CB46D2A1F46888921026F3A6BF", hash_generated_method = "2754E19E8D3944E4285621C5A84F33ED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public URL findResource(String name) {
            dsTaint.addTaint(name);
            {
                boolean var42372B44F4C376120C0651D6EE365C60_766147383 = ((zipFile == null) || (zipFile.getEntry(name) == null));
            } //End collapsed parenthetic
            try 
            {
                URL var16903FDAE22AB516BEBD328AEA8355E6_434507048 = (new URL("jar:" + file.toURL() + "!/" + name));
            } //End block
            catch (MalformedURLException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            return (URL)dsTaint.getTaint();
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


    
    private static final String DEX_SUFFIX = ".dex";
    private static final String JAR_SUFFIX = ".jar";
    private static final String ZIP_SUFFIX = ".zip";
    private static final String APK_SUFFIX = ".apk";
}

