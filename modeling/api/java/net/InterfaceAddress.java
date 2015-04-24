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
 * Copyright (C) 2009 The Android Open Source Project
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


package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class InterfaceAddress {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.534 -0500", hash_original_method = "5E42B457EFC972934681320D52288B28", hash_generated_method = "CC498109EDA786AF03805FD940E7B974")
    
private static short countPrefixLength(Inet4Address mask) {
        short count = 0;
        for (byte b : mask.ipaddress) {
            for (int i = 0; i < 8; ++i) {
                if ((b & (1 << i)) != 0) {
                    ++count;
                }
            }
        }
        return count;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.521 -0500", hash_original_field = "FDCE7272CFC91A6374FBF7F54D5CC8E4", hash_generated_field = "220CE3F94E98B4B531A4938FAFF932C0")

    private  InetAddress address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.523 -0500", hash_original_field = "FD82BD1E05F694B18AD13EC3FE2836DA", hash_generated_field = "7567F98825AE2C855E0ED195DA10645B")

    private  InetAddress broadcastAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.526 -0500", hash_original_field = "F05D18D1D3B9AB4289B6E58A48EDE89D", hash_generated_field = "70DE7742499AEA0A92EA72A6919A370C")

    private  short prefixLength;

    /**
     * For IPv4.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.528 -0500", hash_original_method = "A47E632924417AF09C6FD6A35089DC11", hash_generated_method = "A47E632924417AF09C6FD6A35089DC11")
    
InterfaceAddress(Inet4Address address, Inet4Address broadcastAddress, Inet4Address mask) {
        this.address = address;
        this.broadcastAddress = broadcastAddress;
        this.prefixLength = countPrefixLength(mask);
    }

    /**
     * For IPv6.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.531 -0500", hash_original_method = "48C591F4E78B8661DAF333100DFF1834", hash_generated_method = "48C591F4E78B8661DAF333100DFF1834")
    
InterfaceAddress(Inet6Address address, short prefixLength) {
        this.address = address;
        this.broadcastAddress = null;
        this.prefixLength = prefixLength;
    }

    /**
     * Tests whether this object is equal to another one. Returns true if
     * the address, broadcast address and prefix length are all equal.
     *
     * @param obj the object to be compared.
     * @return true if 'obj' is equal to this InterfaceAddress, false otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.536 -0500", hash_original_method = "C2F63B53807D79A96FCD6544A2D6E3D6", hash_generated_method = "037E561A4D8893183D46362A102CCF13")
    
@Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (!(obj instanceof InterfaceAddress)) {
            return false;
        }
        InterfaceAddress rhs = (InterfaceAddress) obj;
        return ((address == null) ? rhs.address == null : address.equals(rhs.address)) &&
                (rhs.prefixLength == prefixLength) &&
                ((broadcastAddress == null) ? rhs.broadcastAddress == null : broadcastAddress.equals(rhs.broadcastAddress));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.539 -0500", hash_original_method = "2A9C5EEED856061F72C9734D5432AB47", hash_generated_method = "75B59DC663BD7BA53E5BA8D9940EB99D")
    
@Override
    public int hashCode() {
        int hashCode = address == null ? 0 : -address.hashCode();
        hashCode += broadcastAddress == null ? 0 : broadcastAddress.hashCode();
        hashCode += prefixLength;
        return hashCode;
    }

    /**
     * Returns a string representation for this interface address.
     * The string is of the form: InetAddress / prefix length [ broadcast address ].
     *
     * @return a string representation of this interface address.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.541 -0500", hash_original_method = "1F9308CDA843BEB3E12C5EE04150EA0F", hash_generated_method = "5A48EECAEA405813D0EF7C215F9BE110")
    
@Override
    public String toString() {
        return address + "/" + prefixLength + " [" + broadcastAddress + "]";
    }

    /**
     * Returns the InetAddress for this address.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.543 -0500", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "824B3030C6402BCEBDA9F70F4F75F58E")
    
public InetAddress getAddress() {
        return address;
    }

    /**
     * Returns the subnet-directed broadcast address if this is an IPv4 interface, null otherwise.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.546 -0500", hash_original_method = "CFDC66E7DE04051E5606E381D802784E", hash_generated_method = "28382B4EA9311AEBD96E8227D2E78F72")
    
public InetAddress getBroadcast() {
        return broadcastAddress;
    }

    /**
     * Returns the network prefix length in bits.
     * (In IPv4 parlance, this is known as the subnet mask,
     * but this method applies to IPv6 addresses too.)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:15.548 -0500", hash_original_method = "D89613E4F9F0153F2E4A2BF9077CFCE5", hash_generated_method = "9D16C80E8CA50D4C88AD9AD11B498561")
    
public short getNetworkPrefixLength() {
        return prefixLength;
    }
    
}

