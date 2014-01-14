package java.util.jar;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import libcore.io.Streams;

public class JarFile extends ZipFile {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.862 -0500", hash_original_method = "56C76838D318C13C94DEE83CC11CDED9", hash_generated_method = "01AD61DC1B9389BE2B87C74510A04B5F")
    
private static boolean endsWithIgnoreCase(String s, String suffix) {
        return s.regionMatches(true, s.length() - suffix.length(), suffix, 0, suffix.length());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.783 -0500", hash_original_field = "4794462719D3E9F18CEBA2F84F9344AA", hash_generated_field = "1B54FEE38023C23CFBDF6F59EE98F3A8")

    public static final String MANIFEST_NAME = "META-INF/MANIFEST.MF";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.785 -0500", hash_original_field = "B27664B7ACFDCC1A8CC161F5CEA89949", hash_generated_field = "4C54F1EB005D1336C5DED8B80F4F7160")

    static final String META_DIR = "META-INF/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.787 -0500", hash_original_field = "03D210293484A458EB6D74D44F54E99C", hash_generated_field = "261709621967406C2758961F4730EA20")

    private Manifest manifest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.789 -0500", hash_original_field = "E5E02C46F83017A562E2ABA5ABCB04A3", hash_generated_field = "A4D7622C7D5230CEA74D7E274931C68D")

    private ZipEntry manifestEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.791 -0500", hash_original_field = "15838C298A89AE0514754B108BF02A73", hash_generated_field = "15838C298A89AE0514754B108BF02A73")

    JarVerifier verifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.793 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;

