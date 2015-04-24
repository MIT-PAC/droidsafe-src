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


package org.apache.commons.io.output;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Writer;

/**
 * This {@link Writer} writes all data to the famous <b>/dev/null</b>.
 * <p>
 * This <code>Writer</code> has no destination (file/socket etc.) and all
 * characters written to it are ignored and lost.
 * 
 * @version $Id: NullWriter.java 1304052 2012-03-22 20:55:29Z ggregory $
 */
public class NullWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.241 -0400", hash_original_field = "CD8DF839D5F85A736751CAEC6BDBC034", hash_generated_field = "7307ED88D0E2B587CEECC7DE309D3B8E")

    public static final NullWriter NULL_WRITER = new NullWriter();

    /**
     * Constructs a new NullWriter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.241 -0400", hash_original_method = "354338F8D39FF6509677FF2A4C707E5F", hash_generated_method = "7D2535B6C55EA233FAA41D561AE981CE")
    
public NullWriter() {
    }

    /**
     * Does nothing - output to <code>/dev/null</code>.
     * @param c The character to write
     * @return this writer
     * @since 2.0
     */
    
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.242 -0400", hash_original_method = "9925E1DC093C6BADDE8464868171339B", hash_generated_method = "AEE3041B3F1AA0AE8E9154005C96D456")
    
@Override
    public Writer append(char c) {
        //to /dev/null
        return this;
    }

    /**
     * Does nothing - output to <code>/dev/null</code>.
     * @param csq The character sequence to write
     * @param start The index of the first character to write
     * @param end  The index of the first character to write (exclusive)
     * @return this writer
     * @since 2.0
     */
    
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.242 -0400", hash_original_method = "CD2829CDE96B6ED8A5F4CBF7F6F67CA5", hash_generated_method = "1AD03001AC524799F2E5DDE5E1DA5EF9")
    
@Override
    public Writer append(CharSequence csq, int start, int end) {
        //to /dev/null
        return this;
    }

    /**
     * Does nothing - output to <code>/dev/null</code>.
     * @param csq The character sequence to write
     * @return this writer
     * @since 2.0
     */
    
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.243 -0400", hash_original_method = "FE294A17C0469E68DE350D9B87B2A84C", hash_generated_method = "C337B5C193C54642D937100F617F21D7")
    
@Override
    public Writer append(CharSequence csq) {
        //to /dev/null
        return this;
    }

    /**
     * Does nothing - output to <code>/dev/null</code>.
     * @param idx The character to write
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.244 -0400", hash_original_method = "CB9AED790CD954117728F46FA7B99DE8", hash_generated_method = "1CAD9F4FE78AF83D20A13E25CDD749E0")
    
@Override
    public void write(int idx) {
        //to /dev/null
    }

    /**
     * Does nothing - output to <code>/dev/null</code>.
     * @param chr The characters to write
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.244 -0400", hash_original_method = "223F529506D3BF44A149C901A5D55A6B", hash_generated_method = "3426744C62A1AFB93B06E3E44C1DDB13")
    
@Override
    public void write(char[] chr) {
        //to /dev/null
    }

    /**
     * Does nothing - output to <code>/dev/null</code>.
     * @param chr The characters to write
     * @param st The start offset
     * @param end The number of characters to write
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.245 -0400", hash_original_method = "1256300F7D5F2E3F918226B727F42637", hash_generated_method = "051CDF96773B7FF35F11CE6F2403199C")
    
@Override
    public void write(char[] chr, int st, int end) {
        //to /dev/null
    }

    /**
     * Does nothing - output to <code>/dev/null</code>.
     * @param str The string to write
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.245 -0400", hash_original_method = "44D5CA24014EE7A19866ABFBD1E3495E", hash_generated_method = "6E79CA034362D8596520798E17C51E5E")
    
@Override
    public void write(String str) {
        //to /dev/null
    }

    /**
     * Does nothing - output to <code>/dev/null</code>.
     * @param str The string to write
     * @param st The start offset
     * @param end The number of characters to write
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.246 -0400", hash_original_method = "24E1254AF0599ABF4B37852E6EA59286", hash_generated_method = "0933108527968DB340F07BAB59466C01")
    
@Override
    public void write(String str, int st, int end) {
        //to /dev/null
    }

    /** @see java.io.Writer#flush() */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.246 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "EA3016CC08DF8AEAE3A0AF31E6D4BFC8")
    
@Override
    public void flush() {
        //to /dev/null
    }

    /** @see java.io.Writer#close() */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.247 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "2C28E8C9BD92CC4643932192BBF95A64")
    
@Override
    public void close() {
        //to /dev/null
    }

}
