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


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

public class SSLStreamedInput extends SSLInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.199 -0500", hash_original_field = "0A829BC26C36EAF422E245C1EC11D5B0", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.201 -0500", hash_original_method = "2603FDEDA68AA1C899FD148F0716545A", hash_generated_method = "815CBA021DDFEBE9388BB9CCBF77BA26")
    
public SSLStreamedInput(InputStream in) {
        this.in = in;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.204 -0500", hash_original_method = "0AD8415E97210126520B7235309B4152", hash_generated_method = "8E5606FF0A120193314716C29AE15BAC")
    
@Override
    public int available() throws IOException {
        return in.available();
    }

    /**
     * Read an opaque value from the stream.
     * @return the value read from the underlying stream.
     * @throws IOException if the data could not be read from
     * the underlying stream
     * @throws org.apache.harmony.xnet.provider.jsse.EndOfSourceException if the end of the underlying
     * stream has been reached.
     */
    @DSSource({DSSourceKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.206 -0500", hash_original_method = "944A08161D308B286B46AD616F2EEC05", hash_generated_method = "A285847CD23F2C7C711C4A57F7E4A09F")
    
@Override
    public int read() throws IOException {
        int res = in.read();
        if (res < 0) {
            throw new EndOfSourceException();
        }
        return res;
    }
    
}

