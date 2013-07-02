package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.LockSupport;

public class Exchanger<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.770 -0400", hash_original_field = "5CEDCA3B8D1D4D654361BD61AE3A4F29", hash_generated_field = "A4DE78C80A44A9FFB485B1FA97067F63")

    private volatile Slot[] arena = new Slot[CAPACITY];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.770 -0400", hash_original_field = "08FD2B5E7CA277399B1D1E2C946F2D97", hash_generated_field = "C753B28A7DF93AEB959426A931313902")

    private final AtomicInteger max = new AtomicInteger();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.771 -0400", hash_original_method = "7EAF111F5AA6799458B5BA4ED6EF193C", hash_generated_method = "40D20C3FD1381E65CE0DB9BE25AFCC05")
    public  Exchanger() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.772 -0400", hash_original_method = "85CC613BF9709593CA039307E2227217", hash_generated_method = "7ED1DE6BECA2AFEA7657F5F864DD9610")
    private Object doExchange(Object item, boolean timed, long nanos) {
        Object varB4EAC82CA7396A68D541C85D26508E83_645392046 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1574568479 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_105994575 = null; 
        Node me = new Node(item);
        int index = hashIndex();
        int fails = 0;
        {
            Object y;
            Slot slot = arena[index];
            createSlot(index);
            {
                boolean varE874A275ACE4ABDDAD727D19AA73444E_302314005 = ((y = slot.get()) != null &&  
                     slot.compareAndSet(y, null));
                {
                    Node you = (Node)y;
                    {
                        boolean varBE94100B63296741396D38CBBC5C81BA_2065070626 = (you.compareAndSet(null, item));
                        {
                            LockSupport.unpark(you.waiter);
                            varB4EAC82CA7396A68D541C85D26508E83_645392046 = you.item;
                        } 
                    } 
                } 
                {
                    boolean var4AEAC78A07227D518993AFDDC063D2D8_926444887 = (y == null &&                 
                     slot.compareAndSet(null, me));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1574568479 = timed ?
                        awaitNanos(me, slot, nanos) :
                        await(me, slot);
                        Object v = spinWait(me, slot);
                        varB4EAC82CA7396A68D541C85D26508E83_105994575 = v;
                        me = new Node(item);
                        int m = max.get();
                        {
                            boolean var51124E98EC92A4DACB1801B2BF3FE532_126202175 = (m > (index >>>= 1));
                            max.compareAndSet(m, m - 1);
                        } 
                    } 
                    {
                        int m = max.get();
                        {
                            boolean var48BF77E6406E732E8A469F49A4FBA3B1_2002447062 = (fails > 3 && m < FULL && max.compareAndSet(m, m + 1));
                            index = m + 1;
                            index = m;
                        } 
                    } 
                } 
            } 
        } 
        addTaint(item.getTaint());
        addTaint(timed);
        addTaint(nanos);
        Object varA7E53CE21691AB073D9660D615818899_672694288; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_672694288 = varB4EAC82CA7396A68D541C85D26508E83_645392046;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_672694288 = varB4EAC82CA7396A68D541C85D26508E83_1574568479;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_672694288 = varB4EAC82CA7396A68D541C85D26508E83_105994575;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_672694288.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_672694288;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.772 -0400", hash_original_method = "81A7A8FE33AEB39DC2465115E332A8B2", hash_generated_method = "F24C27E208A9435536E07C1BA3A80A95")
    private final int hashIndex() {
        long id = Thread.currentThread().getId();
        int hash = (((int)(id ^ (id >>> 32))) ^ 0x811c9dc5) * 0x01000193;
        int m = max.get();
        int nbits = (((0xfffffc00  >> m) & 4) | 
                     ((0x000001f8 >>> m) & 2) | 
                     ((0xffff00f2 >>> m) & 1));
        int index;
        {
            boolean var9BF149FE11CD2FAAAD04D957F64F9462_897864201 = ((index = hash & ((1 << nbits) - 1)) > m);
            hash = (hash >>> nbits) | (hash << (33 - nbits));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287830387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287830387;
        
        
        
        
        
                     
                     
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.773 -0400", hash_original_method = "710CA77564EC78E634B8090E5C600333", hash_generated_method = "0050F73E4308DB5A94498933F390DFBC")
    private void createSlot(int index) {
        Slot newSlot = new Slot();
        Slot[] a = arena;
        {
            a[index] = newSlot;
        } 
        addTaint(index);
        
        
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean tryCancel(Node node, Slot slot) {
        if (!node.compareAndSet(null, CANCEL))
            return false;
        if (slot.get() == node) 
            slot.compareAndSet(node, null);
        return true;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.776 -0400", hash_original_method = "B05B09390509B455A836B09E2A65E5D4", hash_generated_method = "91523D336778044DC6AB8BEA6444BFDF")
    private Object awaitNanos(Node node, Slot slot, long nanos) {
        Object varB4EAC82CA7396A68D541C85D26508E83_499064129 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1511308196 = null; 
        int spins = TIMED_SPINS;
        long lastTime = 0;
        Thread w = null;
        {
            Object v = node.get();
            varB4EAC82CA7396A68D541C85D26508E83_499064129 = v;
            long now = System.nanoTime();
            w = Thread.currentThread();
            nanos -= now - lastTime;
            lastTime = now;
            {
                node.waiter = w;
                {
                    boolean varE18A53653EF476A6AB7DE0F6C07F3E95_493956366 = (w.isInterrupted());
                    tryCancel(node, slot);
                    LockSupport.parkNanos(node, nanos);
                } 
            } 
            {
                boolean var644ED4DEF9497EA00CC732D9F17916D1_223539589 = (tryCancel(node, slot) && !w.isInterrupted());
                varB4EAC82CA7396A68D541C85D26508E83_1511308196 = scanOnTimeout(node);
            } 
        } 
        addTaint(node.getTaint());
        addTaint(slot.getTaint());
        addTaint(nanos);
        Object varA7E53CE21691AB073D9660D615818899_171179654; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_171179654 = varB4EAC82CA7396A68D541C85D26508E83_499064129;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_171179654 = varB4EAC82CA7396A68D541C85D26508E83_1511308196;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_171179654.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_171179654;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.776 -0400", hash_original_method = "968A2928C62BC7FCD22DA53EF68519F2", hash_generated_method = "450C2AEB39059490B2A59C4254DA780E")
    private Object scanOnTimeout(Node node) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1289002109 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_937982600 = null; 
        Object y;
        {
            int j = arena.length - 1;
            {
                Slot slot = arena[j];
                {
                    {
                        boolean var31CF58C08902F0C40BB48079EA7CA790_933883683 = ((y = slot.get()) != null);
                        {
                            {
                                boolean varA1674EF3A71D1744EC2DE2775415D4E0_1537800932 = (slot.compareAndSet(y, null));
                                {
                                    Node you = (Node)y;
                                    {
                                        boolean varB2985F057C90BC49E4CC3008C2FFC34B_443590825 = (you.compareAndSet(null, node.item));
                                        {
                                            LockSupport.unpark(you.waiter);
                                            varB4EAC82CA7396A68D541C85D26508E83_1289002109 = you.item;
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_937982600 = CANCEL;
        addTaint(node.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_455026448; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_455026448 = varB4EAC82CA7396A68D541C85D26508E83_1289002109;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_455026448 = varB4EAC82CA7396A68D541C85D26508E83_937982600;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_455026448.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_455026448;
        
        
        
            
            
                
                    
                        
                        
                            
                            
                        
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.777 -0400", hash_original_method = "01BD898C994460F5196927F0C5114F9E", hash_generated_method = "B14E91E46E203F3DEE8807346328E405")
    public V exchange(V x) throws InterruptedException {
        V varB4EAC82CA7396A68D541C85D26508E83_1780210649 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_1501254381 = null; 
        {
            boolean var7802430CC9FA3C264EA55E37D5C0452C_1069493857 = (!Thread.interrupted());
            {
                Object v = doExchange((x == null) ? NULL_ITEM : x, false, 0);
                varB4EAC82CA7396A68D541C85D26508E83_1780210649 = null;
                varB4EAC82CA7396A68D541C85D26508E83_1501254381 = (V)v;
                Thread.interrupted();
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        addTaint(x.getTaint());
        V varA7E53CE21691AB073D9660D615818899_611425972; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_611425972 = varB4EAC82CA7396A68D541C85D26508E83_1780210649;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_611425972 = varB4EAC82CA7396A68D541C85D26508E83_1501254381;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_611425972.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_611425972;
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_method = "32FED615BD7111CFC755561A988F29C6", hash_generated_method = "190E660A5C4AAF5416DD2007BF9539AE")
    public V exchange(V x, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
        V varB4EAC82CA7396A68D541C85D26508E83_1691719686 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_1336217552 = null; 
        {
            boolean var7802430CC9FA3C264EA55E37D5C0452C_952636297 = (!Thread.interrupted());
            {
                Object v = doExchange((x == null) ? NULL_ITEM : x,
                                  true, unit.toNanos(timeout));
                varB4EAC82CA7396A68D541C85D26508E83_1691719686 = null;
                varB4EAC82CA7396A68D541C85D26508E83_1336217552 = (V)v;
                {
                    boolean varCA8965A9EA57234B7FB0ED3C4ECB92FA_278218353 = (!Thread.interrupted());
                    if (DroidSafeAndroidRuntime.control) throw new TimeoutException();
                } 
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        addTaint(x.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1980333857; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1980333857 = varB4EAC82CA7396A68D541C85D26508E83_1691719686;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1980333857 = varB4EAC82CA7396A68D541C85D26508E83_1336217552;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1980333857.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1980333857;
        
        
            
                                  
            
                
            
                
            
                
        
        
    }

    
    private static final class Node extends AtomicReference<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "534A9EAE4E6170E4619513891411852D")

        public Object item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_field = "F64CFF138020A2060A9817272F563B3C", hash_generated_field = "CD33F33C6B06BD5F7A2A693861D1129D")

        public volatile Thread waiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_method = "8076C86F5BED3901532DF78458E5A05E", hash_generated_method = "91161F3B4D96F232328ED124C5209D70")
        public  Node(Object item) {
            this.item = item;
            
            
        }

        
    }


    
    private static final class Slot extends AtomicReference<Object> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_field = "61E23FC401E882840B471B3B125A68A9", hash_generated_field = "1AE1EC9FE6B62D9AC31A8484951D02A5")

        long q0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_field = "FF33F1B12213E021C2C4A888141953BA", hash_generated_field = "9D63817BCE5C08A3499D963BC29E7F66")

        long q1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_field = "74D502A7131CDAC90EECDFB0531C4E87", hash_generated_field = "4096B7091287D3D68D867A6771897C4F")

        long q2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_field = "69855EDA6D7282DE712FEE7EB5235AB1", hash_generated_field = "E82AB112AC9A149E44FB6E32C8E09E74")

        long q3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_field = "681568000CC3A37334495EF38FF48282", hash_generated_field = "B4D9EE16DDBAB58D380983755645DB49")

        long q4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.778 -0400", hash_original_field = "352DDE4B72AE781FA1E061FE65EA7251", hash_generated_field = "DBDFEC8FB0C7ECD3F3CA2A742D957B97")

        long q5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "794222D5B33EDD2899D9F35E54CE966D", hash_generated_field = "4C9823271DD5F4B81133463A0FEDC422")

        long q6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "D65D03B02D5E9DD09DC19AD398987C61", hash_generated_field = "B772E7DFC6765B74FB0E3747F9735B14")

        long q7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "AD09072A2B3DA610E4D7180D6B833BC6", hash_generated_field = "B8CFD15EAF457DFB518AC3E77AFD5E83")

        long q8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "F9734637B58C055CE3ED8E38B41D0E17", hash_generated_field = "2D39EC99CB4E8C24CEB9642AF7C84A0E")

        long q9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "8264EE52F589F4C0191AA94F87AA1AEB", hash_generated_field = "180A8E76D6A8305349F33B06C403CD60")

        long qa;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "0D47B8346D57B12A5807C36FB1F14F3C", hash_generated_field = "691C04E05AC23F83FF5C8CDB3328B8ED")

        long qb;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "9300C96AAEC324987EA5CA6E13A02EDA", hash_generated_field = "C837DB7B40EE95DCD5A34423EAF7C2B6")

        long qc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "98877902E81C1A83B58EEE2FF38DD17B", hash_generated_field = "91773591A5407D8E2D5234C2E0661439")

        long qd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "4D6E7051B02397D7733EA9A222FDB8E0", hash_generated_field = "2E6D34B3E7F049D1453E6B068E27473D")

        long qe;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_method = "EA0EDCFF10F8D9E7849DBDB76AB4743F", hash_generated_method = "EA0EDCFF10F8D9E7849DBDB76AB4743F")
        public Slot ()
        {
            
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "08206593AD53118A4399D95F1F5F27A3", hash_generated_field = "8FD1D00BA6B52C5E0CB71DFCD385247C")

    private static final int NCPU = Runtime.getRuntime().availableProcessors();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "C921C4C9D464325B11257C5AEBD1AAA3", hash_generated_field = "E87A8F05D56205E03FD465D71DDC4E64")

    private static final int CAPACITY = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "BDDDCA2C7CA0962F138AEC5FC6D88260", hash_generated_field = "19CBB79F5BAC3C02E55420AC3E96D83F")

    private static final int FULL = Math.max(0, Math.min(CAPACITY, NCPU / 2) - 1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "6B1F0AEC6B8E3406CF74EC7739A70A1F", hash_generated_field = "DD5CFF62634AED5D259CB7E2ADD5133B")

    private static final int SPINS = (NCPU == 1) ? 0 : 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "1E9DADE18B04D44B76130EF230C9444A", hash_generated_field = "76DBAB4631B1B171678A47C88BDDACA5")

    private static final int TIMED_SPINS = SPINS / 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "4EE4680976B68C20E5AEA92BA17B7949", hash_generated_field = "3B0C3CB8323B5C5F4FF4411ED327CEBB")

    private static final Object CANCEL = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.779 -0400", hash_original_field = "1753013D4B829E720100840E87754B47", hash_generated_field = "C3444CF75E87B7410DAF194724DC011B")

    private static final Object NULL_ITEM = new Object();
}

