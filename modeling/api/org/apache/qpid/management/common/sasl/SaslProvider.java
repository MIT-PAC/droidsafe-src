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
import java.security.Provider;

public class SaslProvider extends Provider
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.252 -0400", hash_original_field = "5F9D96B29C27FF7A0869BA9482DFD3C7", hash_generated_field = "2FFFDCC640881669806C35EAA1507287")

    private static final long serialVersionUID = -6978096016899676466L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.252 -0400", hash_original_method = "439F0A516A5700DDE54C0DB4114CB462", hash_generated_method = "DC9F83AAF8F461306784F8CDCA62742B")
    
public SaslProvider()
    {
        super("SaslClientFactory", 1.0, "SASL PLAIN CLIENT MECHANISM");
        put("SaslClientFactory.PLAIN", "ClientSaslFactory");
    }

}
