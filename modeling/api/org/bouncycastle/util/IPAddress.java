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


package org.bouncycastle.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class IPAddress {
    /**
     * Validate the given IPv4 or IPv6 address.
     *
     * @param address the IP address as a String.
     *
     * @return true if a valid address, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.914 -0500", hash_original_method = "6FDFDCFB7822F2E4E0EEE4A5AC1F1A39", hash_generated_method = "B99B627752C96BA487CE34ACFF331411")
    
public static boolean isValid(
        String address)
    {
        return isValidIPv4(address) || isValidIPv6(address);
    }

    /**
     * Validate the given IPv4 or IPv6 address and netmask.
     *
     * @param address the IP address as a String.
     *
     * @return true if a valid address with netmask, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.916 -0500", hash_original_method = "BD7E958A7E0243B3E429B860CDBE19D2", hash_generated_method = "7EF5AD263C5F29EDB075634DFF2FFF6F")
    
public static boolean isValidWithNetMask(
        String address)
    {
        return isValidIPv4WithNetmask(address) || isValidIPv6WithNetmask(address);
    }

    /**
     * Validate the given IPv4 address.
     * 
     * @param address the IP address as a String.
     *
     * @return true if a valid IPv4 address, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.919 -0500", hash_original_method = "2FFE641FCC31BABE3C1FB0FB6868D963", hash_generated_method = "00C0A6F0F2ADCBDD7C7546E14A9F818E")
    
public static boolean isValidIPv4(
        String address)
    {
        if (address.length() == 0)
        {
            return false;
        }

        int octet;
        int octets = 0;
        
        String temp = address+".";

        int pos;
        int start = 0;
        while (start < temp.length()
            && (pos = temp.indexOf('.', start)) > start)
        {
            if (octets == 4)
            {
                return false;
            }
            try
            {
                octet = Integer.parseInt(temp.substring(start, pos));
            }
            catch (NumberFormatException ex)
            {
                return false;
            }
            if (octet < 0 || octet > 255)
            {
                return false;
            }
            start = pos + 1;
            octets++;
        }

        return octets == 4;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.922 -0500", hash_original_method = "E696BA1C969DDA5BF23AFF0738AF83A3", hash_generated_method = "EEB35F852719D9B22AEFC9FE17448073")
    
public static boolean isValidIPv4WithNetmask(
        String address)
    {
        int index = address.indexOf("/");
        String mask = address.substring(index + 1);

        return (index > 0) && isValidIPv4(address.substring(0, index))
                           && (isValidIPv4(mask) || isMaskValue(mask, 32));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.924 -0500", hash_original_method = "79249ACE48E4C55AFFBFA3F5604C2262", hash_generated_method = "A2A153EFF1D572344654103C4D43C1D8")
    
public static boolean isValidIPv6WithNetmask(
        String address)
    {
        int index = address.indexOf("/");
        String mask = address.substring(index + 1);

        return (index > 0) && (isValidIPv6(address.substring(0, index))
                           && (isValidIPv6(mask) || isMaskValue(mask, 128)));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.927 -0500", hash_original_method = "1BB0D96AE2C8F4F1CE1C81F0FD974B5B", hash_generated_method = "43FB89ABF1DB3824AC46F6A59741F7A1")
    
private static boolean isMaskValue(String component, int size)
    {
        try
        {
            int value = Integer.parseInt(component);

            return value >= 0 && value <= size;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    /**
     * Validate the given IPv6 address.
     *
     * @param address the IP address as a String.
     *
     * @return true if a valid IPv4 address, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.930 -0500", hash_original_method = "4D880652E7EC26E2F7EA6DDC90C16CDC", hash_generated_method = "9BEBEFE6425AA3B8A8896CBA9E77B889")
    
public static boolean isValidIPv6(
        String address)
    {
        if (address.length() == 0)
        {
            return false;
        }

        int octet;
        int octets = 0;

        String temp = address + ":";
        boolean doubleColonFound = false;
        int pos;
        int start = 0;
        while (start < temp.length()
            && (pos = temp.indexOf(':', start)) >= start)
        {
            if (octets == 8)
            {
                return false;
            }

            if (start != pos)
            {
                String value = temp.substring(start, pos);

                if (pos == (temp.length() - 1) && value.indexOf('.') > 0)
                {
                    if (!isValidIPv4(value))
                    {
                        return false;
                    }

                    octets++; // add an extra one as address covers 2 words.
                }
                else
                {
                    try
                    {
                        octet = Integer.parseInt(temp.substring(start, pos), 16);
                    }
                    catch (NumberFormatException ex)
                    {
                        return false;
                    }
                    if (octet < 0 || octet > 0xffff)
                    {
                        return false;
                    }
                }
            }
            else
            {
                if (pos != 1 && pos != temp.length() - 1 && doubleColonFound)
                {
                    return false;
                }
                doubleColonFound = true;
            }
            start = pos + 1;
            octets++;
        }

        return octets == 8 || doubleColonFound;
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.201 -0400", hash_original_method = "5836548C92C6B5CB4E6ABB2C3D2D08AC", hash_generated_method = "5836548C92C6B5CB4E6ABB2C3D2D08AC")
    public IPAddress ()
    {
        //Synthesized constructor
    }
    
}

