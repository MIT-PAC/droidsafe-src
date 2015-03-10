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

public class Finished extends Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.973 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

    private byte[] data;

    /**
     * Creates outbound message
     * @param bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.976 -0500", hash_original_method = "5B583BB83679498D2C51EBF7375CF750", hash_generated_method = "5FFFFA9C91536F01676F6077DEBFAF87")
    
public Finished(byte[] bytes) {
        data = bytes;
        length = data.length;
    }

    /**
     * Creates inbound message
     * @param in
     * @param length
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.979 -0500", hash_original_method = "7020D64852F49C66B1A4A40108BB938F", hash_generated_method = "A382C947D99AE7DAB26D118FE5C1393E")
    
public Finished(HandshakeIODataStream in, int length)
            throws IOException {
        if (length == 12 || length == 36) {
            data = in.read(length);
            this.length = data.length;
        } else {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect Finished");
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.981 -0500", hash_original_method = "E175A61E2BD704850DF6197D24D9CB45", hash_generated_method = "A1FF488ACA6CA47BF13EC1B0997CD8ED")
    
@Override
    public void send(HandshakeIODataStream out) {
        out.write(data);
    }

    /**
     * Returns message type
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.984 -0500", hash_original_method = "52E15100C019416DBC0E10E00C79BB89", hash_generated_method = "C7553CCB11696C4583A078D949953E0A")
    
@Override
    public int getType() {
        return Handshake.FINISHED;
    }

    /**
     * Returns verify data
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.986 -0500", hash_original_method = "B9E74D06348E60D6DDB9FA9E07D464F9", hash_generated_method = "EDCB50AB1FD1DF9A8143361DF3DCCF05")
    
public byte[] getData() {
        return data;
    }
    
}

