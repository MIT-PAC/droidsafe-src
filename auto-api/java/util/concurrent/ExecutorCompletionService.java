package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExecutorCompletionService<V> implements CompletionService<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.705 -0400", hash_original_field = "B1925939F66C2E4625AADB18CABF1CEA", hash_generated_field = "C344975DD4C90ADC5A05E9EE82CE3C44")

    private Executor executor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.705 -0400", hash_original_field = "6D3C5993CA017D0FF169B425D3193F02", hash_generated_field = "2BE08B300EAA426E148B747157CCD2EE")

    private AbstractExecutorService aes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.705 -0400", hash_original_field = "2EF30EEC1E91B410D78F022E61CAA304", hash_generated_field = "9ACC5A1B9A9F1BE7ABF80562A03906F3")

    private BlockingQueue<Future<V>> completionQueue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.706 -0400", hash_original_method = "EDD261742BCF15D9FB8B326368F1ACDA", hash_generated_method = "93BC376C9B6784A7F85FC931D960C4F1")
    public  ExecutorCompletionService(Executor executor) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.executor = executor;
        this.aes = (executor instanceof AbstractExecutorService) ?
            (AbstractExecutorService) executor : null;
        this.completionQueue = new LinkedBlockingQueue<Future<V>>();
        // ---------- Original Method ----------
        //if (executor == null)
            //throw new NullPointerException();
        //this.executor = executor;
        //this.aes = (executor instanceof AbstractExecutorService) ?
            //(AbstractExecutorService) executor : null;
        //this.completionQueue = new LinkedBlockingQueue<Future<V>>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.707 -0400", hash_original_method = "4003AFDAD418CC2ECC4A8EB9D6C4E6CA", hash_generated_method = "B60030EFDE2011BB4BDCD60B3920C488")
    public  ExecutorCompletionService(Executor executor,
                                     BlockingQueue<Future<V>> completionQueue) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.executor = executor;
        this.aes = (executor instanceof AbstractExecutorService) ?
            (AbstractExecutorService) executor : null;
        this.completionQueue = completionQueue;
        // ---------- Original Method ----------
        //if (executor == null || completionQueue == null)
            //throw new NullPointerException();
        //this.executor = executor;
        //this.aes = (executor instanceof AbstractExecutorService) ?
            //(AbstractExecutorService) executor : null;
        //this.completionQueue = completionQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.707 -0400", hash_original_method = "C02DA5DA60AA95D77CB448ECF2F70F43", hash_generated_method = "5A5C493D14C860878CA5D221BEB5F881")
    private RunnableFuture<V> newTaskFor(Callable<V> task) {
        RunnableFuture<V> varB4EAC82CA7396A68D541C85D26508E83_1436949504 = null; //Variable for return #1
        RunnableFuture<V> varB4EAC82CA7396A68D541C85D26508E83_1469531425 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1436949504 = new FutureTask<V>(task);
        varB4EAC82CA7396A68D541C85D26508E83_1469531425 = aes.newTaskFor(task);
        addTaint(task.getTaint());
        RunnableFuture<V> varA7E53CE21691AB073D9660D615818899_913764698; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_913764698 = varB4EAC82CA7396A68D541C85D26508E83_1436949504;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_913764698 = varB4EAC82CA7396A68D541C85D26508E83_1469531425;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_913764698.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_913764698;
        // ---------- Original Method ----------
        //if (aes == null)
            //return new FutureTask<V>(task);
        //else
            //return aes.newTaskFor(task);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.708 -0400", hash_original_method = "BBB6A806AE85DE3A7C516C9FC9F3C042", hash_generated_method = "02AF1F50BFEDAD12204DC0D983F34BB2")
    private RunnableFuture<V> newTaskFor(Runnable task, V result) {
        RunnableFuture<V> varB4EAC82CA7396A68D541C85D26508E83_1468252260 = null; //Variable for return #1
        RunnableFuture<V> varB4EAC82CA7396A68D541C85D26508E83_1952640927 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1468252260 = new FutureTask<V>(task, result);
        varB4EAC82CA7396A68D541C85D26508E83_1952640927 = aes.newTaskFor(task, result);
        addTaint(task.getTaint());
        addTaint(result.getTaint());
        RunnableFuture<V> varA7E53CE21691AB073D9660D615818899_1675383421; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1675383421 = varB4EAC82CA7396A68D541C85D26508E83_1468252260;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1675383421 = varB4EAC82CA7396A68D541C85D26508E83_1952640927;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1675383421.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1675383421;
        // ---------- Original Method ----------
        //if (aes == null)
            //return new FutureTask<V>(task, result);
        //else
            //return aes.newTaskFor(task, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.708 -0400", hash_original_method = "1066CE8ABD0AE96E9CBF3A082EB30584", hash_generated_method = "313A655268E308893766CF947DBD716C")
    public Future<V> submit(Callable<V> task) {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_1749938184 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<V> f;
        f = newTaskFor(task);
        executor.execute(new QueueingFuture(f));
        varB4EAC82CA7396A68D541C85D26508E83_1749938184 = f;
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1749938184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1749938184;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<V> f = newTaskFor(task);
        //executor.execute(new QueueingFuture(f));
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.711 -0400", hash_original_method = "90F0DB50BDB2C4419B39525C086024BB", hash_generated_method = "04F50347EF434336D486E0D92C2FA2B9")
    public Future<V> submit(Runnable task, V result) {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_1927590831 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<V> f;
        f = newTaskFor(task, result);
        executor.execute(new QueueingFuture(f));
        varB4EAC82CA7396A68D541C85D26508E83_1927590831 = f;
        addTaint(task.getTaint());
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1927590831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1927590831;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<V> f = newTaskFor(task, result);
        //executor.execute(new QueueingFuture(f));
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.726 -0400", hash_original_method = "B111DAF975BA373371F56AC1A498CB62", hash_generated_method = "5EBADBC81A58B5A8BFBA07E44CC92E44")
    public Future<V> take() throws InterruptedException {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_1766877182 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1766877182 = completionQueue.take();
        varB4EAC82CA7396A68D541C85D26508E83_1766877182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1766877182;
        // ---------- Original Method ----------
        //return completionQueue.take();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.727 -0400", hash_original_method = "AB80AB0A080F8B419B7B16E63DEC8AE2", hash_generated_method = "1191D1AEA2C691758BB4CDC225A25E03")
    public Future<V> poll() {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_941327977 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_941327977 = completionQueue.poll();
        varB4EAC82CA7396A68D541C85D26508E83_941327977.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_941327977;
        // ---------- Original Method ----------
        //return completionQueue.poll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.727 -0400", hash_original_method = "68AEBC19C67278ADE553BA09F2BB4BEF", hash_generated_method = "DE151D9E5B44852F5909B93A103359AE")
    public Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_1761635406 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1761635406 = completionQueue.poll(timeout, unit);
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1761635406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1761635406;
        // ---------- Original Method ----------
        //return completionQueue.poll(timeout, unit);
    }

    
    private class QueueingFuture extends FutureTask<Void> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.728 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "6A81C34C1728BCFC9614DD81361345B5")

        private Future<V> task;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.728 -0400", hash_original_method = "A487293341B42B74719D90AA9DC9C87B", hash_generated_method = "2CFA1E9A5CC48B1C904906338C0A2DE7")
          QueueingFuture(RunnableFuture<V> task) {
            super(task, null);
            this.task = task;
            // ---------- Original Method ----------
            //this.task = task;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.728 -0400", hash_original_method = "A6F9634D935F51A2E62823D21027F809", hash_generated_method = "4F7C67B055D3EAF2C5931F9AE96CF3D2")
        protected void done() {
            completionQueue.add(task);
            // ---------- Original Method ----------
            //completionQueue.add(task);
        }

        
    }


    
}

