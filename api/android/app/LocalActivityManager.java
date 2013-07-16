package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.205 -0400", hash_original_field = "7EF90D5DA2994166B5492D71C1F03D41", hash_generated_field = "421BA2E15FA30D31BA5B63CB3A7B5B13")

    private ActivityThread mActivityThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.205 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "130E2721A67D8BF1BBFAC45B04E5FF8B")

    private Activity mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.206 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "86C367C360550C8AC8371A7EA31B7C59")

    private LocalActivityRecord mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.206 -0400", hash_original_field = "0833C3A14A2DB5DB7AA9AE27BC43FC3B", hash_generated_field = "3279D1193B59C6A27CDB22D771FB6A5E")

    private final Map<String, LocalActivityRecord> mActivities = new HashMap<String, LocalActivityRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.206 -0400", hash_original_field = "6C1CEA265626AF5F032912F771B8DDD8", hash_generated_field = "51D5888963C48B7E77E27D6489323908")

    private final ArrayList<LocalActivityRecord> mActivityArray = new ArrayList<LocalActivityRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.206 -0400", hash_original_field = "393A5CB6F38C86B61249037D93E02019", hash_generated_field = "0DD5EF490635B2544D1F4425BC363B4D")

    private boolean mSingleMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.206 -0400", hash_original_field = "D787ED250F201D4304D525D94F66E645", hash_generated_field = "72BBBF947B4E9BBAA7A265FAF6F263E0")

    private boolean mFinishing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.207 -0400", hash_original_field = "4B17DBAB1845CF65BB0CCBF2EDC3AC05", hash_generated_field = "56550F8D73862FCFD4D73681A0E5EBC0")

    private int mCurState = INITIALIZING;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.208 -0400", hash_original_method = "91223A19E58DDEF4278C27D9FB9EBEA3", hash_generated_method = "CA93C571C8C72C995063FD6E892CFE63")
    public  LocalActivityManager(Activity parent, boolean singleMode) {
        mActivityThread = ActivityThread.currentActivityThread();
        mParent = parent;
        mSingleMode = singleMode;
        // ---------- Original Method ----------
        //mActivityThread = ActivityThread.currentActivityThread();
        //mParent = parent;
        //mSingleMode = singleMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.214 -0400", hash_original_method = "B12896933A50085371F00492E36D4EA5", hash_generated_method = "F12E0349B73AB392CC89CF3C0B07C0E2")
    private void moveToState(LocalActivityRecord r, int desiredState) {
        addTaint(desiredState);
        addTaint(r.getTaint());
    if(r.curState == RESTORED || r.curState == DESTROYED)        
        {
            return;
        } //End block
    if(r.curState == INITIALIZING)        
        {
            HashMap<String, Object> lastNonConfigurationInstances = mParent.getLastNonConfigurationChildInstances();
            Object instanceObj = null;
    if(lastNonConfigurationInstances != null)            
            {
                instanceObj = lastNonConfigurationInstances.get(r.id);
            } //End block
            Activity.NonConfigurationInstances instance = null;
    if(instanceObj != null)            
            {
                instance = new Activity.NonConfigurationInstances();
                instance.activity = instanceObj;
            } //End block
    if(localLOGV){ }    if(r.activityInfo == null)            
            {
                r.activityInfo = mActivityThread.resolveActivityInfo(r.intent);
            } //End block
            r.activity = mActivityThread.startActivityNow(
                    mParent, r.id, r.intent, r.activityInfo, r, r.instanceState, instance);
    if(r.activity == null)            
            {
                return;
            } //End block
            r.window = r.activity.getWindow();
            r.instanceState = null;
            r.curState = STARTED;
    if(desiredState == RESUMED)            
            {
    if(localLOGV){ }                mActivityThread.performResumeActivity(r, true);
                r.curState = RESUMED;
            } //End block
            return;
        } //End block
switch(r.curState){
        case CREATED:
    if(desiredState == STARTED)        
        {
    if(localLOGV){ }            mActivityThread.performRestartActivity(r);
            r.curState = STARTED;
        } //End block
    if(desiredState == RESUMED)        
        {
    if(localLOGV){ }            mActivityThread.performRestartActivity(r);
            mActivityThread.performResumeActivity(r, true);
            r.curState = RESUMED;
        } //End block
        return;
        case STARTED:
    if(desiredState == RESUMED)        
        {
    if(localLOGV){ }            mActivityThread.performResumeActivity(r, true);
            r.instanceState = null;
            r.curState = RESUMED;
        } //End block
    if(desiredState == CREATED)        
        {
    if(localLOGV){ }            mActivityThread.performStopActivity(r, false);
            r.curState = CREATED;
        } //End block
        return;
        case RESUMED:
    if(desiredState == STARTED)        
        {
    if(localLOGV){ }            performPause(r, mFinishing);
            r.curState = STARTED;
        } //End block
    if(desiredState == CREATED)        
        {
    if(localLOGV){ }            performPause(r, mFinishing);
    if(localLOGV){ }            mActivityThread.performStopActivity(r, false);
            r.curState = CREATED;
        } //End block
        return;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.215 -0400", hash_original_method = "D6EC4953476E7D98493712A14D0E2C8F", hash_generated_method = "7B174F664367A8A3ED9410D8B85FA493")
    private void performPause(LocalActivityRecord r, boolean finishing) {
        addTaint(finishing);
        addTaint(r.getTaint());
        boolean needState = r.instanceState == null;
        Bundle instanceState = mActivityThread.performPauseActivity(r,
                finishing, needState);
    if(needState)        
        {
            r.instanceState = instanceState;
        } //End block
        // ---------- Original Method ----------
        //boolean needState = r.instanceState == null;
        //Bundle instanceState = mActivityThread.performPauseActivity(r,
                //finishing, needState);
        //if (needState) {
            //r.instanceState = instanceState;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.218 -0400", hash_original_method = "0A59627F0C289533278C9C6F1CF55EF3", hash_generated_method = "42B412C6433CC941932DE9CEB151F175")
    public Window startActivity(String id, Intent intent) {
        addTaint(intent.getTaint());
        addTaint(id.getTaint());
    if(mCurState == INITIALIZING)        
        {
            IllegalStateException varFDC55787E198DFC1F5952E4AF9F8CB12_1372813679 = new IllegalStateException(
                    "Activities can't be added until the containing group has been created.");
            varFDC55787E198DFC1F5952E4AF9F8CB12_1372813679.addTaint(taint);
            throw varFDC55787E198DFC1F5952E4AF9F8CB12_1372813679;
        } //End block
        boolean adding = false;
        boolean sameIntent = false;
        ActivityInfo aInfo = null;
        LocalActivityRecord r = mActivities.get(id);
    if(r == null)        
        {
            r = new LocalActivityRecord(id, intent);
            adding = true;
        } //End block
        else
    if(r.intent != null)        
        {
            sameIntent = r.intent.filterEquals(intent);
    if(sameIntent)            
            {
                aInfo = r.activityInfo;
            } //End block
        } //End block
    if(aInfo == null)        
        {
            aInfo = mActivityThread.resolveActivityInfo(intent);
        } //End block
    if(mSingleMode)        
        {
            LocalActivityRecord old = mResumed;
    if(old != null && old != r && mCurState == RESUMED)            
            {
                moveToState(old, STARTED);
            } //End block
        } //End block
    if(adding)        
        {
            mActivities.put(id, r);
            mActivityArray.add(r);
        } //End block
        else
    if(r.activityInfo != null)        
        {
    if(aInfo == r.activityInfo ||
                    (aInfo.name.equals(r.activityInfo.name) &&
                            aInfo.packageName.equals(r.activityInfo.packageName)))            
            {
    if(aInfo.launchMode != ActivityInfo.LAUNCH_MULTIPLE ||
                        (intent.getFlags()&Intent.FLAG_ACTIVITY_SINGLE_TOP) != 0)                
                {
                    ArrayList<Intent> intents = new ArrayList<Intent>(1);
                    intents.add(intent);
    if(localLOGV){ }                    mActivityThread.performNewIntents(r, intents);
                    r.intent = intent;
                    moveToState(r, mCurState);
    if(mSingleMode)                    
                    {
                        mResumed = r;
                    } //End block
Window var48B86E8FFA177D997A5C756A6FCAA4D0_506864517 =                     r.window;
                    var48B86E8FFA177D997A5C756A6FCAA4D0_506864517.addTaint(taint);
                    return var48B86E8FFA177D997A5C756A6FCAA4D0_506864517;
                } //End block
    if(sameIntent &&
                        (intent.getFlags()&Intent.FLAG_ACTIVITY_CLEAR_TOP) == 0)                
                {
                    r.intent = intent;
                    moveToState(r, mCurState);
    if(mSingleMode)                    
                    {
                        mResumed = r;
                    } //End block
Window var48B86E8FFA177D997A5C756A6FCAA4D0_534821140 =                     r.window;
                    var48B86E8FFA177D997A5C756A6FCAA4D0_534821140.addTaint(taint);
                    return var48B86E8FFA177D997A5C756A6FCAA4D0_534821140;
                } //End block
            } //End block
            performDestroy(r, true);
        } //End block
        r.intent = intent;
        r.curState = INITIALIZING;
        r.activityInfo = aInfo;
        moveToState(r, mCurState);
    if(mSingleMode)        
        {
            mResumed = r;
        } //End block
Window var48B86E8FFA177D997A5C756A6FCAA4D0_813548033 =         r.window;
        var48B86E8FFA177D997A5C756A6FCAA4D0_813548033.addTaint(taint);
        return var48B86E8FFA177D997A5C756A6FCAA4D0_813548033;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.220 -0400", hash_original_method = "9068A3C43CAB8D5C5EE5DD7E1741D6DA", hash_generated_method = "6F29A401C15B5EAE9BAC856A3320CE0B")
    private Window performDestroy(LocalActivityRecord r, boolean finish) {
        addTaint(finish);
        addTaint(r.getTaint());
        Window win;
        win = r.window;
    if(r.curState == RESUMED && !finish)        
        {
            performPause(r, finish);
        } //End block
    if(localLOGV){ }        mActivityThread.performDestroyActivity(r, finish);
        r.activity = null;
        r.window = null;
    if(finish)        
        {
            r.instanceState = null;
        } //End block
        r.curState = DESTROYED;
Window varEDD7B2DCFC39518AEE1744DBB03DF9FF_156410805 =         win;
        varEDD7B2DCFC39518AEE1744DBB03DF9FF_156410805.addTaint(taint);
        return varEDD7B2DCFC39518AEE1744DBB03DF9FF_156410805;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.221 -0400", hash_original_method = "BE481800D6C8FAA522EB6457C475667B", hash_generated_method = "168FA1D2C26032933488F9524E20C7C7")
    public Window destroyActivity(String id, boolean finish) {
        addTaint(finish);
        addTaint(id.getTaint());
        LocalActivityRecord r = mActivities.get(id);
        Window win = null;
    if(r != null)        
        {
            win = performDestroy(r, finish);
    if(finish)            
            {
                mActivities.remove(id);
                mActivityArray.remove(r);
            } //End block
        } //End block
Window varEDD7B2DCFC39518AEE1744DBB03DF9FF_237466515 =         win;
        varEDD7B2DCFC39518AEE1744DBB03DF9FF_237466515.addTaint(taint);
        return varEDD7B2DCFC39518AEE1744DBB03DF9FF_237466515;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.222 -0400", hash_original_method = "DDB5384220B4A60C69552CE8336AA299", hash_generated_method = "2B01F12B5A6BF0CBF12595399C44AB32")
    public Activity getCurrentActivity() {
Activity varE19544236484E5B0DC9FAEA2B920206B_2076894378 =         mResumed != null ? mResumed.activity : null;
        varE19544236484E5B0DC9FAEA2B920206B_2076894378.addTaint(taint);
        return varE19544236484E5B0DC9FAEA2B920206B_2076894378;
        // ---------- Original Method ----------
        //return mResumed != null ? mResumed.activity : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.222 -0400", hash_original_method = "4729520AC64C6CA5B20AE92550B34CDA", hash_generated_method = "C8454EDDBD5979A539C92C9DB76E48E5")
    public String getCurrentId() {
String var2FDA46E65C37C9EE8C9E00B555D28E22_656001903 =         mResumed != null ? mResumed.id : null;
        var2FDA46E65C37C9EE8C9E00B555D28E22_656001903.addTaint(taint);
        return var2FDA46E65C37C9EE8C9E00B555D28E22_656001903;
        // ---------- Original Method ----------
        //return mResumed != null ? mResumed.id : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.223 -0400", hash_original_method = "AAFBFF7BB86A9D1FFB973CDC0860D37E", hash_generated_method = "95192A337D7409CE7722B8BC16D8D34D")
    public Activity getActivity(String id) {
        addTaint(id.getTaint());
        LocalActivityRecord r = mActivities.get(id);
Activity var58139E1C236E1FCA1AFDE9E3968F4817_217264258 =         r != null ? r.activity : null;
        var58139E1C236E1FCA1AFDE9E3968F4817_217264258.addTaint(taint);
        return var58139E1C236E1FCA1AFDE9E3968F4817_217264258;
        // ---------- Original Method ----------
        //LocalActivityRecord r = mActivities.get(id);
        //return r != null ? r.activity : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.224 -0400", hash_original_method = "012D05327CF4F67BB20181F9A8D8EBE2", hash_generated_method = "CE0E945F5CBB1720FD071BAD30E6FE32")
    public void dispatchCreate(Bundle state) {
        addTaint(state.getTaint());
    if(state != null)        
        {
for(String id : state.keySet())
            {
                try 
                {
                    final Bundle astate = state.getBundle(id);
                    LocalActivityRecord r = mActivities.get(id);
    if(r != null)                    
                    {
                        r.instanceState = astate;
                    } //End block
                    else
                    {
                        r = new LocalActivityRecord(id, null);
                        r.instanceState = astate;
                        mActivities.put(id, r);
                        mActivityArray.add(r);
                    } //End block
                } //End block
                catch (Exception e)
                {
                } //End block
            } //End block
        } //End block
        mCurState = CREATED;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.225 -0400", hash_original_method = "5298101F1EDBDE2B5A84C3EFF961D34B", hash_generated_method = "05F94F7612384DACE36AC62FD23C62AE")
    public Bundle saveInstanceState() {
        Bundle state = null;
        final int N = mActivityArray.size();
for(int i=0;i<N;i++)
        {
            final LocalActivityRecord r = mActivityArray.get(i);
    if(state == null)            
            {
                state = new Bundle();
            } //End block
    if((r.instanceState != null || r.curState == RESUMED)
                    && r.activity != null)            
            {
                final Bundle childState = new Bundle();
                r.activity.performSaveInstanceState(childState);
                r.instanceState = childState;
            } //End block
    if(r.instanceState != null)            
            {
                state.putBundle(r.id, r.instanceState);
            } //End block
        } //End block
Bundle var37C56C9D63C623261861C16DCFB73F6D_1777714069 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1777714069.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1777714069;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.226 -0400", hash_original_method = "7718D5666C8415D1D9EF0CF84FCCE3FD", hash_generated_method = "D0FF45466E9F12344112BDAD8E8F2F22")
    public void dispatchResume() {
        mCurState = RESUMED;
    if(mSingleMode)        
        {
    if(mResumed != null)            
            {
                moveToState(mResumed, RESUMED);
            } //End block
        } //End block
        else
        {
            final int N = mActivityArray.size();
for(int i=0;i<N;i++)
            {
                moveToState(mActivityArray.get(i), RESUMED);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.227 -0400", hash_original_method = "85A6F8844A81DEE3E47CADEC5BC4757D", hash_generated_method = "FEF118FB53A5A171A9BF30231B0B7204")
    public void dispatchPause(boolean finishing) {
        addTaint(finishing);
    if(finishing)        
        {
            mFinishing = true;
        } //End block
        mCurState = STARTED;
    if(mSingleMode)        
        {
    if(mResumed != null)            
            {
                moveToState(mResumed, STARTED);
            } //End block
        } //End block
        else
        {
            final int N = mActivityArray.size();
for(int i=0;i<N;i++)
            {
                LocalActivityRecord r = mActivityArray.get(i);
    if(r.curState == RESUMED)                
                {
                    moveToState(r, STARTED);
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.229 -0400", hash_original_method = "E93631F1674DB507A27EE53DB47C2CFE", hash_generated_method = "5AF815D976C5D655923F3F9DF8BF52C7")
    public void dispatchStop() {
        mCurState = CREATED;
        final int N = mActivityArray.size();
for(int i=0;i<N;i++)
        {
            LocalActivityRecord r = mActivityArray.get(i);
            moveToState(r, CREATED);
        } //End block
        // ---------- Original Method ----------
        //mCurState = CREATED;
        //final int N = mActivityArray.size();
        //for (int i=0; i<N; i++) {
            //LocalActivityRecord r = mActivityArray.get(i);
            //moveToState(r, CREATED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.230 -0400", hash_original_method = "070B049D0EB630832F296616C02C666D", hash_generated_method = "C55355C4DC1353E97A8CBC8D8F0ABE64")
    public HashMap<String,Object> dispatchRetainNonConfigurationInstance() {
        HashMap<String,Object> instanceMap = null;
        final int N = mActivityArray.size();
for(int i=0;i<N;i++)
        {
            LocalActivityRecord r = mActivityArray.get(i);
    if((r != null) && (r.activity != null))            
            {
                Object instance = r.activity.onRetainNonConfigurationInstance();
    if(instance != null)                
                {
    if(instanceMap == null)                    
                    {
                        instanceMap = new HashMap<String,Object>();
                    } //End block
                    instanceMap.put(r.id, instance);
                } //End block
            } //End block
        } //End block
HashMap<String,Object> var827B7F1D928BBF862EF323B8FA47F73C_325164770 =         instanceMap;
        var827B7F1D928BBF862EF323B8FA47F73C_325164770.addTaint(taint);
        return var827B7F1D928BBF862EF323B8FA47F73C_325164770;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.231 -0400", hash_original_method = "430AC76EEFA93CEEF93A908E5EA7F34D", hash_generated_method = "3A4DA8DA5947061AF99B48F41BC8F89F")
    public void removeAllActivities() {
        dispatchDestroy(true);
        // ---------- Original Method ----------
        //dispatchDestroy(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.232 -0400", hash_original_method = "B2B8D2770115DF4D7579D9F1CB00CAA2", hash_generated_method = "6721BB940813CEB5BF1B47AA2D9EC47D")
    public void dispatchDestroy(boolean finishing) {
        addTaint(finishing);
        final int N = mActivityArray.size();
for(int i=0;i<N;i++)
        {
            LocalActivityRecord r = mActivityArray.get(i);
    if(localLOGV){ }            mActivityThread.performDestroyActivity(r, finishing);
        } //End block
        mActivities.clear();
        mActivityArray.clear();
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.233 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "960D0AAB4FA1CF92AEC1F360608BDEE3")

        String id;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.233 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.234 -0400", hash_original_field = "D189E59358BD9D02DDCA24FC5ED15564", hash_generated_field = "9CFCA1B7F8752ABB79A9EED9367C413A")

        ActivityInfo activityInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.234 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "A63B0916BD4AC2611D1AF746A2DF045C")

        Activity activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.234 -0400", hash_original_field = "05B8C74CBD96FBF2DE4C1A352702FBF4", hash_generated_field = "C8345ED8E0FB49346B128B9846AFDDB2")

        Window window;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.235 -0400", hash_original_field = "06C66EE96790DDD78972EC0CDAFFD64B", hash_generated_field = "F4B69932E4B52B5DB7DD5C9BD2D7B407")

        Bundle instanceState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.235 -0400", hash_original_field = "44E6D71A116525FC588F63D6E8C41B70", hash_generated_field = "6D133C9482705F97D3CEA539075FF242")

        int curState = RESTORED;
        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.236 -0400", hash_original_method = "E1D83503B31583A6BAE5696926B0F492", hash_generated_method = "102BDDA6481BC598610972B4C2EC5CBD")
          LocalActivityRecord(String _id, Intent _intent) {
            id = _id;
            intent = _intent;
            // ---------- Original Method ----------
            //id = _id;
            //intent = _intent;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.237 -0400", hash_original_field = "83EA09192E0C282E2EE25C2995B328BB", hash_generated_field = "51C71CC685F225C3ECFF2ACB9029A01F")

    private static final String TAG = "LocalActivityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.237 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "761D2619615A389BF902F171CC86D6A4")

    private static final boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.237 -0400", hash_original_field = "DE23D3AA8471CD4DDA012207F0D50709", hash_generated_field = "FB094120D71B6E47F4CCD5880F183955")

    static final int RESTORED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.237 -0400", hash_original_field = "4F895127A3A22BBA182ACBEB79FC5CFC", hash_generated_field = "482EFBA42C6E2CFF17C7C88620EE2AE7")

    static final int INITIALIZING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.238 -0400", hash_original_field = "D2E10AAAA5735CF15EBCA4B42956602D", hash_generated_field = "79EC126748439AA2A44FDF8D6ED403DD")

    static final int CREATED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.238 -0400", hash_original_field = "F63885AC73DC066964A0D8FBBF99F4F2", hash_generated_field = "32314BE6D22C0FBFEE57366A48F24AEF")

    static final int STARTED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.238 -0400", hash_original_field = "6FD312330E9A73FE8BF601E49D23FE90", hash_generated_field = "CDB8768200B5FB0298BB9334F431B4E6")

    static final int RESUMED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.238 -0400", hash_original_field = "ADEAA8410EE7B6B6683433F7946A3920", hash_generated_field = "5019021A5B3C4386BCA1F34395386874")

    static final int DESTROYED = 5;
}

