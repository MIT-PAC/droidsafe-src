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

package android.support.v7.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.NavUtils;
import android.support.v7.appcompat.R;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

abstract class ActionBarActivityDelegate {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.105 -0400", hash_original_field = "CC43B68644DEB29C9B6A02230D069CFD", hash_generated_field = "057797C9DF9A968298A31F15E432B37F")

    static final String METADATA_UI_OPTIONS = "android.support.UI_OPTIONS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.110 -0400", hash_original_field = "B31C2191C17B25B7A389F6B9125341F0", hash_generated_field = "54C9AC4FEE717CA40836A785A88CA8AB")

    static final String UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = "splitActionBarWhenNarrow";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.114 -0400", hash_original_field = "6E9ACFCB418ED78D45F23F1E5981BC9F", hash_generated_field = "9D7312495AC4037BC342BFB082633E9B")

    private static final String TAG = "ActionBarActivityDelegate";

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.122 -0400", hash_original_method = "557A1CFA863EC827EFA0CB7C32429FB8", hash_generated_method = "D6F87323C902A9BAF0269055BF6C2B50")
    
static ActionBarActivityDelegate createDelegate(ActionBarActivity activity) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= Build.VERSION_CODES.JELLY_BEAN) {
            return new ActionBarActivityDelegateJB(activity);
        } else if (version >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return new ActionBarActivityDelegateICS(activity);
        } else if (version >= Build.VERSION_CODES.HONEYCOMB) {
            return new ActionBarActivityDelegateHC(activity);
        } else {
            return new ActionBarActivityDelegateBase(activity);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.126 -0400", hash_original_field = "BA6F7673D5979BBA8C21EC95A05E041C", hash_generated_field = "BA6F7673D5979BBA8C21EC95A05E041C")

     ActionBarActivity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.131 -0400", hash_original_field = "AFDC62FB2771CBC68D8F8907D45F2196", hash_generated_field = "F1560C03BA0B36CA5EB1F5530A3F9251")

    private ActionBar mActionBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.135 -0400", hash_original_field = "52EDF68A855A6A4E1C6D958055ACE764", hash_generated_field = "53E9FC1E44FE670BE318B42372895069")

    private MenuInflater mMenuInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.139 -0400", hash_original_field = "F7D691EC3D61EE41B254C1BE97FC2331", hash_generated_field = "F7D691EC3D61EE41B254C1BE97FC2331")

    boolean mHasActionBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.143 -0400", hash_original_field = "E02442B95456B1017DA58BC5F633476F", hash_generated_field = "E02442B95456B1017DA58BC5F633476F")

    boolean mOverlayActionBar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.149 -0400", hash_original_field = "9590C9425782B5BBA5AF16F97B4E5C82", hash_generated_field = "BC39A1F201607C260A8D6A5AE57A064D")

    private boolean mEnableDefaultActionBarUp;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.153 -0400", hash_original_method = "7733789C9647FDDDF3B72E2EADF62A80", hash_generated_method = "7733789C9647FDDDF3B72E2EADF62A80")
    
ActionBarActivityDelegate(ActionBarActivity activity) {
        mActivity = activity;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.157 -0400", hash_original_method = "A80652A2796E62D0E4A1A1DC6002E6CF", hash_generated_method = "C88F32B4FA12B08ED658A39506079961")
    
abstract ActionBar createSupportActionBar();

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.161 -0400", hash_original_method = "395740BCE466D955EBB6347E4B7CE955", hash_generated_method = "94E8B62F2888D9630929E2B08A2AA21A")
    
final ActionBar getSupportActionBar() {
        // The Action Bar should be lazily created as mHasActionBar or mOverlayActionBar
        // could change after onCreate
        if (mHasActionBar || mOverlayActionBar) {
            if (mActionBar == null) {
                mActionBar = createSupportActionBar();

                if (mEnableDefaultActionBarUp) {
                    mActionBar.setDisplayHomeAsUpEnabled(true);
                }
            }
        } else {
            // If we're not set to have a Action Bar, null it just in case it's been set
            mActionBar = null;
        }
        return mActionBar;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.174 -0400", hash_original_method = "B7EE79EDF58D840552D3BCD493A606B7", hash_generated_method = "B7EE79EDF58D840552D3BCD493A606B7")
    
MenuInflater getMenuInflater() {
        if (mMenuInflater == null) {
            ActionBar ab = getSupportActionBar();
            if (ab != null) {
                mMenuInflater = new SupportMenuInflater(ab.getThemedContext());
            } else {
                mMenuInflater = new SupportMenuInflater(mActivity);
            }
        }
        return mMenuInflater;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.179 -0400", hash_original_method = "C338EED4843E18E6431B1D07E591CF5E", hash_generated_method = "C338EED4843E18E6431B1D07E591CF5E")
    
void onCreate(Bundle savedInstanceState) {
        TypedArray a = mActivity.obtainStyledAttributes(R.styleable.ActionBarWindow);

        if (!a.hasValue(R.styleable.ActionBarWindow_windowActionBar)) {
            a.recycle();
            throw new IllegalStateException(
                    "You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }

        mHasActionBar = a.getBoolean(R.styleable.ActionBarWindow_windowActionBar, false);
        mOverlayActionBar = a.getBoolean(R.styleable.ActionBarWindow_windowActionBarOverlay, false);
        a.recycle();

        if (NavUtils.getParentActivityName(mActivity) != null) {
            if (mActionBar == null) {
                mEnableDefaultActionBarUp = true;
            } else {
                mActionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.185 -0400", hash_original_method = "1AE11CFD391BD9AE98B6BD4696F9FDCA", hash_generated_method = "C21D81655CB446CA0DFA32434A100D35")
    
abstract void onConfigurationChanged(Configuration newConfig);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.189 -0400", hash_original_method = "21B71D5BA1BEE107197F9887737DACA6", hash_generated_method = "82F0ED18C7E359CA4FA75F7FB351D417")
    
abstract void onStop();

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.193 -0400", hash_original_method = "4AB738682AB223FC603E9F383E2F45F4", hash_generated_method = "BA56F95957058BB0D4A14D94CC6FE01F")
    
abstract void onPostResume();

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.197 -0400", hash_original_method = "9D068CB06FDB425E4F9A616D3738C852", hash_generated_method = "2AB1E4AEDF24FA5AD5BDE91EC156C3F7")
    
abstract void setContentView(View v);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.201 -0400", hash_original_method = "08F42C03483B33ECDF72A14B87B2C79B", hash_generated_method = "7E6BED7EBE562A1AA90EF1616554E5DB")
    
abstract void setContentView(int resId);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.205 -0400", hash_original_method = "744AA4885682D152EA73290BCAA7A88C", hash_generated_method = "119A28DA4D2D0F3EDCCB3D203E0321C7")
    
abstract void setContentView(View v, ViewGroup.LayoutParams lp);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.209 -0400", hash_original_method = "95B8207C2AE38095B49C9E56373486A8", hash_generated_method = "7A76116B7A6E4B2D0A2CB1F7FEA0DE28")
    
abstract void addContentView(View v, ViewGroup.LayoutParams lp);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.213 -0400", hash_original_method = "8611C0DB5F20C79764220AFD3BF18C4F", hash_generated_method = "3028C7A90EB72EFD824ACD8A2BF3D8FB")
    
abstract void onTitleChanged(CharSequence title);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.218 -0400", hash_original_method = "C9777E8901E064DD358F164CD9C811C2", hash_generated_method = "4EF0C2393BF2F5927F46402FED9C05A7")
    
abstract void supportInvalidateOptionsMenu();

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.222 -0400", hash_original_method = "1D02A299A01FA48C8491012604D74CBB", hash_generated_method = "86DEB7FDD195194FE77294D72E2AABC9")
    
abstract boolean supportRequestWindowFeature(int featureId);

    // Methods used to create and respond to options menu
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.226 -0400", hash_original_method = "E0F5C594BDBBAEB4CE75B78F9A0675C1", hash_generated_method = "198FD732D23D3A9CE04660AE24BB5F20")
    
abstract View onCreatePanelView(int featureId);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.231 -0400", hash_original_method = "0154A4006EC830117B6D4EDC2244E9F5", hash_generated_method = "D866CD3F9C646C058A7F5E65E844D62E")
    
abstract boolean onPreparePanel(int featureId, View view, Menu menu);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.235 -0400", hash_original_method = "B442B592B925CE5FACA343F843963354", hash_generated_method = "C6EF201E03402F13905C2D4749DA4137")
    
boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (Build.VERSION.SDK_INT < DSUtils.FAKE_INT) {
            // Call straight through to onPrepareOptionsMenu, bypassing super.onPreparePanel().
            // This is because Activity.onPreparePanel() on <v4.1 calls menu.hasVisibleItems(),
            // which interferes with the initially invisible items.
            return mActivity.onPrepareOptionsMenu(menu);
        }
        return mActivity.superOnPrepareOptionsPanel(view, menu);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.240 -0400", hash_original_method = "50B90F641C38A9D8201DFFC3D86C4A3D", hash_generated_method = "9D0C8FE3A3A8C3024E7AB47FFEA506C5")
    
abstract boolean onCreatePanelMenu(int featureId, Menu menu);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.244 -0400", hash_original_method = "D7254E050AF02A8C14148748E2EEEE98", hash_generated_method = "1D529C192F2D20D9992ADEE7EB7A3F30")
    
abstract boolean onMenuItemSelected(int featureId, MenuItem item);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.248 -0400", hash_original_method = "1E1E13F9ECAE8824D931815B996117AF", hash_generated_method = "58FE3D077EF35B38BFE90A8B447C1557")
    
abstract boolean onBackPressed();

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.252 -0400", hash_original_method = "B9A2A37FA2AAB5C93F8F99CF4817D9EC", hash_generated_method = "C0F5CE8C17D761F60359A4036AF51F5B")
    
abstract ActionMode startSupportActionMode(ActionMode.Callback callback);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.255 -0400", hash_original_method = "3D498E75B2BA81E598A6C1AD643F5AFB", hash_generated_method = "55BDEBE8D21CC7717B5C30A50F579A19")
    
abstract void setSupportProgressBarVisibility(boolean visible);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.260 -0400", hash_original_method = "EB2FD58B5397BDDCAA8E20376B7F31C6", hash_generated_method = "EC92E37AEDB175B07EBE47461536E554")
    
abstract void setSupportProgressBarIndeterminateVisibility(boolean visible);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.265 -0400", hash_original_method = "DE111B945D96268B66BF3A83F2E826EB", hash_generated_method = "CBEB45D5B4E071BFA8107709FBE90FAE")
    
abstract void setSupportProgressBarIndeterminate(boolean indeterminate);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.269 -0400", hash_original_method = "CA7A4C0294C1D6BD4D1246AE343CD0B0", hash_generated_method = "6768EC8E69FEFB8937A7D844170DD5D0")
    
abstract void setSupportProgress(int progress);

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.273 -0400", hash_original_method = "7053B49903EBB31853671B958DFAF9A8", hash_generated_method = "40D1AA6C882A5EE7D5AD309EA32A1FE4")
    
abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.277 -0400", hash_original_method = "409BEE449416BF41DCD93CFC6E98C61D", hash_generated_method = "D6288C8173F51C73F4DAAB728CBC3E1C")
    
abstract void onContentChanged();

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.282 -0400", hash_original_method = "4CEE8F18A3294EAD66AFC7F182CCA4C8", hash_generated_method = "E4A2A14EA6885D9865AAAE9104D4574B")
    
protected final String getUiOptionsFromMetadata() {
        try {
            PackageManager pm = mActivity.getPackageManager();
            ActivityInfo info = pm.getActivityInfo(mActivity.getComponentName(),
                    PackageManager.GET_META_DATA);

            String uiOptions = null;
            if (info.metaData != null) {
                uiOptions = info.metaData.getString(METADATA_UI_OPTIONS);
            }
            return uiOptions;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "getUiOptionsFromMetadata: Activity '" + mActivity.getClass()
                    .getSimpleName() + "' not in manifest");
            return null;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:30.287 -0400", hash_original_method = "9B9BF36535D53CAA517704E6B9856350", hash_generated_method = "1AFDB2C6E778759671B74C6E1F29599D")
    
protected final Context getActionBarThemedContext() {
        Context context = mActivity;

        // If we have an action bar, initialize the menu with a context themed from it.
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            context = ab.getThemedContext();
        }
        return context;
    }
}
