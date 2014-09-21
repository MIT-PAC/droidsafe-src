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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;



public class NameCallback implements Callback, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.755 -0400", hash_original_field = "A3C11AEB9C788395CA72C535218186FB", hash_generated_field = "F6D0611AF8E2CAA2D631C0B9614AD880")


    private static final long serialVersionUID = 3770938795909392253L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.756 -0400", hash_original_field = "E39008C8C5530C4D0AB35F720027C03F", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")


    private String prompt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.756 -0400", hash_original_field = "84BC5372A12AA239726FB6B8D530CCAC", hash_generated_field = "676A68C7EDA9705849D412F44CD2024A")


    private String defaultName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.757 -0400", hash_original_field = "68F20AC0301385291B7516AB94715C9C", hash_generated_field = "C10F0F4D214138BFEDA4939AA454644A")


    private String inputName;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.759 -0400", hash_original_method = "11C0E1D982A0177E2A3478053E5B238C", hash_generated_method = "A898E0F913E7BD50625649CDDC7469C8")
    
public NameCallback(String prompt) {
        super();
        setPrompt(prompt);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.759 -0400", hash_original_method = "82F06BF61A1D35BC6B4545938062758A", hash_generated_method = "68B10BF9BF872FD185E9BA5AF4B66709")
    
public NameCallback(String prompt, String defaultName) {
        super();
        setPrompt(prompt);
        setDefaultName(defaultName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.757 -0400", hash_original_method = "698D470B766BBB13E508EDEAA9F21795", hash_generated_method = "2E1AE1532527C2F20C18C9014EA808B3")
    
private void setPrompt(String prompt) {
        if (prompt == null || prompt.length() == 0) {
            throw new IllegalArgumentException("auth.14"); //$NON-NLS-1$
        }
        this.prompt = prompt;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.758 -0400", hash_original_method = "934F4D2487A1B0733A090229C78788ED", hash_generated_method = "87BB3C59ACD18B6E9ACEFDF14246B15D")
    
private void setDefaultName(String defaultName) {
        if (defaultName == null || defaultName.length() == 0) {
            throw new IllegalArgumentException("auth.1E"); //$NON-NLS-1$
        }
        this.defaultName = defaultName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.760 -0400", hash_original_method = "9CD919A2E5CE4DE3A8693DD7DF368A07", hash_generated_method = "8CA7BA3046EB7CBE9C3CBEDBD6976E4F")
    
public String getPrompt() {
        return prompt;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.760 -0400", hash_original_method = "9E72FEF43745CDBD97CE6C988EB7AE65", hash_generated_method = "ECD0709DD2A76BD64614896D5ED35CB8")
    
public String getDefaultName() {
        return defaultName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.761 -0400", hash_original_method = "AD5B82CAF75084F52E6A3C6164D5626C", hash_generated_method = "91FDCA38DD999B0C2E79CCB8CDB3C079")
    
public void setName(String name) {
        this.inputName = name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.761 -0400", hash_original_method = "243D323BC9BABC1A0E63E09475AB0B6A", hash_generated_method = "6C8E7B674A17E0FBCDB8A5A8B7B851E5")
    
public String getName() {
        return inputName;
    }
}
