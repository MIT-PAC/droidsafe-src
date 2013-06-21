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
    private transient volatile Transferer transferer;
    private ReentrantLock qlock;
    private WaitQueue waitingProducers;
    private WaitQueue waitingConsumers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.867 -0400", hash_original_method = "CA3CB3D951221FCCF0DFF3BB5DF12346", hash_generated_method = "5255A939CCFA97D45156B8A4109C3AE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SynchronousQueue() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.867 -0400", hash_original_method = "2A4F416DA0F8363F009FD8DA8EB74A84", hash_generated_method = "77C2918E1CF77704CB1E1E72DB0D1C41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SynchronousQueue(boolean fair) {
        dsTaint.addTaint(fair);
        transferer = fair ? new TransferQueue() : new TransferStack();
        // ---------- Original Method ----------
        //transferer = fair ? new TransferQueue() : new TransferStack();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.867 -0400", hash_original_method = "C65E97EC40BB31D50DB029B0D4F47DF5", hash_generated_method = "F0AB88BFFF36F5D10FD9C26672DD8B2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(E o) throws InterruptedException {
        dsTaint.addTaint(o.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var7607C5756161FCDCDBD28D01FED3953C_140317752 = (transferer.transfer(o, false, 0) == null);
            {
                Thread.interrupted();
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (o == null) throw new NullPointerException();
        //if (transferer.transfer(o, false, 0) == null) {
            //Thread.interrupted();
            //throw new InterruptedException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.868 -0400", hash_original_method = "3A6AFFAA000C17EA73FBC10B0EC018FD", hash_generated_method = "F600D7815C6C30CE44DAF01F38D27620")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E o, long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(timeout);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean varF1825FBBB753F22C73534A88EB505062_880728917 = (transferer.transfer(o, true, unit.toNanos(timeout)) != null);
        } //End collapsed parenthetic
        {
            boolean var7802430CC9FA3C264EA55E37D5C0452C_963544822 = (!Thread.interrupted());
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == null) throw new NullPointerException();
        //if (transferer.transfer(o, true, unit.toNanos(timeout)) != null)
            //return true;
        //if (!Thread.interrupted())
            //return false;
        //throw new InterruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.868 -0400", hash_original_method = "A4F84C12941B1214559E662FB5D2360B", hash_generated_method = "44AE1E53C7315D24A0FB07227C4A6FAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E e) {
        dsTaint.addTaint(e.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        boolean varE546A568DD0E1DA7331DA7BD0D817F43_2127511347 = (transferer.transfer(e, true, 0) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //return transferer.transfer(e, true, 0) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.868 -0400", hash_original_method = "A59182A477060C80E9C0D7B7DD2CA2C3", hash_generated_method = "9617E3056B836007E49A9150189CCBFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E take() throws InterruptedException {
        Object e;
        e = transferer.transfer(null, false, 0);
        Thread.interrupted();
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object e = transferer.transfer(null, false, 0);
        //if (e != null)
            //return (E)e;
        //Thread.interrupted();
        //throw new InterruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.868 -0400", hash_original_method = "F80BFD27E2D553DA44FF7C91997050D6", hash_generated_method = "4E234C3B2CA6D4A4BBEBC8FEDD0530AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        Object e;
        e = transferer.transfer(null, true, unit.toNanos(timeout));
        {
            boolean varC564A7C2CC52E9BBB2AF6FB9F10A266F_455525853 = (e != null || !Thread.interrupted());
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object e = transferer.transfer(null, true, unit.toNanos(timeout));
        //if (e != null || !Thread.interrupted())
            //return (E)e;
        //throw new InterruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.868 -0400", hash_original_method = "1663F66628103F625AD11623448BFB1D", hash_generated_method = "7957A2FDE079F19EA5374AE529E20935")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll() {
        E var31BCE523A42AB12E71BA5240AA8CD19A_1741375232 = ((E)transferer.transfer(null, true, 0));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (E)transferer.transfer(null, true, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.869 -0400", hash_original_method = "9A172AFBEDC6074FE36DA0C4940853DE", hash_generated_method = "B40A56283385075B1426B53BC8305BF8")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.869 -0400", hash_original_method = "F4586E3A64B5D10DEB709A723C85E55E", hash_generated_method = "F836FE49D22A2F6A90B7980C68961304")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.869 -0400", hash_original_method = "859254362B8CFD4ECD77710B77AC10ED", hash_generated_method = "F69F9A77C733706BF89E8C05D496EE00")
    @DSModeled(DSC.SAFE)
    public int remainingCapacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.869 -0400", hash_original_method = "CAFED8DEE3108243325B67F5797719ED", hash_generated_method = "62E208A158681C1F982FD616252404DD")
    @DSModeled(DSC.SAFE)
    public void clear() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.869 -0400", hash_original_method = "133415712E6841A0903588DC5D4862AA", hash_generated_method = "40F1D1C997D2106004A6817564300BBD")
    @DSModeled(DSC.SAFE)
    public boolean contains(Object o) {
        dsTaint.addTaint(o.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.869 -0400", hash_original_method = "6081257F3AE1D633C77BCA63D6F77CB7", hash_generated_method = "7016A39CCCD110204C2E2147DA749648")
    @DSModeled(DSC.SAFE)
    public boolean remove(Object o) {
        dsTaint.addTaint(o.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.870 -0400", hash_original_method = "C503BED5AF377C63A87B0C398CACB95B", hash_generated_method = "E4B7BF4538F8FC995B4F88C7FEEC903B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsAll(Collection<?> c) {
        dsTaint.addTaint(c.dsTaint);
        boolean varC1DF46038608BCBF5C56CAC54A25A9EA_764795408 = (c.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return c.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.870 -0400", hash_original_method = "EC0A570B588D76D8968190A1BD3D4040", hash_generated_method = "D2D114AF29E7B4E6312394879AA705C1")
    @DSModeled(DSC.SAFE)
    public boolean removeAll(Collection<?> c) {
        dsTaint.addTaint(c.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.870 -0400", hash_original_method = "13D5AD766AE77320C3CF56AB2E9E5FB4", hash_generated_method = "0245C2700464F6C8F029099E2888E34A")
    @DSModeled(DSC.SAFE)
    public boolean retainAll(Collection<?> c) {
        dsTaint.addTaint(c.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.870 -0400", hash_original_method = "2DC914F9B3C538818482710C9EAD9EFB", hash_generated_method = "1EC0EE83348B2ACA5F1E33663E3D9719")
    @DSModeled(DSC.SAFE)
    public E peek() {
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.870 -0400", hash_original_method = "0BB2C5BB97AA1323E2FE15E87216E7E9", hash_generated_method = "7CF7ED8860CFAB746225925DACCCC7A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<E> iterator() {
        Iterator<E> varB71BDDC4CC259640BBB8A0FCB65B6B63_652074580 = (Collections.<E>emptySet().iterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.<E>emptySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.870 -0400", hash_original_method = "AAA5D1CBE91ADDEA174F65821E23BE58", hash_generated_method = "DF2BF92824C45B895CA22FF938CECFE5")
    @DSModeled(DSC.SAFE)
    public Object[] toArray() {
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.871 -0400", hash_original_method = "490A2A0CCABF1E39472F82358B033503", hash_generated_method = "CA4DF704846ABB038FBCA83429D92B4C")
    @DSModeled(DSC.SAFE)
    public <T> T[] toArray(T[] a) {
        dsTaint.addTaint(a[0].dsTaint);
        a[0] = null;
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (a.length > 0)
            //a[0] = null;
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.871 -0400", hash_original_method = "B59D7BDF727183928F94F36988272CAC", hash_generated_method = "4A976576A88E82CE3F716C7EA5963E36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int drainTo(Collection<? super E> c) {
        dsTaint.addTaint(c.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_64042448 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        int n;
        n = 0;
        E e;
        {
            boolean var2F576A572403388DFCF1A0EB0F29376A_424712906 = ((e = poll()) != null);
            {
                c.add(e);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.871 -0400", hash_original_method = "DA549833C1743125BAA2828712BD0C73", hash_generated_method = "2292C36B63F1EFC947A67BF2C70A8700")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int drainTo(Collection<? super E> c, int maxElements) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(maxElements);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1730216167 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        int n;
        n = 0;
        E e;
        {
            boolean var39506E481D804C0DC669E48A616AD818_1719839211 = (n < maxElements && (e = poll()) != null);
            {
                c.add(e);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.872 -0400", hash_original_method = "7D89BB192BA936EC93EB72454855578A", hash_generated_method = "57263CC9AFD6B6E368C87F31D2036EAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        dsTaint.addTaint(s.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.872 -0400", hash_original_method = "E156E82E550566200FEDBE52C0090F6F", hash_generated_method = "0BA558F53B2E916026F489461BE30250")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(final java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultReadObject();
        transferer = new TransferQueue();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.873 -0400", hash_original_method = "A2B65F896449ECE39285AB051EFDD068", hash_generated_method = "A2B65F896449ECE39285AB051EFDD068")
                public Transferer ()
        {
        }


        abstract Object transfer(Object e, boolean timed, long nanos);

        
    }


    
    static final class TransferStack extends Transferer {
        volatile SNode head;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.874 -0400", hash_original_method = "BFB3767719B7C76846348908E2892F6D", hash_generated_method = "BFB3767719B7C76846348908E2892F6D")
                public TransferStack ()
        {
        }


                static boolean isFulfilling(int m) {
            return (m & FULFILLING) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.875 -0400", hash_original_method = "F38594CD80446D46D4DC59D46118C84B", hash_generated_method = "E18FD7D67106CB87A5D4EAF1C8902433")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean casHead(SNode h, SNode nh) {
            dsTaint.addTaint(nh.dsTaint);
            dsTaint.addTaint(h.dsTaint);
            boolean var282379A22391D5E03F6F0D3EAE465E33_2030955840 = (h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh));
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.876 -0400", hash_original_method = "EF565BC8E8F2E2CD3218F549EBA67BF0", hash_generated_method = "E50DFCFF6E77280EC38F8DB329ABF2DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Object transfer(Object e, boolean timed, long nanos) {
            dsTaint.addTaint(nanos);
            dsTaint.addTaint(timed);
            dsTaint.addTaint(e.dsTaint);
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
                            boolean varAF0FEF72D29268ED4CF841ECB2A137E4_1339860117 = (h != null && h.isCancelled());
                            casHead(h, h.next);
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var614383346FD226DA87E63D0856A0A09B_632152761 = (casHead(h, s = snode(s, e, h, mode)));
                        {
                            SNode m;
                            m = awaitFulfill(s, timed, nanos);
                            {
                                clean(s);
                            } //End block
                            {
                                boolean varCEABA499FA984A91272EEF573D762D61_897619953 = ((h = head) != null && h.next == s);
                                casHead(h, s.next);
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var4218B438AD2FB275956E62AB7D82C855_2047235268 = (!isFulfilling(h.mode));
                    {
                        {
                            boolean var45FA36E500306668AF61900380872E2F_1976784282 = (h.isCancelled());
                            casHead(h, h.next);
                            {
                                boolean var56CD32B0D05B8BCEC4781DB0B808E9D4_433860179 = (casHead(h, s=snode(s, e, h, FULFILLING|mode)));
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
                                            boolean varB1F893F63AA2BB92DE5336301E43E893_1228057932 = (m.tryMatch(s));
                                            {
                                                casHead(s, mn);
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
                                boolean varBA066F30AE1F5BAF188C4FB69B8A094C_1877783392 = (m.tryMatch(h));
                                casHead(h, mn);
                                h.casNext(m, mn);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.877 -0400", hash_original_method = "8450123659E4F3E3FBDDF976A06B7608", hash_generated_method = "5680C378E6A757A523ECD32E034A6552")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SNode awaitFulfill(SNode s, boolean timed, long nanos) {
            dsTaint.addTaint(nanos);
            dsTaint.addTaint(timed);
            dsTaint.addTaint(s.dsTaint);
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
                    boolean varE18A53653EF476A6AB7DE0F6C07F3E95_464977577 = (w.isInterrupted());
                    s.tryCancel();
                } //End collapsed parenthetic
                SNode m;
                m = s.match;
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
            return (SNode)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.877 -0400", hash_original_method = "C3C9887957CF791F525718002F2944FE", hash_generated_method = "A9E50464231297A4723266749E3DB552")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean shouldSpin(SNode s) {
            dsTaint.addTaint(s.dsTaint);
            SNode h;
            h = head;
            boolean varC78E38E74D454B0C5F31FDF005C00FBD_987593819 = ((h == s || h == null || isFulfilling(h.mode)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //SNode h = head;
            //return (h == s || h == null || isFulfilling(h.mode));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.878 -0400", hash_original_method = "162514ED54A955A73353466B6689AF5B", hash_generated_method = "D27361AEF4D6F8594629554251E5387E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void clean(SNode s) {
            dsTaint.addTaint(s.dsTaint);
            s.item = null;
            s.waiter = null;
            SNode past;
            past = s.next;
            {
                boolean var4E37DAF71F369F48A6BA6D5D25162637_818783693 = (past != null && past.isCancelled());
                past = past.next;
            } //End collapsed parenthetic
            SNode p;
            {
                boolean varE83DFBC86BE14AC937698BA559B0E748_1911441959 = ((p = head) != null && p != past && p.isCancelled());
                casHead(p, p.next);
            } //End collapsed parenthetic
            {
                SNode n;
                n = p.next;
                {
                    boolean varFA4190EAA665CEE1627963E04B8B5194_309420078 = (n != null && n.isCancelled());
                    p.casNext(n, n.next);
                    p = n;
                } //End collapsed parenthetic
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
            volatile SNode next;
            volatile SNode match;
            volatile Thread waiter;
            Object item;
            int mode;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.878 -0400", hash_original_method = "1B0B8D11CB10F0B4CCAA4D8835EC421B", hash_generated_method = "BB4722E4927AD9785D7FB416487F2DC6")
            @DSModeled(DSC.SAFE)
             SNode(Object item) {
                dsTaint.addTaint(item.dsTaint);
                // ---------- Original Method ----------
                //this.item = item;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.878 -0400", hash_original_method = "265B3E666AD76F55078AE9E7E3AE351C", hash_generated_method = "5B4CDBB73ED16565E58405AB60F56250")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             boolean casNext(SNode cmp, SNode val) {
                dsTaint.addTaint(val.dsTaint);
                dsTaint.addTaint(cmp.dsTaint);
                boolean var177A136DD6EC4DAC0D9ACF118160DDB7_2005375496 = (cmp == next &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return cmp == next &&
                    //UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.878 -0400", hash_original_method = "CEB4EA3334013C3454101E56EFA00D65", hash_generated_method = "BCA3ABEB227450BEAA508361D4EDBE60")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             boolean tryMatch(SNode s) {
                dsTaint.addTaint(s.dsTaint);
                {
                    boolean var6711BCB91C5006023132439F2128DD98_1689536202 = (match == null &&
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
                return dsTaint.getTaintBoolean();
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.879 -0400", hash_original_method = "4364F2F312C8CE7EEFC1A24A7BE396DF", hash_generated_method = "F113C1DDE10ED16910489434287E4197")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             void tryCancel() {
                UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
                // ---------- Original Method ----------
                //UNSAFE.compareAndSwapObject(this, matchOffset, null, this);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.879 -0400", hash_original_method = "BB4CEE3409ECC1A047D42B262CFDD801", hash_generated_method = "20E9122904FDD7D3B63100C4C1ED9F99")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             boolean isCancelled() {
                boolean var7F5D65803B47A70559075CCD6D448518_1160225823 = (match == this);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return match == this;
            }

            
            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            private static final long nextOffset =
                objectFieldOffset(UNSAFE, "next", SNode.class);
            private static final long matchOffset =
                objectFieldOffset(UNSAFE, "match", SNode.class);
        }


        
        static final int REQUEST    = 0;
        static final int DATA       = 1;
        static final int FULFILLING = 2;
        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        private static final long headOffset =
            objectFieldOffset(UNSAFE, "head", TransferStack.class);
    }


    
    static final class TransferQueue extends Transferer {
        transient volatile QNode head;
        transient volatile QNode tail;
        transient volatile QNode cleanMe;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.879 -0400", hash_original_method = "EBB3C2235277D03D49EE8D8BB02DD64A", hash_generated_method = "AA297A2B6833D5627D4DA67C52BF1848")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.879 -0400", hash_original_method = "80B021B7B5DA5B6F1F69021D0C7D6F89", hash_generated_method = "8CB755FDC22C882C4E4E87C106D42160")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void advanceHead(QNode h, QNode nh) {
            dsTaint.addTaint(nh.dsTaint);
            dsTaint.addTaint(h.dsTaint);
            {
                boolean varA1699559793DFF39D27BE01166D10E99_1182589188 = (h == head &&
                UNSAFE.compareAndSwapObject(this, headOffset, h, nh));
                h.next = h;
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (h == head &&
                //UNSAFE.compareAndSwapObject(this, headOffset, h, nh))
                //h.next = h;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.879 -0400", hash_original_method = "8E334B9D021C7CA1D4C0B314F9C4B69F", hash_generated_method = "168DEEB613AE892D2C27EE7DD20C6CE5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void advanceTail(QNode t, QNode nt) {
            dsTaint.addTaint(nt.dsTaint);
            dsTaint.addTaint(t.dsTaint);
            UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
            // ---------- Original Method ----------
            //if (tail == t)
                //UNSAFE.compareAndSwapObject(this, tailOffset, t, nt);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.880 -0400", hash_original_method = "7A9E3B63F4597B524322C45DD727A635", hash_generated_method = "FDB91CCCC8139F23817E32BACECEECC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean casCleanMe(QNode cmp, QNode val) {
            dsTaint.addTaint(val.dsTaint);
            dsTaint.addTaint(cmp.dsTaint);
            boolean var65FAFD82FA2D6EE7BE39B31A73009EBD_211797773 = (cleanMe == cmp &&
                UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return cleanMe == cmp &&
                //UNSAFE.compareAndSwapObject(this, cleanMeOffset, cmp, val);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.880 -0400", hash_original_method = "D9295193CC3F280F47A7E51B4594CC44", hash_generated_method = "B7864C3AAA0413099C2205E13199C6C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Object transfer(Object e, boolean timed, long nanos) {
            dsTaint.addTaint(nanos);
            dsTaint.addTaint(timed);
            dsTaint.addTaint(e.dsTaint);
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
                    s = new QNode(e, isData);
                    {
                        boolean var2D6D1EC910A75C1BE0BDF8DC15A993BD_1458181690 = (!t.casNext(null, s));
                    } //End collapsed parenthetic
                    advanceTail(t, s);
                    Object x;
                    x = awaitFulfill(s, e, timed, nanos);
                    {
                        clean(t, s);
                    } //End block
                    {
                        boolean var49DCCE4E1014EF8A97A0B4DE6D6A07F5_1601820275 = (!s.isOffList());
                        {
                            advanceHead(t, s);
                            s.item = s;
                            s.waiter = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    QNode m;
                    m = h.next;
                    Object x;
                    x = m.item;
                    {
                        boolean var9A5DF2A846D139F665EDBC74399D4235_698163346 = (isData == (x != null) ||    
                        x == m ||                   
                        !m.casItem(x, e));
                        {
                            advanceHead(h, m);
                        } //End block
                    } //End collapsed parenthetic
                    advanceHead(h, m);
                    LockSupport.unpark(m.waiter);
                } //End block
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.881 -0400", hash_original_method = "90C8A09C09ECF2EF83975D209FFEEF37", hash_generated_method = "66D67950926653837FC3CA4C52167EF6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Object awaitFulfill(QNode s, Object e, boolean timed, long nanos) {
            dsTaint.addTaint(nanos);
            dsTaint.addTaint(timed);
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(s.dsTaint);
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
                    boolean varE18A53653EF476A6AB7DE0F6C07F3E95_1487962692 = (w.isInterrupted());
                    s.tryCancel(e);
                } //End collapsed parenthetic
                Object x;
                x = s.item;
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
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.882 -0400", hash_original_method = "6683A876B1B30ADB5D756618BABF762A", hash_generated_method = "603DF439AF0E6BCA8F1BF17A9B729FCF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void clean(QNode pred, QNode s) {
            dsTaint.addTaint(s.dsTaint);
            dsTaint.addTaint(pred.dsTaint);
            s.waiter = null;
            {
                QNode h;
                h = head;
                QNode hn;
                hn = h.next;
                {
                    boolean var90BBDE8A0ACDED3C7351797369CBD741_454320956 = (hn != null && hn.isCancelled());
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
                        boolean var9EC0578845E9330F648DFD38BF8851EE_226669993 = (sn == s || pred.casNext(s, sn));
                    } //End collapsed parenthetic
                } //End block
                QNode dp;
                dp = cleanMe;
                {
                    QNode d;
                    d = dp.next;
                    QNode dn;
                    {
                        boolean var981072472C7ACBE6D966E74F0BA25D4D_1730168106 = (d == null ||               
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
                    boolean varF92453FEDC3A2CB53C1EB52CDEA2A7A0_385799580 = (casCleanMe(null, pred));
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        static final class QNode {
            volatile QNode next;
            volatile Object item;
            volatile Thread waiter;
            boolean isData;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.882 -0400", hash_original_method = "36E0BDE690B9319BBAE39AE7BB5AED99", hash_generated_method = "A0E2AE56823F80CFA28785AD599A8311")
            @DSModeled(DSC.SAFE)
             QNode(Object item, boolean isData) {
                dsTaint.addTaint(isData);
                dsTaint.addTaint(item.dsTaint);
                // ---------- Original Method ----------
                //this.item = item;
                //this.isData = isData;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.882 -0400", hash_original_method = "611C5C34CB4DC255784715588EF3B5E5", hash_generated_method = "29636EBD87DC03CC180D2074C0C62824")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             boolean casNext(QNode cmp, QNode val) {
                dsTaint.addTaint(val.dsTaint);
                dsTaint.addTaint(cmp.dsTaint);
                boolean var17EA7A1AF3964F578962ECF95DC323BD_871252246 = (next == cmp &&
                    UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return next == cmp &&
                    //UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.882 -0400", hash_original_method = "3912AD02565B809FB80AB4089D0BD0C1", hash_generated_method = "E61A5FA1D5E456E4555014664D0233D9")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             boolean casItem(Object cmp, Object val) {
                dsTaint.addTaint(val.dsTaint);
                dsTaint.addTaint(cmp.dsTaint);
                boolean varA0F2A8A326F7E81A747BE437A925260E_940771408 = (item == cmp &&
                    UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val));
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return item == cmp &&
                    //UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.883 -0400", hash_original_method = "99C72522BA0C395099FBEE5F0489DB78", hash_generated_method = "EE12933D743D2DDB1B099D501952BA2D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             void tryCancel(Object cmp) {
                dsTaint.addTaint(cmp.dsTaint);
                UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
                // ---------- Original Method ----------
                //UNSAFE.compareAndSwapObject(this, itemOffset, cmp, this);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.883 -0400", hash_original_method = "45E5A9573D9BA1D0D86064CD1643198D", hash_generated_method = "DCFD58C06FEACB1AD9E1BB4BB20909B2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             boolean isCancelled() {
                boolean varA64503E11EBD2041198E2D58A05084A8_1317420748 = (item == this);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return item == this;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.883 -0400", hash_original_method = "355DAB50A3ED00DA4B9C20D2E0EF6792", hash_generated_method = "95CE822586ED85C4484D0374040C22EB")
            //DSFIXME:  CODE0002: Requires DSC value to be set
             boolean isOffList() {
                boolean varB6C5D4B086DE21F098503EC790F4AB8E_2111106508 = (next == this);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return next == this;
            }

            
            private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
            private static final long nextOffset =
                objectFieldOffset(UNSAFE, "next", QNode.class);
            private static final long itemOffset =
                objectFieldOffset(UNSAFE, "item", QNode.class);
        }


        
        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        private static final long headOffset =
            objectFieldOffset(UNSAFE, "head", TransferQueue.class);
        private static final long tailOffset =
            objectFieldOffset(UNSAFE, "tail", TransferQueue.class);
        private static final long cleanMeOffset =
            objectFieldOffset(UNSAFE, "cleanMe", TransferQueue.class);
    }


    
    static class WaitQueue implements java.io.Serializable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.883 -0400", hash_original_method = "68610211315BEC9DA2CB7D382781C108", hash_generated_method = "68610211315BEC9DA2CB7D382781C108")
                public WaitQueue ()
        {
        }


    }


    
    static class LifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.883 -0400", hash_original_method = "B83C0DE20D6C724C87262673A21D527D", hash_generated_method = "B83C0DE20D6C724C87262673A21D527D")
                public LifoWaitQueue ()
        {
        }


        private static final long serialVersionUID = -3633113410248163686L;
    }


    
    static class FifoWaitQueue extends WaitQueue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.883 -0400", hash_original_method = "5566CFACE190DFD0D8CEC09F59B17628", hash_generated_method = "5566CFACE190DFD0D8CEC09F59B17628")
                public FifoWaitQueue ()
        {
        }


        private static final long serialVersionUID = -3623113410248163686L;
    }


    
    private static final long serialVersionUID = -3223113410248163686L;
    static final int NCPUS = Runtime.getRuntime().availableProcessors();
    static final int maxTimedSpins = (NCPUS < 2) ? 0 : 32;
    static final int maxUntimedSpins = maxTimedSpins * 16;
    static final long spinForTimeoutThreshold = 1000L;
}

