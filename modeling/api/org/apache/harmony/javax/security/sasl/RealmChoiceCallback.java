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
import org.apache.harmony.javax.security.auth.callback.ChoiceCallback;

public class RealmChoiceCallback extends ChoiceCallback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.611 -0400", hash_original_field = "BE2DA24A44241F1FD7C48DAA0A14BF22", hash_generated_field = "49EFA7806F75241669D655F5A2175378")


    private static final long serialVersionUID = -8588141348846281332L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.612 -0400", hash_original_method = "6777266F7F430DC43CB2C3F7E96CE9A3", hash_generated_method = "4F4EF237A3D8DD272F4FE3BF5DDB0EBA")
    
public RealmChoiceCallback(String prompt, String[] choices, int defaultChoice,
            boolean multiple) {
        super(prompt, choices, defaultChoice, multiple);
    }
}
