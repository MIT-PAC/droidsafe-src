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
 * Copyright (C) 2006 The Android Open Source Project
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


package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.420 -0500", hash_original_field = "A1B556EFE7B4A9C39F3C01959441E825", hash_generated_field = "4E1BCCB50336F81563C7D93F9E630BE3")

    private MenuBuilder mParentMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.422 -0500", hash_original_field = "68EA12243619336B32A13EB7EA400114", hash_generated_field = "C38EAFECFFC50960A865217D34B85EF5")

    private MenuItemImpl mItem;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.425 -0500", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "15DBD2DA323A3869B08C1EAAFC6C309E")
    
public SubMenuBuilder(Context context, MenuBuilder parentMenu, MenuItemImpl item) {
        super(context);

        mParentMenu = parentMenu;
        mItem = item;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.427 -0500", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "214A4A0BEECAA855BF8893A7BC43AA5F")
    
@Override
    public void setQwertyMode(boolean isQwerty) {
        mParentMenu.setQwertyMode(isQwerty);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.429 -0500", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "4C977053B0B2C6DCDFEE98637D7D89DF")
    
@Override
    public boolean isQwertyMode() {
        return mParentMenu.isQwertyMode();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.432 -0500", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "DE4DB4020B11B8060FC36965A36F4DF3")
    
@Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.434 -0500", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "694686265DAF471E2897D76C405BF9DB")
    
@Override
    public boolean isShortcutsVisible() {
        return mParentMenu.isShortcutsVisible();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.436 -0500", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "BADFAFE7FDF3B109F8FE3CCBDC2044F6")
    
public Menu getParentMenu() {
        return mParentMenu;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.438 -0500", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "43CA31BE056BF0396EECC4F3C98EA30D")
    
public MenuItem getItem() {
        return mItem;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.441 -0500", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "340CDE46A16AC7418496EE6E3B31FE70")
    
@Override
    public void setCallback(Callback callback) {
        mParentMenu.setCallback(callback);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.443 -0500", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "338894C3870D784FD07E2677216A32BF")
    
@Override
    public MenuBuilder getRootMenu() {
        return mParentMenu;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.446 -0500", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "8EF4C138320A164DEF5D840F03DE8998")
    
@Override
    boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        return super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.448 -0500", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "D7322054920069DFF5993DABFEBA6752")
    
public SubMenu setIcon(Drawable icon) {
        mItem.setIcon(icon);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.450 -0500", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "5FFC0CDB5513BAD85BDE95858B206E03")
    
public SubMenu setIcon(int iconRes) {
        mItem.setIcon(iconRes);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.452 -0500", hash_original_method = "56E209FCA945BF27944112A810A882F0", hash_generated_method = "3889A18346855BA29F159AC8A97223A4")
    
public SubMenu setHeaderIcon(Drawable icon) {
        return (SubMenu) super.setHeaderIconInt(icon);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.454 -0500", hash_original_method = "B3CB9177AFB254AB1F0E1AAE3F32477D", hash_generated_method = "C6AB0FF7011012BE87A798C809EF3628")
    
public SubMenu setHeaderIcon(int iconRes) {
        return (SubMenu) super.setHeaderIconInt(iconRes);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.456 -0500", hash_original_method = "044E20C877A5479948C767280A86F92C", hash_generated_method = "A660FB0EE719A3EF7CA5668E2BF8D6CF")
    
public SubMenu setHeaderTitle(CharSequence title) {
        return (SubMenu) super.setHeaderTitleInt(title);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.458 -0500", hash_original_method = "E2D8E4BE5C0093B8E518BA6E44543D65", hash_generated_method = "1E8A5AB78A631F6FFC0F4A5D089FE1A1")
    
public SubMenu setHeaderTitle(int titleRes) {
        return (SubMenu) super.setHeaderTitleInt(titleRes);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.461 -0500", hash_original_method = "3CB652CBB5FA246B423F36AF77586ECC", hash_generated_method = "E2DDF82B6832C5A3E8DE5ADD8C859DAA")
    
public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.463 -0500", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "135AD02EA0104B47A0C87D9A0E465099")
    
@Override
    public boolean expandItemActionView(MenuItemImpl item) {
        return mParentMenu.expandItemActionView(item);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.466 -0500", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "D2D53E49DEE5F2FB2ED2591BD342324C")
    
@Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        return mParentMenu.collapseItemActionView(item);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.469 -0500", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "5D200AD62DBA2121F59437217C1DCDCE")
    
@Override
    public String getActionViewStatesKey() {
        final int itemId = mItem != null ? mItem.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }
    
}

