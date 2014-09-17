/*
 * Copyright (C) 2014 The Android Open Source Project
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
import android.view.View;
import android.view.animation.Interpolator;

class ViewPropertyAnimatorCompatJellybeanMr2 {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.713 -0400", hash_original_method = "451122CF84D7574C0940D9087FDB7881", hash_generated_method = "44F048EC3A95059C2E6E36A470DE194F")
    
public static Interpolator getInterpolator(View view) {
        //return (Interpolator) view.animate().getInterpolator();
    	return new Interpolator() {
			
			@Override
			@DSComment("Abstract Method")
			@DSSpec(DSCat.ABSTRACT_METHOD)
			public
			float getInterpolation(float input) {
				// TODO Auto-generated method stub
				return input; 
			}
		};
    }
}
