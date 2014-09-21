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

package org.apache.harmony.javax.security.auth.login;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.GeneralSecurityException;

/**
 * Base class for exceptions that are thrown when a login error occurs.
 */
public class LoginException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.390 -0400", hash_original_field = "1CFE884503BEC70158A9FCE2E0676717", hash_generated_field = "BB306F7103545D1A9AD7F5886E73D68E")


    private static final long serialVersionUID = -4679091624035232488L;

    /**
     * Creates a new exception instance and initializes it with default values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.390 -0400", hash_original_method = "167D6058217CAE2D9314E19221D90CE8", hash_generated_method = "1DB101F683AB5E18DE11500B4664D09F")
    
public LoginException() {
        super();
    }

    /**
     * Creates a new exception instance and initializes it with a given message.
     *
     * @param message the error message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.391 -0400", hash_original_method = "C55D1A26828240BF33343375034201CC", hash_generated_method = "C35FC72204F663AD1A6CFC4B6DAEA1B9")
    
public LoginException(String message) {
        super(message);
    }

}
