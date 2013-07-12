package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.113 -0400", hash_original_method = "921B150ED82AB2739CD0194A062DB550", hash_generated_method = "921B150ED82AB2739CD0194A062DB550")
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

    
        @DSModeled(DSC.SAFE)
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.115 -0400", hash_original_field = "D9842D86F1B621627D8D7761167C5582", hash_generated_field = "19761E4007287AB328849D421B39EA27")

    final SparseArray<LoaderInfo> mLoaders = new SparseArray<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.116 -0400", hash_original_field = "5F2130CD4BD2601B065CC003AAB5BEB5", hash_generated_field = "4162D233DB58F382521F27DC73373950")

    final SparseArray<LoaderInfo> mInactiveLoaders = new SparseArray<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.116 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.116 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

    boolean mStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.116 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.116 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

    boolean mRetainingStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.116 -0400", hash_original_field = "543608B879D1153972FED6E1BBB3F2C2", hash_generated_field = "70C1252034BC616F659C7E09E95F15EB")

    boolean mCreatingLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.117 -0400", hash_original_method = "3A1775F72C10D39F9F7BFE3E62E94501", hash_generated_method = "6EE8F7AE5A898E97654D0E1F67D97ABF")
      LoaderManagerImpl(Activity activity, boolean started) {
        mActivity = activity;
        mStarted = started;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.117 -0400", hash_original_method = "ABA1AB897196E6D0611C422D598DF8DF", hash_generated_method = "D5E8998FDCF7539F6E6B2AAC47479B94")
     void updateActivity(Activity activity) {
        mActivity = activity;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.118 -0400", hash_original_method = "31DF1B394D718AFF7F9D42E1B24A1D9F", hash_generated_method = "455B467A0FC9582959D6A429D7E24441")
    private LoaderInfo createLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        addTaint(callback.getTaint());
        addTaint(args.getTaint());
        addTaint(id);
        LoaderInfo info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        Loader<Object> loader = callback.onCreateLoader(id, args);
        info.mLoader = (Loader<Object>)loader;
LoaderInfo var43CF3338FDBA93597A9562D3166E9DC4_767391245 =         info;
        var43CF3338FDBA93597A9562D3166E9DC4_767391245.addTaint(taint);
        return var43CF3338FDBA93597A9562D3166E9DC4_767391245;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.119 -0400", hash_original_method = "D2BDC915DCB9CB038EA75210255617B9", hash_generated_method = "006EBEB9848675EF1DAEF0756B358A1D")
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
LoaderInfo var43CF3338FDBA93597A9562D3166E9DC4_1138062817 =             info;
            var43CF3338FDBA93597A9562D3166E9DC4_1138062817.addTaint(taint);
            return var43CF3338FDBA93597A9562D3166E9DC4_1138062817;
        } 
        finally 
        {
            mCreatingLoader = false;
        } 
        
        
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.119 -0400", hash_original_method = "112626D5EBE4C2D89FE7194A836F5D8E", hash_generated_method = "6604F87A604CD5B12FB34F7CC7833721")
     void installLoader(LoaderInfo info) {
        addTaint(info.getTaint());
        mLoaders.put(info.mId, info);
    if(mStarted)        
        {
            info.start();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.120 -0400", hash_original_method = "E04CC49F77F654C9D0B54FC39C94F2D8", hash_generated_method = "07EA0ACA0D56B485CD3900965E12E90D")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        addTaint(callback.getTaint());
        addTaint(args.getTaint());
        addTaint(id);
    if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_111959348 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_111959348.addTaint(taint);
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_111959348;
        } 
        LoaderInfo info = mLoaders.get(id);
    if(DEBUG){ }    if(info == null)        
        {
            info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
    if(DEBUG){ }
        } 
        else
        {
    if(DEBUG){ }            info.mCallbacks = (LoaderManager.LoaderCallbacks<Object>)callback;
        } 
    if(info.mHaveData && mStarted)        
        {
            info.callOnLoadFinished(info.mLoader, info.mData);
        } 
Loader<D> var75A6A3900136EAA1B4E4C3D43F1802B1_2085917602 =         (Loader<D>)info.mLoader;
        var75A6A3900136EAA1B4E4C3D43F1802B1_2085917602.addTaint(taint);
        return var75A6A3900136EAA1B4E4C3D43F1802B1_2085917602;
        
        
            
        
        
        
        
            
            
        
            
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.122 -0400", hash_original_method = "54BE8D79606278ABB814838D7A2BEC9C", hash_generated_method = "5D5944556640F357E2AF2D876F488720")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        addTaint(callback.getTaint());
        addTaint(args.getTaint());
        addTaint(id);
    if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_1530292587 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_1530292587.addTaint(taint);
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_1530292587;
        } 
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
                } 
                else
                {
    if(!info.mStarted)                    
                    {
    if(DEBUG){ }                        mLoaders.put(id, null);
                        info.destroy();
                    } 
                    else
                    {
    if(info.mPendingLoader != null)                        
                        {
    if(DEBUG){ }                            info.mPendingLoader.destroy();
                            info.mPendingLoader = null;
                        } 
    if(DEBUG){ }                        info.mPendingLoader = createLoader(id, args, 
                                (LoaderManager.LoaderCallbacks<Object>)callback);
Loader<D> varA0A415B70AD2C3775252A85D08956D6B_379629319 =                         (Loader<D>)info.mPendingLoader.mLoader;
                        varA0A415B70AD2C3775252A85D08956D6B_379629319.addTaint(taint);
                        return varA0A415B70AD2C3775252A85D08956D6B_379629319;
                    } 
                } 
            } 
            else
            {
    if(DEBUG){ }                info.mLoader.abandon();
                mInactiveLoaders.put(id, info);
            } 
        } 
        info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
