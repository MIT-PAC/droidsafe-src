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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.google.android.collect.Maps;
import com.google.android.collect.Sets;

import dalvik.system.DexFile;

public class ClassPathPackageInfoSource {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.879 -0500", hash_original_method = "39073AD7440C68985301143C4EF05AD0", hash_generated_method = "FB6305A216513F28E8657D75C1F16B30")
    
public static void setApkPaths(String[] apkPaths) {
        ClassPathPackageInfoSource.apkPaths = apkPaths;
    }

    /**
     * Checks if a given file name represents a toplevel class.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.903 -0500", hash_original_method = "F653DD259DAF160B16141F9C028E5103", hash_generated_method = "0204465D728032ACB5AFCD260826FD3D")
    
private static boolean isToplevelClass(String fileName) {
        return fileName.indexOf('$') < 0;
    }

    /**
     * Given the absolute path of a class file, return the class name.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.905 -0500", hash_original_method = "E96E955A5C1EB2B683E8448061084FE0", hash_generated_method = "EB93C1109129627397BE30F29F6E61DB")
    
private static String getClassName(String className) {
        int classNameEnd = className.length() - CLASS_EXTENSION.length();
        return className.substring(0, classNameEnd);
    }

    /**
     * Gets the class path from the System Property "java.class.path" and splits
     * it up into the individual elements.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.908 -0500", hash_original_method = "C01B1A844B82E746BE12E8FB5FEA7F70", hash_generated_method = "E4BBE2E7512D6E273BCCAFDF839650EB")
    
private static String[] getClassPath() {
        String classPath = System.getProperty("java.class.path");
        String separator = System.getProperty("path.separator", ":");
        return classPath.split(Pattern.quote(separator));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.857 -0500", hash_original_field = "D967D7BD2DC6DD1F65CEF9D1E61AD916", hash_generated_field = "0A8E39F88964FFF21016A3B57374DBA5")

    private static final String CLASS_EXTENSION = ".class";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.860 -0500", hash_original_field = "666867A935B66C5E4CF25DA40805D59F", hash_generated_field = "4A3AFCB5D516866BED33F518C5F5F314")

    private static final ClassLoader CLASS_LOADER
            = ClassPathPackageInfoSource.class.getClassLoader();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.870 -0500", hash_original_field = "B34620BAD0C4618AEF8C50BFEFE63294", hash_generated_field = "E1257C69AD4D655B417A83840C52F8B9")

    private static String[] apkPaths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.551 -0400", hash_original_field = "5B48EC82264433BE164C825255AA2E2A", hash_generated_field = "B2EB813D257A6C0FCC00AC001736957A")

    private final SimpleCache<String, ClassPathPackageInfo> cache = new SimpleCache<String, ClassPathPackageInfo>() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.863 -0500", hash_original_method = "C51B16E1A4E4D11F95C896FC8BD4A403", hash_generated_method = "C206A268A0EDB8DB2205B1BDD1506B47")
        
@Override
                protected ClassPathPackageInfo load(String pkgName) {
                    return createPackageInfo(pkgName);
                }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.868 -0500", hash_original_field = "71A42C6361E2E495CF635983A9996950", hash_generated_field = "738E08BA6D6240CD75FE2D1444323B8B")

    private  String[] classPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.872 -0500", hash_original_field = "628A1551490DFE035CC94E76C99DEE13", hash_generated_field = "10F94FB6EB6D746C033B473F8D40E7A3")

    private final Map<File, Set<String>> jarFiles = Maps.newHashMap();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.874 -0500", hash_original_field = "DB93E4DB6045160743AC769A344DA267", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

    private ClassLoader classLoader;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.876 -0500", hash_original_method = "5ED3C641A9C0B2F78FCA551972DB4070", hash_generated_method = "5ED3C641A9C0B2F78FCA551972DB4070")
    
ClassPathPackageInfoSource() {
        classPath = getClassPath();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.882 -0500", hash_original_method = "DA950CFDA512912E4146952A9FFE3442", hash_generated_method = "5DDD16E906C0CA99C81BE72703B33026")
    
public ClassPathPackageInfo getPackageInfo(String pkgName) {
        return cache.get(pkgName);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.885 -0500", hash_original_method = "276BBF38C683664C5FC093FA16997BEF", hash_generated_method = "8142E479C8EDAF640012769EC51F451B")
    
private ClassPathPackageInfo createPackageInfo(String packageName) {
        Set<String> subpackageNames = new TreeSet<String>();
        Set<String> classNames = new TreeSet<String>();
        Set<Class<?>> topLevelClasses = Sets.newHashSet();
        findClasses(packageName, classNames, subpackageNames);
        for (String className : classNames) {
            if (className.endsWith(".R") || className.endsWith(".Manifest")) {
                // Don't try to load classes that are generated. They usually aren't in test apks.
                continue;
            }
            
            try {
                // We get errors in the emulator if we don't use the caller's class loader.
                topLevelClasses.add(Class.forName(className, false,
                        (classLoader != null) ? classLoader : CLASS_LOADER));
            } catch (ClassNotFoundException e) {
                // Should not happen unless there is a generated class that is not included in
                // the .apk.
                Log.w("ClassPathPackageInfoSource", "Cannot load class. "
                        + "Make sure it is in your apk. Class name: '" + className
                        + "'. Message: " + e.getMessage(), e);
            }
        }
        return new ClassPathPackageInfo(this, packageName, subpackageNames,
                topLevelClasses);
    }

    /**
     * Finds all classes and sub packages that are below the packageName and
     * add them to the respective sets. Searches the package on the whole class
     * path.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.887 -0500", hash_original_method = "8D4A1EEE314B3C48143C50241149E8EC", hash_generated_method = "76FDAD0D1C9C56ADCDC8D83ED45FFD6D")
    
private void findClasses(String packageName, Set<String> classNames,
            Set<String> subpackageNames) {
        String packagePrefix = packageName + '.';
        String pathPrefix = packagePrefix.replace('.', '/');

        for (String entryName : classPath) {
            File classPathEntry = new File(entryName);

            // Forge may not have brought over every item in the classpath. Be
            // polite and ignore missing entries.
            if (classPathEntry.exists()) {
                try {
                    if (entryName.endsWith(".apk")) {
                        findClassesInApk(entryName, packageName, classNames, subpackageNames);
                    } else {
                        // scan the directories that contain apk files.
                        for (String apkPath : apkPaths) {
                            File file = new File(apkPath);
                            scanForApkFiles(file, packageName, classNames, subpackageNames);
                        }
                    }
                } catch (IOException e) {
                    throw new AssertionError("Can't read classpath entry " +
                            entryName + ": " + e.getMessage());
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.890 -0500", hash_original_method = "A7DD27ACC72325E48B148F5150BD252D", hash_generated_method = "822EA7DAA20D99E2A52DBC765C6183CC")
    
private void scanForApkFiles(File source, String packageName,
            Set<String> classNames, Set<String> subpackageNames) throws IOException {
        if (source.getPath().endsWith(".apk")) {
            findClassesInApk(source.getPath(), packageName, classNames, subpackageNames);
        } else {
            File[] files = source.listFiles();
            if (files != null) {
                for (File file : files) {
                    scanForApkFiles(file, packageName, classNames, subpackageNames);
                }
            }
        }
    }

    /**
     * Finds all classes and sub packages that are below the packageName and
     * add them to the respective sets. Searches the package in a class directory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.892 -0500", hash_original_method = "7C382FB07C89ED3AC2E0C82EFB5FB1EF", hash_generated_method = "5FDF3BCD329ED2F9585BD699994F5EF8")
    
private void findClassesInDirectory(File classDir,
            String packagePrefix, String pathPrefix, Set<String> classNames,
            Set<String> subpackageNames)
            throws IOException {
        File directory = new File(classDir, pathPrefix);

        if (directory.exists()) {
            for (File f : directory.listFiles()) {
                String name = f.getName();
                if (name.endsWith(CLASS_EXTENSION) && isToplevelClass(name)) {
                    classNames.add(packagePrefix + getClassName(name));
                } else if (f.isDirectory()) {
                    subpackageNames.add(packagePrefix + name);
                }
            }
        }
    }

    /**
     * Finds all classes and sub packages that are below the packageName and
     * add them to the respective sets. Searches the package in a single jar file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.895 -0500", hash_original_method = "C944AB8B1856D79715AAA6F332DF1C0A", hash_generated_method = "61FB4E599240CFCBD01A8DE57C2E7205")
    
private void findClassesInJar(File jarFile, String pathPrefix,
            Set<String> classNames, Set<String> subpackageNames)
            throws IOException {
        Set<String> entryNames = getJarEntries(jarFile);
        // check if the Jar contains the package.
        if (!entryNames.contains(pathPrefix)) {
            return;
        }
        int prefixLength = pathPrefix.length();
        for (String entryName : entryNames) {
            if (entryName.startsWith(pathPrefix)) {
                if (entryName.endsWith(CLASS_EXTENSION)) {
                    // check if the class is in the package itself or in one of its
                    // subpackages.
                    int index = entryName.indexOf('/', prefixLength);
                    if (index >= 0) {
                        String p = entryName.substring(0, index).replace('/', '.');
                        subpackageNames.add(p);
                    } else if (isToplevelClass(entryName)) {
                        classNames.add(getClassName(entryName).replace('/', '.'));
                    }
                }
            }
        }
    }

    /**
     * Finds all classes and sub packages that are below the packageName and
     * add them to the respective sets. Searches the package in a single apk file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.897 -0500", hash_original_method = "3DB74F10ACB7465BB59ECD7AE11AEF17", hash_generated_method = "05F734B07F12F2772C33A856D1EC69F4")
    
private void findClassesInApk(String apkPath, String packageName,
            Set<String> classNames, Set<String> subpackageNames)
            throws IOException {

        DexFile dexFile = null;
        try {
            dexFile = new DexFile(apkPath);
            Enumeration<String> apkClassNames = dexFile.entries();
            while (apkClassNames.hasMoreElements()) {
                String className = apkClassNames.nextElement();

                if (className.startsWith(packageName)) {
                    String subPackageName = packageName;
                    int lastPackageSeparator = className.lastIndexOf('.');
                    if (lastPackageSeparator > 0) {
                        subPackageName = className.substring(0, lastPackageSeparator);
                    }
                    if (subPackageName.length() > packageName.length()) {
                        subpackageNames.add(subPackageName);
                    } else if (isToplevelClass(className)) {
                        classNames.add(className);
                    }
                }
            }
        } catch (IOException e) {
            if (false) {
                Log.w("ClassPathPackageInfoSource",
                        "Error finding classes at apk path: " + apkPath, e);
            }
        } finally {
            if (dexFile != null) {
                // Todo: figure out why closing causes a dalvik error resulting in vm shutdown.
//                dexFile.close();
            }
        }
    }

    /**
     * Gets the class and package entries from a Jar.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.900 -0500", hash_original_method = "47511CFE3B18B3B12FAA22B4CA43B4A2", hash_generated_method = "69400A0E1B9E959917EB939B937C78D5")
    
private Set<String> getJarEntries(File jarFile)
            throws IOException {
        Set<String> entryNames = jarFiles.get(jarFile);
        if (entryNames == null) {
            entryNames = Sets.newHashSet();
            ZipFile zipFile = new ZipFile(jarFile);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                String entryName = entries.nextElement().getName();
                if (entryName.endsWith(CLASS_EXTENSION)) {
                    // add the entry name of the class
                    entryNames.add(entryName);

                    // add the entry name of the classes package, i.e. the entry name of
                    // the directory that the class is in. Used to quickly skip jar files
                    // if they do not contain a certain package.
                    //
                    // Also add parent packages so that a JAR that contains
                    // pkg1/pkg2/Foo.class will be marked as containing pkg1/ in addition
                    // to pkg1/pkg2/ and pkg1/pkg2/Foo.class.  We're still interested in
                    // JAR files that contains subpackages of a given package, even if
                    // an intermediate package contains no direct classes.
                    //
                    // Classes in the default package will cause a single package named
                    // "" to be added instead.
                    int lastIndex = entryName.lastIndexOf('/');
                    do {
                        String packageName = entryName.substring(0, lastIndex + 1);
                        entryNames.add(packageName);
                        lastIndex = entryName.lastIndexOf('/', lastIndex - 1);
                    } while (lastIndex > 0);
                }
            }
            jarFiles.put(jarFile, entryNames);
        }
        return entryNames;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.910 -0500", hash_original_method = "EF51D9ADCA3E8F522FB005D173D913A5", hash_generated_method = "17E56A506DB48401AA8C60783B0C74E5")
    
public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}

