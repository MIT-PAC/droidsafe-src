package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.locks.*;
import java.util.*;
import libcore.util.EmptyArray;

public class SynchronousQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.448 -0400", hash_original_field = "14FF183E0CBF22E7DBE09157245ED2D4", hash_generated_field = "93A6B6C7FD7700420692EFD74AC915AE")

    private transient volatile Transferer transferer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.448 -0400", hash_original_field = "18B069DB69ED982634500077B1439F32", hash_generated_field = "E2A217843A6D418FDE83E1DD89178FFA")

    private ReentrantLock qlock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.449 -0400", hash_original_field = "882C5ACA03261179CC74C2C00EFBE286", hash_generated_field = "9EC2490AD04FFD57826C64D62CD6D006")

    private WaitQueue waitingProducers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.449 -0400", hash_original_field = "AF8EC88A663239AB823F4C324266FE94", hash_generated_field = "4EC4B53B46775F740D025ADAAB977973")

    private WaitQueue waitingConsumers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.449 -0400", hash_original_method = "CA3CB3D951221FCCF0DFF3BB5DF12346", hash_generated_method = "5255A939CCFA97D45156B8A4109C3AE2")
    public  SynchronousQueue() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.450 -0400", hash_original_method = "2A4F416DA0F8363F009FD8DA8EB74A84", hash_generated_method = "E36170E9580D212BFA99521F1CF0C67D")
    public  SynchronousQueue(boolean fair) {
        transferer = fair ? new TransferQueue() : new TransferStack();
        // ---------- Original Method ----------
        //transferer = fair ? new TransferQueue() : new TransferStack();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.450 -0400", hash_original_method = "C65E97EC40BB31D50DB029B0D4F47DF5", hash_generated_method = "2BB7A26002876812C0F898BFBA9D161E")
    public void put(E o) throws InterruptedException {
        addTaint(o.getTaint());
    if(o == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_897598625 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_897598625.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_897598625;
        }
    if(transferer.transfer(o, false, 0) == null)        
        {
            Thread.interrupted();
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_776778399 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_776778399.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_776778399;
        } //End block
        // ---------- Original Method ----------
        //if (o == null) throw new NullPointerException();
        //if (transferer.transfer(o, false, 0) == null) {
            //Thread.interrupted();
            //throw new InterruptedException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.451 -0400", hash_original_method = "3A6AFFAA000C17EA73FBC10B0EC018FD", hash_generated_method = "8E589C71111F9DEAD9D8A62194D3AE14")
    public boolean offer(E o, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(o.getTaint());
    if(o == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2073690171 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_2073690171.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_2073690171;
        }
    if(transferer.transfer(o, true, unit.toNanos(timeout)) != null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_159876117 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101152280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_101152280;
        }
    if(!Thread.interrupted())        
        {
        boolean var68934A3E9455FA72420237EB05902327_24329846 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885640627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_885640627;
        }
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_1120034963 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_1120034963.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_1120034963;
        // ---------- Original Method ----------
        //if (o == null) throw new NullPointerException();
        //if (transferer.transfer(o, true, unit.toNanos(timeout)) != null)
            //return true;
        //if (!Thread.interrupted())
            //return false;
        //throw new InterruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.452 -0400", hash_original_method = "A4F84C12941B1214559E662FB5D2360B", hash_generated_method = "DC7021B7B8E97D00FBA0C7F90B155099")
    public boolean offer(E e) {
        addTaint(e.getTaint());
    if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_126044528 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_126044528.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_126044528;
        }
        boolean var5C7FCA9FF17A7FA2A3B2DEDAF80D2328_1359644758 = (transferer.transfer(e, true, 0) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064468649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064468649;
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //return transferer.transfer(e, true, 0) != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.452 -0400", hash_original_method = "A59182A477060C80E9C0D7B7DD2CA2C3", hash_generated_method = "769E0C0735BBB5E9DBB9FF9318386402")
    public E take() throws InterruptedException {
        Object e = transferer.transfer(null, false, 0);
    if(e != null)        
        {
E var3BC4883C21B65D53A2DE2E8A607F7309_83524711 =         (E)e;
        var3BC4883C21B65D53A2DE2E8A607F7309_83524711.addTaint(taint);
        return var3BC4883C21B65D53A2DE2E8A607F7309_83524711;
        }
        Thread.interrupted();
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_321915548 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_321915548.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_321915548;
        // ---------- Original Method ----------
        //Object e = transferer.transfer(null, false, 0);
        //if (e != null)
            //return (E)e;
        //Thread.interrupted();
        //throw new InterruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.453 -0400", hash_original_method = "F80BFD27E2D553DA44FF7C91997050D6", hash_generated_method = "C31B626C7F33417802870A284FFC4EDE")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        Object e = transferer.transfer(null, true, unit.toNanos(timeout));
    if(e != null || !Thread.interrupted())        
        {
E var3BC4883C21B65D53A2DE2E8A607F7309_780773213 =         (E)e;
        var3BC4883C21B65D53A2DE2E8A607F7309_780773213.addTaint(taint);
        return var3BC4883C21B65D53A2DE2E8A607F7309_780773213;
        }
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_1390935611 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_1390935611.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_1390935611;
        // ---------- Original Method ----------
        //Object e = transferer.transfer(null, true, unit.toNanos(timeout));
        //if (e != null || !Thread.interrupted())
            //return (E)e;
        //throw new InterruptedException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.453 -0400", hash_original_method = "1663F66628103F625AD11623448BFB1D", hash_generated_method = "7DBA4A03D3A19885EFD9BBA1BEC0D43C")
    public E poll() {
E varC4A3844E08F9AAE23566F5DB59A78299_1055254722 =         (E)transferer.transfer(null, true, 0);
        varC4A3844E08F9AAE23566F5DB59A78299_1055254722.addTaint(taint);
        return varC4A3844E08F9AAE23566F5DB59A78299_1055254722;
        // ---------- Original Method ----------
        //return (E)transferer.transfer(null, true, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.453 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "52764D472DEBE7647B42B1DC13CA18B9")
    public boolean isEmpty() {
        boolean varB326B5062B2F0E69046810717534CB09_649229194 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073913631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073913631;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.454 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "F41A1981F8B9669C0807CDE8C1722F68")
    public int size() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1983518420 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522791739 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522791739;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.454 -0400", hash_original_method = "859254362B8CFD4ECD77710B77AC10ED", hash_generated_method = "5EEF5E45D82474DA17DC2CC741E0341A")
    public int remainingCapacity() {
        int varCFCD208495D565EF66E7DFF9F98764DA_453332601 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824809523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1824809523;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.454 -0400", hash_original_method = "CAFED8DEE3108243325B67F5797719ED", hash_generated_method = "62E208A158681C1F982FD616252404DD")
    public void clear() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.454 -0400", hash_original_method = "133415712E6841A0903588DC5D4862AA", hash_generated_method = "66990764C906FC0BC1DE9C6B6E0D54B7")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_766777920 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047268970 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047268970;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.455 -0400", hash_original_method = "6081257F3AE1D633C77BCA63D6F77CB7", hash_generated_method = "D3C4FCB630FBEAD53231A9A89890C828")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_2029554491 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189151780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189151780;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.455 -0400", hash_original_method = "C503BED5AF377C63A87B0C398CACB95B", hash_generated_method = "D01A3C11F52A4CE8547014E5A550DB1C")
    public boolean containsAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var65FAF5A74582A5D73E221DB675503595_1958144510 = (c.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1964556818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1964556818;
        // ---------- Original Method ----------
        //return c.isEmpty();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.456 -0400", hash_original_method = "EC0A570B588D76D8968190A1BD3D4040", hash_generated_method = "58FEE7CE5DA1EB8B0ECE2390845F7657")
    public boolean removeAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_2127596725 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693429785 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693429785;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.456 -0400", hash_original_method = "13D5AD766AE77320C3CF56AB2E9E5FB4", hash_generated_method = "10FBBF3B5479852F2FE48737A72E0083")
    public boolean retainAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_376053861 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822969119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822969119;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.457 -0400", hash_original_method = "2DC914F9B3C538818482710C9EAD9EFB", hash_generated_method = "6CE63402CCD7ACA5985C63056DB43D9D")
    public E peek() {
E var540C13E9E156B687226421B24F2DF178_1299470548 =         null;
        var540C13E9E156B687226421B24F2DF178_1299470548.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1299470548;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.457 -0400", hash_original_method = "0BB2C5BB97AA1323E2FE15E87216E7E9", hash_generated_method = "33F97B982F45C36CA958712D29387678")
    public Iterator<E> iterator() {
Iterator<E> var5522EE06486778A0917B370AA7495851_1896111404 =         Collections.<E>emptySet().iterator();
        var5522EE06486778A0917B370AA7495851_1896111404.addTaint(taint);
        return var5522EE06486778A0917B370AA7495851_1896111404;
        // ---------- Original Method ----------
        //return Collections.<E>emptySet().iterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.458 -0400", hash_original_method = "AAA5D1CBE91ADDEA174F65821E23BE58", hash_generated_method = "44734175B042886C806556FE55317AFC")
    public Object[] toArray() {
Object[] var3CDAC8E1894CA4B3B37667162540A097_1233791280 =         EmptyArray.OBJECT;
        var3CDAC8E1894CA4B3B37667162540A097_1233791280.addTaint(taint);
        return var3CDAC8E1894CA4B3B37667162540A097_1233791280;
        // ---------- Original Method ----------
        //return EmptyArray.OBJECT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.458 -0400", hash_original_method = "490A2A0CCABF1E39472F82358B033503", hash_generated_method = "810A696D4633CB19ED626B0FF7BBDBFB")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
    if(a.length > 0)        
        a[0] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_451630112 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_451630112.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_451630112;
        // ---------- Original Method ----------
        //if (a.length > 0)
            //a[0] = null;
        //return a;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.459 -0400", hash_original_method = "B59D7BDF727183928F94F36988272CAC", hash_generated_method = "9D768E30C30775AFDE81ED682E9DF0D5")
    public int drainTo(Collection<? super E> c) {
        addTaint(c.getTaint());
    if(c == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_720716805 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_720716805.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_720716805;
        }
    if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_361748426 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_361748426.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_361748426;
        }
        int n = 0;
        E e;
        while
((e = poll()) != null)        
        {
            c.add(e);
            ++n;
        } //End block
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_780152610 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1683607154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1683607154;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.459 -0400", hash_original_method = "DA549833C1743125BAA2828712BD0C73", hash_generated_method = "20B1B5918729D8699D8DEE01FAEEAD9F")
    public int drainTo(Collection<? super E> c, int maxElements) {
        addTaint(maxElements);
        addTaint(c.getTaint());
    if(c == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_532062339 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_532062339.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_532062339;
        }
    if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1127757554 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1127757554.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1127757554;
        }
        int n = 0;
        E e;
        while
(n < maxElements && (e = poll()) != null)        
        {
            c.add(e);
            ++n;
        } //End block
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_1035432530 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_278724948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_278724948;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.461 -0400", hash_original_method = "7D89BB192BA936EC93EB72454855578A", hash_generated_method = "9179A06E3AA62ADBDECB4E97145D3048")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.461 -0400", hash_original_method = "E156E82E550566200FEDBE52C0090F6F", hash_generated_method = "C7B18286A3A74F985F71E96B9CC7F16C")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.462 -0400", hash_original_method = "09F8B62CD164A65EFE70D215172CE3CA", hash_generated_method = "09F8B62CD164A65EFE70D215172CE3CA")
        public Transferer ()
        {
            //Synthesized constructor
        }


        abstract Object transfer(Object e, boolean timed, long nanos);

        
    }


    
    static final class TransferStack extends Transferer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.462 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "228454E0E0F7F2A4C4B0260AD101A4CF")

        volatile SNode head;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.462 -0400", hash_original_method = "02B0885CE62BE77F872535266EC48EF9", hash_generated_method = "02B0885CE62BE77F872535266EC48EF9")
        public TransferStack ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
        static boolean isFulfilling(int m) {
            return (m & FULFILLING) != 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.463 -0400", hash_original_method = "F38594CD80446D46D4DC59D46118C84B", hash_generated_method = "20A1A8DEE0237DB91E63AA95A4E0AF40")
         boolean casHead(SNode h, SNode nh) {
            addTaint(nh.getTaint());
            addTaint(h.getTaint());
            boolean var2B2DB6A22E8F29217A138A728216100A_1792174496 = (h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1099328988 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1099328988;
            // ---------- Original Method ----------
            //return h == head &&
                //UNSAFE.compareAndSwapObject(this, headOffset, h, nh);
        }

        
                static SNode snode(SNode s, Object e, SNode next, int mode) {
            if (s == null) s = new SNode(e);
            s.mode = mode;
            s.next = next;
            return s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.464 -0400", hash_original_method = "EF565BC8E8F2E2CD3218F549EBA67BF0", hash_generated_method = "7E7AA9173724E2B473FE9213557A693E")
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
Object var540C13E9E156B687226421B24F2DF178_929210633 =                         null;
                        var540C13E9E156B687226421B24F2DF178_929210633.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_929210633;
                        }
                    } //End block
                    else
    if(casHead(h, s = snode(s, e, h, mode)))                    
                    {
                        SNode m = awaitFulfill(s, timed, nanos);
    if(m == s)                        
                        {
                            clean(s);
Object var540C13E9E156B687226421B24F2DF178_1192721880 =                             null;
                            var540C13E9E156B687226421B24F2DF178_1192721880.addTaint(taint);
                            return var540C13E9E156B687226421B24F2DF178_1192721880;
                        } //End block
    if((h = head) != null && h.next == s)                        
                        casHead(h, s.next);
Object varEEDD4C596768D38C2DDEFF8C87BE1ABC_941952940 =                         (mode == REQUEST) ? m.item : s.item;
                        varEEDD4C596768D38C2DDEFF8C87BE1ABC_941952940.addTaint(taint);
                        return varEEDD4C596768D38C2DDEFF8C87BE1ABC_941952940;
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
Object varEEDD4C596768D38C2DDEFF8C87BE1ABC_1562068925 =                                 (mode == REQUEST) ? m.item : s.item;
                                varEEDD4C596768D38C2DDEFF8C87BE1ABC_1562068925.addTaint(taint);
                                return varEEDD4C596768D38C2DDEFF8C87BE1ABC_1562068925;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.466 -0400", hash_original_method = "8450123659E4F3E3FBDDF976A06B7608", hash_generated_method = "1952A3260C1170EB0BC83B40B63842EE")
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
SNode varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1264808286 =                 m;
                varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1264808286.addTaint(taint);
                return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1264808286;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.467 -0400", hash_original_method = "C3C9887957CF791F525718002F2944FE", hash_generated_method = "308E499D42A196FCCA0A1FBC587AF7C5")
         boolean shouldSpin(SNode s) {
            addTaint(s.getTaint());
            SNode h = head;
            boolean var3E723F79043311712EC59D9B0380F07A_1579395902 = ((h == s || h == null || isFulfilling(h.mode)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_317811016 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_317811016;
            // ---------- Original Method ----------
            //SNode h = head;
            //return (h == s || h == null || isFulfilling(h.mode));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.468 -0400", hash_original_method = "162514ED54A955A73353466B6689AF5B", hash_generated_method = "893EA4A31C5AC295AEEEAE42659C0BE5")
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.468 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "51B8757B53C140AD03FA5839D28E2835")

            volatile SNode next;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.468 -0400", hash_original_field = "E3CC92C14A5E6DD1A7D94B6FF634D7FC", hash_generated_field = "6CEC32C9039E66F4CB3AFBF850A69E68")

            volatile SNode match;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.468 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.468 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "CF812EE2AD9BC4EAA8B11FCCEDAE3ADB")

            Object item;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.469 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "462D02655D7DD7DF6E5BA12D65851DD2")

            int mode;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.469 -0400", hash_original_method = "1B0B8D11CB10F0B4CCAA4D8835EC421B", hash_generated_method = "CF1397AC3B88B93FEFBB222BFAAE5E40")
              SNode(Object item) {
                this.item = item;
                // ---------- Original Method ----------
                //this.item = item;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.469 -0400", hash_original_method = "265B3E666AD76F55078AE9E7E3AE351C", hash_generated_method = "977F09F1CB5789A4708442518994DDA5")
             boolean casNext(SNode cmp, SNode val) {
                addTaint(val.getTaint());
                addTaint(cmp.getTaint());
                boolean var053E222A2BFDF68AF75A7A6F751FBFED_735439230 = (cmp == next &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_841316853 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_841316853;
                // ---------- Original Method ----------
                //return cmp == next &&
                    //UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.470 -0400", hash_original_method = "CEB4EA3334013C3454101E56EFA00D65", hash_generated_method = "86E03D43BCD31DE2F725DBFF55AB5D46")
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
                    boolean varB326B5062B2F0E69046810717534CB09_1003801823 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355976866 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_355976866;
                } //End block
                boolean varBB8F4E7605B9DFB7896A89DE4C1C7DAD_721121671 = (match == s);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386663559 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386663559;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.470 -0400", hash_original_method = "4364F2F312C8CE7EEFC1A24A7BE396DF", hash_generated_method = "F113C1DDE10ED16910489434287E4197")
             void tryCancel() {
                UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
                // ---------- Original Method ----------
                //UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.471 -0400", hash_original_method = "BB4CEE3409ECC1A047D42B262CFDD801", hash_generated_method = "E2F3F59F3C5D8E3822C10A0E88A3B372")
             boolean isCancelled() {
                boolean var9CCE5538D36BACD81F22F88C53594710_1981141936 = (match == this);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_455161010 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_455161010;
                // ---------- Original Method ----------
                //return match == this;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.471 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.471 -0400", hash_original_field = "8234D14DA629F1B33BC3BF468BFC1AAE", hash_generated_field = "0D8325461BECB64F10F564BE157F8175")

            private static final long nextOffset = objectFieldOffset(UNSAFE, "next", SNode.class);
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.471 -0400", hash_original_field = "CD74A71824B260054518EC8AEE7963D3", hash_generated_field = "B5BF3FE8CC1DDC4679FEA266AA5E519F")

            private static final long matchOffset = objectFieldOffset(UNSAFE, "match", SNode.class);
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.471 -0400", hash_original_field = "00901407DB520A6DA0C4ED8316299BA6", hash_generated_field = "1279CC9CFAD174B5AA85ADAB5A87C1B2")

        static final int REQUEST = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.471 -0400", hash_original_field = "76AD11A457B8D4D9AA18A779A31A8BFF", hash_generated_field = "839D78410482BFBBC8FD6F80E7B7399B")

        static final int DATA = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.471 -0400", hash_original_field = "5E06EC816761815F086BAFA71AC08DF4", hash_generated_field = "14F8F9AC365CBCC20FCF4F001AD6990B")

        static final int FULFILLING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.471 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.471 -0400", hash_original_field = "D060AADCA72F1E682132007013486754", hash_generated_field = "FDC74C8C46C70DC81257DAB123799A8D")

        private static final long headOffset = objectFieldOffset(UNSAFE, "head", TransferStack.class);
    }


    
    static final class TransferQueue extends Transferer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.472 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "8B563AA5A75BA53BC5C38CBCB00877BD")

        transient volatile QNode head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.472 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "28504BE4CF28FABF51A5115491756D5B")

        transient volatile QNode tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.472 -0400", hash_original_field = "15D477186674E9EC651EC7D91C1367FE", hash_generated_field = "11DAC5D336C0CE8D6AABAA86A736FB77")

        transient volatile QNode cleanMe;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.472 -0400", hash_original_method = "EBB3C2235277D03D49EE8D8BB02DD64A", hash_generated_method = "064390A0D5BEAB18E259D10581E7DE52")
          TransferQueue() {
            QNode h = new QNode(null, false);
            head = h;
            tail = h;
            // ---------- Original Method ----------
            //QNode h = new QNode(null, false);
            //head = h;
            //tail = h;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.473 -0400", hash_original_method = "80B021B7B5DA5B6F1F69021D0C7D6F89", hash_generated_method = "3848825921A0C6EF2D287543CD489E8F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.473 -0400", hash_original_method = "8E334B9D021C7CA1D4C0B314F9C4B69F", hash_generated_method = "42770E690901EA6FCDFCD111E808492A")
         void advanceTail(QNode t, QNode nt) {
            addTaint(nt.getTaint());
            addTaint(t.getTaint());
    if(tail == t)            
            UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
            // ---------- Original Method ----------
            //if (tail == t)
                //UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.474 -0400", hash_original_method = "7A9E3B63F4597B524322C45DD727A635", hash_generated_method = "051D05CD982B5E536D5D8CCA4F2E6E68")
         boolean casCleanMe(QNode cmp, QNode val) {
            addTaint(val.getTaint());
            addTaint(cmp.getTaint());
            boolean var8C50B4331E1A233184E81FBD196A80A9_95695364 = (cleanMe == cmp &&
                UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292703347 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_292703347;
            // ---------- Original Method ----------
            //return cleanMe == cmp &&
                //UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.475 -0400", hash_original_method = "D9295193CC3F280F47A7E51B4594CC44", hash_generated_method = "906F123AC25181B901CDFF6114257421")
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
Object var540C13E9E156B687226421B24F2DF178_826352200 =                     null;
                    var540C13E9E156B687226421B24F2DF178_826352200.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_826352200;
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
Object var540C13E9E156B687226421B24F2DF178_1073205137 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1073205137.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1073205137;
                    } //End block
    if(!s.isOffList())                    
                    {
                        advanceHead(t, s);
    if(x != null)                        
                        s.item = s;
                        s.waiter = null;
                    } //End block
Object var334CF9D5F70A003E4B00529C4159C965_1660003989 =                     (x != null) ? x : e;
                    var334CF9D5F70A003E4B00529C4159C965_1660003989.addTaint(taint);
                    return var334CF9D5F70A003E4B00529C4159C965_1660003989;
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
Object var334CF9D5F70A003E4B00529C4159C965_1584119018 =                     (x != null) ? x : e;
                    var334CF9D5F70A003E4B00529C4159C965_1584119018.addTaint(taint);
                    return var334CF9D5F70A003E4B00529C4159C965_1584119018;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.476 -0400", hash_original_method = "90C8A09C09ECF2EF83975D209FFEEF37", hash_generated_method = "1602A76FAE7E5BEDE43512FC1D10938D")
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
Object varEA5659DA512DECF23E6D37EE8060D074_1195284597 =                 x;
                varEA5659DA512DECF23E6D37EE8060D074_1195284597.addTaint(taint);
                return varEA5659DA512DECF23E6D37EE8060D074_1195284597;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.478 -0400", hash_original_method = "6683A876B1B30ADB5D756618BABF762A", hash_generated_method = "9CB6726E913BE84BE197504A381D5A79")
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.478 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "98C54C1386619AED777FF36204F4724D")

            volatile QNode next;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.478 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "572C92874AD4D49E8D97420DECC4EA3C")

            volatile Object item;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.478 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.479 -0400", hash_original_field = "CC995F2BD435828CA793B1399F0CD031", hash_generated_field = "13998CD9DB54AD99E9DAFA28EE2691E9")

            boolean isData;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.479 -0400", hash_original_method = "36E0BDE690B9319BBAE39AE7BB5AED99", hash_generated_method = "AC79B184894CD3D93DB04113A86F071F")
              QNode(Object item, boolean isData) {
                this.item = item;
                this.isData = isData;
                // ---------- Original Method ----------
                //this.item = item;
                //this.isData = isData;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.479 -0400", hash_original_method = "611C5C34CB4DC255784715588EF3B5E5", hash_generated_method = "ACFD1884B21FB99ABE51D6A95E0B083A")
             boolean casNext(QNode cmp, QNode val) {
                addTaint(val.getTaint());
                addTaint(cmp.getTaint());
                boolean varE67D3F7CF362D5D7A8CA55C00C215529_1313240691 = (next == cmp &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258915902 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258915902;
                // ---------- Original Method ----------
                //return next == cmp &&
                    //UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.480 -0400", hash_original_method = "3912AD02565B809FB80AB4089D0BD0C1", hash_generated_method = "2A380D7A3E54EED349DCE33921B1DAC2")
             boolean casItem(Object cmp, Object val) {
                addTaint(val.getTaint());
                addTaint(cmp.getTaint());
                boolean var6D5AC0F4108DD88507274D115F66C1A1_190794365 = (item == cmp &&
                    UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731984087 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731984087;
                // ---------- Original Method ----------
                //return item == cmp &&
                    //UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.480 -0400", hash_original_method = "99C72522BA0C395099FBEE5F0489DB78", hash_generated_method = "78DB00E49750243FBA8528681AB076FE")
             void tryCancel(Object cmp) {
                addTaint(cmp.getTaint());
                UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
                // ---------- Original Method ----------
                //UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.481 -0400", hash_original_method = "45E5A9573D9BA1D0D86064CD1643198D", hash_generated_method = "969338F02BA4ACE0B390024B6D3EC267")
             boolean isCancelled() {
                boolean var730C6CF98606BAC00E4F117050948649_512578195 = (item == this);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_228241005 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_228241005;
                // ---------- Original Method ----------
                //return item == this;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.481 -0400", hash_original_method = "355DAB50A3ED00DA4B9C20D2E0EF6792", hash_generated_method = "1D68399B81BAEE43B2F7EC3B7500E628")
             boolean isOffList() {
                boolean var6517D1C45D1487DACC40419674397359_1894602864 = (next == this);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_837681240 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_837681240;
                // ---------- Original Method ----------
                //return next == this;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.481 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.481 -0400", hash_original_field = "8A1148CE2B27855448692F0F42095BC9", hash_generated_field = "969A31B3082BB4CF0103955413A3CC24")

            private static final long nextOffset = objectFieldOffset(UNSAFE, "next", QNode.class);
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.481 -0400", hash_original_field = "699D04D68ED73F0F2E1CD32D8C6F109A", hash_generated_field = "C54E8DCAC9CD5157F2D50242395059D2")

            private static final long itemOffset = objectFieldOffset(UNSAFE, "item", QNode.class);
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.481 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.481 -0400", hash_original_field = "70027F0D0522D2B8178D239E338F6B3B", hash_generated_field = "718DCD1B9965F259ECF13AAC3FDE17B9")

        private static final long headOffset = objectFieldOffset(UNSAFE, "head", TransferQueue.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.482 -0400", hash_original_field = "FAC26A70E3A7365830A659E724196AC7", hash_generated_field = "125A3490D6DDA910E4EFF8F5BD5EA3A6")

        private static final long tailOffset = objectFieldOffset(UNSAFE, "tail", TransferQueue.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.482 -0400", hash_original_field = "1259B870E41DF8C457DF64A6F063E913", hash_generated_field = "B8C9CACD31C6DFF4CCC160BE1AA5E90A")

        private static final long cleanMeOffset = objectFieldOffset(UNSAFE, "cleanMe", TransferQueue.class);
    }


    
    static class WaitQueue implements java.io.Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.482 -0400", hash_original_method = "A66BE88BE66C40BD12237E932077BBFA", hash_generated_method = "A66BE88BE66C40BD12237E932077BBFA")
        public WaitQueue ()
        {
            //Synthesized constructor
        }


    }


    
    static class LifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.482 -0400", hash_original_method = "2AB7A8E9C876B74C36AEA136750E93EA", hash_generated_method = "2AB7A8E9C876B74C36AEA136750E93EA")
        public LifoWaitQueue ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.482 -0400", hash_original_field = "538748F7DEB6C55C97A19BE3C95E9A81", hash_generated_field = "80F144D9FAF7455012BBD899F5164ED8")

        private static final long serialVersionUID = -3633113410248163686L;
    }


    
    static class FifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.482 -0400", hash_original_method = "2B3543573D85E46D74937DE2E36C8335", hash_generated_method = "2B3543573D85E46D74937DE2E36C8335")
        public FifoWaitQueue ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.482 -0400", hash_original_field = "9697A0ABD2AF5BBA3DD90C1E1CD4F6C6", hash_generated_field = "736A1D17D87D413A39676344D90E22F2")

        private static final long serialVersionUID = -3623113410248163686L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.483 -0400", hash_original_field = "4CA9EACFC32D88A9A4CD6E0A1BDAB9E4", hash_generated_field = "1E3367DE63E4A43E00AB1E404902880B")

    private static final long serialVersionUID = -3223113410248163686L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.483 -0400", hash_original_field = "9D5D4F5356672663FE82C5BD31BC60BF", hash_generated_field = "EB1423FF544459B29A17FADE8C5125D9")

    static final int NCPUS = Runtime.getRuntime().availableProcessors();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.483 -0400", hash_original_field = "B5216FBF1314B0080661A4EF51C6B5C7", hash_generated_field = "EFDB8C9AF5E428D3578BEE68452C22B2")

    static final int maxTimedSpins = (NCPUS < 2) ? 0 : 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.483 -0400", hash_original_field = "5B48E17B478EADCDB689A1C63CCA9BAC", hash_generated_field = "616785537C813125BAC1A7A01A65BE67")

    static final int maxUntimedSpins = maxTimedSpins * 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.483 -0400", hash_original_field = "97826F3E2403B559BA27663CADCEE60A", hash_generated_field = "BFF11A71C399B3DB146FF1C739630A1D")

    static final long spinForTimeoutThreshold = 1000L;
}

