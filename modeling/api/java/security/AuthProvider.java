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

package java.security;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

/**
 * Legacy security code; do not use.
 */
public abstract class AuthProvider extends Provider {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.411 -0400", hash_original_method = "B01814E51CA9B4EE574C9E7E18877645", hash_generated_method = "4FD59BEC0969160656E3627CBE582CA2")
    
protected AuthProvider(String name, double version, String info) { super(name, version, info); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.412 -0400", hash_original_method = "8E8358ECEE2FB1C3C85ABC57C84AE3BF", hash_generated_method = "C361C0DA67053246915DDE39B41EB4F3")
    
public abstract void login(Subject subject, CallbackHandler handler) throws LoginException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.413 -0400", hash_original_method = "CFA3D1E97463B25A846213B152B94226", hash_generated_method = "A4E5C5622BF26EA7B06A23C0ECD98B35")
    
public abstract void logout() throws LoginException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.415 -0400", hash_original_method = "B474BB47078DD4D7E93D29E84B2DBC1C", hash_generated_method = "5A76E3C56EC4A03080BC8A201D8B44CC")
    
public abstract void setCallbackHandler(CallbackHandler handler);
}
