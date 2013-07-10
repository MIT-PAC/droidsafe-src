package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ExecutorCompletionService<V> implements CompletionService<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.854 -0400", hash_original_field = "B1925939F66C2E4625AADB18CABF1CEA", hash_generated_field = "C344975DD4C90ADC5A05E9EE82CE3C44")

    private Executor executor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.854 -0400", hash_original_field = "6D3C5993CA017D0FF169B425D3193F02", hash_generated_field = "2BE08B300EAA426E148B747157CCD2EE")

    private AbstractExecutorService aes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.854 -0400", hash_original_field = "2EF30EEC1E91B410D78F022E61CAA304", hash_generated_field = "9ACC5A1B9A9F1BE7ABF80562A03906F3")

    private BlockingQueue<Future<V>> completionQueue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.854 -0400", hash_original_method = "EDD261742BCF15D9FB8B326368F1ACDA", hash_generated_method = "93BC376C9B6784A7F85FC931D960C4F1")
    public  ExecutorCompletionService(Executor executor) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.executor = executor;
        this.aes = (executor instanceof AbstractExecutorService) ?
            (AbstractExecutorService) executor : null;
        this.completionQueue = new LinkedBlockingQueue<Future<V>>();
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.854 -0400", hash_original_method = "4003AFDAD418CC2ECC4A8EB9D6C4E6CA", hash_generated_method = "B60030EFDE2011BB4BDCD60B3920C488")
    public  ExecutorCompletionService(Executor executor,
                                     BlockingQueue<Future<V>> completionQueue) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.executor = executor;
        this.aes = (executor instanceof AbstractExecutorService) ?
            (AbstractExecutorService) executor : null;
        this.completionQueue = completionQueue;
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.855 -0400", hash_original_method = "C02DA5DA60AA95D77CB448ECF2F70F43", hash_generated_method = "D4D6E28CF92BB84B70F048EAFB64C835")
    private RunnableFuture<V> newTaskFor(Callable<V> task) {
        RunnableFuture<V> varB4EAC82CA7396A68D541C85D26508E83_2118074514 = null; 
        RunnableFuture<V> varB4EAC82CA7396A68D541C85D26508E83_1345204554 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2118074514 = new FutureTask<V>(task);
        varB4EAC82CA7396A68D541C85D26508E83_1345204554 = aes.newTaskFor(task);
        addTaint(task.getTaint());
        RunnableFuture<V> varA7E53CE21691AB073D9660D615818899_619336457; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_619336457 = varB4EAC82CA7396A68D541C85D26508E83_2118074514;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_619336457 = varB4EAC82CA7396A68D541C85D26508E83_1345204554;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_619336457.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_619336457;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.855 -0400", hash_original_method = "BBB6A806AE85DE3A7C516C9FC9F3C042", hash_generated_method = "1C679030F7E8F2AEE46AD2B891976363")
    private RunnableFuture<V> newTaskFor(Runnable task, V result) {
        RunnableFuture<V> varB4EAC82CA7396A68D541C85D26508E83_1208964664 = null; 
        RunnableFuture<V> varB4EAC82CA7396A68D541C85D26508E83_872919573 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1208964664 = new FutureTask<V>(task, result);
        varB4EAC82CA7396A68D541C85D26508E83_872919573 = aes.newTaskFor(task, result);
        addTaint(task.getTaint());
        addTaint(result.getTaint());
        RunnableFuture<V> varA7E53CE21691AB073D9660D615818899_1034842273; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1034842273 = varB4EAC82CA7396A68D541C85D26508E83_1208964664;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1034842273 = varB4EAC82CA7396A68D541C85D26508E83_872919573;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1034842273.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1034842273;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.856 -0400", hash_original_method = "1066CE8ABD0AE96E9CBF3A082EB30584", hash_generated_method = "937406318ADDC3696C04A3B12358D6D3")
    public Future<V> submit(Callable<V> task) {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_1152162805 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<V> f = newTaskFor(task);
        executor.execute(new QueueingFuture(f));
        varB4EAC82CA7396A68D541C85D26508E83_1152162805 = f;
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1152162805.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1152162805;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.857 -0400", hash_original_method = "90F0DB50BDB2C4419B39525C086024BB", hash_generated_method = "5C4324A421BD47563C160E4A6055EB9B")
    public Future<V> submit(Runnable task, V result) {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_457588447 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<V> f = newTaskFor(task, result);
        executor.execute(new QueueingFuture(f));
        varB4EAC82CA7396A68D541C85D26508E83_457588447 = f;
        addTaint(task.getTaint());
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_457588447.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_457588447;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.858 -0400", hash_original_method = "B111DAF975BA373371F56AC1A498CB62", hash_generated_method = "3D82DDDB2C2D7E364599DB0725F0591B")
    public Future<V> take() throws InterruptedException {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_174338909 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_174338909 = completionQueue.take();
        varB4EAC82CA7396A68D541C85D26508E83_174338909.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_174338909;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.858 -0400", hash_original_method = "AB80AB0A080F8B419B7B16E63DEC8AE2", hash_generated_method = "A2DE313EFF063A06BD2DE75FF091DA25")
    public Future<V> poll() {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_2080787554 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2080787554 = completionQueue.poll();
        varB4EAC82CA7396A68D541C85D26508E83_2080787554.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2080787554;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.859 -0400", hash_original_method = "68AEBC19C67278ADE553BA09F2BB4BEF", hash_generated_method = "A1789403125B57285AD470879713EBB5")
    public Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException {
        Future<V> varB4EAC82CA7396A68D541C85D26508E83_962663349 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_962663349 = completionQueue.poll(timeout, unit);
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_962663349.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_962663349;
        
        
    }

    
    private class QueueingFuture extends FutureTask<Void> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.859 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "6A81C34C1728BCFC9614DD81361345B5")

        private Future<V> task;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.859 -0400", hash_original_method = "A487293341B42B74719D90AA9DC9C87B", hash_generated_method = "2CFA1E9A5CC48B1C904906338C0A2DE7")
          QueueingFuture(RunnableFuture<V> task) {
            super(task, null);
            this.task = task;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.860 -0400", hash_original_method = "A6F9634D935F51A2E62823D21027F809", hash_generated_method = "4F7C67B055D3EAF2C5931F9AE96CF3D2")
        protected void done() {
            completionQueue.add(task);
            
            
        }

        
    }


    
}

