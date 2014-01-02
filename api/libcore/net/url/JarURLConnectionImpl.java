package libcore.net.url;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Permission;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

import libcore.net.UriCodec;





public class JarURLConnectionImpl extends JarURLConnection {

    /**
     * Closes the cached files.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.516 -0500", hash_original_method = "A4DC03ACA7E0192C0122C74C14A5C33F", hash_generated_method = "18031D17984944986C36ADBD2F35B132")
    
public static void closeCachedFiles() {
        Set<Map.Entry<URL, JarFile>> s = jarCache.entrySet();
        synchronized (jarCache) {
            Iterator<Map.Entry<URL, JarFile>> i = s.iterator();
            while (i.hasNext()) {
                try {
                    ZipFile zip = i.next().getValue();
                    if (zip != null) {
                        zip.close();
                    }
                } catch (IOException e) {
                    // Ignored
                }
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.463 -0500", hash_original_field = "EEE6F212560803EB63561C5DB4EDC791", hash_generated_field = "DAFAEFD0112EA423D0DE3AF30FA2DDE9")


    static HashMap<URL, JarFile> jarCache = new HashMap<URL, JarFile>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.465 -0500", hash_original_field = "B621CEFFF1CE60AB7ED145CDC7D8A502", hash_generated_field = "07485ED06E2A407A7D38E89DF7EA433B")


    private URL jarFileURL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.468 -0500", hash_original_field = "73CA466E3034481085B5947266F7234C", hash_generated_field = "2FDA65A94865AD8BD0FCF44E4CEE7E9C")


    private InputStream jarInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.470 -0500", hash_original_field = "B339322987345D78E0B630D63AE8DAC1", hash_generated_field = "A1544DC796279D75E8EFE7D422D11F29")


    private JarFile jarFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.472 -0500", hash_original_field = "243A80CC36D36456031E60F78531B9C5", hash_generated_field = "AC8BC8520BF86140D134B22CF6FB9C16")


    private JarEntry jarEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.474 -0500", hash_original_field = "0B6D06FC66AB1A3316E7702989E3F923", hash_generated_field = "52C99699A476D9ED1506978946DA0E51")


    private boolean closed;

    /**
     * @param url
     *            the URL of the JAR
     * @throws MalformedURLException
     *             if the URL is malformed
     * @throws IOException
     *             if there is a problem opening the connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.477 -0500", hash_original_method = "5F30611EBB0C16B95EA706518FA3E093", hash_generated_method = "55BEBD2FFEC37AC966E6A555207D2410")
    
public JarURLConnectionImpl(URL url) throws MalformedURLException,
            IOException {
        super(url);
        jarFileURL = getJarFileURL();
        jarFileURLConnection = jarFileURL.openConnection();
    }

    /**
     * @see java.net.URLConnection#connect()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.479 -0500", hash_original_method = "0D95FCCAA7871FCD5DE5E8081721F47B", hash_generated_method = "FBA25A5DDABF75A218EAB00E77AC5330")
    
@Override
    public void connect() throws IOException {
        if (!connected) {
            findJarFile(); // ensure the file can be found
            findJarEntry(); // ensure the entry, if any, can be found
            connected = true;
        }
    }

    /**
     * Returns the Jar file referred by this {@code URLConnection}.
     *
     * @return the JAR file referenced by this connection
     *
     * @throws IOException
     *             thrown if an IO error occurs while connecting to the
     *             resource.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.481 -0500", hash_original_method = "BAB8781FAD6151E9B45BF4A1B941497D", hash_generated_method = "EDDD207AE7A1A8EF9710B474C9878CF3")
    
@Override
    public JarFile getJarFile() throws IOException {
        connect();
        return jarFile;
    }

    /**
     * Returns the Jar file referred by this {@code URLConnection}
     *
     * @throws IOException
     *             if an IO error occurs while connecting to the resource.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.484 -0500", hash_original_method = "E0D7867F43E3325F58427586B81262FC", hash_generated_method = "9350D4ED5A55F5FCDDE820A56CA4088F")
    
private void findJarFile() throws IOException {
        JarFile jar = null;
        if (getUseCaches()) {
            synchronized (jarCache) {
                jarFile = jarCache.get(jarFileURL);
            }
            if (jarFile == null) {
                jar = openJarFile();
                synchronized (jarCache) {
                    jarFile = jarCache.get(jarFileURL);
                    if (jarFile == null) {
                        jarCache.put(jarFileURL, jar);
                        jarFile = jar;
                    } else {
                        jar.close();
                    }
                }
            }
        } else {
            jarFile = openJarFile();
        }

        if (jarFile == null) {
            throw new IOException();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.487 -0500", hash_original_method = "AF67425F611C6CCEA6B4F36EBE571AB2", hash_generated_method = "AF67425F611C6CCEA6B4F36EBE571AB2")
    
JarFile openJarFile() throws IOException {
        if (jarFileURL.getProtocol().equals("file")) {
            String decodedFile = UriCodec.decode(jarFileURL.getFile());
            return new JarFile(new File(decodedFile), true, ZipFile.OPEN_READ);
        } else {
            final InputStream is = jarFileURL.openConnection().getInputStream();
            try {
                FileOutputStream fos = null;
                JarFile result = null;
                try {
                    File tempJar = File.createTempFile("hyjar_", ".tmp", null);
                    tempJar.deleteOnExit();
                    fos = new FileOutputStream(tempJar);
                    byte[] buf = new byte[4096];
                    int nbytes = 0;
                    while ((nbytes = is.read(buf)) > -1) {
                        fos.write(buf, 0, nbytes);
                    }
                    fos.close();
                    return new JarFile(tempJar, true, ZipFile.OPEN_READ | ZipFile.OPEN_DELETE);
                } catch (IOException e) {
                    return null;
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException ex) {
                            return null;
                        }
                    }
                }
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }
    }

    /**
     * Returns the JarEntry of the entry referenced by this {@code
     * URLConnection}.
     *
     * @return the JarEntry referenced
     *
     * @throws IOException
     *             if an IO error occurs while getting the entry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.490 -0500", hash_original_method = "4969FA075748EE67279B88C22279B5EB", hash_generated_method = "E61711C77A0500B1E101A319B8915E7A")
    
@Override
    public JarEntry getJarEntry() throws IOException {
        connect();
        return jarEntry;

    }

    /**
     * Look up the JarEntry of the entry referenced by this {@code
     * URLConnection}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.492 -0500", hash_original_method = "47E7331F0B55D0071578FE2F3BE66635", hash_generated_method = "61A6D6E95BD183E74AC808B6EE3B68A9")
    
private void findJarEntry() throws IOException {
        if (getEntryName() == null) {
            return;
        }
        jarEntry = jarFile.getJarEntry(getEntryName());
        if (jarEntry == null) {
            throw new FileNotFoundException(getEntryName());
        }
    }

    /**
     * Creates an input stream for reading from this URL Connection.
     *
     * @return the input stream
     *
     * @throws IOException
     *             if an IO error occurs while connecting to the resource.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.494 -0500", hash_original_method = "96C498B69E21157D37D76B9902545F24", hash_generated_method = "C56B586BDAB524E470136EBBC5C9B019")
    
@Override
    public InputStream getInputStream() throws IOException {
        if (closed) {
            throw new IllegalStateException("JarURLConnection InputStream has been closed");
        }
        connect();
        if (jarInput != null) {
            return jarInput;
        }
        if (jarEntry == null) {
            throw new IOException("Jar entry not specified");
        }
        return jarInput = new JarURLConnectionInputStream(jarFile
                .getInputStream(jarEntry), jarFile);
    }

    /**
     * Returns the content type of the resource. For jar file itself
     * "x-java/jar" should be returned, for jar entries the content type of the
     * entry should be returned. Returns non-null results ("content/unknown" for
     * unknown types).
     *
     * @return the content type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.497 -0500", hash_original_method = "626D247225A5C5A729C002EF0C988C29", hash_generated_method = "2758DF82E46CF926A8F810BCC9635F2D")
    
@Override
    public String getContentType() {
        if (url.getFile().endsWith("!/")) {
            // the type for jar file itself is always "x-java/jar"
            return "x-java/jar";
        }
        String cType = null;
        String entryName = getEntryName();

        if (entryName != null) {
            // if there is an Jar Entry, get the content type from the name
            cType = guessContentTypeFromName(entryName);
        } else {
            try {
                connect();
                cType = jarFileURLConnection.getContentType();
            } catch (IOException ioe) {
                // Ignore
            }
        }
        if (cType == null) {
            cType = "content/unknown";
        }
        return cType;
    }

    /**
     * Returns the content length of the resource. Test cases reveal that if the
     * URL is referring to a Jar file, this method answers a content-length
     * returned by URLConnection. For jar entry it should return it's size.
     * Otherwise, it will return -1.
     *
     * @return the content length
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.499 -0500", hash_original_method = "C82FBA290AE26D875C8865E2241D6919", hash_generated_method = "D0608284EF49FF8AD559D7F1BEB68058")
    
@Override
    public int getContentLength() {
        try {
            connect();
            if (jarEntry == null) {
                return jarFileURLConnection.getContentLength();
            }
            return (int) getJarEntry().getSize();
        } catch (IOException e) {
            // Ignored
        }
        return -1;
    }

    /**
     * Returns the object pointed by this {@code URL}. If this URLConnection is
     * pointing to a Jar File (no Jar Entry), this method will return a {@code
     * JarFile} If there is a Jar Entry, it will return the object corresponding
     * to the Jar entry content type.
     *
     * @return a non-null object
     *
     * @throws IOException
     *             if an IO error occurred
     *
     * @see ContentHandler
     * @see ContentHandlerFactory
     * @see java.io.IOException
     * @see #setContentHandlerFactory(ContentHandlerFactory)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.501 -0500", hash_original_method = "277EA8603145BCD9B1620E5B0867C76D", hash_generated_method = "1E407D4BF6D927E9F9483E003F23E85A")
    
@Override
    public Object getContent() throws IOException {
        connect();
        // if there is no Jar Entry, return a JarFile
        if (jarEntry == null) {
            return jarFile;
        }
        return super.getContent();
    }

    /**
     * Returns the permission, in this case the subclass, FilePermission object
     * which represents the permission necessary for this URLConnection to
     * establish the connection.
     *
     * @return the permission required for this URLConnection.
     *
     * @throws IOException
     *             thrown when an IO exception occurs while creating the
     *             permission.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.504 -0500", hash_original_method = "32AB82048771397A8F2D1AACD6751885", hash_generated_method = "4448AB76790A3478C2A6AEE7067BA4F7")
    
@Override
    public Permission getPermission() throws IOException {
        return jarFileURLConnection.getPermission();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.507 -0500", hash_original_method = "89E1132CC6620CB971998873757D9D18", hash_generated_method = "77023372473D25337D2B6542C9C6CC06")
    
@Override
    public boolean getUseCaches() {
        return jarFileURLConnection.getUseCaches();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.509 -0500", hash_original_method = "B4491CDE2E10F000A5909671FFF7BF11", hash_generated_method = "5678194492AA9FFBBE1580289BE105B5")
    
@Override
    public void setUseCaches(boolean usecaches) {
        jarFileURLConnection.setUseCaches(usecaches);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.511 -0500", hash_original_method = "E32A55AFDD8C878EAFF3633240EF835D", hash_generated_method = "4B24D3EC9C6D6325DAB02E033DAF4B32")
    
@Override
    public boolean getDefaultUseCaches() {
        return jarFileURLConnection.getDefaultUseCaches();
    }

    
    private class JarURLConnectionInputStream extends FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.519 -0500", hash_original_field = "B339322987345D78E0B630D63AE8DAC1", hash_generated_field = "B339322987345D78E0B630D63AE8DAC1")

         JarFile jarFile;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.522 -0500", hash_original_method = "6E5813E713394C12219CB12B24913AED", hash_generated_method = "F4F59D7C18547D6DC4E2DEA19BEDD33C")
        
protected JarURLConnectionInputStream(InputStream in, JarFile file) {
            super(in);
            jarFile = file;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.524 -0500", hash_original_method = "C19810B5404F297C56A9BC5E0816E19A", hash_generated_method = "9B66B1EAA676D3BF6A2B7696D488FA68")
        
@Override
        public void close() throws IOException {
            super.close();
            if (!getUseCaches()) {
                closed = true;
                jarFile.close();
            }
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.514 -0500", hash_original_method = "9B53AD37225976042371B5DBF82602F6", hash_generated_method = "26621973421190D65594FDF72B3AA5BA")
    
@Override
    public void setDefaultUseCaches(boolean defaultusecaches) {
        jarFileURLConnection.setDefaultUseCaches(defaultusecaches);
    }
}

