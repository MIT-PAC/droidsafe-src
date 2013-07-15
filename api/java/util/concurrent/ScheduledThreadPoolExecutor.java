package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;
import java.util.*;

public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.245 -0400", hash_original_field = "16F5A356C77125C2C156C9F6B6F49691", hash_generated_field = "AA2F9CF8A8BDA098B7353794A7890F68")

    private volatile boolean continueExistingPeriodicTasksAfterShutdown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.246 -0400", hash_original_field = "0694CB6B95D24930C98752845302446B", hash_generated_field = "D4D52A1567899065AB02C507D671256E")

    private volatile boolean executeExistingDelayedTasksAfterShutdown = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.246 -0400", hash_original_field = "B9C1236F0DDAF6571DA9803B91DCBA27", hash_generated_field = "396CDA7B171456B549FE026890B28734")

    private volatile boolean removeOnCancel = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.246 -0400", hash_original_method = "D36047D4322FE6F8EBCA30AB15266BC6", hash_generated_method = "69663AB27BD1BC39635232462251E927")
    public  ScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue());
        addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.246 -0400", hash_original_method = "ABDCD4F10C893856EFE26F2C021D677A", hash_generated_method = "9FBACCFD51711913D7AD889EE68344FC")
    public  ScheduledThreadPoolExecutor(int corePoolSize,
                                       ThreadFactory threadFactory) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), threadFactory);
        addTaint(threadFactory.getTaint());
        addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.247 -0400", hash_original_method = "15AFC792EAFAB8847ABF7F7AA1CDCAAC", hash_generated_method = "B92D3BA0392D1A5A0429C8F5012FBD2F")
    public  ScheduledThreadPoolExecutor(int corePoolSize,
                                       RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), handler);
        addTaint(handler.getTaint());
        addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.247 -0400", hash_original_method = "FA0219710575675561B4DC7EAFAB1D1D", hash_generated_method = "3DC6EF26E3293BBEEC0C18907D0AF186")
    public  ScheduledThreadPoolExecutor(int corePoolSize,
                                       ThreadFactory threadFactory,
                                       RejectedExecutionHandler handler) {
        super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS,
              new DelayedWorkQueue(), threadFactory, handler);
        addTaint(handler.getTaint());
        addTaint(threadFactory.getTaint());
        addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.247 -0400", hash_original_method = "5D4518F727B3B1C5CE98EBC039D9AF6B", hash_generated_method = "A4A4A488933510D2797FE7A7CBDF7322")
    final long now() {
        long var97501587DA544101C263E23F58D1EE3B_736966400 = (System.nanoTime());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2098730714 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2098730714;
        // ---------- Original Method ----------
        //return System.nanoTime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.248 -0400", hash_original_method = "43122228A318CAFA2BE5FD8EB8B7119A", hash_generated_method = "B107C9BDFA967B157C4F83BE407C39E9")
     boolean canRunInCurrentRunState(boolean periodic) {
        addTaint(periodic);
        boolean var849261B4BF68A185AADD09B57E82B4E0_1889025497 = (isRunningOrShutdown(periodic ?
                                   continueExistingPeriodicTasksAfterShutdown :
                                   executeExistingDelayedTasksAfterShutdown));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_378113153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_378113153;
        // ---------- Original Method ----------
        //return isRunningOrShutdown(periodic ?
                                   //continueExistingPeriodicTasksAfterShutdown :
                                   //executeExistingDelayedTasksAfterShutdown);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.249 -0400", hash_original_method = "74BC2A8347918586B07692C369988E7C", hash_generated_method = "1233BDA0885E8E1DBF51CE9FE38BD51F")
    private void delayedExecute(RunnableScheduledFuture<?> task) {
        addTaint(task.getTaint());
    if(isShutdown())        
        reject(task);
        else
        {
            super.getQueue().add(task);
    if(isShutdown() &&
                !canRunInCurrentRunState(task.isPeriodic()) &&
                remove(task))            
            task.cancel(false);
            else
            prestartCoreThread();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.249 -0400", hash_original_method = "0C685B50A598B045820F5EF901D2AED6", hash_generated_method = "E936D91D9621740D03ED68FDA1AA5865")
     void reExecutePeriodic(RunnableScheduledFuture<?> task) {
        addTaint(task.getTaint());
    if(canRunInCurrentRunState(true))        
        {
            super.getQueue().add(task);
    if(!canRunInCurrentRunState(true) && remove(task))            
            task.cancel(false);
            else
            prestartCoreThread();
        } //End block
        // ---------- Original Method ----------
        //if (canRunInCurrentRunState(true)) {
            //super.getQueue().add(task);
            //if (!canRunInCurrentRunState(true) && remove(task))
                //task.cancel(false);
            //else
                //prestartCoreThread();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.250 -0400", hash_original_method = "64FA3598D4BDF802451AB41ACA7E6BE8", hash_generated_method = "5C8AB3A2FC1CFD36495813FF3A05CD0D")
    @Override
     void onShutdown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        BlockingQueue<Runnable> q = super.getQueue();
        boolean keepDelayed = getExecuteExistingDelayedTasksAfterShutdownPolicy();
        boolean keepPeriodic = getContinueExistingPeriodicTasksAfterShutdownPolicy();
    if(!keepDelayed && !keepPeriodic)        
        {
for(Object e : q.toArray())
    if(e instanceof RunnableScheduledFuture<?>)            
            ((RunnableScheduledFuture<?>) e).cancel(false);
            q.clear();
        } //End block
        else
        {
for(Object e : q.toArray())
            {
    if(e instanceof RunnableScheduledFuture)                
                {
                    RunnableScheduledFuture<?> t = (RunnableScheduledFuture<?>)e;
    if((t.isPeriodic() ? !keepPeriodic : !keepDelayed) ||
                        t.isCancelled())                    
                    {
    if(q.remove(t))                        
                        t.cancel(false);
                    } //End block
                } //End block
            } //End block
        } //End block
        tryTerminate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.250 -0400", hash_original_method = "2D7E8C9964120FA3F638C1BFE2958CB1", hash_generated_method = "78E8F68B5EECC05B07FD599D202704E0")
    protected <V> RunnableScheduledFuture<V> decorateTask(
        Runnable runnable, RunnableScheduledFuture<V> task) {
        addTaint(task.getTaint());
        addTaint(runnable.getTaint());
RunnableScheduledFuture<V> varE3FBC805688C6CF32CF252D3CB460B3C_727329168 =         task;
        varE3FBC805688C6CF32CF252D3CB460B3C_727329168.addTaint(taint);
        return varE3FBC805688C6CF32CF252D3CB460B3C_727329168;
        // ---------- Original Method ----------
        //return task;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.251 -0400", hash_original_method = "5DBE5BBA8D9EF484681F4C8336F1600B", hash_generated_method = "08373C5BB691DF6F7BAB5D03DCFCB9EB")
    protected <V> RunnableScheduledFuture<V> decorateTask(
        Callable<V> callable, RunnableScheduledFuture<V> task) {
        addTaint(task.getTaint());
        addTaint(callable.getTaint());
RunnableScheduledFuture<V> varE3FBC805688C6CF32CF252D3CB460B3C_1770929068 =         task;
        varE3FBC805688C6CF32CF252D3CB460B3C_1770929068.addTaint(taint);
        return varE3FBC805688C6CF32CF252D3CB460B3C_1770929068;
        // ---------- Original Method ----------
        //return task;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.251 -0400", hash_original_method = "14F5A42293D1200CF8E952E9DCB67B90", hash_generated_method = "28563B9808E5014D83112C5DBC817C26")
    private long triggerTime(long delay, TimeUnit unit) {
        addTaint(unit.getTaint());
        addTaint(delay);
        long var3A9A834774A9DD0E83B32D24A8FE0BA3_1507685005 = (triggerTime(unit.toNanos((delay < 0) ? 0 : delay)));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1804261011 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1804261011;
        // ---------- Original Method ----------
        //return triggerTime(unit.toNanos((delay < 0) ? 0 : delay));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.251 -0400", hash_original_method = "43548DFC0EE197F487A673EC89A4A123", hash_generated_method = "923B4FB444FFD9364BF9772A284D8456")
     long triggerTime(long delay) {
        addTaint(delay);
        long varE02A3E263ED074072E8BC5212102C136_1338575236 = (now() +
            ((delay < (Long.MAX_VALUE >> 1)) ? delay : overflowFree(delay)));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_792576066 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_792576066;
        // ---------- Original Method ----------
        //return now() +
            //((delay < (Long.MAX_VALUE >> 1)) ? delay : overflowFree(delay));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.252 -0400", hash_original_method = "7169306CF31D42FCC72896372081E078", hash_generated_method = "355E6CD425AACD8D6E9A8F7F68DF0022")
    private long overflowFree(long delay) {
        addTaint(delay);
        Delayed head = (Delayed) super.getQueue().peek();
    if(head != null)        
        {
            long headDelay = head.getDelay(TimeUnit.NANOSECONDS);
    if(headDelay < 0 && (delay - headDelay < 0))            
            delay = Long.MAX_VALUE + headDelay;
        } //End block
        long var7243F8BE75253AFBADF7477867021F8B_1407915405 = (delay);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2089300358 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2089300358;
        // ---------- Original Method ----------
        //Delayed head = (Delayed) super.getQueue().peek();
        //if (head != null) {
            //long headDelay = head.getDelay(TimeUnit.NANOSECONDS);
            //if (headDelay < 0 && (delay - headDelay < 0))
                //delay = Long.MAX_VALUE + headDelay;
        //}
        //return delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.253 -0400", hash_original_method = "E8C91BC5CFBE81CC8958800A4E70C4DA", hash_generated_method = "AC780332015363B974FE251502EAD084")
    public ScheduledFuture<?> schedule(Runnable command,
                                       long delay,
                                       TimeUnit unit) {
        addTaint(unit.getTaint());
        addTaint(delay);
        addTaint(command.getTaint());
    if(command == null || unit == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2069587905 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_2069587905.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_2069587905;
        }
        RunnableScheduledFuture<?> t = decorateTask(command,
            new ScheduledFutureTask<Void>(command, null,
                                          triggerTime(delay, unit)));
        delayedExecute(t);
ScheduledFuture<?> varE0D714D758F1540A8DF364A965AF9150_490444668 =         t;
        varE0D714D758F1540A8DF364A965AF9150_490444668.addTaint(taint);
        return varE0D714D758F1540A8DF364A965AF9150_490444668;
        // ---------- Original Method ----------
        //if (command == null || unit == null)
            //throw new NullPointerException();
        //RunnableScheduledFuture<?> t = decorateTask(command,
            //new ScheduledFutureTask<Void>(command, null,
                                          //triggerTime(delay, unit)));
        //delayedExecute(t);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.253 -0400", hash_original_method = "3CA816B6292CC3DABD4A8E9E190B6332", hash_generated_method = "81AB88D7EAEFA8FE593032078FA2AE31")
    public <V> ScheduledFuture<V> schedule(Callable<V> callable,
                                           long delay,
                                           TimeUnit unit) {
        addTaint(unit.getTaint());
        addTaint(delay);
        addTaint(callable.getTaint());
    if(callable == null || unit == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1922027696 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1922027696.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1922027696;
        }
        RunnableScheduledFuture<V> t = decorateTask(callable,
            new ScheduledFutureTask<V>(callable,
                                       triggerTime(delay, unit)));
        delayedExecute(t);
ScheduledFuture<V> varE0D714D758F1540A8DF364A965AF9150_1622805509 =         t;
        varE0D714D758F1540A8DF364A965AF9150_1622805509.addTaint(taint);
        return varE0D714D758F1540A8DF364A965AF9150_1622805509;
        // ---------- Original Method ----------
        //if (callable == null || unit == null)
            //throw new NullPointerException();
        //RunnableScheduledFuture<V> t = decorateTask(callable,
            //new ScheduledFutureTask<V>(callable,
                                       //triggerTime(delay, unit)));
        //delayedExecute(t);
        //return t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.254 -0400", hash_original_method = "8D8E5BFEEBAD4838EB16FA502AD719D4", hash_generated_method = "54CF754561205AD2EF0B33B14B4DF430")
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay,
                                                  long period,
                                                  TimeUnit unit) {
        addTaint(unit.getTaint());
        addTaint(period);
        addTaint(initialDelay);
        addTaint(command.getTaint());
    if(command == null || unit == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1086751313 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1086751313.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1086751313;
        }
    if(period <= 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1604030717 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1604030717.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1604030717;
        }
        ScheduledFutureTask<Void> sft = new ScheduledFutureTask<Void>(command,
                                          null,
                                          triggerTime(initialDelay, unit),
                                          unit.toNanos(period));
        RunnableScheduledFuture<Void> t = decorateTask(command, sft);
        sft.outerTask = t;
        delayedExecute(t);
ScheduledFuture<?> varE0D714D758F1540A8DF364A965AF9150_1256387498 =         t;
        varE0D714D758F1540A8DF364A965AF9150_1256387498.addTaint(taint);
        return varE0D714D758F1540A8DF364A965AF9150_1256387498;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.255 -0400", hash_original_method = "F8BFEFA210F26533C5765CF5137E2FD3", hash_generated_method = "6F3DA13D1AA385FB50F596AF354A4968")
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
                                                     long initialDelay,
                                                     long delay,
                                                     TimeUnit unit) {
        addTaint(unit.getTaint());
        addTaint(delay);
        addTaint(initialDelay);
        addTaint(command.getTaint());
    if(command == null || unit == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1957114370 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1957114370.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1957114370;
        }
    if(delay <= 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1633500414 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1633500414.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1633500414;
        }
        ScheduledFutureTask<Void> sft = new ScheduledFutureTask<Void>(command,
                                          null,
                                          triggerTime(initialDelay, unit),
                                          unit.toNanos(-delay));
        RunnableScheduledFuture<Void> t = decorateTask(command, sft);
        sft.outerTask = t;
        delayedExecute(t);
ScheduledFuture<?> varE0D714D758F1540A8DF364A965AF9150_932206056 =         t;
        varE0D714D758F1540A8DF364A965AF9150_932206056.addTaint(taint);
        return varE0D714D758F1540A8DF364A965AF9150_932206056;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.255 -0400", hash_original_method = "106B54169234F208DA4A1738F707D69C", hash_generated_method = "298C226B5D3D89C38498C55CCC18C61C")
    public void execute(Runnable command) {
        addTaint(command.getTaint());
        schedule(command, 0, TimeUnit.NANOSECONDS);
        // ---------- Original Method ----------
        //schedule(command, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.256 -0400", hash_original_method = "71AB87E2E6647A80EF75456B59FD870B", hash_generated_method = "1CF9DF4FAD21629ED4D47D21C7994B5D")
    public Future<?> submit(Runnable task) {
        addTaint(task.getTaint());
Future<?> varC033FC2530DBD28BB1831A9C4CE5DB45_1225369233 =         schedule(task, 0, TimeUnit.NANOSECONDS);
        varC033FC2530DBD28BB1831A9C4CE5DB45_1225369233.addTaint(taint);
        return varC033FC2530DBD28BB1831A9C4CE5DB45_1225369233;
        // ---------- Original Method ----------
        //return schedule(task, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.256 -0400", hash_original_method = "A2BAF492547813A1B4B6DC556E74F888", hash_generated_method = "013E8D471E5A82C7A11A0663DEEF009A")
    public <T> Future<T> submit(Runnable task, T result) {
        addTaint(result.getTaint());
        addTaint(task.getTaint());
Future<T> var5F143B3617D15E425694BCB00707B794_1847818004 =         schedule(Executors.callable(task, result),
                        0, TimeUnit.NANOSECONDS);
        var5F143B3617D15E425694BCB00707B794_1847818004.addTaint(taint);
        return var5F143B3617D15E425694BCB00707B794_1847818004;
        // ---------- Original Method ----------
        //return schedule(Executors.callable(task, result),
                        //0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.257 -0400", hash_original_method = "7532879CEC1557BEB821686E164CE854", hash_generated_method = "B47911D4F02A57CB7C69B9847DBA835F")
    public <T> Future<T> submit(Callable<T> task) {
        addTaint(task.getTaint());
Future<T> varC033FC2530DBD28BB1831A9C4CE5DB45_346884904 =         schedule(task, 0, TimeUnit.NANOSECONDS);
        varC033FC2530DBD28BB1831A9C4CE5DB45_346884904.addTaint(taint);
        return varC033FC2530DBD28BB1831A9C4CE5DB45_346884904;
        // ---------- Original Method ----------
        //return schedule(task, 0, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.257 -0400", hash_original_method = "4AFC27553B47AB13DBA25E0474D83429", hash_generated_method = "103E279385ED13E49F15EF1C104DA70B")
    public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean value) {
        continueExistingPeriodicTasksAfterShutdown = value;
    if(!value && isShutdown())        
        onShutdown();
        // ---------- Original Method ----------
        //continueExistingPeriodicTasksAfterShutdown = value;
        //if (!value && isShutdown())
            //onShutdown();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.258 -0400", hash_original_method = "23365684DD383694198E6F21D088C23A", hash_generated_method = "987980CF22A5834977FEF55B5ABBA5E9")
    public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() {
        boolean var16F5A356C77125C2C156C9F6B6F49691_2022338395 = (continueExistingPeriodicTasksAfterShutdown);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101380176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101380176;
        // ---------- Original Method ----------
        //return continueExistingPeriodicTasksAfterShutdown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.258 -0400", hash_original_method = "DDF8C3EFAF4531B367BDE4CC570E21D4", hash_generated_method = "01E6D0A79A23EDC5CD9F0CB056E5E691")
    public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean value) {
        executeExistingDelayedTasksAfterShutdown = value;
    if(!value && isShutdown())        
        onShutdown();
        // ---------- Original Method ----------
        //executeExistingDelayedTasksAfterShutdown = value;
        //if (!value && isShutdown())
            //onShutdown();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.258 -0400", hash_original_method = "691F6AED1700735267010AB69287CBB5", hash_generated_method = "AD0C6AA3615309BD3BE793AA777C1D50")
    public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() {
        boolean var07A18653AA39EFFB12C28D64E4CEBF7A_2003791241 = (executeExistingDelayedTasksAfterShutdown);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1211324173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1211324173;
        // ---------- Original Method ----------
        //return executeExistingDelayedTasksAfterShutdown;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.259 -0400", hash_original_method = "C989154112CE4F835859D145255931FC", hash_generated_method = "8187F71188C5442EF4B01CC9510CDCEB")
     void setRemoveOnCancelPolicy(boolean value) {
        removeOnCancel = value;
        // ---------- Original Method ----------
        //removeOnCancel = value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.259 -0400", hash_original_method = "3215CF4E7E81ACD4FCE62CEA9B692D35", hash_generated_method = "8546565E979774CA5754E3FD9ACA4B0D")
     boolean getRemoveOnCancelPolicy() {
        boolean varFD8692A9067DBD029B4BB7001C088F36_1606333115 = (removeOnCancel);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803068095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_803068095;
        // ---------- Original Method ----------
        //return removeOnCancel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.259 -0400", hash_original_method = "06AE3A71ACDF5D94BFF2BA3486ECC61C", hash_generated_method = "F4BC997EF9BFFD2417FE8194C56E3FA6")
    public void shutdown() {
        super.shutdown();
        // ---------- Original Method ----------
        //super.shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.260 -0400", hash_original_method = "58CAE4CD18062B6710EA14E24E67D3BE", hash_generated_method = "DEA5568E3ECBD1A9386DC0A22AA8068B")
    public List<Runnable> shutdownNow() {
List<Runnable> var7C14AB944B290776B3A5F9444C7B09E0_558156192 =         super.shutdownNow();
        var7C14AB944B290776B3A5F9444C7B09E0_558156192.addTaint(taint);
        return var7C14AB944B290776B3A5F9444C7B09E0_558156192;
        // ---------- Original Method ----------
        //return super.shutdownNow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.260 -0400", hash_original_method = "161D6A52B7D27778B4A9C4AAA82FE7A8", hash_generated_method = "2585DDDCFA8A53E22C4961163F3AD178")
    public BlockingQueue<Runnable> getQueue() {
BlockingQueue<Runnable> var9B3B10850AFC3876BB673FC3C28B08E2_1469427309 =         super.getQueue();
        var9B3B10850AFC3876BB673FC3C28B08E2_1469427309.addTaint(taint);
        return var9B3B10850AFC3876BB673FC3C28B08E2_1469427309;
        // ---------- Original Method ----------
        //return super.getQueue();
    }

    
    private class ScheduledFutureTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.260 -0400", hash_original_field = "1C021ADF174562C07D271E889F46BABF", hash_generated_field = "BC5948EFF55F237F777F173C3B803F01")

        private long sequenceNumber;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.260 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "2D21F2B1A6174F407FDE900F8B752B4F")

        private long time;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.260 -0400", hash_original_field = "A0ACFA46D86F7610B2C73DBB28F64701", hash_generated_field = "9B4C1F15D97D513A97EBCE4E8EF81345")

        private long period;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.261 -0400", hash_original_field = "AC10162ABA5F230BD320E9A8DE1FBB74", hash_generated_field = "98CF25F8111133A7EC779F1A91CDBA76")

        RunnableScheduledFuture<V> outerTask = this;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.261 -0400", hash_original_field = "14097C6719ADB60131A527E0555F6127", hash_generated_field = "B9E65256978F8C0BE4352922F453397A")

        int heapIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.262 -0400", hash_original_method = "6D6FE21BC02E4EEDE50A66A758AADBC3", hash_generated_method = "62B7F7BEF003807ED4FEEFBD5CEACBE6")
          ScheduledFutureTask(Runnable r, V result, long ns) {
            super(r, result);
            addTaint(result.getTaint());
            addTaint(r.getTaint());
            this.time = ns;
            this.period = 0;
            this.sequenceNumber = sequencer.getAndIncrement();
            // ---------- Original Method ----------
            //this.time = ns;
            //this.period = 0;
            //this.sequenceNumber = sequencer.getAndIncrement();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.262 -0400", hash_original_method = "E04B804C1814B5C9E0689952B28AE769", hash_generated_method = "DBC3753692854C6B28D9D55C1882816B")
          ScheduledFutureTask(Runnable r, V result, long ns, long period) {
            super(r, result);
            addTaint(result.getTaint());
            addTaint(r.getTaint());
            this.time = ns;
            this.period = period;
            this.sequenceNumber = sequencer.getAndIncrement();
            // ---------- Original Method ----------
            //this.time = ns;
            //this.period = period;
            //this.sequenceNumber = sequencer.getAndIncrement();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.263 -0400", hash_original_method = "E88D028A2F4D25267A398506CBA854E6", hash_generated_method = "F15648E5E6776C3103D88CF9150E4257")
          ScheduledFutureTask(Callable<V> callable, long ns) {
            super(callable);
            addTaint(callable.getTaint());
            this.time = ns;
            this.period = 0;
            this.sequenceNumber = sequencer.getAndIncrement();
            // ---------- Original Method ----------
            //this.time = ns;
            //this.period = 0;
            //this.sequenceNumber = sequencer.getAndIncrement();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.263 -0400", hash_original_method = "EA844DF3AD76AAE2032057524EEDD497", hash_generated_method = "E1E0856C98FDBDE72FF1E5F4CC234E7C")
        public long getDelay(TimeUnit unit) {
            addTaint(unit.getTaint());
            long varBF8187370753751666A6B77C869BDE59_2024836308 = (unit.convert(time - now(), TimeUnit.NANOSECONDS));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_320017682 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_320017682;
            // ---------- Original Method ----------
            //return unit.convert(time - now(), TimeUnit.NANOSECONDS);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.264 -0400", hash_original_method = "3DDFB5C452DB9F58801DAD45AC132180", hash_generated_method = "5C679F630BF948FF3CAC6F01DC894133")
        public int compareTo(Delayed other) {
            addTaint(other.getTaint());
    if(other == this)            
            {
            int varCFCD208495D565EF66E7DFF9F98764DA_1067450052 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499651922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499651922;
            }
    if(other instanceof ScheduledFutureTask)            
            {
                ScheduledFutureTask<?> x = (ScheduledFutureTask<?>)other;
                long diff = time - x.time;
    if(diff < 0)                
                {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1219403671 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801059920 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801059920;
                }
                else
    if(diff > 0)                
                {
                int varC4CA4238A0B923820DCC509A6F75849B_405105528 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195269105 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195269105;
                }
                else
    if(sequenceNumber < x.sequenceNumber)                
                {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1464346862 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742940731 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1742940731;
                }
                else
                {
                int varC4CA4238A0B923820DCC509A6F75849B_134642690 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638271484 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638271484;
                }
            } //End block
            long d = (getDelay(TimeUnit.NANOSECONDS) -
                      other.getDelay(TimeUnit.NANOSECONDS));
            int var5A2C85982B976DEBF1169EF72ABEF175_1759148113 = ((d == 0) ? 0 : ((d < 0) ? -1 : 1));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908787771 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908787771;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.265 -0400", hash_original_method = "28936E7BC66C2ACF8A84332D0E4F56D6", hash_generated_method = "D65C30216EECC1536D63DF64DB1DF7F2")
        public boolean isPeriodic() {
            boolean var0D8D214ED9AA8437630C1305DCDAC649_2040974294 = (period != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_427732661 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_427732661;
            // ---------- Original Method ----------
            //return period != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.266 -0400", hash_original_method = "AD0F8B1CE8B17F01519D37E93CCE792B", hash_generated_method = "2C5B79ED8658044948D37A8C1CAADFD0")
        private void setNextRunTime() {
            long p = period;
    if(p > 0)            
            time += p;
            else
            time = triggerTime(-p);
            // ---------- Original Method ----------
            //long p = period;
            //if (p > 0)
                //time += p;
            //else
                //time = triggerTime(-p);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.266 -0400", hash_original_method = "A46BB14AFBF2EAB15C2BA654B07B241E", hash_generated_method = "03B626C59851F01A7F4A21F29EEA39B1")
        public boolean cancel(boolean mayInterruptIfRunning) {
            addTaint(mayInterruptIfRunning);
            boolean cancelled = super.cancel(mayInterruptIfRunning);
    if(cancelled && removeOnCancel && heapIndex >= 0)            
            remove(this);
            boolean var38881E0A24039DC2621E1D6F86CB71F7_1519432795 = (cancelled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145819408 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145819408;
            // ---------- Original Method ----------
            //boolean cancelled = super.cancel(mayInterruptIfRunning);
            //if (cancelled && removeOnCancel && heapIndex >= 0)
                //remove(this);
            //return cancelled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.266 -0400", hash_original_method = "A673F57B6994AD18C8F1F59AB6BC8846", hash_generated_method = "E871BA9CFF53FECC37DD3306693D802C")
        public void run() {
            boolean periodic = isPeriodic();
    if(!canRunInCurrentRunState(periodic))            
            cancel(false);
            else
    if(!periodic)            
            ScheduledFutureTask.super.run();
            else
    if(ScheduledFutureTask.super.runAndReset())            
            {
                setNextRunTime();
                reExecutePeriodic(outerTask);
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.267 -0400", hash_original_field = "61F48537D5CDD107448F51065089B906", hash_generated_field = "7E3ECE26F4AF2143E2D648A19C272D90")

        private RunnableScheduledFuture[] queue = new RunnableScheduledFuture[INITIAL_CAPACITY];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.267 -0400", hash_original_field = "CD2F0EC2CC3E15FC9F14D13EF4CCDCBB", hash_generated_field = "8AC82AC4B8DAC99417915B9333B3E7C3")

        private final ReentrantLock lock = new ReentrantLock();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.267 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "C5D9FEC4EFB462C8A221F2C08D178643")

        private int size = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.267 -0400", hash_original_field = "82A63DA99F8F58D581BB3EF9928D99E4", hash_generated_field = "F986E3D55ACB2544F93BB697B2C53FDD")

        private Thread leader = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.267 -0400", hash_original_field = "F12F9049DC39DE18B81748F5CE552E9E", hash_generated_field = "8F68EB44F62428E1E0B61A4952227D3F")

        private final Condition available = lock.newCondition();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.267 -0400", hash_original_method = "5917AE9375A9F0D7E6AA869E9A88CC5E", hash_generated_method = "5917AE9375A9F0D7E6AA869E9A88CC5E")
        public DelayedWorkQueue ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.268 -0400", hash_original_method = "871562DD277C0AC8BA441D82903E861A", hash_generated_method = "A2C53C2309413CED15321F200F5F1DAE")
        private void setIndex(RunnableScheduledFuture f, int idx) {
            addTaint(idx);
            addTaint(f.getTaint());
    if(f instanceof ScheduledFutureTask)            
            ((ScheduledFutureTask)f).heapIndex = idx;
            // ---------- Original Method ----------
            //if (f instanceof ScheduledFutureTask)
                //((ScheduledFutureTask)f).heapIndex = idx;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.269 -0400", hash_original_method = "82039C4DF7CA25BEE85708617CA17C0A", hash_generated_method = "A81A70FEDAD3242E6F6F3034E7F90834")
        private void siftUp(int k, RunnableScheduledFuture key) {
            while
(k > 0)            
            {
                int parent = (k - 1) >>> 1;
                RunnableScheduledFuture e = queue[parent];
    if(key.compareTo(e) >= 0)                
                break;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.270 -0400", hash_original_method = "2B1F11A0F086CDEBFE52E8E81BF54F43", hash_generated_method = "02C04E8F52483FB1DA198C6724577D3D")
        private void siftDown(int k, RunnableScheduledFuture key) {
            int half = size >>> 1;
            while
(k < half)            
            {
                int child = (k << 1) + 1;
                RunnableScheduledFuture c = queue[child];
                int right = child + 1;
    if(right < size && c.compareTo(queue[right]) > 0)                
                c = queue[child = right];
    if(key.compareTo(c) <= 0)                
                break;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.270 -0400", hash_original_method = "A3FC13DF1E683960EBCF25B1C68B6117", hash_generated_method = "22A15400E6CEAE45BB74CE06A79658E8")
        private void grow() {
            int oldCapacity = queue.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
    if(newCapacity < 0)            
            newCapacity = Integer.MAX_VALUE;
            queue = Arrays.copyOf(queue, newCapacity);
            // ---------- Original Method ----------
            //int oldCapacity = queue.length;
            //int newCapacity = oldCapacity + (oldCapacity >> 1);
            //if (newCapacity < 0) 
                //newCapacity = Integer.MAX_VALUE;
            //queue = Arrays.copyOf(queue, newCapacity);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.271 -0400", hash_original_method = "C580641A4A2388B58215BACCB42FFCE3", hash_generated_method = "B95CFFE32A328CC35FA8F933997B0094")
        private int indexOf(Object x) {
            addTaint(x.getTaint());
    if(x != null)            
            {
    if(x instanceof ScheduledFutureTask)                
                {
                    int i = ((ScheduledFutureTask) x).heapIndex;
    if(i >= 0 && i < size && queue[i] == x)                    
                    {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1854566853 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416158730 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416158730;
                    }
                } //End block
                else
                {
for(int i = 0;i < size;i++)
    if(x.equals(queue[i]))                    
                    {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_47671168 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1760505316 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1760505316;
                    }
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1577229598 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757099550 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757099550;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.271 -0400", hash_original_method = "5E09E7103DB0A49A13B2DDAFBB485D60", hash_generated_method = "509228BB958B7F926C03DE8BF3BFF7DA")
        public boolean contains(Object x) {
            addTaint(x.getTaint());
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
                boolean var54D34D412CCB92E9A609873D6F2FB757_1262533751 = (indexOf(x) != -1);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087645229 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087645229;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return indexOf(x) != -1;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.272 -0400", hash_original_method = "BE80A65233BEEC20C44EE13577B8F6B3", hash_generated_method = "10A77C82193E870F8B28D0DF03DC3E9D")
        public boolean remove(Object x) {
            addTaint(x.getTaint());
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
                int i = indexOf(x);
    if(i < 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1468622792 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529052060 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_529052060;
                }
                setIndex(queue[i], -1);
                int s = --size;
                RunnableScheduledFuture replacement = queue[s];
                queue[s] = null;
    if(s != i)                
                {
                    siftDown(i, replacement);
    if(queue[i] == replacement)                    
                    siftUp(i, replacement);
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_90326479 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756361331 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_756361331;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.272 -0400", hash_original_method = "FB53A461CD3B1BACC3DB27D415F5CC64", hash_generated_method = "DEADAD3518E1FE75AB96DE80857D25F9")
        public int size() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
                int varF7BD60B75B29D79B660A2859395C1A24_1035494189 = (size);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890225883 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890225883;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return size;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.273 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "96C166EA81B280DFFD02ED7E39A74B7A")
        public boolean isEmpty() {
            boolean var5BD3446419BAE72903C4742BF777F0E0_1982467796 = (size() == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_743891998 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_743891998;
            // ---------- Original Method ----------
            //return size() == 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.273 -0400", hash_original_method = "E7CDD1D543D1F61B1D969765A4629893", hash_generated_method = "541887B94F260399BC38FDDB6C7A9E31")
        public int remainingCapacity() {
            int varE7A95D949116A2DA0F0FA83DC6E76C00_718937268 = (Integer.MAX_VALUE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1885865433 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1885865433;
            // ---------- Original Method ----------
            //return Integer.MAX_VALUE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.273 -0400", hash_original_method = "71D771244E4BD1C0173C42068DB81D51", hash_generated_method = "9CF6805842B34A4A7BB4811FEDEEA612")
        public RunnableScheduledFuture peek() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
RunnableScheduledFuture var6B197F94F16A075B757ED2FE0B3729CA_1583951770 =                 queue[0];
                var6B197F94F16A075B757ED2FE0B3729CA_1583951770.addTaint(taint);
                return var6B197F94F16A075B757ED2FE0B3729CA_1583951770;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return queue[0];
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.274 -0400", hash_original_method = "A5863DDF2D55F0A792F5570CB9552D10", hash_generated_method = "1AC48FCD42745F3A4BC6D29862FE07B0")
        public boolean offer(Runnable x) {
            addTaint(x.getTaint());
    if(x == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_854830011 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_854830011.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_854830011;
            }
            RunnableScheduledFuture e = (RunnableScheduledFuture)x;
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
                int i = size;
    if(i >= queue.length)                
                grow();
                size = i + 1;
    if(i == 0)                
                {
                    queue[0] = e;
                    setIndex(e, 0);
                } //End block
                else
                {
                    siftUp(i, e);
                } //End block
    if(queue[0] == e)                
                {
                    leader = null;
                    available.signal();
                } //End block
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1266803914 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1855836419 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1855836419;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.275 -0400", hash_original_method = "4080BF206CA14D39406126FB9F6C27D2", hash_generated_method = "4DA2E5A6700905A2EC1394E32EB2DE01")
        public void put(Runnable e) {
            addTaint(e.getTaint());
            offer(e);
            // ---------- Original Method ----------
            //offer(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.275 -0400", hash_original_method = "AD0F5DE8A091A43B7107BCF4BE0853B5", hash_generated_method = "E27CAC5A22C2F260BD5027CA7E359E48")
        public boolean add(Runnable e) {
            addTaint(e.getTaint());
            boolean var753C0332450253282F40FDC9097055BE_1369830565 = (offer(e));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206965257 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206965257;
            // ---------- Original Method ----------
            //return offer(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.276 -0400", hash_original_method = "C6567B4A0AA1C7B283CF9843CADA74F7", hash_generated_method = "8401E7EBEFBBBB64EEBF4F773EB5B31E")
        public boolean offer(Runnable e, long timeout, TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(timeout);
            addTaint(e.getTaint());
            boolean var753C0332450253282F40FDC9097055BE_348546243 = (offer(e));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_438042276 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_438042276;
            // ---------- Original Method ----------
            //return offer(e);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.276 -0400", hash_original_method = "95AFA75D0998C104C226840186514FC9", hash_generated_method = "F3093EAE33B49C32B1DC61BD4FF1CBDE")
        private RunnableScheduledFuture finishPoll(RunnableScheduledFuture f) {
            addTaint(f.getTaint());
            int s = --size;
            RunnableScheduledFuture x = queue[s];
            queue[s] = null;
    if(s != 0)            
            siftDown(0, x);
            setIndex(f, -1);
RunnableScheduledFuture varABE3CFB53FE4A79F34CB25BC80BFD6E2_2071179666 =             f;
            varABE3CFB53FE4A79F34CB25BC80BFD6E2_2071179666.addTaint(taint);
            return varABE3CFB53FE4A79F34CB25BC80BFD6E2_2071179666;
            // ---------- Original Method ----------
            //int s = --size;
            //RunnableScheduledFuture x = queue[s];
            //queue[s] = null;
            //if (s != 0)
                //siftDown(0, x);
            //setIndex(f, -1);
            //return f;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.286 -0400", hash_original_method = "8EBCD245EA652A524E679A63C787A99C", hash_generated_method = "12554E274A8E277FADAD1884E6205910")
        public RunnableScheduledFuture poll() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
                RunnableScheduledFuture first = queue[0];
    if(first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0)                
                {
RunnableScheduledFuture var540C13E9E156B687226421B24F2DF178_95743226 =                 null;
                var540C13E9E156B687226421B24F2DF178_95743226.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_95743226;
                }
                else
                {
RunnableScheduledFuture var783EE317EF3F20F6DB2D0D3EF00DE570_2090662170 =                 finishPoll(first);
                var783EE317EF3F20F6DB2D0D3EF00DE570_2090662170.addTaint(taint);
                return var783EE317EF3F20F6DB2D0D3EF00DE570_2090662170;
                }
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.288 -0400", hash_original_method = "C35B04B198E2C5886DA81FEFBA3F2D77", hash_generated_method = "1FAC00FE0D440703793562D5BF47BF67")
        public RunnableScheduledFuture take() throws InterruptedException {
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try 
            {
for(;;)
                {
                    RunnableScheduledFuture first = queue[0];
    if(first == null)                    
                    available.await();
                    else
                    {
                        long delay = first.getDelay(TimeUnit.NANOSECONDS);
    if(delay <= 0)                        
                        {
RunnableScheduledFuture var783EE317EF3F20F6DB2D0D3EF00DE570_817894515 =                         finishPoll(first);
                        var783EE317EF3F20F6DB2D0D3EF00DE570_817894515.addTaint(taint);
                        return var783EE317EF3F20F6DB2D0D3EF00DE570_817894515;
                        }
                        else
    if(leader != null)                        
                        available.await();
                        else
                        {
                            Thread thisThread = Thread.currentThread();
                            leader = thisThread;
                            try 
                            {
                                available.awaitNanos(delay);
                            } //End block
                            finally 
                            {
    if(leader == thisThread)                                
                                leader = null;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
    if(leader == null && queue[0] != null)                
                available.signal();
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.291 -0400", hash_original_method = "72DE523456D313A78DBDBA042B83CE23", hash_generated_method = "9BF9D947D309F9835DD7EC3697B582FB")
        public RunnableScheduledFuture poll(long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            long nanos = unit.toNanos(timeout);
            final ReentrantLock lock = this.lock;
            lock.lockInterruptibly();
            try 
            {
for(;;)
                {
                    RunnableScheduledFuture first = queue[0];
    if(first == null)                    
                    {
    if(nanos <= 0)                        
                        {
RunnableScheduledFuture var540C13E9E156B687226421B24F2DF178_376374755 =                         null;
                        var540C13E9E156B687226421B24F2DF178_376374755.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_376374755;
                        }
                        else
                        nanos = available.awaitNanos(nanos);
                    } //End block
                    else
                    {
                        long delay = first.getDelay(TimeUnit.NANOSECONDS);
    if(delay <= 0)                        
                        {
RunnableScheduledFuture var783EE317EF3F20F6DB2D0D3EF00DE570_1791023175 =                         finishPoll(first);
                        var783EE317EF3F20F6DB2D0D3EF00DE570_1791023175.addTaint(taint);
                        return var783EE317EF3F20F6DB2D0D3EF00DE570_1791023175;
                        }
    if(nanos <= 0)                        
                        {
RunnableScheduledFuture var540C13E9E156B687226421B24F2DF178_819316741 =                         null;
                        var540C13E9E156B687226421B24F2DF178_819316741.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_819316741;
                        }
    if(nanos < delay || leader != null)                        
                        nanos = available.awaitNanos(nanos);
                        else
                        {
                            Thread thisThread = Thread.currentThread();
                            leader = thisThread;
                            try 
                            {
                                long timeLeft = available.awaitNanos(delay);
                                nanos -= delay - timeLeft;
                            } //End block
                            finally 
                            {
    if(leader == thisThread)                                
                                leader = null;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
    if(leader == null && queue[0] != null)                
                available.signal();
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.292 -0400", hash_original_method = "B7A92D7F07FC88CC462E2031E3EC4D97", hash_generated_method = "CAA6E78438EAF0F6CBE23C0ABE2B71C9")
        public void clear() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
for(int i = 0;i < size;i++)
                {
                    RunnableScheduledFuture t = queue[i];
    if(t != null)                    
                    {
                        queue[i] = null;
                        setIndex(t, -1);
                    } //End block
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.293 -0400", hash_original_method = "2FE630D35A7B40B0A6753A3386B27535", hash_generated_method = "A778C10D5A1D785806DA0CD6226384BF")
        private RunnableScheduledFuture pollExpired() {
            RunnableScheduledFuture first = queue[0];
    if(first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0)            
            {
RunnableScheduledFuture var540C13E9E156B687226421B24F2DF178_1269043931 =             null;
            var540C13E9E156B687226421B24F2DF178_1269043931.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1269043931;
            }
RunnableScheduledFuture var783EE317EF3F20F6DB2D0D3EF00DE570_838636062 =             finishPoll(first);
            var783EE317EF3F20F6DB2D0D3EF00DE570_838636062.addTaint(taint);
            return var783EE317EF3F20F6DB2D0D3EF00DE570_838636062;
            // ---------- Original Method ----------
            //RunnableScheduledFuture first = queue[0];
            //if (first == null || first.getDelay(TimeUnit.NANOSECONDS) > 0)
                //return null;
            //return finishPoll(first);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.293 -0400", hash_original_method = "A0CF55F6497A110CDDFF356DE0AE8664", hash_generated_method = "0B22C4040091BCA9E9C7E3ED588A5D6E")
        public int drainTo(Collection<? super Runnable> c) {
            addTaint(c.getTaint());
    if(c == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_731300573 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_731300573.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_731300573;
            }
    if(c == this)            
            {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_41840363 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_41840363.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_41840363;
            }
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
                RunnableScheduledFuture first;
                int n = 0;
                while
((first = pollExpired()) != null)                
                {
                    c.add(first);
                    ++n;
                } //End block
                int var7B8B965AD4BCA0E41AB51DE7B31363A1_1923064814 = (n);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409609100 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409609100;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.294 -0400", hash_original_method = "0279366BCBF84614051CBA5B08204A0A", hash_generated_method = "6DC695B0959BD709127BC9988D720D12")
        public int drainTo(Collection<? super Runnable> c, int maxElements) {
            addTaint(maxElements);
            addTaint(c.getTaint());
    if(c == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1484229606 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1484229606.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1484229606;
            }
    if(c == this)            
            {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1905117414 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1905117414.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1905117414;
            }
    if(maxElements <= 0)            
            {
            int varCFCD208495D565EF66E7DFF9F98764DA_1330105274 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895018776 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895018776;
            }
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
                RunnableScheduledFuture first;
                int n = 0;
                while
(n < maxElements && (first = pollExpired()) != null)                
                {
                    c.add(first);
                    ++n;
                } //End block
                int var7B8B965AD4BCA0E41AB51DE7B31363A1_512518240 = (n);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667384571 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667384571;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.295 -0400", hash_original_method = "7408B58852530A87736A5AD8CAD9599F", hash_generated_method = "BCC313CCDBDF76FCED2E95EBFDFEA101")
        public Object[] toArray() {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
Object[] var3FF56653DBD966470290DFA853FBED83_3026448 =                 Arrays.copyOf(queue, size, Object[].class);
                var3FF56653DBD966470290DFA853FBED83_3026448.addTaint(taint);
                return var3FF56653DBD966470290DFA853FBED83_3026448;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = this.lock;
            //lock.lock();
            //try {
                //return Arrays.copyOf(queue, size, Object[].class);
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.295 -0400", hash_original_method = "C537847CD06DB8C82AFD734BEA1D62C4", hash_generated_method = "AD7077E4B3DA777E4A0144C8F5AA214A")
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            final ReentrantLock lock = this.lock;
            lock.lock();
            try 
            {
    if(a.length < size)                
                {
T[] varD7F9E2498EEEC82C28C16468811B6DF2_1798579974 =                 (T[]) Arrays.copyOf(queue, size, a.getClass());
                varD7F9E2498EEEC82C28C16468811B6DF2_1798579974.addTaint(taint);
                return varD7F9E2498EEEC82C28C16468811B6DF2_1798579974;
                }
                System.arraycopy(queue, 0, a, 0, size);
    if(a.length > size)                
                a[size] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_1112510016 =                 a;
                var3F5343BF1D849954A73F0BB303805FFD_1112510016.addTaint(taint);
                return var3F5343BF1D849954A73F0BB303805FFD_1112510016;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.296 -0400", hash_original_method = "46B1FB64DFD489BA9D84B29257E9B6C6", hash_generated_method = "D56FFB6EE0CB78021EFBF4599A6E2370")
        public Iterator<Runnable> iterator() {
Iterator<Runnable> var204ADEB76305F0F46DB2D7013588DB62_802996502 =             new Itr(Arrays.copyOf(queue, size));
            var204ADEB76305F0F46DB2D7013588DB62_802996502.addTaint(taint);
            return var204ADEB76305F0F46DB2D7013588DB62_802996502;
            // ---------- Original Method ----------
            //return new Itr(Arrays.copyOf(queue, size));
        }

        
        private class Itr implements Iterator<Runnable> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.296 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "81254B9FC545B41C37906F59020B61EA")

            RunnableScheduledFuture[] array;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.296 -0400", hash_original_field = "450022C54ECA00D933A53196B279FDDD", hash_generated_field = "EF6EF07B89CC96321B7CFBEF54BCF418")

            int cursor = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.296 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "9128B9A3EF0151CBF070702BF3C62C66")

            int lastRet = -1;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.297 -0400", hash_original_method = "78BE11BC04A59F667BA3E745B91EA864", hash_generated_method = "ABE1A6D5F6CC1003308B5A0719A48D00")
              Itr(RunnableScheduledFuture[] array) {
                this.array = array;
                // ---------- Original Method ----------
                //this.array = array;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.297 -0400", hash_original_method = "C1264B905CC60CA39EE5BE51F177AC9A", hash_generated_method = "3FEC0178F30D8A7E4790C311FB9C0748")
            public boolean hasNext() {
                boolean varD3AC5C71D433D60E62F9BE66035EAE94_1256637129 = (cursor < array.length);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051639231 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051639231;
                // ---------- Original Method ----------
                //return cursor < array.length;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.297 -0400", hash_original_method = "3D0866C62F631AE1F3281A9951BE6C06", hash_generated_method = "B55BCA82FEC3C6B64108C8FEA9732268")
            public Runnable next() {
    if(cursor >= array.length)                
                {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_605657387 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_605657387.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_605657387;
                }
                lastRet = cursor;
Runnable var21E6AD48A912A3158B7B729FDCFBCCF7_281661468 =                 array[cursor++];
                var21E6AD48A912A3158B7B729FDCFBCCF7_281661468.addTaint(taint);
                return var21E6AD48A912A3158B7B729FDCFBCCF7_281661468;
                // ---------- Original Method ----------
                //if (cursor >= array.length)
                    //throw new NoSuchElementException();
                //lastRet = cursor;
                //return array[cursor++];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.298 -0400", hash_original_method = "560EEAA350DF5EAA4CBD4C138A91D642", hash_generated_method = "C8A1ED78F39653E2E336005FCBC0983E")
            public void remove() {
    if(lastRet < 0)                
                {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2009569146 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_2009569146.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_2009569146;
                }
                DelayedWorkQueue.this.remove(array[lastRet]);
                lastRet = -1;
                // ---------- Original Method ----------
                //if (lastRet < 0)
                    //throw new IllegalStateException();
                //DelayedWorkQueue.this.remove(array[lastRet]);
                //lastRet = -1;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.298 -0400", hash_original_field = "60E8041D14101DDB569AC77FCB6B5097", hash_generated_field = "3F2F6BC48DD22A811C2EB325F2D915D6")

        private static final int INITIAL_CAPACITY = 16;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.298 -0400", hash_original_field = "D8FDF1FE130A58926F6239A3C9466239", hash_generated_field = "09EC8D93792C347004E9D906B28CD479")

    private static final AtomicLong sequencer = new AtomicLong(0);
}

