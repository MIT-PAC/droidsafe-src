package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.237 -0400", hash_original_field = "A18F378A1546FFE00B0A7F55021D9E9D", hash_generated_field = "FC01997BAF44874B9D67B78786DC6A66")

    private final ArrayList<Intent> mIntents = new ArrayList<Intent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.237 -0400", hash_original_field = "EF160B1DFAE223EAE2323321493918B2", hash_generated_field = "F1E42593D394BEE701B8AB827039C816")

    private Context mSourceContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.238 -0400", hash_original_method = "D42A6E80ABDCC8C3AC78797ED9ABE957", hash_generated_method = "970E403029151A4E9DDC271056142D70")
    private  TaskStackBuilder(Context a) {
        mSourceContext = a;
        
        
    }

    
        public static TaskStackBuilder from(Context context) {
        return new TaskStackBuilder(context);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.238 -0400", hash_original_method = "511DF8C4B67F5D7A80704A12F82C5852", hash_generated_method = "0A33019EAC02EEE2BF8DD3B636188267")
    public TaskStackBuilder addNextIntent(Intent nextIntent) {
        addTaint(nextIntent.getTaint());
        mIntents.add(nextIntent);
TaskStackBuilder var72A74007B2BE62B849F475C7BDA4658B_386703269 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_386703269.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_386703269;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.239 -0400", hash_original_method = "64FAA2AF3C5B6BB5695479EAC432B8AF", hash_generated_method = "CD42B618F77D2E910CAE73F2467FA229")
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
            } 
            catch (NameNotFoundException e)
            {
                IllegalArgumentException varB5003C51895A632D49EB91E1ECEE1438_1903231510 = new IllegalArgumentException(e);
                varB5003C51895A632D49EB91E1ECEE1438_1903231510.addTaint(taint);
                throw varB5003C51895A632D49EB91E1ECEE1438_1903231510;
            } 
        } 
TaskStackBuilder var72A74007B2BE62B849F475C7BDA4658B_1636713457 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1636713457.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1636713457;
        
        
        
        
            
            
                
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.240 -0400", hash_original_method = "EC72BBC34AEA953E53BF47B67135BE6B", hash_generated_method = "04983BEE401406CEE93E52D6B1A6DB30")
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
            } 
        } 
        catch (NameNotFoundException e)
        {
            IllegalArgumentException varB5003C51895A632D49EB91E1ECEE1438_2071641690 = new IllegalArgumentException(e);
            varB5003C51895A632D49EB91E1ECEE1438_2071641690.addTaint(taint);
            throw varB5003C51895A632D49EB91E1ECEE1438_2071641690;
        } 
