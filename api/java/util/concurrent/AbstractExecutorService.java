package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;

public abstract class AbstractExecutorService implements ExecutorService {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.358 -0400", hash_original_method = "3052CE934B3A3FC619D77CE90023EF56", hash_generated_method = "3052CE934B3A3FC619D77CE90023EF56")
    public AbstractExecutorService ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.359 -0400", hash_original_method = "68FC815A084AC2ED05B7AEC372706304", hash_generated_method = "1B68176FD3C70FA210B0949BFDB3FE41")
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        addTaint(value.getTaint());
        addTaint(runnable.getTaint());
RunnableFuture<T> var8D1A6CD94DD5BAFD6D53EB96DC760D01_561779218 =         new FutureTask<T>(runnable, value);
        var8D1A6CD94DD5BAFD6D53EB96DC760D01_561779218.addTaint(taint);
        return var8D1A6CD94DD5BAFD6D53EB96DC760D01_561779218;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.359 -0400", hash_original_method = "5FB2799215A846560527597078EAB474", hash_generated_method = "2000A8D46FBDE61984E5B6D8A2449F66")
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        addTaint(callable.getTaint());
RunnableFuture<T> varBEF434F9B24D8E8523500F630F54EF1C_1286377909 =         new FutureTask<T>(callable);
        varBEF434F9B24D8E8523500F630F54EF1C_1286377909.addTaint(taint);
        return varBEF434F9B24D8E8523500F630F54EF1C_1286377909;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.359 -0400", hash_original_method = "049AFBF6C6F134F34D289DFB97D38727", hash_generated_method = "3AD7098B5C8A7A1F8A46EC1B08B3CA1A")
    public Future<?> submit(Runnable task) {
        addTaint(task.getTaint());
    if(task == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_124045927 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_124045927.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_124045927;
        }
        RunnableFuture<Void> ftask = newTaskFor(task, null);
        execute(ftask);
Future<?> var1A47BEF10A35E08D71A10703CE70AAF7_1948198647 =         ftask;
        var1A47BEF10A35E08D71A10703CE70AAF7_1948198647.addTaint(taint);
        return var1A47BEF10A35E08D71A10703CE70AAF7_1948198647;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.360 -0400", hash_original_method = "30E9EFFFABD0E5EC417E237355DE18FD", hash_generated_method = "F6759B495A8DB20C27AC7654863CE5DB")
    public <T> Future<T> submit(Runnable task, T result) {
        addTaint(result.getTaint());
        addTaint(task.getTaint());
    if(task == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_614890176 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_614890176.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_614890176;
        }
        RunnableFuture<T> ftask = newTaskFor(task, result);
        execute(ftask);
Future<T> var1A47BEF10A35E08D71A10703CE70AAF7_173272081 =         ftask;
        var1A47BEF10A35E08D71A10703CE70AAF7_173272081.addTaint(taint);
        return var1A47BEF10A35E08D71A10703CE70AAF7_173272081;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.360 -0400", hash_original_method = "F1883381F3EE85BA65E359E467E69859", hash_generated_method = "92037FE66062593D393B5F64ED9DD5CF")
    public <T> Future<T> submit(Callable<T> task) {
        addTaint(task.getTaint());
    if(task == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_497336349 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_497336349.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_497336349;
        }
        RunnableFuture<T> ftask = newTaskFor(task);
        execute(ftask);
Future<T> var1A47BEF10A35E08D71A10703CE70AAF7_490269529 =         ftask;
        var1A47BEF10A35E08D71A10703CE70AAF7_490269529.addTaint(taint);
        return var1A47BEF10A35E08D71A10703CE70AAF7_490269529;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.368 -0400", hash_original_method = "7ADE924855E97F021AF211771D5543D6", hash_generated_method = "F1BBDC991D02B8427FFE1AF6C5CC212A")
    private <T> T doInvokeAny(Collection<? extends Callable<T>> tasks,
                            boolean timed, long nanos) throws InterruptedException, ExecutionException, TimeoutException {
        addTaint(nanos);
        addTaint(timed);
        addTaint(tasks.getTaint());
    if(tasks == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_259422762 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_259422762.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_259422762;
        }
        int ntasks = tasks.size();
    if(ntasks == 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1668075670 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1668075670.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1668075670;
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
                    } 
                    else
    if(active == 0)                    
                    break;
                    else
    if(timed)                    
                    {
                        f = ecs.poll(nanos, TimeUnit.NANOSECONDS);
    if(f == null)                        
                        {
                        TimeoutException var3B6A086CA796B867C2DC52AFEEF9D0CF_1623978103 = new TimeoutException();
                        var3B6A086CA796B867C2DC52AFEEF9D0CF_1623978103.addTaint(taint);
                        throw var3B6A086CA796B867C2DC52AFEEF9D0CF_1623978103;
                        }
                        long now = System.nanoTime();
                        nanos -= now - lastTime;
                        lastTime = now;
                    } 
                    else
                    f = ecs.take();
                } 
    if(f != null)                
                {
                    --active;
                    try 
                    {
T var62EE18F85D765480227B4F97C873CDE0_1904041555 =                         f.get();
                        var62EE18F85D765480227B4F97C873CDE0_1904041555.addTaint(taint);
                        return var62EE18F85D765480227B4F97C873CDE0_1904041555;
                    } 
                    catch (ExecutionException eex)
                    {
                        ee = eex;
                    } 
                    catch (RuntimeException rex)
                    {
                        ee = new ExecutionException(rex);
                    } 
                } 
            } 
    if(ee == null)            
            ee = new ExecutionException();
            ee.addTaint(taint);
            throw ee;
        } 
        finally 
        {
for(Future<T> f : futures)
            f.cancel(true);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.372 -0400", hash_original_method = "97F8F3146846E948F707846D19B902DB", hash_generated_method = "8C43617ECC89CC59B6BF18831584486F")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        addTaint(tasks.getTaint());
        try 
        {
T var0D831F06EB35AD75173571A2A7D5F832_1124143597 =             doInvokeAny(tasks, false, 0);
            var0D831F06EB35AD75173571A2A7D5F832_1124143597.addTaint(taint);
            return var0D831F06EB35AD75173571A2A7D5F832_1124143597;
        } 
        catch (TimeoutException cannotHappen)
        {
T var540C13E9E156B687226421B24F2DF178_1052539697 =             null;
            var540C13E9E156B687226421B24F2DF178_1052539697.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1052539697;
        } 
        
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.374 -0400", hash_original_method = "A9D2441D5895F636CD5D7E2B2C0159D4", hash_generated_method = "9A3099A35939CC7C89251533CC91FB8A")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                           long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(tasks.getTaint());
T varDB8B1C04F589A22E27B8623D8C9F7420_994719580 =         doInvokeAny(tasks, true, unit.toNanos(timeout));
        varDB8B1C04F589A22E27B8623D8C9F7420_994719580.addTaint(taint);
        return varDB8B1C04F589A22E27B8623D8C9F7420_994719580;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.377 -0400", hash_original_method = "B24747B6507D912BAB1561A4B1530E75", hash_generated_method = "94254710DF15678B9AAAFC5F3D062F5A")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        addTaint(tasks.getTaint());
    if(tasks == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_637842535 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_637842535.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_637842535;
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
            } 
for(Future<T> f : futures)
            {
    if(!f.isDone())                
                {
                    try 
                    {
                        f.get();
                    } 
                    catch (CancellationException ignore)
                    {
                    } 
                    catch (ExecutionException ignore)
                    {
                    } 
                } 
            } 
            done = true;
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_1025703883 =             futures;
            var7DD305F66D87C2DBA38D1F4FEAB104D5_1025703883.addTaint(taint);
            return var7DD305F66D87C2DBA38D1F4FEAB104D5_1025703883;
        } 
        finally 
        {
    if(!done)            
for(Future<T> f : futures)
            f.cancel(true);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.385 -0400", hash_original_method = "14FC4B905592A585E278FFB06E2B3922", hash_generated_method = "6EB8715C19308BE6634683E32FA23BC1")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                         long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(tasks.getTaint());
    if(tasks == null || unit == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1422483612 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1422483612.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1422483612;
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
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_1401820161 =                 futures;
                var7DD305F66D87C2DBA38D1F4FEAB104D5_1401820161.addTaint(taint);
                return var7DD305F66D87C2DBA38D1F4FEAB104D5_1401820161;
                }
            } 
for(Future<T> f : futures)
            {
    if(!f.isDone())                
                {
    if(nanos <= 0)                    
                    {
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_420276100 =                     futures;
                    var7DD305F66D87C2DBA38D1F4FEAB104D5_420276100.addTaint(taint);
                    return var7DD305F66D87C2DBA38D1F4FEAB104D5_420276100;
                    }
                    try 
                    {
                        f.get(nanos, TimeUnit.NANOSECONDS);
                    } 
                    catch (CancellationException ignore)
                    {
                    } 
                    catch (ExecutionException ignore)
                    {
                    } 
                    catch (TimeoutException toe)
                    {
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_1641515248 =                         futures;
                        var7DD305F66D87C2DBA38D1F4FEAB104D5_1641515248.addTaint(taint);
                        return var7DD305F66D87C2DBA38D1F4FEAB104D5_1641515248;
                    } 
                    long now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                } 
            } 
            done = true;
List<Future<T>> var7DD305F66D87C2DBA38D1F4FEAB104D5_406988959 =             futures;
            var7DD305F66D87C2DBA38D1F4FEAB104D5_406988959.addTaint(taint);
            return var7DD305F66D87C2DBA38D1F4FEAB104D5_406988959;
        } 
        finally 
        {
    if(!done)            
for(Future<T> f : futures)
            f.cancel(true);
        } 
        
        
    }

    
}

