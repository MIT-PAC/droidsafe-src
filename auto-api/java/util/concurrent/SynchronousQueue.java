package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.*;
import libcore.util.EmptyArray;

public class SynchronousQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.580 -0400", hash_original_field = "14FF183E0CBF22E7DBE09157245ED2D4", hash_generated_field = "93A6B6C7FD7700420692EFD74AC915AE")

    private transient volatile Transferer transferer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.581 -0400", hash_original_field = "18B069DB69ED982634500077B1439F32", hash_generated_field = "E2A217843A6D418FDE83E1DD89178FFA")

    private ReentrantLock qlock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.581 -0400", hash_original_field = "882C5ACA03261179CC74C2C00EFBE286", hash_generated_field = "9EC2490AD04FFD57826C64D62CD6D006")

    private WaitQueue waitingProducers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.581 -0400", hash_original_field = "AF8EC88A663239AB823F4C324266FE94", hash_generated_field = "4EC4B53B46775F740D025ADAAB977973")

    private WaitQueue waitingConsumers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.581 -0400", hash_original_method = "CA3CB3D951221FCCF0DFF3BB5DF12346", hash_generated_method = "5255A939CCFA97D45156B8A4109C3AE2")
    public  SynchronousQueue() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.581 -0400", hash_original_method = "2A4F416DA0F8363F009FD8DA8EB74A84", hash_generated_method = "E36170E9580D212BFA99521F1CF0C67D")
    public  SynchronousQueue(boolean fair) {
        transferer = fair ? new TransferQueue() : new TransferStack();
        // ---------- Original Method ----------
        //transferer = fair ? new TransferQueue() : new TransferStack();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.582 -0400", hash_original_method = "C65E97EC40BB31D50DB029B0D4F47DF5", hash_generated_method = "0E5B2C129960972331A78F44467B68AC")
    public void put(E o) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var7607C5756161FCDCDBD28D01FED3953C_1337085486 = (transferer.transfer(o, false, 0) == null);
            {
                Thread.interrupted();
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        // ---------- Original Method ----------
        //if (o == null) throw new NullPointerException();
        //if (transferer.transfer(o, false, 0) == null) {
            //Thread.interrupted();
            //throw new InterruptedException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.593 -0400", hash_original_method = "3A6AFFAA000C17EA73FBC10B0EC018FD", hash_generated_method = "7EA3350829EDC8050679B1009445B52E")
    public boolean offer(E o, long timeout, TimeUnit unit) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean varF1825FBBB753F22C73534A88EB505062_770569973 = (transferer.transfer(o, true, unit.toNanos(timeout)) != null);
        } //End collapsed parenthetic
        {
            boolean var7802430CC9FA3C264EA55E37D5C0452C_970538479 = (!Thread.interrupted());
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        addTaint(o.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682072985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682072985;
        // ---------- Original Method ----------
        //if (o == null) throw new NullPointerException();
        //if (transferer.transfer(o, true, unit.toNanos(timeout)) != null)
            //return true;
        //if (!Thread.interrupted())
            //return false;
        //throw new InterruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.594 -0400", hash_original_method = "A4F84C12941B1214559E662FB5D2360B", hash_generated_method = "6DFECCDBF05C27E677B1FCC946112B05")
    public boolean offer(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        boolean varE546A568DD0E1DA7331DA7BD0D817F43_1195987537 = (transferer.transfer(e, true, 0) != null);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1824232594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1824232594;
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //return transferer.transfer(e, true, 0) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.594 -0400", hash_original_method = "A59182A477060C80E9C0D7B7DD2CA2C3", hash_generated_method = "F49E0AA7DC9C547492C8D92EA569EDDC")
    public E take() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1430075950 = null; //Variable for return #1
        Object e;
        e = transferer.transfer(null, false, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1430075950 = (E)e;
        Thread.interrupted();
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        varB4EAC82CA7396A68D541C85D26508E83_1430075950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1430075950;
        // ---------- Original Method ----------
        //Object e = transferer.transfer(null, false, 0);
        //if (e != null)
            //return (E)e;
        //Thread.interrupted();
        //throw new InterruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.595 -0400", hash_original_method = "F80BFD27E2D553DA44FF7C91997050D6", hash_generated_method = "96D26FCEE3B5EE66524025D42E2C5BB9")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_444993921 = null; //Variable for return #1
        Object e;
        e = transferer.transfer(null, true, unit.toNanos(timeout));
        {
            boolean varC564A7C2CC52E9BBB2AF6FB9F10A266F_735490814 = (e != null || !Thread.interrupted());
            varB4EAC82CA7396A68D541C85D26508E83_444993921 = (E)e;
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_444993921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_444993921;
        // ---------- Original Method ----------
        //Object e = transferer.transfer(null, true, unit.toNanos(timeout));
        //if (e != null || !Thread.interrupted())
            //return (E)e;
        //throw new InterruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.606 -0400", hash_original_method = "1663F66628103F625AD11623448BFB1D", hash_generated_method = "E62E515D014FB5D24F6281ADB42A90D8")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_86004071 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_86004071 = (E)transferer.transfer(null, true, 0);
        varB4EAC82CA7396A68D541C85D26508E83_86004071.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_86004071;
        // ---------- Original Method ----------
        //return (E)transferer.transfer(null, true, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.607 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "773BF0EA125877A5A2AC6BCEAAFCBC8C")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568900812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_568900812;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.607 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "827983B6E19E952E30DBF326E795EA1C")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283232570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283232570;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.608 -0400", hash_original_method = "859254362B8CFD4ECD77710B77AC10ED", hash_generated_method = "0F0D462E0422DD793D0D3E68BA4A66D9")
    public int remainingCapacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312095922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312095922;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.608 -0400", hash_original_method = "CAFED8DEE3108243325B67F5797719ED", hash_generated_method = "62E208A158681C1F982FD616252404DD")
    public void clear() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.608 -0400", hash_original_method = "133415712E6841A0903588DC5D4862AA", hash_generated_method = "9271B9268A13BF93D5B63AFC8ED8DB4D")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484244573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484244573;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.608 -0400", hash_original_method = "6081257F3AE1D633C77BCA63D6F77CB7", hash_generated_method = "21D018689C1B9D8BF2261ECA7CC91238")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_29341385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_29341385;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.609 -0400", hash_original_method = "C503BED5AF377C63A87B0C398CACB95B", hash_generated_method = "5D868750738A4ABEFC14780470B6A6AE")
    public boolean containsAll(Collection<?> c) {
        boolean varC1DF46038608BCBF5C56CAC54A25A9EA_134185285 = (c.isEmpty());
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226926458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226926458;
        // ---------- Original Method ----------
        //return c.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.609 -0400", hash_original_method = "EC0A570B588D76D8968190A1BD3D4040", hash_generated_method = "9C464AFB7942D90A228A8787F4ABCF28")
    public boolean removeAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_904501731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_904501731;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.609 -0400", hash_original_method = "13D5AD766AE77320C3CF56AB2E9E5FB4", hash_generated_method = "624787EEE7A07BF4DDAD7FD9287C53D7")
    public boolean retainAll(Collection<?> c) {
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833303041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833303041;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.610 -0400", hash_original_method = "2DC914F9B3C538818482710C9EAD9EFB", hash_generated_method = "3A9B364CEAC26A46DDF1C484394CFF5C")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_200631904 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_200631904 = null;
        varB4EAC82CA7396A68D541C85D26508E83_200631904.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_200631904;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.727 -0400", hash_original_method = "0BB2C5BB97AA1323E2FE15E87216E7E9", hash_generated_method = "FC1A034EE9EACE5F66976FDF72A0C5E9")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_2073980598 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2073980598 = Collections.<E>emptySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_2073980598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2073980598;
        // ---------- Original Method ----------
        //return Collections.<E>emptySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.727 -0400", hash_original_method = "AAA5D1CBE91ADDEA174F65821E23BE58", hash_generated_method = "54EE59059CABE930AF750E387A2606C1")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_749611601 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_749611601 = EmptyArray.OBJECT;
        varB4EAC82CA7396A68D541C85D26508E83_749611601.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_749611601;
        // ---------- Original Method ----------
        //return EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.727 -0400", hash_original_method = "490A2A0CCABF1E39472F82358B033503", hash_generated_method = "846FAF594A2F73DE269A252DC4E3B879")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1986440284 = null; //Variable for return #1
        a[0] = null;
        varB4EAC82CA7396A68D541C85D26508E83_1986440284 = a;
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1986440284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1986440284;
        // ---------- Original Method ----------
        //if (a.length > 0)
            //a[0] = null;
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.733 -0400", hash_original_method = "B59D7BDF727183928F94F36988272CAC", hash_generated_method = "FED23AB0A90FB8D0252E6042B860A19F")
    public int drainTo(Collection<? super E> c) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1849804118 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        int n;
        n = 0;
        E e;
        {
            boolean var2F576A572403388DFCF1A0EB0F29376A_1156794494 = ((e = poll()) != null);
            {
                c.add(e);
            } //End block
        } //End collapsed parenthetic
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541626248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541626248;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.734 -0400", hash_original_method = "DA549833C1743125BAA2828712BD0C73", hash_generated_method = "49F92FEF0329D5008630B7FAD896C88F")
    public int drainTo(Collection<? super E> c, int maxElements) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_555151646 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        int n;
        n = 0;
        E e;
        {
            boolean var39506E481D804C0DC669E48A616AD818_992823613 = (n < maxElements && (e = poll()) != null);
            {
                c.add(e);
            } //End block
        } //End collapsed parenthetic
        addTaint(c.getTaint());
        addTaint(maxElements);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_950004987 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_950004987;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.746 -0400", hash_original_method = "7D89BB192BA936EC93EB72454855578A", hash_generated_method = "9DA79E5672B555D877523E25F2F6462B")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        boolean fair;
        fair = transferer instanceof TransferQueue;
        {
            qlock = new ReentrantLock(true);
            waitingProducers = new FifoWaitQueue();
            waitingConsumers = new FifoWaitQueue();
        } //End block
        {
            qlock = new ReentrantLock();
            waitingProducers = new LifoWaitQueue();
            waitingConsumers = new LifoWaitQueue();
        } //End block
        s.defaultWriteObject();
        addTaint(s.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.746 -0400", hash_original_method = "E156E82E550566200FEDBE52C0090F6F", hash_generated_method = "221738A97F236F02972DC9F5321F60CF")
    private void readObject(final java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        transferer = new TransferQueue();
        transferer = new TransferStack();
        addTaint(s.getTaint());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.747 -0400", hash_original_method = "09F8B62CD164A65EFE70D215172CE3CA", hash_generated_method = "09F8B62CD164A65EFE70D215172CE3CA")
        public Transferer ()
        {
            //Synthesized constructor
        }


        abstract Object transfer(Object e, boolean timed, long nanos);

        
    }


    
    static final class TransferStack extends Transferer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.747 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "228454E0E0F7F2A4C4B0260AD101A4CF")

        volatile SNode head;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.747 -0400", hash_original_method = "02B0885CE62BE77F872535266EC48EF9", hash_generated_method = "02B0885CE62BE77F872535266EC48EF9")
        public TransferStack ()
        {
            //Synthesized constructor
        }


                static boolean isFulfilling(int m) {
            return (m & FULFILLING) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.747 -0400", hash_original_method = "F38594CD80446D46D4DC59D46118C84B", hash_generated_method = "6EC6AF29DFB61CFC60677C84757CF2DA")
         boolean casHead(SNode h, SNode nh) {
            boolean var282379A22391D5E03F6F0D3EAE465E33_721908227 = (h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh));
            addTaint(h.getTaint());
            addTaint(nh.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_881368151 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_881368151;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.749 -0400", hash_original_method = "EF565BC8E8F2E2CD3218F549EBA67BF0", hash_generated_method = "B6B9899D5CE4FF151CEC5AF2FF6279D2")
         Object transfer(Object e, boolean timed, long nanos) {
            Object varB4EAC82CA7396A68D541C85D26508E83_56282322 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_909718818 = null; //Variable for return #2
            Object varB4EAC82CA7396A68D541C85D26508E83_753412773 = null; //Variable for return #3
            Object varB4EAC82CA7396A68D541C85D26508E83_406208725 = null; //Variable for return #4
            SNode s;
            s = null;
            int mode;
            mode = REQUEST;
            mode = DATA;
            {
                SNode h;
                h = head;
                {
                    {
                        {
                            boolean varAF0FEF72D29268ED4CF841ECB2A137E4_628966063 = (h != null && h.isCancelled());
                            casHead(h, h.next);
                            varB4EAC82CA7396A68D541C85D26508E83_56282322 = null;
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var614383346FD226DA87E63D0856A0A09B_936981194 = (casHead(h, s = snode(s, e, h, mode)));
                        {
                            SNode m;
                            m = awaitFulfill(s, timed, nanos);
                            {
                                clean(s);
                                varB4EAC82CA7396A68D541C85D26508E83_909718818 = null;
                            } //End block
                            {
                                boolean varCEABA499FA984A91272EEF573D762D61_240697572 = ((h = head) != null && h.next == s);
                                casHead(h, s.next);
                            } //End collapsed parenthetic
                            varB4EAC82CA7396A68D541C85D26508E83_753412773 = (mode == REQUEST) ? m.item : s.item;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var4218B438AD2FB275956E62AB7D82C855_1212392113 = (!isFulfilling(h.mode));
                    {
                        {
                            boolean var45FA36E500306668AF61900380872E2F_1417592731 = (h.isCancelled());
                            casHead(h, h.next);
                            {
                                boolean var56CD32B0D05B8BCEC4781DB0B808E9D4_480104390 = (casHead(h, s=snode(s, e, h, FULFILLING|mode)));
                                {
                                    {
                                        SNode m;
                                        m = s.next;
                                        {
                                            casHead(s, null);
                                            s = null;
                                        } //End block
                                        SNode mn;
                                        mn = m.next;
                                        {
                                            boolean varB1F893F63AA2BB92DE5336301E43E893_960275065 = (m.tryMatch(s));
                                            {
                                                casHead(s, mn);
                                                varB4EAC82CA7396A68D541C85D26508E83_406208725 = (mode == REQUEST) ? m.item : s.item;
                                            } //End block
                                            s.casNext(m, mn);
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    {
                        SNode m;
                        m = h.next;
                        casHead(h, null);
                        {
                            SNode mn;
                            mn = m.next;
                            {
                                boolean varBA066F30AE1F5BAF188C4FB69B8A094C_243003034 = (m.tryMatch(h));
                                casHead(h, mn);
                                h.casNext(m, mn);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(e.getTaint());
            addTaint(timed);
            addTaint(nanos);
            Object varA7E53CE21691AB073D9660D615818899_2142843442; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2142843442 = varB4EAC82CA7396A68D541C85D26508E83_56282322;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_2142843442 = varB4EAC82CA7396A68D541C85D26508E83_909718818;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_2142843442 = varB4EAC82CA7396A68D541C85D26508E83_753412773;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2142843442 = varB4EAC82CA7396A68D541C85D26508E83_406208725;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2142843442.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2142843442;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.765 -0400", hash_original_method = "8450123659E4F3E3FBDDF976A06B7608", hash_generated_method = "B4F949E21EB8A2BE0DD85B6E3AF9B535")
         SNode awaitFulfill(SNode s, boolean timed, long nanos) {
            SNode varB4EAC82CA7396A68D541C85D26508E83_849626857 = null; //Variable for return #1
            long lastTime;
            lastTime = System.nanoTime();
            lastTime = 0;
            Thread w;
            w = Thread.currentThread();
            SNode h;
            h = head;
            int spins;
            spins = (shouldSpin(s) ?
                         (timed ? maxTimedSpins : maxUntimedSpins) : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                {
                    boolean varE18A53653EF476A6AB7DE0F6C07F3E95_874052326 = (w.isInterrupted());
                    s.tryCancel();
                } //End collapsed parenthetic
                SNode m;
                m = s.match;
                varB4EAC82CA7396A68D541C85D26508E83_849626857 = m;
                {
                    long now;
                    now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    {
                        s.tryCancel();
                    } //End block
                } //End block
                spins = shouldSpin(s) ? (spins-1) : 0;
                s.waiter = w;
                LockSupport.park(this);
                LockSupport.parkNanos(this, nanos);
            } //End block
            addTaint(s.getTaint());
            addTaint(timed);
            addTaint(nanos);
            varB4EAC82CA7396A68D541C85D26508E83_849626857.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_849626857;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.766 -0400", hash_original_method = "C3C9887957CF791F525718002F2944FE", hash_generated_method = "00C2D6AB81DAED53B1C5A3379BAD2451")
         boolean shouldSpin(SNode s) {
            SNode h;
            h = head;
            boolean varC78E38E74D454B0C5F31FDF005C00FBD_120950457 = ((h == s || h == null || isFulfilling(h.mode)));
            addTaint(s.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518340671 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518340671;
            // ---------- Original Method ----------
            //SNode h = head;
            //return (h == s || h == null || isFulfilling(h.mode));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.766 -0400", hash_original_method = "162514ED54A955A73353466B6689AF5B", hash_generated_method = "5307D6E1F5730AE396156279FCA8BD57")
         void clean(SNode s) {
            s.item = null;
            s.waiter = null;
            SNode past;
            past = s.next;
            {
                boolean var4E37DAF71F369F48A6BA6D5D25162637_270063000 = (past != null && past.isCancelled());
                past = past.next;
            } //End collapsed parenthetic
            SNode p;
            {
                boolean varE83DFBC86BE14AC937698BA559B0E748_367012652 = ((p = head) != null && p != past && p.isCancelled());
                casHead(p, p.next);
            } //End collapsed parenthetic
            {
                SNode n;
                n = p.next;
                {
                    boolean varFA4190EAA665CEE1627963E04B8B5194_337507706 = (n != null && n.isCancelled());
                    p.casNext(n, n.next);
                    p = n;
                } //End collapsed parenthetic
            } //End block
            addTaint(s.getTaint());
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.767 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "51B8757B53C140AD03FA5839D28E2835")

            volatile SNode next;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.767 -0400", hash_original_field = "E3CC92C14A5E6DD1A7D94B6FF634D7FC", hash_generated_field = "6CEC32C9039E66F4CB3AFBF850A69E68")

            volatile SNode match;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.767 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.768 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "CF812EE2AD9BC4EAA8B11FCCEDAE3ADB")

            Object item;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.768 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "462D02655D7DD7DF6E5BA12D65851DD2")

            int mode;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.768 -0400", hash_original_method = "1B0B8D11CB10F0B4CCAA4D8835EC421B", hash_generated_method = "CF1397AC3B88B93FEFBB222BFAAE5E40")
              SNode(Object item) {
                this.item = item;
                // ---------- Original Method ----------
                //this.item = item;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.782 -0400", hash_original_method = "265B3E666AD76F55078AE9E7E3AE351C", hash_generated_method = "0A9934684EF70B0C4E662CB523055E53")
             boolean casNext(SNode cmp, SNode val) {
                boolean var177A136DD6EC4DAC0D9ACF118160DDB7_1412826719 = (cmp == next &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                addTaint(cmp.getTaint());
                addTaint(val.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451645385 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_451645385;
                // ---------- Original Method ----------
                //return cmp == next &&
                    //UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.782 -0400", hash_original_method = "CEB4EA3334013C3454101E56EFA00D65", hash_generated_method = "637E363A61CF22CE2A94065D49DAD9C5")
             boolean tryMatch(SNode s) {
                {
                    boolean var6711BCB91C5006023132439F2128DD98_942925484 = (match == null &&
                    UNSAFE.compareAndSwapObject(this, matchOffset, null, s));
                    {
                        Thread w;
                        w = waiter;
                        {
                            waiter = null;
                            LockSupport.unpark(w);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                addTaint(s.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1552768675 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1552768675;
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_method = "4364F2F312C8CE7EEFC1A24A7BE396DF", hash_generated_method = "F113C1DDE10ED16910489434287E4197")
             void tryCancel() {
                UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
                // ---------- Original Method ----------
                //UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_method = "BB4CEE3409ECC1A047D42B262CFDD801", hash_generated_method = "E522056BA76C390DBDB7D0E7C6D8D602")
             boolean isCancelled() {
                boolean var7F5D65803B47A70559075CCD6D448518_1677864508 = (match == this);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1848238547 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1848238547;
                // ---------- Original Method ----------
                //return match == this;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "C80AC2E3A7FB8F5C36B566CB2C09667F")

            private static sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_field = "8234D14DA629F1B33BC3BF468BFC1AAE", hash_generated_field = "CC80CB6013C5B7FDCD0BA05DF6C51E3A")

            private static long nextOffset = objectFieldOffset(UNSAFE, "next", SNode.class);
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_field = "CD74A71824B260054518EC8AEE7963D3", hash_generated_field = "CC9A0A42F7EFB851409996FD879B0C5E")

            private static long matchOffset = objectFieldOffset(UNSAFE, "match", SNode.class);
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_field = "00901407DB520A6DA0C4ED8316299BA6", hash_generated_field = "7D3D75AB37A6BC0E94BC61626F849AE0")

        static int REQUEST = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_field = "76AD11A457B8D4D9AA18A779A31A8BFF", hash_generated_field = "D3EF4BADC561E0D6EE723F4475BE8398")

        static int DATA = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_field = "5E06EC816761815F086BAFA71AC08DF4", hash_generated_field = "7F5A3AE2E155E5426DC3968450904896")

        static int FULFILLING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "C80AC2E3A7FB8F5C36B566CB2C09667F")

        private static sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.783 -0400", hash_original_field = "D060AADCA72F1E682132007013486754", hash_generated_field = "65F832C42F4591D98CE163BAAA12DAAC")

        private static long headOffset = objectFieldOffset(UNSAFE, "head", TransferStack.class);
    }


    
    static final class TransferQueue extends Transferer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.788 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "8B563AA5A75BA53BC5C38CBCB00877BD")

        transient volatile QNode head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.788 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "28504BE4CF28FABF51A5115491756D5B")

        transient volatile QNode tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.788 -0400", hash_original_field = "15D477186674E9EC651EC7D91C1367FE", hash_generated_field = "11DAC5D336C0CE8D6AABAA86A736FB77")

        transient volatile QNode cleanMe;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.791 -0400", hash_original_method = "EBB3C2235277D03D49EE8D8BB02DD64A", hash_generated_method = "AA297A2B6833D5627D4DA67C52BF1848")
          TransferQueue() {
            QNode h;
            h = new QNode(null, false);
            head = h;
            tail = h;
            // ---------- Original Method ----------
            //QNode h = new QNode(null, false);
            //head = h;
            //tail = h;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.800 -0400", hash_original_method = "80B021B7B5DA5B6F1F69021D0C7D6F89", hash_generated_method = "FDD14160B1E6BB2ABD862260541E1F4A")
         void advanceHead(QNode h, QNode nh) {
            {
                boolean varA1699559793DFF39D27BE01166D10E99_3348823 = (h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh));
                h.next = h;
            } //End collapsed parenthetic
            addTaint(h.getTaint());
            addTaint(nh.getTaint());
            // ---------- Original Method ----------
            //if (h == head &&
                //UNSAFE.compareAndSwapObject(this, headOffset, h, nh))
                //h.next = h;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.801 -0400", hash_original_method = "8E334B9D021C7CA1D4C0B314F9C4B69F", hash_generated_method = "52615D8D66692BA26F5D61E0B21B554A")
         void advanceTail(QNode t, QNode nt) {
            UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
            addTaint(t.getTaint());
            addTaint(nt.getTaint());
            // ---------- Original Method ----------
            //if (tail == t)
                //UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.801 -0400", hash_original_method = "7A9E3B63F4597B524322C45DD727A635", hash_generated_method = "1AA51AD070A296F76F83C59DF79AEBCF")
         boolean casCleanMe(QNode cmp, QNode val) {
            boolean var65FAFD82FA2D6EE7BE39B31A73009EBD_559586790 = (cleanMe == cmp &&
                UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val));
            addTaint(cmp.getTaint());
            addTaint(val.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126307700 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126307700;
            // ---------- Original Method ----------
            //return cleanMe == cmp &&
                //UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.813 -0400", hash_original_method = "D9295193CC3F280F47A7E51B4594CC44", hash_generated_method = "E4D92918DF948296856328F019BF8310")
         Object transfer(Object e, boolean timed, long nanos) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1854508017 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1158259349 = null; //Variable for return #2
            Object varB4EAC82CA7396A68D541C85D26508E83_1193961458 = null; //Variable for return #3
            Object varB4EAC82CA7396A68D541C85D26508E83_1832700937 = null; //Variable for return #4
            QNode s;
            s = null;
            boolean isData;
            isData = (e != null);
            {
                QNode t;
                t = tail;
                QNode h;
                h = head;
                {
                    QNode tn;
                    tn = t.next;
                    {
                        advanceTail(t, tn);
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_1854508017 = null;
                    s = new QNode(e, isData);
                    {
                        boolean var2D6D1EC910A75C1BE0BDF8DC15A993BD_1006314802 = (!t.casNext(null, s));
                    } //End collapsed parenthetic
                    advanceTail(t, s);
                    Object x;
                    x = awaitFulfill(s, e, timed, nanos);
                    {
                        clean(t, s);
                        varB4EAC82CA7396A68D541C85D26508E83_1158259349 = null;
                    } //End block
                    {
                        boolean var49DCCE4E1014EF8A97A0B4DE6D6A07F5_1069280217 = (!s.isOffList());
                        {
                            advanceHead(t, s);
                            s.item = s;
                            s.waiter = null;
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1193961458 = (x != null) ? x : e;
                } //End block
                {
                    QNode m;
                    m = h.next;
                    Object x;
                    x = m.item;
                    {
                        boolean var9A5DF2A846D139F665EDBC74399D4235_1511742703 = (isData == (x != null) ||    
                        x == m ||                   
                        !m.casItem(x, e));
                        {
                            advanceHead(h, m);
                        } //End block
                    } //End collapsed parenthetic
                    advanceHead(h, m);
                    LockSupport.unpark(m.waiter);
                    varB4EAC82CA7396A68D541C85D26508E83_1832700937 = (x != null) ? x : e;
                } //End block
            } //End block
            addTaint(e.getTaint());
            addTaint(timed);
            addTaint(nanos);
            Object varA7E53CE21691AB073D9660D615818899_1808565506; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1808565506 = varB4EAC82CA7396A68D541C85D26508E83_1854508017;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1808565506 = varB4EAC82CA7396A68D541C85D26508E83_1158259349;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_1808565506 = varB4EAC82CA7396A68D541C85D26508E83_1193961458;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1808565506 = varB4EAC82CA7396A68D541C85D26508E83_1832700937;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1808565506.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1808565506;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.814 -0400", hash_original_method = "90C8A09C09ECF2EF83975D209FFEEF37", hash_generated_method = "FF36363C78B15C37FC29E60AF75FF7B9")
         Object awaitFulfill(QNode s, Object e, boolean timed, long nanos) {
            Object varB4EAC82CA7396A68D541C85D26508E83_791067876 = null; //Variable for return #1
            long lastTime;
            lastTime = System.nanoTime();
            lastTime = 0;
            Thread w;
            w = Thread.currentThread();
            int spins;
            spins = ((head.next == s) ?
                         (timed ? maxTimedSpins : maxUntimedSpins) : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                {
                    boolean varE18A53653EF476A6AB7DE0F6C07F3E95_1443916068 = (w.isInterrupted());
                    s.tryCancel(e);
                } //End collapsed parenthetic
                Object x;
                x = s.item;
                varB4EAC82CA7396A68D541C85D26508E83_791067876 = x;
                {
                    long now;
                    now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                    {
                        s.tryCancel(e);
                    } //End block
                } //End block
                s.waiter = w;
                LockSupport.park(this);
                LockSupport.parkNanos(this, nanos);
            } //End block
            addTaint(s.getTaint());
            addTaint(e.getTaint());
            addTaint(timed);
            addTaint(nanos);
            varB4EAC82CA7396A68D541C85D26508E83_791067876.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_791067876;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.821 -0400", hash_original_method = "6683A876B1B30ADB5D756618BABF762A", hash_generated_method = "69DA2F998537E29A702CE39F4E7F95C8")
         void clean(QNode pred, QNode s) {
            s.waiter = null;
            {
                QNode h;
                h = head;
                QNode hn;
                hn = h.next;
                {
                    boolean var90BBDE8A0ACDED3C7351797369CBD741_358837563 = (hn != null && hn.isCancelled());
                    {
                        advanceHead(h, hn);
                    } //End block
                } //End collapsed parenthetic
                QNode t;
                t = tail;
                QNode tn;
                tn = t.next;
                {
                    advanceTail(t, tn);
                } //End block
                {
                    QNode sn;
                    sn = s.next;
                    {
                        boolean var9EC0578845E9330F648DFD38BF8851EE_1187359336 = (sn == s || pred.casNext(s, sn));
                    } //End collapsed parenthetic
                } //End block
                QNode dp;
                dp = cleanMe;
                {
                    QNode d;
                    d = dp.next;
                    QNode dn;
                    {
                        boolean var981072472C7ACBE6D966E74F0BA25D4D_1029467121 = (d == null ||               
                        d == dp ||                 
                        !d.isCancelled() ||        
                        (d != t &&                 
                         (dn = d.next) != null &&  
                         dn != d &&                
                         dp.casNext(d, dn)));
                        casCleanMe(dp, null);
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varF92453FEDC3A2CB53C1EB52CDEA2A7A0_358049292 = (casCleanMe(null, pred));
                } //End collapsed parenthetic
            } //End block
            addTaint(pred.getTaint());
            addTaint(s.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        static final class QNode {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.821 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "98C54C1386619AED777FF36204F4724D")

            volatile QNode next;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.822 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "572C92874AD4D49E8D97420DECC4EA3C")

            volatile Object item;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.824 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "3ADD07942E4DBB62254A2C8B45EF09E9")

            volatile Thread waiter;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.824 -0400", hash_original_field = "CC995F2BD435828CA793B1399F0CD031", hash_generated_field = "13998CD9DB54AD99E9DAFA28EE2691E9")

            boolean isData;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.825 -0400", hash_original_method = "36E0BDE690B9319BBAE39AE7BB5AED99", hash_generated_method = "AC79B184894CD3D93DB04113A86F071F")
              QNode(Object item, boolean isData) {
                this.item = item;
                this.isData = isData;
                // ---------- Original Method ----------
                //this.item = item;
                //this.isData = isData;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.839 -0400", hash_original_method = "611C5C34CB4DC255784715588EF3B5E5", hash_generated_method = "0A5E4A4322EE4362E783DDF5371C501D")
             boolean casNext(QNode cmp, QNode val) {
                boolean var17EA7A1AF3964F578962ECF95DC323BD_1568990864 = (next == cmp &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                addTaint(cmp.getTaint());
                addTaint(val.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164344584 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_164344584;
                // ---------- Original Method ----------
                //return next == cmp &&
                    //UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.839 -0400", hash_original_method = "3912AD02565B809FB80AB4089D0BD0C1", hash_generated_method = "990926736896BBFACC556715116C182F")
             boolean casItem(Object cmp, Object val) {
                boolean varA0F2A8A326F7E81A747BE437A925260E_626549352 = (item == cmp &&
                    UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val));
                addTaint(cmp.getTaint());
                addTaint(val.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811824462 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_811824462;
                // ---------- Original Method ----------
                //return item == cmp &&
                    //UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.840 -0400", hash_original_method = "99C72522BA0C395099FBEE5F0489DB78", hash_generated_method = "E2C6ECF6C71997A06DF967CE44B0E11D")
             void tryCancel(Object cmp) {
                UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
                addTaint(cmp.getTaint());
                // ---------- Original Method ----------
                //UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.840 -0400", hash_original_method = "45E5A9573D9BA1D0D86064CD1643198D", hash_generated_method = "73B292ECF24A934006FB8C0B00820B6D")
             boolean isCancelled() {
                boolean varA64503E11EBD2041198E2D58A05084A8_774704410 = (item == this);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1824664083 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1824664083;
                // ---------- Original Method ----------
                //return item == this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.840 -0400", hash_original_method = "355DAB50A3ED00DA4B9C20D2E0EF6792", hash_generated_method = "6CF57F1FACCC8AFBC8C90084F403233A")
             boolean isOffList() {
                boolean varB6C5D4B086DE21F098503EC790F4AB8E_1652192804 = (next == this);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087864971 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087864971;
                // ---------- Original Method ----------
                //return next == this;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "C80AC2E3A7FB8F5C36B566CB2C09667F")

            private static sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_field = "8A1148CE2B27855448692F0F42095BC9", hash_generated_field = "241DB180C7C497361237D88446A6D9F7")

            private static long nextOffset = objectFieldOffset(UNSAFE, "next", QNode.class);
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_field = "699D04D68ED73F0F2E1CD32D8C6F109A", hash_generated_field = "4D2CF21778C3475FFD597D69B0ED7C04")

            private static long itemOffset = objectFieldOffset(UNSAFE, "item", QNode.class);
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "C80AC2E3A7FB8F5C36B566CB2C09667F")

        private static sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_field = "70027F0D0522D2B8178D239E338F6B3B", hash_generated_field = "C40F367F83DA1FECAF234E6DAD5A5156")

        private static long headOffset = objectFieldOffset(UNSAFE, "head", TransferQueue.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_field = "FAC26A70E3A7365830A659E724196AC7", hash_generated_field = "2C748828BD9E1EE9144BD252F2FB6B2F")

        private static long tailOffset = objectFieldOffset(UNSAFE, "tail", TransferQueue.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_field = "1259B870E41DF8C457DF64A6F063E913", hash_generated_field = "7314C5B61B11CDC3322CE5109AF9D0C2")

        private static long cleanMeOffset = objectFieldOffset(UNSAFE, "cleanMe", TransferQueue.class);
    }


    
    static class WaitQueue implements java.io.Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_method = "A66BE88BE66C40BD12237E932077BBFA", hash_generated_method = "A66BE88BE66C40BD12237E932077BBFA")
        public WaitQueue ()
        {
            //Synthesized constructor
        }


    }


    
    static class LifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_method = "2AB7A8E9C876B74C36AEA136750E93EA", hash_generated_method = "2AB7A8E9C876B74C36AEA136750E93EA")
        public LifoWaitQueue ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_field = "538748F7DEB6C55C97A19BE3C95E9A81", hash_generated_field = "8CB6BFD5EC2C5EE4B35C919E0AF8BCF3")

        private static long serialVersionUID = -3633113410248163686L;
    }


    
    static class FifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.841 -0400", hash_original_method = "2B3543573D85E46D74937DE2E36C8335", hash_generated_method = "2B3543573D85E46D74937DE2E36C8335")
        public FifoWaitQueue ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.842 -0400", hash_original_field = "9697A0ABD2AF5BBA3DD90C1E1CD4F6C6", hash_generated_field = "0F476E9A24D0B232C80FBBFF2D85B0F5")

        private static long serialVersionUID = -3623113410248163686L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.842 -0400", hash_original_field = "4CA9EACFC32D88A9A4CD6E0A1BDAB9E4", hash_generated_field = "7FC00CA84C3B0B88DEEB434BC3622C60")

    private static long serialVersionUID = -3223113410248163686L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.842 -0400", hash_original_field = "9D5D4F5356672663FE82C5BD31BC60BF", hash_generated_field = "E6EEAF34DB40D95225C067A347550DB8")

    static int NCPUS = Runtime.getRuntime().availableProcessors();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.842 -0400", hash_original_field = "B5216FBF1314B0080661A4EF51C6B5C7", hash_generated_field = "73A2DA70698764D33C2AE3596EDE8967")

    static int maxTimedSpins = (NCPUS < 2) ? 0 : 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.842 -0400", hash_original_field = "5B48E17B478EADCDB689A1C63CCA9BAC", hash_generated_field = "C13061A07A62C5ABFF46A748F18EFDBF")

    static int maxUntimedSpins = maxTimedSpins * 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.842 -0400", hash_original_field = "97826F3E2403B559BA27663CADCEE60A", hash_generated_field = "42D7443A34CE217AF48A02C17C1FAF6D")

    static long spinForTimeoutThreshold = 1000L;
}

