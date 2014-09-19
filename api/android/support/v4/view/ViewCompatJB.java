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
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

/**
 * Jellybean-specific View API access
 */
class ViewCompatJB {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.754 -0400", hash_original_method = "2997C5F9853FAF53A449451414C35954", hash_generated_method = "7EA2C74A15249C30AF62D5E7ED9655AF")
    
public static boolean hasTransientState(View view) {
        return view.hasTransientState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.766 -0400", hash_original_method = "DF9629C5FD5104B48BCC1769DFAB6FA5", hash_generated_method = "1C63B61BB29D26AA267D04800856BF63")
    
public static void setHasTransientState(View view, boolean hasTransientState) {
        view.setHasTransientState(hasTransientState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.774 -0400", hash_original_method = "E32A06C33CB84697AACD607A3B6F0CBA", hash_generated_method = "8C4AFE84629623BC0FAF2DDC6011E21D")
    
public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.786 -0400", hash_original_method = "4EBC9A305A896996824DB41621EC9A8D", hash_generated_method = "6656C2383C227C9DBA1723A42404F77F")
    
public static void postInvalidateOnAnimation(View view, int left, int top,
            int right, int bottom) {
        view.postInvalidate(left, top, right, bottom);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.794 -0400", hash_original_method = "B57EA3592C8C42FE8BEC14B642264F3D", hash_generated_method = "98E8F3FA26E2B5194651B6B3CC63DD37")
    
public static void postOnAnimation(View view, Runnable action) {
        view.postOnAnimation(action);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.804 -0400", hash_original_method = "258D6EBC7AB02FD3802C120A4E57B577", hash_generated_method = "0EB140A083E69A31E051A10C828B0352")
    
public static void postOnAnimationDelayed(View view, Runnable action, long delayMillis) {
        view.postOnAnimationDelayed(action, delayMillis);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.813 -0400", hash_original_method = "A2626F275CD807A0DF903DB45C7A67BA", hash_generated_method = "594BEA42BD02DF6456BD60237B77E49B")
    
public static int getImportantForAccessibility(View view) {
        return view.getImportantForAccessibility();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.834 -0400", hash_original_method = "FC6DAB04671A2718A74B4214E0C316A5", hash_generated_method = "BA409EFB9F7C7C44C958AD3F99E511C5")
    
public static void setImportantForAccessibility(View view, int mode) {
        view.setImportantForAccessibility(mode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.852 -0400", hash_original_method = "194C472CAB18F3C52220B9C4BAD61DD1", hash_generated_method = "852EF31EE458C065A7684FBF048483D8")
    
public static boolean performAccessibilityAction(View view, int action, Bundle arguments) {
        return view.performAccessibilityAction(action, arguments);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.862 -0400", hash_original_method = "0BF3D7E4CD16CF3B0E221B7C13E91CE0", hash_generated_method = "D4FB4B7CFBFCD8588C1AA45C7DCEA4F6")
    
public static Object getAccessibilityNodeProvider(View view) {
        return view.getAccessibilityNodeProvider();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:42:57.872 -0400", hash_original_method = "4A239A5F406CDDFB23957C9E54CCECEA", hash_generated_method = "A947A3055DFF17BA6731769EDC088606")
    
public static ViewParent getParentForAccessibility(View view) {
        return view.getParentForAccessibility();
    }

	public static int getMinimumWidth(View view) {
		// TODO Auto-generated method stub
		return view.getMinimumWidth();
	}
	
	public static int getMinimumHeight(View view) {
		// TODO Auto-generated method stub
		return view.getMinimumHeight();
	}
}
