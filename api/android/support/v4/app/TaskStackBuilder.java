package android.support.v4.app;

// Droidsafe Imports
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
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.010 -0500", hash_original_method = "5EAF1521C2FC3C641AB01A25ACC0D7FA", hash_generated_method = "36A24C7AA9DCA73D5B16B5D135D6E551")
    
public static TaskStackBuilder from(Context context) {
        return new TaskStackBuilder(context);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.984 -0500", hash_original_field = "9615892597CF6575F5AE338E32612C25", hash_generated_field = "F3040376D9C30112F08DC96CCA3958FF")

    private static final String TAG = "TaskStackBuilder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.998 -0500", hash_original_field = "DD3D72FB3D8C9697701A72C43B04CE74", hash_generated_field = "8F241A3DA7B9032F5DEC6E91DB25C831")


    private static  TaskStackBuilderImpl IMPL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.003 -0500", hash_original_field = "8770BD76093914B97223896100B825B8", hash_generated_field = "FC01997BAF44874B9D67B78786DC6A66")


    private final ArrayList<Intent> mIntents = new ArrayList<Intent>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.005 -0500", hash_original_field = "6422EBFFB4888C62FCF44F316AAE5124", hash_generated_field = "F1E42593D394BEE701B8AB827039C816")

    private  Context mSourceContext;

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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.015 -0500", hash_original_method = "64FAA2AF3C5B6BB5695479EAC432B8AF", hash_generated_method = "0D04145620BE8C8A034B4162ADCAA24C")
    
public TaskStackBuilder addParentStack(Activity sourceActivity) {
        final int insertAt = mIntents.size();
        Intent parent = NavUtils.getParentActivityIntent(sourceActivity);
        while (parent != null) {
            mIntents.add(insertAt, parent);
            try {
                parent = NavUtils.getParentActivityIntent(sourceActivity, parent.getComponent());
            } catch (NameNotFoundException e) {
                Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e);
            }
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.018 -0500", hash_original_method = "EC72BBC34AEA953E53BF47B67135BE6B", hash_generated_method = "3D9D64FA8CC90E2F6236386BAC7EF930")
    
public TaskStackBuilder addParentStack(Class<?> sourceActivityClass) {
        final int insertAt = mIntents.size();
        try {
            Intent parent = NavUtils.getParentActivityIntent(mSourceContext, sourceActivityClass);
            while (parent != null) {
                mIntents.add(insertAt, parent);
                parent = NavUtils.getParentActivityIntent(mSourceContext, parent.getComponent());
            }
        } catch (NameNotFoundException e) {
            Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
        return this;
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
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.022 -0500", hash_original_method = "59669D711935F600119486724ABE92DB", hash_generated_method = "93B676100E0B8CBB65C29ADC2D4AC91D")
    
public Intent getIntent(int index) {
        return mIntents.get(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.024 -0500", hash_original_method = "B488DB0CFE3181CA27664FEB9997F729", hash_generated_method = "5B2219A8B58FC839EDD4448194BA2428")
    
public Iterator<Intent> iterator() {
        return mIntents.iterator();
    }

    
    static class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        
        @DSModeled(DSC.SAFE)
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

        
    }


    
    static class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        
        @DSModeled(DSC.SAFE)
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

        
    }


    
    interface TaskStackBuilderImpl {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.027 -0500", hash_original_method = "D781CF9790C14CBB070409FBBD053F79", hash_generated_method = "39528DB0780F73BB5F6CE9BFC8F4A9CB")
    
public void startActivities() {
        if (mIntents.isEmpty()) {
            throw new IllegalStateException(
                    "No intents added to TaskStackBuilder; cannot startActivities");
        }

        Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
        if (!ActivityCompat.startActivities((Activity) mSourceContext, intents)) {
            Intent topIntent = intents[intents.length - 1];
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mSourceContext.startActivity(topIntent);
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
     * @return The obtained PendingIntent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:36.029 -0500", hash_original_method = "FE33C851237F987FCB25B803437FFC5D", hash_generated_method = "0A082087623AB090B12B8EB856C90EF0")
    
public PendingIntent getPendingIntent(int requestCode, int flags) {
        Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        return IMPL.getPendingIntent(mSourceContext, intents, requestCode, flags);
    }
    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new TaskStackBuilderImplHoneycomb();
        } else {
            IMPL = new TaskStackBuilderImplBase();
        }
    }
    
}

