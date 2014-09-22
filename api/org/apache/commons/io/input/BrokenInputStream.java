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

/**
 * Broken input stream. This stream always throws an {@link IOException} from
 * all the {@link InputStream} methods where the exception is declared.
 * <p>
 * This class is mostly useful for testing error handling in code that uses an
 * input stream.
 *
 * @since 2.0
 */
public class BrokenInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.408 -0400", hash_original_field = "3698232F8CADC9B01721C03A953BF68B", hash_generated_field = "0AF882C2A99BE536634D8324F0026FC7")

    private  IOException exception;

    /**
     * Creates a new stream that always throws the given exception.
     *
     * @param exception the exception to be thrown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.409 -0400", hash_original_method = "25F9B147A640764BAD5A91174402EA28", hash_generated_method = "062CE63D0620D144CC8FD8F749FB80E0")
    
public BrokenInputStream(IOException exception) {
        this.exception = exception;
    }

    /**
     * Creates a new stream that always throws an {@link IOException}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.409 -0400", hash_original_method = "007AAB59B3A8E9E189A528ECE8101DA6", hash_generated_method = "914C795571E6510DCA8F83D89D261165")
    
public BrokenInputStream() {
        this(new IOException("Broken input stream"));
    }

    /**
     * Throws the configured exception.
     *
     * @return nothing
     * @throws IOException always thrown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.410 -0400", hash_original_method = "28F9C38B3FDDDB64FC933645C8F9DFA7", hash_generated_method = "95FB0FA2E255263777CDDE8CFD8D14B4")
    
@Override
    public int read() throws IOException {
        throw exception;
    }

    /**
     * Throws the configured exception.
     *
     * @return nothing
     * @throws IOException always thrown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.410 -0400", hash_original_method = "F031365D6E829A45B7583B6D22A26F0A", hash_generated_method = "28DDBA1338EE51F6D648E2EE894551B2")
    
@Override
    public int available() throws IOException {
        throw exception;
    }

    /**
     * Throws the configured exception.
     *
     * @param n ignored
     * @return nothing
     * @throws IOException always thrown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.411 -0400", hash_original_method = "CAAF4DC59EF8C31987E09418AE767741", hash_generated_method = "783EC516262EA72A86DBF4C974A1E3E1")
    
@Override
    public long skip(long n) throws IOException {
        throw exception;
    }

    /**
     * Throws the configured exception.
     *
     * @throws IOException always thrown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.411 -0400", hash_original_method = "0FA8319FDCFD8207BDB70BAA26E790B7", hash_generated_method = "2CBCE6CB58AC78636EEDF9153F9EFD5A")
    
@Override
    public void reset() throws IOException {
        throw exception;
    }

    /**
     * Throws the configured exception.
     *
     * @throws IOException always thrown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.412 -0400", hash_original_method = "CEF9D34BF3086FDA40BC370A70DF5AD2", hash_generated_method = "D60384CEF658CF51488D146FB7DCDC10")
    
@Override
    public void close() throws IOException {
        throw exception;
    }

}
