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
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.Charsets;
import java.nio.charset.CoderResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import libcore.io.Streams;

public class Manifest implements Cloneable {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.163 -0500", hash_original_method = "54A9C882DCF00408D3A492AAABB65302", hash_generated_method = "4120E28E793559951DD415810AFAABC0")
    
private static Field getByteArrayInputStreamField(String name) {
        try {
            Field f = ByteArrayInputStream.class.getDeclaredField(name);
            f.setAccessible(true);
            return f;
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    /**
     * Returns a byte[] containing all the bytes from a ByteArrayInputStream.
     * Where possible, this returns the actual array rather than a copy.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.215 -0500", hash_original_method = "2E7B60C359CF2BD0792E359FF0052325", hash_generated_method = "4574E71359566A1BDF8A7837EF55FE2A")
    
private static byte[] exposeByteArrayInputStreamBytes(ByteArrayInputStream bais) {
        byte[] buffer;
        synchronized (bais) {
            byte[] buf;
            int pos;
            try {
                buf = (byte[]) BAIS_BUF.get(bais);
                pos = BAIS_POS.getInt(bais);
            } catch (IllegalAccessException iae) {
                throw new AssertionError(iae);
            }
            int available = bais.available();
            if (pos == 0 && buf.length == available) {
                buffer = buf;
            } else {
                buffer = new byte[available];
                System.arraycopy(buf, pos, buffer, 0, available);
            }
            bais.skip(available);
        }
        return buffer;
    }

    /**
     * Writes out the attribute information of the specified manifest to the
     * specified {@code OutputStream}
     *
     * @param manifest
     *            the manifest to write out.
     * @param out
     *            The {@code OutputStream} to write to.
     * @throws IOException
     *             If an error occurs writing the {@code Manifest}.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.230 -0500", hash_original_method = "364FA78950C637E356994D1026A925C2", hash_generated_method = "0EE1D0450F252260DB5C7949D54F5970")
    
static void write(Manifest manifest, OutputStream out) throws IOException {
        CharsetEncoder encoder = Charsets.UTF_8.newEncoder();
        ByteBuffer buffer = ByteBuffer.allocate(LINE_LENGTH_LIMIT);

        String version = manifest.mainAttributes.getValue(Attributes.Name.MANIFEST_VERSION);
        if (version != null) {
            writeEntry(out, Attributes.Name.MANIFEST_VERSION, version, encoder, buffer);
            Iterator<?> entries = manifest.mainAttributes.keySet().iterator();
            while (entries.hasNext()) {
                Attributes.Name name = (Attributes.Name) entries.next();
                if (!name.equals(Attributes.Name.MANIFEST_VERSION)) {
                    writeEntry(out, name, manifest.mainAttributes.getValue(name), encoder, buffer);
                }
            }
        }
        out.write(LINE_SEPARATOR);
        Iterator<String> i = manifest.getEntries().keySet().iterator();
        while (i.hasNext()) {
            String key = i.next();
            writeEntry(out, NAME_ATTRIBUTE, key, encoder, buffer);
            Attributes attrib = manifest.entries.get(key);
            Iterator<?> entries = attrib.keySet().iterator();
            while (entries.hasNext()) {
                Attributes.Name name = (Attributes.Name) entries.next();
                writeEntry(out, name, attrib.getValue(name), encoder, buffer);
            }
            out.write(LINE_SEPARATOR);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.233 -0500", hash_original_method = "91A1237435E0826AC7F08CD4C51C942A", hash_generated_method = "C07BDDD76C2E3BC73A743964855535EC")
    
private static void writeEntry(OutputStream os, Attributes.Name name,
            String value, CharsetEncoder encoder, ByteBuffer bBuf) throws IOException {
        String nameString = name.getName();
        os.write(nameString.getBytes(Charsets.US_ASCII));
        os.write(VALUE_SEPARATOR);

        encoder.reset();
        bBuf.clear().limit(LINE_LENGTH_LIMIT - nameString.length() - 2);

        CharBuffer cBuf = CharBuffer.wrap(value);

        while (true) {
            CoderResult r = encoder.encode(cBuf, bBuf, true);
            if (CoderResult.UNDERFLOW == r) {
                r = encoder.flush(bBuf);
            }
            os.write(bBuf.array(), bBuf.arrayOffset(), bBuf.position());
            os.write(LINE_SEPARATOR);
            if (CoderResult.UNDERFLOW == r) {
                break;
            }
            os.write(' ');
            bBuf.clear().limit(LINE_LENGTH_LIMIT - 1);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.148 -0500", hash_original_field = "DF18037A76D43ED78E052DE44F22E3DC", hash_generated_field = "4AAD2B66AAA9D2F0328C62F34531C5E8")

    static final int LINE_LENGTH_LIMIT = 72;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.150 -0500", hash_original_field = "936EBCAA8797754AB37FA01259CA942D", hash_generated_field = "B67A073FAA2504AFA1E673A3A73B5070")

    private static final byte[] LINE_SEPARATOR = new byte[] { '\r', '\n' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.153 -0500", hash_original_field = "3C43E5647122EC9A10FEF7482CB2F448", hash_generated_field = "9343CBDAF9029B97005DD375E4D0C015")

    private static final byte[] VALUE_SEPARATOR = new byte[] { ':', ' ' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.156 -0500", hash_original_field = "5FACB4059AD65A056B74822D539CF3AF", hash_generated_field = "D9224D7DE651E7F79EB2339E3FD0F906")

    private static final Attributes.Name NAME_ATTRIBUTE = new Attributes.Name("Name");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.158 -0500", hash_original_field = "226FD86BA5C88B4CAAEBFF6E975EEA95", hash_generated_field = "1A0ED102D992A4F1419CAAB83C42E3A5")

    private static final Field BAIS_BUF = getByteArrayInputStreamField("buf");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.161 -0500", hash_original_field = "B171DDAE84E1B6E4AAA7C064DC536CF4", hash_generated_field = "BAEA4D286068745E7FCE0DB863E317C3")

    private static final Field BAIS_POS = getByteArrayInputStreamField("pos");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.166 -0500", hash_original_field = "BF1FA796499D694280535B3461BEAE17", hash_generated_field = "E1BDEFB6141BA3D4A18686A70FD48EA7")

    private Attributes mainAttributes = new Attributes();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.168 -0500", hash_original_field = "4225BF2361B516F4138B6A1683A4E835", hash_generated_field = "8F8C40B44CE5717105C1E59BBDAB375B")

    private HashMap<String, Attributes> entries = new HashMap<String, Attributes>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.181 -0500", hash_original_field = "05DACC5ADEF9675F91BE32207558BC6C", hash_generated_field = "786638D71EF24F3687C38482B297CD1D")

    private HashMap<String, Chunk> chunks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.183 -0500", hash_original_field = "DF1FB7A6CE7B100076873B590ECCEE22", hash_generated_field = "DCB6AE1819FDCE75D830612AD5F2AE24")

    private int mainEnd;

    /**
     * Creates a new {@code Manifest} instance.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.185 -0500", hash_original_method = "2CD70F0E3E6560EF53C780EFAB38343C", hash_generated_method = "FA299F001C1CEF4E33B989DA3F830661")
    
public Manifest() {
    }

    /**
     * Creates a new {@code Manifest} instance using the attributes obtained
     * from the input stream.
     *
     * @param is
     *            {@code InputStream} to parse for attributes.
     * @throws IOException
     *             if an IO error occurs while creating this {@code Manifest}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.188 -0500", hash_original_method = "2FA11E9347D2AC2716E0BA224CCFCCB5", hash_generated_method = "9A25B819BAB3FF5FC8622EBB8C328465")
    
public Manifest(InputStream is) throws IOException {
        read(is);
    }

    /**
     * Creates a new {@code Manifest} instance. The new instance will have the
     * same attributes as those found in the parameter {@code Manifest}.
     *
     * @param man
     *            {@code Manifest} instance to obtain attributes from.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.191 -0500", hash_original_method = "0E23B3A5115DCECDE6F46702BE2E2DEF", hash_generated_method = "81428566859418F3DB0717074B4043AC")
    
@SuppressWarnings("unchecked")
    public Manifest(Manifest man) {
        mainAttributes = (Attributes) man.mainAttributes.clone();
        entries = (HashMap<String, Attributes>) ((HashMap<String, Attributes>) man
                .getEntries()).clone();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.194 -0500", hash_original_method = "19FA98C36DB13DC48F6FA00606FD5E9E", hash_generated_method = "19FA98C36DB13DC48F6FA00606FD5E9E")
    
Manifest(InputStream is, boolean readChunks) throws IOException {
        if (readChunks) {
            chunks = new HashMap<String, Chunk>();
        }
        read(is);
    }

    /**
     * Resets the both the main attributes as well as the entry attributes
     * associated with this {@code Manifest}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.197 -0500", hash_original_method = "C6A465A281EC0C52F4CC8FABE5DA0F03", hash_generated_method = "C565984F1E5FA363FB6CB1D16E527D1F")
    
public void clear() {
        entries.clear();
        mainAttributes.clear();
    }

    /**
     * Returns the {@code Attributes} associated with the parameter entry
     * {@code name}.
     *
     * @param name
     *            the name of the entry to obtain {@code Attributes} from.
     * @return the Attributes for the entry or {@code null} if the entry does
     *         not exist.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.199 -0500", hash_original_method = "78C1F2A094121E0A509E66806BC04C36", hash_generated_method = "E4DE14DB9621A9D657B46207A017F464")
    
public Attributes getAttributes(String name) {
        return getEntries().get(name);
    }

    /**
     * Returns a map containing the {@code Attributes} for each entry in the
     * {@code Manifest}.
     *
     * @return the map of entry attributes.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.201 -0500", hash_original_method = "AD5E8B028D2F33E921C50CB4C1BDCE39", hash_generated_method = "E1F6C9A8CB2009128564CD77B4042B46")
    
public Map<String, Attributes> getEntries() {
        return entries;
    }

    /**
     * Returns the main {@code Attributes} of the {@code JarFile}.
     *
     * @return main {@code Attributes} associated with the source {@code
     *         JarFile}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.204 -0500", hash_original_method = "E50165B574B80B3A6D479CE79F6197B1", hash_generated_method = "C4BF8381294FCDC1FAB64ADD93A2235A")
    
public Attributes getMainAttributes() {
        return mainAttributes;
    }

    /**
     * Creates a copy of this {@code Manifest}. The returned {@code Manifest}
     * will equal the {@code Manifest} from which it was cloned.
     *
     * @return a copy of this instance.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.207 -0500", hash_original_method = "ED40FF59379F92DE3112CA6576AF5963", hash_generated_method = "E3BB8358407282EFD983BCE228CEEF97")
    
@Override
    public Object clone() {
        return new Manifest(this);
    }

    /**
     * Writes out the attribute information of the receiver to the specified
     * {@code OutputStream}.
     *
     * @param os
     *            The {@code OutputStream} to write to.
     * @throws IOException
     *             If an error occurs writing the {@code Manifest}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.209 -0500", hash_original_method = "FE58047C3F32AF11D7E00269EA71B148", hash_generated_method = "AABA4DD623EA31BA083B1F1BF032742E")
    
public void write(OutputStream os) throws IOException {
        write(this, os);
    }
    
    static class Chunk {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.171 -0500", hash_original_field = "A420862623A673AB42FCEC90A616158F", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.173 -0500", hash_original_field = "302E5A3147803830441A79AED31F4022", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.177 -0500", hash_original_method = "A8971FBD893650A54F56F7BF8B0891D6", hash_generated_method = "A8971FBD893650A54F56F7BF8B0891D6")
        
Chunk(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
    }

    /**
     * Merges name/attribute pairs read from the input stream {@code is} into this manifest.
     *
     * @param is
     *            The {@code InputStream} to read from.
     * @throws IOException
     *             If an error occurs reading the manifest.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.212 -0500", hash_original_method = "0BB09A51480801FE7389A84744CD3AA5", hash_generated_method = "7E45CD401B5948D65B6801FA87756624")
    
public void read(InputStream is) throws IOException {
        byte[] buf;
        if (is instanceof ByteArrayInputStream) {
            buf = exposeByteArrayInputStreamBytes((ByteArrayInputStream) is);
        } else {
            buf = Streams.readFullyNoClose(is);
        }

        if (buf.length == 0) {
            return;
        }

        // a workaround for HARMONY-5662
        // replace EOF and NUL with another new line
        // which does not trigger an error
        byte b = buf[buf.length - 1];
        if (b == 0 || b == 26) {
            buf[buf.length - 1] = '\n';
        }

        // Attributes.Name.MANIFEST_VERSION is not used for
        // the second parameter for RI compatibility
        InitManifest im = new InitManifest(buf, mainAttributes, null);
        mainEnd = im.getPos();
        im.initEntries(entries, chunks);
    }

    /**
     * Returns the hash code for this instance.
     *
     * @return this {@code Manifest}'s hashCode.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.218 -0500", hash_original_method = "208E1F4DBC48E80FE528AF7E25427460", hash_generated_method = "212D4C2D6B93DB0C152383C6F1E0A9BC")
    
@Override
    public int hashCode() {
        return mainAttributes.hashCode() ^ getEntries().hashCode();
    }

    /**
     * Determines if the receiver is equal to the parameter object. Two {@code
     * Manifest}s are equal if they have identical main attributes as well as
     * identical entry attributes.
     *
     * @param o
     *            the object to compare against.
     * @return {@code true} if the manifests are equal, {@code false} otherwise
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.221 -0500", hash_original_method = "7BEE688CCC8D49794388E10DAC06F788", hash_generated_method = "4AECF5328B37B143D324B7D18EC4DC0A")
    
@Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        if (!mainAttributes.equals(((Manifest) o).mainAttributes)) {
            return false;
        }
        return getEntries().equals(((Manifest) o).getEntries());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.223 -0500", hash_original_method = "5810BB520240B1A3498784B2D92EABA8", hash_generated_method = "5810BB520240B1A3498784B2D92EABA8")
    
Chunk getChunk(String name) {
        return chunks.get(name);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.225 -0500", hash_original_method = "CB43854902C5BB6A2160DF9CF6991C4E", hash_generated_method = "CB43854902C5BB6A2160DF9CF6991C4E")
    
void removeChunks() {
        chunks = null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:58.227 -0500", hash_original_method = "4F9436521007A1D33F6CF267D74BE295", hash_generated_method = "4F9436521007A1D33F6CF267D74BE295")
    
int getMainAttributesEnd() {
        return mainEnd;
    }
}

