package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.util.CollectionUtils;

public class ThreadGroup implements Thread.UncaughtExceptionHandler {
    private String name;
    private int maxPriority = Thread.MAX_PRIORITY;
    final ThreadGroup parent;
    private final List<WeakReference<Thread>> threadRefs = new ArrayList<WeakReference<Thread>>(5);
    private final Iterable<Thread> threads = CollectionUtils.dereferenceIterable(threadRefs, true);
    private final List<ThreadGroup> groups = new ArrayList<ThreadGroup>(3);
    private boolean isDaemon;
    private boolean isDestroyed;
    static final ThreadGroup mSystem = new ThreadGroup();
    static final ThreadGroup mMain = new ThreadGroup(mSystem, "main");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.773 -0400", hash_original_method = "15CA8765FCB0FEEB29D720D0682BEE22", hash_generated_method = "66DCB6522790FB1A65700CF2004E7279")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.785 -0400", hash_original_method = "E77CFC99E1E2014F4D8FD3506A5DB87B", hash_generated_method = "D512C0C817BBC0F5DCAB553180A7F805")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThreadGroup(ThreadGroup parent, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(parent.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException("parent == null");
        } //End block
        {
            parent.add(this);
            this.setMaxPriority(parent.getMaxPriority());
            {
                boolean varFED4C748A11E2972650853AC0BAD4EA5_1918851762 = (parent.isDaemon());
                {
                    this.setDaemon(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        
        this.parent = parent;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.789 -0400", hash_original_method = "2C0349D8A755A992C407F37169B24D0C", hash_generated_method = "CB22B2DECC64918DFE830BD20E0E31C5")
    @DSModeled(DSC.SAFE)
    private ThreadGroup() {
        this.name = "system";
        this.parent = null;
        // ---------- Original Method ----------
        //this.name = "system";
        //this.parent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.801 -0400", hash_original_method = "F6402A744D3DEB7896E39C3D58ADE009", hash_generated_method = "12A18869E416886EF0494B73FBC4D282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int activeCount() {
        int count;
        count = 0;
        {
            {
                Iterator<Thread> seatecAstronomy42 = threads.iterator();
                seatecAstronomy42.hasNext();
                Thread thread = seatecAstronomy42.next();
                {
                    {
                        boolean var834F52F70C5641CAD7243A6F3EDD4895_1869094932 = (thread.isAlive());
                        {
                            count++;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> seatecAstronomy42 = groups.iterator();
                seatecAstronomy42.hasNext();
                ThreadGroup group = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.814 -0400", hash_original_method = "AF255D2A52D389FA67BDDD4C4590191B", hash_generated_method = "3A0262E625B24F35144504BC404AB15D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int activeGroupCount() {
        int count;
        count = 0;
        {
            {
                Iterator<ThreadGroup> seatecAstronomy42 = groups.iterator();
                seatecAstronomy42.hasNext();
                ThreadGroup group = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.822 -0400", hash_original_method = "0DD772AEDB7C823C2E91BB6377F03397", hash_generated_method = "93D9CC8ED97B016FF74720CACA655331")
    @DSModeled(DSC.SAFE)
    private void add(ThreadGroup g) throws IllegalThreadStateException {
        dsTaint.addTaint(g.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) {
                throw new IllegalThreadStateException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.826 -0400", hash_original_method = "17B34AC990B7E085858AFAD80E625CEB", hash_generated_method = "74FB6500CDE129B09A62A60B495B9649")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public boolean allowThreadSuspension(boolean b) {
        dsTaint.addTaint(b);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.829 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "C669480A95355836C191B605390649AF")
    @DSModeled(DSC.SAFE)
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.834 -0400", hash_original_method = "662D73EDBF2256DFDB84D7DB5F6E6941", hash_generated_method = "7D7B6CD0B8077B3A834268E52E7156F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void destroy() {
        {
            {
            	if (DroidSafeAndroidRuntime.control) {
                    throw new IllegalThreadStateException(
                            "Thread group was already destroyed: "
                            + (this.name != null ? this.name : "n/a"));
                } //End block
            	
            	if (DroidSafeAndroidRuntime.control) {
                    boolean var4F3363F09CB0420EE52F5462232AF87C_789505287 = (threads.iterator().hasNext());
                    {
                        throw new IllegalThreadStateException(
                            "Thread group still contains threads: "
                            + (this.name != null ? this.name : "n/a"));
                    } //End block
                } //End collapsed parenthetic
            	
                {
                    boolean var8AFDB33FE984B1BEC548EC5D0AA95D11_1285273006 = (!groups.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.845 -0400", hash_original_method = "CD7DBC672D59D1FAACCF6E53D785D515", hash_generated_method = "B77B016AFCCF3D9A3AC134721BC87297")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void destroyIfEmptyDaemon() {
        {
            {
                boolean var0F38E3A4D4DD70793D9FF286586CF52A_1972217731 = (isDaemon && !isDestroyed && !threads.iterator().hasNext());
                {
                    {
                        {
                            boolean var8F90CF27032DACBA87BBBEC3837FEC96_1412187257 = (groups.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.857 -0400", hash_original_method = "4F115C3CD94EE462D7FE29C66038CE8B", hash_generated_method = "18C599DF628FC393192D5FC345C08A2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enumerate(Thread[] threads) {
        dsTaint.addTaint(threads[0].dsTaint);
        int var5F6FD2F78326CE493B1F98DDADE5E7F1_1258954577 = (enumerate(threads, true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return enumerate(threads, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.863 -0400", hash_original_method = "7C9447501CA37C2477868C242A118750", hash_generated_method = "8815CB0DFB40AD5386951299759717F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enumerate(Thread[] threads, boolean recurse) {
        dsTaint.addTaint(threads[0].dsTaint);
        dsTaint.addTaint(recurse);
        int var8E78C5862A409D685DBDC97F9BEAC903_905193556 = (enumerateGeneric(threads, recurse, 0, true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return enumerateGeneric(threads, recurse, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.874 -0400", hash_original_method = "CA294C4CBD805FDF86CE51E26A265568", hash_generated_method = "71CC8C81C0154B1FE4E203EEA92F9DF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enumerate(ThreadGroup[] groups) {
        dsTaint.addTaint(groups[0].dsTaint);
        int var7A6207DCB59F340F672156C8F350F74C_1007661926 = (enumerate(groups, true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return enumerate(groups, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.878 -0400", hash_original_method = "C3125975C33A76683DB83E92F1059496", hash_generated_method = "E9BDC9AF277C1E810F9D214DABF74A9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int enumerate(ThreadGroup[] groups, boolean recurse) {
        dsTaint.addTaint(recurse);
        dsTaint.addTaint(groups[0].dsTaint);
        int var9BDBAFB14FA45713AA26AA5DDC79F957_1211455850 = (enumerateGeneric(groups, recurse, 0, false));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return enumerateGeneric(groups, recurse, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.901 -0400", hash_original_method = "7CEEE4341262A9B70C3A153644CFBA1A", hash_generated_method = "35D1A55049B881D4CDAF534D5E647C11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int enumerateGeneric(Object[] enumeration, boolean recurse, int enumerationIndex,
            boolean enumeratingThreads) {
        dsTaint.addTaint(enumeration[0].dsTaint);
        dsTaint.addTaint(enumerationIndex);
        dsTaint.addTaint(enumeratingThreads);
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
                            boolean var65C9C2AD7E143DAAAF5F0F54E1E31CC6_1812832767 = (thread != null && thread.isAlive());
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
                    Iterator<ThreadGroup> seatecAstronomy42 = groups.iterator();
                    seatecAstronomy42.hasNext();
                    ThreadGroup group = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.916 -0400", hash_original_method = "DB664BE89D62AA134945B6EEF3A0CB00", hash_generated_method = "12974FB21F9E683AA91ACB48BD13072D")
    @DSModeled(DSC.SAFE)
    public final int getMaxPriority() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maxPriority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.918 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "A892EF72E38635393E1E3CB08CBDBB43")
    @DSModeled(DSC.SAFE)
    public final String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.925 -0400", hash_original_method = "8A85A1BC7F9CDC3D0187C50787EE4700", hash_generated_method = "C3E1CDBCF1F31CFFE00E45941178501F")
    @DSModeled(DSC.SAFE)
    public final ThreadGroup getParent() {
        return (ThreadGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.927 -0400", hash_original_method = "2F1556F9A0B232F489BC24F1BD1E38E0", hash_generated_method = "9B57BD42DAEB4E6613433686DF672A5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void interrupt() {
        {
            {
                Iterator<Thread> seatecAstronomy42 = threads.iterator();
                seatecAstronomy42.hasNext();
                Thread thread = seatecAstronomy42.next();
                {
                    thread.interrupt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> seatecAstronomy42 = groups.iterator();
                seatecAstronomy42.hasNext();
                ThreadGroup group = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.932 -0400", hash_original_method = "5976FB7C02B0576FC514CB127C4662D8", hash_generated_method = "E4DB4D3F596284E6B6D43CC9F8233F16")
    @DSModeled(DSC.SAFE)
    public final boolean isDaemon() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.940 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "E8FE9149128DEF801231256534FD7D50")
    @DSModeled(DSC.SAFE)
    public synchronized boolean isDestroyed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isDestroyed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.942 -0400", hash_original_method = "8CFF2ECA4877D9633C2E3E2E2839A20E", hash_generated_method = "39A8E10EDC1F06D42C520B726A6BEA77")
    @DSModeled(DSC.SAFE)
    public void list() {
        System.out.println();
        list(0);
        // ---------- Original Method ----------
        //System.out.println();
        //list(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.946 -0400", hash_original_method = "38F7DBD37EF32F68FFB89F20FFE0F443", hash_generated_method = "D37614C6D1B821DA7636490B8E7B0913")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void list(int levels) {
        dsTaint.addTaint(levels);
        indent(levels);
        System.out.println(this.toString());
        ++levels;
        {
            {
                Iterator<Thread> seatecAstronomy42 = threads.iterator();
                seatecAstronomy42.hasNext();
                Thread thread = seatecAstronomy42.next();
                {
                    indent(levels);
                    System.out.println(thread);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> seatecAstronomy42 = groups.iterator();
                seatecAstronomy42.hasNext();
                ThreadGroup group = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.957 -0400", hash_original_method = "074D68FF209CFCAF4851113378206A39", hash_generated_method = "23F47859BCA10FD1F3C77E01469368A2")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.960 -0400", hash_original_method = "47457D8FCC611743893B7B7E5D80876A", hash_generated_method = "FB91D5A2B85B7E107BF911E95FC8D1DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.964 -0400", hash_original_method = "7E8DD532FE0D28207249CA86D60AFD62", hash_generated_method = "A8B60B5131C4B394546ED60981882B77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void remove(ThreadGroup g) {
        dsTaint.addTaint(g.dsTaint);
        {
            {
                Iterator<ThreadGroup> i;
                i = groups.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_692542877 = (i.hasNext());
                {
                    ThreadGroup threadGroup;
                    threadGroup = i.next();
                    {
                        boolean varA1BDBEBB1E64746EF11DB086EC5CF143_1557704903 = (threadGroup.equals(g));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.967 -0400", hash_original_method = "DD66491EA6460453E572207637EFB169", hash_generated_method = "4F37F246282AEB81785197F7A036ED1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void resume() {
        {
            {
                Iterator<Thread> seatecAstronomy42 = threads.iterator();
                seatecAstronomy42.hasNext();
                Thread thread = seatecAstronomy42.next();
                {
                    thread.resume();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<ThreadGroup> seatecAstronomy42 = groups.iterator();
                seatecAstronomy42.hasNext();
                ThreadGroup group = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.973 -0400", hash_original_method = "8335FAF0BC3ED6B3C58B58617340A520", hash_generated_method = "29A4A99B2D7D2B3A1B1A51619EB5E583")
    @DSModeled(DSC.SAFE)
    public final void setDaemon(boolean isDaemon) {
        dsTaint.addTaint(isDaemon);
        // ---------- Original Method ----------
        //this.isDaemon = isDaemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.977 -0400", hash_original_method = "271C3F89CA43821F381115CC8E2996B2", hash_generated_method = "6D19547B3D1C27FC45C1BFF5C78DE099")
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
                    Iterator<ThreadGroup> seatecAstronomy42 = groups.iterator();
                    seatecAstronomy42.hasNext();
                    ThreadGroup group = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.981 -0400", hash_original_method = "59A4D041306D60B1EF57E2C22E471227", hash_generated_method = "CF4E5F3DC101F911E4E165221A1C34FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void stop() {
        {
            boolean var5EC1541CA58351A27FD981B0159181A0_996993603 = (stopHelper());
            {
                Thread.currentThread().stop();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (stopHelper()) {
            //Thread.currentThread().stop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.986 -0400", hash_original_method = "F86867FC41FDF8B0075237470EA8A18F", hash_generated_method = "3D341D387A46426C2FB63CA4014CD193")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    private boolean stopHelper() {
        boolean stopCurrent;
        stopCurrent = false;
        {
            Thread current;
            current = Thread.currentThread();
            {
                Iterator<Thread> seatecAstronomy42 = threads.iterator();
                seatecAstronomy42.hasNext();
                Thread thread = seatecAstronomy42.next();
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
                Iterator<ThreadGroup> seatecAstronomy42 = groups.iterator();
                seatecAstronomy42.hasNext();
                ThreadGroup group = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.989 -0400", hash_original_method = "26CED40B1639307872B1DC8622DA2669", hash_generated_method = "B77C468341675EBE90E96DB0B43AB096")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void suspend() {
        {
            boolean var447388F3E04DA462654DDAC740A6E72A_876492217 = (suspendHelper());
            {
                Thread.currentThread().suspend();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (suspendHelper()) {
            //Thread.currentThread().suspend();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:15.994 -0400", hash_original_method = "664C597F1857BDEBDBE75F13D3F147B7", hash_generated_method = "C85401ACAE8D8013640B31C1793A6DCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    private boolean suspendHelper() {
        boolean suspendCurrent;
        suspendCurrent = false;
        {
            Thread current;
            current = Thread.currentThread();
            {
                Iterator<Thread> seatecAstronomy42 = threads.iterator();
                seatecAstronomy42.hasNext();
                Thread thread = seatecAstronomy42.next();
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
                Iterator<ThreadGroup> seatecAstronomy42 = groups.iterator();
                seatecAstronomy42.hasNext();
                ThreadGroup group = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:16.004 -0400", hash_original_method = "54318ADB79169F8C74CBC002CF89020D", hash_generated_method = "53E99623AD0B6768B4CF64CF9C0B2132")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varD3F575061A505BFE1C6B903B0A890C30_214374152 = (getClass().getName() + "[name=" + getName()
                + ",maxPriority=" + getMaxPriority() + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[name=" + getName()
                //+ ",maxPriority=" + getMaxPriority() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:16.016 -0400", hash_original_method = "1AEEC9D33E82C49A9FE6D436A43A8349", hash_generated_method = "02781D2AFDFAEC0862670F5751DC208E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void uncaughtException(Thread t, Throwable e) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(e.dsTaint);
        {
            parent.uncaughtException(t, e);
        } //End block
        {
            boolean var87252FF6409F65E0E51F15C36C8E7DAD_132224082 = (Thread.getDefaultUncaughtExceptionHandler() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:16.020 -0400", hash_original_method = "2D14DBB3818CDCF2DBAC484BFFF8FD8D", hash_generated_method = "32B8DDE7337A9CE0483EE362B68A7EA1")
    @DSModeled(DSC.SAFE)
    final void addThread(Thread thread) throws IllegalThreadStateException {
        dsTaint.addTaint(thread.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) {
                throw new IllegalThreadStateException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:05:16.024 -0400", hash_original_method = "37129B7DF3D611DDAA565F6673B5A889", hash_generated_method = "A944180B103AF02233E81A43D6F32A19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void removeThread(Thread thread) throws IllegalThreadStateException {
        dsTaint.addTaint(thread.dsTaint);
        {
            {
                Iterator<Thread> i;
                i = threads.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1021443149 = (i.hasNext());
                {
                    {
                        boolean var4E3494244B23B077D5079C96D43BDFE5_1589907306 = (i.next().equals(thread));
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

    
}


