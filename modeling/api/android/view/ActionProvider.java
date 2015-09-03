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
 * Copyright (C) 2011 The Android Open Source Project
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
import android.content.Context;

public abstract class ActionProvider {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.115 -0500", hash_original_field = "0CC45A8F2A3DE3D79B6417F1C5FAF5C0", hash_generated_field = "B0B6D637F5D44582200E582C4D2D6000")

    private SubUiVisibilityListener mSubUiVisibilityListener;

    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.118 -0500", hash_original_method = "AD51B37569819E728EA786F52DA39151", hash_generated_method = "01703FE4B54B2BD302FDF7CE9511AF87")
    
public ActionProvider(Context context) {
    }

    /**
     * Factory method for creating new action views.
     *
     * @return A new action view.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.121 -0500", hash_original_method = "D34B37B54FEE3A61B3F2EC9EB9350036", hash_generated_method = "A1917FF468BF52201E55304E949C12BA")
    @DSVerified("Called from MenuItempImp")
public abstract View onCreateActionView();

    /**
     * Performs an optional default action.
     * <p>
     * For the case of an action provider placed in a menu item not shown as an action this
     * method is invoked if previous callbacks for processing menu selection has handled
     * the event.
     * </p>
     * <p>
     * A menu item selection is processed in the following order:
     * <ul>
     * <li>
     * Receiving a call to {@link MenuItem.OnMenuItemClickListener#onMenuItemClick
     *  MenuItem.OnMenuItemClickListener.onMenuItemClick}.
     * </li>
     * <li>
     * Receiving a call to {@link android.app.Activity#onOptionsItemSelected(MenuItem)
     *  Activity.onOptionsItemSelected(MenuItem)}
     * </li>
     * <li>
     * Receiving a call to {@link android.app.Fragment#onOptionsItemSelected(MenuItem)
     *  Fragment.onOptionsItemSelected(MenuItem)}
     * </li>
     * <li>
     * Launching the {@link android.content.Intent} set via
     * {@link MenuItem#setIntent(android.content.Intent) MenuItem.setIntent(android.content.Intent)}
     * </li>
     * <li>
     * Invoking this method.
     * </li>
     * </ul>
     * </p>
     * <p>
     * The default implementation does not perform any action and returns false.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.124 -0500", hash_original_method = "366B075407E0A5F04994070AE9F78DED", hash_generated_method = "8E69AA43F8FD02823DF2F04092FB421C")

    @DSVerified("Called from Menubuilder/MenuItemImpl")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public boolean onPerformDefaultAction() {
        return false;
    }

    /**
     * Determines if this ActionProvider has a submenu associated with it.
     *
     * <p>Associated submenus will be shown when an action view is not. This
     * provider instance will receive a call to {@link #onPrepareSubMenu(SubMenu)}
     * after the call to {@link #onPerformDefaultAction()} and before a submenu is
     * displayed to the user.
     *
     * @return true if the item backed by this provider should have an associated submenu
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.126 -0500", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "C47A8DBA8C06C24113E67B7BE29255AD")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean hasSubMenu() {
        return false;
    }

    /**
     * Called to prepare an associated submenu for the menu item backed by this ActionProvider.
     *
     * <p>if {@link #hasSubMenu()} returns true, this method will be called when the
     * menu item is selected to prepare the submenu for presentation to the user. Apps
     * may use this to create or alter submenu content right before display.
     *
     * @param subMenu Submenu that will be displayed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.129 -0500", hash_original_method = "F59137EC2C0A4379BE18A71AFD20A9D8", hash_generated_method = "50D6E1FB8293636D3A3A82EEB44F6E67")
    
public void onPrepareSubMenu(SubMenu subMenu) {
    }

    /**
     * Notify the system that the visibility of an action view's sub-UI such as
     * an anchored popup has changed. This will affect how other system
     * visibility notifications occur.
     *
     * @hide Pending future API approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.131 -0500", hash_original_method = "486EC9DD7EB4D66CD412B7154F65545B", hash_generated_method = "DB9BE510AE24969A41145DFA8A4FE64E")
    
public void subUiVisibilityChanged(boolean isVisible) {
        if (mSubUiVisibilityListener != null) {
            mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        }
    }

    /**
     * @hide Internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:17.133 -0500", hash_original_method = "D36B582FBFECE681E89AD6546A9F8E0B", hash_generated_method = "4AF91025E5612C10D13FC03AB2FFE231")
    
public void setSubUiVisibilityListener(SubUiVisibilityListener listener) {
        mSubUiVisibilityListener = listener;
    }
    
    public interface SubUiVisibilityListener {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onSubUiVisibilityChanged(boolean isVisible);
    }

    private VisibilityListener mVisibilityListener; 

     /**
     * Listens to changes in visibility as reported by {@link ActionProvider#refreshVisibility()}.
     *
     * @see ActionProvider#overridesItemVisibility()
     * @see ActionProvider#isVisible()
     */
    public interface VisibilityListener {
        public void onActionProviderVisibilityChanged(boolean isVisible);
    }


    /**
     * Set a listener to be notified when this ActionProvider's overridden visibility changes.
     * This should only be used by MenuItem implementations.
     *
     * @param listener listener to set
     */
    @DSSafe(DSCat.CALLBACK_REG)
    @DSVerified
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:19:32.574 -0400", hash_original_method = "5D18E0B68934B628D4AFDEA7D97A0327", hash_generated_method = "A731F8CDD46E7C2E87E8ECC9B681217C")
    
    public void setVisibilityListener(VisibilityListener listener) {
        mVisibilityListener = listener;
        listener.onActionProviderVisibilityChanged(true);
    }
}

