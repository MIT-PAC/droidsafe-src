package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public abstract class LoaderManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.152 -0400", hash_original_method = "921B150ED82AB2739CD0194A062DB550", hash_generated_method = "921B150ED82AB2739CD0194A062DB550")
    public LoaderManager ()
    {
        //Synthesized constructor
    }


    public abstract <D> Loader<D> initLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<D> callback);

    
    public abstract <D> Loader<D> restartLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<D> callback);

    
    public abstract void destroyLoader(int id);

    
    public abstract <D> Loader<D> getLoader(int id);

    
    public abstract void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args);

    
        public static void enableDebugLogging(boolean enabled) {
        LoaderManagerImpl.DEBUG = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.154 -0400", hash_original_method = "59280299B88BC81400789A85A7BD24F4", hash_generated_method = "492CD06F4EE82849FBD67D0D15AE6A39")
    public boolean hasRunningLoaders() {
        boolean var68934A3E9455FA72420237EB05902327_2098696153 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2072662821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2072662821;
        // ---------- Original Method ----------
        //return false;
    }

    
    public interface LoaderCallbacks<D> {
        
        public Loader<D> onCreateLoader(int id, Bundle args);

        
        public void onLoadFinished(Loader<D> loader, D data);

        
        public void onLoaderReset(Loader<D> loader);
    }
    
}

