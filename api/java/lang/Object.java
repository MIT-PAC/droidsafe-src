package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSTaintObject;

public class Object {
    
    // orphaned legacy field
    public DSTaintObject taint;
    /**
     * Constructs a new instance of {@code Object}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.129 -0500", hash_original_method = "1035BC9FD37C3D2AC57825226BBB0539", hash_generated_method = "D31E84B79A4FC29F631370F22BA60293")
    
public Object() {
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.382 -0400", hash_original_method = "6E1D6DBADCF2AAA505FF9A52A4C04C6C", hash_generated_method = "7BD08C4B7BD9668043F5624AF55451A4")
    protected Object clone() throws CloneNotSupportedException {
        if(!(this instanceof Cloneable))        
        {
            CloneNotSupportedException varAAEB03D14830D479070633B166EED001_1798330854 = new CloneNotSupportedException("Class doesn't implement Cloneable");
            varAAEB03D14830D479070633B166EED001_1798330854.addTaint(taint);
            throw varAAEB03D14830D479070633B166EED001_1798330854;
        } //End block
        
        //fix for cloning, just return this statement
        
        return this;
        // ---------- Original Method ----------
        //if (!(this instanceof Cloneable)) {
            //throw new CloneNotSupportedException("Class doesn't implement Cloneable");
        //}
        //return internalClone((Cloneable) this);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.633 -0400", hash_original_method = "DC17854DB4C4786A4B8C4AFD2060B404", hash_generated_method = "A43E05FEA5D61737BBCA795F23B88103")
    
    private Object internalClone(Cloneable o) {
    	 //Object retVal = new Object();
    	//retVal.addTaint(getTaint());
        
        //fix for cloning, just return the this statement
    	return this;
    }

    /**
     * Compares this instance with the specified object and indicates if they
     * are equal. In order to be equal, {@code o} must represent the same object
     * as this instance using a class-specific comparison. The general contract
     * is that this comparison should be reflexive, symmetric, and transitive.
     * Also, no object reference other than null is equal to null.
     *
     * <p>The default implementation returns {@code true} only if {@code this ==
     * o}. See <a href="{@docRoot}reference/java/lang/Object.html#writing_equals">Writing a correct
     * {@code equals} method</a>
     * if you intend implementing your own {@code equals} method.
     *
     * <p>The general contract for the {@code equals} and {@link
     * #hashCode()} methods is that if {@code equals} returns {@code true} for
     * any two objects, then {@code hashCode()} must return the same value for
     * these objects. This means that subclasses of {@code Object} usually
     * override either both methods or neither of them.
     *
     * @param o
     *            the object to compare this instance with.
     * @return {@code true} if the specified object is equal to this {@code
     *         Object}; {@code false} otherwise.
     * @see #hashCode
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.140 -0500", hash_original_method = "9AE1611573D7E7CF89E7E933B2D1DCAF", hash_generated_method = "9814B1EDD6A309DF77DC31113B9908C5")
    @DSVerified()
public boolean equals(Object o) {
        return this == o;
    }

    /**
     * Invoked when the garbage collector has detected that this instance is no longer reachable.
     * The default implementation does nothing, but this method can be overridden to free resources.
     *
     * <p>Note that objects that override {@code finalize} are significantly more expensive than
     * objects that don't. Finalizers may be run a long time after the object is no longer
     * reachable, depending on memory pressure, so it's a bad idea to rely on them for cleanup.
     * Note also that finalizers are run on a single VM-wide finalizer thread,
     * so doing blocking work in a finalizer is a bad idea. A finalizer is usually only necessary
     * for a class that has a native peer and needs to call a native method to destroy that peer.
     * Even then, it's better to provide an explicit {@code close} method (and implement
     * {@link java.io.Closeable}), and insist that callers manually dispose of instances. This
     * works well for something like files, but less well for something like a {@code BigInteger}
     * where typical calling code would have to deal with lots of temporaries. Unfortunately,
     * code that creates lots of temporaries is the worst kind of code from the point of view of
     * the single finalizer thread.
     *
     * <p>If you <i>must</i> use finalizers, consider at least providing your own
     * {@link java.lang.ref.ReferenceQueue} and having your own thread process that queue.
     *
     * <p>Unlike constructors, finalizers are not automatically chained. You are responsible for
     * calling {@code super.finalize()} yourself.
     *
     * <p>Uncaught exceptions thrown by finalizers are ignored and do not terminate the finalizer
     * thread.
     *
     * See <i>Effective Java</i> Item 7, "Avoid finalizers" for more.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.142 -0500", hash_original_method = "D7EA50355B500A6304213C79BC9E9E09", hash_generated_method = "7BAE00D5214727B96165F35F1A10FDEF")
    
@FindBugsSuppressWarnings("FI_EMPTY")
    @DSVerified
    protected void finalize() throws Throwable {
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 13:18:45.696 -0400", hash_original_method = "45F37CFDFF4C9798D584EC7971F96E39", hash_generated_method = "626427EC1E11FF0AD97BEE85D9A44D76")
    
    public final native Class<?> getClass();

    /**
     * Returns an integer hash code for this object. By contract, any two
     * objects for which {@link #equals} returns {@code true} must return
     * the same hash code value. This means that subclasses of {@code Object}
     * usually override both methods or neither method.
     *
     * <p>Note that hash values must not change over time unless information used in equals
     * comparisons also changes.
     *
     * <p>See <a href="{@docRoot}reference/java/lang/Object.html#writing_hashCode">Writing a correct
     * {@code hashCode} method</a>
     * if you intend implementing your own {@code hashCode} method.
     *
     * @return this object's hash code.
     * @see #equals
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.150 -0500", hash_original_method = "55C270AB7FB96DF5C59CA61A88D62880", hash_generated_method = "1752793FA5EABF016299BFC6474E6534")
    @DSVerified()
    public int hashCode(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Causes a thread which is waiting on this object's monitor (by means of
     * calling one of the {@code wait()} methods) to be woken up. If more than
     * one thread is waiting, one of them is chosen at the discretion of the
     * VM. The chosen thread will not run immediately. The thread
     * that called {@code notify()} has to release the object's monitor first.
     * Also, the chosen thread still has to compete against other threads that
     * try to synchronize on the same object.
     * <p>
     * This method can only be invoked by a thread which owns this object's
     * monitor. A thread becomes owner of an object's monitor
     * </p>
     * <ul>
     * <li>by executing a synchronized method of that object;</li>
     * <li>by executing the body of a {@code synchronized} statement that
     * synchronizes on the object;</li>
     * <li>by executing a synchronized static method if the object is of type
     * {@code Class}.</li>
     * </ul>
     *
     * @see #notifyAll
     * @see #wait()
     * @see #wait(long)
     * @see #wait(long,int)
     * @see java.lang.Thread
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.154 -0500", hash_original_method = "2491F7F734B89141B57F81CC2F5A48BA", hash_generated_method = "31FCE39B0D76E1315FFF2B02B5E02276")
    
    public final void notify(){
    	//Formerly a native method
    }

    /**
     * Causes all threads which are waiting on this object's monitor (by means
     * of calling one of the {@code wait()} methods) to be woken up. The threads
     * will not run immediately. The thread that called {@code notify()} has to
     * release the object's monitor first. Also, the threads still have to
     * compete against other threads that try to synchronize on the same object.
     * <p>
     * This method can only be invoked by a thread which owns this object's
     * monitor. A thread becomes owner of an object's monitor
     * </p>
     * <ul>
     * <li>by executing a synchronized method of that object;</li>
     * <li>by executing the body of a {@code synchronized} statement that
     * synchronizes on the object;</li>
     * <li>by executing a synchronized static method if the object is of type
     * {@code Class}.</li>
     * </ul>
     *
     * @throws IllegalMonitorStateException
     *             if the thread calling this method is not the owner of this
     *             object's monitor.
     * @see #notify
     * @see #wait()
     * @see #wait(long)
     * @see #wait(long,int)
     * @see java.lang.Thread
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.158 -0500", hash_original_method = "4A0AA061C7039561E8E17F1D3678B2F2", hash_generated_method = "7C450C91A6344FB734DC7E279E95B4D0")
    
    public final void notifyAll(){
    	//Formerly a native method
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * object. Subclasses are encouraged to override this method and provide an
     * implementation that takes into account the object's type and data. The
     * default implementation is equivalent to the following expression:
     * <pre>
     *   getClass().getName() + '@' + Integer.toHexString(hashCode())</pre>
     * <p>See <a href="{@docRoot}reference/java/lang/Object.html#writing_toString">Writing a useful
     * {@code toString} method</a>
     * if you intend implementing your own {@code toString} method.
     *
     * @return a printable representation of this object.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.161 -0500", hash_original_method = "7905F5E0624643BB59BB03B2872919E1", hash_generated_method = "2078E1806981FD5222134E2086EC67E9")
    @DSVerified()
public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }

    /**
     * Causes the calling thread to wait until another thread calls the {@code
     * notify()} or {@code notifyAll()} method of this object. This method can
     * only be invoked by a thread which owns this object's monitor; see
     * {@link #notify()} on how a thread can become the owner of a monitor.
     * <p>
     * A waiting thread can be sent {@code interrupt()} to cause it to
     * prematurely stop waiting, so {@code wait} should be called in a loop to
     * check that the condition that has been waited for has been met before
     * continuing.
     * </p>
     * <p>
     * While the thread waits, it gives up ownership of this object's monitor.
     * When it is notified (or interrupted), it re-acquires the monitor before
     * it starts running.
     * </p>
     *
     * @throws IllegalMonitorStateException
     *             if the thread calling this method is not the owner of this
     *             object's monitor.
     * @throws InterruptedException
     *             if another thread interrupts this thread while it is waiting.
     * @see #notify
     * @see #notifyAll
     * @see #wait(long)
     * @see #wait(long,int)
     * @see java.lang.Thread
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.163 -0500", hash_original_method = "6FE2BE558DA9BAF1A2BFC29AD62222DA", hash_generated_method = "A38D1B1FBB7E81A6F5CC0EDFC909A7FB")
    
public final void wait() throws InterruptedException {
        wait(0 ,0);
    }

    /**
     * Causes the calling thread to wait until another thread calls the {@code
     * notify()} or {@code notifyAll()} method of this object or until the
     * specified timeout expires. This method can only be invoked by a thread
     * which owns this object's monitor; see {@link #notify()} on how a thread
     * can become the owner of a monitor.
     * <p>
     * A waiting thread can be sent {@code interrupt()} to cause it to
     * prematurely stop waiting, so {@code wait} should be called in a loop to
     * check that the condition that has been waited for has been met before
     * continuing.
     * </p>
     * <p>
     * While the thread waits, it gives up ownership of this object's monitor.
     * When it is notified (or interrupted), it re-acquires the monitor before
     * it starts running.
     * </p>
     *
     * @param millis
     *            the maximum time to wait in milliseconds.
     * @throws IllegalArgumentException
     *             if {@code millis < 0}.
     * @throws IllegalMonitorStateException
     *             if the thread calling this method is not the owner of this
     *             object's monitor.
     * @throws InterruptedException
     *             if another thread interrupts this thread while it is waiting.
     * @see #notify
     * @see #notifyAll
     * @see #wait()
     * @see #wait(long,int)
     * @see java.lang.Thread
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.166 -0500", hash_original_method = "4BB57D31A4F088800B6AE0C762E042CC", hash_generated_method = "EE97E942915A85089DFA80C469394C60")
    
public final void wait(long millis) throws InterruptedException {
        wait(millis, 0);
    }

    /**
     * Causes the calling thread to wait until another thread calls the {@code
     * notify()} or {@code notifyAll()} method of this object or until the
     * specified timeout expires. This method can only be invoked by a thread
     * that owns this object's monitor; see {@link #notify()} on how a thread
     * can become the owner of a monitor.
     * <p>
     * A waiting thread can be sent {@code interrupt()} to cause it to
     * prematurely stop waiting, so {@code wait} should be called in a loop to
     * check that the condition that has been waited for has been met before
     * continuing.
     * </p>
     * <p>
     * While the thread waits, it gives up ownership of this object's monitor.
     * When it is notified (or interrupted), it re-acquires the monitor before
     * it starts running.
     * </p>
     *
     * @param millis
     *            the maximum time to wait in milliseconds.
     * @param nanos
     *            the fraction of a millisecond to wait, specified in
     *            nanoseconds.
     * @throws IllegalArgumentException
     *             if {@code millis < 0}, {@code nanos < 0} or {@code nanos >
     *             999999}.
     * @throws IllegalMonitorStateException
     *             if the thread calling this method is not the owner of this
     *             object's monitor.
     * @throws InterruptedException
     *             if another thread interrupts this thread while it is waiting.
     * @see #notify
     * @see #notifyAll
     * @see #wait()
     * @see #wait(long,int)
     * @see java.lang.Thread
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.170 -0500", hash_original_method = "2C3F1320C25E20DEBA9A5B7EE716C215", hash_generated_method = "94504481D3D619737083E8726B8C7754")
    public final void wait(long millis, int nanos) throws InterruptedException{
    	//Formerly a native method
    	addTaint(millis);
    	addTaint(nanos);
    }
    
    // orphaned legacy method
    
    public DSTaintObject getTaint() {
        
        return taint;
    }
    
    // orphaned legacy method
    
    public int getTaintInt() {
        
        return 0;
    }
    
    // orphaned legacy method
    
    public void addTaint(DSTaintObject taint) {
        
    }
    
    // orphaned legacy method
    
    public short getTaintShort() {
        
        return 0;
    }
    
    // orphaned legacy method
    
    public byte getTaintByte() {
        
        return 0;
    }
    
    // orphaned legacy method
    
    public void addTaint(boolean taint) {
      
    }
    
    // orphaned legacy method
    
    public boolean getTaintBoolean() {
        
        return true;
    }
    
    // orphaned legacy method
    
    public char getTaintChar() {
        
        return 0;
    }
    
    // orphaned legacy method
    
    public float getTaintFloat() {
        
        return 0;
    }
    
    // orphaned legacy method
    
    public double getTaintDouble() {
        
        return 0;
    }
    
    // orphaned legacy method
    
    public long getTaintLong() {
        
        return 0;
    }
    
    // orphaned legacy method
    
    public void addTaint(double taint) {
        
    }
    
    public static boolean toTaintBoolean(boolean intValue) {
        return false;
    }
            
    public static boolean toTaintBoolean(double intValue) {
        return false;
    }
    

    
}

