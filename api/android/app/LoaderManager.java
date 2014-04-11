package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import android.content.Loader;
import android.os.Bundle;
import android.util.DebugUtils;
import android.util.Log;
import android.util.SparseArray;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public abstract class LoaderManager {

    /**
     * Control whether the framework's internal loader manager debugging
     * logs are turned on.  If enabled, you will see output in logcat as
     * the framework performs loader operations.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.760 -0500", hash_original_method = "89A72F83F9D61CEA045D6890DBF87528", hash_generated_method = "8E91F0BDF4B1D754E38DC34F511AD6FE")
    
public static void enableDebugLogging(boolean enabled) {
        LoaderManagerImpl.DEBUG = enabled;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.011 -0400", hash_original_method = "921B150ED82AB2739CD0194A062DB550", hash_generated_method = "921B150ED82AB2739CD0194A062DB550")
    public LoaderManager ()
    {
        //Synthesized constructor
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    public abstract <D> Loader<D> initLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<D> callback);
    
    public abstract <D> Loader<D> restartLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<D> callback);

    /**
     * Stops and removes the loader with the given ID.  If this loader
     * had previously reported data to the client through
     * {@link LoaderCallbacks#onLoadFinished(Loader, Object)}, a call
     * will be made to {@link LoaderCallbacks#onLoaderReset(Loader)}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.754 -0500", hash_original_method = "305FA1A128F5C6D6A2790EF0EF873EFF", hash_generated_method = "F3E476E4573CA6AD6CCCCC8E642C0234")
    
public abstract void destroyLoader(int id);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public abstract <D> Loader<D> getLoader(int id);

    /**
     * Print the LoaderManager's state into the given stream.
     *
     * @param prefix Text to print at the front of each line.
     * @param fd The raw file descriptor that the dump is being sent to.
     * @param writer A PrintWriter to which the dump is to be set.
     * @param args Additional arguments to the dump request.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.758 -0500", hash_original_method = "9309E77AA4047B9B8316706781ED0A27", hash_generated_method = "3FF3D3380483C9ADF611F5CA2E5A6D00")
    
public abstract void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args);
    
    public interface LoaderCallbacks<D> {
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public Loader<D> onCreateLoader(int id, Bundle args);
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onLoadFinished(Loader<D> loader, D data);
        
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onLoaderReset(Loader<D> loader);
    }
    
}

class LoaderManagerImpl extends LoaderManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.764 -0500", hash_original_field = "02EED4CB3BCEFB6D1DE4D8086C849649", hash_generated_field = "6D76EEEE053128D88AD38FCE96834362")

    static final String TAG = "LoaderManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.766 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.768 -0500", hash_original_field = "9FD9DE856C33B69C8B038B56C88A8970", hash_generated_field = "9FF9126464389B65DDE2569E0E6539C5")

    // from the time its load is started until it has been explicitly
    // stopped or restarted by the application.
    final SparseArray<LoaderInfo> mLoaders = new SparseArray<LoaderInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.770 -0500", hash_original_field = "E90A7D4DD714A663AB03F8811D44ABC3", hash_generated_field = "AA8DE82D1CE220A375A21C53186F41E3")

    // to avoid destroying a loader while an application is still using it.
    // It allows an application to restart a loader, but continue using its
    // previously run loader until the new loader's data is available.
    final SparseArray<LoaderInfo> mInactiveLoaders = new SparseArray<LoaderInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.772 -0500", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.774 -0500", hash_original_field = "8C92DC16A5D2F989C0A1D4375841DEF1", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

    boolean mStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.775 -0500", hash_original_field = "9B9EA230363F2EF227C5BE272DCC6838", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.777 -0500", hash_original_field = "6706C7B993D72CED6D04255D2F46A6E0", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

    boolean mRetainingStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.779 -0500", hash_original_field = "70C1252034BC616F659C7E09E95F15EB", hash_generated_field = "70C1252034BC616F659C7E09E95F15EB")
    
    boolean mCreatingLoader;
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.846 -0500", hash_original_method = "3A1775F72C10D39F9F7BFE3E62E94501", hash_generated_method = "3A1775F72C10D39F9F7BFE3E62E94501")
    
LoaderManagerImpl(Activity activity, boolean started) {
        mActivity = activity;
        mStarted = started;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.848 -0500", hash_original_method = "ABA1AB897196E6D0611C422D598DF8DF", hash_generated_method = "ABA1AB897196E6D0611C422D598DF8DF")
    
void updateActivity(Activity activity) {
        mActivity = activity;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.850 -0500", hash_original_method = "31DF1B394D718AFF7F9D42E1B24A1D9F", hash_generated_method = "DDEC0A96F03D9CD3869FEE215F4D438E")
    
private LoaderInfo createLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        LoaderInfo info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        Loader<Object> loader = callback.onCreateLoader(id, args);
        info.mLoader = (Loader<Object>)loader;
        return info;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.852 -0500", hash_original_method = "D2BDC915DCB9CB038EA75210255617B9", hash_generated_method = "D30BD7B7333A5E33E1D2154B4AD3B1C0")
    
private LoaderInfo createAndInstallLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        try {
            mCreatingLoader = true;
            LoaderInfo info = createLoader(id, args, callback);
            installLoader(info);
            return info;
        } finally {
            mCreatingLoader = false;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.854 -0500", hash_original_method = "112626D5EBE4C2D89FE7194A836F5D8E", hash_generated_method = "270C8A6EC15A6C96C82389014CEF07D4")
    
void installLoader(LoaderInfo info) {
        mLoaders.put(info.mId, info);
        if (mStarted) {
            // The activity will start all existing loaders in it's onStart(),
            // so only start them here if we're past that point of the activitiy's
            // life cycle
            info.start();
        }
    }

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    private<D> void droidsafeCallbackHook(Loader<D> loader, int id, Bundle args,  LoaderManager.LoaderCallbacks<D> callback) {
        loader.addTaint(getTaint());
       
        callback.onCreateLoader(id, args);
        callback.onLoaderReset(loader);
        
        //TODO: find a better way to inject generic data
        D data = null;
        callback.onLoadFinished(loader, data);
    }

    @DSVerified("initialize content loader, makes callback to LoaderCallbacks")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.016 -0400", hash_original_method = "E04CC49F77F654C9D0B54FC39C94F2D8", hash_generated_method = "44F3208F077884E4A84DDB056BA88B7C")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        addTaint(callback.getTaint());
        addTaint(args.getTaint());
        addTaint(id);
        
        if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_690930276 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_690930276.addTaint(getTaint());
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_690930276;
        } //End block
        LoaderInfo info = mLoaders.get(id);
        if(DEBUG){ }        if(info == null)        
        {
            info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
            if(DEBUG){ }
        } //End block
        else
        {
            if(DEBUG){ }            info.mCallbacks = (LoaderManager.LoaderCallbacks<Object>)callback;
        } //End block
        if(info.mHaveData && mStarted)        
        {
            info.callOnLoadFinished(info.mLoader, info.mData);
        } //End block

        Loader<D> loader =         (Loader<D>)info.mLoader;
        loader.addTaint(getTaint());
        droidsafeCallbackHook(loader, id, args, callback);
        return loader;
        // ---------- Original Method ----------
        //if (mCreatingLoader) {
            //throw new IllegalStateException("Called while creating a loader");
        //}
        //LoaderInfo info = mLoaders.get(id);
        //if (DEBUG) Log.v(TAG, "initLoader in " + this + ": args=" + args);
        //if (info == null) {
            //info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
            //if (DEBUG) Log.v(TAG, "  Created new loader " + info);
        //} else {
            //if (DEBUG) Log.v(TAG, "  Re-using existing loader " + info);
            //info.mCallbacks = (LoaderManager.LoaderCallbacks<Object>)callback;
        //}
        //if (info.mHaveData && mStarted) {
            //info.callOnLoadFinished(info.mLoader, info.mData);
        //}
        //return (Loader<D>)info.mLoader;
    }
    
    @DSVerified("restart content loader, make call to callback")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.024 -0400", hash_original_method = "54BE8D79606278ABB814838D7A2BEC9C", hash_generated_method = "E405CBE6FB4EF75DAE651B6F372BFECF")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        addTaint(callback.getTaint());
        addTaint(args.getTaint());
        addTaint(id);
        if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_1590505732 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_1590505732.addTaint(getTaint());
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_1590505732;
        } //End block
        LoaderInfo info = mLoaders.get(id);
        if(DEBUG){ }        if(info != null)        
        {
            LoaderInfo inactive = mInactiveLoaders.get(id);
            if(inactive != null)            
            {
                if(info.mHaveData)                
                {
                    if(DEBUG){ }                    inactive.mDeliveredData = false;
                    inactive.destroy();
                    info.mLoader.abandon();
                    mInactiveLoaders.put(id, info);
                } //End block
                else
                {
                    if(!info.mStarted)                    
                    {
                        if(DEBUG){ }                        mLoaders.put(id, null);
                        info.destroy();
                    } //End block
                    else
                    {
                        if(info.mPendingLoader != null)                        
                        {
                            if(DEBUG){ }                            info.mPendingLoader.destroy();
                            info.mPendingLoader = null;
                        } //End block
                        if(DEBUG){ }                        info.mPendingLoader = createLoader(id, args, 
                                (LoaderManager.LoaderCallbacks<Object>)callback);
Loader<D> varA0A415B70AD2C3775252A85D08956D6B_1321731627 =                         (Loader<D>)info.mPendingLoader.mLoader;
                        varA0A415B70AD2C3775252A85D08956D6B_1321731627.addTaint(getTaint());
                        return varA0A415B70AD2C3775252A85D08956D6B_1321731627;
                    } //End block
                } //End block
            } //End block
            else
            {
                if(DEBUG){ }                info.mLoader.abandon();
                mInactiveLoaders.put(id, info);
            } //End block
        } //End block
        info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        Loader<D> loader =         (Loader<D>)info.mLoader;
        loader.addTaint(getTaint());
        droidsafeCallbackHook(loader, id, args, callback);

        return loader;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    /**
     * Rip down, tear apart, shred to pieces a current Loader ID.  After returning
     * from this function, any Loader objects associated with this ID are
     * destroyed.  Any data associated with them is destroyed.  You better not
     * be using it when you do this.
     * @param id Identifier of the Loader to be destroyed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.862 -0500", hash_original_method = "97EDF1A6879B8A3D51445AC765920D76", hash_generated_method = "BA1D73EF0CF4A1CC7C188CE340BAAAF8")
    
public void destroyLoader(int id) {
        if (mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        
        if (DEBUG) Log.v(TAG, "destroyLoader in " + this + " of " + id);
        int idx = mLoaders.indexOfKey(id);
        if (idx >= 0) {
            LoaderInfo info = mLoaders.valueAt(idx);
            mLoaders.removeAt(idx);
            info.destroy();
        }
        idx = mInactiveLoaders.indexOfKey(id);
        if (idx >= 0) {
            LoaderInfo info = mInactiveLoaders.valueAt(idx);
            mInactiveLoaders.removeAt(idx);
            info.destroy();
        }
        if (mActivity != null && !hasRunningLoaders()) {
            mActivity.mFragments.startPendingDeferredFragments();
        }
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.029 -0400", hash_original_method = "01DF8472A2697DF2BC7C6D580583CD7C", hash_generated_method = "9DDF16B53974A9BC9240A98B4EEAB066")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> getLoader(int id) {
        addTaint(id);
        if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_333560318 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_333560318.addTaint(getTaint());
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_333560318;
        } //End block
        LoaderInfo loaderInfo = mLoaders.get(id);
        if(loaderInfo != null)        
        {
            if(loaderInfo.mPendingLoader != null)            
            {
Loader<D> varD7DEEECF015803983B03F1336AB68299_1517013931 =                 (Loader<D>)loaderInfo.mPendingLoader.mLoader;
                varD7DEEECF015803983B03F1336AB68299_1517013931.addTaint(getTaint());
                return varD7DEEECF015803983B03F1336AB68299_1517013931;
            } //End block
Loader<D> var9DBC3DF5BD36BC2BA7A9B881B9D6E27D_1797653311 =             (Loader<D>)loaderInfo.mLoader;
            var9DBC3DF5BD36BC2BA7A9B881B9D6E27D_1797653311.addTaint(getTaint());
            return var9DBC3DF5BD36BC2BA7A9B881B9D6E27D_1797653311;
        } //End block
Loader<D> var540C13E9E156B687226421B24F2DF178_678915004 =         null;
        var540C13E9E156B687226421B24F2DF178_678915004.addTaint(getTaint());
        return var540C13E9E156B687226421B24F2DF178_678915004;
        // ---------- Original Method ----------
        //if (mCreatingLoader) {
            //throw new IllegalStateException("Called while creating a loader");
        //}
        //LoaderInfo loaderInfo = mLoaders.get(id);
        //if (loaderInfo != null) {
            //if (loaderInfo.mPendingLoader != null) {
                //return (Loader<D>)loaderInfo.mPendingLoader.mLoader;
            //}
            //return (Loader<D>)loaderInfo.mLoader;
        //}
        //return null;
    }
 
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.867 -0500", hash_original_method = "1B5BA5EF1034DE46362C6D43A3344D88", hash_generated_method = "BC4C6E7AD9DB652B73A35CDD2E831243")
    
void doStart() {
        if (DEBUG) Log.v(TAG, "Starting in " + this);
        if (mStarted) {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            Log.w(TAG, "Called doStart when already started: " + this, e);
            return;
        }
        
        mStarted = true;

        // Call out to sub classes so they can start their loaders
        // Let the existing loaders know that we want to be notified when a load is complete
        for (int i = mLoaders.size()-1; i >= 0; i--) {
            mLoaders.valueAt(i).start();
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.869 -0500", hash_original_method = "71BF743CC69E0B66056EF8CBB16C9843", hash_generated_method = "71BF743CC69E0B66056EF8CBB16C9843")
    
void doStop() {
        if (DEBUG) Log.v(TAG, "Stopping in " + this);
        if (!mStarted) {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            Log.w(TAG, "Called doStop when not started: " + this, e);
            return;
        }

        for (int i = mLoaders.size()-1; i >= 0; i--) {
            mLoaders.valueAt(i).stop();
        }
        mStarted = false;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.872 -0500", hash_original_method = "BD51E42738EB85BB1FB65E8F190FCB03", hash_generated_method = "BD51E42738EB85BB1FB65E8F190FCB03")
    
void doRetain() {
        if (DEBUG) Log.v(TAG, "Retaining in " + this);
        if (!mStarted) {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            Log.w(TAG, "Called doRetain when not started: " + this, e);
            return;
        }

        mRetaining = true;
        mStarted = false;
        for (int i = mLoaders.size()-1; i >= 0; i--) {
            mLoaders.valueAt(i).retain();
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.875 -0500", hash_original_method = "9F7DD5161F3947B5A7B3D4E3274626A8", hash_generated_method = "9F7DD5161F3947B5A7B3D4E3274626A8")
    
void finishRetain() {
        if (mRetaining) {
            if (DEBUG) Log.v(TAG, "Finished Retaining in " + this);

            mRetaining = false;
            for (int i = mLoaders.size()-1; i >= 0; i--) {
                mLoaders.valueAt(i).finishRetain();
            }
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.877 -0500", hash_original_method = "BC9F0E25D287A864E557748845981277", hash_generated_method = "BC9F0E25D287A864E557748845981277")
    
void doReportNextStart() {
        for (int i = mLoaders.size()-1; i >= 0; i--) {
            mLoaders.valueAt(i).mReportNextStart = true;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.879 -0500", hash_original_method = "F7C6DF9C0A34E794980C884EE85C960C", hash_generated_method = "F7C6DF9C0A34E794980C884EE85C960C")
    
void doReportStart() {
        for (int i = mLoaders.size()-1; i >= 0; i--) {
            mLoaders.valueAt(i).reportStart();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.881 -0500", hash_original_method = "8254B059608384C1C895825978701B08", hash_generated_method = "8254B059608384C1C895825978701B08")
    
void doDestroy() {
        if (!mRetaining) {
            if (DEBUG) Log.v(TAG, "Destroying Active in " + this);
            for (int i = mLoaders.size()-1; i >= 0; i--) {
                mLoaders.valueAt(i).destroy();
            }
        }
        
        if (DEBUG) Log.v(TAG, "Destroying Inactive in " + this);
        for (int i = mInactiveLoaders.size()-1; i >= 0; i--) {
            mInactiveLoaders.valueAt(i).destroy();
        }
        mInactiveLoaders.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.883 -0500", hash_original_method = "A45A0DF363CA3802688DC012A3593E66", hash_generated_method = "2F573BF8CA74DE53BCBA9E5EB402B76D")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        return sb.toString();
    }
    
    final class LoaderInfo implements Loader.OnLoadCompleteListener<Object> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.782 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

         int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.785 -0500", hash_original_field = "7B435E447280D5DC4E48D52C3AACF101", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

         Bundle mArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.787 -0500", hash_original_field = "6C4C07AC29F4D4AA01A483F932AC882C", hash_generated_field = "6C4C07AC29F4D4AA01A483F932AC882C")

        LoaderManager.LoaderCallbacks<Object> mCallbacks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.789 -0500", hash_original_field = "CAAC247984B2641B92D4E9BC40D546DA", hash_generated_field = "CAAC247984B2641B92D4E9BC40D546DA")

        Loader<Object> mLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.792 -0500", hash_original_field = "8653C1EEEDD912C5198A3F395AEACFB9", hash_generated_field = "8653C1EEEDD912C5198A3F395AEACFB9")

        boolean mHaveData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.794 -0500", hash_original_field = "E7E3F3C458E363A4280FDF1098E7D079", hash_generated_field = "E7E3F3C458E363A4280FDF1098E7D079")

        boolean mDeliveredData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.796 -0500", hash_original_field = "F7E50CC556DF4A3D9F10FA584C62181F", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

        Object mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.798 -0500", hash_original_field = "8C92DC16A5D2F989C0A1D4375841DEF1", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

        boolean mStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.800 -0500", hash_original_field = "9B9EA230363F2EF227C5BE272DCC6838", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

        boolean mRetaining;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.802 -0500", hash_original_field = "6706C7B993D72CED6D04255D2F46A6E0", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

        boolean mRetainingStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.804 -0500", hash_original_field = "620EE77E057D462DD77FE41E957B6B8F", hash_generated_field = "620EE77E057D462DD77FE41E957B6B8F")

        boolean mReportNextStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.806 -0500", hash_original_field = "708F9D94DA99CD83DBB18AAAFBA8C49F", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

        boolean mDestroyed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.808 -0500", hash_original_field = "AD96D6DFE99122F027819D4D95BE5F11", hash_generated_field = "AD96D6DFE99122F027819D4D95BE5F11")

        boolean mListenerRegistered;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.810 -0500", hash_original_field = "48D26E3132EBDD98F32F802FBADD8F16", hash_generated_field = "48D26E3132EBDD98F32F802FBADD8F16")

        LoaderInfo mPendingLoader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.812 -0500", hash_original_method = "16FA523516D826BD7B81DB6C5F688F57", hash_generated_method = "30D9CD8C7B835F4C7041E5A419646C97")
        
public LoaderInfo(int id, Bundle args, LoaderManager.LoaderCallbacks<Object> callbacks) {
            mId = id;
            mArgs = args;
            mCallbacks = callbacks;
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.815 -0500", hash_original_method = "59414391327A086CB5A9419E1A5D3F4A", hash_generated_method = "12B18D208DA10316CD5E1B0008ABC3B0")
        
void start() {
            if (mRetaining && mRetainingStarted) {
                // Our owner is started, but we were being retained from a
                // previous instance in the started state...  so there is really
                // nothing to do here, since the loaders are still started.
                mStarted = true;
                return;
            }

            if (mStarted) {
                // If loader already started, don't restart.
                return;
            }

            mStarted = true;
            
            if (DEBUG) Log.v(TAG, "  Starting: " + this);
            if (mLoader == null && mCallbacks != null) {
               mLoader = mCallbacks.onCreateLoader(mId, mArgs);
            }
            if (mLoader != null) {
                if (mLoader.getClass().isMemberClass()
                        && !Modifier.isStatic(mLoader.getClass().getModifiers())) {
                    throw new IllegalArgumentException(
                            "Object returned from onCreateLoader must not be a non-static inner member class: "
                            + mLoader);
                }
                if (!mListenerRegistered) {
                    mLoader.registerListener(mId, this);
                    mListenerRegistered = true;
                }
                mLoader.startLoading();
            }
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.817 -0500", hash_original_method = "EEEFF8F43B746CBA4F0DDA0630ACC8F2", hash_generated_method = "EEEFF8F43B746CBA4F0DDA0630ACC8F2")
        
void retain() {
            if (DEBUG) Log.v(TAG, "  Retaining: " + this);
            mRetaining = true;
            mRetainingStarted = mStarted;
            mStarted = false;
            mCallbacks = null;
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.819 -0500", hash_original_method = "A6A41243ADFD2D6E0A8ECB9143919977", hash_generated_method = "A59BB551C3A8CF48919FE5C2F8308131")
        
void finishRetain() {
            if (mRetaining) {
                if (DEBUG) Log.v(TAG, "  Finished Retaining: " + this);
                mRetaining = false;
                if (mStarted != mRetainingStarted) {
                    if (!mStarted) {
                        // This loader was retained in a started state, but
                        // at the end of retaining everything our owner is
                        // no longer started...  so make it stop.
                        stop();
                    }
                }
            }

            if (mStarted && mHaveData && !mReportNextStart) {
                // This loader has retained its data, either completely across
                // a configuration change or just whatever the last data set
                // was after being restarted from a stop, and now at the point of
                // finishing the retain we find we remain started, have
                // our data, and the owner has a new callback...  so
                // let's deliver the data now.
                callOnLoadFinished(mLoader, mData);
            }
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.821 -0500", hash_original_method = "915BC416A2513DED4BAC846F5B62B555", hash_generated_method = "915BC416A2513DED4BAC846F5B62B555")
        
void reportStart() {
            if (mStarted) {
                if (mReportNextStart) {
                    mReportNextStart = false;
                    if (mHaveData) {
                        callOnLoadFinished(mLoader, mData);
                    }
                }
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.823 -0500", hash_original_method = "2CBDFC8D776F45EC911F1F96CF447373", hash_generated_method = "84565F234F315EB6A98E0B5779C43E16")
        
void stop() {
            if (DEBUG) Log.v(TAG, "  Stopping: " + this);
            mStarted = false;
            if (!mRetaining) {
                if (mLoader != null && mListenerRegistered) {
                    // Let the loader know we're done with it
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                    mLoader.stopLoading();
                }
            }
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.827 -0500", hash_original_method = "A36048C3C1A3E46AC40E97896DEEAF8F", hash_generated_method = "A36048C3C1A3E46AC40E97896DEEAF8F")
        
void destroy() {
            if (DEBUG) Log.v(TAG, "  Destroying: " + this);
            mDestroyed = true;
            boolean needReset = mDeliveredData;
            mDeliveredData = false;
            if (mCallbacks != null && mLoader != null && mHaveData && needReset) {
                if (DEBUG) Log.v(TAG, "  Reseting: " + this);
                String lastBecause = null;
                if (mActivity != null) {
                    lastBecause = mActivity.mFragments.mNoTransactionsBecause;
                    mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
                }
                try {
                    mCallbacks.onLoaderReset(mLoader);
                } finally {
                    if (mActivity != null) {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    }
                }
            }
            mCallbacks = null;
            mData = null;
            mHaveData = false;
            if (mLoader != null) {
                if (mListenerRegistered) {
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                }
                mLoader.reset();
            }
            if (mPendingLoader != null) {
                mPendingLoader.destroy();
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.830 -0500", hash_original_method = "5D6E68340AACAB27821B5B5851C94699", hash_generated_method = "88E9F98DB6600345E8FEB07B27EA2E73")
        
@Override public void onLoadComplete(Loader<Object> loader, Object data) {
            if (DEBUG) Log.v(TAG, "onLoadComplete: " + this);
            
            if (mDestroyed) {
                if (DEBUG) Log.v(TAG, "  Ignoring load complete -- destroyed");
                return;
            }

            if (mLoaders.get(mId) != this) {
                // This data is not coming from the current active loader.
                // We don't care about it.
                if (DEBUG) Log.v(TAG, "  Ignoring load complete -- not active");
                return;
            }
            
            LoaderInfo pending = mPendingLoader;
            if (pending != null) {
                // There is a new request pending and we were just
                // waiting for the old one to complete before starting
                // it.  So now it is time, switch over to the new loader.
                if (DEBUG) Log.v(TAG, "  Switching to pending loader: " + pending);
                mPendingLoader = null;
                mLoaders.put(mId, null);
                destroy();
                installLoader(pending);
                return;
            }
            
            // Notify of the new data so the app can switch out the old data before
            // we try to destroy it.
            if (mData != data || !mHaveData) {
                mData = data;
                mHaveData = true;
                if (mStarted) {
                    callOnLoadFinished(loader, data);
                }
            }

            //if (DEBUG) Log.v(TAG, "  onLoadFinished returned: " + this);

            // We have now given the application the new loader with its
            // loaded data, so it should have stopped using the previous
            // loader.  If there is a previous loader on the inactive list,
            // clean it up.
            LoaderInfo info = mInactiveLoaders.get(mId);
            if (info != null && info != this) {
                info.mDeliveredData = false;
                info.destroy();
                mInactiveLoaders.remove(mId);
            }

            if (mActivity != null && !hasRunningLoaders()) {
                mActivity.mFragments.startPendingDeferredFragments();
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.833 -0500", hash_original_method = "DBCF4A7424D3CE3FF77E30E5C5EDA97C", hash_generated_method = "DBCF4A7424D3CE3FF77E30E5C5EDA97C")
        
void callOnLoadFinished(Loader<Object> loader, Object data) {
            if (mCallbacks != null) {
                String lastBecause = null;
                if (mActivity != null) {
                    lastBecause = mActivity.mFragments.mNoTransactionsBecause;
                    mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
                }
                try {
                    if (DEBUG) Log.v(TAG, "  onLoadFinished in " + loader + ": "
                            + loader.dataToString(data));
                    mCallbacks.onLoadFinished(loader, data);
                } finally {
                    if (mActivity != null) {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    }
                }
                mDeliveredData = true;
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.836 -0500", hash_original_method = "6152E6E73795403DAC53E06540200214", hash_generated_method = "FC6A6C7BEB09F74E956A4DE307491705")
        
@Override
        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }

        @DSSink({DSSinkKind.FILE})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.839 -0500", hash_original_method = "130B539E0C9D3012BFA3C99178E2C6F6", hash_generated_method = "118927D2D3B68F4DDA7767AFFFDD5C05")
        
public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.print(prefix); writer.print("mId="); writer.print(mId);
                    writer.print(" mArgs="); writer.println(mArgs);
            writer.print(prefix); writer.print("mCallbacks="); writer.println(mCallbacks);
            writer.print(prefix); writer.print("mLoader="); writer.println(mLoader);
            if (mLoader != null) {
                mLoader.dump(prefix + "  ", fd, writer, args);
            }
            if (mHaveData || mDeliveredData) {
                writer.print(prefix); writer.print("mHaveData="); writer.print(mHaveData);
                        writer.print("  mDeliveredData="); writer.println(mDeliveredData);
                writer.print(prefix); writer.print("mData="); writer.println(mData);
            }
            writer.print(prefix); writer.print("mStarted="); writer.print(mStarted);
                    writer.print(" mReportNextStart="); writer.print(mReportNextStart);
                    writer.print(" mDestroyed="); writer.println(mDestroyed);
            writer.print(prefix); writer.print("mRetaining="); writer.print(mRetaining);
                    writer.print(" mRetainingStarted="); writer.print(mRetainingStarted);
                    writer.print(" mListenerRegistered="); writer.println(mListenerRegistered);
            if (mPendingLoader != null) {
                writer.print(prefix); writer.println("Pending Loader ");
                        writer.print(mPendingLoader); writer.println(":");
                mPendingLoader.dump(prefix + "  ", fd, writer, args);
            }
        }
        
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.886 -0500", hash_original_method = "469C164486863607CE4F221F1C14A350", hash_generated_method = "E9420D75CB8EEC741B9211CF7195943D")
    
@Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        if (mLoaders.size() > 0) {
            writer.print(prefix); writer.println("Active Loaders:");
            String innerPrefix = prefix + "    ";
            for (int i=0; i < mLoaders.size(); i++) {
                LoaderInfo li = mLoaders.valueAt(i);
                writer.print(prefix); writer.print("  #"); writer.print(mLoaders.keyAt(i));
                        writer.print(": "); writer.println(li.toString());
                li.dump(innerPrefix, fd, writer, args);
            }
        }
        if (mInactiveLoaders.size() > 0) {
            writer.print(prefix); writer.println("Inactive Loaders:");
            String innerPrefix = prefix + "    ";
            for (int i=0; i < mInactiveLoaders.size(); i++) {
                LoaderInfo li = mInactiveLoaders.valueAt(i);
                writer.print(prefix); writer.print("  #"); writer.print(mInactiveLoaders.keyAt(i));
                        writer.print(": "); writer.println(li.toString());
                li.dump(innerPrefix, fd, writer, args);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:23.888 -0500", hash_original_method = "3F0C9C3E43C354715EA08050096B7736", hash_generated_method = "083E3E01FDF07E035BC3F0EFE95D6507")
    
public boolean hasRunningLoaders() {
        boolean loadersRunning = false;
        final int count = mLoaders.size();
        for (int i = 0; i < count; i++) {
            final LoaderInfo li = mLoaders.valueAt(i);
            loadersRunning |= li.mStarted && !li.mDeliveredData;
        }
        return loadersRunning;
    }
}

