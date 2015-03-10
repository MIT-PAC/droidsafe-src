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
 * Copyright (C) 2007 The Android Open Source Project
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


package android.bluetooth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.bluetooth.AtCommandResult;

/**
 * Handler Interface for {@link AtParser}.<p>
 * @hide
 */
public abstract class AtCommandHandler {

    @DSComment("Added for droidsafe only")
    @DSSafe(DSCat.SAFE_OTHERS)
    protected AtCommandHandler() {}
    /**
     * Handle Basic commands "ATA".<p>
     * These are single letter commands such as ATA and ATD. Anything following
     * the single letter command ('A' and 'D' respectively) will be passed as
     * 'arg'.<p>
     * For example, "ATDT1234" would result in the call
     * handleBasicCommand("T1234").<p>
     * @param arg Everything following the basic command character.
     * @return    The result of this command.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.410 -0400", hash_original_method = "560E2BF09A0132513DD81769D9F4599B", hash_generated_method = "A924751863A408B26B5F2B63FD19E47B")
    
public AtCommandResult handleBasicCommand(String arg) {
        return new AtCommandResult(AtCommandResult.ERROR);
    }

    /**
     * Handle Actions command "AT+FOO".<p>
     * Action commands are part of the Extended command syntax, and are
     * typically used to signal an action on "FOO".<p>
     * @return The result of this command.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.415 -0400", hash_original_method = "0C7284D4698B6D9EDCE559C939F82D31", hash_generated_method = "4B1EC895048BE87C177505050F8A1F75")
    
public AtCommandResult handleActionCommand() {
        return new AtCommandResult(AtCommandResult.ERROR);
    }

    /**
     * Handle Read command "AT+FOO?".<p>
     * Read commands are part of the Extended command syntax, and are
     * typically used to read the value of "FOO".<p>
     * @return The result of this command.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.419 -0400", hash_original_method = "3D1D436C307AD2BB06496F9C5BF09A1F", hash_generated_method = "6A3B4FB9DE06F60D0FBCBA03B22CFCB2")
    
public AtCommandResult handleReadCommand() {
        return new AtCommandResult(AtCommandResult.ERROR);
    }

    /**
     * Handle Set command "AT+FOO=...".<p>
     * Set commands are part of the Extended command syntax, and are
     * typically used to set the value of "FOO". Multiple arguments can be
     * sent.<p>
     * AT+FOO=[<arg1>[,<arg2>[,...]]]<p>
     * Each argument will be either numeric (Integer) or String.
     * handleSetCommand is passed a generic Object[] array in which each
     * element will be an Integer (if it can be parsed with parseInt()) or
     * String.<p>
     * Missing arguments ",," are set to empty Strings.<p>
     * @param args Array of String and/or Integer's. There will always be at
     *             least one element in this array.
     * @return     The result of this command.
     */
    // Typically used to set this parameter
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.424 -0400", hash_original_method = "3D19830D494646AEF9F1010DC4A51D20", hash_generated_method = "4F3149D65FD342105C98140E90B5F1B1")
    
public AtCommandResult handleSetCommand(Object[] args) {
        return new AtCommandResult(AtCommandResult.ERROR);
    }

    /**
     * Handle Test command "AT+FOO=?".<p>
     * Test commands are part of the Extended command syntax, and are typically
     * used to request an indication of the range of legal values that "FOO"
     * can take.<p>
     * By default we return an OK result, to indicate that this command is at
     * least recognized.<p>
     * @return The result of this command.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:40:20.430 -0400", hash_original_method = "14018AAD7C4037FEC1E442AACA44DC71", hash_generated_method = "5AF250E1A2853433C52729DC2A32B1B2")
    
public AtCommandResult handleTestCommand() {
        return new AtCommandResult(AtCommandResult.OK);
    }

}
