package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import libcore.util.EmptyArray;





public class SynchronousQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.913 -0400", hash_original_field = "14FF183E0CBF22E7DBE09157245ED2D4", hash_generated_field = "93A6B6C7FD7700420692EFD74AC915AE")

    private transient volatile Transferer transferer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.913 -0400", hash_original_field = "18B069DB69ED982634500077B1439F32", hash_generated_field = "E2A217843A6D418FDE83E1DD89178FFA")

    private ReentrantLock qlock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.913 -0400", hash_original_field = "882C5ACA03261179CC74C2C00EFBE286", hash_generated_field = "9EC2490AD04FFD57826C64D62CD6D006")

    private WaitQueue waitingProducers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.913 -0400", hash_original_field = "AF8EC88A663239AB823F4C324266FE94", hash_generated_field = "4EC4B53B46775F740D025ADAAB977973")

    private WaitQueue waitingConsumers;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.914 -0400", hash_original_method = "CA3CB3D951221FCCF0DFF3BB5DF12346", hash_generated_method = "5255A939CCFA97D45156B8A4109C3AE2")
    public  SynchronousQueue() {
        this(false);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.914 -0400", hash_original_method = "2A4F416DA0F8363F009FD8DA8EB74A84", hash_generated_method = "E36170E9580D212BFA99521F1CF0C67D")
    public  SynchronousQueue(boolean fair) {
        transferer = fair ? new TransferQueue() : new TransferStack();
        // ---------- Original Method ----------
        //transferer = fair ? new TransferQueue() : new TransferStack();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.914 -0400", hash_original_method = "C65E97EC40BB31D50DB029B0D4F47DF5", hash_generated_method = "F6B4FF5688091D0CB80966AF595DC4CB")
    public void put(E o) throws InterruptedException {
        addTaint(o.getTaint());
        if(o == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_751155328 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_751155328.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_751155328;
        }
        if(transferer.transfer(o, false, 0) == null)        
        {
            Thread.interrupted();
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_963824174 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_963824174.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_963824174;
        } //End block
        // ---------- Original Method ----------
        //if (o == null) throw new NullPointerException();
        //if (transferer.transfer(o, false, 0) == null) {
            //Thread.interrupted();
            //throw new InterruptedException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.915 -0400", hash_original_method = "3A6AFFAA000C17EA73FBC10B0EC018FD", hash_generated_method = "49A9B5C13056EF6C75CF8E0333829CEB")
    public boolean offer(E o, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(o.getTaint());
        if(o == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1378309901 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1378309901.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1378309901;
        }
        if(transferer.transfer(o, true, unit.toNanos(timeout)) != null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1595996749 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249267784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249267784;
        }
        if(!Thread.interrupted())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1192262195 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978395378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978395378;
        }
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_2045103343 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_2045103343.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_2045103343;
        // ---------- Original Method ----------
        //if (o == null) throw new NullPointerException();
        //if (transferer.transfer(o, true, unit.toNanos(timeout)) != null)
            //return true;
        //if (!Thread.interrupted())
            //return false;
        //throw new InterruptedException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.916 -0400", hash_original_method = "A4F84C12941B1214559E662FB5D2360B", hash_generated_method = "0380016AA9E5A8B6576AF2972D29C90D")
    public boolean offer(E e) {
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_675682722 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_675682722.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_675682722;
        }
        boolean var5C7FCA9FF17A7FA2A3B2DEDAF80D2328_970846616 = (transferer.transfer(e, true, 0) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1214970779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1214970779;
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //return transferer.transfer(e, true, 0) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.916 -0400", hash_original_method = "A59182A477060C80E9C0D7B7DD2CA2C3", hash_generated_method = "590F8E8EC9F11884B8BF546CABCF1EA4")
    public E take() throws InterruptedException {
        Object e = transferer.transfer(null, false, 0);
        if(e != null)        
        {
E var3BC4883C21B65D53A2DE2E8A607F7309_1787982592 =         (E)e;
        var3BC4883C21B65D53A2DE2E8A607F7309_1787982592.addTaint(taint);
        return var3BC4883C21B65D53A2DE2E8A607F7309_1787982592;
        }
        Thread.interrupted();
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_407798855 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_407798855.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_407798855;
        // ---------- Original Method ----------
        //Object e = transferer.transfer(null, false, 0);
        //if (e != null)
            //return (E)e;
        //Thread.interrupted();
        //throw new InterruptedException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.917 -0400", hash_original_method = "F80BFD27E2D553DA44FF7C91997050D6", hash_generated_method = "72D27AB3D99342F6B0B956C3838AF548")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        Object e = transferer.transfer(null, true, unit.toNanos(timeout));
        if(e != null || !Thread.interrupted())        
        {
E var3BC4883C21B65D53A2DE2E8A607F7309_2081475978 =         (E)e;
        var3BC4883C21B65D53A2DE2E8A607F7309_2081475978.addTaint(taint);
        return var3BC4883C21B65D53A2DE2E8A607F7309_2081475978;
        }
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_1486733122 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_1486733122.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_1486733122;
        // ---------- Original Method ----------
        //Object e = transferer.transfer(null, true, unit.toNanos(timeout));
        //if (e != null || !Thread.interrupted())
            //return (E)e;
        //throw new InterruptedException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.917 -0400", hash_original_method = "1663F66628103F625AD11623448BFB1D", hash_generated_method = "028ACEA8010FFEEEAB658143CC9A2ECD")
    public E poll() {
E varC4A3844E08F9AAE23566F5DB59A78299_1662287934 =         (E)transferer.transfer(null, true, 0);
        varC4A3844E08F9AAE23566F5DB59A78299_1662287934.addTaint(taint);
        return varC4A3844E08F9AAE23566F5DB59A78299_1662287934;
        // ---------- Original Method ----------
        //return (E)transferer.transfer(null, true, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.917 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "29198F3CDF5A957ADC3717A7563C83C4")
    public boolean isEmpty() {
        boolean varB326B5062B2F0E69046810717534CB09_1376791724 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_554684305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_554684305;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.918 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "67A8C3A71019E774425405715836B1BD")
    public int size() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2102726492 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376628724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376628724;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.918 -0400", hash_original_method = "859254362B8CFD4ECD77710B77AC10ED", hash_generated_method = "0EE106EC585D362B65E78C581BBDC4F8")
    public int remainingCapacity() {
        int varCFCD208495D565EF66E7DFF9F98764DA_489755012 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621110926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621110926;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.918 -0400", hash_original_method = "CAFED8DEE3108243325B67F5797719ED", hash_generated_method = "62E208A158681C1F982FD616252404DD")
    public void clear() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.919 -0400", hash_original_method = "133415712E6841A0903588DC5D4862AA", hash_generated_method = "6B8E2CA6E7DEC7C71E4C2BF20DBB5F23")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_972359577 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2118400946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2118400946;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.919 -0400", hash_original_method = "6081257F3AE1D633C77BCA63D6F77CB7", hash_generated_method = "6E24438A38106B28DA358BB924CFF475")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_881939342 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2114103677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2114103677;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.919 -0400", hash_original_method = "C503BED5AF377C63A87B0C398CACB95B", hash_generated_method = "D8BDBF6547D8CDCA9E28B4142FAC0ABB")
    public boolean containsAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var65FAF5A74582A5D73E221DB675503595_1854980555 = (c.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923893736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_923893736;
        // ---------- Original Method ----------
        //return c.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.920 -0400", hash_original_method = "EC0A570B588D76D8968190A1BD3D4040", hash_generated_method = "38C953AB7BE9327A263034F4E8BEC585")
    public boolean removeAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1038949525 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774581838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_774581838;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.920 -0400", hash_original_method = "13D5AD766AE77320C3CF56AB2E9E5FB4", hash_generated_method = "9CAEE849B83E7BA097DBDB6BC785AE05")
    public boolean retainAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1486804401 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507762777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507762777;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.921 -0400", hash_original_method = "2DC914F9B3C538818482710C9EAD9EFB", hash_generated_method = "5499B5C2AB6606C052FAFF4A42EFA25D")
    public E peek() {
E var540C13E9E156B687226421B24F2DF178_1758483355 =         null;
        var540C13E9E156B687226421B24F2DF178_1758483355.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1758483355;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.921 -0400", hash_original_method = "0BB2C5BB97AA1323E2FE15E87216E7E9", hash_generated_method = "36719496841EA8D27AC3037715B27A5B")
    public Iterator<E> iterator() {
Iterator<E> var5522EE06486778A0917B370AA7495851_755919480 =         Collections.<E>emptySet().iterator();
        var5522EE06486778A0917B370AA7495851_755919480.addTaint(taint);
        return var5522EE06486778A0917B370AA7495851_755919480;
        // ---------- Original Method ----------
        //return Collections.<E>emptySet().iterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.921 -0400", hash_original_method = "AAA5D1CBE91ADDEA174F65821E23BE58", hash_generated_method = "296423FC1B2A368B116A9D2C50A39609")
    public Object[] toArray() {
Object[] var3CDAC8E1894CA4B3B37667162540A097_1398858241 =         EmptyArray.OBJECT;
        var3CDAC8E1894CA4B3B37667162540A097_1398858241.addTaint(taint);
        return var3CDAC8E1894CA4B3B37667162540A097_1398858241;
        // ---------- Original Method ----------
        //return EmptyArray.OBJECT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.922 -0400", hash_original_method = "490A2A0CCABF1E39472F82358B033503", hash_generated_method = "84D7A76F162F1E3F50F4408A8B9D5B39")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        if(a.length > 0)        
        a[0] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_368967572 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_368967572.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_368967572;
        // ---------- Original Method ----------
        //if (a.length > 0)
            //a[0] = null;
        //return a;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.923 -0400", hash_original_method = "B59D7BDF727183928F94F36988272CAC", hash_generated_method = "C9F975D522434E01B6119FE47BFEA50A")
    public int drainTo(Collection<? super E> c) {
        addTaint(c.getTaint());
        if(c == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1587681655 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1587681655.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1587681655;
        }
        if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1155843193 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1155843193.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1155843193;
        }
        int n = 0;
        E e;
        while
((e = poll()) != null)        
        {
            c.add(e);
            ++n;
        } //End block
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_2073652265 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098095942 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098095942;
        // ---------- Original Method ----------
        //if (c == null)
            //throw new NullPointerException();
        //if (c == this)
            //throw new IllegalArgumentException();
        //int n = 0;
        //E e;
        //while ( (e = poll()) != null) {
            //c.add(e);
            //++n;
        //}
        //return n;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.923 -0400", hash_original_method = "DA549833C1743125BAA2828712BD0C73", hash_generated_method = "3B4F7F5B77D51825EC380F9DDE2A8875")
    public int drainTo(Collection<? super E> c, int maxElements) {
        addTaint(maxElements);
        addTaint(c.getTaint());
        if(c == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_749464200 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_749464200.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_749464200;
        }
        if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1313972861 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1313972861.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1313972861;
        }
        int n = 0;
        E e;
        while
(n < maxElements && (e = poll()) != null)        
        {
            c.add(e);
            ++n;
        } //End block
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_1401183517 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096271704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096271704;
        // ---------- Original Method ----------
        //if (c == null)
            //throw new NullPointerException();
        //if (c == this)
            //throw new IllegalArgumentException();
        //int n = 0;
        //E e;
        //while (n < maxElements && (e = poll()) != null) {
            //c.add(e);
            //++n;
        //}
        //return n;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.924 -0400", hash_original_method = "7D89BB192BA936EC93EB72454855578A", hash_generated_method = "9179A06E3AA62ADBDECB4E97145D3048")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        addTaint(s.getTaint());
        boolean fair = transferer instanceof TransferQueue;
        if(fair)        
        {
            qlock = new ReentrantLock(true);
            waitingProducers = new FifoWaitQueue();
            waitingConsumers = new FifoWaitQueue();
        } //End block
        else
        {
            qlock = new ReentrantLock();
            waitingProducers = new LifoWaitQueue();
            waitingConsumers = new LifoWaitQueue();
        } //End block
        s.defaultWriteObject();
        // ---------- Original Method ----------
        //boolean fair = transferer instanceof TransferQueue;
        //if (fair) {
            //qlock = new ReentrantLock(true);
            //waitingProducers = new FifoWaitQueue();
            //waitingConsumers = new FifoWaitQueue();
        //}
        //else {
            //qlock = new ReentrantLock();
            //waitingProducers = new LifoWaitQueue();
            //waitingConsumers = new LifoWaitQueue();
        //}
        //s.defaultWriteObject();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.924 -0400", hash_original_method = "E156E82E550566200FEDBE52C0090F6F", hash_generated_method = "C7B18286A3A74F985F71E96B9CC7F16C")
    private void readObject(final java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        addTaint(s.getTaint());
        s.defaultReadObject();
        if(waitingProducers instanceof FifoWaitQueue)        
        transferer = new TransferQueue();
        else
        transferer = new TransferStack();
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //if (waitingProducers instanceof FifoWaitQueue)
            //transferer = new TransferQueue();
        //else
            //transferer = new TransferStack();
    }

    
    @DSModeled(DSC.SAFE)
    static long objectFieldOffset(sun.misc.Unsafe UNSAFE,
                                  String field, Class<?> klazz) {
        try {
            return UNSAFE.objectFieldOffset(klazz.getDeclaredField(field));
        } catch (NoSuchFieldException e) {
            NoSuchFieldError error = new NoSuchFieldError(field);
            error.initCause(e);
            throw error;
        }
    }

    
    abstract static class Transferer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.924 -0400", hash_original_method = "09F8B62CD164A65EFE70D215172CE3CA", hash_generated_method = "09F8B62CD164A65EFE70D215172CE3CA")
        public Transferer ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        abstract Object transfer(Object e, boolean timed, long nanos);

        
    }


    
    static final class TransferStack extends Transferer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.925 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "228454E0E0F7F2A4C4B0260AD101A4CF")

        volatile SNode head;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.925 -0400", hash_original_method = "02B0885CE62BE77F872535266EC48EF9", hash_generated_method = "02B0885CE62BE77F872535266EC48EF9")
        public TransferStack ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        static boolean isFulfilling(int m) {
            return (m & FULFILLING) != 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.925 -0400", hash_original_method = "F38594CD80446D46D4DC59D46118C84B", hash_generated_method = "73F43E39F0D8702CBA0ED57475C3DE19")
         boolean casHead(SNode h, SNode nh) {
            addTaint(nh.getTaint());
            addTaint(h.getTaint());
            boolean var2B2DB6A22E8F29217A138A728216100A_485458160 = (h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064674271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064674271;
            // ---------- Original Method ----------
            //return h == head &&
                //UNSAFE.compareAndSwapObject(this, headOffset, h, nh);
        }

        
        @DSModeled(DSC.SAFE)
        static SNode snode(SNode s, Object e, SNode next, int mode) {
            if (s == null) s = new SNode(e);
            s.mode = mode;
            s.next = next;
            return s;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.926 -0400", hash_original_method = "EF565BC8E8F2E2CD3218F549EBA67BF0", hash_generated_method = "07A71981ACB874AC858855FE97D029EE")
         Object transfer(Object e, boolean timed, long nanos) {
            addTaint(nanos);
            addTaint(timed);
            addTaint(e.getTaint());
            SNode s = null;
            int mode = (e == null) ? REQUEST : DATA;
for(;;)
            {
                SNode h = head;
                if(h == null || h.mode == mode)                
                {
                    if(timed && nanos <= 0)                    
                    {
                        if(h != null && h.isCancelled())                        
                        casHead(h, h.next);
                        else
                        {
Object var540C13E9E156B687226421B24F2DF178_1468516766 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1468516766.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1468516766;
                        }
                    } //End block
                    else
                    if(casHead(h, s = snode(s, e, h, mode)))                    
                    {
                        SNode m = awaitFulfill(s, timed, nanos);
                        if(m == s)                        
                        {
                            clean(s);
Object var540C13E9E156B687226421B24F2DF178_1255865115 =                             null;
                            var540C13E9E156B687226421B24F2DF178_1255865115.addTaint(taint);
                            return var540C13E9E156B687226421B24F2DF178_1255865115;
                        } //End block
                        if((h = head) != null && h.next == s)                        
                        casHead(h, s.next);
Object varEEDD4C596768D38C2DDEFF8C87BE1ABC_7687363 =                         (mode == REQUEST) ? m.item : s.item;
                        varEEDD4C596768D38C2DDEFF8C87BE1ABC_7687363.addTaint(taint);
                        return varEEDD4C596768D38C2DDEFF8C87BE1ABC_7687363;
                    } //End block
                } //End block
                else
                if(!isFulfilling(h.mode))                
                {
                    if(h.isCancelled())                    
                    casHead(h, h.next);
                    else
                    if(casHead(h, s=snode(s, e, h, FULFILLING|mode)))                    
                    {
for(;;)
                        {
                            SNode m = s.next;
                            if(m == null)                            
                            {
                                casHead(s, null);
                                s = null;
                                break;
                            } //End block
                            SNode mn = m.next;
                            if(m.tryMatch(s))                            
                            {
                                casHead(s, mn);
Object varEEDD4C596768D38C2DDEFF8C87BE1ABC_321000788 =                                 (mode == REQUEST) ? m.item : s.item;
                                varEEDD4C596768D38C2DDEFF8C87BE1ABC_321000788.addTaint(taint);
                                return varEEDD4C596768D38C2DDEFF8C87BE1ABC_321000788;
                            } //End block
                            else
                            s.casNext(m, mn);
                        } //End block
                    } //End block
                } //End block
                else
                {
                    SNode m = h.next;
                    if(m == null)                    
                    casHead(h, null);
                    else
                    {
                        SNode mn = m.next;
                        if(m.tryMatch(h))                        
                        casHead(h, mn);
                        else
                        h.casNext(m, mn);
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.927 -0400", hash_original_method = "8450123659E4F3E3FBDDF976A06B7608", hash_generated_method = "BC494BA182F8A0530F4EC713722D11FE")
         SNode awaitFulfill(SNode s, boolean timed, long nanos) {
            addTaint(nanos);
            addTaint(timed);
            addTaint(s.getTaint());
            long lastTime = timed ? System.nanoTime() : 0;
            Thread w = Thread.currentThread();
            SNode h = head;
            int spins = (shouldSpin(s) ?
                         (timed ? maxTimedSpins : maxUntimedSpins) : 0);
for(;;)
            {
                if(w.isInterrupted())                
                s.tryCancel();
                SNode m = s.match;
                if(m != null)                
                {
SNode varBD22C5ECD1F8BC3EE2416AF7A8014FD2_2146597565 =                 m;
                varBD22C5ECD1F8BC3EE2416AF7A8014FD2_2146597565.addTaint(taint);
                return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_2146597565;
                }
                if(timed)                
                {
                    long now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    if(nanos <= 0)                    
                    {
                        s.tryCancel();
                        continue;
                    } //End block
                } //End block
                if(spins > 0)                
                spins = shouldSpin(s) ? (spins-1) : 0;
                else
                if(s.waiter == null)                
                s.waiter = w;
                else
                if(!timed)                
                LockSupport.park(this);
                else
                if(nanos > spinForTimeoutThreshold)                
                LockSupport.parkNanos(this, nanos);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.927 -0400", hash_original_method = "C3C9887957CF791F525718002F2944FE", hash_generated_method = "A271D399CA4B43DDE8ADE2C50220A2D6")
         boolean shouldSpin(SNode s) {
            addTaint(s.getTaint());
            SNode h = head;
            boolean var3E723F79043311712EC59D9B0380F07A_1998918226 = ((h == s || h == null || isFulfilling(h.mode)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280268631 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280268631;
            // ---------- Original Method ----------
            //SNode h = head;
            //return (h == s || h == null || isFulfilling(h.mode));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.927 -0400", hash_original_method = "162514ED54A955A73353466B6689AF5B", hash_generated_method = "893EA4A31C5AC295AEEEAE42659C0BE5")
         void clean(SNode s) {
            addTaint(s.getTaint());
            s.item = null;
            s.waiter = null;
            SNode past = s.next;
            if(past != null && past.isCancelled())            
            past = past.next;
            SNode p;
            while
((p = head) != null && p != past && p.isCancelled())            
            casHead(p, p.next);
            while
(p != null && p != past)            
            {
                SNode n = p.next;
                if(n != null && n.isCancelled())                
                p.casNext(n, n.next);
                else
                p = n;
            } //End block
            // ---------- Original Method ----------
            //s.item = null;
            //s.waiter = null;
            //SNode past = s.next;
            //if (past != null && past.isCancelled())
                //past = past.next;
            //SNode p;
            //while ((p = head) != null && p != past && p.isCancelled())
                //casHead(p, p.next);
            //while (p != null && p != past) {
                //SNode n = p.next;
                //if (n != null && n.isCancelled())
                    //p.casNext(n, n.next);
                //else
                    //p = n;
            //}
        }

        
        static final class SNode {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.928 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "51B8757B53C140AD03FA5839D28E2835")

            volatile SNode next;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.928 -0400", hash_original_field = "E3CC92C14A5E6DD1A7D94B6FF634D7FC", hash_generated_field = "6CEC32C9039E66F4CB3AFBF850A69E68")

            volatile SNode match;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.928 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.928 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "CF812EE2AD9BC4EAA8B11FCCEDAE3ADB")

            Object item;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.928 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "462D02655D7DD7DF6E5BA12D65851DD2")

            int mode;
            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.928 -0400", hash_original_method = "1B0B8D11CB10F0B4CCAA4D8835EC421B", hash_generated_method = "CF1397AC3B88B93FEFBB222BFAAE5E40")
              SNode(Object item) {
                this.item = item;
                // ---------- Original Method ----------
                //this.item = item;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.928 -0400", hash_original_method = "265B3E666AD76F55078AE9E7E3AE351C", hash_generated_method = "D2CFA0F8C9F1537809F6A570DF463B38")
             boolean casNext(SNode cmp, SNode val) {
                addTaint(val.getTaint());
                addTaint(cmp.getTaint());
                boolean var053E222A2BFDF68AF75A7A6F751FBFED_736120498 = (cmp == next &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711012514 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711012514;
                // ---------- Original Method ----------
                //return cmp == next &&
                    //UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.928 -0400", hash_original_method = "CEB4EA3334013C3454101E56EFA00D65", hash_generated_method = "B5EF6A43AB11004EE3CFBAFC5F9E50D2")
             boolean tryMatch(SNode s) {
                addTaint(s.getTaint());
                if(match == null &&
                    UNSAFE.compareAndSwapObject(this, matchOffset, null, s))                
                {
                    Thread w = waiter;
                    if(w != null)                    
                    {
                        waiter = null;
                        LockSupport.unpark(w);
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_1976270708 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467673469 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467673469;
                } //End block
                boolean varBB8F4E7605B9DFB7896A89DE4C1C7DAD_61191826 = (match == s);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_187836809 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_187836809;
                // ---------- Original Method ----------
                //if (match == null &&
                    //UNSAFE.compareAndSwapObject(this, matchOffset, null, s)) {
                    //Thread w = waiter;
                    //if (w != null) {    
                        //waiter = null;
                        //LockSupport.unpark(w);
                    //}
                    //return true;
                //}
                //return match == s;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.928 -0400", hash_original_method = "4364F2F312C8CE7EEFC1A24A7BE396DF", hash_generated_method = "F113C1DDE10ED16910489434287E4197")
             void tryCancel() {
                UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
                // ---------- Original Method ----------
                //UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_method = "BB4CEE3409ECC1A047D42B262CFDD801", hash_generated_method = "CDC252811485B6FEBEDDC42A17300191")
             boolean isCancelled() {
                boolean var9CCE5538D36BACD81F22F88C53594710_74159541 = (match == this);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1949354584 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1949354584;
                // ---------- Original Method ----------
                //return match == this;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "8234D14DA629F1B33BC3BF468BFC1AAE", hash_generated_field = "0D8325461BECB64F10F564BE157F8175")

            private static final long nextOffset = objectFieldOffset(UNSAFE, "next", SNode.class);
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "CD74A71824B260054518EC8AEE7963D3", hash_generated_field = "B5BF3FE8CC1DDC4679FEA266AA5E519F")

            private static final long matchOffset = objectFieldOffset(UNSAFE, "match", SNode.class);
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "00901407DB520A6DA0C4ED8316299BA6", hash_generated_field = "1279CC9CFAD174B5AA85ADAB5A87C1B2")

        static final int REQUEST = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "76AD11A457B8D4D9AA18A779A31A8BFF", hash_generated_field = "839D78410482BFBBC8FD6F80E7B7399B")

        static final int DATA = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "5E06EC816761815F086BAFA71AC08DF4", hash_generated_field = "14F8F9AC365CBCC20FCF4F001AD6990B")

        static final int FULFILLING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "D060AADCA72F1E682132007013486754", hash_generated_field = "FDC74C8C46C70DC81257DAB123799A8D")

        private static final long headOffset = objectFieldOffset(UNSAFE, "head", TransferStack.class);
    }


    
    static final class TransferQueue extends Transferer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "8B563AA5A75BA53BC5C38CBCB00877BD")

        transient volatile QNode head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "28504BE4CF28FABF51A5115491756D5B")

        transient volatile QNode tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_field = "15D477186674E9EC651EC7D91C1367FE", hash_generated_field = "11DAC5D336C0CE8D6AABAA86A736FB77")

        transient volatile QNode cleanMe;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_method = "EBB3C2235277D03D49EE8D8BB02DD64A", hash_generated_method = "064390A0D5BEAB18E259D10581E7DE52")
          TransferQueue() {
            QNode h = new QNode(null, false);
            head = h;
            tail = h;
            // ---------- Original Method ----------
            //QNode h = new QNode(null, false);
            //head = h;
            //tail = h;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_method = "80B021B7B5DA5B6F1F69021D0C7D6F89", hash_generated_method = "3848825921A0C6EF2D287543CD489E8F")
         void advanceHead(QNode h, QNode nh) {
            addTaint(nh.getTaint());
            addTaint(h.getTaint());
            if(h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh))            
            h.next = h;
            // ---------- Original Method ----------
            //if (h == head &&
                //UNSAFE.compareAndSwapObject(this, headOffset, h, nh))
                //h.next = h;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.929 -0400", hash_original_method = "8E334B9D021C7CA1D4C0B314F9C4B69F", hash_generated_method = "42770E690901EA6FCDFCD111E808492A")
         void advanceTail(QNode t, QNode nt) {
            addTaint(nt.getTaint());
            addTaint(t.getTaint());
            if(tail == t)            
            UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
            // ---------- Original Method ----------
            //if (tail == t)
                //UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.930 -0400", hash_original_method = "7A9E3B63F4597B524322C45DD727A635", hash_generated_method = "44F71303F056C406D1E706BB70A160B3")
         boolean casCleanMe(QNode cmp, QNode val) {
            addTaint(val.getTaint());
            addTaint(cmp.getTaint());
            boolean var8C50B4331E1A233184E81FBD196A80A9_1175671816 = (cleanMe == cmp &&
                UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985440013 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_985440013;
            // ---------- Original Method ----------
            //return cleanMe == cmp &&
                //UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.931 -0400", hash_original_method = "D9295193CC3F280F47A7E51B4594CC44", hash_generated_method = "591071C859DFCED13010DA234BA7D679")
         Object transfer(Object e, boolean timed, long nanos) {
            addTaint(nanos);
            addTaint(timed);
            addTaint(e.getTaint());
            QNode s = null;
            boolean isData = (e != null);
for(;;)
            {
                QNode t = tail;
                QNode h = head;
                if(t == null || h == null)                
                continue;
                if(h == t || t.isData == isData)                
                {
                    QNode tn = t.next;
                    if(t != tail)                    
                    continue;
                    if(tn != null)                    
                    {
                        advanceTail(t, tn);
                        continue;
                    } //End block
                    if(timed && nanos <= 0)                    
                    {
Object var540C13E9E156B687226421B24F2DF178_423689488 =                     null;
                    var540C13E9E156B687226421B24F2DF178_423689488.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_423689488;
                    }
                    if(s == null)                    
                    s = new QNode(e, isData);
                    if(!t.casNext(null, s))                    
                    continue;
                    advanceTail(t, s);
                    Object x = awaitFulfill(s, e, timed, nanos);
                    if(x == s)                    
                    {
                        clean(t, s);
Object var540C13E9E156B687226421B24F2DF178_1613049797 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1613049797.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1613049797;
                    } //End block
                    if(!s.isOffList())                    
                    {
                        advanceHead(t, s);
                        if(x != null)                        
                        s.item = s;
                        s.waiter = null;
                    } //End block
Object var334CF9D5F70A003E4B00529C4159C965_1095533103 =                     (x != null) ? x : e;
                    var334CF9D5F70A003E4B00529C4159C965_1095533103.addTaint(taint);
                    return var334CF9D5F70A003E4B00529C4159C965_1095533103;
                } //End block
                else
                {
                    QNode m = h.next;
                    if(t != tail || m == null || h != head)                    
                    continue;
                    Object x = m.item;
                    if(isData == (x != null) ||    
                        x == m ||                   
                        !m.casItem(x, e))                    
                    {
                        advanceHead(h, m);
                        continue;
                    } //End block
                    advanceHead(h, m);
                    LockSupport.unpark(m.waiter);
Object var334CF9D5F70A003E4B00529C4159C965_1402887081 =                     (x != null) ? x : e;
                    var334CF9D5F70A003E4B00529C4159C965_1402887081.addTaint(taint);
                    return var334CF9D5F70A003E4B00529C4159C965_1402887081;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.931 -0400", hash_original_method = "90C8A09C09ECF2EF83975D209FFEEF37", hash_generated_method = "FA6D1BD6CF63AE95BE3A64F48BB8D75E")
         Object awaitFulfill(QNode s, Object e, boolean timed, long nanos) {
            addTaint(nanos);
            addTaint(timed);
            addTaint(e.getTaint());
            addTaint(s.getTaint());
            long lastTime = timed ? System.nanoTime() : 0;
            Thread w = Thread.currentThread();
            int spins = ((head.next == s) ?
                         (timed ? maxTimedSpins : maxUntimedSpins) : 0);
for(;;)
            {
                if(w.isInterrupted())                
                s.tryCancel(e);
                Object x = s.item;
                if(x != e)                
                {
Object varEA5659DA512DECF23E6D37EE8060D074_1689403648 =                 x;
                varEA5659DA512DECF23E6D37EE8060D074_1689403648.addTaint(taint);
                return varEA5659DA512DECF23E6D37EE8060D074_1689403648;
                }
                if(timed)                
                {
                    long now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    if(nanos <= 0)                    
                    {
                        s.tryCancel(e);
                        continue;
                    } //End block
                } //End block
                if(spins > 0)                
                --spins;
                else
                if(s.waiter == null)                
                s.waiter = w;
                else
                if(!timed)                
                LockSupport.park(this);
                else
                if(nanos > spinForTimeoutThreshold)                
                LockSupport.parkNanos(this, nanos);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.933 -0400", hash_original_method = "6683A876B1B30ADB5D756618BABF762A", hash_generated_method = "9CB6726E913BE84BE197504A381D5A79")
         void clean(QNode pred, QNode s) {
            addTaint(s.getTaint());
            addTaint(pred.getTaint());
            s.waiter = null;
            while
(pred.next == s)            
            {
                QNode h = head;
                QNode hn = h.next;
                if(hn != null && hn.isCancelled())                
                {
                    advanceHead(h, hn);
                    continue;
                } //End block
                QNode t = tail;
                if(t == h)                
                return;
                QNode tn = t.next;
                if(t != tail)                
                continue;
                if(tn != null)                
                {
                    advanceTail(t, tn);
                    continue;
                } //End block
                if(s != t)                
                {
                    QNode sn = s.next;
                    if(sn == s || pred.casNext(s, sn))                    
                    return;
                } //End block
                QNode dp = cleanMe;
                if(dp != null)                
                {
                    QNode d = dp.next;
                    QNode dn;
                    if(d == null ||               
                        d == dp ||                 
                        !d.isCancelled() ||        
                        (d != t &&                 
                         (dn = d.next) != null &&  
                         dn != d &&                
                         dp.casNext(d, dn)))                    
                    casCleanMe(dp, null);
                    if(dp == pred)                    
                    return;
                } //End block
                else
                if(casCleanMe(null, pred))                
                return;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        static final class QNode {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.933 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "98C54C1386619AED777FF36204F4724D")

            volatile QNode next;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.933 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "572C92874AD4D49E8D97420DECC4EA3C")

            volatile Object item;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.933 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.933 -0400", hash_original_field = "CC995F2BD435828CA793B1399F0CD031", hash_generated_field = "13998CD9DB54AD99E9DAFA28EE2691E9")

            boolean isData;
            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.934 -0400", hash_original_method = "36E0BDE690B9319BBAE39AE7BB5AED99", hash_generated_method = "AC79B184894CD3D93DB04113A86F071F")
              QNode(Object item, boolean isData) {
                this.item = item;
                this.isData = isData;
                // ---------- Original Method ----------
                //this.item = item;
                //this.isData = isData;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.934 -0400", hash_original_method = "611C5C34CB4DC255784715588EF3B5E5", hash_generated_method = "06120D3444C5AB69BEB9690F214F9D3D")
             boolean casNext(QNode cmp, QNode val) {
                addTaint(val.getTaint());
                addTaint(cmp.getTaint());
                boolean varE67D3F7CF362D5D7A8CA55C00C215529_1432600625 = (next == cmp &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1086292066 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1086292066;
                // ---------- Original Method ----------
                //return next == cmp &&
                    //UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_method = "3912AD02565B809FB80AB4089D0BD0C1", hash_generated_method = "84BDA31E278228802F1D2FA13F460FDD")
             boolean casItem(Object cmp, Object val) {
                addTaint(val.getTaint());
                addTaint(cmp.getTaint());
                boolean var6D5AC0F4108DD88507274D115F66C1A1_157118854 = (item == cmp &&
                    UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_390409749 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_390409749;
                // ---------- Original Method ----------
                //return item == cmp &&
                    //UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_method = "99C72522BA0C395099FBEE5F0489DB78", hash_generated_method = "78DB00E49750243FBA8528681AB076FE")
             void tryCancel(Object cmp) {
                addTaint(cmp.getTaint());
                UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
                // ---------- Original Method ----------
                //UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_method = "45E5A9573D9BA1D0D86064CD1643198D", hash_generated_method = "9EFF373A3612050BE80BB7E7F643F1D9")
             boolean isCancelled() {
                boolean var730C6CF98606BAC00E4F117050948649_74679011 = (item == this);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1969086527 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1969086527;
                // ---------- Original Method ----------
                //return item == this;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_method = "355DAB50A3ED00DA4B9C20D2E0EF6792", hash_generated_method = "4BB746B60C894AD9B4A3DB3696AAF9F8")
             boolean isOffList() {
                boolean var6517D1C45D1487DACC40419674397359_1976994999 = (next == this);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742605189 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_742605189;
                // ---------- Original Method ----------
                //return next == this;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_field = "8A1148CE2B27855448692F0F42095BC9", hash_generated_field = "969A31B3082BB4CF0103955413A3CC24")

            private static final long nextOffset = objectFieldOffset(UNSAFE, "next", QNode.class);
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_field = "699D04D68ED73F0F2E1CD32D8C6F109A", hash_generated_field = "C54E8DCAC9CD5157F2D50242395059D2")

            private static final long itemOffset = objectFieldOffset(UNSAFE, "item", QNode.class);
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_field = "70027F0D0522D2B8178D239E338F6B3B", hash_generated_field = "718DCD1B9965F259ECF13AAC3FDE17B9")

        private static final long headOffset = objectFieldOffset(UNSAFE, "head", TransferQueue.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_field = "FAC26A70E3A7365830A659E724196AC7", hash_generated_field = "125A3490D6DDA910E4EFF8F5BD5EA3A6")

        private static final long tailOffset = objectFieldOffset(UNSAFE, "tail", TransferQueue.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.935 -0400", hash_original_field = "1259B870E41DF8C457DF64A6F063E913", hash_generated_field = "B8C9CACD31C6DFF4CCC160BE1AA5E90A")

        private static final long cleanMeOffset = objectFieldOffset(UNSAFE, "cleanMe", TransferQueue.class);
    }


    
    static class WaitQueue implements java.io.Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_method = "A66BE88BE66C40BD12237E932077BBFA", hash_generated_method = "A66BE88BE66C40BD12237E932077BBFA")
        public WaitQueue ()
        {
            //Synthesized constructor
        }


    }


    
    static class LifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_method = "2AB7A8E9C876B74C36AEA136750E93EA", hash_generated_method = "2AB7A8E9C876B74C36AEA136750E93EA")
        public LifoWaitQueue ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_field = "538748F7DEB6C55C97A19BE3C95E9A81", hash_generated_field = "80F144D9FAF7455012BBD899F5164ED8")

        private static final long serialVersionUID = -3633113410248163686L;
    }


    
    static class FifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_method = "2B3543573D85E46D74937DE2E36C8335", hash_generated_method = "2B3543573D85E46D74937DE2E36C8335")
        public FifoWaitQueue ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_field = "9697A0ABD2AF5BBA3DD90C1E1CD4F6C6", hash_generated_field = "736A1D17D87D413A39676344D90E22F2")

        private static final long serialVersionUID = -3623113410248163686L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_field = "4CA9EACFC32D88A9A4CD6E0A1BDAB9E4", hash_generated_field = "1E3367DE63E4A43E00AB1E404902880B")

    private static final long serialVersionUID = -3223113410248163686L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_field = "9D5D4F5356672663FE82C5BD31BC60BF", hash_generated_field = "EB1423FF544459B29A17FADE8C5125D9")

    static final int NCPUS = Runtime.getRuntime().availableProcessors();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_field = "B5216FBF1314B0080661A4EF51C6B5C7", hash_generated_field = "EFDB8C9AF5E428D3578BEE68452C22B2")

    static final int maxTimedSpins = (NCPUS < 2) ? 0 : 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_field = "5B48E17B478EADCDB689A1C63CCA9BAC", hash_generated_field = "616785537C813125BAC1A7A01A65BE67")

    static final int maxUntimedSpins = maxTimedSpins * 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.936 -0400", hash_original_field = "97826F3E2403B559BA27663CADCEE60A", hash_generated_field = "BFF11A71C399B3DB146FF1C739630A1D")

    static final long spinForTimeoutThreshold = 1000L;
}

