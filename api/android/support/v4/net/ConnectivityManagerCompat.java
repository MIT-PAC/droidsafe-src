/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.support.v4.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import static android.net.ConnectivityManager.TYPE_MOBILE;
import static android.net.ConnectivityManager.TYPE_WIFI;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/**
 * Helper for accessing features in {@link ConnectivityManager} introduced after
 * API level 16 in a backwards compatible fashion.
 */
public class ConnectivityManagerCompat {

    interface ConnectivityManagerCompatImpl {
        boolean isActiveNetworkMetered(ConnectivityManager cm);
    }

    static class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.722 -0500", hash_original_method = "82C8914B64F105CF6CAB5824BAFDEDEF", hash_generated_method = "2BDBA0B89DB22CCDA16A9D6C3B0F1B8A")
        
@Override
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            final NetworkInfo info = cm.getActiveNetworkInfo();
            if (info == null) {
                // err on side of caution
                return true;
            }

            final int type = info.getType();
            switch (type) {
                case TYPE_MOBILE:
                    return true;
                case TYPE_WIFI:
                    return false;
                default:
                    // err on side of caution
                    return true;
            }
        }
    }

    static class GingerbreadConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.733 -0500", hash_original_method = "14319738A596A0F37A5E22E9913AC983", hash_generated_method = "9DCB1CAC48FF9418B38218C438825F98")
        
@Override
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(cm);
        }
    }

    static class HoneycombMR2ConnectivityManagerCompatImpl
            implements ConnectivityManagerCompatImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.747 -0500", hash_original_method = "EB30443802E74F0983577B9D919AABB3", hash_generated_method = "19EB91090445F3487FB91B1EB6667D27")
        
@Override
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(cm);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.757 -0500", hash_original_field = "98D4FEAE4D74781E5C7D506BA2049F3B", hash_generated_field = "1F929D9DFBE6D25785432D16CEEE3F39")


    private static  ConnectivityManagerCompatImpl IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 13) {
            IMPL = new HoneycombMR2ConnectivityManagerCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 8) {
            IMPL = new GingerbreadConnectivityManagerCompatImpl();
        } else {
            IMPL = new BaseConnectivityManagerCompatImpl();
        }
    }

    /**
     * Returns if the currently active data network is metered. A network is
     * classified as metered when the user is sensitive to heavy data usage on
     * that connection. You should check this before doing large data transfers,
     * and warn the user or delay the operation until another network is
     * available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.762 -0500", hash_original_method = "002F171FE72CB6AB63B275E71F0E1346", hash_generated_method = "930731E632109CC1EF5793A28C6DF82E")
    
public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        return IMPL.isActiveNetworkMetered(cm);
    }

    /**
     * Return the {@link NetworkInfo} that caused the given
     * {@link ConnectivityManager#CONNECTIVITY_ACTION} broadcast. This obtains
     * the current state from {@link ConnectivityManager} instead of using the
     * potentially-stale value from
     * {@link ConnectivityManager#EXTRA_NETWORK_INFO}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.766 -0500", hash_original_method = "B5D2929AF51F9EC227FA93BC6AC1D13F", hash_generated_method = "D9576F332F39CC0B6F2F6C8F46671305")
    
public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager cm, Intent intent) {
        final NetworkInfo info = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
        return cm.getNetworkInfo(info.getType());
    }
}
