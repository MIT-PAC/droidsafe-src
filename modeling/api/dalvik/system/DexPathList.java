/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    /**
     * Splits the given dex path string into elements using the path
     * separator, pruning out any elements that do not refer to existing
     * and readable files. (That is, directories are not included in the
     * result.)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.277 -0500", hash_original_method = "0631173DC9A08156235F49544FA05E79", hash_generated_method = "8777EF77154143908F742F2AE2D340C4")
    
private static ArrayList<File> splitDexPath(String path) {
        return splitPaths(path, null, false);
    }

    /**
     * Splits the given library directory path string into elements
     * using the path separator ({@code File.pathSeparator}, which
     * defaults to {@code ":"} on Android, appending on the elements
     * from the system library path, and pruning out any elements that
     * do not refer to existing and readable directories.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.280 -0500", hash_original_method = "D610DB71CD37CA41586F87935A2C6BD0", hash_generated_method = "89AA11A1D51AF4F6BBCB9FF648AF2B3C")
    
private static File[] splitLibraryPath(String path) {
        /*
         * Native libraries may exist in both the system and
         * application library paths, and we use this search order:
         *
         *   1. this class loader's library path for application
         *      libraries
         *   2. the VM's library path from the system
         *      property for system libraries
         *
         * This order was reversed prior to Gingerbread; see http://b/2933456.
         */
        ArrayList<File> result = splitPaths(
                path, System.getProperty("java.library.path", "."), true);
        return result.toArray(new File[result.size()]);
    }

    /**
     * Splits the given path strings into file elements using the path
     * separator, combining the results and filtering out elements
     * that don't exist, aren't readable, or aren't either a regular
     * file or a directory (as specified). Either string may be empty
     * or {@code null}, in which case it is ignored. If both strings
     * are empty or {@code null}, or all elements get pruned out, then
     * this returns a zero-element list.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.282 -0500", hash_original_method = "7A346074F9D863A175A6BEFFD5BD4DA4", hash_generated_method = "80C87C96A5ACFA3FDB9272BB0C44971D")
    
private static ArrayList<File> splitPaths(String path1, String path2,
            boolean wantDirectories) {
        ArrayList<File> result = new ArrayList<File>();

        splitAndAdd(path1, wantDirectories, result);
        splitAndAdd(path2, wantDirectories, result);
        return result;
    }

    /**
     * Helper for {@link #splitPaths}, which does the actual splitting
     * and filtering and adding to a result.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.285 -0500", hash_original_method = "789B4327777138836797F221198809B4", hash_generated_method = "6FC1F61A0A478FAAB0FE5394A4EFBB03")
    
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

            /*
             * Note: There are other entities in filesystems than
             * regular files and directories.
             */
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

    /**
     * Makes an array of dex/resource path elements, one per element of
     * the given array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.288 -0500", hash_original_method = "F1A6F8EFFE6AE4CC1CBF3FEC9CE7ACF7", hash_generated_method = "42A6BF67B8D830ED8E343D9B3686751E")
    
private static Element[] makeDexElements(ArrayList<File> files,
            File optimizedDirectory) {
        
        Element[] ret = new Element[1];
        
        ret[0] = new Element(files.get(0), null, null);

        return ret;

        /*
        ArrayList<Element> elements = new ArrayList<Element>();


        for (File file : files) {
            ZipFile zip = null;
            DexFile dex = null;
            String name = file.getName();

            if (name.endsWith(DEX_SUFFIX)) {
                // Raw dex file (not inside a zip/jar).
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
        */
    }

    /**
     * Constructs a {@code DexFile} instance, as appropriate depending
     * on whether {@code optimizedDirectory} is {@code null}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.291 -0500", hash_original_method = "2303A1AD6D6A9E62ECE4D6AAED613FDB", hash_generated_method = "BD8AFB8B702E3B3C2921F2D45A236D29")
    
private static DexFile loadDexFile(File file, File optimizedDirectory)
            throws IOException {
        if (optimizedDirectory == null) {
            return new DexFile(file);
        } else {
            String optimizedPath = optimizedPathFor(file, optimizedDirectory);
            return DexFile.loadDex(file.getPath(), optimizedPath, 0);
        }
    }

    /**
     * Converts a dex/jar file path and an output directory to an
     * output file path for an associated optimized dex file.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.294 -0500", hash_original_method = "AC9CA52F95EEC7D238B5030F9E805DDC", hash_generated_method = "2D7D3192756557AF7021EA15D326E0EE")
    
private static String optimizedPathFor(File path,
            File optimizedDirectory) {
        /*
         * Get the filename component of the path, and replace the
         * suffix with ".dex" if that's not already the suffix.
         *
         * We don't want to use ".odex", because the build system uses
         * that for files that are paired with resource-only jar
         * files. If the VM can assume that there's no classes.dex in
         * the matching jar, it doesn't need to open the jar to check
         * for updated dependencies, providing a slight performance
         * boost at startup. The use of ".dex" here matches the use on
         * files in /data/dalvik-cache.
         */
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.256 -0500", hash_original_field = "1CA815D0916A6B7AC169D2CAC0E494BF", hash_generated_field = "37CF7DC6ED2CB6FBEB27D6CEFB2D68E1")

    private static final String DEX_SUFFIX = ".dex";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.259 -0500", hash_original_field = "B159BA4BFCD839A9AB95A3BEBA0468BC", hash_generated_field = "3166419EC870FB1378EBC123F44480B1")

    private static final String JAR_SUFFIX = ".jar";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.261 -0500", hash_original_field = "BC92A7E9F999382B202D47FC7F60D23B", hash_generated_field = "EF3CFC1323C1C36712EDA5211E4F7373")

    private static final String ZIP_SUFFIX = ".zip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.264 -0500", hash_original_field = "ED6B710FBF4EE4128C88D28F765DEB48", hash_generated_field = "37B170C5A677C2526C7FE461B48153B8")

    private static final String APK_SUFFIX = ".apk";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.266 -0500", hash_original_field = "402CBF9105CF48C1E38DB2C46CCD557B", hash_generated_field = "C26455FF0303CF3616EEE8FEAA4F7A0F")

    private  ClassLoader definingContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.268 -0500", hash_original_field = "62B55359BF892351862B0CFDFEF2ED4C", hash_generated_field = "A7619B7365AE4C331D989E49ADBEFBCB")

    private  Element[] dexElements;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.271 -0500", hash_original_field = "6BC6C18BF93BB590DA8031D3C1811032", hash_generated_field = "AE1EF9991574B5A7C61DD485E05882A3")

    private  File[] nativeLibraryDirectories;

    /**
     * Constructs an instance.
     *
     * @param definingContext the context in which any as-yet unresolved
     * classes should be defined
     * @param dexPath list of dex/resource path elements, separated by
     * {@code File.pathSeparator}
     * @param libraryPath list of native library directory path elements,
     * separated by {@code File.pathSeparator}
     * @param optimizedDirectory directory where optimized {@code .dex} files
     * should be found and written to, or {@code null} to use the default
     * system directory for same
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.274 -0500", hash_original_method = "391CC1D8031EEADD5869B9B2E6DEDA56", hash_generated_method = "F7E4F276F41A7F6B3EEEF03B4838AE0E")
    
public DexPathList(ClassLoader definingContext, String dexPath,
            String libraryPath, File optimizedDirectory) {
        if (definingContext == null) {
            throw new NullPointerException("definingContext == null");
        }

        if (dexPath == null) {
            throw new NullPointerException("dexPath == null");
        }

        if (optimizedDirectory != null) {
            if (!optimizedDirectory.exists())  {
                throw new IllegalArgumentException(
                        "optimizedDirectory doesn't exist: "
                        + optimizedDirectory);
            }

            if (!(optimizedDirectory.canRead()
                            && optimizedDirectory.canWrite())) {
                throw new IllegalArgumentException(
                        "optimizedDirectory not readable/writable: "
                        + optimizedDirectory);
            }
        }

        this.definingContext = definingContext;
        this.dexElements =
            makeDexElements(splitDexPath(dexPath), optimizedDirectory);
        this.nativeLibraryDirectories = splitLibraryPath(libraryPath);
    }
    
    static class Element {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.307 -0500", hash_original_field = "CF0C1CE75EC12E637A82B051B1AA9983", hash_generated_field = "2F2F994FE64CD70831C1033A4A29832A")

        public  File file;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.309 -0500", hash_original_field = "391A9B27A44F3383A94C4C3B91FF9B70", hash_generated_field = "8D3206573610C2D0826105B08DB3519F")

        public  ZipFile zipFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.311 -0500", hash_original_field = "1B07CDE3D9275D5070319BD626B8EAA2", hash_generated_field = "605FB7C70C2875B1FD6B68477587F1B5")

        public  DexFile dexFile;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.314 -0500", hash_original_method = "6D7B88020BD7097C5D3BFE418F13B214", hash_generated_method = "314E5199DD6A94B91093352D3BF009E9")
        
public Element(File file, ZipFile zipFile, DexFile dexFile) {
            this.file = file;
            this.zipFile = zipFile;
            this.dexFile = dexFile;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.317 -0500", hash_original_method = "853A43CB46D2A1F46888921026F3A6BF", hash_generated_method = "1177088647EBB98999817BDC6B179477")
        
public URL findResource(String name) {
            if ((zipFile == null) || (zipFile.getEntry(name) == null)) {
                /*
                 * Either this element has no zip/jar file (first
                 * clause), or the zip/jar file doesn't have an entry
                 * for the given name (second clause).
                 */
                return null;
            }

            try {
                /*
                 * File.toURL() is compliant with RFC 1738 in
                 * always creating absolute path names. If we
                 * construct the URL by concatenating strings, we
                 * might end up with illegal URLs for relative
                 * names.
                 */
                return new URL("jar:" + file.toURL() + "!/" + name);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
        }
        
    }

    /**
     * Finds the named class in one of the dex files pointed at by
     * this instance. This will find the one in the earliest listed
     * path element. If the class is found but has not yet been
     * defined, then this method will define it in the defining
     * context that this instance was constructed with.
     *
     * @return the named class or {@code null} if the class is not
     * found in any of the dex files
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.296 -0500", hash_original_method = "D0077BF0C677FC7F0C28C59D93206805", hash_generated_method = "89F5B9FD76C4F65D2B0BBA73BDB7C9DA")
    
public Class findClass(String name) {
        for (Element element : dexElements) {
            DexFile dex = element.dexFile;

            if (dex != null) {
                Class clazz = dex.loadClassBinaryName(name, definingContext);
                if (clazz != null) {
                    return clazz;
                }
            }
        }

        return null;
    }

    /**
     * Finds the named resource in one of the zip/jar files pointed at
     * by this instance. This will find the one in the earliest listed
     * path element.
     *
     * @return a URL to the named resource or {@code null} if the
     * resource is not found in any of the zip/jar files
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.299 -0500", hash_original_method = "5F5378C3BB7399B364C8BA4B56CD7FC5", hash_generated_method = "1CD29E35223987FDA91B4E59C4B6D207")
    
public URL findResource(String name) {
        for (Element element : dexElements) {
            URL url = element.findResource(name);
            if (url != null) {
                return url;
            }
        }

        return null;
    }

    /**
     * Finds all the resources with the given name, returning an
     * enumeration of them. If there are no resources with the given
     * name, then this method returns an empty enumeration.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.301 -0500", hash_original_method = "804A7034A2DFDDBE0ECC495815CB31BB", hash_generated_method = "AF55D3E5BEB87EC30C54BBF4C006354C")
    
public Enumeration<URL> findResources(String name) {
        ArrayList<URL> result = new ArrayList<URL>();

        for (Element element : dexElements) {
            URL url = element.findResource(name);
            if (url != null) {
                result.add(url);
            }
        }

        return Collections.enumeration(result);
    }

    /**
     * Finds the named native code library on any of the library
     * directories pointed at by this instance. This will find the
     * one in the earliest listed directory, ignoring any that are not
     * readable regular files.
     *
     * @return the complete path to the library or {@code null} if no
     * library was found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.303 -0500", hash_original_method = "240DC3968F2BE784AD66FA40662DC8EC", hash_generated_method = "E0946249E803D66F7EE5B4E2003C5376")
    
public String findLibrary(String libraryName) {
        String fileName = System.mapLibraryName(libraryName);

        for (File directory : nativeLibraryDirectories) {
            File file = new File(directory, fileName);
            if (file.exists() && file.isFile() && file.canRead()) {
                return file.getPath();
            }
        }

        return null;
    }
}

