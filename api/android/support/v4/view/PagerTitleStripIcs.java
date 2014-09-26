/*
 * Copyright (C) 2012 The Android Open Source Project
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
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

class PagerTitleStripIcs {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:29.759 -0500", hash_original_method = "B0A851A0B0BB297371B5DC2B145B2E98", hash_generated_method = "7ED54DB1D913AE8916877F28D5520124")
    
public static void setSingleLineAllCaps(TextView text) {
        text.setTransformationMethod(new SingleLineAllCapsTransform(text.getContext()));
    }

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:29.761 -0500", hash_original_field = "74D85C5E9C3AEE165ECF48807AB6B26E", hash_generated_field = "BA38CB17745A316A682DD1807824423A")

        private static final String TAG = "SingleLineAllCapsTransform";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:29.762 -0500", hash_original_field = "D959780368C6CA232CF8C3906CDDEDF3", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

        private Locale mLocale;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:29.763 -0500", hash_original_method = "4C2D06E04273338AC4EC5853A2EDD665", hash_generated_method = "2BCB3B97FB66BF641827993DA68FDB10")
        
public SingleLineAllCapsTransform(Context context) {
            mLocale = context.getResources().getConfiguration().locale;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:29.764 -0500", hash_original_method = "D86D9A1AA103AB45F13A7134C7371BA5", hash_generated_method = "5C5D42822347EC8BEA9F3936287FFE89")
        
@Override
        public CharSequence getTransformation(CharSequence source, View view) {
            source = super.getTransformation(source, view);
            return source != null ? source.toString().toUpperCase(mLocale) : null;
        }
    }
}
