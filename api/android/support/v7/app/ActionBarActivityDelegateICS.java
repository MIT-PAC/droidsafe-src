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
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.WindowCompat;
import android.support.v7.internal.view.ActionModeWrapper;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

class ActionBarActivityDelegateICS extends ActionBarActivityDelegate {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.595 -0400", hash_original_field = "3ACDC4FB192289AC415FA5263D322EC6", hash_generated_field = "3ACDC4FB192289AC415FA5263D322EC6")

    Menu mMenu;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.598 -0400", hash_original_method = "B8EB4832F82AF97B36C97A247B40338D", hash_generated_method = "B8EB4832F82AF97B36C97A247B40338D")
    
ActionBarActivityDelegateICS(ActionBarActivity activity) {
        super(activity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.602 -0400", hash_original_method = "286A515C090118EF60C363A1709E9674", hash_generated_method = "6FE61E3A05FBA72A01BC7F078AE1938A")
    
@Override
    public ActionBar createSupportActionBar() {
        return new ActionBarImplICS(mActivity, mActivity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.607 -0400", hash_original_method = "99F24E3A941434F159AA056A8629B590", hash_generated_method = "7355FECF8AC9767F659916DD25764F52")
    
@Override
    public void onCreate(Bundle savedInstanceState) {
        // Set framework uiOptions from the support metadata value
        if (UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW.equals(getUiOptionsFromMetadata())) {
            mActivity.getWindow().setUiOptions(ActivityInfo.UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW,
                    ActivityInfo.UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW);
        }

        super.onCreate(savedInstanceState);

        if (mHasActionBar) {
            // If action bar is requested by inheriting from the appcompat theme,
            // the system will not know about that. So explicitly request for an action bar.
            mActivity.requestWindowFeature(WindowCompat.FEATURE_ACTION_BAR);
        }
        if (mOverlayActionBar) {
            mActivity.requestWindowFeature(WindowCompat.FEATURE_ACTION_BAR_OVERLAY);
        }

        /*
         * This goofy move needs some explanation.
         *
         * The verifier on older platform versions has some interesting side effects if
         * a class defines a method that takes a parameter of a type that doesn't exist.
         * In this case, that type is android.view.ActionMode. Therefore, ActionBarActivity
         * cannot override the onActionModeStarted/Finished methods without causing nastiness
         * when it is loaded on older platform versions.
         *
         * Since these methods are actually part of the window callback and not intrinsic to
         * Activity itself, we can install a little shim with the window instead that knows
         * about the ActionMode class. Note that this means that any new methods added to
         * Window.Callback in the future won't get proxied without updating the support lib,
         * but we shouldn't be adding new methods to public interfaces that way anyway...right? ;)
         */
        final Window w = mActivity.getWindow();
        w.setCallback(createWindowCallbackWrapper(w.getCallback()));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.611 -0400", hash_original_method = "40B5306A081DB21B72AC8364E47B2D1B", hash_generated_method = "40B5306A081DB21B72AC8364E47B2D1B")
    
Window.Callback createWindowCallbackWrapper(Window.Callback cb) {
        return new WindowCallbackWrapper(cb);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.614 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "A5DAF8CC84BBA23E62F9E031FB166060")
    
@Override
    public void onConfigurationChanged(Configuration newConfig) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.618 -0400", hash_original_method = "EC815C6F910B0EC465C50C35C41B0F35", hash_generated_method = "A0BFAEC8D0477768DE0631A909C7C3E0")
    
@Override
    public void onStop() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.621 -0400", hash_original_method = "EB0D7A99A99F488EAEF4B095BCDEAF22", hash_generated_method = "03825C437AE274A7958686BD99D8D9BF")
    
@Override
    public void onPostResume() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.625 -0400", hash_original_method = "CDBC8FFDC27F814210A935CD2728D94C", hash_generated_method = "2FFB3DAA317A73CB41ADADD79B01C127")
    
@Override
    public void setContentView(View v) {
        mActivity.superSetContentView(v);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.629 -0400", hash_original_method = "D74398B960780AABB734623A6F04F9BD", hash_generated_method = "72AD7BB3BC350E9921DAC42104914F8A")
    
@Override
    public void setContentView(int resId) {
        mActivity.superSetContentView(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.633 -0400", hash_original_method = "0E94DC301495734E41712E291845F570", hash_generated_method = "2F2EAE782F7E4CDDCB94348A4D6748E3")
    
@Override
    public void setContentView(View v, ViewGroup.LayoutParams lp) {
        mActivity.superSetContentView(v, lp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.636 -0400", hash_original_method = "70F9CFD39D5FDFC4B1941D193F8C52C2", hash_generated_method = "B80EC076DA778F1804399DD531530612")
    
@Override
    public void addContentView(View v, ViewGroup.LayoutParams lp) {
        mActivity.superAddContentView(v, lp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.639 -0400", hash_original_method = "8928F41739970CE6FAE2B8AD4638CD7E", hash_generated_method = "38613205ADB29183882884D48DB43C6A")
    
@Override
    public void onContentChanged() {
        // Call straight through to the support version of the method
        mActivity.onSupportContentChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.643 -0400", hash_original_method = "C44ECE8FFAF08637716268EDA0845504", hash_generated_method = "7D7BF120E5EE0E1435FA0D99AA9B0429")
    
@Override
    public boolean supportRequestWindowFeature(int featureId) {
        return mActivity.requestWindowFeature(featureId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.647 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "34F61D8CF3041C556E278A1CAD1B2777")
    
@Override
    public View onCreatePanelView(int featureId) {
        // Do not create custom options menu on HC+
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.651 -0400", hash_original_method = "6E249AA5EE5285A1BC3214F3CFE65EBC", hash_generated_method = "83A6DB9DDF7ECF21711A479E2FDAF76A")
    
@Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_OPTIONS_PANEL || featureId == Window.FEATURE_ACTION_BAR) {
            if (mMenu == null) {
                mMenu = MenuWrapperFactory.createMenuWrapper(menu);
            }
            return mActivity.superOnCreatePanelMenu(featureId, mMenu);
        }
        return mActivity.superOnCreatePanelMenu(featureId, menu);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.656 -0400", hash_original_method = "F7DA79EA5E081001E2C22253A258DA4A", hash_generated_method = "FB3E38DFB71F210ED2168660A49A2264")
    
@Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId == Window.FEATURE_OPTIONS_PANEL || featureId == Window.FEATURE_ACTION_BAR) {
            return mActivity.superOnPreparePanel(featureId, view, mMenu);
        }
        return mActivity.superOnPreparePanel(featureId, view, menu);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.659 -0400", hash_original_method = "3D560D7D9A0A1F78AA4B3307FB162103", hash_generated_method = "D9AD02E1DEE878F2DAC702289C95F497")
    
@Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            item = MenuWrapperFactory.createMenuItemWrapper(item);
        }
        return mActivity.superOnMenuItemSelected(featureId, item);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.663 -0400", hash_original_method = "C2591D38F78EC7A8A40E5A569C26C3C0", hash_generated_method = "9291BDC74D796D454477EDF09446DB8F")
    
@Override
    public void onTitleChanged(CharSequence title) {
        // Handled by framework
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.669 -0400", hash_original_method = "22DA02CEEA59B34C89F47378B73A6896", hash_generated_method = "B809C0878D0D7D2AB20B802D02796A96")
    
@Override
    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }

        Context context = getActionBarThemedContext();

        ActionModeWrapper.CallbackWrapper wrappedCallback = new ActionModeWrapper.CallbackWrapper(
                context, callback);
        ActionModeWrapper wrappedMode = null;

        android.view.ActionMode frameworkMode = mActivity.startActionMode(wrappedCallback);

        if (frameworkMode != null) {
            wrappedMode = new ActionModeWrapper(context, frameworkMode);
            wrappedCallback.setLastStartedActionMode(wrappedMode);
        }

        return wrappedMode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.673 -0400", hash_original_method = "222DEF30A050BFDA5E7CA2309EED3342", hash_generated_method = "EC8E2F85C6640DF4C616BB9753FA51D4")
    
public void onActionModeStarted(android.view.ActionMode mode) {
        mActivity.onSupportActionModeStarted(
                new ActionModeWrapper(getActionBarThemedContext(), mode));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.676 -0400", hash_original_method = "1F4986202E1CB9B5539AF5D7CA414E48", hash_generated_method = "ACD88E90041B89273DFE47ED2C26848A")
    
@Override
    void setSupportProgressBarVisibility(boolean visible) {
        mActivity.setProgressBarVisibility(visible);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.679 -0400", hash_original_method = "EBD2CED696475AA5018D48E0F07293B0", hash_generated_method = "6F9A815671A7FE4CA01C654B89C5BE41")
    
@Override
    void setSupportProgressBarIndeterminateVisibility(boolean visible) {
        mActivity.setProgressBarIndeterminateVisibility(visible);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.683 -0400", hash_original_method = "E91D4F66AC49A0D534CDC88A2CA03D49", hash_generated_method = "0209E2364FCDAAD9DD342E2F99B7BBD3")
    
@Override
    void setSupportProgressBarIndeterminate(boolean indeterminate) {
        mActivity.setProgressBarIndeterminate(indeterminate);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.687 -0400", hash_original_method = "0BDC92B9C5B0022188BB00A3B7ADF1E9", hash_generated_method = "7079EB4A16A38E7421CE6908918A46CF")
    
@Override
    void setSupportProgress(int progress) {
        mActivity.setProgress(progress);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.691 -0400", hash_original_method = "8D0233697A5F9A9ABC51CD43DE3B88EA", hash_generated_method = "E803CC76DC1203D44D63C393C7C8F7C6")
    
public void onActionModeFinished(android.view.ActionMode mode) {
        mActivity.onSupportActionModeFinished(
                new ActionModeWrapper(getActionBarThemedContext(), mode));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.694 -0400", hash_original_method = "8F9824B900C16BEDFD09EE4677FEE99C", hash_generated_method = "55DD51006E2EA9475A0FFBB609EEAEFC")
    
@Override
    public void supportInvalidateOptionsMenu() {
        mMenu = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.697 -0400", hash_original_method = "BD74DA77A5630A4E352445A5DD77216F", hash_generated_method = "E4A35BE0F3B1C5259D4D2D249433CBE2")
    
@Override
    public boolean onBackPressed() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:31.702 -0400", hash_original_method = "7C567A242E5DBDD5E7B34272EE63669B", hash_generated_method = "2110A4A84F8FDAE64B3514C87B1C2351")
    
@Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        // Return null so that ActionBarDrawableToggle uses it's standard impl
        return null;
    }

    class WindowCallbackWrapper implements Window.Callback {
        final Window.Callback mWrapped;

        public WindowCallbackWrapper(Window.Callback wrapped) {
            mWrapped = wrapped;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            return mWrapped.dispatchKeyEvent(event);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean dispatchKeyShortcutEvent(KeyEvent event) {
            return mWrapped.dispatchKeyShortcutEvent(event);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            return mWrapped.dispatchTouchEvent(event);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean dispatchTrackballEvent(MotionEvent event) {
            return mWrapped.dispatchTrackballEvent(event);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean dispatchGenericMotionEvent(MotionEvent event) {
            return mWrapped.dispatchGenericMotionEvent(event);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            return mWrapped.dispatchPopulateAccessibilityEvent(event);
        }

        @Override
        public View onCreatePanelView(int featureId) {
            return mWrapped.onCreatePanelView(featureId);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onCreatePanelMenu(int featureId, Menu menu) {
            return mWrapped.onCreatePanelMenu(featureId, menu);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onPreparePanel(int featureId, View view, Menu menu) {
            return mWrapped.onPreparePanel(featureId, view, menu);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onMenuOpened(int featureId, Menu menu) {
            return mWrapped.onMenuOpened(featureId, menu);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onMenuItemSelected(int featureId, MenuItem item) {
            return mWrapped.onMenuItemSelected(featureId, item);
        }

        @Override
        public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) {
            mWrapped.onWindowAttributesChanged(attrs);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onContentChanged() {
            mWrapped.onContentChanged();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onWindowFocusChanged(boolean hasFocus) {
            mWrapped.onWindowFocusChanged(hasFocus);
        }

        @Override
        public void onAttachedToWindow() {
            mWrapped.onAttachedToWindow();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onDetachedFromWindow() {
            mWrapped.onDetachedFromWindow();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onPanelClosed(int featureId, Menu menu) {
            mWrapped.onPanelClosed(featureId, menu);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean onSearchRequested() {
            return mWrapped.onSearchRequested();
        }

        @Override
        public android.view.ActionMode onWindowStartingActionMode(
                android.view.ActionMode.Callback callback) {
            return mWrapped.onWindowStartingActionMode(callback);
        }

        /*
         * And here are the money methods, the reason why this wrapper exists:
         */

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onActionModeStarted(android.view.ActionMode mode) {
            mWrapped.onActionModeStarted(mode);
            ActionBarActivityDelegateICS.this.onActionModeStarted(mode);
        }

        @Override
        public void onActionModeFinished(android.view.ActionMode mode) {
            mWrapped.onActionModeFinished(mode);
            ActionBarActivityDelegateICS.this.onActionModeFinished(mode);
        }
    }
}
