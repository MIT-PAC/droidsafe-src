package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import libcore.util.CollectionUtils;





public class ThreadGroup implements Thread.UncaughtExceptionHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.697 -0500", hash_original_field = "2F6F6F53954BBF04ADF16268DBF28916", hash_generated_field = "C469F1CA0F9CB15DC605ADF2C779CB30")

    static final ThreadGroup mSystem = new ThreadGroup();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.699 -0500", hash_original_field = "F198F715A5D5311ACE2D66E8A47AD66C", hash_generated_field = "843DB6CD61C0C78ABA07CFE273D0F240")

    static final ThreadGroup mMain = new ThreadGroup(mSystem, "main");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.678 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "A71CAEBD89C801748BA2BF13023C8FE1")

    // VM needs this field name for debugging.
    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.680 -0500", hash_original_field = "3CD0E4B96B5D0A2D1AE9CD3A6FB05472", hash_generated_field = "BAE3A77CD99CEF534E87AE87746C2800")

    private int maxPriority = Thread.MAX_PRIORITY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.682 -0500", hash_original_field = "921B83C68DF8C2D2905E66FA6268F314", hash_generated_field = "CDE67052334F44EF5058F45E95BAC0A2")

    // VM needs this field name for debugging.
     ThreadGroup parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.685 -0500", hash_original_field = "648BD9980395ACB809D874C1E8286E01", hash_generated_field = "F1B2F3B9F625FA1FE59B2C7FAD18AF4A")

    private final List<WeakReference<Thread>> threadRefs = new ArrayList<WeakReference<Thread>>(5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.687 -0500", hash_original_field = "FFF3D2A511853F4B6C0D78EC94F571C9", hash_generated_field = "BAAC9A9E91234825CA85E995F8623CDF")

    private final Iterable<Thread> threads = CollectionUtils.dereferenceIterable(threadRefs, true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.690 -0500", hash_original_field = "BF52E4CFF59F6BE0DE6C3D2F13ABD8CD", hash_generated_field = "7493BFD7B9E904844C38FDDC4FA574AD")

    private final List<ThreadGroup> groups = new ArrayList<ThreadGroup>(3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.693 -0500", hash_original_field = "126F56DA73F7A548AE610AF1B8ECB2E5", hash_generated_field = "99285F53C75B3E4B14C168653E64D131")

    private boolean isDaemon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.695 -0500", hash_original_field = "782A358894B2DDC4D8AC51F3A2DB6DBB", hash_generated_field = "1D1E680624D89261892D686BAD995D69")

    private boolean isDestroyed;

    /**
     * Constructs a new {@code ThreadGroup} with the given name. The new {@code ThreadGroup}
     * will be child of the {@code ThreadGroup} to which the calling thread belongs.
     *
     * @param name the name
     * @see Thread#currentThread
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.702 -0500", hash_original_method = "15CA8765FCB0FEEB29D720D0682BEE22", hash_generated_method = "1CFCA8C34A445D374A437B2781C3F066")
    
public ThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
    }

    /**
     * Constructs a new {@code ThreadGroup} with the given name, as a child of the
     * given {@code ThreadGroup}.
     *
     * @param parent the parent
     * @param name the name
     * @throws NullPointerException if {@code parent == null}
     * @throws IllegalThreadStateException if {@code parent} has been
     *         destroyed already
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.705 -0500", hash_original_method = "E77CFC99E1E2014F4D8FD3506A5DB87B", hash_generated_method = "9BAE44DA18F0F926D9E8999AEC69DD33")
    
public ThreadGroup(ThreadGroup parent, String name) {
        if (parent == null) {
            throw new NullPointerException("parent == null");
        }
        this.name = name;
        this.parent = parent;
        if (parent != null) {
            parent.add(this);
            this.setMaxPriority(parent.getMaxPriority());
            if (parent.isDaemon()) {
                this.setDaemon(true);
            }
        }
    }

    /**
     * Initialize the special "system" ThreadGroup. Was "main" in Harmony,
     * but we have an additional group above that in Android.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.708 -0500", hash_original_method = "2C0349D8A755A992C407F37169B24D0C", hash_generated_method = "A839BB6C885C046CDCE6C7E7906B1179")
    
private ThreadGroup() {
        this.name = "system";
        this.parent = null;
    }

    /**
     * Returns the number of running {@code Thread}s which are children of this thread group,
     * directly or indirectly.
     *
     * @return the number of children
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.710 -0500", hash_original_method = "F6402A744D3DEB7896E39C3D58ADE009", hash_generated_method = "AFDDC3EEB6E8F856C515A837C06D6294")
    
public int activeCount() {
        int count = 0;
        synchronized (threadRefs) {
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    count++;
                }
            }
        }
        synchronized (groups) {
            for (ThreadGroup group : groups) {
                count += group.activeCount();
            }
        }
        return count;
    }

    /**
     * Returns the number of {@code ThreadGroup}s which are children of this group,
     * directly or indirectly.
     *
     * @return the number of children
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.713 -0500", hash_original_method = "AF255D2A52D389FA67BDDD4C4590191B", hash_generated_method = "8E7C132A2CAADF736AAFD363FEB19F27")
    
public int activeGroupCount() {
        int count = 0;
        synchronized (groups) {
            for (ThreadGroup group : groups) {
                // One for this group & the subgroups
                count += 1 + group.activeGroupCount();
            }
        }
        return count;
    }

    /**
     * Adds a {@code ThreadGroup} to this thread group.
     *
     * @param g ThreadGroup to add
     * @throws IllegalThreadStateException if this group has been destroyed already
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.715 -0500", hash_original_method = "0DD772AEDB7C823C2E91BB6377F03397", hash_generated_method = "644303AB04378EE60FACEF029E5354E5")
    
private void add(ThreadGroup g) throws IllegalThreadStateException {
        synchronized (groups) {
            if (isDestroyed) {
                throw new IllegalThreadStateException();
            }
            groups.add(g);
        }
    }

    /**
     * Does nothing. The definition of this method depends on the deprecated
     * method {@link #suspend()}. The exact behavior of this call was never
     * specified.
     *
     * @param b Used to control low memory implicit suspension
     * @return {@code true} (always)
     *
     * @deprecated Required deprecated method suspend().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.718 -0500", hash_original_method = "17B34AC990B7E085858AFAD80E625CEB", hash_generated_method = "E0E1FDE2C26B4749EE090641D8EB84C2")
    
@Deprecated
    public boolean allowThreadSuspension(boolean b) {
        // Does not apply to this VM, no-op
        return true;
    }

    /**
     * Does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.720 -0500", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "822B8590C95F1D5952E9B876AE6B37EF")
    
public final void checkAccess() {
    }

    /**
     * Destroys this thread group and recursively all its subgroups. It is only legal
     * to destroy a {@code ThreadGroup} that has no threads in it. Any daemon
     * {@code ThreadGroup} is destroyed automatically when it becomes empty (no threads
     * or thread groups in it).
     *
     * @throws IllegalThreadStateException if this thread group or any of its
     *         subgroups has been destroyed already or if it still contains
     *         threads.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.723 -0500", hash_original_method = "662D73EDBF2256DFDB84D7DB5F6E6941", hash_generated_method = "A446C3A052B9B413C579FD706BDC561F")
    
public final void destroy() {
        synchronized (threadRefs) {
            synchronized (groups) {
                if (isDestroyed) {
                    throw new IllegalThreadStateException(
                            "Thread group was already destroyed: "
                            + (this.name != null ? this.name : "n/a"));
                }
                if (threads.iterator().hasNext()) {
                    throw new IllegalThreadStateException(
                            "Thread group still contains threads: "
                            + (this.name != null ? this.name : "n/a"));
                }
                // Call recursively for subgroups
                while (!groups.isEmpty()) {
                    // We always get the first element - remember, when the
                    // child dies it removes itself from our collection. See
                    // below.
                    groups.get(0).destroy();
                }

                if (parent != null) {
                    parent.remove(this);
                }

                // Now that the ThreadGroup is really destroyed it can be tagged as so
                this.isDestroyed = true;
            }
        }
    }

    /*
     * Auxiliary method that destroys this thread group and recursively all its
     * subgroups if this is a daemon ThreadGroup.
     *
     * @see #destroy
     * @see #setDaemon
     * @see #isDaemon
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.725 -0500", hash_original_method = "CD7DBC672D59D1FAACCF6E53D785D515", hash_generated_method = "34F3FA75DDD0B459C8FD7E56C6729C67")
    
private void destroyIfEmptyDaemon() {
        // Has to be non-destroyed daemon to make sense
        synchronized (threadRefs) {
            if (isDaemon && !isDestroyed && !threads.iterator().hasNext()) {
                synchronized (groups) {
                    if (groups.isEmpty()) {
                        destroy();
                    }
                }
            }
        }
    }

    /**
     * Iterates over all active threads in this group (and its sub-groups) and
     * stores the threads in the given array. Returns when the array is full or
     * no more threads remain, whichever happens first.
     *
     * <p>Note that this method will silently ignore any threads that don't fit in the
     * supplied array.
     *
     * @param threads the array into which the {@code Thread}s will be copied
     * @return the number of {@code Thread}s that were copied
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.728 -0500", hash_original_method = "4F115C3CD94EE462D7FE29C66038CE8B", hash_generated_method = "47882F753BDA0BDAE8FD260C2B66EBED")
    
public int enumerate(Thread[] threads) {
        return enumerate(threads, true);
    }

    /**
     * Iterates over all active threads in this group (and, optionally, its
     * sub-groups) and stores the threads in the given array. Returns when the
     * array is full or no more threads remain, whichever happens first.
     *
     * <p>Note that this method will silently ignore any threads that don't fit in the
     * supplied array.
     *
     * @param threads the array into which the {@code Thread}s will be copied
     * @param recurse indicates whether {@code Thread}s in subgroups should be
     *        recursively copied as well
     * @return the number of {@code Thread}s that were copied
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.731 -0500", hash_original_method = "7C9447501CA37C2477868C242A118750", hash_generated_method = "E89AF51F11EE4A7F22F37BAAA98FE0BB")
    
public int enumerate(Thread[] threads, boolean recurse) {
        return enumerateGeneric(threads, recurse, 0, true);
    }

    /**
     * Iterates over all thread groups in this group (and its sub-groups) and
     * and stores the groups in the given array. Returns when the array is full
     * or no more groups remain, whichever happens first.
     *
     * <p>Note that this method will silently ignore any thread groups that don't fit in the
     * supplied array.
     *
     * @param groups the array into which the {@code ThreadGroup}s will be copied
     * @return the number of {@code ThreadGroup}s that were copied
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.733 -0500", hash_original_method = "CA294C4CBD805FDF86CE51E26A265568", hash_generated_method = "FE05CBCA2255FD8334AEFE70F21493E4")
    
public int enumerate(ThreadGroup[] groups) {
        return enumerate(groups, true);
    }

    /**
     * Iterates over all thread groups in this group (and, optionally, its
     * sub-groups) and stores the groups in the given array. Returns when
     * the array is full or no more groups remain, whichever happens first.
     *
     * <p>Note that this method will silently ignore any thread groups that don't fit in the
     * supplied array.
     *
     * @param groups the array into which the {@code ThreadGroup}s will be copied
     * @param recurse indicates whether {@code ThreadGroup}s in subgroups should be
     *        recursively copied as well or not
     * @return the number of {@code ThreadGroup}s that were copied
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.736 -0500", hash_original_method = "C3125975C33A76683DB83E92F1059496", hash_generated_method = "D6F6173D5989C7938638DB17648EF907")
    
public int enumerate(ThreadGroup[] groups, boolean recurse) {
        return enumerateGeneric(groups, recurse, 0, false);
    }

    /**
     * Copies into <param>enumeration</param> starting at
     * <param>enumerationIndex</param> all Threads or ThreadGroups in the
     * receiver. If <param>recurse</param> is true, recursively enumerate the
     * elements in subgroups.
     *
     * If the array passed as parameter is too small no exception is thrown -
     * the extra elements are simply not copied.
     *
     * @param enumeration array into which the elements will be copied
     * @param recurse Indicates whether subgroups should be enumerated or not
     * @param enumerationIndex Indicates in which position of the enumeration
     *        array we are
     * @param enumeratingThreads Indicates whether we are enumerating Threads or
     *        ThreadGroups
     * @return How many elements were enumerated/copied over
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.739 -0500", hash_original_method = "7CEEE4341262A9B70C3A153644CFBA1A", hash_generated_method = "A188A36867D97B25436336404522BDF2")
    
private int enumerateGeneric(Object[] enumeration, boolean recurse, int enumerationIndex,
            boolean enumeratingThreads) {
        if (enumeratingThreads) {
            synchronized (threadRefs) {
                // walk the references directly so we can iterate in reverse order
                for (int i = threadRefs.size() - 1; i >= 0; --i) {
                    Thread thread = threadRefs.get(i).get();
                    if (thread != null && thread.isAlive()) {
                        if (enumerationIndex >= enumeration.length) {
                            return enumerationIndex;
                        }
                        enumeration[enumerationIndex++] = thread;
                    }
                }
            }
        } else {
            synchronized (groups) {
                for (int i = groups.size() - 1; i >= 0; --i) {
                    if (enumerationIndex >= enumeration.length) {
                        return enumerationIndex;
                    }
                    enumeration[enumerationIndex++] = groups.get(i);
                }
            }
        }

        if (recurse) {
            synchronized (groups) {
                for (ThreadGroup group : groups) {
                    if (enumerationIndex >= enumeration.length) {
                        return enumerationIndex;
                    }
                    enumerationIndex = group.enumerateGeneric(enumeration, recurse,
                            enumerationIndex, enumeratingThreads);
                }
            }
        }
        return enumerationIndex;
    }

    /**
     * Returns the maximum allowed priority for a {@code Thread} in this thread group.
     *
     * @return the maximum priority
     *
     * @see #setMaxPriority
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.741 -0500", hash_original_method = "DB664BE89D62AA134945B6EEF3A0CB00", hash_generated_method = "C38123077310F5EA1712336BF4D3A048")
    
public final int getMaxPriority() {
        return maxPriority;
    }

    /**
     * Returns the name of this thread group.
     *
     * @return the group's name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.743 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "CEAA3BC43A9BFF97F5638C3D9028D82D")
    
public final String getName() {
        return name;
    }

    /**
     * Returns this thread group's parent {@code ThreadGroup}. It can be null if this
     * is the the root ThreadGroup.
     *
     * @return the parent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.746 -0500", hash_original_method = "8A85A1BC7F9CDC3D0187C50787EE4700", hash_generated_method = "AE4706C9EC29F10794934D03E51214FB")
    
public final ThreadGroup getParent() {
        return parent;
    }

    /**
     * Interrupts every {@code Thread} in this group and recursively in all its
     * subgroups.
     *
     * @see Thread#interrupt
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.748 -0500", hash_original_method = "2F1556F9A0B232F489BC24F1BD1E38E0", hash_generated_method = "B7320F80D3774D65B94A9C23ED500F0A")
    
public final void interrupt() {
        synchronized (threadRefs) {
            for (Thread thread : threads) {
                thread.interrupt();
            }
        }
        synchronized (groups) {
            for (ThreadGroup group : groups) {
                group.interrupt();
            }
        }
    }

    /**
     * Checks whether this thread group is a daemon {@code ThreadGroup}.
     *
     * @return true if this thread group is a daemon {@code ThreadGroup}
     *
     * @see #setDaemon
     * @see #destroy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.751 -0500", hash_original_method = "5976FB7C02B0576FC514CB127C4662D8", hash_generated_method = "1A5FBF71F04B42076302EAC7B35B6BF4")
    
public final boolean isDaemon() {
        return isDaemon;
    }

    /**
     * Checks whether this thread group has already been destroyed.
     *
     * @return true if this thread group has already been destroyed
     * @see #destroy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.753 -0500", hash_original_method = "B936E1D4B92F105E0DF31A4819E36563", hash_generated_method = "D9B00402E70972A372B16B54B1144946")
    
public synchronized boolean isDestroyed() {
        return isDestroyed;
    }

    /**
     * Outputs to {@code System.out} a text representation of the
     * hierarchy of {@code Thread}s and {@code ThreadGroup}s in this thread group (and recursively).
     * Proper indentation is used to show the nesting of groups inside groups
     * and threads inside groups.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.756 -0500", hash_original_method = "8CFF2ECA4877D9633C2E3E2E2839A20E", hash_generated_method = "38BE9CA77E0967B64DD424B192116992")
    
public void list() {
        // We start in a fresh line
        System.out.println();
        list(0);
    }

    /*
     * Outputs to {@code System.out}a text representation of the
     * hierarchy of Threads and ThreadGroups in this thread group (and recursively).
     * The indentation will be four spaces per level of nesting.
     *
     * @param levels How many levels of nesting, so that proper indentation can
     * be output.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.759 -0500", hash_original_method = "38F7DBD37EF32F68FFB89F20FFE0F443", hash_generated_method = "4F0F356F01E5BE3745BC160458F54362")
    
private void list(int levels) {
        indent(levels);
        System.out.println(this.toString());

        ++levels;
        synchronized (threadRefs) {
            for (Thread thread : threads) {
                indent(levels);
                System.out.println(thread);
            }
        }
        synchronized (groups) {
            for (ThreadGroup group : groups) {
                group.list(levels);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.761 -0500", hash_original_method = "074D68FF209CFCAF4851113378206A39", hash_generated_method = "88EEC02B72D933C6732FBB8EC4C26F33")
    
private void indent(int levels) {
        for (int i = 0; i < levels; i++) {
            System.out.print("    "); // 4 spaces for each level
        }
    }

    /**
     * Checks whether this thread group is a direct or indirect parent group of a
     * given {@code ThreadGroup}.
     *
     * @param g the potential child {@code ThreadGroup}
     * @return true if this thread group is parent of {@code g}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.763 -0500", hash_original_method = "47457D8FCC611743893B7B7E5D80876A", hash_generated_method = "547F55DA15E46B8ACCFC943A75E78305")
    
public final boolean parentOf(ThreadGroup g) {
        while (g != null) {
            if (this == g) {
                return true;
            }
            g = g.parent;
        }
        return false;
    }

    /**
     * Removes an immediate subgroup.
     *
     * @param g ThreadGroup to remove
     *
     * @see #add(Thread)
     * @see #add(ThreadGroup)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.766 -0500", hash_original_method = "7E8DD532FE0D28207249CA86D60AFD62", hash_generated_method = "D19A9737DAFF09954A9BC9BA22A98230")
    
private void remove(ThreadGroup g) {
        synchronized (groups) {
            for (Iterator<ThreadGroup> i = groups.iterator(); i.hasNext(); ) {
                ThreadGroup threadGroup = i.next();
                if (threadGroup.equals(g)) {
                    i.remove();
                    break;
                }
            }
        }
        destroyIfEmptyDaemon();
    }

    /**
     * Resumes every thread in this group and recursively in all its
     * subgroups.
     *
     * @see Thread#resume
     * @see #suspend
     *
     * @deprecated Requires deprecated method Thread.resume().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.769 -0500", hash_original_method = "DD66491EA6460453E572207637EFB169", hash_generated_method = "062AAD138D06DA94B37AC05F436D3022")
    
@SuppressWarnings("deprecation")
    @Deprecated
    public final void resume() {
        synchronized (threadRefs) {
            for (Thread thread : threads) {
                thread.resume();
            }
        }
        synchronized (groups) {
            for (ThreadGroup group : groups) {
                group.resume();
            }
        }
    }

    /**
     * Sets whether this is a daemon {@code ThreadGroup} or not. Daemon
     * thread groups are automatically destroyed when they become empty.
     *
     * @param isDaemon the new value
     * @see #isDaemon
     * @see #destroy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.771 -0500", hash_original_method = "8335FAF0BC3ED6B3C58B58617340A520", hash_generated_method = "24A6C38EDDCA54145AAF5BDE35CBE7C8")
    
public final void setDaemon(boolean isDaemon) {
        this.isDaemon = isDaemon;
    }

    /**
     * Configures the maximum allowed priority for a {@code Thread} in this group and
     * recursively in all its subgroups.
     *
     * <p>A caller can never increase the maximum priority of a thread group.
     * Such an attempt will not result in an exception, it will
     * simply leave the thread group with its current maximum priority.
     *
     * @param newMax the new maximum priority to be set
     *
     * @throws IllegalArgumentException if the new priority is greater than
     *         Thread.MAX_PRIORITY or less than Thread.MIN_PRIORITY
     *
     * @see #getMaxPriority
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.774 -0500", hash_original_method = "271C3F89CA43821F381115CC8E2996B2", hash_generated_method = "A3A7B44DACC9313045DB1F06D47411A5")
    
public final void setMaxPriority(int newMax) {
        if (newMax <= this.maxPriority) {
            if (newMax < Thread.MIN_PRIORITY) {
                newMax = Thread.MIN_PRIORITY;
            }

            int parentPriority = parent == null ? newMax : parent.getMaxPriority();
            this.maxPriority = parentPriority <= newMax ? parentPriority : newMax;
            synchronized (groups) {
                for (ThreadGroup group : groups) {
                    group.setMaxPriority(newMax);
                }
            }
        }
    }

    /**
     * Stops every thread in this group and recursively in all its subgroups.
     *
     * @see Thread#stop()
     * @see Thread#stop(Throwable)
     * @see ThreadDeath
     *
     * @deprecated Requires deprecated method Thread.stop().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.777 -0500", hash_original_method = "59A4D041306D60B1EF57E2C22E471227", hash_generated_method = "874E1492F11CD362521561994DC41956")
    
@SuppressWarnings("deprecation")
    @Deprecated
    public final void stop() {
        if (stopHelper()) {
            Thread.currentThread().stop();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.780 -0500", hash_original_method = "F86867FC41FDF8B0075237470EA8A18F", hash_generated_method = "38C94953E742CD39BD83518A4C766E57")
    
@SuppressWarnings("deprecation")
    private boolean stopHelper() {
        boolean stopCurrent = false;
        synchronized (threadRefs) {
            Thread current = Thread.currentThread();
            for (Thread thread : threads) {
                if (thread == current) {
                    stopCurrent = true;
                } else {
                    thread.stop();
                }
            }
        }
        synchronized (groups) {
            for (ThreadGroup group : groups) {
                stopCurrent |= group.stopHelper();
            }
        }
        return stopCurrent;
    }

    /**
     * Suspends every thread in this group and recursively in all its
     * subgroups.
     *
     * @see Thread#suspend
     * @see #resume
     *
     * @deprecated Requires deprecated method Thread.suspend().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.783 -0500", hash_original_method = "26CED40B1639307872B1DC8622DA2669", hash_generated_method = "281EB1EC96DE8B0F1A66E8C14DEC1457")
    
@SuppressWarnings("deprecation")
    @Deprecated
    public final void suspend() {
        if (suspendHelper()) {
            Thread.currentThread().suspend();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.785 -0500", hash_original_method = "664C597F1857BDEBDBE75F13D3F147B7", hash_generated_method = "1750B92F76518C148B640D01FE0FE82A")
    
@SuppressWarnings("deprecation")
    private boolean suspendHelper() {
        boolean suspendCurrent = false;
        synchronized (threadRefs) {
            Thread current = Thread.currentThread();
            for (Thread thread : threads) {
                if (thread == current) {
                    suspendCurrent = true;
                } else {
                    thread.suspend();
                }
            }
        }
        synchronized (groups) {
            for (ThreadGroup group : groups) {
                suspendCurrent |= group.suspendHelper();
            }
        }
        return suspendCurrent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.788 -0500", hash_original_method = "54318ADB79169F8C74CBC002CF89020D", hash_generated_method = "5A037D2E66AEA5D460AC5BC74AD15202")
    
@Override
    public String toString() {
        return getClass().getName() + "[name=" + getName()
                + ",maxPriority=" + getMaxPriority() + "]";
    }

    /**
     * Handles uncaught exceptions. Any uncaught exception in any {@code Thread}
     * is forwarded to the thread's {@code ThreadGroup} by invoking this
     * method.
     *
     * <p>New code should use {@link Thread#setUncaughtExceptionHandler} instead of thread groups.
     *
     * @param t the Thread that terminated with an uncaught exception
     * @param e the uncaught exception itself
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.790 -0500", hash_original_method = "1AEEC9D33E82C49A9FE6D436A43A8349", hash_generated_method = "91937A8B8B6096E808B5C7AF181B1ECB")
    
public void uncaughtException(Thread t, Throwable e) {
        if (parent != null) {
            parent.uncaughtException(t, e);
        } else if (Thread.getDefaultUncaughtExceptionHandler() != null) {
            // TODO The spec is unclear regarding this. What do we do?
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
        } else if (!(e instanceof ThreadDeath)) {
            // No parent group, has to be 'system' Thread Group
            e.printStackTrace(System.err);
        }
    }

    /**
     * Called by the Thread constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.792 -0500", hash_original_method = "2D14DBB3818CDCF2DBAC484BFFF8FD8D", hash_generated_method = "5453924C354DA49DAAE4D8422DAD0218")
    
final void addThread(Thread thread) throws IllegalThreadStateException {
        synchronized (threadRefs) {
            if (isDestroyed) {
                throw new IllegalThreadStateException();
            }
            threadRefs.add(new WeakReference<Thread>(thread));
        }
    }

    /**
     * Called by the VM when a Thread dies.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.795 -0500", hash_original_method = "37129B7DF3D611DDAA565F6673B5A889", hash_generated_method = "F883E303C45671B497E96C97324A3629")
    
final void removeThread(Thread thread) throws IllegalThreadStateException {
        synchronized (threadRefs) {
            for (Iterator<Thread> i = threads.iterator(); i.hasNext(); ) {
                if (i.next().equals(thread)) {
                    i.remove();
                    break;
                }
            }
        }
        destroyIfEmptyDaemon();
    }
}

