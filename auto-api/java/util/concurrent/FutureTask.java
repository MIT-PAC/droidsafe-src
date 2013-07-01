package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.locks.*;

public class FutureTask<V> implements RunnableFuture<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.283 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.283 -0400", hash_original_method = "EBD25CFA864782219EF130D05DE406FC", hash_generated_method = "F9CCAEE3CE02C6E2CE15760453E88CBD")
    public  FutureTask(Callable<V> callable) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        sync = new Sync(callable);
        // ---------- Original Method ----------
        //if (callable == null)
            //throw new NullPointerException();
        //sync = new Sync(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.284 -0400", hash_original_method = "343C63FBFE3927352CC6BAC59E679D87", hash_generated_method = "445A2B29F4B296EBE069C195B0BDE12E")
    public  FutureTask(Runnable runnable, V result) {
        sync = new Sync(Executors.callable(runnable, result));
        // ---------- Original Method ----------
        //sync = new Sync(Executors.callable(runnable, result));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.284 -0400", hash_original_method = "87256A2F3BC620B5A65A2DEACA482F4A", hash_generated_method = "FA45C62E5F8AC4BC1C01FD09345EB408")
    public boolean isCancelled() {
        boolean varDDF49245D95EDA4C2B1E13C2033FD842_1673941788 = (sync.innerIsCancelled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047612498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047612498;
        // ---------- Original Method ----------
        //return sync.innerIsCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.285 -0400", hash_original_method = "2C3AC011A196BCCAC0E9F76136242F15", hash_generated_method = "3EA23F0F01FA6B25046B046E350452B2")
    public boolean isDone() {
        boolean var965CDAC5D67CF710B30B4F663C7F54E8_1782226017 = (sync.innerIsDone());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580406884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_580406884;
        // ---------- Original Method ----------
        //return sync.innerIsDone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.285 -0400", hash_original_method = "88A87863EC7E1056D8FE46146EF894BC", hash_generated_method = "FB77AD042D8EBB7F0C41F5ED9570D7C3")
    public boolean cancel(boolean mayInterruptIfRunning) {
        boolean var773625586E0267E8A3EBBAA24319A7D5_359470713 = (sync.innerCancel(mayInterruptIfRunning));
        addTaint(mayInterruptIfRunning);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933575146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_933575146;
        // ---------- Original Method ----------
        //return sync.innerCancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.286 -0400", hash_original_method = "162C3BFD86443C5C054F309FCD025483", hash_generated_method = "001E383EB8B9D604D72FCC4EE2E75431")
    public V get() throws InterruptedException, ExecutionException {
        V varB4EAC82CA7396A68D541C85D26508E83_823032478 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_823032478 = sync.innerGet();
        varB4EAC82CA7396A68D541C85D26508E83_823032478.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_823032478;
        // ---------- Original Method ----------
        //return sync.innerGet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.287 -0400", hash_original_method = "90F54A92EEE05A0240D215CA50ECEC0E", hash_generated_method = "DD7191EA110E5E4124C0B3E0259EDAB2")
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        V varB4EAC82CA7396A68D541C85D26508E83_974371650 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_974371650 = sync.innerGet(unit.toNanos(timeout));
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_974371650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_974371650;
        // ---------- Original Method ----------
        //return sync.innerGet(unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.287 -0400", hash_original_method = "17876694EB227DDF47ED60F50DDB1AB8", hash_generated_method = "11FDBB8776367F84FB5CD85A1E1E97A9")
    protected void done() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.288 -0400", hash_original_method = "A074A8CE9CED8FEBE8C93AF5A1F30EB2", hash_generated_method = "6FA0D62B46A1197E9998FE4CCF0DF3C3")
    protected void set(V v) {
        sync.innerSet(v);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //sync.innerSet(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.288 -0400", hash_original_method = "FDCD59BD475B14EFA0816CB7C0405257", hash_generated_method = "A7C593348CACBBEB81E8B5C9E8A097B1")
    protected void setException(Throwable t) {
        sync.innerSetException(t);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //sync.innerSetException(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.288 -0400", hash_original_method = "C774B2E8DA9F32069C4712123B43B6CD", hash_generated_method = "41358DA92AFAAC7C338B8FDD86F6983F")
    public void run() {
        sync.innerRun();
        // ---------- Original Method ----------
        //sync.innerRun();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.289 -0400", hash_original_method = "016A9258BFECCECB9307E0C389EB3A3D", hash_generated_method = "AEE2ADC3F1DDC3CCC61D9E1895485490")
    protected boolean runAndReset() {
        boolean varAE2B8B7DE670A1AC39F7189A42A39D82_1650981493 = (sync.innerRunAndReset());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_234683087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_234683087;
        // ---------- Original Method ----------
        //return sync.innerRunAndReset();
    }

    
    private final class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.289 -0400", hash_original_field = "765D2EC94553B7CF4C971E7DFCF0E851", hash_generated_field = "B86134CFEB8FBFA3192E582367273039")

        private Callable<V> callable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.289 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "48DD7F9F3DDF2001AA8AEF95D0F84BB9")

        private V result;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.289 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

        private Throwable exception;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.289 -0400", hash_original_field = "4BAD0B8DD3074CD43F641C2AC22A3571", hash_generated_field = "93A1C41CF6D42E56BD1E63B8EC2F515C")

        private volatile Thread runner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.289 -0400", hash_original_method = "D4E27E5AB3ABB7CBBB62FE148674AC0F", hash_generated_method = "571EDA94F9E2C606AE2FD2F082453C98")
          Sync(Callable<V> callable) {
            this.callable = callable;
            // ---------- Original Method ----------
            //this.callable = callable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.289 -0400", hash_original_method = "87EA2642D244DCFE21163D8924915415", hash_generated_method = "EB654A5213B9392AA929D72493F23D04")
        private boolean ranOrCancelled(int state) {
            addTaint(state);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1100023985 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1100023985;
            // ---------- Original Method ----------
            //return (state & (RAN | CANCELLED)) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.290 -0400", hash_original_method = "CB8395C0A8B6CFC4974D10648908BD61", hash_generated_method = "7ED23A531B4FD0858957D2B8DCEC6A53")
        protected int tryAcquireShared(int ignore) {
            {
                boolean var8BFC5F575698513A7EE323356BA90101_669762193 = (innerIsDone());
            } //End flattened ternary
            addTaint(ignore);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983097625 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983097625;
            // ---------- Original Method ----------
            //return innerIsDone() ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.290 -0400", hash_original_method = "BADEFBD4164CAA2A58BD789F486A58F8", hash_generated_method = "657BDB97BDB3CCDD35AAB7E49172D920")
        protected boolean tryReleaseShared(int ignore) {
            runner = null;
            addTaint(ignore);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396600994 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396600994;
            // ---------- Original Method ----------
            //runner = null;
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.291 -0400", hash_original_method = "D8E0DD690F3527605076B5F197BA585A", hash_generated_method = "75C6E8054AA549E3B8BE7183646249F2")
         boolean innerIsCancelled() {
            boolean var8BEF59445BD052803CE0794E87BAA6DD_989883003 = (getState() == CANCELLED);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93534487 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_93534487;
            // ---------- Original Method ----------
            //return getState() == CANCELLED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.291 -0400", hash_original_method = "3CE62A51F6A5DB16A8E43D03725714DF", hash_generated_method = "23638D3D36C5165D127B6F259B65AB87")
         boolean innerIsDone() {
            boolean var8999482CA2B0B8CB4140FFAD837B9ECA_168776220 = (ranOrCancelled(getState()) && runner == null);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986162679 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_986162679;
            // ---------- Original Method ----------
            //return ranOrCancelled(getState()) && runner == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.292 -0400", hash_original_method = "E3CC861BC123329FE0CD5116647662CC", hash_generated_method = "D5A759E40CC4BB26E181E9347EB975E5")
         V innerGet() throws InterruptedException, ExecutionException {
            V varB4EAC82CA7396A68D541C85D26508E83_1644375271 = null; //Variable for return #1
            acquireSharedInterruptibly(0);
            {
                boolean var243AC7C964630701EBA35884971CFA3E_1922880871 = (getState() == CANCELLED);
                if (DroidSafeAndroidRuntime.control) throw new CancellationException();
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new ExecutionException(exception);
            varB4EAC82CA7396A68D541C85D26508E83_1644375271 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1644375271.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1644375271;
            // ---------- Original Method ----------
            //acquireSharedInterruptibly(0);
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.294 -0400", hash_original_method = "C6C2CADBDD008A3436D4C69E1505E94B", hash_generated_method = "F0F964DE87FEF8C21CE8A35DD9ED0E5A")
         V innerGet(long nanosTimeout) throws InterruptedException, ExecutionException, TimeoutException {
            V varB4EAC82CA7396A68D541C85D26508E83_1341756350 = null; //Variable for return #1
            {
                boolean var879BFE9597045A774039A7B438000BFA_66149323 = (!tryAcquireSharedNanos(0, nanosTimeout));
                if (DroidSafeAndroidRuntime.control) throw new TimeoutException();
            } //End collapsed parenthetic
            {
                boolean var243AC7C964630701EBA35884971CFA3E_1135292662 = (getState() == CANCELLED);
                if (DroidSafeAndroidRuntime.control) throw new CancellationException();
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new ExecutionException(exception);
            varB4EAC82CA7396A68D541C85D26508E83_1341756350 = result;
            addTaint(nanosTimeout);
            varB4EAC82CA7396A68D541C85D26508E83_1341756350.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1341756350;
            // ---------- Original Method ----------
            //if (!tryAcquireSharedNanos(0, nanosTimeout))
                //throw new TimeoutException();
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.296 -0400", hash_original_method = "02A830CC89A3607D091CAAFD46553563", hash_generated_method = "A58BC31071721EEFD6DDF1FFF1A8F6A7")
         void innerSet(V v) {
            {
                int s = getState();
                {
                    releaseShared(0);
                } //End block
                {
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_1214912524 = (compareAndSetState(s, RAN));
                    {
                        result = v;
                        releaseShared(0);
                        done();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //for (;;) {
                //int s = getState();
                //if (s == RAN)
                    //return;
                //if (s == CANCELLED) {
                    //releaseShared(0);
                    //return;
                //}
                //if (compareAndSetState(s, RAN)) {
                    //result = v;
                    //releaseShared(0);
                    //done();
                    //return;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.299 -0400", hash_original_method = "05A852D9D717B3F2A7ED4890D7DD8417", hash_generated_method = "0C67DD97E8492934ED3A5016739993D2")
         void innerSetException(Throwable t) {
            {
                int s = getState();
                {
                    releaseShared(0);
                } //End block
                {
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_2005516467 = (compareAndSetState(s, RAN));
                    {
                        exception = t;
                        releaseShared(0);
                        done();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //for (;;) {
                //int s = getState();
                //if (s == RAN)
                    //return;
                //if (s == CANCELLED) {
                    //releaseShared(0);
                    //return;
                //}
                //if (compareAndSetState(s, RAN)) {
                    //exception = t;
                    //releaseShared(0);
                    //done();
                    //return;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.301 -0400", hash_original_method = "8B39040A94FB4A11910F39A32682A441", hash_generated_method = "12988E91D09A7F14F5365E9CB3569C44")
         boolean innerCancel(boolean mayInterruptIfRunning) {
            {
                int s = getState();
                {
                    boolean var654D8D629DE56FE5E8B24F2A611B22E8_1282585350 = (ranOrCancelled(s));
                } //End collapsed parenthetic
                {
                    boolean varF924582CA0B0E32FB2E38FF23994889A_856967304 = (compareAndSetState(s, CANCELLED));
                } //End collapsed parenthetic
            } //End block
            {
                Thread r = runner;
                r.interrupt();
            } //End block
            releaseShared(0);
            done();
            addTaint(mayInterruptIfRunning);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498000314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498000314;
            // ---------- Original Method ----------
            //for (;;) {
                //int s = getState();
                //if (ranOrCancelled(s))
                    //return false;
                //if (compareAndSetState(s, CANCELLED))
                    //break;
            //}
            //if (mayInterruptIfRunning) {
                //Thread r = runner;
                //if (r != null)
                    //r.interrupt();
            //}
            //releaseShared(0);
            //done();
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.302 -0400", hash_original_method = "98D56FA1D01F6A8481F25F546B1688C1", hash_generated_method = "A8BA926A718FA549DEFE818C0FDEBF5C")
         void innerRun() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_1382037277 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            runner = Thread.currentThread();
            {
                boolean varF5ABBEC647038120E0FB1CB92F8BC93A_1962012196 = (getState() == RUNNING);
                {
                    V result;
                    try 
                    {
                        result = callable.call();
                    } //End block
                    catch (Throwable ex)
                    {
                        setException(ex);
                        return;
                    } //End block
                    set(result);
                } //End block
                {
                    releaseShared(0);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (!compareAndSetState(READY, RUNNING))
                //return;
            //runner = Thread.currentThread();
            //if (getState() == RUNNING) { 
                //V result;
                //try {
                    //result = callable.call();
                //} catch (Throwable ex) {
                    //setException(ex);
                    //return;
                //}
                //set(result);
            //} else {
                //releaseShared(0); 
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.302 -0400", hash_original_method = "8E960784829E06CF5804B32B20F49AB2", hash_generated_method = "6727B96B975DE3F1DEEE6DDAF331F036")
         boolean innerRunAndReset() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_2022169738 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            try 
            {
                runner = Thread.currentThread();
                {
                    boolean var83983DFCC8BA2829DC391A1772D9E100_471798983 = (getState() == RUNNING);
                    callable.call();
                } //End collapsed parenthetic
                runner = null;
                boolean varC5BE5D0497CC7CF959738250D8E5A8F5_1812300832 = (compareAndSetState(RUNNING, READY));
            } //End block
            catch (Throwable ex)
            {
                setException(ex);
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305756258 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305756258;
            // ---------- Original Method ----------
            //if (!compareAndSetState(READY, RUNNING))
                //return false;
            //try {
                //runner = Thread.currentThread();
                //if (getState() == RUNNING)
                    //callable.call(); 
                //runner = null;
                //return compareAndSetState(RUNNING, READY);
            //} catch (Throwable ex) {
                //setException(ex);
                //return false;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.302 -0400", hash_original_field = "3BC169E14F9F21C778FF7675E886E329", hash_generated_field = "A00041810A819D5E857048CB950A7783")

        private static final long serialVersionUID = -7828117401763700385L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.302 -0400", hash_original_field = "C7C7980D5941588A0F784DFB73417B5E", hash_generated_field = "13F9744A97D618343432AF93BBD9D480")

        private static final int READY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.302 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "051A4B9B2D44F7620AA6A669FD31AABF")

        private static final int RUNNING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.302 -0400", hash_original_field = "9BE927E22379F613E02A376142663CB6", hash_generated_field = "B92FE57A7EFAB742112B6F9BC9D5B492")

        private static final int RAN = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.302 -0400", hash_original_field = "3BB93A5F6E438EA604AD3BA36C8B338D", hash_generated_field = "28A434F6555460870A9E786CF0B89DF4")

        private static final int CANCELLED = 4;
    }


    
}

