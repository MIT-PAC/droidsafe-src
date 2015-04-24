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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.jar;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import libcore.io.Base64;

import org.apache.harmony.security.utils.JarUtils;

class JarVerifier {

    /**
     * Returns a {@code Vector} of all of the
     * {@link java.security.cert.Certificate}s that are associated with the
     * signing of the named signature file.
     *
     * @param signatureFileName
     *            the name of a signature file.
     * @param certificates
     *            a {@code Map} of all of the certificate chains discovered so
     *            far while attempting to verify the JAR that contains the
     *            signature file {@code signatureFileName}. This object is
     *            previously set in the course of one or more calls to
     *            {@link #verifyJarSignatureFile(String, String, String, Map, Map)}
     *            where it was passed as the last argument.
     * @return all of the {@code Certificate} entries for the signer of the JAR
     *         whose actions led to the creation of the named signature file.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.414 -0500", hash_original_method = "7076E38A2129A6111F64A5E586BC8201", hash_generated_method = "A3ACF8B97210B63D516427CC61673029")
    
public static Vector<Certificate> getSignerCertificates(
            String signatureFileName, Map<String, Certificate[]> certificates) {
        Vector<Certificate> result = new Vector<Certificate>();
        Certificate[] certChain = certificates.get(signatureFileName);
        if (certChain != null) {
            for (Certificate element : certChain) {
                result.add(element);
            }
        }
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.339 -0500", hash_original_field = "88AD73F6C62A39F120982A1969BB094D", hash_generated_field = "9E85BB611D3EE89CADB45020535E6B11")

    private  String jarName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.341 -0500", hash_original_field = "78860F2A6A7B3C54CFA9242D05478E45", hash_generated_field = "1E6BF158A9ED964E950A909DB5592C82")

    private Manifest man;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.344 -0500", hash_original_field = "5063FF266DB0B8DEC600BC2A9CBDDE6C", hash_generated_field = "7597311A3575323E247960656BDFED83")

    private HashMap<String, byte[]> metaEntries = new HashMap<String, byte[]>(5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.347 -0500", hash_original_field = "F43783B6B696E02FC14D6A7D650AD5D8", hash_generated_field = "EBE3D14483DFDBD581E4922AC5C6EF8C")

    private final Hashtable<String, HashMap<String, Attributes>> signatures = new Hashtable<String, HashMap<String, Attributes>>(
            5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.349 -0500", hash_original_field = "A37D8BF86D510C4A7476BA0DF8506801", hash_generated_field = "F2823AD67EF4110598FC3B6AEAEBB2CE")

    private final Hashtable<String, Certificate[]> certificates = new Hashtable<String, Certificate[]>(
            5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.352 -0500", hash_original_field = "C3F2C899B61AB23CACE8C24C191D7DDE", hash_generated_field = "60F30BC5BC981A97975947915771AEC9")

    private final Hashtable<String, Certificate[]> verifiedEntries = new Hashtable<String, Certificate[]>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.354 -0500", hash_original_field = "6B8C7E29F08A08768A13067ED2CA8C6A", hash_generated_field = "6B8C7E29F08A08768A13067ED2CA8C6A")

    int mainAttributesEnd;

    /**
     * Constructs and returns a new instance of {@code JarVerifier}.
     *
     * @param name
     *            the name of the JAR file being verified.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.384 -0500", hash_original_method = "4436059C4E8276439A6065FE93A5DE5F", hash_generated_method = "4436059C4E8276439A6065FE93A5DE5F")
    
JarVerifier(String name) {
        jarName = name;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.379 -0500", hash_original_method = "A00C668D834700B7DBCD83DF376B2F68", hash_generated_method = "EAC500B4D4C6E3E60265AC7DB475A82C")
    
private SecurityException invalidDigest(String signatureFile, String name, String jarName) {
        throw new SecurityException(signatureFile + " has invalid digest for " + name +
                " in " + jarName);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.381 -0500", hash_original_method = "6DF68FF1B39EE346E0EC276311EA5830", hash_generated_method = "F5CE810BEF717ECE24D592E956941563")
    
private SecurityException failedVerification(String jarName, String signatureFile) {
        throw new SecurityException(jarName + " failed verification of " + signatureFile);
    }

    /**
     * Invoked for each new JAR entry read operation from the input
     * stream. This method constructs and returns a new {@link VerifierEntry}
     * which contains the certificates used to sign the entry and its hash value
     * as specified in the JAR MANIFEST format.
     *
     * @param name
     *            the name of an entry in a JAR file which is <b>not</b> in the
     *            {@code META-INF} directory.
     * @return a new instance of {@link VerifierEntry} which can be used by
     *         callers as an {@link OutputStream}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.388 -0500", hash_original_method = "6A6033A1386EA2314D4EF0CB331B3F5C", hash_generated_method = "ECABF68918E30DC7AE663DB563868B1E")
    
VerifierEntry initEntry(String name) {
        // If no manifest is present by the time an entry is found,
        // verification cannot occur. If no signature files have
        // been found, do not verify.
        if (man == null || signatures.size() == 0) {
            return null;
        }

        Attributes attributes = man.getAttributes(name);
        // entry has no digest
        if (attributes == null) {
            return null;
        }

        ArrayList<Certificate> certs = new ArrayList<Certificate>();
        Iterator<Map.Entry<String, HashMap<String, Attributes>>> it = signatures.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, HashMap<String, Attributes>> entry = it.next();
            HashMap<String, Attributes> hm = entry.getValue();
            if (hm.get(name) != null) {
                // Found an entry for entry name in .SF file
                String signatureFile = entry.getKey();
                certs.addAll(getSignerCertificates(signatureFile, certificates));
            }
        }

        // entry is not signed
        if (certs.isEmpty()) {
            return null;
        }
        Certificate[] certificatesArray = certs.toArray(new Certificate[certs.size()]);

        String algorithms = attributes.getValue("Digest-Algorithms");
        if (algorithms == null) {
            algorithms = "SHA SHA1";
        }
        StringTokenizer tokens = new StringTokenizer(algorithms);
        while (tokens.hasMoreTokens()) {
            String algorithm = tokens.nextToken();
            String hash = attributes.getValue(algorithm + "-Digest");
            if (hash == null) {
                continue;
            }
            byte[] hashBytes = hash.getBytes(Charsets.ISO_8859_1);

            try {
                return new VerifierEntry(name, MessageDigest
                        .getInstance(algorithm), hashBytes, certificatesArray);
            } catch (NoSuchAlgorithmException e) {
                // ignored
            }
        }
        return null;
    }

    /**
     * Add a new meta entry to the internal collection of data held on each JAR
     * entry in the {@code META-INF} directory including the manifest
     * file itself. Files associated with the signing of a JAR would also be
     * added to this collection.
     *
     * @param name
     *            the name of the file located in the {@code META-INF}
     *            directory.
     * @param buf
     *            the file bytes for the file called {@code name}.
     * @see #removeMetaEntries()
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.390 -0500", hash_original_method = "B24E46A89F6B78A5F74DC1F8899F1D36", hash_generated_method = "B24E46A89F6B78A5F74DC1F8899F1D36")
    
void addMetaEntry(String name, byte[] buf) {
        metaEntries.put(name.toUpperCase(Locale.US), buf);
    }

    /**
     * If the associated JAR file is signed, check on the validity of all of the
     * known signatures.
     *
     * @return {@code true} if the associated JAR is signed and an internal
     *         check verifies the validity of the signature(s). {@code false} if
     *         the associated JAR file has no entries at all in its {@code
     *         META-INF} directory. This situation is indicative of an invalid
     *         JAR file.
     *         <p>
     *         Will also return {@code true} if the JAR file is <i>not</i>
     *         signed.
     * @throws SecurityException
     *             if the JAR file is signed and it is determined that a
     *             signature block file contains an invalid signature for the
     *             corresponding signature file.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.393 -0500", hash_original_method = "8A8EDD1088AB3F7694E04A76DE584752", hash_generated_method = "8A6C9CCF0D097FF838DD1FBE220DAD25")
    
synchronized boolean readCertificates() {
        if (metaEntries == null) {
            return false;
        }
        Iterator<String> it = metaEntries.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (key.endsWith(".DSA") || key.endsWith(".RSA")) {
                verifyCertificate(key);
                // Check for recursive class load
                if (metaEntries == null) {
                    return false;
                }
                it.remove();
            }
        }
        return true;
    }

    /**
     * @param certFile
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.398 -0500", hash_original_method = "E0F968F23AF085C0376D04DBFBF51D30", hash_generated_method = "6D4AE1E3F1E817737EC4190C3E6EB66E")
    
private void verifyCertificate(String certFile) {
        // Found Digital Sig, .SF should already have been read
        String signatureFile = certFile.substring(0, certFile.lastIndexOf('.'))
                + ".SF";
        byte[] sfBytes = metaEntries.get(signatureFile);
        if (sfBytes == null) {
            return;
        }

        byte[] manifest = metaEntries.get(JarFile.MANIFEST_NAME);
        // Manifest entry is required for any verifications.
        if (manifest == null) {
            return;
        }

        byte[] sBlockBytes = metaEntries.get(certFile);
        try {
            Certificate[] signerCertChain = JarUtils.verifySignature(
                    new ByteArrayInputStream(sfBytes),
                    new ByteArrayInputStream(sBlockBytes));
            /*
             * Recursive call in loading security provider related class which
             * is in a signed JAR.
             */
            if (metaEntries == null) {
                return;
            }
            if (signerCertChain != null) {
                certificates.put(signatureFile, signerCertChain);
            }
        } catch (IOException e) {
            return;
        } catch (GeneralSecurityException e) {
            throw failedVerification(jarName, signatureFile);
        }

        // Verify manifest hash in .sf file
        Attributes attributes = new Attributes();
        HashMap<String, Attributes> entries = new HashMap<String, Attributes>();
        try {
            InitManifest im = new InitManifest(sfBytes, attributes, Attributes.Name.SIGNATURE_VERSION);
            im.initEntries(entries, null);
        } catch (IOException e) {
            return;
        }

        boolean createdBySigntool = false;
        String createdBy = attributes.getValue("Created-By");
        if (createdBy != null) {
            createdBySigntool = createdBy.indexOf("signtool") != -1;
        }

        // Use .SF to verify the mainAttributes of the manifest
        // If there is no -Digest-Manifest-Main-Attributes entry in .SF
        // file, such as those created before java 1.5, then we ignore
        // such verification.
        if (mainAttributesEnd > 0 && !createdBySigntool) {
            String digestAttribute = "-Digest-Manifest-Main-Attributes";
            if (!verify(attributes, digestAttribute, manifest, 0, mainAttributesEnd, false, true)) {
                throw failedVerification(jarName, signatureFile);
            }
        }

        // Use .SF to verify the whole manifest.
        String digestAttribute = createdBySigntool ? "-Digest"
                : "-Digest-Manifest";
        if (!verify(attributes, digestAttribute, manifest, 0, manifest.length,
                false, false)) {
            Iterator<Map.Entry<String, Attributes>> it = entries.entrySet()
                    .iterator();
            while (it.hasNext()) {
                Map.Entry<String, Attributes> entry = it.next();
                Manifest.Chunk chunk = man.getChunk(entry.getKey());
                if (chunk == null) {
                    return;
                }
                if (!verify(entry.getValue(), "-Digest", manifest,
                        chunk.start, chunk.end, createdBySigntool, false)) {
                    throw invalidDigest(signatureFile, entry.getKey(), jarName);
                }
            }
        }
        metaEntries.put(signatureFile, null);
        signatures.put(signatureFile, entries);
    }

    /**
     * Associate this verifier with the specified {@link Manifest} object.
     *
     * @param mf
     *            a {@code java.util.jar.Manifest} object.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.400 -0500", hash_original_method = "5E96175D15755C77B9F4C5D6341FECA1", hash_generated_method = "5E96175D15755C77B9F4C5D6341FECA1")
    
void setManifest(Manifest mf) {
        man = mf;
    }

    /**
     * Returns a <code>boolean</code> indication of whether or not the
     * associated jar file is signed.
     *
     * @return {@code true} if the JAR is signed, {@code false}
     *         otherwise.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.402 -0500", hash_original_method = "61D9EDAFD8C0E1537C8EF2C7E942A904", hash_generated_method = "61D9EDAFD8C0E1537C8EF2C7E942A904")
    
boolean isSignedJar() {
        return certificates.size() > 0;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.406 -0500", hash_original_method = "C1D665F8901BA184CF5172955B73AB34", hash_generated_method = "B6619677E7320A9972188585FDF7BA18")
    
private boolean verify(Attributes attributes, String entry, byte[] data,
            int start, int end, boolean ignoreSecondEndline, boolean ignorable) {
        String algorithms = attributes.getValue("Digest-Algorithms");
        if (algorithms == null) {
            algorithms = "SHA SHA1";
        }
        StringTokenizer tokens = new StringTokenizer(algorithms);
        while (tokens.hasMoreTokens()) {
            String algorithm = tokens.nextToken();
            String hash = attributes.getValue(algorithm + entry);
            if (hash == null) {
                continue;
            }

            MessageDigest md;
            try {
                md = MessageDigest.getInstance(algorithm);
            } catch (NoSuchAlgorithmException e) {
                continue;
            }
            if (ignoreSecondEndline && data[end - 1] == '\n'
                    && data[end - 2] == '\n') {
                md.update(data, start, end - 1 - start);
            } else {
                md.update(data, start, end - start);
            }
            byte[] b = md.digest();
            byte[] hashBytes = hash.getBytes(Charsets.ISO_8859_1);
            return MessageDigest.isEqual(b, Base64.decode(hashBytes));
        }
        return ignorable;
    }

    /**
     * Returns all of the {@link java.security.cert.Certificate} instances that
     * were used to verify the signature on the JAR entry called
     * {@code name}.
     *
     * @param name
     *            the name of a JAR entry.
     * @return an array of {@link java.security.cert.Certificate}.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.408 -0500", hash_original_method = "4AB9D8996D4C7F856FC4CD4DD096303E", hash_generated_method = "4AB9D8996D4C7F856FC4CD4DD096303E")
    
Certificate[] getCertificates(String name) {
        Certificate[] verifiedCerts = verifiedEntries.get(name);
        if (verifiedCerts == null) {
            return null;
        }
        return verifiedCerts.clone();
    }

    /**
     * Remove all entries from the internal collection of data held about each
     * JAR entry in the {@code META-INF} directory.
     *
     * @see #addMetaEntry(String, byte[])
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.411 -0500", hash_original_method = "98B5FDE1FF609AB4DAC6F710E4FAE37E", hash_generated_method = "98B5FDE1FF609AB4DAC6F710E4FAE37E")
    
void removeMetaEntries() {
        metaEntries = null;
    }
    
    class VerifierEntry extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.357 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.359 -0500", hash_original_field = "6490B74EBA547C3BEF2402BDE5E0FF43", hash_generated_field = "145A8FD0EC1911E7DDCA25F923899831")

        private MessageDigest digest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.361 -0500", hash_original_field = "6195FCC77BFDBC9D95F3A31F9C19748F", hash_generated_field = "670F24B05EDED2247F0B4CD66AB4EE15")

        private byte[] hash;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.363 -0500", hash_original_field = "DACE6ADA4B412D57FB31B18C159744DA", hash_generated_field = "6029E7C21A5106D4483252478B646415")

        private Certificate[] certificates;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.367 -0500", hash_original_method = "519B899FEA5DD6CF74252B8A7E9BDF9B", hash_generated_method = "519B899FEA5DD6CF74252B8A7E9BDF9B")
        
VerifierEntry(String name, MessageDigest digest, byte[] hash,
                Certificate[] certificates) {
            this.name = name;
            this.digest = digest;
            this.hash = hash;
            this.certificates = certificates;
        }

        /**
         * Updates a digest with one byte.
         */
        @DSSpec(DSCat.IO)
        @DSSink({DSSinkKind.IO})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.369 -0500", hash_original_method = "977E904E5666EA1924971461B3999364", hash_generated_method = "30B825BE9CB2E300173C549DFAB6AC4A")
        
