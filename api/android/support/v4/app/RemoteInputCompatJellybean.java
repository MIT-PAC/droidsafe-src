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
package android.support.v4.app;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
class RemoteInputCompatJellybean {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.165 -0400", hash_original_field = "7646DE075EE45321BD05F0B758431505", hash_generated_field = "23B2DEE59559E78990832B2E67F9F01E")

    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.167 -0400", hash_original_field = "64F015360A089EB0B6F38915099E0F95", hash_generated_field = "DCCCECA4270D13D45FAB8D70D5219B70")

    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.170 -0400", hash_original_field = "D7F332807006FC4EDD6CDA2FA7CE6578", hash_generated_field = "4F63693542FD8E4B18A116A97FEAB9FF")

    private static final String KEY_RESULT_KEY = "resultKey";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.173 -0400", hash_original_field = "44614D719C388C7B19E3040CB2F9F9D5", hash_generated_field = "17485C6A77570E86E5949E7F2A51455D")

    private static final String KEY_LABEL = "label";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.176 -0400", hash_original_field = "A4C69C523DE575EBEEDDA4760541A1AE", hash_generated_field = "B90FFF68AF189893730F0632CF2ED524")

    private static final String KEY_CHOICES = "choices";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.179 -0400", hash_original_field = "90473F45EE897AEBFEF8018E8B3B573A", hash_generated_field = "B4D6A7A0B2EDE73354A615EAA7635FE2")

    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.182 -0400", hash_original_field = "6E6A07D209C9E9928AC39D4A3091225D", hash_generated_field = "1F93A2120CCA045422063006ABD5F6B9")

    private static final String KEY_EXTRAS = "extras";
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.184 -0400", hash_original_method = "3D7176AE1D776EA92F93DF4F849B2902", hash_generated_method = "C60DF04A80FAA7D260BE7C48D0FF25CA")
    
static RemoteInputCompatBase.RemoteInput fromBundle(Bundle data,
            RemoteInputCompatBase.RemoteInput.Factory factory) {
        return factory.build(data.getString(KEY_RESULT_KEY),
                data.getCharSequence(KEY_LABEL),
                data.getCharSequenceArray(KEY_CHOICES),
                data.getBoolean(KEY_ALLOW_FREE_FORM_INPUT),
                data.getBundle(KEY_EXTRAS));
    }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.187 -0400", hash_original_method = "F439A271FD39B781C1F95A9E05EF39CA", hash_generated_method = "2398E4CDA525775E886A3EFACA39BF4F")
    
static Bundle toBundle(RemoteInputCompatBase.RemoteInput remoteInput) {
        Bundle data = new Bundle();
        data.putString(KEY_RESULT_KEY, remoteInput.getResultKey());
        data.putCharSequence(KEY_LABEL, remoteInput.getLabel());
        data.putCharSequenceArray(KEY_CHOICES, remoteInput.getChoices());
        data.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, remoteInput.getAllowFreeFormInput());
        data.putBundle(KEY_EXTRAS, remoteInput.getExtras());
        return data;
    }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.191 -0400", hash_original_method = "ECD4633176C7409A676170252E1FB9A1", hash_generated_method = "13DBEA8E35790D31A716CCFD4A591EFA")
    
static RemoteInputCompatBase.RemoteInput[] fromBundleArray(Bundle[] bundles,
            RemoteInputCompatBase.RemoteInput.Factory factory) {
        if (bundles == null) {
            return null;
        }
        RemoteInputCompatBase.RemoteInput[] remoteInputs = factory.newArray(bundles.length);
        for (int i = 0; i < bundles.length; i++) {
            remoteInputs[i] = fromBundle(bundles[i], factory);
        }
        return remoteInputs;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.195 -0400", hash_original_method = "C219B281B1A31315FE2CDCFC8D81AB83", hash_generated_method = "00891D5FFDEB714E926E7FD304D9E6DE")
    @DSSafe(DSCat.SAFE_LIST)
    
static Bundle[] toBundleArray(RemoteInputCompatBase.RemoteInput[] remoteInputs) {
        if (remoteInputs == null) {
            return null;
        }
        Bundle[] bundles = new Bundle[remoteInputs.length];
        for (int i = 0; i < remoteInputs.length; i++) {
            bundles[i] = toBundle(remoteInputs[i]);
        }
        return bundles;
    }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.198 -0400", hash_original_method = "27FD281319C870E7B783E9680ECDCBFE", hash_generated_method = "522F8D1B55C627023AB4835160AB0F1B")
    
static Bundle getResultsFromIntent(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription clipDescription = clipData.getDescription();
        if (!clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_INTENT)) {
            return null;
        }
        if (clipDescription.getLabel().equals(RESULTS_CLIP_LABEL)) {
            return clipData.getItemAt(0).getIntent().getExtras().getParcelable(EXTRA_RESULTS_DATA);
        }
        return null;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:07.202 -0400", hash_original_method = "9A0C0F689217DA160B385BD282ABD42F", hash_generated_method = "8859B0A46AD7ACF64A415FA860CDE9EC")
    @DSSafe(DSCat.SAFE_LIST)
static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] remoteInputs, Intent intent,
            Bundle results) {
        Bundle resultsBundle = new Bundle();
        for (RemoteInputCompatBase.RemoteInput remoteInput : remoteInputs) {
            Object result = results.get(remoteInput.getResultKey());
            if (result instanceof CharSequence) {
                resultsBundle.putCharSequence(remoteInput.getResultKey(), (CharSequence) result);
            }
        }
        Intent clipIntent = new Intent();
        clipIntent.putExtra(EXTRA_RESULTS_DATA, resultsBundle);
        intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, clipIntent));
    }
}
