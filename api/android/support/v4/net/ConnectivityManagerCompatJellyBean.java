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
import android.net.ConnectivityManager;

/**
 * Implementation of ConnectivityManagerCompat that can use Jellybean APIs.
 */
class ConnectivityManagerCompatJellyBean {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.458 -0400", hash_original_method = "B1FC19CCE287F8E14F62EA49FCB597CD", hash_generated_method = "A0C5777474F30754FDA901AAC25B0982")
    
public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        return cm.isActiveNetworkMetered();
    }
}
