package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public abstract class AbstractExecutorService implements ExecutorService {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.396 -0400", hash_original_method = "3052CE934B3A3FC619D77CE90023EF56", hash_generated_method = "3052CE934B3A3FC619D77CE90023EF56")
    public AbstractExecutorService ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.397 -0400", hash_original_method = "68FC815A084AC2ED05B7AEC372706304", hash_generated_method = "E68667E70F02D6AD82C9E55A746FB648")
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        RunnableFuture<T> varB4EAC82CA7396A68D541C85D26508E83_1981674616 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1981674616 = new FutureTask<T>(runnable, value);
        addTaint(runnable.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1981674616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1981674616;
        // ---------- Original Method ----------
        //return new FutureTask<T>(runnable, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.397 -0400", hash_original_method = "5FB2799215A846560527597078EAB474", hash_generated_method = "BC5B601E4D6E81AFC5E03B3B1B2F097B")
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        RunnableFuture<T> varB4EAC82CA7396A68D541C85D26508E83_1179467709 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1179467709 = new FutureTask<T>(callable);
        addTaint(callable.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1179467709.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1179467709;
        // ---------- Original Method ----------
        //return new FutureTask<T>(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.398 -0400", hash_original_method = "049AFBF6C6F134F34D289DFB97D38727", hash_generated_method = "C96F7151E32136F5A876B6CB5160D326")
    public Future<?> submit(Runnable task) {
        Future<?> varB4EAC82CA7396A68D541C85D26508E83_1561638982 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<Void> ftask;
        ftask = newTaskFor(task, null);
        execute(ftask);
        varB4EAC82CA7396A68D541C85D26508E83_1561638982 = ftask;
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1561638982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561638982;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<Void> ftask = newTaskFor(task, null);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.403 -0400", hash_original_method = "30E9EFFFABD0E5EC417E237355DE18FD", hash_generated_method = "C75D8556867F4AAC597FEE1A09514AA3")
    public <T> Future<T> submit(Runnable task, T result) {
        Future<T> varB4EAC82CA7396A68D541C85D26508E83_1715632628 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<T> ftask;
        ftask = newTaskFor(task, result);
        execute(ftask);
        varB4EAC82CA7396A68D541C85D26508E83_1715632628 = ftask;
        addTaint(task.getTaint());
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1715632628.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1715632628;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task, result);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.404 -0400", hash_original_method = "F1883381F3EE85BA65E359E467E69859", hash_generated_method = "1D95E116B67B931F0D8810AF0030D45F")
    public <T> Future<T> submit(Callable<T> task) {
        Future<T> varB4EAC82CA7396A68D541C85D26508E83_1950365633 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<T> ftask;
        ftask = newTaskFor(task);
        execute(ftask);
        varB4EAC82CA7396A68D541C85D26508E83_1950365633 = ftask;
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1950365633.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1950365633;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.436 -0400", hash_original_method = "7ADE924855E97F021AF211771D5543D6", hash_generated_method = "73FC03095B7108716DD2F991A2A6C3FA")
    private <T> T doInvokeAny(Collection<? extends Callable<T>> tasks,
                            boolean timed, long nanos) throws InterruptedException, ExecutionException, TimeoutException {
        T varB4EAC82CA7396A68D541C85D26508E83_1388981310 = null; //Variable for return #1
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
                        varB4EAC82CA7396A68D541C85D26508E83_1388981310 = f.get();
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
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1637996502 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1637996502.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1637996502.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        addTaint(tasks.getTaint());
        addTaint(timed);
        addTaint(nanos);
        varB4EAC82CA7396A68D541C85D26508E83_1388981310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388981310;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.437 -0400", hash_original_method = "97F8F3146846E948F707846D19B902DB", hash_generated_method = "E9FB2E40DB81F11E68FE519DE62955D8")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        T varB4EAC82CA7396A68D541C85D26508E83_1430696700 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_994821826 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1430696700 = doInvokeAny(tasks, false, 0);
        } //End block
        catch (TimeoutException cannotHappen)
        {
            varB4EAC82CA7396A68D541C85D26508E83_994821826 = null;
        } //End block
        addTaint(tasks.getTaint());
        T varA7E53CE21691AB073D9660D615818899_1976733054; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1976733054 = varB4EAC82CA7396A68D541C85D26508E83_1430696700;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1976733054 = varB4EAC82CA7396A68D541C85D26508E83_994821826;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1976733054.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1976733054;
        // ---------- Original Method ----------
        //try {
            //return doInvokeAny(tasks, false, 0);
        //} catch (TimeoutException cannotHappen) {
            //assert false;
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.438 -0400", hash_original_method = "A9D2441D5895F636CD5D7E2B2C0159D4", hash_generated_method = "A38925235CF9D47F0BC2C249F5B6696A")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                           long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        T varB4EAC82CA7396A68D541C85D26508E83_1723973901 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1723973901 = doInvokeAny(tasks, true, unit.toNanos(timeout));
        addTaint(tasks.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1723973901.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1723973901;
        // ---------- Original Method ----------
        //return doInvokeAny(tasks, true, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.477 -0400", hash_original_method = "B24747B6507D912BAB1561A4B1530E75", hash_generated_method = "16590B652DD86B2DC634FD841B9BC4B2")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1965834446 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        List<Future<T>> futures;
        futures = new ArrayList<Future<T>>(tasks.size());
        boolean done;
        done = false;
        try 
        {
            {
                Iterator<Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1064728085 = (tasks).iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1064728085.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1064728085.next();
                {
                    RunnableFuture<T> f;
                    f = newTaskFor(t);
                    futures.add(f);
                    execute(f);
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_24174567 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_24174567.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_24174567.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_737329527 = (!f.isDone());
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
            varB4EAC82CA7396A68D541C85D26508E83_1965834446 = futures;
        } //End block
        finally 
        {
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_605221571 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_605221571.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_605221571.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        addTaint(tasks.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1965834446.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1965834446;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.513 -0400", hash_original_method = "14FC4B905592A585E278FFB06E2B3922", hash_generated_method = "4F9059C961A5BF6C9015EF6CC9E9E423")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                         long timeout, TimeUnit unit) throws InterruptedException {
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1487628949 = null; //Variable for return #1
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_786287069 = null; //Variable for return #2
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_731554506 = null; //Variable for return #3
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1033830433 = null; //Variable for return #4
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
                Iterator<Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_252392541 = (tasks).iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_252392541.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_252392541.next();
                futures.add(newTaskFor(t));
            } //End collapsed parenthetic
            long lastTime;
            lastTime = System.nanoTime();
            Iterator<Future<T>> it;
            it = futures.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1466121801 = (it.hasNext());
                {
                    execute((Runnable)(it.next()));
                    long now;
                    now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    varB4EAC82CA7396A68D541C85D26508E83_1487628949 = futures;
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1138081978 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1138081978.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1138081978.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_766917953 = (!f.isDone());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_786287069 = futures;
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
                                varB4EAC82CA7396A68D541C85D26508E83_731554506 = futures;
                            } //End block
                            long now;
                            now = System.nanoTime();
                            nanos -= now - lastTime;
                            lastTime = now;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            done = true;
            varB4EAC82CA7396A68D541C85D26508E83_1033830433 = futures;
        } //End block
        finally 
        {
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1396435380 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1396435380.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1396435380.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        addTaint(tasks.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        List<Future<T>> varA7E53CE21691AB073D9660D615818899_880618126; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_880618126 = varB4EAC82CA7396A68D541C85D26508E83_1487628949;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_880618126 = varB4EAC82CA7396A68D541C85D26508E83_786287069;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_880618126 = varB4EAC82CA7396A68D541C85D26508E83_731554506;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_880618126 = varB4EAC82CA7396A68D541C85D26508E83_1033830433;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_880618126.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_880618126;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

