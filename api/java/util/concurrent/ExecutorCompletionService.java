package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ExecutorCompletionService<V> implements CompletionService<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.494 -0400", hash_original_field = "B1925939F66C2E4625AADB18CABF1CEA", hash_generated_field = "C344975DD4C90ADC5A05E9EE82CE3C44")

    private Executor executor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.494 -0400", hash_original_field = "6D3C5993CA017D0FF169B425D3193F02", hash_generated_field = "2BE08B300EAA426E148B747157CCD2EE")

    private AbstractExecutorService aes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.494 -0400", hash_original_field = "2EF30EEC1E91B410D78F022E61CAA304", hash_generated_field = "9ACC5A1B9A9F1BE7ABF80562A03906F3")

    private BlockingQueue<Future<V>> completionQueue;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.495 -0400", hash_original_method = "EDD261742BCF15D9FB8B326368F1ACDA", hash_generated_method = "44B1294BCA0C7A20310D9A9002E52E6F")
    public  ExecutorCompletionService(Executor executor) {
    if(executor == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_41335717 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_41335717.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_41335717;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.497 -0400", hash_original_method = "4003AFDAD418CC2ECC4A8EB9D6C4E6CA", hash_generated_method = "A56AB1F46ED3E31D6C64250C082F3645")
    public  ExecutorCompletionService(Executor executor,
                                     BlockingQueue<Future<V>> completionQueue) {
    if(executor == null || completionQueue == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1130417565 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1130417565.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1130417565;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.498 -0400", hash_original_method = "C02DA5DA60AA95D77CB448ECF2F70F43", hash_generated_method = "2FE24D323DABC09633BC7B186DEC07FE")
    private RunnableFuture<V> newTaskFor(Callable<V> task) {
        addTaint(task.getTaint());
    if(aes == null)        
        {
RunnableFuture<V> var25AA9B35FEDDCAB26431AAFD5DB71F0C_339307057 =         new FutureTask<V>(task);
        var25AA9B35FEDDCAB26431AAFD5DB71F0C_339307057.addTaint(taint);
        return var25AA9B35FEDDCAB26431AAFD5DB71F0C_339307057;
        }
        else
        {
RunnableFuture<V> var43B3148BB5E6650D57F808400964E06A_1815022163 =         aes.newTaskFor(task);
        var43B3148BB5E6650D57F808400964E06A_1815022163.addTaint(taint);
        return var43B3148BB5E6650D57F808400964E06A_1815022163;
        }
        // ---------- Original Method ----------
        //if (aes == null)
            //return new FutureTask<V>(task);
        //else
            //return aes.newTaskFor(task);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.499 -0400", hash_original_method = "BBB6A806AE85DE3A7C516C9FC9F3C042", hash_generated_method = "BD259731370B2629FBF79798CF6A76D8")
    private RunnableFuture<V> newTaskFor(Runnable task, V result) {
        addTaint(result.getTaint());
        addTaint(task.getTaint());
    if(aes == null)        
        {
RunnableFuture<V> varFF5C87F6BF8CB3186A6A23459DD36BC7_1812005871 =         new FutureTask<V>(task, result);
        varFF5C87F6BF8CB3186A6A23459DD36BC7_1812005871.addTaint(taint);
        return varFF5C87F6BF8CB3186A6A23459DD36BC7_1812005871;
        }
        else
        {
RunnableFuture<V> var9D13125A19E67035EAA1615C5C63FD97_1591364286 =         aes.newTaskFor(task, result);
        var9D13125A19E67035EAA1615C5C63FD97_1591364286.addTaint(taint);
        return var9D13125A19E67035EAA1615C5C63FD97_1591364286;
        }
        // ---------- Original Method ----------
        //if (aes == null)
            //return new FutureTask<V>(task, result);
        //else
            //return aes.newTaskFor(task, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.499 -0400", hash_original_method = "1066CE8ABD0AE96E9CBF3A082EB30584", hash_generated_method = "2A997E4F2024B6BA7A734083E77BE20B")
    public Future<V> submit(Callable<V> task) {
        addTaint(task.getTaint());
    if(task == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_461823307 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_461823307.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_461823307;
        }
        RunnableFuture<V> f = newTaskFor(task);
        executor.execute(new QueueingFuture(f));
Future<V> varABE3CFB53FE4A79F34CB25BC80BFD6E2_1837115893 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_1837115893.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1837115893;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<V> f = newTaskFor(task);
        //executor.execute(new QueueingFuture(f));
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.500 -0400", hash_original_method = "90F0DB50BDB2C4419B39525C086024BB", hash_generated_method = "9ECFD345A8C24F4D5183AB563A220032")
    public Future<V> submit(Runnable task, V result) {
        addTaint(result.getTaint());
        addTaint(task.getTaint());
    if(task == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1498767003 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1498767003.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1498767003;
        }
        RunnableFuture<V> f = newTaskFor(task, result);
        executor.execute(new QueueingFuture(f));
Future<V> varABE3CFB53FE4A79F34CB25BC80BFD6E2_947850188 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_947850188.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_947850188;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<V> f = newTaskFor(task, result);
        //executor.execute(new QueueingFuture(f));
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.500 -0400", hash_original_method = "B111DAF975BA373371F56AC1A498CB62", hash_generated_method = "1D92BA613648582F8F91F7D454AFBE91")
    public Future<V> take() throws InterruptedException {
Future<V> varDDA8A4DDC380A4CADE2CFC8A8159504F_60841611 =         completionQueue.take();
        varDDA8A4DDC380A4CADE2CFC8A8159504F_60841611.addTaint(taint);
        return varDDA8A4DDC380A4CADE2CFC8A8159504F_60841611;
        // ---------- Original Method ----------
        //return completionQueue.take();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.500 -0400", hash_original_method = "AB80AB0A080F8B419B7B16E63DEC8AE2", hash_generated_method = "AE877414246E4E980A2FB53147A03975")
    public Future<V> poll() {
Future<V> varB1E3F920A6FDBCB7B47C9C9E8C6506B8_237531041 =         completionQueue.poll();
        varB1E3F920A6FDBCB7B47C9C9E8C6506B8_237531041.addTaint(taint);
        return varB1E3F920A6FDBCB7B47C9C9E8C6506B8_237531041;
        // ---------- Original Method ----------
        //return completionQueue.poll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.501 -0400", hash_original_method = "68AEBC19C67278ADE553BA09F2BB4BEF", hash_generated_method = "371B2C7B29B68C8C5756BAAA729E9BBE")
    public Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
Future<V> var6499A2FAA4A72B0B362D284410DD9B81_927905039 =         completionQueue.poll(timeout, unit);
        var6499A2FAA4A72B0B362D284410DD9B81_927905039.addTaint(taint);
        return var6499A2FAA4A72B0B362D284410DD9B81_927905039;
        // ---------- Original Method ----------
        //return completionQueue.poll(timeout, unit);
    }

    
    private class QueueingFuture extends FutureTask<Void> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.501 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "6A81C34C1728BCFC9614DD81361345B5")

        private Future<V> task;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.501 -0400", hash_original_method = "A487293341B42B74719D90AA9DC9C87B", hash_generated_method = "2CFA1E9A5CC48B1C904906338C0A2DE7")
          QueueingFuture(RunnableFuture<V> task) {
            super(task, null);
            this.task = task;
            // ---------- Original Method ----------
            //this.task = task;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.502 -0400", hash_original_method = "A6F9634D935F51A2E62823D21027F809", hash_generated_method = "4F7C67B055D3EAF2C5931F9AE96CF3D2")
        protected void done() {
            completionQueue.add(task);
            // ---------- Original Method ----------
            //completionQueue.add(task);
        }

        
    }


    
}

