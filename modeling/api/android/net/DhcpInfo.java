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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class DhcpInfo implements Parcelable {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.824 -0500", hash_original_method = "C4630BCCACA5913D9EFE445952131BDB", hash_generated_method = "D7100706F3DA9D35C8228CA2981296E2")
    
private static void putAddress(StringBuffer buf, int addr) {
        buf.append(NetworkUtils.intToInetAddress(addr).getHostAddress());
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.466 -0400", hash_original_field = "9856C027FECDC0A66630F7DFB04D7434", hash_generated_field = "89C286478D97EE5D122EFDEA836E1240")

    public static final Creator<DhcpInfo> CREATOR =
        new Creator<DhcpInfo>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.833 -0500", hash_original_method = "F44837DFDE4E00511933DFB4D7F0040E", hash_generated_method = "85828B4F335D384AAB760CCC0E316227")
        
public DhcpInfo createFromParcel(Parcel in) {
                DhcpInfo info = new DhcpInfo();
                info.ipAddress = in.readInt();
                info.gateway = in.readInt();
                info.netmask = in.readInt();
                info.dns1 = in.readInt();
                info.dns2 = in.readInt();
                info.serverAddress = in.readInt();
                info.leaseDuration = in.readInt();
                return info;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.835 -0500", hash_original_method = "807ED57C7D32921184285C1BE9B084C4", hash_generated_method = "3518739E05DCDA6E387E2861AEA6FF25")
        
public DhcpInfo[] newArray(int size) {
                return new DhcpInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.802 -0500", hash_original_field = "A3E13DDDECF36DAF88A56A59296668A5", hash_generated_field = "C724F9C20BA29ABA1B784CD7B6F790AC")

    public int ipAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.804 -0500", hash_original_field = "FCAFB9569CC67D1E952DD189A971899E", hash_generated_field = "4A25F063CFF1A08AFBDF399724369996")

    public int gateway;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.807 -0500", hash_original_field = "2127ED5D8320FEA86C37CF2425D37D98", hash_generated_field = "425E646BC1F92E2E3580929E14D019CB")

    public int netmask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.809 -0500", hash_original_field = "DD5C00C7D698690DB50DDE4E11D9B847", hash_generated_field = "257F82C9AA70827B0BA2B4E037775503")

    public int dns1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.811 -0500", hash_original_field = "BB166109CA3E3292037E187A9AD0424A", hash_generated_field = "BC9DD1C3178F0AAF32A5A79882B2C471")

    public int dns2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.813 -0500", hash_original_field = "EFA5EDCAD00909BB1BE02EB7F655FE09", hash_generated_field = "955CDA6770D7F45900D23A25A1E286DF")

    public int serverAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.815 -0500", hash_original_field = "24726342E9CB33AC125472BB0EF00AFE", hash_generated_field = "7EE02913D8BA0209DD0BF7B47A6FCC6D")

    public int leaseDuration;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.817 -0500", hash_original_method = "C1DF7E5F229CB04932AB2C91464EDDF1", hash_generated_method = "277E1F8AB1BB05F0D3B5C79F1B46AC7E")
    
public DhcpInfo() {
        super();
    }

    /** copy constructor {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.820 -0500", hash_original_method = "39B86796FD777927684A932467EC8639", hash_generated_method = "2FBB47A3EC6B3E550F24020D0D93A7B3")
    
public DhcpInfo(DhcpInfo source) {
        if (source != null) {
            ipAddress = source.ipAddress;
            gateway = source.gateway;
            netmask = source.netmask;
            dns1 = source.dns1;
            dns2 = source.dns2;
            serverAddress = source.serverAddress;
            leaseDuration = source.leaseDuration;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.822 -0500", hash_original_method = "8D7B8EC19D16628B2975B72E53B9E8C8", hash_generated_method = "5249A72ACA966A97676F9DF740D3607F")
    
public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("ipaddr "); putAddress(str, ipAddress);
        str.append(" gateway "); putAddress(str, gateway);
        str.append(" netmask "); putAddress(str, netmask);
        str.append(" dns1 "); putAddress(str, dns1);
        str.append(" dns2 "); putAddress(str, dns2);
        str.append(" DHCP server "); putAddress(str, serverAddress);
        str.append(" lease ").append(leaseDuration).append(" seconds");

        return str.toString();
    }

    /** Implement the Parcelable interface {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.826 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:06.828 -0500", hash_original_method = "EAB5EBBB3C53B9EB39B520A9586CC73F", hash_generated_method = "0B1B8DFE449710908AA68F64708C7A53")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ipAddress);
        dest.writeInt(gateway);
        dest.writeInt(netmask);
        dest.writeInt(dns1);
        dest.writeInt(dns2);
        dest.writeInt(serverAddress);
        dest.writeInt(leaseDuration);
    }
    // orphaned legacy method
    public DhcpInfo createFromParcel(Parcel in) {
                DhcpInfo info = new DhcpInfo();
                info.ipAddress = in.readInt();
                info.gateway = in.readInt();
                info.netmask = in.readInt();
                info.dns1 = in.readInt();
                info.dns2 = in.readInt();
                info.serverAddress = in.readInt();
                info.leaseDuration = in.readInt();
                return info;
            }
    
    // orphaned legacy method
    public DhcpInfo[] newArray(int size) {
                return new DhcpInfo[size];
            }
    
}

