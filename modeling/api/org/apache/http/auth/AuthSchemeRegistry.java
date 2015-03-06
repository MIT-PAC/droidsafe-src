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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/auth/AuthSchemeRegistry.java $
 * $Revision: 652950 $
 * $Date: 2008-05-02 16:49:48 -0700 (Fri, 02 May 2008) $
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


package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.http.params.HttpParams;

public final class AuthSchemeRegistry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.159 -0500", hash_original_field = "A76137644C4EB541CBD7C570A2A34EDA", hash_generated_field = "7DEAAE1C48DF7EB41AD4414C102662D1")

    private  Map<String,AuthSchemeFactory> registeredSchemes;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.162 -0500", hash_original_method = "22746583E1A94F633C7199B49397C3E9", hash_generated_method = "111F085ED72F7E6F8F03A7FC65727737")
    
public AuthSchemeRegistry() {
        super();
        this.registeredSchemes = new LinkedHashMap<String,AuthSchemeFactory>();
    }
    
    /**
     * Registers a {@link AuthSchemeFactory} with  the given identifier. If a factory with the 
     * given name already exists it will be overridden. This name is the same one used to 
     * retrieve the {@link AuthScheme authentication scheme} from {@link #getAuthScheme}.
     * 
     * <p>
     * Please note that custom authentication preferences, if used, need to be updated accordingly 
     * for the new {@link AuthScheme authentication scheme} to take effect.
     * </p>    
     * 
     * @param name the identifier for this scheme
     * @param factory the {@link AuthSchemeFactory} class to register
     * 
     * @see #getAuthScheme
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.164 -0500", hash_original_method = "86D80B5F63163F72174F2671E9B32DD3", hash_generated_method = "F17DB22DB4CBFB84FC203B4E5480B5C2")
    
public synchronized void register(
            final String name, 
            final AuthSchemeFactory factory) {
         if (name == null) {
             throw new IllegalArgumentException("Name may not be null");
         }
        if (factory == null) {
            throw new IllegalArgumentException("Authentication scheme factory may not be null");
        }
        registeredSchemes.put(name.toLowerCase(Locale.ENGLISH), factory);
    }

    /**
     * Unregisters the class implementing an {@link AuthScheme authentication scheme} with 
     * the given name.
     * 
     * @param name the identifier of the class to unregister
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.167 -0500", hash_original_method = "65CA9EEB97401D491830ABAD4DFFB0A8", hash_generated_method = "0CAF915EBC12074A8C9A7F37A671A1A5")
    
public synchronized void unregister(final String name) {
         if (name == null) {
             throw new IllegalArgumentException("Name may not be null");
         }
        registeredSchemes.remove(name.toLowerCase(Locale.ENGLISH));
    }

    /**
     * Gets the {@link AuthScheme authentication scheme} with the given name.
     * 
     * @param name the {@link AuthScheme authentication scheme} identifier
     * @param params the {@link HttpParams HTTP parameters} for the authentication
     *  scheme. 
     * 
     * @return {@link AuthScheme authentication scheme}
     * 
     * @throws IllegalStateException if a scheme with the given name cannot be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.170 -0500", hash_original_method = "8F2D5DDAEEB3D14130F6F0EEE6300B47", hash_generated_method = "356A76CA5C5A604F4A9541DDFDCA9B95")
    
public synchronized AuthScheme getAuthScheme(final String name, final HttpParams params) 
        throws IllegalStateException {

        if (name == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        AuthSchemeFactory factory = registeredSchemes.get(name.toLowerCase(Locale.ENGLISH));
        if (factory != null) {
            return factory.newInstance(params);
        } else {
            throw new IllegalStateException("Unsupported authentication scheme: " + name);
        }
    }

    /**
     * Obtains a list containing names of all registered {@link AuthScheme authentication 
     * schemes} in their default order.
     * 
     * @return list of registered scheme names
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.173 -0500", hash_original_method = "AC70BADA49B0F71D218410F2BC1D1DD5", hash_generated_method = "A0766A9657CCECE4B5EA241D39076162")
    
public synchronized List<String> getSchemeNames() {
        return new ArrayList<String>(registeredSchemes.keySet()); 
    }
 
    /**
     * Populates the internal collection of registered {@link AuthScheme authentication schemes} 
     * with the content of the map passed as a parameter.
     * 
     * @param map authentication schemes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.175 -0500", hash_original_method = "34BF27E04F7109EDCEF6964572DA093F", hash_generated_method = "22872E7A4B65A332824F48C8D363D546")
    
public synchronized void setItems(final Map<String, AuthSchemeFactory> map) {
        if (map == null) {
            return;
        }
        registeredSchemes.clear();
        registeredSchemes.putAll(map);
    }
    
}

