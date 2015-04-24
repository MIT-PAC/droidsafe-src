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
import java.io.IOException;
import java.nio.charset.Charsets;
import java.util.Map;

class InitManifest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.104 -0500", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "779441B2743BF5C0505B790A17C97DE6")

    private  byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.106 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.108 -0500", hash_original_field = "B6C3F4133101E588C401E9449C3FB888", hash_generated_field = "D7569CAE48A3644A0F728A88E286B99D")

    private Attributes.Name name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.111 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.113 -0500", hash_original_field = "9C37F6B8A8CF78814560D41B139075FB", hash_generated_field = "E3B6135907F2544C8BA6970CAAB07453")

    private final UnsafeByteSequence valueBuffer = new UnsafeByteSequence(80);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.116 -0500", hash_original_field = "D7F629BC0E42930C2E4F0450BDD658F7", hash_generated_field = "AC2BE617228FC59BA35299FD9389D19B")

    private int consecutiveLineBreaks = 0;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.119 -0500", hash_original_method = "89843BCADFC879C55233B63F5B246F2C", hash_generated_method = "DBA60F9BD722A7F975CC9357C24C9327")
    
InitManifest(byte[] buf, Attributes main, Attributes.Name ver) throws IOException {
        this.buf = buf;

        // check a version attribute
        if (!readHeader() || (ver != null && !name.equals(ver))) {
            throw new IOException("Missing version attribute: " + ver);
        }

        main.put(name, value);
        while (readHeader()) {
            main.put(name, value);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.123 -0500", hash_original_method = "CF9A667F0E0C9B5E94CE0B45251AAFAF", hash_generated_method = "B86EF89E75DC5F495793572B51D79D73")
    
void initEntries(Map<String, Attributes> entries,
            Map<String, Manifest.Chunk> chunks) throws IOException {

        int mark = pos;
        while (readHeader()) {
            if (!Attributes.Name.NAME.equals(name)) {
                throw new IOException("Entry is not named");
            }
            String entryNameValue = value;

            Attributes entry = entries.get(entryNameValue);
            if (entry == null) {
                entry = new Attributes(12);
            }

            while (readHeader()) {
                entry.put(name, value);
            }

            if (chunks != null) {
                if (chunks.get(entryNameValue) != null) {
                    // TODO A bug: there might be several verification chunks for
                    // the same name. I believe they should be used to update
                    // signature in order of appearance; there are two ways to fix
                    // this: either use a list of chunks, or decide on used
                    // signature algorithm in advance and reread the chunks while
                    // updating the signature; for now a defensive error is thrown
                    throw new IOException("A jar verifier does not support more than one entry with the same name");
                }
                chunks.put(entryNameValue, new Manifest.Chunk(mark, pos));
                mark = pos;
            }

            entries.put(entryNameValue, entry);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.125 -0500", hash_original_method = "DA9F28DCB522B20E2FDE0CD9A032935D", hash_generated_method = "DA9F28DCB522B20E2FDE0CD9A032935D")
    
int getPos() {
        return pos;
    }

    /**
     * Read a single line from the manifest buffer.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.128 -0500", hash_original_method = "A5E7BCD31AF83D3157F8D11FE9DEE1F1", hash_generated_method = "B0989563A2859A21237FD768866FD7A4")
    
private boolean readHeader() throws IOException {
        if (consecutiveLineBreaks > 1) {
            // break a section on an empty line
            consecutiveLineBreaks = 0;
            return false;
        }
        readName();
        consecutiveLineBreaks = 0;
        readValue();
        // if the last line break is missed, the line
        // is ignored by the reference implementation
        return consecutiveLineBreaks > 0;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.131 -0500", hash_original_method = "BA591702B8733A5B91A49342DCC26BF2", hash_generated_method = "B41DB55734822C9DEFD85397F22492F7")
    
private void readName() throws IOException {
        int mark = pos;

        while (pos < buf.length) {
            if (buf[pos++] != ':') {
                continue;
            }

            String name = new String(buf, mark, pos - mark - 1, Charsets.US_ASCII);

            if (buf[pos++] != ' ') {
                throw new IOException(String.format("Invalid value for attribute '%s'", name));
            }

            try {
                this.name = new Attributes.Name(name);
            } catch (IllegalArgumentException e) {
                // new Attributes.Name() throws IllegalArgumentException but we declare IOException
                throw new IOException(e.getMessage());
            }
            return;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:57.134 -0500", hash_original_method = "F963A8011A3FFB3111BBD881FC78A3FF", hash_generated_method = "F3AA5C376290FFE67575A0054CF30EB5")
    
private void readValue() throws IOException {
        boolean lastCr = false;
        int mark = pos;
        int last = pos;
        valueBuffer.rewind();
        while (pos < buf.length) {
            byte next = buf[pos++];
            switch (next) {
            case 0:
                throw new IOException("NUL character in a manifest");
            case '\n':
                if (lastCr) {
                    lastCr = false;
                } else {
                    consecutiveLineBreaks++;
                }
                continue;
            case '\r':
                lastCr = true;
                consecutiveLineBreaks++;
                continue;
            case ' ':
                if (consecutiveLineBreaks == 1) {
                    valueBuffer.write(buf, mark, last - mark);
                    mark = pos;
                    consecutiveLineBreaks = 0;
                    continue;
                }
            }

            if (consecutiveLineBreaks >= 1) {
                pos--;
                break;
            }
            last = pos;
        }

        valueBuffer.write(buf, mark, last - mark);
        value = valueBuffer.toString(Charsets.UTF_8);
    }
    
}

