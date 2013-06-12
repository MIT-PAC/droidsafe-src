package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public abstract class AbstractExecutorService implements ExecutorService {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.362 -0400", hash_original_method = "68FC815A084AC2ED05B7AEC372706304", hash_generated_method = "859DE271094F8AB8BB29F3EDBFFCECD0")
    @DSModeled(DSC.SAFE)
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        return (RunnableFuture<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FutureTask<T>(runnable, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.376 -0400", hash_original_method = "5FB2799215A846560527597078EAB474", hash_generated_method = "0A00049593FF80A2EB0A944332D0D680")
    @DSModeled(DSC.SAFE)
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        dsTaint.addTaint(callable.dsTaint);
        return (RunnableFuture<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FutureTask<T>(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.404 -0400", hash_original_method = "049AFBF6C6F134F34D289DFB97D38727", hash_generated_method = "0C6C8651110CFD0972B14656AE3CE2DC")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.431 -0400", hash_original_method = "30E9EFFFABD0E5EC417E237355DE18FD", hash_generated_method = "845856CE104B06BEFB8798CBE3E29FA4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.462 -0400", hash_original_method = "F1883381F3EE85BA65E359E467E69859", hash_generated_method = "088FF2A6E99ECD14FDD10F4B9CA0A3CE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.591 -0400", hash_original_method = "7ADE924855E97F021AF211771D5543D6", hash_generated_method = "C0A029D5C56215AE96FC17336EF21BB1")
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
            --ntasks;
            int active;
            active = 1;
            {
                Future<T> f;
                f = ecs.poll();
                {
                    {
                        --ntasks;
                        futures.add(ecs.submit(it.next()));
                        ++active;
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
                    --active;
                    try 
                    {
                        T var3594130D7EAF41224D5BED58875728BE_542011490 = (f.get());
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
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1191503385 = futures.iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1191503385.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1191503385.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.652 -0400", hash_original_method = "97F8F3146846E948F707846D19B902DB", hash_generated_method = "C710717BC4038C098BD8793E5EBDB676")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        dsTaint.addTaint(tasks.dsTaint);
        try 
        {
            T varA5CCAADE6AF4AE143E03C1ED388B767A_64367517 = (doInvokeAny(tasks, false, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.688 -0400", hash_original_method = "A9D2441D5895F636CD5D7E2B2C0159D4", hash_generated_method = "16867FC80288536EE4A14D2BB998AB78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                           long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(tasks.dsTaint);
        dsTaint.addTaint(timeout);
        T var7014DB679E7D20E833AAE007B001A8EA_1065550151 = (doInvokeAny(tasks, true, unit.toNanos(timeout)));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return doInvokeAny(tasks, true, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.703 -0400", hash_original_method = "B24747B6507D912BAB1561A4B1530E75", hash_generated_method = "1215D4B42DF5D9B163E773A6C7A33B11")
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
                Iterator<? extends Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_928259873 = tasks.iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_928259873.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_928259873.next();
                {
                    RunnableFuture<T> f;
                    f = newTaskFor(t);
                    futures.add(f);
                    execute(f);
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_196813851 = futures.iterator();
                var562C00083CDEF6998493FFDF1B4B277F_196813851.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_196813851.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_473533873 = (!f.isDone());
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
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1106217606 = futures.iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1106217606.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1106217606.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        return (List<Future<T>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:14:39.738 -0400", hash_original_method = "14FC4B905592A585E278FFB06E2B3922", hash_generated_method = "EFDD4B3E8FFA912D7EAE116D6DDF40EC")
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
                Iterator<? extends Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1890855274 = tasks.iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1890855274.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1890855274.next();
                futures.add(newTaskFor(t));
            } //End collapsed parenthetic
            long lastTime;
            lastTime = System.nanoTime();
            Iterator<Future<T>> it;
            it = futures.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_458332366 = (it.hasNext());
                {
                    execute((Runnable)(it.next()));
                    long now;
                    now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_495212479 = futures.iterator();
                var562C00083CDEF6998493FFDF1B4B277F_495212479.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_495212479.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_898833025 = (!f.isDone());
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
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1574099020 = futures.iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1574099020.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1574099020.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        return (List<Future<T>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


