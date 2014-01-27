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
import static android.net.ConnectivityManager.TYPE_BLUETOOTH;
import static android.net.ConnectivityManager.TYPE_ETHERNET;
import static android.net.ConnectivityManager.TYPE_MOBILE;
import static android.net.ConnectivityManager.TYPE_MOBILE_DUN;
import static android.net.ConnectivityManager.TYPE_MOBILE_HIPRI;
import static android.net.ConnectivityManager.TYPE_MOBILE_MMS;
import static android.net.ConnectivityManager.TYPE_MOBILE_SUPL;
import static android.net.ConnectivityManager.TYPE_WIFI;
import static android.net.ConnectivityManager.TYPE_WIMAX;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Implementation of ConnectivityManagerCompat that can use Honeycomb MR2 APIs.
 */
class ConnectivityManagerCompatHoneycombMR2 {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.921 -0500", hash_original_method = "AE16958E049AF3298F03043273C994A2", hash_generated_method = "EEC2362FDCB8ABC195A4E52C4E83EC56")
    
public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        final NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            // err on side of caution
            return true;
        }

        final int type = info.getType();
        switch (type) {
            case TYPE_MOBILE:
            case TYPE_MOBILE_DUN:
            case TYPE_MOBILE_HIPRI:
            case TYPE_MOBILE_MMS:
            case TYPE_MOBILE_SUPL:
            case TYPE_WIMAX:
                return true;
            case TYPE_WIFI:
            case TYPE_BLUETOOTH:
            case TYPE_ETHERNET:
                return false;
            default:
                // err on side of caution
                return true;
        }
    }
}