class LoaderManagerImpl extends LoaderManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.154 -0400", hash_original_field = "581A48C88B1F4455461B49B9FED0F6E5", hash_generated_field = "F7D0C10CD91FC35F4677D918BBC06CFE")

    final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.155 -0400", hash_original_field = "7DAAE059AA586D05F0C81A3816E7F517", hash_generated_field = "432E345626C0D17D30ADB55101BDE065")

    final SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.155 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "7ECAB8F1DFD4D8C88111D51780B29562")

    String mWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.155 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "DC6970CAF75184DB6DB1AAC52EA720C0")

    FragmentActivity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.155 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

    boolean mStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.155 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.155 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

    boolean mRetainingStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.155 -0400", hash_original_field = "543608B879D1153972FED6E1BBB3F2C2", hash_generated_field = "70C1252034BC616F659C7E09E95F15EB")

    boolean mCreatingLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.156 -0400", hash_original_method = "8A8E6D86E6D6B2C8C93367E841E4998B", hash_generated_method = "6C4A23BB54B986C26908C5D945FDD353")
      LoaderManagerImpl(String who, FragmentActivity activity, boolean started) {
        mWho = who;
        mActivity = activity;
        mStarted = started;
        // ---------- Original Method ----------
        //mWho = who;
        //mActivity = activity;
        //mStarted = started;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.156 -0400", hash_original_method = "39148A68E08215CAB837BA67F40FAA62", hash_generated_method = "FD7298AAA1462E00D71BDFDBAB50C6A6")
     void updateActivity(FragmentActivity activity) {
        mActivity = activity;
        // ---------- Original Method ----------
        //mActivity = activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.156 -0400", hash_original_method = "31DF1B394D718AFF7F9D42E1B24A1D9F", hash_generated_method = "BB9625BF6719383205EBF83C475F6955")
    private LoaderInfo createLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        addTaint(callback.getTaint());
        addTaint(args.getTaint());
        addTaint(id);
        LoaderInfo info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        Loader<Object> loader = callback.onCreateLoader(id, args);
        info.mLoader = (Loader<Object>)loader;
LoaderInfo var43CF3338FDBA93597A9562D3166E9DC4_856484873 =         info;
        var43CF3338FDBA93597A9562D3166E9DC4_856484873.addTaint(taint);
        return var43CF3338FDBA93597A9562D3166E9DC4_856484873;
        // ---------- Original Method ----------
        //LoaderInfo info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        //Loader<Object> loader = callback.onCreateLoader(id, args);
        //info.mLoader = (Loader<Object>)loader;
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.157 -0400", hash_original_method = "D2BDC915DCB9CB038EA75210255617B9", hash_generated_method = "D125B01C4CF4CBCAEC8437357726F782")
    private LoaderInfo createAndInstallLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        addTaint(callback.getTaint());
        addTaint(args.getTaint());
        addTaint(id);
        try 
        {
            mCreatingLoader = true;
            LoaderInfo info = createLoader(id, args, callback);
            installLoader(info);
LoaderInfo var43CF3338FDBA93597A9562D3166E9DC4_537693289 =             info;
            var43CF3338FDBA93597A9562D3166E9DC4_537693289.addTaint(taint);
            return var43CF3338FDBA93597A9562D3166E9DC4_537693289;
        } //End block
        finally 
        {
            mCreatingLoader = false;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mCreatingLoader = true;
            //LoaderInfo info = createLoader(id, args, callback);
            //installLoader(info);
            //return info;
        //} finally {
            //mCreatingLoader = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.157 -0400", hash_original_method = "112626D5EBE4C2D89FE7194A836F5D8E", hash_generated_method = "6604F87A604CD5B12FB34F7CC7833721")
     void installLoader(LoaderInfo info) {
        addTaint(info.getTaint());
        mLoaders.put(info.mId, info);
    if(mStarted)        
        {
            info.start();
        } //End block
        // ---------- Original Method ----------
        //mLoaders.put(info.mId, info);
        //if (mStarted) {
            //info.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.158 -0400", hash_original_method = "E04CC49F77F654C9D0B54FC39C94F2D8", hash_generated_method = "0E9B7B4E8D3048CF4B68FD821534E16A")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        addTaint(callback.getTaint());
        addTaint(args.getTaint());
        addTaint(id);
    if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_1942650603 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_1942650603.addTaint(taint);
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_1942650603;
        } //End block
        LoaderInfo info = mLoaders.get(id);
    if(DEBUG){ }    if(info == null)        
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
Loader<D> var75A6A3900136EAA1B4E4C3D43F1802B1_1585413132 =         (Loader<D>)info.mLoader;
        var75A6A3900136EAA1B4E4C3D43F1802B1_1585413132.addTaint(taint);
        return var75A6A3900136EAA1B4E4C3D43F1802B1_1585413132;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.159 -0400", hash_original_method = "54BE8D79606278ABB814838D7A2BEC9C", hash_generated_method = "36E7F114EC43F9BF1A27DFC729A88896")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        addTaint(callback.getTaint());
        addTaint(args.getTaint());
        addTaint(id);
    if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_1194920441 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_1194920441.addTaint(taint);
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_1194920441;
        } //End block
        LoaderInfo info = mLoaders.get(id);
    if(DEBUG){ }    if(info != null)        
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
Loader<D> varA0A415B70AD2C3775252A85D08956D6B_134864925 =                         (Loader<D>)info.mPendingLoader.mLoader;
                        varA0A415B70AD2C3775252A85D08956D6B_134864925.addTaint(taint);
                        return varA0A415B70AD2C3775252A85D08956D6B_134864925;
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
Loader<D> var75A6A3900136EAA1B4E4C3D43F1802B1_1700926405 =         (Loader<D>)info.mLoader;
        var75A6A3900136EAA1B4E4C3D43F1802B1_1700926405.addTaint(taint);
        return var75A6A3900136EAA1B4E4C3D43F1802B1_1700926405;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.160 -0400", hash_original_method = "97EDF1A6879B8A3D51445AC765920D76", hash_generated_method = "62D0707309BAD5EB6AE3C856F221A88D")
    public void destroyLoader(int id) {
        addTaint(id);
    if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_2089638052 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_2089638052.addTaint(taint);
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_2089638052;
        } //End block
    if(DEBUG){ }        int idx = mLoaders.indexOfKey(id);
    if(idx >= 0)        
        {
            LoaderInfo info = mLoaders.valueAt(idx);
            mLoaders.removeAt(idx);
            info.destroy();
        } //End block
        idx = mInactiveLoaders.indexOfKey(id);
    if(idx >= 0)        
        {
            LoaderInfo info = mInactiveLoaders.valueAt(idx);
            mInactiveLoaders.removeAt(idx);
            info.destroy();
        } //End block
    if(mActivity != null && !hasRunningLoaders())        
        {
            mActivity.mFragments.startPendingDeferredFragments();
        } //End block
        // ---------- Original Method ----------
        //if (mCreatingLoader) {
            //throw new IllegalStateException("Called while creating a loader");
        //}
        //if (DEBUG) Log.v(TAG, "destroyLoader in " + this + " of " + id);
        //int idx = mLoaders.indexOfKey(id);
        //if (idx >= 0) {
            //LoaderInfo info = mLoaders.valueAt(idx);
            //mLoaders.removeAt(idx);
            //info.destroy();
        //}
        //idx = mInactiveLoaders.indexOfKey(id);
        //if (idx >= 0) {
            //LoaderInfo info = mInactiveLoaders.valueAt(idx);
            //mInactiveLoaders.removeAt(idx);
            //info.destroy();
        //}
        //if (mActivity != null && !hasRunningLoaders()) {
            //mActivity.mFragments.startPendingDeferredFragments();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.161 -0400", hash_original_method = "01DF8472A2697DF2BC7C6D580583CD7C", hash_generated_method = "9CAEA63EEF2D8CDCB0EDF47F16C2440B")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> getLoader(int id) {
        addTaint(id);
    if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_2051055015 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_2051055015.addTaint(taint);
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_2051055015;
        } //End block
        LoaderInfo loaderInfo = mLoaders.get(id);
    if(loaderInfo != null)        
        {
    if(loaderInfo.mPendingLoader != null)            
            {
Loader<D> varD7DEEECF015803983B03F1336AB68299_493757253 =                 (Loader<D>)loaderInfo.mPendingLoader.mLoader;
                varD7DEEECF015803983B03F1336AB68299_493757253.addTaint(taint);
                return varD7DEEECF015803983B03F1336AB68299_493757253;
            } //End block
Loader<D> var9DBC3DF5BD36BC2BA7A9B881B9D6E27D_657002691 =             (Loader<D>)loaderInfo.mLoader;
            var9DBC3DF5BD36BC2BA7A9B881B9D6E27D_657002691.addTaint(taint);
            return var9DBC3DF5BD36BC2BA7A9B881B9D6E27D_657002691;
        } //End block
Loader<D> var540C13E9E156B687226421B24F2DF178_1068897030 =         null;
        var540C13E9E156B687226421B24F2DF178_1068897030.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1068897030;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.161 -0400", hash_original_method = "1B5BA5EF1034DE46362C6D43A3344D88", hash_generated_method = "44B4C78C42F2F803BE409A0A1DAAC173")
     void doStart() {
    if(DEBUG){ }    if(mStarted)        
        {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            return;
        } //End block
        mStarted = true;
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).start();
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "Starting in " + this);
        //if (mStarted) {
            //RuntimeException e = new RuntimeException("here");
            //e.fillInStackTrace();
            //Log.w(TAG, "Called doStart when already started: " + this, e);
            //return;
        //}
        //mStarted = true;
        //for (int i = mLoaders.size()-1; i >= 0; i--) {
            //mLoaders.valueAt(i).start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.162 -0400", hash_original_method = "71BF743CC69E0B66056EF8CBB16C9843", hash_generated_method = "A02C6413885F34B2043666BA8DB54D1C")
     void doStop() {
    if(DEBUG){ }    if(!mStarted)        
        {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            return;
        } //End block
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).stop();
        } //End block
        mStarted = false;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "Stopping in " + this);
        //if (!mStarted) {
            //RuntimeException e = new RuntimeException("here");
            //e.fillInStackTrace();
            //Log.w(TAG, "Called doStop when not started: " + this, e);
            //return;
        //}
        //for (int i = mLoaders.size()-1; i >= 0; i--) {
            //mLoaders.valueAt(i).stop();
        //}
        //mStarted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.162 -0400", hash_original_method = "BD51E42738EB85BB1FB65E8F190FCB03", hash_generated_method = "8C952EF8B307332F0EF8B649716A88C0")
     void doRetain() {
    if(DEBUG){ }    if(!mStarted)        
        {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            return;
        } //End block
        mRetaining = true;
        mStarted = false;
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).retain();
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "Retaining in " + this);
        //if (!mStarted) {
            //RuntimeException e = new RuntimeException("here");
            //e.fillInStackTrace();
            //Log.w(TAG, "Called doRetain when not started: " + this, e);
            //return;
        //}
        //mRetaining = true;
        //mStarted = false;
        //for (int i = mLoaders.size()-1; i >= 0; i--) {
            //mLoaders.valueAt(i).retain();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.163 -0400", hash_original_method = "9F7DD5161F3947B5A7B3D4E3274626A8", hash_generated_method = "3159F2DC0474255D6F7687D7EDBD8FB1")
     void finishRetain() {
    if(mRetaining)        
        {
    if(DEBUG){ }            mRetaining = false;
for(int i = mLoaders.size()-1;i >= 0;i--)
            {
                mLoaders.valueAt(i).finishRetain();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mRetaining) {
            //if (DEBUG) Log.v(TAG, "Finished Retaining in " + this);
            //mRetaining = false;
            //for (int i = mLoaders.size()-1; i >= 0; i--) {
                //mLoaders.valueAt(i).finishRetain();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.163 -0400", hash_original_method = "BC9F0E25D287A864E557748845981277", hash_generated_method = "74F058892DF11136B396EA7422AE2D1C")
     void doReportNextStart() {
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).mReportNextStart = true;
        } //End block
        // ---------- Original Method ----------
        //for (int i = mLoaders.size()-1; i >= 0; i--) {
            //mLoaders.valueAt(i).mReportNextStart = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.163 -0400", hash_original_method = "F7C6DF9C0A34E794980C884EE85C960C", hash_generated_method = "6B679AFD8B93318DBB7C14CA0C48E4FB")
     void doReportStart() {
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).reportStart();
        } //End block
        // ---------- Original Method ----------
        //for (int i = mLoaders.size()-1; i >= 0; i--) {
            //mLoaders.valueAt(i).reportStart();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.164 -0400", hash_original_method = "736E3BF19FA9B5737831BA1044201B86", hash_generated_method = "FFBDEFE40B4B8FB7B934FD12F2163AD3")
     void doDestroy() {
    if(!mRetaining)        
        {
    if(DEBUG){ }for(int i = mLoaders.size()-1;i >= 0;i--)
            {
                mLoaders.valueAt(i).destroy();
            } //End block
            mLoaders.clear();
        } //End block
    if(DEBUG){ }for(int i = mInactiveLoaders.size()-1;i >= 0;i--)
        {
            mInactiveLoaders.valueAt(i).destroy();
        } //End block
        mInactiveLoaders.clear();
        // ---------- Original Method ----------
        //if (!mRetaining) {
            //if (DEBUG) Log.v(TAG, "Destroying Active in " + this);
            //for (int i = mLoaders.size()-1; i >= 0; i--) {
                //mLoaders.valueAt(i).destroy();
            //}
            //mLoaders.clear();
        //}
        //if (DEBUG) Log.v(TAG, "Destroying Inactive in " + this);
        //for (int i = mInactiveLoaders.size()-1; i >= 0; i--) {
            //mInactiveLoaders.valueAt(i).destroy();
        //}
        //mInactiveLoaders.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.165 -0400", hash_original_method = "A45A0DF363CA3802688DC012A3593E66", hash_generated_method = "ECE92AC28BCDC908B8A5727BADF26134")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
String var2460B846747F8B22185AD8BE722266A5_1286582260 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1286582260.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1286582260;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("LoaderManager{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(" in ");
        //DebugUtils.buildShortClassTag(mActivity, sb);
        //sb.append("}}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.166 -0400", hash_original_method = "469C164486863607CE4F221F1C14A350", hash_generated_method = "F07305D376E4565BC6FE225BF47B0DD2")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
    if(mLoaders.size() > 0)        
        {
            writer.print(prefix);
            writer.println("Active Loaders:");
            String innerPrefix = prefix + "    ";
for(int i=0;i < mLoaders.size();i++)
            {
                LoaderInfo li = mLoaders.valueAt(i);
                writer.print(prefix);
                writer.print("  #");
                writer.print(mLoaders.keyAt(i));
                writer.print(": ");
                writer.println(li.toString());
                li.dump(innerPrefix, fd, writer, args);
            } //End block
        } //End block
    if(mInactiveLoaders.size() > 0)        
        {
            writer.print(prefix);
            writer.println("Inactive Loaders:");
            String innerPrefix = prefix + "    ";
for(int i=0;i < mInactiveLoaders.size();i++)
            {
                LoaderInfo li = mInactiveLoaders.valueAt(i);
                writer.print(prefix);
                writer.print("  #");
                writer.print(mInactiveLoaders.keyAt(i));
                writer.print(": ");
                writer.println(li.toString());
                li.dump(innerPrefix, fd, writer, args);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.167 -0400", hash_original_method = "3F0C9C3E43C354715EA08050096B7736", hash_generated_method = "1BE719448B9F3C6644ECDC6C6E8136D1")
    @Override
    public boolean hasRunningLoaders() {
        boolean loadersRunning = false;
        final int count = mLoaders.size();
for(int i = 0;i < count;i++)
        {
            final LoaderInfo li = mLoaders.valueAt(i);
            loadersRunning |= li.mStarted && !li.mDeliveredData;
        } //End block
        boolean var606D8489253BD9E9D91CEB4E75BDD667_1507963979 = (loadersRunning);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122465504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122465504;
        // ---------- Original Method ----------
        //boolean loadersRunning = false;
        //final int count = mLoaders.size();
        //for (int i = 0; i < count; i++) {
            //final LoaderInfo li = mLoaders.valueAt(i);
            //loadersRunning |= li.mStarted && !li.mDeliveredData;
        //}
        //return loadersRunning;
    }

    
    final class LoaderInfo implements Loader.OnLoadCompleteListener<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.167 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

        int mId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.167 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "6C4C07AC29F4D4AA01A483F932AC882C")

        LoaderManager.LoaderCallbacks<Object> mCallbacks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "80FF3862892C05890CE6715239D5E8AB", hash_generated_field = "CAAC247984B2641B92D4E9BC40D546DA")

        Loader<Object> mLoader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "3E6578FC76C21F1A7CAE156E12A3C9E7", hash_generated_field = "8653C1EEEDD912C5198A3F395AEACFB9")

        boolean mHaveData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "3670C33CC4ABF71ACE43E5EE0ECFE123", hash_generated_field = "E7E3F3C458E363A4280FDF1098E7D079")

        boolean mDeliveredData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

        Object mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

        boolean mStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

        boolean mRetaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

        boolean mRetainingStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "8DBA0029FAB59A1B665D7DEA39DF2B1A", hash_generated_field = "620EE77E057D462DD77FE41E957B6B8F")

        boolean mReportNextStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

        boolean mDestroyed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "B0EC9D56AB3AFD18C789DC47DFF0EB6B", hash_generated_field = "AD96D6DFE99122F027819D4D95BE5F11")

        boolean mListenerRegistered;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.168 -0400", hash_original_field = "BFD46B06A9331820E543FDC5B0775B98", hash_generated_field = "48D26E3132EBDD98F32F802FBADD8F16")

        LoaderInfo mPendingLoader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.169 -0400", hash_original_method = "16FA523516D826BD7B81DB6C5F688F57", hash_generated_method = "B1787A946F4FAE1D5E958B14E046210B")
        public  LoaderInfo(int id, Bundle args, LoaderManager.LoaderCallbacks<Object> callbacks) {
            mId = id;
            mArgs = args;
            mCallbacks = callbacks;
            // ---------- Original Method ----------
            //mId = id;
            //mArgs = args;
            //mCallbacks = callbacks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.170 -0400", hash_original_method = "59414391327A086CB5A9419E1A5D3F4A", hash_generated_method = "2970ED61C9804AA1A5E77D2B91F48A90")
         void start() {
    if(mRetaining && mRetainingStarted)            
            {
                mStarted = true;
                return;
            } //End block
    if(mStarted)            
            {
                return;
            } //End block
            mStarted = true;
    if(DEBUG){ }    if(mLoader == null && mCallbacks != null)            
            {
                mLoader = mCallbacks.onCreateLoader(mId, mArgs);
            } //End block
    if(mLoader != null)            
            {
    if(mLoader.getClass().isMemberClass()
                        && !Modifier.isStatic(mLoader.getClass().getModifiers()))                
                {
                    IllegalArgumentException var4B8346B77A5BF415573A735E89DFAAA9_991329066 = new IllegalArgumentException(
                            "Object returned from onCreateLoader must not be a non-static inner member class: "
                            + mLoader);
                    var4B8346B77A5BF415573A735E89DFAAA9_991329066.addTaint(taint);
                    throw var4B8346B77A5BF415573A735E89DFAAA9_991329066;
                } //End block
    if(!mListenerRegistered)                
                {
                    mLoader.registerListener(mId, this);
                    mListenerRegistered = true;
                } //End block
                mLoader.startLoading();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.171 -0400", hash_original_method = "EEEFF8F43B746CBA4F0DDA0630ACC8F2", hash_generated_method = "AAE016661F320F56649073D3D751B676")
         void retain() {
    if(DEBUG){ }            mRetaining = true;
            mRetainingStarted = mStarted;
            mStarted = false;
            mCallbacks = null;
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "  Retaining: " + this);
            //mRetaining = true;
            //mRetainingStarted = mStarted;
            //mStarted = false;
            //mCallbacks = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.171 -0400", hash_original_method = "A6A41243ADFD2D6E0A8ECB9143919977", hash_generated_method = "50BF206D479089E3EB2EF78FF702712F")
         void finishRetain() {
    if(mRetaining)            
            {
    if(DEBUG){ }                mRetaining = false;
    if(mStarted != mRetainingStarted)                
                {
    if(!mStarted)                    
                    {
                        stop();
                    } //End block
                } //End block
            } //End block
    if(mStarted && mHaveData && !mReportNextStart)            
            {
                callOnLoadFinished(mLoader, mData);
            } //End block
            // ---------- Original Method ----------
            //if (mRetaining) {
                //if (DEBUG) Log.v(TAG, "  Finished Retaining: " + this);
                //mRetaining = false;
                //if (mStarted != mRetainingStarted) {
                    //if (!mStarted) {
                        //stop();
                    //}
                //}
            //}
            //if (mStarted && mHaveData && !mReportNextStart) {
                //callOnLoadFinished(mLoader, mData);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.171 -0400", hash_original_method = "915BC416A2513DED4BAC846F5B62B555", hash_generated_method = "2515B7A113E051098A1F769DE291622B")
         void reportStart() {
    if(mStarted)            
            {
    if(mReportNextStart)                
                {
                    mReportNextStart = false;
    if(mHaveData)                    
                    {
                        callOnLoadFinished(mLoader, mData);
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (mStarted) {
                //if (mReportNextStart) {
                    //mReportNextStart = false;
                    //if (mHaveData) {
                        //callOnLoadFinished(mLoader, mData);
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.172 -0400", hash_original_method = "2CBDFC8D776F45EC911F1F96CF447373", hash_generated_method = "E5ACD222CD63F167A67AD1AEBFB954D9")
         void stop() {
    if(DEBUG){ }            mStarted = false;
    if(!mRetaining)            
            {
    if(mLoader != null && mListenerRegistered)                
                {
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                    mLoader.stopLoading();
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "  Stopping: " + this);
            //mStarted = false;
            //if (!mRetaining) {
                //if (mLoader != null && mListenerRegistered) {
                    //mListenerRegistered = false;
                    //mLoader.unregisterListener(this);
                    //mLoader.stopLoading();
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.173 -0400", hash_original_method = "A36048C3C1A3E46AC40E97896DEEAF8F", hash_generated_method = "A354DDDC8956DB4281E1EA7204A66E55")
         void destroy() {
    if(DEBUG){ }            mDestroyed = true;
            boolean needReset = mDeliveredData;
            mDeliveredData = false;
    if(mCallbacks != null && mLoader != null && mHaveData && needReset)            
            {
    if(DEBUG){ }                String lastBecause = null;
    if(mActivity != null)                
                {
                    lastBecause = mActivity.mFragments.mNoTransactionsBecause;
                    mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
                } //End block
                try 
                {
                    mCallbacks.onLoaderReset(mLoader);
                } //End block
                finally 
                {
    if(mActivity != null)                    
                    {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    } //End block
                } //End block
            } //End block
            mCallbacks = null;
            mData = null;
            mHaveData = false;
    if(mLoader != null)            
            {
    if(mListenerRegistered)                
                {
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                } //End block
                mLoader.reset();
            } //End block
    if(mPendingLoader != null)            
            {
                mPendingLoader.destroy();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.175 -0400", hash_original_method = "5D6E68340AACAB27821B5B5851C94699", hash_generated_method = "7171DBD7033371002C95648D2C22BBD1")
        @Override
        public void onLoadComplete(Loader<Object> loader, Object data) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(loader.getTaint());
    if(DEBUG){ }    if(mDestroyed)            
            {
    if(DEBUG){ }                return;
            } //End block
    if(mLoaders.get(mId) != this)            
            {
    if(DEBUG){ }                return;
            } //End block
            LoaderInfo pending = mPendingLoader;
    if(pending != null)            
            {
    if(DEBUG){ }                mPendingLoader = null;
                mLoaders.put(mId, null);
                destroy();
                installLoader(pending);
                return;
            } //End block
    if(mData != data || !mHaveData)            
            {
                mData = data;
                mHaveData = true;
    if(mStarted)                
                {
                    callOnLoadFinished(loader, data);
                } //End block
            } //End block
            LoaderInfo info = mInactiveLoaders.get(mId);
    if(info != null && info != this)            
            {
                info.mDeliveredData = false;
                info.destroy();
                mInactiveLoaders.remove(mId);
            } //End block
    if(mActivity != null && !hasRunningLoaders())            
            {
                mActivity.mFragments.startPendingDeferredFragments();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.177 -0400", hash_original_method = "DBCF4A7424D3CE3FF77E30E5C5EDA97C", hash_generated_method = "D9CD2462F7A0D9E8FD045E74C48C320C")
         void callOnLoadFinished(Loader<Object> loader, Object data) {
            addTaint(data.getTaint());
            addTaint(loader.getTaint());
    if(mCallbacks != null)            
            {
                String lastBecause = null;
    if(mActivity != null)                
                {
                    lastBecause = mActivity.mFragments.mNoTransactionsBecause;
                    mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
                } //End block
                try 
                {
    if(DEBUG){ }                    mCallbacks.onLoadFinished(loader, data);
                } //End block
                finally 
                {
    if(mActivity != null)                    
                    {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    } //End block
                } //End block
                mDeliveredData = true;
            } //End block
            // ---------- Original Method ----------
            //if (mCallbacks != null) {
                //String lastBecause = null;
                //if (mActivity != null) {
                    //lastBecause = mActivity.mFragments.mNoTransactionsBecause;
                    //mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
                //}
                //try {
                    //if (DEBUG) Log.v(TAG, "  onLoadFinished in " + loader + ": "
                            //+ loader.dataToString(data));
                    //mCallbacks.onLoadFinished(loader, data);
                //} finally {
                    //if (mActivity != null) {
                        //mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    //}
                //}
                //mDeliveredData = true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.178 -0400", hash_original_method = "6152E6E73795403DAC53E06540200214", hash_generated_method = "5514AA956E448AAE221D493FB70602FB")
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
String var2460B846747F8B22185AD8BE722266A5_1888004109 =             sb.toString();
            var2460B846747F8B22185AD8BE722266A5_1888004109.addTaint(taint);
            return var2460B846747F8B22185AD8BE722266A5_1888004109;
            // ---------- Original Method ----------
            //StringBuilder sb = new StringBuilder(64);
            //sb.append("LoaderInfo{");
            //sb.append(Integer.toHexString(System.identityHashCode(this)));
            //sb.append(" #");
            //sb.append(mId);
            //sb.append(" : ");
            //DebugUtils.buildShortClassTag(mLoader, sb);
            //sb.append("}}");
            //return sb.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.180 -0400", hash_original_method = "130B539E0C9D3012BFA3C99178E2C6F6", hash_generated_method = "23A138D4FE06A47449222DF9FDF6FE74")
        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            addTaint(args[0].getTaint());
            addTaint(writer.getTaint());
            addTaint(fd.getTaint());
            addTaint(prefix.getTaint());
            writer.print(prefix);
            writer.print("mId=");
            writer.print(mId);
            writer.print(" mArgs=");
            writer.println(mArgs);
            writer.print(prefix);
            writer.print("mCallbacks=");
            writer.println(mCallbacks);
            writer.print(prefix);
            writer.print("mLoader=");
            writer.println(mLoader);
    if(mLoader != null)            
            {
                mLoader.dump(prefix + "  ", fd, writer, args);
            } //End block
    if(mHaveData || mDeliveredData)            
            {
                writer.print(prefix);
                writer.print("mHaveData=");
                writer.print(mHaveData);
                writer.print("  mDeliveredData=");
                writer.println(mDeliveredData);
                writer.print(prefix);
                writer.print("mData=");
                writer.println(mData);
            } //End block
            writer.print(prefix);
            writer.print("mStarted=");
            writer.print(mStarted);
            writer.print(" mReportNextStart=");
            writer.print(mReportNextStart);
            writer.print(" mDestroyed=");
            writer.println(mDestroyed);
            writer.print(prefix);
            writer.print("mRetaining=");
            writer.print(mRetaining);
            writer.print(" mRetainingStarted=");
            writer.print(mRetainingStarted);
            writer.print(" mListenerRegistered=");
            writer.println(mListenerRegistered);
    if(mPendingLoader != null)            
            {
                writer.print(prefix);
                writer.println("Pending Loader ");
                writer.print(mPendingLoader);
                writer.println(":");
                mPendingLoader.dump(prefix + "  ", fd, writer, args);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.181 -0400", hash_original_field = "907A52D366FFA5C236EE38B314D09A14", hash_generated_field = "6D76EEEE053128D88AD38FCE96834362")

    static final String TAG = "LoaderManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.181 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
}

