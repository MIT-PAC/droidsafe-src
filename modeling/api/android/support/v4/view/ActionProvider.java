/*
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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/**
 * This class is a mediator for accomplishing a given task, for example sharing a file. It is
 * responsible for creating a view that performs an action that accomplishes the task. This class
 * also implements other functions such a performing a default action.
 *
 * <p class="note"><strong>Note:</strong> This class is included in the <a
 * href="{@docRoot}tools/extras/support-library.html">support library</a> for compatibility
 * with API level 4 and higher. If you're developing your app for API level 14 and higher
 * <em>only</em>, you should instead use the framework {@link android.view.ActionProvider}
 * class.</p>
 *
 * <p>An ActionProvider can be
 * optionally specified for a {@link android.view.MenuItem} and in such a case it will be
 * responsible for
 * creating the action view that appears in the {@link android.app.ActionBar} as a substitute for
 * the menu item when the item is displayed as an action item. Also the provider is responsible for
 * performing a default action if a menu item placed on the overflow menu of the ActionBar is
 * selected and none of the menu item callbacks has handled the selection. For this case the
 * provider can also optionally provide a sub-menu for accomplishing the task at hand.
 *
 * <p>There are two ways for using an action provider for creating and handling of action views:
 *
 * <ul><li> Setting the action provider on a {@link android.view.MenuItem} directly by
 * calling {@link
 * android.support.v4.view.MenuItemCompat#setActionProvider(android.view.MenuItem, ActionProvider)}.
 * </li>
 *
 * <li>Declaring the action provider in the menu XML resource. For example:
 *
 * <pre><code>
 *   &lt;item android:id="@+id/my_menu_item"
 *     android:title="@string/my_menu_item_title"
 *     android:icon="@drawable/my_menu_item_icon"
 *     android:showAsAction="ifRoom"
 *     android:actionProviderClass="foo.bar.SomeActionProvider" /&gt;
 * </code></pre>
 * </li></ul></p>
 *
 * @see android.support.v4.view.MenuItemCompat#setActionProvider(android.view.MenuItem, ActionProvider)
 * @see android.support.v4.view.MenuItemCompat#getActionProvider(android.view.MenuItem)
 */
public abstract class ActionProvider {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.817 -0400", hash_original_field = "68BA32B2001C93D969A5442895704B0F", hash_generated_field = "B7808DA292DB21C39463086483B38AEB")

    private static final String TAG = "ActionProvider(support)";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.822 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.828 -0400", hash_original_field = "0CC45A8F2A3DE3D79B6417F1C5FAF5C0", hash_generated_field = "B0B6D637F5D44582200E582C4D2D6000")

    private SubUiVisibilityListener mSubUiVisibilityListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.834 -0400", hash_original_field = "BF29511CA55E8788B8128B8F3A1E89ED", hash_generated_field = "0AE9BB679554EA8223E2AE175AD42623")

    private VisibilityListener mVisibilityListener;

    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.841 -0400", hash_original_method = "F381852A4A5D075E3879DAF29773726A", hash_generated_method = "59A3B55342EBE050EEC368F7CB193759")
    
public ActionProvider(Context context) {
        mContext = context;
    }

