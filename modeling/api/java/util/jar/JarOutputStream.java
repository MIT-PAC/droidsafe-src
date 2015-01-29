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
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * The {@code JarOutputStream} is used to write data in the {@code JarFile}
 * format to an arbitrary output stream
 */
public class JarOutputStream extends ZipOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.805 -0400", hash_original_field = "03D210293484A458EB6D74D44F54E99C", hash_generated_field = "261709621967406C2758961F4730EA20")


    private Manifest manifest;

    /**
     * Constructs a new {@code JarOutputStream} using an output stream. The
     * content of the {@code Manifest} must match the JAR entry information
     * written subsequently to the stream.
     *
     * @param os
     *            the {@code OutputStream} to write to
     * @param manifest
     *            the {@code Manifest} to output for this JAR file.
     * @throws IOException
     *             if an error occurs creating the {@code JarOutputStream}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.806 -0400", hash_original_method = "220D39DD351B7C4F3351EFDB07DE24CD", hash_generated_method = "C1594FD710A5A9B019F121DF801B101C")
    
public JarOutputStream(OutputStream os, Manifest manifest) throws IOException {
        super(os);
        if (manifest == null) {
            throw new NullPointerException("manifest == null");
        }
        this.manifest = manifest;
        ZipEntry ze = new ZipEntry(JarFile.MANIFEST_NAME);
        putNextEntry(ze);
        this.manifest.write(this);
        closeEntry();
    }

    /**
     * Constructs a new {@code JarOutputStream} using an arbitrary output
     * stream.
     *
     * @param os
     *            the {@code OutputStream} to write to.
     * @throws IOException
     *             if an error occurs creating the {@code JarOutputStream}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.806 -0400", hash_original_method = "62D1673A8761811F365EE90ED3EB38AC", hash_generated_method = "0016E4404626833E9C2B40FA4C29A922")
    
public JarOutputStream(OutputStream os) throws IOException {
        super(os);
    }

    /**
     * Writes the specified ZIP entry to the underlying stream. The previous
     * entry is closed if it is still open.
     *
     * @param ze
     *            the {@code ZipEntry} to write to.
     * @throws IOException
     *             if an error occurs writing to the entry.
     * @see ZipEntry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.807 -0400", hash_original_method = "1DF5A4F82AD71DE648728A6F6545B094", hash_generated_method = "EB053A6377C6B19C32A3194D9A8E16A3")
    
@Override
    public void putNextEntry(ZipEntry ze) throws IOException {
        super.putNextEntry(ze);
    }
}
