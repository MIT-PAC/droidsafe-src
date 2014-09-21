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
import de.measite.smack.Sasl;
import org.apache.harmony.javax.security.sasl.SaslClient;
import org.apache.harmony.javax.security.sasl.SaslException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PlainSaslClient implements SaslClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.331 -0400", hash_original_field = "388ED80661B6AC0F0EB4C12F75109D38", hash_generated_field = "88676F5133256C273B4D9F892B86D029")

    private static byte SEPARATOR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.328 -0400", hash_original_field = "6F7213FF7399DF0279D950956B2B2FE6", hash_generated_field = "6D26FB1F0B2CA12479DA851F94F91642")


    private boolean completed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.329 -0400", hash_original_field = "25B934E410CCD39A59F082A3398A37B2", hash_generated_field = "F23185F8CDB6C4F9627937C948DDA302")

    private CallbackHandler cbh;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.329 -0400", hash_original_field = "637D0D1A5F876511791F70072F81AC34", hash_generated_field = "B0945085C1ED9DAB2890A06C7CEBC5C9")

    private String authorizationID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.330 -0400", hash_original_field = "26A3B19BC4B2989FF37C1A8FE074E3EA", hash_generated_field = "9FBFC911F8AB1588C9163140EACBF422")

    private String authenticationID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.330 -0400", hash_original_field = "8E594ED647A0C9DECC4C217F350DC5BA", hash_generated_field = "D7402AC3623E5EFBBC3C993A00B9C334")

    private byte password[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.331 -0400", hash_original_method = "27FF65E16B83503AAF5388BC8AF29FE6", hash_generated_method = "87D32CC42F0452D2CD5B222B8D5AB4E1")
    
public PlainSaslClient(String authorizationID, CallbackHandler cbh) throws SaslException
    {
        completed = false;
        this.cbh = cbh;
        Object[] userInfo = getUserInfo();
        this.authorizationID = authorizationID;
        this.authenticationID = (String) userInfo[0];
        this.password = (byte[]) userInfo[1];
        if (authenticationID == null || password == null)
        {
            throw new SaslException("PLAIN: authenticationID and password must be specified");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.332 -0400", hash_original_method = "64279EE9EE92C626800A17E7364AC837", hash_generated_method = "6BDE3D14ABE2AC713366E6AE1749B522")
    
public byte[] evaluateChallenge(byte[] challenge) throws SaslException
    {
        if (completed)
        {
            throw new IllegalStateException("PLAIN: authentication already " +
            "completed");
        }
        completed = true;
        try 
        {
            byte authzid[] =
                authorizationID == null ? null : authorizationID.getBytes("UTF8");
            byte authnid[] = authenticationID.getBytes("UTF8");
            byte response[] =
                new byte[
                         password.length +
                         authnid.length +
                         2 + // SEPARATOR
                         (authzid != null ? authzid.length : 0)
                         ];
            int size = 0;
            if (authzid != null) {
                System.arraycopy(authzid, 0, response, 0, authzid.length);
                size = authzid.length;
            }
            response[size++] = SEPARATOR;
            System.arraycopy(authnid, 0, response, size, authnid.length);
            size += authnid.length;
            response[size++] = SEPARATOR;
            System.arraycopy(password, 0, response, size, password.length);
            clearPassword();
            return response;
        } catch (UnsupportedEncodingException e) {
            throw new SaslException("PLAIN: Cannot get UTF-8 encoding of ids",
                    e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.333 -0400", hash_original_method = "623E6A87CD0762D796A3F46D5B59F98F", hash_generated_method = "28069C5BCEE6FC44476AF1A8BF0C0B67")
    
public String getMechanismName()
    {
        return "PLAIN";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.334 -0400", hash_original_method = "C8D270CED56C1E00EC276007B15E00A7", hash_generated_method = "2B50E7AA1BE804AD046CB432D70E6989")
    
public boolean hasInitialResponse()
    {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.334 -0400", hash_original_method = "BA72049F179214F5DD48F18277D164B7", hash_generated_method = "F65384AD57E5BC10B73EF28070DE5410")
    
public boolean isComplete()
    {
        return completed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.335 -0400", hash_original_method = "5AB58F8AAE90F0D5E567ABEA3232C948", hash_generated_method = "2831801FBDCC4476BF70F9132FB24656")
    
public byte[] unwrap(byte[] incoming, int offset, int len) throws SaslException
    {
        if (completed) {
            throw new IllegalStateException("PLAIN: this mechanism supports " +
            "neither integrity nor privacy");
        } else {
            throw new IllegalStateException("PLAIN: authentication not " +
            "completed");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.336 -0400", hash_original_method = "972F738282FB8F7B1DC839825D290FF4", hash_generated_method = "EE61C45475871829822154070050DF41")
    
public byte[] wrap(byte[] outgoing, int offset, int len) throws SaslException
    {
        if (completed)
        {
            throw new IllegalStateException("PLAIN: this mechanism supports " +
            "neither integrity nor privacy");
        }
        else
        {
            throw new IllegalStateException("PLAIN: authentication not " +
            "completed");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.336 -0400", hash_original_method = "F8DDCB0DB1B2807F5C125B507C675A9E", hash_generated_method = "44FA7FB1427C84CE6F96907BDBC6A46C")
    
public Object getNegotiatedProperty(String propName)
    {
        if (completed)
        {
            if (propName.equals(Sasl.QOP))
            {
                return "auth";
            }
            else
            {
                return null;
            }
        }
        else 
        {
            throw new IllegalStateException("PLAIN: authentication not " +
            "completed");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.337 -0400", hash_original_method = "8D2DDD850DCF58F27A8499342A932184", hash_generated_method = "BC14B2796FB6AD7997671DB8E3D342C1")
    
private void clearPassword()
    {
        if (password != null)
        {
            for (int i = 0 ; i < password.length ; i++)
            {
                password[i] = 0;
            }
            password = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.337 -0400", hash_original_method = "FEACE5230FAFE10E82943B7DC86BF53A", hash_generated_method = "2C78E80609B84459E32CD3FCAEB00F8A")
    
public void dispose() throws SaslException
    {
        clearPassword();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.338 -0400", hash_original_method = "F42E225388304E92333E79B9269CB397", hash_generated_method = "3317C6C84829BE897BEC68EC75053F37")
    
protected void finalize()
    {
        clearPassword();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.339 -0400", hash_original_method = "921D41C25A2FFEB5C3F6BA120EE50021", hash_generated_method = "1AB5C5436BB2E3FA8E74A6E8F7159B4D")
    
private Object[] getUserInfo() throws SaslException
    {
        try
        {
            final String userPrompt = "PLAIN authentication id: ";
            final String pwPrompt = "PLAIN password: ";
            NameCallback nameCb = new NameCallback(userPrompt);
            PasswordCallback passwordCb = new PasswordCallback(pwPrompt, false);
            cbh.handle(new Callback[] { nameCb, passwordCb });
            String userid = nameCb.getName();
            char pwchars[] = passwordCb.getPassword();
            byte pwbytes[];
            if (pwchars != null)
            {
                pwbytes = (new String(pwchars)).getBytes("UTF8");
                passwordCb.clearPassword();
            }
            else 
            {
                pwbytes = null;
            }
            return (new Object[] { userid, pwbytes });
        } 
        catch (IOException e)
        {
            throw new SaslException("Cannot get password", e);
        } 
        catch (UnsupportedCallbackException e)
        {
            throw new SaslException("Cannot get userid/password", e);
        }
    }
}
