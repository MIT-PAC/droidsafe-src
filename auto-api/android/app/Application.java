package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;

public class Application extends ContextWrapper implements ComponentCallbacks2 {
    private ArrayList<ComponentCallbacks> mComponentCallbacks =
            new ArrayList<ComponentCallbacks>();
    private ArrayList<ActivityLifecycleCallbacks> mActivityLifecycleCallbacks =
            new ArrayList<ActivityLifecycleCallbacks>();
    public LoadedApk mLoadedApk;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.520 -0400", hash_original_method = "C931B33981954029459F423E4A87FAC0", hash_generated_method = "7C12002EA4BAD91EC04D0ADCB77C2679")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Application() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.521 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "7564C9BAB223A8E7FAC043FBCC648B76")
    @DSModeled(DSC.SAFE)
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.521 -0400", hash_original_method = "9A007B9204A4409A01090B4582DB84FC", hash_generated_method = "85299B4BE1512429EABA91F15A3B99D5")
    @DSModeled(DSC.SAFE)
    public void onTerminate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.524 -0400", hash_original_method = "2D485B4C1AE5E3664AA314F747191250", hash_generated_method = "1AB1CE786F2DD7745E8C2F8BFC96B7D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        Object[] callbacks;
        callbacks = collectComponentCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    ((ComponentCallbacks)callbacks[i]).onConfigurationChanged(newConfig);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectComponentCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ComponentCallbacks)callbacks[i]).onConfigurationChanged(newConfig);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.524 -0400", hash_original_method = "32ED3A67A5037221704DD520024E5B9C", hash_generated_method = "80A307DFBE4426AE9096CFC2D6354354")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object[] callbacks;
        callbacks = collectComponentCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    ((ComponentCallbacks)callbacks[i]).onLowMemory();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectComponentCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ComponentCallbacks)callbacks[i]).onLowMemory();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.525 -0400", hash_original_method = "5BCB587BF7423BC0B6C7061FE2EAADB1", hash_generated_method = "75D6B257E6F349E822DB75A8259AFAD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        Object[] callbacks;
        callbacks = collectComponentCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    Object c;
                    c = callbacks[i];
                    {
                        ((ComponentCallbacks2)c).onTrimMemory(level);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectComponentCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //Object c = callbacks[i];
                //if (c instanceof ComponentCallbacks2) {
                    //((ComponentCallbacks2)c).onTrimMemory(level);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.526 -0400", hash_original_method = "999C2BA374DE68751A0CA6FB69F492E4", hash_generated_method = "85AB91AB9A73E712DD376F3D544FA0D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(callback.dsTaint);
        {
            mComponentCallbacks.add(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mComponentCallbacks) {
            //mComponentCallbacks.add(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.526 -0400", hash_original_method = "01F19973468E375E5E76C4BC0EA13BD8", hash_generated_method = "F0B4FFE45886BE7CB8067EB4C13B9DE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            mComponentCallbacks.remove(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mComponentCallbacks) {
            //mComponentCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.527 -0400", hash_original_method = "E08A3F54F3A8B985B7290C2DDF6D4A2E", hash_generated_method = "52FAC8B985B3323650CDB3561CE30BCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(callback.dsTaint);
        {
            mActivityLifecycleCallbacks.add(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mActivityLifecycleCallbacks) {
            //mActivityLifecycleCallbacks.add(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.527 -0400", hash_original_method = "3537E943E5CD5EE71FF990B3E6F24A93", hash_generated_method = "8218920DDF4B2A995A4E7380EE3A3E70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            mActivityLifecycleCallbacks.remove(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mActivityLifecycleCallbacks) {
            //mActivityLifecycleCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.528 -0400", hash_original_method = "A1FD1227D92B45F25B0D2B23D5D98DA3", hash_generated_method = "9D04D5D6E691E14B1910078D71268F6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void attach(Context context) {
        dsTaint.addTaint(context.dsTaint);
        attachBaseContext(context);
        mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
        // ---------- Original Method ----------
        //attachBaseContext(context);
        //mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.528 -0400", hash_original_method = "2B96BC83E264258C9DA658E6486A0ADA", hash_generated_method = "47B24C40089FC95934BAC3E037754E2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivityCreated(Activity activity, Bundle savedInstanceState) {
        dsTaint.addTaint(savedInstanceState.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        Object[] callbacks;
        callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityCreated(activity,
                        savedInstanceState);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityCreated(activity,
                        //savedInstanceState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.529 -0400", hash_original_method = "BB2CB10BE5DA2456D7FFED5329EAA067", hash_generated_method = "78F53F517D7C602375D98A2F61AB8841")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivityStarted(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        Object[] callbacks;
        callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityStarted(activity);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityStarted(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.530 -0400", hash_original_method = "7639D676E3D6026BF188B6D74D0066A2", hash_generated_method = "7D10A0948B26061CC0738DD66A52506C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivityResumed(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        Object[] callbacks;
        callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityResumed(activity);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityResumed(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.531 -0400", hash_original_method = "5DB331CA50D721A0DDEB1A6DEFCCACF3", hash_generated_method = "50B1E0A863230549E032A9B86CA0F61A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivityPaused(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        Object[] callbacks;
        callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityPaused(activity);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityPaused(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.531 -0400", hash_original_method = "F8E6CA2DBF83F739D06FE3A12F2BF88C", hash_generated_method = "EF01189B11E8406BC984C889A36C6583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivityStopped(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        Object[] callbacks;
        callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityStopped(activity);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityStopped(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.532 -0400", hash_original_method = "B5ED6DC4BA8E7805F8F571CEAE93D7B1", hash_generated_method = "A4E292008E28A54782DCB1DF2F4741ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivitySaveInstanceState(Activity activity, Bundle outState) {
        dsTaint.addTaint(outState.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        Object[] callbacks;
        callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivitySaveInstanceState(activity,
                        outState);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivitySaveInstanceState(activity,
                        //outState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.533 -0400", hash_original_method = "53A653C273347AA10BEB59307E30D6C5", hash_generated_method = "2BBEFCB4F51D4089FDF3DF394BC84746")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchActivityDestroyed(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        Object[] callbacks;
        callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i;
                i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityDestroyed(activity);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityDestroyed(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.533 -0400", hash_original_method = "324DD85B066E69EB73C73FA0F3E95B35", hash_generated_method = "035A12DB1AEFA6EC15731D9DB623A8D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object[] collectComponentCallbacks() {
        Object[] callbacks;
        callbacks = null;
        {
            {
                boolean var38B7DE3DF372203432B684A53F5381FC_1061636625 = (mComponentCallbacks.size() > 0);
                {
                    callbacks = mComponentCallbacks.toArray();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] callbacks = null;
        //synchronized (mComponentCallbacks) {
            //if (mComponentCallbacks.size() > 0) {
                //callbacks = mComponentCallbacks.toArray();
            //}
        //}
        //return callbacks;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.535 -0400", hash_original_method = "8B856F104DA3FA2F4A1E951FC948DC43", hash_generated_method = "9C3A4BCF4A4F8388888C5261237BE642")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object[] collectActivityLifecycleCallbacks() {
        Object[] callbacks;
        callbacks = null;
        {
            {
                boolean var288CD92E0C2C3B5BCA99A537DCE8A614_1515705298 = (mActivityLifecycleCallbacks.size() > 0);
                {
                    callbacks = mActivityLifecycleCallbacks.toArray();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] callbacks = null;
        //synchronized (mActivityLifecycleCallbacks) {
            //if (mActivityLifecycleCallbacks.size() > 0) {
                //callbacks = mActivityLifecycleCallbacks.toArray();
            //}
        //}
        //return callbacks;
    }

    
    public interface ActivityLifecycleCallbacks {
        void onActivityCreated(Activity activity, Bundle savedInstanceState);
        void onActivityStarted(Activity activity);
        void onActivityResumed(Activity activity);
        void onActivityPaused(Activity activity);
        void onActivityStopped(Activity activity);
        void onActivitySaveInstanceState(Activity activity, Bundle outState);
        void onActivityDestroyed(Activity activity);
    }
    
}

