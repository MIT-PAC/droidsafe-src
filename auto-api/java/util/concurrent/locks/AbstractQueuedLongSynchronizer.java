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

public abstract class AbstractQueuedLongSynchronizer extends AbstractOwnableSynchronizer implements java.io.Serializable {
    private static long serialVersionUID = 7373984972572414692L;
    private transient volatile Node head;
    private transient volatile Node tail;
    private volatile long state;
    static long spinForTimeoutThreshold = 1000L;
    private static Unsafe unsafe = Unsafe.getUnsafe();
    private static long stateOffset;
    private static long headOffset;
    private static long tailOffset;
    private static long waitStatusOffset;
    private static long nextOffset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.186 -0400", hash_original_method = "A751A42DC11C9B938D5C9CF149C890E7", hash_generated_method = "9B2F96DC7B996D07C6152E54CC3BEF69")
    @DSModeled(DSC.SAFE)
    protected AbstractQueuedLongSynchronizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.194 -0400", hash_original_method = "C8422C2BC77721E652ABF77397F36C3E", hash_generated_method = "4D64D3DE8D93A6971CB0FE803DBC3868")
    @DSModeled(DSC.SAFE)
    protected final long getState() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.200 -0400", hash_original_method = "86D6A35B387F9FCAAA3FE3B41A42F2F2", hash_generated_method = "14FBC3DD555686C63321551BF23A8493")
    @DSModeled(DSC.SAFE)
    protected final void setState(long newState) {
        dsTaint.addTaint(newState);
        // ---------- Original Method ----------
        //state = newState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.208 -0400", hash_original_method = "D3184127FA1DC4C2C312E82CFB4A178E", hash_generated_method = "5DCE0D43F565B07D10ACD3EA6BECFFFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final boolean compareAndSetState(long expect, long update) {
        dsTaint.addTaint(expect);
        dsTaint.addTaint(update);
        boolean var0F6F68C52F75AD07F2EDEB095D0431CC_984210776 = (unsafe.compareAndSwapLong(this, stateOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapLong(this, stateOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.230 -0400", hash_original_method = "D115C79C5FCCB59668763118EBD8CBBB", hash_generated_method = "322886993FC117F4404D23B81D9F0D1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Node enq(final Node node) {
        dsTaint.addTaint(node.dsTaint);
        {
            Node t;
            t = tail;
            {
                {
                    boolean varC2BD7D899FDAEA316177871081826EFD_1883565478 = (compareAndSetHead(new Node()));
                    tail = head;
                } //End collapsed parenthetic
            } //End block
            {
                node.prev = t;
                {
                    boolean var30CFF97C04D4F21E508F35AC3CDBADC7_1210815759 = (compareAndSetTail(t, node));
                    {
                        t.next = node;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (Node)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.248 -0400", hash_original_method = "7269E5EC16B8883F661BF745CCC5E6A6", hash_generated_method = "7287695C5948B2302537B8DB8CD004D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Node addWaiter(Node mode) {
        dsTaint.addTaint(mode.dsTaint);
        Node node;
        node = new Node(Thread.currentThread(), mode);
        Node pred;
        pred = tail;
        {
            node.prev = pred;
            {
                boolean varB759FEC06526555CC952C851C67B8004_909821191 = (compareAndSetTail(pred, node));
                {
                    pred.next = node;
                } //End block
            } //End collapsed parenthetic
        } //End block
        enq(node);
        return (Node)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.266 -0400", hash_original_method = "51AEDFDDD323C78EE2EC4A6DE568B8D1", hash_generated_method = "17B45587EF08758B28F32C280CBCC8B2")
    @DSModeled(DSC.SAFE)
    private void setHead(Node node) {
        dsTaint.addTaint(node.dsTaint);
        node.thread = null;
        node.prev = null;
        // ---------- Original Method ----------
        //head = node;
        //node.thread = null;
        //node.prev = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.284 -0400", hash_original_method = "F262A3A18BABECF7EC492736953EAF6E", hash_generated_method = "544F7F4175CCEFC33759365672A63EE0")
    @DSModeled(DSC.SAFE)
    private void unparkSuccessor(Node node) {
        dsTaint.addTaint(node.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.309 -0400", hash_original_method = "D8D55646997B45206CD2F0528B603753", hash_generated_method = "6CDD2542272032BFD945B071D09DC12E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doReleaseShared() {
        {
            Node h;
            h = head;
            {
                int ws;
                ws = h.waitStatus;
                {
                    {
                        boolean varCC865867FC8DEDE4843F9E3D62245755_1131387793 = (!compareAndSetWaitStatus(h, Node.SIGNAL, 0));
                    } //End collapsed parenthetic
                    unparkSuccessor(h);
                } //End block
                {
                    boolean var658C7F41A73D231A5E38D15A1070790F_1681774165 = (ws == 0 &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.338 -0400", hash_original_method = "AC57E5BE4F40CA13FB5EC85FF9A1D1C8", hash_generated_method = "CF824FDAC092F07CA163B14FE80B3537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setHeadAndPropagate(Node node, long propagate) {
        dsTaint.addTaint(node.dsTaint);
        dsTaint.addTaint(propagate);
        Node h;
        h = head;
        setHead(node);
        {
            Node s;
            s = node.next;
            {
                boolean varB6D0E63ACFCFA5DA33C33F91435930F9_1612829678 = (s == null || s.isShared());
                doReleaseShared();
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.373 -0400", hash_original_method = "1CA41B58715410C4216B9DE6C43BB9D4", hash_generated_method = "0F0C9552B105F1163A7214AE9533880C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void cancelAcquire(Node node) {
        dsTaint.addTaint(node.dsTaint);
        node.thread = null;
        Node pred;
        pred = node.prev;
        node.prev = pred = pred.prev;
        Node predNext;
        predNext = pred.next;
        node.waitStatus = Node.CANCELLED;
        {
            boolean var9C67AE94C69ECBB4560E786F86E10C76_988610816 = (node == tail && compareAndSetTail(node, pred));
            {
                compareAndSetNext(pred, predNext, null);
            } //End block
            {
                int ws;
                {
                    boolean var806CB84C61F87A678A0A252FCBFAAB06_1596566777 = (pred != head &&
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.382 -0400", hash_original_method = "F65239B395BF4DB687722F10CCB87FAF", hash_generated_method = "73C14A112E3BE4BF2C82CABE04458317")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.393 -0400", hash_original_method = "A017FE2B347BB8E3F328A9771EBB4299", hash_generated_method = "8DC8129982A7D3B365DA079876162962")
    private static void selfInterrupt() {
        Thread.currentThread().interrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.397 -0400", hash_original_method = "C551D5FD0C0A2C72DAD755E48C68905F", hash_generated_method = "87573EBE2B77B9D0A6D296281D509C29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        boolean var17A536D12FEB0466CF9F0EDC1509A805_1603986545 = (Thread.interrupted());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //LockSupport.park(this);
        //return Thread.interrupted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.408 -0400", hash_original_method = "01CB53E47AF5384558F5A1C3FDB268E6", hash_generated_method = "84759D0BBC98450D6016B1BADAB094ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean acquireQueued(final Node node, long arg) {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(node.dsTaint);
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
                    boolean varB702A2D695A14FF8E8F201BF2E513471_1505484932 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_1633552568 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    interrupted = true;
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.428 -0400", hash_original_method = "55E6E177951B42431803927A7959D0FA", hash_generated_method = "F413D33ADD24101B7651A600AEC612CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doAcquireInterruptibly(long arg) throws InterruptedException {
        dsTaint.addTaint(arg);
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
                    boolean varB702A2D695A14FF8E8F201BF2E513471_805566976 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_2139908154 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.446 -0400", hash_original_method = "8E03C4B48840A9B3BF90FDE1E1A7FD89", hash_generated_method = "D0CB9CAFF737DADC8A22C2070010FED9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean doAcquireNanos(long arg, long nanosTimeout) throws InterruptedException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(nanosTimeout);
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
                    boolean varB702A2D695A14FF8E8F201BF2E513471_2113426913 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var00B5F1835D8E1D445CE64BB60FAD1503_581679094 = (shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold);
                    LockSupport.parkNanos(this, nanosTimeout);
                } //End collapsed parenthetic
                long now;
                now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                {
                    boolean varFDD1D09D0FE11E5BCA86E55DE77A8E11_1830254642 = (Thread.interrupted());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.459 -0400", hash_original_method = "095D12E4A7332AAD7407B545C8A52562", hash_generated_method = "ACE51E930436077BF8AD4FA633FC0A71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doAcquireShared(long arg) {
        dsTaint.addTaint(arg);
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
                    long r;
                    r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        selfInterrupt();
                        failed = false;
                    } //End block
                } //End block
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_1152007749 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    interrupted = true;
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.472 -0400", hash_original_method = "9789736263D9A07C7DAA9126D0810BC9", hash_generated_method = "76C13D9A0A73D4CA131450701C71B342")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doAcquireSharedInterruptibly(long arg) throws InterruptedException {
        dsTaint.addTaint(arg);
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
                    long r;
                    r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End block
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_307272678 = (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        // ---------- Original Method ----------
        //final Node node = addWaiter(Node.SHARED);
        //boolean failed = true;
        //try {
            //for (;;) {
                //final Node p = node.predecessor();
                //if (p == head) {
                    //long r = tryAcquireShared(arg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.496 -0400", hash_original_method = "2A440B2625D20BDACB83035D82E3E5FD", hash_generated_method = "312A34C2B28E9096A9E297FBC3DD07EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean doAcquireSharedNanos(long arg, long nanosTimeout) throws InterruptedException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(nanosTimeout);
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
                    long r;
                    r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End block
                {
                    boolean var00B5F1835D8E1D445CE64BB60FAD1503_1064603805 = (shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold);
                    LockSupport.parkNanos(this, nanosTimeout);
                } //End collapsed parenthetic
                long now;
                now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                {
                    boolean varFDD1D09D0FE11E5BCA86E55DE77A8E11_1622974664 = (Thread.interrupted());
                    if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
                } //End collapsed parenthetic
            } //End block
        } //End block
        finally 
        {
            cancelAcquire(node);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.502 -0400", hash_original_method = "FD370A9634E720EE7DED3E002AB064BA", hash_generated_method = "429BE748CDF6133B811C19FE06D1E5F4")
    @DSModeled(DSC.SAFE)
    protected boolean tryAcquire(long arg) {
        dsTaint.addTaint(arg);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.507 -0400", hash_original_method = "2B32EBB8339D727CD82009C5D6FE656F", hash_generated_method = "696980DEEF767ED693C6E6052E1F70F1")
    @DSModeled(DSC.SAFE)
    protected boolean tryRelease(long arg) {
        dsTaint.addTaint(arg);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.511 -0400", hash_original_method = "59DC5C90BD058244A08E7F765FBAC34A", hash_generated_method = "946285E6D8C7507F4E01A20D11A59FA0")
    @DSModeled(DSC.SAFE)
    protected long tryAcquireShared(long arg) {
        dsTaint.addTaint(arg);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.514 -0400", hash_original_method = "2C81131B355160A1FCBC5B245A885B63", hash_generated_method = "A703DB310AD672DFE276582322411140")
    @DSModeled(DSC.SAFE)
    protected boolean tryReleaseShared(long arg) {
        dsTaint.addTaint(arg);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.518 -0400", hash_original_method = "B1A3EF7BA2A74EEB6B3236F0A99ED9FE", hash_generated_method = "7BAFEF9B60619758C7CC9D78BB2E3C8C")
    @DSModeled(DSC.SAFE)
    protected boolean isHeldExclusively() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.523 -0400", hash_original_method = "C44D906E2E89F4CED0C5B57E730977A1", hash_generated_method = "22F5EE852CCCACB2C72CB884B0984C74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void acquire(long arg) {
        dsTaint.addTaint(arg);
        {
            boolean varFCEF5DD222F9CABA3FDCCFE99D21AA7A_871938028 = (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg));
            selfInterrupt();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!tryAcquire(arg) &&
            //acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            //selfInterrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.529 -0400", hash_original_method = "1F4AB8CF8FF5E0E3ED34F16FC2636AFC", hash_generated_method = "55E69A15F2EB7EE818B41139E6F16FD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void acquireInterruptibly(long arg) throws InterruptedException {
        dsTaint.addTaint(arg);
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1623955649 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        {
            boolean var6C80CD83DDCC36721F42CDF9EFE1FC97_25696503 = (!tryAcquire(arg));
            doAcquireInterruptibly(arg);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (!tryAcquire(arg))
            //doAcquireInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.538 -0400", hash_original_method = "4438C59C37A58FAD53E3CCD4B9296E56", hash_generated_method = "1112CDD96C35DEBEBD730C4601B2AA86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean tryAcquireNanos(long arg, long nanosTimeout) throws InterruptedException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(nanosTimeout);
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1976217910 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        boolean var34DCAB88C8A0F240E32D599EDB2FE196_280601991 = (tryAcquire(arg) ||
            doAcquireNanos(arg, nanosTimeout));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquire(arg) ||
            //doAcquireNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.546 -0400", hash_original_method = "F5461D18E242AE6951E770BA9FA4949B", hash_generated_method = "C3753B2A8DD8D9643969F243AB445D78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean release(long arg) {
        dsTaint.addTaint(arg);
        {
            boolean varFF82B8E2BC2E04000CA63D87A88AB8D2_1762581078 = (tryRelease(arg));
            {
                Node h;
                h = head;
                unparkSuccessor(h);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (tryRelease(arg)) {
            //Node h = head;
            //if (h != null && h.waitStatus != 0)
                //unparkSuccessor(h);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.551 -0400", hash_original_method = "B962A705530420D4F3D8394241987A2D", hash_generated_method = "DF76A5D6BBED4F54585DF439B1293296")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void acquireShared(long arg) {
        dsTaint.addTaint(arg);
        {
            boolean varE24C999E8142A86B0EF4E6AFA805A8A0_1076374669 = (tryAcquireShared(arg) < 0);
            doAcquireShared(arg);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (tryAcquireShared(arg) < 0)
            //doAcquireShared(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.557 -0400", hash_original_method = "7641C894C4A04D6267227FDE57644692", hash_generated_method = "5727F083F798CC20437C2F8478AF2F3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void acquireSharedInterruptibly(long arg) throws InterruptedException {
        dsTaint.addTaint(arg);
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1580188483 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        {
            boolean varE24C999E8142A86B0EF4E6AFA805A8A0_710678442 = (tryAcquireShared(arg) < 0);
            doAcquireSharedInterruptibly(arg);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (tryAcquireShared(arg) < 0)
            //doAcquireSharedInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.568 -0400", hash_original_method = "87B0A1537018C4FA81BDEC61F6B0DB04", hash_generated_method = "2DFE440164273CE40CE725EB95C5F34A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean tryAcquireSharedNanos(long arg, long nanosTimeout) throws InterruptedException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(nanosTimeout);
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_138813335 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        boolean varE4B1D6DE7AE03DFEE28CA37F75A87EB4_1310640428 = (tryAcquireShared(arg) >= 0 ||
            doAcquireSharedNanos(arg, nanosTimeout));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquireShared(arg) >= 0 ||
            //doAcquireSharedNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.573 -0400", hash_original_method = "7E3130045E756130345AFDFCDD4972BC", hash_generated_method = "E45E239DC081489767FCCD84ED0DCB27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean releaseShared(long arg) {
        dsTaint.addTaint(arg);
        {
            boolean varEB9480595F3C382515F926391F6AAE14_563163971 = (tryReleaseShared(arg));
            {
                doReleaseShared();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (tryReleaseShared(arg)) {
            //doReleaseShared();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.577 -0400", hash_original_method = "3ACA5092770D7AD1442898AF3B627DFE", hash_generated_method = "82129C619441442B9CA3EA4FDD4B1EA6")
    @DSModeled(DSC.SAFE)
    public final boolean hasQueuedThreads() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return head != tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.580 -0400", hash_original_method = "3ED9D0D071477B613E998B33D61DD4C5", hash_generated_method = "A49B64A400C6120C3248DBF82292AFB5")
    @DSModeled(DSC.SAFE)
    public final boolean hasContended() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return head != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.585 -0400", hash_original_method = "DB23AE447B60E978D848F5CEAEC8257B", hash_generated_method = "F636F6BCB9D24C7C075E8C445C6AFC8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Thread getFirstQueuedThread() {
        {
            Object var3B7CB660AB505354CD602C60DFD0581B_1344980431 = (fullGetFirstQueuedThread());
        } //End flattened ternary
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (head == tail) ? null : fullGetFirstQueuedThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.599 -0400", hash_original_method = "18818CB637EBC5CF82DC4C50B37FB17C", hash_generated_method = "03843ED34ECAA1E3D81672A3B800BE95")
    @DSModeled(DSC.SAFE)
    private Thread fullGetFirstQueuedThread() {
        Node h, s;
        Thread st;
        {
            boolean varAB96948AFE2AAAF3BBF624BD73ABA985_996656121 = (((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null) ||
            ((h = head) != null && (s = h.next) != null &&
             s.prev == head && (st = s.thread) != null));
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
        return (Thread)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.608 -0400", hash_original_method = "1573E83A14D593E0BFADABB9AEDBB7D2", hash_generated_method = "D42E570190DB29AC70F2D7D3CA0C02F5")
    @DSModeled(DSC.SAFE)
    public final boolean isQueued(Thread thread) {
        dsTaint.addTaint(thread.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            Node p;
            p = tail;
            p = p.prev;
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (thread == null)
            //throw new NullPointerException();
        //for (Node p = tail; p != null; p = p.prev)
            //if (p.thread == thread)
                //return true;
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.613 -0400", hash_original_method = "4993AFB2E466C494E10B5DA4780E51AB", hash_generated_method = "6639A979C45300A215FF5230D689A728")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean apparentlyFirstQueuedIsExclusive() {
        Node h, s;
        boolean var7A2694C8A18196F041BDCF2FCD7324AE_764660599 = ((h = head) != null &&
            (s = h.next)  != null &&
            !s.isShared()         &&
            s.thread != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Node h, s;
        //return (h = head) != null &&
            //(s = h.next)  != null &&
            //!s.isShared()         &&
            //s.thread != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.617 -0400", hash_original_method = "155F6B01F514C41CA8367710346D37E3", hash_generated_method = "9E7351257B965117C8AF59EAE46FCD93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean hasQueuedPredecessors() {
        Node t;
        t = tail;
        Node h;
        h = head;
        Node s;
        boolean var4B72E4D0E536DE6B3ACB8283BCD4F664_1578102206 = (h != t &&
            ((s = h.next) == null || s.thread != Thread.currentThread()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Node t = tail;
        //Node h = head;
        //Node s;
        //return h != t &&
            //((s = h.next) == null || s.thread != Thread.currentThread());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.622 -0400", hash_original_method = "65AB677A04652631BF1CC269A789F93A", hash_generated_method = "A592F7A5F1B4A7BA05F3E7C57A78C289")
    @DSModeled(DSC.SAFE)
    public final int getQueueLength() {
        int n;
        n = 0;
        {
            Node p;
            p = tail;
            p = p.prev;
            {
                ++n;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int n = 0;
        //for (Node p = tail; p != null; p = p.prev) {
            //if (p.thread != null)
                //++n;
        //}
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.626 -0400", hash_original_method = "BA97C075FB0E9B39CEF398B585209CAD", hash_generated_method = "832C16240D93053BC8FF6E9CFE311885")
    @DSModeled(DSC.SAFE)
    public final Collection<Thread> getQueuedThreads() {
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
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<Thread> list = new ArrayList<Thread>();
        //for (Node p = tail; p != null; p = p.prev) {
            //Thread t = p.thread;
            //if (t != null)
                //list.add(t);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.632 -0400", hash_original_method = "8F9C05C78C38CDEC6B94C7386A00C30C", hash_generated_method = "94B97658A0BDA5B4631D3EE37DBA6818")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Collection<Thread> getExclusiveQueuedThreads() {
        ArrayList<Thread> list;
        list = new ArrayList<Thread>();
        {
            Node p;
            p = tail;
            p = p.prev;
            {
                {
                    boolean varDFA54A0E0CB503BCC5CE98449AAB2A08_1339347503 = (!p.isShared());
                    {
                        Thread t;
                        t = p.thread;
                        list.add(t);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Collection<Thread>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.641 -0400", hash_original_method = "3B2BC348731488178C75B0F7C3256BE4", hash_generated_method = "452AC464AB1D4A30C26FD371429ADF14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Collection<Thread> getSharedQueuedThreads() {
        ArrayList<Thread> list;
        list = new ArrayList<Thread>();
        {
            Node p;
            p = tail;
            p = p.prev;
            {
                {
                    boolean varC6C07EC060C76D1E58FED758F007D903_2011586933 = (p.isShared());
                    {
                        Thread t;
                        t = p.thread;
                        list.add(t);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Collection<Thread>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.651 -0400", hash_original_method = "659FCE8B95FD967D9AF39A9878BA590C", hash_generated_method = "C9B12BB00154C38A1FD54AB795368FC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        long s;
        s = getState();
        String q;
        boolean var58703E822CB7EE24CF8A625587E1C63E_1626091726 = (hasQueuedThreads());
        q = "non";
        q = "";
        String varA627899E43EA43F388C27ED3471D90CE_231899452 = (super.toString() +
            "[State = " + s + ", " + q + "empty queue]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //long s = getState();
        //String q  = hasQueuedThreads() ? "non" : "";
        //return super.toString() +
            //"[State = " + s + ", " + q + "empty queue]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.656 -0400", hash_original_method = "0981A7B7481B56654552F826D97FC7A4", hash_generated_method = "63FF4AE7653008962598CB55D7F2B68E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean isOnSyncQueue(Node node) {
        dsTaint.addTaint(node.dsTaint);
        boolean varF3A4D6770CAC1AA85AF3A6C51812BE70_200399884 = (findNodeFromTail(node));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (node.waitStatus == Node.CONDITION || node.prev == null)
            //return false;
        //if (node.next != null) 
            //return true;
        //return findNodeFromTail(node);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.659 -0400", hash_original_method = "E84A510853D9F9659F34649D5E631E14", hash_generated_method = "85BD075848FEFC6E030C9201EECB621B")
    @DSModeled(DSC.SAFE)
    private boolean findNodeFromTail(Node node) {
        dsTaint.addTaint(node.dsTaint);
        Node t;
        t = tail;
        {
            t = t.prev;
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.665 -0400", hash_original_method = "AC7EB2A7C3E5842E27808853E2EADEA4", hash_generated_method = "985D564843508791B2951C302336FD2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean transferForSignal(Node node) {
        dsTaint.addTaint(node.dsTaint);
        {
            boolean var8F78D6E41179A92913D59E278DAF4713_1448750300 = (!compareAndSetWaitStatus(node, Node.CONDITION, 0));
        } //End collapsed parenthetic
        Node p;
        p = enq(node);
        int ws;
        ws = p.waitStatus;
        {
            boolean var11909F9DE762D0C62EFBB539D3DF08AB_1159522974 = (ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL));
            LockSupport.unpark(node.thread);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!compareAndSetWaitStatus(node, Node.CONDITION, 0))
            //return false;
        //Node p = enq(node);
        //int ws = p.waitStatus;
        //if (ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL))
            //LockSupport.unpark(node.thread);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.673 -0400", hash_original_method = "202AE2159172221E521994FECA693914", hash_generated_method = "C6BBE7ECDEC507002F990C88BCDFAFF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean transferAfterCancelledWait(Node node) {
        dsTaint.addTaint(node.dsTaint);
        {
            boolean varAB52CB6F165D0797C877670E5EE00069_716693558 = (compareAndSetWaitStatus(node, Node.CONDITION, 0));
            {
                enq(node);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA5ECD06A31929CB111AEF5ECED825AFB_1344920664 = (!isOnSyncQueue(node));
            Thread.yield();
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (compareAndSetWaitStatus(node, Node.CONDITION, 0)) {
            //enq(node);
            //return true;
        //}
        //while (!isOnSyncQueue(node))
            //Thread.yield();
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.679 -0400", hash_original_method = "55E74F52DCD070A69EA862B249BE28A1", hash_generated_method = "7ED6585231B7D32CAF862785A7579910")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final long fullyRelease(Node node) {
        dsTaint.addTaint(node.dsTaint);
        boolean failed;
        failed = true;
        try 
        {
            long savedState;
            savedState = getState();
            {
                boolean var3C6705464C8EDF86A554C3C7455FE111_1736473167 = (release(savedState));
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
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //boolean failed = true;
        //try {
            //long savedState = getState();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.686 -0400", hash_original_method = "B60D02054E03A30F41C10CC4F7B33B2F", hash_generated_method = "DFB5BF2F8377ED34B07BE3A39A096532")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean owns(ConditionObject condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        boolean var81F8FCB295780CD2D5751E1181CC9428_830506150 = (condition.isOwnedBy(this));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //return condition.isOwnedBy(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.694 -0400", hash_original_method = "B87CA02CD99C2C81A6ADCC153DE8BF7D", hash_generated_method = "5C77F821A88DCDF7F6B2A8D1847D125D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasWaiters(ConditionObject condition) {
        dsTaint.addTaint(condition.dsTaint);
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_310044043 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } //End collapsed parenthetic
        boolean var335079E40CDAA9EFDA14CFAFE44A0835_1962664039 = (condition.hasWaiters());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.hasWaiters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.699 -0400", hash_original_method = "FDFBF2604A26737643DD133E9F8A257F", hash_generated_method = "CBB38F6095006F71F6D10EA17F37591F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getWaitQueueLength(ConditionObject condition) {
        dsTaint.addTaint(condition.dsTaint);
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_485208858 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } //End collapsed parenthetic
        int var5991F4798FCDE9B9D32781CE8A86C9C1_411166522 = (condition.getWaitQueueLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.704 -0400", hash_original_method = "70972013E049E7504ADBD56143485C77", hash_generated_method = "955BAD933739B3E94731F7CD713343BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Collection<Thread> getWaitingThreads(ConditionObject condition) {
        dsTaint.addTaint(condition.dsTaint);
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_1069195620 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } //End collapsed parenthetic
        Collection<Thread> var36A2E52470B9D7B4821E23B59E8D5DE3_870619220 = (condition.getWaitingThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitingThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.707 -0400", hash_original_method = "20D2259271C7B1C96C133ACBD2C26B14", hash_generated_method = "26AC37BE5A31EC75611317A79717FCD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final boolean compareAndSetHead(Node update) {
        dsTaint.addTaint(update.dsTaint);
        boolean var7C9BAC36D5138868FE92F3C1948386AB_971669038 = (unsafe.compareAndSwapObject(this, headOffset, null, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.713 -0400", hash_original_method = "8C47C531A43F622294BF6051B04C8993", hash_generated_method = "50E73065829A536A0B795B96CE4FA9FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final boolean compareAndSetTail(Node expect, Node update) {
        dsTaint.addTaint(expect.dsTaint);
        dsTaint.addTaint(update.dsTaint);
        boolean varC5CCFD292C10D03F1C8C777B8815D2E2_17075018 = (unsafe.compareAndSwapObject(this, tailOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.715 -0400", hash_original_method = "C08E184A516295B7BF20ABCE746571ED", hash_generated_method = "357E5ABF0E0719E98E02C88719CE5D0C")
    private static final boolean compareAndSetWaitStatus(Node node,
                                                         int expect,
                                                         int update) {
        return unsafe.compareAndSwapInt(node, waitStatusOffset,
                                        expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.717 -0400", hash_original_method = "E6B89C35380C1CC08274185C89FBCA81", hash_generated_method = "39BD2E41F5823D830B4D7DC13E878B54")
    private static final boolean compareAndSetNext(Node node,
                                                   Node expect,
                                                   Node update) {
        return unsafe.compareAndSwapObject(node, nextOffset, expect, update);
    }

    
    static final class Node {
        static Node SHARED = new Node();
        static Node EXCLUSIVE = null;
        static int CANCELLED =  1;
        static int SIGNAL    = -1;
        static int CONDITION = -2;
        static int PROPAGATE = -3;
        volatile int waitStatus;
        volatile Node prev;
        volatile Node next;
        volatile Thread thread;
        Node nextWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.720 -0400", hash_original_method = "2DD8BF5485F2495811D83404AF44A29C", hash_generated_method = "D97AA86E3E532ED09C929914C7D648A4")
        @DSModeled(DSC.SAFE)
         Node() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.723 -0400", hash_original_method = "764EF23A3C66C99D5E5160039F46E6BD", hash_generated_method = "CD9AC8B2F6F2152AB82B53E42AE0F4F5")
        @DSModeled(DSC.SAFE)
         Node(Thread thread, Node mode) {
            dsTaint.addTaint(thread.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            // ---------- Original Method ----------
            //this.nextWaiter = mode;
            //this.thread = thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.726 -0400", hash_original_method = "5118904E6021AE155CDFF15DB609BD48", hash_generated_method = "141ACF42047CCE85E8BA418A6528A446")
        @DSModeled(DSC.SAFE)
         Node(Thread thread, int waitStatus) {
            dsTaint.addTaint(thread.dsTaint);
            dsTaint.addTaint(waitStatus);
            // ---------- Original Method ----------
            //this.waitStatus = waitStatus;
            //this.thread = thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.730 -0400", hash_original_method = "EA506AD78E2AE8ACF234FE0610B9A575", hash_generated_method = "41C123C3414DBA44B501221AC54D0509")
        @DSModeled(DSC.SAFE)
        final boolean isShared() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nextWaiter == SHARED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.734 -0400", hash_original_method = "7AA5CFB77F71DE2C6FFA937BCE62ADAE", hash_generated_method = "483C6E6CB2CB9463FDF8C10466102307")
        @DSModeled(DSC.SAFE)
        final Node predecessor() throws NullPointerException {
            Node p;
            p = prev;
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            return (Node)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Node p = prev;
            //if (p == null)
                //throw new NullPointerException();
            //else
                //return p;
        }

        
    }


    
    public class ConditionObject implements Condition, java.io.Serializable {
        private static final long serialVersionUID = 1173984872572414699L;
        private transient Node firstWaiter;
        private transient Node lastWaiter;
        private static final int REINTERRUPT =  1;
        private static final int THROW_IE    = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.750 -0400", hash_original_method = "0A3E2C1E27BAEA738FDF96AD17500BEE", hash_generated_method = "9DA9DA1CBE0707973004B0B03662E1B6")
        @DSModeled(DSC.SAFE)
        public ConditionObject() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.755 -0400", hash_original_method = "43F5E066353E431B2C9AD7CD0397BCCF", hash_generated_method = "BBF67622FB115A977496F8F046066F62")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Node addConditionWaiter() {
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
            return (Node)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.762 -0400", hash_original_method = "74B8316ED8B5F40365D8BD9CF002AB2D", hash_generated_method = "FDF14047EB89C644262994C3D0878EF4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void doSignal(Node first) {
            dsTaint.addTaint(first.dsTaint);
            {
                {
                    boolean varBC585BCE36C017A7C94055DA929092A7_284104185 = ((firstWaiter = first.nextWaiter) == null);
                    lastWaiter = null;
                } //End collapsed parenthetic
                first.nextWaiter = null;
            } //End block
            {
                boolean var608C6B17E7E10DD5072B7876717FB9A1_1499506956 = (!transferForSignal(first) &&
                     (first = firstWaiter) != null);
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //do {
                //if ( (firstWaiter = first.nextWaiter) == null)
                    //lastWaiter = null;
                //first.nextWaiter = null;
            //} while (!transferForSignal(first) &&
                     //(first = firstWaiter) != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.766 -0400", hash_original_method = "DE4F68C515AD9FDEF86DCFCC83AF390E", hash_generated_method = "858B59C04FB731AF2E5F00DA57E24238")
        @DSModeled(DSC.SAFE)
        private void doSignalAll(Node first) {
            dsTaint.addTaint(first.dsTaint);
            lastWaiter = firstWaiter = null;
            {
                Node next;
                next = first.nextWaiter;
                first.nextWaiter = null;
                transferForSignal(first);
                first = next;
            } //End block
            // ---------- Original Method ----------
            //lastWaiter = firstWaiter = null;
            //do {
                //Node next = first.nextWaiter;
                //first.nextWaiter = null;
                //transferForSignal(first);
                //first = next;
            //} while (first != null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.774 -0400", hash_original_method = "2AF991EC026F340CB09E7C74A01E5A9A", hash_generated_method = "BD1AC915A4D162535B95C32DD9B6F9D9")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.780 -0400", hash_original_method = "217DDC96D1B25C0D1457937D523A3AA4", hash_generated_method = "71254ADC884498082A5F8D279A38538A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void signal() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_434260448 = (!isHeldExclusively());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.785 -0400", hash_original_method = "8098E0901B1513A38FF0251B40A20DA9", hash_generated_method = "91FBF8C60D815C662472CBAAC08FD80C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void signalAll() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_2039183553 = (!isHeldExclusively());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.792 -0400", hash_original_method = "D8D48CC94AF482BB39207ADE07724A27", hash_generated_method = "86095819EF457DB3980594984F5D5E2C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void awaitUninterruptibly() {
            Node node;
            node = addConditionWaiter();
            long savedState;
            savedState = fullyRelease(node);
            boolean interrupted;
            interrupted = false;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1610610955 = (!isOnSyncQueue(node));
                {
                    LockSupport.park(this);
                    {
                        boolean varA664C6144AE4C03C0F8F972E8F70F7E8_925708659 = (Thread.interrupted());
                        interrupted = true;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var17DE45DCF221A6E3B338FD5BCAB95962_1945650939 = (acquireQueued(node, savedState) || interrupted);
                selfInterrupt();
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //Node node = addConditionWaiter();
            //long savedState = fullyRelease(node);
            //boolean interrupted = false;
            //while (!isOnSyncQueue(node)) {
                //LockSupport.park(this);
                //if (Thread.interrupted())
                    //interrupted = true;
            //}
            //if (acquireQueued(node, savedState) || interrupted)
                //selfInterrupt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.804 -0400", hash_original_method = "5CA3F4E55230C1BE0E77A65DF87A61F3", hash_generated_method = "608863C6A17ABF253A1DD4651861F287")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int checkInterruptWhileWaiting(Node node) {
            dsTaint.addTaint(node.dsTaint);
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_654366010 = (Thread.interrupted());
                Object varE3D941AA1F8858C4DCE68CB723942357_1018852756 = ((transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT)); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End flattened ternary
            //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Thread.interrupted() ?
                //(transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT) :
                //0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.809 -0400", hash_original_method = "5304D5C5F98F936C59A15960318DA98F", hash_generated_method = "932C78A15BA0F00EB25AC07C3935A0F3")
        @DSModeled(DSC.SAFE)
        private void reportInterruptAfterWait(int interruptMode) throws InterruptedException {
            dsTaint.addTaint(interruptMode);
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            selfInterrupt();
            // ---------- Original Method ----------
            //if (interruptMode == THROW_IE)
                //throw new InterruptedException();
            //else if (interruptMode == REINTERRUPT)
                //selfInterrupt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.821 -0400", hash_original_method = "7FB7FD86DD73FB2CF877AB02383CA9C6", hash_generated_method = "3AB6BF4B1CD768E34AAFDDFCF731270E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void await() throws InterruptedException {
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_1346589563 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End collapsed parenthetic
            Node node;
            node = addConditionWaiter();
            long savedState;
            savedState = fullyRelease(node);
            int interruptMode;
            interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_636000075 = (!isOnSyncQueue(node));
                {
                    LockSupport.park(this);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_940522595 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_563859377 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            // ---------- Original Method ----------
            //if (Thread.interrupted())
                //throw new InterruptedException();
            //Node node = addConditionWaiter();
            //long savedState = fullyRelease(node);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.839 -0400", hash_original_method = "AA33D98DBFA12924E6BD89DADEDC4BF4", hash_generated_method = "9264EC13223C012B1347AB57FB465A6D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final long awaitNanos(long nanosTimeout) throws InterruptedException {
            dsTaint.addTaint(nanosTimeout);
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_1083771267 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End collapsed parenthetic
            Node node;
            node = addConditionWaiter();
            long savedState;
            savedState = fullyRelease(node);
            long lastTime;
            lastTime = System.nanoTime();
            int interruptMode;
            interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1506944058 = (!isOnSyncQueue(node));
                {
                    {
                        transferAfterCancelledWait(node);
                    } //End block
                    LockSupport.parkNanos(this, nanosTimeout);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_879382296 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                    long now;
                    now = System.nanoTime();
                    nanosTimeout -= now - lastTime;
                    lastTime = now;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_1823175418 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            long var0AE99C9194A9E8813170658867C876DB_643383188 = (nanosTimeout - (System.nanoTime() - lastTime));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.862 -0400", hash_original_method = "5CEE3165A6A9DF8157E66AD68C7943BB", hash_generated_method = "16FA621D755D6650FB8D24073BB3AD8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean awaitUntil(Date deadline) throws InterruptedException {
            dsTaint.addTaint(deadline.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            long abstime;
            abstime = deadline.getTime();
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_294535433 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End collapsed parenthetic
            Node node;
            node = addConditionWaiter();
            long savedState;
            savedState = fullyRelease(node);
            boolean timedout;
            timedout = false;
            int interruptMode;
            interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_563597170 = (!isOnSyncQueue(node));
                {
                    {
                        boolean varD36E947A894CF1227DF67FCDA3A195E9_2070184006 = (System.currentTimeMillis() > abstime);
                        {
                            timedout = transferAfterCancelledWait(node);
                        } //End block
                    } //End collapsed parenthetic
                    LockSupport.parkUntil(this, abstime);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_1816216598 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_1181030409 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.892 -0400", hash_original_method = "C38710B3F716B27E3686F37E2D9429BB", hash_generated_method = "53B630C9CD70121BF212777DE28DFC2E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean await(long time, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(time);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            long nanosTimeout;
            nanosTimeout = unit.toNanos(time);
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_1039477897 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End collapsed parenthetic
            Node node;
            node = addConditionWaiter();
            long savedState;
            savedState = fullyRelease(node);
            long lastTime;
            lastTime = System.nanoTime();
            boolean timedout;
            timedout = false;
            int interruptMode;
            interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_291010326 = (!isOnSyncQueue(node));
                {
                    {
                        timedout = transferAfterCancelledWait(node);
                    } //End block
                    LockSupport.parkNanos(this, nanosTimeout);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_1831389108 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                    long now;
                    now = System.nanoTime();
                    nanosTimeout -= now - lastTime;
                    lastTime = now;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_823452569 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.898 -0400", hash_original_method = "50CCAFE3157E2FBE31CA5FF7D33760D6", hash_generated_method = "928CFAA9A3BE8A9AA8E6B32F473F42A8")
        @DSModeled(DSC.SAFE)
        final boolean isOwnedBy(AbstractQueuedLongSynchronizer sync) {
            dsTaint.addTaint(sync.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync == AbstractQueuedLongSynchronizer.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.904 -0400", hash_original_method = "5570422C2D22E250B14B7FB8C176D89A", hash_generated_method = "D36E12DF524EDA8FA9EA0FC9BFE8DEC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean hasWaiters() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_724770921 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            {
                Node w;
                w = firstWaiter;
                w = w.nextWaiter;
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //for (Node w = firstWaiter; w != null; w = w.nextWaiter) {
                //if (w.waitStatus == Node.CONDITION)
                    //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.912 -0400", hash_original_method = "586699B2B19676C29FE19392CDC481BB", hash_generated_method = "E25B6E3256A298066B1F51BD21C67500")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final int getWaitQueueLength() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1707560830 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            int n;
            n = 0;
            {
                Node w;
                w = firstWaiter;
                w = w.nextWaiter;
                {
                    ++n;
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:13:24.918 -0400", hash_original_method = "D1136CB2B0FE173AD3F139F996FAE8B5", hash_generated_method = "0B12E0E262BCA8EADE5933C8F1C2D0F7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final Collection<Thread> getWaitingThreads() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1806775597 = (!isHeldExclusively());
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
            return (Collection<Thread>)dsTaint.getTaint();
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

        
    }


    
    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                (AbstractQueuedLongSynchronizer.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset
                (AbstractQueuedLongSynchronizer.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                (AbstractQueuedLongSynchronizer.class.getDeclaredField("tail"));
            waitStatusOffset = unsafe.objectFieldOffset
                (Node.class.getDeclaredField("waitStatus"));
            nextOffset = unsafe.objectFieldOffset
                (Node.class.getDeclaredField("next"));
        } catch (Exception ex) { throw new Error(ex); }
    }
    
}


