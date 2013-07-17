package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ExecutorCompletionService<V> implements CompletionService<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.977 -0400", hash_original_field = "B1925939F66C2E4625AADB18CABF1CEA", hash_generated_field = "C344975DD4C90ADC5A05E9EE82CE3C44")

    private Executor executor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.977 -0400", hash_original_field = "6D3C5993CA017D0FF169B425D3193F02", hash_generated_field = "2BE08B300EAA426E148B747157CCD2EE")

    private AbstractExecutorService aes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.977 -0400", hash_original_field = "2EF30EEC1E91B410D78F022E61CAA304", hash_generated_field = "9ACC5A1B9A9F1BE7ABF80562A03906F3")

    private BlockingQueue<Future<V>> completionQueue;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.978 -0400", hash_original_method = "EDD261742BCF15D9FB8B326368F1ACDA", hash_generated_method = "590BEB3E1CB17782F5FCD08D2152C696")
    public  ExecutorCompletionService(Executor executor) {
        if(executor == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1227906600 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1227906600.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1227906600;
        }
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.979 -0400", hash_original_method = "4003AFDAD418CC2ECC4A8EB9D6C4E6CA", hash_generated_method = "513B91483CA0031B3A31CBAE015E84C3")
    public  ExecutorCompletionService(Executor executor,
                                     BlockingQueue<Future<V>> completionQueue) {
        if(executor == null || completionQueue == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_108176596 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_108176596.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_108176596;
        }
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.980 -0400", hash_original_method = "C02DA5DA60AA95D77CB448ECF2F70F43", hash_generated_method = "7E03F19965339F6CB0A952C818333249")
    private RunnableFuture<V> newTaskFor(Callable<V> task) {
        addTaint(task.getTaint());
        if(aes == null)        
        {
RunnableFuture<V> var25AA9B35FEDDCAB26431AAFD5DB71F0C_1657307862 =         new FutureTask<V>(task);
        var25AA9B35FEDDCAB26431AAFD5DB71F0C_1657307862.addTaint(taint);
        return var25AA9B35FEDDCAB26431AAFD5DB71F0C_1657307862;
        }
        else
        {
RunnableFuture<V> var43B3148BB5E6650D57F808400964E06A_1655015414 =         aes.newTaskFor(task);
        var43B3148BB5E6650D57F808400964E06A_1655015414.addTaint(taint);
        return var43B3148BB5E6650D57F808400964E06A_1655015414;
        }
        // ---------- Original Method ----------
        //if (aes == null)
            //return new FutureTask<V>(task);
        //else
            //return aes.newTaskFor(task);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.980 -0400", hash_original_method = "BBB6A806AE85DE3A7C516C9FC9F3C042", hash_generated_method = "6947E2724971FBBB526FD5587A387EC9")
    private RunnableFuture<V> newTaskFor(Runnable task, V result) {
        addTaint(result.getTaint());
        addTaint(task.getTaint());
        if(aes == null)        
        {
RunnableFuture<V> varFF5C87F6BF8CB3186A6A23459DD36BC7_725619609 =         new FutureTask<V>(task, result);
        varFF5C87F6BF8CB3186A6A23459DD36BC7_725619609.addTaint(taint);
        return varFF5C87F6BF8CB3186A6A23459DD36BC7_725619609;
        }
        else
        {
RunnableFuture<V> var9D13125A19E67035EAA1615C5C63FD97_1997487818 =         aes.newTaskFor(task, result);
        var9D13125A19E67035EAA1615C5C63FD97_1997487818.addTaint(taint);
        return var9D13125A19E67035EAA1615C5C63FD97_1997487818;
        }
        // ---------- Original Method ----------
        //if (aes == null)
            //return new FutureTask<V>(task, result);
        //else
            //return aes.newTaskFor(task, result);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.981 -0400", hash_original_method = "1066CE8ABD0AE96E9CBF3A082EB30584", hash_generated_method = "97953AB515C8EB439C1F6C353335CE41")
    public Future<V> submit(Callable<V> task) {
        addTaint(task.getTaint());
        if(task == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_175676872 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_175676872.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_175676872;
        }
        RunnableFuture<V> f = newTaskFor(task);
        executor.execute(new QueueingFuture(f));
Future<V> varABE3CFB53FE4A79F34CB25BC80BFD6E2_586764662 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_586764662.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_586764662;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<V> f = newTaskFor(task);
        //executor.execute(new QueueingFuture(f));
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.981 -0400", hash_original_method = "90F0DB50BDB2C4419B39525C086024BB", hash_generated_method = "C0FF29DBA042E28808BC81A2539C15D4")
    public Future<V> submit(Runnable task, V result) {
        addTaint(result.getTaint());
        addTaint(task.getTaint());
        if(task == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_659978860 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_659978860.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_659978860;
        }
        RunnableFuture<V> f = newTaskFor(task, result);
        executor.execute(new QueueingFuture(f));
Future<V> varABE3CFB53FE4A79F34CB25BC80BFD6E2_184935715 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_184935715.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_184935715;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<V> f = newTaskFor(task, result);
        //executor.execute(new QueueingFuture(f));
        //return f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.981 -0400", hash_original_method = "B111DAF975BA373371F56AC1A498CB62", hash_generated_method = "C637F34C33B419DC1947F5964A65008B")
    public Future<V> take() throws InterruptedException {
Future<V> varDDA8A4DDC380A4CADE2CFC8A8159504F_46986387 =         completionQueue.take();
        varDDA8A4DDC380A4CADE2CFC8A8159504F_46986387.addTaint(taint);
        return varDDA8A4DDC380A4CADE2CFC8A8159504F_46986387;
        // ---------- Original Method ----------
        //return completionQueue.take();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.982 -0400", hash_original_method = "AB80AB0A080F8B419B7B16E63DEC8AE2", hash_generated_method = "9A6859ABC245063D32742AAE30A59DC7")
    public Future<V> poll() {
Future<V> varB1E3F920A6FDBCB7B47C9C9E8C6506B8_1375089685 =         completionQueue.poll();
        varB1E3F920A6FDBCB7B47C9C9E8C6506B8_1375089685.addTaint(taint);
        return varB1E3F920A6FDBCB7B47C9C9E8C6506B8_1375089685;
        // ---------- Original Method ----------
        //return completionQueue.poll();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.982 -0400", hash_original_method = "68AEBC19C67278ADE553BA09F2BB4BEF", hash_generated_method = "FDD4C9CC9F30F212CE59D54DBE9FF70D")
    public Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
Future<V> var6499A2FAA4A72B0B362D284410DD9B81_1695179142 =         completionQueue.poll(timeout, unit);
        var6499A2FAA4A72B0B362D284410DD9B81_1695179142.addTaint(taint);
        return var6499A2FAA4A72B0B362D284410DD9B81_1695179142;
        // ---------- Original Method ----------
        //return completionQueue.poll(timeout, unit);
    }

    
    private class QueueingFuture extends FutureTask<Void> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.982 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "6A81C34C1728BCFC9614DD81361345B5")

        private Future<V> task;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.983 -0400", hash_original_method = "A487293341B42B74719D90AA9DC9C87B", hash_generated_method = "2CFA1E9A5CC48B1C904906338C0A2DE7")
          QueueingFuture(RunnableFuture<V> task) {
            super(task, null);
            this.task = task;
            // ---------- Original Method ----------
            //this.task = task;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.983 -0400", hash_original_method = "A6F9634D935F51A2E62823D21027F809", hash_generated_method = "4F7C67B055D3EAF2C5931F9AE96CF3D2")
        protected void done() {
            completionQueue.add(task);
            // ---------- Original Method ----------
            //completionQueue.add(task);
        }

        
    }


    
}

