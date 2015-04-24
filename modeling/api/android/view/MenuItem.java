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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;

public interface MenuItem {
    
    public static final int SHOW_AS_ACTION_NEVER = 0;
    
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    
    public interface OnMenuItemClickListener {

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)

        public boolean onMenuItemClick(MenuItem item);
    }
    
    public interface OnActionExpandListener {

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)

        public boolean onMenuItemActionExpand(MenuItem item);

        @DSVerified("Callback modeled")
        @DSSpec(DSCat.ABSTRACT_METHOD)

        public boolean onMenuItemActionCollapse(MenuItem item);
    }

    @DSVerified
    @DSSafe(DSCat.GUI)
    public int getItemId();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getGroupId();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getOrder();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setTitle(CharSequence title);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setTitle(int title);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public CharSequence getTitle();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setTitleCondensed(CharSequence title);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public CharSequence getTitleCondensed();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setIcon(Drawable icon);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setIcon(int iconRes);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Drawable getIcon();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setIntent(Intent intent);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Intent getIntent();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setShortcut(char numericChar, char alphaChar);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setNumericShortcut(char numericChar);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public char getNumericShortcut();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setAlphabeticShortcut(char alphaChar);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public char getAlphabeticShortcut();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setCheckable(boolean checkable);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isCheckable();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setChecked(boolean checked);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isChecked();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setVisible(boolean visible);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isVisible();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setEnabled(boolean enabled);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean isEnabled();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean hasSubMenu();
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public SubMenu getSubMenu();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public ContextMenuInfo getMenuInfo();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public void setShowAsAction(int actionEnum);
    
    @DSVerified
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MenuItem setShowAsActionFlags(int actionEnum);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setActionView(View view);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setActionView(int resId);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public View getActionView();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setActionProvider(ActionProvider actionProvider);
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public ActionProvider getActionProvider();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean expandActionView();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean collapseActionView();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean isActionViewExpanded();
    
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener);
}
