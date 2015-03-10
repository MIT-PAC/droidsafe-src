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
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.android.internal.telephony.Call;
import com.android.internal.telephony.Connection;

abstract class SipCallBase extends Call {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.331 -0500", hash_original_field = "CF6A431F779622AF0115FA7C1EE3B9D1", hash_generated_field = "8202D840EE6CEF3CCCA47896EED71E34")

    protected List<Connection> connections = new ArrayList<Connection>();
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.071 -0400", hash_original_method = "0EF508E50423F81ECC9230D92981C1BD", hash_generated_method = "0EF508E50423F81ECC9230D92981C1BD")
    public SipCallBase ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.333 -0500", hash_original_method = "77598EDB7A4C0294DEE395EE32533812", hash_generated_method = "9E4D06176A8C81C8EE2C1DA904E8E091")
    
protected abstract void setState(State newState);

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.336 -0500", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "B2D46C83F0D5D8DC52CF45AA8A64DAEC")
    
public List<Connection> getConnections() {
        // FIXME should return Collections.unmodifiableList();
        return connections;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.338 -0500", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "2CA3BDACC129D60EAE4D95F06A3D2F50")
    
public boolean isMultiparty() {
        return connections.size() > 1;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.341 -0500", hash_original_method = "7D1F122E9D021AC073DB09CCD6084B65", hash_generated_method = "AE254132F7C591FD635DC3E850C99BF3")
    
public String toString() {
        return state.toString() + ":" + super.toString();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:23.343 -0500", hash_original_method = "2179B35862415320201802CDBF1F003D", hash_generated_method = "2179B35862415320201802CDBF1F003D")
    
void clearDisconnected() {
        for (Iterator<Connection> it = connections.iterator(); it.hasNext(); ) {
            Connection c = it.next();
            if (c.getState() == State.DISCONNECTED) it.remove();
        }

        if (connections.isEmpty()) setState(State.IDLE);
    }
    
}

