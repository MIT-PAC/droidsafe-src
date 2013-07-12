package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.util.CollectionUtils;

public class ThreadGroup implements Thread.UncaughtExceptionHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.597 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.597 -0400", hash_original_field = "7005D74F5B8E4D2D07E778F4D2499AE7", hash_generated_field = "BAE3A77CD99CEF534E87AE87746C2800")

    private int maxPriority = Thread.MAX_PRIORITY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.597 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "921B83C68DF8C2D2905E66FA6268F314")

    ThreadGroup parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.597 -0400", hash_original_field = "1E4C064ED2AB9E0FCD37DF408927B55F", hash_generated_field = "F1B2F3B9F625FA1FE59B2C7FAD18AF4A")

    private final List<WeakReference<Thread>> threadRefs = new ArrayList<WeakReference<Thread>>(5);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.597 -0400", hash_original_field = "B4933EA45A022B5606D665A127322C47", hash_generated_field = "BAAC9A9E91234825CA85E995F8623CDF")

    private final Iterable<Thread> threads = CollectionUtils.dereferenceIterable(threadRefs, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.597 -0400", hash_original_field = "D3B573D0607A9BB00C5811DCD4D5EBA5", hash_generated_field = "7493BFD7B9E904844C38FDDC4FA574AD")

    private final List<ThreadGroup> groups = new ArrayList<ThreadGroup>(3);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.597 -0400", hash_original_field = "1CFEB9E5381AE97C57DD59616C5FA3B7", hash_generated_field = "99285F53C75B3E4B14C168653E64D131")

    private boolean isDaemon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.597 -0400", hash_original_field = "090F38A7DDDF192B3BA702F9AFFD747C", hash_generated_field = "1D1E680624D89261892D686BAD995D69")

    private boolean isDestroyed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.598 -0400", hash_original_method = "15CA8765FCB0FEEB29D720D0682BEE22", hash_generated_method = "3B996292AFF43978FACFCB1859624595")
    public  ThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.599 -0400", hash_original_method = "E77CFC99E1E2014F4D8FD3506A5DB87B", hash_generated_method = "BEB05351B9E3CCD8FC364B734DE80CBE")
    public  ThreadGroup(ThreadGroup parent, String name) {
    if(parent == null)        
        {
            NullPointerException varED1EDCABC9DE1352BD636F2377072BDB_1451204676 = new NullPointerException("parent == null");
            varED1EDCABC9DE1352BD636F2377072BDB_1451204676.addTaint(taint);
            throw varED1EDCABC9DE1352BD636F2377072BDB_1451204676;
        } 
        this.name = name;
        this.parent = parent;
    if(parent != null)        
        {
            parent.add(this);
            this.setMaxPriority(parent.getMaxPriority());
    if(parent.isDaemon())            
            {
                this.setDaemon(true);
            } 
        } 
        
        
            
        
        
        
        
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.599 -0400", hash_original_method = "2C0349D8A755A992C407F37169B24D0C", hash_generated_method = "2023BF93A9F5BDCA687CAB745D1EC815")
    private  ThreadGroup() {
        this.name = "system";
        this.parent = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.600 -0400", hash_original_method = "F6402A744D3DEB7896E39C3D58ADE009", hash_generated_method = "C975135F04525FE1C85E19A630D72FE3")
    public int activeCount() {
        int count = 0;
        synchronized
(threadRefs)        {
for(Thread thread : threads)
            {
    if(thread.isAlive())                
                {
                    count++;
                } 
            } 
        } 
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                count += group.activeCount();
            } 
        } 
        int varE2942A04780E223B215EB8B663CF5353_1112600053 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_324578955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_324578955;
        
        
        
            
                
                    
                
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.601 -0400", hash_original_method = "AF255D2A52D389FA67BDDD4C4590191B", hash_generated_method = "DF745ECE4CE4E7B2E33255055F4CF4AA")
    public int activeGroupCount() {
        int count = 0;
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                count += 1 + group.activeGroupCount();
            } 
        } 
        int varE2942A04780E223B215EB8B663CF5353_893154841 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870623621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870623621;
        
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.601 -0400", hash_original_method = "0DD772AEDB7C823C2E91BB6377F03397", hash_generated_method = "206C3B4A386DF31EEFCF57B3820FAD9F")
    private void add(ThreadGroup g) throws IllegalThreadStateException {
        addTaint(g.getTaint());
        synchronized
(groups)        {
    if(isDestroyed)            
            {
                IllegalThreadStateException varA05439E94317FDF813F0A0DCA5B5DD9A_1216488891 = new IllegalThreadStateException();
                varA05439E94317FDF813F0A0DCA5B5DD9A_1216488891.addTaint(taint);
                throw varA05439E94317FDF813F0A0DCA5B5DD9A_1216488891;
            } 
            groups.add(g);
        } 
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.602 -0400", hash_original_method = "17B34AC990B7E085858AFAD80E625CEB", hash_generated_method = "8A7D499A5DEE2D74D6BFF11A21DEDCFC")
    @Deprecated
    public boolean allowThreadSuspension(boolean b) {
        addTaint(b);
        boolean varB326B5062B2F0E69046810717534CB09_448945141 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_969024923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_969024923;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.602 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    public final void checkAccess() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.603 -0400", hash_original_method = "662D73EDBF2256DFDB84D7DB5F6E6941", hash_generated_method = "F6C0A32395DC814CF4187DC1837E5354")
    public final void destroy() {
        synchronized
(threadRefs)        {
            synchronized
(groups)            {
    if(isDestroyed)                
                {
                    IllegalThreadStateException var759515A5611E927EE189DAC60459E163_1903957407 = new IllegalThreadStateException(
                            "Thread group was already destroyed: "
                            + (this.name != null ? this.name : "n/a"));
                    var759515A5611E927EE189DAC60459E163_1903957407.addTaint(taint);
                    throw var759515A5611E927EE189DAC60459E163_1903957407;
                } 
    if(threads.iterator().hasNext())                
                {
                    IllegalThreadStateException varAC568F6EA8E9BD19EC11411DFC787840_720840639 = new IllegalThreadStateException(
                            "Thread group still contains threads: "
                            + (this.name != null ? this.name : "n/a"));
                    varAC568F6EA8E9BD19EC11411DFC787840_720840639.addTaint(taint);
                    throw varAC568F6EA8E9BD19EC11411DFC787840_720840639;
                } 
                while
(!groups.isEmpty())                
                {
                    groups.get(0).destroy();
                } 
    if(parent != null)                
                {
                    parent.remove(this);
                } 
                this.isDestroyed = true;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.604 -0400", hash_original_method = "CD7DBC672D59D1FAACCF6E53D785D515", hash_generated_method = "3ECD5C24D4B58AAD907F74000FD3A576")
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
                    } 
                } 
            } 
        } 
        
        
            
                
                    
                        
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.605 -0400", hash_original_method = "4F115C3CD94EE462D7FE29C66038CE8B", hash_generated_method = "9CD80AD6F2293FEC364BF6EA1163EDDE")
    public int enumerate(Thread[] threads) {
        addTaint(threads[0].getTaint());
        int varE88487EA963B1CA4470710FDEEF6150D_2009664692 = (enumerate(threads, true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881062264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881062264;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.606 -0400", hash_original_method = "7C9447501CA37C2477868C242A118750", hash_generated_method = "20BE155F692E4CEDD3EBA04D9A867F13")
    public int enumerate(Thread[] threads, boolean recurse) {
        addTaint(recurse);
        addTaint(threads[0].getTaint());
        int var9F45FC03189A4CDE3A04E26394C27598_2007825829 = (enumerateGeneric(threads, recurse, 0, true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_338143312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_338143312;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.606 -0400", hash_original_method = "CA294C4CBD805FDF86CE51E26A265568", hash_generated_method = "64684B8C7B486D25D221A301416ECC8D")
    public int enumerate(ThreadGroup[] groups) {
        addTaint(groups[0].getTaint());
        int var67882C778C85CFFFAB178FC90FD4AD6C_660283287 = (enumerate(groups, true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546741385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546741385;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.606 -0400", hash_original_method = "C3125975C33A76683DB83E92F1059496", hash_generated_method = "827359751C4F10F41F95169E84A1AC97")
    public int enumerate(ThreadGroup[] groups, boolean recurse) {
        addTaint(recurse);
        addTaint(groups[0].getTaint());
        int varF80C0934D497350B81BE9A2A2F86F000_61200214 = (enumerateGeneric(groups, recurse, 0, false));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566215026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566215026;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.608 -0400", hash_original_method = "7CEEE4341262A9B70C3A153644CFBA1A", hash_generated_method = "04F55F7CAC57125AEC9D592D1CB16874")
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
                            int var4118BA52E9D686B3984C6B39C3013E3A_519968679 = (enumerationIndex);
                                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1453798082 = getTaintInt();
                            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1453798082;
                        } 
                        enumeration[enumerationIndex++] = thread;
                    } 
                } 
            } 
        } 
        else
        {
            synchronized
(groups)            {
for(int i = groups.size() - 1;i >= 0;--i)
                {
    if(enumerationIndex >= enumeration.length)                    
                    {
                        int var4118BA52E9D686B3984C6B39C3013E3A_1824854237 = (enumerationIndex);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90657593 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90657593;
                    } 
                    enumeration[enumerationIndex++] = groups.get(i);
                } 
            } 
        } 
    if(recurse)        
        {
            synchronized
(groups)            {
for(ThreadGroup group : groups)
                {
    if(enumerationIndex >= enumeration.length)                    
                    {
                        int var4118BA52E9D686B3984C6B39C3013E3A_1350995933 = (enumerationIndex);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107185412 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107185412;
                    } 
                    enumerationIndex = group.enumerateGeneric(enumeration, recurse,
                            enumerationIndex, enumeratingThreads);
                } 
            } 
        } 
        int var4118BA52E9D686B3984C6B39C3013E3A_1530450623 = (enumerationIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599154457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599154457;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.609 -0400", hash_original_method = "DB664BE89D62AA134945B6EEF3A0CB00", hash_generated_method = "84F63663611370473EC906A5946ECB71")
    public final int getMaxPriority() {
        int var605B899CE7517A7E2B487FD888B3B34B_1964125859 = (maxPriority);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145343741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145343741;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.609 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "E451DE3775BA08D4FDA9903B3779141C")
    public final String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_231132552 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_231132552.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_231132552;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.609 -0400", hash_original_method = "8A85A1BC7F9CDC3D0187C50787EE4700", hash_generated_method = "0971F8216994C223B32A23209F9E9340")
    public final ThreadGroup getParent() {
ThreadGroup var0F49909EA73F8892C338E4DCA6EB9906_946796590 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_946796590.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_946796590;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.610 -0400", hash_original_method = "2F1556F9A0B232F489BC24F1BD1E38E0", hash_generated_method = "D1EA4039B0425509B7BD00775FC14E30")
    public final void interrupt() {
        synchronized
(threadRefs)        {
for(Thread thread : threads)
            {
                thread.interrupt();
            } 
        } 
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                group.interrupt();
            } 
        } 
        
        
            
                
            
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.610 -0400", hash_original_method = "5976FB7C02B0576FC514CB127C4662D8", hash_generated_method = "B21191BAC6BD837BCF715C141AC496AC")
    public final boolean isDaemon() {
        boolean var1CFEB9E5381AE97C57DD59616C5FA3B7_968108783 = (isDaemon);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1288915702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1288915702;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.611 -0400", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "4DA86BF6B1CA6D2CBD791936E13FABF1")
    public synchronized boolean isDestroyed() {
        boolean var090F38A7DDDF192B3BA702F9AFFD747C_1398701969 = (isDestroyed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379688798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_379688798;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.611 -0400", hash_original_method = "8CFF2ECA4877D9633C2E3E2E2839A20E", hash_generated_method = "C6E05FAED89AA6A1B46B82F7A311D5CC")
    public void list() {
        System.out.println();
        list(0);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.611 -0400", hash_original_method = "38F7DBD37EF32F68FFB89F20FFE0F443", hash_generated_method = "E2BD07B0F9BBC705A50C049F9A6B8FED")
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
            } 
        } 
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                group.list(levels);
            } 
        } 
        
        
        
        
        
            
                
                
            
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.612 -0400", hash_original_method = "074D68FF209CFCAF4851113378206A39", hash_generated_method = "08A3D3C98405AB643B339EE874F88F51")
    private void indent(int levels) {
        addTaint(levels);
for(int i = 0;i < levels;i++)
        {
            System.out.print("    ");
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.613 -0400", hash_original_method = "47457D8FCC611743893B7B7E5D80876A", hash_generated_method = "CBF442AB78D26D3633ED0BC3035FF617")
    public final boolean parentOf(ThreadGroup g) {
        addTaint(g.getTaint());
        while
(g != null)        
        {
    if(this == g)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1681259036 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104871303 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_104871303;
            } 
            g = g.parent;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1805439418 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772978332 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_772978332;
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.613 -0400", hash_original_method = "7E8DD532FE0D28207249CA86D60AFD62", hash_generated_method = "E8F8F23876D2A1A5C1BAA9519A159170")
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
                } 
            } 
        } 
        destroyIfEmptyDaemon();
        
        
            
                
                
                    
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.614 -0400", hash_original_method = "DD66491EA6460453E572207637EFB169", hash_generated_method = "509ED0C2176DDCCF4665FF88E295657C")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void resume() {
        synchronized
(threadRefs)        {
for(Thread thread : threads)
            {
                thread.resume();
            } 
        } 
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                group.resume();
            } 
        } 
        
        
            
                
            
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.614 -0400", hash_original_method = "8335FAF0BC3ED6B3C58B58617340A520", hash_generated_method = "41930952754EA7B18095BC1B8F27AACA")
    public final void setDaemon(boolean isDaemon) {
        this.isDaemon = isDaemon;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.615 -0400", hash_original_method = "271C3F89CA43821F381115CC8E2996B2", hash_generated_method = "31CDE7ECEB308F5619C0D1789D52D23A")
    public final void setMaxPriority(int newMax) {
    if(newMax <= this.maxPriority)        
        {
    if(newMax < Thread.MIN_PRIORITY)            
            {
                newMax = Thread.MIN_PRIORITY;
            } 
            int parentPriority = parent == null ? newMax : parent.getMaxPriority();
            this.maxPriority = parentPriority <= newMax ? parentPriority : newMax;
            synchronized
(groups)            {
for(ThreadGroup group : groups)
                {
                    group.setMaxPriority(newMax);
                } 
            } 
        } 
        
        
            
                
            
            
            
            
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.616 -0400", hash_original_method = "59A4D041306D60B1EF57E2C22E471227", hash_generated_method = "713A24B4C3E1BAC61769770BEF29FA86")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void stop() {
    if(stopHelper())        
        {
            Thread.currentThread().stop();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.616 -0400", hash_original_method = "F86867FC41FDF8B0075237470EA8A18F", hash_generated_method = "B66C711FA6FE148D51FC2AC40331063C")
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
                } 
                else
                {
                    thread.stop();
                } 
            } 
        } 
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                stopCurrent |= group.stopHelper();
            } 
        } 
        boolean var784B75F63E8CE9D6B35ED439029C6847_1109704643 = (stopCurrent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_869743217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_869743217;
        
        
        
            
            
                
                    
                
                    
                
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.617 -0400", hash_original_method = "26CED40B1639307872B1DC8622DA2669", hash_generated_method = "B5EC9002911ED8AFA497E3AA15F8F956")
    @SuppressWarnings("deprecation")
    @Deprecated
    public final void suspend() {
    if(suspendHelper())        
        {
            Thread.currentThread().suspend();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.618 -0400", hash_original_method = "664C597F1857BDEBDBE75F13D3F147B7", hash_generated_method = "59D3929C082004FA50893FFDC5932780")
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
                } 
                else
                {
                    thread.suspend();
                } 
            } 
        } 
        synchronized
(groups)        {
for(ThreadGroup group : groups)
            {
                suspendCurrent |= group.suspendHelper();
            } 
        } 
        boolean var78753EFF84E0F2A5BDFA90A5A032233B_1756936088 = (suspendCurrent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845086584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_845086584;
        
        
        
            
            
                
                    
                
                    
                
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.618 -0400", hash_original_method = "54318ADB79169F8C74CBC002CF89020D", hash_generated_method = "3118A09AAF97D399A21CC8125B399412")
    @Override
    public String toString() {
String var8A8A36D1F5831B81760F8A7B6FB3030F_1223439841 =         getClass().getName() + "[name=" + getName()
                + ",maxPriority=" + getMaxPriority() + "]";
        var8A8A36D1F5831B81760F8A7B6FB3030F_1223439841.addTaint(taint);
        return var8A8A36D1F5831B81760F8A7B6FB3030F_1223439841;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.619 -0400", hash_original_method = "1AEEC9D33E82C49A9FE6D436A43A8349", hash_generated_method = "9DF25E8A893766443023250739070799")
    public void uncaughtException(Thread t, Throwable e) {
        addTaint(e.getTaint());
        addTaint(t.getTaint());
    if(parent != null)        
        {
            parent.uncaughtException(t, e);
        } 
        else
    if(Thread.getDefaultUncaughtExceptionHandler() != null)        
        {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
        } 
        else
    if(!(e instanceof ThreadDeath))        
        {
            e.printStackTrace(System.err);
        } 
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.619 -0400", hash_original_method = "2D14DBB3818CDCF2DBAC484BFFF8FD8D", hash_generated_method = "29FA4668B25F76C1CCB171643F14DEE3")
    final void addThread(Thread thread) throws IllegalThreadStateException {
        addTaint(thread.getTaint());
        synchronized
(threadRefs)        {
    if(isDestroyed)            
            {
                IllegalThreadStateException varA05439E94317FDF813F0A0DCA5B5DD9A_1588258219 = new IllegalThreadStateException();
                varA05439E94317FDF813F0A0DCA5B5DD9A_1588258219.addTaint(taint);
                throw varA05439E94317FDF813F0A0DCA5B5DD9A_1588258219;
            } 
            threadRefs.add(new WeakReference<Thread>(thread));
        } 
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.620 -0400", hash_original_method = "37129B7DF3D611DDAA565F6673B5A889", hash_generated_method = "B09E492711FFDC23E5C76E8092AE8DCF")
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
                } 
            } 
        } 
        destroyIfEmptyDaemon();
        
        
            
                
                    
                    
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.620 -0400", hash_original_field = "70A32802F055FB9A8B4FBD04FF20DFF8", hash_generated_field = "C469F1CA0F9CB15DC605ADF2C779CB30")

    static final ThreadGroup mSystem = new ThreadGroup();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.620 -0400", hash_original_field = "6FE2FE3A7188BFD5BCCC556BE6D6F073", hash_generated_field = "843DB6CD61C0C78ABA07CFE273D0F240")

    static final ThreadGroup mMain = new ThreadGroup(mSystem, "main");
}

