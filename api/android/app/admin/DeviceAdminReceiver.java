package android.app.admin;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;





public class DeviceAdminReceiver extends BroadcastReceiver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.610 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "B6CADA07BA29C079D23C0A8EC8039560")

    private DevicePolicyManager mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.610 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "5E0E13E7B1E652015B78D6466E133B40")

    private ComponentName mWho;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.610 -0400", hash_original_method = "D22D7983747EBDA5D1157714B0E9C778", hash_generated_method = "D22D7983747EBDA5D1157714B0E9C778")
    public DeviceAdminReceiver ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.611 -0400", hash_original_method = "43C291A37A92DFF8A999D859F17AC34F", hash_generated_method = "A6B7635C0B9323123B78C635BA3787EF")
    public DevicePolicyManager getManager(Context context) {
        if(mManager != null)        
        {
DevicePolicyManager var47199A017DD8E7B2591FF59F5B3F2F4D_1814979609 =             mManager;
            var47199A017DD8E7B2591FF59F5B3F2F4D_1814979609.addTaint(taint);
            return var47199A017DD8E7B2591FF59F5B3F2F4D_1814979609;
        } //End block
        mManager = (DevicePolicyManager)context.getSystemService(
                Context.DEVICE_POLICY_SERVICE);
DevicePolicyManager var47199A017DD8E7B2591FF59F5B3F2F4D_787745839 =         mManager;
        var47199A017DD8E7B2591FF59F5B3F2F4D_787745839.addTaint(taint);
        return var47199A017DD8E7B2591FF59F5B3F2F4D_787745839;
        // ---------- Original Method ----------
        //if (mManager != null) {
            //return mManager;
        //}
        //mManager = (DevicePolicyManager)context.getSystemService(
                //Context.DEVICE_POLICY_SERVICE);
        //return mManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.612 -0400", hash_original_method = "EB0C16120CE9EB47FE1BD44BF5A331E9", hash_generated_method = "F83490C0B75D2496DE80A87FC67CB6A4")
    public ComponentName getWho(Context context) {
        if(mWho != null)        
        {
ComponentName varB1E306C5C480708721962AF755EE9EB4_350742488 =             mWho;
            varB1E306C5C480708721962AF755EE9EB4_350742488.addTaint(taint);
            return varB1E306C5C480708721962AF755EE9EB4_350742488;
        } //End block
        mWho = new ComponentName(context, getClass());
ComponentName varB1E306C5C480708721962AF755EE9EB4_550322779 =         mWho;
        varB1E306C5C480708721962AF755EE9EB4_550322779.addTaint(taint);
        return varB1E306C5C480708721962AF755EE9EB4_550322779;
        // ---------- Original Method ----------
        //if (mWho != null) {
            //return mWho;
        //}
        //mWho = new ComponentName(context, getClass());
        //return mWho;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.612 -0400", hash_original_method = "B5AB3987ECA0392723BA81C8F9C984A4", hash_generated_method = "702C180364C39425B1BE3898623ED50F")
    public void onEnabled(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.613 -0400", hash_original_method = "B030DD992F331571B7C674C361AA5021", hash_generated_method = "C18234894982142537FCBB577A7E4E14")
    public CharSequence onDisableRequested(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(context.getTaint());
CharSequence var540C13E9E156B687226421B24F2DF178_953735808 =         null;
        var540C13E9E156B687226421B24F2DF178_953735808.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_953735808;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.613 -0400", hash_original_method = "3AE73024A5AE1632BF7BF3FF39ABC61B", hash_generated_method = "CB388A76D7739A15A014932B8A128C9C")
    public void onDisabled(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.614 -0400", hash_original_method = "5C5796A973779ABAC966AF8BF648505D", hash_generated_method = "186A548C593FEFEB09A397F6C2EB7585")
    public void onPasswordChanged(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.614 -0400", hash_original_method = "CF78327402B2C2123E9EC601B6F31A15", hash_generated_method = "09C393F37E8C3579BE3E927C02234CCB")
    public void onPasswordFailed(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.615 -0400", hash_original_method = "2AC7C3B5C72B40DDF68FA801C448C7B7", hash_generated_method = "320108A4444499864A3DA7A7C97DA01E")
    public void onPasswordSucceeded(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.616 -0400", hash_original_method = "412B859F7B36388642359BACAD05594E", hash_generated_method = "3F627A1982ACDAE3D4B220531982A2D4")
    public void onPasswordExpiring(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.617 -0400", hash_original_method = "2445129A1CDA7F03AFDA7F9C777F984A", hash_generated_method = "183A62B492D8611CE9726698B9B716DA")
    @Override
    public void onReceive(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(context.getTaint());
        String action = intent.getAction();
        if(ACTION_PASSWORD_CHANGED.equals(action))        
        {
            onPasswordChanged(context, intent);
        } //End block
        else
        if(ACTION_PASSWORD_FAILED.equals(action))        
        {
            onPasswordFailed(context, intent);
        } //End block
        else
        if(ACTION_PASSWORD_SUCCEEDED.equals(action))        
        {
            onPasswordSucceeded(context, intent);
        } //End block
        else
        if(ACTION_DEVICE_ADMIN_ENABLED.equals(action))        
        {
            onEnabled(context, intent);
        } //End block
        else
        if(ACTION_DEVICE_ADMIN_DISABLE_REQUESTED.equals(action))        
        {
            CharSequence res = onDisableRequested(context, intent);
            if(res != null)            
            {
                Bundle extras = getResultExtras(true);
                extras.putCharSequence(EXTRA_DISABLE_WARNING, res);
            } //End block
        } //End block
        else
        if(ACTION_DEVICE_ADMIN_DISABLED.equals(action))        
        {
            onDisabled(context, intent);
        } //End block
        else
        if(ACTION_PASSWORD_EXPIRING.equals(action))        
        {
            onPasswordExpiring(context, intent);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.618 -0400", hash_original_field = "10CCD4534E77DE13BA3397541526565A", hash_generated_field = "9C06F9BEB08AB3677C371FCD749129C1")

    private static String TAG = "DevicePolicy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.618 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.619 -0400", hash_original_field = "0BA5FD379AF676EDB1BC36E377A32BEC", hash_generated_field = "B5AC0D98DBC8A28F278728CC7291BFF0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_ADMIN_ENABLED
            = "android.app.action.DEVICE_ADMIN_ENABLED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.619 -0400", hash_original_field = "DCCD0A4EAD5088D2A51EDE4F72498376", hash_generated_field = "AE8BA4C83F3DCA866135A2D94C7D9275")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_ADMIN_DISABLE_REQUESTED
            = "android.app.action.DEVICE_ADMIN_DISABLE_REQUESTED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.619 -0400", hash_original_field = "32EBBF423D2D7520C5B68B2A7AF1056B", hash_generated_field = "6725382D3A51995AEB33A7BBB93F6A7A")

    public static final String EXTRA_DISABLE_WARNING = "android.app.extra.DISABLE_WARNING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.619 -0400", hash_original_field = "EE6315521DABAA3BF6BCBA8EB6300D6D", hash_generated_field = "796D083947AE3DDEE65A347753520A00")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_ADMIN_DISABLED
            = "android.app.action.DEVICE_ADMIN_DISABLED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.619 -0400", hash_original_field = "331E3F2E0AFF3215A8396C3448049D97", hash_generated_field = "69BFD08160D245EE4E448D4EAC1F3770")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PASSWORD_CHANGED
            = "android.app.action.ACTION_PASSWORD_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.619 -0400", hash_original_field = "1A1FCA5401688124517C4C2E44B5E0FC", hash_generated_field = "F20A03E232FF17BFED5A28783E7E1C3F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PASSWORD_FAILED
            = "android.app.action.ACTION_PASSWORD_FAILED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.619 -0400", hash_original_field = "E7E761021A3DBEE87D62961F098F5C08", hash_generated_field = "B2B5F20719F1C528A46B6DDA51EC2D98")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PASSWORD_SUCCEEDED
            = "android.app.action.ACTION_PASSWORD_SUCCEEDED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.620 -0400", hash_original_field = "0D38283E79FBA1EA020E2384782410EC", hash_generated_field = "7A9C30C27EE26D275A81ED05EADE42E0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PASSWORD_EXPIRING
            = "android.app.action.ACTION_PASSWORD_EXPIRING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.620 -0400", hash_original_field = "09E1C7620CBE7952A29DB18B4CF40A7C", hash_generated_field = "6F550D4F669BB60983EFB37FA6CB7E5A")

    public static final String DEVICE_ADMIN_META_DATA = "android.app.device_admin";
}

