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

package android.support.v7.internal.widget;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @hide
 */
public class NativeActionModeAwareLayout extends LinearLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.962 -0400", hash_original_field = "23407C7CCB56BE7EE1980FFA24D7588B", hash_generated_field = "C37B0104FBC5F715CC484B81D1A39110")


    private OnActionModeForChildListener mActionModeForChildListener;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.965 -0400", hash_original_method = "442556088DE8017C4A804C66DB5E4027", hash_generated_method = "4C35E1E12307F009579FC05DFB72AE6C")
    
public NativeActionModeAwareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.967 -0400", hash_original_method = "7B93844020F0CA6E6D45E5B3DBB5AF7C", hash_generated_method = "BAC32E7287583C9238D3A46D4379B962")
    
public void setActionModeForChildListener(OnActionModeForChildListener listener) {
        mActionModeForChildListener = listener;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:48.970 -0400", hash_original_method = "ED7176CB249EE63B6F19D5A22FAC367D", hash_generated_method = "760B0846C93D83FC54E5BD8C78BE7F08")
    
@Override
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        if (mActionModeForChildListener != null) {
            callback = mActionModeForChildListener.onActionModeForChild(callback);
        }
        return super.startActionModeForChild(originalView, callback);
    }

    /**
     * @hide
     */
    public interface OnActionModeForChildListener {
        ActionMode.Callback onActionModeForChild(ActionMode.Callback callback);
    }
}
