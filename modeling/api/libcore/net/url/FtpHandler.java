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
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class FtpHandler extends URLStreamHandler {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.195 -0400", hash_original_method = "D147DA8ADE52659E6B675F3FCB66ABA5", hash_generated_method = "D147DA8ADE52659E6B675F3FCB66ABA5")
    public FtpHandler ()
    {
        //Synthesized constructor
    }
    /**
     * Open a URLConnection on the given URL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.663 -0500", hash_original_method = "3C5B2D25E22696E048ED7556D298C58C", hash_generated_method = "950BA299B573064452A86E0E53D88336")
    
@Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new FtpURLConnection(u);
    }

    /**
     * Returns a connection, which is established via the <code>proxy</code>,
     * to the FTP server specified by this <code>URL</code>. If
     * <code>proxy</code> is DIRECT type, the connection is made in normal
     * way.
     *
     * @param url
     *            the URL which the connection is pointing to
     * @param proxy
     *            the proxy which is used to make the connection
     * @return a connection to the resource pointed by this url.
     *
     * @throws IOException
     *             if this handler fails to establish a connection.
     * @throws IllegalArgumentException
     *             if any argument is null or the type of proxy is wrong.
     * @throws UnsupportedOperationException
     *             if the protocol handler doesn't support this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.666 -0500", hash_original_method = "1D737A935EF21FF08B15C0F0950C4FF6", hash_generated_method = "C5D04284015278F1AA31C6B17625F949")
    
@Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        if (url == null || proxy == null) {
            throw new IllegalArgumentException("url == null || proxy == null");
        }
        return new FtpURLConnection(url, proxy);
    }

    /**
     * Return the default port.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.669 -0500", hash_original_method = "EEF2A707E6AE293A2B045747E5BC7948", hash_generated_method = "837E1A89ED5DEE7DBC3C424F105290DF")
    
@Override
    protected int getDefaultPort() {
        return 21;
    }
    
}

