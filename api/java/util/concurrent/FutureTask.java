package java.util.concurrent;

// Droidsafe Imports
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class FutureTask<V> implements RunnableFuture<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.455 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.455 -0400", hash_original_method = "EBD25CFA864782219EF130D05DE406FC", hash_generated_method = "D7BE11182C95A08A74F354E292576973")
    public  FutureTask(Callable<V> callable) {
        if(callable == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1701276344 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1701276344.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1701276344;
        }
        sync = new Sync(callable);
        // ---------- Original Method ----------
        //if (callable == null)
            //throw new NullPointerException();
        //sync = new Sync(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.455 -0400", hash_original_method = "343C63FBFE3927352CC6BAC59E679D87", hash_generated_method = "445A2B29F4B296EBE069C195B0BDE12E")
    public  FutureTask(Runnable runnable, V result) {
        sync = new Sync(Executors.callable(runnable, result));
        // ---------- Original Method ----------
        //sync = new Sync(Executors.callable(runnable, result));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.455 -0400", hash_original_method = "87256A2F3BC620B5A65A2DEACA482F4A", hash_generated_method = "8D30CE4B56282F029C010EBB33E163F5")
    public boolean isCancelled() {
        boolean var8BF5A93E962ACD00396C5A3C10E32D6D_348494343 = (sync.innerIsCancelled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1875165693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1875165693;
        // ---------- Original Method ----------
        //return sync.innerIsCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.456 -0400", hash_original_method = "2C3AC011A196BCCAC0E9F76136242F15", hash_generated_method = "B6BC7738B067CE8F86B9EADCF2AB5E81")
    public boolean isDone() {
        boolean var0CA19EE88E1C42206EB8810802615E80_1537373635 = (sync.innerIsDone());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1191241179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1191241179;
        // ---------- Original Method ----------
        //return sync.innerIsDone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.456 -0400", hash_original_method = "88A87863EC7E1056D8FE46146EF894BC", hash_generated_method = "3C9230DE8449CA771AE03DC769525DEE")
    public boolean cancel(boolean mayInterruptIfRunning) {
        addTaint(mayInterruptIfRunning);
        boolean varFB185C2D76B8417436995523961A0076_1698453178 = (sync.innerCancel(mayInterruptIfRunning));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557657162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557657162;
        // ---------- Original Method ----------
        //return sync.innerCancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.456 -0400", hash_original_method = "162C3BFD86443C5C054F309FCD025483", hash_generated_method = "7AD612FEFFDF609806F38A1F8ED1EB37")
    public V get() throws InterruptedException, ExecutionException {
V var85F1CBC08013F2D5AD7E74CF674146E5_1794546674 =         sync.innerGet();
        var85F1CBC08013F2D5AD7E74CF674146E5_1794546674.addTaint(taint);
        return var85F1CBC08013F2D5AD7E74CF674146E5_1794546674;
        // ---------- Original Method ----------
        //return sync.innerGet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.456 -0400", hash_original_method = "90F54A92EEE05A0240D215CA50ECEC0E", hash_generated_method = "B26A13B8C053FC4838B0DE08DD4B7FD7")
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        addTaint(unit.getTaint());
        addTaint(timeout);
V var4C2A78DBAFD6AD30BA87C753CA8CEF1C_1774988166 =         sync.innerGet(unit.toNanos(timeout));
        var4C2A78DBAFD6AD30BA87C753CA8CEF1C_1774988166.addTaint(taint);
        return var4C2A78DBAFD6AD30BA87C753CA8CEF1C_1774988166;
        // ---------- Original Method ----------
        //return sync.innerGet(unit.toNanos(timeout));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.457 -0400", hash_original_method = "17876694EB227DDF47ED60F50DDB1AB8", hash_generated_method = "11FDBB8776367F84FB5CD85A1E1E97A9")
    protected void done() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.457 -0400", hash_original_method = "A074A8CE9CED8FEBE8C93AF5A1F30EB2", hash_generated_method = "A1594A2580EEC5A83119579394EA3302")
    protected void set(V v) {
        addTaint(v.getTaint());
        sync.innerSet(v);
        // ---------- Original Method ----------
        //sync.innerSet(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.457 -0400", hash_original_method = "FDCD59BD475B14EFA0816CB7C0405257", hash_generated_method = "2DD535C3636DF6E17BCE00AFCC8AAAE5")
    protected void setException(Throwable t) {
        addTaint(t.getTaint());
        sync.innerSetException(t);
        // ---------- Original Method ----------
        //sync.innerSetException(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.457 -0400", hash_original_method = "C774B2E8DA9F32069C4712123B43B6CD", hash_generated_method = "41358DA92AFAAC7C338B8FDD86F6983F")
    public void run() {
        sync.innerRun();
        // ---------- Original Method ----------
        //sync.innerRun();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.457 -0400", hash_original_method = "016A9258BFECCECB9307E0C389EB3A3D", hash_generated_method = "7D1C4DD5F8C248378DB8CD9C7170327D")
    protected boolean runAndReset() {
        boolean var3C3199211714AF73C9FF4117A88D6471_1918113385 = (sync.innerRunAndReset());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1957528308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1957528308;
        // ---------- Original Method ----------
        //return sync.innerRunAndReset();
    }

    
    private final class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.458 -0400", hash_original_field = "765D2EC94553B7CF4C971E7DFCF0E851", hash_generated_field = "B86134CFEB8FBFA3192E582367273039")

        private Callable<V> callable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.458 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "48DD7F9F3DDF2001AA8AEF95D0F84BB9")

        private V result;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.458 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

        private Throwable exception;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.458 -0400", hash_original_field = "4BAD0B8DD3074CD43F641C2AC22A3571", hash_generated_field = "93A1C41CF6D42E56BD1E63B8EC2F515C")

        private volatile Thread runner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.458 -0400", hash_original_method = "D4E27E5AB3ABB7CBBB62FE148674AC0F", hash_generated_method = "571EDA94F9E2C606AE2FD2F082453C98")
          Sync(Callable<V> callable) {
            this.callable = callable;
            // ---------- Original Method ----------
            //this.callable = callable;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.458 -0400", hash_original_method = "87EA2642D244DCFE21163D8924915415", hash_generated_method = "E62589B3EF60410D33CA60FFBE562394")
        private boolean ranOrCancelled(int state) {
            addTaint(state);
            boolean varF426E25E5EBA5053CDF87EB34E0847CC_1935553532 = ((state & (RAN | CANCELLED)) != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2134968776 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2134968776;
            // ---------- Original Method ----------
            //return (state & (RAN | CANCELLED)) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.459 -0400", hash_original_method = "CB8395C0A8B6CFC4974D10648908BD61", hash_generated_method = "4678C160F0810824AB492DC102D49279")
        protected int tryAcquireShared(int ignore) {
            addTaint(ignore);
            int var97132568738497C8C8BBD351EC2CB210_933180107 = (innerIsDone() ? 1 : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24952024 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24952024;
            // ---------- Original Method ----------
            //return innerIsDone() ? 1 : -1;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.459 -0400", hash_original_method = "BADEFBD4164CAA2A58BD789F486A58F8", hash_generated_method = "A3EF8B9764A3D10B70FB5F0A1088C751")
        protected boolean tryReleaseShared(int ignore) {
            addTaint(ignore);
            runner = null;
            boolean varB326B5062B2F0E69046810717534CB09_66929836 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1004870866 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1004870866;
            // ---------- Original Method ----------
            //runner = null;
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.459 -0400", hash_original_method = "D8E0DD690F3527605076B5F197BA585A", hash_generated_method = "6A4EEFB90120039019200AF395A8A87F")
         boolean innerIsCancelled() {
            boolean varC8F0BB487210E6EF22F33D571975E8E6_1537776690 = (getState() == CANCELLED);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_994405306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_994405306;
            // ---------- Original Method ----------
            //return getState() == CANCELLED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.459 -0400", hash_original_method = "3CE62A51F6A5DB16A8E43D03725714DF", hash_generated_method = "8E2EA832AEF3EC2F89D6AEDEF8D87595")
         boolean innerIsDone() {
            boolean var4316EAD4E51BC5A1F44BFD16D0388A9F_1154627627 = (ranOrCancelled(getState()) && runner == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_280716114 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_280716114;
            // ---------- Original Method ----------
            //return ranOrCancelled(getState()) && runner == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.460 -0400", hash_original_method = "E3CC861BC123329FE0CD5116647662CC", hash_generated_method = "2ADF439E33E28D167346D8A91FAFAD6F")
         V innerGet() throws InterruptedException, ExecutionException {
            acquireSharedInterruptibly(0);
            if(getState() == CANCELLED)            
            {
            CancellationException var4B526D5FE195F3D5851ADC840E5D7276_994525510 = new CancellationException();
            var4B526D5FE195F3D5851ADC840E5D7276_994525510.addTaint(taint);
            throw var4B526D5FE195F3D5851ADC840E5D7276_994525510;
            }
            if(exception != null)            
            {
            ExecutionException var68D16561C2393D703CD2D9C1CC5AF55E_1309354695 = new ExecutionException(exception);
            var68D16561C2393D703CD2D9C1CC5AF55E_1309354695.addTaint(taint);
            throw var68D16561C2393D703CD2D9C1CC5AF55E_1309354695;
            }
V varDC838461EE2FA0CA4C9BBB70A15456B0_906807836 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_906807836.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_906807836;
            // ---------- Original Method ----------
            //acquireSharedInterruptibly(0);
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.460 -0400", hash_original_method = "C6C2CADBDD008A3436D4C69E1505E94B", hash_generated_method = "BD6B235060C65888B3F91998A489D691")
         V innerGet(long nanosTimeout) throws InterruptedException, ExecutionException, TimeoutException {
            addTaint(nanosTimeout);
            if(!tryAcquireSharedNanos(0, nanosTimeout))            
            {
            TimeoutException var3B6A086CA796B867C2DC52AFEEF9D0CF_1155125672 = new TimeoutException();
            var3B6A086CA796B867C2DC52AFEEF9D0CF_1155125672.addTaint(taint);
            throw var3B6A086CA796B867C2DC52AFEEF9D0CF_1155125672;
            }
            if(getState() == CANCELLED)            
            {
            CancellationException var4B526D5FE195F3D5851ADC840E5D7276_1455724378 = new CancellationException();
            var4B526D5FE195F3D5851ADC840E5D7276_1455724378.addTaint(taint);
            throw var4B526D5FE195F3D5851ADC840E5D7276_1455724378;
            }
            if(exception != null)            
            {
            ExecutionException var68D16561C2393D703CD2D9C1CC5AF55E_591613144 = new ExecutionException(exception);
            var68D16561C2393D703CD2D9C1CC5AF55E_591613144.addTaint(taint);
            throw var68D16561C2393D703CD2D9C1CC5AF55E_591613144;
            }
V varDC838461EE2FA0CA4C9BBB70A15456B0_844108631 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_844108631.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_844108631;
            // ---------- Original Method ----------
            //if (!tryAcquireSharedNanos(0, nanosTimeout))
                //throw new TimeoutException();
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.460 -0400", hash_original_method = "02A830CC89A3607D091CAAFD46553563", hash_generated_method = "7C3F8D4570A36B0D1ADA9ED5088FE45B")
         void innerSet(V v) {
for(;;)
            {
                int s = getState();
                if(s == RAN)                
                return;
                if(s == CANCELLED)                
                {
                    releaseShared(0);
                    return;
                } //End block
                if(compareAndSetState(s, RAN))                
                {
                    result = v;
                    releaseShared(0);
                    done();
                    return;
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.461 -0400", hash_original_method = "05A852D9D717B3F2A7ED4890D7DD8417", hash_generated_method = "C87C533C9626844DD0FC295C321C0FC9")
         void innerSetException(Throwable t) {
for(;;)
            {
                int s = getState();
                if(s == RAN)                
                return;
                if(s == CANCELLED)                
                {
                    releaseShared(0);
                    return;
                } //End block
                if(compareAndSetState(s, RAN))                
                {
                    exception = t;
                    releaseShared(0);
                    done();
                    return;
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.462 -0400", hash_original_method = "8B39040A94FB4A11910F39A32682A441", hash_generated_method = "BF14B844B326EE6FC5F0EC0FCB7F58FA")
         boolean innerCancel(boolean mayInterruptIfRunning) {
            addTaint(mayInterruptIfRunning);
for(;;)
            {
                int s = getState();
                if(ranOrCancelled(s))                
                {
                boolean var68934A3E9455FA72420237EB05902327_2121567707 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030652884 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030652884;
                }
                if(compareAndSetState(s, CANCELLED))                
                break;
            } //End block
            if(mayInterruptIfRunning)            
            {
                Thread r = runner;
                if(r != null)                
                r.interrupt();
            } //End block
            releaseShared(0);
            done();
            boolean varB326B5062B2F0E69046810717534CB09_1046277073 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_255745033 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_255745033;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.462 -0400", hash_original_method = "98D56FA1D01F6A8481F25F546B1688C1", hash_generated_method = "0100183BD008894C82E23B7A43D715DC")
         void innerRun() {
            if(!compareAndSetState(READY, RUNNING))            
            return;
            runner = Thread.currentThread();
            if(getState() == RUNNING)            
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
            else
            {
                releaseShared(0);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.463 -0400", hash_original_method = "8E960784829E06CF5804B32B20F49AB2", hash_generated_method = "BB60D7B78009EA86BA90884EAB88DB9B")
         boolean innerRunAndReset() {
            if(!compareAndSetState(READY, RUNNING))            
            {
            boolean var68934A3E9455FA72420237EB05902327_795621546 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555109472 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555109472;
            }
            try 
            {
                runner = Thread.currentThread();
                if(getState() == RUNNING)                
                callable.call();
                runner = null;
                boolean var30F1DD35E2B5768309A006C35C7113CF_622959898 = (compareAndSetState(RUNNING, READY));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789005803 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789005803;
            } //End block
            catch (Throwable ex)
            {
                setException(ex);
                boolean var68934A3E9455FA72420237EB05902327_1727093314 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725466877 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_725466877;
            } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.463 -0400", hash_original_field = "3BC169E14F9F21C778FF7675E886E329", hash_generated_field = "A00041810A819D5E857048CB950A7783")

        private static final long serialVersionUID = -7828117401763700385L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.463 -0400", hash_original_field = "C7C7980D5941588A0F784DFB73417B5E", hash_generated_field = "13F9744A97D618343432AF93BBD9D480")

        private static final int READY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.463 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "051A4B9B2D44F7620AA6A669FD31AABF")

        private static final int RUNNING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.463 -0400", hash_original_field = "9BE927E22379F613E02A376142663CB6", hash_generated_field = "B92FE57A7EFAB742112B6F9BC9D5B492")

        private static final int RAN = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.463 -0400", hash_original_field = "3BB93A5F6E438EA604AD3BA36C8B338D", hash_generated_field = "28A434F6555460870A9E786CF0B89DF4")

        private static final int CANCELLED = 4;
    }


    
}

