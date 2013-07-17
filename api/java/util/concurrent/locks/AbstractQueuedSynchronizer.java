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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.292 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "C968564223BCE6AEFE8413EAB36A32B1")

    private transient volatile Node head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.293 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "AD93D08E1C37116EBC071C3224E8414A")

    private transient volatile Node tail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.293 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "40C4313E234E54E18DC2BFEA68F3E464")

    private volatile int state;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.293 -0400", hash_original_method = "C7F1FA27B1E7517E25F1C7951B5E8CA8", hash_generated_method = "D0F5CBC29675A9CABCA264BF6F7A7644")
    protected  AbstractQueuedSynchronizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.293 -0400", hash_original_method = "15A8F8E5739EB2961628EAE8F68BF29F", hash_generated_method = "B765A0D313F2995039EACBD646C5850B")
    protected final int getState() {
        int var9ED39E2EA931586B6A985A6942EF573E_1666088328 = (state);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621665941 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_621665941;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.293 -0400", hash_original_method = "57BE013BA515294E586014B30A336C04", hash_generated_method = "B9B29E2146A9DFA0E89C5BBC08072583")
    protected final void setState(int newState) {
        state = newState;
        // ---------- Original Method ----------
        //state = newState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.294 -0400", hash_original_method = "DF00243144DD556AB3E9A0ABE3AEC78F", hash_generated_method = "8B14B5D2F85C6083175973E29688059F")
    protected final boolean compareAndSetState(int expect, int update) {
        addTaint(update);
        addTaint(expect);
        boolean varE169225C89A949AD38419A0BE7572030_1152776366 = (unsafe.compareAndSwapInt(this, stateOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_850637293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_850637293;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.295 -0400", hash_original_method = "D115C79C5FCCB59668763118EBD8CBBB", hash_generated_method = "2B9DFD31CD067D35FF671DC3EE1FEDD6")
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
Node varE0D714D758F1540A8DF364A965AF9150_1262158398 =                     t;
                    varE0D714D758F1540A8DF364A965AF9150_1262158398.addTaint(taint);
                    return varE0D714D758F1540A8DF364A965AF9150_1262158398;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.296 -0400", hash_original_method = "7269E5EC16B8883F661BF745CCC5E6A6", hash_generated_method = "EBB8C59130DF77C5C7F30CAFA7B2B4C8")
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
Node var1924C94B76524D1C3D7310EA17B0EF94_2008407164 =                 node;
                var1924C94B76524D1C3D7310EA17B0EF94_2008407164.addTaint(taint);
                return var1924C94B76524D1C3D7310EA17B0EF94_2008407164;
            } //End block
        } //End block
        enq(node);
Node var1924C94B76524D1C3D7310EA17B0EF94_496908491 =         node;
        var1924C94B76524D1C3D7310EA17B0EF94_496908491.addTaint(taint);
        return var1924C94B76524D1C3D7310EA17B0EF94_496908491;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.298 -0400", hash_original_method = "51AEDFDDD323C78EE2EC4A6DE568B8D1", hash_generated_method = "E532E4CBBEBFF44C610D0F95E73E8319")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.299 -0400", hash_original_method = "F262A3A18BABECF7EC492736953EAF6E", hash_generated_method = "A93A115F239F2D3D3F010BE781B1A7F1")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.301 -0400", hash_original_method = "D8D55646997B45206CD2F0528B603753", hash_generated_method = "70DCCB5937F13D53C20996F49C5243FC")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.302 -0400", hash_original_method = "A2FB30DAE399AEFA487E20396027BD36", hash_generated_method = "40E839A4C9B6A476B26404E2C51E7F79")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.303 -0400", hash_original_method = "1CA41B58715410C4216B9DE6C43BB9D4", hash_generated_method = "C5F79ACF849694CECD07366B161DDD11")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.305 -0400", hash_original_method = "C551D5FD0C0A2C72DAD755E48C68905F", hash_generated_method = "F073936CFF5A65E94E682340A37C048E")
    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        boolean var3B1A033197311EAFDE26E62437B6A8BF_957903838 = (Thread.interrupted());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649766005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649766005;
        // ---------- Original Method ----------
        //LockSupport.park(this);
        //return Thread.interrupted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.305 -0400", hash_original_method = "0D7553B7A8DFDAC7C355CECFA0DBF574", hash_generated_method = "ADD9FBE0A9D14C317EF4899A364C4404")
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
                    boolean varFADB76763385627E57EC386C9B6038F0_700706614 = (interrupted);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1433056944 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1433056944;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.306 -0400", hash_original_method = "E74C4677EAF9B6C97A4A9A93D88FC71E", hash_generated_method = "ECA6F63F8CF2D3A3CCB42911CA1FE8E9")
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
                InterruptedException var1358A8E226367F12BB278428C2BEEE00_759294581 = new InterruptedException();
                var1358A8E226367F12BB278428C2BEEE00_759294581.addTaint(taint);
                throw var1358A8E226367F12BB278428C2BEEE00_759294581;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.308 -0400", hash_original_method = "AF980EBAC4BC6C4AB1174BED3B10073B", hash_generated_method = "DB3EF83971300B68D8BE9546F06E710F")
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
                    boolean varB326B5062B2F0E69046810717534CB09_2005538119 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685437874 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685437874;
                } //End block
                if(nanosTimeout <= 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1634298078 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1494110190 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1494110190;
                }
                if(shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold)                
                LockSupport.parkNanos(this, nanosTimeout);
                long now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                if(Thread.interrupted())                
                {
                InterruptedException var1358A8E226367F12BB278428C2BEEE00_179611667 = new InterruptedException();
                var1358A8E226367F12BB278428C2BEEE00_179611667.addTaint(taint);
                throw var1358A8E226367F12BB278428C2BEEE00_179611667;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.309 -0400", hash_original_method = "D66678B4038334D8E14600B3A8FC8FD7", hash_generated_method = "706DE7BF41217D97C1B1C0111FA50E7F")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.311 -0400", hash_original_method = "4E093FA1B6FCF5593272CE0DEA00D69B", hash_generated_method = "2D4E165097B376D719672743C0EFA351")
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
                InterruptedException var1358A8E226367F12BB278428C2BEEE00_67886941 = new InterruptedException();
                var1358A8E226367F12BB278428C2BEEE00_67886941.addTaint(taint);
                throw var1358A8E226367F12BB278428C2BEEE00_67886941;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.313 -0400", hash_original_method = "873D99639E9E59C87CD3A574B36E4573", hash_generated_method = "74D9A3CD2C4AFF05F50E27E05D2F1FB9")
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
                        boolean varB326B5062B2F0E69046810717534CB09_1200166308 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762657343 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_762657343;
                    } //End block
                } //End block
                if(nanosTimeout <= 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1424141186 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_791205040 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_791205040;
                }
                if(shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold)                
                LockSupport.parkNanos(this, nanosTimeout);
                long now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                if(Thread.interrupted())                
                {
                InterruptedException var1358A8E226367F12BB278428C2BEEE00_1739109983 = new InterruptedException();
                var1358A8E226367F12BB278428C2BEEE00_1739109983.addTaint(taint);
                throw var1358A8E226367F12BB278428C2BEEE00_1739109983;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.313 -0400", hash_original_method = "FADA99D99649E8B049B596B89A86AFE3", hash_generated_method = "24D3D97B70EE9A4F2DA0B8828F2D1558")
    protected boolean tryAcquire(int arg) {
        addTaint(arg);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1417510370 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1417510370.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1417510370;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.314 -0400", hash_original_method = "0AA9B3926B88397CF769442818D9CA16", hash_generated_method = "6E51973550CC068810FBA43E8D2A967C")
    protected boolean tryRelease(int arg) {
        addTaint(arg);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1280761662 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1280761662.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1280761662;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.314 -0400", hash_original_method = "143AB2DE4C7A8CA8F45FD3C862AFB93B", hash_generated_method = "D994444CA5192DBD060C63804A1F13DF")
    protected int tryAcquireShared(int arg) {
        addTaint(arg);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_835481248 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_835481248.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_835481248;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.314 -0400", hash_original_method = "57760B0E19163CFD26451EB4C702B2B7", hash_generated_method = "B832AC79F070087471EACB59C838BD7C")
    protected boolean tryReleaseShared(int arg) {
        addTaint(arg);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_908388581 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_908388581.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_908388581;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.314 -0400", hash_original_method = "B1A3EF7BA2A74EEB6B3236F0A99ED9FE", hash_generated_method = "25FD70F97654CD98661B3CEB8F4FFF44")
    protected boolean isHeldExclusively() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_10942790 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_10942790.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_10942790;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.314 -0400", hash_original_method = "10DE26F4AB94E5F1867D5F821F4BF0D7", hash_generated_method = "9D434AAC078ACD909DA7ADFE9A674506")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.315 -0400", hash_original_method = "34DE0EEECFCC486100F3F952023E1D48", hash_generated_method = "F6A7CE630AAEF77510991090C7228459")
    public final void acquireInterruptibly(int arg) throws InterruptedException {
        addTaint(arg);
        if(Thread.interrupted())        
        {
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_412899740 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_412899740.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_412899740;
        }
        if(!tryAcquire(arg))        
        doAcquireInterruptibly(arg);
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (!tryAcquire(arg))
            //doAcquireInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.315 -0400", hash_original_method = "C2BC4409CE226EEA6D2598B40FA64E1C", hash_generated_method = "6F3B6A0CE3C674FE2EC9229683ADFAD0")
    public final boolean tryAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
        addTaint(nanosTimeout);
        addTaint(arg);
        if(Thread.interrupted())        
        {
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_807685566 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_807685566.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_807685566;
        }
        boolean varA01D96404099C31650ABFFBB7F35E590_1662412997 = (tryAcquire(arg) ||
            doAcquireNanos(arg, nanosTimeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718701026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_718701026;
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquire(arg) ||
            //doAcquireNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.316 -0400", hash_original_method = "482847B9E820B21E98E389768A5050E4", hash_generated_method = "3249FAAFC1E53534C6C435BF9E041A57")
    public final boolean release(int arg) {
        addTaint(arg);
        if(tryRelease(arg))        
        {
            Node h = head;
            if(h != null && h.waitStatus != 0)            
            unparkSuccessor(h);
            boolean varB326B5062B2F0E69046810717534CB09_882432799 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996655199 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996655199;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_290530815 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1294735305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1294735305;
        // ---------- Original Method ----------
        //if (tryRelease(arg)) {
            //Node h = head;
            //if (h != null && h.waitStatus != 0)
                //unparkSuccessor(h);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.316 -0400", hash_original_method = "503864E706CF656D09684EB1E461773D", hash_generated_method = "EE10D68B90A4E67490FA41A3F047DC45")
    public final void acquireShared(int arg) {
        addTaint(arg);
        if(tryAcquireShared(arg) < 0)        
        doAcquireShared(arg);
        // ---------- Original Method ----------
        //if (tryAcquireShared(arg) < 0)
            //doAcquireShared(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.316 -0400", hash_original_method = "10425BDCE3B0F2DAA2E0ECCAD9B4BACD", hash_generated_method = "80403E9348D71EBF3D13275609B0E7D6")
    public final void acquireSharedInterruptibly(int arg) throws InterruptedException {
        addTaint(arg);
        if(Thread.interrupted())        
        {
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_1129602761 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_1129602761.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_1129602761;
        }
        if(tryAcquireShared(arg) < 0)        
        doAcquireSharedInterruptibly(arg);
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (tryAcquireShared(arg) < 0)
            //doAcquireSharedInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.317 -0400", hash_original_method = "34AA5C57E6BB40898FDB5D4BB2EF37C3", hash_generated_method = "00EAA05A5ED1A3CC0BE6B9CD08CAF0B3")
    public final boolean tryAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
        addTaint(nanosTimeout);
        addTaint(arg);
        if(Thread.interrupted())        
        {
        InterruptedException var1358A8E226367F12BB278428C2BEEE00_1808607743 = new InterruptedException();
        var1358A8E226367F12BB278428C2BEEE00_1808607743.addTaint(taint);
        throw var1358A8E226367F12BB278428C2BEEE00_1808607743;
        }
        boolean varAC8EC28312AC77D7940A1374507E454D_221777613 = (tryAcquireShared(arg) >= 0 ||
            doAcquireSharedNanos(arg, nanosTimeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1132817961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1132817961;
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquireShared(arg) >= 0 ||
            //doAcquireSharedNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.317 -0400", hash_original_method = "64AF2599D3C05FF36535D67856367D8D", hash_generated_method = "94EA3BD71F6D54E5F794367A99E691FC")
    public final boolean releaseShared(int arg) {
        addTaint(arg);
        if(tryReleaseShared(arg))        
        {
            doReleaseShared();
            boolean varB326B5062B2F0E69046810717534CB09_1675107155 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565167522 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_565167522;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1770340374 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858677963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858677963;
        // ---------- Original Method ----------
        //if (tryReleaseShared(arg)) {
            //doReleaseShared();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.317 -0400", hash_original_method = "3ACA5092770D7AD1442898AF3B627DFE", hash_generated_method = "170778F3FFEA0FD9F7A51BC7F3EDA53D")
    public final boolean hasQueuedThreads() {
        boolean varA082AC3EB8E95F4F31577910CF1352A9_709944474 = (head != tail);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923361541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_923361541;
        // ---------- Original Method ----------
        //return head != tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.318 -0400", hash_original_method = "3ED9D0D071477B613E998B33D61DD4C5", hash_generated_method = "1B3BD3F2DD96246A517E97FDD7AA6DC0")
    public final boolean hasContended() {
        boolean varF99FF234A7427ED48BEA6CF28AE0958C_637593438 = (head != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1061880030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1061880030;
        // ---------- Original Method ----------
        //return head != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.318 -0400", hash_original_method = "DB23AE447B60E978D848F5CEAEC8257B", hash_generated_method = "73E51FC442C7C94A000D4DAD3C7F867C")
    public final Thread getFirstQueuedThread() {
Thread var870C75E9F1DE61C9DB12235564677748_63023656 =         (head == tail) ? null : fullGetFirstQueuedThread();
        var870C75E9F1DE61C9DB12235564677748_63023656.addTaint(taint);
        return var870C75E9F1DE61C9DB12235564677748_63023656;
        // ---------- Original Method ----------
        //return (head == tail) ? null : fullGetFirstQueuedThread();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.331 -0400", hash_original_method = "18818CB637EBC5CF82DC4C50B37FB17C", hash_generated_method = "93D1441071F9B2E98ED53DC347544755")
    private Thread fullGetFirstQueuedThread() {
        Node h;
        Node s;
        Thread st;
        if(((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null) ||
            ((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null))        
        {
Thread varAA0158446C9008DEF446ADFDF1B056A8_1566889234 =         st;
        varAA0158446C9008DEF446ADFDF1B056A8_1566889234.addTaint(taint);
        return varAA0158446C9008DEF446ADFDF1B056A8_1566889234;
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
Thread varDBE1B135F3AB7C062EA0CD8FCD339ACB_759636403 =         firstThread;
        varDBE1B135F3AB7C062EA0CD8FCD339ACB_759636403.addTaint(taint);
        return varDBE1B135F3AB7C062EA0CD8FCD339ACB_759636403;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.331 -0400", hash_original_method = "1573E83A14D593E0BFADABB9AEDBB7D2", hash_generated_method = "469CC8EE30ED434AD443E6519FE0BFE2")
    public final boolean isQueued(Thread thread) {
        addTaint(thread.getTaint());
        if(thread == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1622792340 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1622792340.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1622792340;
        }
for(Node p = tail;p != null;p = p.prev)
        if(p.thread == thread)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_58232013 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141634336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141634336;
        }
        boolean var68934A3E9455FA72420237EB05902327_1420703729 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_135957913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_135957913;
        // ---------- Original Method ----------
        //if (thread == null)
            //throw new NullPointerException();
        //for (Node p = tail; p != null; p = p.prev)
            //if (p.thread == thread)
                //return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.332 -0400", hash_original_method = "4993AFB2E466C494E10B5DA4780E51AB", hash_generated_method = "F0876CD68708A82BAC4435D40546EA8B")
    final boolean apparentlyFirstQueuedIsExclusive() {
        Node h;
        Node s;
        boolean var384A24DAA64C392C8BD17ED8B979769C_1658381153 = ((h = head) != null &&
            (s = h.next)  != null &&
            !s.isShared()         &&
            s.thread != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254504515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_254504515;
        // ---------- Original Method ----------
        //Node h, s;
        //return (h = head) != null &&
            //(s = h.next)  != null &&
            //!s.isShared()         &&
            //s.thread != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.339 -0400", hash_original_method = "155F6B01F514C41CA8367710346D37E3", hash_generated_method = "A633E7E52CFCEBB5E96D063F622CD696")
    public final boolean hasQueuedPredecessors() {
        Node t = tail;
        Node h = head;
        Node s;
        boolean var549425DF4D520D7AED284FC4F26FB594_133831915 = (h != t &&
            ((s = h.next) == null || s.thread != Thread.currentThread()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1519383250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1519383250;
        // ---------- Original Method ----------
        //Node t = tail;
        //Node h = head;
        //Node s;
        //return h != t &&
            //((s = h.next) == null || s.thread != Thread.currentThread());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.345 -0400", hash_original_method = "65AB677A04652631BF1CC269A789F93A", hash_generated_method = "B3948F6D5FB0346931D765C662F31DD4")
    public final int getQueueLength() {
        int n = 0;
for(Node p = tail;p != null;p = p.prev)
        {
            if(p.thread != null)            
            ++n;
        } //End block
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_2080100326 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603777084 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603777084;
        // ---------- Original Method ----------
        //int n = 0;
        //for (Node p = tail; p != null; p = p.prev) {
            //if (p.thread != null)
                //++n;
        //}
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.350 -0400", hash_original_method = "BA97C075FB0E9B39CEF398B585209CAD", hash_generated_method = "611EE97036BA70F077CC1680766F0F66")
    public final Collection<Thread> getQueuedThreads() {
        ArrayList<Thread> list = new ArrayList<Thread>();
for(Node p = tail;p != null;p = p.prev)
        {
            Thread t = p.thread;
            if(t != null)            
            list.add(t);
        } //End block
Collection<Thread> varED12C351C2E8CA4F85F097DDC7E77B4D_73401253 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_73401253.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_73401253;
        // ---------- Original Method ----------
        //ArrayList<Thread> list = new ArrayList<Thread>();
        //for (Node p = tail; p != null; p = p.prev) {
            //Thread t = p.thread;
            //if (t != null)
                //list.add(t);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.357 -0400", hash_original_method = "8F9C05C78C38CDEC6B94C7386A00C30C", hash_generated_method = "DE70A67608F40C813EBACC0F9144B9FC")
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
Collection<Thread> varED12C351C2E8CA4F85F097DDC7E77B4D_1344254680 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1344254680.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1344254680;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.364 -0400", hash_original_method = "3B2BC348731488178C75B0F7C3256BE4", hash_generated_method = "C327AE0E9A1E518CC9F5CB55AD8F83D4")
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
Collection<Thread> varED12C351C2E8CA4F85F097DDC7E77B4D_847413911 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_847413911.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_847413911;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.368 -0400", hash_original_method = "2C49C090DBE6788B4A91D995132AEECA", hash_generated_method = "553B9D421AFE3B15BB914B237ADA1A53")
    public String toString() {
        int s = getState();
        String q = hasQueuedThreads() ? "non" : "";
String var4EB727B8FD98B5F7ED6D14E18A4FCCA4_1295557547 =         super.toString() +
            "[State = " + s + ", " + q + "empty queue]";
        var4EB727B8FD98B5F7ED6D14E18A4FCCA4_1295557547.addTaint(taint);
        return var4EB727B8FD98B5F7ED6D14E18A4FCCA4_1295557547;
        // ---------- Original Method ----------
        //int s = getState();
        //String q  = hasQueuedThreads() ? "non" : "";
        //return super.toString() +
            //"[State = " + s + ", " + q + "empty queue]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.371 -0400", hash_original_method = "0981A7B7481B56654552F826D97FC7A4", hash_generated_method = "EF5FE3733DF9654937E9533230A8629A")
    final boolean isOnSyncQueue(Node node) {
        addTaint(node.getTaint());
        if(node.waitStatus == Node.CONDITION || node.prev == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_328912805 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1855168233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1855168233;
        }
        if(node.next != null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_93368181 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_747143675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_747143675;
        }
        boolean var1334757DEAE6F9A44E12EB6C1BF18A1A_204561552 = (findNodeFromTail(node));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261501183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_261501183;
        // ---------- Original Method ----------
        //if (node.waitStatus == Node.CONDITION || node.prev == null)
            //return false;
        //if (node.next != null) 
            //return true;
        //return findNodeFromTail(node);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.377 -0400", hash_original_method = "E84A510853D9F9659F34649D5E631E14", hash_generated_method = "82F42682478FFBEF86F6BB3D64706C4F")
    private boolean findNodeFromTail(Node node) {
        addTaint(node.getTaint());
        Node t = tail;
for(;;)
        {
            if(t == node)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1229743187 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656679858 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656679858;
            }
            if(t == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1265347721 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_945666775 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_945666775;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.384 -0400", hash_original_method = "AC7EB2A7C3E5842E27808853E2EADEA4", hash_generated_method = "CDA60011B7BD0792A5DB078F05CEC387")
    final boolean transferForSignal(Node node) {
        addTaint(node.getTaint());
        if(!compareAndSetWaitStatus(node, Node.CONDITION, 0))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1711387755 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680367249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680367249;
        }
        Node p = enq(node);
        int ws = p.waitStatus;
        if(ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL))        
        LockSupport.unpark(node.thread);
        boolean varB326B5062B2F0E69046810717534CB09_1058313687 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671985465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671985465;
        // ---------- Original Method ----------
        //if (!compareAndSetWaitStatus(node, Node.CONDITION, 0))
            //return false;
        //Node p = enq(node);
        //int ws = p.waitStatus;
        //if (ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL))
            //LockSupport.unpark(node.thread);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.386 -0400", hash_original_method = "202AE2159172221E521994FECA693914", hash_generated_method = "D814235B9D841C1E1B4E9009B48D1AED")
    final boolean transferAfterCancelledWait(Node node) {
        addTaint(node.getTaint());
        if(compareAndSetWaitStatus(node, Node.CONDITION, 0))        
        {
            enq(node);
            boolean varB326B5062B2F0E69046810717534CB09_843137500 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149702837 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_149702837;
        } //End block
        while
(!isOnSyncQueue(node))        
        Thread.yield();
        boolean var68934A3E9455FA72420237EB05902327_1560339659 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305155760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305155760;
        // ---------- Original Method ----------
        //if (compareAndSetWaitStatus(node, Node.CONDITION, 0)) {
            //enq(node);
            //return true;
        //}
        //while (!isOnSyncQueue(node))
            //Thread.yield();
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.387 -0400", hash_original_method = "13260C05A29655F6FC8F2FA182B20EC8", hash_generated_method = "82859A4F6DCC9750D6CFF31D440E3322")
    final int fullyRelease(Node node) {
        addTaint(node.getTaint());
        boolean failed = true;
        try 
        {
            int savedState = getState();
            if(release(savedState))            
            {
                failed = false;
                int var4C0428E38EB47B04E0869E39E7C0D6A1_1116362643 = (savedState);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444354850 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444354850;
            } //End block
            else
            {
                IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1015116179 = new IllegalMonitorStateException();
                var9D4F198B973DC32951341758A9D245B5_1015116179.addTaint(taint);
                throw var9D4F198B973DC32951341758A9D245B5_1015116179;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.388 -0400", hash_original_method = "B60D02054E03A30F41C10CC4F7B33B2F", hash_generated_method = "E0AD9F6214305B116F075863AC8B2C1B")
    public final boolean owns(ConditionObject condition) {
        addTaint(condition.getTaint());
        if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1889262633 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1889262633.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1889262633;
        }
        boolean varD1428399BF953DC879A6F44FC54099DD_1549194036 = (condition.isOwnedBy(this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1613616065 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1613616065;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //return condition.isOwnedBy(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.389 -0400", hash_original_method = "B87CA02CD99C2C81A6ADCC153DE8BF7D", hash_generated_method = "08719847907ADF2C08FAA298836265C0")
    public final boolean hasWaiters(ConditionObject condition) {
        addTaint(condition.getTaint());
        if(!owns(condition))        
        {
        IllegalArgumentException var10F139FF311F906191A15D005A0AF6DB_551707250 = new IllegalArgumentException("Not owner");
        var10F139FF311F906191A15D005A0AF6DB_551707250.addTaint(taint);
        throw var10F139FF311F906191A15D005A0AF6DB_551707250;
        }
        boolean varD110D0E8476BE1ED9552C2B17F2EABE3_1685232240 = (condition.hasWaiters());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97672272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_97672272;
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.hasWaiters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.389 -0400", hash_original_method = "FDFBF2604A26737643DD133E9F8A257F", hash_generated_method = "E0BA3721E24A38ECDE8F4077717DDF80")
    public final int getWaitQueueLength(ConditionObject condition) {
        addTaint(condition.getTaint());
        if(!owns(condition))        
        {
        IllegalArgumentException var10F139FF311F906191A15D005A0AF6DB_1684103499 = new IllegalArgumentException("Not owner");
        var10F139FF311F906191A15D005A0AF6DB_1684103499.addTaint(taint);
        throw var10F139FF311F906191A15D005A0AF6DB_1684103499;
        }
        int var74EB0FD17BFFF2510CAC56C3F4C7D72C_326500494 = (condition.getWaitQueueLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171923581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171923581;
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.390 -0400", hash_original_method = "70972013E049E7504ADBD56143485C77", hash_generated_method = "2AD01D41A79E152A7A7B4D4569A382E1")
    public final Collection<Thread> getWaitingThreads(ConditionObject condition) {
        addTaint(condition.getTaint());
        if(!owns(condition))        
        {
        IllegalArgumentException var10F139FF311F906191A15D005A0AF6DB_1532172605 = new IllegalArgumentException("Not owner");
        var10F139FF311F906191A15D005A0AF6DB_1532172605.addTaint(taint);
        throw var10F139FF311F906191A15D005A0AF6DB_1532172605;
        }
Collection<Thread> var8981A24903B26F18C4110654EEEEEF5C_1388021589 =         condition.getWaitingThreads();
        var8981A24903B26F18C4110654EEEEEF5C_1388021589.addTaint(taint);
        return var8981A24903B26F18C4110654EEEEEF5C_1388021589;
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitingThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.390 -0400", hash_original_method = "20D2259271C7B1C96C133ACBD2C26B14", hash_generated_method = "26BF181AA211A7FBEC55AF252E73C56E")
    private final boolean compareAndSetHead(Node update) {
        addTaint(update.getTaint());
        boolean var0A2860D9316D8AD7309534503883A416_693205800 = (unsafe.compareAndSwapObject(this, headOffset, null, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648948588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648948588;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.391 -0400", hash_original_method = "8C47C531A43F622294BF6051B04C8993", hash_generated_method = "759064A1ACE6F1B9890EA1DC1370CF13")
    private final boolean compareAndSetTail(Node expect, Node update) {
        addTaint(update.getTaint());
        addTaint(expect.getTaint());
        boolean var1B8F67C774023CA8EF7CAAF2DAEE008A_1468524002 = (unsafe.compareAndSwapObject(this, tailOffset, expect, update));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676019741 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676019741;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.392 -0400", hash_original_field = "282F56A6C3233E93D5BACF05B9AA8876", hash_generated_field = "4D5292AE19E73CB6BC72A4A4EE34646D")

        volatile int waitStatus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.392 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "CE4F99BFA9BE83062548109E0A80EB36")

        volatile Node prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.392 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "495F81DE1A0BB70B1CC0F10199933490")

        volatile Node next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.393 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3347E7A3168C0A597DE966A2AEA728E2")

        volatile Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.393 -0400", hash_original_field = "1F76D737B407F4A2AD51A0EFEB508D50", hash_generated_field = "EE921616C37FFDDFA9B9DA84ABF34675")

        Node nextWaiter;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.393 -0400", hash_original_method = "2DD8BF5485F2495811D83404AF44A29C", hash_generated_method = "AAE5751DE21B256CB4EDD0DDB605F24E")
          Node() {
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.394 -0400", hash_original_method = "764EF23A3C66C99D5E5160039F46E6BD", hash_generated_method = "2CAC145FA8BF94E846C302C88AD33F87")
          Node(Thread thread, Node mode) {
            this.nextWaiter = mode;
            this.thread = thread;
            // ---------- Original Method ----------
            //this.nextWaiter = mode;
            //this.thread = thread;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.395 -0400", hash_original_method = "5118904E6021AE155CDFF15DB609BD48", hash_generated_method = "4FCE7CEF63C545859A3D7EF41D2DEAC9")
          Node(Thread thread, int waitStatus) {
            this.waitStatus = waitStatus;
            this.thread = thread;
            // ---------- Original Method ----------
            //this.waitStatus = waitStatus;
            //this.thread = thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.395 -0400", hash_original_method = "EA506AD78E2AE8ACF234FE0610B9A575", hash_generated_method = "D3383CEDB127AC9B71609ACDA7443510")
        final boolean isShared() {
            boolean varDC3CBE439A4F6F1CF2883A72D8EC2038_1950926027 = (nextWaiter == SHARED);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618269848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_618269848;
            // ---------- Original Method ----------
            //return nextWaiter == SHARED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.396 -0400", hash_original_method = "7AA5CFB77F71DE2C6FFA937BCE62ADAE", hash_generated_method = "3BC182108D9F7B81E47250C76C910B04")
        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if(p == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1947550029 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1947550029.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1947550029;
            }
            else
            {
Node var74E4690D9F2A026504928C017944E149_1158107245 =             p;
            var74E4690D9F2A026504928C017944E149_1158107245.addTaint(taint);
            return var74E4690D9F2A026504928C017944E149_1158107245;
            }
            // ---------- Original Method ----------
            //Node p = prev;
            //if (p == null)
                //throw new NullPointerException();
            //else
                //return p;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.396 -0400", hash_original_field = "29B93CAC7244964D7B989712BB2AAA8F", hash_generated_field = "A09441E8911A57E0DA262F7FAB0EA28A")

        static final Node SHARED = new Node();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.396 -0400", hash_original_field = "F427D28BCA700281DA9D02E201499452", hash_generated_field = "2FB080405C41D521F6A68DD8C95FE029")

        static final Node EXCLUSIVE = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.396 -0400", hash_original_field = "988DB81EC2397AB0D5457DF07B87908A", hash_generated_field = "E67B54E6E13DC27CF3608595B88B40CB")

        static final int CANCELLED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.396 -0400", hash_original_field = "1B171CE64A08A97E810AC0B2A481548E", hash_generated_field = "8577B9810AB6FC6DF6B54ADA380AC389")

        static final int SIGNAL = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.396 -0400", hash_original_field = "EC24A5598A6130CF31D6F9BEF244C4A1", hash_generated_field = "1D67D49288B45666BD2DADDDBBA57C2F")

        static final int CONDITION = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.397 -0400", hash_original_field = "2F582260408474C896C524B277DB2733", hash_generated_field = "16BF27DDB917629F3C35C8BC0AB5CC5C")

        static final int PROPAGATE = -3;
    }


    
    public class ConditionObject implements Condition, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.397 -0400", hash_original_field = "CD495CA7D725FEED43A3FB720F4B8EC1", hash_generated_field = "65A161514F134134E9F0B478EBDE5ED3")

        private transient Node firstWaiter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.397 -0400", hash_original_field = "8BDF0C40F706950EC229FBE0007BC4E3", hash_generated_field = "2A9616AEC7221DB00588D39E0457BC79")

        private transient Node lastWaiter;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.397 -0400", hash_original_method = "0A3E2C1E27BAEA738FDF96AD17500BEE", hash_generated_method = "6AF9B0E3D406E6C56AA07F09E795B0E2")
        public  ConditionObject() {
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.400 -0400", hash_original_method = "43F5E066353E431B2C9AD7CD0397BCCF", hash_generated_method = "32CF2F58F59B79B994D29F36AC55FED7")
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
Node var1924C94B76524D1C3D7310EA17B0EF94_1116113005 =             node;
            var1924C94B76524D1C3D7310EA17B0EF94_1116113005.addTaint(taint);
            return var1924C94B76524D1C3D7310EA17B0EF94_1116113005;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.402 -0400", hash_original_method = "74B8316ED8B5F40365D8BD9CF002AB2D", hash_generated_method = "5A26EDA37C913BD6A78C85A0B826BA92")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.403 -0400", hash_original_method = "DE4F68C515AD9FDEF86DCFCC83AF390E", hash_generated_method = "538AA885639A6DAD8B8C761ACEA5BCCC")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.404 -0400", hash_original_method = "2AF991EC026F340CB09E7C74A01E5A9A", hash_generated_method = "80733A3444837168288E85B20119B428")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.405 -0400", hash_original_method = "217DDC96D1B25C0D1457937D523A3AA4", hash_generated_method = "05EC620E2472088C0A3EF0D22E364D8E")
        public final void signal() {
            if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1004984033 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_1004984033.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_1004984033;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.405 -0400", hash_original_method = "8098E0901B1513A38FF0251B40A20DA9", hash_generated_method = "CC2EF4C816FB61B68D5B68B58D2B6396")
        public final void signalAll() {
            if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_951698173 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_951698173.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_951698173;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.405 -0400", hash_original_method = "03B567BE1E70F2310FD90D1C09544B27", hash_generated_method = "272321F8AF73C778F581CAC28F8822E3")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.406 -0400", hash_original_method = "5CA3F4E55230C1BE0E77A65DF87A61F3", hash_generated_method = "077D3EA3390394F9DED6EBBE5F213EF7")
        private int checkInterruptWhileWaiting(Node node) {
            addTaint(node.getTaint());
            int varC1AE5D8813CDE6238A1CD29E0E291926_161911300 = (Thread.interrupted() ?
                (transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT) :
                0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586824398 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586824398;
            // ---------- Original Method ----------
            //return Thread.interrupted() ?
                //(transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT) :
                //0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.407 -0400", hash_original_method = "5304D5C5F98F936C59A15960318DA98F", hash_generated_method = "6332C66033F7ABEFAF1D6EEF65DA116D")
        private void reportInterruptAfterWait(int interruptMode) throws InterruptedException {
            addTaint(interruptMode);
            if(interruptMode == THROW_IE)            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_1285030113 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_1285030113.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_1285030113;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.408 -0400", hash_original_method = "316B8F22454E74CF1A9F01045EC67EC6", hash_generated_method = "A768920FA27000B2CB5F3408DC8E48F5")
        public final void await() throws InterruptedException {
            if(Thread.interrupted())            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_1199502842 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_1199502842.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_1199502842;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.410 -0400", hash_original_method = "46C34832DD3406F7F3C664FF7A3A79B4", hash_generated_method = "C3A4E8299D30DC6B57B5FFCEB23124A9")
        public final long awaitNanos(long nanosTimeout) throws InterruptedException {
            addTaint(nanosTimeout);
            if(Thread.interrupted())            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_1842317331 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_1842317331.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_1842317331;
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
            long var57645198E102F4FE227A39824B6A9A42_1384457789 = (nanosTimeout - (System.nanoTime() - lastTime));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1529157187 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1529157187;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.411 -0400", hash_original_method = "9B6F9AFE5FC55A4D3153D2EEB76307B9", hash_generated_method = "34797F061184F1C2FB8CDE811EDCD554")
        public final boolean awaitUntil(Date deadline) throws InterruptedException {
            addTaint(deadline.getTaint());
            if(deadline == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_237889610 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_237889610.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_237889610;
            }
            long abstime = deadline.getTime();
            if(Thread.interrupted())            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_1006125453 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_1006125453.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_1006125453;
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
            boolean var3B93B8D4C8D03AB14C23D3E4B12FA84A_1910427950 = (!timedout);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432511655 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432511655;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.412 -0400", hash_original_method = "BFE4D71142E465ECC716594C0843F211", hash_generated_method = "5C4C3D34B169BEE8FB45F673C4EB5F9B")
        public final boolean await(long time, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(time);
            if(unit == null)            
            {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1303699243 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1303699243.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1303699243;
            }
            long nanosTimeout = unit.toNanos(time);
            if(Thread.interrupted())            
            {
            InterruptedException var1358A8E226367F12BB278428C2BEEE00_1027707509 = new InterruptedException();
            var1358A8E226367F12BB278428C2BEEE00_1027707509.addTaint(taint);
            throw var1358A8E226367F12BB278428C2BEEE00_1027707509;
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
            boolean var3B93B8D4C8D03AB14C23D3E4B12FA84A_2129672730 = (!timedout);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1595463852 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1595463852;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.418 -0400", hash_original_method = "165B5BC520C58D38E1ED3303B481AD06", hash_generated_method = "69C6A8E5F54A239A5B441A8AA47F02C9")
        final boolean isOwnedBy(AbstractQueuedSynchronizer sync) {
            addTaint(sync.getTaint());
            boolean var96786A6FAD3E7934374DCD0D0EDF1460_534988057 = (sync == AbstractQueuedSynchronizer.this);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_552550003 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_552550003;
            // ---------- Original Method ----------
            //return sync == AbstractQueuedSynchronizer.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.419 -0400", hash_original_method = "5570422C2D22E250B14B7FB8C176D89A", hash_generated_method = "FEFC5A4D60C129DFC63678C61217A0F8")
        protected final boolean hasWaiters() {
            if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_265655020 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_265655020.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_265655020;
            }
for(Node w = firstWaiter;w != null;w = w.nextWaiter)
            {
                if(w.waitStatus == Node.CONDITION)                
                {
                boolean varB326B5062B2F0E69046810717534CB09_749834282 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1491316595 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1491316595;
                }
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_2063245158 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1446198737 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1446198737;
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //for (Node w = firstWaiter; w != null; w = w.nextWaiter) {
                //if (w.waitStatus == Node.CONDITION)
                    //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.420 -0400", hash_original_method = "586699B2B19676C29FE19392CDC481BB", hash_generated_method = "D1AD93BE6CB7213FF89064F0B7A9A8F8")
        protected final int getWaitQueueLength() {
            if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_525442540 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_525442540.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_525442540;
            }
            int n = 0;
for(Node w = firstWaiter;w != null;w = w.nextWaiter)
            {
                if(w.waitStatus == Node.CONDITION)                
                ++n;
            } //End block
            int var7B8B965AD4BCA0E41AB51DE7B31363A1_689646307 = (n);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_398682928 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_398682928;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.421 -0400", hash_original_method = "D1136CB2B0FE173AD3F139F996FAE8B5", hash_generated_method = "E3578A10F8993467EB50DBDBA2E1DF25")
        protected final Collection<Thread> getWaitingThreads() {
            if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1766206711 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_1766206711.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_1766206711;
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
Collection<Thread> varED12C351C2E8CA4F85F097DDC7E77B4D_2024066347 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_2024066347.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_2024066347;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.421 -0400", hash_original_field = "C457B05B8D8DCF2333B7BE06BB3694B7", hash_generated_field = "C9096AAE36B16976484AF1C63AF46815")

        private static final long serialVersionUID = 1173984872572414699L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "D61A8CF122BE9E2755E208E71F14B796", hash_generated_field = "719C1717721B97867F5478A2BF8734E2")

        private static final int REINTERRUPT = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "26CBB60DE11931C6D9D95F685537FC92", hash_generated_field = "4348EF9055A3499985FF0B3F446F2BC1")

        private static final int THROW_IE = -1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "53B46295871253A108CBEAB47C328D22", hash_generated_field = "D0E32D39585FA118FF323BF7B8487515")

    private static final long serialVersionUID = 7373984972572414691L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "97826F3E2403B559BA27663CADCEE60A", hash_generated_field = "BFF11A71C399B3DB146FF1C739630A1D")

    static final long spinForTimeoutThreshold = 1000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "E7D465D52C267C4626E00B16AF4442B8")

    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "2C1DA28B2CFB5A4DCF7A56B1409A3B45", hash_generated_field = "162353053FFA573C2A47BACEC7C77131")

    private static long stateOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "949FBEE482BB8F9AF6BC94101DBBFA8B", hash_generated_field = "97CE09A29DB2EB713A48E047121081EE")

    private static long headOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "9AB0A3F42E66C0E1646CAE7D9DF99009", hash_generated_field = "8B58E2B37A159AAD83A5260C2F388DB2")

    private static long tailOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "FA3E7ECB1F7079FDF9ADC8AA71B67A14", hash_generated_field = "58D083123B9F4D91D47538963124B084")

    private static long waitStatusOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.422 -0400", hash_original_field = "AF712C58580FB5A2A86652706D04C24E", hash_generated_field = "94ADDD311D046BDDD72EC240B54C288D")

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

