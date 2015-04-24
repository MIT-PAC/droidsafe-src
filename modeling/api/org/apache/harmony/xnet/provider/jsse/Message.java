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
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

public abstract class Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.641 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "01D45192EF478C4B8895FC65CF51D2EB")

    protected int length;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.676 -0400", hash_original_method = "1320821CB7E319AA2006FCB6CC079C6F", hash_generated_method = "1320821CB7E319AA2006FCB6CC079C6F")
    public Message ()
    {
        //Synthesized constructor
    }

    /**
     * Returns message type
     * @return
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.644 -0500", hash_original_method = "2661BA1F0AB44A1458B9DF009873A1E7", hash_generated_method = "36213AEFF6693FFB3A13105AE24E6A1E")
    
abstract int getType();

    /**
     * Returns message length
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.646 -0500", hash_original_method = "A95929A9D1E422E13DF7B6BE29D62093", hash_generated_method = "0744BCA0A089D0C6D748DF23D36A5A63")
    
public int length() {
        return length;
    }

    /**
     * Sends message
     * @param out
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.648 -0500", hash_original_method = "B58948AFEF1A0E057CD3CFAE54CA0552", hash_generated_method = "2E9F9AA3787127B95DA1E436E11287FE")
    
abstract void send(HandshakeIODataStream out);

    /**
     * Sends fatal alert
     * @param description
     * @param reason
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.651 -0500", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "9867DC8FBFE9F1B9BC6DB5E6A4B30F51")
    
protected void fatalAlert(byte description, String reason) {
        throw new AlertException(description, new SSLHandshakeException(reason));
    }

    /**
     * Sends fatal alert
     * @param description
     * @param reason
     * @param cause
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.653 -0500", hash_original_method = "8FFC926D3CD0D9B230B909F759D2E972", hash_generated_method = "83D22385F41B2709BC1B4274EA441A3E")
    
protected void fatalAlert(byte description, String reason, Throwable cause) {
        throw new AlertException(description, new SSLException(reason, cause));
    }
    
}

