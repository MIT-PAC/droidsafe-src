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
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class SubMenuWrapperICS extends MenuWrapperICS implements SupportSubMenu {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.163 -0400", hash_original_method = "9A2303666857A75DDBFB89E6FC21BE01", hash_generated_method = "9A2303666857A75DDBFB89E6FC21BE01")
    
SubMenuWrapperICS(android.view.SubMenu subMenu) {
        super(subMenu);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.167 -0400", hash_original_method = "3DE9352F6ECAFD28A704DE5EC846218B", hash_generated_method = "4D07909FE5B84A07AEEF56BF9A8AF070")
    
@Override
    public android.view.SubMenu getWrappedObject() {
        return (android.view.SubMenu) mWrappedObject;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.169 -0400", hash_original_method = "0D2CEC382EEFDD02A97447E84E019AC9", hash_generated_method = "21608AFA9848F3655B00BAC362A73D96")
    
@Override
    public SubMenu setHeaderTitle(int titleRes) {
        ((android.view.SubMenu) mWrappedObject).setHeaderTitle(titleRes);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.172 -0400", hash_original_method = "081E2F8352F14F70416273B84900E479", hash_generated_method = "62647E79B5C902783B5C58E417B7A503")
    
@Override
    public SubMenu setHeaderTitle(CharSequence title) {
        ((android.view.SubMenu) mWrappedObject).setHeaderTitle(title);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.175 -0400", hash_original_method = "A743B261955BEBFEA76E4DB0FDB9C2B9", hash_generated_method = "D78623DEE5FD1979B159E8FA6515DAB3")
    
@Override
    public SubMenu setHeaderIcon(int iconRes) {
        ((android.view.SubMenu) mWrappedObject).setHeaderIcon(iconRes);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.179 -0400", hash_original_method = "A09F2789125DF5352EECB61E79F9A3A0", hash_generated_method = "C42B4B0BA7E2D32E2BF7DA6EBB688996")
    
@Override
    public SubMenu setHeaderIcon(Drawable icon) {
        ((android.view.SubMenu) mWrappedObject).setHeaderIcon(icon);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.181 -0400", hash_original_method = "FB2A7291433008F42794B4DBD2ACBEEA", hash_generated_method = "91858E7B6111D8DF2842CAD950B5B681")
    
@Override
    public SubMenu setHeaderView(View view) {
        ((android.view.SubMenu) mWrappedObject).setHeaderView(view);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.184 -0400", hash_original_method = "B824926E601F92195A02B0B3C7B4F731", hash_generated_method = "2DBD0A37140DB878F34FCDFAC0114ED3")
    
@Override
    public void clearHeader() {
        ((android.view.SubMenu) mWrappedObject).clearHeader();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.186 -0400", hash_original_method = "9067659DF85182EC93ECBA29B76BA546", hash_generated_method = "C192FC619862EF685EFC83090B7D8F15")
    
@Override
    public SubMenu setIcon(int iconRes) {
        ((android.view.SubMenu) mWrappedObject).setIcon(iconRes);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.189 -0400", hash_original_method = "70FFD3FECA903B99927996A6563DFF31", hash_generated_method = "C3F0F93557AC0E2CAEDB36E54A6B3D01")
    
@Override
    public SubMenu setIcon(Drawable icon) {
        ((android.view.SubMenu) mWrappedObject).setIcon(icon);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:41.191 -0400", hash_original_method = "64C8C43A710EE1E12D35137747049FCC", hash_generated_method = "EE53C10221A61AC25460FDA57D0CD79F")
    
@Override
    public MenuItem getItem() {
        return getMenuItemWrapper(((android.view.SubMenu) mWrappedObject).getItem());
    }
}
