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

package android.support.v7.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Base class for activities that use the <a
 * href="{@docRoot}tools/extras/support-library.html">support library</a> action bar features.
 *
 * <p>You can add an {@link ActionBar} to your activity when running on API level 7 or higher
 * by extending this class for your activity and setting the activity theme to
 * {@link android.support.v7.appcompat.R.style#Theme_AppCompat Theme.AppCompat} or a similar theme.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 *
 * <p>For information about how to use the action bar, including how to add action items, navigation
 * modes and more, read the <a href="{@docRoot}guide/topics/ui/actionbar.html">Action
 * Bar</a> API guide.</p>
 * </div>
 */
public class ActionBarActivity extends FragmentActivity implements ActionBar.Callback,
        TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.366 -0400", hash_original_field = "374A9F8562285FB482679AC39E044DFD", hash_generated_field = "374A9F8562285FB482679AC39E044DFD")

    ActionBarActivityDelegate mImpl;

    /**
     * Support library version of {@link Activity#getActionBar}.
     *
     * <p>Retrieve a reference to this activity's ActionBar.
     *
     * @return The Activity's ActionBar, or null if it does not have one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.393 -0400", hash_original_method = "A7EEAB292CD7D39E94A27DFF134AA8C8", hash_generated_method = "2B2B7A1DE88BC371EAF8A5C058B3A3CE")
    
public ActionBar getSupportActionBar() {
        return mImpl.getSupportActionBar();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.401 -0400", hash_original_method = "A63D0DCB5A2DED6E06C62C21596D4A13", hash_generated_method = "5FDF959980D4E28EC10013A4B769B4C0")
    
@Override
    public MenuInflater getMenuInflater() {
        return mImpl.getMenuInflater();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.410 -0400", hash_original_method = "3BBF515DB23893EBC86A36061B416492", hash_generated_method = "EBFEA5FACC1536715F2CE879FD22327B")
    
@Override
    public void setContentView(int layoutResID) {
        mImpl.setContentView(layoutResID);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.417 -0400", hash_original_method = "4901B88EB9F59F9DB5585DE5CEA4FD0C", hash_generated_method = "D8E0919774CFE890AD0D0C211C26DEC6")
    
@Override
    public void setContentView(View view) {
        mImpl.setContentView(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.425 -0400", hash_original_method = "4D7A9816A3E5EC5F29B67247D57D5FA7", hash_generated_method = "45046D555E5040F8B6942B2901C8E7A6")
    
@Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        mImpl.setContentView(view, params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.431 -0400", hash_original_method = "0688A93BC2A40B448E3269FD3A0515C0", hash_generated_method = "228A62329F4323BFC40EA20DA817FF54")
    
@Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        mImpl.addContentView(view, params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.441 -0400", hash_original_method = "A8DA43CDD49BD7FF25CD847525AB0225", hash_generated_method = "0BA8EB8DF2DA5BD29302E04175525DC2")
    
@Override
    protected void onCreate(Bundle savedInstanceState) {
        mImpl = ActionBarActivityDelegate.createDelegate(this);
        super.onCreate(savedInstanceState);
        mImpl.onCreate(savedInstanceState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.447 -0400", hash_original_method = "85DCDA3F9CF63242611E1028630CCFF9", hash_generated_method = "F2192EFB2EB4F141517EB5B0A6239BBE")
    
@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mImpl.onConfigurationChanged(newConfig);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.455 -0400", hash_original_method = "7AD5756B4170E486F94FEF09D45C2C90", hash_generated_method = "4A729DF356311CE3CEE189EBB3BEEFB4")
    
@Override
    protected void onStop() {
        super.onStop();
        mImpl.onStop();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.463 -0400", hash_original_method = "199C0B437D139113CC2D1AB11EB85AEA", hash_generated_method = "ED363C54A6B4DC9EED320CF5D6AEB97F")
    
@Override
    protected void onPostResume() {
        super.onPostResume();
        mImpl.onPostResume();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.471 -0400", hash_original_method = "FBF41060A4407ADC1A907BCF46CAEA7E", hash_generated_method = "3AF4C91567D16E9E88528F23A58054C1")
    
@Override
    public View onCreatePanelView(int featureId) {
        if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            return mImpl.onCreatePanelView(featureId);
        } else {
            return super.onCreatePanelView(featureId);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.480 -0400", hash_original_method = "122BCE66CC764BDB8F60593B63935516", hash_generated_method = "37B77A88CB577420FDDE046E94D5AF5F")
    
@Override
    public final boolean onMenuItemSelected(int featureId, android.view.MenuItem item) {
        if (mImpl.onMenuItemSelected(featureId, item)) {
            return true;
        }

        final ActionBar ab = getSupportActionBar();
        if (item.getItemId() == DSUtils.FAKE_INT && ab != null &&
                (ab.getDisplayOptions() & ActionBar.DISPLAY_HOME_AS_UP) != 0) {
            return onSupportNavigateUp();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.487 -0400", hash_original_method = "00F3F382694E73791BD613BA78197DEF", hash_generated_method = "A026E05CF92585335D8B12D8DC309D47")
    
@Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        mImpl.onTitleChanged(title);
    }

    /**
     * Enable extended support library window features.
     * <p>
     * This is a convenience for calling
     * {@link android.view.Window#requestFeature getWindow().requestFeature()}.
     * </p>
     *
     * @param featureId The desired feature as defined in
     * {@link android.view.Window} or {@link WindowCompat}.
     * @return Returns true if the requested feature is supported and now enabled.
     *
     * @see android.app.Activity#requestWindowFeature
     * @see android.view.Window#requestFeature
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.497 -0400", hash_original_method = "BC10B79DEE55E1EC1C5D63448BA09B46", hash_generated_method = "9126449E09BB37B3CF9B2CFCDACC19C4")
    
public boolean supportRequestWindowFeature(int featureId) {
        return mImpl.supportRequestWindowFeature(featureId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.506 -0400", hash_original_method = "A14B8C8ED62F41B7F00E71FA28F98E50", hash_generated_method = "D32D03C7657C517E5530A501E97B6C87")
    
@Override
    public void supportInvalidateOptionsMenu() {
        // Only call up to super on ICS+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            super.supportInvalidateOptionsMenu();
        }
        mImpl.supportInvalidateOptionsMenu();
    }

    /**
     * Notifies the Activity that a support action mode has been started.
     * Activity subclasses overriding this method should call the superclass implementation.
     *
     * @param mode The new action mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.513 -0400", hash_original_method = "A04B79009CE228312B38627AAADD475C", hash_generated_method = "D2A32CDCE886B3B6C4A424B9451ACCA7")
    
public void onSupportActionModeStarted(ActionMode mode) {
    }

    /**
     * Notifies the activity that a support action mode has finished.
     * Activity subclasses overriding this method should call the superclass implementation.
     *
     * @param mode The action mode that just finished.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.521 -0400", hash_original_method = "D8B68FB20189DFD1BF1EB7309BFA69B0", hash_generated_method = "58611AAB3481BA235847201B2247A5D5")
    
public void onSupportActionModeFinished(ActionMode mode) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.528 -0400", hash_original_method = "2104B8732136095006A2B547BF9021C7", hash_generated_method = "DB0E316051844DECC242924B47D5732D")
    
public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return mImpl.startSupportActionMode(callback);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.537 -0400", hash_original_method = "2206032A619B7F05586D2E666AAE984E", hash_generated_method = "1CF9F5613E37387FAA1311C3353D1E08")
    
@Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return mImpl.onCreatePanelMenu(featureId, menu);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.543 -0400", hash_original_method = "B80CF4495F4ED5FCE8010C55E2B38EC6", hash_generated_method = "934E662622E87FD09DE5D200A93AC1ED")
    
@Override
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return mImpl.onPreparePanel(featureId, view, menu);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.548 -0400", hash_original_method = "06C525CBDEA9BF8398C6276535DF3B17", hash_generated_method = "8A61671CD7CF6F414E6DA928505191E8")
    
@Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return mImpl.onPrepareOptionsPanel(view, menu);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.553 -0400", hash_original_method = "77C3BCD8F446C1201EB8C854BCFEA35E", hash_generated_method = "77C3BCD8F446C1201EB8C854BCFEA35E")
    
void superSetContentView(int resId) {
        super.setContentView(resId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.558 -0400", hash_original_method = "3658A5197B85EC285F9D5D16A667E587", hash_generated_method = "3658A5197B85EC285F9D5D16A667E587")
    
void superSetContentView(View v) {
        super.setContentView(v);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.565 -0400", hash_original_method = "50DC2D989CB129E9712D4A54FCB3C3B7", hash_generated_method = "50DC2D989CB129E9712D4A54FCB3C3B7")
    
void superSetContentView(View v, ViewGroup.LayoutParams lp) {
        super.setContentView(v, lp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.571 -0400", hash_original_method = "2C7DAAEFF3D02EBA8470C1BDEF7069D1", hash_generated_method = "2C7DAAEFF3D02EBA8470C1BDEF7069D1")
    
void superAddContentView(View v, ViewGroup.LayoutParams lp) {
        super.addContentView(v, lp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.575 -0400", hash_original_method = "7AA13DE4A18FBB6F633A8BC885690E08", hash_generated_method = "7AA13DE4A18FBB6F633A8BC885690E08")
    
boolean superOnCreatePanelMenu(int featureId, android.view.Menu frameworkMenu) {
        return super.onCreatePanelMenu(featureId, frameworkMenu);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.581 -0400", hash_original_method = "77DD8DEC743C1393902BAB8A9BF30785", hash_generated_method = "77DD8DEC743C1393902BAB8A9BF30785")
    
boolean superOnPreparePanel(int featureId, View view, android.view.Menu menu) {
        return super.onPreparePanel(featureId, view, menu);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.586 -0400", hash_original_method = "195A97FCC9CA574AA72E4BAA813DC438", hash_generated_method = "195A97FCC9CA574AA72E4BAA813DC438")
    
boolean superOnPrepareOptionsPanel(View view, Menu menu) {
        return super.onPrepareOptionsPanel(view, menu);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.591 -0400", hash_original_method = "2D2DDC7C730DE0A179351287B77B801D", hash_generated_method = "2D2DDC7C730DE0A179351287B77B801D")
    
boolean superOnMenuItemSelected(int featureId, MenuItem menuItem) {
        return super.onMenuItemSelected(featureId, menuItem);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.596 -0400", hash_original_method = "FF1F69702D71E15272679CCE7F75189B", hash_generated_method = "167B94A438A8BEB7A7B3294DA84F8181")
    
@Override
    public void onBackPressed() {
        if (!mImpl.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /**
     * Support library version of {@link Activity#setProgressBarVisibility(boolean)}
     * <p>
     * Sets the visibility of the progress bar in the title.
     * <p>
     * In order for the progress bar to be shown, the feature must be requested
     * via {@link #supportRequestWindowFeature(int)}.
     *
     * @param visible Whether to show the progress bars in the title.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.601 -0400", hash_original_method = "73A22253B8569ADE4C97D2538F31D669", hash_generated_method = "DA39F0CB812F2B366E948DC9600398AD")
    
public void setSupportProgressBarVisibility(boolean visible) {
        mImpl.setSupportProgressBarVisibility(visible);
    }

    /**
     * Support library version of {@link Activity#setProgressBarIndeterminateVisibility(boolean)}
     * <p>
     * Sets the visibility of the indeterminate progress bar in the title.
     * <p>
     * In order for the progress bar to be shown, the feature must be requested
     * via {@link #supportRequestWindowFeature(int)}.
     *
     * @param visible Whether to show the progress bars in the title.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.605 -0400", hash_original_method = "0C42774B9174A4CF2D8BC3A70E4603CC", hash_generated_method = "483C367A2D9436D408E6995BD9A0C4AD")
    
public void setSupportProgressBarIndeterminateVisibility(boolean visible) {
        mImpl.setSupportProgressBarIndeterminateVisibility(visible);
    }

    /**
     * Support library version of {@link Activity#setProgressBarIndeterminate(boolean)}
     * <p>
     * Sets whether the horizontal progress bar in the title should be indeterminate (the
     * circular is always indeterminate).
     * <p>
     * In order for the progress bar to be shown, the feature must be requested
     * via {@link #supportRequestWindowFeature(int)}.
     *
     * @param indeterminate Whether the horizontal progress bar should be indeterminate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.610 -0400", hash_original_method = "344308409287DC749C73DEC24B7A113F", hash_generated_method = "A9B7403434BFA42B6D871EB21E282D3A")
    
public void setSupportProgressBarIndeterminate(boolean indeterminate) {
        mImpl.setSupportProgressBarIndeterminate(indeterminate);
    }

    /**
     * Support library version of {@link Activity#setProgress(int)}.
     * <p>
     * Sets the progress for the progress bars in the title.
     * <p>
     * In order for the progress bar to be shown, the feature must be requested
     * via {@link #supportRequestWindowFeature(int)}.
     *
     * @param progress The progress for the progress bar. Valid ranges are from
     *            0 to 10000 (both inclusive). If 10000 is given, the progress
     *            bar will be completely filled and will fade out.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.616 -0400", hash_original_method = "C5D9D1AEC625CA2B661F152F5320D4B4", hash_generated_method = "2E787ED52E58D8A7AEE217CB819D85D6")
    
public void setSupportProgress(int progress) {
        mImpl.setSupportProgress(progress);
    }

    /**
     * Support version of {@link #onCreateNavigateUpTaskStack(android.app.TaskStackBuilder)}.
     * This method will be called on all platform versions.
     *
     * Define the synthetic task stack that will be generated during Up navigation from
     * a different task.
     *
     * <p>The default implementation of this method adds the parent chain of this activity
     * as specified in the manifest to the supplied {@link TaskStackBuilder}. Applications
     * may choose to override this method to construct the desired task stack in a different
     * way.</p>
     *
     * <p>This method will be invoked by the default implementation of {@link #onNavigateUp()}
     * if {@link #shouldUpRecreateTask(Intent)} returns true when supplied with the intent
     * returned by {@link #getParentActivityIntent()}.</p>
     *
     * <p>Applications that wish to supply extra Intent parameters to the parent stack defined
     * by the manifest should override
     * {@link #onPrepareSupportNavigateUpTaskStack(TaskStackBuilder)}.</p>
     *
     * @param builder An empty TaskStackBuilder - the application should add intents representing
     *                the desired task stack
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.622 -0400", hash_original_method = "8C95C6CCFF61BB92C67C24D1C44B8BBF", hash_generated_method = "0D0A5EDBFB1CF25DE533D44AB1253B55")
    
public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder builder) {
        builder.addParentStack(this);
    }

    /**
     * Support version of {@link #onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder)}.
     * This method will be called on all platform versions.
     *
     * Prepare the synthetic task stack that will be generated during Up navigation
     * from a different task.
     *
     * <p>This method receives the {@link TaskStackBuilder} with the constructed series of
     * Intents as generated by {@link #onCreateSupportNavigateUpTaskStack(TaskStackBuilder)}.
     * If any extra data should be added to these intents before launching the new task,
     * the application should override this method and add that data here.</p>
     *
     * @param builder A TaskStackBuilder that has been populated with Intents by
     *                onCreateNavigateUpTaskStack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.628 -0400", hash_original_method = "8C51F939561320E9CFFD6852FBDF0A45", hash_generated_method = "15139F10D4202F74D7BF67F7B4CBA4B1")
    
public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder builder) {
    }

    /**
     * This method is called whenever the user chooses to navigate Up within your application's
     * activity hierarchy from the action bar.
     *
     * <p>If a parent was specified in the manifest for this activity or an activity-alias to it,
     * default Up navigation will be handled automatically. See
     * {@link #getSupportParentActivityIntent()} for how to specify the parent. If any activity
     * along the parent chain requires extra Intent arguments, the Activity subclass
     * should override the method {@link #onPrepareSupportNavigateUpTaskStack(TaskStackBuilder)}
     * to supply those arguments.</p>
     *
     * <p>See <a href="{@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html">Tasks and
     * Back Stack</a> from the developer guide and
     * <a href="{@docRoot}design/patterns/navigation.html">Navigation</a> from the design guide
     * for more information about navigating within your app.</p>
     *
     * <p>See the {@link TaskStackBuilder} class and the Activity methods
     * {@link #getSupportParentActivityIntent()}, {@link #supportShouldUpRecreateTask(Intent)}, and
     * {@link #supportNavigateUpTo(Intent)} for help implementing custom Up navigation.</p>
     *
     * @return true if Up navigation completed successfully and this Activity was finished,
     *         false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.634 -0400", hash_original_method = "EC83D49F04104AC8C7AA1871463F9588", hash_generated_method = "C2885D9B937E26BAD6C07877EAD8BE6E")
    
public boolean onSupportNavigateUp() {
        Intent upIntent = getSupportParentActivityIntent();

        if (upIntent != null) {
            if (supportShouldUpRecreateTask(upIntent)) {
                TaskStackBuilder b = TaskStackBuilder.create(this);
                onCreateSupportNavigateUpTaskStack(b);
                onPrepareSupportNavigateUpTaskStack(b);
                b.startActivities();

                try {
                    ActivityCompat.finishAffinity(this);
                } catch (IllegalStateException e) {
                    // This can only happen on 4.1+, when we don't have a parent or a result set.
                    // In that case we should just finish().
                    finish();
                }
            } else {
                // This activity is part of the application's task, so simply
                // navigate up to the hierarchical parent activity.
                supportNavigateUpTo(upIntent);
            }
            return true;
        }
        return false;
    }

    /**
     * Obtain an {@link Intent} that will launch an explicit target activity
     * specified by sourceActivity's {@link NavUtils#PARENT_ACTIVITY} &lt;meta-data&gt;
     * element in the application's manifest. If the device is running
     * Jellybean or newer, the android:parentActivityName attribute will be preferred
     * if it is present.
     *
     * @return a new Intent targeting the defined parent activity of sourceActivity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.640 -0400", hash_original_method = "C29CF7F5D04C484841AFBFE4194EBD60", hash_generated_method = "4B35CAECCA38ED679B7EE399B262BD4E")
    
public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    /**
     * Returns true if sourceActivity should recreate the task when navigating 'up'
     * by using targetIntent.
     *
     * <p>If this method returns false the app can trivially call
     * {@link #supportNavigateUpTo(Intent)} using the same parameters to correctly perform
     * up navigation. If this method returns false, the app should synthesize a new task stack
     * by using {@link TaskStackBuilder} or another similar mechanism to perform up navigation.</p>
     *
     * @param targetIntent An intent representing the target destination for up navigation
     * @return true if navigating up should recreate a new task stack, false if the same task
     *         should be used for the destination
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.645 -0400", hash_original_method = "EE8B48E28B0260D6F4321C1BDE9EC342", hash_generated_method = "A2158B89EDAAD542B662A3479F93FFA2")
    
public boolean supportShouldUpRecreateTask(Intent targetIntent) {
        return NavUtils.shouldUpRecreateTask(this, targetIntent);
    }

    /**
     * Navigate from sourceActivity to the activity specified by upIntent, finishing sourceActivity
     * in the process. upIntent will have the flag {@link Intent#FLAG_ACTIVITY_CLEAR_TOP} set
     * by this method, along with any others required for proper up navigation as outlined
     * in the Android Design Guide.
     *
     * <p>This method should be used when performing up navigation from within the same task
     * as the destination. If up navigation should cross tasks in some cases, see
     * {@link #supportShouldUpRecreateTask(Intent)}.</p>
     *
     * @param upIntent An intent representing the target destination for up navigation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.649 -0400", hash_original_method = "00086B55975687817AF2DD0048FA0334", hash_generated_method = "945B5303AE50F0926FACEDDB238DDD24")
    
public void supportNavigateUpTo(Intent upIntent) {
        NavUtils.navigateUpTo(this, upIntent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.654 -0400", hash_original_method = "5EA5EC62A087ADF79D8CA8D7C9446A6D", hash_generated_method = "7F2A0467DCFE1E73D9CAB4B35896D843")
    
@Override
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return mImpl.getDrawerToggleDelegate();
    }

    /**
     * Use {@link #onSupportContentChanged()} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.660 -0400", hash_original_method = "78CE9B486785A622BDAA4E18162BD6BB", hash_generated_method = "2336414F471D037E997F3213A642BC42")
    
public final void onContentChanged() {
        mImpl.onContentChanged();
    }

    /**
     * This hook is called whenever the content view of the screen changes.
     * @see android.app.Activity#onContentChanged()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 21:46:29.664 -0400", hash_original_method = "F56B7C8CA328FB1ED7ED79921B024825", hash_generated_method = "860C1816E42A5EB18B9FDE5948E4A5A8")
    
public void onSupportContentChanged() {
    }
}
