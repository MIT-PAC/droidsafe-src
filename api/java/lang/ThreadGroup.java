package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import libcore.util.CollectionUtils;





public class ThreadGroup implements Thread.UncaughtExceptionHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.513 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.513 -0400", hash_original_field = "7005D74F5B8E4D2D07E778F4D2499AE7", hash_generated_field = "BAE3A77CD99CEF534E87AE87746C2800")

    private int maxPriority = Thread.MAX_PRIORITY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.513 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "921B83C68DF8C2D2905E66FA6268F314")

    ThreadGroup parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.513 -0400", hash_original_field = "1E4C064ED2AB9E0FCD37DF408927B55F", hash_generated_field = "F1B2F3B9F625FA1FE59B2C7FAD18AF4A")

    private final List<WeakReference<Thread>> threadRefs = new ArrayList<WeakReference<Thread>>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.513 -0400", hash_original_field = "B4933EA45A022B5606D665A127322C47", hash_generated_field = "BAAC9A9E91234825CA85E995F8623CDF")

    private final Iterable<Thread> threads = CollectionUtils.dereferenceIterable(threadRefs, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.513 -0400", hash_original_field = "D3B573D0607A9BB00C5811DCD4D5EBA5", hash_generated_field = "7493BFD7B9E904844C38FDDC4FA574AD")

    private final List<ThreadGroup> groups = new ArrayList<ThreadGroup>(3);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.513 -0400", hash_original_field = "1CFEB9E5381AE97C57DD59616C5FA3B7", hash_generated_field = "99285F53C75B3E4B14C168653E64D131")

    private boolean isDaemon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.513 -0400", hash_original_field = "090F38A7DDDF192B3BA702F9AFFD747C", hash_generated_field = "1D1E680624D89261892D686BAD995D69")

    private boolean isDestroyed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.514 -0400", hash_original_method = "15CA8765FCB0FEEB29D720D0682BEE22", hash_generated_method = "3B996292AFF43978FACFCB1859624595")
    public  ThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.514 -0400", hash_original_method = "E77CFC99E1E2014F4D8FD3506A5DB87B", hash_generated_method = "FDD61B9457A11601D166AF303D682565")
    public  ThreadGroup(ThreadGroup parent, String name) {
        if(parent == null)        
        {
            NullPointerException varED1EDCABC9DE1352BD636F2377072BDB_1038438985 = new NullPointerException("parent == null");
            varED1EDCABC9DE1352BD636F2377072BDB_1038438985.addTaint(taint);
            throw varED1EDCABC9DE1352BD636F2377072BDB_1038438985;
        } //End block
        this.name = name;
        this.parent = parent;
        if(parent != null)        
        {
            parent.add(this);
            this.setMaxPriority(parent.getMaxPriority());
            if(parent.isDaemon())            
            {
                this.setDaemon(true);
            } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.516 -0400", hash_original_method = "2C0349D8A755A992C407F37169B24D0C", hash_generated_method = "2023BF93A9F5BDCA687CAB745D1EC815")
    private  ThreadGroup() {
        this.name = "system";
        this.parent = null;
        // ---------- Original Method ----------
        //this.name = "system";
        //this.parent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.516 -0400", hash_original_method = "F6402A744D3DEB7896E39C3D58ADE009", hash_generated_method = "DD9139DF0B815FFCE52C0695F6603075")
    public int activeCount() {
        int count = 0;
        synchronized
(threadRefs)        {
for(Thread thread : threads)
            {
                if(thread.isAlive())                
                {
                    count++;
                } //End block
            } //End block
        } //End block
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                count += group.activeCount();
            } //End block
        } //End block
        int varE2942A04780E223B215EB8B663CF5353_609022548 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261815347 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261815347;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.517 -0400", hash_original_method = "AF255D2A52D389FA67BDDD4C4590191B", hash_generated_method = "5AD60DD256F90E3776B4349BCD628B73")
    public int activeGroupCount() {
        int count = 0;
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                count += 1 + group.activeGroupCount();
            } //End block
        } //End block
        int varE2942A04780E223B215EB8B663CF5353_1460596206 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745712830 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745712830;
        // ---------- Original Method ----------
        //int count = 0;
        //synchronized (groups) {
            //for (ThreadGroup group : groups) {
                //count += 1 + group.activeGroupCount();
            //}
        //}
        //return count;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.517 -0400", hash_original_method = "0DD772AEDB7C823C2E91BB6377F03397", hash_generated_method = "0490A50F6656BEF7A83869C88610E98B")
    private void add(ThreadGroup g) throws IllegalThreadStateException {
        addTaint(g.getTaint());
        synchronized
(groups)        {
            if(isDestroyed)            
            {
                IllegalThreadStateException varA05439E94317FDF813F0A0DCA5B5DD9A_922882103 = new IllegalThreadStateException();
                varA05439E94317FDF813F0A0DCA5B5DD9A_922882103.addTaint(taint);
                throw varA05439E94317FDF813F0A0DCA5B5DD9A_922882103;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.518 -0400", hash_original_method = "17B34AC990B7E085858AFAD80E625CEB", hash_generated_method = "A5535294BBD5302106D3713BE8A5CB80")
    @Deprecated
    public boolean allowThreadSuspension(boolean b) {
        addTaint(b);
        boolean varB326B5062B2F0E69046810717534CB09_1486996249 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1034196862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1034196862;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.518 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.519 -0400", hash_original_method = "662D73EDBF2256DFDB84D7DB5F6E6941", hash_generated_method = "24EFDC6905C7DCE9F5B230AF361C2557")
    public final void destroy() {
        synchronized
(threadRefs)        {
            synchronized
(groups)            {
                if(isDestroyed)                
                {
                    IllegalThreadStateException var759515A5611E927EE189DAC60459E163_478719786 = new IllegalThreadStateException(
                            "Thread group was already destroyed: "
                            + (this.name != null ? this.name : "n/a"));
                    var759515A5611E927EE189DAC60459E163_478719786.addTaint(taint);
                    throw var759515A5611E927EE189DAC60459E163_478719786;
                } //End block
                if(threads.iterator().hasNext())                
                {
                    IllegalThreadStateException varAC568F6EA8E9BD19EC11411DFC787840_908209534 = new IllegalThreadStateException(
                            "Thread group still contains threads: "
                            + (this.name != null ? this.name : "n/a"));
                    varAC568F6EA8E9BD19EC11411DFC787840_908209534.addTaint(taint);
                    throw varAC568F6EA8E9BD19EC11411DFC787840_908209534;
                } //End block
                while
(!groups.isEmpty())                
                {
                    groups.get(0).destroy();
                } //End block
                if(parent != null)                
                {
                    parent.remove(this);
                } //End block
                this.isDestroyed = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.519 -0400", hash_original_method = "CD7DBC672D59D1FAACCF6E53D785D515", hash_generated_method = "3ECD5C24D4B58AAD907F74000FD3A576")
    private void destroyIfEmptyDaemon() {
        synchronized
(threadRefs)        {
            if(isDaemon && !isDestroyed && !threads.iterator().hasNext())            
            {
                synchronized
(groups)                {
                    if(groups.isEmpty())                    
                    {
                        destroy();
                    } //End block
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.519 -0400", hash_original_method = "4F115C3CD94EE462D7FE29C66038CE8B", hash_generated_method = "DC1B02E033DFD5A18CFC332848D6AE41")
    public int enumerate(Thread[] threads) {
        addTaint(threads[0].getTaint());
        int varE88487EA963B1CA4470710FDEEF6150D_718928540 = (enumerate(threads, true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784098266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784098266;
        // ---------- Original Method ----------
        //return enumerate(threads, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.520 -0400", hash_original_method = "7C9447501CA37C2477868C242A118750", hash_generated_method = "7F7452C5B981CC26C38A9724A81FA5A7")
    public int enumerate(Thread[] threads, boolean recurse) {
        addTaint(recurse);
        addTaint(threads[0].getTaint());
        int var9F45FC03189A4CDE3A04E26394C27598_788850746 = (enumerateGeneric(threads, recurse, 0, true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445143952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445143952;
        // ---------- Original Method ----------
        //return enumerateGeneric(threads, recurse, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.520 -0400", hash_original_method = "CA294C4CBD805FDF86CE51E26A265568", hash_generated_method = "8EC5B0668A61AC3998DA6AFE67D0EA2B")
    public int enumerate(ThreadGroup[] groups) {
        addTaint(groups[0].getTaint());
        int var67882C778C85CFFFAB178FC90FD4AD6C_364006143 = (enumerate(groups, true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269479948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269479948;
        // ---------- Original Method ----------
        //return enumerate(groups, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.521 -0400", hash_original_method = "C3125975C33A76683DB83E92F1059496", hash_generated_method = "48133F3014C25BFE438531E32A52650B")
    public int enumerate(ThreadGroup[] groups, boolean recurse) {
        addTaint(recurse);
        addTaint(groups[0].getTaint());
        int varF80C0934D497350B81BE9A2A2F86F000_260915427 = (enumerateGeneric(groups, recurse, 0, false));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872210751 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872210751;
        // ---------- Original Method ----------
        //return enumerateGeneric(groups, recurse, 0, false);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.522 -0400", hash_original_method = "7CEEE4341262A9B70C3A153644CFBA1A", hash_generated_method = "21357B32E23258070B1C32053BACA1C8")
    private int enumerateGeneric(Object[] enumeration, boolean recurse, int enumerationIndex,
            boolean enumeratingThreads) {
        addTaint(enumeratingThreads);
        addTaint(enumerationIndex);
        addTaint(recurse);
        addTaint(enumeration[0].getTaint());
        if(enumeratingThreads)        
        {
            synchronized
(threadRefs)            {
for(int i = threadRefs.size() - 1;i >= 0;--i)
                {
                    Thread thread = threadRefs.get(i).get();
                    if(thread != null && thread.isAlive())                    
                    {
                        if(enumerationIndex >= enumeration.length)                        
                        {
                            int var4118BA52E9D686B3984C6B39C3013E3A_1874542856 = (enumerationIndex);
                                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1913099732 = getTaintInt();
                            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1913099732;
                        } //End block
                        enumeration[enumerationIndex++] = thread;
                    } //End block
                } //End block
            } //End block
        } //End block
        else
        {
            synchronized
(groups)            {
for(int i = groups.size() - 1;i >= 0;--i)
                {
                    if(enumerationIndex >= enumeration.length)                    
                    {
                        int var4118BA52E9D686B3984C6B39C3013E3A_1064468008 = (enumerationIndex);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552020806 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552020806;
                    } //End block
                    enumeration[enumerationIndex++] = groups.get(i);
                } //End block
            } //End block
        } //End block
        if(recurse)        
        {
            synchronized
(groups)            {
for(ThreadGroup group : groups)
                {
                    if(enumerationIndex >= enumeration.length)                    
                    {
                        int var4118BA52E9D686B3984C6B39C3013E3A_914840069 = (enumerationIndex);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988192135 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988192135;
                    } //End block
                    enumerationIndex = group.enumerateGeneric(enumeration, recurse,
                            enumerationIndex, enumeratingThreads);
                } //End block
            } //End block
        } //End block
        int var4118BA52E9D686B3984C6B39C3013E3A_289882515 = (enumerationIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498916588 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498916588;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.523 -0400", hash_original_method = "DB664BE89D62AA134945B6EEF3A0CB00", hash_generated_method = "CE5631FA6943CD85BE78E172A741F754")
    public final int getMaxPriority() {
        int var605B899CE7517A7E2B487FD888B3B34B_1955545235 = (maxPriority);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466667952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466667952;
        // ---------- Original Method ----------
        //return maxPriority;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.523 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "75C0174093D8612056464926D5AC8531")
    public final String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_923082809 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_923082809.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_923082809;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.523 -0400", hash_original_method = "8A85A1BC7F9CDC3D0187C50787EE4700", hash_generated_method = "D802CFBD9570F25E3CD7D0D48BA52C65")
    public final ThreadGroup getParent() {
ThreadGroup var0F49909EA73F8892C338E4DCA6EB9906_1316588857 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_1316588857.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_1316588857;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.524 -0400", hash_original_method = "2F1556F9A0B232F489BC24F1BD1E38E0", hash_generated_method = "D1EA4039B0425509B7BD00775FC14E30")
    public final void interrupt() {
        synchronized
(threadRefs)        {
for(Thread thread : threads)
            {
                thread.interrupt();
            } //End block
        } //End block
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                group.interrupt();
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.524 -0400", hash_original_method = "5976FB7C02B0576FC514CB127C4662D8", hash_generated_method = "64C24DF38B63CE74943FAD9D8A508D5B")
    public final boolean isDaemon() {
        boolean var1CFEB9E5381AE97C57DD59616C5FA3B7_1505028832 = (isDaemon);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1388821261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1388821261;
        // ---------- Original Method ----------
        //return isDaemon;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.524 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "6C1BC2A73510F3562A1679E8C6636E35")
    public synchronized boolean isDestroyed() {
        boolean var090F38A7DDDF192B3BA702F9AFFD747C_1725644701 = (isDestroyed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_663295316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_663295316;
        // ---------- Original Method ----------
        //return isDestroyed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.525 -0400", hash_original_method = "8CFF2ECA4877D9633C2E3E2E2839A20E", hash_generated_method = "C6E05FAED89AA6A1B46B82F7A311D5CC")
    public void list() {
        System.out.println();
        list(0);
        // ---------- Original Method ----------
        //System.out.println();
        //list(0);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.525 -0400", hash_original_method = "38F7DBD37EF32F68FFB89F20FFE0F443", hash_generated_method = "E2BD07B0F9BBC705A50C049F9A6B8FED")
    private void list(int levels) {
        addTaint(levels);
        indent(levels);
        System.out.println(this.toString());
        ++levels;
        synchronized
(threadRefs)        {
for(Thread thread : threads)
            {
                indent(levels);
                System.out.println(thread);
            } //End block
        } //End block
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                group.list(levels);
            } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.525 -0400", hash_original_method = "074D68FF209CFCAF4851113378206A39", hash_generated_method = "08A3D3C98405AB643B339EE874F88F51")
    private void indent(int levels) {
        addTaint(levels);
for(int i = 0;i < levels;i++)
        {
            System.out.print("    ");
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < levels; i++) {
            //System.out.print("    "); 
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.526 -0400", hash_original_method = "47457D8FCC611743893B7B7E5D80876A", hash_generated_method = "1D764DCA95932D8A8D4D087366D91FBE")
    public final boolean parentOf(ThreadGroup g) {
        addTaint(g.getTaint());
        while
(g != null)        
        {
            if(this == g)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1900305816 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_342544077 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_342544077;
            } //End block
            g = g.parent;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1684977696 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002338634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002338634;
        // ---------- Original Method ----------
        //while (g != null) {
            //if (this == g) {
                //return true;
            //}
            //g = g.parent;
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.526 -0400", hash_original_method = "7E8DD532FE0D28207249CA86D60AFD62", hash_generated_method = "E8F8F23876D2A1A5C1BAA9519A159170")
    private void remove(ThreadGroup g) {
        addTaint(g.getTaint());
        synchronized
(groups)        {
for(Iterator<ThreadGroup> i = groups.iterator();i.hasNext();)
            {
                ThreadGroup threadGroup = i.next();
                if(threadGroup.equals(g))                
                {
                    i.remove();
                    break;
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.526 -0400", hash_original_method = "DD66491EA6460453E572207637EFB169", hash_generated_method = "509ED0C2176DDCCF4665FF88E295657C")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void resume() {
        synchronized
(threadRefs)        {
for(Thread thread : threads)
            {
                thread.resume();
            } //End block
        } //End block
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                group.resume();
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.527 -0400", hash_original_method = "8335FAF0BC3ED6B3C58B58617340A520", hash_generated_method = "41930952754EA7B18095BC1B8F27AACA")
    public final void setDaemon(boolean isDaemon) {
        this.isDaemon = isDaemon;
        // ---------- Original Method ----------
        //this.isDaemon = isDaemon;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.527 -0400", hash_original_method = "271C3F89CA43821F381115CC8E2996B2", hash_generated_method = "31CDE7ECEB308F5619C0D1789D52D23A")
    public final void setMaxPriority(int newMax) {
        if(newMax <= this.maxPriority)        
        {
            if(newMax < Thread.MIN_PRIORITY)            
            {
                newMax = Thread.MIN_PRIORITY;
            } //End block
            int parentPriority = parent == null ? newMax : parent.getMaxPriority();
            this.maxPriority = parentPriority <= newMax ? parentPriority : newMax;
            synchronized
(groups)            {
for(ThreadGroup group : groups)
                {
                    group.setMaxPriority(newMax);
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.527 -0400", hash_original_method = "59A4D041306D60B1EF57E2C22E471227", hash_generated_method = "713A24B4C3E1BAC61769770BEF29FA86")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void stop() {
        if(stopHelper())        
        {
            Thread.currentThread().stop();
        } //End block
        // ---------- Original Method ----------
        //if (stopHelper()) {
            //Thread.currentThread().stop();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.527 -0400", hash_original_method = "F86867FC41FDF8B0075237470EA8A18F", hash_generated_method = "4E9F3AE5DA6B4C2A19AD6408D2E86676")
    @SuppressWarnings("deprecation")
    private boolean stopHelper() {
        boolean stopCurrent = false;
        synchronized
(threadRefs)        {
            Thread current = Thread.currentThread();
for(Thread thread : threads)
            {
                if(thread == current)                
                {
                    stopCurrent = true;
                } //End block
                else
                {
                    thread.stop();
                } //End block
            } //End block
        } //End block
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                stopCurrent |= group.stopHelper();
            } //End block
        } //End block
        boolean var784B75F63E8CE9D6B35ED439029C6847_594733827 = (stopCurrent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_183544287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_183544287;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.527 -0400", hash_original_method = "26CED40B1639307872B1DC8622DA2669", hash_generated_method = "B5EC9002911ED8AFA497E3AA15F8F956")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void suspend() {
        if(suspendHelper())        
        {
            Thread.currentThread().suspend();
        } //End block
        // ---------- Original Method ----------
        //if (suspendHelper()) {
            //Thread.currentThread().suspend();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.528 -0400", hash_original_method = "664C597F1857BDEBDBE75F13D3F147B7", hash_generated_method = "252FC4AD2ED1E1FB76DF5E8EC6620BC5")
    @SuppressWarnings("deprecation")
    private boolean suspendHelper() {
        boolean suspendCurrent = false;
        synchronized
(threadRefs)        {
            Thread current = Thread.currentThread();
for(Thread thread : threads)
            {
                if(thread == current)                
                {
                    suspendCurrent = true;
                } //End block
                else
                {
                    thread.suspend();
                } //End block
            } //End block
        } //End block
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                suspendCurrent |= group.suspendHelper();
            } //End block
        } //End block
        boolean var78753EFF84E0F2A5BDFA90A5A032233B_1914345300 = (suspendCurrent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1451108870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1451108870;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.529 -0400", hash_original_method = "54318ADB79169F8C74CBC002CF89020D", hash_generated_method = "540BF2BCAFD570FB2218D7F6B0525411")
    @Override
    public String toString() {
String var8A8A36D1F5831B81760F8A7B6FB3030F_451338402 =         getClass().getName() + "[name=" + getName()
                + ",maxPriority=" + getMaxPriority() + "]";
        var8A8A36D1F5831B81760F8A7B6FB3030F_451338402.addTaint(taint);
        return var8A8A36D1F5831B81760F8A7B6FB3030F_451338402;
        // ---------- Original Method ----------
        //return getClass().getName() + "[name=" + getName()
                //+ ",maxPriority=" + getMaxPriority() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.529 -0400", hash_original_method = "1AEEC9D33E82C49A9FE6D436A43A8349", hash_generated_method = "9DF25E8A893766443023250739070799")
    public void uncaughtException(Thread t, Throwable e) {
        addTaint(e.getTaint());
        addTaint(t.getTaint());
        if(parent != null)        
        {
            parent.uncaughtException(t, e);
        } //End block
        else
        if(Thread.getDefaultUncaughtExceptionHandler() != null)        
        {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
        } //End block
        else
        if(!(e instanceof ThreadDeath))        
        {
            e.printStackTrace(System.err);
        } //End block
        // ---------- Original Method ----------
        //if (parent != null) {
            //parent.uncaughtException(t, e);
        //} else if (Thread.getDefaultUncaughtExceptionHandler() != null) {
            //Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
        //} else if (!(e instanceof ThreadDeath)) {
            //e.printStackTrace(System.err);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.529 -0400", hash_original_method = "2D14DBB3818CDCF2DBAC484BFFF8FD8D", hash_generated_method = "C5DF400ED2DAE5FD9496E6D48E1D1C79")
    final void addThread(Thread thread) throws IllegalThreadStateException {
        addTaint(thread.getTaint());
        synchronized
(threadRefs)        {
            if(isDestroyed)            
            {
                IllegalThreadStateException varA05439E94317FDF813F0A0DCA5B5DD9A_212724395 = new IllegalThreadStateException();
                varA05439E94317FDF813F0A0DCA5B5DD9A_212724395.addTaint(taint);
                throw varA05439E94317FDF813F0A0DCA5B5DD9A_212724395;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.530 -0400", hash_original_method = "37129B7DF3D611DDAA565F6673B5A889", hash_generated_method = "B09E492711FFDC23E5C76E8092AE8DCF")
    final void removeThread(Thread thread) throws IllegalThreadStateException {
        addTaint(thread.getTaint());
        synchronized
(threadRefs)        {
for(Iterator<Thread> i = threads.iterator();i.hasNext();)
            {
                if(i.next().equals(thread))                
                {
                    i.remove();
                    break;
                } //End block
            } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.530 -0400", hash_original_field = "70A32802F055FB9A8B4FBD04FF20DFF8", hash_generated_field = "C469F1CA0F9CB15DC605ADF2C779CB30")

    static final ThreadGroup mSystem = new ThreadGroup();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.530 -0400", hash_original_field = "6FE2FE3A7188BFD5BCCC556BE6D6F073", hash_generated_field = "843DB6CD61C0C78ABA07CFE273D0F240")

    static final ThreadGroup mMain = new ThreadGroup(mSystem, "main");
}

