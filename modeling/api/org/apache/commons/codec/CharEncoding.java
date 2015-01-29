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

package org.apache.commons.codec;

/**
 * Character encoding names required of every implementation of the Java platform.
 *
 * From the Java documentation <a
 * href="http://download.oracle.com/javase/6/docs/api/java/nio/charset/Charset.html">Standard charsets</a>:
 * <p>
 * <cite>Every implementation of the Java platform is required to support the following character encodings. Consult the
 * release documentation for your implementation to see if any other encodings are supported. Consult the release
 * documentation for your implementation to see if any other encodings are supported.</cite>
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
 * This perhaps would best belong in the [lang] project. Even if a similar interface is defined in [lang], it is not
 * foreseen that [codec] would be made to depend on [lang].
 *
 * <p>
 * This class is immutable and thread-safe.
 * </p>
 *
 * @see <a href="http://download.oracle.com/javase/6/docs/api/java/nio/charset/Charset.html">Standard charsets</a>
 * @since 1.4
 * @version $Id: CharEncoding.java 1379049 2012-08-30 18:35:22Z tn $
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class CharEncoding {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:43:30.300 -0500", hash_original_field = "9B4241CF8375027A3760457C90F1C043", hash_generated_field = "C54DD200E0A99AF152F5F6AA68726A31")

    public static final String ISO_8859_1 = "ISO-8859-1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:43:30.314 -0500", hash_original_field = "4BA4D73EFE3E4386F492E6E345E19D10", hash_generated_field = "6E4160004BBA062156F08F5FA5E24E91")

    public static final String US_ASCII = "US-ASCII";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:43:30.325 -0500", hash_original_field = "F937D08544423510C929202A06C5E40C", hash_generated_field = "37AEDC72537277B8C7D6E458F0C0A8AC")

    public static final String UTF_16 = "UTF-16";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:43:30.335 -0500", hash_original_field = "7A664CEB53B0C4FA8E002B6DB4DF105A", hash_generated_field = "1D1A269F15639FCAA11A4A1336A31B64")

    public static final String UTF_16BE = "UTF-16BE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:43:30.344 -0500", hash_original_field = "6CC197384106D30E9A24D6D1F6B0E309", hash_generated_field = "2B5F0BA738700C69A43D629817B22DC5")

    public static final String UTF_16LE = "UTF-16LE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:43:30.374 -0500", hash_original_field = "4C869B13BEF7E7EB87393F929DAAEF08", hash_generated_field = "059F3081BD79133B19DA92D71B903D4B")

    public static final String UTF_8 = "UTF-8";
}
