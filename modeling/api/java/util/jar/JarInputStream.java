/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.util.jar;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The input stream from which the JAR file to be read may be fetched. It is
 * used like the {@code ZipInputStream}.
 *
 * @see ZipInputStream
 */
public class JarInputStream extends ZipInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.310 -0400", hash_original_field = "03D210293484A458EB6D74D44F54E99C", hash_generated_field = "261709621967406C2758961F4730EA20")

    private Manifest manifest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.311 -0400", hash_original_field = "542D70E5D5A3290907DA75B37B0954FD", hash_generated_field = "5CC6878338707D51F8B0333379CFA92C")

    private boolean eos = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.311 -0400", hash_original_field = "5331E6FEE4B5044231137D1E672CD2C7", hash_generated_field = "DD9A6E05A2A7AEB76B4202439E0E33FC")

    private JarEntry mEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.311 -0400", hash_original_field = "243A80CC36D36456031E60F78531B9C5", hash_generated_field = "AC8BC8520BF86140D134B22CF6FB9C16")

    private JarEntry jarEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.312 -0400", hash_original_field = "697C1BA932E57713DDA42831C668EB15", hash_generated_field = "C561A558EDBDC4549FE9E3D8634A1322")

    private boolean isMeta;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.312 -0400", hash_original_field = "15838C298A89AE0514754B108BF02A73", hash_generated_field = "5A6E602E6A4879953D21B5670B282CB9")

    private JarVerifier verifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.312 -0400", hash_original_field = "1523629A13DB95122E99EDD04197FDAC", hash_generated_field = "CE0EED03A1B8C68A8550E70F11ED281D")

    private OutputStream verStream;

    /**
     * Constructs a new {@code JarInputStream} from an input stream.
     *
     * @param stream
     *            the input stream containing the JAR file.
     * @param verify
     *            if the file should be verified with a {@code JarVerifier}.
     * @throws IOException
     *             If an error occurs reading entries from the input stream.
     * @see ZipInputStream#ZipInputStream(InputStream)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.313 -0400", hash_original_method = "A702CA11ED54D772A8FA56C8516AE76F", hash_generated_method = "01E7D0C28321D57C7716953CC2B4DBE2")
    
public JarInputStream(InputStream stream, boolean verify) throws IOException {
        super(stream);
        if (verify) {
            verifier = new JarVerifier("JarInputStream");
        }
        if ((mEntry = getNextJarEntry()) == null) {
            return;
        }
        if (mEntry.getName().equalsIgnoreCase(JarFile.META_DIR)) {
            mEntry = null; // modifies behavior of getNextJarEntry()
            closeEntry();
            mEntry = getNextJarEntry();
        }
        if (mEntry.getName().equalsIgnoreCase(JarFile.MANIFEST_NAME)) {
            mEntry = null;
            manifest = new Manifest(this, verify);
            closeEntry();
            if (verify) {
                verifier.setManifest(manifest);
                if (manifest != null) {
                    verifier.mainAttributesEnd = manifest.getMainAttributesEnd();
                }
            }

        } else {
            Attributes temp = new Attributes(3);
            temp.map.put("hidden", null);
            mEntry.setAttributes(temp);
            /*
             * if not from the first entry, we will not get enough
             * information,so no verify will be taken out.
             */
            verifier = null;
        }
    }

    /**
     * Constructs a new {@code JarInputStream} from an input stream.
     *
     * @param stream
     *            the input stream containing the JAR file.
     * @throws IOException
     *             If an error occurs reading entries from the input stream.
     * @see ZipInputStream#ZipInputStream(InputStream)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.314 -0400", hash_original_method = "F6E2982D0383C7B44A0A65D44F7E3571", hash_generated_method = "E46DCD6597CA8C4A4025B29DDD5EE48E")
    
public JarInputStream(InputStream stream) throws IOException {
        this(stream, true);
    }

    /**
     * Returns the {@code Manifest} object associated with this {@code
     * JarInputStream} or {@code null} if no manifest entry exists.
     *
     * @return the MANIFEST specifying the contents of the JAR file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.314 -0400", hash_original_method = "EC5668F9084EE9EFAB85F951E1920969", hash_generated_method = "6A46919B49F3758B0BC4D2731033228D")
    
public Manifest getManifest() {
        return manifest;
    }

    /**
     * Returns the next {@code JarEntry} contained in this stream or {@code
     * null} if no more entries are present.
     *
     * @return the next JAR entry.
     * @throws IOException
     *             if an error occurs while reading the entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.314 -0400", hash_original_method = "BD4903E2B6D49D615EE65CF0C8FA22E1", hash_generated_method = "0F5FE0182C0DA5E4D0987E97E0724F96")
    
public JarEntry getNextJarEntry() throws IOException {
        return (JarEntry) getNextEntry();
    }

    /**
     * Reads up to {@code byteCount} bytes of decompressed data and stores it in
     * {@code buffer} starting at {@code byteOffset}. Returns the number of uncompressed bytes read.
     *
     * @throws IOException
     *             if an IOException occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.315 -0400", hash_original_method = "E92616C965F72196BCD3B01F79A94A0A", hash_generated_method = "5C845B3E1FCAA242B57813F9256D0ED4")
    
@Override
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        if (mEntry != null) {
            return -1;
        }
        int r = super.read(buffer, byteOffset, byteCount);
        if (verStream != null && !eos) {
            if (r == -1) {
                eos = true;
                if (verifier != null) {
                    if (isMeta) {
                        verifier.addMetaEntry(jarEntry.getName(),
                                ((ByteArrayOutputStream) verStream)
                                        .toByteArray());
                        try {
                            verifier.readCertificates();
                        } catch (SecurityException e) {
                            verifier = null;
                            throw e;
                        }
                    } else {
                        ((JarVerifier.VerifierEntry) verStream).verify();
                    }
                }
            } else {
                verStream.write(buffer, byteOffset, r);
            }
        }
        return r;
    }

    /**
     * Returns the next {@code ZipEntry} contained in this stream or {@code
     * null} if no more entries are present.
     *
     * @return the next extracted ZIP entry.
     * @throws IOException
     *             if an error occurs while reading the entry.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.316 -0400", hash_original_method = "E2767A1B54B913B29813784563C296CA", hash_generated_method = "609A6107C59CD2301041648B03160762")
    
@Override
    public ZipEntry getNextEntry() throws IOException {
        if (mEntry != null) {
            jarEntry = mEntry;
            mEntry = null;
            jarEntry.setAttributes(null);
        } else {
            jarEntry = (JarEntry) super.getNextEntry();
            if (jarEntry == null) {
                return null;
            }
            if (verifier != null) {
                isMeta = jarEntry.getName().toUpperCase(Locale.US).startsWith(JarFile.META_DIR);
                if (isMeta) {
                    verStream = new ByteArrayOutputStream();
                } else {
                    verStream = verifier.initEntry(jarEntry.getName());
                }
            }
        }
        eos = false;
        return jarEntry;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.316 -0400", hash_original_method = "1B909A49B3D7F73538507E4693AB8BF7", hash_generated_method = "AE32464A20771662823EC7C74E85D801")
    
@Override
    protected ZipEntry createZipEntry(String name) {
        JarEntry entry = new JarEntry(name);
        if (manifest != null) {
            entry.setAttributes(manifest.getAttributes(name));
        }
        return entry;
    }
}
