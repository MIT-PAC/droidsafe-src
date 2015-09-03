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
import java.io.OutputStream;

import libcore.io.Streams;

public class SSLSocketOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.930 -0500", hash_original_field = "09345289E0F08ED39AA376881C5DC943", hash_generated_field = "FC855125850BB72054AAC77176B58208")

    private  SSLSocketImpl owner;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.932 -0500", hash_original_method = "A41E4766E55868182E82056D4801E8D9", hash_generated_method = "04B6ABE5C4995B5869C51820FCCA2F91")
    
protected SSLSocketOutputStream(SSLSocketImpl owner) {
        this.owner = owner;
    }

    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.935 -0500", hash_original_method = "C558B2B88CBF261C0FBBE5741F96019C", hash_generated_method = "23C1BFB0F79EE3063A60285E2CC71033")
    
@Override public void write(int b) throws IOException {
        Streams.writeSingleByte(this, b);
    }

    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.937 -0500", hash_original_method = "A06DCDC39D6B1A9C644C2D57A083C16C", hash_generated_method = "899EF57D5285130E25B1B9F4EB64F8B2")
    
@Override
    public void write(byte[] b, int off, int len) throws IOException {
        owner.writeAppData(b, off, len);
    }
    
}

