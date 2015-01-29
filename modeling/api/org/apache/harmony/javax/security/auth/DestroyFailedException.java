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

package org.apache.harmony.javax.security.auth;

/**
 * Signals that the {@link Destroyable#destroy()} method failed.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class DestroyFailedException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.758 -0400", hash_original_field = "FDF463C72305A847C176800C2E9B80CB", hash_generated_field = "D46412D2433956C0DBCFF8D8717318CC")


    private static final long serialVersionUID = -7790152857282749162L;

    /**
     * Creates an exception of type {@code DestroyFailedException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.758 -0400", hash_original_method = "57F0C61D724E9F3CDD4A42B5EE84F80F", hash_generated_method = "5B209D335FF4C426A1A8AFBB7F85C8EE")
    
public DestroyFailedException() {
        super();
    }

    /**
     * Creates an exception of type {@code DestroyFailedException}.
     *
     * @param message
     *            A detail message that describes the reason for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.759 -0400", hash_original_method = "49DB9D74B82421E273A368ED4AD8049A", hash_generated_method = "AA533DE5989EF4733DCFBDDC7804569F")
    
public DestroyFailedException(String message) {
        super(message);
    }

}
