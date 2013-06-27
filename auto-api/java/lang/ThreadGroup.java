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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.554 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.554 -0400", hash_original_field = "7005D74F5B8E4D2D07E778F4D2499AE7", hash_generated_field = "BAE3A77CD99CEF534E87AE87746C2800")

    private int maxPriority = Thread.MAX_PRIORITY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.554 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "921B83C68DF8C2D2905E66FA6268F314")

    ThreadGroup parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.554 -0400", hash_original_field = "1E4C064ED2AB9E0FCD37DF408927B55F", hash_generated_field = "002986617C38E42C7A7087B56209B7EB")

    private List<WeakReference<Thread>> threadRefs = new ArrayList<WeakReference<Thread>>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.554 -0400", hash_original_field = "B4933EA45A022B5606D665A127322C47", hash_generated_field = "0E403C6139C11C483C51C1A19B486E07")

    private Iterable<Thread> threads = CollectionUtils.dereferenceIterable(threadRefs, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.554 -0400", hash_original_field = "D3B573D0607A9BB00C5811DCD4D5EBA5", hash_generated_field = "A8F9CEF629406652D1853294F662D860")

    private List<ThreadGroup> groups = new ArrayList<ThreadGroup>(3);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.554 -0400", hash_original_field = "1CFEB9E5381AE97C57DD59616C5FA3B7", hash_generated_field = "99285F53C75B3E4B14C168653E64D131")

    private boolean isDaemon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.554 -0400", hash_original_field = "090F38A7DDDF192B3BA702F9AFFD747C", hash_generated_field = "1D1E680624D89261892D686BAD995D69")

    private boolean isDestroyed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.554 -0400", hash_original_method = "15CA8765FCB0FEEB29D720D0682BEE22", hash_generated_method = "3B996292AFF43978FACFCB1859624595")
    public  ThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.555 -0400", hash_original_method = "E77CFC99E1E2014F4D8FD3506A5DB87B", hash_generated_method = "DB602068F65217891DA48CEE77E8465A")
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
                boolean varFED4C748A11E2972650853AC0BAD4EA5_707281635 = (parent.isDaemon());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.555 -0400", hash_original_method = "2C0349D8A755A992C407F37169B24D0C", hash_generated_method = "2023BF93A9F5BDCA687CAB745D1EC815")
    private  ThreadGroup() {
        this.name = "system";
        this.parent = null;
        // ---------- Original Method ----------
        //this.name = "system";
        //this.parent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.603 -0400", hash_original_method = "F6402A744D3DEB7896E39C3D58ADE009", hash_generated_method = "053D382B6E1634165656AF58FFCF21E1")
    public int activeCount() {
        int count;
        count = 0;
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_822450497 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_822450497.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_822450497.next();
                {
                    {
                        boolean var834F52F70C5641CAD7243A6F3EDD4895_1707852877 = (thread.isAlive());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1569790997 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1569790997.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1569790997.next();
                {
                    count += group.activeCount();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854652646 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854652646;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.632 -0400", hash_original_method = "AF255D2A52D389FA67BDDD4C4590191B", hash_generated_method = "F5FE2448EFBA81CE3F5958DBD86A26D7")
    public int activeGroupCount() {
        int count;
        count = 0;
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_551994299 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_551994299.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_551994299.next();
                {
                    count += 1 + group.activeGroupCount();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941545608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941545608;
        // ---------- Original Method ----------
        //int count = 0;
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //count += 1 + group.activeGroupCount();
            //}
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.632 -0400", hash_original_method = "0DD772AEDB7C823C2E91BB6377F03397", hash_generated_method = "9445FFA636847F148ABE97326359B6CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.633 -0400", hash_original_method = "17B34AC990B7E085858AFAD80E625CEB", hash_generated_method = "E113CF138EF3FF31939B1435FD5F46FA")
    @Deprecated
    public boolean allowThreadSuspension(boolean b) {
        addTaint(b);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966142606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_966142606;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.633 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.640 -0400", hash_original_method = "662D73EDBF2256DFDB84D7DB5F6E6941", hash_generated_method = "C9B4A8AF26AD23B65FC093DAB5E37EAC")
    public final void destroy() {
        {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Thread group was already destroyed: "
                            + (this.name != null ? this.name : "n/a"));
                } //End block
                {
                    boolean var4F3363F09CB0420EE52F5462232AF87C_426627456 = (threads.iterator().hasNext());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Thread group still contains threads: "
                            + (this.name != null ? this.name : "n/a"));
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var8AFDB33FE984B1BEC548EC5D0AA95D11_1602108656 = (!groups.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.641 -0400", hash_original_method = "CD7DBC672D59D1FAACCF6E53D785D515", hash_generated_method = "0D44B72AFAFF6B8AE3B888253434B91B")
    private void destroyIfEmptyDaemon() {
        {
            {
                boolean var0F38E3A4D4DD70793D9FF286586CF52A_1365416422 = (isDaemon && !isDestroyed && !threads.iterator().hasNext());
                {
                    {
                        {
                            boolean var8F90CF27032DACBA87BBBEC3837FEC96_1562183451 = (groups.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.641 -0400", hash_original_method = "4F115C3CD94EE462D7FE29C66038CE8B", hash_generated_method = "EB94C3B50578EF0FFB79483B582A99FF")
    public int enumerate(Thread[] threads) {
        int var5F6FD2F78326CE493B1F98DDADE5E7F1_1989462508 = (enumerate(threads, true));
        addTaint(threads[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77171296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77171296;
        // ---------- Original Method ----------
        //return enumerate(threads, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.641 -0400", hash_original_method = "7C9447501CA37C2477868C242A118750", hash_generated_method = "49FB37FDE787D60A6A1180E5F5A4A752")
    public int enumerate(Thread[] threads, boolean recurse) {
        int var8E78C5862A409D685DBDC97F9BEAC903_639475675 = (enumerateGeneric(threads, recurse, 0, true));
        addTaint(threads[0].getTaint());
        addTaint(recurse);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814429604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814429604;
        // ---------- Original Method ----------
        //return enumerateGeneric(threads, recurse, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.642 -0400", hash_original_method = "CA294C4CBD805FDF86CE51E26A265568", hash_generated_method = "2454C28F5528F380A33A811F0C7DF9EF")
    public int enumerate(ThreadGroup[] groups) {
        int var7A6207DCB59F340F672156C8F350F74C_1251054209 = (enumerate(groups, true));
        addTaint(groups[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180907813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180907813;
        // ---------- Original Method ----------
        //return enumerate(groups, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.642 -0400", hash_original_method = "C3125975C33A76683DB83E92F1059496", hash_generated_method = "B6B1FB28F238543FA1C48483EF4D03EF")
    public int enumerate(ThreadGroup[] groups, boolean recurse) {
        int var9BDBAFB14FA45713AA26AA5DDC79F957_1000499887 = (enumerateGeneric(groups, recurse, 0, false));
        addTaint(groups[0].getTaint());
        addTaint(recurse);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331522668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331522668;
        // ---------- Original Method ----------
        //return enumerateGeneric(groups, recurse, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.772 -0400", hash_original_method = "7CEEE4341262A9B70C3A153644CFBA1A", hash_generated_method = "8398BE0D199F7C1CC9F281768F54E290")
    private int enumerateGeneric(Object[] enumeration, boolean recurse, int enumerationIndex,
            boolean enumeratingThreads) {
        {
            {
                {
                    int i;
                    i = threadRefs.size() - 1;
                    {
                        Thread thread;
                        thread = threadRefs.get(i).get();
                        {
                            boolean var65C9C2AD7E143DAAAF5F0F54E1E31CC6_1400033440 = (thread != null && thread.isAlive());
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
                    int i;
                    i = groups.size() - 1;
                    {
                        enumeration[enumerationIndex++] = groups.get(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_207284417 = (groups).iterator();
                    var54EA1B7E21F6B1B7A595CF2D130BDF63_207284417.hasNext();
                    ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_207284417.next();
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009258640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009258640;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.772 -0400", hash_original_method = "DB664BE89D62AA134945B6EEF3A0CB00", hash_generated_method = "9DFF5CD88BED90817B931614C806D226")
    public final int getMaxPriority() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1105587745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1105587745;
        // ---------- Original Method ----------
        //return maxPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.773 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "7343F8328BB50E21ECD4160054A14F7B")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_905802020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_905802020 = name;
        varB4EAC82CA7396A68D541C85D26508E83_905802020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_905802020;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.780 -0400", hash_original_method = "8A85A1BC7F9CDC3D0187C50787EE4700", hash_generated_method = "298CFFE1D388AEAAA697DA5BF1B95660")
    public final ThreadGroup getParent() {
        ThreadGroup varB4EAC82CA7396A68D541C85D26508E83_1475973854 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1475973854 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1475973854.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1475973854;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.836 -0400", hash_original_method = "2F1556F9A0B232F489BC24F1BD1E38E0", hash_generated_method = "EFA273F4EB42243790241C9F44AAB36E")
    public final void interrupt() {
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_1300529224 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_1300529224.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_1300529224.next();
                {
                    thread.interrupt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_680426399 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_680426399.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_680426399.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.853 -0400", hash_original_method = "5976FB7C02B0576FC514CB127C4662D8", hash_generated_method = "E91FC9AB95031922869732A46DA4B774")
    public final boolean isDaemon() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408524388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_408524388;
        // ---------- Original Method ----------
        //return isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.853 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "1EC308C69428CF0C98390E565FAEF9ED")
    public synchronized boolean isDestroyed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39874576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_39874576;
        // ---------- Original Method ----------
        //return isDestroyed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.853 -0400", hash_original_method = "8CFF2ECA4877D9633C2E3E2E2839A20E", hash_generated_method = "C6E05FAED89AA6A1B46B82F7A311D5CC")
    public void list() {
        System.out.println();
        list(0);
        // ---------- Original Method ----------
        //System.out.println();
        //list(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.962 -0400", hash_original_method = "38F7DBD37EF32F68FFB89F20FFE0F443", hash_generated_method = "AFBD9634B843BE2B1A145A4AF19337B9")
    private void list(int levels) {
        indent(levels);
        System.out.println(this.toString());
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_11991319 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_11991319.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_11991319.next();
                {
                    indent(levels);
                    System.out.println(thread);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1596152932 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1596152932.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1596152932.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.963 -0400", hash_original_method = "074D68FF209CFCAF4851113378206A39", hash_generated_method = "D8090481833ECB195E44C71F0CEE0818")
    private void indent(int levels) {
        {
            int i;
            i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.977 -0400", hash_original_method = "47457D8FCC611743893B7B7E5D80876A", hash_generated_method = "4CDBA2E06B60819EF505B66E370D6C49")
    public final boolean parentOf(ThreadGroup g) {
        {
            g = g.parent;
        } //End block
        addTaint(g.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_871435519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_871435519;
        // ---------- Original Method ----------
        //while (g != null) {
            //if (this == g) {
                //return true;
            //}
            //g = g.parent;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.978 -0400", hash_original_method = "7E8DD532FE0D28207249CA86D60AFD62", hash_generated_method = "13B95385624AC671ADD6DF36FFD3B254")
    private void remove(ThreadGroup g) {
        {
            {
                Iterator<ThreadGroup> i;
                i = groups.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_2032351294 = (i.hasNext());
                {
                    ThreadGroup threadGroup;
                    threadGroup = i.next();
                    {
                        boolean varA1BDBEBB1E64746EF11DB086EC5CF143_1025197140 = (threadGroup.equals(g));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.066 -0400", hash_original_method = "DD66491EA6460453E572207637EFB169", hash_generated_method = "0745C42905149580EAB2A7DE604E5650")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void resume() {
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_1684230602 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_1684230602.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_1684230602.next();
                {
                    thread.resume();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1764349435 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1764349435.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1764349435.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.072 -0400", hash_original_method = "8335FAF0BC3ED6B3C58B58617340A520", hash_generated_method = "41930952754EA7B18095BC1B8F27AACA")
    public final void setDaemon(boolean isDaemon) {
        this.isDaemon = isDaemon;
        // ---------- Original Method ----------
        //this.isDaemon = isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.115 -0400", hash_original_method = "271C3F89CA43821F381115CC8E2996B2", hash_generated_method = "237A2AA5F00497C9ED3BAEF724DEC8A5")
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
                    Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_924548257 = (groups).iterator();
                    var54EA1B7E21F6B1B7A595CF2D130BDF63_924548257.hasNext();
                    ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_924548257.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.116 -0400", hash_original_method = "59A4D041306D60B1EF57E2C22E471227", hash_generated_method = "1FE23ECA073B37C9D485332DEC6A6ECA")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void stop() {
        {
            boolean var5EC1541CA58351A27FD981B0159181A0_485195076 = (stopHelper());
            {
                Thread.currentThread().stop();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (stopHelper()) {
            //Thread.currentThread().stop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.217 -0400", hash_original_method = "F86867FC41FDF8B0075237470EA8A18F", hash_generated_method = "07CDB77A50E22DA451C8C2F57845A7F2")
    @SuppressWarnings("deprecation")
    private boolean stopHelper() {
        boolean stopCurrent;
        stopCurrent = false;
        {
            Thread current;
            current = Thread.currentThread();
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_84725351 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_84725351.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_84725351.next();
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
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1822350721 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1822350721.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1822350721.next();
                {
                    stopCurrent |= group.stopHelper();
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_20881901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_20881901;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.218 -0400", hash_original_method = "26CED40B1639307872B1DC8622DA2669", hash_generated_method = "3737D7375C2D7E32B05D327D32E39430")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void suspend() {
        {
            boolean var447388F3E04DA462654DDAC740A6E72A_1121971603 = (suspendHelper());
            {
                Thread.currentThread().suspend();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (suspendHelper()) {
            //Thread.currentThread().suspend();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.315 -0400", hash_original_method = "664C597F1857BDEBDBE75F13D3F147B7", hash_generated_method = "C543305BF5A397A8F26D128F8F84B6C4")
    @SuppressWarnings("deprecation")
    private boolean suspendHelper() {
        boolean suspendCurrent;
        suspendCurrent = false;
        {
            Thread current;
            current = Thread.currentThread();
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_1550607685 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_1550607685.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_1550607685.next();
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
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_846425529 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_846425529.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_846425529.next();
                {
                    suspendCurrent |= group.suspendHelper();
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_46729422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_46729422;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.316 -0400", hash_original_method = "54318ADB79169F8C74CBC002CF89020D", hash_generated_method = "99FE142E7A96B0437A6309B9C2E592A5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1825475951 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1825475951 = getClass().getName() + "[name=" + getName()
                + ",maxPriority=" + getMaxPriority() + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1825475951.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1825475951;
        // ---------- Original Method ----------
        //return getClass().getName() + "[name=" + getName()
                //+ ",maxPriority=" + getMaxPriority() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.317 -0400", hash_original_method = "1AEEC9D33E82C49A9FE6D436A43A8349", hash_generated_method = "89E7A52FE64D1A7A8E5C2FAB52DF1506")
    public void uncaughtException(Thread t, Throwable e) {
        {
            parent.uncaughtException(t, e);
        } //End block
        {
            boolean var87252FF6409F65E0E51F15C36C8E7DAD_408987020 = (Thread.getDefaultUncaughtExceptionHandler() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.317 -0400", hash_original_method = "2D14DBB3818CDCF2DBAC484BFFF8FD8D", hash_generated_method = "4AC8CAED0C30B6D4B76BC53C37D59BCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.318 -0400", hash_original_method = "37129B7DF3D611DDAA565F6673B5A889", hash_generated_method = "CB3F0EF429CC406751175469AB294F92")
    final void removeThread(Thread thread) throws IllegalThreadStateException {
        {
            {
                Iterator<Thread> i;
                i = threads.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1820444150 = (i.hasNext());
                {
                    {
                        boolean var4E3494244B23B077D5079C96D43BDFE5_2011078331 = (i.next().equals(thread));
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.318 -0400", hash_original_field = "70A32802F055FB9A8B4FBD04FF20DFF8", hash_generated_field = "148D880FA6D71711053EBC20ACEE69D4")

    static ThreadGroup mSystem = new ThreadGroup();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.318 -0400", hash_original_field = "6FE2FE3A7188BFD5BCCC556BE6D6F073", hash_generated_field = "6AF03139B67DE22B3FA9731EC6FAC9A2")

    static ThreadGroup mMain = new ThreadGroup(mSystem, "main");
}

