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


package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;

public class ExtractEditLayout extends LinearLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.011 -0500", hash_original_field = "84372CBE17BCE552A035CEA7A14F295A", hash_generated_field = "84372CBE17BCE552A035CEA7A14F295A")

    ExtractActionMode mActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.013 -0500", hash_original_field = "3B9794871E7B10840F19B29A2246BB31", hash_generated_field = "3B9794871E7B10840F19B29A2246BB31")

    Button mExtractActionButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.015 -0500", hash_original_field = "B2154EF2825FBCE7DE09C4738860180E", hash_generated_field = "B2154EF2825FBCE7DE09C4738860180E")

    Button mEditButton;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.017 -0500", hash_original_method = "5E5A3BB351E8D9D7F73E3207F63F4561", hash_generated_method = "F7A56E72915119248656F6E915BD40B9")
    
public ExtractEditLayout(Context context) {
        super(context);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.020 -0500", hash_original_method = "5B5DDD3A07057211F0994E26CEDA1A4A", hash_generated_method = "3FF74879CD47B620FD3745A8116422F0")
    
public ExtractEditLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.022 -0500", hash_original_method = "3AB740C640E719B54F03586FCEB648DB", hash_generated_method = "9A56200277F45BB67552B7B9BFB49B07")
    
@Override
    public ActionMode startActionModeForChild(View sourceView, ActionMode.Callback cb) {
        final ExtractActionMode mode = new ExtractActionMode(cb);
        if (mode.dispatchOnCreate()) {
            mode.invalidate();
            mExtractActionButton.setVisibility(INVISIBLE);
            mEditButton.setVisibility(VISIBLE);
            mActionMode = mode;
            sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            return mode;
        }
        return null;
    }

    /**
     * @return true if an action mode is currently active.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.024 -0500", hash_original_method = "587B198236267AC63B96064EC21D7789", hash_generated_method = "FA81C36F8DF5D2BA4B9635CE33CAECB6")
    
public boolean isActionModeStarted() {
        return mActionMode != null;
    }

    /**
     * Finishes a possibly started action mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.026 -0500", hash_original_method = "CFF93884DD9A272729CBAF15B54B9CD3", hash_generated_method = "34B1931F87CC1AB70BF43630E548F2D0")
    
public void finishActionMode() {
        if (mActionMode != null) {
            mActionMode.finish();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.032 -0500", hash_original_method = "F4E3F3E884E506D9FE93C33AFB725466", hash_generated_method = "F57748A137F4898F67CC2F0B65ACBBF6")
    
@Override
    public void onFinishInflate() {
        super.onFinishInflate();
        mExtractActionButton = (Button) findViewById(com.android.internal.R.id.inputExtractAction);
        mEditButton = (Button) findViewById(com.android.internal.R.id.inputExtractEditButton);
        mEditButton.setOnClickListener(new OnClickListener() {
            @DSSafe(DSCat.SAFE_LIST)
        public void onClick(View clicked) {
                if (mActionMode != null) {
                    new MenuPopupHelper(getContext(), mActionMode.mMenu, clicked).show();
                }
            }
        });
    }
    
    private class ExtractActionMode extends ActionMode implements MenuBuilder.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.035 -0500", hash_original_field = "E2F920D760DEB2BCDAE7988D1DB3FA5A", hash_generated_field = "8F251D8FB2618CB877D06AB4E966D630")

        private ActionMode.Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.037 -0500", hash_original_field = "E0FA7D9C40725579D8730D3DABE74643", hash_generated_field = "E0FA7D9C40725579D8730D3DABE74643")

        MenuBuilder mMenu;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.040 -0500", hash_original_method = "1DFFBDF48C83C4F81EE07812707228A4", hash_generated_method = "F8D13E55F46B95CC260024AD97EC27A7")
        
public ExtractActionMode(Callback cb) {
            mMenu = new MenuBuilder(getContext());
            mMenu.setCallback(this);
            mCallback = cb;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.043 -0500", hash_original_method = "F1AD782B0CD2259E0BE9FDDD0EC2ADD5", hash_generated_method = "3C407A74DF668365A0C3F1F37D355D39")
        
@Override
        public void setTitle(CharSequence title) {
            // Title will not be shown.
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.046 -0500", hash_original_method = "B30C6763E9E5F305FC4AC0CFECBEE869", hash_generated_method = "71ED5D641D68012971096394B0729D5E")
        
@Override
        public void setTitle(int resId) {
            // Title will not be shown.
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.048 -0500", hash_original_method = "EB006AC48BB7A6AA8B2958DC91304E5C", hash_generated_method = "52625096A6110B6E46AAC07A39455545")
        
@Override
        public void setSubtitle(CharSequence subtitle) {
            // Subtitle will not be shown.
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.050 -0500", hash_original_method = "1F86E8EB25240C47EC24308D126D97B9", hash_generated_method = "E1F78E11DA67FB56A35C9961A0795BA1")
        
@Override
        public void setSubtitle(int resId) {
            // Subtitle will not be shown.
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.053 -0500", hash_original_method = "3E94F533B6F67EA66D83CADA4353AF33", hash_generated_method = "2E318619E408B8AB7D6A959A732BA147")
        
@Override
        public void setCustomView(View view) {
            // Custom view is not supported here.
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.055 -0500", hash_original_method = "AE3782F4A9FD5538AF0C8FC979CD15B1", hash_generated_method = "C7B93D882D43833903DA2C39ACBD8C5D")
        
@Override
        public void invalidate() {
            mMenu.stopDispatchingItemsChanged();
            try {
                mCallback.onPrepareActionMode(this, mMenu);
            } finally {
                mMenu.startDispatchingItemsChanged();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.058 -0500", hash_original_method = "73ABB077D09B369F1D81F6F51241E9AF", hash_generated_method = "E6E10873790E802AB877A4675CDF0495")
        
public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            try {
                return mCallback.onCreateActionMode(this, mMenu);
            } finally {
                mMenu.startDispatchingItemsChanged();
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.060 -0500", hash_original_method = "2B69AFBC6E24AF84D26A0EF2F0EF4896", hash_generated_method = "24173C2D47628DB5A30B4E9C60662222")
        
@Override
        public void finish() {
            if (mActionMode != this) {
                // Not the active action mode - no-op
                return;
            }

            mCallback.onDestroyActionMode(this);
            mCallback = null;

            mExtractActionButton.setVisibility(VISIBLE);
            mEditButton.setVisibility(INVISIBLE);

            sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);

            mActionMode = null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.063 -0500", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "7AE22C739145027C00A176505D582411")
        
@Override
        public Menu getMenu() {
            return mMenu;
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.065 -0500", hash_original_method = "CD9B990298CF856E49A643E530553914", hash_generated_method = "CDCEE9683F3E38FE42C9823826F1C1DE")
        
@Override
        public CharSequence getTitle() {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.067 -0500", hash_original_method = "F475DA391A1931FE20FFD2579FFFF5AF", hash_generated_method = "C976D9440453D00E334CDABF0EC76D42")
        
@Override
        public CharSequence getSubtitle() {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.069 -0500", hash_original_method = "7A49E6A1A0BF55D8D926541A71E4907E", hash_generated_method = "6F301B3473369A299AB6637D3DF3F9B8")
        
@Override
        public View getCustomView() {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.072 -0500", hash_original_method = "DECFD94D9899EA20C3E59178999FB9F7", hash_generated_method = "DC6F839317893A37089C9D33ED9980A8")
        
@Override
        public MenuInflater getMenuInflater() {
            return new MenuInflater(getContext());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.074 -0500", hash_original_method = "51BD8FD51955B080CEEB769553E9A9F7", hash_generated_method = "F3140CE6E25A80B1C33AE5249B87891C")
        
@Override
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            if (mCallback != null) {
                return mCallback.onActionItemClicked(this, item);
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.077 -0500", hash_original_method = "BD3281B75359F57929C0B7D8E3BC0065", hash_generated_method = "73449E95AC0270C2FD8BB6A9F526EF3E")
        
@Override
        public void onMenuModeChange(MenuBuilder menu) {
        }
        
    }
    
}

