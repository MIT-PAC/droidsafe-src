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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.view.SubMenu;

import java.util.HashMap;
import java.util.Iterator;

abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.164 -0400", hash_original_field = "4E9A38ADDCA7C688C2240E9397F4BC67", hash_generated_field = "098A10632CBF1758751A8B44C2122C5E")

    private HashMap<MenuItem, SupportMenuItem> mMenuItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.167 -0400", hash_original_field = "C7A493738C6DD4A2EC7EC6A9D228BBEE", hash_generated_field = "8291566C9E072580634A5B218403990E")

    private HashMap<SubMenu, SubMenu> mSubMenus;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.169 -0400", hash_original_method = "4FBC667C8E44DAD3C66B512AA14C6ADC", hash_generated_method = "4FBC667C8E44DAD3C66B512AA14C6ADC")
    
BaseMenuWrapper(T object) {
        super(object);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.173 -0400", hash_original_method = "A6D8BC8B70287AEB2AC72C0DFCFF7C42", hash_generated_method = "995B359119DF4A1DC0E7B1695AED5603")
    
final SupportMenuItem getMenuItemWrapper(android.view.MenuItem frameworkItem) {
        if (frameworkItem != null) {
            // Instantiate HashMap if null
            if (mMenuItems == null) {
                mMenuItems = new HashMap<MenuItem, SupportMenuItem>();
            }

            SupportMenuItem compatItem = mMenuItems.get(frameworkItem);

            if (null == compatItem) {
                compatItem = MenuWrapperFactory.createSupportMenuItemWrapper(frameworkItem);
                mMenuItems.put(frameworkItem, compatItem);
            }

            return compatItem;
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.177 -0400", hash_original_method = "8FBBC91EC999734690BF004A9EFD6627", hash_generated_method = "596F91010163DF4AA954BE739E541041")
    
final SubMenu getSubMenuWrapper(android.view.SubMenu frameworkSubMenu) {
        if (frameworkSubMenu != null) {
            // Instantiate HashMap if null
            if (mSubMenus == null) {
                mSubMenus = new HashMap<android.view.SubMenu, SubMenu>();
            }

            SubMenu compatSubMenu = mSubMenus.get(frameworkSubMenu);

            if (null == compatSubMenu) {
                compatSubMenu = MenuWrapperFactory.createSupportSubMenuWrapper(frameworkSubMenu);
                mSubMenus.put(frameworkSubMenu, compatSubMenu);
            }
            return compatSubMenu;
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.181 -0400", hash_original_method = "E549614518765980654D955A3A4AAEAD", hash_generated_method = "32246BD159BB6BD6D4DA490538283A8F")
    
final void internalClear() {
        if (mMenuItems != null) {
            mMenuItems.clear();
        }
        if (mSubMenus != null) {
            mSubMenus.clear();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.184 -0400", hash_original_method = "645C0050BD2DD88EB3A23A012B738566", hash_generated_method = "0433E0130532C4F46E6A01E3449B214C")
    
final void internalRemoveGroup(final int groupId) {
        if (mMenuItems == null) {
            return;
        }

        Iterator<android.view.MenuItem> iterator = mMenuItems.keySet().iterator();
        android.view.MenuItem menuItem;

        while (iterator.hasNext()) {
            menuItem = iterator.next();
            if (groupId == menuItem.getGroupId()) {
                iterator.remove();
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:37.187 -0400", hash_original_method = "D302BEEAB3BEEB8612C6C303FB1EC35D", hash_generated_method = "A5E8CB74922D975F2DEFE0955080700B")
    
final void internalRemoveItem(final int id) {
        if (mMenuItems == null) {
            return;
        }

        Iterator<android.view.MenuItem> iterator = mMenuItems.keySet().iterator();
        android.view.MenuItem menuItem;

        while (iterator.hasNext()) {
            menuItem = iterator.next();
            if (id == menuItem.getItemId()) {
                iterator.remove();
                break;
            }
        }
    }
}
