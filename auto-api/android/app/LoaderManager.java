package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Loader;
import android.os.Bundle;
import android.util.DebugUtils;
import android.util.Log;
import android.util.SparseArray;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public abstract class LoaderManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.332 -0400", hash_original_method = "921B150ED82AB2739CD0194A062DB550", hash_generated_method = "921B150ED82AB2739CD0194A062DB550")
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

    
    public interface LoaderCallbacks<D> {
        
        public Loader<D> onCreateLoader(int id, Bundle args);

        
        public void onLoadFinished(Loader<D> loader, D data);

        
        public void onLoaderReset(Loader<D> loader);
    }
    
}

class LoaderManagerImpl extends LoaderManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.356 -0400", hash_original_field = "D9842D86F1B621627D8D7761167C5582", hash_generated_field = "9FD9DE856C33B69C8B038B56C88A8970")

    SparseArray<LoaderInfo> mLoaders = new SparseArray<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.357 -0400", hash_original_field = "5F2130CD4BD2601B065CC003AAB5BEB5", hash_generated_field = "E90A7D4DD714A663AB03F8811D44ABC3")

    SparseArray<LoaderInfo> mInactiveLoaders = new SparseArray<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.358 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.359 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

    boolean mStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.360 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.393 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

    boolean mRetainingStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.393 -0400", hash_original_field = "543608B879D1153972FED6E1BBB3F2C2", hash_generated_field = "70C1252034BC616F659C7E09E95F15EB")

    boolean mCreatingLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.409 -0400", hash_original_method = "3A1775F72C10D39F9F7BFE3E62E94501", hash_generated_method = "6EE8F7AE5A898E97654D0E1F67D97ABF")
      LoaderManagerImpl(Activity activity, boolean started) {
        mActivity = activity;
        mStarted = started;
        // ---------- Original Method ----------
        //mActivity = activity;
        //mStarted = started;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.410 -0400", hash_original_method = "ABA1AB897196E6D0611C422D598DF8DF", hash_generated_method = "D5E8998FDCF7539F6E6B2AAC47479B94")
     void updateActivity(Activity activity) {
        mActivity = activity;
        // ---------- Original Method ----------
        //mActivity = activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.422 -0400", hash_original_method = "31DF1B394D718AFF7F9D42E1B24A1D9F", hash_generated_method = "01F63F1BB6285447BD6EE50386C13CAF")
    private LoaderInfo createLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        LoaderInfo varB4EAC82CA7396A68D541C85D26508E83_1027230409 = null; //Variable for return #1
        LoaderInfo info;
        info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        Loader<Object> loader;
        loader = callback.onCreateLoader(id, args);
        info.mLoader = (Loader<Object>)loader;
        varB4EAC82CA7396A68D541C85D26508E83_1027230409 = info;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1027230409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1027230409;
        // ---------- Original Method ----------
        //LoaderInfo info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        //Loader<Object> loader = callback.onCreateLoader(id, args);
        //info.mLoader = (Loader<Object>)loader;
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.464 -0400", hash_original_method = "D2BDC915DCB9CB038EA75210255617B9", hash_generated_method = "308797F8D37096121A820F7D000CA998")
    private LoaderInfo createAndInstallLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        LoaderInfo varB4EAC82CA7396A68D541C85D26508E83_861463769 = null; //Variable for return #1
        try 
        {
            mCreatingLoader = true;
            LoaderInfo info;
            info = createLoader(id, args, callback);
            installLoader(info);
            varB4EAC82CA7396A68D541C85D26508E83_861463769 = info;
        } //End block
        finally 
        {
            mCreatingLoader = false;
        } //End block
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_861463769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_861463769;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.466 -0400", hash_original_method = "112626D5EBE4C2D89FE7194A836F5D8E", hash_generated_method = "4200F51A22DB1E04932FCFE2B04790F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.501 -0400", hash_original_method = "E04CC49F77F654C9D0B54FC39C94F2D8", hash_generated_method = "14F51B5CC32567418F39DE4AB743E49D")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1652652039 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1652652039 = (Loader<D>)info.mLoader;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1652652039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1652652039;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.540 -0400", hash_original_method = "54BE8D79606278ABB814838D7A2BEC9C", hash_generated_method = "48D453338CDE49A778AD0362D6DB3EE7")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_180878988 = null; //Variable for return #1
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_978032298 = null; //Variable for return #2
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
                        varB4EAC82CA7396A68D541C85D26508E83_180878988 = (Loader<D>)info.mPendingLoader.mLoader;
                    } //End block
                } //End block
            } //End block
            {
                info.mLoader.abandon();
                mInactiveLoaders.put(id, info);
            } //End block
        } //End block
        info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        varB4EAC82CA7396A68D541C85D26508E83_978032298 = (Loader<D>)info.mLoader;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        Loader<D> varA7E53CE21691AB073D9660D615818899_898739933; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_898739933 = varB4EAC82CA7396A68D541C85D26508E83_180878988;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_898739933 = varB4EAC82CA7396A68D541C85D26508E83_978032298;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_898739933.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_898739933;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.568 -0400", hash_original_method = "97EDF1A6879B8A3D51445AC765920D76", hash_generated_method = "FFEBB29FCA58E39D28D6D4E868BCA14A")
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
            boolean varAA85D886B05D83FC0ED3196B796619BB_2050342718 = (mActivity != null && !hasRunningLoaders());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.592 -0400", hash_original_method = "01DF8472A2697DF2BC7C6D580583CD7C", hash_generated_method = "55AE23D3937D094833F294A13D9CAE90")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> getLoader(int id) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_196801969 = null; //Variable for return #1
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_641374507 = null; //Variable for return #2
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1656409930 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } //End block
        LoaderInfo loaderInfo;
        loaderInfo = mLoaders.get(id);
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_196801969 = (Loader<D>)loaderInfo.mPendingLoader.mLoader;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_641374507 = (Loader<D>)loaderInfo.mLoader;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1656409930 = null;
        addTaint(id);
        Loader<D> varA7E53CE21691AB073D9660D615818899_1370778653; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1370778653 = varB4EAC82CA7396A68D541C85D26508E83_196801969;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1370778653 = varB4EAC82CA7396A68D541C85D26508E83_641374507;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1370778653 = varB4EAC82CA7396A68D541C85D26508E83_1656409930;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1370778653.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1370778653;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.614 -0400", hash_original_method = "1B5BA5EF1034DE46362C6D43A3344D88", hash_generated_method = "0F72C250134CB85886521F6F89657401")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.628 -0400", hash_original_method = "71BF743CC69E0B66056EF8CBB16C9843", hash_generated_method = "AF68E35CFE0843BC87818B65519AE966")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.648 -0400", hash_original_method = "BD51E42738EB85BB1FB65E8F190FCB03", hash_generated_method = "AF4F1415A1C690F24CA5CFB1282DA5B7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.675 -0400", hash_original_method = "9F7DD5161F3947B5A7B3D4E3274626A8", hash_generated_method = "A72C09209A00085E3DB5650AEEB61D28")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.680 -0400", hash_original_method = "BC9F0E25D287A864E557748845981277", hash_generated_method = "D9CE21FDAD037942E78EB9ABAA382289")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.682 -0400", hash_original_method = "F7C6DF9C0A34E794980C884EE85C960C", hash_generated_method = "EB9C0909DFB4CB6E65704A8E40CA153A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.687 -0400", hash_original_method = "8254B059608384C1C895825978701B08", hash_generated_method = "FDDEC9792032BF7FAD230E8B2B72A66E")
     void doDestroy() {
        {
            {
                int i;
                i = mLoaders.size()-1;
                {
                    mLoaders.valueAt(i).destroy();
                } //End block
            } //End collapsed parenthetic
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
        //}
        //if (DEBUG) Log.v(TAG, "Destroying Inactive in " + this);
        //for (int i = mInactiveLoaders.size()-1; i >= 0; i--) {
            //mInactiveLoaders.valueAt(i).destroy();
        //}
        //mInactiveLoaders.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.710 -0400", hash_original_method = "A45A0DF363CA3802688DC012A3593E66", hash_generated_method = "4D57292CF1EC46D389FD5D4FC0E8632A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1040876395 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        varB4EAC82CA7396A68D541C85D26508E83_1040876395 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1040876395.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1040876395;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("LoaderManager{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(" in ");
        //DebugUtils.buildShortClassTag(mActivity, sb);
        //sb.append("}}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.754 -0400", hash_original_method = "469C164486863607CE4F221F1C14A350", hash_generated_method = "321B768A2B85E74B6027C883B03A177C")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        {
            boolean varEE58C679480D0972D699B2684BCEBD96_1512809457 = (mLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Active Loaders:");
                String innerPrefix;
                innerPrefix = prefix + "    ";
                {
                    int i;
                    i = 0;
                    boolean var3DD1886DF4F41430C4BFFAEA91986789_986717580 = (i < mLoaders.size());
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
            boolean var282C5CDAE1350DAB1D040F1744D3C286_900203082 = (mInactiveLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Inactive Loaders:");
                String innerPrefix;
                innerPrefix = prefix + "    ";
                {
                    int i;
                    i = 0;
                    boolean var898D73B8559A4D372B97514D1C022E2A_66115691 = (i < mInactiveLoaders.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.762 -0400", hash_original_method = "3F0C9C3E43C354715EA08050096B7736", hash_generated_method = "C454DFA5060711380EFF2A372C7EF6C8")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939543;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.763 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

        int mId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.776 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.777 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "6C4C07AC29F4D4AA01A483F932AC882C")

        LoaderManager.LoaderCallbacks<Object> mCallbacks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.777 -0400", hash_original_field = "80FF3862892C05890CE6715239D5E8AB", hash_generated_field = "CAAC247984B2641B92D4E9BC40D546DA")

        Loader<Object> mLoader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.778 -0400", hash_original_field = "3E6578FC76C21F1A7CAE156E12A3C9E7", hash_generated_field = "8653C1EEEDD912C5198A3F395AEACFB9")

        boolean mHaveData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.779 -0400", hash_original_field = "3670C33CC4ABF71ACE43E5EE0ECFE123", hash_generated_field = "E7E3F3C458E363A4280FDF1098E7D079")

        boolean mDeliveredData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.787 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

        Object mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.788 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

        boolean mStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.789 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

        boolean mRetaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.789 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

        boolean mRetainingStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.804 -0400", hash_original_field = "8DBA0029FAB59A1B665D7DEA39DF2B1A", hash_generated_field = "620EE77E057D462DD77FE41E957B6B8F")

        boolean mReportNextStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.805 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

        boolean mDestroyed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.805 -0400", hash_original_field = "B0EC9D56AB3AFD18C789DC47DFF0EB6B", hash_generated_field = "AD96D6DFE99122F027819D4D95BE5F11")

        boolean mListenerRegistered;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.806 -0400", hash_original_field = "BFD46B06A9331820E543FDC5B0775B98", hash_generated_field = "48D26E3132EBDD98F32F802FBADD8F16")

        LoaderInfo mPendingLoader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.824 -0400", hash_original_method = "16FA523516D826BD7B81DB6C5F688F57", hash_generated_method = "B1787A946F4FAE1D5E958B14E046210B")
        public  LoaderInfo(int id, Bundle args, LoaderManager.LoaderCallbacks<Object> callbacks) {
            mId = id;
            mArgs = args;
            mCallbacks = callbacks;
            // ---------- Original Method ----------
            //mId = id;
            //mArgs = args;
            //mCallbacks = callbacks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.841 -0400", hash_original_method = "59414391327A086CB5A9419E1A5D3F4A", hash_generated_method = "EAB07696DB7DF8879B96B13D33EBA436")
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
                    boolean varC59DA0641E3D9EFCA2CBD395510230E2_749563901 = (mLoader.getClass().isMemberClass()
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.861 -0400", hash_original_method = "EEEFF8F43B746CBA4F0DDA0630ACC8F2", hash_generated_method = "EF8C98B11E97B53B0DE39492B29BBEC6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.876 -0400", hash_original_method = "A6A41243ADFD2D6E0A8ECB9143919977", hash_generated_method = "3A81054A3E09BDCCCBA90E364893D4A9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.889 -0400", hash_original_method = "915BC416A2513DED4BAC846F5B62B555", hash_generated_method = "0F987794529CE8B7289FD21EEB54AC26")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.909 -0400", hash_original_method = "2CBDFC8D776F45EC911F1F96CF447373", hash_generated_method = "BF077203F7B68E38F80D7B958B25635B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:51.956 -0400", hash_original_method = "A36048C3C1A3E46AC40E97896DEEAF8F", hash_generated_method = "3228917F590A2B9F3F82431886EF244A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.107 -0400", hash_original_method = "5D6E68340AACAB27821B5B5851C94699", hash_generated_method = "F46A059843795ADE2102541918CE1EA5")
        @Override
        public void onLoadComplete(Loader<Object> loader, Object data) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var333CD009E2691114D1D942AFA1A276F0_441582831 = (mLoaders.get(mId) != this);
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
                boolean var096B903244A3118F8D65EEC99906CE4F_145015260 = (info != null && info != this);
                {
                    info.mDeliveredData = false;
                    info.destroy();
                    mInactiveLoaders.remove(mId);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var6F7A2F80E7742D15ECC5F8E1556DAF45_796140985 = (mActivity != null && !hasRunningLoaders());
                {
                    mActivity.mFragments.startPendingDeferredFragments();
                } //End block
            } //End collapsed parenthetic
            addTaint(loader.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.132 -0400", hash_original_method = "DBCF4A7424D3CE3FF77E30E5C5EDA97C", hash_generated_method = "3FAFD397DDE2707A782E30E763F8A798")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.155 -0400", hash_original_method = "6152E6E73795403DAC53E06540200214", hash_generated_method = "4B9BD40D3C6EB55764E3ACE8FCC6199A")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1280355367 = null; //Variable for return #1
            StringBuilder sb;
            sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(mLoader, sb);
            sb.append("}}");
            varB4EAC82CA7396A68D541C85D26508E83_1280355367 = sb.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1280355367.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1280355367;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.183 -0400", hash_original_method = "130B539E0C9D3012BFA3C99178E2C6F6", hash_generated_method = "922875F751B77895EB9ED24AA5FCF5AA")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.195 -0400", hash_original_field = "907A52D366FFA5C236EE38B314D09A14", hash_generated_field = "7052282AEA174080901763B913A21EAE")

    static String TAG = "LoaderManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:52.195 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
}

