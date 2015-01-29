/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.MenuItem;

/**
 * Helper for accessing features in {@link android.view.Menu}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class MenuCompat {

    /**
     * Interface for the full API.
     */
    interface MenuVersionImpl {
        public boolean setShowAsAction(MenuItem item, int actionEnum);
    }

    /**
     * Interface implementation that doesn't use anything about v4 APIs.
     */
    static class BaseMenuVersionImpl implements MenuVersionImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:30.547 -0500", hash_original_method = "7F014EF22317C05910A706092D499BCA", hash_generated_method = "89BB310A989C6FF93C741B0EF53FBAE6")
        
@Override
        public boolean setShowAsAction(MenuItem item, int actionEnum) {
            return false;
        }
    }

    /**
     * Interface implementation for devices with at least v11 APIs.
     */
    static class HoneycombMenuVersionImpl implements MenuVersionImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:30.549 -0500", hash_original_method = "F1D99359C312DFE7F282494BE8BB96CD", hash_generated_method = "EA0914BF60B1334207BB9253E2344C05")
        
@Override
        public boolean setShowAsAction(MenuItem item, int actionEnum) {
            MenuItemCompatHoneycomb.setShowAsAction(item, actionEnum);
            return true;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:30.551 -0500", hash_original_field = "8028B97E4B96DA4F8B25DB17232BD5A2", hash_generated_field = "4E3138D2C8B4893576326933CC27438B")

    static  MenuVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombMenuVersionImpl();
        } else {
            IMPL = new BaseMenuVersionImpl();
        }
    }

    // -------------------------------------------------------------------

    /**
     * Call {@link MenuItem#setShowAsAction(int) MenuItem.setShowAsAction()}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#HONEYCOMB} device,
     * does nothing and returns false.  Otherwise returns true.
     *
     * @deprecated Use {@link MenuItemCompat#setShowAsAction(MenuItem, int)
     *     MenuItemCompat.setShowAsAction(MenuItem, int)}

     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:30.552 -0500", hash_original_method = "5464B522F72319259637DF43320B19A6", hash_generated_method = "12B28E79969300F0990EE2EDC1028CE1")
    
public static boolean setShowAsAction(MenuItem item, int actionEnum) {
        return IMPL.setShowAsAction(item, actionEnum);
    }
}
