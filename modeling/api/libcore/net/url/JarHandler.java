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


package libcore.net.url;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class JarHandler extends URLStreamHandler {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.324 -0400", hash_original_method = "0A284EE1D1173C3D5D1EE186B211FF85", hash_generated_method = "0A284EE1D1173C3D5D1EE186B211FF85")
    public JarHandler ()
    {
        //Synthesized constructor
    }
    /**
     * Returns a connection to the jar file pointed by this <code>URL</code>
     * in the file system
     *
     * @return java.net.URLConnection A connection to the resource pointed by
     *         this url.
     * @param u
     *            java.net.URL The URL to which the connection is pointing to
     *
     * @throws IOException
     *             thrown if an IO error occurs when this method tries to
     *             establish connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.363 -0500", hash_original_method = "BD0D54E815B3E8434D2BE4AD1DDC7411", hash_generated_method = "78BB64D9372F21C949C4029C556A8131")
    
@Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new JarURLConnectionImpl(u);
    }

    /**
     *
     * @param url
     *            URL the context URL
     * @param spec
     *            java.lang.String the spec string
     * @param start
     *            int the location to start parsing from
     * @param limit
     *            int the location where parsing ends
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.366 -0500", hash_original_method = "57C5D17E5E318F4D460452A0FAAB1E77", hash_generated_method = "CF416AC81ED16574D0269088E2D4D7CA")
    
@Override
    protected void parseURL(URL url, String spec, int start, int limit) {
        String file = url.getFile();
        file = file + spec;
        try {
            // check that the embedded url is valid
            new URL(file);
        } catch (MalformedURLException e) {
            throw new NullPointerException(e.toString());
        }
        setURL(url, "jar", "", -1, null, null, file, null, null);
    }

    /**
     * Build and return the externalized string representation of url.
     *
     * @return String the externalized string representation of url
     * @param url
     *            a URL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.369 -0500", hash_original_method = "F692A804EFA22D479A24DA08ED26F838", hash_generated_method = "14C560568D73D889123A33232020A01A")
    
@Override
    protected String toExternalForm(URL url) {
        StringBuilder sb = new StringBuilder();
        sb.append("jar:");
        sb.append(url.getFile());
        String ref = url.getRef();
        if (ref != null) {
            sb.append(ref);
        }
        return sb.toString();
    }
    
}

