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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.598 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.598 -0400", hash_original_field = "7005D74F5B8E4D2D07E778F4D2499AE7", hash_generated_field = "BAE3A77CD99CEF534E87AE87746C2800")

    private int maxPriority = Thread.MAX_PRIORITY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.599 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "921B83C68DF8C2D2905E66FA6268F314")

    ThreadGroup parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.599 -0400", hash_original_field = "1E4C064ED2AB9E0FCD37DF408927B55F", hash_generated_field = "002986617C38E42C7A7087B56209B7EB")

    private List<WeakReference<Thread>> threadRefs = new ArrayList<WeakReference<Thread>>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.599 -0400", hash_original_field = "B4933EA45A022B5606D665A127322C47", hash_generated_field = "0E403C6139C11C483C51C1A19B486E07")

    private Iterable<Thread> threads = CollectionUtils.dereferenceIterable(threadRefs, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.599 -0400", hash_original_field = "D3B573D0607A9BB00C5811DCD4D5EBA5", hash_generated_field = "A8F9CEF629406652D1853294F662D860")

    private List<ThreadGroup> groups = new ArrayList<ThreadGroup>(3);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.599 -0400", hash_original_field = "1CFEB9E5381AE97C57DD59616C5FA3B7", hash_generated_field = "99285F53C75B3E4B14C168653E64D131")

    private boolean isDaemon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.599 -0400", hash_original_field = "090F38A7DDDF192B3BA702F9AFFD747C", hash_generated_field = "1D1E680624D89261892D686BAD995D69")

    private boolean isDestroyed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.599 -0400", hash_original_method = "15CA8765FCB0FEEB29D720D0682BEE22", hash_generated_method = "3B996292AFF43978FACFCB1859624595")
    public  ThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.600 -0400", hash_original_method = "E77CFC99E1E2014F4D8FD3506A5DB87B", hash_generated_method = "AE439E596BAC0681EFA485E557A8E95F")
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
                boolean varFED4C748A11E2972650853AC0BAD4EA5_2111767851 = (parent.isDaemon());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.600 -0400", hash_original_method = "2C0349D8A755A992C407F37169B24D0C", hash_generated_method = "2023BF93A9F5BDCA687CAB745D1EC815")
    private  ThreadGroup() {
        this.name = "system";
        this.parent = null;
        // ---------- Original Method ----------
        //this.name = "system";
        //this.parent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.662 -0400", hash_original_method = "F6402A744D3DEB7896E39C3D58ADE009", hash_generated_method = "E53800A0661ADDBED2981CF5C66B8D91")
    public int activeCount() {
        int count;
        count = 0;
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_358686213 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_358686213.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_358686213.next();
                {
                    {
                        boolean var834F52F70C5641CAD7243A6F3EDD4895_1662488910 = (thread.isAlive());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_91873734 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_91873734.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_91873734.next();
                {
                    count += group.activeCount();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045764240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045764240;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.689 -0400", hash_original_method = "AF255D2A52D389FA67BDDD4C4590191B", hash_generated_method = "EDBE1C85C74E9B89E8D492F465232DFC")
    public int activeGroupCount() {
        int count;
        count = 0;
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_905183028 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_905183028.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_905183028.next();
                {
                    count += 1 + group.activeGroupCount();
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1815838496 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1815838496;
        // ---------- Original Method ----------
        //int count = 0;
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //count += 1 + group.activeGroupCount();
            //}
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.689 -0400", hash_original_method = "0DD772AEDB7C823C2E91BB6377F03397", hash_generated_method = "9445FFA636847F148ABE97326359B6CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.690 -0400", hash_original_method = "17B34AC990B7E085858AFAD80E625CEB", hash_generated_method = "4331AAAA4BD3833E28FCFD676D4401EE")
    @Deprecated
    public boolean allowThreadSuspension(boolean b) {
        addTaint(b);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003539669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003539669;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.690 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.690 -0400", hash_original_method = "662D73EDBF2256DFDB84D7DB5F6E6941", hash_generated_method = "7B89925503A0F4B1C1069346B81A1009")
    public final void destroy() {
        {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Thread group was already destroyed: "
                            + (this.name != null ? this.name : "n/a"));
                } //End block
                {
                    boolean var4F3363F09CB0420EE52F5462232AF87C_960779079 = (threads.iterator().hasNext());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Thread group still contains threads: "
                            + (this.name != null ? this.name : "n/a"));
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var8AFDB33FE984B1BEC548EC5D0AA95D11_1615145225 = (!groups.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.693 -0400", hash_original_method = "CD7DBC672D59D1FAACCF6E53D785D515", hash_generated_method = "387C7AF8E8AC04D6A15AF622B1B0BFE6")
    private void destroyIfEmptyDaemon() {
        {
            {
                boolean var0F38E3A4D4DD70793D9FF286586CF52A_968183028 = (isDaemon && !isDestroyed && !threads.iterator().hasNext());
                {
                    {
                        {
                            boolean var8F90CF27032DACBA87BBBEC3837FEC96_498903288 = (groups.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.693 -0400", hash_original_method = "4F115C3CD94EE462D7FE29C66038CE8B", hash_generated_method = "8F2B0C3A177029610DD0B6DDBB4C5BAF")
    public int enumerate(Thread[] threads) {
        int var5F6FD2F78326CE493B1F98DDADE5E7F1_495003897 = (enumerate(threads, true));
        addTaint(threads[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734215762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734215762;
        // ---------- Original Method ----------
        //return enumerate(threads, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.694 -0400", hash_original_method = "7C9447501CA37C2477868C242A118750", hash_generated_method = "E58ECCA64024F87982EBA3F3D3558BE7")
    public int enumerate(Thread[] threads, boolean recurse) {
        int var8E78C5862A409D685DBDC97F9BEAC903_185829656 = (enumerateGeneric(threads, recurse, 0, true));
        addTaint(threads[0].getTaint());
        addTaint(recurse);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_556329997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_556329997;
        // ---------- Original Method ----------
        //return enumerateGeneric(threads, recurse, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.694 -0400", hash_original_method = "CA294C4CBD805FDF86CE51E26A265568", hash_generated_method = "02FB4D96FEB33D76234223DB292932FC")
    public int enumerate(ThreadGroup[] groups) {
        int var7A6207DCB59F340F672156C8F350F74C_1003126638 = (enumerate(groups, true));
        addTaint(groups[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508376344 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_508376344;
        // ---------- Original Method ----------
        //return enumerate(groups, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.694 -0400", hash_original_method = "C3125975C33A76683DB83E92F1059496", hash_generated_method = "B2B7828390634EF494C59455FC71B362")
    public int enumerate(ThreadGroup[] groups, boolean recurse) {
        int var9BDBAFB14FA45713AA26AA5DDC79F957_199595405 = (enumerateGeneric(groups, recurse, 0, false));
        addTaint(groups[0].getTaint());
        addTaint(recurse);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_743504226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_743504226;
        // ---------- Original Method ----------
        //return enumerateGeneric(groups, recurse, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.832 -0400", hash_original_method = "7CEEE4341262A9B70C3A153644CFBA1A", hash_generated_method = "2B4CFC95F2351FE4D3722B187FC98B16")
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
                            boolean var65C9C2AD7E143DAAAF5F0F54E1E31CC6_154086254 = (thread != null && thread.isAlive());
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
                    Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_632208374 = (groups).iterator();
                    var54EA1B7E21F6B1B7A595CF2D130BDF63_632208374.hasNext();
                    ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_632208374.next();
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128414377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128414377;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.833 -0400", hash_original_method = "DB664BE89D62AA134945B6EEF3A0CB00", hash_generated_method = "176608788D108B5116C2AD6FB99012D8")
    public final int getMaxPriority() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303490261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303490261;
        // ---------- Original Method ----------
        //return maxPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.834 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "78DB7E8BBF3168F5F6C358D3688C3AAA")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1560911271 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1560911271 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1560911271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1560911271;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.837 -0400", hash_original_method = "8A85A1BC7F9CDC3D0187C50787EE4700", hash_generated_method = "0A4D276CD4A88D2C4A0AB7FAAE180D8E")
    public final ThreadGroup getParent() {
        ThreadGroup varB4EAC82CA7396A68D541C85D26508E83_487781834 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_487781834 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_487781834.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_487781834;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.890 -0400", hash_original_method = "2F1556F9A0B232F489BC24F1BD1E38E0", hash_generated_method = "27B2FACFD1258BF9EBF728DB60B042D7")
    public final void interrupt() {
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_316430751 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_316430751.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_316430751.next();
                {
                    thread.interrupt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1949116958 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1949116958.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1949116958.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.891 -0400", hash_original_method = "5976FB7C02B0576FC514CB127C4662D8", hash_generated_method = "C01E3E34FC0F7EFB068A3B48D0997B3A")
    public final boolean isDaemon() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965242120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965242120;
        // ---------- Original Method ----------
        //return isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.891 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "E50A7C628416ABEEED0E1743963CF9D7")
    public synchronized boolean isDestroyed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842362574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842362574;
        // ---------- Original Method ----------
        //return isDestroyed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.891 -0400", hash_original_method = "8CFF2ECA4877D9633C2E3E2E2839A20E", hash_generated_method = "C6E05FAED89AA6A1B46B82F7A311D5CC")
    public void list() {
        System.out.println();
        list(0);
        // ---------- Original Method ----------
        //System.out.println();
        //list(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.923 -0400", hash_original_method = "38F7DBD37EF32F68FFB89F20FFE0F443", hash_generated_method = "73B01C591774000F28B19154306EE50C")
    private void list(int levels) {
        indent(levels);
        System.out.println(this.toString());
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_812209659 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_812209659.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_812209659.next();
                {
                    indent(levels);
                    System.out.println(thread);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1628486093 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1628486093.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1628486093.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.936 -0400", hash_original_method = "074D68FF209CFCAF4851113378206A39", hash_generated_method = "D8090481833ECB195E44C71F0CEE0818")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.937 -0400", hash_original_method = "47457D8FCC611743893B7B7E5D80876A", hash_generated_method = "59DD8E7126897FF6A1D118C7F2348E4C")
    public final boolean parentOf(ThreadGroup g) {
        {
            g = g.parent;
        } //End block
        addTaint(g.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2124205817 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2124205817;
        // ---------- Original Method ----------
        //while (g != null) {
            //if (this == g) {
                //return true;
            //}
            //g = g.parent;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.938 -0400", hash_original_method = "7E8DD532FE0D28207249CA86D60AFD62", hash_generated_method = "9F66B67DF1E4F81501C66BA3F1E78751")
    private void remove(ThreadGroup g) {
        {
            {
                Iterator<ThreadGroup> i;
                i = groups.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1894554452 = (i.hasNext());
                {
                    ThreadGroup threadGroup;
                    threadGroup = i.next();
                    {
                        boolean varA1BDBEBB1E64746EF11DB086EC5CF143_2031477382 = (threadGroup.equals(g));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.994 -0400", hash_original_method = "DD66491EA6460453E572207637EFB169", hash_generated_method = "864DDB4FB281A80C5130F40BB90C6EE6")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void resume() {
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_291619787 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_291619787.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_291619787.next();
                {
                    thread.resume();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_173578549 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_173578549.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_173578549.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.994 -0400", hash_original_method = "8335FAF0BC3ED6B3C58B58617340A520", hash_generated_method = "41930952754EA7B18095BC1B8F27AACA")
    public final void setDaemon(boolean isDaemon) {
        this.isDaemon = isDaemon;
        // ---------- Original Method ----------
        //this.isDaemon = isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.035 -0400", hash_original_method = "271C3F89CA43821F381115CC8E2996B2", hash_generated_method = "70A4B66FE43EFABAD9145B0F29D8191A")
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
                    Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_190539510 = (groups).iterator();
                    var54EA1B7E21F6B1B7A595CF2D130BDF63_190539510.hasNext();
                    ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_190539510.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.036 -0400", hash_original_method = "59A4D041306D60B1EF57E2C22E471227", hash_generated_method = "6F2AD75269225E3F6FBA7854A8733AC2")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void stop() {
        {
            boolean var5EC1541CA58351A27FD981B0159181A0_1576747639 = (stopHelper());
            {
                Thread.currentThread().stop();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (stopHelper()) {
            //Thread.currentThread().stop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.097 -0400", hash_original_method = "F86867FC41FDF8B0075237470EA8A18F", hash_generated_method = "105D60C3DF7FACF3B09D7ACA8EF4170B")
    @SuppressWarnings("deprecation")
    private boolean stopHelper() {
        boolean stopCurrent;
        stopCurrent = false;
        {
            Thread current;
            current = Thread.currentThread();
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_1070858647 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_1070858647.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_1070858647.next();
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
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1608002431 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1608002431.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1608002431.next();
                {
                    stopCurrent |= group.stopHelper();
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852493893 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852493893;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.100 -0400", hash_original_method = "26CED40B1639307872B1DC8622DA2669", hash_generated_method = "DFDE0C671A2EE7F180A27B2782B44B89")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void suspend() {
        {
            boolean var447388F3E04DA462654DDAC740A6E72A_1766779646 = (suspendHelper());
            {
                Thread.currentThread().suspend();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (suspendHelper()) {
            //Thread.currentThread().suspend();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.193 -0400", hash_original_method = "664C597F1857BDEBDBE75F13D3F147B7", hash_generated_method = "561914F3FDEC1E694608D4DF681051ED")
    @SuppressWarnings("deprecation")
    private boolean suspendHelper() {
        boolean suspendCurrent;
        suspendCurrent = false;
        {
            Thread current;
            current = Thread.currentThread();
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_889840797 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_889840797.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_889840797.next();
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
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_245221048 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_245221048.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_245221048.next();
                {
                    suspendCurrent |= group.suspendHelper();
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202016919 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_202016919;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.194 -0400", hash_original_method = "54318ADB79169F8C74CBC002CF89020D", hash_generated_method = "D3E953F7BA082E6D1CCBEF1BFA2EECF7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1717082038 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1717082038 = getClass().getName() + "[name=" + getName()
                + ",maxPriority=" + getMaxPriority() + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1717082038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1717082038;
        // ---------- Original Method ----------
        //return getClass().getName() + "[name=" + getName()
                //+ ",maxPriority=" + getMaxPriority() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.194 -0400", hash_original_method = "1AEEC9D33E82C49A9FE6D436A43A8349", hash_generated_method = "E5D864FE879FE9E725694B1530CA213D")
    public void uncaughtException(Thread t, Throwable e) {
        {
            parent.uncaughtException(t, e);
        } //End block
        {
            boolean var87252FF6409F65E0E51F15C36C8E7DAD_317163936 = (Thread.getDefaultUncaughtExceptionHandler() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.194 -0400", hash_original_method = "2D14DBB3818CDCF2DBAC484BFFF8FD8D", hash_generated_method = "4AC8CAED0C30B6D4B76BC53C37D59BCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.195 -0400", hash_original_method = "37129B7DF3D611DDAA565F6673B5A889", hash_generated_method = "C368DEE56C1E00BE227688A3723600C9")
    final void removeThread(Thread thread) throws IllegalThreadStateException {
        {
            {
                Iterator<Thread> i;
                i = threads.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1043367064 = (i.hasNext());
                {
                    {
                        boolean var4E3494244B23B077D5079C96D43BDFE5_279379523 = (i.next().equals(thread));
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.195 -0400", hash_original_field = "70A32802F055FB9A8B4FBD04FF20DFF8", hash_generated_field = "148D880FA6D71711053EBC20ACEE69D4")

    static ThreadGroup mSystem = new ThreadGroup();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.195 -0400", hash_original_field = "6FE2FE3A7188BFD5BCCC556BE6D6F073", hash_generated_field = "6AF03139B67DE22B3FA9731EC6FAC9A2")

    static ThreadGroup mMain = new ThreadGroup(mSystem, "main");
}

