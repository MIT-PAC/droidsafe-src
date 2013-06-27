package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.LockSupport;

public class Exchanger<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.524 -0400", hash_original_field = "5CEDCA3B8D1D4D654361BD61AE3A4F29", hash_generated_field = "A4DE78C80A44A9FFB485B1FA97067F63")

    private volatile Slot[] arena = new Slot[CAPACITY];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.524 -0400", hash_original_field = "08FD2B5E7CA277399B1D1E2C946F2D97", hash_generated_field = "C66EB78C9C747088647CB665EA37C340")

    private AtomicInteger max = new AtomicInteger();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.525 -0400", hash_original_method = "7EAF111F5AA6799458B5BA4ED6EF193C", hash_generated_method = "40D20C3FD1381E65CE0DB9BE25AFCC05")
    public  Exchanger() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.526 -0400", hash_original_method = "85CC613BF9709593CA039307E2227217", hash_generated_method = "239C0B4A8FDC464D25E40FAA0646B6FF")
    private Object doExchange(Object item, boolean timed, long nanos) {
        Object varB4EAC82CA7396A68D541C85D26508E83_333738730 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_776509349 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1694101848 = null; //Variable for return #3
        Node me;
        me = new Node(item);
        int index;
        index = hashIndex();
        int fails;
        fails = 0;
        {
            Object y;
            Slot slot;
            slot = arena[index];
            createSlot(index);
            {
                boolean varE874A275ACE4ABDDAD727D19AA73444E_1642570315 = ((y = slot.get()) != null &&  
                     slot.compareAndSet(y, null));
                {
                    Node you;
                    you = (Node)y;
                    {
                        boolean varBE94100B63296741396D38CBBC5C81BA_1205340341 = (you.compareAndSet(null, item));
                        {
                            LockSupport.unpark(you.waiter);
                            varB4EAC82CA7396A68D541C85D26508E83_333738730 = you.item;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var4AEAC78A07227D518993AFDDC063D2D8_140577531 = (y == null &&                 
                     slot.compareAndSet(null, me));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_776509349 = timed ?
                        awaitNanos(me, slot, nanos) :
                        await(me, slot);
                        Object v;
                        v = spinWait(me, slot);
                        varB4EAC82CA7396A68D541C85D26508E83_1694101848 = v;
                        me = new Node(item);
                        int m;
                        m = max.get();
                        {
                            boolean var51124E98EC92A4DACB1801B2BF3FE532_369540921 = (m > (index >>>= 1));
                            max.compareAndSet(m, m - 1);
                        } //End collapsed parenthetic
                    } //End block
                    {
                        int m;
                        m = max.get();
                        {
                            boolean var48BF77E6406E732E8A469F49A4FBA3B1_1044491157 = (fails > 3 && m < FULL && max.compareAndSet(m, m + 1));
                            index = m + 1;
                            index = m;
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        addTaint(item.getTaint());
        addTaint(timed);
        addTaint(nanos);
        Object varA7E53CE21691AB073D9660D615818899_1928444896; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1928444896 = varB4EAC82CA7396A68D541C85D26508E83_333738730;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1928444896 = varB4EAC82CA7396A68D541C85D26508E83_776509349;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1928444896 = varB4EAC82CA7396A68D541C85D26508E83_1694101848;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1928444896.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1928444896;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.530 -0400", hash_original_method = "81A7A8FE33AEB39DC2465115E332A8B2", hash_generated_method = "FCD6D9924C66AE7498C248BB8EEA1C44")
    private final int hashIndex() {
        long id;
        id = Thread.currentThread().getId();
        int hash;
        hash = (((int)(id ^ (id >>> 32))) ^ 0x811c9dc5) * 0x01000193;
        int m;
        m = max.get();
        int nbits;
        nbits = (((0xfffffc00  >> m) & 4) | 
                     ((0x000001f8 >>> m) & 2) | 
                     ((0xffff00f2 >>> m) & 1));
        int index;
        {
            boolean var9BF149FE11CD2FAAAD04D957F64F9462_17991667 = ((index = hash & ((1 << nbits) - 1)) > m);
            hash = (hash >>> nbits) | (hash << (33 - nbits));
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294144481 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294144481;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.551 -0400", hash_original_method = "710CA77564EC78E634B8090E5C600333", hash_generated_method = "2F16F4AB494D42997214EE36118B255C")
    private void createSlot(int index) {
        Slot newSlot;
        newSlot = new Slot();
        Slot[] a;
        a = arena;
        {
            a[index] = newSlot;
        } //End block
        addTaint(index);
        // ---------- Original Method ----------
        //Slot newSlot = new Slot();
        //Slot[] a = arena;
        //synchronized (a) {
            //if (a[index] == null)
                //a[index] = newSlot;
        //}
    }

    
        private static boolean tryCancel(Node node, Slot slot) {
        if (!node.compareAndSet(null, CANCEL))
            return false;
        if (slot.get() == node) 
            slot.compareAndSet(node, null);
        return true;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.556 -0400", hash_original_method = "B05B09390509B455A836B09E2A65E5D4", hash_generated_method = "41822E2C0EF9F19155530BACA9F53F58")
    private Object awaitNanos(Node node, Slot slot, long nanos) {
        Object varB4EAC82CA7396A68D541C85D26508E83_58207909 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_79316240 = null; //Variable for return #2
        int spins;
        spins = TIMED_SPINS;
        long lastTime;
        lastTime = 0;
        Thread w;
        w = null;
        {
            Object v;
            v = node.get();
            varB4EAC82CA7396A68D541C85D26508E83_58207909 = v;
            long now;
            now = System.nanoTime();
            w = Thread.currentThread();
            nanos -= now - lastTime;
            lastTime = now;
            {
                node.waiter = w;
                {
                    boolean varE18A53653EF476A6AB7DE0F6C07F3E95_1520218698 = (w.isInterrupted());
                    tryCancel(node, slot);
                    LockSupport.parkNanos(node, nanos);
                } //End collapsed parenthetic
            } //End block
            {
                boolean var644ED4DEF9497EA00CC732D9F17916D1_372739304 = (tryCancel(node, slot) && !w.isInterrupted());
                varB4EAC82CA7396A68D541C85D26508E83_79316240 = scanOnTimeout(node);
            } //End collapsed parenthetic
        } //End block
        addTaint(node.getTaint());
        addTaint(slot.getTaint());
        addTaint(nanos);
        Object varA7E53CE21691AB073D9660D615818899_119900252; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_119900252 = varB4EAC82CA7396A68D541C85D26508E83_58207909;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_119900252 = varB4EAC82CA7396A68D541C85D26508E83_79316240;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_119900252.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_119900252;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.571 -0400", hash_original_method = "968A2928C62BC7FCD22DA53EF68519F2", hash_generated_method = "D2E1E66AEDE27DF646EC45DE6B5C0F41")
    private Object scanOnTimeout(Node node) {
        Object varB4EAC82CA7396A68D541C85D26508E83_426229135 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1130745026 = null; //Variable for return #2
        Object y;
        {
            int j;
            j = arena.length - 1;
            {
                Slot slot;
                slot = arena[j];
                {
                    {
                        boolean var31CF58C08902F0C40BB48079EA7CA790_45333564 = ((y = slot.get()) != null);
                        {
                            {
                                boolean varA1674EF3A71D1744EC2DE2775415D4E0_887481670 = (slot.compareAndSet(y, null));
                                {
                                    Node you;
                                    you = (Node)y;
                                    {
                                        boolean varB2985F057C90BC49E4CC3008C2FFC34B_835604248 = (you.compareAndSet(null, node.item));
                                        {
                                            LockSupport.unpark(you.waiter);
                                            varB4EAC82CA7396A68D541C85D26508E83_426229135 = you.item;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1130745026 = CANCEL;
        addTaint(node.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1916899276; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1916899276 = varB4EAC82CA7396A68D541C85D26508E83_426229135;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1916899276 = varB4EAC82CA7396A68D541C85D26508E83_1130745026;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1916899276.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1916899276;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.572 -0400", hash_original_method = "01BD898C994460F5196927F0C5114F9E", hash_generated_method = "88C63A1B312FD4448F97DD6D9FAA6085")
    public V exchange(V x) throws InterruptedException {
        V varB4EAC82CA7396A68D541C85D26508E83_148682982 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_222699828 = null; //Variable for return #2
        {
            boolean var7802430CC9FA3C264EA55E37D5C0452C_873673855 = (!Thread.interrupted());
            {
                Object v;
                v = doExchange((x == null) ? NULL_ITEM : x, false, 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
                varB4EAC82CA7396A68D541C85D26508E83_148682982 = null;
                varB4EAC82CA7396A68D541C85D26508E83_222699828 = (V)v;
                Thread.interrupted();
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        addTaint(x.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1759843124; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1759843124 = varB4EAC82CA7396A68D541C85D26508E83_148682982;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1759843124 = varB4EAC82CA7396A68D541C85D26508E83_222699828;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1759843124.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1759843124;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.572 -0400", hash_original_method = "32FED615BD7111CFC755561A988F29C6", hash_generated_method = "9375BF70B1F9DF7FBEA11F51BE510A53")
    public V exchange(V x, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
        V varB4EAC82CA7396A68D541C85D26508E83_1810600027 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1595263360 = null; //Variable for return #2
        {
            boolean var7802430CC9FA3C264EA55E37D5C0452C_624527162 = (!Thread.interrupted());
            {
                Object v;
                v = doExchange((x == null) ? NULL_ITEM : x,
                                  true, unit.toNanos(timeout));//DSFIXME:  CODE0008: Nested ternary operator in expression
                varB4EAC82CA7396A68D541C85D26508E83_1810600027 = null;
                varB4EAC82CA7396A68D541C85D26508E83_1595263360 = (V)v;
                {
                    boolean varCA8965A9EA57234B7FB0ED3C4ECB92FA_1875737148 = (!Thread.interrupted());
                    if (DroidSafeAndroidRuntime.control) throw new TimeoutException();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        addTaint(x.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        V varA7E53CE21691AB073D9660D615818899_530879229; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_530879229 = varB4EAC82CA7396A68D541C85D26508E83_1810600027;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_530879229 = varB4EAC82CA7396A68D541C85D26508E83_1595263360;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_530879229.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_530879229;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.572 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "534A9EAE4E6170E4619513891411852D")

        public Object item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.572 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "CD33F33C6B06BD5F7A2A693861D1129D")

        public volatile Thread waiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_method = "8076C86F5BED3901532DF78458E5A05E", hash_generated_method = "91161F3B4D96F232328ED124C5209D70")
        public  Node(Object item) {
            this.item = item;
            // ---------- Original Method ----------
            //this.item = item;
        }

        
    }


    
    private static final class Slot extends AtomicReference<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "61E23FC401E882840B471B3B125A68A9", hash_generated_field = "1AE1EC9FE6B62D9AC31A8484951D02A5")

        long q0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "FF33F1B12213E021C2C4A888141953BA", hash_generated_field = "9D63817BCE5C08A3499D963BC29E7F66")

        long q1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "74D502A7131CDAC90EECDFB0531C4E87", hash_generated_field = "4096B7091287D3D68D867A6771897C4F")

        long q2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "69855EDA6D7282DE712FEE7EB5235AB1", hash_generated_field = "E82AB112AC9A149E44FB6E32C8E09E74")

        long q3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "681568000CC3A37334495EF38FF48282", hash_generated_field = "B4D9EE16DDBAB58D380983755645DB49")

        long q4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "352DDE4B72AE781FA1E061FE65EA7251", hash_generated_field = "DBDFEC8FB0C7ECD3F3CA2A742D957B97")

        long q5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "794222D5B33EDD2899D9F35E54CE966D", hash_generated_field = "4C9823271DD5F4B81133463A0FEDC422")

        long q6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "D65D03B02D5E9DD09DC19AD398987C61", hash_generated_field = "B772E7DFC6765B74FB0E3747F9735B14")

        long q7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "AD09072A2B3DA610E4D7180D6B833BC6", hash_generated_field = "B8CFD15EAF457DFB518AC3E77AFD5E83")

        long q8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "F9734637B58C055CE3ED8E38B41D0E17", hash_generated_field = "2D39EC99CB4E8C24CEB9642AF7C84A0E")

        long q9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "8264EE52F589F4C0191AA94F87AA1AEB", hash_generated_field = "180A8E76D6A8305349F33B06C403CD60")

        long qa;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "0D47B8346D57B12A5807C36FB1F14F3C", hash_generated_field = "691C04E05AC23F83FF5C8CDB3328B8ED")

        long qb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "9300C96AAEC324987EA5CA6E13A02EDA", hash_generated_field = "C837DB7B40EE95DCD5A34423EAF7C2B6")

        long qc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "98877902E81C1A83B58EEE2FF38DD17B", hash_generated_field = "91773591A5407D8E2D5234C2E0661439")

        long qd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "4D6E7051B02397D7733EA9A222FDB8E0", hash_generated_field = "2E6D34B3E7F049D1453E6B068E27473D")

        long qe;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_method = "EA0EDCFF10F8D9E7849DBDB76AB4743F", hash_generated_method = "EA0EDCFF10F8D9E7849DBDB76AB4743F")
        public Slot ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "08206593AD53118A4399D95F1F5F27A3", hash_generated_field = "5CE49859B8F494726A371CD08B60F778")

    private static int NCPU = Runtime.getRuntime().availableProcessors();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "C921C4C9D464325B11257C5AEBD1AAA3", hash_generated_field = "C66D64A14BD1839FF1D09E6D19C883B3")

    private static int CAPACITY = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "BDDDCA2C7CA0962F138AEC5FC6D88260", hash_generated_field = "7BB2972DF2C2787952E78AA7983F7C35")

    private static int FULL = Math.max(0, Math.min(CAPACITY, NCPU / 2) - 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.573 -0400", hash_original_field = "6B1F0AEC6B8E3406CF74EC7739A70A1F", hash_generated_field = "37122F1B35927F6E918D49CE84034B95")

    private static int SPINS = (NCPU == 1) ? 0 : 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.584 -0400", hash_original_field = "1E9DADE18B04D44B76130EF230C9444A", hash_generated_field = "6C61034BFC0BED37AF3552896608445C")

    private static int TIMED_SPINS = SPINS / 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.585 -0400", hash_original_field = "4EE4680976B68C20E5AEA92BA17B7949", hash_generated_field = "AD2C784B4F303A59B8055E55ADDD387D")

    private static Object CANCEL = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.585 -0400", hash_original_field = "1753013D4B829E720100840E87754B47", hash_generated_field = "FD876C4E75D0458E243B885A00C2196E")

    private static Object NULL_ITEM = new Object();
}

