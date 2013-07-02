package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;

public class Application extends ContextWrapper implements ComponentCallbacks2 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.221 -0400", hash_original_field = "1009BF2C0E9446739A33C63F7A074E0B", hash_generated_field = "16B69693C5E15AB94DE4137F3E4501E9")

    private ArrayList<ComponentCallbacks> mComponentCallbacks = new ArrayList<ComponentCallbacks>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.221 -0400", hash_original_field = "E2B2BC009CAF9777A81722CA4641A7B9", hash_generated_field = "1190D7B87E33C46DAB58949EEB001EB4")

    private ArrayList<ActivityLifecycleCallbacks> mActivityLifecycleCallbacks = new ArrayList<ActivityLifecycleCallbacks>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.221 -0400", hash_original_field = "86538E88D79456D578B9342A488D13A3", hash_generated_field = "FF6531A6914CAE203686310F4E2851DB")

    public LoadedApk mLoadedApk;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.222 -0400", hash_original_method = "C931B33981954029459F423E4A87FAC0", hash_generated_method = "7C12002EA4BAD91EC04D0ADCB77C2679")
    public  Application() {
        super(null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.222 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "7564C9BAB223A8E7FAC043FBCC648B76")
    public void onCreate() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.223 -0400", hash_original_method = "9A007B9204A4409A01090B4582DB84FC", hash_generated_method = "85299B4BE1512429EABA91F15A3B99D5")
    public void onTerminate() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.223 -0400", hash_original_method = "2D485B4C1AE5E3664AA314F747191250", hash_generated_method = "A04301D4CEA13B4DFB9B3296541BF579")
    public void onConfigurationChanged(Configuration newConfig) {
        
        Object[] callbacks = collectComponentCallbacks();
        {
            {
                int i = 0;
                {
                    ((ComponentCallbacks)callbacks[i]).onConfigurationChanged(newConfig);
                } 
            } 
        } 
        addTaint(newConfig.getTaint());
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.224 -0400", hash_original_method = "32ED3A67A5037221704DD520024E5B9C", hash_generated_method = "AC14AAE4665DD5890C7F13B38F64CDDC")
    public void onLowMemory() {
        
        Object[] callbacks = collectComponentCallbacks();
        {
            {
                int i = 0;
                {
                    ((ComponentCallbacks)callbacks[i]).onLowMemory();
                } 
            } 
        } 
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.225 -0400", hash_original_method = "5BCB587BF7423BC0B6C7061FE2EAADB1", hash_generated_method = "BA36F050D2DAE621CB932451F0150C8D")
    public void onTrimMemory(int level) {
        
        Object[] callbacks = collectComponentCallbacks();
        {
            {
                int i = 0;
                {
                    Object c = callbacks[i];
                    {
                        ((ComponentCallbacks2)c).onTrimMemory(level);
                    } 
                } 
            } 
        } 
        addTaint(level);
        
        
        
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.226 -0400", hash_original_method = "999C2BA374DE68751A0CA6FB69F492E4", hash_generated_method = "EF724B2C838FF361F99C440ACD2555F9")
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        
        {
            mComponentCallbacks.add(callback);
        } 
        addTaint(callback.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.226 -0400", hash_original_method = "01F19973468E375E5E76C4BC0EA13BD8", hash_generated_method = "18E5599FC8E2803650192DE0044F64BF")
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        {
            mComponentCallbacks.remove(callback);
        } 
        addTaint(callback.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.227 -0400", hash_original_method = "E08A3F54F3A8B985B7290C2DDF6D4A2E", hash_generated_method = "BE74DED7613000EE89B4ED21A57CA5D1")
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        
        {
            mActivityLifecycleCallbacks.add(callback);
        } 
        addTaint(callback.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.228 -0400", hash_original_method = "3537E943E5CD5EE71FF990B3E6F24A93", hash_generated_method = "673A5309A6D600562FE61A324B73E4DC")
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        {
            mActivityLifecycleCallbacks.remove(callback);
        } 
        addTaint(callback.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.229 -0400", hash_original_method = "A1FD1227D92B45F25B0D2B23D5D98DA3", hash_generated_method = "73D7041135078FB08BE3214A3469F2B9")
    final void attach(Context context) {
        attachBaseContext(context);
        mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.230 -0400", hash_original_method = "2B96BC83E264258C9DA658E6486A0ADA", hash_generated_method = "3BBEB5FF8E6477D95F17A333D851F0C9")
     void dispatchActivityCreated(Activity activity, Bundle savedInstanceState) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityCreated(activity,
                        savedInstanceState);
                } 
            } 
        } 
        addTaint(activity.getTaint());
        addTaint(savedInstanceState.getTaint());
        
        
        
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.232 -0400", hash_original_method = "BB2CB10BE5DA2456D7FFED5329EAA067", hash_generated_method = "7D181B4521AA8D29C4FC51D36891E9A0")
     void dispatchActivityStarted(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityStarted(activity);
                } 
            } 
        } 
        addTaint(activity.getTaint());
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.232 -0400", hash_original_method = "7639D676E3D6026BF188B6D74D0066A2", hash_generated_method = "68830B77DF91E8CE4A422374094EE09C")
     void dispatchActivityResumed(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityResumed(activity);
                } 
            } 
        } 
        addTaint(activity.getTaint());
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.233 -0400", hash_original_method = "5DB331CA50D721A0DDEB1A6DEFCCACF3", hash_generated_method = "6A63B30C148FFCE35DD6B33A4BB3033A")
     void dispatchActivityPaused(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityPaused(activity);
                } 
            } 
        } 
        addTaint(activity.getTaint());
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.234 -0400", hash_original_method = "F8E6CA2DBF83F739D06FE3A12F2BF88C", hash_generated_method = "5F993A881C73EF9BA4C89805D97962A4")
     void dispatchActivityStopped(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityStopped(activity);
                } 
            } 
        } 
        addTaint(activity.getTaint());
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.234 -0400", hash_original_method = "B5ED6DC4BA8E7805F8F571CEAE93D7B1", hash_generated_method = "F320D2EAC8B53D6532211CC8CD7E8BA7")
     void dispatchActivitySaveInstanceState(Activity activity, Bundle outState) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivitySaveInstanceState(activity,
                        outState);
                } 
            } 
        } 
        addTaint(activity.getTaint());
        addTaint(outState.getTaint());
        
        
        
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.235 -0400", hash_original_method = "53A653C273347AA10BEB59307E30D6C5", hash_generated_method = "5FD28717B2863E376DEC4E0BC2C8453E")
     void dispatchActivityDestroyed(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        {
            {
                int i = 0;
                {
                    ((ActivityLifecycleCallbacks)callbacks[i]).onActivityDestroyed(activity);
                } 
            } 
        } 
        addTaint(activity.getTaint());
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.236 -0400", hash_original_method = "324DD85B066E69EB73C73FA0F3E95B35", hash_generated_method = "17F6ED6D17B4C31FFB59BB7713025F87")
    private Object[] collectComponentCallbacks() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1048000470 = null; 
        Object[] callbacks = null;
        {
            {
                boolean var38B7DE3DF372203432B684A53F5381FC_925431375 = (mComponentCallbacks.size() > 0);
                {
                    callbacks = mComponentCallbacks.toArray();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1048000470 = callbacks;
        varB4EAC82CA7396A68D541C85D26508E83_1048000470.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1048000470;
        
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.237 -0400", hash_original_method = "8B856F104DA3FA2F4A1E951FC948DC43", hash_generated_method = "7C44074417F30F7055DEBED778FD43FE")
    private Object[] collectActivityLifecycleCallbacks() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1768097856 = null; 
        Object[] callbacks = null;
        {
            {
                boolean var288CD92E0C2C3B5BCA99A537DCE8A614_603123728 = (mActivityLifecycleCallbacks.size() > 0);
                {
                    callbacks = mActivityLifecycleCallbacks.toArray();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1768097856 = callbacks;
        varB4EAC82CA7396A68D541C85D26508E83_1768097856.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1768097856;
        
        
        
            
                
            
        
        
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

