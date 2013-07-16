package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import sun.misc.Unsafe;

public abstract class AbstractQueuedSynchronizer extends AbstractOwnableSynchronizer implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.802 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "C968564223BCE6AEFE8413EAB36A32B1")

    private transient volatile Node head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.802 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "AD93D08E1C37116EBC071C3224E8414A")

    private transient volatile Node tail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.803 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "40C4313E234E54E18DC2BFEA68F3E464")

    private volatile int state;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.803 -0400", hash_original_method = "C7F1FA27B1E7517E25F1C7951B5E8CA8", hash_generated_method = "D0F5CBC29675A9CABCA264BF6F7A7644")
    protected  AbstractQueuedSynchronizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.803 -0400", hash_original_method = "15A8F8E5739EB2961628EAE8F68BF29F", hash_generated_method = "7369B260A36897E79ABC343B03B9B7AD")
    protected final int getState() {
        int var9ED39E2EA931586B6A985A6942EF573E_1337950723 = (state);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361817206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361817206;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.804 -0400", hash_original_method = "57BE013BA515294E586014B30A336C04", hash_generated_method = "B9B29E2146A9DFA0E89C5BBC08072583")
    protected final void setState(int newState) {
        state = newState;
        // ---------- Original Method ----------
        //state = newState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.804 -0400", hash_original_method = "DF00243144DD556AB3E9A0ABE3AEC78F", hash_generated_method = "D08822AB601A60B0FEE7E206E9710D01")
    protected final boolean compareAndSetState(int expect, int update) {
        addTaint(update);
        addTaint(expect);
        boolean varE169225C89A949AD38419A0BE7572030_1157309355 = (unsafe.compareAndSwapInt(this, stateOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1883241495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1883241495;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.805 -0400", hash_original_method = "D115C79C5FCCB59668763118EBD8CBBB", hash_generated_method = "BA6A2117FE1961FF52A4FB74359C878F")
    private Node enq(final Node node) {
        addTaint(node.getTaint());
for(;;)
        {
            Node t = tail;
    if(t == null)            
            {
    if(compareAndSetHead(new Node()))                
                tail = head;
            } //End block
            else
            {
                node.prev = t;
    if(compareAndSetTail(t, node))                
                {
                    t.next = node;
Node varE0D714D758F1540A8DF364A965AF9150_1585764816 =                     t;
                    varE0D714D758F1540A8DF364A965AF9150_1585764816.addTaint(taint);
                    return varE0D714D758F1540A8DF364A965AF9150_1585764816;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //Node t = tail;
            //if (t == null) { 
                //if (compareAndSetHead(new Node()))
                    //tail = head;
            //} else {
                //node.prev = t;
                //if (compareAndSetTail(t, node)) {
                    //t.next = node;
                    //return t;
                //}
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.806 -0400", hash_original_method = "7269E5EC16B8883F661BF745CCC5E6A6", hash_generated_method = "DF5D35EDD80839B17D0ED55AA310494E")
    private Node addWaiter(Node mode) {
        addTaint(mode.getTaint());
        Node node = new Node(Thread.currentThread(), mode);
        Node pred = tail;
    if(pred != null)        
        {
            node.prev = pred;
    if(compareAndSetTail(pred, node))            
            {
                pred.next = node;
Node var1924C94B76524D1C3D7310EA17B0EF94_935975464 =                 node;
                var1924C94B76524D1C3D7310EA17B0EF94_935975464.addTaint(taint);
                return var1924C94B76524D1C3D7310EA17B0EF94_935975464;
            } //End block
        } //End block
        enq(node);
Node var1924C94B76524D1C3D7310EA17B0EF94_493017457 =         node;
        var1924C94B76524D1C3D7310EA17B0EF94_493017457.addTaint(taint);
        return var1924C94B76524D1C3D7310EA17B0EF94_493017457;
        // ---------- Original Method ----------
        //Node node = new Node(Thread.currentThread(), mode);
        //Node pred = tail;
        //if (pred != null) {
            //node.prev = pred;
            //if (compareAndSetTail(pred, node)) {
                //pred.next = node;
                //return node;
            //}
        //}
        //enq(node);
        //return node;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.806 -0400", hash_original_method = "51AEDFDDD323C78EE2EC4A6DE568B8D1", hash_generated_method = "E532E4CBBEBFF44C610D0F95E73E8319")
    private void setHead(Node node) {
        head = node;
        node.thread = null;
        node.prev = null;
        // ---------- Original Method ----------
        //head = node;
        //node.thread = null;
        //node.prev = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.807 -0400", hash_original_method = "F262A3A18BABECF7EC492736953EAF6E", hash_generated_method = "A93A115F239F2D3D3F010BE781B1A7F1")
    private void unparkSuccessor(Node node) {
        addTaint(node.getTaint());
        int ws = node.waitStatus;
    if(ws < 0)        
        compareAndSetWaitStatus(node, ws, 0);
        Node s = node.next;
    if(s == null || s.waitStatus > 0)        
        {
            s = null;
for(Node t = tail;t != null && t != node;t = t.prev)
    if(t.waitStatus <= 0)            
            s = t;
        } //End block
    if(s != null)        
        LockSupport.unpark(s.thread);
        // ---------- Original Method ----------
        //int ws = node.waitStatus;
        //if (ws < 0)
            //compareAndSetWaitStatus(node, ws, 0);
        //Node s = node.next;
        //if (s == null || s.waitStatus > 0) {
            //s = null;
            //for (Node t = tail; t != null && t != node; t = t.prev)
                //if (t.waitStatus <= 0)
                    //s = t;
        //}
        //if (s != null)
            //LockSupport.unpark(s.thread);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.808 -0400", hash_original_method = "D8D55646997B45206CD2F0528B603753", hash_generated_method = "70DCCB5937F13D53C20996F49C5243FC")
    private void doReleaseShared() {
for(;;)
        {
            Node h = head;
    if(h != null && h != tail)            
            {
                int ws = h.waitStatus;
    if(ws == Node.SIGNAL)                
                {
    if(!compareAndSetWaitStatus(h, Node.SIGNAL, 0))                    
                    continue;
                    unparkSuccessor(h);
                } //End block
                else
    if(ws == 0 &&
                         !compareAndSetWaitStatus(h, 0, Node.PROPAGATE))                
                continue;
            } //End block
    if(h == head)            
            break;
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //Node h = head;
            //if (h != null && h != tail) {
                //int ws = h.waitStatus;
                //if (ws == Node.SIGNAL) {
                    //if (!compareAndSetWaitStatus(h, Node.SIGNAL, 0))
                        //continue;            
                    //unparkSuccessor(h);
                //}
                //else if (ws == 0 &&
                         //!compareAndSetWaitStatus(h, 0, Node.PROPAGATE))
                    //continue;                
            //}
            //if (h == head)                   
                //break;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.808 -0400", hash_original_method = "A2FB30DAE399AEFA487E20396027BD36", hash_generated_method = "40E839A4C9B6A476B26404E2C51E7F79")
    private void setHeadAndPropagate(Node node, int propagate) {
        addTaint(propagate);
        addTaint(node.getTaint());
        Node h = head;
        setHead(node);
    if(propagate > 0 || h == null || h.waitStatus < 0)        
        {
            Node s = node.next;
    if(s == null || s.isShared())            
            doReleaseShared();
        } //End block
        // ---------- Original Method ----------
        //Node h = head;
        //setHead(node);
        //if (propagate > 0 || h == null || h.waitStatus < 0) {
            //Node s = node.next;
            //if (s == null || s.isShared())
                //doReleaseShared();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.815 -0400", hash_original_method = "1CA41B58715410C4216B9DE6C43BB9D4", hash_generated_method = "C5F79ACF849694CECD07366B161DDD11")
    private void cancelAcquire(Node node) {
        addTaint(node.getTaint());
    if(node == null)        
        return;
        node.thread = null;
        Node pred = node.prev;
        while
(pred.waitStatus > 0)        
        node.prev = pred = pred.prev;
        Node predNext = pred.next;
        node.waitStatus = Node.CANCELLED;
    if(node == tail && compareAndSetTail(node, pred))        
        {
            compareAndSetNext(pred, predNext, null);
        } //End block
        else
        {
            int ws;
    if(pred != head &&
                ((ws = pred.waitStatus) == Node.SIGNAL ||
                 (ws <= 0 && compareAndSetWaitStatus(pred, ws, Node.SIGNAL))) &&
                pred.thread != null)            
            {
                Node next = node.next;
    if(next != null && next.waitStatus <= 0)                
                compareAndSetNext(pred, predNext, next);
            } //End block
            else
            {
                unparkSuccessor(node);
            } //End block
            node.next = node;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.816 -0400", hash_original_method = "C551D5FD0C0A2C72DAD755E48C68905F", hash_generated_method = "244215B99EE8929EEB1B6B500428FA43")
    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        boolean var3B1A033197311EAFDE26E62437B6A8BF_897401458 = (Thread.interrupted());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_405042266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_405042266;
        // ---------- Original Method ----------
        //LockSupport.park(this);
        //return Thread.interrupted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.817 -0400", hash_original_method = "0D7553B7A8DFDAC7C355CECFA0DBF574", hash_generated_method = "D381B196373E4F92B589C2037222BB94")
    final boolean acquireQueued(final Node node, int arg) {
        addTaint(arg);
        addTaint(node.getTaint());
        boolean failed = true;
        try 
        {
            boolean interrupted = false;
for(;;)
            {
                final Node p = node.predecessor();
    if(p == head && tryAcquire(arg))                
                {
                    setHead(node);
                    p.next = null;
                    failed = false;
                    boolean varFADB76763385627E57EC386C9B6038F0_1828735099 = (interrupted);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064144311 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064144311;
                } //End block
    if(shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())                
                interrupted = true;
            } //End block
        } //End block
        finally 
        {
    if(failed)            
            cancelAcquire(node);
        } //End block
        // ---------- Original Method ----------
        //boolean failed = true;
        //try {
            //boolean interrupted = false;
            //for (;;) {
                //final Node p = node.predecessor();
                //if (p == head && tryAcquire(arg)) {
                    //setHead(node);
                    //p.next = null; 
                    //failed = false;
                    //return interrupted;
                //}
                //if (shouldParkAfterFailedAcquire(p, node) &&
                    //parkAndCheckInterrupt())
                    //interrupted = true;
            //}
        //} finally {
            //if (failed)
                //cancelAcquire(node);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.818 -0400", hash_original_method = "E74C4677EAF9B6C97A4A9A93D88FC71E", hash_generated_method = "7FECF21AFB77F939B61FEE09CFCDA5B3")
    private void doAcquireInterruptibly(int arg) throws InterruptedException {
        addTaint(arg);
        final Node node = addWaiter(Node.EXCLUSIVE);
        boolean failed = true;
        try 
        {
for(;;)
            {
                final Node p = node.predecessor();
    if(p == head && tryAcquire(arg))                
                {
                    setHead(node);
                    p.next = null;
                    failed = false;
                    return;
                } //End block
    if(shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())                
                {
                InterruptedException var1358A8E226367F12BB278428C2BEEE00_1329493626 = new InterruptedException();
                var1358A8E226367F12BB278428C2BEEE00_1329493626.addTaint(taint);
                throw var1358A8E226367F12BB278428C2BEEE00_1329493626;
                }
            } //End block
        } //End block
        finally 
        {
    if(failed)            
            cancelAcquire(node);
        } //End block
        // ---------- Original Method ----------
        //final Node node = addWaiter(Node.EXCLUSIVE);
        //boolean failed = true;
        //try {
            //for (;;) {
                //final Node p = node.predecessor();
                //if (p == head && tryAcquire(arg)) {
                    //setHead(node);
                    //p.next = null; 
                    //failed = false;
                    //return;
                //}
                //if (shouldParkAfterFailedAcquire(p, node) &&
                    //parkAndCheckInterrupt())
                    //throw new InterruptedException();
            //}
        //} finally {
            //if (failed)
                //cancelAcquire(node);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.819 -0400", hash_original_method = "AF980EBAC4BC6C4AB1174BED3B10073B", hash_generated_method = "7B71C0BA9771A46E26B7E803CAADCD1E")
    private boolean doAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
        addTaint(nanosTimeout);
        addTaint(arg);
        long lastTime = System.nanoTime();
        final Node node = addWaiter(Node.EXCLUSIVE);
        boolean failed = true;
        try 
        {
for(;;)
            {
                final Node p = node.predecessor();
    if(p == head && tryAcquire(arg))                
                {
                    setHead(node);
                    p.next = null;
                    failed = false;
                    boolean varB326B5062B2F0E69046810717534CB09_86701898 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355491688 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355491688;
                } //End block
    if(nanosTimeout <= 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_351079048 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_771282521 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_771282521;
                }
    if(shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold)                
                LockSupport.parkNanos(this, nanosTimeout);
                long now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
    if(Thread.interrupted())                
                {
                InterruptedException var1358A8E226367F12BB278428C2BEEE00_141695293 = new InterruptedException();
                var1358A8E226367F12BB278428C2BEEE00_141695293.addTaint(taint);
                throw var1358A8E226367F12BB278428C2BEEE00_141695293;
                }
            } //End block
        } //End block
        finally 
        {
    if(failed)            
            cancelAcquire(node);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.820 -0400", hash_original_method = "D66678B4038334D8E14600B3A8FC8FD7", hash_generated_method = "706DE7BF41217D97C1B1C0111FA50E7F")
    private void doAcquireShared(int arg) {
        addTaint(arg);
        final Node node = addWaiter(Node.SHARED);
        boolean failed = true;
        try 
        {
            boolean interrupted = false;
for(;;)
            {
                final Node p = node.predecessor();
    if(p == head)                
                {
                    int r = tryAcquireShared(arg);
    if(r >= 0)                    
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
    if(interrupted)                        
                        selfInterrupt();
                        failed = false;
                        return;
                    } //End block
                } //End block
    if(shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())                
                interrupted = true;
            } //End block
        } //End block
        finally 
        {
    if(failed)            
            cancelAcquire(node);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.821 -0400", hash_original_method = "4E093FA1B6FCF5593272CE0DEA00D69B", hash_generated_method = "01E0C09DE38458EE6780774EB82E7E04")
    private void doAcquireSharedInterruptibly(int arg) throws InterruptedException {
        addTaint(arg);
        final Node node = addWaiter(Node.SHARED);
        boolean failed = true;
        try 
        {
for(;;)
            {
                final Node p = node.predecessor();
    if(p == head)                
                {
                    int r = tryAcquireShared(arg);
    if(r >= 0)                    
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                        return;
                    } //End block
                } //End block
    if(shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())                
                {
                InterruptedException var1358A8E226367F12BB278428C2BEEE00_1763294413 = new InterruptedException();
                var1358A8E226367F12BB278428C2BEEE00_1763294413.addTaint(taint);
                throw var1358A8E226367F12BB278428C2BEEE00_1763294413;
                }
            } //End block
        } //End block
        finally 
        {
    if(failed)            
            cancelAcquire(node);
        } //End block
        // ---------- Original Method ----------
        //final Node node = addWaiter(Node.SHARED);
        //boolean failed = true;
        //try {
            //for (;;) {
                //final Node p = node.predecessor();
                //if (p == head) {
                    //int r = tryAcquireShared(arg);
                    //if (r >= 0) {
                        //setHeadAndPropagate(node, r);
                        //p.next = null; 
                        //failed = false;
                        //return;
                    //}
                //}
                //if (shouldParkAfterFailedAcquire(p, node) &&
                    //parkAndCheckInterrupt())
                    //throw new InterruptedException();
            //}
        //} finally {
            //if (failed)
                //cancelAcquire(node);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.823 -0400", hash_original_method = "873D99639E9E59C87CD3A574B36E4573", hash_generated_method = "68FC54D3018689B52D284C311E49E324")
    private boolean doAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
        addTaint(nanosTimeout);
        addTaint(arg);
        long lastTime = System.nanoTime();
        final Node node = addWaiter(Node.SHARED);
        boolean failed = true;
        try 
        {
for(;;)
            {
                final Node p = node.predecessor();
    if(p == head)                
                {
                    int r = tryAcquireShared(arg);
    if(r >= 0)                    
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                        boolean varB326B5062B2F0E69046810717534CB09_1875788367 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138148464 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138148464;
                    } //End block
                } //End block
    if(nanosTimeout <= 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1811954903 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1187277355 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1187277355;
                }
    if(shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold)                
                LockSupport.parkNanos(this, nanosTimeout);
                long now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
    if(Thread.interrupted())                
                {
                InterruptedException var1358A8E226367F12BB278428C2BEEE00_423269730 = new InterruptedException();
                var1358A8E226367F12BB278428C2BEEE00_423269730.addTaint(taint);
                throw var1358A8E226367F12BB278428C2BEEE00_423269730;
                }
            } //End block
        } //End block
        finally 
        {
    if(failed)            
            cancelAcquire(node);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.823 -0400", hash_original_method = "FADA99D99649E8B049B596B89A86AFE3", hash_generated_method = "9FF64669226D86D9146C77CC68042C06")
    protected boolean tryAcquire(int arg) {
        addTaint(arg);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1884960285 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1884960285.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1884960285;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.824 -0400", hash_original_method = "0AA9B3926B88397CF769442818D9CA16", hash_generated_method = "01BDDE76E9B5F58D18CF4D4D82966AF8")
    protected boolean tryRelease(int arg) {
        addTaint(arg);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2080555205 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2080555205.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2080555205;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.824 -0400", hash_original_method = "143AB2DE4C7A8CA8F45FD3C862AFB93B", hash_generated_method = "81ED5743C4946D4168015CAAF4E76BD6")
    protected int tryAcquireShared(int arg) {
        addTaint(arg);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1063014982 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1063014982.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1063014982;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.824 -0400", hash_original_method = "57760B0E19163CFD26451EB4C702B2B7", hash_generated_method = "ED6CCB57E2F3318037DF6CF80AE3DE43")
    protected boolean tryReleaseShared(int arg) {
        addTaint(arg);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_45210775 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_45210775.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_45210775;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.825 -0400", hash_original_method = "B1A3EF7BA2A74EEB6B3236F0A99ED9FE", hash_generated_method = "B3FD0C3D0CB92153BFAE4DCE8C4C9C3F")
    protected boolean isHeldExclusively() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1670870256 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1670870256.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1670870256;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.825 -0400", hash_original_method = "10DE26F4AB94E5F1867D5F821F4BF0D7", hash_generated_method = "9D434AAC078ACD909DA7ADFE9A674506")
    public final void acquire(int arg) {
        addTaint(arg);
    if(!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg))        
        selfInterrupt();
        // ---------- Original Method ----------
        //if (!tryAcquire(arg) &&
            //acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            //selfInterrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.825 -0400", hash_original_method = "34DE0EEECFCC486100F3F952023E1D48", hash_generated_method = "0B633B103D0A36E90149124CF35D5715")
    public final void acquireInterruptibly(int arg) throws InterruptedException {
        addTaint(arg);
    if(Thread.interrupted())        
        {
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_475458062 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_475458062.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_475458062;
        }
    if(!tryAcquire(arg))        
        doAcquireInterruptibly(arg);
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (!tryAcquire(arg))
            //doAcquireInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.826 -0400", hash_original_method = "C2BC4409CE226EEA6D2598B40FA64E1C", hash_generated_method = "C956978FD3A227DC088F4C07F3C5BF34")
    public final boolean tryAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
        addTaint(nanosTimeout);
        addTaint(arg);
    if(Thread.interrupted())        
        {
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_1137012558 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_1137012558.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_1137012558;
        }
        boolean varA01D96404099C31650ABFFBB7F35E590_1605703565 = (tryAcquire(arg) ||
            doAcquireNanos(arg, nanosTimeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736792669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_736792669;
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquire(arg) ||
            //doAcquireNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.826 -0400", hash_original_method = "482847B9E820B21E98E389768A5050E4", hash_generated_method = "EF666AE4877B35A6CAFE481759803318")
    public final boolean release(int arg) {
        addTaint(arg);
    if(tryRelease(arg))        
        {
            Node h = head;
    if(h != null && h.waitStatus != 0)            
            unparkSuccessor(h);
            boolean varB326B5062B2F0E69046810717534CB09_999243433 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386243426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_386243426;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_434424298 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1608197132 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1608197132;
        // ---------- Original Method ----------
        //if (tryRelease(arg)) {
            //Node h = head;
            //if (h != null && h.waitStatus != 0)
                //unparkSuccessor(h);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.827 -0400", hash_original_method = "503864E706CF656D09684EB1E461773D", hash_generated_method = "EE10D68B90A4E67490FA41A3F047DC45")
    public final void acquireShared(int arg) {
        addTaint(arg);
    if(tryAcquireShared(arg) < 0)        
        doAcquireShared(arg);
        // ---------- Original Method ----------
        //if (tryAcquireShared(arg) < 0)
            //doAcquireShared(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.827 -0400", hash_original_method = "10425BDCE3B0F2DAA2E0ECCAD9B4BACD", hash_generated_method = "20AB19B0F797A846BF2FB66008E354E7")
    public final void acquireSharedInterruptibly(int arg) throws InterruptedException {
        addTaint(arg);
    if(Thread.interrupted())        
        {
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_906293613 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_906293613.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_906293613;
        }
    if(tryAcquireShared(arg) < 0)        
        doAcquireSharedInterruptibly(arg);
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (tryAcquireShared(arg) < 0)
            //doAcquireSharedInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.828 -0400", hash_original_method = "34AA5C57E6BB40898FDB5D4BB2EF37C3", hash_generated_method = "2D1B07694A9A9BCCFD48C3CCDB42FFBC")
    public final boolean tryAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
        addTaint(nanosTimeout);
        addTaint(arg);
    if(Thread.interrupted())        
        {
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_21986725 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_21986725.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_21986725;
        }
        boolean varAC8EC28312AC77D7940A1374507E454D_1717959598 = (tryAcquireShared(arg) >= 0 ||
            doAcquireSharedNanos(arg, nanosTimeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830460913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_830460913;
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquireShared(arg) >= 0 ||
            //doAcquireSharedNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.828 -0400", hash_original_method = "64AF2599D3C05FF36535D67856367D8D", hash_generated_method = "FDD1D49FA86E47A5552105D4E26AE118")
    public final boolean releaseShared(int arg) {
        addTaint(arg);
    if(tryReleaseShared(arg))        
        {
            doReleaseShared();
            boolean varB326B5062B2F0E69046810717534CB09_551602420 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1183280639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1183280639;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_249428744 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_600282826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_600282826;
        // ---------- Original Method ----------
        //if (tryReleaseShared(arg)) {
            //doReleaseShared();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.829 -0400", hash_original_method = "3ACA5092770D7AD1442898AF3B627DFE", hash_generated_method = "5CE54557E3D5EA1EF58BC4AF4B25B793")
    public final boolean hasQueuedThreads() {
        boolean varA082AC3EB8E95F4F31577910CF1352A9_1765402283 = (head != tail);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2107223758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2107223758;
        // ---------- Original Method ----------
        //return head != tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.829 -0400", hash_original_method = "3ED9D0D071477B613E998B33D61DD4C5", hash_generated_method = "DE59E771FD17B5DB67ECD7340A238669")
    public final boolean hasContended() {
        boolean varF99FF234A7427ED48BEA6CF28AE0958C_1198065263 = (head != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677486328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_677486328;
        // ---------- Original Method ----------
        //return head != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.829 -0400", hash_original_method = "DB23AE447B60E978D848F5CEAEC8257B", hash_generated_method = "A0EA3D6F0FA76AC6AD6E335559BBFEB8")
    public final Thread getFirstQueuedThread() {
Thread var870C75E9F1DE61C9DB12235564677748_1030701080 =         (head == tail) ? null : fullGetFirstQueuedThread();
        var870C75E9F1DE61C9DB12235564677748_1030701080.addTaint(taint);
        return var870C75E9F1DE61C9DB12235564677748_1030701080;
        // ---------- Original Method ----------
        //return (head == tail) ? null : fullGetFirstQueuedThread();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.830 -0400", hash_original_method = "18818CB637EBC5CF82DC4C50B37FB17C", hash_generated_method = "FC4878F382CE34BEDF715327065866F3")
    private Thread fullGetFirstQueuedThread() {
        Node h;
        Node s;
        Thread st;
    if(((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null) ||
            ((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null))        
        {
Thread varAA0158446C9008DEF446ADFDF1B056A8_1728058768 =         st;
        varAA0158446C9008DEF446ADFDF1B056A8_1728058768.addTaint(taint);
        return varAA0158446C9008DEF446ADFDF1B056A8_1728058768;
        }
        Node t = tail;
        Thread firstThread = null;
        while
(t != null && t != head)        
        {
            Thread tt = t.thread;
    if(tt != null)            
            firstThread = tt;
            t = t.prev;
        } //End block
Thread varDBE1B135F3AB7C062EA0CD8FCD339ACB_1763601558 =         firstThread;
        varDBE1B135F3AB7C062EA0CD8FCD339ACB_1763601558.addTaint(taint);
        return varDBE1B135F3AB7C062EA0CD8FCD339ACB_1763601558;
        // ---------- Original Method ----------
        //Node h, s;
        //Thread st;
        //if (((h = head) != null && (s = h.next) != null &&
             //s.prev == head && (st = s.thread) != null) ||
            //((h = head) != null && (s = h.next) != null &&
             //s.prev == head && (st = s.thread) != null))
            //return st;
        //Node t = tail;
        //Thread firstThread = null;
        //while (t != null && t != head) {
            //Thread tt = t.thread;
            //if (tt != null)
                //firstThread = tt;
            //t = t.prev;
        //}
        //return firstThread;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.831 -0400", hash_original_method = "1573E83A14D593E0BFADABB9AEDBB7D2", hash_generated_method = "ECBFEC661721170518CB3E89A2FB353C")
    public final boolean isQueued(Thread thread) {
        addTaint(thread.getTaint());
    if(thread == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1757068749 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1757068749.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1757068749;
        }
for(Node p = tail;p != null;p = p.prev)
    if(p.thread == thread)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_7105110 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622372990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622372990;
        }
        boolean var68934A3E9455FA72420237EB05902327_1324145138 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947642828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947642828;
        // ---------- Original Method ----------
        //if (thread == null)
            //throw new NullPointerException();
        //for (Node p = tail; p != null; p = p.prev)
            //if (p.thread == thread)
                //return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.831 -0400", hash_original_method = "4993AFB2E466C494E10B5DA4780E51AB", hash_generated_method = "96F59AA4A4614E948F1BE2417CB5A4B9")
    final boolean apparentlyFirstQueuedIsExclusive() {
        Node h;
        Node s;
        boolean var384A24DAA64C392C8BD17ED8B979769C_28129023 = ((h = head) != null &&
            (s = h.next)  != null &&
            !s.isShared()         &&
            s.thread != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676204064 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676204064;
        // ---------- Original Method ----------
        //Node h, s;
        //return (h = head) != null &&
            //(s = h.next)  != null &&
            //!s.isShared()         &&
            //s.thread != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.832 -0400", hash_original_method = "155F6B01F514C41CA8367710346D37E3", hash_generated_method = "433A1857AD23CBF5AC3DB0C5F6455A41")
    public final boolean hasQueuedPredecessors() {
        Node t = tail;
        Node h = head;
        Node s;
        boolean var549425DF4D520D7AED284FC4F26FB594_818495388 = (h != t &&
            ((s = h.next) == null || s.thread != Thread.currentThread()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_545110885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_545110885;
        // ---------- Original Method ----------
        //Node t = tail;
        //Node h = head;
        //Node s;
        //return h != t &&
            //((s = h.next) == null || s.thread != Thread.currentThread());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.832 -0400", hash_original_method = "65AB677A04652631BF1CC269A789F93A", hash_generated_method = "19D2F143F85C8263788499D5232D158D")
    public final int getQueueLength() {
        int n = 0;
for(Node p = tail;p != null;p = p.prev)
        {
    if(p.thread != null)            
            ++n;
        } //End block
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_1110884869 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941392182 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941392182;
        // ---------- Original Method ----------
        //int n = 0;
        //for (Node p = tail; p != null; p = p.prev) {
            //if (p.thread != null)
                //++n;
        //}
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.833 -0400", hash_original_method = "BA97C075FB0E9B39CEF398B585209CAD", hash_generated_method = "529CBDC92E145B879D8906F70B2D82A5")
    public final Collection<Thread> getQueuedThreads() {
        ArrayList<Thread> list = new ArrayList<Thread>();
for(Node p = tail;p != null;p = p.prev)
        {
            Thread t = p.thread;
    if(t != null)            
            list.add(t);
        } //End block
Collection<Thread> varED12C351C2E8CA4F85F097DDC7E77B4D_353681611 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_353681611.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_353681611;
        // ---------- Original Method ----------
        //ArrayList<Thread> list = new ArrayList<Thread>();
        //for (Node p = tail; p != null; p = p.prev) {
            //Thread t = p.thread;
            //if (t != null)
                //list.add(t);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.834 -0400", hash_original_method = "8F9C05C78C38CDEC6B94C7386A00C30C", hash_generated_method = "7E492FE6523197C9F336D0C2EA5AFF4C")
    public final Collection<Thread> getExclusiveQueuedThreads() {
        ArrayList<Thread> list = new ArrayList<Thread>();
for(Node p = tail;p != null;p = p.prev)
        {
    if(!p.isShared())            
            {
                Thread t = p.thread;
    if(t != null)                
                list.add(t);
            } //End block
        } //End block
Collection<Thread> varED12C351C2E8CA4F85F097DDC7E77B4D_1654874804 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1654874804.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1654874804;
        // ---------- Original Method ----------
        //ArrayList<Thread> list = new ArrayList<Thread>();
        //for (Node p = tail; p != null; p = p.prev) {
            //if (!p.isShared()) {
                //Thread t = p.thread;
                //if (t != null)
                    //list.add(t);
            //}
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.834 -0400", hash_original_method = "3B2BC348731488178C75B0F7C3256BE4", hash_generated_method = "A589D74E3BC6BA0F18510ECBA54CF2F6")
    public final Collection<Thread> getSharedQueuedThreads() {
        ArrayList<Thread> list = new ArrayList<Thread>();
for(Node p = tail;p != null;p = p.prev)
        {
    if(p.isShared())            
            {
                Thread t = p.thread;
    if(t != null)                
                list.add(t);
            } //End block
        } //End block
Collection<Thread> varED12C351C2E8CA4F85F097DDC7E77B4D_11689867 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_11689867.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_11689867;
        // ---------- Original Method ----------
        //ArrayList<Thread> list = new ArrayList<Thread>();
        //for (Node p = tail; p != null; p = p.prev) {
            //if (p.isShared()) {
                //Thread t = p.thread;
                //if (t != null)
                    //list.add(t);
            //}
        //}
        //return list;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.835 -0400", hash_original_method = "2C49C090DBE6788B4A91D995132AEECA", hash_generated_method = "388DA8BF10A5A3517ED076AED01E355A")
    public String toString() {
        int s = getState();
        String q = hasQueuedThreads() ? "non" : "";
String var4EB727B8FD98B5F7ED6D14E18A4FCCA4_448468103 =         super.toString() +
            "[State = " + s + ", " + q + "empty queue]";
        var4EB727B8FD98B5F7ED6D14E18A4FCCA4_448468103.addTaint(taint);
        return var4EB727B8FD98B5F7ED6D14E18A4FCCA4_448468103;
        // ---------- Original Method ----------
        //int s = getState();
        //String q  = hasQueuedThreads() ? "non" : "";
        //return super.toString() +
            //"[State = " + s + ", " + q + "empty queue]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.835 -0400", hash_original_method = "0981A7B7481B56654552F826D97FC7A4", hash_generated_method = "D72837C26222FAD7C19EF5C482BCD7E8")
    final boolean isOnSyncQueue(Node node) {
        addTaint(node.getTaint());
    if(node.waitStatus == Node.CONDITION || node.prev == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_368468485 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221186902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221186902;
        }
    if(node.next != null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1001590917 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997756550 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997756550;
        }
        boolean var1334757DEAE6F9A44E12EB6C1BF18A1A_7745939 = (findNodeFromTail(node));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1860154299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1860154299;
        // ---------- Original Method ----------
        //if (node.waitStatus == Node.CONDITION || node.prev == null)
            //return false;
        //if (node.next != null) 
            //return true;
        //return findNodeFromTail(node);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.836 -0400", hash_original_method = "E84A510853D9F9659F34649D5E631E14", hash_generated_method = "BFF81108CB8C6D408924E6ABC96AE8F9")
    private boolean findNodeFromTail(Node node) {
        addTaint(node.getTaint());
        Node t = tail;
for(;;)
        {
    if(t == node)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1690396861 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735938904 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735938904;
            }
    if(t == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1283340510 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69010399 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_69010399;
            }
            t = t.prev;
        } //End block
        // ---------- Original Method ----------
        //Node t = tail;
        //for (;;) {
            //if (t == node)
                //return true;
            //if (t == null)
                //return false;
            //t = t.prev;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.837 -0400", hash_original_method = "AC7EB2A7C3E5842E27808853E2EADEA4", hash_generated_method = "22E0477C50E46EB6AF8B6028C955C018")
    final boolean transferForSignal(Node node) {
        addTaint(node.getTaint());
    if(!compareAndSetWaitStatus(node, Node.CONDITION, 0))        
        {
        boolean var68934A3E9455FA72420237EB05902327_921886679 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1381958182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1381958182;
        }
        Node p = enq(node);
        int ws = p.waitStatus;
    if(ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL))        
        LockSupport.unpark(node.thread);
        boolean varB326B5062B2F0E69046810717534CB09_1245667674 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368212321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_368212321;
        // ---------- Original Method ----------
        //if (!compareAndSetWaitStatus(node, Node.CONDITION, 0))
            //return false;
        //Node p = enq(node);
        //int ws = p.waitStatus;
        //if (ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL))
            //LockSupport.unpark(node.thread);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.837 -0400", hash_original_method = "202AE2159172221E521994FECA693914", hash_generated_method = "D89B4825C68F421130E0EC3523F57105")
    final boolean transferAfterCancelledWait(Node node) {
        addTaint(node.getTaint());
    if(compareAndSetWaitStatus(node, Node.CONDITION, 0))        
        {
            enq(node);
            boolean varB326B5062B2F0E69046810717534CB09_1650032120 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658478227 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658478227;
        } //End block
        while
(!isOnSyncQueue(node))        
        Thread.yield();
        boolean var68934A3E9455FA72420237EB05902327_1973866457 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989888266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_989888266;
        // ---------- Original Method ----------
        //if (compareAndSetWaitStatus(node, Node.CONDITION, 0)) {
            //enq(node);
            //return true;
        //}
        //while (!isOnSyncQueue(node))
            //Thread.yield();
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.838 -0400", hash_original_method = "13260C05A29655F6FC8F2FA182B20EC8", hash_generated_method = "4E956ECF881CA47AE60D602623F52478")
    final int fullyRelease(Node node) {
        addTaint(node.getTaint());
        boolean failed = true;
        try 
        {
            int savedState = getState();
    if(release(savedState))            
            {
                failed = false;
                int var4C0428E38EB47B04E0869E39E7C0D6A1_549135689 = (savedState);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738565408 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738565408;
            } //End block
            else
            {
                IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1654160097 = new IllegalMonitorStateException();
                var9D4F198B973DC32951341758A9D245B5_1654160097.addTaint(taint);
                throw var9D4F198B973DC32951341758A9D245B5_1654160097;
            } //End block
        } //End block
        finally 
        {
    if(failed)            
            node.waitStatus = Node.CANCELLED;
        } //End block
        // ---------- Original Method ----------
        //boolean failed = true;
        //try {
            //int savedState = getState();
            //if (release(savedState)) {
                //failed = false;
                //return savedState;
            //} else {
                //throw new IllegalMonitorStateException();
            //}
        //} finally {
            //if (failed)
                //node.waitStatus = Node.CANCELLED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.838 -0400", hash_original_method = "B60D02054E03A30F41C10CC4F7B33B2F", hash_generated_method = "522AB4074B299742E51DB7AC4C5FAE74")
    public final boolean owns(ConditionObject condition) {
        addTaint(condition.getTaint());
    if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1667435248 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1667435248.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1667435248;
        }
        boolean varD1428399BF953DC879A6F44FC54099DD_17440828 = (condition.isOwnedBy(this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2063261470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2063261470;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //return condition.isOwnedBy(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.839 -0400", hash_original_method = "B87CA02CD99C2C81A6ADCC153DE8BF7D", hash_generated_method = "4DC15EFAB71245B8653986DEFB0B3ABB")
    public final boolean hasWaiters(ConditionObject condition) {
        addTaint(condition.getTaint());
    if(!owns(condition))        
        {
        IllegalArgumentException var10F139FF311F906191A15D005A0AF6DB_814384301 = new IllegalArgumentException("Not owner");
        var10F139FF311F906191A15D005A0AF6DB_814384301.addTaint(taint);
        throw var10F139FF311F906191A15D005A0AF6DB_814384301;
        }
        boolean varD110D0E8476BE1ED9552C2B17F2EABE3_1552665484 = (condition.hasWaiters());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550922045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550922045;
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.hasWaiters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.839 -0400", hash_original_method = "FDFBF2604A26737643DD133E9F8A257F", hash_generated_method = "6497484143D2F90A9BC451E849CEFE47")
    public final int getWaitQueueLength(ConditionObject condition) {
        addTaint(condition.getTaint());
    if(!owns(condition))        
        {
        IllegalArgumentException var10F139FF311F906191A15D005A0AF6DB_1110963353 = new IllegalArgumentException("Not owner");
        var10F139FF311F906191A15D005A0AF6DB_1110963353.addTaint(taint);
        throw var10F139FF311F906191A15D005A0AF6DB_1110963353;
        }
        int var74EB0FD17BFFF2510CAC56C3F4C7D72C_1315230498 = (condition.getWaitQueueLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878218762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878218762;
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.840 -0400", hash_original_method = "70972013E049E7504ADBD56143485C77", hash_generated_method = "73EF122E1FB3C5B6B224EE7B1643948E")
    public final Collection<Thread> getWaitingThreads(ConditionObject condition) {
        addTaint(condition.getTaint());
    if(!owns(condition))        
        {
        IllegalArgumentException var10F139FF311F906191A15D005A0AF6DB_371989991 = new IllegalArgumentException("Not owner");
        var10F139FF311F906191A15D005A0AF6DB_371989991.addTaint(taint);
        throw var10F139FF311F906191A15D005A0AF6DB_371989991;
        }
Collection<Thread> var8981A24903B26F18C4110654EEEEEF5C_2116542914 =         condition.getWaitingThreads();
        var8981A24903B26F18C4110654EEEEEF5C_2116542914.addTaint(taint);
        return var8981A24903B26F18C4110654EEEEEF5C_2116542914;
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitingThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.840 -0400", hash_original_method = "20D2259271C7B1C96C133ACBD2C26B14", hash_generated_method = "8F9D23C5090F7E542BA9D745CABA04EF")
    private final boolean compareAndSetHead(Node update) {
        addTaint(update.getTaint());
        boolean var0A2860D9316D8AD7309534503883A416_1785414865 = (unsafe.compareAndSwapObject(this, headOffset, null, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_673912307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_673912307;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.841 -0400", hash_original_method = "8C47C531A43F622294BF6051B04C8993", hash_generated_method = "481065AF491247E7A527985C038312DB")
    private final boolean compareAndSetTail(Node expect, Node update) {
        addTaint(update.getTaint());
        addTaint(expect.getTaint());
        boolean var1B8F67C774023CA8EF7CAAF2DAEE008A_1771089443 = (unsafe.compareAndSwapObject(this, tailOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2114746610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2114746610;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.842 -0400", hash_original_field = "282F56A6C3233E93D5BACF05B9AA8876", hash_generated_field = "4D5292AE19E73CB6BC72A4A4EE34646D")

        volatile int waitStatus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.842 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "CE4F99BFA9BE83062548109E0A80EB36")

        volatile Node prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.842 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "495F81DE1A0BB70B1CC0F10199933490")

        volatile Node next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.842 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3347E7A3168C0A597DE966A2AEA728E2")

        volatile Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.842 -0400", hash_original_field = "1F76D737B407F4A2AD51A0EFEB508D50", hash_generated_field = "EE921616C37FFDDFA9B9DA84ABF34675")

        Node nextWaiter;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.842 -0400", hash_original_method = "2DD8BF5485F2495811D83404AF44A29C", hash_generated_method = "AAE5751DE21B256CB4EDD0DDB605F24E")
          Node() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.843 -0400", hash_original_method = "764EF23A3C66C99D5E5160039F46E6BD", hash_generated_method = "2CAC145FA8BF94E846C302C88AD33F87")
          Node(Thread thread, Node mode) {
            this.nextWaiter = mode;
            this.thread = thread;
            // ---------- Original Method ----------
            //this.nextWaiter = mode;
            //this.thread = thread;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.843 -0400", hash_original_method = "5118904E6021AE155CDFF15DB609BD48", hash_generated_method = "4FCE7CEF63C545859A3D7EF41D2DEAC9")
          Node(Thread thread, int waitStatus) {
            this.waitStatus = waitStatus;
            this.thread = thread;
            // ---------- Original Method ----------
            //this.waitStatus = waitStatus;
            //this.thread = thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.844 -0400", hash_original_method = "EA506AD78E2AE8ACF234FE0610B9A575", hash_generated_method = "AFD89CEE433E30082A8E40A40E502DC5")
        final boolean isShared() {
            boolean varDC3CBE439A4F6F1CF2883A72D8EC2038_2101323717 = (nextWaiter == SHARED);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_360593376 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_360593376;
            // ---------- Original Method ----------
            //return nextWaiter == SHARED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.844 -0400", hash_original_method = "7AA5CFB77F71DE2C6FFA937BCE62ADAE", hash_generated_method = "2D8D32AF539B0E51D88986BEE83D00DD")
        final Node predecessor() throws NullPointerException {
            Node p = prev;
    if(p == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_994922132 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_994922132.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_994922132;
            }
            else
            {
Node var74E4690D9F2A026504928C017944E149_1619547431 =             p;
            var74E4690D9F2A026504928C017944E149_1619547431.addTaint(taint);
            return var74E4690D9F2A026504928C017944E149_1619547431;
            }
            // ---------- Original Method ----------
            //Node p = prev;
            //if (p == null)
                //throw new NullPointerException();
            //else
                //return p;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.844 -0400", hash_original_field = "29B93CAC7244964D7B989712BB2AAA8F", hash_generated_field = "A09441E8911A57E0DA262F7FAB0EA28A")

        static final Node SHARED = new Node();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.844 -0400", hash_original_field = "F427D28BCA700281DA9D02E201499452", hash_generated_field = "2FB080405C41D521F6A68DD8C95FE029")

        static final Node EXCLUSIVE = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.844 -0400", hash_original_field = "988DB81EC2397AB0D5457DF07B87908A", hash_generated_field = "E67B54E6E13DC27CF3608595B88B40CB")

        static final int CANCELLED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.845 -0400", hash_original_field = "1B171CE64A08A97E810AC0B2A481548E", hash_generated_field = "8577B9810AB6FC6DF6B54ADA380AC389")

        static final int SIGNAL = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.845 -0400", hash_original_field = "EC24A5598A6130CF31D6F9BEF244C4A1", hash_generated_field = "1D67D49288B45666BD2DADDDBBA57C2F")

        static final int CONDITION = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.845 -0400", hash_original_field = "2F582260408474C896C524B277DB2733", hash_generated_field = "16BF27DDB917629F3C35C8BC0AB5CC5C")

        static final int PROPAGATE = -3;
    }


    
    public class ConditionObject implements Condition, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.845 -0400", hash_original_field = "CD495CA7D725FEED43A3FB720F4B8EC1", hash_generated_field = "65A161514F134134E9F0B478EBDE5ED3")

        private transient Node firstWaiter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.845 -0400", hash_original_field = "8BDF0C40F706950EC229FBE0007BC4E3", hash_generated_field = "2A9616AEC7221DB00588D39E0457BC79")

        private transient Node lastWaiter;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.845 -0400", hash_original_method = "0A3E2C1E27BAEA738FDF96AD17500BEE", hash_generated_method = "6AF9B0E3D406E6C56AA07F09E795B0E2")
        public  ConditionObject() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.867 -0400", hash_original_method = "43F5E066353E431B2C9AD7CD0397BCCF", hash_generated_method = "13D8345615024EA5EEED7C1F7E6725BF")
        private Node addConditionWaiter() {
            Node t = lastWaiter;
    if(t != null && t.waitStatus != Node.CONDITION)            
            {
                unlinkCancelledWaiters();
                t = lastWaiter;
            } //End block
            Node node = new Node(Thread.currentThread(), Node.CONDITION);
    if(t == null)            
            firstWaiter = node;
            else
            t.nextWaiter = node;
            lastWaiter = node;
Node var1924C94B76524D1C3D7310EA17B0EF94_733827469 =             node;
            var1924C94B76524D1C3D7310EA17B0EF94_733827469.addTaint(taint);
            return var1924C94B76524D1C3D7310EA17B0EF94_733827469;
            // ---------- Original Method ----------
            //Node t = lastWaiter;
            //if (t != null && t.waitStatus != Node.CONDITION) {
                //unlinkCancelledWaiters();
                //t = lastWaiter;
            //}
            //Node node = new Node(Thread.currentThread(), Node.CONDITION);
            //if (t == null)
                //firstWaiter = node;
            //else
                //t.nextWaiter = node;
            //lastWaiter = node;
            //return node;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.868 -0400", hash_original_method = "74B8316ED8B5F40365D8BD9CF002AB2D", hash_generated_method = "5A26EDA37C913BD6A78C85A0B826BA92")
        private void doSignal(Node first) {
            addTaint(first.getTaint());
            do {
                {
    if((firstWaiter = first.nextWaiter) == null)                    
                    lastWaiter = null;
                    first.nextWaiter = null;
                } //End block
} while (!transferForSignal(first) &&
                     (first = firstWaiter) != null);
            // ---------- Original Method ----------
            //do {
                //if ( (firstWaiter = first.nextWaiter) == null)
                    //lastWaiter = null;
                //first.nextWaiter = null;
            //} while (!transferForSignal(first) &&
                     //(first = firstWaiter) != null);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.869 -0400", hash_original_method = "DE4F68C515AD9FDEF86DCFCC83AF390E", hash_generated_method = "538AA885639A6DAD8B8C761ACEA5BCCC")
        private void doSignalAll(Node first) {
            addTaint(first.getTaint());
            lastWaiter = firstWaiter = null;
            do {
                {
                    Node next = first.nextWaiter;
                    first.nextWaiter = null;
                    transferForSignal(first);
                    first = next;
                } //End block
} while (first != null);
            // ---------- Original Method ----------
            //lastWaiter = firstWaiter = null;
            //do {
                //Node next = first.nextWaiter;
                //first.nextWaiter = null;
                //transferForSignal(first);
                //first = next;
            //} while (first != null);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.870 -0400", hash_original_method = "2AF991EC026F340CB09E7C74A01E5A9A", hash_generated_method = "80733A3444837168288E85B20119B428")
        private void unlinkCancelledWaiters() {
            Node t = firstWaiter;
            Node trail = null;
            while
(t != null)            
            {
                Node next = t.nextWaiter;
    if(t.waitStatus != Node.CONDITION)                
                {
                    t.nextWaiter = null;
    if(trail == null)                    
                    firstWaiter = next;
                    else
                    trail.nextWaiter = next;
    if(next == null)                    
                    lastWaiter = trail;
                } //End block
                else
                trail = t;
                t = next;
            } //End block
            // ---------- Original Method ----------
            //Node t = firstWaiter;
            //Node trail = null;
            //while (t != null) {
                //Node next = t.nextWaiter;
                //if (t.waitStatus != Node.CONDITION) {
                    //t.nextWaiter = null;
                    //if (trail == null)
                        //firstWaiter = next;
                    //else
                        //trail.nextWaiter = next;
                    //if (next == null)
                        //lastWaiter = trail;
                //}
                //else
                    //trail = t;
                //t = next;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.871 -0400", hash_original_method = "217DDC96D1B25C0D1457937D523A3AA4", hash_generated_method = "545616413D097BBD1ADD2C4139291BCB")
        public final void signal() {
    if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1882167969 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_1882167969.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_1882167969;
            }
            Node first = firstWaiter;
    if(first != null)            
            doSignal(first);
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //Node first = firstWaiter;
            //if (first != null)
                //doSignal(first);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.871 -0400", hash_original_method = "8098E0901B1513A38FF0251B40A20DA9", hash_generated_method = "EB429BD5F8F1356DF39FA7582420BA40")
        public final void signalAll() {
    if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1857955069 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_1857955069.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_1857955069;
            }
            Node first = firstWaiter;
    if(first != null)            
            doSignalAll(first);
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //Node first = firstWaiter;
            //if (first != null)
                //doSignalAll(first);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.871 -0400", hash_original_method = "03B567BE1E70F2310FD90D1C09544B27", hash_generated_method = "272321F8AF73C778F581CAC28F8822E3")
        public final void awaitUninterruptibly() {
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            boolean interrupted = false;
            while
(!isOnSyncQueue(node))            
            {
                LockSupport.park(this);
    if(Thread.interrupted())                
                interrupted = true;
            } //End block
    if(acquireQueued(node, savedState) || interrupted)            
            selfInterrupt();
            // ---------- Original Method ----------
            //Node node = addConditionWaiter();
            //int savedState = fullyRelease(node);
            //boolean interrupted = false;
            //while (!isOnSyncQueue(node)) {
                //LockSupport.park(this);
                //if (Thread.interrupted())
                    //interrupted = true;
            //}
            //if (acquireQueued(node, savedState) || interrupted)
                //selfInterrupt();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.872 -0400", hash_original_method = "5CA3F4E55230C1BE0E77A65DF87A61F3", hash_generated_method = "674DDAFF2F9C5E0E556D1B4F96D6FB3A")
        private int checkInterruptWhileWaiting(Node node) {
            addTaint(node.getTaint());
            int varC1AE5D8813CDE6238A1CD29E0E291926_173049783 = (Thread.interrupted() ?
                (transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT) :
                0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855712787 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855712787;
            // ---------- Original Method ----------
            //return Thread.interrupted() ?
                //(transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT) :
                //0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.872 -0400", hash_original_method = "5304D5C5F98F936C59A15960318DA98F", hash_generated_method = "60B5C79AA85F58765815D8F341BAD1B7")
        private void reportInterruptAfterWait(int interruptMode) throws InterruptedException {
            addTaint(interruptMode);
    if(interruptMode == THROW_IE)            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_1484510980 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_1484510980.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_1484510980;
            }
            else
    if(interruptMode == REINTERRUPT)            
            selfInterrupt();
            // ---------- Original Method ----------
            //if (interruptMode == THROW_IE)
                //throw new InterruptedException();
            //else if (interruptMode == REINTERRUPT)
                //selfInterrupt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.872 -0400", hash_original_method = "316B8F22454E74CF1A9F01045EC67EC6", hash_generated_method = "D3320879A21A85BC56BDD733981BAE7C")
        public final void await() throws InterruptedException {
    if(Thread.interrupted())            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_689211869 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_689211869.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_689211869;
            }
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            int interruptMode = 0;
            while
(!isOnSyncQueue(node))            
            {
                LockSupport.park(this);
    if((interruptMode = checkInterruptWhileWaiting(node)) != 0)                
                break;
            } //End block
    if(acquireQueued(node, savedState) && interruptMode != THROW_IE)            
            interruptMode = REINTERRUPT;
    if(node.nextWaiter != null)            
            unlinkCancelledWaiters();
    if(interruptMode != 0)            
            reportInterruptAfterWait(interruptMode);
            // ---------- Original Method ----------
            //if (Thread.interrupted())
                //throw new InterruptedException();
            //Node node = addConditionWaiter();
            //int savedState = fullyRelease(node);
            //int interruptMode = 0;
            //while (!isOnSyncQueue(node)) {
                //LockSupport.park(this);
                //if ((interruptMode = checkInterruptWhileWaiting(node)) != 0)
                    //break;
            //}
            //if (acquireQueued(node, savedState) && interruptMode != THROW_IE)
                //interruptMode = REINTERRUPT;
            //if (node.nextWaiter != null) 
                //unlinkCancelledWaiters();
            //if (interruptMode != 0)
                //reportInterruptAfterWait(interruptMode);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.873 -0400", hash_original_method = "46C34832DD3406F7F3C664FF7A3A79B4", hash_generated_method = "A6C64CF60E7DFA0A2EF30AE48CEF58CC")
        public final long awaitNanos(long nanosTimeout) throws InterruptedException {
            addTaint(nanosTimeout);
    if(Thread.interrupted())            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_1930728973 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_1930728973.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_1930728973;
            }
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            long lastTime = System.nanoTime();
            int interruptMode = 0;
            while
(!isOnSyncQueue(node))            
            {
    if(nanosTimeout <= 0L)                
                {
                    transferAfterCancelledWait(node);
                    break;
                } //End block
                LockSupport.parkNanos(this, nanosTimeout);
    if((interruptMode = checkInterruptWhileWaiting(node)) != 0)                
                break;
                long now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
            } //End block
    if(acquireQueued(node, savedState) && interruptMode != THROW_IE)            
            interruptMode = REINTERRUPT;
    if(node.nextWaiter != null)            
            unlinkCancelledWaiters();
    if(interruptMode != 0)            
            reportInterruptAfterWait(interruptMode);
            long var57645198E102F4FE227A39824B6A9A42_1013732747 = (nanosTimeout - (System.nanoTime() - lastTime));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1648667712 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1648667712;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.874 -0400", hash_original_method = "9B6F9AFE5FC55A4D3153D2EEB76307B9", hash_generated_method = "B6761F52A9593DC3AAF896B8BD10B7C2")
        public final boolean awaitUntil(Date deadline) throws InterruptedException {
            addTaint(deadline.getTaint());
    if(deadline == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1457890326 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1457890326.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1457890326;
            }
            long abstime = deadline.getTime();
    if(Thread.interrupted())            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_1224301537 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_1224301537.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_1224301537;
            }
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            boolean timedout = false;
            int interruptMode = 0;
            while
(!isOnSyncQueue(node))            
            {
    if(System.currentTimeMillis() > abstime)                
                {
                    timedout = transferAfterCancelledWait(node);
                    break;
                } //End block
                LockSupport.parkUntil(this, abstime);
    if((interruptMode = checkInterruptWhileWaiting(node)) != 0)                
                break;
            } //End block
    if(acquireQueued(node, savedState) && interruptMode != THROW_IE)            
            interruptMode = REINTERRUPT;
    if(node.nextWaiter != null)            
            unlinkCancelledWaiters();
    if(interruptMode != 0)            
            reportInterruptAfterWait(interruptMode);
            boolean var3B93B8D4C8D03AB14C23D3E4B12FA84A_538299872 = (!timedout);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439623400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_439623400;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.875 -0400", hash_original_method = "BFE4D71142E465ECC716594C0843F211", hash_generated_method = "730E942FB4F53F7066DE27F8F2552B1A")
        public final boolean await(long time, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(time);
    if(unit == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_537135413 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_537135413.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_537135413;
            }
            long nanosTimeout = unit.toNanos(time);
    if(Thread.interrupted())            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_1923308713 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_1923308713.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_1923308713;
            }
            Node node = addConditionWaiter();
            int savedState = fullyRelease(node);
            long lastTime = System.nanoTime();
            boolean timedout = false;
            int interruptMode = 0;
            while
(!isOnSyncQueue(node))            
            {
    if(nanosTimeout <= 0L)                
                {
                    timedout = transferAfterCancelledWait(node);
                    break;
                } //End block
    if(nanosTimeout >= spinForTimeoutThreshold)                
                LockSupport.parkNanos(this, nanosTimeout);
    if((interruptMode = checkInterruptWhileWaiting(node)) != 0)                
                break;
                long now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
            } //End block
    if(acquireQueued(node, savedState) && interruptMode != THROW_IE)            
            interruptMode = REINTERRUPT;
    if(node.nextWaiter != null)            
            unlinkCancelledWaiters();
    if(interruptMode != 0)            
            reportInterruptAfterWait(interruptMode);
            boolean var3B93B8D4C8D03AB14C23D3E4B12FA84A_1412367021 = (!timedout);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672618716 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672618716;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.875 -0400", hash_original_method = "165B5BC520C58D38E1ED3303B481AD06", hash_generated_method = "13591ED74580967D230E67B6D6E0E488")
        final boolean isOwnedBy(AbstractQueuedSynchronizer sync) {
            addTaint(sync.getTaint());
            boolean var96786A6FAD3E7934374DCD0D0EDF1460_1350381296 = (sync == AbstractQueuedSynchronizer.this);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913665615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913665615;
            // ---------- Original Method ----------
            //return sync == AbstractQueuedSynchronizer.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.875 -0400", hash_original_method = "5570422C2D22E250B14B7FB8C176D89A", hash_generated_method = "8D073D0EF53E843C7E9DD7055907A6C2")
        protected final boolean hasWaiters() {
    if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1884534109 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_1884534109.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_1884534109;
            }
for(Node w = firstWaiter;w != null;w = w.nextWaiter)
            {
    if(w.waitStatus == Node.CONDITION)                
                {
                boolean varB326B5062B2F0E69046810717534CB09_994410555 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_987233869 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_987233869;
                }
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1648768803 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162476049 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_162476049;
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //for (Node w = firstWaiter; w != null; w = w.nextWaiter) {
                //if (w.waitStatus == Node.CONDITION)
                    //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.876 -0400", hash_original_method = "586699B2B19676C29FE19392CDC481BB", hash_generated_method = "00E705C5E0089EB41D07A1B54CE60F62")
        protected final int getWaitQueueLength() {
    if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1029970872 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_1029970872.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_1029970872;
            }
            int n = 0;
for(Node w = firstWaiter;w != null;w = w.nextWaiter)
            {
    if(w.waitStatus == Node.CONDITION)                
                ++n;
            } //End block
            int var7B8B965AD4BCA0E41AB51DE7B31363A1_1022345429 = (n);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859920146 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859920146;
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //int n = 0;
            //for (Node w = firstWaiter; w != null; w = w.nextWaiter) {
                //if (w.waitStatus == Node.CONDITION)
                    //++n;
            //}
            //return n;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.877 -0400", hash_original_method = "D1136CB2B0FE173AD3F139F996FAE8B5", hash_generated_method = "8E9A4BBDB1124FEB1292D93C4361E223")
        protected final Collection<Thread> getWaitingThreads() {
    if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1802605394 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_1802605394.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_1802605394;
            }
            ArrayList<Thread> list = new ArrayList<Thread>();
for(Node w = firstWaiter;w != null;w = w.nextWaiter)
            {
    if(w.waitStatus == Node.CONDITION)                
                {
                    Thread t = w.thread;
    if(t != null)                    
                    list.add(t);
                } //End block
            } //End block
Collection<Thread> varED12C351C2E8CA4F85F097DDC7E77B4D_1477798630 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_1477798630.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_1477798630;
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //ArrayList<Thread> list = new ArrayList<Thread>();
            //for (Node w = firstWaiter; w != null; w = w.nextWaiter) {
                //if (w.waitStatus == Node.CONDITION) {
                    //Thread t = w.thread;
                    //if (t != null)
                        //list.add(t);
                //}
            //}
            //return list;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.877 -0400", hash_original_field = "C457B05B8D8DCF2333B7BE06BB3694B7", hash_generated_field = "C9096AAE36B16976484AF1C63AF46815")

        private static final long serialVersionUID = 1173984872572414699L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.877 -0400", hash_original_field = "D61A8CF122BE9E2755E208E71F14B796", hash_generated_field = "719C1717721B97867F5478A2BF8734E2")

        private static final int REINTERRUPT = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.877 -0400", hash_original_field = "26CBB60DE11931C6D9D95F685537FC92", hash_generated_field = "4348EF9055A3499985FF0B3F446F2BC1")

        private static final int THROW_IE = -1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.877 -0400", hash_original_field = "53B46295871253A108CBEAB47C328D22", hash_generated_field = "D0E32D39585FA118FF323BF7B8487515")

    private static final long serialVersionUID = 7373984972572414691L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.877 -0400", hash_original_field = "97826F3E2403B559BA27663CADCEE60A", hash_generated_field = "BFF11A71C399B3DB146FF1C739630A1D")

    static final long spinForTimeoutThreshold = 1000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.877 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.877 -0400", hash_original_field = "2C1DA28B2CFB5A4DCF7A56B1409A3B45", hash_generated_field = "162353053FFA573C2A47BACEC7C77131")

    private static long stateOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.877 -0400", hash_original_field = "949FBEE482BB8F9AF6BC94101DBBFA8B", hash_generated_field = "97CE09A29DB2EB713A48E047121081EE")

    private static long headOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.878 -0400", hash_original_field = "9AB0A3F42E66C0E1646CAE7D9DF99009", hash_generated_field = "8B58E2B37A159AAD83A5260C2F388DB2")

    private static long tailOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.878 -0400", hash_original_field = "FA3E7ECB1F7079FDF9ADC8AA71B67A14", hash_generated_field = "58D083123B9F4D91D47538963124B084")

    private static long waitStatusOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.878 -0400", hash_original_field = "AF712C58580FB5A2A86652706D04C24E", hash_generated_field = "94ADDD311D046BDDD72EC240B54C288D")

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

