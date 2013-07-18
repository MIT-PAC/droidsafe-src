package android.support.v4.app;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.support.v4.content.IntentCompat;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TaskStackBuilder implements Iterable<Intent> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.724 -0400", hash_original_field = "A18F378A1546FFE00B0A7F55021D9E9D", hash_generated_field = "FC01997BAF44874B9D67B78786DC6A66")

    private final ArrayList<Intent> mIntents = new ArrayList<Intent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.724 -0400", hash_original_field = "EF160B1DFAE223EAE2323321493918B2", hash_generated_field = "F1E42593D394BEE701B8AB827039C816")

    private Context mSourceContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.725 -0400", hash_original_method = "D42A6E80ABDCC8C3AC78797ED9ABE957", hash_generated_method = "970E403029151A4E9DDC271056142D70")
    private  TaskStackBuilder(Context a) {
        mSourceContext = a;
        // ---------- Original Method ----------
        //mSourceContext = a;
    }

    
    public static TaskStackBuilder from(Context context) {
        return new TaskStackBuilder(context);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.727 -0400", hash_original_method = "511DF8C4B67F5D7A80704A12F82C5852", hash_generated_method = "EA13594C539E5B4F8AF0AD65883B0556")
    public TaskStackBuilder addNextIntent(Intent nextIntent) {
        addTaint(nextIntent.getTaint());
        mIntents.add(nextIntent);
TaskStackBuilder var72A74007B2BE62B849F475C7BDA4658B_1520308198 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1520308198.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1520308198;
        // ---------- Original Method ----------
        //mIntents.add(nextIntent);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.728 -0400", hash_original_method = "64FAA2AF3C5B6BB5695479EAC432B8AF", hash_generated_method = "85E5A3DBB6A1B19A122A8E317A971683")
    public TaskStackBuilder addParentStack(Activity sourceActivity) {
        addTaint(sourceActivity.getTaint());
        final int insertAt = mIntents.size();
        Intent parent = NavUtils.getParentActivityIntent(sourceActivity);
        while
(parent != null)        
        {
            mIntents.add(insertAt, parent);
            try 
            {
                parent = NavUtils.getParentActivityIntent(sourceActivity, parent.getComponent());
            } //End block
            catch (NameNotFoundException e)
            {
                IllegalArgumentException varB5003C51895A632D49EB91E1ECEE1438_498364767 = new IllegalArgumentException(e);
                varB5003C51895A632D49EB91E1ECEE1438_498364767.addTaint(taint);
                throw varB5003C51895A632D49EB91E1ECEE1438_498364767;
            } //End block
        } //End block
TaskStackBuilder var72A74007B2BE62B849F475C7BDA4658B_421680371 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_421680371.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_421680371;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.730 -0400", hash_original_method = "EC72BBC34AEA953E53BF47B67135BE6B", hash_generated_method = "765902822F55B29B20530E85183E70E5")
    public TaskStackBuilder addParentStack(Class<?> sourceActivityClass) {
        addTaint(sourceActivityClass.getTaint());
        final int insertAt = mIntents.size();
        try 
        {
            Intent parent = NavUtils.getParentActivityIntent(mSourceContext, sourceActivityClass);
            while
(parent != null)            
            {
                mIntents.add(insertAt, parent);
                parent = NavUtils.getParentActivityIntent(mSourceContext, parent.getComponent());
            } //End block
        } //End block
        catch (NameNotFoundException e)
        {
            IllegalArgumentException varB5003C51895A632D49EB91E1ECEE1438_127352888 = new IllegalArgumentException(e);
            varB5003C51895A632D49EB91E1ECEE1438_127352888.addTaint(taint);
            throw varB5003C51895A632D49EB91E1ECEE1438_127352888;
        } //End block
TaskStackBuilder var72A74007B2BE62B849F475C7BDA4658B_585343183 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_585343183.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_585343183;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.731 -0400", hash_original_method = "660350E20C571F188D04D8C6E9BF83E3", hash_generated_method = "3A31320E1822EF11BB7813A98F000FC7")
    public int getIntentCount() {
        int varE259DDE2EAFE48E5D8266C32CA0C5CC8_596358320 = (mIntents.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_678521379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_678521379;
        // ---------- Original Method ----------
        //return mIntents.size();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.731 -0400", hash_original_method = "59669D711935F600119486724ABE92DB", hash_generated_method = "B48C72B7E993A1D7F58727C96D395AD5")
    public Intent getIntent(int index) {
        addTaint(index);
Intent varB61F6019BB592036C72F58753E1878A1_1286399808 =         mIntents.get(index);
        varB61F6019BB592036C72F58753E1878A1_1286399808.addTaint(taint);
        return varB61F6019BB592036C72F58753E1878A1_1286399808;
        // ---------- Original Method ----------
        //return mIntents.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.731 -0400", hash_original_method = "B488DB0CFE3181CA27664FEB9997F729", hash_generated_method = "D8F6EA01B1E20AFB63AD610896FA76DD")
    public Iterator<Intent> iterator() {
Iterator<Intent> varDCE3F2C6DE8648EB944C31405F1E2F2B_1022652251 =         mIntents.iterator();
        varDCE3F2C6DE8648EB944C31405F1E2F2B_1022652251.addTaint(taint);
        return varDCE3F2C6DE8648EB944C31405F1E2F2B_1022652251;
        // ---------- Original Method ----------
        //return mIntents.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.732 -0400", hash_original_method = "D781CF9790C14CBB070409FBBD053F79", hash_generated_method = "E0AB00BC9C782A766E1B36EAAF6FAD28")
    public void startActivities() {
        if(mIntents.isEmpty())        
        {
            IllegalStateException var025A81657BDAAD1A92F07EE376428737_995679621 = new IllegalStateException(
                    "No intents added to TaskStackBuilder; cannot startActivities");
            var025A81657BDAAD1A92F07EE376428737_995679621.addTaint(taint);
            throw var025A81657BDAAD1A92F07EE376428737_995679621;
        } //End block
        Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
        if(!ActivityCompat.startActivities((Activity) mSourceContext, intents))        
        {
            Intent topIntent = intents[intents.length - 1];
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mSourceContext.startActivity(topIntent);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.732 -0400", hash_original_method = "FE33C851237F987FCB25B803437FFC5D", hash_generated_method = "11B8D7501CB00877C66897B71417922E")
    public PendingIntent getPendingIntent(int requestCode, int flags) {
        addTaint(flags);
        addTaint(requestCode);
        Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
PendingIntent var8C66BCFAD345254529DBEC59C73D54DE_2056895776 =         IMPL.getPendingIntent(mSourceContext, intents, requestCode, flags);
        var8C66BCFAD345254529DBEC59C73D54DE_2056895776.addTaint(taint);
        return var8C66BCFAD345254529DBEC59C73D54DE_2056895776;
        // ---------- Original Method ----------
        //Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        //return IMPL.getPendingIntent(mSourceContext, intents, requestCode, flags);
    }

    
    static class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.732 -0400", hash_original_method = "A4B09A1D14221C9A079C3523AB777622", hash_generated_method = "A4B09A1D14221C9A079C3523AB777622")
        public TaskStackBuilderImplBase ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.733 -0400", hash_original_method = "B2FA3A9517A56BFC6E40B46435E79D4C", hash_generated_method = "912289609A198AE4D9AFB118C3F6B67A")
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            addTaint(flags);
            addTaint(requestCode);
            addTaint(intents[0].getTaint());
            addTaint(context.getTaint());
            Intent topIntent = intents[intents.length - 1];
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
PendingIntent var78B913836D3EA934C43638960253A32F_216802101 =             PendingIntent.getActivity(context, requestCode, topIntent, flags);
            var78B913836D3EA934C43638960253A32F_216802101.addTaint(taint);
            return var78B913836D3EA934C43638960253A32F_216802101;
            // ---------- Original Method ----------
            //Intent topIntent = intents[intents.length - 1];
            //topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //return PendingIntent.getActivity(context, requestCode, topIntent, flags);
        }

        
    }


    
    static class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.733 -0400", hash_original_method = "A254BA88AEF3ECF74695EB22288FD591", hash_generated_method = "A254BA88AEF3ECF74695EB22288FD591")
        public TaskStackBuilderImplHoneycomb ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.733 -0400", hash_original_method = "E15EFF6820AC92E3F921DC4152866184", hash_generated_method = "AFCD67DE1F8A7798824A12945404DB5C")
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            addTaint(flags);
            addTaint(requestCode);
            addTaint(intents[0].getTaint());
            addTaint(context.getTaint());
            intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
PendingIntent var2C930E320285304BFF0164FE1FA117C9_1183159211 =             TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, requestCode,
                    intents, flags);
            var2C930E320285304BFF0164FE1FA117C9_1183159211.addTaint(taint);
            return var2C930E320285304BFF0164FE1FA117C9_1183159211;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.734 -0400", hash_original_field = "56ADC477100606C28EFD00360944C008", hash_generated_field = "F3040376D9C30112F08DC96CCA3958FF")

    private static final String TAG = "TaskStackBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.734 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "8F241A3DA7B9032F5DEC6E91DB25C831")

    private static TaskStackBuilderImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new TaskStackBuilderImplHoneycomb();
        } else {
            IMPL = new TaskStackBuilderImplBase();
        }
    }
    
}

