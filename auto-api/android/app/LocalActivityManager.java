package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalActivityManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.768 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "421BA2E15FA30D31BA5B63CB3A7B5B13")

    private ActivityThread mActivityThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.768 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "130E2721A67D8BF1BBFAC45B04E5FF8B")

    private Activity mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.769 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "86C367C360550C8AC8371A7EA31B7C59")

    private LocalActivityRecord mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.769 -0400", hash_original_field = "0833C3A14A2DB5DB7AA9AE27BC43FC3B", hash_generated_field = "8F1EE3677EBFE40762A4CAE819EF8E03")

    private Map<String, LocalActivityRecord> mActivities = new HashMap<String, LocalActivityRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.787 -0400", hash_original_field = "6C1CEA265626AF5F032912F771B8DDD8", hash_generated_field = "1DC63AB1B203FC241AAF8567DAD24A66")

    private ArrayList<LocalActivityRecord> mActivityArray = new ArrayList<LocalActivityRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.787 -0400", hash_original_field = "393A5CB6F38C86B61249037D93E02019", hash_generated_field = "0DD5EF490635B2544D1F4425BC363B4D")

    private boolean mSingleMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.788 -0400", hash_original_field = "D787ED250F201D4304D525D94F66E645", hash_generated_field = "72BBBF947B4E9BBAA7A265FAF6F263E0")

    private boolean mFinishing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.788 -0400", hash_original_field = "4B17DBAB1845CF65BB0CCBF2EDC3AC05", hash_generated_field = "56550F8D73862FCFD4D73681A0E5EBC0")

    private int mCurState = INITIALIZING;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.809 -0400", hash_original_method = "91223A19E58DDEF4278C27D9FB9EBEA3", hash_generated_method = "CA93C571C8C72C995063FD6E892CFE63")
    public  LocalActivityManager(Activity parent, boolean singleMode) {
        mActivityThread = ActivityThread.currentActivityThread();
        mParent = parent;
        mSingleMode = singleMode;
        // ---------- Original Method ----------
        //mActivityThread = ActivityThread.currentActivityThread();
        //mParent = parent;
        //mSingleMode = singleMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.900 -0400", hash_original_method = "B12896933A50085371F00492E36D4EA5", hash_generated_method = "B86DDCC3A7FEE6D6A00F1FF4774707F4")
    private void moveToState(LocalActivityRecord r, int desiredState) {
        {
            HashMap<String, Object> lastNonConfigurationInstances;
            lastNonConfigurationInstances = mParent.getLastNonConfigurationChildInstances();
            Object instanceObj;
            instanceObj = null;
            {
                instanceObj = lastNonConfigurationInstances.get(r.id);
            } //End block
            Activity.NonConfigurationInstances instance;
            instance = null;
            {
                instance = new Activity.NonConfigurationInstances();
                instance.activity = instanceObj;
            } //End block
            {
                r.activityInfo = mActivityThread.resolveActivityInfo(r.intent);
            } //End block
            r.activity = mActivityThread.startActivityNow(
                    mParent, r.id, r.intent, r.activityInfo, r, r.instanceState, instance);
            r.window = r.activity.getWindow();
            r.instanceState = null;
            r.curState = STARTED;
            {
                mActivityThread.performResumeActivity(r, true);
                r.curState = RESUMED;
            } //End block
        } //End block
        //Begin case CREATED 
        {
            mActivityThread.performRestartActivity(r);
            r.curState = STARTED;
        } //End block
        //End case CREATED 
        //Begin case CREATED 
        {
            mActivityThread.performRestartActivity(r);
            mActivityThread.performResumeActivity(r, true);
            r.curState = RESUMED;
        } //End block
        //End case CREATED 
        //Begin case STARTED 
        {
            mActivityThread.performResumeActivity(r, true);
            r.instanceState = null;
            r.curState = RESUMED;
        } //End block
        //End case STARTED 
        //Begin case STARTED 
        {
            mActivityThread.performStopActivity(r, false);
            r.curState = CREATED;
        } //End block
        //End case STARTED 
        //Begin case RESUMED 
        {
            performPause(r, mFinishing);
            r.curState = STARTED;
        } //End block
        //End case RESUMED 
        //Begin case RESUMED 
        {
            performPause(r, mFinishing);
            mActivityThread.performStopActivity(r, false);
            r.curState = CREATED;
        } //End block
        //End case RESUMED 
        addTaint(r.getTaint());
        addTaint(desiredState);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:50.915 -0400", hash_original_method = "D6EC4953476E7D98493712A14D0E2C8F", hash_generated_method = "75A550FD9109123928FFDB200692C0DE")
    private void performPause(LocalActivityRecord r, boolean finishing) {
        boolean needState;
        needState = r.instanceState == null;
        Bundle instanceState;
        instanceState = mActivityThread.performPauseActivity(r,
                finishing, needState);
        {
            r.instanceState = instanceState;
        } //End block
        addTaint(r.getTaint());
        addTaint(finishing);
        // ---------- Original Method ----------
        //boolean needState = r.instanceState == null;
        //Bundle instanceState = mActivityThread.performPauseActivity(r,
                //finishing, needState);
        //if (needState) {
            //r.instanceState = instanceState;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.019 -0400", hash_original_method = "0A59627F0C289533278C9C6F1CF55EF3", hash_generated_method = "3F18EE57FD985E098252ACD07AD96BA8")
    public Window startActivity(String id, Intent intent) {
        Window varB4EAC82CA7396A68D541C85D26508E83_193775336 = null; //Variable for return #1
        Window varB4EAC82CA7396A68D541C85D26508E83_1888225902 = null; //Variable for return #2
        Window varB4EAC82CA7396A68D541C85D26508E83_803838630 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Activities can't be added until the containing group has been created.");
        } //End block
        boolean adding;
        adding = false;
        boolean sameIntent;
        sameIntent = false;
        ActivityInfo aInfo;
        aInfo = null;
        LocalActivityRecord r;
        r = mActivities.get(id);
        {
            r = new LocalActivityRecord(id, intent);
            adding = true;
        } //End block
        {
            sameIntent = r.intent.filterEquals(intent);
            {
                aInfo = r.activityInfo;
            } //End block
        } //End block
        {
            aInfo = mActivityThread.resolveActivityInfo(intent);
        } //End block
        {
            LocalActivityRecord old;
            old = mResumed;
            {
                moveToState(old, STARTED);
            } //End block
        } //End block
        {
            mActivities.put(id, r);
            mActivityArray.add(r);
        } //End block
        {
            {
                boolean var3AF418AE03930BF4B5AC7F4EFFD6C8F8_1802321956 = (aInfo == r.activityInfo ||
                    (aInfo.name.equals(r.activityInfo.name) &&
                            aInfo.packageName.equals(r.activityInfo.packageName)));
                {
                    {
                        boolean varE7665EB95381187563B763CB79320605_1496276214 = (aInfo.launchMode != ActivityInfo.LAUNCH_MULTIPLE ||
                        (intent.getFlags()&Intent.FLAG_ACTIVITY_SINGLE_TOP) != 0);
                        {
                            ArrayList<Intent> intents;
                            intents = new ArrayList<Intent>(1);
                            intents.add(intent);
                            mActivityThread.performNewIntents(r, intents);
                            r.intent = intent;
                            moveToState(r, mCurState);
                            {
                                mResumed = r;
                            } //End block
                            varB4EAC82CA7396A68D541C85D26508E83_193775336 = r.window;
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var2867490B298E0AA2AA6B22C988E5A180_1465229759 = (sameIntent &&
                        (intent.getFlags()&Intent.FLAG_ACTIVITY_CLEAR_TOP) == 0);
                        {
                            r.intent = intent;
                            moveToState(r, mCurState);
                            {
                                mResumed = r;
                            } //End block
                            varB4EAC82CA7396A68D541C85D26508E83_1888225902 = r.window;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            performDestroy(r, true);
        } //End block
        r.intent = intent;
        r.curState = INITIALIZING;
        r.activityInfo = aInfo;
        moveToState(r, mCurState);
        {
            mResumed = r;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_803838630 = r.window;
        addTaint(id.getTaint());
        addTaint(intent.getTaint());
        Window varA7E53CE21691AB073D9660D615818899_806548996; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_806548996 = varB4EAC82CA7396A68D541C85D26508E83_193775336;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_806548996 = varB4EAC82CA7396A68D541C85D26508E83_1888225902;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_806548996 = varB4EAC82CA7396A68D541C85D26508E83_803838630;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_806548996.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_806548996;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.023 -0400", hash_original_method = "9068A3C43CAB8D5C5EE5DD7E1741D6DA", hash_generated_method = "411CA44A621331CDE9434B8CAE58FE5F")
    private Window performDestroy(LocalActivityRecord r, boolean finish) {
        Window varB4EAC82CA7396A68D541C85D26508E83_2021051873 = null; //Variable for return #1
        Window win;
        win = r.window;
        {
            performPause(r, finish);
        } //End block
        mActivityThread.performDestroyActivity(r, finish);
        r.activity = null;
        r.window = null;
        {
            r.instanceState = null;
        } //End block
        r.curState = DESTROYED;
        varB4EAC82CA7396A68D541C85D26508E83_2021051873 = win;
        addTaint(r.getTaint());
        addTaint(finish);
        varB4EAC82CA7396A68D541C85D26508E83_2021051873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021051873;
        // ---------- Original Method ----------
        //Window win;
        //win = r.window;
        //if (r.curState == RESUMED && !finish) {
            //performPause(r, finish);
        //}
        //if (localLOGV) Log.v(TAG, r.id + ": destroying");
        //mActivityThread.performDestroyActivity(r, finish);
        //r.activity = null;
        //r.window = null;
        //if (finish) {
            //r.instanceState = null;
        //}
        //r.curState = DESTROYED;
        //return win;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.044 -0400", hash_original_method = "BE481800D6C8FAA522EB6457C475667B", hash_generated_method = "4373603EA99280C2B57C3991F5894259")
    public Window destroyActivity(String id, boolean finish) {
        Window varB4EAC82CA7396A68D541C85D26508E83_402455125 = null; //Variable for return #1
        LocalActivityRecord r;
        r = mActivities.get(id);
        Window win;
        win = null;
        {
            win = performDestroy(r, finish);
            {
                mActivities.remove(id);
                mActivityArray.remove(r);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_402455125 = win;
        addTaint(id.getTaint());
        addTaint(finish);
        varB4EAC82CA7396A68D541C85D26508E83_402455125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_402455125;
        // ---------- Original Method ----------
        //LocalActivityRecord r = mActivities.get(id);
        //Window win = null;
        //if (r != null) {
            //win = performDestroy(r, finish);
            //if (finish) {
                //mActivities.remove(id);
                //mActivityArray.remove(r);
            //}
        //}
        //return win;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.052 -0400", hash_original_method = "DDB5384220B4A60C69552CE8336AA299", hash_generated_method = "5EE281A6BF13F92B2F4B5115E3C28D0A")
    public Activity getCurrentActivity() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_247034212 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_247034212 = mResumed != null ? mResumed.activity : null;
        varB4EAC82CA7396A68D541C85D26508E83_247034212.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_247034212;
        // ---------- Original Method ----------
        //return mResumed != null ? mResumed.activity : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.080 -0400", hash_original_method = "4729520AC64C6CA5B20AE92550B34CDA", hash_generated_method = "2A18DF46D768ABE0AAE1140779CDBAE4")
    public String getCurrentId() {
        String varB4EAC82CA7396A68D541C85D26508E83_93039385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_93039385 = mResumed != null ? mResumed.id : null;
        varB4EAC82CA7396A68D541C85D26508E83_93039385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93039385;
        // ---------- Original Method ----------
        //return mResumed != null ? mResumed.id : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.092 -0400", hash_original_method = "AAFBFF7BB86A9D1FFB973CDC0860D37E", hash_generated_method = "D6540924DF7A131069FFC0D94689556B")
    public Activity getActivity(String id) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1801316850 = null; //Variable for return #1
        LocalActivityRecord r;
        r = mActivities.get(id);
        varB4EAC82CA7396A68D541C85D26508E83_1801316850 = r != null ? r.activity : null;
        addTaint(id.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1801316850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1801316850;
        // ---------- Original Method ----------
        //LocalActivityRecord r = mActivities.get(id);
        //return r != null ? r.activity : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.520 -0400", hash_original_method = "012D05327CF4F67BB20181F9A8D8EBE2", hash_generated_method = "1D03ABDCE43BB1C93FF1D9ECB1C8B486")
    public void dispatchCreate(Bundle state) {
        {
            {
                Iterator<String> var7D8942AD40EC7B984421A58B76077F0C_1245192463 = (state.keySet()).iterator();
                var7D8942AD40EC7B984421A58B76077F0C_1245192463.hasNext();
                String id = var7D8942AD40EC7B984421A58B76077F0C_1245192463.next();
                {
                    try 
                    {
                        Bundle astate;
                        astate = state.getBundle(id);
                        LocalActivityRecord r;
                        r = mActivities.get(id);
                        {
                            r.instanceState = astate;
                        } //End block
                        {
                            r = new LocalActivityRecord(id, null);
                            r.instanceState = astate;
                            mActivities.put(id, r);
                            mActivityArray.add(r);
                        } //End block
                    } //End block
                    catch (Exception e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        mCurState = CREATED;
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //if (state != null) {
            //for (String id : state.keySet()) {
                //try {
                    //final Bundle astate = state.getBundle(id);
                    //LocalActivityRecord r = mActivities.get(id);
                    //if (r != null) {
                        //r.instanceState = astate;
                    //} else {
                        //r = new LocalActivityRecord(id, null);
                        //r.instanceState = astate;
                        //mActivities.put(id, r);
                        //mActivityArray.add(r);
                    //}
                //} catch (Exception e) {
                    //Log.e(TAG, "Exception thrown when restoring LocalActivityManager state", e);
                //}
            //}
        //}
        //mCurState = CREATED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.547 -0400", hash_original_method = "5298101F1EDBDE2B5A84C3EFF961D34B", hash_generated_method = "4676D434DCD94F78193F53DB07BF197A")
    public Bundle saveInstanceState() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1374836857 = null; //Variable for return #1
        Bundle state;
        state = null;
        int N;
        N = mActivityArray.size();
        {
            int i;
            i = 0;
            {
                LocalActivityRecord r;
                r = mActivityArray.get(i);
                {
                    state = new Bundle();
                } //End block
                {
                    Bundle childState;
                    childState = new Bundle();
                    r.activity.performSaveInstanceState(childState);
                    r.instanceState = childState;
                } //End block
                {
                    state.putBundle(r.id, r.instanceState);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1374836857 = state;
        varB4EAC82CA7396A68D541C85D26508E83_1374836857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1374836857;
        // ---------- Original Method ----------
        //Bundle state = null;
        //final int N = mActivityArray.size();
        //for (int i=0; i<N; i++) {
            //final LocalActivityRecord r = mActivityArray.get(i);
            //if (state == null) {
                //state = new Bundle();
            //}
            //if ((r.instanceState != null || r.curState == RESUMED)
                    //&& r.activity != null) {
                //final Bundle childState = new Bundle();
                //r.activity.performSaveInstanceState(childState);
                //r.instanceState = childState;
            //}
            //if (r.instanceState != null) {
                //state.putBundle(r.id, r.instanceState);
            //}
        //}
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.562 -0400", hash_original_method = "7718D5666C8415D1D9EF0CF84FCCE3FD", hash_generated_method = "C87DF94DC89D287F30E004EB74F1012A")
    public void dispatchResume() {
        mCurState = RESUMED;
        {
            {
                moveToState(mResumed, RESUMED);
            } //End block
        } //End block
        {
            int N;
            N = mActivityArray.size();
            {
                int i;
                i = 0;
                {
                    moveToState(mActivityArray.get(i), RESUMED);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //mCurState = RESUMED;
        //if (mSingleMode) {
            //if (mResumed != null) {
                //moveToState(mResumed, RESUMED);
            //}
        //} else {
            //final int N = mActivityArray.size();
            //for (int i=0; i<N; i++) {
                //moveToState(mActivityArray.get(i), RESUMED);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.574 -0400", hash_original_method = "85A6F8844A81DEE3E47CADEC5BC4757D", hash_generated_method = "E1A5EF7DD41ED32D954EE963DBE2A69A")
    public void dispatchPause(boolean finishing) {
        {
            mFinishing = true;
        } //End block
        mCurState = STARTED;
        {
            {
                moveToState(mResumed, STARTED);
            } //End block
        } //End block
        {
            int N;
            N = mActivityArray.size();
            {
                int i;
                i = 0;
                {
                    LocalActivityRecord r;
                    r = mActivityArray.get(i);
                    {
                        moveToState(r, STARTED);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(finishing);
        // ---------- Original Method ----------
        //if (finishing) {
            //mFinishing = true;
        //}
        //mCurState = STARTED;
        //if (mSingleMode) {
            //if (mResumed != null) {
                //moveToState(mResumed, STARTED);
            //}
        //} else {
            //final int N = mActivityArray.size();
            //for (int i=0; i<N; i++) {
                //LocalActivityRecord r = mActivityArray.get(i);
                //if (r.curState == RESUMED) {
                    //moveToState(r, STARTED);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.599 -0400", hash_original_method = "E93631F1674DB507A27EE53DB47C2CFE", hash_generated_method = "5C4D7FA035DD60D10EB8BEE00486AEA6")
    public void dispatchStop() {
        mCurState = CREATED;
        int N;
        N = mActivityArray.size();
        {
            int i;
            i = 0;
            {
                LocalActivityRecord r;
                r = mActivityArray.get(i);
                moveToState(r, CREATED);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mCurState = CREATED;
        //final int N = mActivityArray.size();
        //for (int i=0; i<N; i++) {
            //LocalActivityRecord r = mActivityArray.get(i);
            //moveToState(r, CREATED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.617 -0400", hash_original_method = "070B049D0EB630832F296616C02C666D", hash_generated_method = "2F030069F4CEF7BC567A1D769FF835F4")
    public HashMap<String,Object> dispatchRetainNonConfigurationInstance() {
        HashMap<String,Object> varB4EAC82CA7396A68D541C85D26508E83_1750392160 = null; //Variable for return #1
        HashMap<String,Object> instanceMap;
        instanceMap = null;
        int N;
        N = mActivityArray.size();
        {
            int i;
            i = 0;
            {
                LocalActivityRecord r;
                r = mActivityArray.get(i);
                {
                    Object instance;
                    instance = r.activity.onRetainNonConfigurationInstance();
                    {
                        {
                            instanceMap = new HashMap<String,Object>();
                        } //End block
                        instanceMap.put(r.id, instance);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1750392160 = instanceMap;
        varB4EAC82CA7396A68D541C85D26508E83_1750392160.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1750392160;
        // ---------- Original Method ----------
        //HashMap<String,Object> instanceMap = null;
        //final int N = mActivityArray.size();
        //for (int i=0; i<N; i++) {
            //LocalActivityRecord r = mActivityArray.get(i);
            //if ((r != null) && (r.activity != null)) {
                //Object instance = r.activity.onRetainNonConfigurationInstance();
                //if (instance != null) {
                    //if (instanceMap == null) {
                        //instanceMap = new HashMap<String,Object>();
                    //}
                    //instanceMap.put(r.id, instance);
                //}
            //}
        //}
        //return instanceMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.619 -0400", hash_original_method = "430AC76EEFA93CEEF93A908E5EA7F34D", hash_generated_method = "3A4DA8DA5947061AF99B48F41BC8F89F")
    public void removeAllActivities() {
        dispatchDestroy(true);
        // ---------- Original Method ----------
        //dispatchDestroy(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.649 -0400", hash_original_method = "B2B8D2770115DF4D7579D9F1CB00CAA2", hash_generated_method = "10B153D5121B302BC550AD4FD5A2CB17")
    public void dispatchDestroy(boolean finishing) {
        int N;
        N = mActivityArray.size();
        {
            int i;
            i = 0;
            {
                LocalActivityRecord r;
                r = mActivityArray.get(i);
                mActivityThread.performDestroyActivity(r, finishing);
            } //End block
        } //End collapsed parenthetic
        mActivities.clear();
        mActivityArray.clear();
        addTaint(finishing);
        // ---------- Original Method ----------
        //final int N = mActivityArray.size();
        //for (int i=0; i<N; i++) {
            //LocalActivityRecord r = mActivityArray.get(i);
            //if (localLOGV) Log.v(TAG, r.id + ": destroying");
            //mActivityThread.performDestroyActivity(r, finishing);
        //}
        //mActivities.clear();
        //mActivityArray.clear();
    }

    
    private static class LocalActivityRecord extends Binder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.650 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "960D0AAB4FA1CF92AEC1F360608BDEE3")

        String id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.663 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.663 -0400", hash_original_field = "D189E59358BD9D02DDCA24FC5ED15564", hash_generated_field = "9CFCA1B7F8752ABB79A9EED9367C413A")

        ActivityInfo activityInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.667 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "A63B0916BD4AC2611D1AF746A2DF045C")

        Activity activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.667 -0400", hash_original_field = "05B8C74CBD96FBF2DE4C1A352702FBF4", hash_generated_field = "C8345ED8E0FB49346B128B9846AFDDB2")

        Window window;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.668 -0400", hash_original_field = "06C66EE96790DDD78972EC0CDAFFD64B", hash_generated_field = "F4B69932E4B52B5DB7DD5C9BD2D7B407")

        Bundle instanceState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.668 -0400", hash_original_field = "44E6D71A116525FC588F63D6E8C41B70", hash_generated_field = "6D133C9482705F97D3CEA539075FF242")

        int curState = RESTORED;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.691 -0400", hash_original_method = "E1D83503B31583A6BAE5696926B0F492", hash_generated_method = "102BDDA6481BC598610972B4C2EC5CBD")
          LocalActivityRecord(String _id, Intent _intent) {
            id = _id;
            intent = _intent;
            // ---------- Original Method ----------
            //id = _id;
            //intent = _intent;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.692 -0400", hash_original_field = "83EA09192E0C282E2EE25C2995B328BB", hash_generated_field = "561B8A558D3A42C3B33C04580A3E9F98")

    private static String TAG = "LocalActivityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.692 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.702 -0400", hash_original_field = "DE23D3AA8471CD4DDA012207F0D50709", hash_generated_field = "0B2DA7319143ACD26A29A21C9AC527B7")

    static int RESTORED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.703 -0400", hash_original_field = "4F895127A3A22BBA182ACBEB79FC5CFC", hash_generated_field = "A15A7CA86386F089167CF88F0D9B4111")

    static int INITIALIZING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.703 -0400", hash_original_field = "D2E10AAAA5735CF15EBCA4B42956602D", hash_generated_field = "A25AD14CA9FE52D634195F0634EFB329")

    static int CREATED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.704 -0400", hash_original_field = "F63885AC73DC066964A0D8FBBF99F4F2", hash_generated_field = "4B730B9DC872DBA84529B08F41A05759")

    static int STARTED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.722 -0400", hash_original_field = "6FD312330E9A73FE8BF601E49D23FE90", hash_generated_field = "2830E66123A7879F3EA7767096C7EDF4")

    static int RESUMED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.723 -0400", hash_original_field = "ADEAA8410EE7B6B6683433F7946A3920", hash_generated_field = "B0109FAF45ACCA3A97490CED2617F281")

    static int DESTROYED = 5;
}

