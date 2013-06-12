package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueuedWork {
    private static final ConcurrentLinkedQueue<Runnable> sPendingWorkFinishers =
            new ConcurrentLinkedQueue<Runnable>();
    private static ExecutorService sSingleThreadExecutor = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.007 -0400", hash_original_method = "13E1A18DB49260CED334452DE885FB8A", hash_generated_method = "E796C07BD021D64E7EF6413F2DC1E006")
    public static ExecutorService singleThreadExecutor() {
        synchronized (QueuedWork.class) {
            if (sSingleThreadExecutor == null) {
                sSingleThreadExecutor = Executors.newSingleThreadExecutor();
            }
            return sSingleThreadExecutor;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.007 -0400", hash_original_method = "7B6375E3361202B2623A569246ADB845", hash_generated_method = "86CE4C043442D3BE24E2CEC21928CA6A")
    public static void add(Runnable finisher) {
        sPendingWorkFinishers.add(finisher);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.007 -0400", hash_original_method = "417BEE19E0D290A8A24EFBE6B2C62725", hash_generated_method = "9514EA57B6A9BA3DF3BD34C31E2AEBEB")
    public static void remove(Runnable finisher) {
        sPendingWorkFinishers.remove(finisher);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.008 -0400", hash_original_method = "0ABA14D3C219E3137A12A8B54201A585", hash_generated_method = "1BEEE3D600CCD50D9170B9CA2284E416")
    public static void waitToFinish() {
        Runnable toFinish;
        while ((toFinish = sPendingWorkFinishers.poll()) != null) {
            toFinish.run();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.008 -0400", hash_original_method = "3EDC66A2B3D8F14E5C835683106EF1A9", hash_generated_method = "8A1497FE1DF985F390DD86C438698A75")
    public static boolean hasPendingWork() {
        return !sPendingWorkFinishers.isEmpty();
    }

    
}


