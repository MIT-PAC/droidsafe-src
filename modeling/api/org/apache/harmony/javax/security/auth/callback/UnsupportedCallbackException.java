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

package org.apache.harmony.javax.security.auth.callback;

/**
 * Thrown when a {@link CallbackHandler} does not support a particular {@link
 * Callback}.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class UnsupportedCallbackException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.069 -0400", hash_original_field = "56CE38A38205544B2FE5536B145B6081", hash_generated_field = "FC86D54941A45B4F0C0B942F5184732A")


    private static final long serialVersionUID = -6873556327655666839L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.069 -0400", hash_original_field = "C574120157192C52B2CACC10319556B7", hash_generated_field = "1B1600DBF2D274518D5E0379C95B483E")


    private Callback callback;

    /**
     * Creates a new exception instance and initializes it with just the
     * unsupported {@code Callback}, but no error message.
     *
     * @param callback
     *            the {@code Callback}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.070 -0400", hash_original_method = "E0AAB39AAE15CA67F1E357019A2DB320", hash_generated_method = "1C19E4766682F03C27D017E2E088D093")
    
public UnsupportedCallbackException(Callback callback) {
        super();
        this.callback = callback;
    }

    /**
     * Creates a new exception instance and initializes it with both the
     * unsupported {@code Callback} and an error message.
     *
     * @param callback
     *            the {@code Callback}
     * @param message
     *            the error message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.070 -0400", hash_original_method = "E54A6FA33A5BFCD773DCE92A09F71FE9", hash_generated_method = "CBE90BFD29AA7F10B044C0FFD3B24438")
    
public UnsupportedCallbackException(Callback callback, String message) {
        super(message);
        this.callback = callback;
    }

    /**
     * Returns the unsupported {@code Callback} that triggered this exception.
     *
     * @return the {@code Callback}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.071 -0400", hash_original_method = "C52CB6D8F1111BAF8BAA5D6F66319767", hash_generated_method = "17B3C10E1BA6FC648E22A0AAC65F204E")
    
public Callback getCallback() {
        return callback;
    }
}
