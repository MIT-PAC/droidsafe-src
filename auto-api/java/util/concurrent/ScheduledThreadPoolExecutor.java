package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.util.*;

public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService {
    private volatile boolean continueExistingPeriodicTasksAfterShutdown;
    private volatile boolean executeExistingDelayedTasksAfterShutdown = true;
    private volatile boolean removeOnCancel = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.797 -0400", hash_original_method = "D36047D4322FE6F8EBCA30AB15266BC6", hash_generated_method = "4BBE3CA42048704BD3DBD15CEC11F2EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue());
        dsTaint.addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.797 -0400", hash_original_method = "ABDCD4F10C893856EFE26F2C021D677A", hash_generated_method = "AFF51048B52168806A009EA498C5B14C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScheduledThreadPoolExecutor(int corePoolSize,
                                       ThreadFactory threadFactory) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), threadFactory);
        dsTaint.addTaint(threadFactory.dsTaint);
        dsTaint.addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.797 -0400", hash_original_method = "15AFC792EAFAB8847ABF7F7AA1CDCAAC", hash_generated_method = "9797892CE5BC9BBD52047D3EF0C51736")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScheduledThreadPoolExecutor(int corePoolSize,
                                       RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), handler);
        dsTaint.addTaint(corePoolSize);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.797 -0400", hash_original_method = "FA0219710575675561B4DC7EAFAB1D1D", hash_generated_method = "E2E2A6B57508DF2E64231089CED6FD2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScheduledThreadPoolExecutor(int corePoolSize,
                                       ThreadFactory threadFactory,
                                       RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), threadFactory, handler);
        dsTaint.addTaint(threadFactory.dsTaint);
        dsTaint.addTaint(corePoolSize);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.797 -0400", hash_original_method = "5D4518F727B3B1C5CE98EBC039D9AF6B", hash_generated_method = "0ABE68D28239AEBAAA2A103496279DE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final long now() {
        long var38C9A41D4C7B496258927F1AFD7464A5_1218589326 = (System.nanoTime());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return System.nanoTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.798 -0400", hash_original_method = "43122228A318CAFA2BE5FD8EB8B7119A", hash_generated_method = "12BB7D3081A55B827EE0AA4A6D26435E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean canRunInCurrentRunState(boolean periodic) {
        dsTaint.addTaint(periodic);
        boolean var636123F330B288C0794F274F6243222D_464380040 = (isRunningOrShutdown(periodic ?
                                   continueExistingPeriodicTasksAfterShutdown :
                                   executeExistingDelayedTasksAfterShutdown)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isRunningOrShutdown(periodic ?
                                   //continueExistingPeriodicTasksAfterShutdown :
                                   //executeExistingDelayedTasksAfterShutdown);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.798 -0400", hash_original_method = "74BC2A8347918586B07692C369988E7C", hash_generated_method = "0B00D9F4DA13394C400DF48CF0609E9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void delayedExecute(RunnableScheduledFuture<?> task) {
        dsTaint.addTaint(task.dsTaint);
        {
            boolean varD7D6F17835B9DE02DC18908B63864E97_798686837 = (isShutdown());
            reject(task);
            {
                super.getQueue().add(task);
                {
                    boolean var9F93D657B4AB08D4C240833C5152DDD5_242742945 = (isShutdown() &&
                !canRunInCurrentRunState(task.isPeriodic()) &&
                remove(task));
                    task.cancel(false);
                    prestartCoreThread();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isShutdown())
            //reject(task);
        //else {
            //super.getQueue().add(task);
            //if (isShutdown() &&
                //!canRunInCurrentRunState(task.isPeriodic()) &&
                //remove(task))
                //task.cancel(false);
            //else
                //prestartCoreThread();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.798 -0400", hash_original_method = "0C685B50A598B045820F5EF901D2AED6", hash_generated_method = "2128201B430C341F9ED496F7A31551DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void reExecutePeriodic(RunnableScheduledFuture<?> task) {
        dsTaint.addTaint(task.dsTaint);
        {
            boolean var2689F2A799548532A8E160831E5A33A8_1579256268 = (canRunInCurrentRunState(true));
            {
                super.getQueue().add(task);
                {
                    boolean var471B5F2C64914A5472B62C3F29896BF1_1077193734 = (!canRunInCurrentRunState(true) && remove(task));
                    task.cancel(false);
                    prestartCoreThread();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (canRunInCurrentRunState(true)) {
            //super.getQueue().add(task);
            //if (!canRunInCurrentRunState(true) && remove(task))
                //task.cancel(false);
            //else
                //prestartCoreThread();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.803 -0400", hash_original_method = "64FA3598D4BDF802451AB41ACA7E6BE8", hash_generated_method = "F0B35D3111EC2CD5CC97DEBDFE087930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void onShutdown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        BlockingQueue<Runnable> q;
        q = super.getQueue();
        boolean keepDelayed;
        keepDelayed = getExecuteExistingDelayedTasksAfterShutdownPolicy();
        boolean keepPeriodic;
        keepPeriodic = getContinueExistingPeriodicTasksAfterShutdownPolicy();
        {
            {
                Object e = q.toArray()[0];
                ((RunnableScheduledFuture<?>) e).cancel(false);
            } //End collapsed parenthetic
            q.clear();
        } //End block
        {
            {
                Object e = q.toArray()[0];
                {
                    {
                        RunnableScheduledFuture<?> t;
                        t = (RunnableScheduledFuture<?>)e;
                        {
                            boolean varF7F2675F0606E27C21A93E064C27288B_2083204502 = ((t.isPeriodic() ? !keepPeriodic : !keepDelayed) ||
                        t.isCancelled()); //DSFIXME:  CODE0008: Nested ternary operator in expression
                            {
                                {
                                    boolean varBEBF9C2A16974119BECC96CE9B7D06C1_1363838814 = (q.remove(t));
                                    t.cancel(false);
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        tryTerminate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.803 -0400", hash_original_method = "2D7E8C9964120FA3F638C1BFE2958CB1", hash_generated_method = "D3CC65BB5BE3AAA4D364422574F4AB45")
    @DSModeled(DSC.SAFE)
    protected <V> RunnableScheduledFuture<V> decorateTask(
        Runnable runnable, RunnableScheduledFuture<V> task) {
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(task.dsTaint);
        return (RunnableScheduledFuture<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return task;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.804 -0400", hash_original_method = "5DBE5BBA8D9EF484681F4C8336F1600B", hash_generated_method = "EE50FE51CD65DF1BF14734F1D1BA4332")
    @DSModeled(DSC.SAFE)
    protected <V> RunnableScheduledFuture<V> decorateTask(
        Callable<V> callable, RunnableScheduledFuture<V> task) {
        dsTaint.addTaint(callable.dsTaint);
        dsTaint.addTaint(task.dsTaint);
        return (RunnableScheduledFuture<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return task;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.804 -0400", hash_original_method = "14F5A42293D1200CF8E952E9DCB67B90", hash_generated_method = "1159739486F82C8544AAED24EAE3B827")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long triggerTime(long delay, TimeUnit unit) {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(delay);
        long var921EC63E99B1B0D90270C7CCF06C4834_221793176 = (triggerTime(unit.toNanos((delay < 0) ? 0 : delay))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return triggerTime(unit.toNanos((delay < 0) ? 0 : delay));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.804 -0400", hash_original_method = "43548DFC0EE197F487A673EC89A4A123", hash_generated_method = "14DAB738EBA3A853D8E4E8E23F1673B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     long triggerTime(long delay) {
        dsTaint.addTaint(delay);
        long var9E9C1F7E6FCC2FB90620873C1CB2CFB4_873054020 = (now() +
            ((delay < (Long.MAX_VALUE >> 1)) ? delay : overflowFree(delay))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return now() +
            //((delay < (Long.MAX_VALUE >> 1)) ? delay : overflowFree(delay));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.804 -0400", hash_original_method = "7169306CF31D42FCC72896372081E078", hash_generated_method = "A53CFE22171411A8A9DF4957675FFFA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long overflowFree(long delay) {
        dsTaint.addTaint(delay);
        Delayed head;
        head = (Delayed) super.getQueue().peek();
        {
            long headDelay;
            headDelay = head.getDelay(TimeUnit.NANOSECONDS);
            delay = Long.MAX_VALUE + headDelay;
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Delayed head = (Delayed) super.getQueue().peek();
        //if (head != null) {
            //long headDelay = head.getDelay(TimeUnit.NANOSECONDS);
            //if (headDelay < 0 && (delay - headDelay < 0))
                //delay = Long.MAX_VALUE + headDelay;
        //}
        //return delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.804 -0400", hash_original_method = "E8C91BC5CFBE81CC8958800A4E70C4DA", hash_generated_method = "0D2A5731402C8873B820243C8E5CCF92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScheduledFuture<?> schedule(Runnable command,
                                       long delay,
                                       TimeUnit unit) {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(command.dsTaint);
        dsTaint.addTaint(delay);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableScheduledFuture<?> t;
        t = decorateTask(command,
            new ScheduledFutureTask<Void>(command, null,
                                          triggerTime(delay, unit)));
        delayedExecute(t);
        return (ScheduledFuture<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (command == null || unit == null)
            //throw new NullPointerException();
        //RunnableScheduledFuture<?> t = decorateTask(command,
            //new ScheduledFutureTask<Void>(command, null,
                                          //triggerTime(delay, unit)));
        //delayedExecute(t);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.805 -0400", hash_original_method = "3CA816B6292CC3DABD4A8E9E190B6332", hash_generated_method = "3851287E31E886850C69EEECDA79991E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <V> ScheduledFuture<V> schedule(Callable<V> callable,
                                           long delay,
                                           TimeUnit unit) {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(callable.dsTaint);
        dsTaint.addTaint(delay);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableScheduledFuture<V> t;
        t = decorateTask(callable,
            new ScheduledFutureTask<V>(callable,
                                       triggerTime(delay, unit)));
        delayedExecute(t);
        return (ScheduledFuture<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (callable == null || unit == null)
            //throw new NullPointerException();
        //RunnableScheduledFuture<V> t = decorateTask(callable,
            //new ScheduledFutureTask<V>(callable,
                                       //triggerTime(delay, unit)));
        //delayedExecute(t);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.805 -0400", hash_original_method = "8D8E5BFEEBAD4838EB16FA502AD719D4", hash_generated_method = "85B9756198FE01A70CA656B0BC317379")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay,
                                                  long period,
                                                  TimeUnit unit) {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(initialDelay);
        dsTaint.addTaint(command.dsTaint);
        dsTaint.addTaint(period);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        ScheduledFutureTask<Void> sft;
        sft = new ScheduledFutureTask<Void>(command,
                                          null,
                                          triggerTime(initialDelay, unit),
                                          unit.toNanos(period));
        RunnableScheduledFuture<Void> t;
        t = decorateTask(command, sft);
        sft.outerTask = t;
        delayedExecute(t);
        return (ScheduledFuture<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (command == null || unit == null)
            //throw new NullPointerException();
        //if (period <= 0)
            //throw new IllegalArgumentException();
        //ScheduledFutureTask<Void> sft =
            //new ScheduledFutureTask<Void>(command,
                                          //null,
                                          //triggerTime(initialDelay, unit),
                                          //unit.toNanos(period));
        //RunnableScheduledFuture<Void> t = decorateTask(command, sft);
        //sft.outerTask = t;
        //delayedExecute(t);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.805 -0400", hash_original_method = "F8BFEFA210F26533C5765CF5137E2FD3", hash_generated_method = "562FE1A4A516AF762ED52A1AFB712474")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
                                                     long initialDelay,
                                                     long delay,
                                                     TimeUnit unit) {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(initialDelay);
        dsTaint.addTaint(command.dsTaint);
        dsTaint.addTaint(delay);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        ScheduledFutureTask<Void> sft;
        sft = new ScheduledFutureTask<Void>(command,
                                          null,
                                          triggerTime(initialDelay, unit),
                                          unit.toNanos(-delay));
        RunnableScheduledFuture<Void> t;
        t = decorateTask(command, sft);
        sft.outerTask = t;
        delayedExecute(t);
        return (ScheduledFuture<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (command == null || unit == null)
            //throw new NullPointerException();
        //if (delay <= 0)
            //throw new IllegalArgumentException();
        //ScheduledFutureTask<Void> sft =
            //new ScheduledFutureTask<Void>(command,
                                          //null,
                                          //triggerTime(initialDelay, unit),
                                          //unit.toNanos(-delay));
        //RunnableScheduledFuture<Void> t = decorateTask(command, sft);
        //sft.outerTask = t;
        //delayedExecute(t);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.806 -0400", hash_original_method = "106B54169234F208DA4A1738F707D69C", hash_generated_method = "45FAF540A986E30C2CC098E9DBDF2898")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void execute(Runnable command) {
        dsTaint.addTaint(command.dsTaint);
        schedule(command, 0, TimeUnit.NANOSECONDS);
        // ---------- Original Method ----------
        //schedule(command, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.806 -0400", hash_original_method = "71AB87E2E6647A80EF75456B59FD870B", hash_generated_method = "94C7C1B675F0EBC3A34E0C846CFBA00E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Future<?> submit(Runnable task) {
        dsTaint.addTaint(task.dsTaint);
        Future<?> var084CC832E659F55130289021C5DAD80B_2102687604 = (schedule(task, 0, TimeUnit.NANOSECONDS));
        return (Future<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return schedule(task, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.806 -0400", hash_original_method = "A2BAF492547813A1B4B6DC556E74F888", hash_generated_method = "7171A78ED90D4A8298724077676F06A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> Future<T> submit(Runnable task, T result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(task.dsTaint);
        Future<T> var3FE6CDA3B01105133B37ED68D4868908_743854929 = (schedule(Executors.callable(task, result),
                        0, TimeUnit.NANOSECONDS));
        return (Future<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return schedule(Executors.callable(task, result),
                        //0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.806 -0400", hash_original_method = "7532879CEC1557BEB821686E164CE854", hash_generated_method = "C29C0AE1E47D10AC03F198C5CB503637")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> Future<T> submit(Callable<T> task) {
        dsTaint.addTaint(task.dsTaint);
        Future<T> var084CC832E659F55130289021C5DAD80B_1698436985 = (schedule(task, 0, TimeUnit.NANOSECONDS));
        return (Future<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return schedule(task, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.806 -0400", hash_original_method = "4AFC27553B47AB13DBA25E0474D83429", hash_generated_method = "D3AFE2A6A7542BB7A785262591EDCE3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean value) {
        dsTaint.addTaint(value);
        {
            boolean varD7CCA429FE7709242F7FBD82DD2F415D_560243971 = (!value && isShutdown());
            onShutdown();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //continueExistingPeriodicTasksAfterShutdown = value;
        //if (!value && isShutdown())
            //onShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.807 -0400", hash_original_method = "23365684DD383694198E6F21D088C23A", hash_generated_method = "B2B815B3AC1A9B8E29FC5836E51F0927")
    @DSModeled(DSC.SAFE)
    public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return continueExistingPeriodicTasksAfterShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.807 -0400", hash_original_method = "DDF8C3EFAF4531B367BDE4CC570E21D4", hash_generated_method = "4509E417414D93EFF2296EA900157576")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean value) {
        dsTaint.addTaint(value);
        {
            boolean varD7CCA429FE7709242F7FBD82DD2F415D_659131215 = (!value && isShutdown());
            onShutdown();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //executeExistingDelayedTasksAfterShutdown = value;
        //if (!value && isShutdown())
            //onShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.807 -0400", hash_original_method = "691F6AED1700735267010AB69287CBB5", hash_generated_method = "41737D7DE9F786A5DE51B7CCD07D25A5")
    @DSModeled(DSC.SAFE)
    public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return executeExistingDelayedTasksAfterShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.807 -0400", hash_original_method = "C989154112CE4F835859D145255931FC", hash_generated_method = "4B360F4507E7FB7059D0929D4BD53119")
    @DSModeled(DSC.SAFE)
     void setRemoveOnCancelPolicy(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //removeOnCancel = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.807 -0400", hash_original_method = "3215CF4E7E81ACD4FCE62CEA9B692D35", hash_generated_method = "2DC27C3236D3C1C3324578176581FB06")
    @DSModeled(DSC.SAFE)
     boolean getRemoveOnCancelPolicy() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeOnCancel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.807 -0400", hash_original_method = "06AE3A71ACDF5D94BFF2BA3486ECC61C", hash_generated_method = "F4BC997EF9BFFD2417FE8194C56E3FA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdown() {
        super.shutdown();
        // ---------- Original Method ----------
        //super.shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.808 -0400", hash_original_method = "58CAE4CD18062B6710EA14E24E67D3BE", hash_generated_method = "8BE8EF2467A5935A6CEBDB2EB3374739")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<Runnable> shutdownNow() {
        List<Runnable> varD28DFF58106C5AD6C738FC25714B560F_537441685 = (super.shutdownNow());
        return (List<Runnable>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.shutdownNow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.808 -0400", hash_original_method = "161D6A52B7D27778B4A9C4AAA82FE7A8", hash_generated_method = "72E2200AA372094B8EBC8185A2EC2586")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BlockingQueue<Runnable> getQueue() {
        BlockingQueue<Runnable> var10FB945BD87D8640236F3DEF34A8B0E1_576723159 = (super.getQueue());
        return (BlockingQueue<Runnable>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.getQueue();
    }

    
    private class ScheduledFutureTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
        private long sequenceNumber;
        private long time;
        private long period;
        RunnableScheduledFuture<V> outerTask = this;
        int heapIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.808 -0400", hash_original_method = "6D6FE21BC02E4EEDE50A66A758AADBC3", hash_generated_method = "D1F0CB12F498A9BF1EAC7860C46A6617")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ScheduledFutureTask(Runnable r, V result, long ns) {
            super(r, result);
            dsTaint.addTaint(result.dsTaint);
            dsTaint.addTaint(ns);
            dsTaint.addTaint(r.dsTaint);
            this.period = 0;
            this.sequenceNumber = sequencer.getAndIncrement();
            // ---------- Original Method ----------
            //this.time = ns;
            //this.period = 0;
            //this.sequenceNumber = sequencer.getAndIncrement();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.808 -0400", hash_original_method = "E04B804C1814B5C9E0689952B28AE769", hash_generated_method = "53B71ADB88CFAA911AC347716166F066")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ScheduledFutureTask(Runnable r, V result, long ns, long period) {
            super(r, result);
            dsTaint.addTaint(result.dsTaint);
            dsTaint.addTaint(ns);
            dsTaint.addTaint(r.dsTaint);
            dsTaint.addTaint(period);
            this.sequenceNumber = sequencer.getAndIncrement();
            // ---------- Original Method ----------
            //this.time = ns;
            //this.period = period;
            //this.sequenceNumber = sequencer.getAndIncrement();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.808 -0400", hash_original_method = "E88D028A2F4D25267A398506CBA854E6", hash_generated_method = "468FAB67F811688F7D11A791A4AAE485")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ScheduledFutureTask(Callable<V> callable, long ns) {
            super(callable);
            dsTaint.addTaint(ns);
            dsTaint.addTaint(callable.dsTaint);
            this.period = 0;
            this.sequenceNumber = sequencer.getAndIncrement();
            // ---------- Original Method ----------
            //this.time = ns;
            //this.period = 0;
            //this.sequenceNumber = sequencer.getAndIncrement();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.809 -0400", hash_original_method = "EA844DF3AD76AAE2032057524EEDD497", hash_generated_method = "C2C806C7CB734A13B86EBE504679D88D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long getDelay(TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            long varC4B119B969BAB4F86949605FEAAFF2DA_1411670841 = (unit.convert(time - now(), TimeUnit.NANOSECONDS));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return unit.convert(time - now(), TimeUnit.NANOSECONDS);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.809 -0400", hash_original_method = "3DDFB5C452DB9F58801DAD45AC132180", hash_generated_method = "4548490FC37962F0A50F37686A577ED6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compareTo(Delayed other) {
            dsTaint.addTaint(other.dsTaint);
            {
                boolean varEBAA9C88926E0374801C3AD978616673_313957041 = (other == this);
            } //End collapsed parenthetic
            {
                ScheduledFutureTask<?> x;
                x = (ScheduledFutureTask<?>)other;
                long diff;
                diff = time - x.time;
            } //End block
            long d;
            d = (getDelay(TimeUnit.NANOSECONDS) -
                      other.getDelay(TimeUnit.NANOSECONDS));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (other == this) 
                //return 0;
            //if (other instanceof ScheduledFutureTask) {
                //ScheduledFutureTask<?> x = (ScheduledFutureTask<?>)other;
                //long diff = time - x.time;
                //if (diff < 0)
                    //return -1;
                //else if (diff > 0)
                    //return 1;
                //else if (sequenceNumber < x.sequenceNumber)
                    //return -1;
                //else
                    //return 1;
            //}
            //long d = (getDelay(TimeUnit.NANOSECONDS) -
                      //other.getDelay(TimeUnit.NANOSECONDS));
            //return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.809 -0400", hash_original_method = "28936E7BC66C2ACF8A84332D0E4F56D6", hash_generated_method = "5F294FEF31F7D7EE24E91F8E2A59D5B3")
        @DSModeled(DSC.SAFE)
        public boolean isPeriodic() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return period != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.809 -0400", hash_original_method = "AD0F8B1CE8B17F01519D37E93CCE792B", hash_generated_method = "DBD718E3271DFDABF126A92DF3EE9F6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void setNextRunTime() {
            long p;
            p = period;
            time += p;
            time = triggerTime(-p);
            // ---------- Original Method ----------
            //long p = period;
            //if (p > 0)
                //time += p;
            //else
                //time = triggerTime(-p);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.809 -0400", hash_original_method = "A46BB14AFBF2EAB15C2BA654B07B241E", hash_generated_method = "601A3D0E13F437A2E9BD051D4A40B7CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean cancel(boolean mayInterruptIfRunning) {
            dsTaint.addTaint(mayInterruptIfRunning);
            boolean cancelled;
            cancelled = super.cancel(mayInterruptIfRunning);
            remove(this);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //boolean cancelled = super.cancel(mayInterruptIfRunning);
            //if (cancelled && removeOnCancel && heapIndex >= 0)
                //remove(this);
            //return cancelled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.810 -0400", hash_original_method = "A673F57B6994AD18C8F1F59AB6BC8846", hash_generated_method = "8EFFB6D986A76092237280740B4534D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            boolean periodic;
            periodic = isPeriodic();
            {
                boolean var37C260D1D1CB5998B8FB395425A46855_1010695899 = (!canRunInCurrentRunState(periodic));
                cancel(false);
                ScheduledFutureTask.super.run();
                {
                    boolean varFE418E2F5A0C160FF79CF8CDC517BDAA_1036041480 = (ScheduledFutureTask.super.runAndReset());
                    {
                        setNextRunTime();
                        reExecutePeriodic(outerTask);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //boolean periodic = isPeriodic();
            //if (!canRunInCurrentRunState(periodic))
                //cancel(false);
            //else if (!periodic)
                //ScheduledFutureTask.super.run();
            //else if (ScheduledFutureTask.super.runAndReset()) {
                //setNextRunTime();
                //reExecutePeriodic(outerTask);
            //}
        }

        
    }


    
    static class DelayedWorkQueue extends AbstractQueue<Runnable> implements BlockingQueue<Runnable> {
        private RunnableScheduledFuture[] queue =
            new RunnableScheduledFuture[INITIAL_CAPACITY];
        private ReentrantLock lock = new ReentrantLock();
        private int size = 0;
        private Thread leader = null;
        private Condition available = lock.newCondition();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.810 -0400", hash_original_method = "CA4104F6A0D0820E4453684AC83B46A0", hash_generated_method = "CA4104F6A0D0820E4453684AC83B46A0")
                public DelayedWorkQueue ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.811 -0400", hash_original_method = "871562DD277C0AC8BA441D82903E861A", hash_generated_method = "208D5BBF4E9BCC45E7A3BEBC3786584A")
        @DSModeled(DSC.SAFE)
        private void setIndex(RunnableScheduledFuture f, int idx) {
            dsTaint.addTaint(f.dsTaint);
            dsTaint.addTaint(idx);
            ((ScheduledFutureTask)f).heapIndex = idx;
            // ---------- Original Method ----------
            //if (f instanceof ScheduledFutureTask)
                //((ScheduledFutureTask)f).heapIndex = idx;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.811 -0400", hash_original_method = "82039C4DF7CA25BEE85708617CA17C0A", hash_generated_method = "89770EC5FBC8E49DC35C494F8FEAC2DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void siftUp(int k, RunnableScheduledFuture key) {
            dsTaint.addTaint(k);
            dsTaint.addTaint(key.dsTaint);
            {
                int parent;
                parent = (k - 1) >>> 1;
                RunnableScheduledFuture e;
                e = queue[parent];
                {
                    boolean varC4C5D1172CD54B7DA5B4B3D658159E80_242910252 = (key.compareTo(e) >= 0);
                } //End collapsed parenthetic
                queue[k] = e;
                setIndex(e, k);
                k = parent;
            } //End block
            queue[k] = key;
            setIndex(key, k);
            // ---------- Original Method ----------
            //while (k > 0) {
                //int parent = (k - 1) >>> 1;
                //RunnableScheduledFuture e = queue[parent];
                //if (key.compareTo(e) >= 0)
                    //break;
                //queue[k] = e;
                //setIndex(e, k);
                //k = parent;
            //}
            //queue[k] = key;
            //setIndex(key, k);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.812 -0400", hash_original_method = "2B1F11A0F086CDEBFE52E8E81BF54F43", hash_generated_method = "23B46457770B6B5CBD8544788ADFAF87")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void siftDown(int k, RunnableScheduledFuture key) {
            dsTaint.addTaint(k);
            dsTaint.addTaint(key.dsTaint);
            int half;
            half = size >>> 1;
            {
                int child;
                child = (k << 1) + 1;
                RunnableScheduledFuture c;
                c = queue[child];
                int right;
                right = child + 1;
                {
                    boolean var7E86A53F0AFEB1BC3F88CC41D31B2A33_2114390673 = (right < size && c.compareTo(queue[right]) > 0);
                    c = queue[child = right];
                } //End collapsed parenthetic
                {
                    boolean var7F16288BED19CE15B51BB4F575E3252F_852984213 = (key.compareTo(c) <= 0);
                } //End collapsed parenthetic
                queue[k] = c;
                setIndex(c, k);
                k = child;
            } //End block
            queue[k] = key;
            setIndex(key, k);
            // ---------- Original Method ----------
            //int half = size >>> 1;
            //while (k < half) {
                //int child = (k << 1) + 1;
                //RunnableScheduledFuture c = queue[child];
                //int right = child + 1;
                //if (right < size && c.compareTo(queue[right]) > 0)
                    //c = queue[child = right];
                //if (key.compareTo(c) <= 0)
                    //break;
                //queue[k] = c;
                //setIndex(c, k);
                //k = child;
            //}
            //queue[k] = key;
            //setIndex(key, k);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.812 -0400", hash_original_method = "A3FC13DF1E683960EBCF25B1C68B6117", hash_generated_method = "ED72AC44B6E1AAC3A52FA92705947288")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void grow() {
            int oldCapacity;
            oldCapacity = queue.length;
            int newCapacity;
            newCapacity = oldCapacity + (oldCapacity >> 1);
            newCapacity = Integer.MAX_VALUE;
            queue = Arrays.copyOf(queue, newCapacity);
            // ---------- Original Method ----------
            //int oldCapacity = queue.length;
            //int newCapacity = oldCapacity + (oldCapacity >> 1);
            //if (newCapacity < 0) 
                //newCapacity = Integer.MAX_VALUE;
            //queue = Arrays.copyOf(queue, newCapacity);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.813 -0400", hash_original_method = "C580641A4A2388B58215BACCB42FFCE3", hash_generated_method = "3AA62C0E5CF798F7158EE5E7A9BCBC93")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int indexOf(Object x) {
            dsTaint.addTaint(x.dsTaint);
            {
                {
                    int i;
                    i = ((ScheduledFutureTask) x).heapIndex;
                } //End block
                {
                    {
                        int i;
                        i = 0;
                        {
                            boolean varB28D373523DC4FB5420385081303E702_851163571 = (x.equals(queue[i]));
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (x != null) {
                //if (x instanceof ScheduledFutureTask) {
                    //int i = ((ScheduledFutureTask) x).heapIndex;
                    //if (i >= 0 && i < size && queue[i] == x)
                        //return i;
                //} else {
                    //for (int i = 0; i < size; i++)
                        //if (x.equals(queue[i]))
                            //return i;
                //}
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.814 -0400", hash_original_method = "5E09E7103DB0A49A13B2DDAFBB485D60", hash_generated_method = "24A60D86ACC52932CA558EA8C909E45B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean contains(Object x) {
            dsTaint.addTaint(x.dsTaint);
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                boolean var50987CC635D4EF59A4064B2DDB6782AF_1840611519 = (indexOf(x) != -1);
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return indexOf(x) != -1;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.814 -0400", hash_original_method = "BE80A65233BEEC20C44EE13577B8F6B3", hash_generated_method = "31492DC09A8AAA21C4CC95A4C6225E1B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean remove(Object x) {
            dsTaint.addTaint(x.dsTaint);
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                int i;
                i = indexOf(x);
                setIndex(queue[i], -1);
                int s;
                s = --size;
                RunnableScheduledFuture replacement;
                replacement = queue[s];
                queue[s] = null;
                {
                    siftDown(i, replacement);
                    siftUp(i, replacement);
                } //End block
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //int i = indexOf(x);
                //if (i < 0)
                    //return false;
                //setIndex(queue[i], -1);
                //int s = --size;
                //RunnableScheduledFuture replacement = queue[s];
                //queue[s] = null;
                //if (s != i) {
                    //siftDown(i, replacement);
                    //if (queue[i] == replacement)
                        //siftUp(i, replacement);
                //}
                //return true;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.815 -0400", hash_original_method = "FB53A461CD3B1BACC3DB27D415F5CC64", hash_generated_method = "CF8C7BB1690AA67A2055BF9A050F87F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int size() {
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return size;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.815 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "15C50960A7B44863F5E4B74CCEAD190D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isEmpty() {
            boolean var5A234584F0C312DA2BE9DBC07A5ED4AF_744046917 = (size() == 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return size() == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.815 -0400", hash_original_method = "E7CDD1D543D1F61B1D969765A4629893", hash_generated_method = "8E1A081DA1DF6F1CC1200F550EDCDB06")
        @DSModeled(DSC.SAFE)
        public int remainingCapacity() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Integer.MAX_VALUE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.815 -0400", hash_original_method = "71D771244E4BD1C0173C42068DB81D51", hash_generated_method = "C9B92098611BF4E28A8F8A84181A7301")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RunnableScheduledFuture peek() {
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            return (RunnableScheduledFuture)dsTaint.getTaint();
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return queue[0];
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.816 -0400", hash_original_method = "A5863DDF2D55F0A792F5570CB9552D10", hash_generated_method = "A36A33DF30BA59FA1924F62B622FD8B6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean offer(Runnable x) {
            dsTaint.addTaint(x.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            RunnableScheduledFuture e;
            e = (RunnableScheduledFuture)x;
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                int i;
                i = size;
                grow();
                size = i + 1;
                {
                    queue[0] = e;
                    setIndex(e, 0);
                } //End block
                {
                    siftUp(i, e);
                } //End block
                {
                    leader = null;
                    available.signal();
                } //End block
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (x == null)
                //throw new NullPointerException();
            //RunnableScheduledFuture e = (RunnableScheduledFuture)x;
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //int i = size;
                //if (i >= queue.length)
                    //grow();
                //size = i + 1;
                //if (i == 0) {
                    //queue[0] = e;
                    //setIndex(e, 0);
                //} else {
                    //siftUp(i, e);
                //}
                //if (queue[0] == e) {
                    //leader = null;
                    //available.signal();
                //}
            //} finally {
                //lock.unlock();
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.816 -0400", hash_original_method = "4080BF206CA14D39406126FB9F6C27D2", hash_generated_method = "7863B059B91F0AA6B29E367A1A62ED9B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void put(Runnable e) {
            dsTaint.addTaint(e.dsTaint);
            offer(e);
            // ---------- Original Method ----------
            //offer(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.816 -0400", hash_original_method = "AD0F5DE8A091A43B7107BCF4BE0853B5", hash_generated_method = "E2C3177D8DB77AE0D3F0FD9ED80EE844")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean add(Runnable e) {
            dsTaint.addTaint(e.dsTaint);
            boolean varE46C21D833DB059BB8F6E49CAFEACF2D_506318883 = (offer(e));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return offer(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.816 -0400", hash_original_method = "C6567B4A0AA1C7B283CF9843CADA74F7", hash_generated_method = "BF7F4EE9C3D0207E1EAF3D7F3E6DC295")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean offer(Runnable e, long timeout, TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(timeout);
            boolean varE46C21D833DB059BB8F6E49CAFEACF2D_1498960333 = (offer(e));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return offer(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.816 -0400", hash_original_method = "95AFA75D0998C104C226840186514FC9", hash_generated_method = "F6C798CF7441CDB175E0BBE1EA0F0EB2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RunnableScheduledFuture finishPoll(RunnableScheduledFuture f) {
            dsTaint.addTaint(f.dsTaint);
            int s;
            s = --size;
            RunnableScheduledFuture x;
            x = queue[s];
            queue[s] = null;
            siftDown(0, x);
            setIndex(f, -1);
            return (RunnableScheduledFuture)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int s = --size;
            //RunnableScheduledFuture x = queue[s];
            //queue[s] = null;
            //if (s != 0)
                //siftDown(0, x);
            //setIndex(f, -1);
            //return f;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.817 -0400", hash_original_method = "8EBCD245EA652A524E679A63C787A99C", hash_generated_method = "37D0FAA0B3C3AC5280FEE706CBD05978")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RunnableScheduledFuture poll() {
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                RunnableScheduledFuture first;
                first = queue[0];
                {
                    boolean var5A3EA0F41303197B859A517B5ABCDA38_773866566 = (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0);
                    RunnableScheduledFuture varFB9D12AA31F8B38E437D2FD9AF07D1F2_1230932405 = (finishPoll(first));
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            return (RunnableScheduledFuture)dsTaint.getTaint();
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //RunnableScheduledFuture first = queue[0];
                //if (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0)
                    //return null;
                //else
                    //return finishPoll(first);
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.817 -0400", hash_original_method = "C35B04B198E2C5886DA81FEFBA3F2D77", hash_generated_method = "3CA2FBFCFF59FC93859B18763E846CEC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RunnableScheduledFuture take() throws InterruptedException {
            ReentrantLock lock;
            lock = this.lock;
            lock.lockInterruptibly();
            try 
            {
                {
                    RunnableScheduledFuture first;
                    first = queue[0];
                    available.await();
                    {
                        long delay;
                        delay = first.getDelay(TimeUnit.NANOSECONDS);
                        RunnableScheduledFuture varAC0A651D39DE926A4DF6E0B2BA54A3AC_1401670064 = (finishPoll(first));
                        available.await();
                        {
                            Thread thisThread;
                            thisThread = Thread.currentThread();
                            leader = thisThread;
                            try 
                            {
                                available.awaitNanos(delay);
                            } //End block
                            finally 
                            {
                                leader = null;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
                available.signal();
                lock.unlock();
            } //End block
            return (RunnableScheduledFuture)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.818 -0400", hash_original_method = "72DE523456D313A78DBDBA042B83CE23", hash_generated_method = "17659DD60EAB28E06027E5B63EBD2E04")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RunnableScheduledFuture poll(long timeout, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout);
            long nanos;
            nanos = unit.toNanos(timeout);
            ReentrantLock lock;
            lock = this.lock;
            lock.lockInterruptibly();
            try 
            {
                {
                    RunnableScheduledFuture first;
                    first = queue[0];
                    {
                        nanos = available.awaitNanos(nanos);
                    } //End block
                    {
                        long delay;
                        delay = first.getDelay(TimeUnit.NANOSECONDS);
                        RunnableScheduledFuture varAC0A651D39DE926A4DF6E0B2BA54A3AC_1183748417 = (finishPoll(first));
                        nanos = available.awaitNanos(nanos);
                        {
                            Thread thisThread;
                            thisThread = Thread.currentThread();
                            leader = thisThread;
                            try 
                            {
                                long timeLeft;
                                timeLeft = available.awaitNanos(delay);
                                nanos -= delay - timeLeft;
                            } //End block
                            finally 
                            {
                                leader = null;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
                available.signal();
                lock.unlock();
            } //End block
            return (RunnableScheduledFuture)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.818 -0400", hash_original_method = "B7A92D7F07FC88CC462E2031E3EC4D97", hash_generated_method = "AC678A42861AD374BE53722278D25AEA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clear() {
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                {
                    int i;
                    i = 0;
                    {
                        RunnableScheduledFuture t;
                        t = queue[i];
                        {
                            queue[i] = null;
                            setIndex(t, -1);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                size = 0;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //for (int i = 0; i < size; i++) {
                    //RunnableScheduledFuture t = queue[i];
                    //if (t != null) {
                        //queue[i] = null;
                        //setIndex(t, -1);
                    //}
                //}
                //size = 0;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.818 -0400", hash_original_method = "2FE630D35A7B40B0A6753A3386B27535", hash_generated_method = "EB4DAAE41F2D5FB847E45E6F0DD4D4B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private RunnableScheduledFuture pollExpired() {
            RunnableScheduledFuture first;
            first = queue[0];
            {
                boolean varDBDDC81EE2A47102CBC7EDC3FD3B2190_2099833517 = (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0);
            } //End collapsed parenthetic
            RunnableScheduledFuture var05AD8B2DD2E45C890C14C77807DCD3EB_470451675 = (finishPoll(first));
            return (RunnableScheduledFuture)dsTaint.getTaint();
            // ---------- Original Method ----------
            //RunnableScheduledFuture first = queue[0];
            //if (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0)
                //return null;
            //return finishPoll(first);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.819 -0400", hash_original_method = "A0CF55F6497A110CDDFF356DE0AE8664", hash_generated_method = "6E0DA38FCA2B0ED9170AC5B4CB26C631")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int drainTo(Collection<? super Runnable> c) {
            dsTaint.addTaint(c.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            {
                boolean varBA1311186045D728773ECE86BC5E0754_1329936515 = (c == this);
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End collapsed parenthetic
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                RunnableScheduledFuture first;
                int n;
                n = 0;
                {
                    boolean varE67564F86D6C2E56821D82C2AB67713B_10068177 = ((first = pollExpired()) != null);
                    {
                        c.add(first);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (c == null)
                //throw new NullPointerException();
            //if (c == this)
                //throw new IllegalArgumentException();
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //RunnableScheduledFuture first;
                //int n = 0;
                //while ((first = pollExpired()) != null) {
                    //c.add(first);
                    //++n;
                //}
                //return n;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.819 -0400", hash_original_method = "0279366BCBF84614051CBA5B08204A0A", hash_generated_method = "C9903317C86AC604A198C32EF35ABA7C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int drainTo(Collection<? super Runnable> c, int maxElements) {
            dsTaint.addTaint(c.dsTaint);
            dsTaint.addTaint(maxElements);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            {
                boolean varBA1311186045D728773ECE86BC5E0754_698494268 = (c == this);
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End collapsed parenthetic
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                RunnableScheduledFuture first;
                int n;
                n = 0;
                {
                    boolean var907F87A983490314E2E468AEABFC930D_1983178798 = (n < maxElements && (first = pollExpired()) != null);
                    {
                        c.add(first);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (c == null)
                //throw new NullPointerException();
            //if (c == this)
                //throw new IllegalArgumentException();
            //if (maxElements <= 0)
                //return 0;
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //RunnableScheduledFuture first;
                //int n = 0;
                //while (n < maxElements && (first = pollExpired()) != null) {
                    //c.add(first);
                    //++n;
                //}
                //return n;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.819 -0400", hash_original_method = "7408B58852530A87736A5AD8CAD9599F", hash_generated_method = "1D51C45BFFFDAF2ABBEB267A3650F708")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object[] toArray() {
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                Object[] varABD2400ABAD725538C105678BD644408_1108069368 = (Arrays.copyOf(queue, size, Object[].class));
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            return (Object[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return Arrays.copyOf(queue, size, Object[].class);
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.819 -0400", hash_original_method = "C537847CD06DB8C82AFD734BEA1D62C4", hash_generated_method = "2F9F7F86994B29837410E3909504956D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            dsTaint.addTaint(a[0].dsTaint);
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                T[] varEB2C982AE67C52107C9B3A8635222728_791204673 = ((T[]) Arrays.copyOf(queue, size, a.getClass()));
                System.arraycopy(queue, 0, a, 0, size);
                a[size] = null;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            return (T[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //if (a.length < size)
                    //return (T[]) Arrays.copyOf(queue, size, a.getClass());
                //System.arraycopy(queue, 0, a, 0, size);
                //if (a.length > size)
                    //a[size] = null;
                //return a;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.820 -0400", hash_original_method = "46B1FB64DFD489BA9D84B29257E9B6C6", hash_generated_method = "3651643D05DA04C676870A544C956DEC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<Runnable> iterator() {
            Iterator<Runnable> varC240D99506260118421B83B95236CE78_1189156108 = (new Itr(Arrays.copyOf(queue, size)));
            return (Iterator<Runnable>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Itr(Arrays.copyOf(queue, size));
        }

        
        private class Itr implements Iterator<Runnable> {
            RunnableScheduledFuture[] array;
            int cursor = 0;
            int lastRet = -1;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.820 -0400", hash_original_method = "78BE11BC04A59F667BA3E745B91EA864", hash_generated_method = "38109F23B4C0C566653076C4BE4BEEB5")
            @DSModeled(DSC.SAFE)
             Itr(RunnableScheduledFuture[] array) {
                dsTaint.addTaint(array[0].dsTaint);
                // ---------- Original Method ----------
                //this.array = array;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.820 -0400", hash_original_method = "C1264B905CC60CA39EE5BE51F177AC9A", hash_generated_method = "660D36E321FC94AE74E98EFA1F92EF77")
            @DSModeled(DSC.SAFE)
            public boolean hasNext() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return cursor < array.length;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.820 -0400", hash_original_method = "3D0866C62F631AE1F3281A9951BE6C06", hash_generated_method = "E6B978AF5FB7A66A5F88A25AFCF3EAC6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public Runnable next() {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                lastRet = cursor;
                return (Runnable)dsTaint.getTaint();
                // ---------- Original Method ----------
                //if (cursor >= array.length)
                    //throw new NoSuchElementException();
                //lastRet = cursor;
                //return array[cursor++];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.820 -0400", hash_original_method = "560EEAA350DF5EAA4CBD4C138A91D642", hash_generated_method = "CE7DA7858017CF4323B5084C501777C6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void remove() {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                DelayedWorkQueue.this.remove(array[lastRet]);
                lastRet = -1;
                // ---------- Original Method ----------
                //if (lastRet < 0)
                    //throw new IllegalStateException();
                //DelayedWorkQueue.this.remove(array[lastRet]);
                //lastRet = -1;
            }

            
        }


        
        private static final int INITIAL_CAPACITY = 16;
    }


    
    private static final AtomicLong sequencer = new AtomicLong(0);
}

