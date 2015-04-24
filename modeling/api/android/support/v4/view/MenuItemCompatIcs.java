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
 * Copyright (C) 2013 The Android Open Source Project
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


package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.MenuItem;

class MenuItemCompatIcs {
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.576 -0400", hash_original_method = "4B8CCCB17354081770D4346ABBDA6F3D", hash_generated_method = "7DA4082CDF5C7E18A369183234BE7B68")
    
public static boolean expandActionView(MenuItem item) {
        return item.expandActionView();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.579 -0400", hash_original_method = "96E9F7C2234269C2B00D1FBC2A74794F", hash_generated_method = "A1B37D789195769911C721C5E0D5FB29")
    
public static boolean collapseActionView(MenuItem item) {
        return item.collapseActionView();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.584 -0400", hash_original_method = "38AC527F8FFDD8192B0AB7EB073EA05A", hash_generated_method = "E6AE4634FE3E80F171939E283BF4CD2E")
    
public static boolean isActionViewExpanded(MenuItem item) {
        return item.isActionViewExpanded();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.588 -0400", hash_original_method = "03F26D583518D0771657FE4126C348DB", hash_generated_method = "AB53818EFD142C13D753EC8F58DF8C43")
    
public static MenuItem setOnActionExpandListener(MenuItem item,
            SupportActionExpandProxy listener) {
        return item.setOnActionExpandListener(new OnActionExpandListenerWrapper(listener));
    }

    /**
     * Work around the support lib's build dependency chain. The actual API-lib
     * depends on -ics, but -ics doesn't depend on the API-lib so it doesn't know
     * that MenuItemCompat.OnActionExpandListener exists.
     */
    interface SupportActionExpandProxy {
        boolean onMenuItemActionExpand(MenuItem item);
        boolean onMenuItemActionCollapse(MenuItem item);
    }

    // support => framework
    static class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private SupportActionExpandProxy mWrapped;

        public OnActionExpandListenerWrapper(SupportActionExpandProxy wrapped) {
            mWrapped = wrapped;
        }

        @Override
        public boolean onMenuItemActionExpand(MenuItem item) {
            return mWrapped.onMenuItemActionExpand(item);
        }

        @Override
        public boolean onMenuItemActionCollapse(MenuItem item) {
            return mWrapped.onMenuItemActionCollapse(item);
        }
    }
}
