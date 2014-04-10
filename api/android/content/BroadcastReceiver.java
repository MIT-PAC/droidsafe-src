package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import android.util.Slog;
import java.util.HashSet;
import java.util.Set;

import droidsafe.annotations.*;

import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.Application;
import android.app.IActivityManager;
import android.app.QueuedWork;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public abstract class BroadcastReceiver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.618 -0500", hash_original_field = "B6F0ED1C97BC5319472703C5AFA1B37B", hash_generated_field = "56CC6D10D54B274449EA4D95649A29AE")

    private PendingResult mPendingResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.620 -0500", hash_original_field = "A79B6E0166802F3342C33F0FE8F46913", hash_generated_field = "D63712D72C7DEA3780B2E3ED680A7016")

    private boolean mDebugUnregister;
    
    private Application mApplication;
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.695 -0500", hash_original_method = "2900F07960080430406180ADD3872CDD", hash_generated_method = "D3FA3C172476927ED563AFCC971E4A9A")
    
public BroadcastReceiver() {
    }

    public void droidSafeOnReceive(Context context, Intent intent) {
        onReceive(context, intent);
    }

    /**
     * This method is called when the BroadcastReceiver is receiving an Intent
     * broadcast.  During this time you can use the other methods on
     * BroadcastReceiver to view/modify the current result values.  The function
     * is normally called within the main thread of its process, so you should
     * never perform long-running operations in it (there is a timeout of
     * 10 seconds that the system allows before considering the receiver to
     * be blocked and a candidate to be killed). You cannot launch a popup dialog
     * in your implementation of onReceive().
     * 
     * <p><b>If this BroadcastReceiver was launched through a &lt;receiver&gt; tag,
     * then the object is no longer alive after returning from this
     * function.</b>  This means you should not perform any operations that
     * return a result to you asynchronously -- in particular, for interacting
     * with services, you should use
     * {@link Context#startService(Intent)} instead of
     * {@link Context#bindService(Intent, ServiceConnection, int)}.  If you wish
     * to interact with a service that is already running, you can use
     * {@link #peekService}.
     * 
     * <p>The Intent filters used in {@link android.content.Context#registerReceiver}
     * and in application manifests are <em>not</em> guaranteed to be exclusive. They
     * are hints to the operating system about how to find suitable recipients. It is
     * possible for senders to force delivery to specific recipients, bypassing filter
     * resolution.  For this reason, {@link #onReceive(Context, Intent) onReceive()}
     * implementations should respond only to known actions, ignoring any unexpected
     * Intents that they may receive.
     * 
     * @param context The Context in which the receiver is running.
     * @param intent The Intent being received.
     */
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.698 -0500", hash_original_method = "938B84A43002091BA0754FF3EF2C5C0E", hash_generated_method = "694CB25ED6D3FBC56A56AD38523219EB")
    
