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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/auth/NTLMScheme.java $
 * $Revision: 655048 $
 * $Date: 2008-05-10 04:22:12 -0700 (Sat, 10 May 2008) $
 *
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.impl.auth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.InvalidCredentialsException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.NTCredentials;
import org.apache.http.impl.auth.AuthSchemeBase;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;

public class NTLMScheme extends AuthSchemeBase {

    enum State {
        UNINITIATED,
        CHALLENGE_RECEIVED,
        MSG_TYPE1_GENERATED,
        MSG_TYPE2_RECEVIED,
        MSG_TYPE3_GENERATED,
        FAILED,
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.276 -0400", hash_original_field = "284A44BEFFF029C1D545E73E2865D54E", hash_generated_field = "CF68C17F46FEB6A6EFE3E26B5FBB0D32")

    
    private  NTLMEngine engine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.277 -0400", hash_original_field = "05D925C5BEC5275A59607FB5FAF72E84", hash_generated_field = "1BABB00C62C02094F906A511C44D4ACB")

    
    private State state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.278 -0400", hash_original_field = "250DD14315DBA25631465B27752AA1F4", hash_generated_field = "58AB7407AC32F11E181369ACE6EB5164")

    private String challenge;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.280 -0400", hash_original_method = "9BE403D776F588B76A927DC1F4FEC4F5", hash_generated_method = "DF2CC13598EFC408EA4088B707076E97")
    
public NTLMScheme(final NTLMEngine engine) {
        super();
        if (engine == null) {
            throw new IllegalArgumentException("NTLM engine may not be null");
        }
        this.engine = engine;
        this.state = State.UNINITIATED;
        this.challenge = null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.281 -0400", hash_original_method = "945FE005071D7CB767EC7AA97EF1945B", hash_generated_method = "DA1EFE40F0F6B93A6979DE8FA30F1297")
    
public String getSchemeName() {
        return "ntlm";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.282 -0400", hash_original_method = "DCB95D7616B44D13EA6E1CCBDF2ED521", hash_generated_method = "4AADF45D7278C19D01C152BF841F4CD5")
    
public String getParameter(String name) {
        // String parameters not supported
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.283 -0400", hash_original_method = "4F2D20B8FE2F60F2B00CFDBEBBFE8A87", hash_generated_method = "DF886D3BA08DFC3C9EB5C08DF430F7C3")
    
public String getRealm() {
        // NTLM does not support the concept of an authentication realm
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.284 -0400", hash_original_method = "BDDCE56C4E2466D59BDC8BEEEFFEE6F1", hash_generated_method = "64A5E0F829EDD950C795054FA766672C")
    
public boolean isConnectionBased() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.286 -0400", hash_original_method = "A02ECCE8BE3FED6C2EDA68373DAED40B", hash_generated_method = "B7B9BA31A7089EFF35A2D0B9251E907D")
    
@Override
    protected void parseChallenge(
            final CharArrayBuffer buffer, int pos, int len) throws MalformedChallengeException {
        String challenge = buffer.substringTrimmed(pos, len);
        if (challenge.length() == 0) {
            if (this.state == State.UNINITIATED) {
                this.state = State.CHALLENGE_RECEIVED;
            } else {
                this.state = State.FAILED;
            }
            this.challenge = null;
        } else {
            this.state = State.MSG_TYPE2_RECEVIED;
            this.challenge = challenge;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.288 -0400", hash_original_method = "41BD1988261729314D4778360393C6D2", hash_generated_method = "C8874EE820E1EB4EC0003C02F059FAA6")
    
public Header authenticate(
            final Credentials credentials, 
            final HttpRequest request) throws AuthenticationException {
        NTCredentials ntcredentials = null;
        try {
            ntcredentials = (NTCredentials) credentials;
        } catch (ClassCastException e) {
            throw new InvalidCredentialsException(
             "Credentials cannot be used for NTLM authentication: " 
              + credentials.getClass().getName());
        }
        String response = null;
        if (this.state == State.CHALLENGE_RECEIVED || this.state == State.FAILED) {
            response = this.engine.generateType1Msg(
                    ntcredentials.getDomain(), 
                    ntcredentials.getWorkstation());
            this.state = State.MSG_TYPE1_GENERATED;
        } else if (this.state == State.MSG_TYPE2_RECEVIED) {
            response = this.engine.generateType3Msg(
                    ntcredentials.getUserName(), 
                    ntcredentials.getPassword(), 
                    ntcredentials.getDomain(), 
                    ntcredentials.getWorkstation(),
                    this.challenge);
            this.state = State.MSG_TYPE3_GENERATED;
        } else {
            throw new AuthenticationException("Unexpected state: " + this.state);
        }
        CharArrayBuffer buffer = new CharArrayBuffer(32);
        if (isProxy()) {
            buffer.append(AUTH.PROXY_AUTH_RESP);
        } else {
            buffer.append(AUTH.WWW_AUTH_RESP);
        }
        buffer.append(": NTLM ");
        buffer.append(response);
        return new BufferedHeader(buffer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.290 -0400", hash_original_method = "60A084439BB9534665FD119940C18153", hash_generated_method = "B13C0387C98F4D23A85B0456BC9AD840")
    
public boolean isComplete() {
        return this.state == State.MSG_TYPE3_GENERATED || this.state == State.FAILED;
    }

}
