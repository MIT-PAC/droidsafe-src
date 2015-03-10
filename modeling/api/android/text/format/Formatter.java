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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.text.format;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.net.NetworkUtils;

public final class Formatter {

    /**
     * Formats a content size to be in the form of bytes, kilobytes, megabytes, etc
     *
     * @param context Context to use to load the localized units
     * @param number size value to be formatted
     * @return formatted string with the number
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.371 -0500", hash_original_method = "DC56F1E18CD1755F16D6493522100254", hash_generated_method = "D3598CFE5F5174ED8EE1FF7B6118D260")
    
public static String formatFileSize(Context context, long number) {
        return formatFileSize(context, number, false);
    }

    /**
     * Like {@link #formatFileSize}, but trying to generate shorter numbers
     * (showing fewer digits of precision).
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.373 -0500", hash_original_method = "DAB82976D16A0D6212EFE29EDEB70CAF", hash_generated_method = "F45DDB9658DA0BA299DED556C4484D86")
    
public static String formatShortFileSize(Context context, long number) {
        return formatFileSize(context, number, true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.378 -0500", hash_original_method = "7861A6C88DACFCACDFF217A58ACD485F", hash_generated_method = "0BB14DB7BC814C6E06D9ED6E5071DF00")
    
private static String formatFileSize(Context context, long number, boolean shorter) {
        if (context == null) {
            return "";
        }

        float result = number;
        int suffix = com.android.internal.R.string.byteShort;
        if (result > 900) {
            suffix = com.android.internal.R.string.kilobyteShort;
            result = result / 1024;
        }
        if (result > 900) {
            suffix = com.android.internal.R.string.megabyteShort;
            result = result / 1024;
        }
        if (result > 900) {
            suffix = com.android.internal.R.string.gigabyteShort;
            result = result / 1024;
        }
        if (result > 900) {
            suffix = com.android.internal.R.string.terabyteShort;
            result = result / 1024;
        }
        if (result > 900) {
            suffix = com.android.internal.R.string.petabyteShort;
            result = result / 1024;
        }
        String value;
        if (result < 1) {
            value = String.format("%.2f", result);
        } else if (result < 10) {
            if (shorter) {
                value = String.format("%.1f", result);
            } else {
                value = String.format("%.2f", result);
            }
        } else if (result < 100) {
            if (shorter) {
                value = String.format("%.0f", result);
            } else {
                value = String.format("%.2f", result);
            }
        } else {
            value = String.format("%.0f", result);
        }
        return context.getResources().
            getString(com.android.internal.R.string.fileSizeSuffix,
                      value, context.getString(suffix));
    }

    /**
     * Returns a string in the canonical IP format ###.###.###.### from a packed integer containing
     * the IP address.  The IP address is expected to be in little-endian format (LSB first). That
     * is, 0x01020304 will return "4.3.2.1".
     *
     * @param ipv4Address the IP address as a packed integer with LSB first.
     * @return string with canonical IP address format.
     *
     * @deprecated this method doesn't support IPv6 addresses. Prefer {@link
     *     java.net.InetAddress#getHostAddress()}, which supports both IPv4 and
     *     IPv6 addresses.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:19.381 -0500", hash_original_method = "260063B43BB0DBB7B5FBB381EFCDB1A9", hash_generated_method = "2296DD251EC8DBEFE13B5CAD7F4219FE")
    
@Deprecated
    public static String formatIpAddress(int ipv4Address) {
        return NetworkUtils.intToInetAddress(ipv4Address).getHostAddress();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.728 -0400", hash_original_method = "161EB95286E2D4F6FBD55DBF919180AE", hash_generated_method = "161EB95286E2D4F6FBD55DBF919180AE")
    public Formatter ()
    {
        //Synthesized constructor
    }
    
}