public abstract void onReceive(Context context, Intent intent);

    /**
     * This can be called by an application in {@link #onReceive} to allow
     * it to keep the broadcast active after returning from that function.
     * This does <em>not</em> change the expectation of being relatively
     * responsive to the broadcast (finishing it within 10s), but does allow
     * the implementation to move work related to it over to another thread
     * to avoid glitching the main UI thread due to disk IO.
     * 
     * @return Returns a {@link PendingResult} representing the result of
     * the active broadcast.  The BroadcastRecord itself is no longer active;
     * all data and other interaction must go through {@link PendingResult}
     * APIs.  The {@link PendingResult#finish PendingResult.finish()} method
     * must be called once processing of the broadcast is done.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.700 -0500", hash_original_method = "A694EC135053AF2FEB071A12D3EE4319", hash_generated_method = "BE715AB72252288900126FB579872EE2")
    
public final PendingResult goAsync() {
        PendingResult res = mPendingResult;
        mPendingResult = null;
        return res;
    }
    
    /**
     * Provide a binder to an already-running service.  This method is synchronous
     * and will not start the target service if it is not present, so it is safe
     * to call from {@link #onReceive}.
     * 
     * @param myContext The Context that had been passed to {@link #onReceive(Context, Intent)}
     * @param service The Intent indicating the service you wish to use.  See {@link
     * Context#startService(Intent)} for more information.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.702 -0500", hash_original_method = "891D062EE6B5DF300B0D5F817EBA802C", hash_generated_method = "A37EB1F6A113B613535C93793351ED22")
    
public IBinder peekService(Context myContext, Intent service) {
        IActivityManager am = ActivityManagerNative.getDefault();
        IBinder binder = null;
        try {
            service.setAllowFds(false);
            binder = am.peekService(service, service.resolveTypeIfNeeded(
                    myContext.getContentResolver()));
        } catch (RemoteException e) {
        }
        return binder;
    }

    /**
     * Change the current result code of this broadcast; only works with
     * broadcasts sent through
     * {@link Context#sendOrderedBroadcast(Intent, String)
     * Context.sendOrderedBroadcast}.  Often uses the
     * Activity {@link android.app.Activity#RESULT_CANCELED} and
     * {@link android.app.Activity#RESULT_OK} constants, though the
     * actual meaning of this value is ultimately up to the broadcaster.
     * 
     * <p class="note">This method does not work with non-ordered broadcasts such
     * as those sent with {@link Context#sendBroadcast(Intent)
     * Context.sendBroadcast}</p>
     * 
     * @param code The new result code.
     * 
     * @see #setResult(int, String, Bundle)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.705 -0500", hash_original_method = "D9C6679B9D8E9806D41E73EFA120BCFE", hash_generated_method = "4728470787842C4041B9F512D6E54F97")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSink(DSSinkKind.IPC)
public final void setResultCode(int code) {
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
    }

    /**
     * Retrieve the current result code, as set by the previous receiver.
     * 
     * @return int The current result code.
     */
    @DSComment("no impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.IPC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.707 -0500", hash_original_method = "413D4442793CB2CD30088D833172245E", hash_generated_method = "880C511B5BE77BEBC42FD95480D19EEC")
    
