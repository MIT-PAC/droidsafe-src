package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.725 -0400", hash_original_method = "C931B33981954029459F423E4A87FAC0", hash_generated_method = "7FFEA0B81763E61AFF49E37CF74912FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Application() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.726 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "B382920F64FDE934FF92CA84351F4952")
    @DSModeled(DSC.SAFE)
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.726 -0400", hash_original_method = "9A007B9204A4409A01090B4582DB84FC", hash_generated_method = "B489AB5CACBCD38F5D448E322BB9ACE9")
    @DSModeled(DSC.SAFE)
    public void onTerminate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.726 -0400", hash_original_method = "2D485B4C1AE5E3664AA314F747191250", hash_generated_method = "927D9CAFFB5CABAF6885B1DAE2CF350F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.727 -0400", hash_original_method = "32ED3A67A5037221704DD520024E5B9C", hash_generated_method = "38201E9C13E5255403FECDF8162175F6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.727 -0400", hash_original_method = "5BCB587BF7423BC0B6C7061FE2EAADB1", hash_generated_method = "0C07FCC0F463116829EC2B0BCDC6E8A6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.727 -0400", hash_original_method = "999C2BA374DE68751A0CA6FB69F492E4", hash_generated_method = "3A3973C139C2A070C064633EFF4DBC44")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.728 -0400", hash_original_method = "01F19973468E375E5E76C4BC0EA13BD8", hash_generated_method = "4FA91CCD7371C6FAB32276E221ABC8D7")
    @DSModeled(DSC.SAFE)
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(callback.dsTaint);
        {
            mComponentCallbacks.remove(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mComponentCallbacks) {
            //mComponentCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.728 -0400", hash_original_method = "E08A3F54F3A8B985B7290C2DDF6D4A2E", hash_generated_method = "B90A954E7AEDDE3807D0DFC9E40D1D36")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.728 -0400", hash_original_method = "3537E943E5CD5EE71FF990B3E6F24A93", hash_generated_method = "BDE76BE6424A9097C08DF0A0E32A61F6")
    @DSModeled(DSC.SAFE)
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(callback.dsTaint);
        {
            mActivityLifecycleCallbacks.remove(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mActivityLifecycleCallbacks) {
            //mActivityLifecycleCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.729 -0400", hash_original_method = "A1FD1227D92B45F25B0D2B23D5D98DA3", hash_generated_method = "18BB394C45BDC0192AFDC7FF24AA55F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void attach(Context context) {
        dsTaint.addTaint(context.dsTaint);
        attachBaseContext(context);
        mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
        // ---------- Original Method ----------
        //attachBaseContext(context);
        //mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.729 -0400", hash_original_method = "2B96BC83E264258C9DA658E6486A0ADA", hash_generated_method = "D2F4BF40D8CC43C0CF905BA1FD696963")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.730 -0400", hash_original_method = "BB2CB10BE5DA2456D7FFED5329EAA067", hash_generated_method = "FA2E33B0E492FCCE044D86C9A4BFD3A3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.730 -0400", hash_original_method = "7639D676E3D6026BF188B6D74D0066A2", hash_generated_method = "A046F4928F154F4E4442B46F3CEC2A51")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.730 -0400", hash_original_method = "5DB331CA50D721A0DDEB1A6DEFCCACF3", hash_generated_method = "9AA9413B50818D19092E7D4217FF8B72")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.731 -0400", hash_original_method = "F8E6CA2DBF83F739D06FE3A12F2BF88C", hash_generated_method = "7BD390008AC61178536CF94FF5472AF0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.731 -0400", hash_original_method = "B5ED6DC4BA8E7805F8F571CEAE93D7B1", hash_generated_method = "0B95A65649933293F7B7BD6B0B5B72CA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.731 -0400", hash_original_method = "53A653C273347AA10BEB59307E30D6C5", hash_generated_method = "CAEC06DA866FD5058555EE53845D073D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.732 -0400", hash_original_method = "324DD85B066E69EB73C73FA0F3E95B35", hash_generated_method = "7AECE4B767C35CACBA703231B0DA232C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object[] collectComponentCallbacks() {
        Object[] callbacks;
        callbacks = null;
        {
            {
                boolean var38B7DE3DF372203432B684A53F5381FC_1444587532 = (mComponentCallbacks.size() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.732 -0400", hash_original_method = "8B856F104DA3FA2F4A1E951FC948DC43", hash_generated_method = "94EDFAC873A62DDD6EAD05FCED07305C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object[] collectActivityLifecycleCallbacks() {
        Object[] callbacks;
        callbacks = null;
        {
            {
                boolean var288CD92E0C2C3B5BCA99A537DCE8A614_1428108836 = (mActivityLifecycleCallbacks.size() > 0);
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


