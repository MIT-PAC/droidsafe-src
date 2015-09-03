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
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.support.v4.content.IntentCompat;

public class TaskStackBuilder implements Iterable<Intent> {

    /**
     * Return a new TaskStackBuilder for launching a fresh task stack consisting
     * of a series of activities.
     *
     * @param context The context that will launch the new task stack or generate a PendingIntent
     * @return A new TaskStackBuilder
     *
     * @deprecated use {@link #create(Context)} instead
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.698 -0400", hash_original_method = "515F760364B61AD1E1648A40C199B11F", hash_generated_method = "F3866294EB31AF549E7F0BC4A3FF12D1")
            
public static TaskStackBuilder from(Context context) {
        return create(context);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.984 -0500", hash_original_field = "9615892597CF6575F5AE338E32612C25", hash_generated_field = "F3040376D9C30112F08DC96CCA3958FF")

    private static final String TAG = "TaskStackBuilder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.998 -0500", hash_original_field = "DD3D72FB3D8C9697701A72C43B04CE74", hash_generated_field = "8F241A3DA7B9032F5DEC6E91DB25C831")

    private static  TaskStackBuilderImpl IMPL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.003 -0500", hash_original_field = "8770BD76093914B97223896100B825B8", hash_generated_field = "FC01997BAF44874B9D67B78786DC6A66")

    private final ArrayList<Intent> mIntents = new ArrayList<Intent>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.005 -0500", hash_original_field = "6422EBFFB4888C62FCF44F316AAE5124", hash_generated_field = "F1E42593D394BEE701B8AB827039C816")

    private  Context mSourceContext;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.008 -0500", hash_original_method = "D42A6E80ABDCC8C3AC78797ED9ABE957", hash_generated_method = "960C1FC90ECAD12565878A27908BE5B4")
    
private TaskStackBuilder(Context a) {
        mSourceContext = a;
    }

    /**
     * Add a new Intent to the task stack. The most recently added Intent will invoke
     * the Activity at the top of the final task stack.
     *
     * @param nextIntent Intent for the next Activity in the synthesized task stack
     * @return This TaskStackBuilder for method chaining
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.013 -0500", hash_original_method = "511DF8C4B67F5D7A80704A12F82C5852", hash_generated_method = "7EFB3181C895615DF3364C75B837554F")
    
public TaskStackBuilder addNextIntent(Intent nextIntent) {
        mIntents.add(nextIntent);
        return this;
    }

    /**
     * Add the activity parent chain as specified by manifest &lt;meta-data&gt; elements
     * to the task stack builder.
     *
     * @param sourceActivity All parents of this activity will be added
     * @return This TaskStackBuilder for method chaining
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.710 -0400", hash_original_method = "2EB34731B15849E8B9C5BBB17613EC66", hash_generated_method = "A19C38F6122A3B34AEC1EE91784747BB")
            
public TaskStackBuilder addParentStack(Activity sourceActivity) {
        Intent parent = null;
        if (sourceActivity instanceof SupportParentable) {
            parent = ((SupportParentable) sourceActivity).getSupportParentActivityIntent();
        }
        if (parent == null) {
            parent = NavUtils.getParentActivityIntent(sourceActivity);
        }

        if (parent != null) {
            // We have the actual parent intent, build the rest from static metadata
            // then add the direct parent intent to the end.
            ComponentName target = parent.getComponent();
            if (target == null) {
                target = parent.resolveActivity(mSourceContext.getPackageManager());
            }
            addParentStack(target);
            addNextIntent(parent);
        }
        return this;
    }

    /**
     * Add the activity parent chain as specified by manifest &lt;meta-data&gt; elements
     * to the task stack builder.
     *
     * @param sourceActivityClass All parents of this activity will be added
     * @return This TaskStackBuilder for method chaining
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.714 -0400", hash_original_method = "24789189026035DB86CDD288A0DC1914", hash_generated_method = "F3E77F34C82FE5453C29711624AE4893")
            
public TaskStackBuilder addParentStack(Class<?> sourceActivityClass) {
        return addParentStack(new ComponentName(mSourceContext, sourceActivityClass));
    }

    /**
     * @return the number of intents added so far.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.020 -0500", hash_original_method = "660350E20C571F188D04D8C6E9BF83E3", hash_generated_method = "59920B258A3BE41E352CF57B001DE9A4")
    
public int getIntentCount() {
        return mIntents.size();
    }

    /**
     * Get the intent at the specified index.
     * Useful if you need to modify the flags or extras of an intent that was previously added,
     * for example with {@link #addParentStack(Activity)}.
     *
     * @param index Index from 0-getIntentCount()
     * @return the intent at position index
     *
     * @deprecated Renamed to editIntentAt to better reflect intended usage
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.724 -0400", hash_original_method = "4915CBCFA1822F275709D18B038733CC", hash_generated_method = "35BB849E4D65B3243ABE16B8793E2809")
            
public Intent getIntent(int index) {
        return editIntentAt(index);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.024 -0500", hash_original_method = "B488DB0CFE3181CA27664FEB9997F729", hash_generated_method = "5B2219A8B58FC839EDD4448194BA2428")
    
public Iterator<Intent> iterator() {
        return mIntents.iterator();
    }
    
    static class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.732 -0400", hash_original_method = "A4B09A1D14221C9A079C3523AB777622", hash_generated_method = "A4B09A1D14221C9A079C3523AB777622")
        public TaskStackBuilderImplBase ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.989 -0500", hash_original_method = "B2FA3A9517A56BFC6E40B46435E79D4C", hash_generated_method = "874E90D0C9C2D02902A78244B2E8BEDB")
        
public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            Intent topIntent = intents[intents.length - 1];
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            return PendingIntent.getActivity(context, requestCode, topIntent, flags);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.655 -0400", hash_original_method = "0EC693EAD418FAD5DC7EF9CC9A04B4F6", hash_generated_method = "59C0A1B84391067A7AAE5AE105E72B52")
                
public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags, Bundle options) {
            Intent topIntent = new Intent(intents[intents.length - 1]);
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            return PendingIntent.getActivity(context, requestCode, topIntent, flags);
        }}
    
    static class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.733 -0400", hash_original_method = "A254BA88AEF3ECF74695EB22288FD591", hash_generated_method = "A254BA88AEF3ECF74695EB22288FD591")
        public TaskStackBuilderImplHoneycomb ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.994 -0500", hash_original_method = "E15EFF6820AC92E3F921DC4152866184", hash_generated_method = "68399BF5A5B57AB10155A7571AF4A28D")
        
public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
            return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, requestCode,
                    intents, flags);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.664 -0400", hash_original_method = "23456E97DF18402395D2229CC661A415", hash_generated_method = "4408097C3532810D90883C9691D88BC3")
                
public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags, Bundle options) {
            intents[0] = new Intent(intents[0]).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                    IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
            return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, requestCode,
                    intents, flags);
        }}
    
    interface TaskStackBuilderImpl {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags);
    }

    /**
     * Start the task stack constructed by this builder. The Context used to obtain
     * this builder must be an Activity.
     *
     * <p>On devices that do not support API level 11 or higher the topmost activity
     * will be started as a new task. On devices that do support API level 11 or higher
     * the new task stack will be created in its entirety.</p>
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.734 -0400", hash_original_method = "06A574342CCF39D1F49A10455C86E5DE", hash_generated_method = "127B19B1AD93D1C9A18860E3D6FC7B67")
            
public void startActivities() {
        startActivities(null);
    }

    @DSSafe(DSCat.SAFE_LIST)

    /**
     * Obtain a {@link PendingIntent} for launching the task constructed by this builder so far.
     *
     * @param requestCode Private request code for the sender
     * @param flags May be {@link PendingIntent#FLAG_ONE_SHOT},
     *              {@link PendingIntent#FLAG_NO_CREATE}, {@link PendingIntent#FLAG_CANCEL_CURRENT},
     *              {@link PendingIntent#FLAG_UPDATE_CURRENT}, or any of the flags supported by
     *              {@link Intent#fillIn(Intent, int)} to control which unspecified parts of the
     *              intent that can be supplied when the actual send happens.
     * @return The obtained PendingIntent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.743 -0400", hash_original_method = "8DDFBBB696073C87298196D6517F5951", hash_generated_method = "64D25301637CDAB658AB247F60A529AF")
            
public PendingIntent getPendingIntent(int requestCode, int flags) {
        return getPendingIntent(requestCode, flags, null);
    }
    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new TaskStackBuilderImplHoneycomb();
        } else {
            IMPL = new TaskStackBuilderImplBase();
        }
    }

    /**
     * Obtain a {@link PendingIntent} for launching the task constructed by this builder so far.
     *
     * @param requestCode Private request code for the sender
     * @param flags May be {@link PendingIntent#FLAG_ONE_SHOT},
     *              {@link PendingIntent#FLAG_NO_CREATE}, {@link PendingIntent#FLAG_CANCEL_CURRENT},
     *              {@link PendingIntent#FLAG_UPDATE_CURRENT}, or any of the flags supported by
     *              {@link Intent#fillIn(Intent, int)} to control which unspecified parts of the
     *              intent that can be supplied when the actual send happens.
     * @param options Additional options for how the Activity should be started.
     * See {@link android.content.Context#startActivity(Intent, Bundle)
     * @return The obtained PendingIntent
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.748 -0400", hash_original_method = "0E80A803E7C1AEC8F916FAEA93A5B1EC", hash_generated_method = "6333BBA6D29A2AFEC8E1885C605F593E")
            
public PendingIntent getPendingIntent(int requestCode, int flags, Bundle options) {
        if (mIntents.isEmpty()) {
            throw new IllegalStateException(
                    "No intents added to TaskStackBuilder; cannot getPendingIntent");
        }

        Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        intents[0] = new Intent(intents[0]).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
        // Appropriate flags will be added by the call below.
        return IMPL.getPendingIntent(mSourceContext, intents, requestCode, flags);
    }

    /**
     * Return an array containing the intents added to this builder. The intent at the
     * root of the task stack will appear as the first item in the array and the
     * intent at the top of the stack will appear as the last item.
     *
     * @return An array containing the intents added to this builder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.753 -0400", hash_original_method = "A911449C7A997F4E1A6CD5216F20B5C7", hash_generated_method = "212B19974A16373EE7A1D565CB1CEC22")
            
public Intent[] getIntents() {
        Intent[] intents = new Intent[mIntents.size()];
        if (intents.length == 0) return intents;

        intents[0] = new Intent(mIntents.get(0)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
        for (int i = 1; i < intents.length; i++) {
            intents[i] = new Intent(mIntents.get(i));
        }
        return intents;
    }

    /**
     * Return the intent at the specified index for modification.
     * Useful if you need to modify the flags or extras of an intent that was previously added,
     * for example with {@link #addParentStack(Activity)}.
     *
     * @param index Index from 0-getIntentCount()
     * @return the intent at position index
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.727 -0400", hash_original_method = "D8C1B8A201F5DF3584F78E1905328A4C", hash_generated_method = "11912DF99E5CC9DAF292DC6CDAE56C4A")
            
public Intent editIntentAt(int index) {
        return mIntents.get(index);
    }

    /**
     * Add a new Intent with the resolved chain of parents for the target activity to
     * the task stack.
     *
     * <p>This is equivalent to calling {@link #addParentStack(ComponentName) addParentStack}
     * with the resolved ComponentName of nextIntent (if it can be resolved), followed by
     * {@link #addNextIntent(Intent) addNextIntent} with nextIntent.</p>
     *
     * @param nextIntent Intent for the topmost Activity in the synthesized task stack.
     *                   Its chain of parents as specified in the manifest will be added.
     * @return This TaskStackBuilder for method chaining.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.706 -0400", hash_original_method = "3C8E9FEAF001E5DDE2932E299E52D93C", hash_generated_method = "9D63CDDC4DA8C01C491023E171095AEB")
            
public TaskStackBuilder addNextIntentWithParentStack(Intent nextIntent) {
        ComponentName target = nextIntent.getComponent();
        if (target == null) {
            target = nextIntent.resolveActivity(mSourceContext.getPackageManager());
        }
        if (target != null) {
            addParentStack(target);
        }
        addNextIntent(nextIntent);
        return this;
    }

    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    /**
     * Start the task stack constructed by this builder. The Context used to obtain
     * this builder must be an Activity.
     *
     * <p>On devices that do not support API level 11 or higher the topmost activity
     * will be started as a new task. On devices that do support API level 11 or higher
     * the new task stack will be created in its entirety.</p>
     *
     * @param options Additional options for how the Activity should be started.
     * See {@link android.content.Context#startActivity(Intent, Bundle)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.739 -0400", hash_original_method = "7165C9589E28314A1EBFB6EE9E7FEB29", hash_generated_method = "756BF9B1EC59A746D0EA0AF3325D4D2F")
            
public void startActivities(Bundle options) {
        if (mIntents.isEmpty()) {
            throw new IllegalStateException(
                    "No intents added to TaskStackBuilder; cannot startActivities");
        }

        Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        intents[0] = new Intent(intents[0]).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
        if (!ContextCompat.startActivities(mSourceContext, intents, options)) {
            Intent topIntent = new Intent(intents[intents.length - 1]);
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mSourceContext.startActivity(topIntent);
        }
    }

    static class TaskStackBuilderImplJellybean implements TaskStackBuilderImpl {
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags, Bundle options) {
            intents[0] = new Intent(intents[0]).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                    IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
            return TaskStackBuilderJellybean.getActivitiesPendingIntent(context, requestCode,
                    intents, flags, options);
        }

		@Override
		@DSComment("Abstract Method")
		@DSSpec(DSCat.ABSTRACT_METHOD)
		public
		PendingIntent getPendingIntent(Context context, Intent[] intents,
				int requestCode, int flags) {
			// TODO Auto-generated method stub
			PendingIntent pending = new PendingIntent(DSOnlyType.DONTCARE);
			pending.addTaint(intents[0].getAction().getTaintInt() +
                        intents[0].getType().getTaintInt() +
                        intents[0].getFlags() + 
                        intents[0].getDataString().getTaintInt() +
                        requestCode + flags);
			return pending;
		}
    }

    /**
     * Return a new TaskStackBuilder for launching a fresh task stack consisting
     * of a series of activities.
     *
     * @param context The context that will launch the new task stack or generate a PendingIntent
     * @return A new TaskStackBuilder
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.694 -0400", hash_original_method = "2281F09D881D66F33F75EC0F8221EA7A", hash_generated_method = "4A3521B80F8F9313E3AC7808BC76BB19")
            
public static TaskStackBuilder create(Context context) {
        return new TaskStackBuilder(context);
    }

    /**
     * Add the activity parent chain as specified by manifest &lt;meta-data&gt; elements
     * to the task stack builder.
     *
     * @param sourceActivityName Must specify an Activity component. All parents of
     *                           this activity will be added
     * @return This TaskStackBuilder for method chaining
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 10:59:49.717 -0400", hash_original_method = "D9F2A468A63D7BB696B6B7F7857CF5CC", hash_generated_method = "FA3ACB1680C4B44111D91EB7A7473414")
            
public TaskStackBuilder addParentStack(ComponentName sourceActivityName) {
        final int insertAt = mIntents.size();
        try {
            Intent parent = NavUtils.getParentActivityIntent(mSourceContext, sourceActivityName);
            while (parent != null) {
                mIntents.add(insertAt, parent);
                parent = NavUtils.getParentActivityIntent(mSourceContext, parent.getComponent());
            }
        } catch (NameNotFoundException e) {
            Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
        return this;
    }}

