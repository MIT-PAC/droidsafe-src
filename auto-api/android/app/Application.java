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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.172 -0400", hash_original_field = "1009BF2C0E9446739A33C63F7A074E0B", hash_generated_field = "16B69693C5E15AB94DE4137F3E4501E9")

    private ArrayList<ComponentCallbacks> mComponentCallbacks = new ArrayList<ComponentCallbacks>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.173 -0400", hash_original_field = "E2B2BC009CAF9777A81722CA4641A7B9", hash_generated_field = "1190D7B87E33C46DAB58949EEB001EB4")

    private ArrayList<ActivityLifecycleCallbacks> mActivityLifecycleCallbacks = new ArrayList<ActivityLifecycleCallbacks>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.174 -0400", hash_original_field = "86538E88D79456D578B9342A488D13A3", hash_generated_field = "FF6531A6914CAE203686310F4E2851DB")

    public LoadedApk mLoadedApk;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.185 -0400", hash_original_method = "C931B33981954029459F423E4A87FAC0", hash_generated_method = "7C12002EA4BAD91EC04D0ADCB77C2679")
    public  Application() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.187 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "7564C9BAB223A8E7FAC043FBCC648B76")
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.188 -0400", hash_original_method = "9A007B9204A4409A01090B4582DB84FC", hash_generated_method = "85299B4BE1512429EABA91F15A3B99D5")
    public void onTerminate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.204 -0400", hash_original_method = "2D485B4C1AE5E3664AA314F747191250", hash_generated_method = "3153E540541C38F5AD0DD304857A5ABE")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //Object[] callbacks = collectComponentCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ComponentCallbacks)callbacks[i]).onConfigurationChanged(newConfig);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.209 -0400", hash_original_method = "32ED3A67A5037221704DD520024E5B9C", hash_generated_method = "80A307DFBE4426AE9096CFC2D6354354")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.235 -0400", hash_original_method = "5BCB587BF7423BC0B6C7061FE2EAADB1", hash_generated_method = "860BFC2D2519940E89A48E44058176B5")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(level);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.237 -0400", hash_original_method = "999C2BA374DE68751A0CA6FB69F492E4", hash_generated_method = "EF724B2C838FF361F99C440ACD2555F9")
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            mComponentCallbacks.add(callback);
        } //End block
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //synchronized (mComponentCallbacks) {
            //mComponentCallbacks.add(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.244 -0400", hash_original_method = "01F19973468E375E5E76C4BC0EA13BD8", hash_generated_method = "18E5599FC8E2803650192DE0044F64BF")
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        {
            mComponentCallbacks.remove(callback);
        } //End block
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //synchronized (mComponentCallbacks) {
            //mComponentCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.245 -0400", hash_original_method = "E08A3F54F3A8B985B7290C2DDF6D4A2E", hash_generated_method = "BE74DED7613000EE89B4ED21A57CA5D1")
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            mActivityLifecycleCallbacks.add(callback);
        } //End block
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //synchronized (mActivityLifecycleCallbacks) {
            //mActivityLifecycleCallbacks.add(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.264 -0400", hash_original_method = "3537E943E5CD5EE71FF990B3E6F24A93", hash_generated_method = "673A5309A6D600562FE61A324B73E4DC")
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        {
            mActivityLifecycleCallbacks.remove(callback);
        } //End block
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //synchronized (mActivityLifecycleCallbacks) {
            //mActivityLifecycleCallbacks.remove(callback);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.281 -0400", hash_original_method = "A1FD1227D92B45F25B0D2B23D5D98DA3", hash_generated_method = "73D7041135078FB08BE3214A3469F2B9")
    final void attach(Context context) {
        attachBaseContext(context);
        mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
        // ---------- Original Method ----------
        //attachBaseContext(context);
        //mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.284 -0400", hash_original_method = "2B96BC83E264258C9DA658E6486A0ADA", hash_generated_method = "F97F9C53D5202EC01CE7CDD261D028DE")
     void dispatchActivityCreated(Activity activity, Bundle savedInstanceState) {
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
        addTaint(activity.getTaint());
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityCreated(activity,
                        //savedInstanceState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.297 -0400", hash_original_method = "BB2CB10BE5DA2456D7FFED5329EAA067", hash_generated_method = "04E62E4311F3932B3253A651057CDFE2")
     void dispatchActivityStarted(Activity activity) {
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
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityStarted(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.306 -0400", hash_original_method = "7639D676E3D6026BF188B6D74D0066A2", hash_generated_method = "2675B916519D090218E8784ED48CD998")
     void dispatchActivityResumed(Activity activity) {
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
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityResumed(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.322 -0400", hash_original_method = "5DB331CA50D721A0DDEB1A6DEFCCACF3", hash_generated_method = "D0038120F3F59791653678C40582C84A")
     void dispatchActivityPaused(Activity activity) {
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
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityPaused(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.333 -0400", hash_original_method = "F8E6CA2DBF83F739D06FE3A12F2BF88C", hash_generated_method = "2898A43E12300128D04C151EB3CE3014")
     void dispatchActivityStopped(Activity activity) {
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
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityStopped(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.342 -0400", hash_original_method = "B5ED6DC4BA8E7805F8F571CEAE93D7B1", hash_generated_method = "87EF3FBA42CD04EEA31559D7349E9D1C")
     void dispatchActivitySaveInstanceState(Activity activity, Bundle outState) {
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
        addTaint(activity.getTaint());
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivitySaveInstanceState(activity,
                        //outState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.345 -0400", hash_original_method = "53A653C273347AA10BEB59307E30D6C5", hash_generated_method = "F74CA470F2A8DDA8AEECCDE29550ACC0")
     void dispatchActivityDestroyed(Activity activity) {
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
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //Object[] callbacks = collectActivityLifecycleCallbacks();
        //if (callbacks != null) {
            //for (int i=0; i<callbacks.length; i++) {
                //((ActivityLifecycleCallbacks)callbacks[i]).onActivityDestroyed(activity);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.588 -0400", hash_original_method = "324DD85B066E69EB73C73FA0F3E95B35", hash_generated_method = "9788D670D1F81959AD34C24D06DA65F2")
    private Object[] collectComponentCallbacks() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1724148487 = null; //Variable for return #1
        Object[] callbacks;
        callbacks = null;
        {
            {
                boolean var38B7DE3DF372203432B684A53F5381FC_1347652152 = (mComponentCallbacks.size() > 0);
                {
                    callbacks = mComponentCallbacks.toArray();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1724148487 = callbacks;
        varB4EAC82CA7396A68D541C85D26508E83_1724148487.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1724148487;
        // ---------- Original Method ----------
        //Object[] callbacks = null;
        //synchronized (mComponentCallbacks) {
            //if (mComponentCallbacks.size() > 0) {
                //callbacks = mComponentCallbacks.toArray();
            //}
        //}
        //return callbacks;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.592 -0400", hash_original_method = "8B856F104DA3FA2F4A1E951FC948DC43", hash_generated_method = "903FA2CFC3D5CAAD986A14B54692C9DE")
    private Object[] collectActivityLifecycleCallbacks() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_2145057298 = null; //Variable for return #1
        Object[] callbacks;
        callbacks = null;
        {
            {
                boolean var288CD92E0C2C3B5BCA99A537DCE8A614_1799436710 = (mActivityLifecycleCallbacks.size() > 0);
                {
                    callbacks = mActivityLifecycleCallbacks.toArray();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2145057298 = callbacks;
        varB4EAC82CA7396A68D541C85D26508E83_2145057298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2145057298;
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

