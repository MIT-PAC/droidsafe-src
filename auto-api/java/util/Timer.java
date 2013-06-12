package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


public class Timer {
    private static long timerId;
    private final TimerImpl impl;
    @SuppressWarnings("unused")
    private final FinalizerHelper finalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.696 -0400", hash_original_method = "CCBAE4C218CB3D4968980BC5ABE4FF3C", hash_generated_method = "33AB4211510F48A95565E27E53377C87")
    @DSModeled(DSC.SAFE)
    public Timer(String name, boolean isDaemon) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(isDaemon);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name is null");
        } //End block
        this.impl = new TimerImpl(name, isDaemon);
        this.finalizer = new FinalizerHelper(impl);
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name is null");
        //}
        //this.impl = new TimerImpl(name, isDaemon);
        //this.finalizer = new FinalizerHelper(impl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.708 -0400", hash_original_method = "02AE08AD1BF27E917ED31D51A1B3D791", hash_generated_method = "296AA7E5F0A639AB1BE2D4303447A642")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Timer(String name) {
        this(name, false);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.710 -0400", hash_original_method = "70CAEF4BF7F4A75D51C26667927F81EF", hash_generated_method = "575944DEA5E236E1B5A8F6D743B20DB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Timer(boolean isDaemon) {
        this("Timer-" + Timer.nextId(), isDaemon);
        dsTaint.addTaint(isDaemon);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.711 -0400", hash_original_method = "0270210C5FDC4EA43E305D84D4C8B476", hash_generated_method = "C854C214464B9A983D324624626F8819")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Timer() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.718 -0400", hash_original_method = "583B36D89F2230FC842E9DB40CDF730D", hash_generated_method = "F6AED2A8A3D3246BB251352889CBE974")
    private synchronized static long nextId() {
        return timerId++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.725 -0400", hash_original_method = "4F9571F346BBFC93F458CCCC1BA285E2", hash_generated_method = "5435ECAC40A3D4DA63030411501B18F6")
    @DSModeled(DSC.SAFE)
    public void cancel() {
        impl.cancel();
        // ---------- Original Method ----------
        //impl.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.730 -0400", hash_original_method = "0B011E4041136408340083F55A5156B3", hash_generated_method = "EFD394503E3CB6A8A94D49D3A68427C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int purge() {
        {
            int var8E00E955D506B96DA16229A075B2EF35_558896482 = (impl.purge());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (impl) {
            //return impl.purge();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.737 -0400", hash_original_method = "11725ACE17CC712A9ECE78E61369355E", hash_generated_method = "C0BB0236C59A90AE53368C6380CCE1F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void schedule(TimerTask task, Date when) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(when.dsTaint);
        {
            boolean var28AAFB18FEC364CA37F6AC4ACB25179C_599137019 = (when.getTime() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        long delay;
        delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, -1, false);
        // ---------- Original Method ----------
        //if (when.getTime() < 0) {
            //throw new IllegalArgumentException();
        //}
        //long delay = when.getTime() - System.currentTimeMillis();
        //scheduleImpl(task, delay < 0 ? 0 : delay, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.749 -0400", hash_original_method = "C70A5270C6C8A079FCAADE9A65184BCF", hash_generated_method = "8E1F28364189A6C4ABC90287A56C16D5")
    @DSModeled(DSC.SAFE)
    public void schedule(TimerTask task, long delay) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(delay);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        scheduleImpl(task, delay, -1, false);
        // ---------- Original Method ----------
        //if (delay < 0) {
            //throw new IllegalArgumentException();
        //}
        //scheduleImpl(task, delay, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.756 -0400", hash_original_method = "2638FF3E02C15EB097A85AD3BAF82535", hash_generated_method = "A7BAB8562A26CAF7F118F3350A4BE58F")
    @DSModeled(DSC.SAFE)
    public void schedule(TimerTask task, long delay, long period) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(delay);
        dsTaint.addTaint(period);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        scheduleImpl(task, delay, period, false);
        // ---------- Original Method ----------
        //if (delay < 0 || period <= 0) {
            //throw new IllegalArgumentException();
        //}
        //scheduleImpl(task, delay, period, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.765 -0400", hash_original_method = "D1ECD2ED5B40CEEFE097F1521E46D9CD", hash_generated_method = "3267046436AF81E1DD2E381AFC28CFEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void schedule(TimerTask task, Date when, long period) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(when.dsTaint);
        dsTaint.addTaint(period);
        {
            boolean var98E3B2ACDC7E58F10263C88A8AF5A4DE_330095053 = (period <= 0 || when.getTime() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        long delay;
        delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, period, false);
        // ---------- Original Method ----------
        //if (period <= 0 || when.getTime() < 0) {
            //throw new IllegalArgumentException();
        //}
        //long delay = when.getTime() - System.currentTimeMillis();
        //scheduleImpl(task, delay < 0 ? 0 : delay, period, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.773 -0400", hash_original_method = "5346126CCA7833D0BFEF2BABD1293D7B", hash_generated_method = "8C82E07E517BAB455F9A8551084E386F")
    @DSModeled(DSC.SAFE)
    public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(delay);
        dsTaint.addTaint(period);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        scheduleImpl(task, delay, period, true);
        // ---------- Original Method ----------
        //if (delay < 0 || period <= 0) {
            //throw new IllegalArgumentException();
        //}
        //scheduleImpl(task, delay, period, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.786 -0400", hash_original_method = "6589A168C51AEA92DBDCD8B282926324", hash_generated_method = "A9EEDF8B1E426B1E06D72E13C7DC172F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleAtFixedRate(TimerTask task, Date when, long period) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(when.dsTaint);
        dsTaint.addTaint(period);
        {
            boolean var98E3B2ACDC7E58F10263C88A8AF5A4DE_56862249 = (period <= 0 || when.getTime() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        long delay;
        delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay, period, true);
        // ---------- Original Method ----------
        //if (period <= 0 || when.getTime() < 0) {
            //throw new IllegalArgumentException();
        //}
        //long delay = when.getTime() - System.currentTimeMillis();
        //scheduleImpl(task, delay, period, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.789 -0400", hash_original_method = "163F6B0C6203677A1F058E56FE2F9B83", hash_generated_method = "4C99069D7B750D002384C89B576A1BFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void scheduleImpl(TimerTask task, long delay, long period, boolean fixed) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(delay);
        dsTaint.addTaint(period);
        dsTaint.addTaint(fixed);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Timer was canceled");
            } //End block
            long when;
            when = delay + System.currentTimeMillis();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + when);
            } //End block
            {
                {
                    //boolean var6907B24DBA5C82DAA6F3CA1916D2DC39_198124077 = (task.isScheduled());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("TimerTask is scheduled already");
                    } //End block
                } //End collapsed parenthetic
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("TimerTask is canceled");
                } //End block
                //task.when = when;
                //task.period = period;
                //task.fixedRate = fixed;
            } //End block
            impl.insertTask(task);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final class TimerImpl extends Thread {
        private boolean cancelled;
        private boolean finished;
        private TimerHeap tasks = new TimerHeap();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.800 -0400", hash_original_method = "F4DF6B4551FDBC23EEE87B7E4E870504", hash_generated_method = "61ADAEC619DBC6FEC4A51FB542796BFD")
        @DSModeled(DSC.SAFE)
         TimerImpl(String name, boolean isDaemon) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(isDaemon);
            this.setName(name);
            this.setDaemon(isDaemon);
            this.start();
            // ---------- Original Method ----------
            //this.setName(name);
            //this.setDaemon(isDaemon);
            //this.start();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.828 -0400", hash_original_method = "F5D6E902D7971393BC779DF27078ED52", hash_generated_method = "DD8BE1AE00771A73F7BB9F135CC74977")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            {
                TimerTask task;
                {
                    {
                        boolean varE000C8CD27A28F30D1F5A6F1BE3E1A6B_2116508263 = (tasks.isEmpty());
                        {
                            try 
                            {
                                this.wait();
                            } //End block
                            catch (InterruptedException ignored)
                            { }
                        } //End block
                    } //End collapsed parenthetic
                    long currentTime;
                    currentTime = System.currentTimeMillis();
                    task = tasks.minimum();
                    long timeToSleep = 0;
                    {
                        {
                            tasks.delete(0);
                        } //End block
                        //timeToSleep = task.when - currentTime;
                    } //End block
                    {
                        try 
                        {
                            this.wait(timeToSleep);
                        } //End block
                        catch (InterruptedException ignored)
                        { }
                    } //End block
                    /*
                    {
                        int pos;
                        pos = 0;
                        {
                            boolean varF3D982CB1D1D4376F524CD5CE5CEABCA_733343577 = (tasks.minimum().when != task.when);
                            {
                                pos = tasks.getTask(task);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            tasks.delete(tasks.getTask(task));
                        } //End block
                        task.setScheduledTime(task.when);
                        tasks.delete(pos);
                        {
                            {
                                task.when = task.when + task.period;
                            } //End block
                            {
                                task.when = System.currentTimeMillis()
                                        + task.period;
                            } //End block
                            insertTask(task);
                        } //End block
                        {
                            task.when = 0;
                        } //End block
                    } //End block
                    */
                } //End block
                boolean taskCompletedNormally;
                taskCompletedNormally = false;
                try 
                {
                    task.run();
                    taskCompletedNormally = true;
                } //End block
                finally 
                {
                    {
                        {
                            cancelled = true;
                        } //End block
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.837 -0400", hash_original_method = "1179C8665DD7C88A3DCD4C96D03B447E", hash_generated_method = "A6B5CA1BFAD88984472E1927ADBA0D6D")
        @DSModeled(DSC.SAFE)
        private void insertTask(TimerTask newTask) {
            dsTaint.addTaint(newTask.dsTaint);
            tasks.insert(newTask);
            this.notify();
            // ---------- Original Method ----------
            //tasks.insert(newTask);
            //this.notify();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.844 -0400", hash_original_method = "98F63C51B8CE3B66A34B3D1691EEC660", hash_generated_method = "DC18189F002B08C68E482FC4F2ECBBE5")
        @DSModeled(DSC.SAFE)
        public synchronized void cancel() {
            cancelled = true;
            tasks.reset();
            this.notify();
            // ---------- Original Method ----------
            //cancelled = true;
            //tasks.reset();
            //this.notify();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.847 -0400", hash_original_method = "14258CF4E602CCBF988A676BE8DF635B", hash_generated_method = "20FAA0D4FA4AEF400172241FCEBC2E91")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int purge() {
            {
                boolean var94892AA28B9C9E2A6A9FBA5CBDBF08E1_501095642 = (tasks.isEmpty());
            } //End collapsed parenthetic
            tasks.deletedCancelledNumber = 0;
            tasks.deleteIfCancelled();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (tasks.isEmpty()) {
                //return 0;
            //}
            //tasks.deletedCancelledNumber = 0;
            //tasks.deleteIfCancelled();
            //return tasks.deletedCancelledNumber;
        }

        
        private static final class TimerHeap {
            private int DEFAULT_HEAP_SIZE = 256;
            private TimerTask[] timers = new TimerTask[DEFAULT_HEAP_SIZE];
            private int size = 0;
            private int deletedCancelledNumber = 0;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.853 -0400", hash_original_method = "54D4D4169DAC5C26DC557B9A789FA70D", hash_generated_method = "6F81DA6B28D8825271D4F036C70C00DF")
            @DSModeled(DSC.SAFE)
            public TimerTask minimum() {
                return (TimerTask)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return timers[0];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.856 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "1CBA5DF5BAEBF8C241F0BFF52A55C9B3")
            @DSModeled(DSC.SAFE)
            public boolean isEmpty() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return size == 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.869 -0400", hash_original_method = "FCBB49BFF2D0F5589541AAD0BAE25774", hash_generated_method = "9BF69488DF117E108F753C598929CA56")
            @DSModeled(DSC.SAFE)
            public void insert(TimerTask task) {
                dsTaint.addTaint(task.dsTaint);
                {
                    TimerTask[] appendedTimers;
                    appendedTimers = new TimerTask[size * 2];
                    System.arraycopy(timers, 0, appendedTimers, 0, size);
                    timers = appendedTimers;
                } //End block
                timers[size++] = task;
                upHeap();
                // ---------- Original Method ----------
                //if (timers.length == size) {
                    //TimerTask[] appendedTimers = new TimerTask[size * 2];
                    //System.arraycopy(timers, 0, appendedTimers, 0, size);
                    //timers = appendedTimers;
                //}
                //timers[size++] = task;
                //upHeap();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.872 -0400", hash_original_method = "0B132463A6995D392821B524FFDE805E", hash_generated_method = "2E73C2EC12FBA45336D64A476BE9D152")
            @DSModeled(DSC.SAFE)
            public void delete(int pos) {
                dsTaint.addTaint(pos);
                {
                    timers[pos] = timers[--size];
                    timers[size] = null;
                    downHeap(pos);
                } //End block
                // ---------- Original Method ----------
                //if (pos >= 0 && pos < size) {
                    //timers[pos] = timers[--size];
                    //timers[size] = null;
                    //downHeap(pos);
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.884 -0400", hash_original_method = "4756DE20DDADB3FD04AA7E2F3A372FAC", hash_generated_method = "536E6160D9162680988560C180146B79")
            @DSModeled(DSC.SAFE)
            private void upHeap() {
                int current;
                current = size - 1;
                int parent;
                parent = (current - 1) / 2;
                {
                    TimerTask tmp;
                    tmp = timers[current];
                    timers[current] = timers[parent];
                    timers[parent] = tmp;
                    current = parent;
                    parent = (current - 1) / 2;
                } //End block
                // ---------- Original Method ----------
                //int current = size - 1;
                //int parent = (current - 1) / 2;
                //while (timers[current].when < timers[parent].when) {
                    //TimerTask tmp = timers[current];
                    //timers[current] = timers[parent];
                    //timers[parent] = tmp;
                    //current = parent;
                    //parent = (current - 1) / 2;
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.900 -0400", hash_original_method = "A63AC6E1F65E01631F08DE00B4EE87D2", hash_generated_method = "D905922703BBC8FAD5E7B8A0ABCCA1B5")
            @DSModeled(DSC.SAFE)
            private void downHeap(int pos) {
                dsTaint.addTaint(pos);
                int current;
                current = pos;
                int child;
                child = 2 * current + 1;
                {
                    {
                        child++;
                    } //End block
                    TimerTask tmp;
                    tmp = timers[current];
                    timers[current] = timers[child];
                    timers[child] = tmp;
                    current = child;
                    child = 2 * current + 1;
                } //End block
                // ---------- Original Method ----------
                //int current = pos;
                //int child = 2 * current + 1;
                //while (child < size && size > 0) {
                    //if (child + 1 < size
                            //&& timers[child + 1].when < timers[child].when) {
                        //child++;
                    //}
                    //if (timers[current].when < timers[child].when) {
                        //break;
                    //}
                    //TimerTask tmp = timers[current];
                    //timers[current] = timers[child];
                    //timers[child] = tmp;
                    //current = child;
                    //child = 2 * current + 1;
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.913 -0400", hash_original_method = "2535A97D037DD57E0DAFCE2BC7E2038E", hash_generated_method = "7E10DA132819209A46A8C539B1BC8CD5")
            @DSModeled(DSC.SAFE)
            public void reset() {
                timers = new TimerTask[DEFAULT_HEAP_SIZE];
                size = 0;
                // ---------- Original Method ----------
                //timers = new TimerTask[DEFAULT_HEAP_SIZE];
                //size = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.915 -0400", hash_original_method = "D8C208FA954780F7AF0BEF19488333D3", hash_generated_method = "B5CAE8EEEAC9D4F05A35A50778F9EC65")
            @DSModeled(DSC.SAFE)
            public void adjustMinimum() {
                downHeap(0);
                // ---------- Original Method ----------
                //downHeap(0);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.921 -0400", hash_original_method = "AE1ACEED0F069268C38EE209755704B2", hash_generated_method = "88F4FB3A8F4B14214093E013C82D4DD1")
            @DSModeled(DSC.SAFE)
            public void deleteIfCancelled() {
                {
                    int i;
                    i = 0;
                    {
                        {
                            deletedCancelledNumber++;
                            delete(i);
                            i--;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                // ---------- Original Method ----------
                //for (int i = 0; i < size; i++) {
                    //if (timers[i].cancelled) {
                        //deletedCancelledNumber++;
                        //delete(i);
                        //i--;
                    //}
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.929 -0400", hash_original_method = "B28407BF2F77FCC6A87AD91AEA3746F4", hash_generated_method = "4AB61130C49E06CDF3898DE3222AE138")
            @DSModeled(DSC.SAFE)
            private int getTask(TimerTask task) {
                dsTaint.addTaint(task.dsTaint);
                {
                    int i;
                    i = 0;
                } //End collapsed parenthetic
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //for (int i = 0; i < timers.length; i++) {
                    //if (timers[i] == task) {
                        //return i;
                    //}
                //}
                //return -1;
            }

            
        }


        
    }


    
    private static final class FinalizerHelper {
        private final TimerImpl impl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.941 -0400", hash_original_method = "433E2FD3ED4C8DEDF63A6DA216B65604", hash_generated_method = "07B1FF13F66D33FCA40C52F8DA350A0E")
        @DSModeled(DSC.SAFE)
         FinalizerHelper(TimerImpl impl) {
            dsTaint.addTaint(impl.dsTaint);
            // ---------- Original Method ----------
            this.impl = impl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.944 -0400", hash_original_method = "DFA080161CE25EF58ACF3FC158495E65", hash_generated_method = "6FE3D6DDA86A3F7D80B3DC9DEC847063")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                {
                    impl.finished = true;
                    impl.notify();
                } //End block
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //synchronized (impl) {
                    //impl.finished = true;
                    //impl.notify();
                //}
            //} finally {
                //super.finalize();
            //}
        }

        
    }


    
}


