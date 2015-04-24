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
 * Copyright (C) 2013 The Android Open Source Project
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


package android.support.v7.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ProgressBarICS;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

class ActionBarActivityDelegateBase extends ActionBarActivityDelegate  implements
        MenuPresenter.Callback, MenuBuilder.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.823 -0400", hash_original_field = "1294C1DD2060AFB07B06D6331190FEF2", hash_generated_field = "0637BCC5F28D9A527DB3959ED0D98358")

    private static final String TAG = "ActionBarActivityDelegateBase";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.828 -0400", hash_original_field = "393CFE891C8C400D2701704963B1D431", hash_generated_field = "F2C1E3FD6750F800842814C7F03138E6")

    private static final int[] ACTION_BAR_DRAWABLE_TOGGLE_ATTRS = new int[] {
            R.attr.homeAsUpIndicator
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.833 -0400", hash_original_field = "28B10220967DD5BDA404C6D29C1B3C6E", hash_generated_field = "6CC22F47D8F7AAE7532A872F09B0E534")

    private ActionBarView mActionBarView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.837 -0400", hash_original_field = "1695BEB5E7C9DE969EBD1616C1FC842D", hash_generated_field = "611F0E63548303C4F8ADA27B4E34D680")

    private ListMenuPresenter mListMenuPresenter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.841 -0400", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.845 -0400", hash_original_field = "B7BD8B12490FD42C33E24469AF6B48C1", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

    private ActionMode mActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.850 -0400", hash_original_field = "CE057B06400B24E3687CA685FF43F693", hash_generated_field = "BD434F385CC26941808008BFDFB3BD46")

    private boolean mSubDecorInstalled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.854 -0400", hash_original_field = "7A1FEF6FEC13BEB91DEF3A009F2A7ABE", hash_generated_field = "AC80BC9708D1C4D6EE731547E0D9F272")

    private CharSequence mTitleToSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.858 -0400", hash_original_field = "EF1A08BE4B468AFD3925595116440239", hash_generated_field = "42BCB566ECECE0D04E65BB095C81D67E")

    private boolean mFeatureProgress, mFeatureIndeterminateProgress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.862 -0400", hash_original_field = "052647D6675EB5D78D27F036B1581179", hash_generated_field = "C50C1573E39F1F091A461D6840A3B874")

    private boolean mInvalidateMenuPosted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.876 -0400", hash_original_field = "DF170F48A4A1C6FB11F5644452DC65EE", hash_generated_field = "A69C6B583C5C89A03008577BB6FC6912")

    private final Runnable mInvalidateMenuRunnable = new Runnable() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void run() {
            final MenuBuilder menu = createMenu();
            setMenu(menu);
           /* if (mActivity.superOnCreatePanelMenu(Window.FEATURE_OPTIONS_PANEL, menu) &&
                    mActivity.superOnPreparePanel(Window.FEATURE_OPTIONS_PANEL, null, menu)) {
                setMenu(menu);
            } else {
                setMenu(null);
            }
*/
            mInvalidateMenuPosted = false;
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.880 -0400", hash_original_method = "0691506E48A317B129876F642FB81A03", hash_generated_method = "0691506E48A317B129876F642FB81A03")
    
ActionBarActivityDelegateBase(ActionBarActivity activity) {
        super(activity);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.885 -0400", hash_original_method = "544AB14724FBAA18807A42362828E844", hash_generated_method = "DDF57B003DEF86D7B7AC266D9987BE89")
    
@Override
    public ActionBar createSupportActionBar() {
        ensureSubDecor();
        return new ActionBarImplBase(mActivity, mActivity);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.890 -0400", hash_original_method = "4625E1B086925D21D904160D1908801D", hash_generated_method = "D8CC731CE421BB95D137F6920C0D41BA")
    
@Override
    public void onConfigurationChanged(Configuration newConfig) {
        // If this is called before sub-decor is installed, ActionBar will not
        // be properly initialized.
        if (mHasActionBar && mSubDecorInstalled) {
            // Note: The action bar will need to access
            // view changes from superclass.
            ActionBarImplBase actionBar = (ActionBarImplBase) getSupportActionBar();
            actionBar.onConfigurationChanged(newConfig);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.894 -0400", hash_original_method = "2A810E0433016CF238EB6C089DB68FEB", hash_generated_method = "81265CA319088AD3782CAA3B46CC2FFE")
    
@Override
    public void onStop() {
        ActionBarImplBase ab = (ActionBarImplBase) getSupportActionBar();
        if (ab != null) {
            ab.setShowHideAnimationEnabled(false);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.898 -0400", hash_original_method = "39334DEFACBC3014E6C1678D38D71C41", hash_generated_method = "C23D236FFEBDBD7FC86325C129E91780")
    
@Override
    public void onPostResume() {
        ActionBarImplBase ab = (ActionBarImplBase) getSupportActionBar();
        if (ab != null) {
            ab.setShowHideAnimationEnabled(true);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.903 -0400", hash_original_method = "11B2F458B0450E004E181F63E051C584", hash_generated_method = "F924B40C72A52BDF9B18E14489641324")
    
@Override
    public void setContentView(View v) {
        ensureSubDecor();
        if (mHasActionBar) {
            ViewGroup contentParent = (ViewGroup) mActivity.findViewById(android.R.id.content);
            contentParent.removeAllViews();
            contentParent.addView(v);
        } else {
            mActivity.superSetContentView(v);
        }
        mActivity.onSupportContentChanged();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.908 -0400", hash_original_method = "9A84E32E0714AB3E5FCBAA0060FEA51C", hash_generated_method = "A7433B534C98190F7137B66EE22BACCF")
    
@Override
    public void setContentView(int resId) {
        ensureSubDecor();
        if (mHasActionBar) {
            ViewGroup contentParent = (ViewGroup) mActivity.findViewById(android.R.id.content);
            contentParent.removeAllViews();
            mActivity.getLayoutInflater().inflate(resId, contentParent);
        } else {
            mActivity.superSetContentView(resId);
        }
        mActivity.onSupportContentChanged();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.913 -0400", hash_original_method = "072225F6C21E6D2F72334F171A2FCFEA", hash_generated_method = "0DE6F68F8B5364F9CE1A9DFD805C12CC")
    
@Override
    public void setContentView(View v, ViewGroup.LayoutParams lp) {
        ensureSubDecor();
        if (mHasActionBar) {
            ViewGroup contentParent = (ViewGroup) mActivity.findViewById(android.R.id.content);
            contentParent.removeAllViews();
            contentParent.addView(v, lp);
        } else {
            mActivity.superSetContentView(v, lp);
        }
        mActivity.onSupportContentChanged();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.917 -0400", hash_original_method = "40C076693F133FC15DA10BF7DCEB2E64", hash_generated_method = "195A776F8C45F5C7B578E9CF7D4E94B3")
    
@Override
    public void addContentView(View v, ViewGroup.LayoutParams lp) {
        ensureSubDecor();
        if (mHasActionBar) {
            ViewGroup contentParent = (ViewGroup) mActivity.findViewById(android.R.id.content);
            contentParent.addView(v, lp);
        } else {
            mActivity.superSetContentView(v, lp);
        }
        mActivity.onSupportContentChanged();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.922 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "BF3E5F84F0DB5B26D1E199CC08ED339A")
    
@Override
    public void onContentChanged() {
        // Ignore all calls to this method as we call onSupportContentChanged manually above
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.927 -0400", hash_original_method = "3F5C3C668866CAAA177A509556464024", hash_generated_method = "3CC0DB6F369A6B78797E0F1321E4F529")
    
final void ensureSubDecor() {
        if (mHasActionBar && !mSubDecorInstalled) {
            if (mOverlayActionBar) {
                mActivity.superSetContentView(R.layout.abc_action_bar_decor_overlay);
            } else {
                mActivity.superSetContentView(R.layout.abc_action_bar_decor);
            }
            mActionBarView = (ActionBarView) mActivity.findViewById(R.id.action_bar);
            mActionBarView.setWindowCallback(mActivity);

            /**
             * Progress Bars
             */
            if (mFeatureProgress) {
                mActionBarView.initProgress();
            }
            if (mFeatureIndeterminateProgress) {
                mActionBarView.initIndeterminateProgress();
            }

            /**
             * Split Action Bar
             */
            boolean splitWhenNarrow = UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW
                    .equals(getUiOptionsFromMetadata());
            boolean splitActionBar;

            if (splitWhenNarrow) {
                splitActionBar = mActivity.getResources()
                        .getBoolean(R.bool.abc_split_action_bar_is_narrow);
            } else {
                TypedArray a = mActivity.obtainStyledAttributes(R.styleable.ActionBarWindow);
                splitActionBar = a
                        .getBoolean(R.styleable.ActionBarWindow_windowSplitActionBar, false);
                a.recycle();
            }

            final ActionBarContainer splitView = (ActionBarContainer) mActivity.findViewById(
                    R.id.split_action_bar);
            if (splitView != null) {
                mActionBarView.setSplitView(splitView);
                mActionBarView.setSplitActionBar(splitActionBar);
                mActionBarView.setSplitWhenNarrow(splitWhenNarrow);

                final ActionBarContextView cab = (ActionBarContextView) mActivity.findViewById(
                        R.id.action_context_bar);
                cab.setSplitView(splitView);
                cab.setSplitActionBar(splitActionBar);
                cab.setSplitWhenNarrow(splitWhenNarrow);
            }

            // Change our content FrameLayout to use the android.R.id.content id.
            // Useful for fragments.
            View content = mActivity.findViewById(android.R.id.content);
            content.setId(View.NO_ID);
            View abcContent = mActivity.findViewById(R.id.action_bar_activity_content);
            abcContent.setId(android.R.id.content);

            // A title was set before we've install the decor so set it now.
            if (mTitleToSet != null) {
                mActionBarView.setWindowTitle(mTitleToSet);
                mTitleToSet  = null;
            }

            mSubDecorInstalled = true;
            supportInvalidateOptionsMenu();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.932 -0400", hash_original_method = "8D0C140DB24874A64D92B914AF1925A8", hash_generated_method = "99710F1DA197A6866DAA9A979956E336")
    
@Override
    public boolean supportRequestWindowFeature(int featureId) {
        switch (featureId) {
            case Window.FEATURE_PROGRESS:
                mHasActionBar = true;
                mOverlayActionBar = true;
                mFeatureProgress = true;
                return true;
            case Window.FEATURE_INDETERMINATE_PROGRESS:
                mFeatureIndeterminateProgress = true;
                return true;
            default:
                return mActivity.requestWindowFeature(featureId);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.938 -0400", hash_original_method = "F3A389276680B626842536A2005F9454", hash_generated_method = "6276B81CEB0A9386FFFE2AC6CA5560A9")
    
@Override
    public void onTitleChanged(CharSequence title) {
        if (mActionBarView != null) {
            mActionBarView.setWindowTitle(title);
        } else {
            mTitleToSet = title;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.943 -0400", hash_original_method = "95BAA0C4FD9C2782C5A3E51A3A2D9CBA", hash_generated_method = "6D73A27BFD7DD5A56CAA0ECA183E6B0F")
    
@Override
    public View onCreatePanelView(int featureId) {
        View createdPanelView = null;

        if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            boolean show = true;
            MenuBuilder menu = mMenu;

            if (mActionMode == null) {
                // We only want to dispatch Activity/Fragment menu calls if there isn't
                // currently an action mode

                if (menu == null) {
                    // We don't have a menu created, so create one
                    menu = createMenu();
                    setMenu(menu);

                    // Make sure we're not dispatching item changes to presenters
                    menu.stopDispatchingItemsChanged();
                    // Dispatch onCreateOptionsMenu
                    //show = mActivity.superOnCreatePanelMenu(Window.FEATURE_OPTIONS_PANEL, menu);
                }

                if (show) {
                    // Make sure we're not dispatching item changes to presenters
                    menu.stopDispatchingItemsChanged();
                    // Dispatch onPrepareOptionsMenu
                    //show = mActivity.superOnPreparePanel(Window.FEATURE_OPTIONS_PANEL, null, menu);
                }
            }

            if (show) {
                createdPanelView = (View) getListMenuView(mActivity, this);

                // Allow menu to start dispatching changes to presenters
                menu.startDispatchingItemsChanged();
            } else {
                // If the menu isn't being shown, we no longer need it
                setMenu(null);
            }
        }

        return createdPanelView;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.947 -0400", hash_original_method = "03F62539232B8BD3554CC7C0D8A04F44", hash_generated_method = "E9184D383A351A22B60283C636AE3032")
    
@Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId != Window.FEATURE_OPTIONS_PANEL) {
            return mActivity.superOnCreatePanelMenu(featureId, menu);
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.952 -0400", hash_original_method = "D0FBE5F8815F193B2A5FFC941EB1ED4A", hash_generated_method = "3F09EA26102221C786E975EF8E397859")
    
@Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId != Window.FEATURE_OPTIONS_PANEL) {
            return mActivity.superOnPreparePanel(featureId, view, menu);
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.956 -0400", hash_original_method = "3D560D7D9A0A1F78AA4B3307FB162103", hash_generated_method = "D9AD02E1DEE878F2DAC702289C95F497")
    
@Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            item = MenuWrapperFactory.createMenuItemWrapper(item);
        }
        return mActivity.superOnMenuItemSelected(featureId, item);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.961 -0400", hash_original_method = "B6A1E7D6BFBBD8FCA0E35E06EF25A1E3", hash_generated_method = "3BDE9B0C25FD2C502C068489384A4053")
    
@Override
    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
        return mActivity.onMenuItemSelected(Window.FEATURE_OPTIONS_PANEL, item);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.965 -0400", hash_original_method = "08D15C6BA057612B39E36616E42F0F8D", hash_generated_method = "088D154A2A70D2255A5470B12130CD83")
    
@Override
    public void onMenuModeChange(MenuBuilder menu) {
        reopenMenu(menu, true);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.969 -0400", hash_original_method = "0E6DB963705CC7BABB9C51126CEDCE46", hash_generated_method = "F8285C11A039A225A622D4354EA922D8")
    
@Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        mActivity.closeOptionsMenu();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.973 -0400", hash_original_method = "1185DB8BF434B77102D0B31BC3E2A51C", hash_generated_method = "118EDE36DF6A32963DA857B791CCA488")
    
@Override
    public boolean onOpenSubMenu(MenuBuilder subMenu) {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.979 -0400", hash_original_method = "444CE4DB24561452F2ADA2EAC7FDD0FC", hash_generated_method = "15139CB1A93FF10279D0E858EA4B26D8")
    
@Override
    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }

        if (mActionMode != null) {
            mActionMode.finish();
        }

        final ActionMode.Callback wrappedCallback = new ActionModeCallbackWrapper(callback);

        ActionBarImplBase ab = (ActionBarImplBase) getSupportActionBar();
        if (ab != null) {
            mActionMode = ab.startActionMode(wrappedCallback);
        }

        if (mActionMode != null) {
            mActivity.onSupportActionModeStarted(mActionMode);
        }
        return mActionMode;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.984 -0400", hash_original_method = "D829D03F3EEA688C586DDF7226675AC8", hash_generated_method = "17EB494E3590C36A70139CAD115E8F49")
    
@Override
    public void supportInvalidateOptionsMenu() {
        if (!mInvalidateMenuPosted) {
            mInvalidateMenuPosted = true;
            mActivity.getWindow().getDecorView().post(mInvalidateMenuRunnable);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.988 -0400", hash_original_method = "91ED48DDB5F9DCDA303F6AFD41495881", hash_generated_method = "F67F0D7D854F6F0E0FB59752591E8772")
    
private MenuBuilder createMenu() {
        MenuBuilder menu = new MenuBuilder(getActionBarThemedContext());
        menu.setCallback(this);
        return menu;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.993 -0400", hash_original_method = "9791CBF5767CB87BF0A074977F6A4187", hash_generated_method = "6E90E8108FE3CE2EF6DEBDC9365D5671")
    
private void reopenMenu(MenuBuilder menu, boolean toggleMenuMode) {
        if (mActionBarView != null && mActionBarView.isOverflowReserved()) {
            if (!mActionBarView.isOverflowMenuShowing() || !toggleMenuMode) {
                if (mActionBarView.getVisibility() == View.VISIBLE) {
                    mActionBarView.showOverflowMenu();
                }
            } else {
                mActionBarView.hideOverflowMenu();
            }
            return;
        }

        menu.close();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.999 -0400", hash_original_method = "B2B61C593E8DC52AE53E783750770F10", hash_generated_method = "C6DC0B73AE460F4986922A7A93462522")
    
private MenuView getListMenuView(Context context, MenuPresenter.Callback cb) {
        if (mMenu == null) {
            return null;
        }

        if (mListMenuPresenter == null) {
            TypedArray a = context.obtainStyledAttributes(R.styleable.Theme);
            final int listPresenterTheme = a.getResourceId(
                    R.styleable.Theme_panelMenuListTheme,
                    R.style.Theme_AppCompat_CompactMenu);
            a.recycle();

            mListMenuPresenter = new ListMenuPresenter(
                    R.layout.abc_list_menu_item_layout, listPresenterTheme);
            mListMenuPresenter.setCallback(cb);
            mMenu.addMenuPresenter(mListMenuPresenter);
        } else {
            // Make sure we update the ListView
            mListMenuPresenter.updateMenuView(false);
        }

        return mListMenuPresenter.getMenuView(new FrameLayout(context));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.004 -0400", hash_original_method = "6ACA0E4C5896376AB2A5AE5B75AA5D7E", hash_generated_method = "46DB5474BC980AD9C2CB47AB325E49F0")
    
private void setMenu(MenuBuilder menu) {
        if (menu == mMenu) {
            return;
        }

        if (mMenu != null) {
            mMenu.removeMenuPresenter(mListMenuPresenter);
        }
        mMenu = menu;

        if (menu != null && mListMenuPresenter != null) {
            // Only update list menu if there isn't an action mode menu
            menu.addMenuPresenter(mListMenuPresenter);
        }
        /*if (mActionBarView != null) {
            mActionBarView.setMenu(menu, this);
        }*/
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.008 -0400", hash_original_method = "ADE8C54E67965A162EEB2F00E326D3CE", hash_generated_method = "A532F91AD8FCF0A0A93FF22569A1F970")
    
@Override
    public boolean onBackPressed() {
        // Back cancels action modes first.
        if (mActionMode != null) {
            mActionMode.finish();
            return true;
        }

        // Next collapse any expanded action views.
        if (mActionBarView != null && mActionBarView.hasExpandedActionView()) {
            mActionBarView.collapseActionView();
            return true;
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.013 -0400", hash_original_method = "1BC73AB51342F388FC9E3DB8009AEEC1", hash_generated_method = "0730766A59BA598EC0F115377714DC04")
    
@Override
    void setSupportProgressBarVisibility(boolean visible) {
        updateProgressBars(visible ? Window.PROGRESS_VISIBILITY_ON :
                Window.PROGRESS_VISIBILITY_OFF);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.017 -0400", hash_original_method = "036EE14518735D808D3CB8950FF07B41", hash_generated_method = "85CB7FDDE4C46E3A9A70706AEB185361")
    
@Override
    void setSupportProgressBarIndeterminateVisibility(boolean visible) {
        updateProgressBars(visible ? Window.PROGRESS_VISIBILITY_ON :
                Window.PROGRESS_VISIBILITY_OFF);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.021 -0400", hash_original_method = "89783CB7DB3794ED51FB9ED1CC8B681C", hash_generated_method = "19F665471CB85D1192FEF1AE93D32A2E")
    
@Override
    void setSupportProgressBarIndeterminate(boolean indeterminate) {
        updateProgressBars(indeterminate ? Window.PROGRESS_INDETERMINATE_ON
                : Window.PROGRESS_INDETERMINATE_OFF);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.025 -0400", hash_original_method = "4EE0A29AC9C8CBDE12E5322B0A6C84A0", hash_generated_method = "2E4E6389E497BE9C564076BEE8ED7199")
    
@Override
    void setSupportProgress(int progress) {
        updateProgressBars(Window.PROGRESS_START + progress);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.030 -0400", hash_original_method = "EEC3A9B57896DC93FFFC6E04D6F55636", hash_generated_method = "6131A1F397061CF5300C5599A04569C4")
    
@Override
    ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl();
    }

    /**
     * Progress Bar function. Mostly extracted from PhoneWindow.java
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.036 -0400", hash_original_method = "2AD65621D0635456A6083A503234FC83", hash_generated_method = "B964E97FED374457F5CB3C2FEA97D8BF")
    
private void updateProgressBars(int value) {
        ProgressBarICS circularProgressBar = getCircularProgressBar();
        ProgressBarICS horizontalProgressBar = getHorizontalProgressBar();

        if (value == Window.PROGRESS_VISIBILITY_ON) {
            if (mFeatureProgress) {
                int level = horizontalProgressBar.getProgress();
                int visibility = (horizontalProgressBar.isIndeterminate() || level < 10000) ?
                        View.VISIBLE : View.INVISIBLE;
                horizontalProgressBar.setVisibility(visibility);
            }
            if (mFeatureIndeterminateProgress) {
                circularProgressBar.setVisibility(View.VISIBLE);
            }
        } else if (value == Window.PROGRESS_VISIBILITY_OFF) {
            if (mFeatureProgress) {
                horizontalProgressBar.setVisibility(View.GONE);
            }
            if (mFeatureIndeterminateProgress) {
                circularProgressBar.setVisibility(View.GONE);
            }
        } else if (value == Window.PROGRESS_INDETERMINATE_ON) {
            horizontalProgressBar.setIndeterminate(true);
        } else if (value == Window.PROGRESS_INDETERMINATE_OFF) {
            horizontalProgressBar.setIndeterminate(false);
        } else if (Window.PROGRESS_START <= value && value <= Window.PROGRESS_END) {
            // We want to set the progress value before testing for visibility
            // so that when the progress bar becomes visible again, it has the
            // correct level.
            horizontalProgressBar.setProgress(value - Window.PROGRESS_START);

            if (value < Window.PROGRESS_END) {
                showProgressBars(horizontalProgressBar, circularProgressBar);
            } else {
                hideProgressBars(horizontalProgressBar, circularProgressBar);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.041 -0400", hash_original_method = "B78744FDBC19EBD333395C4C56E14B8E", hash_generated_method = "7C8FB3F4DCA91C8C3AE3E23F96ABF4EB")
    
private void showProgressBars(ProgressBarICS horizontalProgressBar,
            ProgressBarICS spinnyProgressBar) {
        if (mFeatureIndeterminateProgress && spinnyProgressBar.getVisibility() == View.INVISIBLE) {
            spinnyProgressBar.setVisibility(View.VISIBLE);
        }
        // Only show the progress bars if the primary progress is not complete
        if (mFeatureProgress && horizontalProgressBar.getProgress() < 10000) {
            horizontalProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.045 -0400", hash_original_method = "A3D07F26E9EA151E20B13E144D4A407D", hash_generated_method = "0394834D69D7404738EE423C6409B984")
    
private void hideProgressBars(ProgressBarICS horizontalProgressBar,
            ProgressBarICS spinnyProgressBar) {
        if (mFeatureIndeterminateProgress && spinnyProgressBar.getVisibility() == View.VISIBLE) {
            spinnyProgressBar.setVisibility(View.INVISIBLE);
        }
        if (mFeatureProgress && horizontalProgressBar.getVisibility() == View.VISIBLE) {
            horizontalProgressBar.setVisibility(View.INVISIBLE);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.050 -0400", hash_original_method = "77FF2A1A01D7AF4EEA1942E588239F03", hash_generated_method = "776F379B96FD481F56E3932C1AA292EE")
    
private ProgressBarICS getCircularProgressBar() {
        ProgressBarICS pb = (ProgressBarICS) mActionBarView.findViewById(R.id.progress_circular);
        if (pb != null) {
            pb.setVisibility(View.INVISIBLE);
        }
        return pb;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.053 -0400", hash_original_method = "73A1A6EDA3340351A356B2E945EA07D0", hash_generated_method = "AD88E414A05242319862FC97830BC249")
    
private ProgressBarICS getHorizontalProgressBar() {
        ProgressBarICS pb = (ProgressBarICS) mActionBarView.findViewById(R.id.progress_horizontal);
        if (pb != null) {
            pb.setVisibility(View.INVISIBLE);
        }
        return pb;
    }

    /**
     * Clears out internal reference when the action mode is destroyed.
     */
    private class ActionModeCallbackWrapper implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapper(ActionMode.Callback wrapped) {
            mWrapped = wrapped;
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return mWrapped.onCreateActionMode(mode, menu);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return mWrapped.onPrepareActionMode(mode, menu);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return mWrapped.onActionItemClicked(mode, item);
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void onDestroyActionMode(ActionMode mode) {
            mWrapped.onDestroyActionMode(mode);
            mActivity.onSupportActionModeFinished(mode);
            mActionMode = null;
        }
    }

    private class ActionBarDrawableToggleImpl
            implements ActionBarDrawerToggle.Delegate {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Drawable getThemeUpIndicator() {
            final TypedArray a = mActivity.obtainStyledAttributes(ACTION_BAR_DRAWABLE_TOGGLE_ATTRS);
            final Drawable result = a.getDrawable(0);
            a.recycle();
            return result;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setActionBarUpIndicator(Drawable upDrawable, int contentDescRes) {
            if (mActionBarView != null) {
                mActionBarView.setHomeAsUpIndicator(upDrawable);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void setActionBarDescription(int contentDescRes) {
            // No support for setting Action Bar content description
        }
    }

}
