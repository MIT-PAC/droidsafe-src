package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Timer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.170 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "BD810B8E7F0EAA2CFBEB665BD5956193")

    private TimerImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.170 -0400", hash_original_field = "127161DB3B8D504B5618E82D4391BDDC", hash_generated_field = "BE0845D4DD46C2E4FF9E16078B08E358")

    @SuppressWarnings("unused") private FinalizerHelper finalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.177 -0400", hash_original_method = "CCBAE4C218CB3D4968980BC5ABE4FF3C", hash_generated_method = "4B24BC7D04A2F94E09EBB0B9898B7BFF")
    public  Timer(String name, boolean isDaemon) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.197 -0400", hash_original_method = "02AE08AD1BF27E917ED31D51A1B3D791", hash_generated_method = "BD760B12BCB3C9EFDD381D4F861D4E99")
    public  Timer(String name) {
        this(name, false);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.197 -0400", hash_original_method = "70CAEF4BF7F4A75D51C26667927F81EF", hash_generated_method = "7F5F59856E80CB782DD93EA124AC235F")
    public  Timer(boolean isDaemon) {
        this("Timer-" + Timer.nextId(), isDaemon);
        addTaint(isDaemon);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.197 -0400", hash_original_method = "0270210C5FDC4EA43E305D84D4C8B476", hash_generated_method = "F6B72E5049AAA19123589FFA16EED6C0")
    public  Timer() {
        this(false);
        // ---------- Original Method ----------
    }

    
        private synchronized static long nextId() {
        return timerId++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.198 -0400", hash_original_method = "4F9571F346BBFC93F458CCCC1BA285E2", hash_generated_method = "8B1BBB6959E6C72980148F70ACDA4DC6")
    public void cancel() {
        impl.cancel();
        // ---------- Original Method ----------
        //impl.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.198 -0400", hash_original_method = "0B011E4041136408340083F55A5156B3", hash_generated_method = "1C1DEB67A70A52DEDC1B71F3C60282E6")
    public int purge() {
        {
            int var8E00E955D506B96DA16229A075B2EF35_1580917824 = (impl.purge());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_362193199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_362193199;
        // ---------- Original Method ----------
        //synchronized (impl) {
            //return impl.purge();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.199 -0400", hash_original_method = "11725ACE17CC712A9ECE78E61369355E", hash_generated_method = "78C12D82575C1EF423F26C11D2A0FCCF")
    public void schedule(TimerTask task, Date when) {
        {
            boolean var28AAFB18FEC364CA37F6AC4ACB25179C_1966407146 = (when.getTime() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        long delay;
        delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, -1, false);
        addTaint(task.getTaint());
        addTaint(when.getTaint());
        // ---------- Original Method ----------
        //if (when.getTime() < 0) {
            //throw new IllegalArgumentException();
        //}
        //long delay = when.getTime() - System.currentTimeMillis();
        //scheduleImpl(task, delay < 0 ? 0 : delay, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.199 -0400", hash_original_method = "C70A5270C6C8A079FCAADE9A65184BCF", hash_generated_method = "663F36CF237CD720B1B6D4E2591E0906")
    public void schedule(TimerTask task, long delay) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        scheduleImpl(task, delay, -1, false);
        addTaint(task.getTaint());
        addTaint(delay);
        // ---------- Original Method ----------
        //if (delay < 0) {
            //throw new IllegalArgumentException();
        //}
        //scheduleImpl(task, delay, -1, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.199 -0400", hash_original_method = "2638FF3E02C15EB097A85AD3BAF82535", hash_generated_method = "2955127A07E6303E52386A78F2D4624E")
    public void schedule(TimerTask task, long delay, long period) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        scheduleImpl(task, delay, period, false);
        addTaint(task.getTaint());
        addTaint(delay);
        addTaint(period);
        // ---------- Original Method ----------
        //if (delay < 0 || period <= 0) {
            //throw new IllegalArgumentException();
        //}
        //scheduleImpl(task, delay, period, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.200 -0400", hash_original_method = "D1ECD2ED5B40CEEFE097F1521E46D9CD", hash_generated_method = "70837D3C8C13C49DB97EF86EEE4767C6")
    public void schedule(TimerTask task, Date when, long period) {
        {
            boolean var98E3B2ACDC7E58F10263C88A8AF5A4DE_1135729340 = (period <= 0 || when.getTime() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        long delay;
        delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, period, false);
        addTaint(task.getTaint());
        addTaint(when.getTaint());
        addTaint(period);
        // ---------- Original Method ----------
        //if (period <= 0 || when.getTime() < 0) {
            //throw new IllegalArgumentException();
        //}
        //long delay = when.getTime() - System.currentTimeMillis();
        //scheduleImpl(task, delay < 0 ? 0 : delay, period, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.200 -0400", hash_original_method = "5346126CCA7833D0BFEF2BABD1293D7B", hash_generated_method = "2519AAD2D6626F4BA6E89D2A8982248F")
    public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        scheduleImpl(task, delay, period, true);
        addTaint(task.getTaint());
        addTaint(delay);
        addTaint(period);
        // ---------- Original Method ----------
        //if (delay < 0 || period <= 0) {
            //throw new IllegalArgumentException();
        //}
        //scheduleImpl(task, delay, period, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.200 -0400", hash_original_method = "6589A168C51AEA92DBDCD8B282926324", hash_generated_method = "2E312A2F74CF7A15FFAEAF6672FB9F92")
    public void scheduleAtFixedRate(TimerTask task, Date when, long period) {
        {
            boolean var98E3B2ACDC7E58F10263C88A8AF5A4DE_106599002 = (period <= 0 || when.getTime() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        long delay;
        delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay, period, true);
        addTaint(task.getTaint());
        addTaint(when.getTaint());
        addTaint(period);
        // ---------- Original Method ----------
        //if (period <= 0 || when.getTime() < 0) {
            //throw new IllegalArgumentException();
        //}
        //long delay = when.getTime() - System.currentTimeMillis();
        //scheduleImpl(task, delay, period, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.219 -0400", hash_original_method = "163F6B0C6203677A1F058E56FE2F9B83", hash_generated_method = "E7E18D16B15C5CF80A3E855D7D9CC0E2")
    private void scheduleImpl(TimerTask task, long delay, long period, boolean fixed) {
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
                    boolean var6907B24DBA5C82DAA6F3CA1916D2DC39_294466073 = (task.isScheduled());
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
        addTaint(task.getTaint());
        addTaint(delay);
        addTaint(period);
        addTaint(fixed);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final class TimerImpl extends Thread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.219 -0400", hash_original_field = "38881E0A24039DC2621E1D6F86CB71F7", hash_generated_field = "DD77D1125D3DB6D338BBBF7F15E50974")

        private boolean cancelled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.219 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

        private boolean finished;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.219 -0400", hash_original_field = "A922F9122839A05A2C3C193CED01A95B", hash_generated_field = "42B47F8DE84F38316DBD90F59FBB0655")

        private TimerHeap tasks = new TimerHeap();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.219 -0400", hash_original_method = "F4DF6B4551FDBC23EEE87B7E4E870504", hash_generated_method = "9DDF867E2E7219DF58888AB99AC9232E")
          TimerImpl(String name, boolean isDaemon) {
            this.setName(name);
            this.setDaemon(isDaemon);
            this.start();
            addTaint(name.getTaint());
            addTaint(isDaemon);
            // ---------- Original Method ----------
            //this.setName(name);
            //this.setDaemon(isDaemon);
            //this.start();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.221 -0400", hash_original_method = "F5D6E902D7971393BC779DF27078ED52", hash_generated_method = "1BC797E182311F6B99D55DCBDDEB83C8")
        @Override
        public void run() {
            {
                TimerTask task;
                {
                    {
                        boolean varE000C8CD27A28F30D1F5A6F1BE3E1A6B_669995887 = (tasks.isEmpty());
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
                            boolean varF3D982CB1D1D4376F524CD5CE5CEABCA_380678377 = (tasks.minimum().when != task.when);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.221 -0400", hash_original_method = "1179C8665DD7C88A3DCD4C96D03B447E", hash_generated_method = "81F4A2B79E3F9EA767D38EF722582F3A")
        private void insertTask(TimerTask newTask) {
            tasks.insert(newTask);
            this.notify();
            addTaint(newTask.getTaint());
            // ---------- Original Method ----------
            //tasks.insert(newTask);
            //this.notify();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.221 -0400", hash_original_method = "98F63C51B8CE3B66A34B3D1691EEC660", hash_generated_method = "D46269E7176EB5C7BED6DA170FC81CDE")
        public synchronized void cancel() {
            cancelled = true;
            tasks.reset();
            this.notify();
            // ---------- Original Method ----------
            //cancelled = true;
            //tasks.reset();
            //this.notify();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.235 -0400", hash_original_method = "14258CF4E602CCBF988A676BE8DF635B", hash_generated_method = "E75C9D3DA59FB6B9BB115C7AB4422EE9")
        public int purge() {
            {
                boolean var94892AA28B9C9E2A6A9FBA5CBDBF08E1_1972968012 = (tasks.isEmpty());
            } //End collapsed parenthetic
            tasks.deletedCancelledNumber = 0;
            tasks.deleteIfCancelled();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628793394 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628793394;
            // ---------- Original Method ----------
            //if (tasks.isEmpty()) {
                //return 0;
            //}
            //tasks.deletedCancelledNumber = 0;
            //tasks.deleteIfCancelled();
            //return tasks.deletedCancelledNumber;
        }

        
        private static final class TimerHeap {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.235 -0400", hash_original_field = "C30D0995BFA5B67E8BEB6F82218A7256", hash_generated_field = "5DCC43DD97C899F4FF86DBEA0DEC4532")

            private int DEFAULT_HEAP_SIZE = 256;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.235 -0400", hash_original_field = "DA0C237DC5B6D69E947A2A23D09D2A53", hash_generated_field = "E31F25F3395C26BA2E25CE6943B12BB4")

            private TimerTask[] timers = new TimerTask[DEFAULT_HEAP_SIZE];
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.235 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "C5D9FEC4EFB462C8A221F2C08D178643")

            private int size = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.236 -0400", hash_original_field = "6B1DCD5522C8E4183D5D71E6F73B7276", hash_generated_field = "1B4C6ED5AD73B84D34A3A5D4C320C40E")

            private int deletedCancelledNumber = 0;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.237 -0400", hash_original_method = "8C2F50BDBBFD0A7BB81F89CAC3407288", hash_generated_method = "8C2F50BDBBFD0A7BB81F89CAC3407288")
            public TimerHeap ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.238 -0400", hash_original_method = "54D4D4169DAC5C26DC557B9A789FA70D", hash_generated_method = "3DFEAFFEA8E6FBEF288CB64CFD1549E3")
            public TimerTask minimum() {
                TimerTask varB4EAC82CA7396A68D541C85D26508E83_793788665 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_793788665 = timers[0];
                varB4EAC82CA7396A68D541C85D26508E83_793788665.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_793788665;
                // ---------- Original Method ----------
                //return timers[0];
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.239 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "EB0BEE7F355CDCEEE25C80EBBE00D1BC")
            public boolean isEmpty() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1911968132 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1911968132;
                // ---------- Original Method ----------
                //return size == 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.251 -0400", hash_original_method = "FCBB49BFF2D0F5589541AAD0BAE25774", hash_generated_method = "7E694AF808B39D4DC43E7809F181A262")
            public void insert(TimerTask task) {
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.253 -0400", hash_original_method = "0B132463A6995D392821B524FFDE805E", hash_generated_method = "7789FA9F09B49764E97990EFC61FAC84")
            public void delete(int pos) {
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.253 -0400", hash_original_method = "4756DE20DDADB3FD04AA7E2F3A372FAC", hash_generated_method = "B51BD102B1369BBF484053590E38C8D2")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.254 -0400", hash_original_method = "A63AC6E1F65E01631F08DE00B4EE87D2", hash_generated_method = "944E4622C04502EABE04188FCACD5C1B")
            private void downHeap(int pos) {
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
                addTaint(pos);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.269 -0400", hash_original_method = "2535A97D037DD57E0DAFCE2BC7E2038E", hash_generated_method = "FEDFA13AA9192D076D68218879D9832F")
            public void reset() {
                timers = new TimerTask[DEFAULT_HEAP_SIZE];
                size = 0;
                // ---------- Original Method ----------
                //timers = new TimerTask[DEFAULT_HEAP_SIZE];
                //size = 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.270 -0400", hash_original_method = "D8C208FA954780F7AF0BEF19488333D3", hash_generated_method = "655D2B1724BE5C017764F419A1F28993")
            public void adjustMinimum() {
                downHeap(0);
                // ---------- Original Method ----------
                //downHeap(0);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.270 -0400", hash_original_method = "AE1ACEED0F069268C38EE209755704B2", hash_generated_method = "CA279638E2A1FA882257617D3FB1234E")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.270 -0400", hash_original_method = "B28407BF2F77FCC6A87AD91AEA3746F4", hash_generated_method = "988FDE1E8D884BCFE1ADC6C191A3F6EB")
            private int getTask(TimerTask task) {
                {
                    int i;
                    i = 0;
                } //End collapsed parenthetic
                addTaint(task.getTaint());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592650953 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592650953;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.271 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "BD810B8E7F0EAA2CFBEB665BD5956193")

        private TimerImpl impl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.287 -0400", hash_original_method = "433E2FD3ED4C8DEDF63A6DA216B65604", hash_generated_method = "4CBFABE13119C5255BCBDD03AEBE9965")
          FinalizerHelper(TimerImpl impl) {
            this.impl = impl;
            // ---------- Original Method ----------
            //this.impl = impl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.287 -0400", hash_original_method = "DFA080161CE25EF58ACF3FC158495E65", hash_generated_method = "46DD072A0569F988F8CB0CDB40A0B957")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.287 -0400", hash_original_field = "D788D0843582347FA30F14628757091E", hash_generated_field = "AE70AF39EAB820096114FC8C9C2796F7")

    private static long timerId;
}

