package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;



public abstract class AbstractExecutorService implements ExecutorService {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.222 -0400", hash_original_method = "3052CE934B3A3FC619D77CE90023EF56", hash_generated_method = "3052CE934B3A3FC619D77CE90023EF56")
    public AbstractExecutorService ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.222 -0400", hash_original_method = "68FC815A084AC2ED05B7AEC372706304", hash_generated_method = "829AC854D74225026CA79008A967D805")
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        addTaint(value.getTaint());
        addTaint(runnable.getTaint());
RunnableFuture<T> var8D1A6CD94DD5BAFD6D53EB96DC760D01_1846031723 =         new FutureTask<T>(runnable, value);
        var8D1A6CD94DD5BAFD6D53EB96DC760D01_1846031723.addTaint(taint);
        return var8D1A6CD94DD5BAFD6D53EB96DC760D01_1846031723;
        // ---------- Original Method ----------
        //return new FutureTask<T>(runnable, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.222 -0400", hash_original_method = "5FB2799215A846560527597078EAB474", hash_generated_method = "B0C75F0DA6EC83E584762C6701FDEEEB")
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        addTaint(callable.getTaint());
RunnableFuture<T> varBEF434F9B24D8E8523500F630F54EF1C_34807659 =         new FutureTask<T>(callable);
        varBEF434F9B24D8E8523500F630F54EF1C_34807659.addTaint(taint);
        return varBEF434F9B24D8E8523500F630F54EF1C_34807659;
        // ---------- Original Method ----------
        //return new FutureTask<T>(callable);
    }

    /**
     * @throws RejectedExecutionException {@inheritDoc}
     * @throws NullPointerException       {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:45.479 -0500", hash_original_method = "049AFBF6C6F134F34D289DFB97D38727", hash_generated_method = "D79DC49478D56E7E26C565781312A0F8")
    public Future<?> submit(Runnable task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<Void> ftask = newTaskFor(task, null);
        execute(ftask);
        return ftask;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.223 -0400", hash_original_method = "30E9EFFFABD0E5EC417E237355DE18FD", hash_generated_method = "DD6D1EA6860F6B27E5D7F68DCF37D2D8")
    public <T> Future<T> submit(Runnable task, T result) {
        addTaint(result.getTaint());
        addTaint(task.getTaint());
        if(task == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1226693436 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1226693436.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1226693436;
        }
        RunnableFuture<T> ftask = newTaskFor(task, result);
        execute(ftask);
Future<T> var1A47BEF10A35E08D71A10703CE70AAF7_603271610 =         ftask;
        var1A47BEF10A35E08D71A10703CE70AAF7_603271610.addTaint(taint);
        return var1A47BEF10A35E08D71A10703CE70AAF7_603271610;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task, result);
        //execute(ftask);
        //return ftask;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.223 -0400", hash_original_method = "F1883381F3EE85BA65E359E467E69859", hash_generated_method = "0A3A2888CF8F0BF76D5EA93D0E113021")
    public <T> Future<T> submit(Callable<T> task) {
        addTaint(task.getTaint());
        if(task == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_971193699 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_971193699.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_971193699;
        }
        RunnableFuture<T> ftask = newTaskFor(task);
        execute(ftask);
Future<T> var1A47BEF10A35E08D71A10703CE70AAF7_2038148973 =         ftask;
        var1A47BEF10A35E08D71A10703CE70AAF7_2038148973.addTaint(taint);
        return var1A47BEF10A35E08D71A10703CE70AAF7_2038148973;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task);
        //execute(ftask);
        //return ftask;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.225 -0400", hash_original_method = "7ADE924855E97F021AF211771D5543D6", hash_generated_method = "44D4AE2F73DA112D29569CF14CE5E9D4")
    private <T> T doInvokeAny(Collection<? extends Callable<T>> tasks,
                            boolean timed, long nanos) throws InterruptedException, ExecutionException, TimeoutException {
        addTaint(nanos);
        addTaint(timed);
        addTaint(tasks.getTaint());
        if(tasks == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1502055719 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1502055719.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1502055719;
        }
        int ntasks = tasks.size();
        if(ntasks == 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_379144784 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_379144784.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_379144784;
        }
        List<Future<T>> futures = new ArrayList<Future<T>>(ntasks);
        ExecutorCompletionService<T> ecs = new ExecutorCompletionService<T>(this);
        try 
        {
            ExecutionException ee = null;
            long lastTime = timed ? System.nanoTime() : 0;
            Iterator<? extends Callable<T>> it = tasks.iterator();
            futures.add(ecs.submit(it.next()));
            --ntasks;
            int active = 1;
for(;;)
            {
                Future<T> f = ecs.poll();
                if(f == null)                
                {
                    if(ntasks > 0)                    
                    {
                        --ntasks;
                        futures.add(ecs.submit(it.next()));
                        ++active;
                    } //End block
                    else
                    if(active == 0)                    
                    break;
                    else
                    if(timed)                    
                    {
                        f = ecs.poll(nanos, TimeUnit.NANOSECONDS);
                        if(f == null)                        
                        {
                        TimeoutException var3B6A086CA796B867C2DC52AFEEF9D0CF_569672888 = new TimeoutException();
                        var3B6A086CA796B867C2DC52AFEEF9D0CF_569672888.addTaint(taint);
                        throw var3B6A086CA796B867C2DC52AFEEF9D0CF_569672888;
                        }
                        long now = System.nanoTime();
                        nanos -= now - lastTime;
                        lastTime = now;
                    } //End block
                    else
                    f = ecs.take();
                } //End block
                if(f != null)                
                {
                    --active;
                    try 
                    {
T var62EE18F85D765480227B4F97C873CDE0_1318816487 =                         f.get();
                        var62EE18F85D765480227B4F97C873CDE0_1318816487.addTaint(taint);
                        return var62EE18F85D765480227B4F97C873CDE0_1318816487;
                    } //End block
                    catch (ExecutionException eex)
                    {
                        ee = eex;
                    } //End block
                    catch (RuntimeException rex)
                    {
                        ee = new ExecutionException(rex);
                    } //End block
                } //End block
            } //End block
            if(ee == null)            
            ee = new ExecutionException();
            ee.addTaint(taint);
            throw ee;
        } //End block
        finally 
        {
for(Future<T> f : futures)
            f.cancel(true);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.226 -0400", hash_original_method = "97F8F3146846E948F707846D19B902DB", hash_generated_method = "335A6A65005D9084AED12D1BFD0AFA67")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        addTaint(tasks.getTaint());
        try 
        {
T var0D831F06EB35AD75173571A2A7D5F832_1034355156 =             doInvokeAny(tasks, false, 0);
            var0D831F06EB35AD75173571A2A7D5F832_1034355156.addTaint(taint);
            return var0D831F06EB35AD75173571A2A7D5F832_1034355156;
        } //End block
        catch (TimeoutException cannotHappen)
        {
T var540C13E9E156B687226421B24F2DF178_243117211 =             null;
            var540C13E9E156B687226421B24F2DF178_243117211.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_243117211;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return doInvokeAny(tasks, false, 0);
        //} catch (TimeoutException cannotHappen) {
            //assert false;
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.227 -0400", hash_original_method = "A9D2441D5895F636CD5D7E2B2C0159D4", hash_generated_method = "47BE9D7B20E7DE41613BFEC4C8821AB3")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                           long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(tasks.getTaint());
T varDB8B1C04F589A22E27B8623D8C9F7420_1843617302 =         doInvokeAny(tasks, true, unit.toNanos(timeout));
        varDB8B1C04F589A22E27B8623D8C9F7420_1843617302.addTaint(taint);
        return varDB8B1C04F589A22E27B8623D8C9F7420_1843617302;
        // ---------- Original Method ----------
        //return doInvokeAny(tasks, true, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.228 -0400", hash_original_method = "B24747B6507D912BAB1561A4B1530E75", hash_generated_method = "6B88AB56D4FD3FC6D38846EDFAB2944E")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        addTaint(tasks.getTaint());
        if(tasks == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1690769176 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1690769176.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1690769176;
        }
        List<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
        boolean done = false;
        try 
        {
for(Callable<T> t : tasks)
            {
                RunnableFuture<T> f = newTaskFor(t);
                futures.add(f);
                execute(f);
            } //End block
for(Future<T> f : futures)
            {
                if(!f.isDone())                
                {
                    try 
                    {
                        f.get();
                    } //End block
                    catch (CancellationException ignore)
                    {
                    } //End block
                    catch (ExecutionException ignore)
                    {
                    } //End block
                } //End block
            } //End block
            done = true;
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_1026182331 =             futures;
            var7DD305F66D87C2DBA38D1F4FEAB104D5_1026182331.addTaint(taint);
            return var7DD305F66D87C2DBA38D1F4FEAB104D5_1026182331;
        } //End block
        finally 
        {
            if(!done)            
for(Future<T> f : futures)
            f.cancel(true);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.229 -0400", hash_original_method = "14FC4B905592A585E278FFB06E2B3922", hash_generated_method = "04CB5139E2DA7EC87D98241F5D35EC88")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                         long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(tasks.getTaint());
        if(tasks == null || unit == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2032225772 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_2032225772.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_2032225772;
        }
        long nanos = unit.toNanos(timeout);
        List<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
        boolean done = false;
        try 
        {
for(Callable<T> t : tasks)
            futures.add(newTaskFor(t));
            long lastTime = System.nanoTime();
            Iterator<Future<T>> it = futures.iterator();
            while
(it.hasNext())            
            {
                execute((Runnable)(it.next()));
                long now = System.nanoTime();
                nanos -= now - lastTime;
                lastTime = now;
                if(nanos <= 0)                
                {
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_1907078213 =                 futures;
                var7DD305F66D87C2DBA38D1F4FEAB104D5_1907078213.addTaint(taint);
                return var7DD305F66D87C2DBA38D1F4FEAB104D5_1907078213;
                }
            } //End block
for(Future<T> f : futures)
            {
                if(!f.isDone())                
                {
                    if(nanos <= 0)                    
                    {
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_2016215237 =                     futures;
                    var7DD305F66D87C2DBA38D1F4FEAB104D5_2016215237.addTaint(taint);
                    return var7DD305F66D87C2DBA38D1F4FEAB104D5_2016215237;
                    }
                    try 
                    {
                        f.get(nanos, TimeUnit.NANOSECONDS);
                    } //End block
                    catch (CancellationException ignore)
                    {
                    } //End block
                    catch (ExecutionException ignore)
                    {
                    } //End block
                    catch (TimeoutException toe)
                    {
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_1141320188 =                         futures;
                        var7DD305F66D87C2DBA38D1F4FEAB104D5_1141320188.addTaint(taint);
                        return var7DD305F66D87C2DBA38D1F4FEAB104D5_1141320188;
                    } //End block
                    long now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                } //End block
            } //End block
            done = true;
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_1749954216 =             futures;
            var7DD305F66D87C2DBA38D1F4FEAB104D5_1749954216.addTaint(taint);
            return var7DD305F66D87C2DBA38D1F4FEAB104D5_1749954216;
        } //End block
        finally 
        {
            if(!done)            
for(Future<T> f : futures)
            f.cancel(true);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

