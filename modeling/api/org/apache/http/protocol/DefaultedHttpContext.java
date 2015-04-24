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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/DefaultedHttpContext.java $
 * $Revision: 654882 $
 * $Date: 2008-05-09 09:58:59 -0700 (Fri, 09 May 2008) $
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


package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class DefaultedHttpContext implements HttpContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.521 -0500", hash_original_field = "6D2A54D860DEBB1E031F687F0830CF6F", hash_generated_field = "E015EF617CD4ED004D5007AC30C609BC")

    private  HttpContext local;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.524 -0500", hash_original_field = "FB45C7B58028E43766461E8C8059F493", hash_generated_field = "7ADABA5216B59FD658450669A2A3CCAA")

    private  HttpContext defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.527 -0500", hash_original_method = "A0575674BF73385D2F6A60AE80137BEF", hash_generated_method = "D2F9D43F197DE0F3D5D3425785FA8EC1")
    
public DefaultedHttpContext(final HttpContext local, final HttpContext defaults) {
        super();
        if (local == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
        this.local = local;
        this.defaults = defaults;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.529 -0500", hash_original_method = "E6F5162D8C28E0713279EA6EC6682784", hash_generated_method = "E94E515CD7BA06B5B09E33AB4660CDF3")
    
public Object getAttribute(final String id) {
        Object obj = this.local.getAttribute(id);
        if (obj == null) {
            return this.defaults.getAttribute(id);
        } else {
            return obj;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.532 -0500", hash_original_method = "0AEE49A004EDC83FD5C79915CB13681F", hash_generated_method = "CDACE077E3C198B2262748C00D934BD5")
    
public Object removeAttribute(final String id) {
        return this.local.removeAttribute(id);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.535 -0500", hash_original_method = "EE2D3704A963700B0310D3F12DCBDD4D", hash_generated_method = "230DE4EAE88EA33E341F37B703B11AF3")
    
public void setAttribute(final String id, final Object obj) {
        this.local.setAttribute(id, obj);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.538 -0500", hash_original_method = "FA59965C12DF7B81C110308001A0693E", hash_generated_method = "2417135D67EAB4F57C659CEED6FDC3B5")
    
public HttpContext getDefaults() {
        return this.defaults;
    }
    
}

