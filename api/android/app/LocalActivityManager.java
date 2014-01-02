package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Binder;
import android.os.Bundle;
import android.view.Window;





public class LocalActivityManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.339 -0500", hash_original_field = "CE8ADB3DD1644E5C152ADB17DBF734F0", hash_generated_field = "51C71CC685F225C3ECFF2ACB9029A01F")

    private static final String TAG = "LocalActivityManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.341 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "761D2619615A389BF902F171CC86D6A4")

    private static final boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.363 -0500", hash_original_field = "732E0C842B1B09236CA82DB3232F02AF", hash_generated_field = "FB094120D71B6E47F4CCD5880F183955")


    static final int RESTORED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.365 -0500", hash_original_field = "C4D8D1583E3D0B4649E95F837328E9BE", hash_generated_field = "482EFBA42C6E2CFF17C7C88620EE2AE7")

    static final int INITIALIZING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.368 -0500", hash_original_field = "51FC0DA9040C2EA600704EFB36FAF31A", hash_generated_field = "79EC126748439AA2A44FDF8D6ED403DD")

    static final int CREATED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.370 -0500", hash_original_field = "0B45C76A7815F18DFE404F4073DD0437", hash_generated_field = "32314BE6D22C0FBFEE57366A48F24AEF")

    static final int STARTED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.372 -0500", hash_original_field = "F43ACF77B48A854C5A60C856FB2C66E8", hash_generated_field = "CDB8768200B5FB0298BB9334F431B4E6")

    static final int RESUMED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.374 -0500", hash_original_field = "EE1E47480CD073D6FC41BA2B2BF10298", hash_generated_field = "5019021A5B3C4386BCA1F34395386874")

    static final int DESTROYED = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.376 -0500", hash_original_field = "B78253FB0F6A8AE9C3434DD384D8A838", hash_generated_field = "59A25D5EA94D9575239D0D207B005E37")

    
    /** Thread our activities are running in. */
    private  ActivityThread mActivityThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.379 -0500", hash_original_field = "CD55C80FF47FF655766F475F33319B07", hash_generated_field = "130E2721A67D8BF1BBFAC45B04E5FF8B")

    private  Activity mParent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.381 -0500", hash_original_field = "C40E394A1E402210013123EB86833106", hash_generated_field = "86C367C360550C8AC8371A7EA31B7C59")

    private LocalActivityRecord mResumed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.383 -0500", hash_original_field = "875472C83F8851CCC8A0034D56E012BD", hash_generated_field = "3279D1193B59C6A27CDB22D771FB6A5E")

    private final Map<String, LocalActivityRecord> mActivities
            = new HashMap<String, LocalActivityRecord>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.385 -0500", hash_original_field = "577FD602961559A115D212445B755CD3", hash_generated_field = "51D5888963C48B7E77E27D6489323908")

    private final ArrayList<LocalActivityRecord> mActivityArray
            = new ArrayList<LocalActivityRecord>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.388 -0500", hash_original_field = "DE989A93D6B70C1F62975671963E3D34", hash_generated_field = "0DD5EF490635B2544D1F4425BC363B4D")

    private boolean mSingleMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.390 -0500", hash_original_field = "E47120DD0AACE728FE0AF8530ED0B336", hash_generated_field = "72BBBF947B4E9BBAA7A265FAF6F263E0")

    private boolean mFinishing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.392 -0500", hash_original_field = "CFF0F0646F9DF3F6E23C34B8849FCCBF", hash_generated_field = "56550F8D73862FCFD4D73681A0E5EBC0")

    private int mCurState = INITIALIZING;
    
    /** String ids of running activities starting with least recently used. */
    // TODO: put back in stopping of activities.
    //private List<LocalActivityRecord>  mLRU = new ArrayList();

    /**
     * Create a new LocalActivityManager for holding activities running within
     * the given <var>parent</var>.
     * 
     * @param parent the host of the embedded activities
     * @param singleMode True if the LocalActivityManger should keep a maximum
     * of one activity resumed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.394 -0500", hash_original_method = "91223A19E58DDEF4278C27D9FB9EBEA3", hash_generated_method = "3314B25AF66BFE180F30D55AB12A0DB4")
    
public LocalActivityManager(Activity parent, boolean singleMode) {
        mActivityThread = ActivityThread.currentActivityThread();
        mParent = parent;
        mSingleMode = singleMode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.399 -0500", hash_original_method = "B12896933A50085371F00492E36D4EA5", hash_generated_method = "4D5847CE6422221DF635E53671887260")
    
private void moveToState(LocalActivityRecord r, int desiredState) {
        if (r.curState == RESTORED || r.curState == DESTROYED) {
            // startActivity() has not yet been called, so nothing to do.
            return;
        }
        
        if (r.curState == INITIALIZING) {
            // Get the lastNonConfigurationInstance for the activity
            HashMap<String, Object> lastNonConfigurationInstances =
                    mParent.getLastNonConfigurationChildInstances();
            Object instanceObj = null;
            if (lastNonConfigurationInstances != null) {
                instanceObj = lastNonConfigurationInstances.get(r.id);
            }
            Activity.NonConfigurationInstances instance = null;
            if (instanceObj != null) {
                instance = new Activity.NonConfigurationInstances();
                instance.activity = instanceObj;
            }
            
            // We need to have always created the activity.
            if (localLOGV) Log.v(TAG, r.id + ": starting " + r.intent);
            if (r.activityInfo == null) {
                r.activityInfo = mActivityThread.resolveActivityInfo(r.intent);
            }
            r.activity = mActivityThread.startActivityNow(
                    mParent, r.id, r.intent, r.activityInfo, r, r.instanceState, instance);
            if (r.activity == null) {
                return;
            }
            r.window = r.activity.getWindow();
            r.instanceState = null;
            r.curState = STARTED;
            
            if (desiredState == RESUMED) {
                if (localLOGV) Log.v(TAG, r.id + ": resuming");
                mActivityThread.performResumeActivity(r, true);
                r.curState = RESUMED;
            }
            
            // Don't do anything more here.  There is an important case:
            // if this is being done as part of onCreate() of the group, then
            // the launching of the activity gets its state a little ahead
            // of our own (it is now STARTED, while we are only CREATED).
            // If we just leave things as-is, we'll deal with it as the
            // group's state catches up.
            return;
        }
        
        switch (r.curState) {
            case CREATED:
                if (desiredState == STARTED) {
                    if (localLOGV) Log.v(TAG, r.id + ": restarting");
                    mActivityThread.performRestartActivity(r);
                    r.curState = STARTED;
                }
                if (desiredState == RESUMED) {
                    if (localLOGV) Log.v(TAG, r.id + ": restarting and resuming");
                    mActivityThread.performRestartActivity(r);
                    mActivityThread.performResumeActivity(r, true);
                    r.curState = RESUMED;
                }
                return;
                
            case STARTED:
                if (desiredState == RESUMED) {
                    // Need to resume it...
                    if (localLOGV) Log.v(TAG, r.id + ": resuming");
                    mActivityThread.performResumeActivity(r, true);
                    r.instanceState = null;
                    r.curState = RESUMED;
                }
                if (desiredState == CREATED) {
                    if (localLOGV) Log.v(TAG, r.id + ": stopping");
                    mActivityThread.performStopActivity(r, false);
                    r.curState = CREATED;
                }
                return;
                
            case RESUMED:
                if (desiredState == STARTED) {
                    if (localLOGV) Log.v(TAG, r.id + ": pausing");
                    performPause(r, mFinishing);
                    r.curState = STARTED;
                }
                if (desiredState == CREATED) {
                    if (localLOGV) Log.v(TAG, r.id + ": pausing");
                    performPause(r, mFinishing);
                    if (localLOGV) Log.v(TAG, r.id + ": stopping");
                    mActivityThread.performStopActivity(r, false);
                    r.curState = CREATED;
                }
                return;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.401 -0500", hash_original_method = "D6EC4953476E7D98493712A14D0E2C8F", hash_generated_method = "95DC1535A4E291CF846F71A615F24706")
    
private void performPause(LocalActivityRecord r, boolean finishing) {
        boolean needState = r.instanceState == null;
        Bundle instanceState = mActivityThread.performPauseActivity(r,
                finishing, needState);
        if (needState) {
            r.instanceState = instanceState;
        }
    }
    
    /**
     * Start a new activity running in the group.  Every activity you start
     * must have a unique string ID associated with it -- this is used to keep
     * track of the activity, so that if you later call startActivity() again
     * on it the same activity object will be retained.
     * 
     * <p>When there had previously been an activity started under this id,
     * it may either be destroyed and a new one started, or the current
     * one re-used, based on these conditions, in order:</p>
     * 
     * <ul>
     * <li> If the Intent maps to a different activity component than is
     * currently running, the current activity is finished and a new one
     * started.
     * <li> If the current activity uses a non-multiple launch mode (such
     * as singleTop), or the Intent has the
     * {@link Intent#FLAG_ACTIVITY_SINGLE_TOP} flag set, then the current
     * activity will remain running and its
     * {@link Activity#onNewIntent(Intent) Activity.onNewIntent()} method
     * called.
     * <li> If the new Intent is the same (excluding extras) as the previous
     * one, and the new Intent does not have the
     * {@link Intent#FLAG_ACTIVITY_CLEAR_TOP} set, then the current activity
     * will remain running as-is.
     * <li> Otherwise, the current activity will be finished and a new
     * one started.
     * </ul>
     * 
     * <p>If the given Intent can not be resolved to an available Activity,
     * this method throws {@link android.content.ActivityNotFoundException}.
     * 
     * <p>Warning: There is an issue where, if the Intent does not
     * include an explicit component, we can restore the state for a different
     * activity class than was previously running when the state was saved (if
     * the set of available activities changes between those points).
     * 
     * @param id Unique identifier of the activity to be started
     * @param intent The Intent describing the activity to be started
     * 
     * @return Returns the window of the activity.  The caller needs to take
     * care of adding this window to a view hierarchy, and likewise dealing
     * with removing the old window if the activity has changed.
     * 
     * @throws android.content.ActivityNotFoundException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.405 -0500", hash_original_method = "0A59627F0C289533278C9C6F1CF55EF3", hash_generated_method = "B78CB55B0AD280C73F4ADD02A9AABA0F")
    
public Window startActivity(String id, Intent intent) {
        if (mCurState == INITIALIZING) {
            throw new IllegalStateException(
                    "Activities can't be added until the containing group has been created.");
        }
        
        boolean adding = false;
        boolean sameIntent = false;

        ActivityInfo aInfo = null;
        
        // Already have information about the new activity id?
        LocalActivityRecord r = mActivities.get(id);
        if (r == null) {
            // Need to create it...
            r = new LocalActivityRecord(id, intent);
            adding = true;
        } else if (r.intent != null) {
            sameIntent = r.intent.filterEquals(intent); 
            if (sameIntent) {
                // We are starting the same activity.
                aInfo = r.activityInfo;
            }
        }
        if (aInfo == null) {
            aInfo = mActivityThread.resolveActivityInfo(intent);
        }
        
        // Pause the currently running activity if there is one and only a single
        // activity is allowed to be running at a time.
        if (mSingleMode) {
            LocalActivityRecord old = mResumed;
    
            // If there was a previous activity, and it is not the current
            // activity, we need to stop it.
            if (old != null && old != r && mCurState == RESUMED) {
                moveToState(old, STARTED);
            }
        }

        if (adding) {
            // It's a brand new world.
            mActivities.put(id, r);
            mActivityArray.add(r);
        } else if (r.activityInfo != null) {
            // If the new activity is the same as the current one, then
            // we may be able to reuse it.
            if (aInfo == r.activityInfo ||
                    (aInfo.name.equals(r.activityInfo.name) &&
                            aInfo.packageName.equals(r.activityInfo.packageName))) {
                if (aInfo.launchMode != ActivityInfo.LAUNCH_MULTIPLE ||
                        (intent.getFlags()&Intent.FLAG_ACTIVITY_SINGLE_TOP) != 0) {
                    // The activity wants onNewIntent() called.
                    ArrayList<Intent> intents = new ArrayList<Intent>(1);
                    intents.add(intent);
                    if (localLOGV) Log.v(TAG, r.id + ": new intent");
                    mActivityThread.performNewIntents(r, intents);
                    r.intent = intent;
                    moveToState(r, mCurState);
                    if (mSingleMode) {
                        mResumed = r;
                    }
                    return r.window;
                }
                if (sameIntent &&
                        (intent.getFlags()&Intent.FLAG_ACTIVITY_CLEAR_TOP) == 0) {
                    // We are showing the same thing, so this activity is
                    // just resumed and stays as-is.
                    r.intent = intent;
                    moveToState(r, mCurState);
                    if (mSingleMode) {
                        mResumed = r;
                    }
                    return r.window;
                }
            }
            
            // The new activity is different than the current one, or it
            // is a multiple launch activity, so we need to destroy what
            // is currently there.
            performDestroy(r, true);
        }
        
        r.intent = intent;
        r.curState = INITIALIZING;
        r.activityInfo = aInfo;

        moveToState(r, mCurState);

        // When in single mode keep track of the current activity
        if (mSingleMode) {
            mResumed = r;
        }
        return r.window;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.408 -0500", hash_original_method = "9068A3C43CAB8D5C5EE5DD7E1741D6DA", hash_generated_method = "E828F3B0F04834D18D82BED4FEB45432")
    
private Window performDestroy(LocalActivityRecord r, boolean finish) {
        Window win;
        win = r.window;
        if (r.curState == RESUMED && !finish) {
            performPause(r, finish);
        }
        if (localLOGV) Log.v(TAG, r.id + ": destroying");
        mActivityThread.performDestroyActivity(r, finish);
        r.activity = null;
        r.window = null;
        if (finish) {
            r.instanceState = null;
        }
        r.curState = DESTROYED;
        return win;
    }
    
    /**
     * Destroy the activity associated with a particular id.  This activity
     * will go through the normal lifecycle events and fine onDestroy(), and
     * then the id removed from the group.
     * 
     * @param id Unique identifier of the activity to be destroyed
     * @param finish If true, this activity will be finished, so its id and
     * all state are removed from the group.
     * 
     * @return Returns the window that was used to display the activity, or
     * null if there was none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.410 -0500", hash_original_method = "BE481800D6C8FAA522EB6457C475667B", hash_generated_method = "F44233FB347E5FD4543E20B51FB6AAAB")
    
public Window destroyActivity(String id, boolean finish) {
        LocalActivityRecord r = mActivities.get(id);
        Window win = null;
        if (r != null) {
            win = performDestroy(r, finish);
            if (finish) {
                mActivities.remove(id);
                mActivityArray.remove(r);
            }
        }
        return win;
    }
    
    /**
     * Retrieve the Activity that is currently running.
     * 
     * @return the currently running (resumed) Activity, or null if there is
     *         not one
     * 
     * @see #startActivity
     * @see #getCurrentId
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.412 -0500", hash_original_method = "DDB5384220B4A60C69552CE8336AA299", hash_generated_method = "FF1F9ECE6E3D1BD66D6645D262D06434")
    
public Activity getCurrentActivity() {
        return mResumed != null ? mResumed.activity : null;
    }

    /**
     * Retrieve the ID of the activity that is currently running.
     * 
     * @return the ID of the currently running (resumed) Activity, or null if
     *         there is not one
     * 
     * @see #startActivity
     * @see #getCurrentActivity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.415 -0500", hash_original_method = "4729520AC64C6CA5B20AE92550B34CDA", hash_generated_method = "4DDCC0BF080D774312C1898D964EC6C2")
    
public String getCurrentId() {
        return mResumed != null ? mResumed.id : null;
    }

    /**
     * Return the Activity object associated with a string ID.
     * 
     * @see #startActivity
     * 
     * @return the associated Activity object, or null if the id is unknown or
     *         its activity is not currently instantiated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.417 -0500", hash_original_method = "AAFBFF7BB86A9D1FFB973CDC0860D37E", hash_generated_method = "5B68D0E1E88D3BA99DAC8D301ECEEEED")
    
public Activity getActivity(String id) {
        LocalActivityRecord r = mActivities.get(id);
        return r != null ? r.activity : null;
    }

    
    private static class LocalActivityRecord extends Binder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.346 -0500", hash_original_field = "960D0AAB4FA1CF92AEC1F360608BDEE3", hash_generated_field = "960D0AAB4FA1CF92AEC1F360608BDEE3")


         String id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.348 -0500", hash_original_field = "170FCA7A98A65D8003A3D20D5B3C245D", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.351 -0500", hash_original_field = "9CFCA1B7F8752ABB79A9EED9367C413A", hash_generated_field = "9CFCA1B7F8752ABB79A9EED9367C413A")

        ActivityInfo activityInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.353 -0500", hash_original_field = "A63B0916BD4AC2611D1AF746A2DF045C", hash_generated_field = "A63B0916BD4AC2611D1AF746A2DF045C")

        Activity activity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.355 -0500", hash_original_field = "C8345ED8E0FB49346B128B9846AFDDB2", hash_generated_field = "C8345ED8E0FB49346B128B9846AFDDB2")

        Window window;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.357 -0500", hash_original_field = "F4B69932E4B52B5DB7DD5C9BD2D7B407", hash_generated_field = "F4B69932E4B52B5DB7DD5C9BD2D7B407")

        Bundle instanceState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.359 -0500", hash_original_field = "6D133C9482705F97D3CEA539075FF242", hash_generated_field = "6D133C9482705F97D3CEA539075FF242")

        int curState = RESTORED;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.344 -0500", hash_original_method = "E1D83503B31583A6BAE5696926B0F492", hash_generated_method = "E1D83503B31583A6BAE5696926B0F492")
        
LocalActivityRecord(String _id, Intent _intent) {
            id = _id;
            intent = _intent;
        }

        
    }

    /**
     * Restore a state that was previously returned by {@link #saveInstanceState}.  This
     * adds to the activity group information about all activity IDs that had
     * previously been saved, even if they have not been started yet, so if the
     * user later navigates to them the correct state will be restored.
     * 
     * <p>Note: This does <b>not</b> change the current running activity, or
     * start whatever activity was previously running when the state was saved.
     * That is up to the client to do, in whatever way it thinks is best.
     * 
     * @param state a previously saved state; does nothing if this is null
     * 
     * @see #saveInstanceState
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.419 -0500", hash_original_method = "012D05327CF4F67BB20181F9A8D8EBE2", hash_generated_method = "DE4C485033BE39BACB098EE622F21137")
    
public void dispatchCreate(Bundle state) {
        if (state != null) {
            for (String id : state.keySet()) {
                try {
                    final Bundle astate = state.getBundle(id);
                    LocalActivityRecord r = mActivities.get(id);
                    if (r != null) {
                        r.instanceState = astate;
                    } else {
                        r = new LocalActivityRecord(id, null);
                        r.instanceState = astate;
                        mActivities.put(id, r);
                        mActivityArray.add(r);
                    }
                } catch (Exception e) {
                    // Recover from -all- app errors.
                    Log.e(TAG, "Exception thrown when restoring LocalActivityManager state", e);
                }
            }
        }
        
        mCurState = CREATED;
    }

    /**
     * Retrieve the state of all activities known by the group.  For
     * activities that have previously run and are now stopped or finished, the
     * last saved state is used.  For the current running activity, its
     * {@link Activity#onSaveInstanceState} is called to retrieve its current state.
     * 
     * @return a Bundle holding the newly created state of all known activities
     * 
     * @see #dispatchCreate
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.422 -0500", hash_original_method = "5298101F1EDBDE2B5A84C3EFF961D34B", hash_generated_method = "380788475216D0A335556FD30738A77D")
    
public Bundle saveInstanceState() {
        Bundle state = null;

        // FIXME: child activities will freeze as part of onPaused. Do we
        // need to do this here?
        final int N = mActivityArray.size();
        for (int i=0; i<N; i++) {
            final LocalActivityRecord r = mActivityArray.get(i);
            if (state == null) {
                state = new Bundle();
            }
            if ((r.instanceState != null || r.curState == RESUMED)
                    && r.activity != null) {
                // We need to save the state now, if we don't currently
                // already have it or the activity is currently resumed.
                final Bundle childState = new Bundle();
                r.activity.performSaveInstanceState(childState);
                r.instanceState = childState;
            }
            if (r.instanceState != null) {
                state.putBundle(r.id, r.instanceState);
            }
        }

        return state;
    }

    /**
     * Called by the container activity in its {@link Activity#onResume} so
     * that LocalActivityManager can perform the corresponding action on the
     * activities it holds.
     * 
     * @see Activity#onResume
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.424 -0500", hash_original_method = "7718D5666C8415D1D9EF0CF84FCCE3FD", hash_generated_method = "89B030EB532E367F10F6215449F2D4F1")
    
public void dispatchResume() {
        mCurState = RESUMED;
        if (mSingleMode) {
            if (mResumed != null) {
                moveToState(mResumed, RESUMED);
            }
        } else {
            final int N = mActivityArray.size();
            for (int i=0; i<N; i++) {
                moveToState(mActivityArray.get(i), RESUMED);
            }
        }
    }

    /**
     * Called by the container activity in its {@link Activity#onPause} so
     * that LocalActivityManager can perform the corresponding action on the
     * activities it holds.
     * 
     * @param finishing set to true if the parent activity has been finished;
     *                  this can be determined by calling
     *                  Activity.isFinishing()
     * 
     * @see Activity#onPause
     * @see Activity#isFinishing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.427 -0500", hash_original_method = "85A6F8844A81DEE3E47CADEC5BC4757D", hash_generated_method = "028D48D2A242341C4CED30A3C5B7667D")
    
public void dispatchPause(boolean finishing) {
        if (finishing) {
            mFinishing = true;
        }
        mCurState = STARTED;
        if (mSingleMode) {
            if (mResumed != null) {
                moveToState(mResumed, STARTED);
            }
        } else {
            final int N = mActivityArray.size();
            for (int i=0; i<N; i++) {
                LocalActivityRecord r = mActivityArray.get(i);
                if (r.curState == RESUMED) {
                    moveToState(r, STARTED);
                }
            }
        }
    }

    /**
     * Called by the container activity in its {@link Activity#onStop} so
     * that LocalActivityManager can perform the corresponding action on the
     * activities it holds.
     * 
     * @see Activity#onStop
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.429 -0500", hash_original_method = "E93631F1674DB507A27EE53DB47C2CFE", hash_generated_method = "B20D5AD41CA9D6A1A9D3856FA4E7C061")
    
public void dispatchStop() {
        mCurState = CREATED;
        final int N = mActivityArray.size();
        for (int i=0; i<N; i++) {
            LocalActivityRecord r = mActivityArray.get(i);
            moveToState(r, CREATED);
        }
    }
    
    /**
     * Call onRetainNonConfigurationInstance on each child activity and store the
     * results in a HashMap by id.  Only construct the HashMap if there is a non-null
     * object to store.  Note that this does not support nested ActivityGroups.
     * 
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.431 -0500", hash_original_method = "070B049D0EB630832F296616C02C666D", hash_generated_method = "6B03AD255CDDCAC63500D38F4490A1FD")
    
public HashMap<String,Object> dispatchRetainNonConfigurationInstance() {
        HashMap<String,Object> instanceMap = null;
        
        final int N = mActivityArray.size();
        for (int i=0; i<N; i++) {
            LocalActivityRecord r = mActivityArray.get(i);
            if ((r != null) && (r.activity != null)) {
                Object instance = r.activity.onRetainNonConfigurationInstance();
                if (instance != null) {
                    if (instanceMap == null) {
                        instanceMap = new HashMap<String,Object>();
                    }
                    instanceMap.put(r.id, instance);
                }
            }
        }
        return instanceMap;
    }

    /**
     * Remove all activities from this LocalActivityManager, performing an
     * {@link Activity#onDestroy} on any that are currently instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.433 -0500", hash_original_method = "430AC76EEFA93CEEF93A908E5EA7F34D", hash_generated_method = "5475561F052910F544652A5F13851A56")
    
public void removeAllActivities() {
        dispatchDestroy(true);
    }

    /**
     * Called by the container activity in its {@link Activity#onDestroy} so
     * that LocalActivityManager can perform the corresponding action on the
     * activities it holds.
     * 
     * @see Activity#onDestroy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:24.435 -0500", hash_original_method = "B2B8D2770115DF4D7579D9F1CB00CAA2", hash_generated_method = "1331549BB05532D676BF427989AB8847")
    
public void dispatchDestroy(boolean finishing) {
        final int N = mActivityArray.size();
        for (int i=0; i<N; i++) {
            LocalActivityRecord r = mActivityArray.get(i);
            if (localLOGV) Log.v(TAG, r.id + ": destroying");
            mActivityThread.performDestroyActivity(r, finishing);
        }
        mActivities.clear();
        mActivityArray.clear();
    }
}

