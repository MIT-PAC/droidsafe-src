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
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.net.pop3;

/***
 * POP3Command stores POP3 command code constants.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class POP3Command
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.765 -0500", hash_original_field = "38740774723BFB990EBC4D8EB07A209F", hash_generated_field = "BC090F0E8C06B8BB8BF776FFEE0B6ACE")

    public static final int USER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.768 -0500", hash_original_field = "4FA57327CED6694145C49B079534E64B", hash_generated_field = "38CB5C658F7C6AEB8DDE1659AEF7BFC4")

    public static final int PASS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.771 -0500", hash_original_field = "C34022A33AC7DDA285F719858070E8B7", hash_generated_field = "0A3AC8F7D3D36FC2FB396DDA0C4B855C")

    public static final int QUIT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.775 -0500", hash_original_field = "2D2DDB630611C4C05B2032597C8EC76B", hash_generated_field = "6D1CADC86CAAE859E9B799B84AD9AB76")

    public static final int STAT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.778 -0500", hash_original_field = "F36AE467F12BC9ECAF4F7A3672950D32", hash_generated_field = "3B444C312800B02515940D5B8333CC08")

    public static final int LIST = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.781 -0500", hash_original_field = "F0C983A6D7E917CEB407D987538665D5", hash_generated_field = "96BA847AAD36AF73A9D35E95F61DBA97")

    public static final int RETR = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.785 -0500", hash_original_field = "DF9BA37D126268D64D65F5A35A751A8F", hash_generated_field = "FDE057B24460BACF7F62B849B5BD909E")

    public static final int DELE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.788 -0500", hash_original_field = "CAEB7A0F5ED348F28DA23FD3E66A7DE6", hash_generated_field = "FEABF923C75FE26582AC2D5F12D9BC2B")

    public static final int NOOP = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.791 -0500", hash_original_field = "E160B0C518A45CCE5B6B3A31DC5464DF", hash_generated_field = "8F85B143DA18FF0F5D1885FE2C947E37")

    public static final int RSET = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.794 -0500", hash_original_field = "06CD89E662691945B7FE887EF77E64F4", hash_generated_field = "259138C13D250F79B9655289AC835EE0")

    public static final int APOP = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.797 -0500", hash_original_field = "478D1AA58FE7D5CF0AAB383B1926939F", hash_generated_field = "B919244D2CF62F2C1C9599A4AB693BF6")

    public static final int TOP = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.800 -0500", hash_original_field = "A6FCA946E629229CBAD503F2F8F92B24", hash_generated_field = "FA00EF2F3A9BE5C6021814791450AE1B")

    public static final int UIDL = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.803 -0500", hash_original_field = "3645B28A0B89C49B56FD0AF2EF2342CE", hash_generated_field = "3CFD93D6314E605565F5FF4BBBF31320")

    static final String[] _commands = {
                                          "USER", "PASS", "QUIT", "STAT", "LIST", "RETR", "DELE", "NOOP", "RSET",
                                          "APOP", "TOP", "UIDL"
                                      };

    /***
     * Get the POP3 protocol string command corresponding to a command code.
     * <p>
     * @return The POP3 protocol string command corresponding to a command code.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.810 -0500", hash_original_method = "00EADAB9B7F650A465A01299B290A28E", hash_generated_method = "D266DA9BA95C2A211722ACB893ECDCA5")
    
public static final String getCommand(int command)
    {
        return _commands[command];
    }

    // Cannot be instantiated.
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.807 -0500", hash_original_method = "22F8EC87B5F45AEF318E46284FAECCA4", hash_generated_method = "4BB2A3295000D1FF764A83834DC41367")
    
private POP3Command()
    {}
}
