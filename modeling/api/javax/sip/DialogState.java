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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public enum DialogState {
    EARLY,
    CONFIRMED,
    TERMINATED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.579 -0500", hash_original_field = "526FF1F0204F6E5BDC4A5A3BA8AC00DD", hash_generated_field = "C9E06769341822B1B6CDB926DB447894")

    public static final int _EARLY = EARLY.ordinal();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.581 -0500", hash_original_field = "BF1B42EC270C501A0E364AFCDB1C8901", hash_generated_field = "6A63569C1D2E7D7796D040FAFB014DA5")

    public static final int _CONFIRMED = CONFIRMED.ordinal();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.583 -0500", hash_original_field = "01EAACFA2448F6FD637496456BF6E491", hash_generated_field = "6E7B7776A00009149ADAE13655EC6668")

    public static final int _TERMINATED = TERMINATED.ordinal();

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.586 -0500", hash_original_method = "E68636E8BD2193552FCB485AE2CFD8B1", hash_generated_method = "9899BF788BB60C2BE76A3E985826EF57")
        
public static DialogState getObject(int state) {
        try {
            return values()[state];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(
                    "Invalid dialog state: " + state);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.588 -0500", hash_original_method = "9ED8F0C6AD1AE480E401F51569E0D37D", hash_generated_method = "CA60F0DE8ACDF55C5A3448B65478BBA8")
        
public int getValue() {
        return ordinal();
    }
}
