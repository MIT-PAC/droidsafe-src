package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.091 -0400", hash_original_method = "921B150ED82AB2739CD0194A062DB550", hash_generated_method = "921B150ED82AB2739CD0194A062DB550")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.108 -0400", hash_original_method = "59280299B88BC81400789A85A7BD24F4", hash_generated_method = "F2912932BC90818FDDACA7B120BF8FE3")
    public boolean hasRunningLoaders() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1549269056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1549269056;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.111 -0400", hash_original_field = "581A48C88B1F4455461B49B9FED0F6E5", hash_generated_field = "1CF8892D2B02DEB107CFDFA81ECE326A")

    SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.111 -0400", hash_original_field = "7DAAE059AA586D05F0C81A3816E7F517", hash_generated_field = "BE05FD3A57AE60D3C1007840A971D17D")

    SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.111 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "7ECAB8F1DFD4D8C88111D51780B29562")

    String mWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.111 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "DC6970CAF75184DB6DB1AAC52EA720C0")

    FragmentActivity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.111 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

    boolean mStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.111 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.111 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

    boolean mRetainingStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.111 -0400", hash_original_field = "543608B879D1153972FED6E1BBB3F2C2", hash_generated_field = "70C1252034BC616F659C7E09E95F15EB")

    boolean mCreatingLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.112 -0400", hash_original_method = "8A8E6D86E6D6B2C8C93367E841E4998B", hash_generated_method = "6C4A23BB54B986C26908C5D945FDD353")
      LoaderManagerImpl(String who, FragmentActivity activity, boolean started) {
        mWho = who;
        mActivity = activity;
        mStarted = started;
        // ---------- Original Method ----------
        //mWho = who;
        //mActivity = activity;
        //mStarted = started;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.112 -0400", hash_original_method = "39148A68E08215CAB837BA67F40FAA62", hash_generated_method = "FD7298AAA1462E00D71BDFDBAB50C6A6")
     void updateActivity(FragmentActivity activity) {
        mActivity = activity;
        // ---------- Original Method ----------
        //mActivity = activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.113 -0400", hash_original_method = "31DF1B394D718AFF7F9D42E1B24A1D9F", hash_generated_method = "CEE0C57AF386A80F959075C69FFB69E5")
    private LoaderInfo createLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        LoaderInfo varB4EAC82CA7396A68D541C85D26508E83_123744028 = null; //Variable for return #1
        LoaderInfo info;
        info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        Loader<Object> loader;
        loader = callback.onCreateLoader(id, args);
        info.mLoader = (Loader<Object>)loader;
        varB4EAC82CA7396A68D541C85D26508E83_123744028 = info;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_123744028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_123744028;
        // ---------- Original Method ----------
        //LoaderInfo info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        //Loader<Object> loader = callback.onCreateLoader(id, args);
        //info.mLoader = (Loader<Object>)loader;
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.114 -0400", hash_original_method = "D2BDC915DCB9CB038EA75210255617B9", hash_generated_method = "203F70B850E9B946F1E4E55E539EB25F")
    private LoaderInfo createAndInstallLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        LoaderInfo varB4EAC82CA7396A68D541C85D26508E83_93010669 = null; //Variable for return #1
        try 
        {
            mCreatingLoader = true;
            LoaderInfo info;
            info = createLoader(id, args, callback);
            installLoader(info);
            varB4EAC82CA7396A68D541C85D26508E83_93010669 = info;
        } //End block
        finally 
        {
            mCreatingLoader = false;
        } //End block
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_93010669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93010669;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.115 -0400", hash_original_method = "112626D5EBE4C2D89FE7194A836F5D8E", hash_generated_method = "4200F51A22DB1E04932FCFE2B04790F0")
     void installLoader(LoaderInfo info) {
        mLoaders.put(info.mId, info);
        {
            info.start();
        } //End block
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //mLoaders.put(info.mId, info);
        //if (mStarted) {
            //info.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.123 -0400", hash_original_method = "E04CC49F77F654C9D0B54FC39C94F2D8", hash_generated_method = "B5936BAADE9AE01C354BB04A83688874")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1643684358 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } //End block
        LoaderInfo info;
        info = mLoaders.get(id);
        {
            info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        } //End block
        {
            info.mCallbacks = (LoaderManager.LoaderCallbacks<Object>)callback;
        } //End block
        {
            info.callOnLoadFinished(info.mLoader, info.mData);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1643684358 = (Loader<D>)info.mLoader;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1643684358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1643684358;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.141 -0400", hash_original_method = "54BE8D79606278ABB814838D7A2BEC9C", hash_generated_method = "08398CD1BA1DE20AA764C207C09EED40")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1694140738 = null; //Variable for return #1
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1246065675 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } //End block
        LoaderInfo info;
        info = mLoaders.get(id);
        {
            LoaderInfo inactive;
            inactive = mInactiveLoaders.get(id);
            {
                {
                    inactive.mDeliveredData = false;
                    inactive.destroy();
                    info.mLoader.abandon();
                    mInactiveLoaders.put(id, info);
                } //End block
                {
                    {
                        mLoaders.put(id, null);
                        info.destroy();
                    } //End block
                    {
                        {
                            info.mPendingLoader.destroy();
                            info.mPendingLoader = null;
                        } //End block
                        info.mPendingLoader = createLoader(id, args, 
                                (LoaderManager.LoaderCallbacks<Object>)callback);
                        varB4EAC82CA7396A68D541C85D26508E83_1694140738 = (Loader<D>)info.mPendingLoader.mLoader;
                    } //End block
                } //End block
            } //End block
            {
                info.mLoader.abandon();
                mInactiveLoaders.put(id, info);
            } //End block
        } //End block
        info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        varB4EAC82CA7396A68D541C85D26508E83_1246065675 = (Loader<D>)info.mLoader;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        Loader<D> varA7E53CE21691AB073D9660D615818899_730121508; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_730121508 = varB4EAC82CA7396A68D541C85D26508E83_1694140738;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_730121508 = varB4EAC82CA7396A68D541C85D26508E83_1246065675;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_730121508.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_730121508;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.145 -0400", hash_original_method = "97EDF1A6879B8A3D51445AC765920D76", hash_generated_method = "8EA0AFC0104EE7D4899826AB4B83F433")
    public void destroyLoader(int id) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } //End block
        int idx;
        idx = mLoaders.indexOfKey(id);
        {
            LoaderInfo info;
            info = mLoaders.valueAt(idx);
            mLoaders.removeAt(idx);
            info.destroy();
        } //End block
        idx = mInactiveLoaders.indexOfKey(id);
        {
            LoaderInfo info;
            info = mInactiveLoaders.valueAt(idx);
            mInactiveLoaders.removeAt(idx);
            info.destroy();
        } //End block
        {
            boolean varAA85D886B05D83FC0ED3196B796619BB_173432440 = (mActivity != null && !hasRunningLoaders());
            {
                mActivity.mFragments.startPendingDeferredFragments();
            } //End block
        } //End collapsed parenthetic
        addTaint(id);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.150 -0400", hash_original_method = "01DF8472A2697DF2BC7C6D580583CD7C", hash_generated_method = "7C6CB42EBAA82016A2FAD30038DC43AF")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> getLoader(int id) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1384024949 = null; //Variable for return #1
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1342505831 = null; //Variable for return #2
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_365521378 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } //End block
        LoaderInfo loaderInfo;
        loaderInfo = mLoaders.get(id);
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1384024949 = (Loader<D>)loaderInfo.mPendingLoader.mLoader;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1342505831 = (Loader<D>)loaderInfo.mLoader;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_365521378 = null;
        addTaint(id);
        Loader<D> varA7E53CE21691AB073D9660D615818899_90194518; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_90194518 = varB4EAC82CA7396A68D541C85D26508E83_1384024949;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_90194518 = varB4EAC82CA7396A68D541C85D26508E83_1342505831;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_90194518 = varB4EAC82CA7396A68D541C85D26508E83_365521378;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_90194518.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_90194518;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.164 -0400", hash_original_method = "1B5BA5EF1034DE46362C6D43A3344D88", hash_generated_method = "0F72C250134CB85886521F6F89657401")
     void doStart() {
        {
            RuntimeException e;
            e = new RuntimeException("here");
            e.fillInStackTrace();
        } //End block
        mStarted = true;
        {
            int i;
            i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).start();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.165 -0400", hash_original_method = "71BF743CC69E0B66056EF8CBB16C9843", hash_generated_method = "AF68E35CFE0843BC87818B65519AE966")
     void doStop() {
        {
            RuntimeException e;
            e = new RuntimeException("here");
            e.fillInStackTrace();
        } //End block
        {
            int i;
            i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).stop();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.166 -0400", hash_original_method = "BD51E42738EB85BB1FB65E8F190FCB03", hash_generated_method = "AF4F1415A1C690F24CA5CFB1282DA5B7")
     void doRetain() {
        {
            RuntimeException e;
            e = new RuntimeException("here");
            e.fillInStackTrace();
        } //End block
        mRetaining = true;
        mStarted = false;
        {
            int i;
            i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).retain();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.174 -0400", hash_original_method = "9F7DD5161F3947B5A7B3D4E3274626A8", hash_generated_method = "A72C09209A00085E3DB5650AEEB61D28")
     void finishRetain() {
        {
            mRetaining = false;
            {
                int i;
                i = mLoaders.size()-1;
                {
                    mLoaders.valueAt(i).finishRetain();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.175 -0400", hash_original_method = "BC9F0E25D287A864E557748845981277", hash_generated_method = "D9CE21FDAD037942E78EB9ABAA382289")
     void doReportNextStart() {
        {
            int i;
            i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).mReportNextStart = true;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = mLoaders.size()-1; i >= 0; i--) {
            //mLoaders.valueAt(i).mReportNextStart = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.179 -0400", hash_original_method = "F7C6DF9C0A34E794980C884EE85C960C", hash_generated_method = "EB9C0909DFB4CB6E65704A8E40CA153A")
     void doReportStart() {
        {
            int i;
            i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).reportStart();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = mLoaders.size()-1; i >= 0; i--) {
            //mLoaders.valueAt(i).reportStart();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.194 -0400", hash_original_method = "736E3BF19FA9B5737831BA1044201B86", hash_generated_method = "02263E5F59215A99F7DD0F6F8DD89914")
     void doDestroy() {
        {
            {
                int i;
                i = mLoaders.size()-1;
                {
                    mLoaders.valueAt(i).destroy();
                } //End block
            } //End collapsed parenthetic
            mLoaders.clear();
        } //End block
        {
            int i;
            i = mInactiveLoaders.size()-1;
            {
                mInactiveLoaders.valueAt(i).destroy();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.195 -0400", hash_original_method = "A45A0DF363CA3802688DC012A3593E66", hash_generated_method = "011E6C7D2E8D53C8FCE1543BDA982FB6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_511326761 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        varB4EAC82CA7396A68D541C85D26508E83_511326761 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_511326761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_511326761;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("LoaderManager{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(" in ");
        //DebugUtils.buildShortClassTag(mActivity, sb);
        //sb.append("}}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.205 -0400", hash_original_method = "469C164486863607CE4F221F1C14A350", hash_generated_method = "5A89C0A9CD971ACB4F1D4646C13671CE")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        {
            boolean varEE58C679480D0972D699B2684BCEBD96_1317779005 = (mLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Active Loaders:");
                String innerPrefix;
                innerPrefix = prefix + "    ";
                {
                    int i;
                    i = 0;
                    boolean var3DD1886DF4F41430C4BFFAEA91986789_539625930 = (i < mLoaders.size());
                    {
                        LoaderInfo li;
                        li = mLoaders.valueAt(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(mLoaders.keyAt(i));
                        writer.print(": ");
                        writer.println(li.toString());
                        li.dump(innerPrefix, fd, writer, args);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var282C5CDAE1350DAB1D040F1744D3C286_321520585 = (mInactiveLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Inactive Loaders:");
                String innerPrefix;
                innerPrefix = prefix + "    ";
                {
                    int i;
                    i = 0;
                    boolean var898D73B8559A4D372B97514D1C022E2A_275099087 = (i < mInactiveLoaders.size());
                    {
                        LoaderInfo li;
                        li = mInactiveLoaders.valueAt(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(mInactiveLoaders.keyAt(i));
                        writer.print(": ");
                        writer.println(li.toString());
                        li.dump(innerPrefix, fd, writer, args);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.206 -0400", hash_original_method = "3F0C9C3E43C354715EA08050096B7736", hash_generated_method = "106D6D6C52315D5DB1C8CE75A462F86E")
    @Override
    public boolean hasRunningLoaders() {
        boolean loadersRunning;
        loadersRunning = false;
        int count;
        count = mLoaders.size();
        {
            int i;
            i = 0;
            {
                LoaderInfo li;
                li = mLoaders.valueAt(i);
                loadersRunning |= li.mStarted && !li.mDeliveredData;
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1706779944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1706779944;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

        int mId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "6C4C07AC29F4D4AA01A483F932AC882C")

        LoaderManager.LoaderCallbacks<Object> mCallbacks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "80FF3862892C05890CE6715239D5E8AB", hash_generated_field = "CAAC247984B2641B92D4E9BC40D546DA")

        Loader<Object> mLoader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "3E6578FC76C21F1A7CAE156E12A3C9E7", hash_generated_field = "8653C1EEEDD912C5198A3F395AEACFB9")

        boolean mHaveData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "3670C33CC4ABF71ACE43E5EE0ECFE123", hash_generated_field = "E7E3F3C458E363A4280FDF1098E7D079")

        boolean mDeliveredData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

        Object mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

        boolean mStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

        boolean mRetaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

        boolean mRetainingStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.207 -0400", hash_original_field = "8DBA0029FAB59A1B665D7DEA39DF2B1A", hash_generated_field = "620EE77E057D462DD77FE41E957B6B8F")

        boolean mReportNextStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.208 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

        boolean mDestroyed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.208 -0400", hash_original_field = "B0EC9D56AB3AFD18C789DC47DFF0EB6B", hash_generated_field = "AD96D6DFE99122F027819D4D95BE5F11")

        boolean mListenerRegistered;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.208 -0400", hash_original_field = "BFD46B06A9331820E543FDC5B0775B98", hash_generated_field = "48D26E3132EBDD98F32F802FBADD8F16")

        LoaderInfo mPendingLoader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.208 -0400", hash_original_method = "16FA523516D826BD7B81DB6C5F688F57", hash_generated_method = "B1787A946F4FAE1D5E958B14E046210B")
        public  LoaderInfo(int id, Bundle args, LoaderManager.LoaderCallbacks<Object> callbacks) {
            mId = id;
            mArgs = args;
            mCallbacks = callbacks;
            // ---------- Original Method ----------
            //mId = id;
            //mArgs = args;
            //mCallbacks = callbacks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.213 -0400", hash_original_method = "59414391327A086CB5A9419E1A5D3F4A", hash_generated_method = "472BED4FF6C7E6A112555AECEED66ED2")
         void start() {
            {
                mStarted = true;
            } //End block
            mStarted = true;
            {
                mLoader = mCallbacks.onCreateLoader(mId, mArgs);
            } //End block
            {
                {
                    boolean varC59DA0641E3D9EFCA2CBD395510230E2_620067669 = (mLoader.getClass().isMemberClass()
                        && !Modifier.isStatic(mLoader.getClass().getModifiers()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                            "Object returned from onCreateLoader must not be a non-static inner member class: "
                            + mLoader);
                    } //End block
                } //End collapsed parenthetic
                {
                    mLoader.registerListener(mId, this);
                    mListenerRegistered = true;
                } //End block
                mLoader.startLoading();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.214 -0400", hash_original_method = "EEEFF8F43B746CBA4F0DDA0630ACC8F2", hash_generated_method = "EF8C98B11E97B53B0DE39492B29BBEC6")
         void retain() {
            mRetaining = true;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.214 -0400", hash_original_method = "A6A41243ADFD2D6E0A8ECB9143919977", hash_generated_method = "3A81054A3E09BDCCCBA90E364893D4A9")
         void finishRetain() {
            {
                mRetaining = false;
                {
                    {
                        stop();
                    } //End block
                } //End block
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.226 -0400", hash_original_method = "915BC416A2513DED4BAC846F5B62B555", hash_generated_method = "0F987794529CE8B7289FD21EEB54AC26")
         void reportStart() {
            {
                {
                    mReportNextStart = false;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.231 -0400", hash_original_method = "2CBDFC8D776F45EC911F1F96CF447373", hash_generated_method = "BF077203F7B68E38F80D7B958B25635B")
         void stop() {
            mStarted = false;
            {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.234 -0400", hash_original_method = "A36048C3C1A3E46AC40E97896DEEAF8F", hash_generated_method = "3228917F590A2B9F3F82431886EF244A")
         void destroy() {
            mDestroyed = true;
            boolean needReset;
            needReset = mDeliveredData;
            mDeliveredData = false;
            {
                String lastBecause;
                lastBecause = null;
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
                    {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    } //End block
                } //End block
            } //End block
            mCallbacks = null;
            mData = null;
            mHaveData = false;
            {
                {
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                } //End block
                mLoader.reset();
            } //End block
            {
                mPendingLoader.destroy();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.245 -0400", hash_original_method = "5D6E68340AACAB27821B5B5851C94699", hash_generated_method = "AE95AA0891702C7654FC955C296B6D37")
        @Override
        public void onLoadComplete(Loader<Object> loader, Object data) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var333CD009E2691114D1D942AFA1A276F0_318436265 = (mLoaders.get(mId) != this);
            } //End collapsed parenthetic
            LoaderInfo pending;
            pending = mPendingLoader;
            {
                mPendingLoader = null;
                mLoaders.put(mId, null);
                destroy();
                installLoader(pending);
            } //End block
            {
                mData = data;
                mHaveData = true;
                {
                    callOnLoadFinished(loader, data);
                } //End block
            } //End block
            LoaderInfo info;
            info = mInactiveLoaders.get(mId);
            {
                boolean var096B903244A3118F8D65EEC99906CE4F_67570389 = (info != null && info != this);
                {
                    info.mDeliveredData = false;
                    info.destroy();
                    mInactiveLoaders.remove(mId);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var6F7A2F80E7742D15ECC5F8E1556DAF45_1111379136 = (mActivity != null && !hasRunningLoaders());
                {
                    mActivity.mFragments.startPendingDeferredFragments();
                } //End block
            } //End collapsed parenthetic
            addTaint(loader.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.253 -0400", hash_original_method = "DBCF4A7424D3CE3FF77E30E5C5EDA97C", hash_generated_method = "3FAFD397DDE2707A782E30E763F8A798")
         void callOnLoadFinished(Loader<Object> loader, Object data) {
            {
                String lastBecause;
                lastBecause = null;
                {
                    lastBecause = mActivity.mFragments.mNoTransactionsBecause;
                    mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
                } //End block
                try 
                {
                    mCallbacks.onLoadFinished(loader, data);
                } //End block
                finally 
                {
                    {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    } //End block
                } //End block
                mDeliveredData = true;
            } //End block
            addTaint(loader.getTaint());
            addTaint(data.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.269 -0400", hash_original_method = "6152E6E73795403DAC53E06540200214", hash_generated_method = "DE41CD604DD32088738CB078B91D95EB")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_885410148 = null; //Variable for return #1
            StringBuilder sb;
            sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(mLoader, sb);
            sb.append("}}");
            varB4EAC82CA7396A68D541C85D26508E83_885410148 = sb.toString();
            varB4EAC82CA7396A68D541C85D26508E83_885410148.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_885410148;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.275 -0400", hash_original_method = "130B539E0C9D3012BFA3C99178E2C6F6", hash_generated_method = "922875F751B77895EB9ED24AA5FCF5AA")
        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
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
            {
                mLoader.dump(prefix + "  ", fd, writer, args);
            } //End block
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
            {
                writer.print(prefix);
                writer.println("Pending Loader ");
                writer.print(mPendingLoader);
                writer.println(":");
                mPendingLoader.dump(prefix + "  ", fd, writer, args);
            } //End block
            addTaint(prefix.getTaint());
            addTaint(fd.getTaint());
            addTaint(writer.getTaint());
            addTaint(args[0].getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.275 -0400", hash_original_field = "907A52D366FFA5C236EE38B314D09A14", hash_generated_field = "7052282AEA174080901763B913A21EAE")

    static String TAG = "LoaderManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.275 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
}

