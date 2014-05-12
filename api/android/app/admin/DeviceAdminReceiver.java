package android.app.admin;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DeviceAdminReceiver extends BroadcastReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.443 -0500", hash_original_field = "CC2DD932D152DB6D244545AF4CC9B722", hash_generated_field = "9C06F9BEB08AB3677C371FCD749129C1")

    private static String TAG = "DevicePolicy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.445 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.448 -0500", hash_original_field = "8A5FD53A40310A1889501972811C0055", hash_generated_field = "B5AC0D98DBC8A28F278728CC7291BFF0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_ADMIN_ENABLED
            = "android.app.action.DEVICE_ADMIN_ENABLED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.451 -0500", hash_original_field = "D04EBFDF2F432A7F4770D9D4A42A80C5", hash_generated_field = "AE8BA4C83F3DCA866135A2D94C7D9275")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_ADMIN_DISABLE_REQUESTED
            = "android.app.action.DEVICE_ADMIN_DISABLE_REQUESTED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.453 -0500", hash_original_field = "D1753D41B3C618700046DA25FE59094A", hash_generated_field = "6725382D3A51995AEB33A7BBB93F6A7A")

    public static final String EXTRA_DISABLE_WARNING = "android.app.extra.DISABLE_WARNING";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.456 -0500", hash_original_field = "C754F79D9E1BFEAA548839C19B1CF325", hash_generated_field = "796D083947AE3DDEE65A347753520A00")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_DEVICE_ADMIN_DISABLED
            = "android.app.action.DEVICE_ADMIN_DISABLED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.458 -0500", hash_original_field = "D3B0CFB071E910941DA454D345863899", hash_generated_field = "69BFD08160D245EE4E448D4EAC1F3770")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PASSWORD_CHANGED
            = "android.app.action.ACTION_PASSWORD_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.460 -0500", hash_original_field = "BB2DAF762804475A908844AC2FB7E2FB", hash_generated_field = "F20A03E232FF17BFED5A28783E7E1C3F")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PASSWORD_FAILED
            = "android.app.action.ACTION_PASSWORD_FAILED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.463 -0500", hash_original_field = "2EB8E9651A309E0FE9560B462C85239F", hash_generated_field = "B2B5F20719F1C528A46B6DDA51EC2D98")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PASSWORD_SUCCEEDED
            = "android.app.action.ACTION_PASSWORD_SUCCEEDED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.466 -0500", hash_original_field = "4AC7A1C4245036EAE36EA97CD871C518", hash_generated_field = "7A9C30C27EE26D275A81ED05EADE42E0")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_PASSWORD_EXPIRING
            = "android.app.action.ACTION_PASSWORD_EXPIRING";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.468 -0500", hash_original_field = "41E46103034F621CE9E50FE090CA422F", hash_generated_field = "6F550D4F669BB60983EFB37FA6CB7E5A")

    public static final String DEVICE_ADMIN_META_DATA = "android.app.device_admin";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.471 -0500", hash_original_field = "11AE5A38EFB8870FC22369090EAC76E6", hash_generated_field = "B6CADA07BA29C079D23C0A8EC8039560")
    
    private DevicePolicyManager mManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.473 -0500", hash_original_field = "5CA8B308CBEA910AC2B87AA086FB0517", hash_generated_field = "5E0E13E7B1E652015B78D6466E133B40")

    private ComponentName mWho;
    
    @DSComment("device administration")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.610 -0400", hash_original_method = "D22D7983747EBDA5D1157714B0E9C778", hash_generated_method = "D22D7983747EBDA5D1157714B0E9C778")
    public DeviceAdminReceiver ()
    {
        //Synthesized constructor
    }
    
    /**
     * Retrieve the DevicePolicyManager interface for this administrator to work
     * with the system.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.476 -0500", hash_original_method = "43C291A37A92DFF8A999D859F17AC34F", hash_generated_method = "46601141C2213B359BC865325D3DEED8")
    
public DevicePolicyManager getManager(Context context) {
        if (mManager != null) {
            return mManager;
        }
        mManager = (DevicePolicyManager)context.getSystemService(
                Context.DEVICE_POLICY_SERVICE);
        return mManager;
    }
    
    /**
     * Retrieve the ComponentName describing who this device administrator is, for
     * use in {@link DevicePolicyManager} APIs that require the administrator to
     * identify itself.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.478 -0500", hash_original_method = "EB0C16120CE9EB47FE1BD44BF5A331E9", hash_generated_method = "D627423E91C7D85DE1F630EE7D27FDAD")
    
public ComponentName getWho(Context context) {
        if (mWho != null) {
            return mWho;
        }
        mWho = new ComponentName(context, getClass());
        return mWho;
    }
    
    /**
     * Called after the administrator is first enabled, as a result of
     * receiving {@link #ACTION_DEVICE_ADMIN_ENABLED}.  At this point you
     * can use {@link DevicePolicyManager} to set your desired policies.
     * @param context The running context as per {@link #onReceive}.
     * @param intent The received intent as per {@link #onReceive}.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.480 -0500", hash_original_method = "B5AB3987ECA0392723BA81C8F9C984A4", hash_generated_method = "8B5EE3325DE226B338C2FD08481371E1")
    @DSVerified
public void onEnabled(Context context, Intent intent) {
    }
    
    /**
     * Called when the user has asked to disable the administrator, as a result of
     * receiving {@link #ACTION_DEVICE_ADMIN_DISABLE_REQUESTED}, giving you
     * a chance to present a warning message to them.  The message is returned
     * as the result; if null is returned (the default implementation), no
     * message will be displayed.
     * @param context The running context as per {@link #onReceive}.
     * @param intent The received intent as per {@link #onReceive}.
     * @return Return the warning message to display to the user before
     * being disabled; if null is returned, no message is displayed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.482 -0500", hash_original_method = "B030DD992F331571B7C674C361AA5021", hash_generated_method = "FFEC1869BCDFDAF4A3E4B0735713365F")
    @DSVerified
    @DSSpec(DSCat.INTENT_EXCHANGE)    
public CharSequence onDisableRequested(Context context, Intent intent) {
        return null;
    }
    
    /**
     * Called prior to the administrator being disabled, as a result of
     * receiving {@link #ACTION_DEVICE_ADMIN_DISABLED}.  Upon return, you
     * can no longer use the protected parts of the {@link DevicePolicyManager}
     * API.
     * @param context The running context as per {@link #onReceive}.
     * @param intent The received intent as per {@link #onReceive}.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.485 -0500", hash_original_method = "3AE73024A5AE1632BF7BF3FF39ABC61B", hash_generated_method = "F87BC4D3C872A59388EE472A15BF5243")
    @DSVerified
public void onDisabled(Context context, Intent intent) {
    }
    
    /**
     * Called after the user has changed their password, as a result of
     * receiving {@link #ACTION_PASSWORD_CHANGED}.  At this point you
     * can use {@link DevicePolicyManager#getCurrentFailedPasswordAttempts()
     * DevicePolicyManager.getCurrentFailedPasswordAttempts()}
     * to retrieve the active password characteristics.
     * @param context The running context as per {@link #onReceive}.
     * @param intent The received intent as per {@link #onReceive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.487 -0500", hash_original_method = "5C5796A973779ABAC966AF8BF648505D", hash_generated_method = "5EE87EFB7B0AC2C37DA8366DD70046E0")
    @DSVerified
    @DSSpec(DSCat.INTENT_EXCHANGE)
public void onPasswordChanged(Context context, Intent intent) {
    }
    
    /**
     * Called after the user has failed at entering their current password, as a result of
     * receiving {@link #ACTION_PASSWORD_FAILED}.  At this point you
     * can use {@link DevicePolicyManager} to retrieve the number of failed
     * password attempts.
     * @param context The running context as per {@link #onReceive}.
     * @param intent The received intent as per {@link #onReceive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.489 -0500", hash_original_method = "CF78327402B2C2123E9EC601B6F31A15", hash_generated_method = "7D6546C5FE125B5DF1F48600716B832B")
    @DSVerified
    @DSSpec(DSCat.INTENT_EXCHANGE)

public void onPasswordFailed(Context context, Intent intent) {
    }
    
    /**
     * Called after the user has succeeded at entering their current password,
     * as a result of receiving {@link #ACTION_PASSWORD_SUCCEEDED}.  This will
     * only be received the first time they succeed after having previously
     * failed.
     * @param context The running context as per {@link #onReceive}.
     * @param intent The received intent as per {@link #onReceive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.491 -0500", hash_original_method = "2AC7C3B5C72B40DDF68FA801C448C7B7", hash_generated_method = "9232896A96911725C9C6CE39E4E346BF")
    @DSVerified
    @DSSpec(DSCat.INTENT_EXCHANGE)
public void onPasswordSucceeded(Context context, Intent intent) {
    }

    /**
     * Called periodically when the password is about to expire or has expired.  It will typically
     * be called at these times: on device boot, once per day before the password expires,
     * and at the time when the password expires.
     *
     * <p>If the password is not updated by the user, this method will continue to be called
     * once per day until the password is changed or the device admin disables password expiration.
     *
     * <p>The admin will typically post a notification requesting the user to change their password
     * in response to this call. The actual password expiration time can be obtained by calling
     * {@link DevicePolicyManager#getPasswordExpiration(ComponentName) }
     *
     * <p>The admin should be sure to take down any notifications it posted in response to this call
     * when it receives {@link DeviceAdminReceiver#onPasswordChanged(Context, Intent) }.
     *
     * @param context The running context as per {@link #onReceive}.
     * @param intent The received intent as per {@link #onReceive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.493 -0500", hash_original_method = "412B859F7B36388642359BACAD05594E", hash_generated_method = "6160BA354A3AF505E3F25076E08ADC87")
    @DSVerified
    @DSSpec(DSCat.INTENT_EXCHANGE)
public void onPasswordExpiring(Context context, Intent intent) {
    }

    /**
     * Intercept standard device administrator broadcasts.  Implementations
     * should not override this method; it is better to implement the
     * convenience callbacks for each action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:50.496 -0500", hash_original_method = "2445129A1CDA7F03AFDA7F9C777F984A", hash_generated_method = "FF7DC1FEB70492C2E8AF52B85A93BCFA")
    @DSVerified
    @DSSafe(DSCat.IPC_CALLBACK)

@Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (ACTION_PASSWORD_CHANGED.equals(action)) {
            onPasswordChanged(context, intent);
        } else if (ACTION_PASSWORD_FAILED.equals(action)) {
            onPasswordFailed(context, intent);
        } else if (ACTION_PASSWORD_SUCCEEDED.equals(action)) {
            onPasswordSucceeded(context, intent);
        } else if (ACTION_DEVICE_ADMIN_ENABLED.equals(action)) {
            onEnabled(context, intent);
        } else if (ACTION_DEVICE_ADMIN_DISABLE_REQUESTED.equals(action)) {
            CharSequence res = onDisableRequested(context, intent);
            if (res != null) {
                Bundle extras = getResultExtras(true);
                extras.putCharSequence(EXTRA_DISABLE_WARNING, res);
            }
        } else if (ACTION_DEVICE_ADMIN_DISABLED.equals(action)) {
            onDisabled(context, intent);
        } else if (ACTION_PASSWORD_EXPIRING.equals(action)) {
            onPasswordExpiring(context, intent);
        }
    }
}

