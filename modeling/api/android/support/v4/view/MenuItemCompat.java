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


package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/**
 * Helper for accessing features in {@link android.view.MenuItem}
 * introduced after API level 4 in a backwards compatible fashion.
 * <p class="note"><strong>Note:</strong> You cannot get an instance of this class. Instead,
 * it provides <em>static</em> methods that correspond to the methods in {@link
 * android.view.MenuItem}, but take a {@link android.view.MenuItem} object as an additional
 * argument.</p>
 */
public class MenuItemCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.163 -0400", hash_original_field = "3CE923ADE23C6192B4AAE3CC7F045A6A", hash_generated_field = "B9753B6C426E6854A72ABC85CFCE6CC2")

    private static final String TAG = "MenuItemCompat";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.167 -0400", hash_original_field = "CE0FD093D5606EE490406D031A25C64B", hash_generated_field = "49E9487BFDE37A8FB02ED40DCD77804C")

    public static final int SHOW_AS_ACTION_NEVER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.172 -0400", hash_original_field = "DB02EA7CAFC50D4ED26C0904D5112D55", hash_generated_field = "F83989AA2029EE1F6F60BC38E0C9593B")

    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.177 -0400", hash_original_field = "111C6B8FAFFDDA0C5D2F4A588AFB73B6", hash_generated_field = "DE50309D75A966DECCE3F374CC190FA0")

    public static final int SHOW_AS_ACTION_ALWAYS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.181 -0400", hash_original_field = "D219A6715D1C1D7D21AB0BDD1F5F21E7", hash_generated_field = "952B81CF40CAF8C98C9D373E5E3B8792")

    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.186 -0400", hash_original_field = "D49FA3E90EDF32C5CE4EC8398CC41D65", hash_generated_field = "420F4F1044A62A048FC7608F58EA2B72")

    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    /**
     * Interface for the full API.
     */
    interface MenuVersionImpl {
        void setShowAsAction(MenuItem item, int actionEnum);
        MenuItem setActionView(MenuItem item, View view);
        MenuItem setActionView(MenuItem item, int resId);
        View getActionView(MenuItem item);
        boolean expandActionView(MenuItem item);
        boolean collapseActionView(MenuItem item);
        boolean isActionViewExpanded(MenuItem item);
        MenuItem setOnActionExpandListener(MenuItem item, OnActionExpandListener listener);
    }

    /**
     * Interface definition for a callback to be invoked when a menu item marked with {@link
     * #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW} is expanded or collapsed.
     *
     * @see #expandActionView(android.view.MenuItem)
     * @see #collapseActionView(android.view.MenuItem)
     * @see #setShowAsAction(android.view.MenuItem, int)
     */
    public interface OnActionExpandListener {

        /**
         * Called when a menu item with {@link #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}
         * is expanded.
         *
         * @param item Item that was expanded
         * @return true if the item should expand, false if expansion should be suppressed.
         */
        public boolean onMenuItemActionExpand(MenuItem item);

        /**
         * Called when a menu item with {@link #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}
         * is collapsed.
         *
         * @param item Item that was collapsed
         * @return true if the item should collapse, false if collapsing should be suppressed.
         */
        public boolean onMenuItemActionCollapse(MenuItem item);
    }

    /**
     * Interface implementation that doesn't use anything about v4 APIs.
     */
    static class BaseMenuVersionImpl implements MenuVersionImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setShowAsAction(MenuItem item, int actionEnum) {
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public MenuItem setActionView(MenuItem item, View view) {
            return item;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public MenuItem setActionView(MenuItem item, int resId) {
            return item;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public View getActionView(MenuItem item) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean expandActionView(MenuItem item) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean collapseActionView(MenuItem item) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isActionViewExpanded(MenuItem item) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public MenuItem setOnActionExpandListener(MenuItem item, OnActionExpandListener listener) {
            return item;
        }
    }

    /**
     * Interface implementation for devices with at least v11 APIs.
     */
    static class HoneycombMenuVersionImpl implements MenuVersionImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setShowAsAction(MenuItem item, int actionEnum) {
            MenuItemCompatHoneycomb.setShowAsAction(item, actionEnum);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public MenuItem setActionView(MenuItem item, View view) {
            return MenuItemCompatHoneycomb.setActionView(item, view);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public MenuItem setActionView(MenuItem item, int resId) {
            return MenuItemCompatHoneycomb.setActionView(item, resId);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public View getActionView(MenuItem item) {
            return MenuItemCompatHoneycomb.getActionView(item);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean expandActionView(MenuItem item) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean collapseActionView(MenuItem item) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isActionViewExpanded(MenuItem item) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public MenuItem setOnActionExpandListener(MenuItem item, OnActionExpandListener listener) {
            return item;
        }
    }

    static class IcsMenuVersionImpl extends HoneycombMenuVersionImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean expandActionView(MenuItem item) {
            return MenuItemCompatIcs.expandActionView(item);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean collapseActionView(MenuItem item) {
            return MenuItemCompatIcs.collapseActionView(item);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean isActionViewExpanded(MenuItem item) {
            return MenuItemCompatIcs.isActionViewExpanded(item);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public MenuItem setOnActionExpandListener(MenuItem item,
                final OnActionExpandListener listener) {
            if (listener == null) {
                return MenuItemCompatIcs.setOnActionExpandListener(item, null);
            }
            /*
             * MenuItemCompatIcs is a dependency of this segment of the support lib
             * but not the other way around, so we need to take an extra step here to proxy
             * to the right types.
             */
            return MenuItemCompatIcs.setOnActionExpandListener(item,
                    new MenuItemCompatIcs.SupportActionExpandProxy() {
                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    return listener.onMenuItemActionExpand(item);
                }

                @DSSafe(DSCat.SAFE_LIST)
            @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    return listener.onMenuItemActionCollapse(item);
                }
            });
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.305 -0400", hash_original_field = "8028B97E4B96DA4F8B25DB17232BD5A2", hash_generated_field = "4E3138D2C8B4893576326933CC27438B")

    static  MenuVersionImpl IMPL;
    static {
        final int version = android.os.Build.VERSION.SDK_INT;
        if (version >= 14) {
            IMPL = new IcsMenuVersionImpl();
        } else if (version >= 11) {
            IMPL = new HoneycombMenuVersionImpl();
        } else {
            IMPL = new BaseMenuVersionImpl();
        }
    }

    // -------------------------------------------------------------------

    /**
     * Sets how this item should display in the presence of a compatible Action Bar. If the given
     * item is compatible, this will call the item's supported implementation of
     * {@link MenuItem#setShowAsAction(int)}.
     *
     * @param item - the item to change
     * @param actionEnum - How the item should display.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.311 -0400", hash_original_method = "8F841F057C0A60394A7A6D3B06E21642", hash_generated_method = "E4986EFA4F2942B1EC0DE7BD481A12D7")
            
public static void setShowAsAction(MenuItem item, int actionEnum) {
        if (item instanceof SupportMenuItem) {
            ((SupportMenuItem) item).setShowAsAction(actionEnum);
        } else {
            IMPL.setShowAsAction(item, actionEnum);
        }
    }

    /**
     * Set an action view for this menu item. An action view will be displayed in place
     * of an automatically generated menu item element in the UI when this item is shown
     * as an action within a parent.
     *
     * @param item the item to change
     * @param view View to use for presenting this item to the user.
     * @return This Item so additional setters can be called.
     *
     * @see #setShowAsAction(MenuItem, int)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.316 -0400", hash_original_method = "C1DF577F3A30C050B5E2ED31699D6BB2", hash_generated_method = "E01F9AD1539D5B60955F5D4F920FB610")
            
public static MenuItem setActionView(MenuItem item, View view) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).setActionView(view);
        }
        return IMPL.setActionView(item, view);
    }

    /**
     * Set an action view for this menu item. An action view will be displayed in place
     * of an automatically generated menu item element in the UI when this item is shown
     * as an action within a parent.
     * <p>
     *   <strong>Note:</strong> Setting an action view overrides the action provider
     *           set via {@link #setActionProvider(MenuItem, ActionProvider)}.
     * </p>
     *
     * @param item the item to change
     * @param resId Layout resource to use for presenting this item to the user.
     * @return This Item so additional setters can be called.
     *
     * @see #setShowAsAction(MenuItem, int)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.321 -0400", hash_original_method = "7B166626F5FAA3F5FE15407C12F37815", hash_generated_method = "3C7877B9BA457FCA8604836DB6DD2F81")
            
public static MenuItem setActionView(MenuItem item, int resId) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).setActionView(resId);
        }
        return IMPL.setActionView(item, resId);
    }

    /**
     * Returns the currently set action view for this menu item.
     *
     * @param item the item to query
     * @return This item's action view
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.325 -0400", hash_original_method = "6C4BDB99371C4C08FD24EC9768420DB9", hash_generated_method = "FACE0889DA080CD745E544EE598EB248")
            
public static View getActionView(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).getActionView();
        }
        return IMPL.getActionView(item);
    }

    /**
     * Sets the {@link ActionProvider} responsible for creating an action view if
     * the item is placed on the action bar. The provider also provides a default
     * action invoked if the item is placed in the overflow menu.
     * <p>
     *   <strong>Note:</strong> Setting an action provider overrides the action view
     *           set via {@link #setActionView(MenuItem, View)}.
     * </p>
     *
     * @param item item to change
     * @param provider The action provider.
     * @return This Item so additional setters can be called.
     *
     * @see ActionProvider
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.330 -0400", hash_original_method = "E21F159404A4BFAEF28E6FCC5721403A", hash_generated_method = "575D35A034A6CE4240D0E52E0F68FC07")
            
public static MenuItem setActionProvider(MenuItem item, ActionProvider provider) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).setSupportActionProvider(provider);
        }
        // TODO Wrap the support ActionProvider and assign it
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return item;
    }

    /**
     * Gets the {@link ActionProvider}.
     *
     * @return The action provider.
     *
     * @see ActionProvider
     * @see #setActionProvider(MenuItem, ActionProvider)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.334 -0400", hash_original_method = "57DB8A2025740890BEF97DF7007B793D", hash_generated_method = "25C73F0FF2F24358BD92346621DDB6C6")
            
public static ActionProvider getActionProvider(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).getSupportActionProvider();
        }

        // TODO Wrap the framework ActionProvider and return it
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    /**
     * Expand the action view associated with this menu item.
     * The menu item must have an action view set, as well as
     * the showAsAction flag {@link #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}.
     * If a listener has been set using
     * {@link #setOnActionExpandListener(MenuItem, OnActionExpandListener)}
     * it will have its {@link OnActionExpandListener#onMenuItemActionExpand(MenuItem)}
     * method invoked. The listener may return false from this method to prevent expanding
     * the action view.
     *
     * @return true if the action view was expanded, false otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.338 -0400", hash_original_method = "6875B886DDFC4C2D29D5E342F2B9427C", hash_generated_method = "075E4C1F8E87F7BCF472C049B3FB3AB8")
            
public static boolean expandActionView(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).expandActionView();
        }
        return IMPL.expandActionView(item);
    }

    /**
     * Collapse the action view associated with this menu item. The menu item must have an action
     * view set, as well as the showAsAction flag {@link #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}. If a
     * listener has been set using {@link #setOnActionExpandListener(MenuItem,
     * android.support.v4.view.MenuItemCompat.OnActionExpandListener)}
     * it will have its {@link
     * android.support.v4.view.MenuItemCompat.OnActionExpandListener#onMenuItemActionCollapse(MenuItem)}
     * method invoked. The listener may return false from this method to prevent collapsing
     * the action view.
     *
     * @return true if the action view was collapsed, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.342 -0400", hash_original_method = "0FF1E052F97B16DF87EBAD7BC1EEAC6D", hash_generated_method = "74F87FD94B6FDC7AD487C63928544511")
            
public static boolean collapseActionView(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).collapseActionView();
        }
        return IMPL.collapseActionView(item);
    }

    /**
     * Returns true if this menu item's action view has been expanded.
     *
     * @return true if the item's action view is expanded, false otherwise.
     * @see #expandActionView(MenuItem)
     * @see #collapseActionView(MenuItem)
     * @see #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW
     * @see android.support.v4.view.MenuItemCompat.OnActionExpandListener
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.346 -0400", hash_original_method = "6B725D4EB4453644A71A1671F65709B0", hash_generated_method = "6B71DD51B8828E2F2DD47DF4B1278C08")
            
public static boolean isActionViewExpanded(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).isActionViewExpanded();
        }
        return IMPL.isActionViewExpanded(item);
    }

    /**
     * Set an {@link OnActionExpandListener} on this menu
     * item to be notified when the associated action view is expanded or collapsed.
     * The menu item must be configured to expand or collapse its action view using the flag
     * {@link #SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW}.
     *
     * @param listener Listener that will respond to expand/collapse events
     * @return This menu item instance for call chaining
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:01.351 -0400", hash_original_method = "B01984D78A6AD5DEA6D62A7E2E04A278", hash_generated_method = "DD8363AB7E424B4AAC043F6142FCB638")
            
public static MenuItem setOnActionExpandListener(MenuItem item,
            OnActionExpandListener listener) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).setSupportOnActionExpandListener(listener);
        }
        return IMPL.setOnActionExpandListener(item, listener);
    }
}
