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

public class DelegatedTask implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.003 -0500", hash_original_field = "2FAEBA4E6DD79DB48FD81B0F04E000FA", hash_generated_field = "1E40A8F04D6C87AD06430CB770B50920")

    private  HandshakeProtocol handshaker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.006 -0500", hash_original_field = "6E604B84976ABCF0C30A63D2F996D309", hash_generated_field = "95D8B8F79B2D276990C93DE7E8E59CF0")

    private  Runnable action;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.008 -0500", hash_original_method = "E66EF7E710B4ECD724343E3A45657AE3", hash_generated_method = "DAD7BC05C721AF9B9941C1CD1ED4078B")
    
public DelegatedTask(Runnable action, HandshakeProtocol handshaker) {
        this.action = action;
        this.handshaker = handshaker;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.011 -0500", hash_original_method = "BC92620C95DC261FCD2ED821B8965098", hash_generated_method = "DDB79F5778145D07CB17CA4544EE8544")
    
public void run() {
        synchronized (handshaker) {
            try {
                action.run();
            } catch (RuntimeException e) {
                // pass exception to HandshakeProtocol
                handshaker.delegatedTaskErr = e;
            }
        }
    }
    
}

