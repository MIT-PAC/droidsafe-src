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
    private transient volatile Node head;
    private transient volatile Node tail;
    private volatile int state;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.150 -0400", hash_original_method = "C7F1FA27B1E7517E25F1C7951B5E8CA8", hash_generated_method = "D0F5CBC29675A9CABCA264BF6F7A7644")
    @DSModeled(DSC.SAFE)
    protected AbstractQueuedSynchronizer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.151 -0400", hash_original_method = "15A8F8E5739EB2961628EAE8F68BF29F", hash_generated_method = "8E975A5B19E8C2C420B76156D3B7CEF5")
    @DSModeled(DSC.SAFE)
    protected final int getState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.151 -0400", hash_original_method = "57BE013BA515294E586014B30A336C04", hash_generated_method = "2088A6FE2517D6565BCB31C53CDBB963")
    @DSModeled(DSC.SAFE)
    protected final void setState(int newState) {
        dsTaint.addTaint(newState);
        // ---------- Original Method ----------
        //state = newState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.151 -0400", hash_original_method = "DF00243144DD556AB3E9A0ABE3AEC78F", hash_generated_method = "1C0D7EA50FAFC20EA9B794D78E7D6404")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final boolean compareAndSetState(int expect, int update) {
        dsTaint.addTaint(update);
        dsTaint.addTaint(expect);
        boolean var281C41540058F29F0DB0A762C52DDE13_149583434 = (unsafe.compareAndSwapInt(this, stateOffset, expect, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.152 -0400", hash_original_method = "D115C79C5FCCB59668763118EBD8CBBB", hash_generated_method = "D6210A079E51A952E87900069751A036")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Node enq(final Node node) {
        dsTaint.addTaint(node.dsTaint);
        {
            Node t;
            t = tail;
            {
                {
                    boolean varC2BD7D899FDAEA316177871081826EFD_498208228 = (compareAndSetHead(new Node()));
                    tail = head;
                } //End collapsed parenthetic
            } //End block
            {
                node.prev = t;
                {
                    boolean var30CFF97C04D4F21E508F35AC3CDBADC7_387052508 = (compareAndSetTail(t, node));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.152 -0400", hash_original_method = "7269E5EC16B8883F661BF745CCC5E6A6", hash_generated_method = "2036A6E3A07EBD9FCEE7B81422D54D74")
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
                boolean varB759FEC06526555CC952C851C67B8004_1786640531 = (compareAndSetTail(pred, node));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.153 -0400", hash_original_method = "51AEDFDDD323C78EE2EC4A6DE568B8D1", hash_generated_method = "5210379EAA462490775B5BC50BBECC7B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.153 -0400", hash_original_method = "F262A3A18BABECF7EC492736953EAF6E", hash_generated_method = "2AA34F4FFA5397F7EDAD627FC960FDCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.154 -0400", hash_original_method = "D8D55646997B45206CD2F0528B603753", hash_generated_method = "7E0547D1D5D8E2A671720D8BB11C2D0F")
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
                        boolean varCC865867FC8DEDE4843F9E3D62245755_352388207 = (!compareAndSetWaitStatus(h, Node.SIGNAL, 0));
                    } //End collapsed parenthetic
                    unparkSuccessor(h);
                } //End block
                {
                    boolean var658C7F41A73D231A5E38D15A1070790F_562624164 = (ws == 0 &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.154 -0400", hash_original_method = "A2FB30DAE399AEFA487E20396027BD36", hash_generated_method = "631CC31784FA18F5F990A2F89A7E85AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setHeadAndPropagate(Node node, int propagate) {
        dsTaint.addTaint(node.dsTaint);
        dsTaint.addTaint(propagate);
        Node h;
        h = head;
        setHead(node);
        {
            Node s;
            s = node.next;
            {
                boolean varB6D0E63ACFCFA5DA33C33F91435930F9_987651654 = (s == null || s.isShared());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.155 -0400", hash_original_method = "1CA41B58715410C4216B9DE6C43BB9D4", hash_generated_method = "FFE02B8353688788BC3986FDD2A75F40")
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
            boolean var9C67AE94C69ECBB4560E786F86E10C76_912497678 = (node == tail && compareAndSetTail(node, pred));
            {
                compareAndSetNext(pred, predNext, null);
            } //End block
            {
                int ws;
                {
                    boolean var806CB84C61F87A678A0A252FCBFAAB06_1035408294 = (pred != head &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.156 -0400", hash_original_method = "C551D5FD0C0A2C72DAD755E48C68905F", hash_generated_method = "10A1E62785D9327BF374FEC94CD5D85A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final boolean parkAndCheckInterrupt() {
        LockSupport.park(this);
        boolean var17A536D12FEB0466CF9F0EDC1509A805_1273323779 = (Thread.interrupted());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //LockSupport.park(this);
        //return Thread.interrupted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.156 -0400", hash_original_method = "0D7553B7A8DFDAC7C355CECFA0DBF574", hash_generated_method = "04841704D7B610F0A2AEC572AFEEA129")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean acquireQueued(final Node node, int arg) {
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
                    boolean varB702A2D695A14FF8E8F201BF2E513471_503351483 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_1954136603 = (shouldParkAfterFailedAcquire(p, node) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.157 -0400", hash_original_method = "E74C4677EAF9B6C97A4A9A93D88FC71E", hash_generated_method = "D3B4C2886D67969DDC8541DBCAD3A729")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doAcquireInterruptibly(int arg) throws InterruptedException {
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
                    boolean varB702A2D695A14FF8E8F201BF2E513471_618800452 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_922837649 = (shouldParkAfterFailedAcquire(p, node) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.157 -0400", hash_original_method = "AF980EBAC4BC6C4AB1174BED3B10073B", hash_generated_method = "B3611F88EDB1F31E6F8CF7F74BDF5940")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean doAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
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
                    boolean varB702A2D695A14FF8E8F201BF2E513471_1548333358 = (p == head && tryAcquire(arg));
                    {
                        setHead(node);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var00B5F1835D8E1D445CE64BB60FAD1503_228821734 = (shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold);
                    LockSupport.parkNanos(this, nanosTimeout);
                } //End collapsed parenthetic
                long now;
                now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                {
                    boolean varFDD1D09D0FE11E5BCA86E55DE77A8E11_1046792266 = (Thread.interrupted());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.157 -0400", hash_original_method = "D66678B4038334D8E14600B3A8FC8FD7", hash_generated_method = "C5CF1FCE25567A2670BB8023B7B908FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doAcquireShared(int arg) {
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
                    boolean var9C0B051AA94D017E376D03A90C5698A7_596276119 = (shouldParkAfterFailedAcquire(p, node) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.158 -0400", hash_original_method = "4E093FA1B6FCF5593272CE0DEA00D69B", hash_generated_method = "9AC2ABCF338B4E6226ABCE2467DC22E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doAcquireSharedInterruptibly(int arg) throws InterruptedException {
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
                    int r;
                    r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End block
                {
                    boolean var9C0B051AA94D017E376D03A90C5698A7_1304802644 = (shouldParkAfterFailedAcquire(p, node) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.158 -0400", hash_original_method = "873D99639E9E59C87CD3A574B36E4573", hash_generated_method = "FDEDE7D16D36E401772A94A0DA54A922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean doAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
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
                    int r;
                    r = tryAcquireShared(arg);
                    {
                        setHeadAndPropagate(node, r);
                        p.next = null;
                        failed = false;
                    } //End block
                } //End block
                {
                    boolean var00B5F1835D8E1D445CE64BB60FAD1503_610340698 = (shouldParkAfterFailedAcquire(p, node) &&
                    nanosTimeout > spinForTimeoutThreshold);
                    LockSupport.parkNanos(this, nanosTimeout);
                } //End collapsed parenthetic
                long now;
                now = System.nanoTime();
                nanosTimeout -= now - lastTime;
                lastTime = now;
                {
                    boolean varFDD1D09D0FE11E5BCA86E55DE77A8E11_1264645377 = (Thread.interrupted());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.158 -0400", hash_original_method = "FADA99D99649E8B049B596B89A86AFE3", hash_generated_method = "E53BCAC1A2EEC6BA908021262CD9C0A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean tryAcquire(int arg) {
        dsTaint.addTaint(arg);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.159 -0400", hash_original_method = "0AA9B3926B88397CF769442818D9CA16", hash_generated_method = "485E3267FC608DD42B0B998584647418")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean tryRelease(int arg) {
        dsTaint.addTaint(arg);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.159 -0400", hash_original_method = "143AB2DE4C7A8CA8F45FD3C862AFB93B", hash_generated_method = "974D8F2CF66C0ACF865717700A3FEA38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int tryAcquireShared(int arg) {
        dsTaint.addTaint(arg);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.159 -0400", hash_original_method = "57760B0E19163CFD26451EB4C702B2B7", hash_generated_method = "7C6702BD6E60ED4A6E045901CF2D51F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean tryReleaseShared(int arg) {
        dsTaint.addTaint(arg);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.159 -0400", hash_original_method = "B1A3EF7BA2A74EEB6B3236F0A99ED9FE", hash_generated_method = "B47FC36CCB09A3A9A73EFF267AC5722A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean isHeldExclusively() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.159 -0400", hash_original_method = "10DE26F4AB94E5F1867D5F821F4BF0D7", hash_generated_method = "9AF9F515771F0DDBFF4916E07BBD0CDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void acquire(int arg) {
        dsTaint.addTaint(arg);
        {
            boolean varFCEF5DD222F9CABA3FDCCFE99D21AA7A_1897596328 = (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg));
            selfInterrupt();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!tryAcquire(arg) &&
            //acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            //selfInterrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.159 -0400", hash_original_method = "34DE0EEECFCC486100F3F952023E1D48", hash_generated_method = "AAF3F05C61A4AF55FD961607268D0347")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void acquireInterruptibly(int arg) throws InterruptedException {
        dsTaint.addTaint(arg);
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1476142422 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        {
            boolean var6C80CD83DDCC36721F42CDF9EFE1FC97_688819149 = (!tryAcquire(arg));
            doAcquireInterruptibly(arg);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (!tryAcquire(arg))
            //doAcquireInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.160 -0400", hash_original_method = "C2BC4409CE226EEA6D2598B40FA64E1C", hash_generated_method = "87CCEECB0B4547AB782454307AC052EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean tryAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(nanosTimeout);
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1997284049 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        boolean var34DCAB88C8A0F240E32D599EDB2FE196_905525607 = (tryAcquire(arg) ||
            doAcquireNanos(arg, nanosTimeout));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquire(arg) ||
            //doAcquireNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.160 -0400", hash_original_method = "482847B9E820B21E98E389768A5050E4", hash_generated_method = "EB3952783026E7C438479463EDD851FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean release(int arg) {
        dsTaint.addTaint(arg);
        {
            boolean varFF82B8E2BC2E04000CA63D87A88AB8D2_1407366777 = (tryRelease(arg));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.194 -0400", hash_original_method = "503864E706CF656D09684EB1E461773D", hash_generated_method = "8DC316B63E3C70220819C3F19A84DEBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void acquireShared(int arg) {
        dsTaint.addTaint(arg);
        {
            boolean varE24C999E8142A86B0EF4E6AFA805A8A0_1533264157 = (tryAcquireShared(arg) < 0);
            doAcquireShared(arg);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (tryAcquireShared(arg) < 0)
            //doAcquireShared(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.195 -0400", hash_original_method = "10425BDCE3B0F2DAA2E0ECCAD9B4BACD", hash_generated_method = "DDEFF2C055ECA0B9C4ECCA2126636EDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void acquireSharedInterruptibly(int arg) throws InterruptedException {
        dsTaint.addTaint(arg);
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1084046884 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        {
            boolean varE24C999E8142A86B0EF4E6AFA805A8A0_1468055196 = (tryAcquireShared(arg) < 0);
            doAcquireSharedInterruptibly(arg);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //if (tryAcquireShared(arg) < 0)
            //doAcquireSharedInterruptibly(arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.195 -0400", hash_original_method = "34AA5C57E6BB40898FDB5D4BB2EF37C3", hash_generated_method = "6087FC039D33925E8F6DE8DFC35D4F30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean tryAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(nanosTimeout);
        {
            boolean var59C8EE922E8B3738507C43FFF99EACF7_1878241679 = (Thread.interrupted());
            if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
        } //End collapsed parenthetic
        boolean varE4B1D6DE7AE03DFEE28CA37F75A87EB4_542868266 = (tryAcquireShared(arg) >= 0 ||
            doAcquireSharedNanos(arg, nanosTimeout));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (Thread.interrupted())
            //throw new InterruptedException();
        //return tryAcquireShared(arg) >= 0 ||
            //doAcquireSharedNanos(arg, nanosTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.195 -0400", hash_original_method = "64AF2599D3C05FF36535D67856367D8D", hash_generated_method = "EC1B7DDD37E6E2E901195C7E8F6D2CD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean releaseShared(int arg) {
        dsTaint.addTaint(arg);
        {
            boolean varEB9480595F3C382515F926391F6AAE14_1412998584 = (tryReleaseShared(arg));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.195 -0400", hash_original_method = "3ACA5092770D7AD1442898AF3B627DFE", hash_generated_method = "1926303FC75B8D39BD806D6A99DC4BFE")
    @DSModeled(DSC.SAFE)
    public final boolean hasQueuedThreads() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return head != tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.195 -0400", hash_original_method = "3ED9D0D071477B613E998B33D61DD4C5", hash_generated_method = "73A1347608DAD9D5EBD1DD381E8F73F6")
    @DSModeled(DSC.SAFE)
    public final boolean hasContended() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return head != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.196 -0400", hash_original_method = "DB23AE447B60E978D848F5CEAEC8257B", hash_generated_method = "888A12A67EEE89CBDA3FCA12D8C7221B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Thread getFirstQueuedThread() {
        {
            Object var3B7CB660AB505354CD602C60DFD0581B_2070697224 = (fullGetFirstQueuedThread());
        } //End flattened ternary
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (head == tail) ? null : fullGetFirstQueuedThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.196 -0400", hash_original_method = "18818CB637EBC5CF82DC4C50B37FB17C", hash_generated_method = "166FF2223F7AA85753D63A8740069CFB")
    @DSModeled(DSC.SAFE)
    private Thread fullGetFirstQueuedThread() {
        Node h, s;
        Thread st;
        {
            boolean varAB96948AFE2AAAF3BBF624BD73ABA985_1855476912 = (((h = head) != null && (s = h.next) != null &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.196 -0400", hash_original_method = "1573E83A14D593E0BFADABB9AEDBB7D2", hash_generated_method = "06470FC6882E6A5D0BA87A82DEEE6C08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.197 -0400", hash_original_method = "4993AFB2E466C494E10B5DA4780E51AB", hash_generated_method = "E3DAFF547232270EFBB70DD2E4BAE6CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean apparentlyFirstQueuedIsExclusive() {
        Node h, s;
        boolean var7A2694C8A18196F041BDCF2FCD7324AE_2070840412 = ((h = head) != null &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.197 -0400", hash_original_method = "155F6B01F514C41CA8367710346D37E3", hash_generated_method = "4CF5DAD1CDB6D42763118ACEAE979FCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedPredecessors() {
        Node t;
        t = tail;
        Node h;
        h = head;
        Node s;
        boolean var4B72E4D0E536DE6B3ACB8283BCD4F664_422805301 = (h != t &&
            ((s = h.next) == null || s.thread != Thread.currentThread()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Node t = tail;
        //Node h = head;
        //Node s;
        //return h != t &&
            //((s = h.next) == null || s.thread != Thread.currentThread());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.197 -0400", hash_original_method = "65AB677A04652631BF1CC269A789F93A", hash_generated_method = "5350739B623E9F444E0C8FF5347CCDD3")
    @DSModeled(DSC.SAFE)
    public final int getQueueLength() {
        int n;
        n = 0;
        {
            Node p;
            p = tail;
            p = p.prev;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.197 -0400", hash_original_method = "BA97C075FB0E9B39CEF398B585209CAD", hash_generated_method = "902C56B06DD343BBAC574FD6CE5F83A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.197 -0400", hash_original_method = "8F9C05C78C38CDEC6B94C7386A00C30C", hash_generated_method = "66D4C423546E439158A7107621BB118A")
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
                    boolean varDFA54A0E0CB503BCC5CE98449AAB2A08_1518817635 = (!p.isShared());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.198 -0400", hash_original_method = "3B2BC348731488178C75B0F7C3256BE4", hash_generated_method = "4C7C6938284C80064A790998F1EB1065")
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
                    boolean varC6C07EC060C76D1E58FED758F007D903_1133831126 = (p.isShared());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.198 -0400", hash_original_method = "2C49C090DBE6788B4A91D995132AEECA", hash_generated_method = "D4153D152CC2B235FB95CAC182B00547")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        int s;
        s = getState();
        String q;
        boolean var58703E822CB7EE24CF8A625587E1C63E_766230039 = (hasQueuedThreads());
        q = "non";
        q = "";
        String varA627899E43EA43F388C27ED3471D90CE_243942170 = (super.toString() +
            "[State = " + s + ", " + q + "empty queue]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int s = getState();
        //String q  = hasQueuedThreads() ? "non" : "";
        //return super.toString() +
            //"[State = " + s + ", " + q + "empty queue]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.198 -0400", hash_original_method = "0981A7B7481B56654552F826D97FC7A4", hash_generated_method = "A901D15F8103E8FDBC66F7286E9C9C35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean isOnSyncQueue(Node node) {
        dsTaint.addTaint(node.dsTaint);
        boolean varF3A4D6770CAC1AA85AF3A6C51812BE70_1637527454 = (findNodeFromTail(node));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (node.waitStatus == Node.CONDITION || node.prev == null)
            //return false;
        //if (node.next != null) 
            //return true;
        //return findNodeFromTail(node);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.198 -0400", hash_original_method = "E84A510853D9F9659F34649D5E631E14", hash_generated_method = "3BB04F151AAAD586B19DE78139480C4D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.199 -0400", hash_original_method = "AC7EB2A7C3E5842E27808853E2EADEA4", hash_generated_method = "EFB284CA3526E2923E99A11DCB33F821")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean transferForSignal(Node node) {
        dsTaint.addTaint(node.dsTaint);
        {
            boolean var8F78D6E41179A92913D59E278DAF4713_2040604341 = (!compareAndSetWaitStatus(node, Node.CONDITION, 0));
        } //End collapsed parenthetic
        Node p;
        p = enq(node);
        int ws;
        ws = p.waitStatus;
        {
            boolean var11909F9DE762D0C62EFBB539D3DF08AB_1483248538 = (ws > 0 || !compareAndSetWaitStatus(p, ws, Node.SIGNAL));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.199 -0400", hash_original_method = "202AE2159172221E521994FECA693914", hash_generated_method = "3C205C19A86113370AB05C526002FA4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean transferAfterCancelledWait(Node node) {
        dsTaint.addTaint(node.dsTaint);
        {
            boolean varAB52CB6F165D0797C877670E5EE00069_1388536983 = (compareAndSetWaitStatus(node, Node.CONDITION, 0));
            {
                enq(node);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA5ECD06A31929CB111AEF5ECED825AFB_2034573624 = (!isOnSyncQueue(node));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.199 -0400", hash_original_method = "13260C05A29655F6FC8F2FA182B20EC8", hash_generated_method = "A1B3896BD7D60FFFD49B447425CC0EF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final int fullyRelease(Node node) {
        dsTaint.addTaint(node.dsTaint);
        boolean failed;
        failed = true;
        try 
        {
            int savedState;
            savedState = getState();
            {
                boolean var3C6705464C8EDF86A554C3C7455FE111_1691801365 = (release(savedState));
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.199 -0400", hash_original_method = "B60D02054E03A30F41C10CC4F7B33B2F", hash_generated_method = "818645E43AD76523A25286361AD363EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean owns(ConditionObject condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        boolean var81F8FCB295780CD2D5751E1181CC9428_1330916858 = (condition.isOwnedBy(this));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //return condition.isOwnedBy(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.199 -0400", hash_original_method = "B87CA02CD99C2C81A6ADCC153DE8BF7D", hash_generated_method = "D6E408D1511A35500D4D30E3173C691D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasWaiters(ConditionObject condition) {
        dsTaint.addTaint(condition.dsTaint);
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_1046937326 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } //End collapsed parenthetic
        boolean var335079E40CDAA9EFDA14CFAFE44A0835_2116742447 = (condition.hasWaiters());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.hasWaiters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.200 -0400", hash_original_method = "FDFBF2604A26737643DD133E9F8A257F", hash_generated_method = "C62485655265947BE916945F0C0786CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getWaitQueueLength(ConditionObject condition) {
        dsTaint.addTaint(condition.dsTaint);
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_1577165814 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } //End collapsed parenthetic
        int var5991F4798FCDE9B9D32781CE8A86C9C1_1430367408 = (condition.getWaitQueueLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.200 -0400", hash_original_method = "70972013E049E7504ADBD56143485C77", hash_generated_method = "8F44FC4B2430437DFB2C1C74DF9A2FFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Collection<Thread> getWaitingThreads(ConditionObject condition) {
        dsTaint.addTaint(condition.dsTaint);
        {
            boolean varF6FA8CE34847109F1EDDCFA2A2B550C8_1422048224 = (!owns(condition));
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Not owner");
        } //End collapsed parenthetic
        Collection<Thread> var36A2E52470B9D7B4821E23B59E8D5DE3_1356509876 = (condition.getWaitingThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!owns(condition))
            //throw new IllegalArgumentException("Not owner");
        //return condition.getWaitingThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.200 -0400", hash_original_method = "20D2259271C7B1C96C133ACBD2C26B14", hash_generated_method = "119E27C16F085B92486972C8C3C71AEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final boolean compareAndSetHead(Node update) {
        dsTaint.addTaint(update.dsTaint);
        boolean var7C9BAC36D5138868FE92F3C1948386AB_19878794 = (unsafe.compareAndSwapObject(this, headOffset, null, update));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.200 -0400", hash_original_method = "8C47C531A43F622294BF6051B04C8993", hash_generated_method = "A2EF8015A917535E9AE246A5E4EB6B8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final boolean compareAndSetTail(Node expect, Node update) {
        dsTaint.addTaint(update.dsTaint);
        dsTaint.addTaint(expect.dsTaint);
        boolean varC5CCFD292C10D03F1C8C777B8815D2E2_1482802689 = (unsafe.compareAndSwapObject(this, tailOffset, expect, update));
        return dsTaint.getTaintBoolean();
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
        volatile int waitStatus;
        volatile Node prev;
        volatile Node next;
        volatile Thread thread;
        Node nextWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.201 -0400", hash_original_method = "2DD8BF5485F2495811D83404AF44A29C", hash_generated_method = "AAE5751DE21B256CB4EDD0DDB605F24E")
        @DSModeled(DSC.SAFE)
         Node() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.201 -0400", hash_original_method = "764EF23A3C66C99D5E5160039F46E6BD", hash_generated_method = "54E531E3602058910E4DEE08059882EF")
        @DSModeled(DSC.SAFE)
         Node(Thread thread, Node mode) {
            dsTaint.addTaint(thread.dsTaint);
            dsTaint.addTaint(mode.dsTaint);
            // ---------- Original Method ----------
            //this.nextWaiter = mode;
            //this.thread = thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.201 -0400", hash_original_method = "5118904E6021AE155CDFF15DB609BD48", hash_generated_method = "E4B75623035EB5337E7111134A811EBE")
        @DSModeled(DSC.SAFE)
         Node(Thread thread, int waitStatus) {
            dsTaint.addTaint(thread.dsTaint);
            dsTaint.addTaint(waitStatus);
            // ---------- Original Method ----------
            //this.waitStatus = waitStatus;
            //this.thread = thread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.201 -0400", hash_original_method = "EA506AD78E2AE8ACF234FE0610B9A575", hash_generated_method = "6F1E0E258120A81BA69DC057AD95A263")
        @DSModeled(DSC.SAFE)
        final boolean isShared() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nextWaiter == SHARED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.201 -0400", hash_original_method = "7AA5CFB77F71DE2C6FFA937BCE62ADAE", hash_generated_method = "9670B1B52BFF85027385032D16C5B6D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        static final Node SHARED = new Node();
        static final Node EXCLUSIVE = null;
        static final int CANCELLED =  1;
        static final int SIGNAL    = -1;
        static final int CONDITION = -2;
        static final int PROPAGATE = -3;
    }


    
    public class ConditionObject implements Condition, java.io.Serializable {
        private transient Node firstWaiter;
        private transient Node lastWaiter;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.201 -0400", hash_original_method = "0A3E2C1E27BAEA738FDF96AD17500BEE", hash_generated_method = "6AF9B0E3D406E6C56AA07F09E795B0E2")
        @DSModeled(DSC.SAFE)
        public ConditionObject() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.202 -0400", hash_original_method = "43F5E066353E431B2C9AD7CD0397BCCF", hash_generated_method = "01D874DAA3D0A265959A9CF5AE46AB3C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.202 -0400", hash_original_method = "74B8316ED8B5F40365D8BD9CF002AB2D", hash_generated_method = "86F47601EFA8B1FDC36708CD65C0A66E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void doSignal(Node first) {
            dsTaint.addTaint(first.dsTaint);
            {
                {
                    boolean varBC585BCE36C017A7C94055DA929092A7_1697038473 = ((firstWaiter = first.nextWaiter) == null);
                    lastWaiter = null;
                } //End collapsed parenthetic
                first.nextWaiter = null;
            } //End block
            {
                boolean var608C6B17E7E10DD5072B7876717FB9A1_1422398810 = (!transferForSignal(first) &&
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.202 -0400", hash_original_method = "DE4F68C515AD9FDEF86DCFCC83AF390E", hash_generated_method = "7B55B834A1B864B0F4AB6937CFE4E2C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.202 -0400", hash_original_method = "2AF991EC026F340CB09E7C74A01E5A9A", hash_generated_method = "3356A25D8D13BF5A01088971CA423629")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.203 -0400", hash_original_method = "217DDC96D1B25C0D1457937D523A3AA4", hash_generated_method = "D596EC9A010EB530EB03F247DB1B60A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void signal() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_472381675 = (!isHeldExclusively());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.203 -0400", hash_original_method = "8098E0901B1513A38FF0251B40A20DA9", hash_generated_method = "866AD9E3D1237B712315897169794886")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void signalAll() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_70410909 = (!isHeldExclusively());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.203 -0400", hash_original_method = "03B567BE1E70F2310FD90D1C09544B27", hash_generated_method = "73EBB22532FC3D9E753721EC2FD27189")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void awaitUninterruptibly() {
            Node node;
            node = addConditionWaiter();
            int savedState;
            savedState = fullyRelease(node);
            boolean interrupted;
            interrupted = false;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_2064192103 = (!isOnSyncQueue(node));
                {
                    LockSupport.park(this);
                    {
                        boolean varA664C6144AE4C03C0F8F972E8F70F7E8_796601239 = (Thread.interrupted());
                        interrupted = true;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var17DE45DCF221A6E3B338FD5BCAB95962_57320907 = (acquireQueued(node, savedState) || interrupted);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.204 -0400", hash_original_method = "5CA3F4E55230C1BE0E77A65DF87A61F3", hash_generated_method = "40295928E0A507AE246751BB1BE3D166")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int checkInterruptWhileWaiting(Node node) {
            dsTaint.addTaint(node.dsTaint);
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_1649857849 = (Thread.interrupted());
                Object varE3D941AA1F8858C4DCE68CB723942357_1694515528 = ((transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT)); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End flattened ternary
            //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Thread.interrupted() ?
                //(transferAfterCancelledWait(node) ? THROW_IE : REINTERRUPT) :
                //0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.204 -0400", hash_original_method = "5304D5C5F98F936C59A15960318DA98F", hash_generated_method = "AC7CD6AB2210C5945975486B4D92E78E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.204 -0400", hash_original_method = "316B8F22454E74CF1A9F01045EC67EC6", hash_generated_method = "78B704DCFDBDF2FAC0220E09A4C4E1A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void await() throws InterruptedException {
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_2024941382 = (Thread.interrupted());
                if (DroidSafeAndroidRuntime.control) throw new InterruptedException();
            } //End collapsed parenthetic
            Node node;
            node = addConditionWaiter();
            int savedState;
            savedState = fullyRelease(node);
            int interruptMode;
            interruptMode = 0;
            {
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_408289386 = (!isOnSyncQueue(node));
                {
                    LockSupport.park(this);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_1986797060 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_1184935818 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.204 -0400", hash_original_method = "46C34832DD3406F7F3C664FF7A3A79B4", hash_generated_method = "12A0E09C8B0FBBD3D5889BB266373AAA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final long awaitNanos(long nanosTimeout) throws InterruptedException {
            dsTaint.addTaint(nanosTimeout);
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_562017246 = (Thread.interrupted());
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
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1364957196 = (!isOnSyncQueue(node));
                {
                    {
                        transferAfterCancelledWait(node);
                    } //End block
                    LockSupport.parkNanos(this, nanosTimeout);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_1285841667 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                    long now;
                    now = System.nanoTime();
                    nanosTimeout -= now - lastTime;
                    lastTime = now;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_1786863191 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            long var0AE99C9194A9E8813170658867C876DB_1759425233 = (nanosTimeout - (System.nanoTime() - lastTime));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.205 -0400", hash_original_method = "9B6F9AFE5FC55A4D3153D2EEB76307B9", hash_generated_method = "A7809F7888B7AFF8BA33E9F8A66C8517")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean awaitUntil(Date deadline) throws InterruptedException {
            dsTaint.addTaint(deadline.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            long abstime;
            abstime = deadline.getTime();
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_716294017 = (Thread.interrupted());
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
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_1687727529 = (!isOnSyncQueue(node));
                {
                    {
                        boolean varD36E947A894CF1227DF67FCDA3A195E9_667382577 = (System.currentTimeMillis() > abstime);
                        {
                            timedout = transferAfterCancelledWait(node);
                        } //End block
                    } //End collapsed parenthetic
                    LockSupport.parkUntil(this, abstime);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_627345362 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_348246108 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.205 -0400", hash_original_method = "BFE4D71142E465ECC716594C0843F211", hash_generated_method = "F5C58F397D42790A0B2343076BB228BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean await(long time, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(time);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            long nanosTimeout;
            nanosTimeout = unit.toNanos(time);
            {
                boolean var0E37FE7B424140ECEE412D02939B568B_479666773 = (Thread.interrupted());
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
                boolean var7669BC6629557DFF8ED85859E0E0A9CB_972768413 = (!isOnSyncQueue(node));
                {
                    {
                        timedout = transferAfterCancelledWait(node);
                    } //End block
                    LockSupport.parkNanos(this, nanosTimeout);
                    {
                        boolean var6AE23BDEA9D63180A0E3C204AF41FD36_1064096058 = ((interruptMode = checkInterruptWhileWaiting(node)) != 0);
                    } //End collapsed parenthetic
                    long now;
                    now = System.nanoTime();
                    nanosTimeout -= now - lastTime;
                    lastTime = now;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var9A8AD69289DFCA583A17189FA6FE1B11_2063573650 = (acquireQueued(node, savedState) && interruptMode != THROW_IE);
                interruptMode = REINTERRUPT;
            } //End collapsed parenthetic
            unlinkCancelledWaiters();
            reportInterruptAfterWait(interruptMode);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.205 -0400", hash_original_method = "165B5BC520C58D38E1ED3303B481AD06", hash_generated_method = "6A59CEA3BC5880D7AB367E036C9B2F96")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean isOwnedBy(AbstractQueuedSynchronizer sync) {
            dsTaint.addTaint(sync.dsTaint);
            boolean var2A8E0121C9EBA5DBD487804D196CA981_76244728 = (sync == AbstractQueuedSynchronizer.this);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync == AbstractQueuedSynchronizer.this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.206 -0400", hash_original_method = "5570422C2D22E250B14B7FB8C176D89A", hash_generated_method = "BBCF97675A567FAFB9D4207F902278BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean hasWaiters() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1762442327 = (!isHeldExclusively());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.206 -0400", hash_original_method = "586699B2B19676C29FE19392CDC481BB", hash_generated_method = "FD802F74270AB8DD464F57CF222CD703")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final int getWaitQueueLength() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_148353248 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            int n;
            n = 0;
            {
                Node w;
                w = firstWaiter;
                w = w.nextWaiter;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.206 -0400", hash_original_method = "D1136CB2B0FE173AD3F139F996FAE8B5", hash_generated_method = "817BE8AC455549E43A6D033A9A5CCC31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final Collection<Thread> getWaitingThreads() {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1439892869 = (!isHeldExclusively());
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

        
        private static final long serialVersionUID = 1173984872572414699L;
        private static final int REINTERRUPT =  1;
        private static final int THROW_IE    = -1;
    }


    
    private static final long serialVersionUID = 7373984972572414691L;
    static final long spinForTimeoutThreshold = 1000L;
    private static final Unsafe unsafe = UnsafeAccess.THE_ONE;
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;
    private static final long waitStatusOffset;
    private static final long nextOffset;
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

