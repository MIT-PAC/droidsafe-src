package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.456 -0400", hash_original_method = "921B150ED82AB2739CD0194A062DB550", hash_generated_method = "921B150ED82AB2739CD0194A062DB550")
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.462 -0400", hash_original_field = "D9842D86F1B621627D8D7761167C5582", hash_generated_field = "19761E4007287AB328849D421B39EA27")

    final SparseArray<LoaderInfo> mLoaders = new SparseArray<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.463 -0400", hash_original_field = "5F2130CD4BD2601B065CC003AAB5BEB5", hash_generated_field = "4162D233DB58F382521F27DC73373950")

    final SparseArray<LoaderInfo> mInactiveLoaders = new SparseArray<LoaderInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.463 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.463 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

    boolean mStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.463 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.463 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

    boolean mRetainingStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.463 -0400", hash_original_field = "543608B879D1153972FED6E1BBB3F2C2", hash_generated_field = "70C1252034BC616F659C7E09E95F15EB")

    boolean mCreatingLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.464 -0400", hash_original_method = "3A1775F72C10D39F9F7BFE3E62E94501", hash_generated_method = "6EE8F7AE5A898E97654D0E1F67D97ABF")
      LoaderManagerImpl(Activity activity, boolean started) {
        mActivity = activity;
        mStarted = started;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.465 -0400", hash_original_method = "ABA1AB897196E6D0611C422D598DF8DF", hash_generated_method = "D5E8998FDCF7539F6E6B2AAC47479B94")
     void updateActivity(Activity activity) {
        mActivity = activity;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.468 -0400", hash_original_method = "31DF1B394D718AFF7F9D42E1B24A1D9F", hash_generated_method = "97A01B9EC5E2DA5E1148ACCE7444C0BE")
    private LoaderInfo createLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        LoaderInfo varB4EAC82CA7396A68D541C85D26508E83_88926463 = null; 
        LoaderInfo info = new LoaderInfo(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        Loader<Object> loader = callback.onCreateLoader(id, args);
        info.mLoader = (Loader<Object>)loader;
        varB4EAC82CA7396A68D541C85D26508E83_88926463 = info;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_88926463.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_88926463;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.473 -0400", hash_original_method = "D2BDC915DCB9CB038EA75210255617B9", hash_generated_method = "D8A8597EC81E40214C065AE7F30543F5")
    private LoaderInfo createAndInstallLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<Object> callback) {
        LoaderInfo varB4EAC82CA7396A68D541C85D26508E83_2075208507 = null; 
        try 
        {
            mCreatingLoader = true;
            LoaderInfo info = createLoader(id, args, callback);
            installLoader(info);
            varB4EAC82CA7396A68D541C85D26508E83_2075208507 = info;
        } 
        finally 
        {
            mCreatingLoader = false;
        } 
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2075208507.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2075208507;
        
        
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.474 -0400", hash_original_method = "112626D5EBE4C2D89FE7194A836F5D8E", hash_generated_method = "4200F51A22DB1E04932FCFE2B04790F0")
     void installLoader(LoaderInfo info) {
        mLoaders.put(info.mId, info);
        {
            info.start();
        } 
        addTaint(info.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.477 -0400", hash_original_method = "E04CC49F77F654C9D0B54FC39C94F2D8", hash_generated_method = "3010E3BBDC1DA895922A277FBD46BCC1")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1570075111 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_1570075111 = (Loader<D>)info.mLoader;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1570075111.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1570075111;
        
        
            
        
        
        
        
            
            
        
            
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.483 -0400", hash_original_method = "54BE8D79606278ABB814838D7A2BEC9C", hash_generated_method = "1863CAD0BADBE528EC30A6C1585EB216")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderManager.LoaderCallbacks<D> callback) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_462198452 = null; 
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1426366838 = null; 
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
                        varB4EAC82CA7396A68D541C85D26508E83_462198452 = (Loader<D>)info.mPendingLoader.mLoader;
                    } 
                } 
            } 
            {
                info.mLoader.abandon();
                mInactiveLoaders.put(id, info);
            } 
        } 
        info = createAndInstallLoader(id, args,  (LoaderManager.LoaderCallbacks<Object>)callback);
        varB4EAC82CA7396A68D541C85D26508E83_1426366838 = (Loader<D>)info.mLoader;
        addTaint(id);
        addTaint(args.getTaint());
        addTaint(callback.getTaint());
        Loader<D> varA7E53CE21691AB073D9660D615818899_369357387; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_369357387 = varB4EAC82CA7396A68D541C85D26508E83_462198452;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_369357387 = varB4EAC82CA7396A68D541C85D26508E83_1426366838;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_369357387.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_369357387;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.484 -0400", hash_original_method = "97EDF1A6879B8A3D51445AC765920D76", hash_generated_method = "E6332C88610FD2C1C3E89FC1073A6025")
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
            boolean varAA85D886B05D83FC0ED3196B796619BB_1278317331 = (mActivity != null && !hasRunningLoaders());
            {
                mActivity.mFragments.startPendingDeferredFragments();
            } 
        } 
        addTaint(id);
        
        
            
        
        
        
        
            
            
            
        
        
        
            
            
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.489 -0400", hash_original_method = "01DF8472A2697DF2BC7C6D580583CD7C", hash_generated_method = "4F3BD947C52E2CB94444164EC30D452A")
    @SuppressWarnings("unchecked")
    public <D> Loader<D> getLoader(int id) {
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1927861845 = null; 
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_1756079347 = null; 
        Loader<D> varB4EAC82CA7396A68D541C85D26508E83_390595457 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Called while creating a loader");
        } 
        LoaderInfo loaderInfo = mLoaders.get(id);
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1927861845 = (Loader<D>)loaderInfo.mPendingLoader.mLoader;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1756079347 = (Loader<D>)loaderInfo.mLoader;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_390595457 = null;
        addTaint(id);
        Loader<D> varA7E53CE21691AB073D9660D615818899_1605363711; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1605363711 = varB4EAC82CA7396A68D541C85D26508E83_1927861845;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1605363711 = varB4EAC82CA7396A68D541C85D26508E83_1756079347;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1605363711 = varB4EAC82CA7396A68D541C85D26508E83_390595457;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1605363711.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1605363711;
        
        
            
        
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.491 -0400", hash_original_method = "1B5BA5EF1034DE46362C6D43A3344D88", hash_generated_method = "0EAD6FA183A12DD870FB39B2A92EBA78")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.493 -0400", hash_original_method = "71BF743CC69E0B66056EF8CBB16C9843", hash_generated_method = "9881D230DD563F657FE4F20283934A09")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.494 -0400", hash_original_method = "BD51E42738EB85BB1FB65E8F190FCB03", hash_generated_method = "46B2C9036A6C49723A318318CA79A4F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.495 -0400", hash_original_method = "9F7DD5161F3947B5A7B3D4E3274626A8", hash_generated_method = "17381E94366149D77887947445DC1D95")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.496 -0400", hash_original_method = "BC9F0E25D287A864E557748845981277", hash_generated_method = "F44B93EC3388D313DB676819CB5AE283")
     void doReportNextStart() {
        {
            int i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).mReportNextStart = true;
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.497 -0400", hash_original_method = "F7C6DF9C0A34E794980C884EE85C960C", hash_generated_method = "59130A82E76428669CF9F132B79D4ADB")
     void doReportStart() {
        {
            int i = mLoaders.size()-1;
            {
                mLoaders.valueAt(i).reportStart();
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.498 -0400", hash_original_method = "8254B059608384C1C895825978701B08", hash_generated_method = "26574CE367AC003F0221FB11DE6B96B6")
     void doDestroy() {
        {
            {
                int i = mLoaders.size()-1;
                {
                    mLoaders.valueAt(i).destroy();
                } 
            } 
        } 
        {
            int i = mInactiveLoaders.size()-1;
            {
                mInactiveLoaders.valueAt(i).destroy();
            } 
        } 
        mInactiveLoaders.clear();
        
        
            
            
                
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.501 -0400", hash_original_method = "A45A0DF363CA3802688DC012A3593E66", hash_generated_method = "B72E0F0C3B139893F97ED04201A042C5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1793931676 = null; 
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        varB4EAC82CA7396A68D541C85D26508E83_1793931676 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1793931676.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1793931676;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.503 -0400", hash_original_method = "469C164486863607CE4F221F1C14A350", hash_generated_method = "34D63951D318A38FA04511CFE0E3866B")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        {
            boolean varEE58C679480D0972D699B2684BCEBD96_2064371393 = (mLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Active Loaders:");
                String innerPrefix = prefix + "    ";
                {
                    int i = 0;
                    boolean var3DD1886DF4F41430C4BFFAEA91986789_436504537 = (i < mLoaders.size());
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
            boolean var282C5CDAE1350DAB1D040F1744D3C286_684418430 = (mInactiveLoaders.size() > 0);
            {
                writer.print(prefix);
                writer.println("Inactive Loaders:");
                String innerPrefix = prefix + "    ";
                {
                    int i = 0;
                    boolean var898D73B8559A4D372B97514D1C022E2A_1121225258 = (i < mInactiveLoaders.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_method = "3F0C9C3E43C354715EA08050096B7736", hash_generated_method = "774F49EDC57396C3E5B002FB3B33E6B2")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141884953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141884953;
        
        
        
        
            
            
        
        
    }

    
    final class LoaderInfo implements Loader.OnLoadCompleteListener<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

        int mId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "6C4C07AC29F4D4AA01A483F932AC882C")

        LoaderManager.LoaderCallbacks<Object> mCallbacks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_field = "80FF3862892C05890CE6715239D5E8AB", hash_generated_field = "CAAC247984B2641B92D4E9BC40D546DA")

        Loader<Object> mLoader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_field = "3E6578FC76C21F1A7CAE156E12A3C9E7", hash_generated_field = "8653C1EEEDD912C5198A3F395AEACFB9")

        boolean mHaveData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_field = "3670C33CC4ABF71ACE43E5EE0ECFE123", hash_generated_field = "E7E3F3C458E363A4280FDF1098E7D079")

        boolean mDeliveredData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "F7E50CC556DF4A3D9F10FA584C62181F")

        Object mData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_field = "7103AE9E2C0D3B676C4EDC763D39DFCF", hash_generated_field = "8C92DC16A5D2F989C0A1D4375841DEF1")

        boolean mStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.505 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

        boolean mRetaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.506 -0400", hash_original_field = "728049A36F1CE64BE02E66E51ABA25C8", hash_generated_field = "6706C7B993D72CED6D04255D2F46A6E0")

        boolean mRetainingStarted;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.506 -0400", hash_original_field = "8DBA0029FAB59A1B665D7DEA39DF2B1A", hash_generated_field = "620EE77E057D462DD77FE41E957B6B8F")

        boolean mReportNextStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.506 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

        boolean mDestroyed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.506 -0400", hash_original_field = "B0EC9D56AB3AFD18C789DC47DFF0EB6B", hash_generated_field = "AD96D6DFE99122F027819D4D95BE5F11")

        boolean mListenerRegistered;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.506 -0400", hash_original_field = "BFD46B06A9331820E543FDC5B0775B98", hash_generated_field = "48D26E3132EBDD98F32F802FBADD8F16")

        LoaderInfo mPendingLoader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.507 -0400", hash_original_method = "16FA523516D826BD7B81DB6C5F688F57", hash_generated_method = "B1787A946F4FAE1D5E958B14E046210B")
        public  LoaderInfo(int id, Bundle args, LoaderManager.LoaderCallbacks<Object> callbacks) {
            mId = id;
            mArgs = args;
            mCallbacks = callbacks;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.508 -0400", hash_original_method = "59414391327A086CB5A9419E1A5D3F4A", hash_generated_method = "EE4E01BEDE03BBD3079421AD904E422B")
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
                    boolean varC59DA0641E3D9EFCA2CBD395510230E2_489424217 = (mLoader.getClass().isMemberClass()
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.509 -0400", hash_original_method = "EEEFF8F43B746CBA4F0DDA0630ACC8F2", hash_generated_method = "EF8C98B11E97B53B0DE39492B29BBEC6")
         void retain() {
            mRetaining = true;
            mRetainingStarted = mStarted;
            mStarted = false;
            mCallbacks = null;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.511 -0400", hash_original_method = "A6A41243ADFD2D6E0A8ECB9143919977", hash_generated_method = "3A81054A3E09BDCCCBA90E364893D4A9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.513 -0400", hash_original_method = "915BC416A2513DED4BAC846F5B62B555", hash_generated_method = "0F987794529CE8B7289FD21EEB54AC26")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.514 -0400", hash_original_method = "2CBDFC8D776F45EC911F1F96CF447373", hash_generated_method = "BF077203F7B68E38F80D7B958B25635B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.516 -0400", hash_original_method = "A36048C3C1A3E46AC40E97896DEEAF8F", hash_generated_method = "DEE08BBC16902BD1FA5093968A643AFC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.517 -0400", hash_original_method = "5D6E68340AACAB27821B5B5851C94699", hash_generated_method = "12841964AA3E410CAE0B06C63E3DB0B7")
        @Override
        public void onLoadComplete(Loader<Object> loader, Object data) {
            
            {
                boolean var333CD009E2691114D1D942AFA1A276F0_1506647588 = (mLoaders.get(mId) != this);
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
                boolean var096B903244A3118F8D65EEC99906CE4F_1245791333 = (info != null && info != this);
                {
                    info.mDeliveredData = false;
                    info.destroy();
                    mInactiveLoaders.remove(mId);
                } 
            } 
            {
                boolean var6F7A2F80E7742D15ECC5F8E1556DAF45_1162826020 = (mActivity != null && !hasRunningLoaders());
                {
                    mActivity.mFragments.startPendingDeferredFragments();
                } 
            } 
            addTaint(loader.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.519 -0400", hash_original_method = "DBCF4A7424D3CE3FF77E30E5C5EDA97C", hash_generated_method = "5A26DF3A6980FDD1C5B870809B2EEB2A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.523 -0400", hash_original_method = "6152E6E73795403DAC53E06540200214", hash_generated_method = "5D8E946B31B09A54F39F883F0A91B05A")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_773364294 = null; 
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(mLoader, sb);
            sb.append("}}");
            varB4EAC82CA7396A68D541C85D26508E83_773364294 = sb.toString();
            varB4EAC82CA7396A68D541C85D26508E83_773364294.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_773364294;
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.525 -0400", hash_original_method = "130B539E0C9D3012BFA3C99178E2C6F6", hash_generated_method = "922875F751B77895EB9ED24AA5FCF5AA")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.525 -0400", hash_original_field = "907A52D366FFA5C236EE38B314D09A14", hash_generated_field = "6D76EEEE053128D88AD38FCE96834362")

    static final String TAG = "LoaderManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.525 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
}