@Override
        public void write(int value) {
            digest.update((byte) value);
        }

        /**
         * Updates a digest with byte array.
         */
        @DSSpec(DSCat.IO)
        @DSSink({DSSinkKind.IO})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.372 -0500", hash_original_method = "8BB7D0A84FCC70584CF33970C6F95BDA", hash_generated_method = "49397E41D8BCC7E685ABB904DB99146B")
        
@Override
        public void write(byte[] buf, int off, int nbytes) {
            digest.update(buf, off, nbytes);
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.210 -0400", hash_original_method = "E514DAB8C6AF0A1EE37FB72F5B8B9108", hash_generated_method = "5C4BD9472CDE665A3B734979B8A321D7")
         void verify() {
            byte[] d = digest.digest();
    if(!MessageDigest.isEqual(d, Base64.decode(hash)))            
            {
                SecurityException var9EEA0942EA74388A1F03C5B5C555D6C5_1241829624 = invalidDigest(JarFile.MANIFEST_NAME, name, jarName);
                var9EEA0942EA74388A1F03C5B5C555D6C5_1241829624.addTaint(getTaint());
                throw var9EEA0942EA74388A1F03C5B5C555D6C5_1241829624;
            } //End block
            verifiedEntries.put(name, certificates);
            // ---------- Original Method ----------
            //byte[] d = digest.digest();
            //if (!MessageDigest.isEqual(d, Base64.decode(hash))) {
                //throw invalidDigest(JarFile.MANIFEST_NAME, name, jarName);
            //}
            //verifiedEntries.put(name, certificates);
        }
        
    }
    
}

