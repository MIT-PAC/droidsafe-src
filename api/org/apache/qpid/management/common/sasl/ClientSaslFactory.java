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
import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import org.apache.harmony.javax.security.sasl.SaslClient;
import org.apache.harmony.javax.security.sasl.SaslClientFactory;
import org.apache.harmony.javax.security.sasl.SaslException;
import java.util.Map;

public class ClientSaslFactory implements SaslClientFactory
{
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.259 -0400", hash_original_method = "01C6AA26EF8F832755416F585A240ABB", hash_generated_method = "981E19C95D92A692C8BA91250F2A6851")
    
public SaslClient createSaslClient(String[] mechs, String authorizationId, String protocol,
                                       String serverName, Map props, CallbackHandler cbh)
    throws SaslException 
    {
        for (int i = 0; i < mechs.length; i++)
        {
            if (mechs[i].equals("PLAIN"))
            {
                return new PlainSaslClient(authorizationId, cbh);
            }
        }
        return null;
    }

    /**
     * Simple-minded implementation that ignores props
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.260 -0400", hash_original_method = "9D916B475685D0FFCC4A5DD4F0B8A4F1", hash_generated_method = "3281EB15A9A938DB7D34513091CDD6AA")
    
public String[] getMechanismNames(Map props)
    {
        return new String[]{"PLAIN"};
    }

}
