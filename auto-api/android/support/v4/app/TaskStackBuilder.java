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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.606 -0400", hash_original_field = "A18F378A1546FFE00B0A7F55021D9E9D", hash_generated_field = "CFA58A7769A46541408E74BA3BD38195")

    private ArrayList<Intent> mIntents = new ArrayList<Intent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.606 -0400", hash_original_field = "EF160B1DFAE223EAE2323321493918B2", hash_generated_field = "F1E42593D394BEE701B8AB827039C816")

    private Context mSourceContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.607 -0400", hash_original_method = "D42A6E80ABDCC8C3AC78797ED9ABE957", hash_generated_method = "970E403029151A4E9DDC271056142D70")
    private  TaskStackBuilder(Context a) {
        mSourceContext = a;
        // ---------- Original Method ----------
        //mSourceContext = a;
    }

    
        public static TaskStackBuilder from(Context context) {
        return new TaskStackBuilder(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.611 -0400", hash_original_method = "511DF8C4B67F5D7A80704A12F82C5852", hash_generated_method = "641E4A0E107531D40150CC0EB6CF7B9E")
    public TaskStackBuilder addNextIntent(Intent nextIntent) {
        TaskStackBuilder varB4EAC82CA7396A68D541C85D26508E83_1741526503 = null; //Variable for return #1
        mIntents.add(nextIntent);
        varB4EAC82CA7396A68D541C85D26508E83_1741526503 = this;
        addTaint(nextIntent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1741526503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1741526503;
        // ---------- Original Method ----------
        //mIntents.add(nextIntent);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.628 -0400", hash_original_method = "64FAA2AF3C5B6BB5695479EAC432B8AF", hash_generated_method = "12A2C0AEB1C0D04D43CA1A6DEEB96579")
    public TaskStackBuilder addParentStack(Activity sourceActivity) {
        TaskStackBuilder varB4EAC82CA7396A68D541C85D26508E83_302638735 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_302638735 = this;
        addTaint(sourceActivity.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_302638735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_302638735;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.630 -0400", hash_original_method = "EC72BBC34AEA953E53BF47B67135BE6B", hash_generated_method = "C7F492FC63BE5BBF936CD6A1C81E21E6")
    public TaskStackBuilder addParentStack(Class<?> sourceActivityClass) {
        TaskStackBuilder varB4EAC82CA7396A68D541C85D26508E83_1369759157 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1369759157 = this;
        addTaint(sourceActivityClass.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1369759157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1369759157;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.642 -0400", hash_original_method = "660350E20C571F188D04D8C6E9BF83E3", hash_generated_method = "C6B2499BBDC0B17E50C377251BB78C2A")
    public int getIntentCount() {
        int varD5F2C54D95E41395AA6CA6DE538601B6_1730025524 = (mIntents.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516819241 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516819241;
        // ---------- Original Method ----------
        //return mIntents.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.644 -0400", hash_original_method = "59669D711935F600119486724ABE92DB", hash_generated_method = "40B260D07CBAE2FE5A6AABD63EA319AF")
    public Intent getIntent(int index) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2077909396 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2077909396 = mIntents.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2077909396.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2077909396;
        // ---------- Original Method ----------
        //return mIntents.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.645 -0400", hash_original_method = "B488DB0CFE3181CA27664FEB9997F729", hash_generated_method = "CE475A2AE3DF2DE325FF5CA93974F888")
    public Iterator<Intent> iterator() {
        Iterator<Intent> varB4EAC82CA7396A68D541C85D26508E83_887857410 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_887857410 = mIntents.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_887857410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_887857410;
        // ---------- Original Method ----------
        //return mIntents.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.662 -0400", hash_original_method = "D781CF9790C14CBB070409FBBD053F79", hash_generated_method = "A90B6AFA59A66B8A0BA06CAA2C341263")
    public void startActivities() {
        {
            boolean var5471783A2BC5469B9058DE6DEA884296_829273791 = (mIntents.isEmpty());
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
            boolean var7D1A156040C0080B6381D92D069ADAD8_1876726590 = (!ActivityCompat.startActivities((Activity) mSourceContext, intents));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.663 -0400", hash_original_method = "FE33C851237F987FCB25B803437FFC5D", hash_generated_method = "FCE4E32A19E0C0A5B693488F37811C84")
    public PendingIntent getPendingIntent(int requestCode, int flags) {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1957965377 = null; //Variable for return #1
        Intent[] intents;
        intents = mIntents.toArray(new Intent[mIntents.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1957965377 = IMPL.getPendingIntent(mSourceContext, intents, requestCode, flags);
        addTaint(requestCode);
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1957965377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1957965377;
        // ---------- Original Method ----------
        //Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        //return IMPL.getPendingIntent(mSourceContext, intents, requestCode, flags);
    }

    
    static class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.664 -0400", hash_original_method = "A4B09A1D14221C9A079C3523AB777622", hash_generated_method = "A4B09A1D14221C9A079C3523AB777622")
        public TaskStackBuilderImplBase ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.670 -0400", hash_original_method = "B2FA3A9517A56BFC6E40B46435E79D4C", hash_generated_method = "668C378FD2761FC1F997F51F399A5D77")
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            PendingIntent varB4EAC82CA7396A68D541C85D26508E83_459033947 = null; //Variable for return #1
            Intent topIntent;
            topIntent = intents[intents.length - 1];
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            varB4EAC82CA7396A68D541C85D26508E83_459033947 = PendingIntent.getActivity(context, requestCode, topIntent, flags);
            addTaint(context.getTaint());
            addTaint(intents[0].getTaint());
            addTaint(requestCode);
            addTaint(flags);
            varB4EAC82CA7396A68D541C85D26508E83_459033947.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_459033947;
            // ---------- Original Method ----------
            //Intent topIntent = intents[intents.length - 1];
            //topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //return PendingIntent.getActivity(context, requestCode, topIntent, flags);
        }

        
    }


    
    static class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.673 -0400", hash_original_method = "A254BA88AEF3ECF74695EB22288FD591", hash_generated_method = "A254BA88AEF3ECF74695EB22288FD591")
        public TaskStackBuilderImplHoneycomb ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.674 -0400", hash_original_method = "E15EFF6820AC92E3F921DC4152866184", hash_generated_method = "CE940BEE4FEDA3659714CC2764F5C892")
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            PendingIntent varB4EAC82CA7396A68D541C85D26508E83_670859875 = null; //Variable for return #1
            intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
            varB4EAC82CA7396A68D541C85D26508E83_670859875 = TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, requestCode,
                    intents, flags);
            addTaint(context.getTaint());
            addTaint(intents[0].getTaint());
            addTaint(requestCode);
            addTaint(flags);
            varB4EAC82CA7396A68D541C85D26508E83_670859875.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_670859875;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.692 -0400", hash_original_field = "56ADC477100606C28EFD00360944C008", hash_generated_field = "194362FA524A7B180E7A04EA8D36AADF")

    private static String TAG = "TaskStackBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:33.693 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "8F241A3DA7B9032F5DEC6E91DB25C831")

    private static TaskStackBuilderImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new TaskStackBuilderImplHoneycomb();
        } else {
            IMPL = new TaskStackBuilderImplBase();
        }
    }
    
}

