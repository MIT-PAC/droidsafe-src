package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.locks.*;

public class FutureTask<V> implements RunnableFuture<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.981 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.981 -0400", hash_original_method = "EBD25CFA864782219EF130D05DE406FC", hash_generated_method = "4FE95AE6B23532D00A926F0E9D1064E9")
    public  FutureTask(Callable<V> callable) {
    if(callable == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1802023511 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1802023511.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1802023511;
        }
        sync = new Sync(callable);
        // ---------- Original Method ----------
        //if (callable == null)
            //throw new NullPointerException();
        //sync = new Sync(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.982 -0400", hash_original_method = "343C63FBFE3927352CC6BAC59E679D87", hash_generated_method = "445A2B29F4B296EBE069C195B0BDE12E")
    public  FutureTask(Runnable runnable, V result) {
        sync = new Sync(Executors.callable(runnable, result));
        // ---------- Original Method ----------
        //sync = new Sync(Executors.callable(runnable, result));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.982 -0400", hash_original_method = "87256A2F3BC620B5A65A2DEACA482F4A", hash_generated_method = "0ABFD0B54346C40247F2C2AF9981F5FE")
    public boolean isCancelled() {
        boolean var8BF5A93E962ACD00396C5A3C10E32D6D_1183784444 = (sync.innerIsCancelled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231070757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231070757;
        // ---------- Original Method ----------
        //return sync.innerIsCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.982 -0400", hash_original_method = "2C3AC011A196BCCAC0E9F76136242F15", hash_generated_method = "59EFB71300EA11A8BAAD7AC2E328DE44")
    public boolean isDone() {
        boolean var0CA19EE88E1C42206EB8810802615E80_471821421 = (sync.innerIsDone());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914181462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914181462;
        // ---------- Original Method ----------
        //return sync.innerIsDone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.983 -0400", hash_original_method = "88A87863EC7E1056D8FE46146EF894BC", hash_generated_method = "F724B4EE46EE9FABCE2FFBC51DA8ECD8")
    public boolean cancel(boolean mayInterruptIfRunning) {
        addTaint(mayInterruptIfRunning);
        boolean varFB185C2D76B8417436995523961A0076_2027804805 = (sync.innerCancel(mayInterruptIfRunning));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110661112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110661112;
        // ---------- Original Method ----------
        //return sync.innerCancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.983 -0400", hash_original_method = "162C3BFD86443C5C054F309FCD025483", hash_generated_method = "8DB74296B66A17B260FA3B9508C33CA8")
    public V get() throws InterruptedException, ExecutionException {
V var85F1CBC08013F2D5AD7E74CF674146E5_2115448836 =         sync.innerGet();
        var85F1CBC08013F2D5AD7E74CF674146E5_2115448836.addTaint(taint);
        return var85F1CBC08013F2D5AD7E74CF674146E5_2115448836;
        // ---------- Original Method ----------
        //return sync.innerGet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.983 -0400", hash_original_method = "90F54A92EEE05A0240D215CA50ECEC0E", hash_generated_method = "0D15435293D965FA0DC2855B3C323E3C")
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        addTaint(unit.getTaint());
        addTaint(timeout);
V var4C2A78DBAFD6AD30BA87C753CA8CEF1C_100659634 =         sync.innerGet(unit.toNanos(timeout));
        var4C2A78DBAFD6AD30BA87C753CA8CEF1C_100659634.addTaint(taint);
        return var4C2A78DBAFD6AD30BA87C753CA8CEF1C_100659634;
        // ---------- Original Method ----------
        //return sync.innerGet(unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.984 -0400", hash_original_method = "17876694EB227DDF47ED60F50DDB1AB8", hash_generated_method = "11FDBB8776367F84FB5CD85A1E1E97A9")
    protected void done() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.984 -0400", hash_original_method = "A074A8CE9CED8FEBE8C93AF5A1F30EB2", hash_generated_method = "A1594A2580EEC5A83119579394EA3302")
    protected void set(V v) {
        addTaint(v.getTaint());
        sync.innerSet(v);
        // ---------- Original Method ----------
        //sync.innerSet(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.984 -0400", hash_original_method = "FDCD59BD475B14EFA0816CB7C0405257", hash_generated_method = "2DD535C3636DF6E17BCE00AFCC8AAAE5")
    protected void setException(Throwable t) {
        addTaint(t.getTaint());
        sync.innerSetException(t);
        // ---------- Original Method ----------
        //sync.innerSetException(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.985 -0400", hash_original_method = "C774B2E8DA9F32069C4712123B43B6CD", hash_generated_method = "41358DA92AFAAC7C338B8FDD86F6983F")
    public void run() {
        sync.innerRun();
        // ---------- Original Method ----------
        //sync.innerRun();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.985 -0400", hash_original_method = "016A9258BFECCECB9307E0C389EB3A3D", hash_generated_method = "DD341B2A82AEFE56CA5FEF1489661B05")
    protected boolean runAndReset() {
        boolean var3C3199211714AF73C9FF4117A88D6471_2088369447 = (sync.innerRunAndReset());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149845545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149845545;
        // ---------- Original Method ----------
        //return sync.innerRunAndReset();
    }

    
    private final class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.985 -0400", hash_original_field = "765D2EC94553B7CF4C971E7DFCF0E851", hash_generated_field = "B86134CFEB8FBFA3192E582367273039")

        private Callable<V> callable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.985 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "48DD7F9F3DDF2001AA8AEF95D0F84BB9")

        private V result;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.986 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

        private Throwable exception;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.986 -0400", hash_original_field = "4BAD0B8DD3074CD43F641C2AC22A3571", hash_generated_field = "93A1C41CF6D42E56BD1E63B8EC2F515C")

        private volatile Thread runner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.986 -0400", hash_original_method = "D4E27E5AB3ABB7CBBB62FE148674AC0F", hash_generated_method = "571EDA94F9E2C606AE2FD2F082453C98")
          Sync(Callable<V> callable) {
            this.callable = callable;
            // ---------- Original Method ----------
            //this.callable = callable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.987 -0400", hash_original_method = "87EA2642D244DCFE21163D8924915415", hash_generated_method = "21A1A0A6209306BA9DA65CADE7397404")
        private boolean ranOrCancelled(int state) {
            addTaint(state);
            boolean varF426E25E5EBA5053CDF87EB34E0847CC_1956761181 = ((state & (RAN | CANCELLED)) != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1595216123 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1595216123;
            // ---------- Original Method ----------
            //return (state & (RAN | CANCELLED)) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.987 -0400", hash_original_method = "CB8395C0A8B6CFC4974D10648908BD61", hash_generated_method = "0E9BD1E4C0F7C2094876934C2A37B266")
        protected int tryAcquireShared(int ignore) {
            addTaint(ignore);
            int var97132568738497C8C8BBD351EC2CB210_721125372 = (innerIsDone() ? 1 : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646890725 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646890725;
            // ---------- Original Method ----------
            //return innerIsDone() ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.987 -0400", hash_original_method = "BADEFBD4164CAA2A58BD789F486A58F8", hash_generated_method = "B6815821F3F6182C5AF9D376BF0F1DE3")
        protected boolean tryReleaseShared(int ignore) {
            addTaint(ignore);
            runner = null;
            boolean varB326B5062B2F0E69046810717534CB09_2064005807 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1911607782 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1911607782;
            // ---------- Original Method ----------
            //runner = null;
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.988 -0400", hash_original_method = "D8E0DD690F3527605076B5F197BA585A", hash_generated_method = "A75A7FE8F5D832842004618671C52292")
         boolean innerIsCancelled() {
            boolean varC8F0BB487210E6EF22F33D571975E8E6_828861593 = (getState() == CANCELLED);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249244779 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_249244779;
            // ---------- Original Method ----------
            //return getState() == CANCELLED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.988 -0400", hash_original_method = "3CE62A51F6A5DB16A8E43D03725714DF", hash_generated_method = "0A09FA5538AA78F35C613CC4A31342EB")
         boolean innerIsDone() {
            boolean var4316EAD4E51BC5A1F44BFD16D0388A9F_602664300 = (ranOrCancelled(getState()) && runner == null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_466413977 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_466413977;
            // ---------- Original Method ----------
            //return ranOrCancelled(getState()) && runner == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.989 -0400", hash_original_method = "E3CC861BC123329FE0CD5116647662CC", hash_generated_method = "680449F11F46B403FDAD1B719B797BB7")
         V innerGet() throws InterruptedException, ExecutionException {
            acquireSharedInterruptibly(0);
    if(getState() == CANCELLED)            
            {
            CancellationException var4B526D5FE195F3D5851ADC840E5D7276_70340072 = new CancellationException();
            var4B526D5FE195F3D5851ADC840E5D7276_70340072.addTaint(taint);
            throw var4B526D5FE195F3D5851ADC840E5D7276_70340072;
            }
    if(exception != null)            
            {
            ExecutionException var68D16561C2393D703CD2D9C1CC5AF55E_1854543125 = new ExecutionException(exception);
            var68D16561C2393D703CD2D9C1CC5AF55E_1854543125.addTaint(taint);
            throw var68D16561C2393D703CD2D9C1CC5AF55E_1854543125;
            }
V varDC838461EE2FA0CA4C9BBB70A15456B0_1115990545 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1115990545.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1115990545;
            // ---------- Original Method ----------
            //acquireSharedInterruptibly(0);
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.989 -0400", hash_original_method = "C6C2CADBDD008A3436D4C69E1505E94B", hash_generated_method = "549FDCC272E6CD805037CFCE6B12585F")
         V innerGet(long nanosTimeout) throws InterruptedException, ExecutionException, TimeoutException {
            addTaint(nanosTimeout);
    if(!tryAcquireSharedNanos(0, nanosTimeout))            
            {
            TimeoutException var3B6A086CA796B867C2DC52AFEEF9D0CF_1311390666 = new TimeoutException();
            var3B6A086CA796B867C2DC52AFEEF9D0CF_1311390666.addTaint(taint);
            throw var3B6A086CA796B867C2DC52AFEEF9D0CF_1311390666;
            }
    if(getState() == CANCELLED)            
            {
            CancellationException var4B526D5FE195F3D5851ADC840E5D7276_1433822406 = new CancellationException();
            var4B526D5FE195F3D5851ADC840E5D7276_1433822406.addTaint(taint);
            throw var4B526D5FE195F3D5851ADC840E5D7276_1433822406;
            }
    if(exception != null)            
            {
            ExecutionException var68D16561C2393D703CD2D9C1CC5AF55E_1362167179 = new ExecutionException(exception);
            var68D16561C2393D703CD2D9C1CC5AF55E_1362167179.addTaint(taint);
            throw var68D16561C2393D703CD2D9C1CC5AF55E_1362167179;
            }
V varDC838461EE2FA0CA4C9BBB70A15456B0_593420235 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_593420235.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_593420235;
            // ---------- Original Method ----------
            //if (!tryAcquireSharedNanos(0, nanosTimeout))
                //throw new TimeoutException();
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.990 -0400", hash_original_method = "02A830CC89A3607D091CAAFD46553563", hash_generated_method = "7C3F8D4570A36B0D1ADA9ED5088FE45B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.991 -0400", hash_original_method = "05A852D9D717B3F2A7ED4890D7DD8417", hash_generated_method = "C87C533C9626844DD0FC295C321C0FC9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.991 -0400", hash_original_method = "8B39040A94FB4A11910F39A32682A441", hash_generated_method = "557E3BEF6E866F69A282FCDC6C64D859")
         boolean innerCancel(boolean mayInterruptIfRunning) {
            addTaint(mayInterruptIfRunning);
for(;;)
            {
                int s = getState();
    if(ranOrCancelled(s))                
                {
                boolean var68934A3E9455FA72420237EB05902327_1876151986 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_931911463 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_931911463;
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
            boolean varB326B5062B2F0E69046810717534CB09_345156664 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567145191 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_567145191;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.992 -0400", hash_original_method = "98D56FA1D01F6A8481F25F546B1688C1", hash_generated_method = "0100183BD008894C82E23B7A43D715DC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.993 -0400", hash_original_method = "8E960784829E06CF5804B32B20F49AB2", hash_generated_method = "B8D9A86AC9C83BD4317810D7E222D0BF")
         boolean innerRunAndReset() {
    if(!compareAndSetState(READY, RUNNING))            
            {
            boolean var68934A3E9455FA72420237EB05902327_940514408 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1285162422 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1285162422;
            }
            try 
            {
                runner = Thread.currentThread();
    if(getState() == RUNNING)                
                callable.call();
                runner = null;
                boolean var30F1DD35E2B5768309A006C35C7113CF_1569137829 = (compareAndSetState(RUNNING, READY));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_169506409 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_169506409;
            } //End block
            catch (Throwable ex)
            {
                setException(ex);
                boolean var68934A3E9455FA72420237EB05902327_1856260131 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496623488 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_496623488;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.993 -0400", hash_original_field = "3BC169E14F9F21C778FF7675E886E329", hash_generated_field = "A00041810A819D5E857048CB950A7783")

        private static final long serialVersionUID = -7828117401763700385L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.993 -0400", hash_original_field = "C7C7980D5941588A0F784DFB73417B5E", hash_generated_field = "13F9744A97D618343432AF93BBD9D480")

        private static final int READY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.993 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "051A4B9B2D44F7620AA6A669FD31AABF")

        private static final int RUNNING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.994 -0400", hash_original_field = "9BE927E22379F613E02A376142663CB6", hash_generated_field = "B92FE57A7EFAB742112B6F9BC9D5B492")

        private static final int RAN = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.994 -0400", hash_original_field = "3BB93A5F6E438EA604AD3BA36C8B338D", hash_generated_field = "28A434F6555460870A9E786CF0B89DF4")

        private static final int CANCELLED = 4;
    }


    
}

