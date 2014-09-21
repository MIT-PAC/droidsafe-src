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
public class FailedLoginException extends LoginException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.306 -0400", hash_original_field = "6E62FC491E2A2638081C57BB63E2EA7C", hash_generated_field = "E6D550D82D13D916AE07402348EEDE15")


    private static final long serialVersionUID = 802556922354616286L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.307 -0400", hash_original_method = "5A9AC26B9BD7764ED0F978A606005253", hash_generated_method = "2C5C474FE906810337B50BBE44CEA127")
    
public FailedLoginException() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.307 -0400", hash_original_method = "5F1396F51FF7C6835038F30642E1BB04", hash_generated_method = "7ADFADA28E35F5578EBC7BA29345B532")
    
public FailedLoginException(String message) {
        super(message);
    }

}