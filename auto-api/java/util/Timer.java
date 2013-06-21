package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Timer {
    private TimerImpl impl;
    @SuppressWarnings("unused") private FinalizerHelper finalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.831 -0400", hash_original_method = "CCBAE4C218CB3D4968980BC5ABE4FF3C", hash_generated_method = "5B0C3C71E2C9D19F2BA1B47221FADDBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.831 -0400", hash_original_method = "02AE08AD1BF27E917ED31D51A1B3D791", hash_generated_method = "FAD106097C26F62E7FBE0C11A0E953B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Timer(String name) {
        this(name, false);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.831 -0400", hash_original_method = "70CAEF4BF7F4A75D51C26667927F81EF", hash_generated_method = "D1DA79765DD58E92C5A512CB5C73396B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Timer(boolean isDaemon) {
        this("Timer-" + Timer.nextId(), isDaemon);
        dsTaint.addTaint(isDaemon);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.832 -0400", hash_original_method = "0270210C5FDC4EA43E305D84D4C8B476", hash_generated_method = "F6B72E5049AAA19123589FFA16EED6C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Timer() {
        this(false);
        // ---------- Original Method ----------
    }

    
        private synchronized static long nextId() {
        return timerId++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.832 -0400", hash_original_method = "4F9571F346BBFC93F458CCCC1BA285E2", hash_generated_method = "8B1BBB6959E6C72980148F70ACDA4DC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        impl.cancel();
        // ---------- Original Method ----------
        //impl.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.833 -0400", hash_original_method = "0B011E4041136408340083F55A5156B3", hash_generated_method = "53DEA8AD6871A40CAD74AED033DF71DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int purge() {
        {
            int var8E00E955D506B96DA16229A075B2EF35_1416742121 = (impl.purge());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (impl) {
            //return impl.purge();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.834 -0400", hash_original_method = "11725ACE17CC712A9ECE78E61369355E", hash_generated_method = "83664B9B282B941FFD482D5A7F2EA486")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void schedule(TimerTask task, Date when) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(when.dsTaint);
        {
            boolean var28AAFB18FEC364CA37F6AC4ACB25179C_1302782099 = (when.getTime() < 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.834 -0400", hash_original_method = "C70A5270C6C8A079FCAADE9A65184BCF", hash_generated_method = "101BD7328FA3E9FD35A5214FD6C4D5A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.835 -0400", hash_original_method = "2638FF3E02C15EB097A85AD3BAF82535", hash_generated_method = "B2FEC9FCFD37686B35A2585EB1ADDAD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.835 -0400", hash_original_method = "D1ECD2ED5B40CEEFE097F1521E46D9CD", hash_generated_method = "CCD682699508B3F1FFB6962714C19FAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void schedule(TimerTask task, Date when, long period) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(when.dsTaint);
        dsTaint.addTaint(period);
        {
            boolean var98E3B2ACDC7E58F10263C88A8AF5A4DE_1122801651 = (period <= 0 || when.getTime() < 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.835 -0400", hash_original_method = "5346126CCA7833D0BFEF2BABD1293D7B", hash_generated_method = "360A15697F62EC3EABEA2186935764F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.835 -0400", hash_original_method = "6589A168C51AEA92DBDCD8B282926324", hash_generated_method = "7F5A509D2A4E641C94A1E9B1C0F01886")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleAtFixedRate(TimerTask task, Date when, long period) {
        dsTaint.addTaint(task.dsTaint);
        dsTaint.addTaint(when.dsTaint);
        dsTaint.addTaint(period);
        {
            boolean var98E3B2ACDC7E58F10263C88A8AF5A4DE_1437637041 = (period <= 0 || when.getTime() < 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.836 -0400", hash_original_method = "163F6B0C6203677A1F058E56FE2F9B83", hash_generated_method = "BC9F28A6599DEACB5E26D0C95F144CC5")
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
                    boolean var6907B24DBA5C82DAA6F3CA1916D2DC39_668060978 = (task.isScheduled());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("TimerTask is scheduled already");
                    } //End block
                } //End collapsed parenthetic
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("TimerTask is canceled");
                } //End block
                task.when = when;
                task.period = period;
                task.fixedRate = fixed;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.836 -0400", hash_original_method = "F4DF6B4551FDBC23EEE87B7E4E870504", hash_generated_method = "3F75D46235A7C394B04B707778349E8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.837 -0400", hash_original_method = "F5D6E902D7971393BC779DF27078ED52", hash_generated_method = "AD10728B98B5405E2B3ECAD0D1F7443E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            {
                TimerTask task;
                {
                    {
                        boolean varE000C8CD27A28F30D1F5A6F1BE3E1A6B_1884200194 = (tasks.isEmpty());
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
                    long timeToSleep;
                    {
                        {
                            tasks.delete(0);
                        } //End block
                        timeToSleep = task.when - currentTime;
                    } //End block
                    {
                        try 
                        {
                            this.wait(timeToSleep);
                        } //End block
                        catch (InterruptedException ignored)
                        { }
                    } //End block
                    {
                        int pos;
                        pos = 0;
                        {
                            boolean varF3D982CB1D1D4376F524CD5CE5CEABCA_236770551 = (tasks.minimum().when != task.when);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.837 -0400", hash_original_method = "1179C8665DD7C88A3DCD4C96D03B447E", hash_generated_method = "18276BA631D3C2F32F23400A61E25DC2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void insertTask(TimerTask newTask) {
            dsTaint.addTaint(newTask.dsTaint);
            tasks.insert(newTask);
            this.notify();
            // ---------- Original Method ----------
            //tasks.insert(newTask);
            //this.notify();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.837 -0400", hash_original_method = "98F63C51B8CE3B66A34B3D1691EEC660", hash_generated_method = "D46269E7176EB5C7BED6DA170FC81CDE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void cancel() {
            cancelled = true;
            tasks.reset();
            this.notify();
            // ---------- Original Method ----------
            //cancelled = true;
            //tasks.reset();
            //this.notify();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.837 -0400", hash_original_method = "14258CF4E602CCBF988A676BE8DF635B", hash_generated_method = "93AEFBF8E7436012C691FCD6F04F1F6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int purge() {
            {
                boolean var94892AA28B9C9E2A6A9FBA5CBDBF08E1_525139558 = (tasks.isEmpty());
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.838 -0400", hash_original_method = "5C5A515237948A334F542E00D2B64305", hash_generated_method = "5C5A515237948A334F542E00D2B64305")
                        public TimerHeap ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.838 -0400", hash_original_method = "54D4D4169DAC5C26DC557B9A789FA70D", hash_generated_method = "AF52EBDDC084FBFAF26015AFC1B8D12A")
            @DSModeled(DSC.SAFE)
            public TimerTask minimum() {
                return (TimerTask)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return timers[0];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.838 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "B02D7658F0824D0869C92F4AD19DB19E")
            @DSModeled(DSC.SAFE)
            public boolean isEmpty() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return size == 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.838 -0400", hash_original_method = "FCBB49BFF2D0F5589541AAD0BAE25774", hash_generated_method = "C82660EBA02FC1CD1B5250BB87758C9A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.839 -0400", hash_original_method = "0B132463A6995D392821B524FFDE805E", hash_generated_method = "13023D84C09DAEE99E7791105DDD433F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.839 -0400", hash_original_method = "4756DE20DDADB3FD04AA7E2F3A372FAC", hash_generated_method = "B51BD102B1369BBF484053590E38C8D2")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.839 -0400", hash_original_method = "A63AC6E1F65E01631F08DE00B4EE87D2", hash_generated_method = "5ECD687720055326F84FA8CDC076E4DE")
            @DSModeled(DSC.SAFE)
            private void downHeap(int pos) {
                dsTaint.addTaint(pos);
                int current;
                current = pos;
                int child;
                child = 2 * current + 1;
                {
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.840 -0400", hash_original_method = "2535A97D037DD57E0DAFCE2BC7E2038E", hash_generated_method = "FEDFA13AA9192D076D68218879D9832F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void reset() {
                timers = new TimerTask[DEFAULT_HEAP_SIZE];
                size = 0;
                // ---------- Original Method ----------
                //timers = new TimerTask[DEFAULT_HEAP_SIZE];
                //size = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.840 -0400", hash_original_method = "D8C208FA954780F7AF0BEF19488333D3", hash_generated_method = "655D2B1724BE5C017764F419A1F28993")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void adjustMinimum() {
                downHeap(0);
                // ---------- Original Method ----------
                //downHeap(0);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.840 -0400", hash_original_method = "AE1ACEED0F069268C38EE209755704B2", hash_generated_method = "CA279638E2A1FA882257617D3FB1234E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void deleteIfCancelled() {
                {
                    int i;
                    i = 0;
                    {
                        {
                            delete(i);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.840 -0400", hash_original_method = "B28407BF2F77FCC6A87AD91AEA3746F4", hash_generated_method = "3766EC69615CCAF9A5AE9B6C84139B56")
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
        private TimerImpl impl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.840 -0400", hash_original_method = "433E2FD3ED4C8DEDF63A6DA216B65604", hash_generated_method = "E0C2D5C179FDE3F298561B842D18D7CA")
        @DSModeled(DSC.SAFE)
         FinalizerHelper(TimerImpl impl) {
            dsTaint.addTaint(impl.dsTaint);
            // ---------- Original Method ----------
            //this.impl = impl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.846 -0400", hash_original_method = "DFA080161CE25EF58ACF3FC158495E65", hash_generated_method = "46DD072A0569F988F8CB0CDB40A0B957")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    private static long timerId;
}

