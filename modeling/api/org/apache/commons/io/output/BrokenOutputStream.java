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
import java.io.IOException;
import java.io.OutputStream;

/**
 * Broken output stream. This stream always throws an {@link IOException} from
 * all {@link OutputStream} methods.
 * <p>
 * This class is mostly useful for testing error handling in code that uses an
 * output stream.
 *
 * @since 2.0
 */
public class BrokenOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.071 -0400", hash_original_field = "3698232F8CADC9B01721C03A953BF68B", hash_generated_field = "0AF882C2A99BE536634D8324F0026FC7")

    private  IOException exception;

    /**
     * Creates a new stream that always throws the given exception.
     *
     * @param exception the exception to be thrown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.071 -0400", hash_original_method = "DC14AD217499C73BF2ED5ED6A0A09FC7", hash_generated_method = "5FBCC34012703571EF05BA1C10A544CC")
    
public BrokenOutputStream(IOException exception) {
        this.exception = exception;
    }

    /**
     * Creates a new stream that always throws an {@link IOException}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.072 -0400", hash_original_method = "59CC42DFD0763C2AECC76B7A8477456C", hash_generated_method = "EDDAC093FDA9857FDF36CBC90D4E3F2A")
    
public BrokenOutputStream() {
        this(new IOException("Broken output stream"));
    }

    /**
     * Throws the configured exception.
     *
     * @param b ignored
     * @throws IOException always thrown
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.072 -0400", hash_original_method = "AF68FB9108929D9CC8AF2DAD857DF91D", hash_generated_method = "03F18DCDF3636CF439F76D81DC2B5009")
    
@Override
    public void write(int b) throws IOException {
        throw exception;
    }

    /**
     * Throws the configured exception.
     *
     * @throws IOException always thrown
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.073 -0400", hash_original_method = "2F30F2D964E96D4253E7019EBAE48140", hash_generated_method = "CB61CA2DDDC7A56278D519175D793B1A")
    
@Override
    public void flush() throws IOException {
        throw exception;
    }

    /**
     * Throws the configured exception.
     *
     * @throws IOException always thrown
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.073 -0400", hash_original_method = "CEF9D34BF3086FDA40BC370A70DF5AD2", hash_generated_method = "D60384CEF658CF51488D146FB7DCDC10")
    
@Override
    public void close() throws IOException {
        throw exception;
    }

}
