package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Timer {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.157 -0500", hash_original_method = "583B36D89F2230FC842E9DB40CDF730D", hash_generated_method = "F6AED2A8A3D3246BB251352889CBE974")
    
private synchronized static long nextId() {
        return timerId++;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.154 -0500", hash_original_field = "275662F311FA6F70B6AC8B7C0851A93A", hash_generated_field = "AE70AF39EAB820096114FC8C9C2796F7")

    private static long timerId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.159 -0500", hash_original_field = "0DFC13B34E003C343B9C8B89D1EEE128", hash_generated_field = "BD810B8E7F0EAA2CFBEB665BD5956193")

    private  TimerImpl impl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.162 -0500", hash_original_field = "1FF311AD1A7908BEBD237F6DC91C540B", hash_generated_field = "BE0845D4DD46C2E4FF9E16078B08E358")

    @SuppressWarnings("unused")
    private  FinalizerHelper finalizer;

    /**
     * Creates a new named {@code Timer} which may be specified to be run as a
     * daemon thread.
     *
     * @param name the name of the {@code Timer}.
     * @param isDaemon true if {@code Timer}'s thread should be a daemon thread.
     * @throws NullPointerException is {@code name} is {@code null}
     */
    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.165 -0500", hash_original_method = "CCBAE4C218CB3D4968980BC5ABE4FF3C", hash_generated_method = "4F4050F2B2137BAFABE65E241132CEDE")
    
public Timer(String name, boolean isDaemon) {
        if (name == null) {
            throw new NullPointerException("name is null");
        }
        this.impl = new TimerImpl(name, isDaemon);
        this.finalizer = new FinalizerHelper(impl);
    }

    /**
     * Creates a new named {@code Timer} which does not run as a daemon thread.
     *
     * @param name the name of the Timer.
     * @throws NullPointerException is {@code name} is {@code null}
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.168 -0500", hash_original_method = "02AE08AD1BF27E917ED31D51A1B3D791", hash_generated_method = "DE017D6B334B8FAA16AEDBC01E009554")
    
public Timer(String name) {
        this(name, false);
    }

    /**
     * Creates a new {@code Timer} which may be specified to be run as a daemon thread.
     *
     * @param isDaemon {@code true} if the {@code Timer}'s thread should be a daemon thread.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.171 -0500", hash_original_method = "70CAEF4BF7F4A75D51C26667927F81EF", hash_generated_method = "15B6642BB509B71CA62741487A9CB5D4")
    
public Timer(boolean isDaemon) {
        this("Timer-" + Timer.nextId(), isDaemon);
    }

    /**
     * Creates a new non-daemon {@code Timer}.
     */
    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.174 -0500", hash_original_method = "0270210C5FDC4EA43E305D84D4C8B476", hash_generated_method = "499A560DBC0C5BDE6B1755B6E5AC6650")
    
public Timer() {
        this(false);
    }

    /**
     * Cancels the {@code Timer} and all scheduled tasks. If there is a
     * currently running task it is not affected. No more tasks may be scheduled
     * on this {@code Timer}. Subsequent calls do nothing.
     */
    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.176 -0500", hash_original_method = "4F9571F346BBFC93F458CCCC1BA285E2", hash_generated_method = "D6F90BEE6A18F57B30D55128B8FFAEB3")
    
public void cancel() {
        impl.cancel();
    }

    /**
     * Removes all canceled tasks from the task queue. If there are no
     * other references on the tasks, then after this call they are free
     * to be garbage collected.
     *
     * @return the number of canceled tasks that were removed from the task
     *         queue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.178 -0500", hash_original_method = "0B011E4041136408340083F55A5156B3", hash_generated_method = "407F6F402D6B283873CE3DF652B88B34")
    
public int purge() {
        synchronized (impl) {
            return impl.purge();
        }
    }

    /**
     * Schedule a task for single execution. If {@code when} is less than the
     * current time, it will be scheduled to be executed as soon as possible.
     *
     * @param task
     *            the task to schedule.
     * @param when
     *            time of execution.
     * @throws IllegalArgumentException
     *                if {@code when.getTime() < 0}.
     * @throws IllegalStateException
     *                if the {@code Timer} has been canceled, or if the task has been
     *                scheduled or canceled.
     */
    @DSSpec(DSCat.EXEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.181 -0500", hash_original_method = "11725ACE17CC712A9ECE78E61369355E", hash_generated_method = "E5FBDC3B831A54ED62987E03F41010FB")
    
public void schedule(TimerTask task, Date when) {
        if (when.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        long delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, -1, false);
    }

    /**
     * Schedule a task for single execution after a specified delay.
     *
     * @param task
     *            the task to schedule.
     * @param delay
     *            amount of time in milliseconds before execution.
     * @throws IllegalArgumentException
     *                if {@code delay < 0}.
     * @throws IllegalStateException
     *                if the {@code Timer} has been canceled, or if the task has been
     *                scheduled or canceled.
     */
    @DSComment("callback needs to be called")
    @DSSpec(DSCat.TO_MODEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.184 -0500", hash_original_method = "C70A5270C6C8A079FCAADE9A65184BCF", hash_generated_method = "A193FECA312B4466BB2570207EDE17A7")
    
public void schedule(TimerTask task, long delay) {
        if (delay < 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(task, delay, -1, false);
    }

    /**
     * Schedule a task for repeated fixed-delay execution after a specific delay.
     *
     * @param task
     *            the task to schedule.
     * @param delay
     *            amount of time in milliseconds before first execution.
     * @param period
     *            amount of time in milliseconds between subsequent executions.
     * @throws IllegalArgumentException
     *                if {@code delay < 0} or {@code period <= 0}.
     * @throws IllegalStateException
     *                if the {@code Timer} has been canceled, or if the task has been
     *                scheduled or canceled.
     */
    @DSSpec(DSCat.EXEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.187 -0500", hash_original_method = "2638FF3E02C15EB097A85AD3BAF82535", hash_generated_method = "B03E339FC2895DF48CBE79037980BEB1")
    
public void schedule(TimerTask task, long delay, long period) {
        if (delay < 0 || period <= 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(task, delay, period, false);
    }

    /**
     * Schedule a task for repeated fixed-delay execution after a specific time
     * has been reached.
     *
     * @param task
     *            the task to schedule.
     * @param when
     *            time of first execution.
     * @param period
     *            amount of time in milliseconds between subsequent executions.
     * @throws IllegalArgumentException
     *                if {@code when.getTime() < 0} or {@code period <= 0}.
     * @throws IllegalStateException
     *                if the {@code Timer} has been canceled, or if the task has been
     *                scheduled or canceled.
     */
    @DSSpec(DSCat.EXEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.189 -0500", hash_original_method = "D1ECD2ED5B40CEEFE097F1521E46D9CD", hash_generated_method = "BC7567E4F469DC71F10170E64C7B8281")
    
public void schedule(TimerTask task, Date when, long period) {
        if (period <= 0 || when.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        long delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, period, false);
    }

    /**
     * Schedule a task for repeated fixed-rate execution after a specific delay
     * has passed.
     *
     * @param task
     *            the task to schedule.
     * @param delay
     *            amount of time in milliseconds before first execution.
     * @param period
     *            amount of time in milliseconds between subsequent executions.
     * @throws IllegalArgumentException
     *                if {@code delay < 0} or {@code period <= 0}.
     * @throws IllegalStateException
     *                if the {@code Timer} has been canceled, or if the task has been
     *                scheduled or canceled.
     */
    @DSComment("callback needs to be called")
    @DSSpec(DSCat.TO_MODEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.192 -0500", hash_original_method = "5346126CCA7833D0BFEF2BABD1293D7B", hash_generated_method = "834C458F3EDB574F1E7D5FF6A1B3C05A")
    
public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        if (delay < 0 || period <= 0) {
            throw new IllegalArgumentException();
        }
        scheduleImpl(task, delay, period, true);
    }

    /**
     * Schedule a task for repeated fixed-rate execution after a specific time
     * has been reached.
     *
     * @param task
     *            the task to schedule.
     * @param when
     *            time of first execution.
     * @param period
     *            amount of time in milliseconds between subsequent executions.
     * @throws IllegalArgumentException
     *                if {@code when.getTime() < 0} or {@code period <= 0}.
     * @throws IllegalStateException
     *                if the {@code Timer} has been canceled, or if the task has been
     *                scheduled or canceled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.194 -0500", hash_original_method = "6589A168C51AEA92DBDCD8B282926324", hash_generated_method = "6DBB8521784273138C30FBFC45BA2EEC")
    
public void scheduleAtFixedRate(TimerTask task, Date when, long period) {
        if (period <= 0 || when.getTime() < 0) {
            throw new IllegalArgumentException();
        }
        long delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay, period, true);
    }
    
    private static final class TimerImpl extends Thread {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.116 -0500", hash_original_field = "FE3EA34D60211B160636288AB9105E56", hash_generated_field = "DD77D1125D3DB6D338BBBF7F15E50974")

        private boolean cancelled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.119 -0500", hash_original_field = "59CD61E3A383ACAD01F8F1AA33285180", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

        private boolean finished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.122 -0500", hash_original_field = "53CC16C7CE103DF7D8BFFB50A101CC6F", hash_generated_field = "42B47F8DE84F38316DBD90F59FBB0655")

        private TimerHeap tasks = new TimerHeap();

        /**
         * Starts a new timer.
         *
         * @param name thread's name
         * @param isDaemon daemon thread or not
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.125 -0500", hash_original_method = "F4DF6B4551FDBC23EEE87B7E4E870504", hash_generated_method = "F4DF6B4551FDBC23EEE87B7E4E870504")
        
TimerImpl(String name, boolean isDaemon) {
            this.setName(name);
            this.setDaemon(isDaemon);
            this.start();
        }

        /**
         * This method will be launched on separate thread for each Timer
         * object.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.129 -0500", hash_original_method = "F5D6E902D7971393BC779DF27078ED52", hash_generated_method = "62FF54BB817CCC7842C56839A52B4CB8")
        
@Override
        public void run() {
            while (true) {
                TimerTask task;
                synchronized (this) {
                    // need to check cancelled inside the synchronized block
                    if (cancelled) {
                        return;
                    }
                    if (tasks.isEmpty()) {
                        if (finished) {
                            return;
                        }
                        // no tasks scheduled -- sleep until any task appear
                        try {
                            this.wait();
                        } catch (InterruptedException ignored) {
                        }
                        continue;
                    }

                    long currentTime = System.currentTimeMillis();

                    task = tasks.minimum();
                    long timeToSleep;

                    synchronized (task.lock) {
                        if (task.cancelled) {
                            tasks.delete(0);
                            continue;
                        }

                        // check the time to sleep for the first task scheduled
                        timeToSleep = task.when - currentTime;
                    }

                    if (timeToSleep > 0) {
                        // sleep!
                        try {
                            this.wait(timeToSleep);
                        } catch (InterruptedException ignored) {
                        }
                        continue;
                    }

                    // no sleep is necessary before launching the task

                    synchronized (task.lock) {
                        int pos = 0;
                        if (tasks.minimum().when != task.when) {
                            pos = tasks.getTask(task);
                        }
                        if (task.cancelled) {
                            tasks.delete(tasks.getTask(task));
                            continue;
                        }

                        // set time to schedule
                        task.setScheduledTime(task.when);

                        // remove task from queue
                        tasks.delete(pos);

                        // set when the next task should be launched
                        if (task.period >= 0) {
                            // this is a repeating task,
                            if (task.fixedRate) {
                                // task is scheduled at fixed rate
                                task.when = task.when + task.period;
                            } else {
                                // task is scheduled at fixed delay
                                task.when = System.currentTimeMillis()
                                        + task.period;
                            }

                            // insert this task into queue
                            insertTask(task);
                        } else {
                            task.when = 0;
                        }
                    }
                }

                boolean taskCompletedNormally = false;
                try {
                    task.run();
                    taskCompletedNormally = true;
                } finally {
                    if (!taskCompletedNormally) {
                        synchronized (this) {
                            cancelled = true;
                        }
                    }
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.132 -0500", hash_original_method = "1179C8665DD7C88A3DCD4C96D03B447E", hash_generated_method = "3A09465985A4325B7F092E5B20961DFF")
        
private void insertTask(TimerTask newTask) {
            // callers are synchronized
            tasks.insert(newTask);
            this.notify();
        }

        /**
         * Cancels timer.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.135 -0500", hash_original_method = "98F63C51B8CE3B66A34B3D1691EEC660", hash_generated_method = "57C0EB29DDC4CE42B3474704D7BE0604")
        
public synchronized void cancel() {
            cancelled = true;
            tasks.reset();
            this.notify();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.137 -0500", hash_original_method = "14258CF4E602CCBF988A676BE8DF635B", hash_generated_method = "029090D75516A1530E1FF78B95F06C8D")
        
public int purge() {
            if (tasks.isEmpty()) {
                return 0;
            }
            // callers are synchronized
            tasks.deletedCancelledNumber = 0;
            tasks.deleteIfCancelled();
            return tasks.deletedCancelledNumber;
        }
        
        private static final class TimerHeap {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.073 -0500", hash_original_field = "F8F93760EFC80DEB2BBE0C4A73D7D09C", hash_generated_field = "5DCC43DD97C899F4FF86DBEA0DEC4532")

            private int DEFAULT_HEAP_SIZE = 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.077 -0500", hash_original_field = "C0BBEC6DD6CE83ECEAC1379936106291", hash_generated_field = "E31F25F3395C26BA2E25CE6943B12BB4")

            private TimerTask[] timers = new TimerTask[DEFAULT_HEAP_SIZE];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.080 -0500", hash_original_field = "689FC3CB9A887B5817C15E9CFDD066DB", hash_generated_field = "C5D9FEC4EFB462C8A221F2C08D178643")

            private int size = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.082 -0500", hash_original_field = "24C516E967A43FAB3DB3AC3E500B20C3", hash_generated_field = "1B4C6ED5AD73B84D34A3A5D4C320C40E")

            private int deletedCancelledNumber = 0;
            
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.867 -0400", hash_original_method = "8C2F50BDBBFD0A7BB81F89CAC3407288", hash_generated_method = "8C2F50BDBBFD0A7BB81F89CAC3407288")
            public TimerHeap ()
            {
                //Synthesized constructor
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.085 -0500", hash_original_method = "54D4D4169DAC5C26DC557B9A789FA70D", hash_generated_method = "ED4BF57E53764DAD440F6C1B00506C4A")
            
public TimerTask minimum() {
                return timers[0];
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.088 -0500", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "BCEA08F5849F536168BFB81023CBA1DB")
            
public boolean isEmpty() {
                return size == 0;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.091 -0500", hash_original_method = "FCBB49BFF2D0F5589541AAD0BAE25774", hash_generated_method = "030CE70398FE05F29A22011D74E4A161")
            
public void insert(TimerTask task) {
                if (timers.length == size) {
                    TimerTask[] appendedTimers = new TimerTask[size * 2];
                    System.arraycopy(timers, 0, appendedTimers, 0, size);
                    timers = appendedTimers;
                }
                timers[size++] = task;
                upHeap();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.094 -0500", hash_original_method = "0B132463A6995D392821B524FFDE805E", hash_generated_method = "2DBF4CBC5D25AF722951C2A375D67B69")
            
public void delete(int pos) {
                // posible to delete any position of the heap
                if (pos >= 0 && pos < size) {
                    timers[pos] = timers[--size];
                    timers[size] = null;
                    downHeap(pos);
                }
            }

            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.097 -0500", hash_original_method = "4756DE20DDADB3FD04AA7E2F3A372FAC", hash_generated_method = "F6EFD1079C9FBFA191BB2B88B1CA4D54")
            
private void upHeap() {
                int current = size - 1;
                int parent = (current - 1) / 2;

                while (timers[current].when < timers[parent].when) {
                    // swap the two
                    TimerTask tmp = timers[current];
                    timers[current] = timers[parent];
                    timers[parent] = tmp;

                    // update pos and current
                    current = parent;
                    parent = (current - 1) / 2;
                }
            }

            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.100 -0500", hash_original_method = "A63AC6E1F65E01631F08DE00B4EE87D2", hash_generated_method = "A093CBF3F9B1D0E853F483CAE169BC01")
            
private void downHeap(int pos) {
                int current = pos;
                int child = 2 * current + 1;

                while (child < size && size > 0) {
                    // compare the children if they exist
                    if (child + 1 < size
                            && timers[child + 1].when < timers[child].when) {
                        child++;
                    }

                    // compare selected child with parent
                    if (timers[current].when < timers[child].when) {
                        break;
                    }

                    // swap the two
                    TimerTask tmp = timers[current];
                    timers[current] = timers[child];
                    timers[child] = tmp;

                    // update pos and current
                    current = child;
                    child = 2 * current + 1;
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.103 -0500", hash_original_method = "2535A97D037DD57E0DAFCE2BC7E2038E", hash_generated_method = "A8541D0113BBE8D165CCDF87F220241A")
            
public void reset() {
                timers = new TimerTask[DEFAULT_HEAP_SIZE];
                size = 0;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.106 -0500", hash_original_method = "D8C208FA954780F7AF0BEF19488333D3", hash_generated_method = "BB932E75A51CD9CD85D1EC96CC8B9310")
            
public void adjustMinimum() {
                downHeap(0);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.109 -0500", hash_original_method = "AE1ACEED0F069268C38EE209755704B2", hash_generated_method = "EDB95FA5FCC6D623E5ED7EF6EFD162D4")
            
public void deleteIfCancelled() {
                for (int i = 0; i < size; i++) {
                    if (timers[i].cancelled) {
                        deletedCancelledNumber++;
                        delete(i);
                        // re-try this point
                        i--;
                    }
                }
            }

            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.111 -0500", hash_original_method = "B28407BF2F77FCC6A87AD91AEA3746F4", hash_generated_method = "71B2343A558DA510F7E8C618FD4E1787")
            
private int getTask(TimerTask task) {
                for (int i = 0; i < timers.length; i++) {
                    if (timers[i] == task) {
                        return i;
                    }
                }
                return -1;
            }
            
        }
        
    }
    
    private static final class FinalizerHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.144 -0500", hash_original_field = "0DFC13B34E003C343B9C8B89D1EEE128", hash_generated_field = "BD810B8E7F0EAA2CFBEB665BD5956193")

        private  TimerImpl impl;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.147 -0500", hash_original_method = "433E2FD3ED4C8DEDF63A6DA216B65604", hash_generated_method = "433E2FD3ED4C8DEDF63A6DA216B65604")
        
FinalizerHelper(TimerImpl impl) {
            this.impl = impl;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.150 -0500", hash_original_method = "DFA080161CE25EF58ACF3FC158495E65", hash_generated_method = "5A682063EC7ACB978BD99CD6F76D4E71")
        
@Override protected void finalize() throws Throwable {
            try {
                synchronized (impl) {
                    impl.finished = true;
                    impl.notify();
                }
            } finally {
                super.finalize();
            }
        }
        
    }

    /*
     * Schedule a task.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.197 -0500", hash_original_method = "163F6B0C6203677A1F058E56FE2F9B83", hash_generated_method = "D8ABB86F6BE38A4B04DB74BF6B5FD7D6")
    
private void scheduleImpl(TimerTask task, long delay, long period, boolean fixed) {
        synchronized (impl) {
            if (impl.cancelled) {
                throw new IllegalStateException("Timer was canceled");
            }

            long when = delay + System.currentTimeMillis();

            if (when < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + when);
            }

            synchronized (task.lock) {
                if (task.isScheduled()) {
                    throw new IllegalStateException("TimerTask is scheduled already");
                }

                if (task.cancelled) {
                    throw new IllegalStateException("TimerTask is canceled");
                }

                task.when = when;
                task.period = period;
                task.fixedRate = fixed;
            }

            // insert the newTask into queue
            impl.insertTask(task);
        }
    }
}

