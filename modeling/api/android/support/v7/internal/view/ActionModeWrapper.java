/*
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

package android.support.v7.internal.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

/**
 * @hide
 */
public class ActionModeWrapper extends ActionMode {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.506 -0400", hash_original_field = "F8A6F06EECAE5E1F88EB1D958FECB66C", hash_generated_field = "F8A6F06EECAE5E1F88EB1D958FECB66C")

     MenuInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.509 -0400", hash_original_field = "A6870F960C783A956211935C5876C7FF", hash_generated_field = "A6870F960C783A956211935C5876C7FF")

     android.view.ActionMode mWrappedObject;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.513 -0400", hash_original_method = "93C1BFA5D3C1FE248097D1EFD663E8C0", hash_generated_method = "44814C896D7CA6DC586B5B65A6D598A1")
    
public ActionModeWrapper(Context context, android.view.ActionMode frameworkActionMode) {
        mWrappedObject = frameworkActionMode;
        mInflater = new SupportMenuInflater(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.515 -0400", hash_original_method = "F156FE30E30FFAECBC050DC9933D8C01", hash_generated_method = "503E9068ECACF92B16FEC103C8DC6774")
    
@Override
    public Object getTag() {
        return mWrappedObject.getTag();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.519 -0400", hash_original_method = "EE1E96637E21487C3D47B3957B9F06FD", hash_generated_method = "30769E152959FB69F3CA99F4470F9BD8")
    
@Override
    public void setTag(Object tag) {
        mWrappedObject.setTag(tag);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.522 -0400", hash_original_method = "F5415E2621A74B3FCE7AFEE31597FB80", hash_generated_method = "A8F2D6463CAA101AD27A0A7ACC0D5773")
    
@Override
    public boolean getTitleOptionalHint() {
        return mWrappedObject.getTitleOptionalHint();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.524 -0400", hash_original_method = "1955C5F435E8D489895FAE838A3D62A3", hash_generated_method = "FEA0806D132F74A2D05C42B0C27136CE")
    
@Override
    public void setTitleOptionalHint(boolean titleOptional) {
        mWrappedObject.setTitleOptionalHint(titleOptional);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.527 -0400", hash_original_method = "BFAAC001D13775D5612A7E220F4D1389", hash_generated_method = "02B89AA789373D09239256F5114C1AC2")
    
@Override
    public boolean isTitleOptional() {
        return mWrappedObject.isTitleOptional();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.530 -0400", hash_original_method = "9F901F54FE7A4548E5EA87AA6AA11A2E", hash_generated_method = "FEDBD96C9AC37778DF21F3AEAAEB5AB4")
    
@Override
    public void setTitle(CharSequence title) {
        mWrappedObject.setTitle(title);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.533 -0400", hash_original_method = "672725B12BD44589913992F61DE87730", hash_generated_method = "BF390898B58160BE4E94BCFCD2E66280")
    
@Override
    public void setSubtitle(CharSequence subtitle) {
        mWrappedObject.setSubtitle(subtitle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.536 -0400", hash_original_method = "5A3AF11897C2BC2D0AEB2DBD8850CB4D", hash_generated_method = "D5F625098974EDE847DED34B7789F8F9")
    
@Override
    public void invalidate() {
        mWrappedObject.invalidate();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.538 -0400", hash_original_method = "2C644FC46CEDAB21E01FEE987AD613C0", hash_generated_method = "161157D9B7A2030A59978A948952E90E")
    
@Override
    public void finish() {
        mWrappedObject.finish();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.540 -0400", hash_original_method = "62EC8ABFA22AFF3F1F1CD9A3A0F81313", hash_generated_method = "1DBE9CD06932D4BFE7ADE6670197EA8E")
    
@Override
    public Menu getMenu() {
        return MenuWrapperFactory.createMenuWrapper(mWrappedObject.getMenu());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.543 -0400", hash_original_method = "9EE6D2DDA3272B8060633454B2464840", hash_generated_method = "8BB2563A2B07C0D3BCAC1558BFFD5FC0")
    
@Override
    public CharSequence getTitle() {
        return mWrappedObject.getTitle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.545 -0400", hash_original_method = "4F40FD75A0BCF8E899E7335BA137E4C1", hash_generated_method = "63794C3E9FB481335E3AFB5ED10CCEC8")
    
@Override
    public void setTitle(int resId) {
        mWrappedObject.setTitle(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.550 -0400", hash_original_method = "18FA7029BE6B2FDD66C87F9A41B06F92", hash_generated_method = "A246FCB6B1E8060A25248D904983DE38")
    
@Override
    public CharSequence getSubtitle() {
        return mWrappedObject.getSubtitle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.553 -0400", hash_original_method = "B9B3E027331CB93A09F0248A4B8A579C", hash_generated_method = "A8B92E3739A604BC8FF610BC563DBD72")
    
@Override
    public void setSubtitle(int resId) {
        mWrappedObject.setSubtitle(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.555 -0400", hash_original_method = "AA6A8DDE643503619FA37E18CC1295D0", hash_generated_method = "003E4FE43935E4EDB9822A21A1D705AD")
    
@Override
    public View getCustomView() {
        return mWrappedObject.getCustomView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.558 -0400", hash_original_method = "2FD6C87556AB8E688800B1984378FD9F", hash_generated_method = "A522E5DB2D3A5AFB8E58878EC4A64385")
    
@Override
    public void setCustomView(View view) {
        mWrappedObject.setCustomView(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:34.561 -0400", hash_original_method = "E68B4DEFF11D44B86A279219AFC28C8E", hash_generated_method = "BD32A09B132F51B5EFF81BE2053DA164")
    
@Override
    public MenuInflater getMenuInflater() {
        return mInflater;
    }

    /**
     * @hide
     */
    public static class CallbackWrapper implements android.view.ActionMode.Callback {
        final Callback mWrappedCallback;
        final Context mContext;

        private ActionModeWrapper mLastStartedActionMode;

        public CallbackWrapper(Context context, Callback supportCallback) {
            mContext = context;
            mWrappedCallback = supportCallback;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onCreateActionMode(android.view.ActionMode mode, android.view.Menu menu) {
            return mWrappedCallback.onCreateActionMode(getActionModeWrapper(mode),
                    MenuWrapperFactory.createMenuWrapper(menu));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onPrepareActionMode(android.view.ActionMode mode, android.view.Menu menu) {
            return mWrappedCallback.onPrepareActionMode(getActionModeWrapper(mode),
                    MenuWrapperFactory.createMenuWrapper(menu));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onActionItemClicked(android.view.ActionMode mode,
                android.view.MenuItem item) {
            return mWrappedCallback.onActionItemClicked(getActionModeWrapper(mode),
                    MenuWrapperFactory.createMenuItemWrapper(item));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onDestroyActionMode(android.view.ActionMode mode) {
            mWrappedCallback.onDestroyActionMode(getActionModeWrapper(mode));
        }

        @DSSafe(DSCat.SAFE_LIST)
        public void setLastStartedActionMode(ActionModeWrapper modeWrapper) {
            mLastStartedActionMode = modeWrapper;
        }

        @DSSafe(DSCat.SAFE_LIST)
        private ActionMode getActionModeWrapper(android.view.ActionMode mode) {
            if (mLastStartedActionMode != null && mLastStartedActionMode.mWrappedObject == mode) {
                // If the given mode equals our wrapped mode, just return it
                return mLastStartedActionMode;
            } else {
                return new ActionModeWrapper(mContext, mode);
            }
        }
    }
}
