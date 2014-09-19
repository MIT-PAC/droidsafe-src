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

package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;

/**
 * @hide
 */
public final class MenuWrapperFactory {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.791 -0400", hash_original_method = "A7DB189133F11D01232564292CF2F9B5", hash_generated_method = "2DDCDA83FE8AE225A6D5FE39DFE9690A")
    
public static Menu createMenuWrapper(android.view.Menu frameworkMenu) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return new MenuWrapperICS(frameworkMenu);
        }
        return frameworkMenu;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.795 -0400", hash_original_method = "1486C69AD9CF92997B6FD39F62B7C24F", hash_generated_method = "30497D7840D7443D90E1B3BC0374B7E9")
    
public static MenuItem createMenuItemWrapper(android.view.MenuItem frameworkMenuItem) {
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return new MenuItemWrapperJB(frameworkMenuItem);
        } else*/ if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return new MenuItemWrapperICS(frameworkMenuItem);
        }
        return frameworkMenuItem;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.798 -0400", hash_original_method = "1069FA1263646F3B59D288EE288BB390", hash_generated_method = "7A0CF91035B4364E33C504503B0C2082")
    
public static SupportMenu createSupportMenuWrapper(android.view.Menu frameworkMenu) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return new MenuWrapperICS(frameworkMenu);
        }
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.802 -0400", hash_original_method = "C34963244CC7679A5C7C787AB9EB8753", hash_generated_method = "6C09B453779ED50A7E1E9A7F4DC02FBF")
    
public static SupportSubMenu createSupportSubMenuWrapper(
            android.view.SubMenu frameworkSubMenu) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return new SubMenuWrapperICS(frameworkSubMenu);
        }
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.806 -0400", hash_original_method = "F4F86DC1898C0732ECA5A7C3F74FC1BF", hash_generated_method = "1BFE975CA6CD5305DF3691E7C1C3C2CF")
    
public static SupportMenuItem createSupportMenuItemWrapper(
            android.view.MenuItem frameworkMenuItem) {
   /*     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return new MenuItemWrapperJB(frameworkMenuItem);
        } else*/ if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return new MenuItemWrapperICS(frameworkMenuItem);
        }
        throw new UnsupportedOperationException();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.789 -0400", hash_original_method = "9E2357C480A9641874C03D0FB962FFF1", hash_generated_method = "D69778811C1A463141DC9DA221441566")
    
private MenuWrapperFactory() {
    }
}
