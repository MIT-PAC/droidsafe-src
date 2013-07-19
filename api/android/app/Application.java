package android.app;

// Droidsafe Imports
import java.util.ArrayList;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Application extends ContextWrapper implements ComponentCallbacks2 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.117 -0400", hash_original_field = "1009BF2C0E9446739A33C63F7A074E0B", hash_generated_field = "16B69693C5E15AB94DE4137F3E4501E9")

    private ArrayList<ComponentCallbacks> mComponentCallbacks = new ArrayList<ComponentCallbacks>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.117 -0400", hash_original_field = "E2B2BC009CAF9777A81722CA4641A7B9", hash_generated_field = "1190D7B87E33C46DAB58949EEB001EB4")

    private ArrayList<ActivityLifecycleCallbacks> mActivityLifecycleCallbacks = new ArrayList<ActivityLifecycleCallbacks>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.117 -0400", hash_original_field = "86538E88D79456D578B9342A488D13A3", hash_generated_field = "FF6531A6914CAE203686310F4E2851DB")

    public LoadedApk mLoadedApk;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.118 -0400", hash_original_method = "C931B33981954029459F423E4A87FAC0", hash_generated_method = "7C12002EA4BAD91EC04D0ADCB77C2679")
    public  Application() {
        super(null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.118 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "7564C9BAB223A8E7FAC043FBCC648B76")
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.119 -0400", hash_original_method = "9A007B9204A4409A01090B4582DB84FC", hash_generated_method = "85299B4BE1512429EABA91F15A3B99D5")
    public void onTerminate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.120 -0400", hash_original_method = "2D485B4C1AE5E3664AA314F747191250", hash_generated_method = "AEFEA1D90204291476E47CF244B9B67E")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        Object[] callbacks = collectComponentCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                ((ComponentCallbacks)callbacks[i]).onConfigurationChanged(newConfig);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectComponentCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ComponentCallbacks)callbacks[i]).onConfigurationChanged(newConfig);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.121 -0400", hash_original_method = "32ED3A67A5037221704DD520024E5B9C", hash_generated_method = "7F3EFF6132761A9955B72A1075C77A3C")
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object[] callbacks = collectComponentCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                ((ComponentCallbacks)callbacks[i]).onLowMemory();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectComponentCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ComponentCallbacks)callbacks[i]).onLowMemory();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.122 -0400", hash_original_method = "5BCB587BF7423BC0B6C7061FE2EAADB1", hash_generated_method = "ECAB3F97BE68251A463890763CCDDA9C")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        Object[] callbacks = collectComponentCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                Object c = callbacks[i];
                if(c instanceof ComponentCallbacks2)                
                {
                    ((ComponentCallbacks2)c).onTrimMemory(level);
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.123 -0400", hash_original_method = "999C2BA374DE68751A0CA6FB69F492E4", hash_generated_method = "6EEC12821FBD9D67A38C5EF3DA386B88")
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(callback.getTaint());
        synchronized
(mComponentCallbacks)        {
            mComponentCallbacks.add(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mComponentCallbacks) {
            //mComponentCallbacks.add(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.124 -0400", hash_original_method = "01F19973468E375E5E76C4BC0EA13BD8", hash_generated_method = "0B819077FAE7AFE4CC49A4D40009CE8B")
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        addTaint(callback.getTaint());
        synchronized
(mComponentCallbacks)        {
            mComponentCallbacks.remove(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mComponentCallbacks) {
            //mComponentCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.125 -0400", hash_original_method = "E08A3F54F3A8B985B7290C2DDF6D4A2E", hash_generated_method = "015E599FA87CE48D479792B49B6D39F7")
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(callback.getTaint());
        synchronized
(mActivityLifecycleCallbacks)        {
            mActivityLifecycleCallbacks.add(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mActivityLifecycleCallbacks) {
            //mActivityLifecycleCallbacks.add(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.126 -0400", hash_original_method = "3537E943E5CD5EE71FF990B3E6F24A93", hash_generated_method = "8BC282DA405E0F80B1052502EF7A5D6C")
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        addTaint(callback.getTaint());
        synchronized
(mActivityLifecycleCallbacks)        {
            mActivityLifecycleCallbacks.remove(callback);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mActivityLifecycleCallbacks) {
            //mActivityLifecycleCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.129 -0400", hash_original_method = "A1FD1227D92B45F25B0D2B23D5D98DA3", hash_generated_method = "73D7041135078FB08BE3214A3469F2B9")
    final void attach(Context context) {
        attachBaseContext(context);
        mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
        // ---------- Original Method ----------
        //attachBaseContext(context);
        //mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.130 -0400", hash_original_method = "2B96BC83E264258C9DA658E6486A0ADA", hash_generated_method = "3687C1996F712E49A2C79C4FF4B9074C")
     void dispatchActivityCreated(Activity activity, Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        addTaint(activity.getTaint());
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityCreated(activity,
                        savedInstanceState);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.131 -0400", hash_original_method = "BB2CB10BE5DA2456D7FFED5329EAA067", hash_generated_method = "CC0454283F21C29F90A29AD9FEEA0BDB")
     void dispatchActivityStarted(Activity activity) {
        addTaint(activity.getTaint());
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityStarted(activity);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityStarted(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.133 -0400", hash_original_method = "7639D676E3D6026BF188B6D74D0066A2", hash_generated_method = "8C4F6FE82CF971BD8F4A184621803236")
     void dispatchActivityResumed(Activity activity) {
        addTaint(activity.getTaint());
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityResumed(activity);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityResumed(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.134 -0400", hash_original_method = "5DB331CA50D721A0DDEB1A6DEFCCACF3", hash_generated_method = "859C618097265A4E566506791253AD73")
     void dispatchActivityPaused(Activity activity) {
        addTaint(activity.getTaint());
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityPaused(activity);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityPaused(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.135 -0400", hash_original_method = "F8E6CA2DBF83F739D06FE3A12F2BF88C", hash_generated_method = "E8B19A22DDC8F1EC6FC4D52D2DD4C8BD")
     void dispatchActivityStopped(Activity activity) {
        addTaint(activity.getTaint());
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityStopped(activity);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityStopped(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.137 -0400", hash_original_method = "B5ED6DC4BA8E7805F8F571CEAE93D7B1", hash_generated_method = "B9C646D104F25D62E442A97FA7CE9EAA")
     void dispatchActivitySaveInstanceState(Activity activity, Bundle outState) {
        addTaint(outState.getTaint());
        addTaint(activity.getTaint());
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivitySaveInstanceState(activity,
                        outState);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.138 -0400", hash_original_method = "53A653C273347AA10BEB59307E30D6C5", hash_generated_method = "09BF3347AE094802EEC0B12ADFDADE87")
     void dispatchActivityDestroyed(Activity activity) {
        addTaint(activity.getTaint());
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if(callbacks != null)        
        {
for(int i=0;i<callbacks.length;i++)
            {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityDestroyed(activity);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityDestroyed(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.141 -0400", hash_original_method = "324DD85B066E69EB73C73FA0F3E95B35", hash_generated_method = "D2E8052186185EF546937DD0FFFA2C8D")
    private Object[] collectComponentCallbacks() {
        Object[] callbacks = null;
        synchronized
(mComponentCallbacks)        {
            if(mComponentCallbacks.size() > 0)            
            {
                callbacks = mComponentCallbacks.toArray();
            } //End block
        } //End block
Object[] var7E06ACD9C2C819F377F4C0B98904AB11_1734513625 =         callbacks;
        var7E06ACD9C2C819F377F4C0B98904AB11_1734513625.addTaint(taint);
        return var7E06ACD9C2C819F377F4C0B98904AB11_1734513625;
        // ---------- Original Method ----------
        //Object[] callbacks = null;
        //synchronized (mComponentCallbacks) {
            //if (mComponentCallbacks.size() > 0) {
                //callbacks = mComponentCallbacks.toArray();
            //}
        //}
        //return callbacks;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.144 -0400", hash_original_method = "8B856F104DA3FA2F4A1E951FC948DC43", hash_generated_method = "FA3FC30C50C8ABA150A508922F70888F")
    private Object[] collectActivityLifecycleCallbacks() {
        Object[] callbacks = null;
        synchronized
(mActivityLifecycleCallbacks)        {
            if(mActivityLifecycleCallbacks.size() > 0)            
            {
                callbacks = mActivityLifecycleCallbacks.toArray();
            } //End block
        } //End block
Object[] var7E06ACD9C2C819F377F4C0B98904AB11_888661499 =         callbacks;
        var7E06ACD9C2C819F377F4C0B98904AB11_888661499.addTaint(taint);
        return var7E06ACD9C2C819F377F4C0B98904AB11_888661499;
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

