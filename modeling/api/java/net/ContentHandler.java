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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public abstract class ContentHandler {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.311 -0400", hash_original_method = "34235149EC6F1F14A33FF6A78502D340", hash_generated_method = "34235149EC6F1F14A33FF6A78502D340")
    public ContentHandler ()
    {
        //Synthesized constructor
    }
    /**
     * Returns the object pointed by the specified URL connection {@code uConn}.
     *
     * @param uConn
     *            URL connection that points to the desired object.
     * @return object referred by {@code uConn}.
     * @throws IOException
     *             if an IO error occurs during the retrieval of the object
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.861 -0500", hash_original_method = "0A0DE36248DED56E2DC9A3C213E73F00", hash_generated_method = "C085E82305BE92773C89ADB444EB7B2D")
    
public abstract Object getContent(URLConnection uConn) throws IOException;

    /**
     * Returns the object pointed by the specified URL connection {@code uConn}.
     *
     * @param uConn
     *            URL connection that points to the desired object.
     * @param types
     *            list of acceptable content types.
     * @return resource object pointed by this URL or {@code null} if the
     *         content doesn't match one of the specified content types.
     * @throws IOException
     *             if an error occurred while obtaining the content.
     */
    // Class arg not generified in the spec.
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.864 -0500", hash_original_method = "8659195BC6B56411F2DC6C9C918B5FC3", hash_generated_method = "1AD0408A977EABBE121234307AE2FBAD")
    
@SuppressWarnings("unchecked")
    public Object getContent(URLConnection uConn, Class[] types)
            throws IOException {
        Object content = getContent(uConn);
        for (int i = 0; i < types.length; i++) {
            if (types[i].isInstance(content)) {
                return content;
            }
        }
        return null;
    }
    
}

