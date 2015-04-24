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
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * Charsets required of every implementation of the Java platform.
 * 
 * From the Java documentation <a href="http://docs.oracle.com/javase/6/docs/api/java/nio/charset/Charset.html">
 * Standard charsets</a>:
 * <p>
 * <cite>Every implementation of the Java platform is required to support the following character encodings. Consult the
 * release documentation for your implementation to see if any other encodings are supported. Consult the release
 * documentation for your implementation to see if any other encodings are supported. </cite>
 * </p>
 * 
 * <ul>
 * <li><code>US-ASCII</code><br/>
 * Seven-bit ASCII, a.k.a. ISO646-US, a.k.a. the Basic Latin block of the Unicode character set.</li>
 * <li><code>ISO-8859-1</code><br/>
 * ISO Latin Alphabet No. 1, a.k.a. ISO-LATIN-1.</li>
 * <li><code>UTF-8</code><br/>
 * Eight-bit Unicode Transformation Format.</li>
 * <li><code>UTF-16BE</code><br/>
 * Sixteen-bit Unicode Transformation Format, big-endian byte order.</li>
 * <li><code>UTF-16LE</code><br/>
 * Sixteen-bit Unicode Transformation Format, little-endian byte order.</li>
 * <li><code>UTF-16</code><br/>
 * Sixteen-bit Unicode Transformation Format, byte order specified by a mandatory initial byte-order mark (either order
 * accepted on input, big-endian used on output.)</li>
 * </ul>
 * 
 * @see <a href="http://docs.oracle.com/javase/6/docs/api/java/nio/charset/Charset.html">Standard charsets</a>
 * @since 2.3
 * @version $Id: Charsets.java 1311751 2012-04-10 14:26:21Z ggregory $
 */
public class Charsets {
    //
    // This class should only contain Charset instances for required encodings. This guarantees that it will load
    // correctly and without delay on all Java platforms.
    //

    /**
     * Returns the given Charset or the default Charset if the given Charset is null.
     * 
     * @param charset
     *            A charset or null.
     * @return the given Charset or the default Charset if the given Charset is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.644 -0400", hash_original_method = "BDEAC3261A0130C537F32DBF8B23BF4C", hash_generated_method = "862631A0B455984DC9E0554CAA320EE8")
    
public static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    /**
     * Returns a Charset for the named charset. If the name is null, return the default Charset.
     * 
     * @param charset
     *            The name of the requested charset, may be null.
     * @return a Charset for the named charset
     * @throws UnsupportedCharsetException
     *             If the named charset is unavailable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.645 -0400", hash_original_method = "CC91E58B4A98ADEB1A92B242C4B6A038", hash_generated_method = "92B052998D9F9FF76FA827B72442D898")
    
public static Charset toCharset(String charset) {
        return charset == null ? Charset.defaultCharset() : Charset.forName(charset);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.646 -0400", hash_original_field = "A22CC05BE6CEEE92799923C2424B3CA8", hash_generated_field = "8EC60A36A46A03E488D22699D2DAA981")

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.646 -0400", hash_original_field = "714C63F2B80D1D2AC8056DCAAFF2BD5B", hash_generated_field = "3E3052A707DD298E1FBE7FC8381E1B07")

    public static final Charset US_ASCII = Charset.forName("US-ASCII");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.647 -0400", hash_original_field = "0E60CC9D940F4A7BBE48ED584C7FABDF", hash_generated_field = "626EA6A3B9EE55F06343FCE9005FB573")

    public static final Charset UTF_16 = Charset.forName("UTF-16");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.647 -0400", hash_original_field = "B2A29496649FC37D8AC382D9E1ADD2FD", hash_generated_field = "2E581518D8DE46969E014F48C2B46CE9")

    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.648 -0400", hash_original_field = "1E784C699AAA1D2509B384FB2F10B837", hash_generated_field = "3BB0DD9828DA9BEC43999249AAF9452C")

    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.648 -0400", hash_original_field = "81A0A19FF2F5A038281B549B1D0CE3F5", hash_generated_field = "31164D91DD586A365881F2A00F655E8D")

    public static final Charset UTF_8 = Charset.forName("UTF-8");
}
