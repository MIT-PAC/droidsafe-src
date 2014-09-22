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
package org.apache.commons.io.output;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;
import java.io.Writer;

/**
 * {@link Writer} implementation that outputs to a {@link StringBuilder}.
 * <p>
 * <strong>NOTE:</strong> This implementation, as an alternative to
 * <code>java.io.StringWriter</code>, provides an <i>un-synchronized</i>
 * (i.e. for use in a single thread) implementation for better performance.
 * For safe usage with multiple {@link Thread}s then
 * <code>java.io.StringWriter</code> should be used.
 *
 * @version $Id: StringBuilderWriter.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 2.0
 */
public class StringBuilderWriter extends Writer implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.952 -0400", hash_original_field = "BE1FD3777D8E9D378A235133A8D55AD7", hash_generated_field = "D91EA2DC02C3EC2AB5BA639FC5E59C31")


    private  StringBuilder builder;

    /**
     * Construct a new {@link StringBuilder} instance with default capacity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.952 -0400", hash_original_method = "0F8886FC3E573AEC69371F58BBD3CDEF", hash_generated_method = "E5663AEFE78C72E6D9F6DB366B93BE15")
    
public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    /**
     * Construct a new {@link StringBuilder} instance with the specified capacity.
     *
     * @param capacity The initial capacity of the underlying {@link StringBuilder}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.953 -0400", hash_original_method = "7EF54AD3CF929444DD9C4F80FE3F6C6F", hash_generated_method = "6508CC2ED2DA653AA56D0D4F724F8B06")
    
public StringBuilderWriter(int capacity) {
        this.builder = new StringBuilder(capacity);
    }

    /**
     * Construct a new instance with the specified {@link StringBuilder}.
     *
     * @param builder The String builder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.953 -0400", hash_original_method = "1B264769CCFA0A0E39B7C5DD9D4CA02B", hash_generated_method = "7E04DA123A37CA8544FE787ABE724541")
    
public StringBuilderWriter(StringBuilder builder) {
        this.builder = builder != null ? builder : new StringBuilder();
    }

    /**
     * Append a single character to this Writer.
     *
     * @param value The character to append
     * @return This writer instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.954 -0400", hash_original_method = "1288124DBF43C46402FB70C838950E72", hash_generated_method = "AF1DB86BCA89272EBF3D0D2068FF9ECA")
    
@Override
    public Writer append(char value) {
        builder.append(value);
        return this;
    }

    /**
     * Append a character sequence to this Writer.
     *
     * @param value The character to append
     * @return This writer instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.954 -0400", hash_original_method = "E2F995DD283D6A0A833AF2D339D19742", hash_generated_method = "B9427F392DE55B9967A3D3DF4534BDBC")
    
@Override
    public Writer append(CharSequence value) {
        builder.append(value);
        return this;
    }

    /**
     * Append a portion of a character sequence to the {@link StringBuilder}.
     *
     * @param value The character to append
     * @param start The index of the first character
     * @param end The index of the last character + 1
     * @return This writer instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.955 -0400", hash_original_method = "FBCD01EFCECB3326031D766445C3DB2F", hash_generated_method = "DC5692522586DB5F5BE483B326F0FCF7")
    
@Override
    public Writer append(CharSequence value, int start, int end) {
        builder.append(value, start, end);
        return this;
    }

    /**
     * Closing this writer has no effect. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.955 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "4D83B8C1063FF7FA74D9E723C4611DA4")
    
@Override
    public void close() {
    }

    /**
     * Flushing this writer has no effect. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.956 -0400", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "21B764AD8B1C1E09B98A34736C8736B1")
    
@Override
    public void flush() {
    }


    /**
     * Write a String to the {@link StringBuilder}.
     * 
     * @param value The value to write
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.956 -0400", hash_original_method = "57CA96DC87E6760D66D655253DABAA82", hash_generated_method = "1E1AEEACBDAE821656E17A3D342272E3")
    
@Override
    public void write(String value) {
        if (value != null) {
            builder.append(value);
        }
    }

    /**
     * Write a portion of a character array to the {@link StringBuilder}.
     *
     * @param value The value to write
     * @param offset The index of the first character
     * @param length The number of characters to write
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.957 -0400", hash_original_method = "F2F4EE164E03551E9A5ECDB103942BDC", hash_generated_method = "1693FCC13D24C01A5D1CEE6CB0A4CC1D")
    
@Override
    public void write(char[] value, int offset, int length) {
        if (value != null) {
            builder.append(value, offset, length);
        }
    }

    /**
     * Return the underlying builder.
     *
     * @return The underlying builder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.957 -0400", hash_original_method = "0D111D6CF8966EDDBE82FC68A5093A5D", hash_generated_method = "F7CE8F2986ABC0FE4E6B2E88762090C7")
    
public StringBuilder getBuilder() {
        return builder;
    }

    /**
     * Returns {@link StringBuilder#toString()}.
     *
     * @return The contents of the String builder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.958 -0400", hash_original_method = "E91A134CF2A6965AC8B4CE2DD48C1D34", hash_generated_method = "D7F9E85DEC15BAB3E09D168F01E1AEF5")
    
@Override
    public String toString() {
        return builder.toString();
    }
}
