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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.484 -0400", hash_original_field = "16F5A356C77125C2C156C9F6B6F49691", hash_generated_field = "AA2F9CF8A8BDA098B7353794A7890F68")

    private volatile boolean continueExistingPeriodicTasksAfterShutdown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.484 -0400", hash_original_field = "0694CB6B95D24930C98752845302446B", hash_generated_field = "D4D52A1567899065AB02C507D671256E")

    private volatile boolean executeExistingDelayedTasksAfterShutdown = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.485 -0400", hash_original_field = "B9C1236F0DDAF6571DA9803B91DCBA27", hash_generated_field = "396CDA7B171456B549FE026890B28734")

    private volatile boolean removeOnCancel = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.485 -0400", hash_original_method = "D36047D4322FE6F8EBCA30AB15266BC6", hash_generated_method = "69663AB27BD1BC39635232462251E927")
    public  ScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue());
        addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.485 -0400", hash_original_method = "ABDCD4F10C893856EFE26F2C021D677A", hash_generated_method = "130B77FC63BAE145C0277FBFACBEB80B")
    public  ScheduledThreadPoolExecutor(int corePoolSize,
                                       ThreadFactory threadFactory) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), threadFactory);
        addTaint(corePoolSize);
        addTaint(threadFactory.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.486 -0400", hash_original_method = "15AFC792EAFAB8847ABF7F7AA1CDCAAC", hash_generated_method = "2DDF212A4CEAC62D600B23E1CFFD4ECF")
    public  ScheduledThreadPoolExecutor(int corePoolSize,
                                       RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), handler);
        addTaint(corePoolSize);
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.487 -0400", hash_original_method = "FA0219710575675561B4DC7EAFAB1D1D", hash_generated_method = "D0B8F2830AB960BB236CBA69820D1D95")
    public  ScheduledThreadPoolExecutor(int corePoolSize,
                                       ThreadFactory threadFactory,
                                       RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), threadFactory, handler);
        addTaint(corePoolSize);
        addTaint(threadFactory.getTaint());
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.503 -0400", hash_original_method = "5D4518F727B3B1C5CE98EBC039D9AF6B", hash_generated_method = "90824EB17834244AD651E52FE697B3C6")
    final long now() {
        long var38C9A41D4C7B496258927F1AFD7464A5_1366722664 = (System.nanoTime());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1006188770 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1006188770;
        // ---------- Original Method ----------
        //return System.nanoTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.503 -0400", hash_original_method = "43122228A318CAFA2BE5FD8EB8B7119A", hash_generated_method = "157238C874E69718E5842398C88D6CCB")
     boolean canRunInCurrentRunState(boolean periodic) {
        boolean var636123F330B288C0794F274F6243222D_2074264739 = (isRunningOrShutdown(periodic ?
                                   continueExistingPeriodicTasksAfterShutdown :
                                   executeExistingDelayedTasksAfterShutdown)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(periodic);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535292195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535292195;
        // ---------- Original Method ----------
        //return isRunningOrShutdown(periodic ?
                                   //continueExistingPeriodicTasksAfterShutdown :
                                   //executeExistingDelayedTasksAfterShutdown);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.504 -0400", hash_original_method = "74BC2A8347918586B07692C369988E7C", hash_generated_method = "F52CFE289564E2DFB52069D3012FB217")
    private void delayedExecute(RunnableScheduledFuture<?> task) {
        {
            boolean varD7D6F17835B9DE02DC18908B63864E97_114728053 = (isShutdown());
            reject(task);
            {
                super.getQueue().add(task);
                {
                    boolean var9F93D657B4AB08D4C240833C5152DDD5_371146561 = (isShutdown() &&
                !canRunInCurrentRunState(task.isPeriodic()) &&
                remove(task));
                    task.cancel(false);
                    prestartCoreThread();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(task.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.504 -0400", hash_original_method = "0C685B50A598B045820F5EF901D2AED6", hash_generated_method = "761651661C9F68FE55CD5799519878BA")
     void reExecutePeriodic(RunnableScheduledFuture<?> task) {
        {
            boolean var2689F2A799548532A8E160831E5A33A8_846835728 = (canRunInCurrentRunState(true));
            {
                super.getQueue().add(task);
                {
                    boolean var471B5F2C64914A5472B62C3F29896BF1_102627154 = (!canRunInCurrentRunState(true) && remove(task));
                    task.cancel(false);
                    prestartCoreThread();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(task.getTaint());
        // ---------- Original Method ----------
        //if (canRunInCurrentRunState(true)) {
            //super.getQueue().add(task);
            //if (!canRunInCurrentRunState(true) && remove(task))
                //task.cancel(false);
            //else
                //prestartCoreThread();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.603 -0400", hash_original_method = "64FA3598D4BDF802451AB41ACA7E6BE8", hash_generated_method = "ACA02556633FACB65BD78614B3566716")
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
                            boolean varF7F2675F0606E27C21A93E064C27288B_848658629 = ((t.isPeriodic() ? !keepPeriodic : !keepDelayed) ||
                        t.isCancelled()); //DSFIXME:  CODE0008: Nested ternary operator in expression
                            {
                                {
                                    boolean varBEBF9C2A16974119BECC96CE9B7D06C1_1772663578 = (q.remove(t));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.604 -0400", hash_original_method = "2D7E8C9964120FA3F638C1BFE2958CB1", hash_generated_method = "62BF3DA585A99953F75BF5B17C1EB8D3")
    protected <V> RunnableScheduledFuture<V> decorateTask(
        Runnable runnable, RunnableScheduledFuture<V> task) {
        RunnableScheduledFuture<V> varB4EAC82CA7396A68D541C85D26508E83_816804272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_816804272 = task;
        addTaint(runnable.getTaint());
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_816804272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_816804272;
        // ---------- Original Method ----------
        //return task;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.723 -0400", hash_original_method = "5DBE5BBA8D9EF484681F4C8336F1600B", hash_generated_method = "22C7A93CFDA65FB32766CB8D1D9CE4E5")
    protected <V> RunnableScheduledFuture<V> decorateTask(
        Callable<V> callable, RunnableScheduledFuture<V> task) {
        RunnableScheduledFuture<V> varB4EAC82CA7396A68D541C85D26508E83_529961094 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_529961094 = task;
        addTaint(callable.getTaint());
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_529961094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_529961094;
        // ---------- Original Method ----------
        //return task;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.724 -0400", hash_original_method = "14F5A42293D1200CF8E952E9DCB67B90", hash_generated_method = "E6ECB3E9CDE0A51A27F6B65550CA84A9")
    private long triggerTime(long delay, TimeUnit unit) {
        long var921EC63E99B1B0D90270C7CCF06C4834_1508940695 = (triggerTime(unit.toNanos((delay < 0) ? 0 : delay))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(delay);
        addTaint(unit.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_986448936 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_986448936;
        // ---------- Original Method ----------
        //return triggerTime(unit.toNanos((delay < 0) ? 0 : delay));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.725 -0400", hash_original_method = "43548DFC0EE197F487A673EC89A4A123", hash_generated_method = "36A36D90571D56641FE9B5D913D9BDD0")
     long triggerTime(long delay) {
        long var9E9C1F7E6FCC2FB90620873C1CB2CFB4_569886698 = (now() +
            ((delay < (Long.MAX_VALUE >> 1)) ? delay : overflowFree(delay))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(delay);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_986237361 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_986237361;
        // ---------- Original Method ----------
        //return now() +
            //((delay < (Long.MAX_VALUE >> 1)) ? delay : overflowFree(delay));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.725 -0400", hash_original_method = "7169306CF31D42FCC72896372081E078", hash_generated_method = "18C9240D5D2B43B63C0E535D6CB35FBC")
    private long overflowFree(long delay) {
        Delayed head;
        head = (Delayed) super.getQueue().peek();
        {
            long headDelay;
            headDelay = head.getDelay(TimeUnit.NANOSECONDS);
            delay = Long.MAX_VALUE + headDelay;
        } //End block
        addTaint(delay);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1110119214 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1110119214;
        // ---------- Original Method ----------
        //Delayed head = (Delayed) super.getQueue().peek();
        //if (head != null) {
            //long headDelay = head.getDelay(TimeUnit.NANOSECONDS);
            //if (headDelay < 0 && (delay - headDelay < 0))
                //delay = Long.MAX_VALUE + headDelay;
        //}
        //return delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.733 -0400", hash_original_method = "E8C91BC5CFBE81CC8958800A4E70C4DA", hash_generated_method = "B1C5DDE9148F56BA34ACEAAC4B168476")
    public ScheduledFuture<?> schedule(Runnable command,
                                       long delay,
                                       TimeUnit unit) {
        ScheduledFuture<?> varB4EAC82CA7396A68D541C85D26508E83_1190791653 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableScheduledFuture<?> t;
        t = decorateTask(command,
            new ScheduledFutureTask<Void>(command, null,
                                          triggerTime(delay, unit)));
        delayedExecute(t);
        varB4EAC82CA7396A68D541C85D26508E83_1190791653 = t;
        addTaint(command.getTaint());
        addTaint(delay);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1190791653.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1190791653;
        // ---------- Original Method ----------
        //if (command == null || unit == null)
            //throw new NullPointerException();
        //RunnableScheduledFuture<?> t = decorateTask(command,
            //new ScheduledFutureTask<Void>(command, null,
                                          //triggerTime(delay, unit)));
        //delayedExecute(t);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.733 -0400", hash_original_method = "3CA816B6292CC3DABD4A8E9E190B6332", hash_generated_method = "F416B983E48A888105E06A341B9886EE")
    public <V> ScheduledFuture<V> schedule(Callable<V> callable,
                                           long delay,
                                           TimeUnit unit) {
        ScheduledFuture<V> varB4EAC82CA7396A68D541C85D26508E83_1963670819 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        RunnableScheduledFuture<V> t;
        t = decorateTask(callable,
            new ScheduledFutureTask<V>(callable,
                                       triggerTime(delay, unit)));
        delayedExecute(t);
        varB4EAC82CA7396A68D541C85D26508E83_1963670819 = t;
        addTaint(callable.getTaint());
        addTaint(delay);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1963670819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1963670819;
        // ---------- Original Method ----------
        //if (callable == null || unit == null)
            //throw new NullPointerException();
        //RunnableScheduledFuture<V> t = decorateTask(callable,
            //new ScheduledFutureTask<V>(callable,
                                       //triggerTime(delay, unit)));
        //delayedExecute(t);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.740 -0400", hash_original_method = "8D8E5BFEEBAD4838EB16FA502AD719D4", hash_generated_method = "AC48BB2579258196BE8878A084424563")
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay,
                                                  long period,
                                                  TimeUnit unit) {
        ScheduledFuture<?> varB4EAC82CA7396A68D541C85D26508E83_458442591 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_458442591 = t;
        addTaint(command.getTaint());
        addTaint(initialDelay);
        addTaint(period);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_458442591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_458442591;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.741 -0400", hash_original_method = "F8BFEFA210F26533C5765CF5137E2FD3", hash_generated_method = "4266F300C3A14A0FE9F7CBCFA00ECECA")
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
                                                     long initialDelay,
                                                     long delay,
                                                     TimeUnit unit) {
        ScheduledFuture<?> varB4EAC82CA7396A68D541C85D26508E83_165453218 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_165453218 = t;
        addTaint(command.getTaint());
        addTaint(initialDelay);
        addTaint(delay);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_165453218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_165453218;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.741 -0400", hash_original_method = "106B54169234F208DA4A1738F707D69C", hash_generated_method = "D765A7303691684BA3630E616406D49C")
    public void execute(Runnable command) {
        schedule(command, 0, TimeUnit.NANOSECONDS);
        addTaint(command.getTaint());
        // ---------- Original Method ----------
        //schedule(command, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.741 -0400", hash_original_method = "71AB87E2E6647A80EF75456B59FD870B", hash_generated_method = "C1A404F7F78F249C42A626C3047F071B")
    public Future<?> submit(Runnable task) {
        Future<?> varB4EAC82CA7396A68D541C85D26508E83_1631576609 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1631576609 = schedule(task, 0, TimeUnit.NANOSECONDS);
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1631576609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1631576609;
        // ---------- Original Method ----------
        //return schedule(task, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.742 -0400", hash_original_method = "A2BAF492547813A1B4B6DC556E74F888", hash_generated_method = "66A41A04D99ACC474CAB9A26CD3685E7")
    public <T> Future<T> submit(Runnable task, T result) {
        Future<T> varB4EAC82CA7396A68D541C85D26508E83_1929381102 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1929381102 = schedule(Executors.callable(task, result),
                        0, TimeUnit.NANOSECONDS);
        addTaint(task.getTaint());
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1929381102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1929381102;
        // ---------- Original Method ----------
        //return schedule(Executors.callable(task, result),
                        //0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.742 -0400", hash_original_method = "7532879CEC1557BEB821686E164CE854", hash_generated_method = "2AC7B309D857483DA035CA80D073C021")
    public <T> Future<T> submit(Callable<T> task) {
        Future<T> varB4EAC82CA7396A68D541C85D26508E83_409520801 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_409520801 = schedule(task, 0, TimeUnit.NANOSECONDS);
        addTaint(task.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_409520801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_409520801;
        // ---------- Original Method ----------
        //return schedule(task, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.743 -0400", hash_original_method = "4AFC27553B47AB13DBA25E0474D83429", hash_generated_method = "2AE8E0C0B9AC07A95C2C847190B6DE18")
    public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean value) {
        continueExistingPeriodicTasksAfterShutdown = value;
        {
            boolean varD7CCA429FE7709242F7FBD82DD2F415D_1672040595 = (!value && isShutdown());
            onShutdown();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //continueExistingPeriodicTasksAfterShutdown = value;
        //if (!value && isShutdown())
            //onShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.743 -0400", hash_original_method = "23365684DD383694198E6F21D088C23A", hash_generated_method = "9DCD2161A4035D48DD34AC4E2E4A633B")
    public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043893823 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043893823;
        // ---------- Original Method ----------
        //return continueExistingPeriodicTasksAfterShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.743 -0400", hash_original_method = "DDF8C3EFAF4531B367BDE4CC570E21D4", hash_generated_method = "AD3ACDD6C91DEF4B98C58A73B935273F")
    public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean value) {
        executeExistingDelayedTasksAfterShutdown = value;
        {
            boolean varD7CCA429FE7709242F7FBD82DD2F415D_764520471 = (!value && isShutdown());
            onShutdown();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //executeExistingDelayedTasksAfterShutdown = value;
        //if (!value && isShutdown())
            //onShutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.744 -0400", hash_original_method = "691F6AED1700735267010AB69287CBB5", hash_generated_method = "7D71FFC7268746011357099012A26257")
    public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133320058 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_133320058;
        // ---------- Original Method ----------
        //return executeExistingDelayedTasksAfterShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.771 -0400", hash_original_method = "C989154112CE4F835859D145255931FC", hash_generated_method = "8187F71188C5442EF4B01CC9510CDCEB")
     void setRemoveOnCancelPolicy(boolean value) {
        removeOnCancel = value;
        // ---------- Original Method ----------
        //removeOnCancel = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.773 -0400", hash_original_method = "3215CF4E7E81ACD4FCE62CEA9B692D35", hash_generated_method = "F785A8B0243D1B20BCBF7EAE20246EE4")
     boolean getRemoveOnCancelPolicy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832845139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832845139;
        // ---------- Original Method ----------
        //return removeOnCancel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.773 -0400", hash_original_method = "06AE3A71ACDF5D94BFF2BA3486ECC61C", hash_generated_method = "F4BC997EF9BFFD2417FE8194C56E3FA6")
    public void shutdown() {
        super.shutdown();
        // ---------- Original Method ----------
        //super.shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.774 -0400", hash_original_method = "58CAE4CD18062B6710EA14E24E67D3BE", hash_generated_method = "C77553EADF69947C31680E2E40DE47F3")
    public List<Runnable> shutdownNow() {
        List<Runnable> varB4EAC82CA7396A68D541C85D26508E83_463279877 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_463279877 = super.shutdownNow();
        varB4EAC82CA7396A68D541C85D26508E83_463279877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_463279877;
        // ---------- Original Method ----------
        //return super.shutdownNow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.774 -0400", hash_original_method = "161D6A52B7D27778B4A9C4AAA82FE7A8", hash_generated_method = "DACFCACCDF335081895C4679DB85698A")
    public BlockingQueue<Runnable> getQueue() {
        BlockingQueue<Runnable> varB4EAC82CA7396A68D541C85D26508E83_2123644063 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2123644063 = super.getQueue();
        varB4EAC82CA7396A68D541C85D26508E83_2123644063.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2123644063;
        // ---------- Original Method ----------
        //return super.getQueue();
    }

    
    private class ScheduledFutureTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.774 -0400", hash_original_field = "1C021ADF174562C07D271E889F46BABF", hash_generated_field = "BC5948EFF55F237F777F173C3B803F01")

        private long sequenceNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.774 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "2D21F2B1A6174F407FDE900F8B752B4F")

        private long time;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.774 -0400", hash_original_field = "A0ACFA46D86F7610B2C73DBB28F64701", hash_generated_field = "9B4C1F15D97D513A97EBCE4E8EF81345")

        private long period;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.774 -0400", hash_original_field = "AC10162ABA5F230BD320E9A8DE1FBB74", hash_generated_field = "98CF25F8111133A7EC779F1A91CDBA76")

        RunnableScheduledFuture<V> outerTask = this;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.774 -0400", hash_original_field = "14097C6719ADB60131A527E0555F6127", hash_generated_field = "B9E65256978F8C0BE4352922F453397A")

        int heapIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.775 -0400", hash_original_method = "6D6FE21BC02E4EEDE50A66A758AADBC3", hash_generated_method = "E377B4CDC4BEE9CDBBC22572EE6CBF6B")
          ScheduledFutureTask(Runnable r, V result, long ns) {
            super(r, result);
            this.time = ns;
            this.period = 0;
            this.sequenceNumber = sequencer.getAndIncrement();
            addTaint(r.getTaint());
            addTaint(result.getTaint());
            // ---------- Original Method ----------
            //this.time = ns;
            //this.period = 0;
            //this.sequenceNumber = sequencer.getAndIncrement();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.775 -0400", hash_original_method = "E04B804C1814B5C9E0689952B28AE769", hash_generated_method = "3CCDDBE08AA0D2890B228FE1DE9315BB")
          ScheduledFutureTask(Runnable r, V result, long ns, long period) {
            super(r, result);
            this.time = ns;
            this.period = period;
            this.sequenceNumber = sequencer.getAndIncrement();
            addTaint(r.getTaint());
            addTaint(result.getTaint());
            // ---------- Original Method ----------
            //this.time = ns;
            //this.period = period;
            //this.sequenceNumber = sequencer.getAndIncrement();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.776 -0400", hash_original_method = "E88D028A2F4D25267A398506CBA854E6", hash_generated_method = "882075443D1E153313D37D432B1429D1")
          ScheduledFutureTask(Callable<V> callable, long ns) {
            super(callable);
            this.time = ns;
            this.period = 0;
            this.sequenceNumber = sequencer.getAndIncrement();
            addTaint(callable.getTaint());
            // ---------- Original Method ----------
            //this.time = ns;
            //this.period = 0;
            //this.sequenceNumber = sequencer.getAndIncrement();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.776 -0400", hash_original_method = "EA844DF3AD76AAE2032057524EEDD497", hash_generated_method = "BFBDEE9F842717D3ADCA9289614D98A5")
        public long getDelay(TimeUnit unit) {
            long varC4B119B969BAB4F86949605FEAAFF2DA_687707175 = (unit.convert(time - now(), TimeUnit.NANOSECONDS));
            addTaint(unit.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_301233236 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_301233236;
            // ---------- Original Method ----------
            //return unit.convert(time - now(), TimeUnit.NANOSECONDS);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.776 -0400", hash_original_method = "3DDFB5C452DB9F58801DAD45AC132180", hash_generated_method = "C54686E644ED1866F5D6609ED868D982")
        public int compareTo(Delayed other) {
            {
                boolean varEBAA9C88926E0374801C3AD978616673_1676922445 = (other == this);
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
            addTaint(other.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514263081 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514263081;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.778 -0400", hash_original_method = "28936E7BC66C2ACF8A84332D0E4F56D6", hash_generated_method = "CB44AB21F2C5C4EF4F8EFF5EC604C29A")
        public boolean isPeriodic() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224799800 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_224799800;
            // ---------- Original Method ----------
            //return period != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.778 -0400", hash_original_method = "AD0F8B1CE8B17F01519D37E93CCE792B", hash_generated_method = "DBD718E3271DFDABF126A92DF3EE9F6A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.779 -0400", hash_original_method = "A46BB14AFBF2EAB15C2BA654B07B241E", hash_generated_method = "521950EA328574F50490DBEFA5D66810")
        public boolean cancel(boolean mayInterruptIfRunning) {
            boolean cancelled;
            cancelled = super.cancel(mayInterruptIfRunning);
            remove(this);
            addTaint(mayInterruptIfRunning);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476301638 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_476301638;
            // ---------- Original Method ----------
            //boolean cancelled = super.cancel(mayInterruptIfRunning);
            //if (cancelled && removeOnCancel && heapIndex >= 0)
                //remove(this);
            //return cancelled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.786 -0400", hash_original_method = "A673F57B6994AD18C8F1F59AB6BC8846", hash_generated_method = "DB88E9C263462C746630016C863A8310")
        public void run() {
            boolean periodic;
            periodic = isPeriodic();
            {
                boolean var37C260D1D1CB5998B8FB395425A46855_1373685138 = (!canRunInCurrentRunState(periodic));
                cancel(false);
                ScheduledFutureTask.super.run();
                {
                    boolean varFE418E2F5A0C160FF79CF8CDC517BDAA_1192892096 = (ScheduledFutureTask.super.runAndReset());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.786 -0400", hash_original_field = "61F48537D5CDD107448F51065089B906", hash_generated_field = "7E3ECE26F4AF2143E2D648A19C272D90")

        private RunnableScheduledFuture[] queue = new RunnableScheduledFuture[INITIAL_CAPACITY];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.786 -0400", hash_original_field = "CD2F0EC2CC3E15FC9F14D13EF4CCDCBB", hash_generated_field = "A6FDCB7B6B78544DFD11CBA5E98BB649")

        private ReentrantLock lock = new ReentrantLock();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.786 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "C5D9FEC4EFB462C8A221F2C08D178643")

        private int size = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.787 -0400", hash_original_field = "82A63DA99F8F58D581BB3EF9928D99E4", hash_generated_field = "F986E3D55ACB2544F93BB697B2C53FDD")

        private Thread leader = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.787 -0400", hash_original_field = "F12F9049DC39DE18B81748F5CE552E9E", hash_generated_field = "C79074F36C98DFB2E5B637BB02408509")

        private Condition available = lock.newCondition();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.787 -0400", hash_original_method = "5917AE9375A9F0D7E6AA869E9A88CC5E", hash_generated_method = "5917AE9375A9F0D7E6AA869E9A88CC5E")
        public DelayedWorkQueue ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.787 -0400", hash_original_method = "871562DD277C0AC8BA441D82903E861A", hash_generated_method = "E5400757E0ABDA0692DD3FDCC4FF0F6E")
        private void setIndex(RunnableScheduledFuture f, int idx) {
            ((ScheduledFutureTask)f).heapIndex = idx;
            addTaint(f.getTaint());
            addTaint(idx);
            // ---------- Original Method ----------
            //if (f instanceof ScheduledFutureTask)
                //((ScheduledFutureTask)f).heapIndex = idx;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.809 -0400", hash_original_method = "82039C4DF7CA25BEE85708617CA17C0A", hash_generated_method = "124223C7681568693790D1C1ED0A151A")
        private void siftUp(int k, RunnableScheduledFuture key) {
            {
                int parent;
                parent = (k - 1) >>> 1;
                RunnableScheduledFuture e;
                e = queue[parent];
                {
                    boolean varC4C5D1172CD54B7DA5B4B3D658159E80_285630955 = (key.compareTo(e) >= 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.810 -0400", hash_original_method = "2B1F11A0F086CDEBFE52E8E81BF54F43", hash_generated_method = "B968713D78734606307B33FAB881AC17")
        private void siftDown(int k, RunnableScheduledFuture key) {
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
                    boolean var7E86A53F0AFEB1BC3F88CC41D31B2A33_926061753 = (right < size && c.compareTo(queue[right]) > 0);
                    c = queue[child = right];
                } //End collapsed parenthetic
                {
                    boolean var7F16288BED19CE15B51BB4F575E3252F_201342071 = (key.compareTo(c) <= 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.810 -0400", hash_original_method = "A3FC13DF1E683960EBCF25B1C68B6117", hash_generated_method = "ED72AC44B6E1AAC3A52FA92705947288")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.811 -0400", hash_original_method = "C580641A4A2388B58215BACCB42FFCE3", hash_generated_method = "A280937960BE2C9E7C9928411B888F18")
        private int indexOf(Object x) {
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
                            boolean varB28D373523DC4FB5420385081303E702_1105927874 = (x.equals(queue[i]));
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End block
            addTaint(x.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343652174 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343652174;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.812 -0400", hash_original_method = "5E09E7103DB0A49A13B2DDAFBB485D60", hash_generated_method = "C4A0275174216E4E4C788D2C4817C0F5")
        public boolean contains(Object x) {
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                boolean var50987CC635D4EF59A4064B2DDB6782AF_1810409282 = (indexOf(x) != -1);
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            addTaint(x.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530203548 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_530203548;
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return indexOf(x) != -1;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.826 -0400", hash_original_method = "BE80A65233BEEC20C44EE13577B8F6B3", hash_generated_method = "0CD979B0F2E0B47A4BDF5AFE49D1DD3D")
        public boolean remove(Object x) {
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
            addTaint(x.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_877022779 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_877022779;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.827 -0400", hash_original_method = "FB53A461CD3B1BACC3DB27D415F5CC64", hash_generated_method = "7490BB2506BFA1FAC798F80077688A71")
        public int size() {
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1806836225 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1806836225;
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return size;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.827 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "ED2EBA4EB3F46FEDB60350CA80957853")
        public boolean isEmpty() {
            boolean var5A234584F0C312DA2BE9DBC07A5ED4AF_1331685685 = (size() == 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174676355 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_174676355;
            // ---------- Original Method ----------
            //return size() == 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.828 -0400", hash_original_method = "E7CDD1D543D1F61B1D969765A4629893", hash_generated_method = "52C059BEEA9E98A0844A5AAE13A1D6E1")
        public int remainingCapacity() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148142369 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148142369;
            // ---------- Original Method ----------
            //return Integer.MAX_VALUE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.832 -0400", hash_original_method = "71D771244E4BD1C0173C42068DB81D51", hash_generated_method = "0FC0BE64FEC5F03A7E51016227DB0AA6")
        public RunnableScheduledFuture peek() {
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_1410602845 = null; //Variable for return #1
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1410602845 = queue[0];
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1410602845.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1410602845;
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return queue[0];
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.838 -0400", hash_original_method = "A5863DDF2D55F0A792F5570CB9552D10", hash_generated_method = "EAA504D4E24B45CF90E2CEAB18BCA5CF")
        public boolean offer(Runnable x) {
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
            addTaint(x.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309641778 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_309641778;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.838 -0400", hash_original_method = "4080BF206CA14D39406126FB9F6C27D2", hash_generated_method = "1A86819A352109BB19D0E5A02A33C8D1")
        public void put(Runnable e) {
            offer(e);
            addTaint(e.getTaint());
            // ---------- Original Method ----------
            //offer(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.851 -0400", hash_original_method = "AD0F5DE8A091A43B7107BCF4BE0853B5", hash_generated_method = "DBE5690B8CAEEE2543C29C5FDAAEBC17")
        public boolean add(Runnable e) {
            boolean varE46C21D833DB059BB8F6E49CAFEACF2D_1522275850 = (offer(e));
            addTaint(e.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24084121 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_24084121;
            // ---------- Original Method ----------
            //return offer(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.858 -0400", hash_original_method = "C6567B4A0AA1C7B283CF9843CADA74F7", hash_generated_method = "F73A8CD98125A4DCF7D8E981614F884B")
        public boolean offer(Runnable e, long timeout, TimeUnit unit) {
            boolean varE46C21D833DB059BB8F6E49CAFEACF2D_766247160 = (offer(e));
            addTaint(e.getTaint());
            addTaint(timeout);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967376852 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967376852;
            // ---------- Original Method ----------
            //return offer(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.858 -0400", hash_original_method = "95AFA75D0998C104C226840186514FC9", hash_generated_method = "8A1DDAA98106B5A51C3A5C1E36EAF444")
        private RunnableScheduledFuture finishPoll(RunnableScheduledFuture f) {
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_28736856 = null; //Variable for return #1
            int s;
            s = --size;
            RunnableScheduledFuture x;
            x = queue[s];
            queue[s] = null;
            siftDown(0, x);
            setIndex(f, -1);
            varB4EAC82CA7396A68D541C85D26508E83_28736856 = f;
            addTaint(f.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_28736856.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_28736856;
            // ---------- Original Method ----------
            //int s = --size;
            //RunnableScheduledFuture x = queue[s];
            //queue[s] = null;
            //if (s != 0)
                //siftDown(0, x);
            //setIndex(f, -1);
            //return f;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.859 -0400", hash_original_method = "8EBCD245EA652A524E679A63C787A99C", hash_generated_method = "4CB941DC20185111ABF9415AE5BB2CF8")
        public RunnableScheduledFuture poll() {
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_1093788214 = null; //Variable for return #1
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_661749088 = null; //Variable for return #2
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                RunnableScheduledFuture first;
                first = queue[0];
                {
                    boolean var5A3EA0F41303197B859A517B5ABCDA38_764915693 = (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0);
                    varB4EAC82CA7396A68D541C85D26508E83_1093788214 = null;
                    varB4EAC82CA7396A68D541C85D26508E83_661749088 = finishPoll(first);
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            RunnableScheduledFuture varA7E53CE21691AB073D9660D615818899_1646122829; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1646122829 = varB4EAC82CA7396A68D541C85D26508E83_1093788214;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1646122829 = varB4EAC82CA7396A68D541C85D26508E83_661749088;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1646122829.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1646122829;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.860 -0400", hash_original_method = "C35B04B198E2C5886DA81FEFBA3F2D77", hash_generated_method = "092A55F3AC0C987736A9CA27CF6DDB15")
        public RunnableScheduledFuture take() throws InterruptedException {
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_1974379175 = null; //Variable for return #1
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
                        varB4EAC82CA7396A68D541C85D26508E83_1974379175 = finishPoll(first);
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
            varB4EAC82CA7396A68D541C85D26508E83_1974379175.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1974379175;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.882 -0400", hash_original_method = "72DE523456D313A78DBDBA042B83CE23", hash_generated_method = "81C0701F2523268F93FD9ABDF119B567")
        public RunnableScheduledFuture poll(long timeout, TimeUnit unit) throws InterruptedException {
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_1285715315 = null; //Variable for return #1
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_279269814 = null; //Variable for return #2
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_267715870 = null; //Variable for return #3
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
                        varB4EAC82CA7396A68D541C85D26508E83_1285715315 = null;
                        nanos = available.awaitNanos(nanos);
                    } //End block
                    {
                        long delay;
                        delay = first.getDelay(TimeUnit.NANOSECONDS);
                        varB4EAC82CA7396A68D541C85D26508E83_279269814 = finishPoll(first);
                        varB4EAC82CA7396A68D541C85D26508E83_267715870 = null;
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
            addTaint(timeout);
            addTaint(unit.getTaint());
            RunnableScheduledFuture varA7E53CE21691AB073D9660D615818899_173147858; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_173147858 = varB4EAC82CA7396A68D541C85D26508E83_1285715315;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_173147858 = varB4EAC82CA7396A68D541C85D26508E83_279269814;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_173147858 = varB4EAC82CA7396A68D541C85D26508E83_267715870;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_173147858.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_173147858;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.890 -0400", hash_original_method = "B7A92D7F07FC88CC462E2031E3EC4D97", hash_generated_method = "AC678A42861AD374BE53722278D25AEA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.891 -0400", hash_original_method = "2FE630D35A7B40B0A6753A3386B27535", hash_generated_method = "13C763EAD9A034575694ED072F0B69EE")
        private RunnableScheduledFuture pollExpired() {
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_1059574534 = null; //Variable for return #1
            RunnableScheduledFuture varB4EAC82CA7396A68D541C85D26508E83_241236933 = null; //Variable for return #2
            RunnableScheduledFuture first;
            first = queue[0];
            {
                boolean varDBDDC81EE2A47102CBC7EDC3FD3B2190_1595208247 = (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0);
                varB4EAC82CA7396A68D541C85D26508E83_1059574534 = null;
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_241236933 = finishPoll(first);
            RunnableScheduledFuture varA7E53CE21691AB073D9660D615818899_936913218; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_936913218 = varB4EAC82CA7396A68D541C85D26508E83_1059574534;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_936913218 = varB4EAC82CA7396A68D541C85D26508E83_241236933;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_936913218.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_936913218;
            // ---------- Original Method ----------
            //RunnableScheduledFuture first = queue[0];
            //if (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0)
                //return null;
            //return finishPoll(first);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.893 -0400", hash_original_method = "A0CF55F6497A110CDDFF356DE0AE8664", hash_generated_method = "8772A58AAC4C7674CE54E64778D1C47D")
        public int drainTo(Collection<? super Runnable> c) {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            {
                boolean varBA1311186045D728773ECE86BC5E0754_351786369 = (c == this);
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
                    boolean varE67564F86D6C2E56821D82C2AB67713B_1128189145 = ((first = pollExpired()) != null);
                    {
                        c.add(first);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            addTaint(c.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781091871 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781091871;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.900 -0400", hash_original_method = "0279366BCBF84614051CBA5B08204A0A", hash_generated_method = "CD7AD025C70C09AD19D66F8C7510D223")
        public int drainTo(Collection<? super Runnable> c, int maxElements) {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            {
                boolean varBA1311186045D728773ECE86BC5E0754_481746434 = (c == this);
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
                    boolean var907F87A983490314E2E468AEABFC930D_611570263 = (n < maxElements && (first = pollExpired()) != null);
                    {
                        c.add(first);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            addTaint(c.getTaint());
            addTaint(maxElements);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504674983 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504674983;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.904 -0400", hash_original_method = "7408B58852530A87736A5AD8CAD9599F", hash_generated_method = "8AB526D784BB82CE251807C8274F5F4D")
        public Object[] toArray() {
            Object[] varB4EAC82CA7396A68D541C85D26508E83_609304171 = null; //Variable for return #1
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_609304171 = Arrays.copyOf(queue, size, Object[].class);
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_609304171.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_609304171;
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return Arrays.copyOf(queue, size, Object[].class);
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.925 -0400", hash_original_method = "C537847CD06DB8C82AFD734BEA1D62C4", hash_generated_method = "E15C9B3C6582CF6CCA2BF33FC45056F0")
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            T[] varB4EAC82CA7396A68D541C85D26508E83_517347850 = null; //Variable for return #1
            T[] varB4EAC82CA7396A68D541C85D26508E83_1850823372 = null; //Variable for return #2
            ReentrantLock lock;
            lock = this.lock;
            lock.lock();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_517347850 = (T[]) Arrays.copyOf(queue, size, a.getClass());
                System.arraycopy(queue, 0, a, 0, size);
                a[size] = null;
                varB4EAC82CA7396A68D541C85D26508E83_1850823372 = a;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            T[] varA7E53CE21691AB073D9660D615818899_760338912; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_760338912 = varB4EAC82CA7396A68D541C85D26508E83_517347850;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_760338912 = varB4EAC82CA7396A68D541C85D26508E83_1850823372;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_760338912.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_760338912;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.926 -0400", hash_original_method = "46B1FB64DFD489BA9D84B29257E9B6C6", hash_generated_method = "A4B4E2ECB4C3EF595493D3765B7F6973")
        public Iterator<Runnable> iterator() {
            Iterator<Runnable> varB4EAC82CA7396A68D541C85D26508E83_172602633 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_172602633 = new Itr(Arrays.copyOf(queue, size));
            varB4EAC82CA7396A68D541C85D26508E83_172602633.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_172602633;
            // ---------- Original Method ----------
            //return new Itr(Arrays.copyOf(queue, size));
        }

        
        private class Itr implements Iterator<Runnable> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.927 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "81254B9FC545B41C37906F59020B61EA")

            RunnableScheduledFuture[] array;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.927 -0400", hash_original_field = "450022C54ECA00D933A53196B279FDDD", hash_generated_field = "EF6EF07B89CC96321B7CFBEF54BCF418")

            int cursor = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.927 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "9128B9A3EF0151CBF070702BF3C62C66")

            int lastRet = -1;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.927 -0400", hash_original_method = "78BE11BC04A59F667BA3E745B91EA864", hash_generated_method = "ABE1A6D5F6CC1003308B5A0719A48D00")
              Itr(RunnableScheduledFuture[] array) {
                this.array = array;
                // ---------- Original Method ----------
                //this.array = array;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.928 -0400", hash_original_method = "C1264B905CC60CA39EE5BE51F177AC9A", hash_generated_method = "431E45DEF4DB450367013E4FF8EE52E8")
            public boolean hasNext() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_174074565 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_174074565;
                // ---------- Original Method ----------
                //return cursor < array.length;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.946 -0400", hash_original_method = "3D0866C62F631AE1F3281A9951BE6C06", hash_generated_method = "272B7AE76EB553B06318D1A102D32F96")
            public Runnable next() {
                Runnable varB4EAC82CA7396A68D541C85D26508E83_1897512820 = null; //Variable for return #1
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                lastRet = cursor;
                varB4EAC82CA7396A68D541C85D26508E83_1897512820 = array[cursor++];
                varB4EAC82CA7396A68D541C85D26508E83_1897512820.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1897512820;
                // ---------- Original Method ----------
                //if (cursor >= array.length)
                    //throw new NoSuchElementException();
                //lastRet = cursor;
                //return array[cursor++];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.947 -0400", hash_original_method = "560EEAA350DF5EAA4CBD4C138A91D642", hash_generated_method = "CE7DA7858017CF4323B5084C501777C6")
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


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.947 -0400", hash_original_field = "60E8041D14101DDB569AC77FCB6B5097", hash_generated_field = "05F257EA7A187AB466D9076A9A3F0E5F")

        private static int INITIAL_CAPACITY = 16;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.947 -0400", hash_original_field = "D8FDF1FE130A58926F6239A3C9466239", hash_generated_field = "1594483929F5FC58560CDCB162389DFF")

    private static AtomicLong sequencer = new AtomicLong(0);
}

