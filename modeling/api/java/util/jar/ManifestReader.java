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
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Reads a JAR file manifest. The specification is here:
 * http://java.sun.com/javase/6/docs/technotes/guides/jar/jar.html
 */
class ManifestReader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.775 -0400", hash_original_field = "113F0D4B1A87EE5A009E8CEDEE50BB6C", hash_generated_field = "E85A97184410C002FC86DBCE01182815")

    // but a manifest might have thousands of entries.
    private final HashMap<String, Attributes.Name> attributeNameCache = new HashMap<String, Attributes.Name>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.775 -0400", hash_original_field = "1BA66816E162FAF59D153A5529C125D0", hash_generated_field = "2420FA44AFF7F61EDDA527DB21A01921")


    private final ByteArrayOutputStream valueBuffer = new ByteArrayOutputStream(80);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.776 -0400", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "779441B2743BF5C0505B790A17C97DE6")


    private  byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.776 -0400", hash_original_field = "6C344D42FD6C3AFE3A2C07377DBA3B06", hash_generated_field = "11DA3A866CF394AD0D0AED376806EEE4")


    private  int endOfMainSection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.776 -0400", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")


    private int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.777 -0400", hash_original_field = "B6C3F4133101E588C401E9449C3FB888", hash_generated_field = "D7569CAE48A3644A0F728A88E286B99D")


    private Attributes.Name name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.777 -0400", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")


    private String value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.777 -0400", hash_original_field = "D7F629BC0E42930C2E4F0450BDD658F7", hash_generated_field = "AC2BE617228FC59BA35299FD9389D19B")


    private int consecutiveLineBreaks = 0;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.778 -0400", hash_original_method = "8085708167F6EE1105A13D86061B35EB", hash_generated_method = "0F4F45682D622645091BFBF5ACFDE667")
    
public ManifestReader(byte[] buf, Attributes main) throws IOException {
        this.buf = buf;
        while (readHeader()) {
            main.put(name, value);
        }
        this.endOfMainSection = pos;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.778 -0400", hash_original_method = "28D8D2C4F541175032974D84259282CE", hash_generated_method = "3C7864260ED69BC68459F84E295600B2")
    
public void readEntries(Map<String, Attributes> entries, Map<String, Manifest.Chunk> chunks) throws IOException {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.779 -0400", hash_original_method = "3594B95C7FA47C13949425F40CCA0F36", hash_generated_method = "DE14046F478918A6748FB32A006DE9F9")
    
public int getEndOfMainSection() {
        return endOfMainSection;
    }

    /**
     * Read a single line from the manifest buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.779 -0400", hash_original_method = "A5E7BCD31AF83D3157F8D11FE9DEE1F1", hash_generated_method = "B0989563A2859A21237FD768866FD7A4")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.780 -0400", hash_original_method = "A829AB0234B1DD4B0B18EF04DDF749C4", hash_generated_method = "EEB036B6A2BF86C11ED64B8C470900BF")
    
private void readName() throws IOException {
        int mark = pos;

        while (pos < buf.length) {
            if (buf[pos++] != ':') {
                continue;
            }

            String nameString = new String(buf, mark, pos - mark - 1, StandardCharsets.US_ASCII);

            if (buf[pos++] != ' ') {
                throw new IOException(String.format("Invalid value for attribute '%s'", nameString));
            }

            try {
                name = attributeNameCache.get(nameString);
                if (name == null) {
                    name = new Attributes.Name(nameString);
                    attributeNameCache.put(nameString, name);
                }
            } catch (IllegalArgumentException e) {
                // new Attributes.Name() throws IllegalArgumentException but we declare IOException
                throw new IOException(e.getMessage());
            }
            return;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:56.781 -0400", hash_original_method = "AB4954217EDDEB258F15C6C92522E990", hash_generated_method = "F97E73D6EBA4405926C8191568FDC38B")
    
private void readValue() throws IOException {
        boolean lastCr = false;
        int mark = pos;
        int last = pos;
        valueBuffer.reset();
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
        // A bit frustrating that that Charset.forName will be called
        // again.
        value = valueBuffer.toString(StandardCharsets.UTF_8.name());
    }
}
