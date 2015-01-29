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

package com.android.internal.view.menu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.util.EventLog;
import android.view.ContextMenu;
import android.view.View;

/**
 * Implementation of the {@link android.view.ContextMenu} interface.
 * <p>
 * Most clients of the menu framework will never need to touch this
 * class.  However, if the client has a window that
 * is not a content view of a Dialog or Activity (for example, the
 * view was added directly to the window manager) and needs to show
 * context menus, it will use this class.
 * <p>
 * To use this class, instantiate it via {@link #ContextMenuBuilder(Context)},
 * and optionally populate it with any of your custom items.  Finally,
 * call {@link #show(View, IBinder)} which will populate the menu
 * with a view's context menu items and show the context menu.
 */
public class ContextMenuBuilder extends MenuBuilder implements ContextMenu {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.283 -0400", hash_original_method = "31B204B44ADDD3A74D11B61FB9698D09", hash_generated_method = "589A5D22BED72F51B2583A57A6E696E5")
    
public ContextMenuBuilder(Context context) {
        super(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.291 -0400", hash_original_method = "4EA0414FDCF4934CB74E67C2BA91AD26", hash_generated_method = "F5B679DB6DC3F57B2768D229C4E4D785")
    
public ContextMenu setHeaderIcon(Drawable icon) {
        return (ContextMenu) super.setHeaderIconInt(icon);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.298 -0400", hash_original_method = "B14F406860E750B2D4438CE5ACEB1ABE", hash_generated_method = "E25D69563F49A13723CF8C3EA1381E5A")
    
public ContextMenu setHeaderIcon(int iconRes) {
        return (ContextMenu) super.setHeaderIconInt(iconRes);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.305 -0400", hash_original_method = "86AE1DFFD66E55B341B47437A16E4421", hash_generated_method = "DDB8C5EBD0D8682BAB7E287DBD080263")
    
public ContextMenu setHeaderTitle(CharSequence title) {
        return (ContextMenu) super.setHeaderTitleInt(title);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.312 -0400", hash_original_method = "6128AAB2C2C12BC1DF4BD1A1C09E51AD", hash_generated_method = "C09E4DED4DD5033664E27F0569B6FED9")
    
public ContextMenu setHeaderTitle(int titleRes) {
        return (ContextMenu) super.setHeaderTitleInt(titleRes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.318 -0400", hash_original_method = "8246E41CF02E865119BF768460C603BA", hash_generated_method = "473970485DE009F1AFD89FDEE8F01188")
    
public ContextMenu setHeaderView(View view) {
        return (ContextMenu) super.setHeaderViewInt(view);
    }

    /**
     * Shows this context menu, allowing the optional original view (and its
     * ancestors) to add items.
     * 
     * @param originalView Optional, the original view that triggered the
     *        context menu.
     * @param token Optional, the window token that should be set on the context
     *        menu's window.
     * @return If the context menu was shown, the {@link MenuDialogHelper} for
     *         dismissing it. Otherwise, null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.329 -0400", hash_original_method = "288A87448E6D764011C1399D11E72FEF", hash_generated_method = "8B5F922B931E20C911357E1A9F1554FF")
    
public MenuDialogHelper show(View originalView, IBinder token) {
        if (originalView != null) {
            // Let relevant views and their populate context listeners populate
            // the context menu
            originalView.createContextMenu(this);
        }

        if (getVisibleItems().size() > 0) {
            EventLog.writeEvent(50001, 1);
            
            MenuDialogHelper helper = new MenuDialogHelper(this); 
            helper.show(token);
            
            return helper;
        }
        
        return null;
    }
    
}