    /**
     * Create a new {@code JarFile} using the contents of the specified file.
     *
     * @param file
     *            the JAR file as {@link File}.
     * @throws IOException
     *             If the file cannot be read.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.824 -0500", hash_original_method = "B9B0355AAF6860849CDAA93CC073B40D", hash_generated_method = "C83E25271015701A8F042457AFE11AD2")
    
public JarFile(File file) throws IOException {
        this(file, true);
    }

    /**
     * Create a new {@code JarFile} using the contents of the specified file.
     *
     * @param file
     *            the JAR file as {@link File}.
     * @param verify
     *            if this JAR file is signed whether it must be verified.
     * @throws IOException
     *             If the file cannot be read.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.827 -0500", hash_original_method = "5EB6670431246E3B0105DDAC48B26AC0", hash_generated_method = "3C9B3E336CE21CD229B2D8F0CE01CA33")
    
public JarFile(File file, boolean verify) throws IOException {
        super(file);
        if (verify) {
            verifier = new JarVerifier(file.getPath());
        }
        readMetaEntries();
    }

    /**
     * Create a new {@code JarFile} using the contents of file.
     *
     * @param file
     *            the JAR file as {@link File}.
     * @param verify
     *            if this JAR filed is signed whether it must be verified.
     * @param mode
     *            the mode to use, either {@link ZipFile#OPEN_READ OPEN_READ} or
     *            {@link ZipFile#OPEN_DELETE OPEN_DELETE}.
     * @throws IOException
     *             If the file cannot be read.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.829 -0500", hash_original_method = "793A8CDEEB3B1480C6CD4A5DE140B86D", hash_generated_method = "EA5869BF5717FAAE23DB4C6FE3175E97")
    
public JarFile(File file, boolean verify, int mode) throws IOException {
        super(file, mode);
        if (verify) {
            verifier = new JarVerifier(file.getPath());
        }
        readMetaEntries();
    }

    /**
     * Create a new {@code JarFile} from the contents of the file specified by
     * filename.
     *
     * @param filename
     *            the file name referring to the JAR file.
     * @throws IOException
     *             if file name cannot be opened for reading.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.832 -0500", hash_original_method = "7A554CED3F155E72368E52962D72B4D7", hash_generated_method = "5971E8B42F2379DF9AA7D80F2B92FD8C")
    
public JarFile(String filename) throws IOException {
        this(filename, true);
    }

    /**
     * Create a new {@code JarFile} from the contents of the file specified by
     * {@code filename}.
     *
     * @param filename
     *            the file name referring to the JAR file.
     * @param verify
     *            if this JAR filed is signed whether it must be verified.
     * @throws IOException
     *             If file cannot be opened or read.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.835 -0500", hash_original_method = "54E668354AB021AFE09898CE1915F8B2", hash_generated_method = "72A086CE0B1B9E938E296637D4A7E519")
    
public JarFile(String filename, boolean verify) throws IOException {
        super(filename);
        if (verify) {
            verifier = new JarVerifier(filename);
        }
        readMetaEntries();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.894 -0400", hash_original_method = "DDF115034FADFE53A1FD9BC36D36CE25", hash_generated_method = "28390275337A046A4F073DB9C9A54D85")
    @Override
    public Enumeration<JarEntry> entries() {
        class JarFileEnumerator implements Enumeration<JarEntry> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.838 -0500", hash_original_field = "BD6898769B3BC196CD1C8BCB2FCBB517", hash_generated_field = "BD6898769B3BC196CD1C8BCB2FCBB517")

            Enumeration<? extends ZipEntry> ze;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.841 -0500", hash_original_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62", hash_generated_field = "9E17897CFE5F4CA6FBFFFAEE1DB51A62")

            JarFile jf;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.844 -0500", hash_original_method = "C7F3ED49203A5BDA1D49193B6084B2BE", hash_generated_method = "C7F3ED49203A5BDA1D49193B6084B2BE")
            
JarFileEnumerator(Enumeration<? extends ZipEntry> zenum, JarFile jf) {
                ze = zenum;
                this.jf = jf;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.847 -0500", hash_original_method = "9E60B2163115C0F4A5143AACEF20F301", hash_generated_method = "5076C090B4C6D92111ACB2E13F1662EB")
            
public boolean hasMoreElements() {
                return ze.hasMoreElements();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.850 -0500", hash_original_method = "5675597FFA2F5C3F421325DE8580ECC3", hash_generated_method = "5BDC623339D2BC42818751FF9BCF82B4")
            
public JarEntry nextElement() {
                JarEntry je = new JarEntry(ze.nextElement());
                je.parentJar = jf;
                return je;
            }
        }
Enumeration<JarEntry> varFD6D5513D1E96AE9B20DD26D8EAB087D_1778760700 =         new JarFileEnumerator(super.entries(), this);
        varFD6D5513D1E96AE9B20DD26D8EAB087D_1778760700.addTaint(taint);
        return varFD6D5513D1E96AE9B20DD26D8EAB087D_1778760700;
        // ---------- Original Method ----------
        //class JarFileEnumerator implements Enumeration<JarEntry> {
            //Enumeration<? extends ZipEntry> ze;
            //JarFile jf;
            //JarFileEnumerator(Enumeration<? extends ZipEntry> zenum, JarFile jf) {
                //ze = zenum;
                //this.jf = jf;
            //}
            //public boolean hasMoreElements() {
                //return ze.hasMoreElements();
            //}
            //public JarEntry nextElement() {
                //JarEntry je = new JarEntry(ze.nextElement());
                //je.parentJar = jf;
                //return je;
            //}
        //}
        //return new JarFileEnumerator(super.entries(), this);
    }

    /**
     * Return the {@code JarEntry} specified by its name or {@code null} if no
     * such entry exists.
     *
     * @param name
     *            the name of the entry in the JAR file.
     * @return the JAR entry defined by the name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.854 -0500", hash_original_method = "C114B7C700B8AEF8B2BF9DB9E2302906", hash_generated_method = "19C6AF12965401ECFC9DBB2954A47690")
    
public JarEntry getJarEntry(String name) {
        return (JarEntry) getEntry(name);
    }

    /**
     * Returns the {@code Manifest} object associated with this {@code JarFile}
     * or {@code null} if no MANIFEST entry exists.
     *
     * @return the MANIFEST.
     * @throws IOException
     *             if an error occurs reading the MANIFEST file.
     * @throws IllegalStateException
     *             if the jar file is closed.
     * @see Manifest
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.857 -0500", hash_original_method = "E67D102DBF269AEACB3865BB39A89C99", hash_generated_method = "FCEBD4860DC6B0A79CDC7C64D2944AFA")
    
public Manifest getManifest() throws IOException {
        if (closed) {
            throw new IllegalStateException("JarFile has been closed");
        }
        if (manifest != null) {
            return manifest;
        }
        try {
            InputStream is = super.getInputStream(manifestEntry);
            if (verifier != null) {
                verifier.addMetaEntry(manifestEntry.getName(), Streams.readFully(is));
                is = super.getInputStream(manifestEntry);
            }
            try {
                manifest = new Manifest(is, verifier != null);
            } finally {
                is.close();
            }
            manifestEntry = null;  // Can discard the entry now.
        } catch (NullPointerException e) {
            manifestEntry = null;
        }
        return manifest;
    }

    /**
     * Called by the JarFile constructors, this method reads the contents of the
     * file's META-INF/ directory and picks out the MANIFEST.MF file and
     * verifier signature files if they exist. Any signature files found are
     * registered with the verifier.
     *
     * @throws IOException
     *             if there is a problem reading the jar file entries.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.860 -0500", hash_original_method = "388F847516FC198A1371FF54043E7729", hash_generated_method = "46A4B6AFC6A992C4ABFA8ACF50D6D1C2")
    
private void readMetaEntries() throws IOException {
        // Get all meta directory entries
        ZipEntry[] metaEntries = getMetaEntriesImpl();
        if (metaEntries == null) {
            verifier = null;
            return;
        }

        boolean signed = false;

        for (ZipEntry entry : metaEntries) {
            String entryName = entry.getName();
            // Is this the entry for META-INF/MANIFEST.MF ?
            if (manifestEntry == null && entryName.equalsIgnoreCase(MANIFEST_NAME)) {
                manifestEntry = entry;
                // If there is no verifier then we don't need to look any further.
                if (verifier == null) {
                    break;
                }
            } else {
                // Is this an entry that the verifier needs?
                if (verifier != null
                        && (endsWithIgnoreCase(entryName, ".SF")
                                || endsWithIgnoreCase(entryName, ".DSA")
                                || endsWithIgnoreCase(entryName, ".RSA"))) {
                    signed = true;
                    InputStream is = super.getInputStream(entry);
                    verifier.addMetaEntry(entryName, Streams.readFully(is));
                }
            }
        }

        // If there were no signature files, then no verifier work to do.
        if (!signed) {
            verifier = null;
        }
    }

    /**
     * Return an {@code InputStream} for reading the decompressed contents of
     * ZIP entry.
     *
     * @param ze
     *            the ZIP entry to be read.
     * @return the input stream to read from.
     * @throws IOException
     *             if an error occurred while creating the input stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.865 -0500", hash_original_method = "53CBE19CD54AC9FA27355C4D3916E5DE", hash_generated_method = "1E6B8FB4461758A643AFA1262535B726")
    
@Override
    public InputStream getInputStream(ZipEntry ze) throws IOException {
        if (manifestEntry != null) {
            getManifest();
        }
        if (verifier != null) {
            verifier.setManifest(getManifest());
            if (manifest != null) {
                verifier.mainAttributesEnd = manifest.getMainAttributesEnd();
            }
            if (verifier.readCertificates()) {
                verifier.removeMetaEntries();
                if (manifest != null) {
                    manifest.removeChunks();
                }
                if (!verifier.isSignedJar()) {
                    verifier = null;
                }
            }
        }
        InputStream in = super.getInputStream(ze);
        if (in == null) {
            return null;
        }
        if (verifier == null || ze.getSize() == -1) {
            return in;
        }
        JarVerifier.VerifierEntry entry = verifier.initEntry(ze.getName());
        if (entry == null) {
            return in;
        }
        return new JarFileInputStream(in, ze, entry);
    }

    /**
     * Return the {@code JarEntry} specified by name or {@code null} if no such
     * entry exists.
     *
     * @param name
     *            the name of the entry in the JAR file.
     * @return the ZIP entry extracted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.868 -0500", hash_original_method = "B825DECF198E8D2309850EFFE99C9789", hash_generated_method = "A5294FCC7223B631CD447911468CFD91")
    
@Override
    public ZipEntry getEntry(String name) {
        ZipEntry ze = super.getEntry(name);
        if (ze == null) {
            return ze;
        }
        JarEntry je = new JarEntry(ze);
        je.parentJar = this;
        return je;
    }
    
    static final class JarFileInputStream extends FilterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.797 -0500", hash_original_field = "D14481EA9CDAD366F91417FC5AF5E134", hash_generated_field = "96817EEF83FA1C93DC2A9F8452312BE5")

        private long count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.800 -0500", hash_original_field = "1FE06773CFC3C2D11351177FC9821537", hash_generated_field = "97423CF71E793626D5B9FCF841E2156D")

        private ZipEntry zipEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.802 -0500", hash_original_field = "3A436B99DEB6660BA60F1E68727D1F8A", hash_generated_field = "D893B68F418C2812B051677DEAD7BC47")

        private JarVerifier.VerifierEntry entry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.804 -0500", hash_original_field = "B3F4B9FB7F6E266775B1E500C6C15A46", hash_generated_field = "9C759896300CD7D902BE34CCDA83590B")

        private boolean done = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.808 -0500", hash_original_method = "C5D82B21AC1025C83393044900E9B5C1", hash_generated_method = "C5D82B21AC1025C83393044900E9B5C1")
        
JarFileInputStream(InputStream is, ZipEntry ze,
                JarVerifier.VerifierEntry e) {
            super(is);
            zipEntry = ze;
            count = zipEntry.getSize();
            entry = e;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.811 -0500", hash_original_method = "89CF4CB391CD9E8B348E579506073CE6", hash_generated_method = "B250FDF4E90C46AD119A8F73DF2C03D4")
        
@Override
        public int read() throws IOException {
            if (done) {
                return -1;
            }
            if (count > 0) {
                int r = super.read();
                if (r != -1) {
                    entry.write(r);
                    count--;
                } else {
                    count = 0;
                }
                if (count == 0) {
                    done = true;
                    entry.verify();
                }
                return r;
            } else {
                done = true;
                entry.verify();
                return -1;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.813 -0500", hash_original_method = "A2A36F60816A3448608DD8EC3FE6DD7B", hash_generated_method = "CEE01730D9D3AF09D011FF066CC57F74")
        
@Override
        public int read(byte[] buf, int off, int nbytes) throws IOException {
            if (done) {
                return -1;
            }
            if (count > 0) {
                int r = super.read(buf, off, nbytes);
                if (r != -1) {
                    int size = r;
                    if (count < size) {
                        size = (int) count;
                    }
                    entry.write(buf, off, size);
                    count -= size;
                } else {
                    count = 0;
                }
                if (count == 0) {
                    done = true;
                    entry.verify();
                }
                return r;
            } else {
                done = true;
                entry.verify();
                return -1;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.816 -0500", hash_original_method = "F5DF26793DC8C27B5E93038A2CA57A87", hash_generated_method = "5CAB3D66EB483457E42A260A8DFD8774")
        
@Override
        public int available() throws IOException {
            if (done) {
                return 0;
            }
            return super.available();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.819 -0500", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "FA64348A96D1C68BD0600E70DFA81D7E")
        
@Override
        public long skip(long byteCount) throws IOException {
            return Streams.skipByReading(this, byteCount);
        }
        
    }

    /**
     * Returns all the ZipEntry's that relate to files in the
     * JAR's META-INF directory.
     *
     * @return the list of ZipEntry's or {@code null} if there are none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.871 -0500", hash_original_method = "4B8F98994A94A2FEBED0E4C85A619A5C", hash_generated_method = "A6126524E6A3EAA35E32646B7419A131")
    
private ZipEntry[] getMetaEntriesImpl() {
        List<ZipEntry> list = new ArrayList<ZipEntry>(8);
        Enumeration<? extends ZipEntry> allEntries = entries();
        while (allEntries.hasMoreElements()) {
            ZipEntry ze = allEntries.nextElement();
            if (ze.getName().startsWith(META_DIR)
                    && ze.getName().length() > META_DIR.length()) {
                list.add(ze);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        ZipEntry[] result = new ZipEntry[list.size()];
        list.toArray(result);
        return result;
    }

    /**
     * Closes this {@code JarFile}.
     *
     * @throws IOException
     *             if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.873 -0500", hash_original_method = "C7FCBD344022D72FF18766A4DFEA8EE1", hash_generated_method = "7035C7CC0EC06D72F1A3D6EF6B3FE4EA")
    
@Override
    public void close() throws IOException {
        super.close();
        closed = true;
    }
}

