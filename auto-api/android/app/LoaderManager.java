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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.369 -0400", hash_original_method = "3A865577F44EAF79262199D80C17C055", hash_generated_method = "3A865577F44EAF79262199D80C17C055")
        public LoaderManager ()
    {
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
    SparseArray<LoaderInfo> mLoaders = new SparseArray<LoaderInfo>();
    SparseArray<LoaderInfo> mInactiveLoaders = new SparseArray<LoaderInfo>();
    Activity mActivity;
    boolean mStarted;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mCreatingLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.371 -0400", hash_original_method = "3A1775F72C10D39F9F7BFE3E62E94501", hash_generated_method = "13C36AB285438E4596E6DDC5EAC2207B")
    @DSModeled(DSC.SAFE)
     LoaderManagerImpl(Activity activity, boolean started) {
        dsTaint.addTaint(started);
        dsTaint.addTaint(activity.dsTaint);
        // ---------- Original Method ----------
        //mActivity = activity;
        //mStarted = started;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.371 -0400", hash_original_method = "ABA1AB897196E6D0611C422D598DF8DF", hash_generated_method = "5AA5AB3736BD3B6C7A3660C5D56CFC1C")
    @DSModeled(DSC.SAFE)
     void updateActivity(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        // ---------- Original Method ----------
        //mActivity = activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.372 -0400", hash_original_method = "31DF1B394D718AFF7F9D42E1B24A1D9F", hash_generated_method = "79EA99526D981C6D216AD0D1C1CB8AF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private LoaderInfo createLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        LoaderInfo info;
        info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        Loader<Object> loader;
        loader = callback.onCreateLoader(id, args);
        info.mLoader = (Loader<Object>)loader;
        return (LoaderInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LoaderInfo info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        //Loader<Object> loader = callback.onCreateLoader(id, args);
        //info.mLoader = (Loader<Object>)loader;
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.372 -0400", hash_original_method = "D2BDC915DCB9CB038EA75210255617B9", hash_generated_method = "8E2B159C4A838D4DCC1F44BA6A3A23FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private LoaderInfo createAndInstallLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        try 
        {
            mCreatingLoader = true;
            LoaderInfo info;
            info = createLoader(id, args, callback);
            installLoader(info);
        } //End block
        finally 
        {
            mCreatingLoader = false;
        } //End block
        return (LoaderInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.372 -0400", hash_original_method = "112626D5EBE4C2D89FE7194A836F5D8E", hash_generated_method = "6EEF29C4C40C4C24EFFDCD8A08C09CB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void installLoader(LoaderInfo info) {
        dsTaint.addTaint(info.dsTaint);
        mLoaders.put(info.mId, info);
        {
            info.start();
        } //End block
        // ---------- Original Method ----------
        //mLoaders.put(info.mId, info);
        //if (mStarted) {
            //info.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.373 -0400", hash_original_method = "E04CC49F77F654C9D0B54FC39C94F2D8", hash_generated_method = "2069D4A4DF03177268D4FCF403BEBFDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
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
        return (Loader<D>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.374 -0400", hash_original_method = "54BE8D79606278ABB814838D7A2BEC9C", hash_generated_method = "1F802D5AD528E9F219DD1C0C6CE7C53D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
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
                    } //End block
                } //End block
            } //End block
            {
                info.mLoader.abandon();
                mInactiveLoaders.put(id, info);
            } //End block
        } //End block
        info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        return (Loader<D>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.375 -0400", hash_original_method = "97EDF1A6879B8A3D51445AC765920D76", hash_generated_method = "9338BF8B8D0EC890697048C3541BBB1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void destroyLoader(int id) {
        dsTaint.addTaint(id);
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
            boolean varAA85D886B05D83FC0ED3196B796619BB_1874484315 = (mActivity != null && !hasRunningLoaders());
            {
                mActivity.mFragments.startPendingDeferredFragments();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.375 -0400", hash_original_method = "01DF8472A2697DF2BC7C6D580583CD7C", hash_generated_method = "88488BB67AD6905496FA451EDB76178E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public <D> Loader<D> getLoader(int id) {
        dsTaint.addTaint(id);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } //End block
        LoaderInfo loaderInfo;
        loaderInfo = mLoaders.get(id);
        return (Loader<D>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.376 -0400", hash_original_method = "1B5BA5EF1034DE46362C6D43A3344D88", hash_generated_method = "0F72C250134CB85886521F6F89657401")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.376 -0400", hash_original_method = "71BF743CC69E0B66056EF8CBB16C9843", hash_generated_method = "AF68E35CFE0843BC87818B65519AE966")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.377 -0400", hash_original_method = "BD51E42738EB85BB1FB65E8F190FCB03", hash_generated_method = "AF4F1415A1C690F24CA5CFB1282DA5B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.377 -0400", hash_original_method = "9F7DD5161F3947B5A7B3D4E3274626A8", hash_generated_method = "A72C09209A00085E3DB5650AEEB61D28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.377 -0400", hash_original_method = "BC9F0E25D287A864E557748845981277", hash_generated_method = "D9CE21FDAD037942E78EB9ABAA382289")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.378 -0400", hash_original_method = "F7C6DF9C0A34E794980C884EE85C960C", hash_generated_method = "EB9C0909DFB4CB6E65704A8E40CA153A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.378 -0400", hash_original_method = "8254B059608384C1C895825978701B08", hash_generated_method = "FDDEC9792032BF7FAD230E8B2B72A66E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.379 -0400", hash_original_method = "A45A0DF363CA3802688DC012A3593E66", hash_generated_method = "FAA8736F324C8E7BDEB061C4D53E3D94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        String var806458D832AB974D230FEE4CBBDBD390_1638409678 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("LoaderManager{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(" in ");
        //DebugUtils.buildShortClassTag(mActivity, sb);
        //sb.append("}}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.380 -0400", hash_original_method = "469C164486863607CE4F221F1C14A350", hash_generated_method = "D40D71759562783231B12DB09F5D4045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(writer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        {
            boolean varEE58C679480D0972D699B2684BCEBD96_602125310 = (mLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Active Loaders:");
                String innerPrefix;
                innerPrefix = prefix + "    ";
                {
                    int i;
                    i = 0;
                    boolean var3DD1886DF4F41430C4BFFAEA91986789_1072919556 = (i < mLoaders.size());
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
            boolean var282C5CDAE1350DAB1D040F1744D3C286_1051713899 = (mInactiveLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Inactive Loaders:");
                String innerPrefix;
                innerPrefix = prefix + "    ";
                {
                    int i;
                    i = 0;
                    boolean var898D73B8559A4D372B97514D1C022E2A_2090113181 = (i < mInactiveLoaders.size());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.380 -0400", hash_original_method = "3F0C9C3E43C354715EA08050096B7736", hash_generated_method = "F589B0923A72FC8E299630D524245C88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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
        int mId;
        Bundle mArgs;
        LoaderManager.LoaderCallbacks<Object> mCallbacks;
        Loader<Object> mLoader;
        boolean mHaveData;
        boolean mDeliveredData;
        Object mData;
        boolean mStarted;
        boolean mRetaining;
        boolean mRetainingStarted;
        boolean mReportNextStart;
        boolean mDestroyed;
        boolean mListenerRegistered;
        LoaderInfo mPendingLoader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.381 -0400", hash_original_method = "16FA523516D826BD7B81DB6C5F688F57", hash_generated_method = "58ABA337810BF6D66880C579F3D3B1B5")
        @DSModeled(DSC.SAFE)
        public LoaderInfo(int id, Bundle args, LoaderManager.LoaderCallbacks<Object> callbacks) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(args.dsTaint);
            dsTaint.addTaint(callbacks.dsTaint);
            // ---------- Original Method ----------
            //mId = id;
            //mArgs = args;
            //mCallbacks = callbacks;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.382 -0400", hash_original_method = "59414391327A086CB5A9419E1A5D3F4A", hash_generated_method = "85CFCCF059D0765101FCD8B1F825CA8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean varC59DA0641E3D9EFCA2CBD395510230E2_582173724 = (mLoader.getClass().isMemberClass()
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.382 -0400", hash_original_method = "EEEFF8F43B746CBA4F0DDA0630ACC8F2", hash_generated_method = "EF8C98B11E97B53B0DE39492B29BBEC6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.382 -0400", hash_original_method = "A6A41243ADFD2D6E0A8ECB9143919977", hash_generated_method = "3A81054A3E09BDCCCBA90E364893D4A9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.383 -0400", hash_original_method = "915BC416A2513DED4BAC846F5B62B555", hash_generated_method = "0F987794529CE8B7289FD21EEB54AC26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.383 -0400", hash_original_method = "2CBDFC8D776F45EC911F1F96CF447373", hash_generated_method = "BF077203F7B68E38F80D7B958B25635B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.384 -0400", hash_original_method = "A36048C3C1A3E46AC40E97896DEEAF8F", hash_generated_method = "3228917F590A2B9F3F82431886EF244A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.385 -0400", hash_original_method = "5D6E68340AACAB27821B5B5851C94699", hash_generated_method = "32DA032D5C62E35CF2E55BD7141B0B0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onLoadComplete(Loader<Object> loader, Object data) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(loader.dsTaint);
            dsTaint.addTaint(data.dsTaint);
            {
                boolean var333CD009E2691114D1D942AFA1A276F0_1259912451 = (mLoaders.get(mId) != this);
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
                mHaveData = true;
                {
                    callOnLoadFinished(loader, data);
                } //End block
            } //End block
            LoaderInfo info;
            info = mInactiveLoaders.get(mId);
            {
                boolean var096B903244A3118F8D65EEC99906CE4F_276958805 = (info != null && info != this);
                {
                    info.mDeliveredData = false;
                    info.destroy();
                    mInactiveLoaders.remove(mId);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var6F7A2F80E7742D15ECC5F8E1556DAF45_413897730 = (mActivity != null && !hasRunningLoaders());
                {
                    mActivity.mFragments.startPendingDeferredFragments();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.386 -0400", hash_original_method = "DBCF4A7424D3CE3FF77E30E5C5EDA97C", hash_generated_method = "5E3E57EDA9712F5885B5380932558E0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void callOnLoadFinished(Loader<Object> loader, Object data) {
            dsTaint.addTaint(loader.dsTaint);
            dsTaint.addTaint(data.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.387 -0400", hash_original_method = "6152E6E73795403DAC53E06540200214", hash_generated_method = "CB56F6D947A7213DC9FB469EE30BCFE6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder sb;
            sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(mLoader, sb);
            sb.append("}}");
            String var01ED4A9DFA1C94365291AB096B854A7B_81213453 = (sb.toString());
            return dsTaint.getTaintString();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.388 -0400", hash_original_method = "130B539E0C9D3012BFA3C99178E2C6F6", hash_generated_method = "2A873B7AFE80CC5FB70756971D147C5F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            dsTaint.addTaint(args[0]);
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(writer.dsTaint);
            dsTaint.addTaint(fd.dsTaint);
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static final String TAG = "LoaderManager";
    static boolean DEBUG = false;
}

