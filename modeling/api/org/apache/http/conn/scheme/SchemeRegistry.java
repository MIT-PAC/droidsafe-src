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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/scheme/SchemeRegistry.java $
 * $Revision: 648356 $
 * $Date: 2008-04-15 10:57:53 -0700 (Tue, 15 Apr 2008) $
 *
 * ====================================================================
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
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;

public final class SchemeRegistry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.022 -0500", hash_original_field = "937907C9E4279052DD4EE9715869156A", hash_generated_field = "F36240EAE5CF2A96AAAB44994667903B")

    private  Map<String,Scheme> registeredSchemes;

    /**
     * Creates a new, empty scheme registry.
     */
    @DSComment("creates data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.025 -0500", hash_original_method = "783AF87541D2DBDBA1743DA12D81CD53", hash_generated_method = "74AB894C18300FE3B23DF04436CBD8A2")
    
public SchemeRegistry() {
        super();
        registeredSchemes = new LinkedHashMap<String,Scheme>();
    }

    /**
     * Obtains a scheme by name.
     *
     * @param name      the name of the scheme to look up (in lowercase)
     *
     * @return  the scheme, never <code>null</code>
     *
     * @throws IllegalStateException
     *          if the scheme with the given name is not registered
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.029 -0500", hash_original_method = "C5B073CA8B29C4A4D0086C8D16427838", hash_generated_method = "5DA1E242E556E78D5BAC6BD8379CF45C")
    
public synchronized final Scheme getScheme(String name) {
        Scheme found = get(name);
        if (found == null) {
            throw new IllegalStateException
                ("Scheme '"+name+"' not registered.");
        }
        return found;
    }

    /**
     * Obtains the scheme for a host.
     * Convenience method for <code>getScheme(host.getSchemeName())</pre>
     *
     * @param host      the host for which to obtain the scheme
     *
     * @return  the scheme for the given host, never <code>null</code>
     *
     * @throws IllegalStateException
     *          if a scheme with the respective name is not registered
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.033 -0500", hash_original_method = "1246E5540B6FD28C8D868D100FFA2CE0", hash_generated_method = "0E6533C6226F3121B59638BF815FC1FD")
    
public synchronized final Scheme getScheme(HttpHost host) {
        if (host == null) {
            throw new IllegalArgumentException("Host must not be null.");
        }
        return getScheme(host.getSchemeName());
    }

    /**
     * Obtains a scheme by name, if registered.
     *
     * @param name      the name of the scheme to look up (in lowercase)
     *
     * @return  the scheme, or
     *          <code>null</code> if there is none by this name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.036 -0500", hash_original_method = "CF0C42ED0F9F87284AAED270A8C47522", hash_generated_method = "9456CAAD0798ECC1328B3429BF803965")
    
public synchronized final Scheme get(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name must not be null.");

        // leave it to the caller to use the correct name - all lowercase
        //name = name.toLowerCase();
        Scheme found = registeredSchemes.get(name);
        return found;
    }

    /**
     * Registers a scheme.
     * The scheme can later be retrieved by its name
     * using {@link #getScheme(String) getScheme} or {@link #get get}.
     *
     * @param sch       the scheme to register
     *
     * @return  the scheme previously registered with that name, or
     *          <code>null</code> if none was registered
     */
    @DSComment("potential callback called inside method")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.038 -0500", hash_original_method = "BF6DF8E3D28698AF7FF4E9FD5B4A484C", hash_generated_method = "254C69213B5D4D2353215375DE7E6B2C")
    
public synchronized final Scheme register(Scheme sch) {
        if (sch == null)
            throw new IllegalArgumentException("Scheme must not be null.");

        Scheme old = registeredSchemes.put(sch.getName(), sch);
        return old;
    }

    /**
     * Unregisters a scheme.
     *
     * @param name      the name of the scheme to unregister (in lowercase)
     *
     * @return  the unregistered scheme, or
     *          <code>null</code> if there was none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.041 -0500", hash_original_method = "68812395544991B9645F8BA0B34BB709", hash_generated_method = "D75FF2A976BD2B6C1FC29FDB97556890")
    
public synchronized final Scheme unregister(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name must not be null.");

        // leave it to the caller to use the correct name - all lowercase
        //name = name.toLowerCase();
        Scheme gone = registeredSchemes.remove(name);
        return gone;
    }

    /**
     * Obtains the names of the registered schemes in their default order.
     *
     * @return  List containing registered scheme names.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.043 -0500", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "60F1E62291485E559C9E3A6E4E1D94F2")
    
public synchronized final List<String> getSchemeNames() {
        return new ArrayList<String>(registeredSchemes.keySet());
    }

    /**
     * Populates the internal collection of registered {@link Scheme protocol schemes} 
     * with the content of the map passed as a parameter.
     * 
     * @param map protocol schemes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.045 -0500", hash_original_method = "E53575E4E05CC4D1B4FC58DE949DDA2A", hash_generated_method = "A20480509991ADF38F1AB560FBF27F36")
    
public synchronized void setItems(final Map<String, Scheme> map) {
        if (map == null) {
            return;
        }
        registeredSchemes.clear();
        registeredSchemes.putAll(map);
    }
    
}

