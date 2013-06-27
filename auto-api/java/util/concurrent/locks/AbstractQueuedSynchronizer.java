package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import sun.misc.Unsafe;

public abstract class AbstractQueuedSynchronizer extends AbstractOwnableSynchronizer implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.480 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "C968564223BCE6AEFE8413EAB36A32B1")

    private transient volatile Node head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.480 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "AD93D08E1C37116EBC071C3224E8414A")

    private transient volatile Node tail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.480 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "40C4313E234E54E18DC2BFEA68F3E464")

    private volatile int state;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.486 -0400", hash_original_method = "C7F1FA27B1E7517E25F1C7951B5E8CA8", hash_generated_method = "D0F5CBC29675A9CABCA264BF6F7A7644")
    protected  AbstractQueuedSynchronizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.500 -0400", hash_original_method = "15A8F8E5739EB2961628EAE8F68BF29F", hash_generated_method = "2B9ACCE2F9EE3C3643F3CF9DFE01D99F")
    protected final int getState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219707303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219707303;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.500 -0400", hash_original_method = "57BE013BA515294E586014B30A336C04", hash_generated_method = "B9B29E2146A9DFA0E89C5BBC08072583")
    protected final void setState(int newState) {
        state = newState;
        // ---------- Original Method ----------
        //state = newState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.501 -0400", hash_original_method = "DF00243144DD556AB3E9A0ABE3AEC78F", hash_generated_method = "9F32D87D996090497F9541FB25F4B4C7")
    protected final boolean compareAndSetState(int expect, int update) {
        boolean var281C41540058F29F0DB0A762C52DDE13_1369364646 = (unsafe.compareAndSwapInt(this, stateOffset, expect, update));
        addTaint(expect);
        addTaint(update);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1793793597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1793793597;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.506 -0400", hash_original_method = "D115C79C5FCCB59668763118EBD8CBBB", hash_generated_method = "E19712ABC23F2C4DF7C54CF394C4EFA1")
    private Node enq(final Node node) {
        Node varB4EAC82CA7396A68D541C85D26508E83_508949716 = null; //Variable for return #1
        {
            Node t;
            t = tail;
            {
                {
                    boolean varC2BD7D899FDAEA316177871081826EFD_1781931360 = (compareAndSetHead(new Node()));
                    tail = head;
                } //End collapsed parenthetic
            } //End block
            {
                node.prev = t;
                {
                    boolean var30CFF97C04D4F21E508F35AC3CDBADC7_456469573 = (compareAndSetTail(t, node));
                    {
                        t.next = node;
                        varB4EAC82CA7396A68D541C85D26508E83_508949716 = t;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(node.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_508949716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_508949716;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.511 -0400", hash_original_method = "7269E5EC16B8883F661BF745CCC5E6A6", hash_generated_method = "04AB16BE9CFC76A0FC1D724462A741E2")
    private Node addWaiter(Node mode) {
        Node varB4EAC82CA7396A68D541C85D26508E83_479904897 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1525170591 = null; //Variable for return #2
        Node node;
        node = new Node(Thread.currentThread(), mode);
        Node pred;
        pred = tail;
        {
            node.prev = pred;
            {
                boolean varB759FEC06526555CC952C851C67B8004_533319421 = (compareAndSetTail(pred, node));
                {
                    pred.next = node;
                    varB4EAC82CA7396A68D541C85D26508E83_479904897 = node;
                } //End block
            } //End collapsed parenthetic
        } //End block
        enq(node);
        varB4EAC82CA7396A68D541C85D26508E83_1525170591 = node;
        addTaint(mode.getTaint());
        Node varA7E53CE21691AB073D9660D615818899_1276144694; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1276144694 = varB4EAC82CA7396A68D541C85D26508E83_479904897;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1276144694 = varB4EAC82CA7396A68D541C85D26508E83_1525170591;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1276144694.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1276144694;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.530 -0400", hash_original_method = "51AEDFDDD323C78EE2EC4A6DE568B8D1", hash_generated_method = "E532E4CBBEBFF44C610D0F95E73E8319")
    private void setHead(Node node) {
        head = node;
        node.thread = null;
        node.prev = null;
        // ---------- Original Method ----------
        //head = node;
        //node.thread = null;
        //node.prev = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.531 -0400", hash_original_method = "F262A3A18BABECF7EC492736953EAF6E", hash_generated_method = "C9181C0068185A6AC06006E82F0F664E")
    private void unparkSuccessor(Node node) {
        int ws;
        ws = node.waitStatus;
        compareAndSetWaitStatus(node, ws, 0);
        Node s;
        s = node.next;
        {
            s = null;
            {
                Node t;
                t = tail;
                t = t.prev;
                s = t;
            } //End collapsed parenthetic
        } //End block
        LockSupport.unpark(s.thread);
        addTaint(node.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.533 -0400", hash_original_method = "D8D55646997B45206CD2F0528B603753", hash_generated_method = "D0BC2DE141D5975E3A86249009CA87FE")
    private void doReleaseShared() {
        {
            Node h;
            h = head;
            {
                int ws;
                ws = h.waitStatus;
                {
                    {
                        boolean varCC865867FC8DEDE4843F9E3D62245755_296260286 = (!compareAndSetWaitStatus(h, Node.SIGNAL, 0));
                    } //End collapsed parenthetic
                    unparkSuccessor(h);
                } //End block
                {
                    boolean var658C7F41A73D231A5E38D15A1070790F_2056312120 = (ws == 0 &&
                         !compareAndSetWaitStatus(h, 0, Node.PROPAGATE));
                } //End collapsed parenthetic
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.558 -0400", hash_original_method = "A2FB30DAE399AEFA487E20396027BD36", hash_generated_method = "5CEE0CE65E015959ACDE5D62BEB51E93")
    private void setHeadAndPropagate(Node node, int propagate) {
        Node h;
        h = head;
        setHead(node);
        {
            Node s;
            s = node.next;
            {
                boolean varB6D0E63ACFCFA5DA33C33F91435930F9_1057220325 = (s == null || s.isShared());
                doReleaseShared();
            } //End collapsed parenthetic
        } //End block
        addTaint(node.getTaint());
        addTaint(propagate);
        // ---------- Original Method ----------
        //Node h = head;
        //setHead(node);
        //if (propagate > 0 || h == null || h.waitStatus < 0) {
            //Node s = node.next;
            //if (s == null || s.isShared())
                //doReleaseShared();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.561 -0400", hash_original_method = "1CA41B58715410C4216B9DE6C43BB9D4", hash_generated_method = "97EF5D6A942201DDFC5576504B61C16F")
    private void cancelAcquire(Node node) {
        node.thread = null;
        Node pred;
        pred = node.prev;
        node.prev = pred = pred.prev;
        Node predNext;
        predNext = pred.next;
        node.waitStatus = Node.CANCELLED;
        {
            boolean var9C67AE94C69ECBB4560E786F86E10C76_179837468 = (node == tail && compareAndSetTail(node, pred));
            {
                compareAndSetNext(pred, predNext, null);
            } //End block
            {
                int ws;
                {
                    boolean var806CB84C61F87A678A0A252FCBFAAB06_1691064481 = (pred != head &&
                ((ws = pred.waitStatus) == Node.SIGNAL ||
                 (ws <= 0 && compareAndSetWaitStatus(pred, ws, Node.SIGNAL))) &&
                pred.thread != null);
                    {
                        Node next;
                        next = node.next;
                        compareAndSetNext(pred, predNext, next);
                    } //End block
                    {
                        unparkSuccessor(node);
                    } //End block
                } //End collapsed parenthetic
                node.next = node;
            } //End block
        } //End collapsed parenthetic
        addTaint(node.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
        private static void selfInterrupt() {
        Thread.currentThread().interrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.562 -0400", hash_original_method = "C551D5FD0C0A2C72DAD755E48C68905F", hash_generated_method = "F832F34AB38B7350053172352A8DFD06")
    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        boolean var17A536D12FEB0466CF9F0EDC1509A805_1320671067 = (Thread.interrupted());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282852283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282852283;
        // ---------- Original Method ----------
        //LockSupport.park(this);
        //return Thread.interrupted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.587 -0400", hash_original_method = "0D7553B7A8DFDAC7C355CECFA0DBF574", hash_generated_method = "41758C81885F0C935EC76D0472409482")
    final boolean acquireQueued(final Node node, int arg) {
        boolean failed;
        failed = true;
        try 
        {
            boolean interrupted;
            interrupted = false;
            {
                Node p;
                p = node.predecessor();
                {
                    boolean varB702A2D695A14FF8E8F201BF2E513471_2081972552 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_596158587 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    interrupted = true;
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        addTaint(node.getTaint());
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045631830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045631830;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.588 -0400", hash_original_method = "E74C4677EAF9B6C97A4A9A93D88FC71E", hash_generated_method = "9CA6E64FEF1D7960A32E5C786C0D96BD")
    private void doAcquireInterruptibly(int arg) throws InterruptedException {
        Node node;
        node = addWaiter(Node.EXCLUSIVE);
        boolean failed;
        failed = true;
        try 
        {
            {
                Node p;
                p = node.predecessor();
                {
                    boolean varB702A2D695A14FF8E8F201BF2E513471_1383810849 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_40490507 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        addTaint(arg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.607 -0400", hash_original_method = "AF980EBAC4BC6C4AB1174BED3B10073B", hash_generated_method = "34F2FC1C51C80A740D5D9397DC9C356F")
    private boolean doAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
        long lastTime;
        lastTime = System.nanoTime();
        Node node;
        node = addWaiter(Node.EXCLUSIVE);
        boolean failed;
        failed = true;
        try 
        {
            {
                Node p;
                p = node.predecessor();
                {
                    boolean varB702A2D695A14FF8E8F201BF2E513471_1154934531 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var00B5F1835D8E1D445CE64BB60FAD1503_1138988856 = (shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold);
                    LockSupport.parkNanos(this, nanosTimeout);
                } //End collapsed parenthetic
                long now;
                now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                {
                    boolean varFDD1D09D0FE11E5BCA86E55DE77A8E11_1801866809 = (Thread.interrupted());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        addTaint(arg);
        addTaint(nanosTimeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005978087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005978087;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.608 -0400", hash_original_method = "D66678B4038334D8E14600B3A8FC8FD7", hash_generated_method = "F709FE35D33053515B0889C8D1283446")
    private void doAcquireShared(int arg) {
        Node node;
        node = addWaiter(Node.SHARED);
        boolean failed;
        failed = true;
        try 
        {
            boolean interrupted;
            interrupted = false;
            {
                Node p;
                p = node.predecessor();
                {
                    int r;
                    r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        selfInterrupt();
                        failed = false;
                    } //End block
                } //End block
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_1792377699 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    interrupted = true;
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        addTaint(arg);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.613 -0400", hash_original_method = "4E093FA1B6FCF5593272CE0DEA00D69B", hash_generated_method = "AF6E0547AC95D5AAA9D88C8377560609")
    private void doAcquireSharedInterruptibly(int arg) throws InterruptedException {
        Node node;
        node = addWaiter(Node.SHARED);
        boolean failed;
        failed = true;
        try 
        {
            {
                Node p;
                p = node.predecessor();
                {
                    int r;
                    r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End block
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_566221206 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        addTaint(arg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.630 -0400", hash_original_method = "873D99639E9E59C87CD3A574B36E4573", hash_generated_method = "6573B5ABED777261A7EA5B03C97CA327")
    private boolean doAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
        long lastTime;
        lastTime = System.nanoTime();
        Node node;
        node = addWaiter(Node.SHARED);
        boolean failed;
        failed = true;
        try 
        {
            {
                Node p;
                p = node.predecessor();
                {
                    int r;
                    r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End block
                {
                    boolean var00B5F1835D8E1D445CE64BB60FAD1503_1911498435 = (shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold);
                    LockSupport.parkNanos(this, nanosTimeout);
                } //End collapsed parenthetic
                long now;
                now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                {
                    boolean varFDD1D09D0FE11E5BCA86E55DE77A8E11_1903842464 = (Thread.interrupted());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        addTaint(arg);
        addTaint(nanosTimeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529558195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_529558195;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.630 -0400", hash_original_method = "FADA99D99649E8B049B596B89A86AFE3", hash_generated_method = "AD95379647F485246D8586E361644A21")
    protected boolean tryAcquire(int arg) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_597689687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_597689687;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.631 -0400", hash_original_method = "0AA9B3926B88397CF769442818D9CA16", hash_generated_method = "C63F007EC1D23C2D12B5B15155B2A521")
    protected boolean tryRelease(int arg) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1158900056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1158900056;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.631 -0400", hash_original_method = "143AB2DE4C7A8CA8F45FD3C862AFB93B", hash_generated_method = "9CABE5EB148893B81688228573602D49")
    protected int tryAcquireShared(int arg) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(arg);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332653003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332653003;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.631 -0400", hash_original_method = "57760B0E19163CFD26451EB4C702B2B7", hash_generated_method = "D06094FA22CB7C7B1E53016714639B87")
    protected boolean tryReleaseShared(int arg) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1587869852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1587869852;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.645 -0400", hash_original_method = "B1A3EF7BA2A74EEB6B3236F0A99ED9FE", hash_generated_method = "5C124A998F6FCD0CBEEABF074EF94437")
    protected boolean isHeldExclusively() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788278051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788278051;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.646 -0400", hash_original_method = "10DE26F4AB94E5F1867D5F821F4BF0D7", hash_generated_method = "97EA8BB3AC1F290A93FDDAAE6F10131C")
    public final void acquire(int arg) {
        {
            boolean varFCEF5DD222F9CABA3FDCCFE99D21AA7A_384799343 = (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg));
            selfInterrupt();
        } //End collapsed parenthetic
        addTaint(arg);
        // ---------- Original Method ----------
        //if (!tryAcquire(arg) &&
            //acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            //selfInterrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.647 -0400", hash_original_method = "34DE0EEECFCC486100F3F952023E1D48", hash_generated_method = "8DE1F701243E616A3B51E35A484CF10C")
    public final void acquireInterruptibly(int arg) throws InterruptedException {
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1762236790 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        {
            boolean var6C80CD83DDCC36721F42CDF9EFE1FC97_1454107214 = (!tryAcquire(arg));
            doAcquireInterruptibly(arg);
        } //End collapsed parenthetic
        addTaint(arg);
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (!tryAcquire(arg))
            //doAcquireInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.648 -0400", hash_original_method = "C2BC4409CE226EEA6D2598B40FA64E1C", hash_generated_method = "3B1304E6CEEC1802DD5DEAEAD267CA08")
    public final boolean tryAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1893691860 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        boolean var34DCAB88C8A0F240E32D599EDB2FE196_1828090455 = (tryAcquire(arg) ||
            doAcquireNanos(arg, nanosTimeout));
        addTaint(arg);
        addTaint(nanosTimeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919992709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_919992709;
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquire(arg) ||
            //doAcquireNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.649 -0400", hash_original_method = "482847B9E820B21E98E389768A5050E4", hash_generated_method = "3C7B3E69F6D283E75F37C25354773A13")
    public final boolean release(int arg) {
        {
            boolean varFF82B8E2BC2E04000CA63D87A88AB8D2_1174318144 = (tryRelease(arg));
            {
                Node h;
                h = head;
                unparkSuccessor(h);
            } //End block
        } //End collapsed parenthetic
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910800037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_910800037;
        // ---------- Original Method ----------
        //if (tryRelease(arg)) {
            //Node h = head;
            //if (h != null && h.waitStatus != 0)
                //unparkSuccessor(h);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.650 -0400", hash_original_method = "503864E706CF656D09684EB1E461773D", hash_generated_method = "B6EF4E4DD28EA48FBA5740AE0428346A")
    public final void acquireShared(int arg) {
        {
            boolean varE24C999E8142A86B0EF4E6AFA805A8A0_983956429 = (tryAcquireShared(arg) < 0);
            doAcquireShared(arg);
        } //End collapsed parenthetic
        addTaint(arg);
        // ---------- Original Method ----------
        //if (tryAcquireShared(arg) < 0)
            //doAcquireShared(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.650 -0400", hash_original_method = "10425BDCE3B0F2DAA2E0ECCAD9B4BACD", hash_generated_method = "A14F5F0FB19757FC22A30480AA48F3DB")
    public final void acquireSharedInterruptibly(int arg) throws InterruptedException {
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_434318873 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        {
            boolean varE24C999E8142A86B0EF4E6AFA805A8A0_1731585634 = (tryAcquireShared(arg) < 0);
            doAcquireSharedInterruptibly(arg);
        } //End collapsed parenthetic
        addTaint(arg);
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (tryAcquireShared(arg) < 0)
            //doAcquireSharedInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.677 -0400", hash_original_method = "34AA5C57E6BB40898FDB5D4BB2EF37C3", hash_generated_method = "2F7A06D737E57C3A054A2383BA1C0228")
    public final boolean tryAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_257324671 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        boolean varE4B1D6DE7AE03DFEE28CA37F75A87EB4_805118935 = (tryAcquireShared(arg) >= 0 ||
            doAcquireSharedNanos(arg, nanosTimeout));
        addTaint(arg);
        addTaint(nanosTimeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1291624437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1291624437;
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquireShared(arg) >= 0 ||
            //doAcquireSharedNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.678 -0400", hash_original_method = "64AF2599D3C05FF36535D67856367D8D", hash_generated_method = "02540EFC84AB456694B22EEC0B6A10D1")
    public final boolean releaseShared(int arg) {
        {
            boolean varEB9480595F3C382515F926391F6AAE14_1200620128 = (tryReleaseShared(arg));
            {
                doReleaseShared();
            } //End block
        } //End collapsed parenthetic
        addTaint(arg);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179204405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179204405;
        // ---------- Original Method ----------
        //if (tryReleaseShared(arg)) {
            //doReleaseShared();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.678 -0400", hash_original_method = "3ACA5092770D7AD1442898AF3B627DFE", hash_generated_method = "0B0DB9655D51CD8B8723A6C646B02871")
    public final boolean hasQueuedThreads() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2019088034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2019088034;
        // ---------- Original Method ----------
        //return head != tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.679 -0400", hash_original_method = "3ED9D0D071477B613E998B33D61DD4C5", hash_generated_method = "2D26B16A11C9505D96B3C7464625256F")
    public final boolean hasContended() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1220494216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1220494216;
        // ---------- Original Method ----------
        //return head != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.680 -0400", hash_original_method = "DB23AE447B60E978D848F5CEAEC8257B", hash_generated_method = "31F953EF746A98173B3B5057CA6EB91C")
    public final Thread getFirstQueuedThread() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_521671943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_521671943 = (head == tail) ? null : fullGetFirstQueuedThread();
        varB4EAC82CA7396A68D541C85D26508E83_521671943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_521671943;
        // ---------- Original Method ----------
        //return (head == tail) ? null : fullGetFirstQueuedThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.687 -0400", hash_original_method = "18818CB637EBC5CF82DC4C50B37FB17C", hash_generated_method = "3FF9D5DBAAB6359FDACFFCA5908BB3E4")
    private Thread fullGetFirstQueuedThread() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_1017270441 = null; //Variable for return #1
        Thread varB4EAC82CA7396A68D541C85D26508E83_2095762922 = null; //Variable for return #2
        Node h, s;
        Thread st;
        {
            boolean varAB96948AFE2AAAF3BBF624BD73ABA985_1601266452 = (((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null) ||
            ((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null));
            varB4EAC82CA7396A68D541C85D26508E83_1017270441 = st;
        } //End collapsed parenthetic
        Node t;
        t = tail;
        Thread firstThread;
        firstThread = null;
        {
            Thread tt;
            tt = t.thread;
            firstThread = tt;
            t = t.prev;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2095762922 = firstThread;
        Thread varA7E53CE21691AB073D9660D615818899_806814071; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_806814071 = varB4EAC82CA7396A68D541C85D26508E83_1017270441;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_806814071 = varB4EAC82CA7396A68D541C85D26508E83_2095762922;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_806814071.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_806814071;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.689 -0400", hash_original_method = "1573E83A14D593E0BFADABB9AEDBB7D2", hash_generated_method = "1798BFB7158D060AAE71D14AB749BB70")
    public final boolean isQueued(Thread thread) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            Node p;
            p = tail;
            p = p.prev;
        } //End collapsed parenthetic
        addTaint(thread.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014133088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014133088;
        // ---------- Original Method ----------
        //if (thread == null)
            //throw new NullPointerException();
        //for (Node p = tail; p != null; p = p.prev)
            //if (p.thread == thread)
                //return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.691 -0400", hash_original_method = "4993AFB2E466C494E10B5DA4780E51AB", hash_generated_method = "60F0BA2E1BD877F7C764158A67D7A6EA")
    final boolean apparentlyFirstQueuedIsExclusive() {
        Node h, s;
        boolean var7A2694C8A18196F041BDCF2FCD7324AE_1110841113 = ((h = head) != null &&
            (s = h.next)  != null &&
            !s.isShared()         &&
            s.thread != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658001440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658001440;
        // ---------- Original Method ----------
        //Node h, s;
        //return (h = head) != null &&
            //(s = h.next)  != null &&
            //!s.isShared()         &&
            //s.thread != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.696 -0400", hash_original_method = "155F6B01F514C41CA8367710346D37E3", hash_generated_method = "3C018EB23C219E6CFDB7693BCB589DC2")
    public final boolean hasQueuedPredecessors() {
        Node t;
        t = tail;
        Node h;
        h = head;
        Node s;
        boolean var4B72E4D0E536DE6B3ACB8283BCD4F664_1405206715 = (h != t &&
            ((s = h.next) == null || s.thread != Thread.currentThread()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790369326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790369326;
        // ---------- Original Method ----------
        //Node t = tail;
        //Node h = head;
        //Node s;
        //return h != t &&
            //((s = h.next) == null || s.thread != Thread.currentThread());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.698 -0400", hash_original_method = "65AB677A04652631BF1CC269A789F93A", hash_generated_method = "ACD5D747CD28205A87511E14584A0F50")
    public final int getQueueLength() {
        int n;
        n = 0;
        {
            Node p;
            p = tail;
            p = p.prev;
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067283552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067283552;
        // ---------- Original Method ----------
        //int n = 0;
        //for (Node p = tail; p != null; p = p.prev) {
            //if (p.thread != null)
                //++n;
        //}
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.707 -0400", hash_original_method = "BA97C075FB0E9B39CEF398B585209CAD", hash_generated_method = "43214403CCF885424A2E1493BDA4C578")
    public final Collection<Thread> getQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_240396454 = null; //Variable for return #1
        ArrayList<Thread> list;
        list = new ArrayList<Thread>();
        {
            Node p;
            p = tail;
            p = p.prev;
            {
                Thread t;
                t = p.thread;
                list.add(t);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_240396454 = list;
        varB4EAC82CA7396A68D541C85D26508E83_240396454.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_240396454;
        // ---------- Original Method ----------
        //ArrayList<Thread> list = new ArrayList<Thread>();
        //for (Node p = tail; p != null; p = p.prev) {
            //Thread t = p.thread;
            //if (t != null)
                //list.add(t);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.709 -0400", hash_original_method = "8F9C05C78C38CDEC6B94C7386A00C30C", hash_generated_method = "885E19395B05A0618F6C42F9EBE8472A")
    public final Collection<Thread> getExclusiveQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1210776357 = null; //Variable for return #1
        ArrayList<Thread> list;
        list = new ArrayList<Thread>();
        {
            Node p;
            p = tail;
            p = p.prev;
            {
                {
                    boolean varDFA54A0E0CB503BCC5CE98449AAB2A08_1688157675 = (!p.isShared());
                    {
                        Thread t;
                        t = p.thread;
                        list.add(t);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1210776357 = list;
        varB4EAC82CA7396A68D541C85D26508E83_1210776357.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1210776357;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.739 -0400", hash_original_method = "3B2BC348731488178C75B0F7C3256BE4", hash_generated_method = "480A64A74364D47A404FC2B15A5FFFA1")
    public final Collection<Thread> getSharedQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_754967988 = null; //Variable for return #1
        ArrayList<Thread> list;
        list = new ArrayList<Thread>();
        {
            Node p;
            p = tail;
            p = p.prev;
            {
                {
                    boolean varC6C07EC060C76D1E58FED758F007D903_1917359421 = (p.isShared());
                    {
                        Thread t;
                        t = p.thread;
                        list.add(t);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_754967988 = list;
        varB4EAC82CA7396A68D541C85D26508E83_754967988.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_754967988;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.740 -0400", hash_original_method = "2C49C090DBE6788B4A91D995132AEECA", hash_generated_method = "73A5FBD6B7348A38EE8F52B1E5615955")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1806080208 = null; //Variable for return #1
        int s;
        s = getState();
        String q;
        boolean var58703E822CB7EE24CF8A625587E1C63E_251262201 = (hasQueuedThreads());
        q = "non";
        q = "";
        varB4EAC82CA7396A68D541C85D26508E83_1806080208 = super.toString() +
            "[State = " + s + ", " + q + "empty queue]";
        varB4EAC82CA7396A68D541C85D26508E83_1806080208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1806080208;
        // ---------- Original Method ----------
        //int s = getState();
        //String q  = hasQueuedThreads() ? "non" : "";
        //return super.toString() +
            //"[State = " + s + ", " + q + "empty queue]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.740 -0400", hash_original_method = "0981A7B7481B56654552F826D97FC7A4", hash_generated_method = "8E5CC7D2E8F6884CE127FD98DA19C804")
    final boolean isOnSyncQueue(Node node) {
        boolean varF3A4D6770CAC1AA85AF3A6C51812BE70_1773739365 = (findNodeFromTail(node));
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961691916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961691916;
        // ---------- Original Method ----------
        //if (node.waitStatus == Node.CONDITION || node.prev == null)
            //return false;
        //if (node.next != null) 
            //return true;
        //return findNodeFromTail(node);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.742 -0400", hash_original_method = "E84A510853D9F9659F34649D5E631E14", hash_generated_method = "3C5F30E274E83CD59545CB670ADBE208")
    private boolean findNodeFromTail(Node node) {
        Node t;
        t = tail;
        {
            t = t.prev;
        } //End block
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1138214217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1138214217;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.744 -0400", hash_original_method = "AC7EB2A7C3E5842E27808853E2EADEA4", hash_generated_method = "69689614D163FA667B729CD90CAE72C0")
    final boolean transferForSignal(Node node) {
        {
            boolean var8F78D6E41179A92913D59E278DAF4713_1159495620 = (!compareAndSetWaitStatus(node, Node.CONDITION, 0));
        } //End collapsed parenthetic
        Node p;
        p = enq(node);
        int ws;
        ws = p.waitStatus;
        {
            boolean var11909F9DE762D0C62EFBB539D3DF08AB_1823809300 = (ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL));
            LockSupport.unpark(node.thread);
        } //End collapsed parenthetic
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1706791356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1706791356;
        // ---------- Original Method ----------
        //if (!compareAndSetWaitStatus(node, Node.CONDITION, 0))
            //return false;
        //Node p = enq(node);
        //int ws = p.waitStatus;
        //if (ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL))
            //LockSupport.unpark(node.thread);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.744 -0400", hash_original_method = "202AE2159172221E521994FECA693914", hash_generated_method = "1825A8E13C3873EBE0263038EA91D242")
    final boolean transferAfterCancelledWait(Node node) {
        {
            boolean varAB52CB6F165D0797C877670E5EE00069_1594796343 = (compareAndSetWaitStatus(node, Node.CONDITION, 0));
            {
                enq(node);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA5ECD06A31929CB111AEF5ECED825AFB_134574006 = (!isOnSyncQueue(node));
            Thread.yield();
        } //End collapsed parenthetic
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415494672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415494672;
        // ---------- Original Method ----------
        //if (compareAndSetWaitStatus(node, Node.CONDITION, 0)) {
            //enq(node);
            //return true;
        //}
        //while (!isOnSyncQueue(node))
            //Thread.yield();
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.745 -0400", hash_original_method = "13260C05A29655F6FC8F2FA182B20EC8", hash_generated_method = "DDD64ECE56B33F19F0E287EA914A9A24")
    final int fullyRelease(Node node) {
        boolean failed;
        failed = true;
        try 
        {
            int savedState;
            savedState = getState();
            {
                boolean var3C6705464C8EDF86A554C3C7455FE111_638815995 = (release(savedState));
                {
                    failed = false;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            node.waitStatus = Node.CANCELLED;
        } //End block
        addTaint(node.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744950900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744950900;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.762 -0400", hash_original_method = "B60D02054E03A30F41C10CC4F7B33B2F", hash_generated_method = "B85412188B2AE01D5F0B1EF922B3EB30")
    public final boolean owns(ConditionObject condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        boolean var81F8FCB295780CD2D5751E1181CC9428_1374024211 = (condition.isOwnedBy(this));
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_380844681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_380844681;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //return condition.isOwnedBy(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.762 -0400", hash_original_method = "B87CA02CD99C2C81A6ADCC153DE8BF7D", hash_generated_method = "3B1572C9D830ACF6E5FE2ECE5FE57746")
    public final boolean hasWaiters(ConditionObject condition) {
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_1606536984 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } //End collapsed parenthetic
        boolean var335079E40CDAA9EFDA14CFAFE44A0835_578354494 = (condition.hasWaiters());
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794853435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_794853435;
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.hasWaiters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.763 -0400", hash_original_method = "FDFBF2604A26737643DD133E9F8A257F", hash_generated_method = "C1CABDA7DB10A16390B91ADBA5436416")
    public final int getWaitQueueLength(ConditionObject condition) {
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_1678572731 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } //End collapsed parenthetic
        int var5991F4798FCDE9B9D32781CE8A86C9C1_2095721419 = (condition.getWaitQueueLength());
        addTaint(condition.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215486763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215486763;
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.763 -0400", hash_original_method = "70972013E049E7504ADBD56143485C77", hash_generated_method = "B9890F97CE85293C5EB86C9E0ED67304")
    public final Collection<Thread> getWaitingThreads(ConditionObject condition) {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1991527354 = null; //Variable for return #1
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_229958746 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1991527354 = condition.getWaitingThreads();
        addTaint(condition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1991527354.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1991527354;
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitingThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.764 -0400", hash_original_method = "20D2259271C7B1C96C133ACBD2C26B14", hash_generated_method = "CF1888AEDF5E6E5E236BBBD616674F5A")
    private final boolean compareAndSetHead(Node update) {
        boolean var7C9BAC36D5138868FE92F3C1948386AB_1978441876 = (unsafe.compareAndSwapObject(this, headOffset, null, update));
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641451089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_641451089;
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.764 -0400", hash_original_method = "8C47C531A43F622294BF6051B04C8993", hash_generated_method = "9E8C3EC96C5AFAC6BF3941A9647E8FD3")
    private final boolean compareAndSetTail(Node expect, Node update) {
        boolean varC5CCFD292C10D03F1C8C777B8815D2E2_946045777 = (unsafe.compareAndSwapObject(this, tailOffset, expect, update));
        addTaint(expect.getTaint());
        addTaint(update.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1601479382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1601479382;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.770 -0400", hash_original_field = "282F56A6C3233E93D5BACF05B9AA8876", hash_generated_field = "4D5292AE19E73CB6BC72A4A4EE34646D")

        volatile int waitStatus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.770 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "CE4F99BFA9BE83062548109E0A80EB36")

        volatile Node prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.770 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "495F81DE1A0BB70B1CC0F10199933490")

        volatile Node next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.770 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3347E7A3168C0A597DE966A2AEA728E2")

        volatile Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.770 -0400", hash_original_field = "1F76D737B407F4A2AD51A0EFEB508D50", hash_generated_field = "EE921616C37FFDDFA9B9DA84ABF34675")

        Node nextWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.770 -0400", hash_original_method = "2DD8BF5485F2495811D83404AF44A29C", hash_generated_method = "AAE5751DE21B256CB4EDD0DDB605F24E")
          Node() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.771 -0400", hash_original_method = "764EF23A3C66C99D5E5160039F46E6BD", hash_generated_method = "2CAC145FA8BF94E846C302C88AD33F87")
          Node(Thread thread, Node mode) {
            this.nextWaiter = mode;
            this.thread = thread;
            // ---------- Original Method ----------
            //this.nextWaiter = mode;
            //this.thread = thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.771 -0400", hash_original_method = "5118904E6021AE155CDFF15DB609BD48", hash_generated_method = "4FCE7CEF63C545859A3D7EF41D2DEAC9")
          Node(Thread thread, int waitStatus) {
            this.waitStatus = waitStatus;
            this.thread = thread;
            // ---------- Original Method ----------
            //this.waitStatus = waitStatus;
            //this.thread = thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.771 -0400", hash_original_method = "EA506AD78E2AE8ACF234FE0610B9A575", hash_generated_method = "7114BD8BEE09712984EA5A0DF02956DB")
        final boolean isShared() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572085524 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_572085524;
            // ---------- Original Method ----------
            //return nextWaiter == SHARED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_method = "7AA5CFB77F71DE2C6FFA937BCE62ADAE", hash_generated_method = "1ADCD161C336C475719B6FEE49C07556")
        final Node predecessor() throws NullPointerException {
            Node varB4EAC82CA7396A68D541C85D26508E83_376356728 = null; //Variable for return #1
            Node p;
            p = prev;
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            varB4EAC82CA7396A68D541C85D26508E83_376356728 = p;
            varB4EAC82CA7396A68D541C85D26508E83_376356728.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_376356728;
            // ---------- Original Method ----------
            //Node p = prev;
            //if (p == null)
                //throw new NullPointerException();
            //else
                //return p;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_field = "29B93CAC7244964D7B989712BB2AAA8F", hash_generated_field = "727F9F6BFDF717C2C1ADDE5A4C8257ED")

        static Node SHARED = new Node();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_field = "F427D28BCA700281DA9D02E201499452", hash_generated_field = "B75102F39F2BCCCFE433EF4078A9A66E")

        static Node EXCLUSIVE = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_field = "988DB81EC2397AB0D5457DF07B87908A", hash_generated_field = "7FFEF5021D569A93664EC6AE3A8F1226")

        static int CANCELLED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_field = "1B171CE64A08A97E810AC0B2A481548E", hash_generated_field = "7B3D6676327228E38E6D7AC1A3667693")

        static int SIGNAL = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_field = "EC24A5598A6130CF31D6F9BEF244C4A1", hash_generated_field = "D553E77A6370D735D8CCBF1C9C1F264E")

        static int CONDITION = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_field = "2F582260408474C896C524B277DB2733", hash_generated_field = "FEA4109D7FA85D53FE708BF91AC66367")

        static int PROPAGATE = -3;
    }


    
    public class ConditionObject implements Condition, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_field = "CD495CA7D725FEED43A3FB720F4B8EC1", hash_generated_field = "65A161514F134134E9F0B478EBDE5ED3")

        private transient Node firstWaiter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_field = "8BDF0C40F706950EC229FBE0007BC4E3", hash_generated_field = "2A9616AEC7221DB00588D39E0457BC79")

        private transient Node lastWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.772 -0400", hash_original_method = "0A3E2C1E27BAEA738FDF96AD17500BEE", hash_generated_method = "6AF9B0E3D406E6C56AA07F09E795B0E2")
        public  ConditionObject() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.774 -0400", hash_original_method = "43F5E066353E431B2C9AD7CD0397BCCF", hash_generated_method = "7BE642C0E45CB42BF6BBC4BB732E43FE")
        private Node addConditionWaiter() {
            Node varB4EAC82CA7396A68D541C85D26508E83_76876501 = null; //Variable for return #1
            Node t;
            t = lastWaiter;
            {
                unlinkCancelledWaiters();
                t = lastWaiter;
            } //End block
            Node node;
            node = new Node(Thread.currentThread(), Node.CONDITION);
            firstWaiter = node;
            t.nextWaiter = node;
            lastWaiter = node;
            varB4EAC82CA7396A68D541C85D26508E83_76876501 = node;
            varB4EAC82CA7396A68D541C85D26508E83_76876501.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_76876501;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.778 -0400", hash_original_method = "74B8316ED8B5F40365D8BD9CF002AB2D", hash_generated_method = "D2B99BC6185BF2CA30FA5853B6E9EB41")
        private void doSignal(Node first) {
            {
                {
                    boolean varBC585BCE36C017A7C94055DA929092A7_1986203649 = ((firstWaiter = first.nextWaiter) == null);
                    lastWaiter = null;
                } //End collapsed parenthetic
                first.nextWaiter = null;
            } //End block
            {
                boolean var608C6B17E7E10DD5072B7876717FB9A1_804851775 = (!transferForSignal(first) &&
                     (first = firstWaiter) != null);
            } //End collapsed parenthetic
            addTaint(first.getTaint());
            // ---------- Original Method ----------
            //do {
                //if ( (firstWaiter = first.nextWaiter) == null)
                    //lastWaiter = null;
                //first.nextWaiter = null;
            //} while (!transferForSignal(first) &&
                     //(first = firstWaiter) != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.793 -0400", hash_original_method = "DE4F68C515AD9FDEF86DCFCC83AF390E", hash_generated_method = "462C27DBCEE920EF4643B4FD730BCF85")
        private void doSignalAll(Node first) {
            lastWaiter = firstWaiter = null;
            {
                Node next;
                next = first.nextWaiter;
                first.nextWaiter = null;
                transferForSignal(first);
                first = next;
            } //End block
            addTaint(first.getTaint());
            // ---------- Original Method ----------
            //lastWaiter = firstWaiter = null;
            //do {
                //Node next = first.nextWaiter;
                //first.nextWaiter = null;
                //transferForSignal(first);
                //first = next;
            //} while (first != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.794 -0400", hash_original_method = "2AF991EC026F340CB09E7C74A01E5A9A", hash_generated_method = "3356A25D8D13BF5A01088971CA423629")
        private void unlinkCancelledWaiters() {
            Node t;
            t = firstWaiter;
            Node trail;
            trail = null;
            {
                Node next;
                next = t.nextWaiter;
                {
                    t.nextWaiter = null;
                    firstWaiter = next;
                    trail.nextWaiter = next;
                    lastWaiter = trail;
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.795 -0400", hash_original_method = "217DDC96D1B25C0D1457937D523A3AA4", hash_generated_method = "1B50595635DE7101B7DC284818E743B5")
        public final void signal() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1165531634 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            Node first;
            first = firstWaiter;
            doSignal(first);
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //Node first = firstWaiter;
            //if (first != null)
                //doSignal(first);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.795 -0400", hash_original_method = "8098E0901B1513A38FF0251B40A20DA9", hash_generated_method = "3846A149C91E200F155C3556AC151B38")
        public final void signalAll() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1879993977 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            Node first;
            first = firstWaiter;
            doSignalAll(first);
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //Node first = firstWaiter;
            //if (first != null)
                //doSignalAll(first);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.796 -0400", hash_original_method = "03B567BE1E70F2310FD90D1C09544B27", hash_generated_method = "BDBDF1437E1675A9690F87AE56FD1F2A")
        public final void awaitUninterruptibly() {
            Node node;
            node = addConditionWaiter();
            int savedState;
            savedState = fullyRelease(node);
            boolean interrupted;
            interrupted = false;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1514363950 = (!isOnSyncQueue(node));
                {
                    LockSupport.park(this);
                    {
                        boolean varA664C6144AE4C03C0F8F972E8F70F7E8_1278912608 = (Thread.interrupted());
                        interrupted = true;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var17DE45DCF221A6E3B338FD5BCAB95962_308031931 = (acquireQueued(node, savedState) || interrupted);
                selfInterrupt();
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.805 -0400", hash_original_method = "5CA3F4E55230C1BE0E77A65DF87A61F3", hash_generated_method = "0C7FCCFBEC9A4D1B686383091408BAE6")
        private int checkInterruptWhileWaiting(Node node) {
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_1319321870 = (Thread.interrupted());
                Object varE3D941AA1F8858C4DCE68CB723942357_1379660918 = ((transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT)); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End flattened ternary
            //DSFIXME:  CODE0008: Nested ternary operator in expression
            addTaint(node.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108762531 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108762531;
            // ---------- Original Method ----------
            //return Thread.interrupted() ?
                //(transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT) :
                //0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.805 -0400", hash_original_method = "5304D5C5F98F936C59A15960318DA98F", hash_generated_method = "4F0549A9C71A3F0067ABB9F9CD8E2C15")
        private void reportInterruptAfterWait(int interruptMode) throws InterruptedException {
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            selfInterrupt();
            addTaint(interruptMode);
            // ---------- Original Method ----------
            //if (interruptMode == THROW_IE)
                //throw new InterruptedException();
            //else if (interruptMode == REINTERRUPT)
                //selfInterrupt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.826 -0400", hash_original_method = "316B8F22454E74CF1A9F01045EC67EC6", hash_generated_method = "BE466C4D3F7026D61F0B8B1A3F34FDD2")
        public final void await() throws InterruptedException {
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_1438216518 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End collapsed parenthetic
            Node node;
            node = addConditionWaiter();
            int savedState;
            savedState = fullyRelease(node);
            int interruptMode;
            interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1579655745 = (!isOnSyncQueue(node));
                {
                    LockSupport.park(this);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_501592007 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_1346846013 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.834 -0400", hash_original_method = "46C34832DD3406F7F3C664FF7A3A79B4", hash_generated_method = "A4BD893532AEE5F83C6EAFB7C8A0370C")
        public final long awaitNanos(long nanosTimeout) throws InterruptedException {
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_84239680 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End collapsed parenthetic
            Node node;
            node = addConditionWaiter();
            int savedState;
            savedState = fullyRelease(node);
            long lastTime;
            lastTime = System.nanoTime();
            int interruptMode;
            interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1143236251 = (!isOnSyncQueue(node));
                {
                    {
                        transferAfterCancelledWait(node);
                    } //End block
                    LockSupport.parkNanos(this, nanosTimeout);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_1368757783 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                    long now;
                    now = System.nanoTime();
                    nanosTimeout -= now - lastTime;
                    lastTime = now;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_941495630 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            long var0AE99C9194A9E8813170658867C876DB_774274327 = (nanosTimeout - (System.nanoTime() - lastTime));
            addTaint(nanosTimeout);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_199035881 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_199035881;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.839 -0400", hash_original_method = "9B6F9AFE5FC55A4D3153D2EEB76307B9", hash_generated_method = "F5ED24E09F4D7BF670BC7E13372977FC")
        public final boolean awaitUntil(Date deadline) throws InterruptedException {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            long abstime;
            abstime = deadline.getTime();
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_1816149393 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End collapsed parenthetic
            Node node;
            node = addConditionWaiter();
            int savedState;
            savedState = fullyRelease(node);
            boolean timedout;
            timedout = false;
            int interruptMode;
            interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_857994006 = (!isOnSyncQueue(node));
                {
                    {
                        boolean varD36E947A894CF1227DF67FCDA3A195E9_977492341 = (System.currentTimeMillis() > abstime);
                        {
                            timedout = transferAfterCancelledWait(node);
                        } //End block
                    } //End collapsed parenthetic
                    LockSupport.parkUntil(this, abstime);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_692508988 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_1923302793 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            addTaint(deadline.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772338794 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_772338794;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.858 -0400", hash_original_method = "BFE4D71142E465ECC716594C0843F211", hash_generated_method = "9EE536D62ABCA829308E1AAFD72EEF87")
        public final boolean await(long time, TimeUnit unit) throws InterruptedException {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            long nanosTimeout;
            nanosTimeout = unit.toNanos(time);
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_550094064 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End collapsed parenthetic
            Node node;
            node = addConditionWaiter();
            int savedState;
            savedState = fullyRelease(node);
            long lastTime;
            lastTime = System.nanoTime();
            boolean timedout;
            timedout = false;
            int interruptMode;
            interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1984475418 = (!isOnSyncQueue(node));
                {
                    {
                        timedout = transferAfterCancelledWait(node);
                    } //End block
                    LockSupport.parkNanos(this, nanosTimeout);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_614802470 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                    long now;
                    now = System.nanoTime();
                    nanosTimeout -= now - lastTime;
                    lastTime = now;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_726384758 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            addTaint(time);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672462555 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672462555;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.859 -0400", hash_original_method = "165B5BC520C58D38E1ED3303B481AD06", hash_generated_method = "32DC075AFFEBE5CF19039329816E3F87")
        final boolean isOwnedBy(AbstractQueuedSynchronizer sync) {
            boolean var2A8E0121C9EBA5DBD487804D196CA981_1445381766 = (sync == AbstractQueuedSynchronizer.this);
            addTaint(sync.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221774254 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_221774254;
            // ---------- Original Method ----------
            //return sync == AbstractQueuedSynchronizer.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.859 -0400", hash_original_method = "5570422C2D22E250B14B7FB8C176D89A", hash_generated_method = "A0A61A51BEC89F889C8333D7FC7E5788")
        protected final boolean hasWaiters() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_520709403 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            {
                Node w;
                w = firstWaiter;
                w = w.nextWaiter;
            } //End collapsed parenthetic
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_13115441 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_13115441;
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //for (Node w = firstWaiter; w != null; w = w.nextWaiter) {
                //if (w.waitStatus == Node.CONDITION)
                    //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.860 -0400", hash_original_method = "586699B2B19676C29FE19392CDC481BB", hash_generated_method = "804660AB4FF00ADD271E0F0BE77D0C7B")
        protected final int getWaitQueueLength() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1453486570 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            int n;
            n = 0;
            {
                Node w;
                w = firstWaiter;
                w = w.nextWaiter;
            } //End collapsed parenthetic
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941799255 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941799255;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_method = "D1136CB2B0FE173AD3F139F996FAE8B5", hash_generated_method = "0896B3E616417EFA2B59990E8630591E")
        protected final Collection<Thread> getWaitingThreads() {
            Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1597830336 = null; //Variable for return #1
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_419688175 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            ArrayList<Thread> list;
            list = new ArrayList<Thread>();
            {
                Node w;
                w = firstWaiter;
                w = w.nextWaiter;
                {
                    {
                        Thread t;
                        t = w.thread;
                        list.add(t);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1597830336 = list;
            varB4EAC82CA7396A68D541C85D26508E83_1597830336.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1597830336;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "C457B05B8D8DCF2333B7BE06BB3694B7", hash_generated_field = "358FCBAC7AD9971159C498A6E192C536")

        private static long serialVersionUID = 1173984872572414699L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "D61A8CF122BE9E2755E208E71F14B796", hash_generated_field = "DC4DC45E0D8AFFFB16A7A1E7444B59D0")

        private static int REINTERRUPT = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "26CBB60DE11931C6D9D95F685537FC92", hash_generated_field = "50C669A47E19922A5EACA70FB77E027A")

        private static int THROW_IE = -1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "53B46295871253A108CBEAB47C328D22", hash_generated_field = "56D169EE9EF53CC38DED680B0494F9C3")

    private static long serialVersionUID = 7373984972572414691L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "97826F3E2403B559BA27663CADCEE60A", hash_generated_field = "42D7443A34CE217AF48A02C17C1FAF6D")

    static long spinForTimeoutThreshold = 1000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "4B38931B7448D73BB4E1EC1A0BEC037D", hash_generated_field = "D0DEE857BA5B5272DFC5F12F486A2516")

    private static Unsafe unsafe = UnsafeAccess.THE_ONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "2C1DA28B2CFB5A4DCF7A56B1409A3B45", hash_generated_field = "162353053FFA573C2A47BACEC7C77131")

    private static long stateOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "949FBEE482BB8F9AF6BC94101DBBFA8B", hash_generated_field = "97CE09A29DB2EB713A48E047121081EE")

    private static long headOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "9AB0A3F42E66C0E1646CAE7D9DF99009", hash_generated_field = "8B58E2B37A159AAD83A5260C2F388DB2")

    private static long tailOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "FA3E7ECB1F7079FDF9ADC8AA71B67A14", hash_generated_field = "58D083123B9F4D91D47538963124B084")

    private static long waitStatusOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.869 -0400", hash_original_field = "AF712C58580FB5A2A86652706D04C24E", hash_generated_field = "94ADDD311D046BDDD72EC240B54C288D")

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

