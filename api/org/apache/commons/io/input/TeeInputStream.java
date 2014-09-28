/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * InputStream proxy that transparently writes a copy of all bytes read
 * from the proxied stream to a given OutputStream. Using {@link #skip(long)}
 * or {@link #mark(int)}/{@link #reset()} on the stream will result on some
 * bytes from the input stream being skipped or duplicated in the output
 * stream.
 * <p>
 * The proxied input stream is closed when the {@link #close()} method is
 * called on this proxy. It is configurable whether the associated output
 * stream will also closed.
 *
 * @version $Id: TeeInputStream.java 1307461 2012-03-30 15:12:29Z ggregory $
 * @since 1.4
 */
public class TeeInputStream extends ProxyInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.292 -0400", hash_original_field = "5D7CE1B829DF3967F3AC761648D2A2A6", hash_generated_field = "164ADC33B65EBBC2FB8F6BCF766DF944")

    private  OutputStream branch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.293 -0400", hash_original_field = "D15B3EEF3194E3D2FDFDA7038C84F522", hash_generated_field = "5364FDC39A5D908CFAA7DC7A7FAE9382")

    private  boolean closeBranch;

    /**
     * Creates a TeeInputStream that proxies the given {@link InputStream}
     * and copies all read bytes to the given {@link OutputStream}. The given
     * output stream will not be closed when this stream gets closed.
     *
     * @param input input stream to be proxied
     * @param branch output stream that will receive a copy of all bytes read
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.293 -0400", hash_original_method = "DAFFFEC0A2F1C3FC2568CE035A699270", hash_generated_method = "18739B479E033E643AE1044C85A2CEA8")
    
public TeeInputStream(InputStream input, OutputStream branch) {
        this(input, branch, false);
    }

    /**
     * Creates a TeeInputStream that proxies the given {@link InputStream}
     * and copies all read bytes to the given {@link OutputStream}. The given
     * output stream will be closed when this stream gets closed if the
     * closeBranch parameter is {@code true}.
     *
     * @param input input stream to be proxied
     * @param branch output stream that will receive a copy of all bytes read
     * @param closeBranch flag for closing also the output stream when this
     *                    stream is closed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.294 -0400", hash_original_method = "D520336E920C0FCB03E0DA6241BF85F5", hash_generated_method = "054D9D4A12D21748DDCF7C2BD1EF6EA6")
    
public TeeInputStream(
            InputStream input, OutputStream branch, boolean closeBranch) {
        super(input);
        this.branch = branch;
        this.closeBranch = closeBranch;
    }

    /**
     * Closes the proxied input stream and, if so configured, the associated
     * output stream. An exception thrown from one stream will not prevent
     * closing of the other stream.
     *
     * @throws IOException if either of the streams could not be closed
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.295 -0400", hash_original_method = "D498A8731A99C06BAF1ACCF96CD0CEC8", hash_generated_method = "F7FEBC11CE3CAC9F2CCA27EA48D5CCF7")
    
@Override
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            if (closeBranch) {
                branch.close();
            }
        }
    }

    /**
     * Reads a single byte from the proxied input stream and writes it to
     * the associated output stream.
     *
     * @return next byte from the stream, or -1 if the stream has ended
     * @throws IOException if the stream could not be read (or written) 
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.295 -0400", hash_original_method = "CF82A12C742F079DEF5ED86F8D9B664D", hash_generated_method = "58CCA48C853B9EC1EB3F4E21DCA79EEB")
    
@Override
    public int read() throws IOException {
        int ch = super.read();
        if (ch != -1) {
            branch.write(ch);
        }
        return ch;
    }

    /**
     * Reads bytes from the proxied input stream and writes the read bytes
     * to the associated output stream.
     *
     * @param bts byte buffer
     * @param st start offset within the buffer
     * @param end maximum number of bytes to read
     * @return number of bytes read, or -1 if the stream has ended
     * @throws IOException if the stream could not be read (or written) 
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.296 -0400", hash_original_method = "BF6CBA9653E90970E99199ACD6FE8DC4", hash_generated_method = "9BC968F9B86D1828A5DF1E63F8C520FC")
    
@Override
    public int read(byte[] bts, int st, int end) throws IOException {
        int n = super.read(bts, st, end);
        if (n != -1) {
            branch.write(bts, st, n);
        }
        return n;
    }

    /**
     * Reads bytes from the proxied input stream and writes the read bytes
     * to the associated output stream.
     *
     * @param bts byte buffer
     * @return number of bytes read, or -1 if the stream has ended
     * @throws IOException if the stream could not be read (or written) 
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.296 -0400", hash_original_method = "C8E3227EF2C47EB9F6C9D577624742C0", hash_generated_method = "2E0E9BB3CA72F5B6E3CF252481EBC1CA")
    
@Override
    public int read(byte[] bts) throws IOException {
        int n = super.read(bts);
        if (n != -1) {
            branch.write(bts, 0, n);
        }
        return n;
    }

}