    /**
     * Gets the context associated with this action provider.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.846 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    
public Context getContext() {
        return mContext;
    }

    /**
     * Factory method for creating new action views.
     *
     * @return A new action view.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.852 -0400", hash_original_method = "D34B37B54FEE3A61B3F2EC9EB9350036", hash_generated_method = "A1917FF468BF52201E55304E949C12BA")
    
public abstract View onCreateActionView();

    /**
     * Factory method called by the Android framework to create new action views.
     * This method returns a new action view for the given MenuItem.
     *
     * <p>If your ActionProvider implementation overrides the deprecated no-argument overload
     * {@link #onCreateActionView()}, overriding this method for devices running API 16 or later
     * is recommended but optional. The default implementation calls {@link #onCreateActionView()}
     * for compatibility with applications written for older platform versions.</p>
     *
     * @param forItem MenuItem to create the action view for
     * @return the new action view
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.858 -0400", hash_original_method = "054A392134B5E307AEBFD4EDAB2E6171", hash_generated_method = "206F886AC35E3B1DB720E9ED19A5A3A0")
    
public View onCreateActionView(MenuItem forItem) {
        return onCreateActionView();
    }

    /**
     * The result of this method determines whether or not {@link #isVisible()} will be used
     * by the {@link MenuItem} this ActionProvider is bound to help determine its visibility.
     *
     * @return true if this ActionProvider overrides the visibility of the MenuItem
     *         it is bound to, false otherwise. The default implementation returns false.
     * @see #isVisible()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.865 -0400", hash_original_method = "92C92075594FFE24E3A24D7123D03315", hash_generated_method = "63C36814B3B9D4508E5A9C68499A65D1")
    
public boolean overridesItemVisibility() {
        return false;
    }

    /**
     * If {@link #overridesItemVisibility()} returns true, the return value of this method
     * will help determine the visibility of the {@link MenuItem} this ActionProvider is bound to.
     *
     * <p>If the MenuItem's visibility is explicitly set to false by the application,
     * the MenuItem will not be shown, even if this method returns true.</p>
     *
     * @return true if the MenuItem this ActionProvider is bound to is visible, false if
     *         it is invisible. The default implementation returns true.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.870 -0400", hash_original_method = "ACBF6EABC93AFDF8B48B778834C35F8C", hash_generated_method = "5AF1A9B3328626D15EDDFB3EC3316EE9")
    
public boolean isVisible() {
        return true;
    }

    /**
     * If this ActionProvider is associated with an item in a menu,
     * refresh the visibility of the item based on {@link #overridesItemVisibility()} and
     * {@link #isVisible()}. If {@link #overridesItemVisibility()} returns false, this call
     * will have no effect.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.875 -0400", hash_original_method = "4652955A1654C6A096D81626C33205E7", hash_generated_method = "5144480E051894B4E3F4D7832659E1FF")
    
public void refreshVisibility() {
        if (mVisibilityListener != null && overridesItemVisibility()) {
            mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        }
    }

    /**
     * Performs an optional default action.
     *
     * <p>For the case of an action provider placed in a menu
     * item not shown as an action this method is invoked if previous callbacks for processing menu
     * selection has handled the event.
     *
     * <p> A menu item selection is processed in the following order:
     *
     * <ul><li>Receiving a call to
     * {@link android.view.MenuItem.OnMenuItemClickListener#onMenuItemClick
     * MenuItem.OnMenuItemClickListener.onMenuItemClick}.</li>
     *
     * <li>Receiving a call to
     * {@link android.app.Activity#onOptionsItemSelected(android.view.MenuItem)}
     * FragmentActivity.onOptionsItemSelected(MenuItem)}
     * </li>
     *
     * <li>Receiving a call to
     * {@link android.support.v4.app.Fragment#onOptionsItemSelected(android.view.MenuItem)}
     * Fragment.onOptionsItemSelected(MenuItem)}</li>
     *
     * <li>Launching the {@link android.content.Intent} set via
     * {@link android.view.MenuItem#setIntent(android.content.Intent)
     * MenuItem.setIntent(android.content.Intent)}
     * </li>
     *
     * <li>Invoking this method.</li></ul>
     *
     * <p>The default implementation does not perform any action and returns false.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.881 -0400", hash_original_method = "366B075407E0A5F04994070AE9F78DED", hash_generated_method = "8E69AA43F8FD02823DF2F04092FB421C")
    
public boolean onPerformDefaultAction() {
        return false;
    }

    /**
     * Determines if this ActionProvider has a submenu associated with it.
     *
     * <p>Associated submenus will be shown when an action view is not. This provider instance will
     * receive a call to {@link #onPrepareSubMenu(SubMenu)} after the call to {@link
     * #onPerformDefaultAction()} and before a submenu is displayed to the user.
     *
     * @return true if the item backed by this provider should have an associated submenu
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.887 -0400", hash_original_method = "6145E76FB29B74D78245641D6BEF294B", hash_generated_method = "C47A8DBA8C06C24113E67B7BE29255AD")
    
public boolean hasSubMenu() {
        return false;
    }

    /**
     * Called to prepare an associated submenu for the menu item backed by this ActionProvider.
     *
     * <p>if {@link #hasSubMenu()} returns true, this method will be called when the menu item is
     * selected to prepare the submenu for presentation to the user. Apps may use this to create or
     * alter submenu content right before display.
     *
     * @param subMenu Submenu that will be displayed
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.892 -0400", hash_original_method = "F59137EC2C0A4379BE18A71AFD20A9D8", hash_generated_method = "50D6E1FB8293636D3A3A82EEB44F6E67")
    
public void onPrepareSubMenu(SubMenu subMenu) {
    }

    /**
     * Notify the system that the visibility of an action view's sub-UI such as an anchored popup
     * has changed. This will affect how other system visibility notifications occur.
     *
     * @hide Pending future API approval
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.897 -0400", hash_original_method = "486EC9DD7EB4D66CD412B7154F65545B", hash_generated_method = "DB9BE510AE24969A41145DFA8A4FE64E")
    
public void subUiVisibilityChanged(boolean isVisible) {
        if (mSubUiVisibilityListener != null) {
            mSubUiVisibilityListener.onSubUiVisibilityChanged(isVisible);
        }
    }

    /**
     * @hide Internal use only
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.902 -0400", hash_original_method = "D36B582FBFECE681E89AD6546A9F8E0B", hash_generated_method = "4AF91025E5612C10D13FC03AB2FFE231")
    
public void setSubUiVisibilityListener(SubUiVisibilityListener listener) {
        mSubUiVisibilityListener = listener;
    }

    /**
     * Set a listener to be notified when this ActionProvider's overridden visibility changes.
     * This should only be used by MenuItem implementations.
     *
     * @param listener listener to set
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:28:58.908 -0400", hash_original_method = "50A691A3A31F643FC669C3A89353EF35", hash_generated_method = "C0F06DA8FA9C918F6AB17F4463280561")
    
public void setVisibilityListener(VisibilityListener listener) {
        if (mVisibilityListener != null && listener != null) {
            Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener " +
                    "when one is already set. Are you reusing this " + getClass().getSimpleName() +
                    " instance while it is still in use somewhere else?");
        }
        mVisibilityListener = listener;
    }

    /**
     * @hide Internal use only
     */
    public interface SubUiVisibilityListener {

        public void onSubUiVisibilityChanged(boolean isVisible);
    }

    /**
     * Listens to changes in visibility as reported by {@link ActionProvider#refreshVisibility()}.
     *
     * @see ActionProvider#overridesItemVisibility()
     * @see ActionProvider#isVisible()
     */
    public interface VisibilityListener {
        public void onActionProviderVisibilityChanged(boolean isVisible);
    }
}
