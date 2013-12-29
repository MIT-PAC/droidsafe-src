package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;






public abstract class JarURLConnection extends URLConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.461 -0500", hash_original_field = "93D14AD8C7327C4E5F76F705777E71A8", hash_generated_field = "90997F9D911A1D629EE88BADE98B7D58")

    protected URLConnection jarFileURLConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.462 -0500", hash_original_field = "380454FECF00A43E372B31B7A119ED79", hash_generated_field = "6BE422D483C01C72CCB99BCB485E4E38")


    private String entryName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.463 -0500", hash_original_field = "2B598560502FFAE49A424093DCE88DD2", hash_generated_field = "82E66C9916EFB4902E3AF0806E62A3D4")


    private URL fileURL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.463 -0500", hash_original_field = "71FDB50C85529723B422EF50FDC30702", hash_generated_field = "30FC605F61F5025973295CA9594B2C5A")

    private String file;

    /**
     * Constructs an instance of {@code JarURLConnection} that refers to the
     * specified URL.
     *
     * @param url
     *            the URL that contains the location to connect to.
     * @throws MalformedURLException
     *             if an invalid URL has been entered.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.465 -0500", hash_original_method = "E4DD2BF7117B0709966B99D66AA37CA9", hash_generated_method = "0A6D8D833CA10FC684091A8F0FA98175")
    protected JarURLConnection(URL url) throws MalformedURLException {
        super(url);
        file = url.getFile();
        int sepIdx;
        if ((sepIdx = file.indexOf("!/")) < 0) {
            throw new MalformedURLException();
        }
        fileURL = new URL(url.getFile().substring(0,sepIdx));
        sepIdx += 2;
        if (file.length() == sepIdx) {
            return;
        }
        entryName = file.substring(sepIdx, file.length());
        if (url.getRef() != null) {
            entryName += "#" + url.getRef();
        }
    }

    /**
     * Returns all attributes of the {@code JarEntry} referenced by this {@code
     * JarURLConnection}.
     *
     * @return the attributes of the referenced {@code JarEntry}.
     * @throws IOException
     *                if an I/O exception occurs while retrieving the
     *                JAR-entries.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.465 -0500", hash_original_method = "42C141A19D7A99858D326914023176B3", hash_generated_method = "465EE6B26AF8D33A8D218A55A49287F1")
    public Attributes getAttributes() throws java.io.IOException {
        JarEntry jEntry = getJarEntry();
        return (jEntry == null) ? null : jEntry.getAttributes();
    }

    /**
     * Returns all certificates of the {@code JarEntry} referenced by this
     * {@code JarURLConnection} instance. This method will return {@code null}
     * until the {@code InputStream} has been completely verified.
     *
     * @return the certificates of the {@code JarEntry} as an array.
     * @throws IOException
     *                if there is an I/O exception occurs while getting the
     *                {@code JarEntry}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.466 -0500", hash_original_method = "D9106FD6CB62E572A0AA8ED3E04C3C09", hash_generated_method = "171C1CA2AA46ABDBDA99BC4144920BCE")
    public Certificate[] getCertificates() throws java.io.IOException {
        JarEntry jEntry = getJarEntry();
        if (jEntry == null) {
            return null;
        }

        return jEntry.getCertificates();
    }

    /**
     * Gets the name of the entry referenced by this {@code JarURLConnection}.
     * The return value will be {@code null} if this instance refers to a JAR
     * file rather than an JAR file entry.
     *
     * @return the {@code JarEntry} name this instance refers to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.467 -0500", hash_original_method = "DAD1125851C16B3E7BCEFC2CE4B21F94", hash_generated_method = "5F1B96D10D677CC80F4A39346F21BC31")
    public String getEntryName() {
        return entryName;
    }

    /**
     * Gets the {@code JarEntry} object of the entry referenced by this {@code
     * JarURLConnection}.
     *
     * @return the referenced {@code JarEntry} object or {@code null} if no
     *         entry name is specified.
     * @throws IOException
     *             if an error occurs while getting the file or file-entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.468 -0500", hash_original_method = "61250D8DAC5E4F2D4FA4FA4B1B6B705C", hash_generated_method = "4F76625C94010149473EBB79A61D5D9F")
    public JarEntry getJarEntry() throws IOException {
        if (!connected) {
            connect();
        }
        if (entryName == null) {
            return null;
        }
        // The entry must exist since the connect succeeded
        return getJarFile().getJarEntry(entryName);
    }

    /**
     * Gets the manifest file associated with this JAR-URL.
     *
     * @return the manifest of the referenced JAR-file.
     * @throws IOException
     *             if an error occurs while getting the manifest file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.469 -0500", hash_original_method = "EC6192B3278FED11B844B429A38C32F1", hash_generated_method = "10C1284C26B94E6CCFDFBE9F97C14404")
    public Manifest getManifest() throws java.io.IOException {
        return (Manifest)getJarFile().getManifest().clone();
    }

    /**
     * Gets the {@code JarFile} object referenced by this {@code
     * JarURLConnection}.
     *
     * @return the referenced JarFile object.
     * @throws IOException
     *                if an I/O exception occurs while retrieving the JAR-file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.469 -0500", hash_original_method = "BF5CCCDB452875A850EBFBEAFE3E1375", hash_generated_method = "939D31392D6E9D4BEED6B815B24B4D7E")
    public abstract JarFile getJarFile() throws java.io.IOException;

    /**
     * Gets the URL to the JAR-file referenced by this {@code JarURLConnection}.
     *
     * @return the URL to the JAR-file or {@code null} if there was an error
     *         retrieving the URL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.470 -0500", hash_original_method = "35923E0EC1A4B6746505AC2CF9BCB1E8", hash_generated_method = "8CC1ACE1CFC60AB221FC4EF323219F05")
    public URL getJarFileURL() {
        return fileURL;
    }

    /**
     * Gets all attributes of the manifest file referenced by this {@code
     * JarURLConnection}. If this instance refers to a JAR-file rather than a
     * JAR-file entry, {@code null} will be returned.
     *
     * @return the attributes of the manifest file or {@code null}.
     * @throws IOException
     *                if an I/O exception occurs while retrieving the {@code
     *                JarFile}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:06.471 -0500", hash_original_method = "392ECCC5BDE098E1298FE9F5D5A5083C", hash_generated_method = "6716954CDF1063A52CFE32BCA8CD08F0")
    public Attributes getMainAttributes() throws java.io.IOException {
        Manifest m = getJarFile().getManifest();
        return (m == null) ? null : m.getMainAttributes();
    }

    
}

