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
 * Copyright (C) 2010 The Android Open Source Project
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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.ArrayList;
import java.util.List;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/**
 * @hide
 */
public class ActionMenu implements Menu {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.848 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.849 -0400", hash_original_field = "FE62634EEDDD849F0AD3B78507BCB643", hash_generated_field = "D911FF6FA4B9C379C57213626A31ED6D")
    
    private boolean mIsQwerty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.850 -0400", hash_original_field = "316B93930256D6555F8A0E473962A451", hash_generated_field = "41A0E7E8D8FC3F8327FB5FA6FAD654C7")
    
    private ArrayList<ActionMenuItem> mItems;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.852 -0400", hash_original_method = "D840125CB7722A3C8E8DC8A11D39596C", hash_generated_method = "0F77A07C3A94B3F07CC70EB1402D0C35")
    
public ActionMenu(Context context) {
        mContext = context;
        mItems = new ArrayList<ActionMenuItem>();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.853 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    
public Context getContext() {
        return mContext;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.854 -0400", hash_original_method = "3A67378AF417362249479437980B3549", hash_generated_method = "6270980F6EAA92DE686F10128DEA7BA7")
    
public MenuItem add(CharSequence title) {
        return add(0, 0, 0, title);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.855 -0400", hash_original_method = "932BF9FB5552691D63AF6A1DA3DCC48B", hash_generated_method = "24E6B75B646AFBCDD2D3142819F9B9F0")
    
public MenuItem add(int titleRes) {
        return add(0, 0, 0, titleRes);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.856 -0400", hash_original_method = "7C069140980D746EE1C40D17873C1EA1", hash_generated_method = "638B7F1C716AD9D78886EA9583EE7DDD")
    
public MenuItem add(int groupId, int itemId, int order, int titleRes) {
        return add(groupId, itemId, order, mContext.getResources().getString(titleRes));
    }
    
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.859 -0400", hash_original_method = "21076FC0A42B5B917B57A4D8E689D0F2", hash_generated_method = "E41C1EA140B3E2AB228E193DD4A7D933")
    
public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
        ActionMenuItem item = new ActionMenuItem(getContext(),
                groupId, itemId, 0, order, title);
        mItems.add(order, item);
        return item;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.860 -0400", hash_original_method = "34EB24CEADFF49BBEA745537FF6B42F1", hash_generated_method = "F514DFA24619587A28272E820DC3FFFB")
    
public int addIntentOptions(int groupId, int itemId, int order,
            ComponentName caller, Intent[] specifics, Intent intent, int flags,
            MenuItem[] outSpecificItems) {
        PackageManager pm = mContext.getPackageManager();
        final List<ResolveInfo> lri =
                pm.queryIntentActivityOptions(caller, specifics, intent, 0);
        final int N = lri != null ? lri.size() : 0;

        if ((flags & FLAG_APPEND_TO_GROUP) == 0) {
            removeGroup(groupId);
        }

        for (int i=0; i<N; i++) {
            final ResolveInfo ri = lri.get(i);
            Intent rintent = new Intent(
                ri.specificIndex < 0 ? intent : specifics[ri.specificIndex]);
            rintent.setComponent(new ComponentName(
                    ri.activityInfo.applicationInfo.packageName,
                    ri.activityInfo.name));
            final MenuItem item = add(groupId, itemId, order, ri.loadLabel(pm))
                    .setIcon(ri.loadIcon(pm))
                    .setIntent(rintent);
            if (outSpecificItems != null && ri.specificIndex >= 0) {
                outSpecificItems[ri.specificIndex] = item;
            }
        }

        return N;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.862 -0400", hash_original_method = "0068CB4BB6C90B892D0E6E645B6CC6C7", hash_generated_method = "3A775F10E9C2B0278857D235A2B9FAD3")
    
public SubMenu addSubMenu(CharSequence title) {
        // TODO Implement submenus
        return null;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.863 -0400", hash_original_method = "4BD9515780E1D3C62206C12109879106", hash_generated_method = "0A98F695B8D53A113362903227DD1F9D")
    
public SubMenu addSubMenu(int titleRes) {
        // TODO Implement submenus
        return null;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.864 -0400", hash_original_method = "E3831C5A978EDF6915F22C914403E787", hash_generated_method = "FD17DAE5CA723E5F9A24A32753DDDFAE")
    
public SubMenu addSubMenu(int groupId, int itemId, int order,
            CharSequence title) {
        // TODO Implement submenus
        return null;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.865 -0400", hash_original_method = "F3CC4511B7BA6B80F888ADAA6C95898A", hash_generated_method = "71B7CDE8EC2BDC9DF4022A77ABACBD48")
    
public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
        // TODO Implement submenus
        return null;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.866 -0400", hash_original_method = "78D696A2499079680ADC35CAD457278C", hash_generated_method = "9C8877766AA828E4AD54AE1642291857")
    
public void clear() {
        mItems.clear();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.867 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "388BFD43642BF851D61AF8A45943A910")
    
public void close() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.868 -0400", hash_original_method = "A00B0642F88BFCD9DC714EAB5057175E", hash_generated_method = "75ADC0EEF96D31DCB396ACD3CFEBD345")
    
private int findItemIndex(int id) {
        final ArrayList<ActionMenuItem> items = mItems;
        final int itemCount = items.size();
        for (int i = 0; i < itemCount; i++) {
            if (items.get(i).getItemId() == id) {
                return i;
            }
        }
        
        return -1;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.869 -0400", hash_original_method = "0B9D8F2BCCAB435BB4CB2F94E8951A1B", hash_generated_method = "BF62218C3B6DB83DE6E526B077BEDD6B")
    
public MenuItem findItem(int id) {
        return mItems.get(findItemIndex(id));
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.870 -0400", hash_original_method = "95D83605E2F67D61DCAF8140DAB642C1", hash_generated_method = "22137EA46159B80F85AF259824015418")
    
public MenuItem getItem(int index) {
        return mItems.get(index);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.871 -0400", hash_original_method = "532C8DD0C10231ED8CD60F99EDE083DF", hash_generated_method = "910FB5F30C2357F9B770A96A29C6F443")
    
public boolean hasVisibleItems() {
        final ArrayList<ActionMenuItem> items = mItems;
        final int itemCount = items.size();
        
        for (int i = 0; i < itemCount; i++) {
            if (items.get(i).isVisible()) {
                return true;
            }
        }
        
        return false;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.873 -0400", hash_original_method = "B4E6538C7BB05099EC08C8D7412FDFC2", hash_generated_method = "34359A9014738B86A8AB515B6C8A23DA")
    
private ActionMenuItem findItemWithShortcut(int keyCode, KeyEvent event) {
        // TODO Make this smarter.
        final boolean qwerty = mIsQwerty;
        final ArrayList<ActionMenuItem> items = mItems;
        final int itemCount = items.size();
        
        for (int i = 0; i < itemCount; i++) {
            ActionMenuItem item = items.get(i);
            final char shortcut = qwerty ? item.getAlphabeticShortcut() :
                    item.getNumericShortcut();
            if (keyCode == shortcut) {
                return item;
            }
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.874 -0400", hash_original_method = "0DDA4D68AC5B1CCD6E78D7F4D7CE7D1C", hash_generated_method = "67DF47C1B89556F866C6C61567BFA168")
    
public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return findItemWithShortcut(keyCode, event) != null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.875 -0400", hash_original_method = "C28F0D7407E4A3D2A74FBCBAE3E3C9E6", hash_generated_method = "692FD7B636FCA67F942BB29F5F41090E")
    
public boolean performIdentifierAction(int id, int flags) {
        final int index = findItemIndex(id);
        if (index < 0) {
            return false;
        }

        return mItems.get(index).invoke();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.877 -0400", hash_original_method = "FCFFBF46B978E57B9C08F24E71664A9C", hash_generated_method = "C5F221F18C7BFEBA9712D00E45E0A483")
    
public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        ActionMenuItem item = findItemWithShortcut(keyCode, event);
        if (item == null) {
            return false;
        }
        
        return item.invoke();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.878 -0400", hash_original_method = "1F9D30FEFC27598836CC1250640F4BD2", hash_generated_method = "35EA1FB5B42B314C3FDEE263B340FD42")
    
public void removeGroup(int groupId) {
        final ArrayList<ActionMenuItem> items = mItems;
        int itemCount = items.size();
        int i = 0;
        while (i < itemCount) {
            if (items.get(i).getGroupId() == groupId) {
                items.remove(i);
                itemCount--;
            } else {
                i++;
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.879 -0400", hash_original_method = "4E0C2E2AB07D1BFF314FF21B1A923D78", hash_generated_method = "37E1EFE346E157C1964AD6B86B9D4ACD")
    
public void removeItem(int id) {
        mItems.remove(findItemIndex(id));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.880 -0400", hash_original_method = "EB8DED36DAA11F9A5F2CAA342B594CD6", hash_generated_method = "A88692FA058675F42A288F03E8BDE3AE")
    
public void setGroupCheckable(int group, boolean checkable,
            boolean exclusive) {
        final ArrayList<ActionMenuItem> items = mItems;
        final int itemCount = items.size();
        
        for (int i = 0; i < itemCount; i++) {
            ActionMenuItem item = items.get(i);
            if (item.getGroupId() == group) {
                item.setCheckable(checkable);
                item.setExclusiveCheckable(exclusive);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.882 -0400", hash_original_method = "225C226398ED6F40932EAEEF6389807F", hash_generated_method = "FBA87841830B7AC2AEBE911A37280BC7")
    
public void setGroupEnabled(int group, boolean enabled) {
        final ArrayList<ActionMenuItem> items = mItems;
        final int itemCount = items.size();
        
        for (int i = 0; i < itemCount; i++) {
            ActionMenuItem item = items.get(i);
            if (item.getGroupId() == group) {
                item.setEnabled(enabled);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.883 -0400", hash_original_method = "04B04D177657819ACFC3A3F04945B150", hash_generated_method = "0E2E4706F210A62D886EF1556D1271A3")
    
public void setGroupVisible(int group, boolean visible) {
        final ArrayList<ActionMenuItem> items = mItems;
        final int itemCount = items.size();
        
        for (int i = 0; i < itemCount; i++) {
            ActionMenuItem item = items.get(i);
            if (item.getGroupId() == group) {
                item.setVisible(visible);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.884 -0400", hash_original_method = "D3BA279DF33FA75A305F365952FB2811", hash_generated_method = "3E9663DFC738DB27387886603B7A48E3")
    
public void setQwertyMode(boolean isQwerty) {
        mIsQwerty = isQwerty;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:47:22.885 -0400", hash_original_method = "5327FF82295AE99159722BB0995F8072", hash_generated_method = "B001909A1E3FF23FBA9BDC7968BCB51C")
    
public int size() {
        return mItems.size();
    }
}
