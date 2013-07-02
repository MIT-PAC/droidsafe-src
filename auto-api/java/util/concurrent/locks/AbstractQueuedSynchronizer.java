package java.util.concurrent.locks;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import sun.misc.Unsafe;

public abstract class AbstractQueuedSynchronizer extends AbstractOwnableSynchronizer implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.704 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "C968564223BCE6AEFE8413EAB36A32B1")

    private transient volatile Node head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.704 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "AD93D08E1C37116EBC071C3224E8414A")

    private transient volatile Node tail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.704 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "40C4313E234E54E18DC2BFEA68F3E464")

    private volatile int state;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.705 -0400", hash_original_method = "C7F1FA27B1E7517E25F1C7951B5E8CA8", hash_generated_method = "D0F5CBC29675A9CABCA264BF6F7A7644")
    protected  AbstractQueuedSynchronizer() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.705 -0400", hash_original_method = "15A8F8E5739EB2961628EAE8F68BF29F", hash_generated_method = "27CE8646FD85AB9F0096CA2E1C63387E")
    protected final int getState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234711999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234711999;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.705 -0400", hash_original_method = "57BE013BA515294E586014B30A336C04", hash_generated_method = "B9B29E2146A9DFA0E89C5BBC08072583")
    protected final void setState(int newState) {
        state = newState;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.705 -0400", hash_original_method = "DF00243144DD556AB3E9A0ABE3AEC78F", hash_generated_method = "54445D99EA57832D054991A706E2DD1D")
    protected final boolean compareAndSetState(int expect, int update) {
        boolean var281C41540058F29F0DB0A762C52DDE13_133015414 = (unsafe.compareAndSwapInt(this, stateOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535197664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_535197664;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.706 -0400", hash_original_method = "D115C79C5FCCB59668763118EBD8CBBB", hash_generated_method = "79CD1373BAB5661540C601C6DAC4B80F")
    private Node enq(final Node node) {
        Node varB4EAC82CA7396A68D541C85D26508E83_2109861736 = null; 
        {
            Node t = tail;
            {
                {
                    boolean varC2BD7D899FDAEA316177871081826EFD_1835505141 = (compareAndSetHead(new Node()));
                    tail = head;
                } 
            } 
            {
                node.prev = t;
                {
                    boolean var30CFF97C04D4F21E508F35AC3CDBADC7_1252313297 = (compareAndSetTail(t, node));
                    {
                        t.next = node;
                        varB4EAC82CA7396A68D541C85D26508E83_2109861736 = t;
                    } 
                } 
            } 
        } 
        addTaint(node.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2109861736.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2109861736;
        
        
            
            
                
                    
            
                
                
                    
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.707 -0400", hash_original_method = "7269E5EC16B8883F661BF745CCC5E6A6", hash_generated_method = "DDDD7469357FF159CDF3D6C39FF9C167")
    private Node addWaiter(Node mode) {
        Node varB4EAC82CA7396A68D541C85D26508E83_336580903 = null; 
        Node varB4EAC82CA7396A68D541C85D26508E83_701469997 = null; 
        Node node = new Node(Thread.currentThread(), mode);
        Node pred = tail;
        {
            node.prev = pred;
            {
                boolean varB759FEC06526555CC952C851C67B8004_1781505621 = (compareAndSetTail(pred, node));
                {
                    pred.next = node;
                    varB4EAC82CA7396A68D541C85D26508E83_336580903 = node;
                } 
            } 
        } 
        enq(node);
        varB4EAC82CA7396A68D541C85D26508E83_701469997 = node;
        addTaint(mode.getTaint());
        Node varA7E53CE21691AB073D9660D615818899_1486768151; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1486768151 = varB4EAC82CA7396A68D541C85D26508E83_336580903;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1486768151 = varB4EAC82CA7396A68D541C85D26508E83_701469997;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1486768151.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1486768151;
        
        
        
        
            
            
                
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.708 -0400", hash_original_method = "51AEDFDDD323C78EE2EC4A6DE568B8D1", hash_generated_method = "E532E4CBBEBFF44C610D0F95E73E8319")
    private void setHead(Node node) {
        head = node;
        node.thread = null;
        node.prev = null;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.709 -0400", hash_original_method = "F262A3A18BABECF7EC492736953EAF6E", hash_generated_method = "BA63E2A4F1706F856E287648A720CEA3")
    private void unparkSuccessor(Node node) {
        int ws = node.waitStatus;
        compareAndSetWaitStatus(node, ws, 0);
        Node s = node.next;
        {
            s = null;
            {
                Node t = tail;
                t = t.prev;
                s = t;
            } 
        } 
        LockSupport.unpark(s.thread);
        addTaint(node.getTaint());
        
        
        
            
        
        
            
            
                
                    
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.710 -0400", hash_original_method = "D8D55646997B45206CD2F0528B603753", hash_generated_method = "96AB632C94BE7BA4DF6019BE7B2467D0")
    private void doReleaseShared() {
        {
            Node h = head;
            {
                int ws = h.waitStatus;
                {
                    {
                        boolean varCC865867FC8DEDE4843F9E3D62245755_1085527604 = (!compareAndSetWaitStatus(h, Node.SIGNAL, 0));
                    } 
                    unparkSuccessor(h);
                } 
                {
                    boolean var658C7F41A73D231A5E38D15A1070790F_2115788686 = (ws == 0 &&
                         !compareAndSetWaitStatus(h, 0, Node.PROPAGATE));
                } 
            } 
        } 
        
        
            
            
                
                
                    
                        
                    
                
                
                         
                    
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.710 -0400", hash_original_method = "A2FB30DAE399AEFA487E20396027BD36", hash_generated_method = "CE60629F46D285715C7B8141C545C72E")
    private void setHeadAndPropagate(Node node, int propagate) {
        Node h = head;
        setHead(node);
        {
            Node s = node.next;
            {
                boolean varB6D0E63ACFCFA5DA33C33F91435930F9_290957775 = (s == null || s.isShared());
                doReleaseShared();
            } 
        } 
        addTaint(node.getTaint());
        addTaint(propagate);
        
        
        
        
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.711 -0400", hash_original_method = "1CA41B58715410C4216B9DE6C43BB9D4", hash_generated_method = "34B828A04341C07B6E9860DA17643FEC")
    private void cancelAcquire(Node node) {
        node.thread = null;
        Node pred = node.prev;
        node.prev = pred = pred.prev;
        Node predNext = pred.next;
        node.waitStatus = Node.CANCELLED;
        {
            boolean var9C67AE94C69ECBB4560E786F86E10C76_1151066679 = (node == tail && compareAndSetTail(node, pred));
            {
                compareAndSetNext(pred, predNext, null);
            } 
            {
                int ws;
                {
                    boolean var806CB84C61F87A678A0A252FCBFAAB06_1092699342 = (pred != head &&
                ((ws = pred.waitStatus) == Node.SIGNAL ||
                 (ws <= 0 && compareAndSetWaitStatus(pred, ws, Node.SIGNAL))) &&
                pred.thread != null);
                    {
                        Node next = node.next;
                        compareAndSetNext(pred, predNext, next);
                    } 
                    {
                        unparkSuccessor(node);
                    } 
                } 
                node.next = node;
            } 
        } 
        addTaint(node.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        int ws = pred.waitStatus;
        if (ws == Node.SIGNAL)
            return true;
        if (ws > 0) {
            do {
                node.prev = pred = pred.prev;
            } while (pred.waitStatus > 0);
            pred.next = node;
        } else {
            compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
        }
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    private static void selfInterrupt() {
        Thread.currentThread().interrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.712 -0400", hash_original_method = "C551D5FD0C0A2C72DAD755E48C68905F", hash_generated_method = "0AE375D7A9738AE097FBE50B456A4260")
    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        boolean var17A536D12FEB0466CF9F0EDC1509A805_1387697008 = (Thread.interrupted());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327459925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327459925;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.712 -0400", hash_original_method = "0D7553B7A8DFDAC7C355CECFA0DBF574", hash_generated_method = "DE4828118D9DE4B53FF11A3BF2262D39")
    final boolean acquireQueued(final Node node, int arg) {
        boolean failed = true;
        try 
        {
            boolean interrupted = false;
            {
                final Node p = node.predecessor();
                {
                    boolean varB702A2D695A14FF8E8F201BF2E513471_1417086697 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } 
                } 
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_1785987823 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    interrupted = true;
                } 
            } 
        } 
        finally 
        {
            cancelAcquire(node);
        } 
        addTaint(node.getTaint());
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659001063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659001063;
        
        
        
            
            
                
                
                    
                    
                    
                    
                
                
                    
                    
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.712 -0400", hash_original_method = "E74C4677EAF9B6C97A4A9A93D88FC71E", hash_generated_method = "63619401F22A8EBB89CBA5021C19113D")
    private void doAcquireInterruptibly(int arg) throws InterruptedException {
        final Node node = addWaiter(Node.EXCLUSIVE);
        boolean failed = true;
        try 
        {
            {
                final Node p = node.predecessor();
                {
                    boolean varB702A2D695A14FF8E8F201BF2E513471_1611091863 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } 
                } 
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_385021405 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } 
            } 
        } 
        finally 
        {
            cancelAcquire(node);
        } 
        addTaint(arg);
        
        
        
        
            
                
                
                    
                    
                    
                    
                
                
                    
                    
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.713 -0400", hash_original_method = "AF980EBAC4BC6C4AB1174BED3B10073B", hash_generated_method = "A73C8F7EB50C99D78F738ABE4B6BE3C0")
    private boolean doAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
        long lastTime = System.nanoTime();
        final Node node = addWaiter(Node.EXCLUSIVE);
        boolean failed = true;
        try 
        {
            {
                final Node p = node.predecessor();
                {
                    boolean varB702A2D695A14FF8E8F201BF2E513471_1213192040 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } 
                } 
                {
                    boolean var00B5F1835D8E1D445CE64BB60FAD1503_500808659 = (shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold);
                    LockSupport.parkNanos(this, nanosTimeout);
                } 
                long now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                {
                    boolean varFDD1D09D0FE11E5BCA86E55DE77A8E11_952796889 = (Thread.interrupted());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } 
            } 
        } 
        finally 
        {
            cancelAcquire(node);
        } 
        addTaint(arg);
        addTaint(nanosTimeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7797559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7797559;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.713 -0400", hash_original_method = "D66678B4038334D8E14600B3A8FC8FD7", hash_generated_method = "645160197E089548B306FDF5498B827D")
    private void doAcquireShared(int arg) {
        final Node node = addWaiter(Node.SHARED);
        boolean failed = true;
        try 
        {
            boolean interrupted = false;
            {
                final Node p = node.predecessor();
                {
                    int r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        selfInterrupt();
                        failed = false;
                    } 
                } 
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_2069770199 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    interrupted = true;
                } 
            } 
        } 
        finally 
        {
            cancelAcquire(node);
        } 
        addTaint(arg);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.714 -0400", hash_original_method = "4E093FA1B6FCF5593272CE0DEA00D69B", hash_generated_method = "9222FF4340AF9C44C6BD83E5419FFE38")
    private void doAcquireSharedInterruptibly(int arg) throws InterruptedException {
        final Node node = addWaiter(Node.SHARED);
        boolean failed = true;
        try 
        {
            {
                final Node p = node.predecessor();
                {
                    int r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                    } 
                } 
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_587591179 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } 
            } 
        } 
        finally 
        {
            cancelAcquire(node);
        } 
        addTaint(arg);
        
        
        
        
            
                
                
                    
                    
                        
                        
                        
                        
                    
                
                
                    
                    
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.715 -0400", hash_original_method = "873D99639E9E59C87CD3A574B36E4573", hash_generated_method = "C27B7C5E29B2285217558CA115AD31AC")
    private boolean doAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
        long lastTime = System.nanoTime();
        final Node node = addWaiter(Node.SHARED);
        boolean failed = true;
        try 
        {
            {
                final Node p = node.predecessor();
                {
                    int r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                    } 
                } 
                {
                    boolean var00B5F1835D8E1D445CE64BB60FAD1503_1788546416 = (shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold);
                    LockSupport.parkNanos(this, nanosTimeout);
                } 
                long now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                {
                    boolean varFDD1D09D0FE11E5BCA86E55DE77A8E11_1070300985 = (Thread.interrupted());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } 
            } 
        } 
        finally 
        {
            cancelAcquire(node);
        } 
        addTaint(arg);
        addTaint(nanosTimeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_285614536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_285614536;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.715 -0400", hash_original_method = "FADA99D99649E8B049B596B89A86AFE3", hash_generated_method = "6186CBA75D5C3CB57C903D2970A24689")
    protected boolean tryAcquire(int arg) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014289430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014289430;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.715 -0400", hash_original_method = "0AA9B3926B88397CF769442818D9CA16", hash_generated_method = "C4529D16593C4AC1692E033991BCC742")
    protected boolean tryRelease(int arg) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686347411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686347411;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.715 -0400", hash_original_method = "143AB2DE4C7A8CA8F45FD3C862AFB93B", hash_generated_method = "B785BAF3A5CC16FF7B8E7F0F7734331C")
    protected int tryAcquireShared(int arg) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(arg);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718345025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718345025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.716 -0400", hash_original_method = "57760B0E19163CFD26451EB4C702B2B7", hash_generated_method = "59B7D4419C2E895B97A4B53440954327")
    protected boolean tryReleaseShared(int arg) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_123768375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_123768375;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.716 -0400", hash_original_method = "B1A3EF7BA2A74EEB6B3236F0A99ED9FE", hash_generated_method = "C607744BF850779675539FD7CA8C5569")
    protected boolean isHeldExclusively() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_132435959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_132435959;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.716 -0400", hash_original_method = "10DE26F4AB94E5F1867D5F821F4BF0D7", hash_generated_method = "D67F8BD1D06ADDB9A31C0A31F56B3C86")
    public final void acquire(int arg) {
        {
            boolean varFCEF5DD222F9CABA3FDCCFE99D21AA7A_915816171 = (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg));
            selfInterrupt();
        } 
        addTaint(arg);
        
        
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.717 -0400", hash_original_method = "34DE0EEECFCC486100F3F952023E1D48", hash_generated_method = "3AB876C2EEA040ADAD41BB040829E43E")
    public final void acquireInterruptibly(int arg) throws InterruptedException {
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1386886646 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } 
        {
            boolean var6C80CD83DDCC36721F42CDF9EFE1FC97_1045155900 = (!tryAcquire(arg));
            doAcquireInterruptibly(arg);
        } 
        addTaint(arg);
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.717 -0400", hash_original_method = "C2BC4409CE226EEA6D2598B40FA64E1C", hash_generated_method = "73461E5B105DF1A95C46E5C53600A562")
    public final boolean tryAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_666879237 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } 
        boolean var34DCAB88C8A0F240E32D599EDB2FE196_1112184574 = (tryAcquire(arg) ||
            doAcquireNanos(arg, nanosTimeout));
        addTaint(arg);
        addTaint(nanosTimeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1409396926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1409396926;
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.718 -0400", hash_original_method = "482847B9E820B21E98E389768A5050E4", hash_generated_method = "1F7E2CC79E44992D2D1EAFDCED421581")
    public final boolean release(int arg) {
        {
            boolean varFF82B8E2BC2E04000CA63D87A88AB8D2_1478827664 = (tryRelease(arg));
            {
                Node h = head;
                unparkSuccessor(h);
            } 
        } 
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806958487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_806958487;
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.718 -0400", hash_original_method = "503864E706CF656D09684EB1E461773D", hash_generated_method = "9BBB36D40ACE1443DED267934559B83E")
    public final void acquireShared(int arg) {
        {
            boolean varE24C999E8142A86B0EF4E6AFA805A8A0_1493693582 = (tryAcquireShared(arg) < 0);
            doAcquireShared(arg);
        } 
        addTaint(arg);
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.720 -0400", hash_original_method = "10425BDCE3B0F2DAA2E0ECCAD9B4BACD", hash_generated_method = "6398652662492D2A298121D9A8ACF1A2")
    public final void acquireSharedInterruptibly(int arg) throws InterruptedException {
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1187438706 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } 
        {
            boolean varE24C999E8142A86B0EF4E6AFA805A8A0_917392534 = (tryAcquireShared(arg) < 0);
            doAcquireSharedInterruptibly(arg);
        } 
        addTaint(arg);
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.721 -0400", hash_original_method = "34AA5C57E6BB40898FDB5D4BB2EF37C3", hash_generated_method = "5D1521B4BE51DC32B2DCD1F3CD988E2A")
    public final boolean tryAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1093696651 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } 
        boolean varE4B1D6DE7AE03DFEE28CA37F75A87EB4_331259007 = (tryAcquireShared(arg) >= 0 ||
            doAcquireSharedNanos(arg, nanosTimeout));
        addTaint(arg);
        addTaint(nanosTimeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_617791659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_617791659;
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.721 -0400", hash_original_method = "64AF2599D3C05FF36535D67856367D8D", hash_generated_method = "A6A575AB006CDFF2B1EA353FB7C6C3EC")
    public final boolean releaseShared(int arg) {
        {
            boolean varEB9480595F3C382515F926391F6AAE14_1854542519 = (tryReleaseShared(arg));
            {
                doReleaseShared();
            } 
        } 
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949220971 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_949220971;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.721 -0400", hash_original_method = "3ACA5092770D7AD1442898AF3B627DFE", hash_generated_method = "7ED4883BAA4BC9FA2ACC09E355EA5BDB")
    public final boolean hasQueuedThreads() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801218413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801218413;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.722 -0400", hash_original_method = "3ED9D0D071477B613E998B33D61DD4C5", hash_generated_method = "97340D1D4F86B2EE2F1A70977349641B")
    public final boolean hasContended() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261355073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_261355073;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.722 -0400", hash_original_method = "DB23AE447B60E978D848F5CEAEC8257B", hash_generated_method = "EC94D9EB97F5A2B75526EF90A6C1A5D1")
    public final Thread getFirstQueuedThread() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_1896521069 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1896521069 = (head == tail) ? null : fullGetFirstQueuedThread();
        varB4EAC82CA7396A68D541C85D26508E83_1896521069.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1896521069;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.724 -0400", hash_original_method = "18818CB637EBC5CF82DC4C50B37FB17C", hash_generated_method = "32B11DD8B096F0D416A698B4F9745DF9")
    private Thread fullGetFirstQueuedThread() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_375213537 = null; 
        Thread varB4EAC82CA7396A68D541C85D26508E83_297603398 = null; 
        Node h;
        Node s;
        Thread st = null;
        {
            boolean varAB96948AFE2AAAF3BBF624BD73ABA985_914055970 = (((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null) ||
            ((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null));
            varB4EAC82CA7396A68D541C85D26508E83_375213537 = st;
        } 
        Node t = tail;
        Thread firstThread = null;
        {
            Thread tt = t.thread;
            firstThread = tt;
            t = t.prev;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_297603398 = firstThread;
        Thread varA7E53CE21691AB073D9660D615818899_1159699408; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1159699408 = varB4EAC82CA7396A68D541C85D26508E83_375213537;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1159699408 = varB4EAC82CA7396A68D541C85D26508E83_297603398;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1159699408.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1159699408;
        
        
        
        
             
            
             
            
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.724 -0400", hash_original_method = "1573E83A14D593E0BFADABB9AEDBB7D2", hash_generated_method = "94C1460066E24A4F9BFD735C6A00E0C3")
    public final boolean isQueued(Thread thread) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            Node p = tail;
            p = p.prev;
        } 
        addTaint(thread.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1311867274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1311867274;
        
        
            
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.725 -0400", hash_original_method = "4993AFB2E466C494E10B5DA4780E51AB", hash_generated_method = "72377EA12517652CA9913E11983F2746")
    final boolean apparentlyFirstQueuedIsExclusive() {
        Node h;
        Node s;
        boolean var7A2694C8A18196F041BDCF2FCD7324AE_1611597793 = ((h = head) != null &&
            (s = h.next)  != null &&
            !s.isShared()         &&
            s.thread != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2136468824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2136468824;
        
        
        
            
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.726 -0400", hash_original_method = "155F6B01F514C41CA8367710346D37E3", hash_generated_method = "A18A9E744262168D902BD4989271381D")
    public final boolean hasQueuedPredecessors() {
        Node t = tail;
        Node h = head;
        Node s;
        boolean var4B72E4D0E536DE6B3ACB8283BCD4F664_1531327258 = (h != t &&
            ((s = h.next) == null || s.thread != Thread.currentThread()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890809151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_890809151;
        
        
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.727 -0400", hash_original_method = "65AB677A04652631BF1CC269A789F93A", hash_generated_method = "BBEA5EF1485E871AF5E659D832A4BAE4")
    public final int getQueueLength() {
        int n = 0;
        {
            Node p = tail;
            p = p.prev;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805454916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805454916;
        
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.730 -0400", hash_original_method = "BA97C075FB0E9B39CEF398B585209CAD", hash_generated_method = "7EE677674F2954A1B5874C6F4C1F870C")
    public final Collection<Thread> getQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1156636360 = null; 
        ArrayList<Thread> list = new ArrayList<Thread>();
        {
            Node p = tail;
            p = p.prev;
            {
                Thread t = p.thread;
                list.add(t);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1156636360 = list;
        varB4EAC82CA7396A68D541C85D26508E83_1156636360.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1156636360;
        
        
        
            
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.731 -0400", hash_original_method = "8F9C05C78C38CDEC6B94C7386A00C30C", hash_generated_method = "639BF49E31174ECB0766C3AEEBBA0636")
    public final Collection<Thread> getExclusiveQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_699509453 = null; 
        ArrayList<Thread> list = new ArrayList<Thread>();
        {
            Node p = tail;
            p = p.prev;
            {
                {
                    boolean varDFA54A0E0CB503BCC5CE98449AAB2A08_1149430874 = (!p.isShared());
                    {
                        Thread t = p.thread;
                        list.add(t);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_699509453 = list;
        varB4EAC82CA7396A68D541C85D26508E83_699509453.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_699509453;
        
        
        
            
                
                
                    
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.734 -0400", hash_original_method = "3B2BC348731488178C75B0F7C3256BE4", hash_generated_method = "F0A69F903ED909CAD09E90175D0F0D19")
    public final Collection<Thread> getSharedQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_900978619 = null; 
        ArrayList<Thread> list = new ArrayList<Thread>();
        {
            Node p = tail;
            p = p.prev;
            {
                {
                    boolean varC6C07EC060C76D1E58FED758F007D903_1183631581 = (p.isShared());
                    {
                        Thread t = p.thread;
                        list.add(t);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_900978619 = list;
        varB4EAC82CA7396A68D541C85D26508E83_900978619.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_900978619;
        
        
        
            
                
                
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.735 -0400", hash_original_method = "2C49C090DBE6788B4A91D995132AEECA", hash_generated_method = "76069C5F287ADD7952D07F390173AA41")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_852403564 = null; 
        int s = getState();
        String q;
        boolean var58703E822CB7EE24CF8A625587E1C63E_1461847503 = (hasQueuedThreads());
        q = "non";
        q = "";
        varB4EAC82CA7396A68D541C85D26508E83_852403564 = super.toString() +
            "[State = " + s + ", " + q + "empty queue]";
        varB4EAC82CA7396A68D541C85D26508E83_852403564.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_852403564;
        
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.736 -0400", hash_original_method = "0981A7B7481B56654552F826D97FC7A4", hash_generated_method = "EADC462A7EC504BD1BC887D5535FC03B")
    final boolean isOnSyncQueue(Node node) {
        boolean varF3A4D6770CAC1AA85AF3A6C51812BE70_1186950889 = (findNodeFromTail(node));
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827888665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_827888665;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.736 -0400", hash_original_method = "E84A510853D9F9659F34649D5E631E14", hash_generated_method = "DC85BACD481B1DC5DB6F6213A720D1CA")
    private boolean findNodeFromTail(Node node) {
        Node t = tail;
        {
            t = t.prev;
        } 
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1603262664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1603262664;
        
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.737 -0400", hash_original_method = "AC7EB2A7C3E5842E27808853E2EADEA4", hash_generated_method = "7C0FF8C347DF63AA1A1C01F07BDA4E1C")
    final boolean transferForSignal(Node node) {
        {
            boolean var8F78D6E41179A92913D59E278DAF4713_1939888298 = (!compareAndSetWaitStatus(node, Node.CONDITION, 0));
        } 
        Node p = enq(node);
        int ws = p.waitStatus;
        {
            boolean var11909F9DE762D0C62EFBB539D3DF08AB_1804562332 = (ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL));
            LockSupport.unpark(node.thread);
        } 
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201021473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201021473;
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.737 -0400", hash_original_method = "202AE2159172221E521994FECA693914", hash_generated_method = "5B7EF313D1FA032C54128B45B10941D1")
    final boolean transferAfterCancelledWait(Node node) {
        {
            boolean varAB52CB6F165D0797C877670E5EE00069_169509516 = (compareAndSetWaitStatus(node, Node.CONDITION, 0));
            {
                enq(node);
            } 
        } 
        {
            boolean varA5ECD06A31929CB111AEF5ECED825AFB_164287980 = (!isOnSyncQueue(node));
            Thread.yield();
        } 
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_358475470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_358475470;
        
        
            
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.738 -0400", hash_original_method = "13260C05A29655F6FC8F2FA182B20EC8", hash_generated_method = "0512957A1A56488C72D6D2EBAE8BD4D3")
    final int fullyRelease(Node node) {
        boolean failed = true;
        try 
        {
            int savedState = getState();
            {
                boolean var3C6705464C8EDF86A554C3C7455FE111_1154393664 = (release(savedState));
                {
                    failed = false;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
                } 
            } 
        } 
        finally 
        {
            node.waitStatus = Node.CANCELLED;
        } 
        addTaint(node.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381199163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381199163;
        
        
        
            
            
                
                
            
                
            
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.738 -0400", hash_original_method = "B60D02054E03A30F41C10CC4F7B33B2F", hash_generated_method = "064296E3096E494059F5D4C5F6B6EB19")
    public final boolean owns(ConditionObject condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        boolean var81F8FCB295780CD2D5751E1181CC9428_1842042827 = (condition.isOwnedBy(this));
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105671770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_105671770;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.739 -0400", hash_original_method = "B87CA02CD99C2C81A6ADCC153DE8BF7D", hash_generated_method = "D0F6DD81D234D85269E01A656699E245")
    public final boolean hasWaiters(ConditionObject condition) {
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_1083169856 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } 
        boolean var335079E40CDAA9EFDA14CFAFE44A0835_1385786759 = (condition.hasWaiters());
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652385121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652385121;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.739 -0400", hash_original_method = "FDFBF2604A26737643DD133E9F8A257F", hash_generated_method = "EC55E14B7DA9858445997EB600A273F2")
    public final int getWaitQueueLength(ConditionObject condition) {
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_614113763 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } 
        int var5991F4798FCDE9B9D32781CE8A86C9C1_1170891625 = (condition.getWaitQueueLength());
        addTaint(condition.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234008745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234008745;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.740 -0400", hash_original_method = "70972013E049E7504ADBD56143485C77", hash_generated_method = "38AA3E5A511926B6E62CFBE24452436B")
    public final Collection<Thread> getWaitingThreads(ConditionObject condition) {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_950885959 = null; 
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_744818510 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_950885959 = condition.getWaitingThreads();
        addTaint(condition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_950885959.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_950885959;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.741 -0400", hash_original_method = "20D2259271C7B1C96C133ACBD2C26B14", hash_generated_method = "CB5118CC417BEF70A70BE8176AB0527C")
    private final boolean compareAndSetHead(Node update) {
        boolean var7C9BAC36D5138868FE92F3C1948386AB_275966627 = (unsafe.compareAndSwapObject(this, headOffset, null, update));
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_30547462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_30547462;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.742 -0400", hash_original_method = "8C47C531A43F622294BF6051B04C8993", hash_generated_method = "300BD5A5DC5864C752D124E7410FCB99")
    private final boolean compareAndSetTail(Node expect, Node update) {
        boolean varC5CCFD292C10D03F1C8C777B8815D2E2_394440105 = (unsafe.compareAndSwapObject(this, tailOffset, expect, update));
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1612048255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1612048255;
        
        
    }

    
    private static final boolean compareAndSetWaitStatus(Node node,
                                                         int expect,
                                                         int update) {
        return unsafe.compareAndSwapInt(node, waitStatusOffset,
                                        expect, update);
    }

    
    private static final boolean compareAndSetNext(Node node,
                                                   Node expect,
                                                   Node update) {
        return unsafe.compareAndSwapObject(node, nextOffset, expect, update);
    }

    
    static final class Node {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.743 -0400", hash_original_field = "282F56A6C3233E93D5BACF05B9AA8876", hash_generated_field = "4D5292AE19E73CB6BC72A4A4EE34646D")

        volatile int waitStatus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.743 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "CE4F99BFA9BE83062548109E0A80EB36")

        volatile Node prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.743 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "495F81DE1A0BB70B1CC0F10199933490")

        volatile Node next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.743 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3347E7A3168C0A597DE966A2AEA728E2")

        volatile Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.743 -0400", hash_original_field = "1F76D737B407F4A2AD51A0EFEB508D50", hash_generated_field = "EE921616C37FFDDFA9B9DA84ABF34675")

        Node nextWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.743 -0400", hash_original_method = "2DD8BF5485F2495811D83404AF44A29C", hash_generated_method = "AAE5751DE21B256CB4EDD0DDB605F24E")
          Node() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.744 -0400", hash_original_method = "764EF23A3C66C99D5E5160039F46E6BD", hash_generated_method = "2CAC145FA8BF94E846C302C88AD33F87")
          Node(Thread thread, Node mode) {
            this.nextWaiter = mode;
            this.thread = thread;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.744 -0400", hash_original_method = "5118904E6021AE155CDFF15DB609BD48", hash_generated_method = "4FCE7CEF63C545859A3D7EF41D2DEAC9")
          Node(Thread thread, int waitStatus) {
            this.waitStatus = waitStatus;
            this.thread = thread;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.744 -0400", hash_original_method = "EA506AD78E2AE8ACF234FE0610B9A575", hash_generated_method = "F5FFBC5B86C383AA401A5C5087545D8A")
        final boolean isShared() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019449087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019449087;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.745 -0400", hash_original_method = "7AA5CFB77F71DE2C6FFA937BCE62ADAE", hash_generated_method = "A22B73EED7F91B8A93B5B3FCF3DEE20A")
        final Node predecessor() throws NullPointerException {
            Node varB4EAC82CA7396A68D541C85D26508E83_1713237132 = null; 
            Node p = prev;
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            varB4EAC82CA7396A68D541C85D26508E83_1713237132 = p;
            varB4EAC82CA7396A68D541C85D26508E83_1713237132.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1713237132;
            
            
            
                
            
                
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.745 -0400", hash_original_field = "29B93CAC7244964D7B989712BB2AAA8F", hash_generated_field = "A09441E8911A57E0DA262F7FAB0EA28A")

        static final Node SHARED = new Node();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.745 -0400", hash_original_field = "F427D28BCA700281DA9D02E201499452", hash_generated_field = "2FB080405C41D521F6A68DD8C95FE029")

        static final Node EXCLUSIVE = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.745 -0400", hash_original_field = "988DB81EC2397AB0D5457DF07B87908A", hash_generated_field = "E67B54E6E13DC27CF3608595B88B40CB")

        static final int CANCELLED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.745 -0400", hash_original_field = "1B171CE64A08A97E810AC0B2A481548E", hash_generated_field = "8577B9810AB6FC6DF6B54ADA380AC389")

        static final int SIGNAL = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.745 -0400", hash_original_field = "EC24A5598A6130CF31D6F9BEF244C4A1", hash_generated_field = "1D67D49288B45666BD2DADDDBBA57C2F")

        static final int CONDITION = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.745 -0400", hash_original_field = "2F582260408474C896C524B277DB2733", hash_generated_field = "16BF27DDB917629F3C35C8BC0AB5CC5C")

        static final int PROPAGATE = -3;
    }


    
    public class ConditionObject implements Condition, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.746 -0400", hash_original_field = "CD495CA7D725FEED43A3FB720F4B8EC1", hash_generated_field = "65A161514F134134E9F0B478EBDE5ED3")

        private transient Node firstWaiter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.746 -0400", hash_original_field = "8BDF0C40F706950EC229FBE0007BC4E3", hash_generated_field = "2A9616AEC7221DB00588D39E0457BC79")

        private transient Node lastWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.746 -0400", hash_original_method = "0A3E2C1E27BAEA738FDF96AD17500BEE", hash_generated_method = "6AF9B0E3D406E6C56AA07F09E795B0E2")
        public  ConditionObject() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.747 -0400", hash_original_method = "43F5E066353E431B2C9AD7CD0397BCCF", hash_generated_method = "E4601E87B43629C38561E7C95AC641BF")
        private Node addConditionWaiter() {
            Node varB4EAC82CA7396A68D541C85D26508E83_1112391234 = null; 
            Node t = lastWaiter;
            {
                unlinkCancelledWaiters();
                t = lastWaiter;
            } 
            Node node = new Node(Thread.currentThread(), Node.CONDITION);
            firstWaiter = node;
            t.nextWaiter = node;
            lastWaiter = node;
            varB4EAC82CA7396A68D541C85D26508E83_1112391234 = node;
            varB4EAC82CA7396A68D541C85D26508E83_1112391234.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1112391234;
            
            
            
                
                
            
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.747 -0400", hash_original_method = "74B8316ED8B5F40365D8BD9CF002AB2D", hash_generated_method = "5C5EA7ACA7CB99CD1C902C5E0049AF6A")
        private void doSignal(Node first) {
            {
                {
                    boolean varBC585BCE36C017A7C94055DA929092A7_1035336831 = ((firstWaiter = first.nextWaiter) == null);
                    lastWaiter = null;
                } 
                first.nextWaiter = null;
            } 
            {
                boolean var608C6B17E7E10DD5072B7876717FB9A1_579743315 = (!transferForSignal(first) &&
                     (first = firstWaiter) != null);
            } 
            addTaint(first.getTaint());
            
            
                
                    
                
            
                     
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.748 -0400", hash_original_method = "DE4F68C515AD9FDEF86DCFCC83AF390E", hash_generated_method = "9931E3B6B12CDDBA4B66622CAF0687D2")
        private void doSignalAll(Node first) {
            lastWaiter = firstWaiter = null;
            {
                Node next = first.nextWaiter;
                first.nextWaiter = null;
                transferForSignal(first);
                first = next;
            } 
            addTaint(first.getTaint());
            
            
            
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.749 -0400", hash_original_method = "2AF991EC026F340CB09E7C74A01E5A9A", hash_generated_method = "A6D234243F76AEBD78095CCA15575435")
        private void unlinkCancelledWaiters() {
            Node t = firstWaiter;
            Node trail = null;
            {
                Node next = t.nextWaiter;
                {
                    t.nextWaiter = null;
                    firstWaiter = next;
                    trail.nextWaiter = next;
                    lastWaiter = trail;
                } 
                trail = t;
                t = next;
            } 
            
            
            
            
                
                
                    
                    
                        
                    
                        
                    
                        
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.750 -0400", hash_original_method = "217DDC96D1B25C0D1457937D523A3AA4", hash_generated_method = "6238487A55AE47E982F7F49E9E28FCA0")
        public final void signal() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_775799455 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } 
            Node first = firstWaiter;
            doSignal(first);
            
            
                
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.751 -0400", hash_original_method = "8098E0901B1513A38FF0251B40A20DA9", hash_generated_method = "E5AC78095C50E4EA2B494FF541DCFB73")
        public final void signalAll() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_851805465 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } 
            Node first = firstWaiter;
            doSignalAll(first);
            
            
                
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.752 -0400", hash_original_method = "03B567BE1E70F2310FD90D1C09544B27", hash_generated_method = "3346AB3669C8E16C57750330F744CFD8")
        public final void awaitUninterruptibly() {
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            boolean interrupted = false;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1208943554 = (!isOnSyncQueue(node));
                {
                    LockSupport.park(this);
                    {
                        boolean varA664C6144AE4C03C0F8F972E8F70F7E8_360381649 = (Thread.interrupted());
                        interrupted = true;
                    } 
                } 
            } 
            {
                boolean var17DE45DCF221A6E3B338FD5BCAB95962_1553760668 = (acquireQueued(node, savedState) || interrupted);
                selfInterrupt();
            } 
            
            
            
            
            
                
                
                    
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.756 -0400", hash_original_method = "5CA3F4E55230C1BE0E77A65DF87A61F3", hash_generated_method = "744CA2B25519D6219BC001CD62067D8F")
        private int checkInterruptWhileWaiting(Node node) {
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_420952605 = (Thread.interrupted());
                Object varE3D941AA1F8858C4DCE68CB723942357_1425431015 = ((transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT)); 
            } 
            
            addTaint(node.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_615638950 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_615638950;
            
            
                
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.756 -0400", hash_original_method = "5304D5C5F98F936C59A15960318DA98F", hash_generated_method = "4F0549A9C71A3F0067ABB9F9CD8E2C15")
        private void reportInterruptAfterWait(int interruptMode) throws InterruptedException {
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            selfInterrupt();
            addTaint(interruptMode);
            
            
                
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.757 -0400", hash_original_method = "316B8F22454E74CF1A9F01045EC67EC6", hash_generated_method = "681AF9D18A93640617D24188D6C29461")
        public final void await() throws InterruptedException {
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_195518832 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } 
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            int interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1286247788 = (!isOnSyncQueue(node));
                {
                    LockSupport.park(this);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_481495260 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } 
                } 
            } 
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_1645933393 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } 
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            
            
                
            
            
            
            
                
                
                    
            
            
                
            
                
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.758 -0400", hash_original_method = "46C34832DD3406F7F3C664FF7A3A79B4", hash_generated_method = "FDB674901851DE14F5B1E0DBC896EBED")
        public final long awaitNanos(long nanosTimeout) throws InterruptedException {
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_1382428378 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } 
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            long lastTime = System.nanoTime();
            int interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1407267040 = (!isOnSyncQueue(node));
                {
                    {
                        transferAfterCancelledWait(node);
                    } 
                    LockSupport.parkNanos(this, nanosTimeout);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_1675764074 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } 
                    long now = System.nanoTime();
                    nanosTimeout -= now - lastTime;
                    lastTime = now;
                } 
            } 
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_1420374532 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } 
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            long var0AE99C9194A9E8813170658867C876DB_157758778 = (nanosTimeout - (System.nanoTime() - lastTime));
            addTaint(nanosTimeout);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_163996876 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_163996876;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.759 -0400", hash_original_method = "9B6F9AFE5FC55A4D3153D2EEB76307B9", hash_generated_method = "38D6B9073DCE584C7E17CF5400554F4F")
        public final boolean awaitUntil(Date deadline) throws InterruptedException {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            long abstime = deadline.getTime();
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_816167846 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } 
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            boolean timedout = false;
            int interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1790291005 = (!isOnSyncQueue(node));
                {
                    {
                        boolean varD36E947A894CF1227DF67FCDA3A195E9_2142871862 = (System.currentTimeMillis() > abstime);
                        {
                            timedout = transferAfterCancelledWait(node);
                        } 
                    } 
                    LockSupport.parkUntil(this, abstime);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_549847767 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } 
                } 
            } 
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_1111677 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } 
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            addTaint(deadline.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858074751 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_858074751;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.760 -0400", hash_original_method = "BFE4D71142E465ECC716594C0843F211", hash_generated_method = "ABCCEE4C0FE6E24EE2DD7BC7CDB96EE6")
        public final boolean await(long time, TimeUnit unit) throws InterruptedException {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            long nanosTimeout = unit.toNanos(time);
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_375455379 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } 
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            long lastTime = System.nanoTime();
            boolean timedout = false;
            int interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_2007266969 = (!isOnSyncQueue(node));
                {
                    {
                        timedout = transferAfterCancelledWait(node);
                    } 
                    LockSupport.parkNanos(this, nanosTimeout);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_1652261930 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } 
                    long now = System.nanoTime();
                    nanosTimeout -= now - lastTime;
                    lastTime = now;
                } 
            } 
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_925941317 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } 
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            addTaint(time);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_215973819 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_215973819;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.760 -0400", hash_original_method = "165B5BC520C58D38E1ED3303B481AD06", hash_generated_method = "4F939FF2431506875876987AA3BF4BFC")
        final boolean isOwnedBy(AbstractQueuedSynchronizer sync) {
            boolean var2A8E0121C9EBA5DBD487804D196CA981_1561635926 = (sync == AbstractQueuedSynchronizer.this);
            addTaint(sync.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625945269 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_625945269;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.761 -0400", hash_original_method = "5570422C2D22E250B14B7FB8C176D89A", hash_generated_method = "D3472508953BB38A885EEDC08D945392")
        protected final boolean hasWaiters() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1510730291 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } 
            {
                Node w = firstWaiter;
                w = w.nextWaiter;
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_318440210 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_318440210;
            
            
                
            
                
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.762 -0400", hash_original_method = "586699B2B19676C29FE19392CDC481BB", hash_generated_method = "EADEAA7716E30E92B8428503A55390F0")
        protected final int getWaitQueueLength() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1152775642 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } 
            int n = 0;
            {
                Node w = firstWaiter;
                w = w.nextWaiter;
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821147461 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821147461;
            
            
                
            
            
                
                    
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.763 -0400", hash_original_method = "D1136CB2B0FE173AD3F139F996FAE8B5", hash_generated_method = "ED0F1D1C89002519D305EDC0108EF990")
        protected final Collection<Thread> getWaitingThreads() {
            Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_542938738 = null; 
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_808643821 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } 
            ArrayList<Thread> list = new ArrayList<Thread>();
            {
                Node w = firstWaiter;
                w = w.nextWaiter;
                {
                    {
                        Thread t = w.thread;
                        list.add(t);
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_542938738 = list;
            varB4EAC82CA7396A68D541C85D26508E83_542938738.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_542938738;
            
            
                
            
            
                
                    
                    
                        
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "C457B05B8D8DCF2333B7BE06BB3694B7", hash_generated_field = "C9096AAE36B16976484AF1C63AF46815")

        private static final long serialVersionUID = 1173984872572414699L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "D61A8CF122BE9E2755E208E71F14B796", hash_generated_field = "719C1717721B97867F5478A2BF8734E2")

        private static final int REINTERRUPT = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "26CBB60DE11931C6D9D95F685537FC92", hash_generated_field = "4348EF9055A3499985FF0B3F446F2BC1")

        private static final int THROW_IE = -1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "53B46295871253A108CBEAB47C328D22", hash_generated_field = "D0E32D39585FA118FF323BF7B8487515")

    private static final long serialVersionUID = 7373984972572414691L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "97826F3E2403B559BA27663CADCEE60A", hash_generated_field = "BFF11A71C399B3DB146FF1C739630A1D")

    static final long spinForTimeoutThreshold = 1000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "2C1DA28B2CFB5A4DCF7A56B1409A3B45", hash_generated_field = "162353053FFA573C2A47BACEC7C77131")

    private static long stateOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "949FBEE482BB8F9AF6BC94101DBBFA8B", hash_generated_field = "97CE09A29DB2EB713A48E047121081EE")

    private static long headOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "9AB0A3F42E66C0E1646CAE7D9DF99009", hash_generated_field = "8B58E2B37A159AAD83A5260C2F388DB2")

    private static long tailOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "FA3E7ECB1F7079FDF9ADC8AA71B67A14", hash_generated_field = "58D083123B9F4D91D47538963124B084")

    private static long waitStatusOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.764 -0400", hash_original_field = "AF712C58580FB5A2A86652706D04C24E", hash_generated_field = "94ADDD311D046BDDD72EC240B54C288D")

    private static long nextOffset;
    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                (AbstractQueuedSynchronizer.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset
                (AbstractQueuedSynchronizer.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                (AbstractQueuedSynchronizer.class.getDeclaredField("tail"));
            waitStatusOffset = unsafe.objectFieldOffset
                (Node.class.getDeclaredField("waitStatus"));
            nextOffset = unsafe.objectFieldOffset
                (Node.class.getDeclaredField("next"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    
}

