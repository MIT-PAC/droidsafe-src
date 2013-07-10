package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.118 -0400", hash_original_method = "921B150ED82AB2739CD0194A062DB550", hash_generated_method = "921B150ED82AB2739CD0194A062DB550")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.119 -0400", hash_original_method = "59280299B88BC81400789A85A7BD24F4", hash_generated_method = "203D9F62B11D066BC581DB699E435787")
    public boolean hasRunningLoaders() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343675916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_343675916;
        
        
    }

    
    public interface LoaderCallbacks<D> {
        
        public Loader<D> onCreateLoader(int id, Bundle args);

        
        public void onLoadFinished(Loader<D> loader, D data);

        
        public void onLoaderReset(Loader<D> loader);
    }
    
}

class LoaderManagerImpl extends LoaderManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.119 -0400", hash_original_field = "581A48C88B1F4455461B49B9FED0F6E5", hash_generated_field = "F7D0C10CD91FC35F4677D918BBC06CFE")

    final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.119 -0400", hash_original_field = "7DAAE059AA586D05F0C81A3816E7F517", hash_generated_field = "432E345626C0D17D30ADB55101BDE065")

    final SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.119 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "7ECAB8F1DFD4D8C88111D51780B29562")

    String mWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.120 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "DC6970CAF75184DB6DB1AAC52EA720C0")

    FragmentActivity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.120 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

    boolean mStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.120 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.120 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

    boolean mRetainingStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.120 -0400", hash_original_field = "543608B879D1153972FED6E1BBB3F2C2", hash_generated_field = "70C1252034BC616F659C7E09E95F15EB")

    boolean mCreatingLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.120 -0400", hash_original_method = "8A8E6D86E6D6B2C8C93367E841E4998B", hash_generated_method = "6C4A23BB54B986C26908C5D945FDD353")
      LoaderManagerImpl(String who, FragmentActivity activity, boolean started) {
        mWho = who;
        mActivity = activity;
        mStarted = started;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.120 -0400", hash_original_method = "39148A68E08215CAB837BA67F40FAA62", hash_generated_method = "FD7298AAA1462E00D71BDFDBAB50C6A6")
     void updateActivity(FragmentActivity activity) {
        mActivity = activity;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.121 -0400", hash_original_method = "31DF1B394D718AFF7F9D42E1B24A1D9F", hash_generated_method = "6E7C5D7F71D911222D981FB0E9ECD4E6")
    private LoaderInfo createLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        LoaderInfo varB4EAC82CA7396A68D541C85D26508E83_2142651357 = null; 
        LoaderInfo info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        Loader<Object> loader = callback.onCreateLoader(id, args);
        info.mLoader = (Loader<Object>)loader;
        varB4EAC82CA7396A68D541C85D26508E83_2142651357 = info;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2142651357.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2142651357;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.122 -0400", hash_original_method = "D2BDC915DCB9CB038EA75210255617B9", hash_generated_method = "644840DC5B314E77BF544FF67E5670ED")
    private LoaderInfo createAndInstallLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        LoaderInfo varB4EAC82CA7396A68D541C85D26508E83_181717668 = null; 
        try 
        {
            mCreatingLoader = true;
            LoaderInfo info = createLoader(id, args, callback);
            installLoader(info);
            varB4EAC82CA7396A68D541C85D26508E83_181717668 = info;
        } 
        finally 
        {
            mCreatingLoader = false;
        } 
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_181717668.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_181717668;
        
        
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.122 -0400", hash_original_method = "112626D5EBE4C2D89FE7194A836F5D8E", hash_generated_method = "4200F51A22DB1E04932FCFE2B04790F0")
     void installLoader(LoaderInfo info) {
        mLoaders.put(info.mId, info);
        {
            info.start();
        } 
        addTaint(info.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.123 -0400", hash_original_method = "E04CC49F77F654C9D0B54FC39C94F2D8", hash_generated_method = "D5AB33F56213BC8DCD16A1EE326B487A")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_104373116 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } 
        LoaderInfo info = mLoaders.get(id);
        {
            info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        } 
        {
            info.mCallbacks = (LoaderManager.LoaderCallbacks<Object>)callback;
        } 
        {
            info.callOnLoadFinished(info.mLoader, info.mData);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_104373116 = (Loader<D>)info.mLoader;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_104373116.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_104373116;
        
        
            
        
        
        
        
            
            
        
            
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.125 -0400", hash_original_method = "54BE8D79606278ABB814838D7A2BEC9C", hash_generated_method = "106B90568739E78F39F900D7A5EE9936")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1250925196 = null; 
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_962876979 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } 
        LoaderInfo info = mLoaders.get(id);
        {
            LoaderInfo inactive = mInactiveLoaders.get(id);
            {
                {
                    inactive.mDeliveredData = false;
                    inactive.destroy();
                    info.mLoader.abandon();
                    mInactiveLoaders.put(id, info);
                } 
                {
                    {
                        mLoaders.put(id, null);
                        info.destroy();
                    } 
                    {
                        {
                            info.mPendingLoader.destroy();
                            info.mPendingLoader = null;
                        } 
                        info.mPendingLoader = createLoader(id, args, 
                                (LoaderManager.LoaderCallbacks<Object>)callback);
                        varB4EAC82CA7396A68D541C85D26508E83_1250925196 = (Loader<D>)info.mPendingLoader.mLoader;
                    } 
                } 
            } 
            {
                info.mLoader.abandon();
                mInactiveLoaders.put(id, info);
            } 
        } 
        info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        varB4EAC82CA7396A68D541C85D26508E83_962876979 = (Loader<D>)info.mLoader;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        Loader<D> varA7E53CE21691AB073D9660D615818899_1192983966; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1192983966 = varB4EAC82CA7396A68D541C85D26508E83_1250925196;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1192983966 = varB4EAC82CA7396A68D541C85D26508E83_962876979;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1192983966.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1192983966;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.125 -0400", hash_original_method = "97EDF1A6879B8A3D51445AC765920D76", hash_generated_method = "5A5EF2DEF3C709E84DAC4C277DFD8DB1")
    public void destroyLoader(int id) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } 
        int idx = mLoaders.indexOfKey(id);
        {
            LoaderInfo info = mLoaders.valueAt(idx);
            mLoaders.removeAt(idx);
            info.destroy();
        } 
        idx = mInactiveLoaders.indexOfKey(id);
        {
            LoaderInfo info = mInactiveLoaders.valueAt(idx);
            mInactiveLoaders.removeAt(idx);
            info.destroy();
        } 
        {
            boolean varAA85D886B05D83FC0ED3196B796619BB_642763107 = (mActivity != null && !hasRunningLoaders());
            {
                mActivity.mFragments.startPendingDeferredFragments();
            } 
        } 
        addTaint(id);
        
        
            
        
        
        
        
            
            
            
        
        
        
            
            
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.126 -0400", hash_original_method = "01DF8472A2697DF2BC7C6D580583CD7C", hash_generated_method = "C94B789A1F65799597E23DD0200EE98D")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> getLoader(int id) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_261613159 = null; 
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_278716477 = null; 
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_906690783 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } 
        LoaderInfo loaderInfo = mLoaders.get(id);
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_261613159 = (Loader<D>)loaderInfo.mPendingLoader.mLoader;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_278716477 = (Loader<D>)loaderInfo.mLoader;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_906690783 = null;
        addTaint(id);
        Loader<D> varA7E53CE21691AB073D9660D615818899_394061936; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_394061936 = varB4EAC82CA7396A68D541C85D26508E83_261613159;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_394061936 = varB4EAC82CA7396A68D541C85D26508E83_278716477;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_394061936 = varB4EAC82CA7396A68D541C85D26508E83_906690783;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_394061936.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_394061936;
        
        
            
        
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.127 -0400", hash_original_method = "1B5BA5EF1034DE46362C6D43A3344D88", hash_generated_method = "0EAD6FA183A12DD870FB39B2A92EBA78")
     void doStart() {
        {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
        } 
        mStarted = true;
        {
            int i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).start();
            } 
        } 
        
        
        
            
            
            
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.127 -0400", hash_original_method = "71BF743CC69E0B66056EF8CBB16C9843", hash_generated_method = "9881D230DD563F657FE4F20283934A09")
     void doStop() {
        {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
        } 
        {
            int i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).stop();
            } 
        } 
        mStarted = false;
        
        
        
            
            
            
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.127 -0400", hash_original_method = "BD51E42738EB85BB1FB65E8F190FCB03", hash_generated_method = "46B2C9036A6C49723A318318CA79A4F6")
     void doRetain() {
        {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
        } 
        mRetaining = true;
        mStarted = false;
        {
            int i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).retain();
            } 
        } 
        
        
        
            
            
            
            
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.128 -0400", hash_original_method = "9F7DD5161F3947B5A7B3D4E3274626A8", hash_generated_method = "17381E94366149D77887947445DC1D95")
     void finishRetain() {
        {
            mRetaining = false;
            {
                int i = mLoaders.size()-1;
                {
                    mLoaders.valueAt(i).finishRetain();
                } 
            } 
        } 
        
        
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.128 -0400", hash_original_method = "BC9F0E25D287A864E557748845981277", hash_generated_method = "F44B93EC3388D313DB676819CB5AE283")
     void doReportNextStart() {
        {
            int i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).mReportNextStart = true;
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.129 -0400", hash_original_method = "F7C6DF9C0A34E794980C884EE85C960C", hash_generated_method = "59130A82E76428669CF9F132B79D4ADB")
     void doReportStart() {
        {
            int i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).reportStart();
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.129 -0400", hash_original_method = "736E3BF19FA9B5737831BA1044201B86", hash_generated_method = "70FCE74AA4C8D88DE9CE8FD683F232A0")
     void doDestroy() {
        {
            {
                int i = mLoaders.size()-1;
                {
                    mLoaders.valueAt(i).destroy();
                } 
            } 
            mLoaders.clear();
        } 
        {
            int i = mInactiveLoaders.size()-1;
            {
                mInactiveLoaders.valueAt(i).destroy();
            } 
        } 
        mInactiveLoaders.clear();
        
        
            
            
                
            
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.130 -0400", hash_original_method = "A45A0DF363CA3802688DC012A3593E66", hash_generated_method = "15AF77F9951AF3517E3FDC198269D9A0")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1751089937 = null; 
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        varB4EAC82CA7396A68D541C85D26508E83_1751089937 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1751089937.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1751089937;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.131 -0400", hash_original_method = "469C164486863607CE4F221F1C14A350", hash_generated_method = "32112F2EBA13FCB8F05EBBB10E7BC8E7")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        {
            boolean varEE58C679480D0972D699B2684BCEBD96_1000379250 = (mLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Active Loaders:");
                String innerPrefix = prefix + "    ";
                {
                    int i = 0;
                    boolean var3DD1886DF4F41430C4BFFAEA91986789_1153702343 = (i < mLoaders.size());
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
            } 
        } 
        {
            boolean var282C5CDAE1350DAB1D040F1744D3C286_455710427 = (mInactiveLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Inactive Loaders:");
                String innerPrefix = prefix + "    ";
                {
                    int i = 0;
                    boolean var898D73B8559A4D372B97514D1C022E2A_565036576 = (i < mInactiveLoaders.size());
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
        } 
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.131 -0400", hash_original_method = "3F0C9C3E43C354715EA08050096B7736", hash_generated_method = "548108471C7FCABF3A5B94264E0BDD71")
    @Override
    public boolean hasRunningLoaders() {
        boolean loadersRunning = false;
        final int count = mLoaders.size();
        {
            int i = 0;
            {
                final LoaderInfo li = mLoaders.valueAt(i);
                loadersRunning |= li.mStarted && !li.mDeliveredData;
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475434134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475434134;
        
        
        
        
            
            
        
        
    }

    
    final class LoaderInfo implements Loader.OnLoadCompleteListener<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.131 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

        int mId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.131 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "6C4C07AC29F4D4AA01A483F932AC882C")

        LoaderManager.LoaderCallbacks<Object> mCallbacks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "80FF3862892C05890CE6715239D5E8AB", hash_generated_field = "CAAC247984B2641B92D4E9BC40D546DA")

        Loader<Object> mLoader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "3E6578FC76C21F1A7CAE156E12A3C9E7", hash_generated_field = "8653C1EEEDD912C5198A3F395AEACFB9")

        boolean mHaveData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "3670C33CC4ABF71ACE43E5EE0ECFE123", hash_generated_field = "E7E3F3C458E363A4280FDF1098E7D079")

        boolean mDeliveredData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

        Object mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

        boolean mStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

        boolean mRetaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

        boolean mRetainingStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "8DBA0029FAB59A1B665D7DEA39DF2B1A", hash_generated_field = "620EE77E057D462DD77FE41E957B6B8F")

        boolean mReportNextStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

        boolean mDestroyed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "B0EC9D56AB3AFD18C789DC47DFF0EB6B", hash_generated_field = "AD96D6DFE99122F027819D4D95BE5F11")

        boolean mListenerRegistered;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.132 -0400", hash_original_field = "BFD46B06A9331820E543FDC5B0775B98", hash_generated_field = "48D26E3132EBDD98F32F802FBADD8F16")

        LoaderInfo mPendingLoader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.133 -0400", hash_original_method = "16FA523516D826BD7B81DB6C5F688F57", hash_generated_method = "B1787A946F4FAE1D5E958B14E046210B")
        public  LoaderInfo(int id, Bundle args, LoaderManager.LoaderCallbacks<Object> callbacks) {
            mId = id;
            mArgs = args;
            mCallbacks = callbacks;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.134 -0400", hash_original_method = "59414391327A086CB5A9419E1A5D3F4A", hash_generated_method = "A827FD5FE9845E2E8D6C09966A4EED99")
         void start() {
            {
                mStarted = true;
            } 
            mStarted = true;
            {
                mLoader = mCallbacks.onCreateLoader(mId, mArgs);
            } 
            {
                {
                    boolean varC59DA0641E3D9EFCA2CBD395510230E2_785926468 = (mLoader.getClass().isMemberClass()
                        && !Modifier.isStatic(mLoader.getClass().getModifiers()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                            "Object returned from onCreateLoader must not be a non-static inner member class: "
                            + mLoader);
                    } 
                } 
                {
                    mLoader.registerListener(mId, this);
                    mListenerRegistered = true;
                } 
                mLoader.startLoading();
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.134 -0400", hash_original_method = "EEEFF8F43B746CBA4F0DDA0630ACC8F2", hash_generated_method = "EF8C98B11E97B53B0DE39492B29BBEC6")
         void retain() {
            mRetaining = true;
            mRetainingStarted = mStarted;
            mStarted = false;
            mCallbacks = null;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.135 -0400", hash_original_method = "A6A41243ADFD2D6E0A8ECB9143919977", hash_generated_method = "3A81054A3E09BDCCCBA90E364893D4A9")
         void finishRetain() {
            {
                mRetaining = false;
                {
                    {
                        stop();
                    } 
                } 
            } 
            {
                callOnLoadFinished(mLoader, mData);
            } 
            
            
                
                
                
                    
                        
                    
                
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.135 -0400", hash_original_method = "915BC416A2513DED4BAC846F5B62B555", hash_generated_method = "0F987794529CE8B7289FD21EEB54AC26")
         void reportStart() {
            {
                {
                    mReportNextStart = false;
                    {
                        callOnLoadFinished(mLoader, mData);
                    } 
                } 
            } 
            
            
                
                    
                    
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.136 -0400", hash_original_method = "2CBDFC8D776F45EC911F1F96CF447373", hash_generated_method = "BF077203F7B68E38F80D7B958B25635B")
         void stop() {
            mStarted = false;
            {
                {
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                    mLoader.stopLoading();
                } 
            } 
            
            
            
            
                
                    
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.136 -0400", hash_original_method = "A36048C3C1A3E46AC40E97896DEEAF8F", hash_generated_method = "DEE08BBC16902BD1FA5093968A643AFC")
         void destroy() {
            mDestroyed = true;
            boolean needReset = mDeliveredData;
            mDeliveredData = false;
            {
                String lastBecause = null;
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
                    {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    } 
                } 
            } 
            mCallbacks = null;
            mData = null;
            mHaveData = false;
            {
                {
                    mListenerRegistered = false;
                    mLoader.unregisterListener(this);
                } 
                mLoader.reset();
            } 
            {
                mPendingLoader.destroy();
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.137 -0400", hash_original_method = "5D6E68340AACAB27821B5B5851C94699", hash_generated_method = "B425FF8053424F3261686BE7161173E4")
        @Override
        public void onLoadComplete(Loader<Object> loader, Object data) {
            
            {
                boolean var333CD009E2691114D1D942AFA1A276F0_1696759826 = (mLoaders.get(mId) != this);
            } 
            LoaderInfo pending = mPendingLoader;
            {
                mPendingLoader = null;
                mLoaders.put(mId, null);
                destroy();
                installLoader(pending);
            } 
            {
                mData = data;
                mHaveData = true;
                {
                    callOnLoadFinished(loader, data);
                } 
            } 
            LoaderInfo info = mInactiveLoaders.get(mId);
            {
                boolean var096B903244A3118F8D65EEC99906CE4F_164472542 = (info != null && info != this);
                {
                    info.mDeliveredData = false;
                    info.destroy();
                    mInactiveLoaders.remove(mId);
                } 
            } 
            {
                boolean var6F7A2F80E7742D15ECC5F8E1556DAF45_95703288 = (mActivity != null && !hasRunningLoaders());
                {
                    mActivity.mFragments.startPendingDeferredFragments();
                } 
            } 
            addTaint(loader.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.138 -0400", hash_original_method = "DBCF4A7424D3CE3FF77E30E5C5EDA97C", hash_generated_method = "5A26DF3A6980FDD1C5B870809B2EEB2A")
         void callOnLoadFinished(Loader<Object> loader, Object data) {
            {
                String lastBecause = null;
                {
                    lastBecause = mActivity.mFragments.mNoTransactionsBecause;
                    mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
                } 
                try 
                {
                    mCallbacks.onLoadFinished(loader, data);
                } 
                finally 
                {
                    {
                        mActivity.mFragments.mNoTransactionsBecause = lastBecause;
                    } 
                } 
                mDeliveredData = true;
            } 
            addTaint(loader.getTaint());
            addTaint(data.getTaint());
            
            
                
                
                    
                    
                
                
                    
                            
                    
                
                    
                        
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.138 -0400", hash_original_method = "6152E6E73795403DAC53E06540200214", hash_generated_method = "B820032D301E3C55BD088E7A44E7F7D6")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1482217707 = null; 
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(mLoader, sb);
            sb.append("}}");
            varB4EAC82CA7396A68D541C85D26508E83_1482217707 = sb.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1482217707.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1482217707;
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.139 -0400", hash_original_method = "130B539E0C9D3012BFA3C99178E2C6F6", hash_generated_method = "922875F751B77895EB9ED24AA5FCF5AA")
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
            } 
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
            {
                writer.print(prefix);
                writer.println("Pending Loader ");
                writer.print(mPendingLoader);
                writer.println(":");
                mPendingLoader.dump(prefix + "  ", fd, writer, args);
            } 
            addTaint(prefix.getTaint());
            addTaint(fd.getTaint());
            addTaint(writer.getTaint());
            addTaint(args[0].getTaint());
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.139 -0400", hash_original_field = "907A52D366FFA5C236EE38B314D09A14", hash_generated_field = "6D76EEEE053128D88AD38FCE96834362")

    static final String TAG = "LoaderManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.139 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
}

