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
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ViewCompatHC {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.044 -0400", hash_original_method = "0D8BE47B4CC10913DB4ECAD1674E174D", hash_generated_method = "667F213CA83AB99077A2424BF50AA4B5")
    
static long getFrameTime() {
        return ValueAnimator.getFrameDelay();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.057 -0400", hash_original_method = "4F85A7DBE26C5D9F71383D656D0BAF22", hash_generated_method = "6CF3B8686C53C63511BB6521657B0134")
    
public static float getAlpha(View view) {
        return view.getAlpha();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.088 -0400", hash_original_method = "13C7B7D6BFB552836C47A79648A3D9CC", hash_generated_method = "0AE65DB0DFCC1B87C1481742525CAC13")
    
public static void setLayerType(View view, int layerType, Paint paint) {
        view.setLayerType(layerType, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.096 -0400", hash_original_method = "9B1C9F40C8B385E85FFD5E213EC50BE6", hash_generated_method = "64BD64267E48FAE833EF6BD6C412CE29")
    
public static int getLayerType(View view) {
        return view.getLayerType();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.107 -0400", hash_original_method = "0659225423D7C478FE12329F89589661", hash_generated_method = "01F49F8976435895433A3B75F35A21BA")
    
public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
        return View.resolveSizeAndState(size, measureSpec, childMeasuredState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.117 -0400", hash_original_method = "EE66E36CFC7F3CED3374D5640A0C4372", hash_generated_method = "DBADDC59F0A5EF22951A6EFB948F1047")
    
public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.126 -0400", hash_original_method = "2C7586AF371139F1301FBCF8DD0EDD25", hash_generated_method = "B3E66BD4EB91F320B89106F6FFFFA87F")
    
public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.147 -0400", hash_original_method = "8441914CD5B1182AA9498A8EE0E68C6A", hash_generated_method = "66DE86F95F6859F3C096757411E14C1F")
    
public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.156 -0400", hash_original_method = "7E0833DD1A426904EF3C45DDA36E6694", hash_generated_method = "D56D8139E7C62ECB29B3E03E16B6CB76")
    
public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.164 -0400", hash_original_method = "14B72C598DD925B1B51825A68B91CBDF", hash_generated_method = "4E714340B10B715B4079ACF987816122")
    
public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.174 -0400", hash_original_method = "4F6E959F28714E9840E3146A8E6D0CA5", hash_generated_method = "D68E572E7BF4F4B9A301B2A904A337DF")
    
public static float getX(View view) {
        return view.getX();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.181 -0400", hash_original_method = "807876852B5001615355FDB3D80C5402", hash_generated_method = "9284E285F5890885300BD4A008730FC4")
    
public static float getY(View view) {
        return view.getY();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.190 -0400", hash_original_method = "E548FB2F955D53B19B2F9324AAB1A397", hash_generated_method = "EBC0F726E095F21174754FD2D840A518")
    
public static float getRotation(View view) {
        return view.getRotation();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.198 -0400", hash_original_method = "1E9D2230C2CCA9502906CA42CF94E46E", hash_generated_method = "44CEFBF723A7311CF78E567B5112D52B")
    
public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.206 -0400", hash_original_method = "46398FA362D4AB81F508AD89DF6D6587", hash_generated_method = "FF27E50D0F265F2F223CD3B0A70A7A96")
    
public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.213 -0400", hash_original_method = "355D8B657ACBF2FFA09DECD5D15530F1", hash_generated_method = "6CACDAD3275423350731F2513E8328B5")
    
public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.221 -0400", hash_original_method = "895942BC36F368F42C14079420E27D2D", hash_generated_method = "ECEC29E6D9E53865E27A5386C5624590")
    
public static float getScaleY(View view) {
        return view.getScaleY();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.230 -0400", hash_original_method = "1739ECA4F6FE1222A72695C618906CE0", hash_generated_method = "E99BA0609FECB76C8D429C76015CDF61")
    
public static void setTranslationX(View view, float value) {
        view.setTranslationX(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.239 -0400", hash_original_method = "9D01F80DD2B3821F17BFD6A9FA50046E", hash_generated_method = "98E91806481F1EE16AAE2F862BFCDAA4")
    
public static void setTranslationY(View view, float value) {
        view.setTranslationY(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.247 -0400", hash_original_method = "6EA12634E65B58E701F36EDB28A9E70B", hash_generated_method = "2E1A41529FC35020CC3D62A69471809A")
    
public static void setAlpha(View view, float value) {
        view.setAlpha(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.254 -0400", hash_original_method = "FEBC9FCF56399A8DB0491FF40BCD6B5B", hash_generated_method = "B663E368D92724217D4A3D3D8B861224")
    
public static void setX(View view, float value) {
        view.setX(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.262 -0400", hash_original_method = "C2B6A9601DF11D3BE7151F13AF4EF89A", hash_generated_method = "AFF6D0EA0CF5EDC205980A4E17455EDF")
    
public static void setY(View view, float value) {
        view.setY(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.270 -0400", hash_original_method = "E6AFB6769679AE318D4F8CEDF70B3926", hash_generated_method = "D9D7BC7E3B40150039E895DDFB90A8BF")
    
public static void setRotation(View view, float value) {
        view.setRotation(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.278 -0400", hash_original_method = "B0E0601B86C2278B7AB4DE14FF379019", hash_generated_method = "FF7B0C4C7D700C947DBD24E798CA6DBA")
    
public static void setRotationX(View view, float value) {
        view.setRotationX(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.287 -0400", hash_original_method = "F80DCB2140CF6518C29F7A8D2E23ADC7", hash_generated_method = "6DD536ADEEA5F6BA63729715A91702C0")
    
public static void setRotationY(View view, float value) {
        view.setRotationY(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.295 -0400", hash_original_method = "EFA92EF69CBAAA7CC86D435E94C33453", hash_generated_method = "8B96597CC5C0A02E3A919D5FD6E0BBB8")
    
public static void setScaleX(View view, float value) {
        view.setScaleX(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.303 -0400", hash_original_method = "8FF083B64F52FA9BF01AB85643561C00", hash_generated_method = "E9430CCDE3CD7DEB388167CB630E5CB2")
    
public static void setScaleY(View view, float value) {
        view.setScaleY(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.310 -0400", hash_original_method = "64251481BC7EE7B302C4FCE2B488C0D0", hash_generated_method = "9F2C8CFA7F11167694814CBB69DE8A3E")
    
public static void setPivotX(View view, float value) {
        view.setPivotX(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.318 -0400", hash_original_method = "7DF5FDBEBA9F18194C72CB9540461AA0", hash_generated_method = "8722CA02CE128E2318AC2F1FEA48D516")
    
public static void setPivotY(View view, float value) {
        view.setPivotY(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.325 -0400", hash_original_method = "57FCDFF6CBA1A85EA2BA7EF1CEDFDE81", hash_generated_method = "A902B0EE30A73FAFE7E6A28FA9E92FC9")
    
public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:03:46.332 -0400", hash_original_method = "D4ED988922B6630EDA864A11E5B48964", hash_generated_method = "8D66F483C18C2A471A3F70333A34051A")
    
public static float getPivotY(View view) {
        return view.getPivotY();
    }
}