Loader<D> var75A6A3900136EAA1B4E4C3D43F1802B1_2057400106 =         (Loader<D>)info.mLoader;
        var75A6A3900136EAA1B4E4C3D43F1802B1_2057400106.addTaint(taint);
        return var75A6A3900136EAA1B4E4C3D43F1802B1_2057400106;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.123 -0400", hash_original_method = "97EDF1A6879B8A3D51445AC765920D76", hash_generated_method = "C61DA492B86C1F2525C007629C00EC81")
    public void destroyLoader(int id) {
        addTaint(id);
    if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_381262567 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_381262567.addTaint(taint);
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_381262567;
        } 
    if(DEBUG){ }        int idx = mLoaders.indexOfKey(id);
    if(idx >= 0)        
        {
            LoaderInfo info = mLoaders.valueAt(idx);
            mLoaders.removeAt(idx);
            info.destroy();
        } 
        idx = mInactiveLoaders.indexOfKey(id);
    if(idx >= 0)        
        {
            LoaderInfo info = mInactiveLoaders.valueAt(idx);
            mInactiveLoaders.removeAt(idx);
            info.destroy();
        } 
    if(mActivity != null && !hasRunningLoaders())        
        {
            mActivity.mFragments.startPendingDeferredFragments();
        } 
        
        
            
        
        
        
        
            
            
            
        
        
        
            
            
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.124 -0400", hash_original_method = "01DF8472A2697DF2BC7C6D580583CD7C", hash_generated_method = "A3FE5995FBDB3EA91CF4000B1DF5F258")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> getLoader(int id) {
        addTaint(id);
    if(mCreatingLoader)        
        {
            IllegalStateException varC1757A3C3A6F109D8AFC5079F17B7ED3_1718646673 = new IllegalStateException("Called while creating a loader");
            varC1757A3C3A6F109D8AFC5079F17B7ED3_1718646673.addTaint(taint);
            throw varC1757A3C3A6F109D8AFC5079F17B7ED3_1718646673;
        } 
        LoaderInfo loaderInfo = mLoaders.get(id);
    if(loaderInfo != null)        
        {
    if(loaderInfo.mPendingLoader != null)            
            {
Loader<D> varD7DEEECF015803983B03F1336AB68299_1548012016 =                 (Loader<D>)loaderInfo.mPendingLoader.mLoader;
                varD7DEEECF015803983B03F1336AB68299_1548012016.addTaint(taint);
                return varD7DEEECF015803983B03F1336AB68299_1548012016;
            } 
Loader<D> var9DBC3DF5BD36BC2BA7A9B881B9D6E27D_2131458697 =             (Loader<D>)loaderInfo.mLoader;
            var9DBC3DF5BD36BC2BA7A9B881B9D6E27D_2131458697.addTaint(taint);
            return var9DBC3DF5BD36BC2BA7A9B881B9D6E27D_2131458697;
        } 
