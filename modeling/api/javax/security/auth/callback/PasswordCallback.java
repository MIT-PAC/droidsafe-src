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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package javax.security.auth.callback;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Arrays;

public class PasswordCallback implements Callback, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.217 -0500", hash_original_field = "30EA3D53279820373EB2F3A169D6AF84", hash_generated_field = "D3C30598DA322C32BB3F1988E72B00C5")

    private static final long serialVersionUID = 2267422647454909926L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.219 -0500", hash_original_field = "E39008C8C5530C4D0AB35F720027C03F", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")

    private String prompt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.221 -0500", hash_original_field = "085E002B7F9684AE04B61B19556E3A7A", hash_generated_field = "085E002B7F9684AE04B61B19556E3A7A")

    boolean echoOn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.223 -0500", hash_original_field = "7E289BD19E05568A632B0E32D8978F5C", hash_generated_field = "F66C98CBF0A43E25F25A4C8C5C084787")

    private char[] inputPassword;

    /**
     * Creates a new {@code PasswordCallback} instance.
     *
     * @param prompt
     *            the message that should be displayed to the user
     * @param echoOn
     *            determines whether the user input should be echoed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.229 -0500", hash_original_method = "FF9C282CA0D3F4D89988C18610E5667F", hash_generated_method = "E540B404EC5FE9FDA58437336046B3BB")
    
public PasswordCallback(String prompt, boolean echoOn) {
        setPrompt(prompt);
        this.echoOn = echoOn;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.226 -0500", hash_original_method = "3C861E594BCF1170EC69D71F98E7DC21", hash_generated_method = "244A43699B324D8C18CDB6AE348409B4")
    
private void setPrompt(String prompt) throws IllegalArgumentException {
        if (prompt == null || prompt.length() == 0) {
            throw new IllegalArgumentException("Invalid prompt");
        }
        this.prompt = prompt;
    }

    /**
     * Returns the prompt that was specified when creating this {@code
     * PasswordCallback}
     *
     * @return the prompt
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.231 -0500", hash_original_method = "9CD919A2E5CE4DE3A8693DD7DF368A07", hash_generated_method = "8CA7BA3046EB7CBE9C3CBEDBD6976E4F")
    
public String getPrompt() {
        return prompt;
    }

    /**
     * Queries whether this {@code PasswordCallback} expects user input to be
     * echoed, which is specified during the creation of the object.
     *
     * @return {@code true} if (and only if) user input should be echoed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.233 -0500", hash_original_method = "A27AE4B1B247F3C75C8013A45B07AFAD", hash_generated_method = "931942F5F7819D02C3747741801115F8")
    
public boolean isEchoOn() {
        return echoOn;
    }

    /**
     * Sets the password. The {@link CallbackHandler} that performs the actual
     * provisioning or input of the password needs to call this method to hand
     * back the password to the security service that requested it.
     *
     * @param password
     *            the password. A copy of this is stored, so subsequent changes
     *            to the input array do not affect the {@code PasswordCallback}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.235 -0500", hash_original_method = "A602CEA65D3FCE1A9999A6860447F09F", hash_generated_method = "33F79571242EF0FC930743511AE8953B")
    
public void setPassword(char[] password) {
        if (password == null) {
            this.inputPassword = password;
        } else {
            inputPassword = new char[password.length];
            System.arraycopy(password, 0, inputPassword, 0, inputPassword.length);
        }
    }

    /**
     * Returns the password. The security service that needs the password
     * usually calls this method once the {@link CallbackHandler} has finished
     * its work.
     *
     * @return the password. A copy of the internal password is created and
     *         returned, so subsequent changes to the internal password do not
     *         affect the result.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.238 -0500", hash_original_method = "5EC08C3E76624CC9F22EE28EB19509D9", hash_generated_method = "F6811A75D4964F0A309EF047CF257E79")
    
public char[] getPassword() {
        if (inputPassword != null) {
            char[] tmp = new char[inputPassword.length];
            System.arraycopy(inputPassword, 0, tmp, 0, tmp.length);
            return tmp;
        }
        return null;
    }

    /**
     * Clears the password stored in this {@code PasswordCallback}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.240 -0500", hash_original_method = "C115B79B56D59F71CAFFFA3A677E976D", hash_generated_method = "D23C14AD6009C33B2F88D2A2A55790C6")
    
public void clearPassword() {
        if (inputPassword != null) {
            Arrays.fill(inputPassword, '\u0000');
        }
    }
}

