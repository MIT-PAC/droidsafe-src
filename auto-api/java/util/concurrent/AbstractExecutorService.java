package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public abstract class AbstractExecutorService implements ExecutorService {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.053 -0400", hash_original_method = "3052CE934B3A3FC619D77CE90023EF56", hash_generated_method = "3052CE934B3A3FC619D77CE90023EF56")
    public AbstractExecutorService ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.053 -0400", hash_original_method = "68FC815A084AC2ED05B7AEC372706304", hash_generated_method = "38E68C00A7B57DB4040785865C4A9242")
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        RunnableFuture<T> varB4EAC82CA7396A68D541C85D26508E83_22513976 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_22513976 = new FutureTask<T>(runnable, value);
        addTaint(runnable.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_22513976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_22513976;
        // ---------- Original Method ----------
        //return new FutureTask<T>(runnable, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.054 -0400", hash_original_method = "5FB2799215A846560527597078EAB474", hash_generated_method = "6FBAC70F75E3909CB0D9E516E2350FD6")
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        RunnableFuture<T> varB4EAC82CA7396A68D541C85D26508E83_1633647994 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1633647994 = new FutureTask<T>(callable);
        addTaint(callable.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1633647994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1633647994;
        // ---------- Original Method ----------
        //return new FutureTask<T>(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.054 -0400", hash_original_method = "049AFBF6C6F134F34D289DFB97D38727", hash_generated_method = "14F55440C703AE48BE98B6E850536BD1")
    public Future<?> submit(Runnable task) {
        Future<?> varB4EAC82CA7396A68D541C85D26508E83_948530914 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<Void> ftask = newTaskFor(task, null);
        execute(ftask);
        varB4EAC82CA7396A68D541C85D26508E83_948530914 = ftask;
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_948530914.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_948530914;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<Void> ftask = newTaskFor(task, null);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.055 -0400", hash_original_method = "30E9EFFFABD0E5EC417E237355DE18FD", hash_generated_method = "DD1545856A9D30F4634E845BACBBE9B7")
    public <T> Future<T> submit(Runnable task, T result) {
        Future<T> varB4EAC82CA7396A68D541C85D26508E83_418470319 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task, result);
        execute(ftask);
        varB4EAC82CA7396A68D541C85D26508E83_418470319 = ftask;
        addTaint(task.getTaint());
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_418470319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_418470319;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task, result);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.055 -0400", hash_original_method = "F1883381F3EE85BA65E359E467E69859", hash_generated_method = "1F12FAA6006FCDD2C1C2898CD0988978")
    public <T> Future<T> submit(Callable<T> task) {
        Future<T> varB4EAC82CA7396A68D541C85D26508E83_650629591 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task);
        execute(ftask);
        varB4EAC82CA7396A68D541C85D26508E83_650629591 = ftask;
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_650629591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_650629591;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.059 -0400", hash_original_method = "7ADE924855E97F021AF211771D5543D6", hash_generated_method = "FCC1AE846E6B5D7B0600A5BC8EE843EB")
    private <T> T doInvokeAny(Collection<? extends Callable<T>> tasks,
                            boolean timed, long nanos) throws InterruptedException, ExecutionException, TimeoutException {
        T varB4EAC82CA7396A68D541C85D26508E83_152329358 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int ntasks = tasks.size();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        List<Future<T>> futures = new ArrayList<Future<T>>(ntasks);
        ExecutorCompletionService<T> ecs = new ExecutorCompletionService<T>(this);
        try 
        {
            ExecutionException ee = null;
            long lastTime;
            lastTime = System.nanoTime();
            lastTime = 0;
            Iterator<? extends Callable<T>> it = tasks.iterator();
            futures.add(ecs.submit(it.next()));
            int active = 1;
            {
                Future<T> f = ecs.poll();
                {
                    {
                        futures.add(ecs.submit(it.next()));
                    } //End block
                    {
                        f = ecs.poll(nanos, TimeUnit.NANOSECONDS);
                        if (DroidSafeAndroidRuntime.control) throw new TimeoutException();
                        long now = System.nanoTime();
                        nanos -= now - lastTime;
                        lastTime = now;
                    } //End block
                    f = ecs.take();
                } //End block
                {
                    try 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_152329358 = f.get();
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
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_456783174 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_456783174.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_456783174.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        addTaint(tasks.getTaint());
        addTaint(timed);
        addTaint(nanos);
        varB4EAC82CA7396A68D541C85D26508E83_152329358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_152329358;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.059 -0400", hash_original_method = "97F8F3146846E948F707846D19B902DB", hash_generated_method = "7F3EF63B62A2680B941C10A580906377")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        T varB4EAC82CA7396A68D541C85D26508E83_207806822 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_1263832557 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_207806822 = doInvokeAny(tasks, false, 0);
        } //End block
        catch (TimeoutException cannotHappen)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1263832557 = null;
        } //End block
        addTaint(tasks.getTaint());
        T varA7E53CE21691AB073D9660D615818899_600873851; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_600873851 = varB4EAC82CA7396A68D541C85D26508E83_207806822;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_600873851 = varB4EAC82CA7396A68D541C85D26508E83_1263832557;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_600873851.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_600873851;
        // ---------- Original Method ----------
        //try {
            //return doInvokeAny(tasks, false, 0);
        //} catch (TimeoutException cannotHappen) {
            //assert false;
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.060 -0400", hash_original_method = "A9D2441D5895F636CD5D7E2B2C0159D4", hash_generated_method = "6D0D49F8779D90827BCCA8FAEC465E74")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                           long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        T varB4EAC82CA7396A68D541C85D26508E83_2087714511 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2087714511 = doInvokeAny(tasks, true, unit.toNanos(timeout));
        addTaint(tasks.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2087714511.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2087714511;
        // ---------- Original Method ----------
        //return doInvokeAny(tasks, true, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.064 -0400", hash_original_method = "B24747B6507D912BAB1561A4B1530E75", hash_generated_method = "D4F5DCE71E0985651FDAA12995EEA61A")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1180850010 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        List<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
        boolean done = false;
        try 
        {
            {
                Iterator<? extends Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_900522027 = (tasks).iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_900522027.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_900522027.next();
                {
                    RunnableFuture<T> f = newTaskFor(t);
                    futures.add(f);
                    execute(f);
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1516798350 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1516798350.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1516798350.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_1616442509 = (!f.isDone());
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
            varB4EAC82CA7396A68D541C85D26508E83_1180850010 = futures;
        } //End block
        finally 
        {
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_339931714 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_339931714.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_339931714.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        addTaint(tasks.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1180850010.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1180850010;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.072 -0400", hash_original_method = "14FC4B905592A585E278FFB06E2B3922", hash_generated_method = "9115B69D208925ADEE58311927E3A3FC")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                         long timeout, TimeUnit unit) throws InterruptedException {
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1433945447 = null; //Variable for return #1
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1012756548 = null; //Variable for return #2
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_899263421 = null; //Variable for return #3
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_418112726 = null; //Variable for return #4
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        long nanos = unit.toNanos(timeout);
        List<Future<T>> futures = new ArrayList<Future<T>>(tasks.size());
        boolean done = false;
        try 
        {
            {
                Iterator<? extends Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1563764440 = (tasks).iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1563764440.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1563764440.next();
                futures.add(newTaskFor(t));
            } //End collapsed parenthetic
            long lastTime = System.nanoTime();
            Iterator<Future<T>> it = futures.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_390892150 = (it.hasNext());
                {
                    execute((Runnable)(it.next()));
                    long now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    varB4EAC82CA7396A68D541C85D26508E83_1433945447 = futures;
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1361801393 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1361801393.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1361801393.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_144447098 = (!f.isDone());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1012756548 = futures;
                            try 
                            {
                                f.get(nanos, TimeUnit.NANOSECONDS);
                            } //End block
                            catch (CancellationException ignore)
                            { }
                            catch (ExecutionException ignore)
                            { }
                            catch (TimeoutException toe)
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_899263421 = futures;
                            } //End block
                            long now = System.nanoTime();
                            nanos -= now - lastTime;
                            lastTime = now;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            done = true;
            varB4EAC82CA7396A68D541C85D26508E83_418112726 = futures;
        } //End block
        finally 
        {
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1224607181 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1224607181.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1224607181.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        addTaint(tasks.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        List<Future<T>> varA7E53CE21691AB073D9660D615818899_345624225; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_345624225 = varB4EAC82CA7396A68D541C85D26508E83_1433945447;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_345624225 = varB4EAC82CA7396A68D541C85D26508E83_1012756548;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_345624225 = varB4EAC82CA7396A68D541C85D26508E83_899263421;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_345624225 = varB4EAC82CA7396A68D541C85D26508E83_418112726;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_345624225.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_345624225;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

