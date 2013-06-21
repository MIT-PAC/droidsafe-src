package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public abstract class AbstractExecutorService implements ExecutorService {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.295 -0400", hash_original_method = "31ECDC66F28FD0CFEE08F4ABD518FEDA", hash_generated_method = "31ECDC66F28FD0CFEE08F4ABD518FEDA")
        public AbstractExecutorService ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.295 -0400", hash_original_method = "68FC815A084AC2ED05B7AEC372706304", hash_generated_method = "843F84029734B7D920A5FEDA78454B7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        RunnableFuture<T> var4EDD2A855DAE9AE386B4FD7B5DABCF33_1736773207 = (new FutureTask<T>(runnable, value));
        return (RunnableFuture<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FutureTask<T>(runnable, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.295 -0400", hash_original_method = "5FB2799215A846560527597078EAB474", hash_generated_method = "9F41291A7F5DF824DB0E2ECED221CE35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        dsTaint.addTaint(callable.dsTaint);
        RunnableFuture<T> var285ED95BA3DA17FC11601A092D4365C0_1850966978 = (new FutureTask<T>(callable));
        return (RunnableFuture<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FutureTask<T>(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.296 -0400", hash_original_method = "049AFBF6C6F134F34D289DFB97D38727", hash_generated_method = "056AEFB42A7D9105BBA555900777000F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Future<?> submit(Runnable task) {
        dsTaint.addTaint(task.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<Void> ftask;
        ftask = newTaskFor(task, null);
        execute(ftask);
        return (Future<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<Void> ftask = newTaskFor(task, null);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.296 -0400", hash_original_method = "30E9EFFFABD0E5EC417E237355DE18FD", hash_generated_method = "C2BF40785FCE3AC0A1910F6CB0D734FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> Future<T> submit(Runnable task, T result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(task.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<T> ftask;
        ftask = newTaskFor(task, result);
        execute(ftask);
        return (Future<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task, result);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.296 -0400", hash_original_method = "F1883381F3EE85BA65E359E467E69859", hash_generated_method = "25E9277D03AC2AA553A57C20746DF55F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> Future<T> submit(Callable<T> task) {
        dsTaint.addTaint(task.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<T> ftask;
        ftask = newTaskFor(task);
        execute(ftask);
        return (Future<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.297 -0400", hash_original_method = "7ADE924855E97F021AF211771D5543D6", hash_generated_method = "083A23843751BD26B89A8783983D4BB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <T> T doInvokeAny(Collection<? extends Callable<T>> tasks,
                            boolean timed, long nanos) throws InterruptedException, ExecutionException, TimeoutException {
        dsTaint.addTaint(nanos);
        dsTaint.addTaint(timed);
        dsTaint.addTaint(tasks.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int ntasks;
        ntasks = tasks.size();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        List<Future<T>> futures;
        futures = new ArrayList<Future<T>>(ntasks);
        ExecutorCompletionService<T> ecs;
        ecs = new ExecutorCompletionService<T>(this);
        try 
        {
            ExecutionException ee;
            ee = null;
            long lastTime;
            lastTime = System.nanoTime();
            lastTime = 0;
            Iterator<? extends Callable<T>> it;
            it = tasks.iterator();
            futures.add(ecs.submit(it.next()));
            int active;
            active = 1;
            {
                Future<T> f;
                f = ecs.poll();
                {
                    {
                        futures.add(ecs.submit(it.next()));
                    } //End block
                    {
                        f = ecs.poll(nanos, TimeUnit.NANOSECONDS);
                        if (DroidSafeAndroidRuntime.control) throw new TimeoutException();
                        long now;
                        now = System.nanoTime();
                        nanos -= now - lastTime;
                        lastTime = now;
                    } //End block
                    f = ecs.take();
                } //End block
                {
                    try 
                    {
                        T var3594130D7EAF41224D5BED58875728BE_1130737343 = (f.get());
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
            ee = new ExecutionException();
            if (DroidSafeAndroidRuntime.control) throw ee;
        } //End block
        finally 
        {
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_50226114 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_50226114.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_50226114.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.298 -0400", hash_original_method = "97F8F3146846E948F707846D19B902DB", hash_generated_method = "9F48037CFA803EF01EEBF174CBAD7E2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        dsTaint.addTaint(tasks.dsTaint);
        try 
        {
            T varA5CCAADE6AF4AE143E03C1ED388B767A_1457302944 = (doInvokeAny(tasks, false, 0));
        } //End block
        catch (TimeoutException cannotHappen)
        { }
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return doInvokeAny(tasks, false, 0);
        //} catch (TimeoutException cannotHappen) {
            //assert false;
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.298 -0400", hash_original_method = "A9D2441D5895F636CD5D7E2B2C0159D4", hash_generated_method = "9514A9C5C299164F2A134B93BE44408A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                           long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(tasks.dsTaint);
        dsTaint.addTaint(timeout);
        T var7014DB679E7D20E833AAE007B001A8EA_1312890779 = (doInvokeAny(tasks, true, unit.toNanos(timeout)));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return doInvokeAny(tasks, true, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.300 -0400", hash_original_method = "B24747B6507D912BAB1561A4B1530E75", hash_generated_method = "8402705E3FDF4A9048297270A3D8D6F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        dsTaint.addTaint(tasks.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        List<Future<T>> futures;
        futures = new ArrayList<Future<T>>(tasks.size());
        boolean done;
        done = false;
        try 
        {
            {
                Iterator<Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_2133254759 = (tasks).iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_2133254759.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_2133254759.next();
                {
                    RunnableFuture<T> f;
                    f = newTaskFor(t);
                    futures.add(f);
                    execute(f);
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_884349501 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_884349501.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_884349501.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_2018447535 = (!f.isDone());
                        {
                            try 
                            {
                                f.get();
                            } //End block
                            catch (CancellationException ignore)
                            { }
                            catch (ExecutionException ignore)
                            { }
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            done = true;
        } //End block
        finally 
        {
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_2118357775 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_2118357775.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_2118357775.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        return (List<Future<T>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.303 -0400", hash_original_method = "14FC4B905592A585E278FFB06E2B3922", hash_generated_method = "60145E31F6AF49A6F60D2FCA9331AC91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                         long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(tasks.dsTaint);
        dsTaint.addTaint(timeout);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        long nanos;
        nanos = unit.toNanos(timeout);
        List<Future<T>> futures;
        futures = new ArrayList<Future<T>>(tasks.size());
        boolean done;
        done = false;
        try 
        {
            {
                Iterator<Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_27577047 = (tasks).iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_27577047.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_27577047.next();
                futures.add(newTaskFor(t));
            } //End collapsed parenthetic
            long lastTime;
            lastTime = System.nanoTime();
            Iterator<Future<T>> it;
            it = futures.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1911435731 = (it.hasNext());
                {
                    execute((Runnable)(it.next()));
                    long now;
                    now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_484316090 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_484316090.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_484316090.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_178601076 = (!f.isDone());
                        {
                            try 
                            {
                                f.get(nanos, TimeUnit.NANOSECONDS);
                            } //End block
                            catch (CancellationException ignore)
                            { }
                            catch (ExecutionException ignore)
                            { }
                            catch (TimeoutException toe)
                            { }
                            long now;
                            now = System.nanoTime();
                            nanos -= now - lastTime;
                            lastTime = now;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            done = true;
        } //End block
        finally 
        {
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1296372337 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1296372337.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1296372337.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        return (List<Future<T>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

