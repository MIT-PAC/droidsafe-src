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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/auth/AUTH.java $
 * $Revision: 618365 $
 * $Date: 2008-02-04 10:20:08 -0800 (Mon, 04 Feb 2008) $
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


package org.apache.http.auth;

/**
 * Constants and static helpers related to the HTTP authentication.
 * 
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @since 4.0
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class AUTH {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.624 -0400", hash_original_field = "06C3AA2A74DE9916899CCB94EB8B68A5", hash_generated_field = "A78B5490FD2B9A797087E7A3F3D120FB")

    public static final String WWW_AUTH = "WWW-Authenticate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.626 -0400", hash_original_field = "C23258A9715103572D1B1E8458E161F7", hash_generated_field = "0262818BF45E3667B2257846021A7952")

    public static final String WWW_AUTH_RESP = "Authorization";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.628 -0400", hash_original_field = "8D60BB2FD702A19C5AAE3D42DFFED6BD", hash_generated_field = "30118915544C302F7307FEC4D80629DF")

    public static final String PROXY_AUTH = "Proxy-Authenticate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.629 -0400", hash_original_field = "5385B9F49A26E8B8036FFAE9B1FA5E97", hash_generated_field = "55C1B501850632E5A8B644FDF189EC78")

    public static final String PROXY_AUTH_RESP = "Proxy-Authorization";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.631 -0400", hash_original_method = "185C96097D6E2D5341FF9904DF8C007F", hash_generated_method = "F945DBF28323A09F1D78BAD89E94A279")
    
private AUTH() {
    }
       
}
