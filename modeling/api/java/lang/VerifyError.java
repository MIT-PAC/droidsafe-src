/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.lang;

/**
 * Thrown when the VM notices that an attempt is made to load a
 * class which does not pass the class verification phase.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class VerifyError extends LinkageError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.368 -0400", hash_original_field = "ED3F8A48FCA8E3EE99BAE226211AF405", hash_generated_field = "7370FD84249F60CB5485C72EAC6C4A74")


    private static final long serialVersionUID = 7001962396098498785L;

    /**
     * Constructs a new {@code VerifyError} that includes the current stack
     * trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.369 -0400", hash_original_method = "A00C9FC96FADEE2A62CB010A7487EBC5", hash_generated_method = "36926955E9CBBBC830E66866E60C6E4F")
    
public VerifyError() {
    }

    /**
     * Constructs a new {@code VerifyError} with the current stack trace and the
     * specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.370 -0400", hash_original_method = "18F96AFD1D2BDB2A8398DB5369F194BB", hash_generated_method = "69298F8B7D564BBA3F487328DEDBF941")
    
public VerifyError(String detailMessage) {
        super(detailMessage);
    }
}
