/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
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

/**
 * This class loader is responsible for loading classes and resources from a
 * list of URLs which can refer to either directories or JAR files. Classes
 * loaded by this {@code URLClassLoader} are granted permission to access the
 * URLs contained in the URL search list.
 */
@FindBugsSuppressWarnings({ "DMI_COLLECTION_OF_URLS", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED" })
public class URLClassLoader extends SecureClassLoader {

    /**
     * Determines if the URL is pointing to a directory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.302 -0400", hash_original_method = "3CFB904866B3259764C1179843D2440E", hash_generated_method = "B0184391B61883391B71DEB8F787FC1E")
    
private static boolean isDirectory(URL url) {
        String file = url.getFile();
        return (file.length() > 0 && file.charAt(file.length() - 1) == '/');
    }

    /**
     * Returns a new {@code URLClassLoader} instance for the given URLs and the
     * system {@code ClassLoader} as its parent.
     *
     * @param urls
     *            the list of URLs that is passed to the new {@code
     *            URLClassLoader}.
     * @return the created {@code URLClassLoader} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.302 -0400", hash_original_method = "4CC25BCE276B028797998A2EBBB2A816", hash_generated_method = "4D10BD7F32F7121E76B07481709855F7")
    
public static URLClassLoader newInstance(final URL[] urls) {
        return new URLClassLoader(urls, ClassLoader.getSystemClassLoader());
    }

    /**
     * Returns a new {@code URLClassLoader} instance for the given URLs and the
     * specified {@code ClassLoader} as its parent.
     *
     * @param urls
     *            the list of URLs that is passed to the new URLClassLoader.
     * @param parentCl
     *            the parent class loader that is passed to the new
     *            URLClassLoader.
     * @return the created {@code URLClassLoader} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.303 -0400", hash_original_method = "85096368C86C39A9A920738098E78F80", hash_generated_method = "E967BE38B0D4AC44B5BCFE3BAECDAE76")
    
public static URLClassLoader newInstance(final URL[] urls, final ClassLoader parentCl) {
        return new URLClassLoader(urls, parentCl);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.272 -0400", hash_original_field = "8493272A5AB4A77AB209F22490E9A299", hash_generated_field = "8493272A5AB4A77AB209F22490E9A299")


    ArrayList<URL> originalUrls;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.272 -0400", hash_original_field = "6EEE0C60179788AF966E079989CB5CB3", hash_generated_field = "6EEE0C60179788AF966E079989CB5CB3")


    List<URL> searchList;

    static class IndexFile {
        //private URLClassLoader host;


        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.275 -0400", hash_original_method = "F2256C562ABA1A793D732471535C7B66", hash_generated_method = "C68D2BD6272B0373AF7CD47F3BB1AED1")
        
static IndexFile readIndexFile(JarFile jf, JarEntry indexEntry, URL url) {
            BufferedReader in = null;
            InputStream is = null;
            try {
                // Add mappings from resource to jar file
                String parentURLString = getParentURL(url).toExternalForm();
                String prefix = "jar:" + parentURLString + "/";
                is = jf.getInputStream(indexEntry);
                in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                HashMap<String, ArrayList<URL>> pre_map = new HashMap<String, ArrayList<URL>>();
                // Ignore the 2 first lines (index version)
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
                // Ignore this jar's index
            } catch (IOException e) {
                // Ignore this jar's index
            } finally {
                IoUtils.closeQuietly(in);
                IoUtils.closeQuietly(is);
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.276 -0400", hash_original_method = "F9F75F1866695430F481015BBE8767F3", hash_generated_method = "1F811BEDCBDA3A3777CF073E60622C08")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.274 -0400", hash_original_field = "76A176000CA2730D7340962D00AB47FA", hash_generated_field = "8CA0A10A56B7E322DF59FAF09C201F44")


        private HashMap<String, ArrayList<URL>> map;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.276 -0400", hash_original_method = "379F12D2048DD620EF06C57D0B8DE6F0", hash_generated_method = "D3363781B695DF1B83D498BBB8704458")
        
public IndexFile(HashMap<String, ArrayList<URL>> map) {
            this.map = map;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.277 -0400", hash_original_method = "8FF86E61D1723FF11EF08355D8ACABBC", hash_generated_method = "8FF86E61D1723FF11EF08355D8ACABBC")
        
ArrayList<URL> get(String name) {
            return map.get(name);
        }
    }

    class URLHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.278 -0400", hash_original_field = "D0C59163767519DDC23EEDD08636971F", hash_generated_field = "D0C59163767519DDC23EEDD08636971F")

        URL url;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.279 -0400", hash_original_field = "CA61315DDA6019C64E03F42F9050F544", hash_generated_field = "CA61315DDA6019C64E03F42F9050F544")

        URL codeSourceUrl;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.280 -0400", hash_original_method = "D5B6F191489E39FDFBD95ACBEEF6948D", hash_generated_method = "52611AF730305CCEA4577BB3112C9FE8")
        
public URLHandler(URL url) {
            this.url = url;
            this.codeSourceUrl = url;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.280 -0400", hash_original_method = "A27A46A41A88BA0FAAC7830FBD366ED6", hash_generated_method = "A27A46A41A88BA0FAAC7830FBD366ED6")
        
void findResources(String name, ArrayList<URL> resources) {
            URL res = findResource(name);
            if (res != null && !resources.contains(res)) {
                resources.add(res);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.280 -0400", hash_original_method = "DE45CDB737E4642285D570F5610849E6", hash_generated_method = "DE45CDB737E4642285D570F5610849E6")
        
Class<?> findClass(String packageName, String name, String origName) {
            URL resURL = targetURL(url, name);
            if (resURL != null) {
                try {
                    InputStream is = resURL.openStream();
                    return createClass(is, packageName, origName);
                } catch (IOException e) {
                }
            }
            return null;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.281 -0400", hash_original_method = "73460255618B48EEC6C92DAEEADA9765", hash_generated_method = "73460255618B48EEC6C92DAEEADA9765")
        
Class<?> createClass(InputStream is, String packageName, String origName) {
            if (is == null) {
                return null;
            }
            byte[] clBuf;
            try {
                clBuf = Streams.readFully(is);
            } catch (IOException e) {
                return null;
            }
            if (packageName != null) {
                String packageDotName = packageName.replace('/', '.');
                Package packageObj = getPackage(packageDotName);
                if (packageObj == null) {
                    definePackage(packageDotName, null, null,
                            null, null, null, null, null);
                } else {
                    if (packageObj.isSealed()) {
                        throw new SecurityException("Package is sealed");
                    }
                }
            }
            return defineClass(origName, clBuf, 0, clBuf.length, new CodeSource(codeSourceUrl, (Certificate[]) null));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.282 -0400", hash_original_method = "127A00E2878A258FF82AAAD1F4FC3101", hash_generated_method = "39240A4F5D5645BAE080905AA4F93FC0")
        
URL findResource(String name) {
            URL resURL = targetURL(url, name);
            if (resURL != null) {
                try {
                    URLConnection uc = resURL.openConnection();
                    uc.getInputStream().close();
                    // HTTP can return a stream on a non-existent file
                    // So check for the return code;
                    if (!resURL.getProtocol().equals("http")) {
                        return resURL;
                    }
                    int code;
                    if ((code = ((HttpURLConnection) uc).getResponseCode()) >= 200
                            && code < 300) {
                        return resURL;
                    }
                } catch (SecurityException e) {
                    return null;
                } catch (IOException e) {
                    return null;
                }
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.282 -0400", hash_original_method = "0524D4A234DDE6E7BD7D4DF76408464F", hash_generated_method = "0524D4A234DDE6E7BD7D4DF76408464F")
        
URL targetURL(URL base, String name) {
            try {
                StringBuilder fileBuilder = new StringBuilder();
                fileBuilder.append(base.getFile());
                URI.PATH_ENCODER.appendEncoded(fileBuilder, name);
                String file = fileBuilder.toString();

                return new URL(base.getProtocol(), base.getHost(), base.getPort(), file, null);
            } catch (MalformedURLException e) {
                return null;
            }
        }

    }

    class URLJarHandler extends URLHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.284 -0400", hash_original_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62", hash_generated_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62")

         JarFile jf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.284 -0400", hash_original_field = "C2C4984C490CB9B238D5B3903BFC80CB", hash_generated_field = "C2C4984C490CB9B238D5B3903BFC80CB")

         String prefixName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.285 -0400", hash_original_field = "1CD0A34CFD9CFF5C38175C01E8A02107", hash_generated_field = "1CD0A34CFD9CFF5C38175C01E8A02107")

         IndexFile index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.285 -0400", hash_original_field = "7C44F8438E081330364F46A075FCABB3", hash_generated_field = "1E63D5B05AD896CB7F2DEBE9E3B81004")

        final Map<URL, URLHandler> subHandlers = new HashMap<URL, URLHandler>();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.286 -0400", hash_original_method = "5C0004D321A5570AF49FDFAA941E414F", hash_generated_method = "8009A406C884D2E416AD6F32281B265F")
        
public URLJarHandler(URL url, URL jarURL, JarFile jf, String prefixName) {
            super(url);
            this.jf = jf;
            this.prefixName = prefixName;
            this.codeSourceUrl = jarURL;
            final JarEntry je = jf.getJarEntry("META-INF/INDEX.LIST");
            this.index = (je == null ? null : IndexFile.readIndexFile(jf, je, url));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.286 -0400", hash_original_method = "D582F40800649C185B2BDB76509EA85E", hash_generated_method = "B9A1035D277518160D511D3046B41054")
        
public URLJarHandler(URL url, URL jarURL, JarFile jf, String prefixName, IndexFile index) {
            super(url);
            this.jf = jf;
            this.prefixName = prefixName;
            this.index = index;
            this.codeSourceUrl = jarURL;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.286 -0400", hash_original_method = "2D62A5E011065AD5CA1BC3D6BB78BB91", hash_generated_method = "2D62A5E011065AD5CA1BC3D6BB78BB91")
        
IndexFile getIndex() {
            return index;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.287 -0400", hash_original_method = "3BC222ED8E766AE357F97E5ED2C16BF7", hash_generated_method = "BCD83623B341CDF2A7469B3A085E5E0B")
        
@Override
        void findResources(String name, ArrayList<URL> resources) {
            URL res = findResourceInOwn(name);
            if (res != null && !resources.contains(res)) {
                resources.add(res);
            }
            if (index != null) {
                int pos = name.lastIndexOf("/");
                // only keep the directory part of the resource
                // as index.list only keeps track of directories and root files
                String indexedName = (pos > 0) ? name.substring(0, pos) : name;
                ArrayList<URL> urls = index.get(indexedName);
                if (urls != null) {
                    urls.remove(url);
                    for (URL url : urls) {
                        URLHandler h = getSubHandler(url);
                        if (h != null) {
                            h.findResources(name, resources);
                        }
                    }
                }
            }

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.288 -0400", hash_original_method = "A33B0C1225B85366B8FACC1A747264F5", hash_generated_method = "DF8596C30CEDD252015018BC62F4D1E3")
        
@Override
        Class<?> findClass(String packageName, String name, String origName) {
            String entryName = prefixName + name;
            JarEntry entry = jf.getJarEntry(entryName);
            if (entry != null) {
                /**
                 * Avoid recursive load class, especially the class
                 * is an implementation class of security provider
                 * and the jar is signed.
                 */
                try {
                    Manifest manifest = jf.getManifest();
                    return createClass(entry, manifest, packageName, origName);
                } catch (IOException e) {
                }
            }
            if (index != null) {
                ArrayList<URL> urls;
                if (packageName == null) {
                    urls = index.get(name);
                } else {
                    urls = index.get(packageName);
                }
                if (urls != null) {
                    urls.remove(url);
                    for (URL url : urls) {
                        URLHandler h = getSubHandler(url);
                        if (h != null) {
                            Class<?> res = h.findClass(packageName, name, origName);
                            if (res != null) {
                                return res;
                            }
                        }
                    }
                }
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.289 -0400", hash_original_method = "0997311DA5151313F3B17639635BC461", hash_generated_method = "48EDE5E1829240ED698B80EDDEA96BE8")
        
private Class<?> createClass(JarEntry entry, Manifest manifest, String packageName, String origName) {
            byte[] clBuf;
            try {
                InputStream is = jf.getInputStream(entry);
                clBuf = Streams.readFully(is);
            } catch (IOException e) {
                return null;
            }
            if (packageName != null) {
                String packageDotName = packageName.replace('/', '.');
                Package packageObj = getPackage(packageDotName);
                if (packageObj == null) {
                    if (manifest != null) {
                        definePackage(packageDotName, manifest,
                                codeSourceUrl);
                    } else {
                        definePackage(packageDotName, null, null,
                                null, null, null, null, null);
                    }
                } else {
                    boolean exception = packageObj.isSealed();
                    if (manifest != null) {
                        if (isSealed(manifest, packageName + "/")) {
                            exception = !packageObj
                                    .isSealed(codeSourceUrl);
                        }
                    }
                    if (exception) {
                        throw new SecurityException(String.format("Package %s is sealed",
                                packageName));
                    }
                }
            }
            CodeSource codeS = new CodeSource(codeSourceUrl, entry.getCertificates());
            return defineClass(origName, clBuf, 0, clBuf.length, codeS);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.290 -0400", hash_original_method = "BEAE23CC7138835BB0FEF01D26145FD9", hash_generated_method = "BEAE23CC7138835BB0FEF01D26145FD9")
        
URL findResourceInOwn(String name) {
            String entryName = prefixName + name;
            if (jf.getEntry(entryName) != null) {
                return targetURL(url, name);
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.290 -0400", hash_original_method = "7546D3992FBBAF86B12F0B740620B74B", hash_generated_method = "755E8E84660E63E5FBB93A85F7E0E9EE")
        
@Override
        URL findResource(String name) {
            URL res = findResourceInOwn(name);
            if (res != null) {
                return res;
            }
            if (index != null) {
                int pos = name.lastIndexOf("/");
                // only keep the directory part of the resource
                // as index.list only keeps track of directories and root files
                String indexedName = (pos > 0) ? name.substring(0, pos) : name;
                ArrayList<URL> urls = index.get(indexedName);
                if (urls != null) {
                    urls.remove(url);
                    for (URL url : urls) {
                        URLHandler h = getSubHandler(url);
                        if (h != null) {
                            res = h.findResource(name);
                            if (res != null) {
                                return res;
                            }
                        }
                    }
                }
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.291 -0400", hash_original_method = "47CD540256D0F2B23AE4D5BB7E445858", hash_generated_method = "9BE68994C32A765117273D88613BEEDD")
        
private synchronized URLHandler getSubHandler(URL url) {
            URLHandler sub = subHandlers.get(url);
            if (sub != null) {
                return sub;
            }
            String protocol = url.getProtocol();
            if (protocol.equals("jar")) {
                sub = createURLJarHandler(url);
            } else if (protocol.equals("file")) {
                sub = createURLSubJarHandler(url);
            } else {
                sub = createURLHandler(url);
            }
            if (sub != null) {
                subHandlers.put(url, sub);
            }
            return sub;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.292 -0400", hash_original_method = "CC5C093E882DD207DA9222EBC985A361", hash_generated_method = "ADAFC0D623EF7003E05B068F6341D3B5")
        
private URLHandler createURLSubJarHandler(URL url) {
            String prefixName;
            String file = url.getFile();
            if (url.getFile().endsWith("!/")) {
                prefixName = "";
            } else {
                int sepIdx = file.lastIndexOf("!/");
                if (sepIdx == -1) {
                    // Invalid URL, don't look here again
                    return null;
                }
                sepIdx += 2;
                prefixName = file.substring(sepIdx);
            }
            try {
                URL jarURL = ((JarURLConnection) url
                        .openConnection()).getJarFileURL();
                JarURLConnection juc = (JarURLConnection) new URL(
                        "jar", "",
                        jarURL.toExternalForm() + "!/").openConnection();
                JarFile jf = juc.getJarFile();
                URLJarHandler jarH = new URLJarHandler(url, jarURL, jf, prefixName, null);
                // TODO : to think what we should do with indexes & manifest.class file here
                return jarH;
            } catch (IOException e) {
            }
            return null;
        }

    }

    class URLFileHandler extends URLHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.295 -0400", hash_original_field = "D07D332701F9B92847141D46D8B2C7CF", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

        private String prefix;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.296 -0400", hash_original_method = "680EB2855BA8F548EBF3C384B153AF69", hash_generated_method = "2E8046C4258CF185485F18B3C66B2437")
        
public URLFileHandler(URL url) {
            super(url);
            String baseFile = url.getFile();
            String host = url.getHost();
            int hostLength = 0;
            if (host != null) {
                hostLength = host.length();
            }
            StringBuilder buf = new StringBuilder(2 + hostLength
                    + baseFile.length());
            if (hostLength > 0) {
                buf.append("//").append(host);
            }
            // baseFile always ends with '/'
            buf.append(baseFile);
            prefix = buf.toString();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.296 -0400", hash_original_method = "459A43E8A29596EEF0DEE6D3A05FE74A", hash_generated_method = "1225838DB65EEC58BE0F9787421B9DAE")
        
@Override
        Class<?> findClass(String packageName, String name, String origName) {
            String filename = prefix + name;
            try {
                filename = URLDecoder.decode(filename, "UTF-8");
            } catch (IllegalArgumentException e) {
                return null;
            } catch (UnsupportedEncodingException e) {
                return null;
            }

            File file = new File(filename);
            if (file.exists()) {
                try {
                    InputStream is = new FileInputStream(file);
                    return createClass(is, packageName, origName);
                } catch (FileNotFoundException e) {
                }
            }
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.297 -0400", hash_original_method = "5954C39BABA19C5921C727F17BF4740B", hash_generated_method = "77CB54B35385669B169A5FC196E7A529")
        
@Override
        URL findResource(String name) {
            int idx = 0;
            String filename;

            // Do not create a UNC path, i.e. \\host
            while (idx < name.length() &&
                   ((name.charAt(idx) == '/') || (name.charAt(idx) == '\\'))) {
                idx++;
            }

            if (idx > 0) {
                name = name.substring(idx);
            }

            try {
                filename = URLDecoder.decode(prefix, "UTF-8") + name;

                if (new File(filename).exists()) {
                    return targetURL(url, name);
                }
                return null;
            } catch (IllegalArgumentException e) {
                return null;
            } catch (UnsupportedEncodingException e) {
                // must not happen
                throw new AssertionError(e);
            }
        }

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.273 -0400", hash_original_field = "018DFABF07E4A0807227E840C28DF558", hash_generated_field = "018DFABF07E4A0807227E840C28DF558")

    ArrayList<URLHandler> handlerList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.273 -0400", hash_original_field = "83210D660C03E6C9492E92BD982991A6", hash_generated_field = "83210D660C03E6C9492E92BD982991A6")

    Map<URL, URLHandler> handlerMap = new HashMap<URL, URLHandler>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.273 -0400", hash_original_field = "9DB50F5F7BDAD32B470567919A87AA9C", hash_generated_field = "E43CA7AA04ACD2FE8928E03B47B06D76")


    private URLStreamHandlerFactory factory;


    /**
     * Constructs a new {@code URLClassLoader} instance. The newly created
     * instance will have the system ClassLoader as its parent. URLs that end
     * with "/" are assumed to be directories, otherwise they are assumed to be
     * JAR files.
     *
     * @param urls
     *            the list of URLs where a specific class or file could be
     *            found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.298 -0400", hash_original_method = "223BBDDFA8D7BCBDBB892F093839C31A", hash_generated_method = "43783A6A442CA27B1A695DA7C863CA18")
    
public URLClassLoader(URL[] urls) {
        this(urls, ClassLoader.getSystemClassLoader(), null);
    }

    /**
     * Constructs a new URLClassLoader instance. The newly created instance will
     * have the system ClassLoader as its parent. URLs that end with "/" are
     * assumed to be directories, otherwise they are assumed to be JAR files.
     *
     * @param urls
     *            the list of URLs where a specific class or file could be
     *            found.
     * @param parent
     *            the class loader to assign as this loader's parent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.299 -0400", hash_original_method = "2C1F233833FFEC69CE12E7A0069A8B49", hash_generated_method = "00BD38C214AA3F43B6E5A11F05CCAD5E")
    
public URLClassLoader(URL[] urls, ClassLoader parent) {
        this(urls, parent, null);
    }

    /**
     * Constructs a new {@code URLClassLoader} instance. The newly created
     * instance will have the specified {@code ClassLoader} as its parent and
     * use the specified factory to create stream handlers. URLs that end with
     * "/" are assumed to be directories, otherwise they are assumed to be JAR
     * files.
     *
     * @param searchUrls
     *            the list of URLs where a specific class or file could be
     *            found.
     * @param parent
     *            the {@code ClassLoader} to assign as this loader's parent.
     * @param factory
     *            the factory that will be used to create protocol-specific
     *            stream handlers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.303 -0400", hash_original_method = "9F92FD383D821F82B2A5EE941293558A", hash_generated_method = "C7642046863F68A6C21532E38608934D")
    
public URLClassLoader(URL[] searchUrls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(parent);
        this.factory = factory;
        int nbUrls = searchUrls.length;
        originalUrls = new ArrayList<URL>(nbUrls);
        handlerList = new ArrayList<URLHandler>(nbUrls);
        searchList = Collections.synchronizedList(new ArrayList<URL>(nbUrls));
        for (int i = 0; i < nbUrls; i++) {
            originalUrls.add(searchUrls[i]);
            try {
                searchList.add(createSearchURL(searchUrls[i]));
            } catch (MalformedURLException e) {
            }
        }
    }

    /**
     * Adds the specified URL to the search list.
     *
     * @param url
     *            the URL which is to add.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.299 -0400", hash_original_method = "8767B0DB3A608CD14EAA847CE6E9F597", hash_generated_method = "549477C92982AB36ECCE3FD77ABFF2F9")
    
protected void addURL(URL url) {
        try {
            originalUrls.add(url);
            searchList.add(createSearchURL(url));
        } catch (MalformedURLException e) {
        }
    }

    /**
     * Returns all known URLs which point to the specified resource.
     *
     * @param name
     *            the name of the requested resource.
     * @return the enumeration of URLs which point to the specified resource.
     * @throws IOException
     *             if an I/O error occurs while attempting to connect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.300 -0400", hash_original_method = "E35E96FBBA5328024F5002F5E092C0FA", hash_generated_method = "1A0885D5DE908CF5CF99681124D5053A")
    
@Override
    public Enumeration<URL> findResources(final String name) throws IOException {
        if (name == null) {
            return null;
        }
        ArrayList<URL> result = new ArrayList<URL>();
        int n = 0;
        while (true) {
            URLHandler handler = getHandler(n++);
            if (handler == null) {
                break;
            }
            handler.findResources(name, result);
        }
        return Collections.enumeration(result);
    }

    /**
     * Gets all permissions for the specified {@code codesource}. First, this
     * method retrieves the permissions from the system policy. If the protocol
     * is "file:/" then a new permission, {@code FilePermission}, granting the
     * read permission to the file is added to the permission collection.
     * Otherwise, connecting to and accepting connections from the URL is
     * granted.
     *
     * @param codesource
     *            the code source object whose permissions have to be known.
     * @return the list of permissions according to the code source object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.301 -0400", hash_original_method = "07FAE3F30AFAC7664087FCB0D480D03A", hash_generated_method = "6BECDF55BED6BD56170C8524F1BA1F07")
    
@Override
    protected PermissionCollection getPermissions(final CodeSource codesource) {
        PermissionCollection pc = super.getPermissions(codesource);
        URL u = codesource.getLocation();
        if (u.getProtocol().equals("jar")) {
            try {
                // Create a URL for the resource the jar refers to
                u = ((JarURLConnection) u.openConnection()).getJarFileURL();
            } catch (IOException e) {
                // This should never occur. If it does continue using the jar
                // URL
            }
        }
        if (u.getProtocol().equals("file")) {
            String path = u.getFile();
            String host = u.getHost();
            if (host != null && host.length() > 0) {
                path = "//" + host + path;
            }

            if (File.separatorChar != '/') {
                path = path.replace('/', File.separatorChar);
            }
            if (isDirectory(u)) {
                pc.add(new FilePermission(path + "-", "read"));
            } else {
                pc.add(new FilePermission(path, "read"));
            }
        } else {
            String host = u.getHost();
            if (host.length() == 0) {
                host = "localhost";
            }
            pc.add(new SocketPermission(host, "connect, accept"));
        }
        return pc;
    }

    /**
     * Returns the search list of this {@code URLClassLoader}.
     *
     * @return the list of all known URLs of this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.301 -0400", hash_original_method = "E74D6D295FD8DF7C4B8AB85761E02982", hash_generated_method = "DD8947860091513FECFE2D9141D4503D")
    
public URL[] getURLs() {
        return originalUrls.toArray(new URL[originalUrls.size()]);
    }

    /**
     * Tries to locate and load the specified class using the known URLs. If the
     * class could be found, a class object representing the loaded class will
     * be returned.
     *
     * @throws ClassNotFoundException
     *             if the specified class cannot be loaded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.304 -0400", hash_original_method = "BAA63B0BE9A75DDAC07B90D04DE61F0B", hash_generated_method = "B9267EE2E3A19C8B170491C449818D74")
    
@Override
    protected Class<?> findClass(final String className) throws ClassNotFoundException {
        String partialName = className.replace('.', '/');
        final String classFileName = new StringBuilder(partialName).append(".class").toString();
        String packageName = null;
        int position = partialName.lastIndexOf('/');
        if ((position = partialName.lastIndexOf('/')) != -1) {
            packageName = partialName.substring(0, position);
        }
        int n = 0;
        while (true) {
            URLHandler handler = getHandler(n++);
            if (handler == null) {
                break;
            }
            Class<?> res = handler.findClass(packageName, classFileName, className);
            if (res != null) {
                return res;
            }
        }
        throw new ClassNotFoundException(className);
    }

    /**
     * Returns an URL that will be checked if it contains the class or resource.
     * If the file component of the URL is not a directory, a Jar URL will be
     * created.
     *
     * @return java.net.URL a test URL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.305 -0400", hash_original_method = "75025FE733C588323FB29CA64B72756D", hash_generated_method = "FB333AB9EE3E9B39A75ADCDD9A7CC5B6")
    
private URL createSearchURL(URL url) throws MalformedURLException {
        if (url == null) {
            return url;
        }

        String protocol = url.getProtocol();

        if (isDirectory(url) || protocol.equals("jar")) {
            return url;
        }
        if (factory == null) {
            return new URL("jar", "",
                    -1, url.toString() + "!/");
        }
        // use jar protocol as the stream handler protocol
        return new URL("jar", "",
                -1, url.toString() + "!/",
                factory.createURLStreamHandler("jar"));
    }

    /**
     * Returns an URL referencing the specified resource or {@code null} if the
     * resource could not be found.
     *
     * @param name
     *            the name of the requested resource.
     * @return the URL which points to the given resource.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.306 -0400", hash_original_method = "36DCCA8214496CA792D9D415CCE3C1EC", hash_generated_method = "214521B9244B9D5FB842CF07D8CF7F87")
    
@Override
    public URL findResource(final String name) {
        if (name == null) {
            return null;
        }
        int n = 0;
        while (true) {
            URLHandler handler = getHandler(n++);
            if (handler == null) {
                break;
            }
            URL res = handler.findResource(name);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.306 -0400", hash_original_method = "CFA5B2A5119E9C6C6C6B8BDB54F0FFE4", hash_generated_method = "FF5764FFBB71073640F549604BF280C1")
    
private URLHandler getHandler(int num) {
        if (num < handlerList.size()) {
            return handlerList.get(num);
        }
        makeNewHandler();
        if (num < handlerList.size()) {
            return handlerList.get(num);
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.307 -0400", hash_original_method = "B13B3FAA12E4EC519D487B45363B07D9", hash_generated_method = "9EE655DCCEA93801CED43809AED0DE83")
    
private synchronized void makeNewHandler() {
        while (!searchList.isEmpty()) {
            URL nextCandidate = searchList.remove(0);
            if (nextCandidate == null) {
                throw new NullPointerException("nextCandidate == null");
            }
            if (!handlerMap.containsKey(nextCandidate)) {
                URLHandler result;
                String protocol = nextCandidate.getProtocol();
                if (protocol.equals("jar")) {
                    result = createURLJarHandler(nextCandidate);
                } else if (protocol.equals("file")) {
                    result = createURLFileHandler(nextCandidate);
                } else {
                    result = createURLHandler(nextCandidate);
                }
                if (result != null) {
                    handlerMap.put(nextCandidate, result);
                    handlerList.add(result);
                    return;
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.307 -0400", hash_original_method = "15D2A778081BB97B4F5082C5EA9323F2", hash_generated_method = "A02BD2F69C2BBA7AA55BAE52D1435E76")
    
private URLHandler createURLHandler(URL url) {
        return new URLHandler(url);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.308 -0400", hash_original_method = "959FE775BCBFF6223F7FD94A4010D369", hash_generated_method = "9B910D461AEF53F624C2B2772D92150D")
    
private URLHandler createURLFileHandler(URL url) {
        return new URLFileHandler(url);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.310 -0400", hash_original_method = "93DBA576D247FBB46E5BCA4D9E3C8DFF", hash_generated_method = "909403B29F0266E249828972FDCB597E")
    
private URLHandler createURLJarHandler(URL url) {
        String prefixName;
        String file = url.getFile();
        if (url.getFile().endsWith("!/")) {
            prefixName = "";
        } else {
            int sepIdx = file.lastIndexOf("!/");
            if (sepIdx == -1) {
                // Invalid URL, don't look here again
                return null;
            }
            sepIdx += 2;
            prefixName = file.substring(sepIdx);
        }
        try {
            URL jarURL = ((JarURLConnection) url
                    .openConnection()).getJarFileURL();
            JarURLConnection juc = (JarURLConnection) new URL(
                    "jar", "",
                    jarURL.toExternalForm() + "!/").openConnection();
            JarFile jf = juc.getJarFile();
            URLJarHandler jarH = new URLJarHandler(url, jarURL, jf, prefixName);

            if (jarH.getIndex() == null) {
                try {
                    Manifest manifest = jf.getManifest();
                    if (manifest != null) {
                        String classpath = manifest.getMainAttributes().getValue(
                                Attributes.Name.CLASS_PATH);
                        if (classpath != null) {
                            searchList.addAll(0, getInternalURLs(url, classpath));
                        }
                    }
                } catch (IOException e) {
                }
            }
            return jarH;
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * Defines a new package using the information extracted from the specified
     * manifest.
     *
     * @param packageName
     *            the name of the new package.
     * @param manifest
     *            the manifest containing additional information for the new
     *            package.
     * @param url
     *            the URL to the code source for the new package.
     * @return the created package.
     * @throws IllegalArgumentException
     *             if a package with the given name already exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.311 -0400", hash_original_method = "1F20C74E5FA90998EED1F262145E5A78", hash_generated_method = "2A7FB06129B3C34770FC909CCF3E0658")
    
protected Package definePackage(String packageName, Manifest manifest,
                                    URL url) throws IllegalArgumentException {
        Attributes mainAttributes = manifest.getMainAttributes();
        String dirName = packageName.replace('.', '/') + "/";
        Attributes packageAttributes = manifest.getAttributes(dirName);
        boolean noEntry = false;
        if (packageAttributes == null) {
            noEntry = true;
            packageAttributes = mainAttributes;
        }
        String specificationTitle = packageAttributes
                .getValue(Attributes.Name.SPECIFICATION_TITLE);
        if (specificationTitle == null && !noEntry) {
            specificationTitle = mainAttributes
                    .getValue(Attributes.Name.SPECIFICATION_TITLE);
        }
        String specificationVersion = packageAttributes
                .getValue(Attributes.Name.SPECIFICATION_VERSION);
        if (specificationVersion == null && !noEntry) {
            specificationVersion = mainAttributes
                    .getValue(Attributes.Name.SPECIFICATION_VERSION);
        }
        String specificationVendor = packageAttributes
                .getValue(Attributes.Name.SPECIFICATION_VENDOR);
        if (specificationVendor == null && !noEntry) {
            specificationVendor = mainAttributes
                    .getValue(Attributes.Name.SPECIFICATION_VENDOR);
        }
        String implementationTitle = packageAttributes
                .getValue(Attributes.Name.IMPLEMENTATION_TITLE);
        if (implementationTitle == null && !noEntry) {
            implementationTitle = mainAttributes
                    .getValue(Attributes.Name.IMPLEMENTATION_TITLE);
        }
        String implementationVersion = packageAttributes
                .getValue(Attributes.Name.IMPLEMENTATION_VERSION);
        if (implementationVersion == null && !noEntry) {
            implementationVersion = mainAttributes
                    .getValue(Attributes.Name.IMPLEMENTATION_VERSION);
        }
        String implementationVendor = packageAttributes
                .getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
        if (implementationVendor == null && !noEntry) {
            implementationVendor = mainAttributes
                    .getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
        }

        return definePackage(packageName, specificationTitle,
                specificationVersion, specificationVendor, implementationTitle,
                implementationVersion, implementationVendor, isSealed(manifest,
                dirName) ? url : null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.312 -0400", hash_original_method = "F65716DA89135DC89A539D54ADB64D73", hash_generated_method = "087223521CD2904435849F646FA29F5F")
    
private boolean isSealed(Manifest manifest, String dirName) {
        Attributes attributes = manifest.getAttributes(dirName);
        if (attributes != null) {
            String value = attributes.getValue(Attributes.Name.SEALED);
            if (value != null) {
                return value.equalsIgnoreCase("true");
            }
        }
        Attributes mainAttributes = manifest.getMainAttributes();
        String value = mainAttributes.getValue(Attributes.Name.SEALED);
        return (value != null && value.equalsIgnoreCase("true"));
    }

    /**
     * returns URLs referenced in the string classpath.
     *
     * @param root
     *            the jar URL that classpath is related to
     * @param classpath
     *            the relative URLs separated by spaces
     * @return URL[] the URLs contained in the string classpath.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:47.313 -0400", hash_original_method = "8DCFE07B381999C3DEF19ABA31EFB008", hash_generated_method = "49BF773CD46AFA0A66A5D2D6767C6242")
    
private ArrayList<URL> getInternalURLs(URL root, String classpath) {
        // Class-path attribute is composed of space-separated values.
        StringTokenizer tokenizer = new StringTokenizer(classpath);
        ArrayList<URL> addedURLs = new ArrayList<URL>();
        String file = root.getFile();
        int jarIndex = file.lastIndexOf("!/") - 1;
        int index = file.lastIndexOf("/", jarIndex) + 1;
        if (index == 0) {
            index = file.lastIndexOf(
                    System.getProperty("file.separator"), jarIndex) + 1;
        }
        file = file.substring(0, index);
        while (tokenizer.hasMoreElements()) {
            String element = tokenizer.nextToken();
            if (!element.isEmpty()) {
                try {
                    // Take absolute path case into consideration
                    URL url = new URL(new URL(file), element);
                    addedURLs.add(createSearchURL(url));
                } catch (MalformedURLException e) {
                    // Nothing is added
                }
            }
        }
        return addedURLs;
    }
}
