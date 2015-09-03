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


package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.content.Intent;

public interface Menu {
    
    static final int USER_MASK = 0x0000ffff;
    
    static final int USER_SHIFT = 0;
    
    static final int CATEGORY_MASK = 0xffff0000;
    
    static final int CATEGORY_SHIFT = 16;
    
    static final int NONE = 0;
    
    static final int FIRST = 1;
    
    static final int CATEGORY_CONTAINER = 0x00010000;
    
    static final int CATEGORY_SYSTEM = 0x00020000;
    
    static final int CATEGORY_SECONDARY = 0x00030000;
    
    static final int CATEGORY_ALTERNATIVE = 0x00040000;
    
    static final int FLAG_APPEND_TO_GROUP = 0x0001;
    
    static final int FLAG_PERFORM_NO_CLOSE = 0x0001;
    
    static final int FLAG_ALWAYS_PERFORM_CLOSE = 0x0002;
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public MenuItem add(CharSequence title);
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public MenuItem add(int titleRes);
    
        @DSVerified
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public MenuItem add(int groupId, int itemId, int order, CharSequence title);
    
        @DSVerified
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public MenuItem add(int groupId, int itemId, int order, int titleRes);
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    SubMenu addSubMenu(final CharSequence title);
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    SubMenu addSubMenu(final int titleRes);
    
    @DSSafe(DSCat.GUI)
    SubMenu addSubMenu(final int groupId, final int itemId, int order, final CharSequence title);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes);
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int addIntentOptions(int groupId, int itemId, int order,
                                ComponentName caller, Intent[] specifics,
                                Intent intent, int flags, MenuItem[] outSpecificItems);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void removeItem(int id);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void removeGroup(int groupId);
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public void clear();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setGroupVisible(int group, boolean visible);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setGroupEnabled(int group, boolean enabled);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean hasVisibleItems();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public MenuItem findItem(int id);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int size();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public MenuItem getItem(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void close();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean performShortcut(int keyCode, KeyEvent event, int flags);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isShortcutKey(int keyCode, KeyEvent event);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean performIdentifierAction(int id, int flags);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setQwertyMode(boolean isQwerty);
}
