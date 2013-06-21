package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExecutorCompletionService<V> implements CompletionService<V> {
    private Executor executor;
    private AbstractExecutorService aes;
    private BlockingQueue<Future<V>> completionQueue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.544 -0400", hash_original_method = "EDD261742BCF15D9FB8B326368F1ACDA", hash_generated_method = "13D9CBD921D93E96F47CE986A9035778")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExecutorCompletionService(Executor executor) {
        dsTaint.addTaint(executor.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.544 -0400", hash_original_method = "4003AFDAD418CC2ECC4A8EB9D6C4E6CA", hash_generated_method = "2EB3FCCBDDDE02506A5800F7FC53A6FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExecutorCompletionService(Executor executor,
                                     BlockingQueue<Future<V>> completionQueue) {
        dsTaint.addTaint(executor.dsTaint);
        dsTaint.addTaint(completionQueue.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.aes = (executor instanceof AbstractExecutorService) ?
            (AbstractExecutorService) executor : null;
        // ---------- Original Method ----------
        //if (executor == null || completionQueue == null)
            //throw new NullPointerException();
        //this.executor = executor;
        //this.aes = (executor instanceof AbstractExecutorService) ?
            //(AbstractExecutorService) executor : null;
        //this.completionQueue = completionQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.545 -0400", hash_original_method = "C02DA5DA60AA95D77CB448ECF2F70F43", hash_generated_method = "A9B4566371167BFC29EAFF6D70612C8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private RunnableFuture<V> newTaskFor(Callable<V> task) {
        dsTaint.addTaint(task.dsTaint);
        RunnableFuture<V> var4D0CA931890A9D63BC736AE85AF5D1B3_2081171094 = (new FutureTask<V>(task));
        RunnableFuture<V> var4027A86320AF3432166D25E6EE697275_559341880 = (aes.newTaskFor(task));
        return (RunnableFuture<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (aes == null)
            //return new FutureTask<V>(task);
        //else
            //return aes.newTaskFor(task);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.545 -0400", hash_original_method = "BBB6A806AE85DE3A7C516C9FC9F3C042", hash_generated_method = "D7949DC274C85E751F110EF95A322E11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private RunnableFuture<V> newTaskFor(Runnable task, V result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(task.dsTaint);
        RunnableFuture<V> var75C5DF9E8649AB672C40F239476B6826_313877548 = (new FutureTask<V>(task, result));
        RunnableFuture<V> var33F96556D7F6272508C4C21489DBE43F_220586557 = (aes.newTaskFor(task, result));
        return (RunnableFuture<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (aes == null)
            //return new FutureTask<V>(task, result);
        //else
            //return aes.newTaskFor(task, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.545 -0400", hash_original_method = "1066CE8ABD0AE96E9CBF3A082EB30584", hash_generated_method = "176F434558CABA30CE7019DEC64BFD48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Future<V> submit(Callable<V> task) {
        dsTaint.addTaint(task.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<V> f;
        f = newTaskFor(task);
        executor.execute(new QueueingFuture(f));
        return (Future<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<V> f = newTaskFor(task);
        //executor.execute(new QueueingFuture(f));
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.545 -0400", hash_original_method = "90F0DB50BDB2C4419B39525C086024BB", hash_generated_method = "EF4EBB561A1F78E5EDAC515567F0BB8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Future<V> submit(Runnable task, V result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(task.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<V> f;
        f = newTaskFor(task, result);
        executor.execute(new QueueingFuture(f));
        return (Future<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<V> f = newTaskFor(task, result);
        //executor.execute(new QueueingFuture(f));
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.545 -0400", hash_original_method = "B111DAF975BA373371F56AC1A498CB62", hash_generated_method = "DB12460B7EEB9935552B52E9FF970B6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Future<V> take() throws InterruptedException {
        Future<V> var147AE298C9A92B09F09CD739B9965727_527902196 = (completionQueue.take());
        return (Future<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return completionQueue.take();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.546 -0400", hash_original_method = "AB80AB0A080F8B419B7B16E63DEC8AE2", hash_generated_method = "AF994B85B118F76CB39392F3A7F4EF5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Future<V> poll() {
        Future<V> varCDC5DCE13FDC594D95A1FC08C0DA0822_1178084226 = (completionQueue.poll());
        return (Future<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return completionQueue.poll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.546 -0400", hash_original_method = "68AEBC19C67278ADE553BA09F2BB4BEF", hash_generated_method = "A6EE6D2C456C64A68440854F9899462C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        Future<V> var0ADF117AC4A430FA6DFF10C9C443E8A8_1247196607 = (completionQueue.poll(timeout, unit));
        return (Future<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return completionQueue.poll(timeout, unit);
    }

    
    private class QueueingFuture extends FutureTask<Void> {
        private Future<V> task;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.546 -0400", hash_original_method = "A487293341B42B74719D90AA9DC9C87B", hash_generated_method = "FA0180953FBCFB9ADB4E5002CE2B7351")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         QueueingFuture(RunnableFuture<V> task) {
            super(task, null);
            dsTaint.addTaint(task.dsTaint);
            // ---------- Original Method ----------
            //this.task = task;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.546 -0400", hash_original_method = "A6F9634D935F51A2E62823D21027F809", hash_generated_method = "4F7C67B055D3EAF2C5931F9AE96CF3D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void done() {
            completionQueue.add(task);
            // ---------- Original Method ----------
            //completionQueue.add(task);
        }

        
    }


    
}

