package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueuedWork {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.503 -0400", hash_original_method = "94C2F41E1F3AD149B563D9E976EAD755", hash_generated_method = "94C2F41E1F3AD149B563D9E976EAD755")
    public QueuedWork ()
    {
        //Synthesized constructor
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.505 -0400", hash_original_field = "1706E13519BFEA1A235A6A0B9DEDABA8", hash_generated_field = "CF7A539450BB674CA1A8D7869164CA83")

    private static final ConcurrentLinkedQueue<Runnable> sPendingWorkFinishers = new ConcurrentLinkedQueue<Runnable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.505 -0400", hash_original_field = "16D70348D8388507803729D3BE713163", hash_generated_field = "48846E427360D3B755393A8B7AB28CDC")

    private static ExecutorService sSingleThreadExecutor = null;
}

