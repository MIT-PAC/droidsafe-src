/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.qpid.management.common.sasl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.harmony.javax.security.auth.callback.Callback;
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import org.apache.harmony.javax.security.auth.callback.NameCallback;
import org.apache.harmony.javax.security.auth.callback.PasswordCallback;
import org.apache.harmony.javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class UsernameHashedPasswordCallbackHandler implements CallbackHandler
{
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.286 -0400", hash_original_method = "5FF2B42B47087D6EDEB23E2883C374D0", hash_generated_method = "066166D1BC8DDA63A672E8DC88BFEF6C")
    
public static char[] getHash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        byte[] data = text.getBytes("utf-8");

        MessageDigest md = MessageDigest.getInstance("MD5");

        for (byte b : data)
        {
            md.update(b);
        }

        byte[] digest = md.digest();

        char[] hash = new char[digest.length ];

        int index = 0;
        for (byte b : digest)
        {            
            hash[index++] = (char) b;
        }

        return hash;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.282 -0400", hash_original_field = "B37EB1ED61432756B8E994D3D7BA4599", hash_generated_field = "62E91D3D5BD86C106CB7D669AA0EE0C2")

    private String user;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.282 -0400", hash_original_field = "D652E426D887F7201DD18BC2099943C7", hash_generated_field = "FE95AF76B7470A71D5FB8B6ACECE0F1C")

    private char[] pwchars;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.283 -0400", hash_original_method = "C5F4271AAA49432E4993FA2685CE61DE", hash_generated_method = "4FA668FC229747D3FD774735ED3B24CD")
    
public UsernameHashedPasswordCallbackHandler(String user, String password) throws Exception
    {
        this.user = user;
        this.pwchars = getHash(password);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.283 -0400", hash_original_method = "728E5FD592B588D0BD967FD67C6AE746", hash_generated_method = "85AC69400D3C0EF80ACD573BACE91298")
    
public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
    {
        for (int i = 0; i < callbacks.length; i++)
        {
            if (callbacks[i] instanceof NameCallback)
            {
                NameCallback ncb = (NameCallback) callbacks[i];
                ncb.setName(user);
            } 
            else if (callbacks[i] instanceof PasswordCallback)
            {
                PasswordCallback pcb = (PasswordCallback) callbacks[i];
                pcb.setPassword(pwchars);
            } 
            else
            {
                throw new UnsupportedCallbackException(callbacks[i]);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.284 -0400", hash_original_method = "1879E0720E927299ACBF67C302ED951A", hash_generated_method = "D906ED2B482080374848C8818107B9E4")
    
private void clearPassword()
    {
        if (pwchars != null) 
        {
            for (int i = 0 ; i < pwchars.length ; i++)
            {
                pwchars[i] = 0;
            }
            pwchars = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.284 -0400", hash_original_method = "F42E225388304E92333E79B9269CB397", hash_generated_method = "3317C6C84829BE897BEC68EC75053F37")
    
protected void finalize()
    {
        clearPassword();
    }
}
