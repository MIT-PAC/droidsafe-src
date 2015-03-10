/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;

public class Application extends ContextWrapper implements ComponentCallbacks2 {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.735 -0500", hash_original_field = "52837140401BB64310DD4D38EE64CEAC", hash_generated_field = "16B69693C5E15AB94DE4137F3E4501E9")

    private ArrayList<ComponentCallbacks> mComponentCallbacks =
            new ArrayList<ComponentCallbacks>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.737 -0500", hash_original_field = "11BB54DB20499CC9620B577771DDB91A", hash_generated_field = "1190D7B87E33C46DAB58949EEB001EB4")

    private ArrayList<ActivityLifecycleCallbacks> mActivityLifecycleCallbacks =
            new ArrayList<ActivityLifecycleCallbacks>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.739 -0500", hash_original_field = "ACB058023AB9A2C77C7FF694483158E5", hash_generated_field = "FF6531A6914CAE203686310F4E2851DB")

    public LoadedApk mLoadedApk;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.744 -0500", hash_original_method = "C931B33981954029459F423E4A87FAC0", hash_generated_method = "F0E4FB0F5E319AAF30983CD5CD1CB19D")
    
public Application() {
        super(DroidSafeAndroidRuntime.context);
    }

    /**
     * Called when the application is starting, before any other application
     * objects have been created.  Implementations should be as quick as
     * possible (for example using lazy initialization of state) since the time
     * spent in this function directly impacts the performance of starting the
     * first activity, service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSVerified
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.746 -0500", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "9687CB6D9F1B2A9EE9EE5E6EB201E78C")
    
public void onCreate() {
    }

    /**
     * This method is for use in emulated process environments.  It will
     * never be called on a production Android device, where processes are
     * removed by simply killing them; no user code (including this callback)
     * is executed when doing so.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.748 -0500", hash_original_method = "9A007B9204A4409A01090B4582DB84FC", hash_generated_method = "0CFB0DE44CBDF4B9B5900A2A835F1B37")
    
public void onTerminate() {
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.750 -0500", hash_original_method = "2D485B4C1AE5E3664AA314F747191250", hash_generated_method = "54485CB360746CF2B2E2C51891FDCFE0")
    @DSVerified
    
public void onConfigurationChanged(Configuration newConfig) {
        Object[] callbacks = collectComponentCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                ((ComponentCallbacks)callbacks[i]).onConfigurationChanged(newConfig);
            }
        }
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.752 -0500", hash_original_method = "32ED3A67A5037221704DD520024E5B9C", hash_generated_method = "16B88362C84C148D000BF9BA526997C6")
    
public void onLowMemory() {
        Object[] callbacks = collectComponentCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                ((ComponentCallbacks)callbacks[i]).onLowMemory();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.754 -0500", hash_original_method = "5BCB587BF7423BC0B6C7061FE2EAADB1", hash_generated_method = "7FEE2C7FCE11DFEBCE6A22DDA5CED1F5")
    
public void onTrimMemory(int level) {
        Object[] callbacks = collectComponentCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                Object c = callbacks[i];
                if (c instanceof ComponentCallbacks2) {
                    ((ComponentCallbacks2)c).onTrimMemory(level);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.757 -0500", hash_original_method = "999C2BA374DE68751A0CA6FB69F492E4", hash_generated_method = "283E1D3A362D1A8D8772446542C8D6CC")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void registerComponentCallbacks(ComponentCallbacks callback) {
        synchronized (mComponentCallbacks) {
            mComponentCallbacks.add(callback);
        }
        callback.onConfigurationChanged(new Configuration());
        callback.onLowMemory();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.759 -0500", hash_original_method = "01F19973468E375E5E76C4BC0EA13BD8", hash_generated_method = "0C577100894B473B84432278E677D48D")
    
public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        synchronized (mComponentCallbacks) {
            mComponentCallbacks.remove(callback);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.761 -0500", hash_original_method = "E08A3F54F3A8B985B7290C2DDF6D4A2E", hash_generated_method = "6F4F097EBEF8246D1D26651C3F5AD02C")
    
public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        synchronized (mActivityLifecycleCallbacks) {
            mActivityLifecycleCallbacks.add(callback);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.763 -0500", hash_original_method = "3537E943E5CD5EE71FF990B3E6F24A93", hash_generated_method = "0E2F9961FA845549BFAF9D4C2FDAD177")
    
public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        synchronized (mActivityLifecycleCallbacks) {
            mActivityLifecycleCallbacks.remove(callback);
        }
    }
    
    // ------------------ Internal API ------------------
    
    /**
     * @hide
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.765 -0500", hash_original_method = "A1FD1227D92B45F25B0D2B23D5D98DA3", hash_generated_method = "84D598C15FE8757E2DACE3FA164916D8")
    
final void attach(Context context) {
        attachBaseContext(context);
        mLoadedApk = ContextImpl.getImpl(context).mPackageInfo;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.767 -0500", hash_original_method = "2B96BC83E264258C9DA658E6486A0ADA", hash_generated_method = "2B96BC83E264258C9DA658E6486A0ADA")
    
void dispatchActivityCreated(Activity activity, Bundle savedInstanceState) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityCreated(activity,
                        savedInstanceState);
            }
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.769 -0500", hash_original_method = "BB2CB10BE5DA2456D7FFED5329EAA067", hash_generated_method = "BB2CB10BE5DA2456D7FFED5329EAA067")
    
void dispatchActivityStarted(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityStarted(activity);
            }
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.772 -0500", hash_original_method = "7639D676E3D6026BF188B6D74D0066A2", hash_generated_method = "7639D676E3D6026BF188B6D74D0066A2")
    
void dispatchActivityResumed(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityResumed(activity);
            }
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.774 -0500", hash_original_method = "5DB331CA50D721A0DDEB1A6DEFCCACF3", hash_generated_method = "5DB331CA50D721A0DDEB1A6DEFCCACF3")
    
void dispatchActivityPaused(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityPaused(activity);
            }
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.777 -0500", hash_original_method = "F8E6CA2DBF83F739D06FE3A12F2BF88C", hash_generated_method = "F8E6CA2DBF83F739D06FE3A12F2BF88C")
    
void dispatchActivityStopped(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityStopped(activity);
            }
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.780 -0500", hash_original_method = "B5ED6DC4BA8E7805F8F571CEAE93D7B1", hash_generated_method = "B5ED6DC4BA8E7805F8F571CEAE93D7B1")
    
void dispatchActivitySaveInstanceState(Activity activity, Bundle outState) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivitySaveInstanceState(activity,
                        outState);
            }
        }
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.782 -0500", hash_original_method = "53A653C273347AA10BEB59307E30D6C5", hash_generated_method = "53A653C273347AA10BEB59307E30D6C5")
    
void dispatchActivityDestroyed(Activity activity) {
        Object[] callbacks = collectActivityLifecycleCallbacks();
        if (callbacks != null) {
            for (int i=0; i<callbacks.length; i++) {
                ((ActivityLifecycleCallbacks)callbacks[i]).onActivityDestroyed(activity);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.784 -0500", hash_original_method = "324DD85B066E69EB73C73FA0F3E95B35", hash_generated_method = "D559B694C8BEA8DBF7D46DB17D40279C")
    
private Object[] collectComponentCallbacks() {
        Object[] callbacks = null;
        synchronized (mComponentCallbacks) {
            if (mComponentCallbacks.size() > 0) {
                callbacks = mComponentCallbacks.toArray();
            }
        }
        return callbacks;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:48.786 -0500", hash_original_method = "8B856F104DA3FA2F4A1E951FC948DC43", hash_generated_method = "0AC84DF213169E1557305E31E2C846E9")
    
private Object[] collectActivityLifecycleCallbacks() {
        Object[] callbacks = null;
        synchronized (mActivityLifecycleCallbacks) {
            if (mActivityLifecycleCallbacks.size() > 0) {
                callbacks = mActivityLifecycleCallbacks.toArray();
            }
        }
        return callbacks;
    }
    
    public interface ActivityLifecycleCallbacks {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onActivityCreated(Activity activity, Bundle savedInstanceState);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onActivityStarted(Activity activity);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onActivityResumed(Activity activity);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onActivityPaused(Activity activity);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onActivityStopped(Activity activity);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onActivitySaveInstanceState(Activity activity, Bundle outState);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onActivityDestroyed(Activity activity);
    }
    
	// ------------- Droidsafe Hooks -------------
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL) 
 	public void droidsafeAttach(Context context) {
 		attach(context);
 	}

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL) 
	public void droidsafeOnCreate() {
		onCreate();
	}

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL) 
	public void droidsafeOnTerminate() {
		onTerminate();
	}

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
	public void droidsafeOnEverythingElse() {
		onTrimMemory(getTaintInt());
		onLowMemory();
		onConfigurationChanged(new Configuration());
	}
}

