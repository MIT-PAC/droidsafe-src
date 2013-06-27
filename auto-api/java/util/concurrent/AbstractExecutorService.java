package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;

public abstract class AbstractExecutorService implements ExecutorService {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.047 -0400", hash_original_method = "3052CE934B3A3FC619D77CE90023EF56", hash_generated_method = "3052CE934B3A3FC619D77CE90023EF56")
    public AbstractExecutorService ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.048 -0400", hash_original_method = "68FC815A084AC2ED05B7AEC372706304", hash_generated_method = "31B0B7F1D34A1F5E9B8E3BA12CE6A8BF")
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        RunnableFuture<T> varB4EAC82CA7396A68D541C85D26508E83_2093432897 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2093432897 = new FutureTask<T>(runnable, value);
        addTaint(runnable.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2093432897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2093432897;
        // ---------- Original Method ----------
        //return new FutureTask<T>(runnable, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.048 -0400", hash_original_method = "5FB2799215A846560527597078EAB474", hash_generated_method = "F74F7FCA19937F0BCFDC8318FA029ED8")
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        RunnableFuture<T> varB4EAC82CA7396A68D541C85D26508E83_1212035783 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1212035783 = new FutureTask<T>(callable);
        addTaint(callable.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1212035783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1212035783;
        // ---------- Original Method ----------
        //return new FutureTask<T>(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.062 -0400", hash_original_method = "049AFBF6C6F134F34D289DFB97D38727", hash_generated_method = "0E68272FA05F685C956A0E12EE87C8EF")
    public Future<?> submit(Runnable task) {
        Future<?> varB4EAC82CA7396A68D541C85D26508E83_1165468215 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<Void> ftask;
        ftask = newTaskFor(task, null);
        execute(ftask);
        varB4EAC82CA7396A68D541C85D26508E83_1165468215 = ftask;
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1165468215.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1165468215;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<Void> ftask = newTaskFor(task, null);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.063 -0400", hash_original_method = "30E9EFFFABD0E5EC417E237355DE18FD", hash_generated_method = "058786811FDC82F9258C4684809F7A50")
    public <T> Future<T> submit(Runnable task, T result) {
        Future<T> varB4EAC82CA7396A68D541C85D26508E83_1665734896 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<T> ftask;
        ftask = newTaskFor(task, result);
        execute(ftask);
        varB4EAC82CA7396A68D541C85D26508E83_1665734896 = ftask;
        addTaint(task.getTaint());
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1665734896.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1665734896;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task, result);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.063 -0400", hash_original_method = "F1883381F3EE85BA65E359E467E69859", hash_generated_method = "AF9170DFE9D7EE788D86B22D292A5622")
    public <T> Future<T> submit(Callable<T> task) {
        Future<T> varB4EAC82CA7396A68D541C85D26508E83_1070362859 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableFuture<T> ftask;
        ftask = newTaskFor(task);
        execute(ftask);
        varB4EAC82CA7396A68D541C85D26508E83_1070362859 = ftask;
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1070362859.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1070362859;
        // ---------- Original Method ----------
        //if (task == null) throw new NullPointerException();
        //RunnableFuture<T> ftask = newTaskFor(task);
        //execute(ftask);
        //return ftask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.073 -0400", hash_original_method = "7ADE924855E97F021AF211771D5543D6", hash_generated_method = "F3C2968DDCF5BD1C4676B4F5DE267CE5")
    private <T> T doInvokeAny(Collection<? extends Callable<T>> tasks,
                            boolean timed, long nanos) throws InterruptedException, ExecutionException, TimeoutException {
        T varB4EAC82CA7396A68D541C85D26508E83_946280565 = null; //Variable for return #1
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
                        varB4EAC82CA7396A68D541C85D26508E83_946280565 = f.get();
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
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1708415636 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1708415636.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1708415636.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        addTaint(tasks.getTaint());
        addTaint(timed);
        addTaint(nanos);
        varB4EAC82CA7396A68D541C85D26508E83_946280565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946280565;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.074 -0400", hash_original_method = "97F8F3146846E948F707846D19B902DB", hash_generated_method = "A2C58630FF5C52BFC8BFF80A1A0A0887")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        T varB4EAC82CA7396A68D541C85D26508E83_813295803 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_1915527880 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_813295803 = doInvokeAny(tasks, false, 0);
        } //End block
        catch (TimeoutException cannotHappen)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1915527880 = null;
        } //End block
        addTaint(tasks.getTaint());
        T varA7E53CE21691AB073D9660D615818899_725415846; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_725415846 = varB4EAC82CA7396A68D541C85D26508E83_813295803;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_725415846 = varB4EAC82CA7396A68D541C85D26508E83_1915527880;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_725415846.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_725415846;
        // ---------- Original Method ----------
        //try {
            //return doInvokeAny(tasks, false, 0);
        //} catch (TimeoutException cannotHappen) {
            //assert false;
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.096 -0400", hash_original_method = "A9D2441D5895F636CD5D7E2B2C0159D4", hash_generated_method = "EE0E143F9B700540DE33538DAC2BFEA8")
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                           long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        T varB4EAC82CA7396A68D541C85D26508E83_915606142 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_915606142 = doInvokeAny(tasks, true, unit.toNanos(timeout));
        addTaint(tasks.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_915606142.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_915606142;
        // ---------- Original Method ----------
        //return doInvokeAny(tasks, true, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.143 -0400", hash_original_method = "B24747B6507D912BAB1561A4B1530E75", hash_generated_method = "CBC257ED8D515862D5AECA9B4A1BDE58")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1568550301 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        List<Future<T>> futures;
        futures = new ArrayList<Future<T>>(tasks.size());
        boolean done;
        done = false;
        try 
        {
            {
                Iterator<Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1343884845 = (tasks).iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1343884845.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_1343884845.next();
                {
                    RunnableFuture<T> f;
                    f = newTaskFor(t);
                    futures.add(f);
                    execute(f);
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_498088809 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_498088809.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_498088809.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_1227855826 = (!f.isDone());
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
            varB4EAC82CA7396A68D541C85D26508E83_1568550301 = futures;
        } //End block
        finally 
        {
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_2036083679 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_2036083679.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_2036083679.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        addTaint(tasks.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1568550301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1568550301;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.213 -0400", hash_original_method = "14FC4B905592A585E278FFB06E2B3922", hash_generated_method = "81594BAACC8EC0D0856261B7E1EC5F8C")
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                         long timeout, TimeUnit unit) throws InterruptedException {
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1087669417 = null; //Variable for return #1
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1487289501 = null; //Variable for return #2
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1187413625 = null; //Variable for return #3
        List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_96781034 = null; //Variable for return #4
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
                Iterator<Callable<T>> var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_240064176 = (tasks).iterator();
                var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_240064176.hasNext();
                Callable<T> t = var23A0DE9A3AA56E22EDA61FDE4D4CCD8A_240064176.next();
                futures.add(newTaskFor(t));
            } //End collapsed parenthetic
            long lastTime;
            lastTime = System.nanoTime();
            Iterator<Future<T>> it;
            it = futures.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1817329096 = (it.hasNext());
                {
                    execute((Runnable)(it.next()));
                    long now;
                    now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    varB4EAC82CA7396A68D541C85D26508E83_1087669417 = futures;
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_529395012 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_529395012.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_529395012.next();
                {
                    {
                        boolean varF2D8200A41381633042302AEDF579A81_1685362620 = (!f.isDone());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1487289501 = futures;
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
                                varB4EAC82CA7396A68D541C85D26508E83_1187413625 = futures;
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
            varB4EAC82CA7396A68D541C85D26508E83_96781034 = futures;
        } //End block
        finally 
        {
            {
                Iterator<Future<T>> var562C00083CDEF6998493FFDF1B4B277F_1109807264 = (futures).iterator();
                var562C00083CDEF6998493FFDF1B4B277F_1109807264.hasNext();
                Future<T> f = var562C00083CDEF6998493FFDF1B4B277F_1109807264.next();
                f.cancel(true);
            } //End collapsed parenthetic
        } //End block
        addTaint(tasks.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        List<Future<T>> varA7E53CE21691AB073D9660D615818899_2033093495; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2033093495 = varB4EAC82CA7396A68D541C85D26508E83_1087669417;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2033093495 = varB4EAC82CA7396A68D541C85D26508E83_1487289501;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2033093495 = varB4EAC82CA7396A68D541C85D26508E83_1187413625;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2033093495 = varB4EAC82CA7396A68D541C85D26508E83_96781034;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2033093495.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2033093495;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