public final int getResultCode() {
        return mPendingResult != null ? mPendingResult.mResultCode : 0;
    }

    /**
     * Change the current result data of this broadcast; only works with
     * broadcasts sent through
     * {@link Context#sendOrderedBroadcast(Intent, String)
     * Context.sendOrderedBroadcast}.  This is an arbitrary
     * string whose interpretation is up to the broadcaster.
     * 
     * <p><strong>This method does not work with non-ordered broadcasts such
     * as those sent with {@link Context#sendBroadcast(Intent)
     * Context.sendBroadcast}</strong></p>
     * 
     * @param data The new result data; may be null.
     * 
     * @see #setResult(int, String, Bundle)
     */
    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSink(DSSinkKind.IPC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.709 -0500", hash_original_method = "326C45A93CAC69AE5F40CC5662FD4E21", hash_generated_method = "E4DE2260ED5DD490E9332E22785D5122")
public final void setResultData(String data) {
        checkSynchronousHint();
        mPendingResult.mResultData = data;
    }

    /**
     * Retrieve the current result data, as set by the previous receiver.
     * Often this is null.
     * 
     * @return String The current result data; may be null.
     */
    @DSSource({DSSourceKind.IPC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.712 -0500", hash_original_method = "4500B5844C9E31997AA4128C2B631832", hash_generated_method = "F3267C287ABB4521B4DB8DAD802FFCAB")
    @DSSafe(DSCat.OS_GENERAL)
public final String getResultData() {
        return mPendingResult != null ? mPendingResult.mResultData : null;
    }

    /**
     * Change the current result extras of this broadcast; only works with
     * broadcasts sent through
     * {@link Context#sendOrderedBroadcast(Intent, String)
     * Context.sendOrderedBroadcast}.  This is a Bundle
     * holding arbitrary data, whose interpretation is up to the
     * broadcaster.  Can be set to null.  Calling this method completely
     * replaces the current map (if any).
     * 
     * <p><strong>This method does not work with non-ordered broadcasts such
     * as those sent with {@link Context#sendBroadcast(Intent)
     * Context.sendBroadcast}</strong></p>
     * 
     * @param extras The new extra data map; may be null.
     * 
     * @see #setResult(int, String, Bundle)
     */
    @DSComment("General android operation, no security concern")
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.714 -0500", hash_original_method = "A002D9C66CF7F2AA1D1827503AAC99EC", hash_generated_method = "569D36CAC8A5C7CB261AB149A764B2A9")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSink(DSSinkKind.IPC)
public final void setResultExtras(Bundle extras) {
        checkSynchronousHint();
        mPendingResult.mResultExtras = extras;
    }

    /**
     * Retrieve the current result extra data, as set by the previous receiver.
     * Any changes you make to the returned Map will be propagated to the next
     * receiver.
     * 
     * @param makeMap If true then a new empty Map will be made for you if the
     *                current Map is null; if false you should be prepared to
     *                receive a null Map.
     * 
     * @return Map The current extras map.
     */
    @DSSource({DSSourceKind.IPC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.716 -0500", hash_original_method = "4CB90710C7A856F1CF5FAF169A56650C", hash_generated_method = "F071904FD5E94C95688CCF90728424FC")
    @DSSafe(DSCat.OS_GENERAL)
public final Bundle getResultExtras(boolean makeMap) {
        if (mPendingResult == null) {
            return null;
        }
        Bundle e = mPendingResult.mResultExtras;
        if (!makeMap) return e;
        if (e == null) mPendingResult.mResultExtras = e = new Bundle();
        return e;
    }

    /**
     * Change all of the result data returned from this broadcasts; only works
     * with broadcasts sent through
     * {@link Context#sendOrderedBroadcast(Intent, String)
     * Context.sendOrderedBroadcast}.  All current result data is replaced
     * by the value given to this method.
     * 
     * <p><strong>This method does not work with non-ordered broadcasts such
     * as those sent with {@link Context#sendBroadcast(Intent)
     * Context.sendBroadcast}</strong></p>
     * 
     * @param code The new result code.  Often uses the
     * Activity {@link android.app.Activity#RESULT_CANCELED} and
     * {@link android.app.Activity#RESULT_OK} constants, though the
     * actual meaning of this value is ultimately up to the broadcaster.
     * @param data The new result data.  This is an arbitrary
     * string whose interpretation is up to the broadcaster; may be null.
     * @param extras The new extra data map.  This is a Bundle
     * holding arbitrary data, whose interpretation is up to the
     * broadcaster.  Can be set to null.  This completely
     * replaces the current map (if any).
     */
    @DSComment("General android operation, no security concern")
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.718 -0500", hash_original_method = "71BA20FC3DD345B39DB950803A39A1ED", hash_generated_method = "ED3154BE987877FA0FF2943FC85107BB")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSink(DSSinkKind.IPC)
public final void setResult(int code, String data, Bundle extras) {
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
        mPendingResult.mResultData = data;
        mPendingResult.mResultExtras = extras;
    }
 
    /**
     * Returns the flag indicating whether or not this receiver should
     * abort the current broadcast.
     * 
     * @return True if the broadcast should be aborted.
     */
    @DSSource({DSSourceKind.IPC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.721 -0500", hash_original_method = "AC60D9C3BD95277DA035DD6FF45A8CCB", hash_generated_method = "149DAF27069326FB25F67A39BB4A2D01")
    @DSSafe(DSCat.OS_GENERAL)
public final boolean getAbortBroadcast() {
        return mPendingResult != null ? mPendingResult.mAbortBroadcast : false;
    }

    /**
     * Sets the flag indicating that this receiver should abort the
     * current broadcast; only works with broadcasts sent through
     * {@link Context#sendOrderedBroadcast(Intent, String)
     * Context.sendOrderedBroadcast}.  This will prevent
     * any other broadcast receivers from receiving the broadcast. It will still
     * call {@link #onReceive} of the BroadcastReceiver that the caller of 
     * {@link Context#sendOrderedBroadcast(Intent, String)
     * Context.sendOrderedBroadcast} passed in.
     * 
     * <p><strong>This method does not work with non-ordered broadcasts such
     * as those sent with {@link Context#sendBroadcast(Intent)
     * Context.sendBroadcast}</strong></p>
     */
    @DSComment("no impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.723 -0500", hash_original_method = "EA4258D43E5FA594C300ACFA62523E77", hash_generated_method = "48E8F953F737C5875A829159CC0D6592")
    
public final void abortBroadcast() {
        checkSynchronousHint();
        mPendingResult.mAbortBroadcast = true;
    }
    
    /**
     * Clears the flag indicating that this receiver should abort the current
     * broadcast.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.725 -0500", hash_original_method = "7C3FDE5990F70723754AFB92AED4E2CB", hash_generated_method = "DB1338A5242336FF55C4115BBF7D31DF")
    
public final void clearAbortBroadcast() {
        if (mPendingResult != null) {
            mPendingResult.mAbortBroadcast = false;
        }
    }
    
    /**
     * Returns true if the receiver is currently processing an ordered
     * broadcast.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.728 -0500", hash_original_method = "E46A4317E3055902B5625099FF6F383B", hash_generated_method = "72669CEA6CC031D5B1734B7741B935E0")
    
public final boolean isOrderedBroadcast() {
        return mPendingResult != null ? mPendingResult.mOrderedHint : false;
    }
    
    /**
     * Returns true if the receiver is currently processing the initial
     * value of a sticky broadcast -- that is, the value that was last
     * broadcast and is currently held in the sticky cache, so this is
     * not directly the result of a broadcast right now.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.730 -0500", hash_original_method = "85C5802A7642DD110CD6FEA4F9597134", hash_generated_method = "F81B94039206930553F82F985768EA83")
    
public final boolean isInitialStickyBroadcast() {
        return mPendingResult != null ? mPendingResult.mInitialStickyHint : false;
    }
    
    /**
     * For internal use, sets the hint about whether this BroadcastReceiver is
     * running in ordered mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.732 -0500", hash_original_method = "68B6314C0DA1E37C298D89B55CAE3400", hash_generated_method = "D3F7606173D6DF39314EA2B2AF34E3EE")
    
public final void setOrderedHint(boolean isOrdered) {
        // Accidentally left in the SDK.
    }
    
    /**
     * For internal use to set the result data that is active. @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.734 -0500", hash_original_method = "D4C333B718143025A27C15902000FB77", hash_generated_method = "3655C594E563935225D30259AECDD6E6")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSink(DSSinkKind.IPC)
public final void setPendingResult(PendingResult result) {
        mPendingResult = result;
    }
    
    /**
     * For internal use to set the result data that is active. @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.737 -0500", hash_original_method = "DB63B22B6D1F06710FF3BD6349434467", hash_generated_method = "0A667A34B1A427078E19EEC72E5E076A")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSource({DSSourceKind.IPC})
public final PendingResult getPendingResult() {
        return mPendingResult;
    }
    
    /**
     * Control inclusion of debugging help for mismatched
     * calls to {@ Context#registerReceiver(BroadcastReceiver, IntentFilter)
     * Context.registerReceiver()}.
     * If called with true, before given to registerReceiver(), then the
     * callstack of the following {@link Context#unregisterReceiver(BroadcastReceiver)
     * Context.unregisterReceiver()} call is retained, to be printed if a later
     * incorrect unregister call is made.  Note that doing this requires retaining
     * information about the BroadcastReceiver for the lifetime of the app,
     * resulting in a leak -- this should only be used for debugging.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.740 -0500", hash_original_method = "A942596201048EAFD951F2DD414301FD", hash_generated_method = "34A7224FEC930EA15D4DBCAD3444AB28")
    
public final void setDebugUnregister(boolean debug) {
        mDebugUnregister = debug;
    }
    
    /**
     * Return the last value given to {@link #setDebugUnregister}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.742 -0500", hash_original_method = "19A67BCF6BEB94B2ECFD54D952C17B9D", hash_generated_method = "9DECD4B98E264D80CCBAA5A6F4CBE4AD")
    @DSSafe(DSCat.OS_GENERAL)
    @DSSource(DSSourceKind.IPC)
public final boolean getDebugUnregister() {
        return mDebugUnregister;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.744 -0500", hash_original_method = "719234F696D75BD5E624E0997AEC2529", hash_generated_method = "C57D981D6CEF7C694F836FD9B92626F6")
    
void checkSynchronousHint() {
        if (mPendingResult == null) {
            throw new IllegalStateException("Call while result is not pending");
        }
        
        // Note that we don't assert when receiving the initial sticky value,
        // since that may have come from an ordered broadcast.  We'll catch
        // them later when the real broadcast happens again.
        if (mPendingResult.mOrderedHint || mPendingResult.mInitialStickyHint) {
            return;
        }
        RuntimeException e = new RuntimeException(
                "BroadcastReceiver trying to return result during a non-ordered broadcast");
        e.fillInStackTrace();
        Log.e("BroadcastReceiver", e.getMessage(), e);
    }
    
    // Broadcast receiver really belongs to application so, we call register intentfilter from
    // broadcast the receiver of application
    // We pull out IntentFilters out of xml and register them with the appropriate subclasses of Context here
    
    public Intent[] __ds__registerIntentFilter(Context context, IntentFilter intentFilter) {
        int actionCount = intentFilter.countActions();
        int catCount = intentFilter.countCategories();
        Intent[] intents = new Intent[actionCount];
        for (int actionIndex = 0; actionIndex < actionCount; actionIndex++) {
            Intent intent = new Intent(intentFilter.getAction(actionIndex));
            
            for (int catIndex = 0; catIndex < catCount; catIndex++) {
                intent.addCategory(intentFilter.getCategory(catIndex));
            }
            
            Uri dataUri = intentFilter.droidsafeGetDataUri();
            if (dataUri != null)
                intent.setData(dataUri);
            
            if (mApplication != null) {
                mApplication.__ds__intentFilters.add(intentFilter);
                mApplication.__ds__intentsFromFilter.add(intent);
            }
            
            onReceive(context, intent);

            intents[actionIndex] = intent;
        }
	
        return intents;
    }
    
    public void setApplication(Application app) { 
        this.mApplication = app;
    }
    
    public static class PendingResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.624 -0500", hash_original_field = "65E5C0613955484CFCF43BA9410EBE24", hash_generated_field = "E4EA6E7A3F4417E09164CDDBDCB8CDCE")

        public static final int TYPE_COMPONENT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.626 -0500", hash_original_field = "5F7083133FA2B534E59CD5D2DFB4FFFF", hash_generated_field = "06907A658310DA1AD3781E70CEE869F6")

        public static final int TYPE_REGISTERED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.628 -0500", hash_original_field = "3FD93F9C18D621243552B0472B0A196F", hash_generated_field = "502D0CFA37619833702608E6E5D5B79C")

        public static final int TYPE_UNREGISTERED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.631 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")
        
         int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.633 -0500", hash_original_field = "CDB2CA9D2DC3E6D40D3791F468236C61", hash_generated_field = "CDB2CA9D2DC3E6D40D3791F468236C61")

         boolean mOrderedHint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.635 -0500", hash_original_field = "13A087E46995ABA3C3337E0311BCBB18", hash_generated_field = "13A087E46995ABA3C3337E0311BCBB18")

         boolean mInitialStickyHint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.638 -0500", hash_original_field = "DD6EB7EC256F1225D4C6DC1A42FB765B", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

         IBinder mToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.640 -0500", hash_original_field = "457E6BFD9A88F809DF3F4A88B9B7B893", hash_generated_field = "457E6BFD9A88F809DF3F4A88B9B7B893")
        
        int mResultCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.642 -0500", hash_original_field = "9297DC4168CE0E61BD9D0F02E127B543", hash_generated_field = "9297DC4168CE0E61BD9D0F02E127B543")

        String mResultData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.644 -0500", hash_original_field = "F5C1D34888409EAA7782FD08EA76AE47", hash_generated_field = "F5C1D34888409EAA7782FD08EA76AE47")

        Bundle mResultExtras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.646 -0500", hash_original_field = "BE6D043F13884118A46F3E134D0352F1", hash_generated_field = "BE6D043F13884118A46F3E134D0352F1")

        boolean mAbortBroadcast;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.648 -0500", hash_original_field = "10598AB9B4F301B505526794EAE9EAF0", hash_generated_field = "10598AB9B4F301B505526794EAE9EAF0")

        boolean mFinished;
        
        /** @hide */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.651 -0500", hash_original_method = "A092172050E6E1EA8E89A6BB2F65A5D7", hash_generated_method = "A85F5B1897850D29BBF53C42AE629823")
        
public PendingResult(int resultCode, String resultData, Bundle resultExtras,
                int type, boolean ordered, boolean sticky, IBinder token) {
            mResultCode = resultCode;
            mResultData = resultData;
            mResultExtras = resultExtras;
            mType = type;
            mOrderedHint = ordered;
            mInitialStickyHint = sticky;
            mToken = token;
        }
        
        /**
         * Version of {@link BroadcastReceiver#setResultCode(int)
         * BroadcastReceiver.setResultCode(int)} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.654 -0500", hash_original_method = "8D188219D9B47ACA890A3A3FC0E4CDB9", hash_generated_method = "E32022466188A7DAF782DFC9003CFD6F")
        @DSSafe(DSCat.OS_GENERAL)
        @DSSink(DSSinkKind.IPC)

public final void setResultCode(int code) {
            checkSynchronousHint();
            mResultCode = code;
        }

        /**
         * Version of {@link BroadcastReceiver#getResultCode()
         * BroadcastReceiver.getResultCode()} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.656 -0500", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "465ACAC5613A6099E1AF6CE8D2EEE8B1")
        @DSSafe(DSCat.OS_GENERAL)
        @DSSource(DSSourceKind.IPC)

public final int getResultCode() {
            return mResultCode;
        }

        /**
         * Version of {@link BroadcastReceiver#setResultData(String)
         * BroadcastReceiver.setResultData(String)} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.658 -0500", hash_original_method = "70EE21896C4793F2CD7F1124D2F52609", hash_generated_method = "184B0DE368B365C6EE3EFE3877A399AC")
        @DSSafe(DSCat.OS_GENERAL)
        @DSSink(DSSinkKind.IPC)

public final void setResultData(String data) {
            checkSynchronousHint();
            mResultData = data;
        }

        /**
         * Version of {@link BroadcastReceiver#getResultData()
         * BroadcastReceiver.getResultData()} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.661 -0500", hash_original_method = "AF28EEAF3BA9B8705C009D1FCC834AB4", hash_generated_method = "5C6F3660000895054189DB24D79089B0")
        @DSSafe(DSCat.OS_GENERAL)
        @DSSource(DSSourceKind.IPC)

public final String getResultData() {
            return mResultData;
        }

        /**
         * Version of {@link BroadcastReceiver#setResultExtras(Bundle)
         * BroadcastReceiver.setResultExtras(Bundle)} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.663 -0500", hash_original_method = "043EFA68A5EC6A2685391992580FAB4F", hash_generated_method = "90BC11B88935DBA281C46408CD5CD07A")
        @DSSafe(DSCat.OS_GENERAL)
        @DSSink(DSSinkKind.IPC)
public final void setResultExtras(Bundle extras) {
            checkSynchronousHint();
            mResultExtras = extras;
        }

        /**
         * Version of {@link BroadcastReceiver#getResultExtras(boolean)
         * BroadcastReceiver.getResultExtras(boolean)} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.666 -0500", hash_original_method = "48408ADF0828FD95531740A7B634349C", hash_generated_method = "9EE4A1D648D3CFF409DC710800479791")
        @DSSafe(DSCat.OS_GENERAL)
        @DSSource(DSSourceKind.IPC)

public final Bundle getResultExtras(boolean makeMap) {
            Bundle e = mResultExtras;
            if (!makeMap) return e;
            if (e == null) mResultExtras = e = new Bundle();
            return e;
        }

        /**
         * Version of {@link BroadcastReceiver#setResult(int, String, Bundle)
         * BroadcastReceiver.setResult(int, String, Bundle)} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.668 -0500", hash_original_method = "48338FF93B0D949C9CE50695C92AC674", hash_generated_method = "1B0E51B76DF4CEB770F6DDC75DD56316")
        @DSSafe(DSCat.OS_GENERAL)
        @DSSink(DSSinkKind.IPC)

public final void setResult(int code, String data, Bundle extras) {
            checkSynchronousHint();
            mResultCode = code;
            mResultData = data;
            mResultExtras = extras;
        }
     
        /**
         * Version of {@link BroadcastReceiver#getAbortBroadcast()
         * BroadcastReceiver.getAbortBroadcast()} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.670 -0500", hash_original_method = "27570BF34E94ABF03E65F54A5F2272E5", hash_generated_method = "F83BD098FE1867AE62400EBE8D0FCBE8")
        @DSSafe(DSCat.OS_GENERAL)
        @DSSource(DSSourceKind.IPC)
public final boolean getAbortBroadcast() {
            return mAbortBroadcast;
        }

        /**
         * Version of {@link BroadcastReceiver#abortBroadcast()
         * BroadcastReceiver.abortBroadcast()} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.672 -0500", hash_original_method = "1D9776C1F73983B7C91D53BC3475252B", hash_generated_method = "AE6A9BD50FCC1EBD6EA286BBC71104B6")
        
public final void abortBroadcast() {
            checkSynchronousHint();
            mAbortBroadcast = true;
        }
        
        /**
         * Version of {@link BroadcastReceiver#clearAbortBroadcast()
         * BroadcastReceiver.clearAbortBroadcast()} for
         * asynchronous broadcast handling.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.675 -0500", hash_original_method = "D4C82CDA8EB6714DAE416B0884FCBC85", hash_generated_method = "E219B0B0EF571715A899CC59EED367B9")
        
public final void clearAbortBroadcast() {
            mAbortBroadcast = false;
        }
        
        /**
         * Finish the broadcast.  The current result will be sent and the
         * next broadcast will proceed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.681 -0500", hash_original_method = "D8A44D8DD1BCA140D23101E83E968FA0", hash_generated_method = "3112768060D5949EC2B35E71F665E4A6")
        
public final void finish() {
            if (mType == TYPE_COMPONENT) {
                final IActivityManager mgr = ActivityManagerNative.getDefault();
                if (QueuedWork.hasPendingWork()) {
                    // If this is a broadcast component, we need to make sure any
                    // queued work is complete before telling AM we are done, so
                    // we don't have our process killed before that.  We now know
                    // there is pending work; put another piece of work at the end
                    // of the list to finish the broadcast, so we don't block this
                    // thread (which may be the main thread) to have it finished.
                    //
                    // Note that we don't need to use QueuedWork.add() with the
                    // runnable, since we know the AM is waiting for us until the
                    // executor gets to it.
                    QueuedWork.singleThreadExecutor().execute( new Runnable() {
                        @Override public void run() {
                            if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                                    "Finishing broadcast after work to component " + mToken);
                            sendFinished(mgr);
                        }
                    });
                } else {
                    if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                            "Finishing broadcast to component " + mToken);
                    sendFinished(mgr);
                }
            } else if (mOrderedHint && mType != TYPE_UNREGISTERED) {
                if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                        "Finishing broadcast to " + mToken);
                final IActivityManager mgr = ActivityManagerNative.getDefault();
                sendFinished(mgr);
            }
        }
        
        /** @hide */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.684 -0500", hash_original_method = "09CFE321AB9E3444E3559F2B522AB2BE", hash_generated_method = "270A7467DBBC424A0346BC1B0BEB0CE4")
        
public void setExtrasClassLoader(ClassLoader cl) {
            if (mResultExtras != null) {
                mResultExtras.setClassLoader(cl);
            }
        }
        
        /** @hide */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.686 -0500", hash_original_method = "AADF9DDAF1334800EDC66F9968E01FC0", hash_generated_method = "A3DF577E6135F4F98DF945D23062A031")
        
public void sendFinished(IActivityManager am) {
            synchronized (this) {
                if (mFinished) {
                    throw new IllegalStateException("Broadcast already finished");
                }
                mFinished = true;
            
                try {
                    if (mResultExtras != null) {
                        mResultExtras.setAllowFds(false);
                    }
                    if (mOrderedHint) {
                        am.finishReceiver(mToken, mResultCode, mResultData, mResultExtras,
                                mAbortBroadcast);
                    } else {
                        // This broadcast was sent to a component; it is not ordered,
                        // but we still need to tell the activity manager we are done.
                        am.finishReceiver(mToken, 0, null, null, false);
                    }
                } catch (RemoteException ex) {
                }
            }
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.689 -0500", hash_original_method = "82A6C5AFD458725D364E088D203D4257", hash_generated_method = "D3D9B52B557CC655E4E6062D42823B33")
        
void checkSynchronousHint() {
            // Note that we don't assert when receiving the initial sticky value,
            // since that may have come from an ordered broadcast.  We'll catch
            // them later when the real broadcast happens again.
            if (mOrderedHint || mInitialStickyHint) {
                return;
            }
            RuntimeException e = new RuntimeException(
                    "BroadcastReceiver trying to return result during a non-ordered broadcast");
            e.fillInStackTrace();
            Log.e("BroadcastReceiver", e.getMessage(), e);
        }
    }
    
}

