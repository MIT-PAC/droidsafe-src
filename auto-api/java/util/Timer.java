package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class Timer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.918 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "BD810B8E7F0EAA2CFBEB665BD5956193")

    private TimerImpl impl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.918 -0400", hash_original_field = "127161DB3B8D504B5618E82D4391BDDC", hash_generated_field = "BE0845D4DD46C2E4FF9E16078B08E358")

    @SuppressWarnings("unused") private FinalizerHelper finalizer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.919 -0400", hash_original_method = "CCBAE4C218CB3D4968980BC5ABE4FF3C", hash_generated_method = "4B24BC7D04A2F94E09EBB0B9898B7BFF")
    public  Timer(String name, boolean isDaemon) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name is null");
        } 
        this.impl = new TimerImpl(name, isDaemon);
        this.finalizer = new FinalizerHelper(impl);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.919 -0400", hash_original_method = "02AE08AD1BF27E917ED31D51A1B3D791", hash_generated_method = "BD760B12BCB3C9EFDD381D4F861D4E99")
    public  Timer(String name) {
        this(name, false);
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.919 -0400", hash_original_method = "70CAEF4BF7F4A75D51C26667927F81EF", hash_generated_method = "7F5F59856E80CB782DD93EA124AC235F")
    public  Timer(boolean isDaemon) {
        this("Timer-" + Timer.nextId(), isDaemon);
        addTaint(isDaemon);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.919 -0400", hash_original_method = "0270210C5FDC4EA43E305D84D4C8B476", hash_generated_method = "F6B72E5049AAA19123589FFA16EED6C0")
    public  Timer() {
        this(false);
        
    }

    
    private synchronized static long nextId() {
        return timerId++;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.919 -0400", hash_original_method = "4F9571F346BBFC93F458CCCC1BA285E2", hash_generated_method = "8B1BBB6959E6C72980148F70ACDA4DC6")
    public void cancel() {
        impl.cancel();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.920 -0400", hash_original_method = "0B011E4041136408340083F55A5156B3", hash_generated_method = "94A566BC2E010AFF57E2D073AAF2102D")
    public int purge() {
        {
            int var8E00E955D506B96DA16229A075B2EF35_829109515 = (impl.purge());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166598474 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166598474;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.920 -0400", hash_original_method = "11725ACE17CC712A9ECE78E61369355E", hash_generated_method = "0F7B55369E642E573EB094F2A020632A")
    public void schedule(TimerTask task, Date when) {
        {
            boolean var28AAFB18FEC364CA37F6AC4ACB25179C_1654386520 = (when.getTime() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        long delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, -1, false);
        addTaint(task.getTaint());
        addTaint(when.getTaint());
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.920 -0400", hash_original_method = "C70A5270C6C8A079FCAADE9A65184BCF", hash_generated_method = "663F36CF237CD720B1B6D4E2591E0906")
    public void schedule(TimerTask task, long delay) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        scheduleImpl(task, delay, -1, false);
        addTaint(task.getTaint());
        addTaint(delay);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.920 -0400", hash_original_method = "2638FF3E02C15EB097A85AD3BAF82535", hash_generated_method = "2955127A07E6303E52386A78F2D4624E")
    public void schedule(TimerTask task, long delay, long period) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        scheduleImpl(task, delay, period, false);
        addTaint(task.getTaint());
        addTaint(delay);
        addTaint(period);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.921 -0400", hash_original_method = "D1ECD2ED5B40CEEFE097F1521E46D9CD", hash_generated_method = "16CDBD47B04382DCD9F2B23BC26C3310")
    public void schedule(TimerTask task, Date when, long period) {
        {
            boolean var98E3B2ACDC7E58F10263C88A8AF5A4DE_232403564 = (period <= 0 || when.getTime() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        long delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay < 0 ? 0 : delay, period, false);
        addTaint(task.getTaint());
        addTaint(when.getTaint());
        addTaint(period);
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.921 -0400", hash_original_method = "5346126CCA7833D0BFEF2BABD1293D7B", hash_generated_method = "2519AAD2D6626F4BA6E89D2A8982248F")
    public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        scheduleImpl(task, delay, period, true);
        addTaint(task.getTaint());
        addTaint(delay);
        addTaint(period);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.922 -0400", hash_original_method = "6589A168C51AEA92DBDCD8B282926324", hash_generated_method = "2C978E6DB9F8273E8DF381299B42B09A")
    public void scheduleAtFixedRate(TimerTask task, Date when, long period) {
        {
            boolean var98E3B2ACDC7E58F10263C88A8AF5A4DE_1685281993 = (period <= 0 || when.getTime() < 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        long delay = when.getTime() - System.currentTimeMillis();
        scheduleImpl(task, delay, period, true);
        addTaint(task.getTaint());
        addTaint(when.getTaint());
        addTaint(period);
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.923 -0400", hash_original_method = "163F6B0C6203677A1F058E56FE2F9B83", hash_generated_method = "E0EBDCC7B54A55642D7484C133EE4F2E")
    private void scheduleImpl(TimerTask task, long delay, long period, boolean fixed) {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Timer was canceled");
            } 
            long when = delay + System.currentTimeMillis();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + when);
            } 
            {
                {
                    boolean var6907B24DBA5C82DAA6F3CA1916D2DC39_290809246 = (task.isScheduled());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("TimerTask is scheduled already");
                    } 
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("TimerTask is canceled");
                } 
                task.when = when;
                task.period = period;
                task.fixedRate = fixed;
            } 
            impl.insertTask(task);
        } 
        addTaint(task.getTaint());
        addTaint(delay);
        addTaint(period);
        addTaint(fixed);
        
        
    }

    
    private static final class TimerImpl extends Thread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.923 -0400", hash_original_field = "38881E0A24039DC2621E1D6F86CB71F7", hash_generated_field = "DD77D1125D3DB6D338BBBF7F15E50974")

        private boolean cancelled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.950 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

        private boolean finished;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.950 -0400", hash_original_field = "A922F9122839A05A2C3C193CED01A95B", hash_generated_field = "42B47F8DE84F38316DBD90F59FBB0655")

        private TimerHeap tasks = new TimerHeap();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.951 -0400", hash_original_method = "F4DF6B4551FDBC23EEE87B7E4E870504", hash_generated_method = "9DDF867E2E7219DF58888AB99AC9232E")
          TimerImpl(String name, boolean isDaemon) {
            this.setName(name);
            this.setDaemon(isDaemon);
            this.start();
            addTaint(name.getTaint());
            addTaint(isDaemon);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.952 -0400", hash_original_method = "F5D6E902D7971393BC779DF27078ED52", hash_generated_method = "10B2BE8FC5436F92987DBD3469516CE0")
        @Override
        public void run() {
            {
                TimerTask task;
                {
                    {
                        boolean varE000C8CD27A28F30D1F5A6F1BE3E1A6B_786699453 = (tasks.isEmpty());
                        {
                            try 
                            {
                                this.wait();
                            } 
                            catch (InterruptedException ignored)
                            { }
                        } 
                    } 
                    long currentTime = System.currentTimeMillis();
                    task = tasks.minimum();
                    long timeToSleep;
                    {
                        {
                            tasks.delete(0);
                        } 
                        timeToSleep = task.when - currentTime;
                    } 
                    {
                        try 
                        {
                            this.wait(timeToSleep);
                        } 
                        catch (InterruptedException ignored)
                        { }
                    } 
                    {
                        int pos = 0;
                        {
                            boolean varF3D982CB1D1D4376F524CD5CE5CEABCA_157646935 = (tasks.minimum().when != task.when);
                            {
                                pos = tasks.getTask(task);
                            } 
                        } 
                        {
                            tasks.delete(tasks.getTask(task));
                        } 
                        task.setScheduledTime(task.when);
                        tasks.delete(pos);
                        {
                            {
                                task.when = task.when + task.period;
                            } 
                            {
                                task.when = System.currentTimeMillis()
                                        + task.period;
                            } 
                            insertTask(task);
                        } 
                        {
                            task.when = 0;
                        } 
                    } 
                } 
                boolean taskCompletedNormally = false;
                try 
                {
                    task.run();
                    taskCompletedNormally = true;
                } 
                finally 
                {
                    {
                        {
                            cancelled = true;
                        } 
                    } 
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.952 -0400", hash_original_method = "1179C8665DD7C88A3DCD4C96D03B447E", hash_generated_method = "81F4A2B79E3F9EA767D38EF722582F3A")
        private void insertTask(TimerTask newTask) {
            tasks.insert(newTask);
            this.notify();
            addTaint(newTask.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.952 -0400", hash_original_method = "98F63C51B8CE3B66A34B3D1691EEC660", hash_generated_method = "D46269E7176EB5C7BED6DA170FC81CDE")
        public synchronized void cancel() {
            cancelled = true;
            tasks.reset();
            this.notify();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.953 -0400", hash_original_method = "14258CF4E602CCBF988A676BE8DF635B", hash_generated_method = "6DF38622ECFDE3C3FAAAEDB8789646C2")
        public int purge() {
            {
                boolean var94892AA28B9C9E2A6A9FBA5CBDBF08E1_1498282876 = (tasks.isEmpty());
            } 
            tasks.deletedCancelledNumber = 0;
            tasks.deleteIfCancelled();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_13395315 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_13395315;
            
            
                
            
            
            
            
        }

        
        private static final class TimerHeap {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.953 -0400", hash_original_field = "C30D0995BFA5B67E8BEB6F82218A7256", hash_generated_field = "5DCC43DD97C899F4FF86DBEA0DEC4532")

            private int DEFAULT_HEAP_SIZE = 256;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.953 -0400", hash_original_field = "DA0C237DC5B6D69E947A2A23D09D2A53", hash_generated_field = "E31F25F3395C26BA2E25CE6943B12BB4")

            private TimerTask[] timers = new TimerTask[DEFAULT_HEAP_SIZE];
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.953 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "C5D9FEC4EFB462C8A221F2C08D178643")

            private int size = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.953 -0400", hash_original_field = "6B1DCD5522C8E4183D5D71E6F73B7276", hash_generated_field = "1B4C6ED5AD73B84D34A3A5D4C320C40E")

            private int deletedCancelledNumber = 0;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.953 -0400", hash_original_method = "8C2F50BDBBFD0A7BB81F89CAC3407288", hash_generated_method = "8C2F50BDBBFD0A7BB81F89CAC3407288")
            public TimerHeap ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.954 -0400", hash_original_method = "54D4D4169DAC5C26DC557B9A789FA70D", hash_generated_method = "327CD31BD0CA81CF47F5148CD87EF858")
            public TimerTask minimum() {
                TimerTask varB4EAC82CA7396A68D541C85D26508E83_1368371109 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1368371109 = timers[0];
                varB4EAC82CA7396A68D541C85D26508E83_1368371109.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1368371109;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.954 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "BB14193FAFB6B8051E241A2BC36B1ACD")
            public boolean isEmpty() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_468914170 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_468914170;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.955 -0400", hash_original_method = "FCBB49BFF2D0F5589541AAD0BAE25774", hash_generated_method = "147B2C89B407A3545259607A41E7C9A2")
            public void insert(TimerTask task) {
                {
                    TimerTask[] appendedTimers = new TimerTask[size * 2];
                    System.arraycopy(timers, 0, appendedTimers, 0, size);
                    timers = appendedTimers;
                } 
                timers[size++] = task;
                upHeap();
                
                
                    
                    
                    
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.956 -0400", hash_original_method = "0B132463A6995D392821B524FFDE805E", hash_generated_method = "7789FA9F09B49764E97990EFC61FAC84")
            public void delete(int pos) {
                {
                    timers[pos] = timers[--size];
                    timers[size] = null;
                    downHeap(pos);
                } 
                
                
                    
                    
                    
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.957 -0400", hash_original_method = "4756DE20DDADB3FD04AA7E2F3A372FAC", hash_generated_method = "F91BF5B30C813A82E7CDE773B453B8D9")
            private void upHeap() {
                int current = size - 1;
                int parent = (current - 1) / 2;
                {
                    TimerTask tmp = timers[current];
                    timers[current] = timers[parent];
                    timers[parent] = tmp;
                    current = parent;
                    parent = (current - 1) / 2;
                } 
                
                
                
                
                    
                    
                    
                    
                    
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.959 -0400", hash_original_method = "A63AC6E1F65E01631F08DE00B4EE87D2", hash_generated_method = "2E12BF94E677CA281F09024FC210320A")
            private void downHeap(int pos) {
                int current = pos;
                int child = 2 * current + 1;
                {
                    TimerTask tmp = timers[current];
                    timers[current] = timers[child];
                    timers[child] = tmp;
                    current = child;
                    child = 2 * current + 1;
                } 
                addTaint(pos);
                
                
                
                
                    
                            
                        
                    
                    
                        
                    
                    
                    
                    
                    
                    
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.960 -0400", hash_original_method = "2535A97D037DD57E0DAFCE2BC7E2038E", hash_generated_method = "FEDFA13AA9192D076D68218879D9832F")
            public void reset() {
                timers = new TimerTask[DEFAULT_HEAP_SIZE];
                size = 0;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.960 -0400", hash_original_method = "D8C208FA954780F7AF0BEF19488333D3", hash_generated_method = "655D2B1724BE5C017764F419A1F28993")
            public void adjustMinimum() {
                downHeap(0);
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.960 -0400", hash_original_method = "AE1ACEED0F069268C38EE209755704B2", hash_generated_method = "3CD815268812989938665EBEDF7FDAB3")
            public void deleteIfCancelled() {
                {
                    int i = 0;
                    {
                        {
                            delete(i);
                        } 
                    } 
                } 
                
                
                    
                        
                        
                        
                    
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.961 -0400", hash_original_method = "B28407BF2F77FCC6A87AD91AEA3746F4", hash_generated_method = "FDB158C617F3127FDBE588830B84AC43")
            private int getTask(TimerTask task) {
                {
                    int i = 0;
                } 
                addTaint(task.getTaint());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420481164 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420481164;
                
                
                    
                        
                    
                
                
            }

            
        }


        
    }


    
    private static final class FinalizerHelper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.961 -0400", hash_original_field = "86CCEC3D9FF0E9C0514506E982CDC08B", hash_generated_field = "BD810B8E7F0EAA2CFBEB665BD5956193")

        private TimerImpl impl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.961 -0400", hash_original_method = "433E2FD3ED4C8DEDF63A6DA216B65604", hash_generated_method = "4CBFABE13119C5255BCBDD03AEBE9965")
          FinalizerHelper(TimerImpl impl) {
            this.impl = impl;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.962 -0400", hash_original_method = "DFA080161CE25EF58ACF3FC158495E65", hash_generated_method = "46DD072A0569F988F8CB0CDB40A0B957")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                {
                    impl.finished = true;
                    impl.notify();
                } 
            } 
            finally 
            {
                super.finalize();
            } 
            
            
                
                    
                    
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.962 -0400", hash_original_field = "D788D0843582347FA30F14628757091E", hash_generated_field = "AE70AF39EAB820096114FC8C9C2796F7")

    private static long timerId;
}

