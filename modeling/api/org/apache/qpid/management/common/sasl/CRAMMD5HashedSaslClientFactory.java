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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.qpid.management.common.sasl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import de.measite.smack.Sasl;
import org.apache.harmony.javax.security.sasl.SaslClient;
import org.apache.harmony.javax.security.sasl.SaslClientFactory;
import org.apache.harmony.javax.security.sasl.SaslException;
import java.util.Map;

public class CRAMMD5HashedSaslClientFactory implements SaslClientFactory
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.369 -0400", hash_original_field = "C9B8C9FFAAB23ED5670E2CCEE093BE0E", hash_generated_field = "3235BDA9109A656E8A4DDBA461682CD4")

    public static final String MECHANISM = "CRAM-MD5-HASHED";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.370 -0400", hash_original_method = "0FDBA45A722D0781B075FE446793A2FB", hash_generated_method = "6DE42962919549417AB429784E95D265")
    
public SaslClient createSaslClient(String[] mechanisms, String authorizationId, String protocol,
                                       String serverName, Map<String, ?> props, CallbackHandler cbh)
    throws SaslException
    {
        for (int i = 0; i < mechanisms.length; i++)
        {
            if (mechanisms[i].equals(MECHANISM))
            {
                if (cbh == null)
                {
                    throw new SaslException("CallbackHandler must not be null");
                }

                String[] mechs = {"CRAM-MD5"};
                return Sasl.createSaslClient(mechs, authorizationId, protocol, serverName, props, cbh);
            }
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.370 -0400", hash_original_method = "448EBF82C00F379207379E92918C1CC3", hash_generated_method = "10A3E0C5DC7BC61B4DD02B5FDA595C79")
    
public String[] getMechanismNames(Map props)
    { 
        return new String[]{MECHANISM};
    }
}
