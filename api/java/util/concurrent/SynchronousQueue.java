package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.*;
import libcore.util.EmptyArray;

public class SynchronousQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.998 -0400", hash_original_field = "14FF183E0CBF22E7DBE09157245ED2D4", hash_generated_field = "93A6B6C7FD7700420692EFD74AC915AE")

    private transient volatile Transferer transferer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.998 -0400", hash_original_field = "18B069DB69ED982634500077B1439F32", hash_generated_field = "E2A217843A6D418FDE83E1DD89178FFA")

    private ReentrantLock qlock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.998 -0400", hash_original_field = "882C5ACA03261179CC74C2C00EFBE286", hash_generated_field = "9EC2490AD04FFD57826C64D62CD6D006")

    private WaitQueue waitingProducers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.998 -0400", hash_original_field = "AF8EC88A663239AB823F4C324266FE94", hash_generated_field = "4EC4B53B46775F740D025ADAAB977973")

    private WaitQueue waitingConsumers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.999 -0400", hash_original_method = "CA3CB3D951221FCCF0DFF3BB5DF12346", hash_generated_method = "5255A939CCFA97D45156B8A4109C3AE2")
    public  SynchronousQueue() {
        this(false);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.999 -0400", hash_original_method = "2A4F416DA0F8363F009FD8DA8EB74A84", hash_generated_method = "E36170E9580D212BFA99521F1CF0C67D")
    public  SynchronousQueue(boolean fair) {
        transferer = fair ? new TransferQueue() : new TransferStack();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.999 -0400", hash_original_method = "C65E97EC40BB31D50DB029B0D4F47DF5", hash_generated_method = "B4DD094C945FFDB2588CA45A638A6CC6")
    public void put(E o) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var7607C5756161FCDCDBD28D01FED3953C_440494640 = (transferer.transfer(o, false, 0) == null);
            {
                Thread.interrupted();
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } 
        } 
        addTaint(o.getTaint());
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.000 -0400", hash_original_method = "3A6AFFAA000C17EA73FBC10B0EC018FD", hash_generated_method = "9D637737ED64F01CE1A3E035DA840832")
    public boolean offer(E o, long timeout, TimeUnit unit) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean varF1825FBBB753F22C73534A88EB505062_821877433 = (transferer.transfer(o, true, unit.toNanos(timeout)) != null);
        } 
        {
            boolean var7802430CC9FA3C264EA55E37D5C0452C_1607066624 = (!Thread.interrupted());
        } 
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        addTaint(o.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_702710458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_702710458;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.000 -0400", hash_original_method = "A4F84C12941B1214559E662FB5D2360B", hash_generated_method = "E38EC5A4B754ED6E9FDA1075C8E2AA98")
    public boolean offer(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        boolean varE546A568DD0E1DA7331DA7BD0D817F43_1675187100 = (transferer.transfer(e, true, 0) != null);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637740626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637740626;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.001 -0400", hash_original_method = "A59182A477060C80E9C0D7B7DD2CA2C3", hash_generated_method = "3C69A8CFCBA0713705ED22398143D16D")
    public E take() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1585394876 = null; 
        Object e = transferer.transfer(null, false, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1585394876 = (E)e;
        Thread.interrupted();
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        varB4EAC82CA7396A68D541C85D26508E83_1585394876.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1585394876;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.003 -0400", hash_original_method = "F80BFD27E2D553DA44FF7C91997050D6", hash_generated_method = "BE17FD61BA22E45A3DF9A15DF11FA4E5")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1424613616 = null; 
        Object e = transferer.transfer(null, true, unit.toNanos(timeout));
        {
            boolean varC564A7C2CC52E9BBB2AF6FB9F10A266F_1298862803 = (e != null || !Thread.interrupted());
            varB4EAC82CA7396A68D541C85D26508E83_1424613616 = (E)e;
        } 
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1424613616.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1424613616;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.004 -0400", hash_original_method = "1663F66628103F625AD11623448BFB1D", hash_generated_method = "3457A70D3407616837B39CF6EED5A8DA")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_1388554916 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1388554916 = (E)transferer.transfer(null, true, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1388554916.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1388554916;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.004 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "F16D814F134B57BFBDADF78473C2B965")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908829458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_908829458;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.004 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "31CC15D2CE17E50879707D917243A276")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917326936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1917326936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.004 -0400", hash_original_method = "859254362B8CFD4ECD77710B77AC10ED", hash_generated_method = "482AAAFCA043EBF1EA9E98424D41259B")
    public int remainingCapacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275207293 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275207293;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.029 -0400", hash_original_method = "CAFED8DEE3108243325B67F5797719ED", hash_generated_method = "62E208A158681C1F982FD616252404DD")
    public void clear() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.029 -0400", hash_original_method = "133415712E6841A0903588DC5D4862AA", hash_generated_method = "A802766551CEC030BD53B80E85B5D2B8")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472390606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472390606;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.029 -0400", hash_original_method = "6081257F3AE1D633C77BCA63D6F77CB7", hash_generated_method = "6E498D6246C661EBD3965F409A9CF6A5")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_445311964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_445311964;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.029 -0400", hash_original_method = "C503BED5AF377C63A87B0C398CACB95B", hash_generated_method = "DF3955680E2D1801EE909216BA0FD749")
    public boolean containsAll(Collection<?> c) {
        boolean varC1DF46038608BCBF5C56CAC54A25A9EA_1151528645 = (c.isEmpty());
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115910118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115910118;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.029 -0400", hash_original_method = "EC0A570B588D76D8968190A1BD3D4040", hash_generated_method = "01C9BE7EECA7B9293FFC0D9F8A0480F6")
    public boolean removeAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_489667286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_489667286;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.030 -0400", hash_original_method = "13D5AD766AE77320C3CF56AB2E9E5FB4", hash_generated_method = "4EFB274482542ECD42613C6C7BAA854B")
    public boolean retainAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084090977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084090977;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.030 -0400", hash_original_method = "2DC914F9B3C538818482710C9EAD9EFB", hash_generated_method = "0C7EE5646C5E3FC32789BBB3CE6B8F9A")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_1675749292 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1675749292 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1675749292.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1675749292;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.030 -0400", hash_original_method = "0BB2C5BB97AA1323E2FE15E87216E7E9", hash_generated_method = "7EEED8F31183CC6C139183B85C17184E")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1505666410 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1505666410 = Collections.<E>emptySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1505666410.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1505666410;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.030 -0400", hash_original_method = "AAA5D1CBE91ADDEA174F65821E23BE58", hash_generated_method = "DD67ABE9352AEDFC51547780C336B864")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1945801827 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1945801827 = EmptyArray.OBJECT;
        varB4EAC82CA7396A68D541C85D26508E83_1945801827.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1945801827;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.031 -0400", hash_original_method = "490A2A0CCABF1E39472F82358B033503", hash_generated_method = "B0647A2CB2A3F6F3EF961954059021BF")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1906426775 = null; 
        a[0] = null;
        varB4EAC82CA7396A68D541C85D26508E83_1906426775 = a;
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1906426775.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1906426775;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.031 -0400", hash_original_method = "B59D7BDF727183928F94F36988272CAC", hash_generated_method = "7349643AAD8491B3841B852FA99D5A4E")
    public int drainTo(Collection<? super E> c) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1124084911 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        int n = 0;
        E e;
        {
            boolean var2F576A572403388DFCF1A0EB0F29376A_406218560 = ((e = poll()) != null);
            {
                c.add(e);
            } 
        } 
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261512829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261512829;
        
        
            
        
            
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.031 -0400", hash_original_method = "DA549833C1743125BAA2828712BD0C73", hash_generated_method = "3D1ED4021B51E275DAC73BCA61A6045A")
    public int drainTo(Collection<? super E> c, int maxElements) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_269873435 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        int n = 0;
        E e;
        {
        	c.add(poll());
        } 
        addTaint(c.getTaint());
        addTaint(maxElements);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306598950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306598950;
        
        
            
        
            
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.032 -0400", hash_original_method = "7D89BB192BA936EC93EB72454855578A", hash_generated_method = "A4D7E8594EE2D9926A2A6A061CDB471E")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        boolean fair = transferer instanceof TransferQueue;
        {
            qlock = new ReentrantLock(true);
            waitingProducers = new FifoWaitQueue();
            waitingConsumers = new FifoWaitQueue();
        } 
        {
            qlock = new ReentrantLock();
            waitingProducers = new LifoWaitQueue();
            waitingConsumers = new LifoWaitQueue();
        } 
        s.defaultWriteObject();
        addTaint(s.getTaint());
        
        
        
            
            
            
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.032 -0400", hash_original_method = "E156E82E550566200FEDBE52C0090F6F", hash_generated_method = "221738A97F236F02972DC9F5321F60CF")
    private void readObject(final java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        transferer = new TransferQueue();
        transferer = new TransferStack();
        addTaint(s.getTaint());
        
        
        
            
        
            
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.032 -0400", hash_original_method = "09F8B62CD164A65EFE70D215172CE3CA", hash_generated_method = "09F8B62CD164A65EFE70D215172CE3CA")
        public Transferer ()
        {
            
        }


        abstract Object transfer(Object e, boolean timed, long nanos);

        
    }


    
    static final class TransferStack extends Transferer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.032 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "228454E0E0F7F2A4C4B0260AD101A4CF")

        volatile SNode head;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.032 -0400", hash_original_method = "02B0885CE62BE77F872535266EC48EF9", hash_generated_method = "02B0885CE62BE77F872535266EC48EF9")
        public TransferStack ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        static boolean isFulfilling(int m) {
            return (m & FULFILLING) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.033 -0400", hash_original_method = "F38594CD80446D46D4DC59D46118C84B", hash_generated_method = "D1D20DC9310434B1BE39813C5B3B20ED")
         boolean casHead(SNode h, SNode nh) {
            boolean var282379A22391D5E03F6F0D3EAE465E33_1166710054 = (h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh));
            addTaint(h.getTaint());
            addTaint(nh.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_80328080 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_80328080;
            
            
                
        }

        
        static SNode snode(SNode s, Object e, SNode next, int mode) {
            if (s == null) s = new SNode(e);
            s.mode = mode;
            s.next = next;
            return s;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.034 -0400", hash_original_method = "EF565BC8E8F2E2CD3218F549EBA67BF0", hash_generated_method = "32BF9DAEDF0AFAD3E24740EBA5A87A2D")
         Object transfer(Object e, boolean timed, long nanos) {
            Object varB4EAC82CA7396A68D541C85D26508E83_282577603 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_350500795 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1540807925 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1199472067 = null; 
            SNode s = null;
            int mode;
            mode = REQUEST;
            mode = DATA;
            {
                SNode h = head;
                {
                    {
                        {
                            boolean varAF0FEF72D29268ED4CF841ECB2A137E4_614954895 = (h != null && h.isCancelled());
                            casHead(h, h.next);
                            varB4EAC82CA7396A68D541C85D26508E83_282577603 = null;
                        } 
                    } 
                    {
                        boolean var614383346FD226DA87E63D0856A0A09B_2044352119 = (casHead(h, s = snode(s, e, h, mode)));
                        {
                            SNode m = awaitFulfill(s, timed, nanos);
                            {
                                clean(s);
                                varB4EAC82CA7396A68D541C85D26508E83_350500795 = null;
                            } 
                            {
                                boolean varCEABA499FA984A91272EEF573D762D61_358035850 = ((h = head) != null && h.next == s);
                                casHead(h, s.next);
                            } 
                            varB4EAC82CA7396A68D541C85D26508E83_1540807925 = (mode == REQUEST) ? m.item : s.item;
                        } 
                    } 
                } 
                {
                    boolean var4218B438AD2FB275956E62AB7D82C855_1187226362 = (!isFulfilling(h.mode));
                    {
                        {
                            boolean var45FA36E500306668AF61900380872E2F_1109837842 = (h.isCancelled());
                            casHead(h, h.next);
                            {
                                boolean var56CD32B0D05B8BCEC4781DB0B808E9D4_1587210923 = (casHead(h, s=snode(s, e, h, FULFILLING|mode)));
                                {
                                    {
                                        SNode m = s.next;
                                        {
                                            casHead(s, null);
                                            s = null;
                                        } 
                                        SNode mn = m.next;
                                        {
                                            boolean varB1F893F63AA2BB92DE5336301E43E893_1738820475 = (m.tryMatch(s));
                                            {
                                                casHead(s, mn);
                                                varB4EAC82CA7396A68D541C85D26508E83_1199472067 = (mode == REQUEST) ? m.item : s.item;
                                            } 
                                            s.casNext(m, mn);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    {
                        SNode m = h.next;
                        casHead(h, null);
                        {
                            SNode mn = m.next;
                            {
                                boolean varBA066F30AE1F5BAF188C4FB69B8A094C_1495665024 = (m.tryMatch(h));
                                casHead(h, mn);
                                h.casNext(m, mn);
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(e.getTaint());
            addTaint(timed);
            addTaint(nanos);
            Object varA7E53CE21691AB073D9660D615818899_581702653; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_581702653 = varB4EAC82CA7396A68D541C85D26508E83_282577603;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_581702653 = varB4EAC82CA7396A68D541C85D26508E83_350500795;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_581702653 = varB4EAC82CA7396A68D541C85D26508E83_1540807925;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_581702653 = varB4EAC82CA7396A68D541C85D26508E83_1199472067;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_581702653.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_581702653;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.035 -0400", hash_original_method = "8450123659E4F3E3FBDDF976A06B7608", hash_generated_method = "5CD18E5882E0797DD18463C93C91F6BD")
         SNode awaitFulfill(SNode s, boolean timed, long nanos) {
            SNode varB4EAC82CA7396A68D541C85D26508E83_1542218624 = null; 
            long lastTime;
            lastTime = System.nanoTime();
            lastTime = 0;
            Thread w = Thread.currentThread();
            SNode h = head;
            int spins = (shouldSpin(s) ?
                         (timed ? maxTimedSpins : maxUntimedSpins) : 0);
            {
                {
                    boolean varE18A53653EF476A6AB7DE0F6C07F3E95_1065704415 = (w.isInterrupted());
                    s.tryCancel();
                } 
                SNode m = s.match;
                varB4EAC82CA7396A68D541C85D26508E83_1542218624 = m;
                {
                    long now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    {
                        s.tryCancel();
                    } 
                } 
                spins = shouldSpin(s) ? (spins-1) : 0;
                s.waiter = w;
                LockSupport.park(this);
                LockSupport.parkNanos(this, nanos);
            } 
            addTaint(s.getTaint());
            addTaint(timed);
            addTaint(nanos);
            varB4EAC82CA7396A68D541C85D26508E83_1542218624.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1542218624;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.035 -0400", hash_original_method = "C3C9887957CF791F525718002F2944FE", hash_generated_method = "CE3EC953E3F5B02E9F13DA50754CA7A0")
         boolean shouldSpin(SNode s) {
            SNode h = head;
            boolean varC78E38E74D454B0C5F31FDF005C00FBD_1047347436 = ((h == s || h == null || isFulfilling(h.mode)));
            addTaint(s.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1449572996 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1449572996;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.036 -0400", hash_original_method = "162514ED54A955A73353466B6689AF5B", hash_generated_method = "A51E99269264607ADDAF8F7E20848CFE")
         void clean(SNode s) {
            s.item = null;
            s.waiter = null;
            SNode past = s.next;
            {
                boolean var4E37DAF71F369F48A6BA6D5D25162637_478336593 = (past != null && past.isCancelled());
                past = past.next;
            } 
            SNode p;
            {
                boolean varE83DFBC86BE14AC937698BA559B0E748_1337473035 = ((p = head) != null && p != past && p.isCancelled());
                casHead(p, p.next);
            } 
            {
                SNode n = p.next;
                {
                    boolean varFA4190EAA665CEE1627963E04B8B5194_1268453469 = (n != null && n.isCancelled());
                    p.casNext(n, n.next);
                    p = n;
                } 
            } 
            addTaint(s.getTaint());
            
            
            
            
            
                
            
            
                
            
                
                
                    
                
                    
            
        }

        
        static final class SNode {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.036 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "51B8757B53C140AD03FA5839D28E2835")

            volatile SNode next;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.036 -0400", hash_original_field = "E3CC92C14A5E6DD1A7D94B6FF634D7FC", hash_generated_field = "6CEC32C9039E66F4CB3AFBF850A69E68")

            volatile SNode match;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.036 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.036 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "CF812EE2AD9BC4EAA8B11FCCEDAE3ADB")

            Object item;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.036 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "462D02655D7DD7DF6E5BA12D65851DD2")

            int mode;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.037 -0400", hash_original_method = "1B0B8D11CB10F0B4CCAA4D8835EC421B", hash_generated_method = "CF1397AC3B88B93FEFBB222BFAAE5E40")
              SNode(Object item) {
                this.item = item;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.037 -0400", hash_original_method = "265B3E666AD76F55078AE9E7E3AE351C", hash_generated_method = "9A731A0B6F3313F56B3443C629FB15CC")
             boolean casNext(SNode cmp, SNode val) {
                boolean var177A136DD6EC4DAC0D9ACF118160DDB7_859082636 = (cmp == next &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                addTaint(cmp.getTaint());
                addTaint(val.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1639474514 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1639474514;
                
                
                    
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.038 -0400", hash_original_method = "CEB4EA3334013C3454101E56EFA00D65", hash_generated_method = "191E75E7FAE2DE877E12A639D19FE321")
             boolean tryMatch(SNode s) {
                {
                    boolean var6711BCB91C5006023132439F2128DD98_2034819331 = (match == null &&
                    UNSAFE.compareAndSwapObject(this, matchOffset, null, s));
                    {
                        Thread w = waiter;
                        {
                            waiter = null;
                            LockSupport.unpark(w);
                        } 
                    } 
                } 
                addTaint(s.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296826289 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296826289;
                
                
                    
                    
                    
                        
                        
                    
                    
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.038 -0400", hash_original_method = "4364F2F312C8CE7EEFC1A24A7BE396DF", hash_generated_method = "F113C1DDE10ED16910489434287E4197")
             void tryCancel() {
                UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
                
                
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_method = "BB4CEE3409ECC1A047D42B262CFDD801", hash_generated_method = "A69582FC2EAAFEC2AD5D1EF41EDF5C08")
             boolean isCancelled() {
                boolean var7F5D65803B47A70559075CCD6D448518_1860994530 = (match == this);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1168123025 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1168123025;
                
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "8234D14DA629F1B33BC3BF468BFC1AAE", hash_generated_field = "0D8325461BECB64F10F564BE157F8175")

            private static final long nextOffset = objectFieldOffset(UNSAFE, "next", SNode.class);
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "CD74A71824B260054518EC8AEE7963D3", hash_generated_field = "B5BF3FE8CC1DDC4679FEA266AA5E519F")

            private static final long matchOffset = objectFieldOffset(UNSAFE, "match", SNode.class);
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "00901407DB520A6DA0C4ED8316299BA6", hash_generated_field = "1279CC9CFAD174B5AA85ADAB5A87C1B2")

        static final int REQUEST = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "76AD11A457B8D4D9AA18A779A31A8BFF", hash_generated_field = "839D78410482BFBBC8FD6F80E7B7399B")

        static final int DATA = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "5E06EC816761815F086BAFA71AC08DF4", hash_generated_field = "14F8F9AC365CBCC20FCF4F001AD6990B")

        static final int FULFILLING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "D060AADCA72F1E682132007013486754", hash_generated_field = "FDC74C8C46C70DC81257DAB123799A8D")

        private static final long headOffset = objectFieldOffset(UNSAFE, "head", TransferStack.class);
    }


    
    static final class TransferQueue extends Transferer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "8B563AA5A75BA53BC5C38CBCB00877BD")

        transient volatile QNode head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "28504BE4CF28FABF51A5115491756D5B")

        transient volatile QNode tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_field = "15D477186674E9EC651EC7D91C1367FE", hash_generated_field = "11DAC5D336C0CE8D6AABAA86A736FB77")

        transient volatile QNode cleanMe;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.039 -0400", hash_original_method = "EBB3C2235277D03D49EE8D8BB02DD64A", hash_generated_method = "064390A0D5BEAB18E259D10581E7DE52")
          TransferQueue() {
            QNode h = new QNode(null, false);
            head = h;
            tail = h;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.040 -0400", hash_original_method = "80B021B7B5DA5B6F1F69021D0C7D6F89", hash_generated_method = "7F6E0AA8D9CC06665A5B3495E6247F9A")
         void advanceHead(QNode h, QNode nh) {
            {
                boolean varA1699559793DFF39D27BE01166D10E99_1630433121 = (h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh));
                h.next = h;
            } 
            addTaint(h.getTaint());
            addTaint(nh.getTaint());
            
            
                
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.040 -0400", hash_original_method = "8E334B9D021C7CA1D4C0B314F9C4B69F", hash_generated_method = "52615D8D66692BA26F5D61E0B21B554A")
         void advanceTail(QNode t, QNode nt) {
            UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
            addTaint(t.getTaint());
            addTaint(nt.getTaint());
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.040 -0400", hash_original_method = "7A9E3B63F4597B524322C45DD727A635", hash_generated_method = "540A74C637A05921DD80CB04DC8B3BC6")
         boolean casCleanMe(QNode cmp, QNode val) {
            boolean var65FAFD82FA2D6EE7BE39B31A73009EBD_828049962 = (cleanMe == cmp &&
                UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val));
            addTaint(cmp.getTaint());
            addTaint(val.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_537237949 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_537237949;
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.042 -0400", hash_original_method = "D9295193CC3F280F47A7E51B4594CC44", hash_generated_method = "B0F0BBBABF370CCB7A51E399305203FD")
         Object transfer(Object e, boolean timed, long nanos) {
            Object varB4EAC82CA7396A68D541C85D26508E83_597186076 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1198655463 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1397310144 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_466067682 = null; 
            QNode s = null;
            boolean isData = (e != null);
            {
                QNode t = tail;
                QNode h = head;
                {
                    QNode tn = t.next;
                    {
                        advanceTail(t, tn);
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_597186076 = null;
                    s = new QNode(e, isData);
                    {
                        boolean var2D6D1EC910A75C1BE0BDF8DC15A993BD_798598044 = (!t.casNext(null, s));
                    } 
                    advanceTail(t, s);
                    Object x = awaitFulfill(s, e, timed, nanos);
                    {
                        clean(t, s);
                        varB4EAC82CA7396A68D541C85D26508E83_1198655463 = null;
                    } 
                    {
                        boolean var49DCCE4E1014EF8A97A0B4DE6D6A07F5_2094707015 = (!s.isOffList());
                        {
                            advanceHead(t, s);
                            s.item = s;
                            s.waiter = null;
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_1397310144 = (x != null) ? x : e;
                } 
                {
                    QNode m = h.next;
                    Object x = m.item;
                    {
                        boolean var9A5DF2A846D139F665EDBC74399D4235_1345318874 = (isData == (x != null) ||    
                        x == m ||                   
                        !m.casItem(x, e));
                        {
                            advanceHead(h, m);
                        } 
                    } 
                    advanceHead(h, m);
                    LockSupport.unpark(m.waiter);
                    varB4EAC82CA7396A68D541C85D26508E83_466067682 = (x != null) ? x : e;
                } 
            } 
            addTaint(e.getTaint());
            addTaint(timed);
            addTaint(nanos);
            Object varA7E53CE21691AB073D9660D615818899_325755935; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_325755935 = varB4EAC82CA7396A68D541C85D26508E83_597186076;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_325755935 = varB4EAC82CA7396A68D541C85D26508E83_1198655463;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_325755935 = varB4EAC82CA7396A68D541C85D26508E83_1397310144;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_325755935 = varB4EAC82CA7396A68D541C85D26508E83_466067682;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_325755935.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_325755935;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.043 -0400", hash_original_method = "90C8A09C09ECF2EF83975D209FFEEF37", hash_generated_method = "DA15A3C1D4C73375639EF447C56E8D00")
         Object awaitFulfill(QNode s, Object e, boolean timed, long nanos) {
            Object varB4EAC82CA7396A68D541C85D26508E83_581800523 = null; 
            long lastTime;
            lastTime = System.nanoTime();
            lastTime = 0;
            Thread w = Thread.currentThread();
            int spins = ((head.next == s) ?
                         (timed ? maxTimedSpins : maxUntimedSpins) : 0);
            {
                {
                    boolean varE18A53653EF476A6AB7DE0F6C07F3E95_819335063 = (w.isInterrupted());
                    s.tryCancel(e);
                } 
                Object x = s.item;
                varB4EAC82CA7396A68D541C85D26508E83_581800523 = x;
                {
                    long now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    {
                        s.tryCancel(e);
                    } 
                } 
                s.waiter = w;
                LockSupport.park(this);
                LockSupport.parkNanos(this, nanos);
            } 
            addTaint(s.getTaint());
            addTaint(e.getTaint());
            addTaint(timed);
            addTaint(nanos);
            varB4EAC82CA7396A68D541C85D26508E83_581800523.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_581800523;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.044 -0400", hash_original_method = "6683A876B1B30ADB5D756618BABF762A", hash_generated_method = "CCAEE58B03B03A9DB1C27F7A2FD60061")
         void clean(QNode pred, QNode s) {
            s.waiter = null;
            {
                QNode h = head;
                QNode hn = h.next;
                {
                    boolean var90BBDE8A0ACDED3C7351797369CBD741_1119265279 = (hn != null && hn.isCancelled());
                    {
                        advanceHead(h, hn);
                    } 
                } 
                QNode t = tail;
                QNode tn = t.next;
                {
                    advanceTail(t, tn);
                } 
                {
                    QNode sn = s.next;
                    {
                        boolean var9EC0578845E9330F648DFD38BF8851EE_898092792 = (sn == s || pred.casNext(s, sn));
                    } 
                } 
                QNode dp = cleanMe;
                {
                    QNode d = dp.next;
                    QNode dn;
                    {
                        boolean var981072472C7ACBE6D966E74F0BA25D4D_1537900874 = (d == null ||               
                        d == dp ||                 
                        !d.isCancelled() ||        
                        (d != t &&                 
                         (dn = d.next) != null &&  
                         dn != d &&                
                         dp.casNext(d, dn)));
                        casCleanMe(dp, null);
                    } 
                } 
                {
                    boolean varF92453FEDC3A2CB53C1EB52CDEA2A7A0_406160321 = (casCleanMe(null, pred));
                } 
            } 
            addTaint(pred.getTaint());
            addTaint(s.getTaint());
            
            
        }

        
        static final class QNode {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.044 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "98C54C1386619AED777FF36204F4724D")

            volatile QNode next;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.044 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "572C92874AD4D49E8D97420DECC4EA3C")

            volatile Object item;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.044 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.044 -0400", hash_original_field = "CC995F2BD435828CA793B1399F0CD031", hash_generated_field = "13998CD9DB54AD99E9DAFA28EE2691E9")

            boolean isData;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.045 -0400", hash_original_method = "36E0BDE690B9319BBAE39AE7BB5AED99", hash_generated_method = "AC79B184894CD3D93DB04113A86F071F")
              QNode(Object item, boolean isData) {
                this.item = item;
                this.isData = isData;
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.047 -0400", hash_original_method = "611C5C34CB4DC255784715588EF3B5E5", hash_generated_method = "3C5CB725537CFF60C40EA74A7FF6F1B8")
             boolean casNext(QNode cmp, QNode val) {
                boolean var17EA7A1AF3964F578962ECF95DC323BD_1538564799 = (next == cmp &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                addTaint(cmp.getTaint());
                addTaint(val.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435516591 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_435516591;
                
                
                    
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.047 -0400", hash_original_method = "3912AD02565B809FB80AB4089D0BD0C1", hash_generated_method = "B2BA36E3F995D0C0064AADBE4B48B436")
             boolean casItem(Object cmp, Object val) {
                boolean varA0F2A8A326F7E81A747BE437A925260E_720656949 = (item == cmp &&
                    UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val));
                addTaint(cmp.getTaint());
                addTaint(val.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1977539793 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1977539793;
                
                
                    
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.049 -0400", hash_original_method = "99C72522BA0C395099FBEE5F0489DB78", hash_generated_method = "E2C6ECF6C71997A06DF967CE44B0E11D")
             void tryCancel(Object cmp) {
                UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
                addTaint(cmp.getTaint());
                
                
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.051 -0400", hash_original_method = "45E5A9573D9BA1D0D86064CD1643198D", hash_generated_method = "FEEB683761FE857C5407392FBD91F785")
             boolean isCancelled() {
                boolean varA64503E11EBD2041198E2D58A05084A8_1592751954 = (item == this);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923521327 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_923521327;
                
                
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.052 -0400", hash_original_method = "355DAB50A3ED00DA4B9C20D2E0EF6792", hash_generated_method = "C0931F3E7826B067A91E1FA863EDC380")
             boolean isOffList() {
                boolean varB6C5D4B086DE21F098503EC790F4AB8E_1423888570 = (next == this);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59181301 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_59181301;
                
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.052 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.052 -0400", hash_original_field = "8A1148CE2B27855448692F0F42095BC9", hash_generated_field = "969A31B3082BB4CF0103955413A3CC24")

            private static final long nextOffset = objectFieldOffset(UNSAFE, "next", QNode.class);
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.052 -0400", hash_original_field = "699D04D68ED73F0F2E1CD32D8C6F109A", hash_generated_field = "C54E8DCAC9CD5157F2D50242395059D2")

            private static final long itemOffset = objectFieldOffset(UNSAFE, "item", QNode.class);
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.052 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.052 -0400", hash_original_field = "70027F0D0522D2B8178D239E338F6B3B", hash_generated_field = "718DCD1B9965F259ECF13AAC3FDE17B9")

        private static final long headOffset = objectFieldOffset(UNSAFE, "head", TransferQueue.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.052 -0400", hash_original_field = "FAC26A70E3A7365830A659E724196AC7", hash_generated_field = "125A3490D6DDA910E4EFF8F5BD5EA3A6")

        private static final long tailOffset = objectFieldOffset(UNSAFE, "tail", TransferQueue.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_field = "1259B870E41DF8C457DF64A6F063E913", hash_generated_field = "B8C9CACD31C6DFF4CCC160BE1AA5E90A")

        private static final long cleanMeOffset = objectFieldOffset(UNSAFE, "cleanMe", TransferQueue.class);
    }


    
    static class WaitQueue implements java.io.Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_method = "A66BE88BE66C40BD12237E932077BBFA", hash_generated_method = "A66BE88BE66C40BD12237E932077BBFA")
        public WaitQueue ()
        {
            
        }


    }


    
    static class LifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_method = "2AB7A8E9C876B74C36AEA136750E93EA", hash_generated_method = "2AB7A8E9C876B74C36AEA136750E93EA")
        public LifoWaitQueue ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_field = "538748F7DEB6C55C97A19BE3C95E9A81", hash_generated_field = "80F144D9FAF7455012BBD899F5164ED8")

        private static final long serialVersionUID = -3633113410248163686L;
    }


    
    static class FifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_method = "2B3543573D85E46D74937DE2E36C8335", hash_generated_method = "2B3543573D85E46D74937DE2E36C8335")
        public FifoWaitQueue ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_field = "9697A0ABD2AF5BBA3DD90C1E1CD4F6C6", hash_generated_field = "736A1D17D87D413A39676344D90E22F2")

        private static final long serialVersionUID = -3623113410248163686L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_field = "4CA9EACFC32D88A9A4CD6E0A1BDAB9E4", hash_generated_field = "1E3367DE63E4A43E00AB1E404902880B")

    private static final long serialVersionUID = -3223113410248163686L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_field = "9D5D4F5356672663FE82C5BD31BC60BF", hash_generated_field = "EB1423FF544459B29A17FADE8C5125D9")

    static final int NCPUS = Runtime.getRuntime().availableProcessors();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_field = "B5216FBF1314B0080661A4EF51C6B5C7", hash_generated_field = "EFDB8C9AF5E428D3578BEE68452C22B2")

    static final int maxTimedSpins = (NCPUS < 2) ? 0 : 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_field = "5B48E17B478EADCDB689A1C63CCA9BAC", hash_generated_field = "616785537C813125BAC1A7A01A65BE67")

    static final int maxUntimedSpins = maxTimedSpins * 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.053 -0400", hash_original_field = "97826F3E2403B559BA27663CADCEE60A", hash_generated_field = "BFF11A71C399B3DB146FF1C739630A1D")

    static final long spinForTimeoutThreshold = 1000L;
}

