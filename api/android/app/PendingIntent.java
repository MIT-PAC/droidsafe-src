package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AndroidException;

public final class PendingIntent implements Parcelable {

    /**
     * Retrieve a PendingIntent that will start a new activity, like calling
     * {@link Context#startActivity(Intent) Context.startActivity(Intent)}.
     * Note that the activity will be started outside of the context of an
     * existing activity, so you must use the {@link Intent#FLAG_ACTIVITY_NEW_TASK
     * Intent.FLAG_ACTIVITY_NEW_TASK} launch flag in the Intent.
     *
     * @param context The Context in which this PendingIntent should start
     * the activity.
     * @param requestCode Private request code for the sender (currently
     * not used).
     * @param intent Intent of the activity to be launched.
     * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
     * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
     * or any of the flags as supported by
     * {@link Intent#fillIn Intent.fillIn()} to control which unspecified parts
     * of the intent that can be supplied when the actual send happens.
     *
     * @return Returns an existing or new PendingIntent matching the given
     * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
     * supplied.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.420 -0500", hash_original_method = "69D22A82CA352429278AB66C9EC4D269", hash_generated_method = "95BB43864FAB78706EBCD8B6F60963D4")
public static PendingIntent getActivity(Context context, int requestCode,
            Intent intent, int flags) {
        String packageName = context.getPackageName();
        String resolvedType = intent != null ? intent.resolveTypeIfNeeded(
                context.getContentResolver()) : null;
        try {
            intent.setAllowFds(false);
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                    IActivityManager.INTENT_SENDER_ACTIVITY, packageName,
                    null, null, requestCode, new Intent[] { intent },
                    resolvedType != null ? new String[] { resolvedType } : null, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }

    /**
     * Like {@link #getActivity(Context, int, Intent, int)}, but allows an
     * array of Intents to be supplied.  The first Intent in the array is
     * taken as the primary key for the PendingIntent, like the single Intent
     * given to {@link #getActivity(Context, int, Intent, int)}.  Upon sending
     * the resulting PendingIntent, all of the Intents are started in the same
     * way as they would be by passing them to {@link Context#startActivities(Intent[])}.
     *
     * <p class="note">
     * The <em>first</em> intent in the array will be started outside of the context of an
     * existing activity, so you must use the {@link Intent#FLAG_ACTIVITY_NEW_TASK
     * Intent.FLAG_ACTIVITY_NEW_TASK} launch flag in the Intent.  (Activities after
     * the first in the array are started in the context of the previous activity
     * in the array, so FLAG_ACTIVITY_NEW_TASK is not needed nor desired for them.)
     * </p>
     *
     * <p class="note">
     * The <em>last</em> intent in the array represents the key for the
     * PendingIntent.  In other words, it is the significant element for matching
     * (as done with the single intent given to {@link #getActivity(Context, int, Intent, int)},
     * its content will be the subject of replacement by
     * {@link #send(Context, int, Intent)} and {@link #FLAG_UPDATE_CURRENT}, etc.
     * This is because it is the most specific of the supplied intents, and the
     * UI the user actually sees when the intents are started.
     * </p>
     *
     * @param context The Context in which this PendingIntent should start
     * the activity.
     * @param requestCode Private request code for the sender (currently
     * not used).
     * @param intents Array of Intents of the activities to be launched.
     * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
     * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
     * or any of the flags as supported by
     * {@link Intent#fillIn Intent.fillIn()} to control which unspecified parts
     * of the intent that can be supplied when the actual send happens.
     *
     * @return Returns an existing or new PendingIntent matching the given
     * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
     * supplied.
     */
    @DSComment("IPC activity")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.423 -0500", hash_original_method = "54CC706903E6C235969DAB2CC8228B77", hash_generated_method = "BE46BD134F3641199D92CC24DA371D50")
public static PendingIntent getActivities(Context context, int requestCode,
            Intent[] intents, int flags) {
        String packageName = context.getPackageName();
        String[] resolvedTypes = new String[intents.length];
        for (int i=0; i<intents.length; i++) {
            intents[i].setAllowFds(false);
            resolvedTypes[i] = intents[i].resolveTypeIfNeeded(context.getContentResolver());
        }
        try {
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                    IActivityManager.INTENT_SENDER_ACTIVITY, packageName,
                    null, null, requestCode, intents, resolvedTypes, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }

    /**
     * Retrieve a PendingIntent that will perform a broadcast, like calling
     * {@link Context#sendBroadcast(Intent) Context.sendBroadcast()}.
     *
     * @param context The Context in which this PendingIntent should perform
     * the broadcast.
     * @param requestCode Private request code for the sender (currently
     * not used).
     * @param intent The Intent to be broadcast.
     * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
     * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
     * or any of the flags as supported by
     * {@link Intent#fillIn Intent.fillIn()} to control which unspecified parts
     * of the intent that can be supplied when the actual send happens.
     *
     * @return Returns an existing or new PendingIntent matching the given
     * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
     * supplied.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.426 -0500", hash_original_method = "7ECBF28DE75BC4F2B5047057DCC1075B", hash_generated_method = "41701B886985ED16AB2AB3DED8138C7A") 
    public static PendingIntent getBroadcast(Context context, int requestCode,
            Intent intent, int flags) {
        String packageName = context.getPackageName();
        String resolvedType = intent != null ? intent.resolveTypeIfNeeded(
                context.getContentResolver()) : null;
        try {
            intent.setAllowFds(false);
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                    IActivityManager.INTENT_SENDER_BROADCAST, packageName,
                    null, null, requestCode, new Intent[] { intent },
                    resolvedType != null ? new String[] { resolvedType } : null, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }

    /**
     * Retrieve a PendingIntent that will start a service, like calling
     * {@link Context#startService Context.startService()}.  The start
     * arguments given to the service will come from the extras of the Intent.
     *
     * @param context The Context in which this PendingIntent should start
     * the service.
     * @param requestCode Private request code for the sender (currently
     * not used).
     * @param intent An Intent describing the service to be started.
     * @param flags May be {@link #FLAG_ONE_SHOT}, {@link #FLAG_NO_CREATE},
     * {@link #FLAG_CANCEL_CURRENT}, {@link #FLAG_UPDATE_CURRENT},
     * or any of the flags as supported by
     * {@link Intent#fillIn Intent.fillIn()} to control which unspecified parts
     * of the intent that can be supplied when the actual send happens.
     *
     * @return Returns an existing or new PendingIntent matching the given
     * parameters.  May return null only if {@link #FLAG_NO_CREATE} has been
     * supplied.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.428 -0500", hash_original_method = "ABFD2E080CD8663BF6E26BE6876274AD", hash_generated_method = "D979B054426B7D588BDD63C2E93DE780")
public static PendingIntent getService(Context context, int requestCode,
            Intent intent, int flags) {
        String packageName = context.getPackageName();
        String resolvedType = intent != null ? intent.resolveTypeIfNeeded(
                context.getContentResolver()) : null;
        try {
            intent.setAllowFds(false);
            IIntentSender target =
                ActivityManagerNative.getDefault().getIntentSender(
                    IActivityManager.INTENT_SENDER_SERVICE, packageName,
                    null, null, requestCode, new Intent[] { intent },
                    resolvedType != null ? new String[] { resolvedType } : null, flags);
            return target != null ? new PendingIntent(target) : null;
        } catch (RemoteException e) {
        }
        return null;
    }

    /**
     * Convenience function for writing either a PendingIntent or null pointer to
     * a Parcel.  You must use this with {@link #readPendingIntentOrNullFromParcel}
     * for later reading it.
     *
     * @param sender The PendingIntent to write, or null.
     * @param out Where to write the PendingIntent.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.472 -0500", hash_original_method = "22B62015BE969BA5F8FF4277748534BD", hash_generated_method = "9C4F52F75D02CD3BE3C38AA5172500C5")
public static void writePendingIntentOrNullToParcel(PendingIntent sender,
            Parcel out) {
        out.writeStrongBinder(sender != null ? sender.mTarget.asBinder()
                : null);
    }

    /**
     * Convenience function for reading either a Messenger or null pointer from
     * a Parcel.  You must have previously written the Messenger with
     * {@link #writePendingIntentOrNullToParcel}.
     *
     * @param in The Parcel containing the written Messenger.
     *
     * @return Returns the Messenger read from the Parcel, or null if null had
     * been written.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.475 -0500", hash_original_method = "87F4B01ECCD12AE599F0E972E34C07E9", hash_generated_method = "8B33B39B0338061CA43B39E3CB933B33")
    
public static PendingIntent readPendingIntentOrNullFromParcel(Parcel in) {
        IBinder b = in.readStrongBinder();
        return b != null ? new PendingIntent(b) : null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.372 -0500", hash_original_field = "5371EE4B71F65A7A5C4121D8D37CCFBD", hash_generated_field = "5E771266274AD1856355F7F2644C40F0")

    public static final int FLAG_ONE_SHOT = 1<<30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.375 -0500", hash_original_field = "38E08F68905AA7F99318A60DBBA33EBF", hash_generated_field = "6ECB010344DA3BF2E28DD81C26A1E226")

    public static final int FLAG_NO_CREATE = 1<<29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.377 -0500", hash_original_field = "356472E72A9FA6D04BA36253AF11A6B2", hash_generated_field = "50E1B18733D9B9E6FAC056955439D1C7")

    public static final int FLAG_CANCEL_CURRENT = 1<<28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.379 -0500", hash_original_field = "D359E8EBDCAA973E644272D0383BEF56", hash_generated_field = "07161ED3853628F4CC6ED18374F570F7")

    public static final int FLAG_UPDATE_CURRENT = 1<<27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.396 -0400", hash_original_field = "68AC0C0209638127AE110D7481B6BF8A", hash_generated_field = "A03CAD3B827B3F879722CD11378FA14A")

    public static final Parcelable.Creator<PendingIntent> CREATOR
            = new Parcelable.Creator<PendingIntent>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.466 -0500", hash_original_method = "002B3842CB6C032442901D240F958E6F", hash_generated_method = "03E91BD6FC2A0D19BD7193F9F9DCD27E")
        
public PendingIntent createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new PendingIntent(target) : null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.468 -0500", hash_original_method = "54375C4346ED3346E211F06AD01508EB", hash_generated_method = "DD6FD45DF19224B4FC959EB116DD5B3E")
        
public PendingIntent[] newArray(int size) {
            return new PendingIntent[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.370 -0500", hash_original_field = "1D491A99AD04D3B16F7131B168BB0724", hash_generated_field = "E4E58773DF3C0920C12AA38B8FC403A5")

    private  IIntentSender mTarget;

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.478 -0500", hash_original_method = "3ACE5727953950B87626FD6380A23370", hash_generated_method = "3ACE5727953950B87626FD6380A23370")
    
PendingIntent(IIntentSender target) {
        mTarget = target;
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.480 -0500", hash_original_method = "53C8CE2812EC9BCF2C9E54818A5B8D0D", hash_generated_method = "53C8CE2812EC9BCF2C9E54818A5B8D0D")
    
PendingIntent(IBinder target) {
        mTarget = IIntentSender.Stub.asInterface(target);
    }

    /**
     * Retrieve a IntentSender object that wraps the existing sender of the PendingIntent
     *
     * @return Returns a IntentSender object that wraps the sender of PendingIntent
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.430 -0500", hash_original_method = "D9A9ECA0CF76712CB3C35292E7994C6B", hash_generated_method = "CC4CE09BF8F43AD6ADBEBE35CB9D4209")
    
public IntentSender getIntentSender() {
        return new IntentSender(mTarget);
    }

    /**
     * Cancel a currently active PendingIntent.  Only the original application
     * owning an PendingIntent can cancel it.
     */
    @DSComment("other application can control this intent")
    @DSSafe(DSCat.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.433 -0500", hash_original_method = "7E47A257CCD629A0D7E43A8ADD34CCE8", hash_generated_method = "920E8C7E84F34DAC3321073AE18A2854")
    
public void cancel() {
        try {
            ActivityManagerNative.getDefault().cancelIntentSender(mTarget);
        } catch (RemoteException e) {
        }
    }

    /**
     * Perform the operation associated with this PendingIntent.
     *
     * @see #send(Context, int, Intent, android.app.PendingIntent.OnFinished, Handler)
     *
     * @throws CanceledException Throws CanceledException if the PendingIntent
     * is no longer allowing more intents to be sent through it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.435 -0500", hash_original_method = "27B2516FC620720BFD785BFD1E716C8B", hash_generated_method = "46DA51288025E80A0E3EF352BC1B6A2C")
    
public void send() throws CanceledException {
        send(null, 0, null, null, null, null);
    }

    /**
     * Perform the operation associated with this PendingIntent.
     *
     * @param code Result code to supply back to the PendingIntent's target.
     *
     * @see #send(Context, int, Intent, android.app.PendingIntent.OnFinished, Handler)
     *
     * @throws CanceledException Throws CanceledException if the PendingIntent
     * is no longer allowing more intents to be sent through it.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.437 -0500", hash_original_method = "46F134C18EE926B408E7E9C21011E590", hash_generated_method = "CB8910838B2370E2E3A768D7BF8F1FFE")
    
public void send(int code) throws CanceledException {
        send(null, code, null, null, null, null);
    }

    /**
     * Perform the operation associated with this PendingIntent, allowing the
     * caller to specify information about the Intent to use.
     *
     * @param context The Context of the caller.
     * @param code Result code to supply back to the PendingIntent's target.
     * @param intent Additional Intent data.  See {@link Intent#fillIn
     * Intent.fillIn()} for information on how this is applied to the
     * original Intent.
     *
     * @see #send(Context, int, Intent, android.app.PendingIntent.OnFinished, Handler)
     *
     * @throws CanceledException Throws CanceledException if the PendingIntent
     * is no longer allowing more intents to be sent through it.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.439 -0500", hash_original_method = "43E1DC288109C397E82F23215BE8AF8A", hash_generated_method = "6A32A838B0D449ABCB7226D14EC8E406")
    
public void send(Context context, int code, Intent intent)
            throws CanceledException {
        send(context, code, intent, null, null, null);
    }

    /**
     * Perform the operation associated with this PendingIntent, allowing the
     * caller to be notified when the send has completed.
     *
     * @param code Result code to supply back to the PendingIntent's target.
     * @param onFinished The object to call back on when the send has
     * completed, or null for no callback.
     * @param handler Handler identifying the thread on which the callback
     * should happen.  If null, the callback will happen from the thread
     * pool of the process.
     *
     * @see #send(Context, int, Intent, android.app.PendingIntent.OnFinished, Handler)
     *
     * @throws CanceledException Throws CanceledException if the PendingIntent
     * is no longer allowing more intents to be sent through it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.442 -0500", hash_original_method = "10F50483791A59D1BF380CE4A4A7460C", hash_generated_method = "278DD9C1F502BADEE4F34865B60B6AF5")
    
public void send(int code, OnFinished onFinished, Handler handler)
            throws CanceledException {
        send(null, code, null, onFinished, handler, null);
    }

    /**
     * Perform the operation associated with this PendingIntent, allowing the
     * caller to specify information about the Intent to use and be notified
     * when the send has completed.
     *
     * <p>For the intent parameter, a PendingIntent
     * often has restrictions on which fields can be supplied here, based on
     * how the PendingIntent was retrieved in {@link #getActivity},
     * {@link #getBroadcast}, or {@link #getService}.
     *
     * @param context The Context of the caller.  This may be null if
     * <var>intent</var> is also null.
     * @param code Result code to supply back to the PendingIntent's target.
     * @param intent Additional Intent data.  See {@link Intent#fillIn
     * Intent.fillIn()} for information on how this is applied to the
     * original Intent.  Use null to not modify the original Intent.
     * @param onFinished The object to call back on when the send has
     * completed, or null for no callback.
     * @param handler Handler identifying the thread on which the callback
     * should happen.  If null, the callback will happen from the thread
     * pool of the process.
     *
     * @see #send()
     * @see #send(int)
     * @see #send(Context, int, Intent)
     * @see #send(int, android.app.PendingIntent.OnFinished, Handler)
     * @see #send(Context, int, Intent, OnFinished, Handler, String)
     *
     * @throws CanceledException Throws CanceledException if the PendingIntent
     * is no longer allowing more intents to be sent through it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.445 -0500", hash_original_method = "CFAA4D7DA67BDF756999EA8ECE28296B", hash_generated_method = "4AD6AEF1F974525EC4F626AD8217232F")
    
public void send(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler) throws CanceledException {
        send(context, code, intent, onFinished, handler, null);
    }

    /**
     * Perform the operation associated with this PendingIntent, allowing the
     * caller to specify information about the Intent to use and be notified
     * when the send has completed.
     *
     * <p>For the intent parameter, a PendingIntent
     * often has restrictions on which fields can be supplied here, based on
     * how the PendingIntent was retrieved in {@link #getActivity},
     * {@link #getBroadcast}, or {@link #getService}.
     *
     * @param context The Context of the caller.  This may be null if
     * <var>intent</var> is also null.
     * @param code Result code to supply back to the PendingIntent's target.
     * @param intent Additional Intent data.  See {@link Intent#fillIn
     * Intent.fillIn()} for information on how this is applied to the
     * original Intent.  Use null to not modify the original Intent.
     * @param onFinished The object to call back on when the send has
     * completed, or null for no callback.
     * @param handler Handler identifying the thread on which the callback
     * should happen.  If null, the callback will happen from the thread
     * pool of the process.
     * @param requiredPermission Name of permission that a recipient of the PendingIntent
     * is required to hold.  This is only valid for broadcast intents, and
     * corresponds to the permission argument in
     * {@link Context#sendBroadcast(Intent, String) Context.sendOrderedBroadcast(Intent, String)}.
     * If null, no permission is required.
     *
     * @see #send()
     * @see #send(int)
     * @see #send(Context, int, Intent)
     * @see #send(int, android.app.PendingIntent.OnFinished, Handler)
     * @see #send(Context, int, Intent, OnFinished, Handler)
     *
     * @throws CanceledException Throws CanceledException if the PendingIntent
     * is no longer allowing more intents to be sent through it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.447 -0500", hash_original_method = "A238DB61CDFFE1A49966C7738AE7C6E1", hash_generated_method = "0D9CDB0D98A6C7707455612FFEB794D7")
    
public void send(Context context, int code, Intent intent,
            OnFinished onFinished, Handler handler, String requiredPermission)
            throws CanceledException {
        try {
            String resolvedType = intent != null ?
                    intent.resolveTypeIfNeeded(context.getContentResolver())
                    : null;
            int res = mTarget.send(code, intent, resolvedType,
                    onFinished != null
                            ? new FinishedDispatcher(this, onFinished, handler)
                            : null,
                    requiredPermission);
            if (res < 0) {
                throw new CanceledException();
            }
        } catch (RemoteException e) {
            throw new CanceledException(e);
        }
    }

    /**
     * Return the package name of the application that created this
     * PendingIntent, that is the identity under which you will actually be
     * sending the Intent.  The returned string is supplied by the system, so
     * that an application can not spoof its package.
     *
     * @return The package name of the PendingIntent, or null if there is
     * none associated with it.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.449 -0500", hash_original_method = "1AE048A4984F76615C0EAE5393ABDA6D", hash_generated_method = "D3A6F32790B99E339D9B68926FE71FFC")
    
public String getTargetPackage() {
        try {
            return ActivityManagerNative.getDefault()
                .getPackageForIntentSender(mTarget);
        } catch (RemoteException e) {
            // Should never happen.
            return null;
        }
    }

    /**
     * @hide
     * Check to verify that this PendingIntent targets a specific package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.452 -0500", hash_original_method = "6D06AB3EE4D5DE54AFE0CC755257630C", hash_generated_method = "9C0DA04DA2E730A04E7E33B17325BE84")
    
public boolean isTargetedToPackage() {
        try {
            return ActivityManagerNative.getDefault()
                .isIntentSenderTargetedToPackage(mTarget);
        } catch (RemoteException e) {
            // Should never happen.
            return false;
        }
    }

    /**
     * Comparison operator on two PendingIntent objects, such that true
     * is returned then they both represent the same operation from the
     * same package.  This allows you to use {@link #getActivity},
     * {@link #getBroadcast}, or {@link #getService} multiple times (even
     * across a process being killed), resulting in different PendingIntent
     * objects but whose equals() method identifies them as being the same
     * operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.454 -0500", hash_original_method = "29E3C1E256E903CF301460F6770B7518", hash_generated_method = "895A26C8494EF0AA13A50A6453B4B20D")
    
@Override
    public boolean equals(Object otherObj) {
        if (otherObj instanceof PendingIntent) {
            return mTarget.asBinder().equals(((PendingIntent)otherObj)
                    .mTarget.asBinder());
        }
        return false;
    }
    
    public static class CanceledException extends AndroidException {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.382 -0500", hash_original_method = "6C791280BC05C3F7B11A7004B8EB7BE8", hash_generated_method = "76984C31773ED74269A80CE848B3D28D")
        
public CanceledException() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.385 -0500", hash_original_method = "C3CBF66373C770C27B2BC8A07C4853B3", hash_generated_method = "63B8C976D89988330EAE08B9D051A4A4")
        
public CanceledException(String name) {
            super(name);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.387 -0500", hash_original_method = "3AC8DEA112912D7509E7C6631865B3D3", hash_generated_method = "6471698CA95689569E1FEF49CD45D9E3")
        
public CanceledException(Exception cause) {
            super(cause);
        }
        
    }
    
    private static class FinishedDispatcher extends IIntentReceiver.Stub implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.395 -0500", hash_original_field = "7B47F6D668EAC8B29A4C2C64F0EA44AC", hash_generated_field = "094D5D79D03F65D4515938385B22FFF9")

        private  PendingIntent mPendingIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.397 -0500", hash_original_field = "064BC46820F6CAC18F4A40662540577B", hash_generated_field = "3E0837F5746BF0F0EA46630CD994FC89")

        private  OnFinished mWho;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.400 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private  Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.402 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

        private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.404 -0500", hash_original_field = "457E6BFD9A88F809DF3F4A88B9B7B893", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")

        private int mResultCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.406 -0500", hash_original_field = "9297DC4168CE0E61BD9D0F02E127B543", hash_generated_field = "C1E52350501391E7118DB73479974476")

        private String mResultData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.408 -0500", hash_original_field = "F5C1D34888409EAA7782FD08EA76AE47", hash_generated_field = "109BE0C611CD1E4823349D5DAFA222D0")

        private Bundle mResultExtras;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.411 -0500", hash_original_method = "D38CFD5EE08A135F8705E392DA5A871B", hash_generated_method = "D38CFD5EE08A135F8705E392DA5A871B")
        
FinishedDispatcher(PendingIntent pi, OnFinished who, Handler handler) {
            mPendingIntent = pi;
            mWho = who;
            mHandler = handler;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.413 -0500", hash_original_method = "B0E285A2D8AA1A0003201E2D8F6F7169", hash_generated_method = "28B5F41CEB7ECE4D1A59129F3C7D959D")
        
public void performReceive(Intent intent, int resultCode,
                String data, Bundle extras, boolean serialized, boolean sticky) {
            mIntent = intent;
            mResultCode = resultCode;
            mResultData = data;
            mResultExtras = extras;
            if (mHandler == null) {
                run();
            } else {
                mHandler.post(this);
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.416 -0500", hash_original_method = "323DC1202D6F14888580320FDC435E03", hash_generated_method = "7C574604C2F96F251C7EFB72E931341A")
        
public void run() {
            mWho.onSendFinished(mPendingIntent, mIntent, mResultCode,
                    mResultData, mResultExtras);
        }
        
    }
    
    public interface OnFinished {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onSendFinished(PendingIntent pendingIntent, Intent intent,
                int resultCode, String resultData, Bundle resultExtras);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.456 -0500", hash_original_method = "72E49DA56EC3D19D8D09B0982F6DDB55", hash_generated_method = "E62183137C3FCEB0B112CE7C5C0D4444")
    
@Override
    public int hashCode() {
        return mTarget.asBinder().hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.458 -0500", hash_original_method = "A24ED44DCFDBAE1CB5B942522723AC1A", hash_generated_method = "587EE0041A3A79CBFBA2B0E90C3817C7")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("PendingIntent{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(": ");
        sb.append(mTarget != null ? mTarget.asBinder() : null);
        sb.append('}');
        return sb.toString();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.460 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.462 -0500", hash_original_method = "FF0A290BC61B9CD02F1DD23699EA8B8B", hash_generated_method = "5FB48EDF3036D823DDA10D61F6FC459B")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeStrongBinder(mTarget.asBinder());
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.482 -0500", hash_original_method = "5A73019C5B7699A011E114A766F68ECD", hash_generated_method = "147FBD3908885E3E49DD8E1224C6EDEA")
    
public IIntentSender getTarget() {
        return mTarget;
    }
    // orphaned legacy method
    public PendingIntent createFromParcel(Parcel in) {
            IBinder target = in.readStrongBinder();
            return target != null ? new PendingIntent(target) : null;
        }
    
    // orphaned legacy method
    public PendingIntent[] newArray(int size) {
            return new PendingIntent[size];
        }
    
}

