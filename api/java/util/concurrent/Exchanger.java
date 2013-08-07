package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.LockSupport;

public class Exchanger<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.441 -0400", hash_original_field = "5CEDCA3B8D1D4D654361BD61AE3A4F29", hash_generated_field = "A4DE78C80A44A9FFB485B1FA97067F63")

    private volatile Slot[] arena = new Slot[CAPACITY];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.442 -0400", hash_original_field = "08FD2B5E7CA277399B1D1E2C946F2D97", hash_generated_field = "C753B28A7DF93AEB959426A931313902")

    private final AtomicInteger max = new AtomicInteger();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.443 -0400", hash_original_method = "7EAF111F5AA6799458B5BA4ED6EF193C", hash_generated_method = "40D20C3FD1381E65CE0DB9BE25AFCC05")
    public  Exchanger() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.448 -0400", hash_original_method = "85CC613BF9709593CA039307E2227217", hash_generated_method = "F3AB0A199168C8CD96B8E268A4CAD324")
    private Object doExchange(Object item, boolean timed, long nanos) {
        addTaint(nanos);
        addTaint(timed);
        addTaint(item.getTaint());
        Node me = new Node(item);
        int index = hashIndex();
        int fails = 0;
for(;;)
        {
            Object y;
            Slot slot = arena[index];
            if(slot == null)            
            createSlot(index);
            else
            if((y = slot.get()) != null &&  
                     slot.compareAndSet(y, null))            
            {
                Node you = (Node)y;
                if(you.compareAndSet(null, item))                
                {
                    LockSupport.unpark(you.waiter);
Object var15CD5627EC77B4C70E46681E42DEA286_467919635 =                     you.item;
                    var15CD5627EC77B4C70E46681E42DEA286_467919635.addTaint(taint);
                    return var15CD5627EC77B4C70E46681E42DEA286_467919635;
                } //End block
            } //End block
            else
            if(y == null &&                 
                     slot.compareAndSet(null, me))            
            {
                if(index == 0)                
                {
Object var17DEFD59045ACC93949156CC96014216_1825051922 =                 timed ?
                        awaitNanos(me, slot, nanos) :
                        await(me, slot);
                var17DEFD59045ACC93949156CC96014216_1825051922.addTaint(taint);
                return var17DEFD59045ACC93949156CC96014216_1825051922;
                }
                Object v = spinWait(me, slot);
                if(v != CANCEL)                
                {
Object var6DC76BC51820DD65E8396280E884AA78_747046844 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_747046844.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_747046844;
                }
                me = new Node(item);
                int m = max.get();
                if(m > (index >>>= 1))                
                max.compareAndSet(m, m - 1);
            } //End block
            else
            if(++fails > 1)            
            {
                int m = max.get();
                if(fails > 3 && m < FULL && max.compareAndSet(m, m + 1))                
                index = m + 1;
                else
                if(--index < 0)                
                index = m;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.453 -0400", hash_original_method = "81A7A8FE33AEB39DC2465115E332A8B2", hash_generated_method = "3F0AE4AEB028A9539B0CA2887F306CA8")
    private final int hashIndex() {
        long id = Thread.currentThread().getId();
        int hash = (((int)(id ^ (id >>> 32))) ^ 0x811c9dc5) * 0x01000193;
        int m = max.get();
        int nbits = (((0xfffffc00  >> m) & 4) | 
                     ((0x000001f8 >>> m) & 2) | 
                     ((0xffff00f2 >>> m) & 1));
        int index;
        while
((index = hash & ((1 << nbits) - 1)) > m)        
        hash = (hash >>> nbits) | (hash << (33 - nbits));
        int var6A992D5529F459A44FEE58C733255E86_1339659893 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791319996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791319996;
        // ---------- Original Method ----------
        //long id = Thread.currentThread().getId();
        //int hash = (((int)(id ^ (id >>> 32))) ^ 0x811c9dc5) * 0x01000193;
        //int m = max.get();
        //int nbits = (((0xfffffc00  >> m) & 4) | 
                     //((0x000001f8 >>> m) & 2) | 
                     //((0xffff00f2 >>> m) & 1));
        //int index;
        //while ((index = hash & ((1 << nbits) - 1)) > m)       
            //hash = (hash >>> nbits) | (hash << (33 - nbits));
        //return index;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.458 -0400", hash_original_method = "710CA77564EC78E634B8090E5C600333", hash_generated_method = "03DCC27059DA711C525C070285FB60CE")
    private void createSlot(int index) {
        addTaint(index);
        Slot newSlot = new Slot();
        Slot[] a = arena;
        synchronized
(a)        {
            if(a[index] == null)            
            a[index] = newSlot;
        } //End block
        // ---------- Original Method ----------
        //Slot newSlot = new Slot();
        //Slot[] a = arena;
        //synchronized (a) {
            //if (a[index] == null)
                //a[index] = newSlot;
        //}
    }

    
        @DSModeled(DSC.BAN)
    private static boolean tryCancel(Node node, Slot slot) {
        if (!node.compareAndSet(null, CANCEL))
            return false;
        if (slot.get() == node) 
            slot.compareAndSet(node, null);
        return true;
    }

    
        @DSModeled(DSC.BAN)
    private static Object spinWait(Node node, Slot slot) {
        int spins = SPINS;
        for (;;) {
            Object v = node.get();
            if (v != null)
                return v;
            else if (spins > 0)
                --spins;
            else
                tryCancel(node, slot);
        }
    }

    
        @DSModeled(DSC.BAN)
    private static Object await(Node node, Slot slot) {
        Thread w = Thread.currentThread();
        int spins = SPINS;
        for (;;) {
            Object v = node.get();
            if (v != null)
                return v;
            else if (spins > 0)                 
                --spins;
            else if (node.waiter == null)       
                node.waiter = w;
            else if (w.isInterrupted())         
                tryCancel(node, slot);
            else                                
                LockSupport.park(node);
        }
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.473 -0400", hash_original_method = "B05B09390509B455A836B09E2A65E5D4", hash_generated_method = "EE0B136210EEECC2D90CB088E18C1C61")
    private Object awaitNanos(Node node, Slot slot, long nanos) {
        addTaint(nanos);
        addTaint(slot.getTaint());
        addTaint(node.getTaint());
        int spins = TIMED_SPINS;
        long lastTime = 0;
        Thread w = null;
for(;;)
        {
            Object v = node.get();
            if(v != null)            
            {
Object var6DC76BC51820DD65E8396280E884AA78_323073449 =             v;
            var6DC76BC51820DD65E8396280E884AA78_323073449.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_323073449;
            }
            long now = System.nanoTime();
            if(w == null)            
            w = Thread.currentThread();
            else
            nanos -= now - lastTime;
            lastTime = now;
            if(nanos > 0)            
            {
                if(spins > 0)                
                --spins;
                else
                if(node.waiter == null)                
                node.waiter = w;
                else
                if(w.isInterrupted())                
                tryCancel(node, slot);
                else
                LockSupport.parkNanos(node, nanos);
            } //End block
            else
            if(tryCancel(node, slot) && !w.isInterrupted())            
            {
Object var9284ED8317C59E844C0B5D919DAE1270_2099374579 =             scanOnTimeout(node);
            var9284ED8317C59E844C0B5D919DAE1270_2099374579.addTaint(taint);
            return var9284ED8317C59E844C0B5D919DAE1270_2099374579;
            }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.478 -0400", hash_original_method = "968A2928C62BC7FCD22DA53EF68519F2", hash_generated_method = "490B77187B229AC26FC24E93CA533DD1")
    private Object scanOnTimeout(Node node) {
        addTaint(node.getTaint());
        Object y;
for(int j = arena.length - 1;j >= 0;--j)
        {
            Slot slot = arena[j];
            if(slot != null)            
            {
                while
((y = slot.get()) != null)                
                {
                    if(slot.compareAndSet(y, null))                    
                    {
                        Node you = (Node)y;
                        if(you.compareAndSet(null, node.item))                        
                        {
                            LockSupport.unpark(you.waiter);
Object var15CD5627EC77B4C70E46681E42DEA286_1879260653 =                             you.item;
                            var15CD5627EC77B4C70E46681E42DEA286_1879260653.addTaint(taint);
                            return var15CD5627EC77B4C70E46681E42DEA286_1879260653;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
Object varAC1E13DC90B5F88D0548A9E4E47E3438_637930286 =         CANCEL;
        varAC1E13DC90B5F88D0548A9E4E47E3438_637930286.addTaint(taint);
        return varAC1E13DC90B5F88D0548A9E4E47E3438_637930286;
        // ---------- Original Method ----------
        //Object y;
        //for (int j = arena.length - 1; j >= 0; --j) {
            //Slot slot = arena[j];
            //if (slot != null) {
                //while ((y = slot.get()) != null) {
                    //if (slot.compareAndSet(y, null)) {
                        //Node you = (Node)y;
                        //if (you.compareAndSet(null, node.item)) {
                            //LockSupport.unpark(you.waiter);
                            //return you.item;
                        //}
                    //}
                //}
            //}
        //}
        //return CANCEL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.482 -0400", hash_original_method = "01BD898C994460F5196927F0C5114F9E", hash_generated_method = "A3C54706DC83B765E9EF864C9457F4E0")
    public V exchange(V x) throws InterruptedException {
        addTaint(x.getTaint());
        if(!Thread.interrupted())        
        {
            Object v = doExchange((x == null) ? NULL_ITEM : x, false, 0);
            if(v == NULL_ITEM)            
            {
V var540C13E9E156B687226421B24F2DF178_1356029493 =             null;
            var540C13E9E156B687226421B24F2DF178_1356029493.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1356029493;
            }
            if(v != CANCEL)            
            {
V varB8DCCF40993CFCDCE8F471B3D2A68034_1856875648 =             (V)v;
            varB8DCCF40993CFCDCE8F471B3D2A68034_1856875648.addTaint(taint);
            return varB8DCCF40993CFCDCE8F471B3D2A68034_1856875648;
            }
            Thread.interrupted();
        } //End block
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_889625839 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_889625839.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_889625839;
        // ---------- Original Method ----------
        //if (!Thread.interrupted()) {
            //Object v = doExchange((x == null) ? NULL_ITEM : x, false, 0);
            //if (v == NULL_ITEM)
                //return null;
            //if (v != CANCEL)
                //return (V)v;
            //Thread.interrupted(); 
        //}
        //throw new InterruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.490 -0400", hash_original_method = "32FED615BD7111CFC755561A988F29C6", hash_generated_method = "F73990943787727081A070CD2A6353C6")
    public V exchange(V x, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(x.getTaint());
        if(!Thread.interrupted())        
        {
            Object v = doExchange((x == null) ? NULL_ITEM : x,
                                  true, unit.toNanos(timeout));
            if(v == NULL_ITEM)            
            {
V var540C13E9E156B687226421B24F2DF178_462983100 =             null;
            var540C13E9E156B687226421B24F2DF178_462983100.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_462983100;
            }
            if(v != CANCEL)            
            {
V varB8DCCF40993CFCDCE8F471B3D2A68034_665862429 =             (V)v;
            varB8DCCF40993CFCDCE8F471B3D2A68034_665862429.addTaint(taint);
            return varB8DCCF40993CFCDCE8F471B3D2A68034_665862429;
            }
            if(!Thread.interrupted())            
            {
            TimeoutException var3B6A086CA796B867C2DC52AFEEF9D0CF_879135734 = new TimeoutException();
            var3B6A086CA796B867C2DC52AFEEF9D0CF_879135734.addTaint(taint);
            throw var3B6A086CA796B867C2DC52AFEEF9D0CF_879135734;
            }
        } //End block
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_1647458895 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_1647458895.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_1647458895;
        // ---------- Original Method ----------
        //if (!Thread.interrupted()) {
            //Object v = doExchange((x == null) ? NULL_ITEM : x,
                                  //true, unit.toNanos(timeout));
            //if (v == NULL_ITEM)
                //return null;
            //if (v != CANCEL)
                //return (V)v;
            //if (!Thread.interrupted())
                //throw new TimeoutException();
        //}
        //throw new InterruptedException();
    }

    
    private static final class Node extends AtomicReference<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.492 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "534A9EAE4E6170E4619513891411852D")

        public Object item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.493 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "CD33F33C6B06BD5F7A2A693861D1129D")

        public volatile Thread waiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.496 -0400", hash_original_method = "8076C86F5BED3901532DF78458E5A05E", hash_generated_method = "91161F3B4D96F232328ED124C5209D70")
        public  Node(Object item) {
            this.item = item;
            // ---------- Original Method ----------
            //this.item = item;
        }

        
    }


    
    private static final class Slot extends AtomicReference<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.499 -0400", hash_original_field = "61E23FC401E882840B471B3B125A68A9", hash_generated_field = "1AE1EC9FE6B62D9AC31A8484951D02A5")

        long q0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.500 -0400", hash_original_field = "FF33F1B12213E021C2C4A888141953BA", hash_generated_field = "9D63817BCE5C08A3499D963BC29E7F66")

        long q1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.501 -0400", hash_original_field = "74D502A7131CDAC90EECDFB0531C4E87", hash_generated_field = "4096B7091287D3D68D867A6771897C4F")

        long q2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.502 -0400", hash_original_field = "69855EDA6D7282DE712FEE7EB5235AB1", hash_generated_field = "E82AB112AC9A149E44FB6E32C8E09E74")

        long q3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.503 -0400", hash_original_field = "681568000CC3A37334495EF38FF48282", hash_generated_field = "B4D9EE16DDBAB58D380983755645DB49")

        long q4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.504 -0400", hash_original_field = "352DDE4B72AE781FA1E061FE65EA7251", hash_generated_field = "DBDFEC8FB0C7ECD3F3CA2A742D957B97")

        long q5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.505 -0400", hash_original_field = "794222D5B33EDD2899D9F35E54CE966D", hash_generated_field = "4C9823271DD5F4B81133463A0FEDC422")

        long q6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.506 -0400", hash_original_field = "D65D03B02D5E9DD09DC19AD398987C61", hash_generated_field = "B772E7DFC6765B74FB0E3747F9735B14")

        long q7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.508 -0400", hash_original_field = "AD09072A2B3DA610E4D7180D6B833BC6", hash_generated_field = "B8CFD15EAF457DFB518AC3E77AFD5E83")

        long q8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.509 -0400", hash_original_field = "F9734637B58C055CE3ED8E38B41D0E17", hash_generated_field = "2D39EC99CB4E8C24CEB9642AF7C84A0E")

        long q9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.510 -0400", hash_original_field = "8264EE52F589F4C0191AA94F87AA1AEB", hash_generated_field = "180A8E76D6A8305349F33B06C403CD60")

        long qa;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.511 -0400", hash_original_field = "0D47B8346D57B12A5807C36FB1F14F3C", hash_generated_field = "691C04E05AC23F83FF5C8CDB3328B8ED")

        long qb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.513 -0400", hash_original_field = "9300C96AAEC324987EA5CA6E13A02EDA", hash_generated_field = "C837DB7B40EE95DCD5A34423EAF7C2B6")

        long qc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.515 -0400", hash_original_field = "98877902E81C1A83B58EEE2FF38DD17B", hash_generated_field = "91773591A5407D8E2D5234C2E0661439")

        long qd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.517 -0400", hash_original_field = "4D6E7051B02397D7733EA9A222FDB8E0", hash_generated_field = "2E6D34B3E7F049D1453E6B068E27473D")

        long qe;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.518 -0400", hash_original_method = "EA0EDCFF10F8D9E7849DBDB76AB4743F", hash_generated_method = "EA0EDCFF10F8D9E7849DBDB76AB4743F")
        public Slot ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.519 -0400", hash_original_field = "08206593AD53118A4399D95F1F5F27A3", hash_generated_field = "8FD1D00BA6B52C5E0CB71DFCD385247C")

    private static final int NCPU = Runtime.getRuntime().availableProcessors();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.521 -0400", hash_original_field = "C921C4C9D464325B11257C5AEBD1AAA3", hash_generated_field = "E87A8F05D56205E03FD465D71DDC4E64")

    private static final int CAPACITY = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.522 -0400", hash_original_field = "BDDDCA2C7CA0962F138AEC5FC6D88260", hash_generated_field = "19CBB79F5BAC3C02E55420AC3E96D83F")

    private static final int FULL = Math.max(0, Math.min(CAPACITY, NCPU / 2) - 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.523 -0400", hash_original_field = "6B1F0AEC6B8E3406CF74EC7739A70A1F", hash_generated_field = "DD5CFF62634AED5D259CB7E2ADD5133B")

    private static final int SPINS = (NCPU == 1) ? 0 : 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.524 -0400", hash_original_field = "1E9DADE18B04D44B76130EF230C9444A", hash_generated_field = "76DBAB4631B1B171678A47C88BDDACA5")

    private static final int TIMED_SPINS = SPINS / 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.525 -0400", hash_original_field = "4EE4680976B68C20E5AEA92BA17B7949", hash_generated_field = "3B0C3CB8323B5C5F4FF4411ED327CEBB")

    private static final Object CANCEL = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.526 -0400", hash_original_field = "1753013D4B829E720100840E87754B47", hash_generated_field = "C3444CF75E87B7410DAF194724DC011B")

    private static final Object NULL_ITEM = new Object();
}

