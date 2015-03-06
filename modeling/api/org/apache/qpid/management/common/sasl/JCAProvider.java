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
import org.apache.harmony.javax.security.sasl.SaslClientFactory;
import java.security.Provider;
import java.util.Map;

public class JCAProvider extends Provider
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.240 -0400", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;

    /**
     * Creates the security provider with a map from SASL mechanisms to implementing factories.
     *
     * @param providerMap The map from SASL mechanims to implementing factory classes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.241 -0400", hash_original_method = "8DBC82D807C057002CD279E8BB9BECD7", hash_generated_method = "9CD524E88F90C06716B6B893E2EE6975")
    
public JCAProvider(Map<String, Class<? extends SaslClientFactory>> providerMap)
    {
        super("AMQSASLProvider", 1.0, "A JCA provider that registers all "
              + "AMQ SASL providers that want to be registered");
        register(providerMap);
    }

    /**
     * Registers client factory classes for a map of mechanism names to client factory classes.
     *
     * @param providerMap The map from SASL mechanims to implementing factory classes.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.241 -0400", hash_original_method = "2EF87AD3412C8E9EB3D4F13BE6685C5B", hash_generated_method = "FDD416E4802C9DADCD6D4A621EAD160E")
    
private void register(Map<String, Class<? extends SaslClientFactory>> providerMap)
    {
        for (Map.Entry<String, Class<? extends SaslClientFactory>> me : providerMap.entrySet())
        {
            put("SaslClientFactory." + me.getKey(), me.getValue().getName());
        }
    }
}
