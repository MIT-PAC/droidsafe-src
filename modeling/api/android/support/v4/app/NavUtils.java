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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.app;

// Droidsafe Imports
import android.support.v4.content.IntentCompat;
import android.util.Log;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class NavUtils {

    /**
     * Returns true if sourceActivity should recreate the task when navigating 'up'
     * by using targetIntent.
     *
     * <p>If this method returns false the app can trivially call
     * {@link #navigateUpTo(Activity, Intent)} using the same parameters to correctly perform
     * up navigation. If this method returns false, the app should synthesize a new task stack
     * by using {@link TaskStackBuilder} or another similar mechanism to perform up navigation.</p>
     *
     * @param sourceActivity The current activity from which the user is attempting to navigate up
     * @param targetIntent An intent representing the target destination for up navigation
     * @return true if navigating up should recreate a new task stack, false if the same task
     *         should be used for the destination
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.576 -0400", hash_original_method = "8694053549EB0977F153BD2950135821", hash_generated_method = "ACC35A127CCAD31FB685A26849224D6C")
        
public static boolean shouldUpRecreateTask(Activity sourceActivity, Intent targetIntent) {
        return IMPL.shouldUpRecreateTask(sourceActivity, targetIntent);
    }

    /**
     * Convenience method that is equivalent to calling
     * <code>{@link #navigateUpTo(Activity, Intent) navigateUpTo}(sourceActivity,
     * {@link #getParentActivityIntent(Activity) getParentActivityIntent} (sourceActivity))</code>.
     * sourceActivity will be finished by this call.
     *
     * <p><em>Note:</em> This method should only be used when sourceActivity and the corresponding
     * parent are within the same task. If up navigation should cross tasks in some cases, see
     * {@link #shouldUpRecreateTask(Activity, Intent)}.</p>
     *
     * @param sourceActivity The current activity from which the user is attempting to navigate up
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.418 -0500", hash_original_method = "CA98FAED7B046D519D09066602946AD2", hash_generated_method = "7C264CDA5F8697E7AA775B32DE714F84")
    
public static void navigateUpFromSameTask(Activity sourceActivity) {
        Intent upIntent = getParentActivityIntent(sourceActivity);

        if (upIntent == null) {
            throw new IllegalArgumentException("Activity " +
                    sourceActivity.getClass().getSimpleName() +
                    " does not have a parent activity name specified." +
                    " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " +
                    " element in your manifest?)");
        }

        navigateUpTo(sourceActivity, upIntent);
    }

    /**
     * Navigate from sourceActivity to the activity specified by upIntent, finishing sourceActivity
     * in the process. upIntent will have the flag {@link Intent#FLAG_ACTIVITY_CLEAR_TOP} set
     * by this method, along with any others required for proper up navigation as outlined
     * in the Android Design Guide.
     *
     * <p>This method should be used when performing up navigation from within the same task
     * as the destination. If up navigation should cross tasks in some cases, see
     * {@link #shouldUpRecreateTask(Activity, Intent)}.</p>
     *
     * @param sourceActivity The current activity from which the user is attempting to navigate up
     * @param upIntent An intent representing the target destination for up navigation
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.584 -0400", hash_original_method = "5F631F234D0DC1811CD50FBCF3EE9024", hash_generated_method = "16F3E4D2598A69C35DBC6EA447F013C1")
        
public static void navigateUpTo(Activity sourceActivity, Intent upIntent) {
        IMPL.navigateUpTo(sourceActivity, upIntent);
    }

    /**
     * Obtain an {@link Intent} that will launch an explicit target activity
     * specified by sourceActivity's {@link #PARENT_ACTIVITY} &lt;meta-data&gt;
     * element in the application's manifest. If the device is running
     * Jellybean or newer, the android:parentActivityName attribute will be preferred
     * if it is present.
     *
     * @param sourceActivity Activity to fetch a parent intent for
     * @return a new Intent targeting the defined parent activity of sourceActivity
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.587 -0400", hash_original_method = "06EB2AD9FD252CF1628A5B9CC5130567", hash_generated_method = "42BFFB3678B33D0F42F1152FA83CC384")
        
public static Intent getParentActivityIntent(Activity sourceActivity) {
        return IMPL.getParentActivityIntent(sourceActivity);
    }

    /**
     * Obtain an {@link Intent} that will launch an explicit target activity
     * specified by sourceActivityClass's {@link #PARENT_ACTIVITY} &lt;meta-data&gt;
     * element in the application's manifest.
     *
     * @param context Context for looking up the activity component for sourceActivityClass
     * @param sourceActivityClass {@link java.lang.Class} object for an Activity class
     * @return a new Intent targeting the defined parent activity of sourceActivity
     * @throws NameNotFoundException if the ComponentName for sourceActivityClass is invalid
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.593 -0400", hash_original_method = "363BB0EC3D6F8A0C5FB7B8E9948ED7D3", hash_generated_method = "81CC0CD64C399E3E407A18C06B57D902")
        
public static Intent getParentActivityIntent(Context context, Class<?> sourceActivityClass)
            throws NameNotFoundException {
        String parentActivity = getParentActivityName(context,
                new ComponentName(context, sourceActivityClass));
        if (parentActivity == null) return null;

        // If the parent itself has no parent, generate a main activity intent.
        final ComponentName target = new ComponentName(context, parentActivity);
        final String grandparent = getParentActivityName(context, target);
        final Intent parentIntent = grandparent == null
                ? IntentCompat.makeMainActivity(target)
                : new Intent().setComponent(target);
        return parentIntent;
    }

    /**
     * Obtain an {@link Intent} that will launch an explicit target activity
     * specified by sourceActivityClass's {@link #PARENT_ACTIVITY} &lt;meta-data&gt;
     * element in the application's manifest.
     *
     * @param context Context for looking up the activity component for the source activity
     * @param componentName ComponentName for the source Activity
     * @return a new Intent targeting the defined parent activity of sourceActivity
     * @throws NameNotFoundException if the ComponentName for sourceActivityClass is invalid
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.598 -0400", hash_original_method = "7F228843C0699E10640C9B9C0AEB579A", hash_generated_method = "CDD29196154ED136502FC109D21D91A1")
        
public static Intent getParentActivityIntent(Context context, ComponentName componentName)
            throws NameNotFoundException {
        String parentActivity = getParentActivityName(context, componentName);
        if (parentActivity == null) return null;

        // If the parent itself has no parent, generate a main activity intent.
        final ComponentName target = new ComponentName(
                componentName.getPackageName(), parentActivity);
        final String grandparent = getParentActivityName(context, target);
        final Intent parentIntent = grandparent == null
                ? IntentCompat.makeMainActivity(target)
                : new Intent().setComponent(target);
        return parentIntent;
    }

    /**
     * Return the fully qualified class name of sourceActivity's parent activity as specified by
     * a {@link #PARENT_ACTIVITY} &lt;meta-data&gt; element within the activity element in
     * the application's manifest.
     *
     * @param sourceActivity Activity to fetch a parent class name for
     * @return The fully qualified class name of sourceActivity's parent activity or null if
     *         it was not specified
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.431 -0500", hash_original_method = "922476F31426D85F4B2D25305741BC34", hash_generated_method = "4C6D380D72A75E89C92FCE8078B650A3")
    
public static String getParentActivityName(Activity sourceActivity) {
        try {
            return getParentActivityName(sourceActivity, sourceActivity.getComponentName());
        } catch (NameNotFoundException e) {
            // Component name of supplied activity does not exist...?
            throw new IllegalArgumentException(e);
        }
    }
    /**
     * Return the fully qualified class name of a source activity's parent activity as specified by
     * a {@link #PARENT_ACTIVITY} &lt;meta-data&gt; element within the activity element in
     * the application's manifest. The source activity is provided by componentName.
     *
     * @param context Context for looking up the activity component for the source activity
     * @param componentName ComponentName for the source Activity
     * @return The fully qualified class name of sourceActivity's parent activity or null if
     *         it was not specified
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.606 -0400", hash_original_method = "0ABDA37123907F4426EEC94BF151061E", hash_generated_method = "197AD77C6BF572390B3B757F52BB8422")
        
public static String getParentActivityName(Context context, ComponentName componentName)
            throws NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        ActivityInfo info = pm.getActivityInfo(componentName, PackageManager.GET_META_DATA);
        String parentActivity = IMPL.getParentActivityName(context, info);
        return parentActivity;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.410 -0500", hash_original_field = "2B3B53F66B0D832C3C83688F265ED44C", hash_generated_field = "E417B6C891271FCB16EE938B8A1D32B3")

    private static final String TAG = "NavUtils";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.413 -0500", hash_original_field = "323608CCBE6E8FE486946BE33B358388", hash_generated_field = "28AFCA35319A9218F8E9B29ABAC120B0")

    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";

    /** No instances! */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.436 -0500", hash_original_method = "E75D43BE6A1853BDB1330AA34521ED0F", hash_generated_method = "ABB99A4CD397AD199325D202C7A52973")
    
private NavUtils() {
    }

    static class NavUtilsImplBase implements NavUtilsImpl {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Intent getParentActivityIntent(Activity activity) {
            String parentName = NavUtils.getParentActivityName(activity);
            if (parentName == null) return null;

            // If the parent itself has no parent, generate a main activity intent.
            final ComponentName target = new ComponentName(activity, parentName);
            try {
                final String grandparent = NavUtils.getParentActivityName(activity, target);
                final Intent parentIntent = grandparent == null
                        ? IntentCompat.makeMainActivity(target)
                        : new Intent().setComponent(target);
                return parentIntent;
            } catch (NameNotFoundException e) {
                Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + parentName +
                        "' in manifest");
                return null;
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean shouldUpRecreateTask(Activity activity, Intent targetIntent) {
            String action = activity.getIntent().getAction();
            return action != null && !action.equals(Intent.ACTION_MAIN);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void navigateUpTo(Activity activity, Intent upIntent) {
            upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(upIntent);
            activity.finish();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String getParentActivityName(Context context, ActivityInfo info) {
            if (info.metaData == null) return null;
            String parentActivity = info.metaData.getString(PARENT_ACTIVITY);
            if (parentActivity == null) return null;
            if (parentActivity.charAt(0) == '.') {
                parentActivity = context.getPackageName() + parentActivity;
            }
            return parentActivity;
        }
    }

    static class NavUtilsImplJB extends NavUtilsImplBase {

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public Intent getParentActivityIntent(Activity activity) {
            // Prefer the "real" JB definition if available,
            // else fall back to the meta-data element.
            Intent result = NavUtilsJB.getParentActivityIntent(activity);
            if (result == null) {
                result = superGetParentActivityIntent(activity);
            }
            return result;
        }

        @DSSafe(DSCat.SAFE_LIST)
        Intent superGetParentActivityIntent(Activity activity) {
            return super.getParentActivityIntent(activity);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public boolean shouldUpRecreateTask(Activity activity, Intent targetIntent) {
            return NavUtilsJB.shouldUpRecreateTask(activity, targetIntent);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void navigateUpTo(Activity activity, Intent upIntent) {
            NavUtilsJB.navigateUpTo(activity, upIntent);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public String getParentActivityName(Context context, ActivityInfo info) {
            String result = NavUtilsJB.getParentActivityName(info);
            if (result == null) {
                result = super.getParentActivityName(context, info);
            }
            return result;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:00.571 -0400", hash_original_field = "C6811D4037382D1ADC65F4D3DF5E0CC6", hash_generated_field = "9E77B70C45E2AC10E994AD2C22A6D3C4")

    private static  NavUtilsImpl IMPL;

    interface NavUtilsImpl {
        Intent getParentActivityIntent(Activity activity);
        boolean shouldUpRecreateTask(Activity activity, Intent targetIntent);
        void navigateUpTo(Activity activity, Intent upIntent);
        String getParentActivityName(Context context, ActivityInfo info);
    }}

