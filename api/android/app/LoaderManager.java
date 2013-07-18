package android.app;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.content.Loader;
import android.os.Bundle;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class LoaderManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.011 -0400", hash_original_method = "921B150ED82AB2739CD0194A062DB550", hash_generated_method = "921B150ED82AB2739CD0194A062DB550")
    public LoaderManager ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract <D> Loader<D> initLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<D> callback);

    
    @DSModeled(DSC.SAFE)
    public abstract <D> Loader<D> restartLoader(int id, Bundle args,
            LoaderManager.LoaderCallbacks<D> callback);

    
    @DSModeled(DSC.SAFE)
    public abstract void destroyLoader(int id);

    
    @DSModeled(DSC.SAFE)
    public abstract <D> Loader<D> getLoader(int id);

    
    @DSModeled(DSC.SAFE)
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

