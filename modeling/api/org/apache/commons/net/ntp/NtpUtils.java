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


package org.apache.commons.net.ntp;
/*
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

/***
 * Common NtpUtils Helper class.
 *
 * @author Jason Mathews, MITRE Corp
 *
 * @version $Revision: 165675 $ $Date: 2005-05-02 15:09:55 -0500 (Mon, 02 May 2005) $
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class NtpUtils {

    /***
      * Returns 32-bit integer address to IPv4 address string "%d.%d.%d.%d" format.
      *
      * @param address  the 32-bit address
      * @return  the raw IP address in a string format.
      */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.764 -0500", hash_original_method = "3A89BF8D0899EE941D1C854D478EF80D", hash_generated_method = "0D6F1AE93A20D25D2483A9BA05179018")
    
public static String getHostAddress(int address)
     {
          return ((address >>> 24) & 0xFF) + "." +
                 ((address >>> 16) & 0xFF) + "." +
                 ((address >>>  8) & 0xFF) + "." +
                 ((address >>>  0) & 0xFF);
     }

    /***
     * Returns NTP packet reference identifier as IP address.
     *
     * @param packet  NTP packet
     * @return  the packet reference id (as IP address) in "%d.%d.%d.%d" format.
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.769 -0500", hash_original_method = "56743B55A79F6884A1D2FA9E66793632", hash_generated_method = "8D7641C9FD875C537E737D3240DD191B")
    
public static String getRefAddress(NtpV3Packet packet)
     {
         int address = (packet == null) ? 0 : packet.getReferenceId();
         return getHostAddress(address);
     }

    /***
     * Get refId as reference clock string (e.g. GPS, WWV, LCL). If string is
     * invalid (non-ASCII character) then returns empty string "".
     * For details refer to the <A HREF="http://www.eecis.udel.edu/~mills/ntp/html/refclock.html#list">Comprehensive
     * List of Clock Drivers</A>.
     *
     * @param message
     * @return reference clock string if primary NTP server
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.776 -0500", hash_original_method = "77A4D1DF86472A322275030511C84DF2", hash_generated_method = "CC025DAECE0B4195D7F9F2FE83D05767")
    
public static String getReferenceClock(NtpV3Packet message) {
        if (message == null)
            return "";
        int refId = message.getReferenceId();
        if (refId == 0)
            return "";
        StringBuffer buf = new StringBuffer(4);
        // start at highest-order byte (0x4c434c00 -> LCL)
        for (int shiftBits = 24; shiftBits >= 0; shiftBits -= 8)
        {
            char c = (char) ((refId >>> shiftBits) & 0xff);
            if (c == 0) break; // 0-terminated ASCII string
            if (!Character.isLetterOrDigit(c))
                return "";
            buf.append(c);
        }
        return buf.toString();
    }

    /***
     * Return human-readable name of message mode type (RFC 1305).
     *
     * @param mode
     * @return mode name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.786 -0500", hash_original_method = "4F7948B4A5DE727242D8EEC8BA49FA7D", hash_generated_method = "D422BB23D98D23FEBFF2FB1FD2EB7F3A")
    
public static String getModeName(int mode)
    {
        switch (mode) {
            case NtpV3Packet.MODE_RESERVED:
                return "Reserved";
            case NtpV3Packet.MODE_SYMMETRIC_ACTIVE:
                return "Symmetric Active";
            case NtpV3Packet.MODE_SYMMETRIC_PASSIVE:
                return "Symmetric Passive";
            case NtpV3Packet.MODE_CLIENT:
                return "Client";
            case NtpV3Packet.MODE_SERVER:
                return "Server";
            case NtpV3Packet.MODE_BROADCAST:
                return "Broadcast";
            case NtpV3Packet.MODE_CONTROL_MESSAGE:
                return "Control";
            case NtpV3Packet.MODE_PRIVATE:
                return "Private";
            default:
                return "Unknown";
        }
    }

}
