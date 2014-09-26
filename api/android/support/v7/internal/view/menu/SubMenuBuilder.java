/*
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

package android.support.v7.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/**
 * The model for a sub menu, which is an extension of the menu.  Most methods are proxied to the
 * parent menu.
 *
 * @hide
 */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.029 -0400", hash_original_field = "A1B556EFE7B4A9C39F3C01959441E825", hash_generated_field = "4E1BCCB50336F81563C7D93F9E630BE3")

    private MenuBuilder mParentMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.032 -0400", hash_original_field = "68EA12243619336B32A13EB7EA400114", hash_generated_field = "C38EAFECFFC50960A865217D34B85EF5")

    private MenuItemImpl mItem;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.035 -0400", hash_original_method = "EEEDE2897B343E661DCADEF62AF22FE6", hash_generated_method = "15DBD2DA323A3869B08C1EAAFC6C309E")
    
public SubMenuBuilder(Context context, MenuBuilder parentMenu, MenuItemImpl item) {
        super(context);

        mParentMenu = parentMenu;
        mItem = item;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.038 -0400", hash_original_method = "CFA2D90FFED13BED8AFF4C56CD396197", hash_generated_method = "214A4A0BEECAA855BF8893A7BC43AA5F")
    
@Override
    public void setQwertyMode(boolean isQwerty) {
        mParentMenu.setQwertyMode(isQwerty);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.042 -0400", hash_original_method = "136516E019CDEFE0F3C3ED762AF8783A", hash_generated_method = "4C977053B0B2C6DCDFEE98637D7D89DF")
    
@Override
    public boolean isQwertyMode() {
        return mParentMenu.isQwertyMode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.047 -0400", hash_original_method = "A904D66AD1D8E748B65C9C8C5EEC3261", hash_generated_method = "DE4DB4020B11B8060FC36965A36F4DF3")
    
@Override
    public void setShortcutsVisible(boolean shortcutsVisible) {
        mParentMenu.setShortcutsVisible(shortcutsVisible);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.049 -0400", hash_original_method = "71E56F7ABFBB449375F493931D31DE57", hash_generated_method = "694686265DAF471E2897D76C405BF9DB")
    
@Override
    public boolean isShortcutsVisible() {
        return mParentMenu.isShortcutsVisible();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.052 -0400", hash_original_method = "EFEC7F93A39736AF8130A49104B9A895", hash_generated_method = "BADFAFE7FDF3B109F8FE3CCBDC2044F6")
    
public Menu getParentMenu() {
        return mParentMenu;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.054 -0400", hash_original_method = "B68A5ADECB21212250B72B1DD0399FE9", hash_generated_method = "43CA31BE056BF0396EECC4F3C98EA30D")
    
public MenuItem getItem() {
        return mItem;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.056 -0400", hash_original_method = "DBA24265560DE072BE0F453E574665D3", hash_generated_method = "340CDE46A16AC7418496EE6E3B31FE70")
    
@Override
    public void setCallback(Callback callback) {
        mParentMenu.setCallback(callback);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.059 -0400", hash_original_method = "DFDE0312E92BA6118839C252C79690F8", hash_generated_method = "95612BA0ADBF395D4E2C567EE6069281")
    
public MenuBuilder getRootMenu() {
        return mParentMenu;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.061 -0400", hash_original_method = "9000096E0EC4FB2931429080284C8422", hash_generated_method = "81A8DD84F971BDDA9771F2396505EB05")
    
@Override
    public boolean dispatchMenuItemSelected(MenuBuilder menu, MenuItem item) {
        return super.dispatchMenuItemSelected(menu, item) ||
                mParentMenu.dispatchMenuItemSelected(menu, item);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.064 -0400", hash_original_method = "0AF009FB156FDD26BF7D5688EA94EA96", hash_generated_method = "D7322054920069DFF5993DABFEBA6752")
    
public SubMenu setIcon(Drawable icon) {
        mItem.setIcon(icon);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.066 -0400", hash_original_method = "8258AA953D162B52749278DD498F9224", hash_generated_method = "5FFC0CDB5513BAD85BDE95858B206E03")
    
public SubMenu setIcon(int iconRes) {
        mItem.setIcon(iconRes);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.069 -0400", hash_original_method = "7BB67FCFD16CD0BDDBF9E365C564A541", hash_generated_method = "A3DA43534AE6203C7167724ADFBC6279")
    
public SubMenu setHeaderIcon(Drawable icon) {
        super.setHeaderIconInt(icon);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.072 -0400", hash_original_method = "2AB10CAF23EA2F0AC6B8149D4F194F84", hash_generated_method = "F1634DB815185F1462150F0EFADBD2C6")
    
public SubMenu setHeaderIcon(int iconRes) {
        super.setHeaderIconInt(getContext().getResources().getDrawable(iconRes));
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.075 -0400", hash_original_method = "779B318D9B04DDB71F7F933A46268C9A", hash_generated_method = "0D82A884AB26AF2ADD4D8CDFEBFB59A8")
    
public SubMenu setHeaderTitle(CharSequence title) {
        super.setHeaderTitleInt(title);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.077 -0400", hash_original_method = "9DF7D5AF2892DCE72E372C602232AF8A", hash_generated_method = "181BCB3CC9559E50C7746BFDD5230378")
    
public SubMenu setHeaderTitle(int titleRes) {
        super.setHeaderTitleInt(getContext().getResources().getString(titleRes));
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.080 -0400", hash_original_method = "77F0B87E24C3A478ACC05E4EA3637871", hash_generated_method = "31B161ABE8063BE7DCFB684B3FE46739")
    
public SubMenu setHeaderView(View view) {
        super.setHeaderViewInt(view);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.082 -0400", hash_original_method = "9F8E02579667F74DE4B4D60BE044F418", hash_generated_method = "8E211F0051A0168B07FB68DBFFB26C76")
    
@Override
    public void clearHeader() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.085 -0400", hash_original_method = "6E97D9D8BEFE428705B38823DA7B3E98", hash_generated_method = "135AD02EA0104B47A0C87D9A0E465099")
    
@Override
    public boolean expandItemActionView(MenuItemImpl item) {
        return mParentMenu.expandItemActionView(item);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.088 -0400", hash_original_method = "D98ED83F7F18D17C88DF80DBBB24B50B", hash_generated_method = "D2D53E49DEE5F2FB2ED2591BD342324C")
    
@Override
    public boolean collapseItemActionView(MenuItemImpl item) {
        return mParentMenu.collapseItemActionView(item);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.090 -0400", hash_original_method = "2F8B587BD2C060C35373EC0A47CA21D2", hash_generated_method = "5D200AD62DBA2121F59437217C1DCDCE")
    
@Override
    public String getActionViewStatesKey() {
        final int itemId = mItem != null ? mItem.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }
}
