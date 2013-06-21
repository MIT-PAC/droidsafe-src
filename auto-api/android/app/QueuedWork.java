package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueuedWork {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.544 -0400", hash_original_method = "8F8E40AC566D2FFCA7679DA62C466F71", hash_generated_method = "8F8E40AC566D2FFCA7679DA62C466F71")
        public QueuedWork ()
    {
    }


        public static ExecutorService singleThreadExecutor() {
        synchronized (QueuedWork.class) {
            if (sSingleThreadExecutor == null) {
                sSingleThreadExecutor = Executors.newSingleThreadExecutor();
            }
            return sSingleThreadExecutor;
        }
    }

    
        public static void add(Runnable finisher) {
        sPendingWorkFinishers.add(finisher);
    }

    
        public static void remove(Runnable finisher) {
        sPendingWorkFinishers.remove(finisher);
    }

    
        public static void waitToFinish() {
        Runnable toFinish;
        while ((toFinish = sPendingWorkFinishers.poll()) != null) {
            toFinish.run();
        }
    }

    
        public static boolean hasPendingWork() {
        return !sPendingWorkFinishers.isEmpty();
    }

    
    private static final ConcurrentLinkedQueue<Runnable> sPendingWorkFinishers =
            new ConcurrentLinkedQueue<Runnable>();
    private static ExecutorService sSingleThreadExecutor = null;
}

