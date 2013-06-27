package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.support.v4.content.IntentCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskStackBuilder implements Iterable<Intent> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.293 -0400", hash_original_field = "A18F378A1546FFE00B0A7F55021D9E9D", hash_generated_field = "CFA58A7769A46541408E74BA3BD38195")

    private ArrayList<Intent> mIntents = new ArrayList<Intent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.293 -0400", hash_original_field = "EF160B1DFAE223EAE2323321493918B2", hash_generated_field = "F1E42593D394BEE701B8AB827039C816")

    private Context mSourceContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.314 -0400", hash_original_method = "D42A6E80ABDCC8C3AC78797ED9ABE957", hash_generated_method = "970E403029151A4E9DDC271056142D70")
    private  TaskStackBuilder(Context a) {
        mSourceContext = a;
        // ---------- Original Method ----------
        //mSourceContext = a;
    }

    
        public static TaskStackBuilder from(Context context) {
        return new TaskStackBuilder(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.315 -0400", hash_original_method = "511DF8C4B67F5D7A80704A12F82C5852", hash_generated_method = "4BA2F86728C39BFF33ED1F79CDC461B4")
    public TaskStackBuilder addNextIntent(Intent nextIntent) {
        TaskStackBuilder varB4EAC82CA7396A68D541C85D26508E83_1985129917 = null; //Variable for return #1
        mIntents.add(nextIntent);
        varB4EAC82CA7396A68D541C85D26508E83_1985129917 = this;
        addTaint(nextIntent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1985129917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1985129917;
        // ---------- Original Method ----------
        //mIntents.add(nextIntent);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.317 -0400", hash_original_method = "64FAA2AF3C5B6BB5695479EAC432B8AF", hash_generated_method = "3A5E3164A92874DD6EED6D54572148FD")
    public TaskStackBuilder addParentStack(Activity sourceActivity) {
        TaskStackBuilder varB4EAC82CA7396A68D541C85D26508E83_316297730 = null; //Variable for return #1
        int insertAt;
        insertAt = mIntents.size();
        Intent parent;
        parent = NavUtils.getParentActivityIntent(sourceActivity);
        {
            mIntents.add(insertAt, parent);
            try 
            {
                parent = NavUtils.getParentActivityIntent(sourceActivity, parent.getComponent());
            } //End block
            catch (NameNotFoundException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(e);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_316297730 = this;
        addTaint(sourceActivity.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_316297730.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_316297730;
        // ---------- Original Method ----------
        //final int insertAt = mIntents.size();
        //Intent parent = NavUtils.getParentActivityIntent(sourceActivity);
        //while (parent != null) {
            //mIntents.add(insertAt, parent);
            //try {
                //parent = NavUtils.getParentActivityIntent(sourceActivity, parent.getComponent());
            //} catch (NameNotFoundException e) {
                //Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
                //throw new IllegalArgumentException(e);
            //}
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.335 -0400", hash_original_method = "EC72BBC34AEA953E53BF47B67135BE6B", hash_generated_method = "5B270A28A3D314246F4EFD46198A2CEB")
    public TaskStackBuilder addParentStack(Class<?> sourceActivityClass) {
        TaskStackBuilder varB4EAC82CA7396A68D541C85D26508E83_1216024105 = null; //Variable for return #1
        int insertAt;
        insertAt = mIntents.size();
        try 
        {
            Intent parent;
            parent = NavUtils.getParentActivityIntent(mSourceContext, sourceActivityClass);
            {
                mIntents.add(insertAt, parent);
                parent = NavUtils.getParentActivityIntent(mSourceContext, parent.getComponent());
            } //End block
        } //End block
        catch (NameNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1216024105 = this;
        addTaint(sourceActivityClass.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1216024105.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1216024105;
        // ---------- Original Method ----------
        //final int insertAt = mIntents.size();
        //try {
            //Intent parent = NavUtils.getParentActivityIntent(mSourceContext, sourceActivityClass);
            //while (parent != null) {
                //mIntents.add(insertAt, parent);
                //parent = NavUtils.getParentActivityIntent(mSourceContext, parent.getComponent());
            //}
        //} catch (NameNotFoundException e) {
            //Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
            //throw new IllegalArgumentException(e);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.336 -0400", hash_original_method = "660350E20C571F188D04D8C6E9BF83E3", hash_generated_method = "B16DC9CDEE3E66A865B2759F0226776C")
    public int getIntentCount() {
        int varD5F2C54D95E41395AA6CA6DE538601B6_1386439253 = (mIntents.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1932332991 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1932332991;
        // ---------- Original Method ----------
        //return mIntents.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.337 -0400", hash_original_method = "59669D711935F600119486724ABE92DB", hash_generated_method = "738DAECF10CC2ACC9A79CFEFDB4D72CE")
    public Intent getIntent(int index) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_273470243 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_273470243 = mIntents.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_273470243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_273470243;
        // ---------- Original Method ----------
        //return mIntents.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.344 -0400", hash_original_method = "B488DB0CFE3181CA27664FEB9997F729", hash_generated_method = "E1C33EBEC397E8248B6B13B5712469A1")
    public Iterator<Intent> iterator() {
        Iterator<Intent> varB4EAC82CA7396A68D541C85D26508E83_1343865783 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1343865783 = mIntents.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1343865783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1343865783;
        // ---------- Original Method ----------
        //return mIntents.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.359 -0400", hash_original_method = "D781CF9790C14CBB070409FBBD053F79", hash_generated_method = "DE8F2A823A1F0E8B43B757F45429CF37")
    public void startActivities() {
        {
            boolean var5471783A2BC5469B9058DE6DEA884296_1840148246 = (mIntents.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "No intents added to TaskStackBuilder; cannot startActivities");
            } //End block
        } //End collapsed parenthetic
        Intent[] intents;
        intents = mIntents.toArray(new Intent[mIntents.size()]);
        intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
        {
            boolean var7D1A156040C0080B6381D92D069ADAD8_1077747681 = (!ActivityCompat.startActivities((Activity) mSourceContext, intents));
            {
                Intent topIntent;
                topIntent = intents[intents.length - 1];
                topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mSourceContext.startActivity(topIntent);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mIntents.isEmpty()) {
            //throw new IllegalStateException(
                    //"No intents added to TaskStackBuilder; cannot startActivities");
        //}
        //Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        //intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                //IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                //IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
        //if (!ActivityCompat.startActivities((Activity) mSourceContext, intents)) {
            //Intent topIntent = intents[intents.length - 1];
            //topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //mSourceContext.startActivity(topIntent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.360 -0400", hash_original_method = "FE33C851237F987FCB25B803437FFC5D", hash_generated_method = "05F10ED4F8ACFB6D2BAC150C2A33E502")
    public PendingIntent getPendingIntent(int requestCode, int flags) {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_537703887 = null; //Variable for return #1
        Intent[] intents;
        intents = mIntents.toArray(new Intent[mIntents.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_537703887 = IMPL.getPendingIntent(mSourceContext, intents, requestCode, flags);
        addTaint(requestCode);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_537703887.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_537703887;
        // ---------- Original Method ----------
        //Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        //return IMPL.getPendingIntent(mSourceContext, intents, requestCode, flags);
    }

    
    static class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.362 -0400", hash_original_method = "A4B09A1D14221C9A079C3523AB777622", hash_generated_method = "A4B09A1D14221C9A079C3523AB777622")
        public TaskStackBuilderImplBase ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.375 -0400", hash_original_method = "B2FA3A9517A56BFC6E40B46435E79D4C", hash_generated_method = "64A89348975A149D19FD2CFE3B9AD6AE")
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1922843828 = null; //Variable for return #1
            Intent topIntent;
            topIntent = intents[intents.length - 1];
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            varB4EAC82CA7396A68D541C85D26508E83_1922843828 = PendingIntent.getActivity(context, requestCode, topIntent, flags);
            addTaint(context.getTaint());
            addTaint(intents[0].getTaint());
            addTaint(requestCode);
            addTaint(flags);
            varB4EAC82CA7396A68D541C85D26508E83_1922843828.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1922843828;
            // ---------- Original Method ----------
            //Intent topIntent = intents[intents.length - 1];
            //topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //return PendingIntent.getActivity(context, requestCode, topIntent, flags);
        }

        
    }


    
    static class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.375 -0400", hash_original_method = "A254BA88AEF3ECF74695EB22288FD591", hash_generated_method = "A254BA88AEF3ECF74695EB22288FD591")
        public TaskStackBuilderImplHoneycomb ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.376 -0400", hash_original_method = "E15EFF6820AC92E3F921DC4152866184", hash_generated_method = "F7B5E45720C7F3B0324F2C92BC0C987E")
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1745311957 = null; //Variable for return #1
            intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
            varB4EAC82CA7396A68D541C85D26508E83_1745311957 = TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, requestCode,
                    intents, flags);
            addTaint(context.getTaint());
            addTaint(intents[0].getTaint());
            addTaint(requestCode);
            addTaint(flags);
            varB4EAC82CA7396A68D541C85D26508E83_1745311957.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1745311957;
            // ---------- Original Method ----------
            //intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    //IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
            //return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, requestCode,
                    //intents, flags);
        }

        
    }


    
    interface TaskStackBuilderImpl {
        PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.376 -0400", hash_original_field = "56ADC477100606C28EFD00360944C008", hash_generated_field = "194362FA524A7B180E7A04EA8D36AADF")

    private static String TAG = "TaskStackBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:32.376 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "8F241A3DA7B9032F5DEC6E91DB25C831")

    private static TaskStackBuilderImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new TaskStackBuilderImplHoneycomb();
        } else {
            IMPL = new TaskStackBuilderImplBase();
        }
    }
    
}

