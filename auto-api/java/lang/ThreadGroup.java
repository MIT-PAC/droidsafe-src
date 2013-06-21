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
    private String name;
    private int maxPriority = Thread.MAX_PRIORITY;
    ThreadGroup parent;
    private List<WeakReference<Thread>> threadRefs = new ArrayList<WeakReference<Thread>>(5);
    private Iterable<Thread> threads = CollectionUtils.dereferenceIterable(threadRefs, true);
    private List<ThreadGroup> groups = new ArrayList<ThreadGroup>(3);
    private boolean isDaemon;
    private boolean isDestroyed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.353 -0400", hash_original_method = "15CA8765FCB0FEEB29D720D0682BEE22", hash_generated_method = "6FEDF0514913BAC58F88DFD31D6AA551")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.354 -0400", hash_original_method = "E77CFC99E1E2014F4D8FD3506A5DB87B", hash_generated_method = "526A677F41288DA97CCA4BFF0968CA51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThreadGroup(ThreadGroup parent, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(parent.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("parent == null");
        } //End block
        {
            parent.add(this);
            this.setMaxPriority(parent.getMaxPriority());
            {
                boolean varFED4C748A11E2972650853AC0BAD4EA5_318911269 = (parent.isDaemon());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.354 -0400", hash_original_method = "2C0349D8A755A992C407F37169B24D0C", hash_generated_method = "2023BF93A9F5BDCA687CAB745D1EC815")
    @DSModeled(DSC.SAFE)
    private ThreadGroup() {
        this.name = "system";
        this.parent = null;
        // ---------- Original Method ----------
        //this.name = "system";
        //this.parent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.361 -0400", hash_original_method = "F6402A744D3DEB7896E39C3D58ADE009", hash_generated_method = "E60F0C8BD33B64E6830008CC3B5A66B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int activeCount() {
        int count;
        count = 0;
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_63163245 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_63163245.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_63163245.next();
                {
                    {
                        boolean var834F52F70C5641CAD7243A6F3EDD4895_265342387 = (thread.isAlive());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_691264991 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_691264991.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_691264991.next();
                {
                    count += group.activeCount();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.366 -0400", hash_original_method = "AF255D2A52D389FA67BDDD4C4590191B", hash_generated_method = "0F85AAFAAB0C6680262ED17B85A8DE76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int activeGroupCount() {
        int count;
        count = 0;
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1865131602 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1865131602.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1865131602.next();
                {
                    count += 1 + group.activeGroupCount();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = 0;
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //count += 1 + group.activeGroupCount();
            //}
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.367 -0400", hash_original_method = "0DD772AEDB7C823C2E91BB6377F03397", hash_generated_method = "EDA225D541C79D256E7E7B3837A11FF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void add(ThreadGroup g) throws IllegalThreadStateException {
        dsTaint.addTaint(g.dsTaint);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException();
            } //End block
            groups.add(g);
        } //End block
        // ---------- Original Method ----------
        //synchronized (groups) {
            //if (isDestroyed) {
                //throw new IllegalThreadStateException();
            //}
            //groups.add(g);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.367 -0400", hash_original_method = "17B34AC990B7E085858AFAD80E625CEB", hash_generated_method = "AC1BACC9B22270468D3CCB43E76D331D")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public boolean allowThreadSuspension(boolean b) {
        dsTaint.addTaint(b);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.367 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    @DSModeled(DSC.SAFE)
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.368 -0400", hash_original_method = "662D73EDBF2256DFDB84D7DB5F6E6941", hash_generated_method = "419B44291186C588F81A1ECF51C98385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void destroy() {
        {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Thread group was already destroyed: "
                            + (this.name != null ? this.name : "n/a"));
                } //End block
                {
                    boolean var4F3363F09CB0420EE52F5462232AF87C_1895651213 = (threads.iterator().hasNext());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException(
                            "Thread group still contains threads: "
                            + (this.name != null ? this.name : "n/a"));
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var8AFDB33FE984B1BEC548EC5D0AA95D11_1812890742 = (!groups.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.368 -0400", hash_original_method = "CD7DBC672D59D1FAACCF6E53D785D515", hash_generated_method = "57DB758A2224EC4A91C2303103904354")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void destroyIfEmptyDaemon() {
        {
            {
                boolean var0F38E3A4D4DD70793D9FF286586CF52A_1769069024 = (isDaemon && !isDestroyed && !threads.iterator().hasNext());
                {
                    {
                        {
                            boolean var8F90CF27032DACBA87BBBEC3837FEC96_1425692286 = (groups.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.368 -0400", hash_original_method = "4F115C3CD94EE462D7FE29C66038CE8B", hash_generated_method = "5254C74F19CA60935C60E85A67E3DF31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enumerate(Thread[] threads) {
        dsTaint.addTaint(threads[0].dsTaint);
        int var5F6FD2F78326CE493B1F98DDADE5E7F1_1560411224 = (enumerate(threads, true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return enumerate(threads, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.368 -0400", hash_original_method = "7C9447501CA37C2477868C242A118750", hash_generated_method = "9F6EF05A61C99FF60FDC6E9042E6CD53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enumerate(Thread[] threads, boolean recurse) {
        dsTaint.addTaint(threads[0].dsTaint);
        dsTaint.addTaint(recurse);
        int var8E78C5862A409D685DBDC97F9BEAC903_644116470 = (enumerateGeneric(threads, recurse, 0, true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return enumerateGeneric(threads, recurse, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.369 -0400", hash_original_method = "CA294C4CBD805FDF86CE51E26A265568", hash_generated_method = "861628B6086EEBCEB5CE2E8D7A16D0BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enumerate(ThreadGroup[] groups) {
        dsTaint.addTaint(groups[0].dsTaint);
        int var7A6207DCB59F340F672156C8F350F74C_592032965 = (enumerate(groups, true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return enumerate(groups, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.369 -0400", hash_original_method = "C3125975C33A76683DB83E92F1059496", hash_generated_method = "E3338DDD5901543D3D2B8C223DFE9482")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enumerate(ThreadGroup[] groups, boolean recurse) {
        dsTaint.addTaint(recurse);
        dsTaint.addTaint(groups[0].dsTaint);
        int var9BDBAFB14FA45713AA26AA5DDC79F957_1603532034 = (enumerateGeneric(groups, recurse, 0, false));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return enumerateGeneric(groups, recurse, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.387 -0400", hash_original_method = "7CEEE4341262A9B70C3A153644CFBA1A", hash_generated_method = "7B475758AB29B2B624E3C2737C112184")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int enumerateGeneric(Object[] enumeration, boolean recurse, int enumerationIndex,
            boolean enumeratingThreads) {
        dsTaint.addTaint(enumeration[0].dsTaint);
        dsTaint.addTaint(enumeratingThreads);
        dsTaint.addTaint(enumerationIndex);
        dsTaint.addTaint(recurse);
        {
            {
                {
                    int i;
                    i = threadRefs.size() - 1;
                    {
                        Thread thread;
                        thread = threadRefs.get(i).get();
                        {
                            boolean var65C9C2AD7E143DAAAF5F0F54E1E31CC6_383774176 = (thread != null && thread.isAlive());
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
                    Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_824256348 = (groups).iterator();
                    var54EA1B7E21F6B1B7A595CF2D130BDF63_824256348.hasNext();
                    ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_824256348.next();
                    {
                        enumerationIndex = group.enumerateGeneric(enumeration, recurse,
                            enumerationIndex, enumeratingThreads);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.387 -0400", hash_original_method = "DB664BE89D62AA134945B6EEF3A0CB00", hash_generated_method = "5C70C322140F9B3BBAB57A4BA631A480")
    @DSModeled(DSC.SAFE)
    public final int getMaxPriority() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maxPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.388 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "656D8CA904D03A75C55F220277A90C06")
    @DSModeled(DSC.SAFE)
    public final String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.388 -0400", hash_original_method = "8A85A1BC7F9CDC3D0187C50787EE4700", hash_generated_method = "CF35E807C1E67710EBCA5D2E91F53661")
    @DSModeled(DSC.SAFE)
    public final ThreadGroup getParent() {
        return (ThreadGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.395 -0400", hash_original_method = "2F1556F9A0B232F489BC24F1BD1E38E0", hash_generated_method = "DD228DEE3DF138C4B68017509E0CDC98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void interrupt() {
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_1463917200 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_1463917200.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_1463917200.next();
                {
                    thread.interrupt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_389724312 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_389724312.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_389724312.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.395 -0400", hash_original_method = "5976FB7C02B0576FC514CB127C4662D8", hash_generated_method = "05B56A8645D222B3FA1708275E16EDC2")
    @DSModeled(DSC.SAFE)
    public final boolean isDaemon() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.395 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "D61920C29AE0CE08010C1AE8617CBB1F")
    @DSModeled(DSC.SAFE)
    public synchronized boolean isDestroyed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isDestroyed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.396 -0400", hash_original_method = "8CFF2ECA4877D9633C2E3E2E2839A20E", hash_generated_method = "C6E05FAED89AA6A1B46B82F7A311D5CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void list() {
        System.out.println();
        list(0);
        // ---------- Original Method ----------
        //System.out.println();
        //list(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.402 -0400", hash_original_method = "38F7DBD37EF32F68FFB89F20FFE0F443", hash_generated_method = "8DD1DD65869AC6E0D2E5CBB8CC38FAB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void list(int levels) {
        dsTaint.addTaint(levels);
        indent(levels);
        System.out.println(this.toString());
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_954095158 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_954095158.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_954095158.next();
                {
                    indent(levels);
                    System.out.println(thread);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_292845251 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_292845251.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_292845251.next();
                {
                    group.list(levels);
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.402 -0400", hash_original_method = "074D68FF209CFCAF4851113378206A39", hash_generated_method = "49EA95B42224B02037E7402CB734DCD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void indent(int levels) {
        dsTaint.addTaint(levels);
        {
            int i;
            i = 0;
            {
                System.out.print("    ");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < levels; i++) {
            //System.out.print("    "); 
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.402 -0400", hash_original_method = "47457D8FCC611743893B7B7E5D80876A", hash_generated_method = "1D7BBC6329FAEEC448DA19E82772EA31")
    @DSModeled(DSC.SAFE)
    public final boolean parentOf(ThreadGroup g) {
        dsTaint.addTaint(g.dsTaint);
        {
            g = g.parent;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //while (g != null) {
            //if (this == g) {
                //return true;
            //}
            //g = g.parent;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.403 -0400", hash_original_method = "7E8DD532FE0D28207249CA86D60AFD62", hash_generated_method = "05746170D06CF23381F1B20BABE4C74D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void remove(ThreadGroup g) {
        dsTaint.addTaint(g.dsTaint);
        {
            {
                Iterator<ThreadGroup> i;
                i = groups.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1627258428 = (i.hasNext());
                {
                    ThreadGroup threadGroup;
                    threadGroup = i.next();
                    {
                        boolean varA1BDBEBB1E64746EF11DB086EC5CF143_709684776 = (threadGroup.equals(g));
                        {
                            i.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        destroyIfEmptyDaemon();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.408 -0400", hash_original_method = "DD66491EA6460453E572207637EFB169", hash_generated_method = "300CF517728F2E2FDCC864B67C23881A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void resume() {
        {
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_582341174 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_582341174.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_582341174.next();
                {
                    thread.resume();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_1211973408 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_1211973408.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_1211973408.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.408 -0400", hash_original_method = "8335FAF0BC3ED6B3C58B58617340A520", hash_generated_method = "294014100C77FD33334627604ED581E0")
    @DSModeled(DSC.SAFE)
    public final void setDaemon(boolean isDaemon) {
        dsTaint.addTaint(isDaemon);
        // ---------- Original Method ----------
        //this.isDaemon = isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.424 -0400", hash_original_method = "271C3F89CA43821F381115CC8E2996B2", hash_generated_method = "BCE69CC6F798AEE300A5DA211E0C7FD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setMaxPriority(int newMax) {
        dsTaint.addTaint(newMax);
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
                    Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_590836666 = (groups).iterator();
                    var54EA1B7E21F6B1B7A595CF2D130BDF63_590836666.hasNext();
                    ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_590836666.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.424 -0400", hash_original_method = "59A4D041306D60B1EF57E2C22E471227", hash_generated_method = "F55ADBFED7F9F27B7658E539BD3D6B87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void stop() {
        {
            boolean var5EC1541CA58351A27FD981B0159181A0_966792118 = (stopHelper());
            {
                Thread.currentThread().stop();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (stopHelper()) {
            //Thread.currentThread().stop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.433 -0400", hash_original_method = "F86867FC41FDF8B0075237470EA8A18F", hash_generated_method = "63F7A94A47E07F694F5D01DE13A93FA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    private boolean stopHelper() {
        boolean stopCurrent;
        stopCurrent = false;
        {
            Thread current;
            current = Thread.currentThread();
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_1521145850 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_1521145850.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_1521145850.next();
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
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_661903819 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_661903819.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_661903819.next();
                {
                    stopCurrent |= group.stopHelper();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.434 -0400", hash_original_method = "26CED40B1639307872B1DC8622DA2669", hash_generated_method = "2A3E6FA96C9EBFDDEFD0A859882388E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void suspend() {
        {
            boolean var447388F3E04DA462654DDAC740A6E72A_795907259 = (suspendHelper());
            {
                Thread.currentThread().suspend();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (suspendHelper()) {
            //Thread.currentThread().suspend();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.457 -0400", hash_original_method = "664C597F1857BDEBDBE75F13D3F147B7", hash_generated_method = "5A7F50125A8958A8C93F9C028A507823")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    private boolean suspendHelper() {
        boolean suspendCurrent;
        suspendCurrent = false;
        {
            Thread current;
            current = Thread.currentThread();
            {
                Iterator<Thread> var64031C2010DBED70B36EC2AE78AC91AC_515126108 = (threads).iterator();
                var64031C2010DBED70B36EC2AE78AC91AC_515126108.hasNext();
                Thread thread = var64031C2010DBED70B36EC2AE78AC91AC_515126108.next();
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
                Iterator<ThreadGroup> var54EA1B7E21F6B1B7A595CF2D130BDF63_39371765 = (groups).iterator();
                var54EA1B7E21F6B1B7A595CF2D130BDF63_39371765.hasNext();
                ThreadGroup group = var54EA1B7E21F6B1B7A595CF2D130BDF63_39371765.next();
                {
                    suspendCurrent |= group.suspendHelper();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.458 -0400", hash_original_method = "54318ADB79169F8C74CBC002CF89020D", hash_generated_method = "E7A33AE3DFDD85ED479A2D1E6FA5B736")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varD3F575061A505BFE1C6B903B0A890C30_1309471221 = (getClass().getName() + "[name=" + getName()
                + ",maxPriority=" + getMaxPriority() + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[name=" + getName()
                //+ ",maxPriority=" + getMaxPriority() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.459 -0400", hash_original_method = "1AEEC9D33E82C49A9FE6D436A43A8349", hash_generated_method = "571FD9AD0A10B75B877104DC41DE8621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void uncaughtException(Thread t, Throwable e) {
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(t.dsTaint);
        {
            parent.uncaughtException(t, e);
        } //End block
        {
            boolean var87252FF6409F65E0E51F15C36C8E7DAD_1257436736 = (Thread.getDefaultUncaughtExceptionHandler() != null);
            {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
            } //End block
            {
                e.printStackTrace(System.err);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (parent != null) {
            //parent.uncaughtException(t, e);
        //} else if (Thread.getDefaultUncaughtExceptionHandler() != null) {
            //Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
        //} else if (!(e instanceof ThreadDeath)) {
            //e.printStackTrace(System.err);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.459 -0400", hash_original_method = "2D14DBB3818CDCF2DBAC484BFFF8FD8D", hash_generated_method = "FCB3C1CDC0C2628F3F00EEA213AF6D38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void addThread(Thread thread) throws IllegalThreadStateException {
        dsTaint.addTaint(thread.dsTaint);
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException();
            } //End block
            threadRefs.add(new WeakReference<Thread>(thread));
        } //End block
        // ---------- Original Method ----------
        //synchronized (threadRefs) {
            //if (isDestroyed) {
                //throw new IllegalThreadStateException();
            //}
            //threadRefs.add(new WeakReference<Thread>(thread));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.460 -0400", hash_original_method = "37129B7DF3D611DDAA565F6673B5A889", hash_generated_method = "0E09CAF18F2E9848D5CB8B23FD243C01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void removeThread(Thread thread) throws IllegalThreadStateException {
        dsTaint.addTaint(thread.dsTaint);
        {
            {
                Iterator<Thread> i;
                i = threads.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_2046808514 = (i.hasNext());
                {
                    {
                        boolean var4E3494244B23B077D5079C96D43BDFE5_436459509 = (i.next().equals(thread));
                        {
                            i.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        destroyIfEmptyDaemon();
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

    
    static final ThreadGroup mSystem = new ThreadGroup();
    static final ThreadGroup mMain = new ThreadGroup(mSystem, "main");
}