TaskStackBuilder var72A74007B2BE62B849F475C7BDA4658B_2097346849 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2097346849.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2097346849;
        
        
        
            
            
                
                
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.240 -0400", hash_original_method = "660350E20C571F188D04D8C6E9BF83E3", hash_generated_method = "4D924533A4715DFC48C9B3CC30602D3D")
    public int getIntentCount() {
        int varE259DDE2EAFE48E5D8266C32CA0C5CC8_1672789787 = (mIntents.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690023577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690023577;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.240 -0400", hash_original_method = "59669D711935F600119486724ABE92DB", hash_generated_method = "AC9A352967ABE216837BAB39930EAFCB")
    public Intent getIntent(int index) {
        addTaint(index);
Intent varB61F6019BB592036C72F58753E1878A1_820030719 =         mIntents.get(index);
        varB61F6019BB592036C72F58753E1878A1_820030719.addTaint(taint);
        return varB61F6019BB592036C72F58753E1878A1_820030719;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.241 -0400", hash_original_method = "B488DB0CFE3181CA27664FEB9997F729", hash_generated_method = "36EF8CE02D5942C2BBE658A4BBB53BE5")
    public Iterator<Intent> iterator() {
Iterator<Intent> varDCE3F2C6DE8648EB944C31405F1E2F2B_426790741 =         mIntents.iterator();
        varDCE3F2C6DE8648EB944C31405F1E2F2B_426790741.addTaint(taint);
        return varDCE3F2C6DE8648EB944C31405F1E2F2B_426790741;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.241 -0400", hash_original_method = "D781CF9790C14CBB070409FBBD053F79", hash_generated_method = "5BD134FC1F5183DCA43F6AADE27D8051")
    public void startActivities() {
    if(mIntents.isEmpty())        
        {
            IllegalStateException var025A81657BDAAD1A92F07EE376428737_729293231 = new IllegalStateException(
                    "No intents added to TaskStackBuilder; cannot startActivities");
            var025A81657BDAAD1A92F07EE376428737_729293231.addTaint(taint);
            throw var025A81657BDAAD1A92F07EE376428737_729293231;
        } 
        Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
        intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                IntentCompat.FLAG_ACTIVITY_CLEAR_TASK |
                IntentCompat.FLAG_ACTIVITY_TASK_ON_HOME);
    if(!ActivityCompat.startActivities((Activity) mSourceContext, intents))        
        {
            Intent topIntent = intents[intents.length - 1];
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mSourceContext.startActivity(topIntent);
        } 
        
        
            
                    
        
        
        
                
                
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.242 -0400", hash_original_method = "FE33C851237F987FCB25B803437FFC5D", hash_generated_method = "7E38ED40AF936F443D11C41287F3C78E")
    public PendingIntent getPendingIntent(int requestCode, int flags) {
        addTaint(flags);
        addTaint(requestCode);
        Intent[] intents = mIntents.toArray(new Intent[mIntents.size()]);
PendingIntent var8C66BCFAD345254529DBEC59C73D54DE_1198383151 =         IMPL.getPendingIntent(mSourceContext, intents, requestCode, flags);
        var8C66BCFAD345254529DBEC59C73D54DE_1198383151.addTaint(taint);
        return var8C66BCFAD345254529DBEC59C73D54DE_1198383151;
        
        
        
    }

    
    static class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.242 -0400", hash_original_method = "A4B09A1D14221C9A079C3523AB777622", hash_generated_method = "A4B09A1D14221C9A079C3523AB777622")
        public TaskStackBuilderImplBase ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.243 -0400", hash_original_method = "B2FA3A9517A56BFC6E40B46435E79D4C", hash_generated_method = "5602AAC7C11C8524B2301B2EF2A2089F")
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            addTaint(flags);
            addTaint(requestCode);
            addTaint(intents[0].getTaint());
            addTaint(context.getTaint());
            Intent topIntent = intents[intents.length - 1];
            topIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
PendingIntent var78B913836D3EA934C43638960253A32F_216252252 =             PendingIntent.getActivity(context, requestCode, topIntent, flags);
            var78B913836D3EA934C43638960253A32F_216252252.addTaint(taint);
            return var78B913836D3EA934C43638960253A32F_216252252;
            
            
            
            
        }

        
    }


    
    static class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.243 -0400", hash_original_method = "A254BA88AEF3ECF74695EB22288FD591", hash_generated_method = "A254BA88AEF3ECF74695EB22288FD591")
        public TaskStackBuilderImplHoneycomb ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.243 -0400", hash_original_method = "E15EFF6820AC92E3F921DC4152866184", hash_generated_method = "FD01EA760CCA15DFCEEB39210B4E66D4")
        public PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags) {
            addTaint(flags);
            addTaint(requestCode);
            addTaint(intents[0].getTaint());
            addTaint(context.getTaint());
            intents[0].addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
PendingIntent var2C930E320285304BFF0164FE1FA117C9_278187354 =             TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, requestCode,
                    intents, flags);
            var2C930E320285304BFF0164FE1FA117C9_278187354.addTaint(taint);
            return var2C930E320285304BFF0164FE1FA117C9_278187354;
            
            
                    
            
                    
        }

        
    }


    
    interface TaskStackBuilderImpl {
        PendingIntent getPendingIntent(Context context, Intent[] intents, int requestCode,
                int flags);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.244 -0400", hash_original_field = "56ADC477100606C28EFD00360944C008", hash_generated_field = "F3040376D9C30112F08DC96CCA3958FF")

    private static final String TAG = "TaskStackBuilder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.244 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "8F241A3DA7B9032F5DEC6E91DB25C831")

    private static TaskStackBuilderImpl IMPL;
    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new TaskStackBuilderImplHoneycomb();
        } else {
            IMPL = new TaskStackBuilderImplBase();
        }
    }
    
}

