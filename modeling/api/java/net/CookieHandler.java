/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class CookieHandler {

    /**
     * Returns the system-wide cookie handler or {@code null} if not set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.128 -0500", hash_original_method = "65064E42240CB41EFD8C79933CC6C8FC", hash_generated_method = "55FAD7BF0BEF4B8C6325DB42E40DDC15")
    
public static CookieHandler getDefault() {
        return systemWideCookieHandler;
    }

    /**
     * Sets the system-wide cookie handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.130 -0500", hash_original_method = "AB3F232505BCF1617B98122211B7FA81", hash_generated_method = "734A52BCED4FD1C1F2414241135412A8")
    
public static void setDefault(CookieHandler cHandler) {
        systemWideCookieHandler = cHandler;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.125 -0500", hash_original_field = "960FE1D0599F5BBCD5F5E9E0F7FBB7E7", hash_generated_field = "8C9BF4ECEE0FD776A81C187004A66852")

    private static CookieHandler systemWideCookieHandler;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.319 -0400", hash_original_method = "88D15E3335299CEFE37CA24D0A89E063", hash_generated_method = "88D15E3335299CEFE37CA24D0A89E063")
    public CookieHandler ()
    {
        //Synthesized constructor
    }

    /**
     * Gets all cookies for a specific URI from the cookie cache.
     *
     * @param uri
     *            a URI to search for applicable cookies.
     * @param requestHeaders
     *            a list of request headers.
     * @return an unchangeable map of all appropriate cookies.
     * @throws IOException
     *             if an error occurs during the I/O operation.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.132 -0500", hash_original_method = "D068D18B3D9B47F0EAD824B58CADE291", hash_generated_method = "D2294388951A4DED6ABEA745A3199C15")
    
public abstract Map<String, List<String>> get(URI uri,
            Map<String, List<String>> requestHeaders) throws IOException;

    /**
     * Sets all cookies of a specific URI in the {@code responseHeaders} into
     * the cookie cache.
     *
     * @param uri
     *            the origin URI of the cookies.
     * @param responseHeaders
     *            a list of request headers.
     * @throws IOException
     *             if an error occurs during the I/O operation.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.135 -0500", hash_original_method = "9C8A274D718511DE42A2D4C3B7D23DEA", hash_generated_method = "86CB2FC2AB52984EA96576101B656CCF")
    
public abstract void put(URI uri, Map<String, List<String>> responseHeaders)
            throws IOException;
}

