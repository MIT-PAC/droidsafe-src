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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/io/IdentityInputStream.java $
 * $Revision: 560358 $
 * $Date: 2007-07-27 12:30:42 -0700 (Fri, 27 Jul 2007) $
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


package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.io.SessionInputBuffer;

public class IdentityInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.914 -0500", hash_original_field = "70993BC56EC5FB33DD67D98C82018650", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")
    
    private  SessionInputBuffer in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.916 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")
    
    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.919 -0500", hash_original_method = "9BF2DB3D820A8A5E47D8F845957A3FBA", hash_generated_method = "02CA87C5038900CAFE9B94925F103C66")
    
public IdentityInputStream(final SessionInputBuffer in) {
        super();
        if (in == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        }
        this.in = in;
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.921 -0500", hash_original_method = "DCB121D8842EB51547DBC31A4230EDC6", hash_generated_method = "5CD863C5AA1EC1E8A1FD76E994C7BF4D")
    
public int available() throws IOException {
        if (!this.closed && this.in.isDataAvailable(10)) {
            return 1;
        } else {
            return 0;
        }
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.923 -0500", hash_original_method = "311E5281CF91526FD2B39B7023BBB3B5", hash_generated_method = "E9229935EC81724C05DDA3378F484A43")
    
public void close() throws IOException {
        this.closed = true;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.925 -0500", hash_original_method = "F6A0760AFCA549A5825114F4EAC4FB8F", hash_generated_method = "9E0DD976E5A0EA9794F891A4D359B15F")
    
public int read() throws IOException {
        if (this.closed) {
            return -1;
        } else {
            return this.in.read();
        }
    }
    
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.927 -0500", hash_original_method = "E3ECD120B22D1F545DEC5B2DDE1C9AA2", hash_generated_method = "F96A7B756D9E3C99004DF720461E90B4")
    
public int read(final byte[] b, int off, int len) throws IOException {
        if (this.closed) {
            return -1;
        } else {
            return this.in.read(b, off, len);
        }
    }
    
}

