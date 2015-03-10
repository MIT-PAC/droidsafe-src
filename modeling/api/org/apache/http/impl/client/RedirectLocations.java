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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/client/RedirectLocations.java $
 * $Revision: 652020 $
 * $Date: 2008-04-27 14:23:31 -0700 (Sun, 27 Apr 2008) $
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


package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class RedirectLocations {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.534 -0500", hash_original_field = "1CA521CCC81E60F840743F80D41918F7", hash_generated_field = "E609FAD9509EA57EE6F15C46616EE93D")

    private  Set<URI> uris;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.536 -0500", hash_original_method = "9519CF5B1DBD865D59F3013CCB6A2D22", hash_generated_method = "5B37674157F725D7786F2E93247B9F7B")
    
public RedirectLocations() {
        super();
        this.uris = new HashSet<URI>();
    }
    
    /**
     * Returns true if this collection contains the given URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.539 -0500", hash_original_method = "AE445335586A61F4AB9D472CB658E765", hash_generated_method = "1FB526D41F3DD0C51856D56C1E80CDED")
    
public boolean contains(final URI uri) {
        return this.uris.contains(uri);
    }
    
    /**
     * Adds a new URI to the list of redirects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.541 -0500", hash_original_method = "F9942D2466FE07715480ED4C9CFB455E", hash_generated_method = "3A42119FB9C691DFF3EDB01412BDBFAC")
    
public void add(final URI uri) {
        this.uris.add(uri);
    }

    /**
     * Removes a URI from the list of redirects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.543 -0500", hash_original_method = "E60762F1048604C69EBEEFFB1108CCA7", hash_generated_method = "D7F57C172E88386FD52BD254A2E2CA69")
    
public boolean remove(final URI uri) {
        return this.uris.remove(uri);
    }
    
}

