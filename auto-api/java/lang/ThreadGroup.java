package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.util.CollectionUtils;

public class ThreadGroup implements Thread.UncaughtExceptionHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.213 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.213 -0400", hash_original_field = "7005D74F5B8E4D2D07E778F4D2499AE7", hash_generated_field = "BAE3A77CD99CEF534E87AE87746C2800")

    private int maxPriority = Thread.MAX_PRIORITY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.213 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "921B83C68DF8C2D2905E66FA6268F314")

    ThreadGroup parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.213 -0400", hash_original_field = "1E4C064ED2AB9E0FCD37DF408927B55F", hash_generated_field = "F1B2F3B9F625FA1FE59B2C7FAD18AF4A")

    private final List<WeakReference<Thread>> threadRefs = new ArrayList<WeakReference<Thread>>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.213 -0400", hash_original_field = "B4933EA45A022B5606D665A127322C47", hash_generated_field = "BAAC9A9E91234825CA85E995F8623CDF")

    private final Iterable<Thread> threads = CollectionUtils.dereferenceIterable(threadRefs, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.213 -0400", hash_original_field = "D3B573D0607A9BB00C5811DCD4D5EBA5", hash_generated_field = "7493BFD7B9E904844C38FDDC4FA574AD")

    private final List<ThreadGroup> groups = new ArrayList<ThreadGroup>(3);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.213 -0400", hash_original_field = "1CFEB9E5381AE97C57DD59616C5FA3B7", hash_generated_field = "99285F53C75B3E4B14C168653E64D131")

    private boolean isDaemon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.213 -0400", hash_original_field = "090F38A7DDDF192B3BA702F9AFFD747C", hash_generated_field = "1D1E680624D89261892D686BAD995D69")

    private boolean isDestroyed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.213 -0400", hash_original_method = "15CA8765FCB0FEEB29D720D0682BEE22", hash_generated_method = "3B996292AFF43978FACFCB1859624595")
    public  ThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.214 -0400", hash_original_method = "E77CFC99E1E2014F4D8FD3506A5DB87B", hash_generated_method = "12E3C0530735B26A4DB0BE230C17918E")
    public  ThreadGroup(ThreadGroup parent, String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("parent == null");
        } //End block
        this.name = name;
        this.parent = parent;
        {
            parent.add(this);
            this.setMaxPriority(parent.getMaxPriority());
            {
                boolean varFED4C748A11E2972650853AC0BAD4EA5_964939785 = (parent.isDaemon());
                {
                    this.setDaemon(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (parent == null) {
            //throw new NullPointerException("parent == null");
        //}
        //this.name = name;
        //this.parent = parent;
        //if (parent != null) {
            //parent.add(this);
            //this.setMaxPriority(parent.getMaxPriority());
            //if (parent.isDaemon()) {
                //this.setDaemon(true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.214 -0400", hash_original_method = "2C0349D8A755A992C407F37169B24D0C", hash_generated_method = "2023BF93A9F5BDCA687CAB745D1EC815")
    private  ThreadGroup() {
        this.name = "system";
        this.parent = null;
        // ---------- Original Method ----------
        //this.name = "system";
        //this.parent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.220 -0400", hash_original_method = "F6402A744D3DEB7896E39C3D58ADE009", hash_generated_method = "92CF43978E06888513660390DBCBA1D4")
    public int activeCount() {
        int count = 0;
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_1095645987 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_1095645987.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_1095645987.next();
                {
                    {
                        boolean var834F52F70C5641CAD7243A6F3EDD4895_135021893 = (thread.isAlive());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_241473586 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_241473586.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_241473586.next();
                {
                    count += group.activeCount();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89166524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89166524;
        // ---------- Original Method ----------
        //int count = 0;
        //synchronized (threadRefs) {
            //for (Thread thread : threads) {
                //if (thread.isAlive()) {
                    //count++;
                //}
            //}
        //}
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //count += group.activeCount();
            //}
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.224 -0400", hash_original_method = "AF255D2A52D389FA67BDDD4C4590191B", hash_generated_method = "A6A63E074A4F08E46588AB69F3B729AA")
    public int activeGroupCount() {
        int count = 0;
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_635856663 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_635856663.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_635856663.next();
                {
                    count += 1 + group.activeGroupCount();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943527457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1943527457;
        // ---------- Original Method ----------
        //int count = 0;
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //count += 1 + group.activeGroupCount();
            //}
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.225 -0400", hash_original_method = "0DD772AEDB7C823C2E91BB6377F03397", hash_generated_method = "9445FFA636847F148ABE97326359B6CB")
    private void add(ThreadGroup g) throws IllegalThreadStateException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException();
            } //End block
            groups.add(g);
        } //End block
        addTaint(g.getTaint());
        // ---------- Original Method ----------
        //synchronized (groups) {
            //if (isDestroyed) {
                //throw new IllegalThreadStateException();
            //}
            //groups.add(g);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.225 -0400", hash_original_method = "17B34AC990B7E085858AFAD80E625CEB", hash_generated_method = "710063584B909B97C782B20A8C1B6F1A")
    @Deprecated
    public boolean allowThreadSuspension(boolean b) {
        addTaint(b);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_855821940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_855821940;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.225 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.225 -0400", hash_original_method = "662D73EDBF2256DFDB84D7DB5F6E6941", hash_generated_method = "7A2C3C6F4BD53A009F4B02A8B2FF6CF6")
    public final void destroy() {
        {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Thread group was already destroyed: "
                            + (this.name != null ? this.name : "n/a"));
                } //End block
                {
                    boolean var4F3363F09CB0420EE52F5462232AF87C_518672401 = (threads.iterator().hasNext());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Thread group still contains threads: "
                            + (this.name != null ? this.name : "n/a"));
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var8AFDB33FE984B1BEC548EC5D0AA95D11_484820218 = (!groups.isEmpty());
                    {
                        groups.get(0).destroy();
                    } //End block
                } //End collapsed parenthetic
                {
                    parent.remove(this);
                } //End block
                this.isDestroyed = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.226 -0400", hash_original_method = "CD7DBC672D59D1FAACCF6E53D785D515", hash_generated_method = "381FD2474A3DB1F94696D870A18D8BD3")
    private void destroyIfEmptyDaemon() {
        {
            {
                boolean var0F38E3A4D4DD70793D9FF286586CF52A_112820604 = (isDaemon && !isDestroyed && !threads.iterator().hasNext());
                {
                    {
                        {
                            boolean var8F90CF27032DACBA87BBBEC3837FEC96_375003425 = (groups.isEmpty());
                            {
                                destroy();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (threadRefs) {
            //if (isDaemon && !isDestroyed && !threads.iterator().hasNext()) {
                //synchronized (groups) {
                    //if (groups.isEmpty()) {
                        //destroy();
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.226 -0400", hash_original_method = "4F115C3CD94EE462D7FE29C66038CE8B", hash_generated_method = "1D1894373D5EEF85A4B0AD35D96032BE")
    public int enumerate(Thread[] threads) {
        int var5F6FD2F78326CE493B1F98DDADE5E7F1_13806467 = (enumerate(threads, true));
        addTaint(threads[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156395187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156395187;
        // ---------- Original Method ----------
        //return enumerate(threads, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.226 -0400", hash_original_method = "7C9447501CA37C2477868C242A118750", hash_generated_method = "E62F99AF0C8E557DB810C0F9B676B3F0")
    public int enumerate(Thread[] threads, boolean recurse) {
        int var8E78C5862A409D685DBDC97F9BEAC903_1871509074 = (enumerateGeneric(threads, recurse, 0, true));
        addTaint(threads[0].getTaint());
        addTaint(recurse);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58721084 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58721084;
        // ---------- Original Method ----------
        //return enumerateGeneric(threads, recurse, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.226 -0400", hash_original_method = "CA294C4CBD805FDF86CE51E26A265568", hash_generated_method = "FD65D4B0C604E98ABE1A8960D1779E4A")
    public int enumerate(ThreadGroup[] groups) {
        int var7A6207DCB59F340F672156C8F350F74C_1450417726 = (enumerate(groups, true));
        addTaint(groups[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233087211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233087211;
        // ---------- Original Method ----------
        //return enumerate(groups, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.226 -0400", hash_original_method = "C3125975C33A76683DB83E92F1059496", hash_generated_method = "DAE7E036DB5B145058C70E1B13265C1B")
    public int enumerate(ThreadGroup[] groups, boolean recurse) {
        int var9BDBAFB14FA45713AA26AA5DDC79F957_1041454496 = (enumerateGeneric(groups, recurse, 0, false));
        addTaint(groups[0].getTaint());
        addTaint(recurse);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581709285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581709285;
        // ---------- Original Method ----------
        //return enumerateGeneric(groups, recurse, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.263 -0400", hash_original_method = "7CEEE4341262A9B70C3A153644CFBA1A", hash_generated_method = "DA6DB23AE5DA0836DE26F33660B10014")
    private int enumerateGeneric(Object[] enumeration, boolean recurse, int enumerationIndex,
            boolean enumeratingThreads) {
        {
            {
                {
                    int i = threadRefs.size() - 1;
                    {
                        Thread thread = threadRefs.get(i).get();
                        {
                            boolean var65C9C2AD7E143DAAAF5F0F54E1E31CC6_2118583725 = (thread != null && thread.isAlive());
                            {
                                enumeration[enumerationIndex++] = thread;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    int i = groups.size() - 1;
                    {
                        enumeration[enumerationIndex++] = groups.get(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1772096707 = (groups).iterator();
                    var54EA1B7E21F6B1B7A595CF2D130BDF63_1772096707.hasNext();
                    ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1772096707.next();
                    {
                        enumerationIndex = group.enumerateGeneric(enumeration, recurse,
                            enumerationIndex, enumeratingThreads);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(enumeration[0].getTaint());
        addTaint(recurse);
        addTaint(enumerationIndex);
        addTaint(enumeratingThreads);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1256724549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1256724549;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.264 -0400", hash_original_method = "DB664BE89D62AA134945B6EEF3A0CB00", hash_generated_method = "743CDD0997645C9C75FE26F9C8834FAF")
    public final int getMaxPriority() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896402883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896402883;
        // ---------- Original Method ----------
        //return maxPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.267 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "7BBC0C351A2AD5FB2B73B60F408D8B4F")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_705479222 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_705479222 = name;
        varB4EAC82CA7396A68D541C85D26508E83_705479222.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_705479222;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.270 -0400", hash_original_method = "8A85A1BC7F9CDC3D0187C50787EE4700", hash_generated_method = "F4C9A9E3476241892626D68B34FC3723")
    public final ThreadGroup getParent() {
        ThreadGroup varB4EAC82CA7396A68D541C85D26508E83_997444637 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_997444637 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_997444637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_997444637;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.279 -0400", hash_original_method = "2F1556F9A0B232F489BC24F1BD1E38E0", hash_generated_method = "BCBB445F82C9AC6C8A79C0F4D4C0DFB8")
    public final void interrupt() {
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_1997883302 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_1997883302.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_1997883302.next();
                {
                    thread.interrupt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_445522532 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_445522532.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_445522532.next();
                {
                    group.interrupt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (threadRefs) {
            //for (Thread thread : threads) {
                //thread.interrupt();
            //}
        //}
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //group.interrupt();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.280 -0400", hash_original_method = "5976FB7C02B0576FC514CB127C4662D8", hash_generated_method = "6BCF8028A412F054EB75750BB727588B")
    public final boolean isDaemon() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1125101121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1125101121;
        // ---------- Original Method ----------
        //return isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.281 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "0AD6437F320DE4BEAFD52ACA016C3245")
    public synchronized boolean isDestroyed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268531986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268531986;
        // ---------- Original Method ----------
        //return isDestroyed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.284 -0400", hash_original_method = "8CFF2ECA4877D9633C2E3E2E2839A20E", hash_generated_method = "C6E05FAED89AA6A1B46B82F7A311D5CC")
    public void list() {
        System.out.println();
        list(0);
        // ---------- Original Method ----------
        //System.out.println();
        //list(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.296 -0400", hash_original_method = "38F7DBD37EF32F68FFB89F20FFE0F443", hash_generated_method = "0833487812DC54115EE189949A2A7DCC")
    private void list(int levels) {
        indent(levels);
        System.out.println(this.toString());
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_286780697 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_286780697.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_286780697.next();
                {
                    indent(levels);
                    System.out.println(thread);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_544045682 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_544045682.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_544045682.next();
                {
                    group.list(levels);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(levels);
        // ---------- Original Method ----------
        //indent(levels);
        //System.out.println(this.toString());
        //++levels;
        //synchronized (threadRefs) {
            //for (Thread thread : threads) {
                //indent(levels);
                //System.out.println(thread);
            //}
        //}
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //group.list(levels);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.297 -0400", hash_original_method = "074D68FF209CFCAF4851113378206A39", hash_generated_method = "4BF7564CE2961B2B13928D69B5D0B141")
    private void indent(int levels) {
        {
            int i = 0;
            {
                System.out.print("    ");
            } //End block
        } //End collapsed parenthetic
        addTaint(levels);
        // ---------- Original Method ----------
        //for (int i = 0; i < levels; i++) {
            //System.out.print("    "); 
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.298 -0400", hash_original_method = "47457D8FCC611743893B7B7E5D80876A", hash_generated_method = "FFBCE65EB03F65C8D49C93A5F3E5E88C")
    public final boolean parentOf(ThreadGroup g) {
        {
            g = g.parent;
        } //End block
        addTaint(g.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622610996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622610996;
        // ---------- Original Method ----------
        //while (g != null) {
            //if (this == g) {
                //return true;
            //}
            //g = g.parent;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.300 -0400", hash_original_method = "7E8DD532FE0D28207249CA86D60AFD62", hash_generated_method = "35FD7A416BA1858D39650DDC91A25FFE")
    private void remove(ThreadGroup g) {
        {
            {
                Iterator<ThreadGroup> i = groups.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1152765037 = (i.hasNext());
                {
                    ThreadGroup threadGroup = i.next();
                    {
                        boolean varA1BDBEBB1E64746EF11DB086EC5CF143_1101150573 = (threadGroup.equals(g));
                        {
                            i.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        destroyIfEmptyDaemon();
        addTaint(g.getTaint());
        // ---------- Original Method ----------
        //synchronized (groups) {
            //for (Iterator<ThreadGroup> i = groups.iterator(); i.hasNext(); ) {
                //ThreadGroup threadGroup = i.next();
                //if (threadGroup.equals(g)) {
                    //i.remove();
                    //break;
                //}
            //}
        //}
        //destroyIfEmptyDaemon();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.310 -0400", hash_original_method = "DD66491EA6460453E572207637EFB169", hash_generated_method = "11988DD22E8758B34881286E9080D060")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void resume() {
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_687146778 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_687146778.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_687146778.next();
                {
                    thread.resume();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_207695147 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_207695147.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_207695147.next();
                {
                    group.resume();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (threadRefs) {
            //for (Thread thread : threads) {
                //thread.resume();
            //}
        //}
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //group.resume();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.311 -0400", hash_original_method = "8335FAF0BC3ED6B3C58B58617340A520", hash_generated_method = "41930952754EA7B18095BC1B8F27AACA")
    public final void setDaemon(boolean isDaemon) {
        this.isDaemon = isDaemon;
        // ---------- Original Method ----------
        //this.isDaemon = isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.318 -0400", hash_original_method = "271C3F89CA43821F381115CC8E2996B2", hash_generated_method = "95A5E7793FA6488857F12CE81BAC04E6")
    public final void setMaxPriority(int newMax) {
        {
            {
                newMax = Thread.MIN_PRIORITY;
            } //End block
            int parentPriority;
            parentPriority = newMax;
            parentPriority = parent.getMaxPriority();
            this.maxPriority = parentPriority <= newMax ? parentPriority : newMax;
            {
                {
                    Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_2013084527 = (groups).iterator();
                    var54EA1B7E21F6B1B7A595CF2D130BDF63_2013084527.hasNext();
                    ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_2013084527.next();
                    {
                        group.setMaxPriority(newMax);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (newMax <= this.maxPriority) {
            //if (newMax < Thread.MIN_PRIORITY) {
                //newMax = Thread.MIN_PRIORITY;
            //}
            //int parentPriority = parent == null ? newMax : parent.getMaxPriority();
            //this.maxPriority = parentPriority <= newMax ? parentPriority : newMax;
            //synchronized (groups) {
                //for (ThreadGroup group : groups) {
                    //group.setMaxPriority(newMax);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.319 -0400", hash_original_method = "59A4D041306D60B1EF57E2C22E471227", hash_generated_method = "1D611A4351C57768137F33DAA0952B4B")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void stop() {
        {
            boolean var5EC1541CA58351A27FD981B0159181A0_102887585 = (stopHelper());
            {
                Thread.currentThread().stop();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (stopHelper()) {
            //Thread.currentThread().stop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.327 -0400", hash_original_method = "F86867FC41FDF8B0075237470EA8A18F", hash_generated_method = "D32129CAFB8F8829E681C2C29B835F5F")
    @SuppressWarnings("deprecation")
    private boolean stopHelper() {
        boolean stopCurrent = false;
        {
            Thread current = Thread.currentThread();
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_1226234346 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_1226234346.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_1226234346.next();
                {
                    {
                        stopCurrent = true;
                    } //End block
                    {
                        thread.stop();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1133979742 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1133979742.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1133979742.next();
                {
                    stopCurrent |= group.stopHelper();
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372292277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_372292277;
        // ---------- Original Method ----------
        //boolean stopCurrent = false;
        //synchronized (threadRefs) {
            //Thread current = Thread.currentThread();
            //for (Thread thread : threads) {
                //if (thread == current) {
                    //stopCurrent = true;
                //} else {
                    //thread.stop();
                //}
            //}
        //}
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //stopCurrent |= group.stopHelper();
            //}
        //}
        //return stopCurrent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.328 -0400", hash_original_method = "26CED40B1639307872B1DC8622DA2669", hash_generated_method = "3E888358E06E087689B7C68428BCF863")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void suspend() {
        {
            boolean var447388F3E04DA462654DDAC740A6E72A_1224330226 = (suspendHelper());
            {
                Thread.currentThread().suspend();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (suspendHelper()) {
            //Thread.currentThread().suspend();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.336 -0400", hash_original_method = "664C597F1857BDEBDBE75F13D3F147B7", hash_generated_method = "7CC6D63F66ADD9087FE9A26C252B885E")
    @SuppressWarnings("deprecation")
    private boolean suspendHelper() {
        boolean suspendCurrent = false;
        {
            Thread current = Thread.currentThread();
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_553799163 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_553799163.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_553799163.next();
                {
                    {
                        suspendCurrent = true;
                    } //End block
                    {
                        thread.suspend();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_2021582117 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_2021582117.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_2021582117.next();
                {
                    suspendCurrent |= group.suspendHelper();
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196884079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_196884079;
        // ---------- Original Method ----------
        //boolean suspendCurrent = false;
        //synchronized (threadRefs) {
            //Thread current = Thread.currentThread();
            //for (Thread thread : threads) {
                //if (thread == current) {
                    //suspendCurrent = true;
                //} else {
                    //thread.suspend();
                //}
            //}
        //}
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //suspendCurrent |= group.suspendHelper();
            //}
        //}
        //return suspendCurrent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.336 -0400", hash_original_method = "54318ADB79169F8C74CBC002CF89020D", hash_generated_method = "E8B25AFF66E0D8F349D6CF3EE5054332")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1225537304 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1225537304 = getClass().getName() + "[name=" + getName()
                + ",maxPriority=" + getMaxPriority() + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1225537304.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1225537304;
        // ---------- Original Method ----------
        //return getClass().getName() + "[name=" + getName()
                //+ ",maxPriority=" + getMaxPriority() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.337 -0400", hash_original_method = "1AEEC9D33E82C49A9FE6D436A43A8349", hash_generated_method = "EB3614CB1BD49054671968BE8F10C919")
    public void uncaughtException(Thread t, Throwable e) {
        {
            parent.uncaughtException(t, e);
        } //End block
        {
            boolean var87252FF6409F65E0E51F15C36C8E7DAD_789704008 = (Thread.getDefaultUncaughtExceptionHandler() != null);
            {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
            } //End block
            {
                e.printStackTrace(System.err);
            } //End block
        } //End collapsed parenthetic
        addTaint(t.getTaint());
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //if (parent != null) {
            //parent.uncaughtException(t, e);
        //} else if (Thread.getDefaultUncaughtExceptionHandler() != null) {
            //Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
        //} else if (!(e instanceof ThreadDeath)) {
            //e.printStackTrace(System.err);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.337 -0400", hash_original_method = "2D14DBB3818CDCF2DBAC484BFFF8FD8D", hash_generated_method = "4AC8CAED0C30B6D4B76BC53C37D59BCB")
    final void addThread(Thread thread) throws IllegalThreadStateException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException();
            } //End block
            threadRefs.add(new WeakReference<Thread>(thread));
        } //End block
        addTaint(thread.getTaint());
        // ---------- Original Method ----------
        //synchronized (threadRefs) {
            //if (isDestroyed) {
                //throw new IllegalThreadStateException();
            //}
            //threadRefs.add(new WeakReference<Thread>(thread));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.338 -0400", hash_original_method = "37129B7DF3D611DDAA565F6673B5A889", hash_generated_method = "570784D9768996E3CE873343ACFB2BA5")
    final void removeThread(Thread thread) throws IllegalThreadStateException {
        {
            {
                Iterator<Thread> i = threads.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_506294526 = (i.hasNext());
                {
                    {
                        boolean var4E3494244B23B077D5079C96D43BDFE5_587687018 = (i.next().equals(thread));
                        {
                            i.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        destroyIfEmptyDaemon();
        addTaint(thread.getTaint());
        // ---------- Original Method ----------
        //synchronized (threadRefs) {
            //for (Iterator<Thread> i = threads.iterator(); i.hasNext(); ) {
                //if (i.next().equals(thread)) {
                    //i.remove();
                    //break;
                //}
            //}
        //}
        //destroyIfEmptyDaemon();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.338 -0400", hash_original_field = "70A32802F055FB9A8B4FBD04FF20DFF8", hash_generated_field = "C469F1CA0F9CB15DC605ADF2C779CB30")

    static final ThreadGroup mSystem = new ThreadGroup();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.338 -0400", hash_original_field = "6FE2FE3A7188BFD5BCCC556BE6D6F073", hash_generated_field = "843DB6CD61C0C78ABA07CFE273D0F240")

    static final ThreadGroup mMain = new ThreadGroup(mSystem, "main");
}