Loader<D> var540C13E9E156B687226421B24F2DF178_1267660802 =         null;
        var540C13E9E156B687226421B24F2DF178_1267660802.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1267660802;
        
        
            
        
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.124 -0400", hash_original_method = "1B5BA5EF1034DE46362C6D43A3344D88", hash_generated_method = "44B4C78C42F2F803BE409A0A1DAAC173")
     void doStart() {
    if(DEBUG){ }    if(mStarted)        
        {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            return;
        } 
        mStarted = true;
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).start();
        } 
        
        
        
            
            
            
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.125 -0400", hash_original_method = "71BF743CC69E0B66056EF8CBB16C9843", hash_generated_method = "A02C6413885F34B2043666BA8DB54D1C")
     void doStop() {
    if(DEBUG){ }    if(!mStarted)        
        {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            return;
        } 
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).stop();
        } 
        mStarted = false;
        
        
        
            
            
            
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.127 -0400", hash_original_method = "BD51E42738EB85BB1FB65E8F190FCB03", hash_generated_method = "8C952EF8B307332F0EF8B649716A88C0")
     void doRetain() {
    if(DEBUG){ }    if(!mStarted)        
        {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            return;
        } 
        mRetaining = true;
        mStarted = false;
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).retain();
        } 
        
        
        
            
            
            
            
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.128 -0400", hash_original_method = "9F7DD5161F3947B5A7B3D4E3274626A8", hash_generated_method = "3159F2DC0474255D6F7687D7EDBD8FB1")
     void finishRetain() {
    if(mRetaining)        
        {
    if(DEBUG){ }            mRetaining = false;
for(int i = mLoaders.size()-1;i >= 0;i--)
            {
                mLoaders.valueAt(i).finishRetain();
            } 
        } 
        
        
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.128 -0400", hash_original_method = "BC9F0E25D287A864E557748845981277", hash_generated_method = "74F058892DF11136B396EA7422AE2D1C")
     void doReportNextStart() {
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).mReportNextStart = true;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.129 -0400", hash_original_method = "F7C6DF9C0A34E794980C884EE85C960C", hash_generated_method = "6B679AFD8B93318DBB7C14CA0C48E4FB")
     void doReportStart() {
for(int i = mLoaders.size()-1;i >= 0;i--)
        {
            mLoaders.valueAt(i).reportStart();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.130 -0400", hash_original_method = "8254B059608384C1C895825978701B08", hash_generated_method = "9A4F793884019C125993B6DB48459925")
     void doDestroy() {
    if(!mRetaining)        
        {
    if(DEBUG){ }for(int i = mLoaders.size()-1;i >= 0;i--)
            {
                mLoaders.valueAt(i).destroy();
            } 
        } 
    if(DEBUG){ }for(int i = mInactiveLoaders.size()-1;i >= 0;i--)
        {
            mInactiveLoaders.valueAt(i).destroy();
        } 
        mInactiveLoaders.clear();
        
        
            
            
                
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.130 -0400", hash_original_method = "A45A0DF363CA3802688DC012A3593E66", hash_generated_method = "D800857158B8CB6C1E446091143D27EC")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
String var2460B846747F8B22185AD8BE722266A5_1283868637 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1283868637.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1283868637;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.132 -0400", hash_original_method = "469C164486863607CE4F221F1C14A350", hash_generated_method = "F07305D376E4565BC6FE225BF47B0DD2")
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
            } 
        } 
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
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.133 -0400", hash_original_method = "3F0C9C3E43C354715EA08050096B7736", hash_generated_method = "FB3EC56D2AE76D8E3356AE6A940AB0A7")
    public boolean hasRunningLoaders() {
        boolean loadersRunning = false;
        final int count = mLoaders.size();
for(int i = 0;i < count;i++)
        {
            final LoaderInfo li = mLoaders.valueAt(i);
            loadersRunning |= li.mStarted && !li.mDeliveredData;
        } 
        boolean var606D8489253BD9E9D91CEB4E75BDD667_1115529807 = (loadersRunning);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_198184810 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_198184810;
        
        
        
        
            
            
        
        
    }

    
    final class LoaderInfo implements Loader.OnLoadCompleteListener<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.134 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

        int mId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.135 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.135 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "6C4C07AC29F4D4AA01A483F932AC882C")

        LoaderManager.LoaderCallbacks<Object> mCallbacks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.135 -0400", hash_original_field = "80FF3862892C05890CE6715239D5E8AB", hash_generated_field = "CAAC247984B2641B92D4E9BC40D546DA")

        Loader<Object> mLoader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.136 -0400", hash_original_field = "3E6578FC76C21F1A7CAE156E12A3C9E7", hash_generated_field = "8653C1EEEDD912C5198A3F395AEACFB9")

        boolean mHaveData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.136 -0400", hash_original_field = "3670C33CC4ABF71ACE43E5EE0ECFE123", hash_generated_field = "E7E3F3C458E363A4280FDF1098E7D079")

        boolean mDeliveredData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.136 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

        Object mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.136 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

        boolean mStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.136 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

        boolean mRetaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.136 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

        boolean mRetainingStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.137 -0400", hash_original_field = "8DBA0029FAB59A1B665D7DEA39DF2B1A", hash_generated_field = "620EE77E057D462DD77FE41E957B6B8F")

        boolean mReportNextStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.137 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

        boolean mDestroyed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.137 -0400", hash_original_field = "B0EC9D56AB3AFD18C789DC47DFF0EB6B", hash_generated_field = "AD96D6DFE99122F027819D4D95BE5F11")

        boolean mListenerRegistered;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.137 -0400", hash_original_field = "BFD46B06A9331820E543FDC5B0775B98", hash_generated_field = "48D26E3132EBDD98F32F802FBADD8F16")

        LoaderInfo mPendingLoader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.139 -0400", hash_original_method = "16FA523516D826BD7B81DB6C5F688F57", hash_generated_method = "B1787A946F4FAE1D5E958B14E046210B")
        public  LoaderInfo(int id, Bundle args, LoaderManager.LoaderCallbacks<Object> callbacks) {
            mId = id;
            mArgs = args;
            mCallbacks = callbacks;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.142 -0400", hash_original_method = "59414391327A086CB5A9419E1A5D3F4A", hash_generated_method = "C8D6043A98C0240E7634005FF6667E05")
         void start() {
    if(mRetaining && mRetainingStarted)            
            {
                mStarted = true;
                return;
            } 
    if(mStarted)            
            {
                return;
            } 
            mStarted = true;
    if(DEBUG){ }    if(mLoader == null && mCallbacks != null)            
            {
                mLoader = mCallbacks.onCreateLoader(mId, mArgs);
            } 
    if(mLoader != null)            
            {
    if(mLoader.getClass().isMemberClass()
                        && !Modifier.isStatic(mLoader.getClass().getModifiers()))                
                {
                    IllegalArgumentException var4B8346B77A5BF415573A735E89DFAAA9_1737176922 = new IllegalArgumentException(
                            "Object returned from onCreateLoader must not be a non-static inner member class: "
                            + mLoader);
                    var4B8346B77A5BF415573A735E89DFAAA9_1737176922.addTaint(taint);
                    throw var4B8346B77A5BF415573A735E89DFAAA9_1737176922;
                } 
    if(!mListenerRegistered)                
                {
                    mLoader.registerListener(mId, this);
                    mListenerRegistered = true;
                } 
                mLoader.startLoading();
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.143 -0400", hash_original_method = "EEEFF8F43B746CBA4F0DDA0630ACC8F2", hash_generated_method = "AAE016661F320F56649073D3D751B676")
         void retain() {
    if(DEBUG){ }            mRetaining = true;
            mRetainingStarted = mStarted;
            mStarted = false;
            mCallbacks = null;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.143 -0400", hash_original_method = "A6A41243ADFD2D6E0A8ECB9143919977", hash_generated_method = "50BF206D479089E3EB2EF78FF702712F")
         void finishRetain() {
    if(mRetaining)            
            {
    if(DEBUG){ }                mRetaining = false;
    if(mStarted != mRetainingStarted)                
                {
    if(!mStarted)                    
                    {
                        stop();
                    } 
                } 
            } 
    if(mStarted && mHaveData && !mReportNextStart)            
            {
                callOnLoadFinished(mLoader, mData);
            } 
            
            
                
                
                
                    
                        
                    
                
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.144 -0400", hash_original_method = "915BC416A2513DED4BAC846F5B62B555", hash_generated_method = "2515B7A113E051098A1F769DE291622B")
         void reportStart() {
    if(mStarted)            
            {
    if(mReportNextStart)                
                {
                    mReportNextStart = false;
    if(mHaveData)                    
                    {
                        callOnLoadFinished(mLoader, mData);
                    } 
                } 
            } 
            
            
                
                    
                    
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.145 -0400", hash_original_method = "2CBDFC8D776F45EC911F1F96CF447373", hash_generated_method = "E5ACD222CD63F167A67AD1AEBFB954D9")
         void stop() {
    if(DEBUG){ }            mStarted = false;
    if(!mRetaining)            
            {
    if(mLoader != null && mListenerRegistered)                
                {
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                    mLoader.stopLoading();
                } 
            } 
            
            
            
            
                
                    
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.146 -0400", hash_original_method = "A36048C3C1A3E46AC40E97896DEEAF8F", hash_generated_method = "A354DDDC8956DB4281E1EA7204A66E55")
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
                } 
                try 
                {
                    mCallbacks.onLoaderReset(mLoader);
                } 
                finally 
                {
    if(mActivity != null)                    
                    {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    } 
                } 
            } 
            mCallbacks = null;
            mData = null;
            mHaveData = false;
    if(mLoader != null)            
            {
    if(mListenerRegistered)                
                {
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                } 
                mLoader.reset();
            } 
    if(mPendingLoader != null)            
            {
                mPendingLoader.destroy();
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.149 -0400", hash_original_method = "5D6E68340AACAB27821B5B5851C94699", hash_generated_method = "7171DBD7033371002C95648D2C22BBD1")
        @Override
        public void onLoadComplete(Loader<Object> loader, Object data) {
            
            addTaint(loader.getTaint());
    if(DEBUG){ }    if(mDestroyed)            
            {
    if(DEBUG){ }                return;
            } 
    if(mLoaders.get(mId) != this)            
            {
    if(DEBUG){ }                return;
            } 
            LoaderInfo pending = mPendingLoader;
    if(pending != null)            
            {
    if(DEBUG){ }                mPendingLoader = null;
                mLoaders.put(mId, null);
                destroy();
                installLoader(pending);
                return;
            } 
    if(mData != data || !mHaveData)            
            {
                mData = data;
                mHaveData = true;
    if(mStarted)                
                {
                    callOnLoadFinished(loader, data);
                } 
            } 
            LoaderInfo info = mInactiveLoaders.get(mId);
    if(info != null && info != this)            
            {
                info.mDeliveredData = false;
                info.destroy();
                mInactiveLoaders.remove(mId);
            } 
    if(mActivity != null && !hasRunningLoaders())            
            {
                mActivity.mFragments.startPendingDeferredFragments();
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.151 -0400", hash_original_method = "DBCF4A7424D3CE3FF77E30E5C5EDA97C", hash_generated_method = "D9CD2462F7A0D9E8FD045E74C48C320C")
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
                } 
                try 
                {
    if(DEBUG){ }                    mCallbacks.onLoadFinished(loader, data);
                } 
                finally 
                {
    if(mActivity != null)                    
                    {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    } 
                } 
                mDeliveredData = true;
            } 
            
            
                
                
                    
                    
                
                
                    
                            
                    
                
                    
                        
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.151 -0400", hash_original_method = "6152E6E73795403DAC53E06540200214", hash_generated_method = "96863195BE2A80F59C221FC507758A9E")
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
String var2460B846747F8B22185AD8BE722266A5_1206104562 =             sb.toString();
            var2460B846747F8B22185AD8BE722266A5_1206104562.addTaint(taint);
            return var2460B846747F8B22185AD8BE722266A5_1206104562;
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.152 -0400", hash_original_method = "130B539E0C9D3012BFA3C99178E2C6F6", hash_generated_method = "23A138D4FE06A47449222DF9FDF6FE74")
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
            } 
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
            } 
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
            } 
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.153 -0400", hash_original_field = "907A52D366FFA5C236EE38B314D09A14", hash_generated_field = "6D76EEEE053128D88AD38FCE96834362")

    static final String TAG = "LoaderManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.153 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
}

