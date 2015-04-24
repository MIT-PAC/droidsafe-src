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
import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;

class MenuWrapperICS extends BaseMenuWrapper<android.view.Menu> implements SupportMenu {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.857 -0400", hash_original_method = "6BFB35B41D47E541FCF50EB7037C4A1B", hash_generated_method = "6BFB35B41D47E541FCF50EB7037C4A1B")
    
MenuWrapperICS(android.view.Menu object) {
        super(object);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.859 -0400", hash_original_method = "E5963349223FCB66135CA2FDBA300BAB", hash_generated_method = "C59D489A16EA4763F01753BE38F8776D")
    
@Override
    public MenuItem add(CharSequence title) {
        return getMenuItemWrapper(mWrappedObject.add(title));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.862 -0400", hash_original_method = "93BD16EA850DF6DE683D92CED021F27D", hash_generated_method = "6C731980B8C6A7FCCF745A256BC15F5B")
    
@Override
    public MenuItem add(int titleRes) {
        return getMenuItemWrapper(mWrappedObject.add(titleRes));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.867 -0400", hash_original_method = "0DE1CCF8EAA6088851A8388CC1EA1B64", hash_generated_method = "45B5BF929D1D9D688E889BE20B0E5DA9")
    
@Override
    public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
        return getMenuItemWrapper(mWrappedObject.add(groupId, itemId, order, title));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.870 -0400", hash_original_method = "7E959AC3BF06C53F28385A38C149DB55", hash_generated_method = "F8172535EEA314C12F42950CAD0D70D1")
    
@Override
    public MenuItem add(int groupId, int itemId, int order, int titleRes) {
        return getMenuItemWrapper(mWrappedObject.add(groupId, itemId, order, titleRes));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.872 -0400", hash_original_method = "0564BDF6FF184F2CE81C725D4969E10E", hash_generated_method = "F2CBA47E2516187A5954EF021F449E6E")
    
@Override
    public SubMenu addSubMenu(CharSequence title) {
        return getSubMenuWrapper(mWrappedObject.addSubMenu(title));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.875 -0400", hash_original_method = "11A9350C4E975F9033ECF4DC19842902", hash_generated_method = "E10750443D46F8EF16E163A4AEFE93F8")
    
@Override
    public SubMenu addSubMenu(int titleRes) {
        return getSubMenuWrapper(mWrappedObject.addSubMenu(titleRes));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.878 -0400", hash_original_method = "A48E8CC59CA576A0A963D8E89B03B434", hash_generated_method = "055BDD42392F721F43ED8F81F0F2C7C1")
    
@Override
    public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {
        return getSubMenuWrapper(mWrappedObject.addSubMenu(groupId, itemId, order, title));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.881 -0400", hash_original_method = "891F454B1BFB04C2846763CE46C85A67", hash_generated_method = "86BC7A6BF4FA85BE711D9E9299CAE8CB")
    
@Override
    public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
        return getSubMenuWrapper(
                mWrappedObject.addSubMenu(groupId, itemId, order, titleRes));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.886 -0400", hash_original_method = "51FDEAE0CB87AA42A641ACD987D78CDD", hash_generated_method = "4B0D2D77C6A74B4027C53D902FCB0472")
    
@Override
    public int addIntentOptions(int groupId, int itemId, int order, ComponentName caller,
            Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        android.view.MenuItem[] items = null;
        if (outSpecificItems != null) {
            items = new android.view.MenuItem[outSpecificItems.length];
        }

        int result = mWrappedObject
                .addIntentOptions(groupId, itemId, order, caller, specifics, intent, flags, items);

        if (items != null) {
            for (int i = 0, z = items.length; i < z; i++) {
                outSpecificItems[i] = getMenuItemWrapper(items[i]);
            }
        }

        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.888 -0400", hash_original_method = "2F9C004A2CBE82F08990AAA124DD3C3F", hash_generated_method = "C1778217CB646BBF00A49CD5CA64D974")
    
@Override
    public void removeItem(int id) {
        internalRemoveItem(id);
        mWrappedObject.removeItem(id);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.891 -0400", hash_original_method = "A592150386128C41C7E38FC5CA61044F", hash_generated_method = "C1427D1C106A742CDF98FD1ADCA162B1")
    
@Override
    public void removeGroup(int groupId) {
        internalRemoveGroup(groupId);
        mWrappedObject.removeGroup(groupId);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.894 -0400", hash_original_method = "040A3352340541564C73076179CC3FD7", hash_generated_method = "F8296014AB51385C0177D51AF7CB37BA")
    
@Override
    public void clear() {
        internalClear();
        mWrappedObject.clear();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.898 -0400", hash_original_method = "F4B4722FF3024B3547D4D56BF58B9C7F", hash_generated_method = "1868EA43FD2F6B15F4A0955B07A869FC")
    
@Override
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        mWrappedObject.setGroupCheckable(group, checkable, exclusive);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.900 -0400", hash_original_method = "D4E3361D853ABA35462DF6C455F10D52", hash_generated_method = "85EC2DEF53E433F61A6E1509084276E7")
    
@Override
    public void setGroupVisible(int group, boolean visible) {
        mWrappedObject.setGroupVisible(group, visible);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.903 -0400", hash_original_method = "1B259C4B2B9084E776E4D1E53D2E3769", hash_generated_method = "AE7F9CAF1D4A9943F1DBEA2FF4C967D6")
    
@Override
    public void setGroupEnabled(int group, boolean enabled) {
        mWrappedObject.setGroupEnabled(group, enabled);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.909 -0400", hash_original_method = "59DEC0284ACDDA9C490DE2C76BF5C130", hash_generated_method = "AE2547D75C865D6F7401CF897036A13B")
    
@Override
    public boolean hasVisibleItems() {
        return mWrappedObject.hasVisibleItems();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.911 -0400", hash_original_method = "D5D5D4DB0A0CEB52489BBEEA8E483248", hash_generated_method = "2BF2EF19F23B7E8B10ACAD7B6A6B3630")
    
@Override
    public MenuItem findItem(int id) {
        return getMenuItemWrapper(mWrappedObject.findItem(id));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.914 -0400", hash_original_method = "5AA51E2163B149F83CFCCC9D627FD0F5", hash_generated_method = "E916DCD210471216C16C74262FE6E9B9")
    
@Override
    public int size() {
        return mWrappedObject.size();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.916 -0400", hash_original_method = "29192C9BF49367901D1518EF4931E753", hash_generated_method = "76C45D696F44025C21E9F4B60D31239C")
    
@Override
    public MenuItem getItem(int index) {
        return getMenuItemWrapper(mWrappedObject.getItem(index));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.919 -0400", hash_original_method = "F7C8ED58622BE828CC4402E463D5E347", hash_generated_method = "E7B2F4A0AA79EA74AA3B672D788585E5")
    
@Override
    public void close() {
        mWrappedObject.close();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.921 -0400", hash_original_method = "B9E06C680FF0CF9757AC2C271DC23C85", hash_generated_method = "E1820E8C2B5FF15B4E19AA811D349DAC")
    
@Override
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        return mWrappedObject.performShortcut(keyCode, event, flags);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.924 -0400", hash_original_method = "E77EC88DA5E39909814167B0989F671E", hash_generated_method = "B5D25B6AF891B06DEAC3B75A26AF1412")
    
@Override
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return mWrappedObject.isShortcutKey(keyCode, event);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.927 -0400", hash_original_method = "CDD5E776AD5ABF68221921B3F31E8BBF", hash_generated_method = "D10BE7A87A09C8AD918D339F9C79A487")
    
@Override
    public boolean performIdentifierAction(int id, int flags) {
        return mWrappedObject.performIdentifierAction(id, flags);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:40.929 -0400", hash_original_method = "C7F155D96FDBBF8131C73D8F8A7EA0E5", hash_generated_method = "EEB3802B6F138976B88F88A8A192414D")
    
@Override
    public void setQwertyMode(boolean isQwerty) {
        mWrappedObject.setQwertyMode(isQwerty);
    }
}
