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
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

class ActionBarImplHC extends ActionBarImplBase
        implements NativeActionModeAwareLayout.OnActionModeForChildListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.533 -0400", hash_original_field = "CF97E3B53DD703B3CE9D939F5386EF1A", hash_generated_field = "CF97E3B53DD703B3CE9D939F5386EF1A")

     NativeActionModeAwareLayout mNativeActionModeAwareLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.536 -0400", hash_original_field = "48ABAD2021433D1A75BA1588C2366122", hash_generated_field = "3026006E0EAADB8BACC56464391EC291")

    private ActionMode mCurActionMode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.540 -0400", hash_original_method = "599FD04C826E922A6CEE3D2ADC678F08", hash_generated_method = "E28203478FE20AF79B328C0F7B29A3DD")
    
public ActionBarImplHC(ActionBarActivity activity, Callback callback) {
        super(activity, callback);

        // NativeActionModeAwareLayout is used to notify us whena native Action Mode is started
        mNativeActionModeAwareLayout = (NativeActionModeAwareLayout) activity
                .findViewById(R.id.action_bar_root);

        // Can be null when using FEATURE_ACTION_BAR_OVERLAY
        if (mNativeActionModeAwareLayout != null) {
            mNativeActionModeAwareLayout.setActionModeForChildListener(this);
        }
    }

    // From NativeActionModeAwareLayout.OnActionModeForChildListener
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.544 -0400", hash_original_method = "5C1FF5F038F738689804F013E648BD98", hash_generated_method = "AAD11A6FA1975330DD29802978B12FD1")
    
@Override
    public ActionMode.Callback onActionModeForChild(ActionMode.Callback callback) {
        return new CallbackWrapper(callback);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.547 -0400", hash_original_method = "399FF41AD5D1CC997F989351CB2FC081", hash_generated_method = "C98E42464C66A5F1C9B168C5848CA755")
    
@Override
    public void show() {
        super.show();
        if (mCurActionMode != null) {
            mCurActionMode.finish();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.551 -0400", hash_original_method = "2535E52C4E223E897D6EABC095CF72D5", hash_generated_method = "727D0B78C814A4A352EF325EA3D5797B")
    
@Override
    public void hide() {
        super.hide();
        if (mCurActionMode != null) {
            mCurActionMode.finish();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:33.554 -0400", hash_original_method = "8EC3F05E3CA7C597730A8D8B12B6C564", hash_generated_method = "BDE5FAD4F6BE477EDB97A0FCFE0C99E7")
    
@Override
    boolean isShowHideAnimationEnabled() {
        // Only allow animation if we're not currently showing an action mode
        return mCurActionMode == null && super.isShowHideAnimationEnabled();
    }

    private class CallbackWrapper implements ActionMode.Callback {
        private final ActionMode.Callback mWrappedCallback;

        CallbackWrapper(ActionMode.Callback callback) {
            mWrappedCallback = callback;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            final boolean wrappedResult = mWrappedCallback.onCreateActionMode(mode, menu);
            if (wrappedResult) {
                // Keep reference to action mode
                mCurActionMode = mode;
                // Make sure that the compat Action Bar is shown
                showForActionMode();
            }
            return wrappedResult;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return mWrappedCallback.onPrepareActionMode(mode, menu);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return mWrappedCallback.onActionItemClicked(mode, item);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mWrappedCallback.onDestroyActionMode(mode);

            // We previously shown the Action Bar for positioning purposes, now hide it again
            hideForActionMode();
            // Remove any reference to the mode
            mCurActionMode = null;
        }
    }
}
