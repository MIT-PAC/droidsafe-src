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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.Interpolator;

import java.util.WeakHashMap;

class ViewPropertyAnimatorCompatICS {

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.498 -0400", hash_original_method = "5B72454FB177F59E7CBA37C7E1CE2864", hash_generated_method = "E89C1AB4373908D9378581A995A2AE1C")
    
public static void setDuration(View view, long value) {
        view.animate().setDuration(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.501 -0400", hash_original_method = "3B5B2AA511C9E44E135E99DC0833AB5B", hash_generated_method = "2FD75BE167E660CA9F985CD8225F1DB2")
    
public static void alpha(View view, float value) {
        view.animate().alpha(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.504 -0400", hash_original_method = "DD1230D7BFFF28AF06690C9049FBE1D7", hash_generated_method = "482459709D905412FC0306E05C8C1737")
    
public static void translationX(View view, float value) {
        view.animate().translationX(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.507 -0400", hash_original_method = "E8739F55666BAD8D4EA40AA0DBEE8167", hash_generated_method = "9897315E8533545C81DFB99F31A6D606")
    
public static void translationY(View view, float value) {
        view.animate().translationY(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.511 -0400", hash_original_method = "95D16675068A1991021F4F60B985835E", hash_generated_method = "F0310E2397B736AA158A9FEED3BC16B8")
    
public static long getDuration(View view) {
        return view.animate().getDuration();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.514 -0400", hash_original_method = "63A67CCCAF9E8C04413A80C40CB956EF", hash_generated_method = "DD8D8F915D8B97F6B79C458BBB8ED422")
    
public static void setInterpolator(View view, Interpolator value) {
        view.animate().setInterpolator(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.516 -0400", hash_original_method = "96B7EF00070B4CF818FF4C0AE8AC91EA", hash_generated_method = "2117EC762D83837475037808D9FD2644")
    
public static void setStartDelay(View view, long value) {
        view.animate().setStartDelay(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.519 -0400", hash_original_method = "9702F2364EF7527A5BA2E15B8A23E812", hash_generated_method = "8F602A0F63C90961B17C9A0728C44103")
    
public static long getStartDelay(View view) {
        return view.animate().getStartDelay();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.522 -0400", hash_original_method = "ACE86973C0F9E3E27E4A05D01CD0C7A3", hash_generated_method = "A2E838F50E18866949E0077D55B51472")
    
public static void alphaBy(View view, float value) {
        view.animate().alphaBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.525 -0400", hash_original_method = "DCACBD93498642DAB1E6ACA51DBA5381", hash_generated_method = "6A6EFB03BABE29B8D7A00FEAE270514F")
    
public static void rotation(View view, float value) {
        view.animate().rotation(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.528 -0400", hash_original_method = "8991723AB2C13233D22D6CC29EAED6A2", hash_generated_method = "A35346E606F53031C74DB6694E868225")
    
public static void rotationBy(View view, float value) {
        view.animate().rotationBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.531 -0400", hash_original_method = "7B9FAA038347434684D332A89CFC0D3F", hash_generated_method = "6908A9E116604181B4969FAEEB6B358C")
    
public static void rotationX(View view, float value) {
        view.animate().rotationX(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.534 -0400", hash_original_method = "145E81961D2B72B457FE762B4982FFD0", hash_generated_method = "88FA39D6DA5911BF9D60333FA74700D8")
    
public static void rotationXBy(View view, float value) {
        view.animate().rotationXBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.537 -0400", hash_original_method = "AC0068E6CEF427952D3AC9E5A0B8303F", hash_generated_method = "4A92F40A95A183075EA08AD87F8B652A")
    
public static void rotationY(View view, float value) {
        view.animate().rotationY(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.540 -0400", hash_original_method = "02A47DA77CB23CFCC0817E528302FE89", hash_generated_method = "8E1073F89724E21F7D5042C7E3744C36")
    
public static void rotationYBy(View view, float value) {
        view.animate().rotationYBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.543 -0400", hash_original_method = "E7D526BE5545A58F586261C05EEB02E7", hash_generated_method = "98AD8C2C33AA04D06D19D2837E47B500")
    
public static void scaleX(View view, float value) {
        view.animate().scaleX(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.546 -0400", hash_original_method = "69C2CACA655723D90B5220BC85C18B96", hash_generated_method = "891D0BE9898A80F9C7FDC64E3087C663")
    
public static void scaleXBy(View view, float value) {
        view.animate().scaleXBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.549 -0400", hash_original_method = "BD41C1458054F7092E84CB29BCF16F3C", hash_generated_method = "D3FF09418AEB64C1431D1C230E3A55BA")
    
public static void scaleY(View view, float value) {
        view.animate().scaleY(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.552 -0400", hash_original_method = "D1ACB36402B015EA0762A2FCA1C636E7", hash_generated_method = "6E10F6FFAF7239C3385DF256A0DE963F")
    
public static void scaleYBy(View view, float value) {
        view.animate().scaleYBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.555 -0400", hash_original_method = "2892F95601444388AA268A2AFB338A80", hash_generated_method = "7DE69F5A6AE0C7032C94EF9E782FFCFC")
    
public static void cancel(View view) {
        view.animate().cancel();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.558 -0400", hash_original_method = "3002E9A596CC81F6B9E702A5D7C3E32C", hash_generated_method = "82D42E979651A717FF93D9646AD07AEB")
    
public static void x(View view, float value) {
        view.animate().x(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.561 -0400", hash_original_method = "0726369898EE91E383285FB59CD00C9F", hash_generated_method = "5E2C8AA69AA2EA7EC0129A92DCBE357B")
    
public static void xBy(View view, float value) {
        view.animate().xBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.564 -0400", hash_original_method = "B8EB813892AB10AAA80B0C0D8C646A5C", hash_generated_method = "E7E9D117C3AADDE4EDFD9B3B12BF97D9")
    
public static void y(View view, float value) {
        view.animate().y(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.567 -0400", hash_original_method = "E012B10FE1CAA3E3D0EE5B65F60847A1", hash_generated_method = "FBC48C9510A16FAC88EE23EB2BD7F301")
    
public static void yBy(View view, float value) {
        view.animate().yBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.570 -0400", hash_original_method = "535BA471BFF0CD3B20D4A941575E5CF1", hash_generated_method = "1A32A69218098EA49F3AE791DCD8C890")
    
public static void translationXBy(View view, float value) {
        view.animate().translationXBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.573 -0400", hash_original_method = "D7076BA8A199AD33CEBB131EEB018395", hash_generated_method = "ECBBDFE326415AA5DC9474EE66ABB528")
    
public static void translationYBy(View view, float value) {
        view.animate().translationYBy(value);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.575 -0400", hash_original_method = "082AD06F85E145EFF2BB4E0C977E0AE7", hash_generated_method = "9FF987FD6164BA2BC15B2262E1E3254D")
    
public static void start(View view) {
        view.animate().start();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:07.590 -0400", hash_original_method = "04D7EB5A0536442A9A2124F458BA8C8E", hash_generated_method = "5B53697BF8C6C0E3753B5A133754AD4B")
    
public static void setListener(final View view,
            final ViewPropertyAnimatorListener listener) {
        view.animate().setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                listener.onAnimationCancel(view);
            }

            @DSSafe(DSCat.ANDROID_ANIMATION)
        @Override
            public void onAnimationEnd(Animator animation) {
                listener.onAnimationEnd(view);
            }

            @DSSafe(DSCat.ANDROID_ANIMATION)
        @Override
            public void onAnimationStart(Animator animation) {
                listener.onAnimationStart(view);
            }
        });
    }
}
