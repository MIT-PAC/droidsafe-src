package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import libcore.util.EmptyArray;
import dalvik.system.VMStack;

public class Thread implements Runnable {

    /**
     * Returns the number of active {@code Thread}s in the running {@code
     * Thread}'s group and its subgroups.
     *
     * @return the number of {@code Thread}s
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.568 -0500", hash_original_method = "72CB3A6A0CD8DFEFDD9F27A9340FE949", hash_generated_method = "E8DF2F9A27CDE94B070C859E848D0FEB")
    
public static int activeCount() {
        return currentThread().getThreadGroup().activeCount();
    }

    /**
     * Returns the Thread of the caller, that is, the current Thread.
     *
     * @return the current Thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.575 -0500", hash_original_method = "E6DEC3347F951D8CF63DAEF794A9852A", hash_generated_method = "A6E83BE8198CFD257937EA056A110E8E")
    
public static Thread currentThread() {
        return VMThread.currentThread();
    }

    /**
     * Prints to the standard error stream a text representation of the current
     * stack for this Thread.
     *
     * @see Throwable#printStackTrace()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.581 -0500", hash_original_method = "9CF46F98160BA265944E973BF0CF5516", hash_generated_method = "4BD7326C6CB379906F5E516C898AF985")
    
public static void dumpStack() {
        new Throwable("stack dump").printStackTrace();
    }

    /**
     * Copies an array with all Threads which are in the same ThreadGroup as the
     * receiver - and subgroups - into the array <code>threads</code> passed as
     * parameter. If the array passed as parameter is too small no exception is
     * thrown - the extra elements are simply not copied.
     *
     * @param threads
     *            array into which the Threads will be copied
     * @return How many Threads were copied over
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.583 -0500", hash_original_method = "F21037CBC74EFF42DC16954068137FCD", hash_generated_method = "279702287A8803CF7FD9B3CD0FDA5D55")
    
public static int enumerate(Thread[] threads) {
        Thread thread = Thread.currentThread();
        return thread.getThreadGroup().enumerate(threads);
    }

    /**
     * Returns a map of all the currently live threads to their stack traces.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.586 -0500", hash_original_method = "D98109DB19C89E6A58A3F60993E1DFAD", hash_generated_method = "33347C70C21C4214A33F263633907A41")
    
public static Map<Thread, StackTraceElement[]> getAllStackTraces() {
        Map<Thread, StackTraceElement[]> map = new HashMap<Thread, StackTraceElement[]>();

        // Find out how many live threads we have. Allocate a bit more
        // space than needed, in case new ones are just being created.
        int count = ThreadGroup.mSystem.activeCount();
        Thread[] threads = new Thread[count + count / 2];

        // Enumerate the threads and collect the stacktraces.
        count = ThreadGroup.mSystem.enumerate(threads);
        for (int i = 0; i < count; i++) {
            map.put(threads[i], threads[i].getStackTrace());
        }

        return map;
    }

    /**
     * Returns the default exception handler that's executed when uncaught
     * exception terminates a thread.
     *
     * @return an {@link UncaughtExceptionHandler} or <code>null</code> if
     *         none exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.590 -0500", hash_original_method = "73AAE965D068D2FCF4D0B9A099B9DE78", hash_generated_method = "840EEEAC9685CC9DF7B90C9EB93D3A39")
    
public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return defaultUncaughtHandler;
    }

    /**
     * Returns a <code>boolean</code> indicating whether the current Thread (
     * <code>currentThread()</code>) has a pending interrupt request (<code>
     * true</code>) or not (<code>false</code>). It also has the side-effect of
     * clearing the flag.
     *
     * @return a <code>boolean</code> indicating the interrupt status
     * @see Thread#currentThread
     * @see Thread#interrupt
     * @see Thread#isInterrupted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.613 -0500", hash_original_method = "B8A4971B71D8B35D3212DC9C05DB29D4", hash_generated_method = "00ED1370A4CE19FDDCF3473034823E48")
    
public static boolean interrupted() {
        return VMThread.interrupted();
    }

    /**
     * Sets the default uncaught exception handler. This handler is invoked in
     * case any Thread dies due to an unhandled exception.
     *
     * @param handler
     *            The handler to set or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.641 -0500", hash_original_method = "95384CA17BFB199A9F049656335D2B20", hash_generated_method = "55EC1A754B4B8622CAD4ED907C8F51B6")
    
public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        Thread.defaultUncaughtHandler = handler;
    }

    /**
     * Causes the thread which sent this message to sleep for the given interval
     * of time (given in milliseconds). The precision is not guaranteed - the
     * Thread may sleep more or less than requested.
     *
     * @param time
     *            The time to sleep in milliseconds.
     * @throws InterruptedException
     *             if <code>interrupt()</code> was called for this Thread while
     *             it was sleeping
     * @see Thread#interrupt()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.656 -0500", hash_original_method = "6EAEFD6D0AE091A9829D7DAE1948EA2E", hash_generated_method = "321DA4B5D3B0E5CF8FEB944014F5F83B")
    
public static void sleep(long time) throws InterruptedException {
        Thread.sleep(time, 0);
    }
    
    public static void sleep(long millis, int nanos) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) {
            InterruptedException ex = new InterruptedException();
            ex.addTaint(millis);
            ex.addTaint(nanos);
            throw ex;
        }
        VMThread.sleep(millis, nanos);
    }

    /**
     * Causes the calling Thread to yield execution time to another Thread that
     * is ready to run. The actual scheduling is implementation-dependent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.674 -0500", hash_original_method = "20B3C869DA440A74B56436DD2A7E18B0", hash_generated_method = "ECC5CEEE91AB0DE77B9F3B933211D215")
    
public static void yield() {
        VMThread.yield();
    }

    /**
     * Indicates whether the current Thread has a monitor lock on the specified
     * object.
     *
     * @param object the object to test for the monitor lock
     * @return true if the current thread has a monitor lock on the specified
     *         object; false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.676 -0500", hash_original_method = "4BFB422FC2892097647B5CFF3006D866", hash_generated_method = "1BCBF2A06539CEF9F83D2539DCAFCEAE")
    
public static boolean holdsLock(Object object) {
        return currentThread().vmThread.holdsLock(object);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.473 -0500", hash_original_field = "5FC7F9392DE523EE635F94A39030F4C7", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.489 -0500", hash_original_field = "B9247AA9E83D4D22A4E76634397D42DB", hash_generated_field = "706621D0D1857AEE97C3233E8B1CD39C")

    public static final int MAX_PRIORITY = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.491 -0500", hash_original_field = "FB2A6079B3774844549CACFBBC6ADCB4", hash_generated_field = "4B0AE7C1DD2BB6CEB517D1F2268AEEFF")

    public static final int MIN_PRIORITY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.494 -0500", hash_original_field = "6C73D624A7B7A263191FA96912636C8B", hash_generated_field = "C493C9DD27E116A919077E0BD37657C0")

    public static final int NORM_PRIORITY = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.515 -0500", hash_original_field = "B524E41AA0CF6AD39267F32C8C687778", hash_generated_field = "6A0B7CDB09C9D5381ED29C2BE609D34C")

    private static int count = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.531 -0500", hash_original_field = "82BD197ACB809BA0253BA7902EA2FEDB", hash_generated_field = "5C82310D1632632F57D1ECC47F5F0326")

    private static UncaughtExceptionHandler defaultUncaughtHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.496 -0500", hash_original_field = "51ECDB9B5F4973294E1EDAE1161A6C6D", hash_generated_field = "AD2271ADED5B0642EAD7F6C10D7138A3")

    volatile VMThread vmThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.499 -0500", hash_original_field = "33105990A6F540695DACD98BC18B81F7", hash_generated_field = "323908075291FF73A0BF0480EC78D762")

    volatile ThreadGroup group;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.501 -0500", hash_original_field = "62DB8A1BDD71C2F57B5FF6FD37ED23E0", hash_generated_field = "1ED59F53ED2B99A4AD9663473B1CC006")

    volatile boolean daemon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.503 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "34558C70E1377442D4C0DBDA56BC6C23")

    volatile String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.506 -0500", hash_original_field = "4AD9F2E37B35E313CD211FBAFDADA238", hash_generated_field = "FDCCFF27A359BAE03856205C3A73A167")

    volatile int priority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.508 -0500", hash_original_field = "6759FFD90D21B645E599258551405BD5", hash_generated_field = "31CCA7F61A6273CAFC2F2A0EB46C6C22")

    volatile long stackSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.512 -0500", hash_original_field = "3BC51F00CA4514C3C4790A78C316DD07", hash_generated_field = "3BC51F00CA4514C3C4790A78C316DD07")

    Runnable target;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.517 -0500", hash_original_field = "FF4AD99D820B36F46F04892B42F122AA", hash_generated_field = "AE2623257C6319B5969DD2321BB374E1")

    private long id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.519 -0500", hash_original_field = "BC582D53333FA9EE36376F01B3892F08", hash_generated_field = "BC582D53333FA9EE36376F01B3892F08")

    ThreadLocal.Values localValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.521 -0500", hash_original_field = "1DCD99C357BDD63DBAEA19AB3742D070", hash_generated_field = "1DCD99C357BDD63DBAEA19AB3742D070")

    ThreadLocal.Values inheritableValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.524 -0500", hash_original_field = "EA9757892E7FC81BAB1B1F703705EDA4", hash_generated_field = "90F6FDD1E7EA8160FB4E33738C8B4E2A")

    private final List<Runnable> interruptActions = new ArrayList<Runnable>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.526 -0500", hash_original_field = "0A137DE0B6C8729CA24F8F9B18D44243", hash_generated_field = "C41102AB5C0E4C512DB1FC97849C5D3F")

    private ClassLoader contextClassLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.528 -0500", hash_original_field = "29DBDFDD523D5D8F30173E39F0BE89D7", hash_generated_field = "9E70AF0C0F09E0E8D22000D357561505")

    private UncaughtExceptionHandler uncaughtHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.533 -0500", hash_original_field = "F52710C226B829B42671DDE4B1108733", hash_generated_field = "F52710C226B829B42671DDE4B1108733")

    boolean hasBeenStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.536 -0500", hash_original_field = "ACEF00480D51D48B6334E5C96DFEE086", hash_generated_field = "1586B270E49D73D94EC53EC7F719398A")

    private int parkState = ParkState.UNPARKED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.538 -0500", hash_original_field = "B04F40C2035FC4B0DD8697D5A67A5665", hash_generated_field = "34932EF005581D2A5FD235907377EED6")

    private Object parkBlocker;

    /**
     * Constructs a new {@code Thread} with no {@code Runnable} object and a
     * newly generated name. The new {@code Thread} will belong to the same
     * {@code ThreadGroup} as the {@code Thread} calling this constructor.
     *
     * @see java.lang.ThreadGroup
     * @see java.lang.Runnable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.540 -0500", hash_original_method = "A2846A412942D9A4A6734B659C3C08EA", hash_generated_method = "F8D663241D3BE03836B5B656811F626F")
    
public Thread() {
        create(null, null, null, 0);
    }

    /**
     * Constructs a new {@code Thread} with a {@code Runnable} object and a
     * newly generated name. The new {@code Thread} will belong to the same
     * {@code ThreadGroup} as the {@code Thread} calling this constructor.
     *
     * @param runnable
     *            a {@code Runnable} whose method <code>run</code> will be
     *            executed by the new {@code Thread}
     *
     * @see java.lang.ThreadGroup
     * @see java.lang.Runnable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.543 -0500", hash_original_method = "FFE43BBD5535897A2D4ADC63E06A2D0F", hash_generated_method = "F90C5CD5D3864819E1DE105AE256BFEE")
    
public Thread(Runnable runnable) {
        create(null, runnable, null, 0);
    }

    /**
     * Constructs a new {@code Thread} with a {@code Runnable} object and name
     * provided. The new {@code Thread} will belong to the same {@code
     * ThreadGroup} as the {@code Thread} calling this constructor.
     *
     * @param runnable
     *            a {@code Runnable} whose method <code>run</code> will be
     *            executed by the new {@code Thread}
     * @param threadName
     *            the name for the {@code Thread} being created
     *
     * @see java.lang.ThreadGroup
     * @see java.lang.Runnable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.545 -0500", hash_original_method = "BDCA95CAB999722EC25DF6B8E927C95F", hash_generated_method = "C26ED3CEB33006056E94A062350A3BCD")
    
public Thread(Runnable runnable, String threadName) {
        if (threadName == null) {
            throw new NullPointerException();
        }

        create(null, runnable, threadName, 0);
    }

    /**
     * Constructs a new {@code Thread} with no {@code Runnable} object and the
     * name provided. The new {@code Thread} will belong to the same {@code
     * ThreadGroup} as the {@code Thread} calling this constructor.
     *
     * @param threadName
     *            the name for the {@code Thread} being created
     *
     * @see java.lang.ThreadGroup
     * @see java.lang.Runnable
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.548 -0500", hash_original_method = "ACB5E26D2EF52FBACC4A4E78EC843CDD", hash_generated_method = "58CB3772237497BCBEE9592D7AAEB7D0")
    
public Thread(String threadName) {
        if (threadName == null) {
            throw new NullPointerException();
        }

        create(null, null, threadName, 0);
    }

    /**
     * Constructs a new {@code Thread} with a {@code Runnable} object and a
     * newly generated name. The new {@code Thread} will belong to the {@code
     * ThreadGroup} passed as parameter.
     *
     * @param group
     *            {@code ThreadGroup} to which the new {@code Thread} will
     *            belong
     * @param runnable
     *            a {@code Runnable} whose method <code>run</code> will be
     *            executed by the new {@code Thread}
     * @throws IllegalThreadStateException
     *             if <code>group.destroy()</code> has already been done
     * @see java.lang.ThreadGroup
     * @see java.lang.Runnable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.551 -0500", hash_original_method = "CFE0254168731091471FC08E1B68E532", hash_generated_method = "17A7608BEA96360E13AAC96221758215")
    
public Thread(ThreadGroup group, Runnable runnable) {
        create(group, runnable, null, 0);
    }

    /**
     * Constructs a new {@code Thread} with a {@code Runnable} object, the given
     * name and belonging to the {@code ThreadGroup} passed as parameter.
     *
     * @param group
     *            ThreadGroup to which the new {@code Thread} will belong
     * @param runnable
     *            a {@code Runnable} whose method <code>run</code> will be
     *            executed by the new {@code Thread}
     * @param threadName
     *            the name for the {@code Thread} being created
     * @throws IllegalThreadStateException
     *             if <code>group.destroy()</code> has already been done
     * @see java.lang.ThreadGroup
     * @see java.lang.Runnable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.555 -0500", hash_original_method = "492306C5FED9EC58991A5E8736E27F15", hash_generated_method = "35FB1A83520105B4AC877538231D0DE7")
    
public Thread(ThreadGroup group, Runnable runnable, String threadName) {
        if (threadName == null) {
            throw new NullPointerException();
        }

        create(group, runnable, threadName, 0);
    }

    /**
     * Constructs a new {@code Thread} with no {@code Runnable} object, the
     * given name and belonging to the {@code ThreadGroup} passed as parameter.
     *
     * @param group
     *            {@code ThreadGroup} to which the new {@code Thread} will belong
     * @param threadName
     *            the name for the {@code Thread} being created
     * @throws IllegalThreadStateException
     *             if <code>group.destroy()</code> has already been done
     * @see java.lang.ThreadGroup
     * @see java.lang.Runnable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.557 -0500", hash_original_method = "D83475E079BCC4E2E3558A574C3A704E", hash_generated_method = "5803C3D7E1AFF31B1E83E8A50C84CA6B")
    
public Thread(ThreadGroup group, String threadName) {
        if (threadName == null) {
            throw new NullPointerException();
        }

        create(group, null, threadName, 0);
    }

    /**
     * Constructs a new {@code Thread} with a {@code Runnable} object, the given
     * name and belonging to the {@code ThreadGroup} passed as parameter.
     *
     * @param group
     *            {@code ThreadGroup} to which the new {@code Thread} will
     *            belong
     * @param runnable
     *            a {@code Runnable} whose method <code>run</code> will be
     *            executed by the new {@code Thread}
     * @param threadName
     *            the name for the {@code Thread} being created
     * @param stackSize
     *            a stack size for the new {@code Thread}. This has a highly
     *            platform-dependent interpretation. It may even be ignored
     *            completely.
     * @throws IllegalThreadStateException
     *             if <code>group.destroy()</code> has already been done
     * @see java.lang.ThreadGroup
     * @see java.lang.Runnable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.560 -0500", hash_original_method = "38DDF80F64A6875AC3B97FC941143FB8", hash_generated_method = "45591954BA5D1C91A2F9803A060A0855")
    
public Thread(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        if (threadName == null) {
            throw new NullPointerException();
        }
        create(group, runnable, threadName, stackSize);
    }

    /**
     * Package-scope method invoked by Dalvik VM to create "internal"
     * threads or attach threads created externally.
     *
     * Don't call Thread.currentThread(), since there may not be such
     * a thing (e.g. for Main).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.563 -0500", hash_original_method = "DA36D17A4C27DE9C11E6923E1A7A26CA", hash_generated_method = "F43CA0419F7CB7FF7B8EFC3381E7F4E3")
    
Thread(ThreadGroup group, String name, int priority, boolean daemon) {
        synchronized (Thread.class) {
            id = ++Thread.count;
        }

        if (name == null) {
            this.name = "Thread-" + id;
        } else {
            this.name = name;
        }

        if (group == null) {
            throw new InternalError("group not specified");
        }

        this.group = group;

        this.target = null;
        this.stackSize = 0;
        this.priority = priority;
        this.daemon = daemon;

        /* add ourselves to our ThreadGroup of choice */
        this.group.addThread(this);
    }

    /**
     * Initializes a new, existing Thread object with a runnable object,
     * the given name and belonging to the ThreadGroup passed as parameter.
     * This is the method that the several public constructors delegate their
     * work to.
     *
     * @param group ThreadGroup to which the new Thread will belong
     * @param runnable a java.lang.Runnable whose method <code>run</code> will
     *        be executed by the new Thread
     * @param threadName Name for the Thread being created
     * @param stackSize Platform dependent stack size
     * @throws IllegalThreadStateException if <code>group.destroy()</code> has
     *         already been done
     * @see java.lang.ThreadGroup
     * @see java.lang.Runnable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.566 -0500", hash_original_method = "B7E7B76C5A1CA256325AA2280577DF6E", hash_generated_method = "B9050FD6C572C048D3082A63D11149E1")
    
private void create(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        Thread currentThread = Thread.currentThread();
        if (group == null) {
            group = currentThread.getThreadGroup();
        }

        if (group.isDestroyed()) {
            throw new IllegalThreadStateException("Group already destroyed");
        }

        this.group = group;

        synchronized (Thread.class) {
            id = ++Thread.count;
        }

        if (threadName == null) {
            this.name = "Thread-" + id;
        } else {
            this.name = threadName;
        }

        this.target = runnable;
        this.stackSize = stackSize;

        this.priority = currentThread.getPriority();

        this.contextClassLoader = currentThread.contextClassLoader;

        // Transfer over InheritableThreadLocals.
        if (currentThread.inheritableValues != null) {
            inheritableValues = new ThreadLocal.Values(currentThread.inheritableValues);
        }

        // add ourselves to our ThreadGroup of choice
        this.group.addThread(this);
    }

    /**
     * Does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.571 -0500", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "822B8590C95F1D5952E9B876AE6B37EF")
    
public final void checkAccess() {
    }

    /**
     * Returns the number of stack frames in this thread.
     *
     * @return Number of stack frames
     * @deprecated The results of this call were never well defined. To make
     *             things worse, it would depend on whether the Thread was
     *             suspended or not, and suspend was deprecated too.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.573 -0500", hash_original_method = "6B880F3A25E0C40C35D8EAA702DA9116", hash_generated_method = "1B81A93AF41C8E11702FCF53AC8CD075")
    
@Deprecated
    public int countStackFrames() {
        return getStackTrace().length;
    }

    /**
     * Destroys the receiver without any monitor cleanup.
     *
     * @deprecated Not implemented.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.578 -0500", hash_original_method = "E295DBEBB7624DABB0FA2D3E0377892B", hash_generated_method = "326C904F8C73CA2DCC57E2CCF07658EC")
    
@Deprecated
    public void destroy() {
        throw new NoSuchMethodError("Thread.destroy()"); // TODO Externalize???
    }

    /**
     * Returns the context ClassLoader for this Thread.
     *
     * @return ClassLoader The context ClassLoader
     * @see java.lang.ClassLoader
     * @see #getContextClassLoader()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.588 -0500", hash_original_method = "D65A36EB6AF7077545898D8D2274216D", hash_generated_method = "9633C94A47589C7321EE60A6609E480C")
    
public ClassLoader getContextClassLoader() {
        return contextClassLoader;
    }

    /**
     * Returns the thread's identifier. The ID is a positive <code>long</code>
     * generated on thread creation, is unique to the thread, and doesn't change
     * during the lifetime of the thread; the ID may be reused after the thread
     * has been terminated.
     *
     * @return the thread's ID.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.592 -0500", hash_original_method = "AC34FCBA00CFFBED3290FFC752B7D422", hash_generated_method = "50A1BB2B1F2164322D909F16E85CDE7D")
    
public long getId() {
        return id;
    }

    /**
     * Returns the name of the Thread.
     *
     * @return the Thread's name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.595 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "CEAA3BC43A9BFF97F5638C3D9028D82D")
    
public final String getName() {
        return name;
    }

    /**
     * Returns the priority of the Thread.
     *
     * @return the Thread's priority
     * @see Thread#setPriority
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.597 -0500", hash_original_method = "0FA6C5514FC3354D3A5FFA078FF2070D", hash_generated_method = "B4B45689BCD450DB4D8629E0D5D6C977")
    
public final int getPriority() {
        return priority;
    }

    /**
     * Returns an array of {@link StackTraceElement} representing the current thread's stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.601 -0500", hash_original_method = "105ECA4B48BD428C2A4BFADC722280E4", hash_generated_method = "8A75AE8A4C2C212F1BC7525D22936731")
    
public StackTraceElement[] getStackTrace() {
        StackTraceElement ste[] = VMStack.getThreadStackTrace(this);
        return ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
    }

    /**
     * Returns the current state of the Thread. This method is useful for
     * monitoring purposes.
     *
     * @return a {@link State} value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.603 -0500", hash_original_method = "07EB6E55BA9633DD05ED126331098808", hash_generated_method = "BB5064B4667026FA9295779FABA1A723")
    
public State getState() {
        // TODO This is ugly and should be implemented better.
        VMThread vmt = this.vmThread;

        // Make sure we have a valid reference to an object. If native code
        // deletes the reference we won't run into a null reference later.
        VMThread thread = vmThread;
        if (thread != null) {
            // If the Thread Object became invalid or was not yet started,
            // getStatus() will return -1.
            int state = thread.getStatus();
            if(state != -1) {
                return VMThread.STATE_MAP[state];
            }
        }
        return hasBeenStarted ? Thread.State.TERMINATED : Thread.State.NEW;
    }

    /**
     * Returns the ThreadGroup to which this Thread belongs.
     *
     * @return the Thread's ThreadGroup
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.606 -0500", hash_original_method = "00D5D6D0C2A305848EB6704B96DA1F7A", hash_generated_method = "0B8E8EA57C4B96EC813031BA186E9BBC")
    
public final ThreadGroup getThreadGroup() {
        // TODO This should actually be done at native termination.
        if (getState() == Thread.State.TERMINATED) {
            return null;
        } else {
            return group;
        }
    }

    /**
     * Returns the thread's uncaught exception handler. If not explicitly set,
     * then the ThreadGroup's handler is returned. If the thread is terminated,
     * then <code>null</code> is returned.
     *
     * @return an {@link UncaughtExceptionHandler} instance or {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.608 -0500", hash_original_method = "5CF1F81DC91E6D2E78C73116F661ED4D", hash_generated_method = "11FA876AA2D7F6A968FEF8ECFAB86CFF")
    
public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        if (uncaughtHandler != null)
            return uncaughtHandler;
        else
            return group;           // ThreadGroup is instance of UEH
    }

    /**
     * Posts an interrupt request to this {@code Thread}. The behavior depends on
     * the state of this {@code Thread}:
     * <ul>
     * <li>
     * {@code Thread}s blocked in one of {@code Object}'s {@code wait()} methods
     * or one of {@code Thread}'s {@code join()} or {@code sleep()} methods will
     * be woken up, their interrupt status will be cleared, and they receive an
     * {@link InterruptedException}.
     * <li>
     * {@code Thread}s blocked in an I/O operation of an
     * {@link java.nio.channels.InterruptibleChannel} will have their interrupt
     * status set and receive an
     * {@link java.nio.channels.ClosedByInterruptException}. Also, the channel
     * will be closed.
     * <li>
     * {@code Thread}s blocked in a {@link java.nio.channels.Selector} will have
     * their interrupt status set and return immediately. They don't receive an
     * exception in this case.
     * <ul>
     *
     * @see Thread#interrupted
     * @see Thread#isInterrupted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.610 -0500", hash_original_method = "17DDF3808A6EBB129363B48719FB5512", hash_generated_method = "7822AB2F5B34D299297A20478B751727")
    
public void interrupt() {
        synchronized (interruptActions) {
            for (int i = interruptActions.size() - 1; i >= 0; i--) {
                interruptActions.get(i).run();
            }
        }

        VMThread vmt = this.vmThread;
        if (vmt != null) {
            vmt.interrupt();
        }
    }

    /**
     * Returns <code>true</code> if the receiver has already been started and
     * still runs code (hasn't died yet). Returns <code>false</code> either if
     * the receiver hasn't been started yet or if it has already started and run
     * to completion and died.
     *
     * @return a <code>boolean</code> indicating the liveness of the Thread
     * @see Thread#start
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.615 -0500", hash_original_method = "FDF1C6D176BF98E9EEA025E5AC84BE96", hash_generated_method = "CB4A29BEF9B271FCE21030FDC66920A9")
    
public final boolean isAlive() {
        return (vmThread != null);
    }

    /**
     * Returns a <code>boolean</code> indicating whether the receiver is a
     * daemon Thread (<code>true</code>) or not (<code>false</code>) A
     * daemon Thread only runs as long as there are non-daemon Threads running.
     * When the last non-daemon Thread ends, the whole program ends no matter if
     * it had daemon Threads still running or not.
     *
     * @return a <code>boolean</code> indicating whether the Thread is a daemon
     * @see Thread#setDaemon
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.618 -0500", hash_original_method = "C545A28661A0C27F268C3C9CA79B188B", hash_generated_method = "C54D40D7DA837FDFD807DF93515ECF59")
    
public final boolean isDaemon() {
        return daemon;
    }

    /**
     * Returns a <code>boolean</code> indicating whether the receiver has a
     * pending interrupt request (<code>true</code>) or not (
     * <code>false</code>)
     *
     * @return a <code>boolean</code> indicating the interrupt status
     * @see Thread#interrupt
     * @see Thread#interrupted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.620 -0500", hash_original_method = "8001B196EB7A1BAE7873C2E86818FA5F", hash_generated_method = "2AF4AEBD2944FF117BD9F1C74E068B54")
    
public boolean isInterrupted() {
        VMThread vmt = this.vmThread;
        if (vmt != null) {
            return vmt.isInterrupted();
        }

        return false;
    }

    /**
     * Blocks the current Thread (<code>Thread.currentThread()</code>) until
     * the receiver finishes its execution and dies.
     *
     * @throws InterruptedException if <code>interrupt()</code> was called for
     *         the receiver while it was in the <code>join()</code> call
     * @see Object#notifyAll
     * @see java.lang.ThreadDeath
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.623 -0500", hash_original_method = "39C10B080916DB467DF3B4EA48EC57E3", hash_generated_method = "3FB6E060663F198EA4B377511A51CAB1")
    
public final void join() throws InterruptedException {
        VMThread t = vmThread;
        if (t == null) {
            return;
        }

        synchronized (t) {
            while (isAlive()) {
                t.wait();
            }
        }
    }

    /**
     * Blocks the current Thread (<code>Thread.currentThread()</code>) until
     * the receiver finishes its execution and dies or the specified timeout
     * expires, whatever happens first.
     *
     * @param millis The maximum time to wait (in milliseconds).
     * @throws InterruptedException if <code>interrupt()</code> was called for
     *         the receiver while it was in the <code>join()</code> call
     * @see Object#notifyAll
     * @see java.lang.ThreadDeath
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.625 -0500", hash_original_method = "4A31F3D41623AEE48E003D8DCAD5BFFA", hash_generated_method = "540E6A7CA91480A038EDD83504FD7594")
    
public final void join(long millis) throws InterruptedException {
        join(millis, 0);
    }

    /**
     * Blocks the current Thread (<code>Thread.currentThread()</code>) until
     * the receiver finishes its execution and dies or the specified timeout
     * expires, whatever happens first.
     *
     * @param millis The maximum time to wait (in milliseconds).
     * @param nanos Extra nanosecond precision
     * @throws InterruptedException if <code>interrupt()</code> was called for
     *         the receiver while it was in the <code>join()</code> call
     * @see Object#notifyAll
     * @see java.lang.ThreadDeath
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.628 -0500", hash_original_method = "7E549C860CA937D59E3BB1D99D89340F", hash_generated_method = "D009B3011A949A17C6885D2CE2FFFD80")
    
public final void join(long millis, int nanos) throws InterruptedException {
        if (millis < 0 || nanos < 0 || nanos >= NANOS_PER_MILLI) {
            throw new IllegalArgumentException();
        }

        // avoid overflow: if total > 292,277 years, just wait forever
        boolean overflow = millis >= (Long.MAX_VALUE - nanos) / NANOS_PER_MILLI;
        boolean forever = (millis | nanos) == 0;
        if (forever | overflow) {
            join();
            return;
        }

        VMThread t = vmThread;
        if (t == null) {
            return;
        }

        synchronized (t) {
            if (!isAlive()) {
                return;
            }

            // guaranteed not to overflow
            long nanosToWait = millis * NANOS_PER_MILLI + nanos;

            // wait until this thread completes or the timeout has elapsed
            long start = System.nanoTime();
            while (true) {
                t.wait(millis, nanos);
                if (!isAlive()) {
                    break;
                }
                long nanosElapsed = System.nanoTime() - start;
                long nanosRemaining = nanosToWait - nanosElapsed;
                if (nanosRemaining <= 0) {
                    break;
                }
                millis = nanosRemaining / NANOS_PER_MILLI;
                nanos = (int) (nanosRemaining - millis * NANOS_PER_MILLI);
            }
        }
    }

    /**
     * Throws {@code UnsupportedOperationException}.
     *
     * @see Thread#suspend()
     * @deprecated Used with deprecated method {@link Thread#suspend}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.631 -0500", hash_original_method = "A6ED0DA6D495D98AD3E3BF5221571689", hash_generated_method = "CDD6B64EDCFE9909EB5384734EC074EA")
    
@Deprecated
    public final void resume() {
        throw new UnsupportedOperationException();
    }

    /**
     * Calls the <code>run()</code> method of the Runnable object the receiver
     * holds. If no Runnable is set, does nothing.
     *
     * @see Thread#start
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.633 -0500", hash_original_method = "74F6289977938D08C5FBC2624A0DC216", hash_generated_method = "699B0F71A4A21C34025432D7A8734079")
    
public void run() {
        if (target != null) {
            target.run();
        }
    }

    /**
     * Set the context ClassLoader for the receiver.
     *
     * @param cl The context ClassLoader
     * @see #getContextClassLoader()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.635 -0500", hash_original_method = "93EFC46ED375C1C54A6285C5204CF25C", hash_generated_method = "0A82B7E807F0644939A2807629211C77")
    
public void setContextClassLoader(ClassLoader cl) {
        contextClassLoader = cl;
    }

    /**
     * Set if the receiver is a daemon Thread or not. This can only be done
     * before the Thread starts running.
     *
     * @param isDaemon
     *            indicates whether the Thread should be daemon or not
     * @see Thread#isDaemon
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.638 -0500", hash_original_method = "9670EAA0D97E9800D90F260AB00393C1", hash_generated_method = "14B2B7EDA10E99D7B0B1219AC06E26A8")
    
public final void setDaemon(boolean isDaemon) {
        if (hasBeenStarted) {
            throw new IllegalThreadStateException("Thread already started."); // TODO Externalize?
        }

        if (vmThread == null) {
            daemon = isDaemon;
        }
    }

    /**
     * Adds a runnable to be invoked upon interruption. If this thread has
     * already been interrupted, the runnable will be invoked immediately. The
     * action should be idempotent as it may be invoked multiple times for a
     * single interruption.
     *
     * <p>Each call to this method must be matched with a corresponding call to
     * {@link #popInterruptAction$}.
     *
     * @hide used by NIO
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.643 -0500", hash_original_method = "C18D87700F0558E88B776CB695EE515A", hash_generated_method = "8FE82BB3AD8B4B38C2F97DFA4638CB90")
    
public final void pushInterruptAction$(Runnable interruptAction) {
        synchronized (interruptActions) {
            interruptActions.add(interruptAction);
        }

        if (interruptAction != null && isInterrupted()) {
            interruptAction.run();
        }
    }

    /**
     * Removes {@code interruptAction} so it is not invoked upon interruption.
     *
     * @param interruptAction the pushed action, used to check that the call
     *     stack is correctly nested.
     *
     * @hide used by NIO
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.646 -0500", hash_original_method = "134AC2DB3FFDAEE2D6D132954D878FFF", hash_generated_method = "15D19B037C74B1147A5E728F0AA5070C")
    
public final void popInterruptAction$(Runnable interruptAction) {
        synchronized (interruptActions) {
            Runnable removed = interruptActions.remove(interruptActions.size() - 1);
            if (interruptAction != removed) {
                throw new IllegalArgumentException(
                        "Expected " + interruptAction + " but was " + removed);
            }
        }
    }

    /**
     * Sets the name of the Thread.
     *
     * @param threadName the new name for the Thread
     * @see Thread#getName
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.648 -0500", hash_original_method = "52D88413A8A1215EC9D935022AA7508F", hash_generated_method = "59AE00DD9E6ADCB1B134A709A30DEF72")
    
public final void setName(String threadName) {
        if (threadName == null) {
            throw new NullPointerException();
        }

        name = threadName;
        VMThread vmt = this.vmThread;
        if (vmt != null) {
            /* notify the VM that the thread name has changed */
            vmt.nameChanged(threadName);
        }
    }

    /**
     * Sets the priority of the Thread. Note that the final priority set may not
     * be the parameter that was passed - it will depend on the receiver's
     * ThreadGroup. The priority cannot be set to be higher than the receiver's
     * ThreadGroup's maxPriority().
     *
     * @param priority
     *            new priority for the Thread
     * @throws IllegalArgumentException
     *             if the new priority is greater than Thread.MAX_PRIORITY or
     *             less than Thread.MIN_PRIORITY
     * @see Thread#getPriority
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.651 -0500", hash_original_method = "A91023FCF06B8647A6CEF3B99492A3A2", hash_generated_method = "C1A06B2E3C98AFF5EF465F8F6420E8E7")
    
public final void setPriority(int priority) {
        if (priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY) {
            throw new IllegalArgumentException("Priority out of range"); // TODO Externalize?
        }

        if (priority > group.getMaxPriority()) {
            priority = group.getMaxPriority();
        }

        this.priority = priority;

        VMThread vmt = this.vmThread;
        if (vmt != null) {
            vmt.setPriority(priority);
        }
    }

    /**
     * <p>
     * Sets the uncaught exception handler. This handler is invoked in case this
     * Thread dies due to an unhandled exception.
     * </p>
     *
     * @param handler
     *            The handler to set or <code>null</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.653 -0500", hash_original_method = "D58D250923779D2B2016D80FC2081BA1", hash_generated_method = "B182685DA439E90833A3FFE19F71C5BA")
    
public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        uncaughtHandler = handler;
    }

    /**
     * Starts the new Thread of execution. The <code>run()</code> method of
     * the receiver will be called by the receiver Thread itself (and not the
     * Thread calling <code>start()</code>).
     *
     * @throws IllegalThreadStateException if the Thread has been started before
     *
     * @see Thread#run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.661 -0500", hash_original_method = "389CF6E0D3A08F228CF4E4A156CC86D9", hash_generated_method = "4B5E86BEBB59EC254CCB9739B41E550A")
    
public synchronized void start() {
        if (hasBeenStarted) {
            throw new IllegalThreadStateException("Thread already started."); // TODO Externalize?
        }

        hasBeenStarted = true;

        VMThread.create(this, stackSize);
    }

    /**
     * Requests the receiver Thread to stop and throw ThreadDeath. The Thread is
     * resumed if it was suspended and awakened if it was sleeping, so that it
     * can proceed to throw ThreadDeath.
     *
     * @deprecated because stopping a thread in this manner is unsafe and can
     * leave your application and the VM in an unpredictable state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.664 -0500", hash_original_method = "345C33A5CF7530BB38CAED519DB524FA", hash_generated_method = "71D5D6DED3FE352EB1BCBD2E6307A79A")
    
@Deprecated
    public final void stop() {
        stop(new ThreadDeath());
    }
    
    private static class ParkState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.477 -0500", hash_original_field = "B6FEEFB1323BD524F78EBED48725C001", hash_generated_field = "5F7B3D5520F70EA2E650375F945D4166")

        private static final int UNPARKED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.479 -0500", hash_original_field = "353840882BCB3B9B7B9FE1E4384C6459", hash_generated_field = "7BF82648F2EB786712FF07EA5F35294C")

        private static final int PREEMPTIVELY_UNPARKED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.482 -0500", hash_original_field = "2BC11EB6DE0128B45B03E8659BCF0F22", hash_generated_field = "4906CF74EDC592846414C69420DD3136")

        private static final int PARKED = 3;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_method = "13ABD2C1475A75B421FFE7ADB6CF97D6", hash_generated_method = "13ABD2C1475A75B421FFE7ADB6CF97D6")
        public ParkState ()
        {
            //Synthesized constructor
        }
    }
    
    public enum State {
        NEW,
        RUNNABLE,
        BLOCKED,
        WAITING,
        TIMED_WAITING,
        TERMINATED
    }
    
    public static interface UncaughtExceptionHandler {
        
        void uncaughtException(Thread thread, Throwable ex);
    }

    /**
     * Throws {@code UnsupportedOperationException}.
     *
     * @throws NullPointerException if <code>throwable()</code> is
     *         <code>null</code>
     * @deprecated because stopping a thread in this manner is unsafe and can
     * leave your application and the VM in an unpredictable state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.667 -0500", hash_original_method = "B034829378D149E76566D897B904AD02", hash_generated_method = "01A838702CAD2FD31FB1262C74B1B4D1")
    
@Deprecated
    public final synchronized void stop(Throwable throwable) {
        throw new UnsupportedOperationException();
    }

    /**
     * Throws {@code UnsupportedOperationException}.
     *
     * @see Thread#resume()
     * @deprecated May cause deadlocks.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.669 -0500", hash_original_method = "BFD882A151848FA6FDA9CF11B3EB5020", hash_generated_method = "45AED642BC011444693B293C0FEDABC1")
    
@Deprecated
    public final void suspend() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a string containing a concise, human-readable description of the
     * Thread. It includes the Thread's name, priority, and group name.
     *
     * @return a printable representation for the receiver.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.672 -0500", hash_original_method = "E21D755A7854968438B35D363D61DC14", hash_generated_method = "5FF322F59C190612C9B047EA8E31B09B")
    
@Override
    public String toString() {
        return "Thread[" + name + "," + priority + "," + group.getName() + "]";
    }

    /**
     * Unparks this thread. This unblocks the thread it if it was
     * previously parked, or indicates that the thread is "preemptively
     * unparked" if it wasn't already parked. The latter means that the
     * next time the thread is told to park, it will merely clear its
     * latent park bit and carry on without blocking.
     *
     * <p>See {@link java.util.concurrent.locks.LockSupport} for more
     * in-depth information of the behavior of this method.</p>
     *
     * @hide for Unsafe
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.681 -0500", hash_original_method = "A23472E398F1697320641EE9BCE07378", hash_generated_method = "EF55F94392AFE1651323B5CB3F34FCE5")
    
public void unpark() {
        VMThread vmt = vmThread;

        if (vmt == null) {
            /*
             * vmThread is null before the thread is start()ed. In
             * this case, we just go ahead and set the state to
             * PREEMPTIVELY_UNPARKED. Since this happens before the
             * thread is started, we don't have to worry about
             * synchronizing with it.
             */
            parkState = ParkState.PREEMPTIVELY_UNPARKED;
            return;
        }

        synchronized (vmt) {
            switch (parkState) {
                case ParkState.PREEMPTIVELY_UNPARKED: {
                    /*
                     * Nothing to do in this case: By definition, a
                     * preemptively unparked thread is to remain in
                     * the preemptively unparked state if it is told
                     * to unpark.
                     */
                    break;
                }
                case ParkState.UNPARKED: {
                    parkState = ParkState.PREEMPTIVELY_UNPARKED;
                    break;
                }
                default /*parked*/: {
                    parkState = ParkState.UNPARKED;
                    vmt.notifyAll();
                    break;
                }
            }
        }
    }

    /**
     * Parks the current thread for a particular number of nanoseconds, or
     * indefinitely. If not indefinitely, this method unparks the thread
     * after the given number of nanoseconds if no other thread unparks it
     * first. If the thread has been "preemptively unparked," this method
     * cancels that unparking and returns immediately. This method may
     * also return spuriously (that is, without the thread being told to
     * unpark and without the indicated amount of time elapsing).
     *
     * <p>See {@link java.util.concurrent.locks.LockSupport} for more
     * in-depth information of the behavior of this method.</p>
     *
     * <p>This method must only be called when <code>this</code> is the current
     * thread.
     *
     * @param nanos number of nanoseconds to park for or <code>0</code>
     * to park indefinitely
     * @throws IllegalArgumentException thrown if <code>nanos &lt; 0</code>
     *
     * @hide for Unsafe
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.684 -0500", hash_original_method = "25C50086F373F8B2A1357A67BAD56EA4", hash_generated_method = "96B78C49F0C114B68EE5F31253BE89ED")
    
public void parkFor(long nanos) {
        VMThread vmt = vmThread;

        if (vmt == null) {
            // Running threads should always have an associated vmThread.
            throw new AssertionError();
        }

        synchronized (vmt) {
            switch (parkState) {
                case ParkState.PREEMPTIVELY_UNPARKED: {
                    parkState = ParkState.UNPARKED;
                    break;
                }
                case ParkState.UNPARKED: {
                    long millis = nanos / NANOS_PER_MILLI;
                    nanos %= NANOS_PER_MILLI;

                    parkState = ParkState.PARKED;
                    try {
                        vmt.wait(millis, (int) nanos);
                    } catch (InterruptedException ex) {
                        interrupt();
                    } finally {
                        /*
                         * Note: If parkState manages to become
                         * PREEMPTIVELY_UNPARKED before hitting this
                         * code, it should left in that state.
                         */
                        if (parkState == ParkState.PARKED) {
                            parkState = ParkState.UNPARKED;
                        }
                    }
                    break;
                }
                default /*parked*/: {
                    throw new AssertionError(
                            "shouldn't happen: attempt to repark");
                }
            }
        }
    }

    /**
     * Parks the current thread until the specified system time. This
     * method attempts to unpark the current thread immediately after
     * <code>System.currentTimeMillis()</code> reaches the specified
     * value, if no other thread unparks it first. If the thread has
     * been "preemptively unparked," this method cancels that
     * unparking and returns immediately. This method may also return
     * spuriously (that is, without the thread being told to unpark
     * and without the indicated amount of time elapsing).
     *
     * <p>See {@link java.util.concurrent.locks.LockSupport} for more
     * in-depth information of the behavior of this method.</p>
     *
     * <p>This method must only be called when <code>this</code> is the
     * current thread.
     *
     * @param time the time after which the thread should be unparked,
     * in absolute milliseconds-since-the-epoch
     *
     * @hide for Unsafe
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.687 -0500", hash_original_method = "98F10CBBB26C44644E065EAD29E052AC", hash_generated_method = "187AF55D9829DCAFB9E9DB811B9AF877")
    
public void parkUntil(long time) {
        VMThread vmt = vmThread;

        if (vmt == null) {
            // Running threads should always have an associated vmThread.
            throw new AssertionError();
        }

        synchronized (vmt) {
            /*
             * Note: This conflates the two time bases of "wall clock"
             * time and "monotonic uptime" time. However, given that
             * the underlying system can only wait on monotonic time,
             * it is unclear if there is any way to avoid the
             * conflation. The downside here is that if, having
             * calculated the delay, the wall clock gets moved ahead,
             * this method may not return until well after the wall
             * clock has reached the originally designated time. The
             * reverse problem (the wall clock being turned back)
             * isn't a big deal, since this method is allowed to
             * spuriously return for any reason, and this situation
             * can safely be construed as just such a spurious return.
             */
            long delayMillis = time - System.currentTimeMillis();

            if (delayMillis <= 0) {
                parkState = ParkState.UNPARKED;
            } else {
                parkFor(delayMillis * NANOS_PER_MILLI);
            }
        }
    }
}

