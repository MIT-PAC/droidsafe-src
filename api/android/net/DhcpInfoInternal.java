/*
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

package android.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.text.TextUtils;
import android.util.Log;

import java.net.InetAddress;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * A simple object for retrieving the results of a DHCP request.
 * Replaces (internally) the IPv4-only DhcpInfo class.
 * @hide
 */
public class DhcpInfoInternal {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.888 -0500", hash_original_field = "3CB33298A4061ED1417213B63036FE0A", hash_generated_field = "A5674722483026F2F3006E7D0AABED55")

    private final static String TAG = "DhcpInfoInternal";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.891 -0500", hash_original_field = "902291576A6EA4536D6C9669E1B1BFD7", hash_generated_field = "CB9C78C1E059A1386FB49D6927F16131")

    public String ipAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.894 -0500", hash_original_field = "1AA9974238E4283C84A2103371F7F10F", hash_generated_field = "1B7FC41D1937ECDB5D304B36F5DCDEB8")

    public int prefixLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.896 -0500", hash_original_field = "DECD515C39266B6E455A2945E7B6E788", hash_generated_field = "6BA23B4699424291896C2FAB8F71E4ED")

    public String dns1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.899 -0500", hash_original_field = "3BACE6B3C988B24EAA427D1E5476EBA9", hash_generated_field = "6E1E48638CF1AA462ECA9ACEB7A55A1E")

    public String dns2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.905 -0500", hash_original_field = "D5280BD2879FEE9E6B031D97BBD9BA13", hash_generated_field = "31817BAB043228C64B0C1E44D880EEB3")

    public String serverAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.908 -0500", hash_original_field = "24726342E9CB33AC125472BB0EF00AFE", hash_generated_field = "7EE02913D8BA0209DD0BF7B47A6FCC6D")

    public int leaseDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.911 -0500", hash_original_field = "7FC020484225451DACED235B89B450B3", hash_generated_field = "0B305BD316BC734DE6D262B5BB826CC8")

    private Collection<RouteInfo> mRoutes;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.913 -0500", hash_original_method = "C24463A395F151F1ED18C8AE3DD2E8F1", hash_generated_method = "D598DB2FEE11DEDC87D5D95BE8F56029")
    public DhcpInfoInternal() {
        mRoutes = new ArrayList<RouteInfo>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.916 -0500", hash_original_method = "D197593071DA10611769AE1CA30B2E9D", hash_generated_method = "8218892E5F6779B99A4EB0D9A3FDB14C")
    public void addRoute(RouteInfo routeInfo) {
        mRoutes.add(routeInfo);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.919 -0500", hash_original_method = "A7B26240781BB7C0E135CB45CD0D9800", hash_generated_method = "7304006BADE7268B32CBBD8D9383478F")
    public Collection<RouteInfo> getRoutes() {
        return Collections.unmodifiableCollection(mRoutes);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.922 -0500", hash_original_method = "88E38A7A08EF7AB18CBA8BA26CF70492", hash_generated_method = "5F94BE3FE452A3599BCDB206D870547E")
    private int convertToInt(String addr) {
        if (addr != null) {
            try {
                InetAddress inetAddress = NetworkUtils.numericToInetAddress(addr);
                if (inetAddress instanceof Inet4Address) {
                    return NetworkUtils.inetAddressToInt(inetAddress);
                }
            } catch (IllegalArgumentException e) {}
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.928 -0500", hash_original_method = "E21558F1D3B0F886C686EEE0856B17CA", hash_generated_method = "D14067BA6F1F79FFB1B684D602200755")
    public DhcpInfo makeDhcpInfo() {
        DhcpInfo info = new DhcpInfo();
        info.ipAddress = convertToInt(ipAddress);
        for (RouteInfo route : mRoutes) {
            if (route.isDefaultRoute()) {
                info.gateway = convertToInt(route.getGateway().getHostAddress());
                break;
            }
        }
        try {
            InetAddress inetAddress = NetworkUtils.numericToInetAddress(ipAddress);
            info.netmask = NetworkUtils.prefixLengthToNetmaskInt(prefixLength);
        } catch (IllegalArgumentException e) {}
        info.dns1 = convertToInt(dns1);
        info.dns2 = convertToInt(dns2);
        info.serverAddress = convertToInt(serverAddress);
        info.leaseDuration = leaseDuration;
        return info;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.932 -0500", hash_original_method = "E411AAC6C17BC1F68BAF3D965F991BC4", hash_generated_method = "A714EBD6019A03D23873931E04D7F23B")
    public LinkAddress makeLinkAddress() {
        if (TextUtils.isEmpty(ipAddress)) {
            Log.e(TAG, "makeLinkAddress with empty ipAddress");
            return null;
        }
        return new LinkAddress(NetworkUtils.numericToInetAddress(ipAddress), prefixLength);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.937 -0500", hash_original_method = "583E02970D8F2DB474612F39E6C1AFB8", hash_generated_method = "56459B0291EA59802BFB2F58155865F8")
    public LinkProperties makeLinkProperties() {
        LinkProperties p = new LinkProperties();
        p.addLinkAddress(makeLinkAddress());
        for (RouteInfo route : mRoutes) {
            p.addRoute(route);
        }
        //if empty, connectivity configures default DNS
        if (TextUtils.isEmpty(dns1) == false) {
            p.addDns(NetworkUtils.numericToInetAddress(dns1));
        } else {
            Log.d(TAG, "makeLinkProperties with empty dns1!");
        }
        if (TextUtils.isEmpty(dns2) == false) {
            p.addDns(NetworkUtils.numericToInetAddress(dns2));
        } else {
            Log.d(TAG, "makeLinkProperties with empty dns2!");
        }
        return p;
    }

    /* Updates the DHCP fields that need to be retained from
     * original DHCP request if the DHCP renewal shows them as
     * being empty
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.940 -0500", hash_original_method = "D98D8E99473C35647F4B15EE83EDDE71", hash_generated_method = "7BCA037AA83813C2E92D300B92FA039C")
    public void updateFromDhcpRequest(DhcpInfoInternal orig) {
        if (orig == null) return;

        if (TextUtils.isEmpty(dns1)) {
            dns1 = orig.dns1;
        }

        if (TextUtils.isEmpty(dns2)) {
            dns2 = orig.dns2;
        }

        if (mRoutes.size() == 0) {
            for (RouteInfo route : orig.getRoutes()) {
                addRoute(route);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-29 15:18:49.944 -0500", hash_original_method = "4AA9FBC2D45E1110E54A5D07C5B867F3", hash_generated_method = "3F4A5CA090E96D2F4C531A5FED0F07B2")
    public String toString() {
        String routeString = "";
        for (RouteInfo route : mRoutes) routeString += route.toString() + " | ";
        return "addr: " + ipAddress + "/" + prefixLength +
                " mRoutes: " + routeString +
                " dns: " + dns1 + "," + dns2 +
                " dhcpServer: " + serverAddress +
                " leaseDuration: " + leaseDuration;
    }
}
