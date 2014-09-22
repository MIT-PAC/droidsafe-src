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

package org.apache.harmony.javax.security.sasl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.harmony.javax.security.auth.callback.TextInputCallback;

public class RealmCallback extends TextInputCallback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.531 -0400", hash_original_field = "C2FD224B9BBFB6D6EB2D0B851B849067", hash_generated_field = "33E01ABA2E4EF3A41442BBE42D2DE748")


    private static final long serialVersionUID = -4342673378785456908L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.531 -0400", hash_original_method = "FBBF4E371373528492B104D3EE35827C", hash_generated_method = "89663C3D4A9BFA18082A0C39F0378265")
    
public RealmCallback(String prompt) {
        super(prompt);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.532 -0400", hash_original_method = "861CCAE84999D7DA426AAD8AAEAFFA5A", hash_generated_method = "19BC53E7C3FA3DFCAED36A1A40A24E24")
    
public RealmCallback(String prompt, String defaultRealmInfo) {
        super(prompt, defaultRealmInfo);
    }
}
