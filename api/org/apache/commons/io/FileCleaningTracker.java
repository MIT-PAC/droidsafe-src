/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Keeps track of files awaiting deletion, and deletes them when an associated
 * marker object is reclaimed by the garbage collector.
 * <p>
 * This utility creates a background thread to handle file deletion.
 * Each file to be deleted is registered with a handler object.
 * When the handler object is garbage collected, the file is deleted.
 * <p>
 * In an environment with multiple class loaders (a servlet container, for
 * example), you should consider stopping the background thread if it is no
 * longer needed. This is done by invoking the method
 * {@link #exitWhenFinished}, typically in
 * {@link javax.servlet.ServletContextListener#contextDestroyed} or similar.
 *
 * @version $Id: FileCleaningTracker.java 1307462 2012-03-30 15:13:11Z ggregory $
 */
public class FileCleaningTracker {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.322 -0400", hash_original_field = "213531C24E01D75B6586561286CC3D19", hash_generated_field = "213531C24E01D75B6586561286CC3D19")

    ReferenceQueue<Object> q = new ReferenceQueue<Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.322 -0400", hash_original_field = "14A8C4C39789CC6394C0F07624C236D3", hash_generated_field = "AF9D0C9A26B48389985C14225EEC9872")

    final Collection<Tracker> trackers = Collections.synchronizedSet(new HashSet<Tracker>());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.323 -0400", hash_original_field = "AC2F776E50A8843D73CFC7D977CF20B7", hash_generated_field = "3B38E3F054C530D64669A89040A89ED5")

    /**
     * Collection of File paths that failed to delete.
     */
    final List<String> deleteFailures = Collections.synchronizedList(new ArrayList<String>());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.323 -0400", hash_original_field = "E8C55FF70357A3CE01189512095E7073", hash_generated_field = "FC69D0639783984C922B494B12D9334F")

    volatile boolean exitWhenFinished = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.324 -0400", hash_original_field = "FF1EED7D363F9E58AB5605C1B22B97F7", hash_generated_field = "FF1EED7D363F9E58AB5605C1B22B97F7")

    Thread reaper;

    //-----------------------------------------------------------------------
    /**
     * Track the specified file, using the provided marker, deleting the file
     * when the marker instance is garbage collected.
     * The {@link FileDeleteStrategy#NORMAL normal} deletion strategy will be used.
     *
     * @param file  the file to be tracked, not null
     * @param marker  the marker object used to track the file, not null
     * @throws NullPointerException if the file is null
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.325 -0400", hash_original_method = "F07020199FD227FDE709D6E57E38422A", hash_generated_method = "FE6ABE5F9F8279E840F1B593ED77BA5D")
    
public void track(File file, Object marker) {
        track(file, marker, (FileDeleteStrategy) null);
    }

    /**
     * Track the specified file, using the provided marker, deleting the file
     * when the marker instance is garbage collected.
     * The speified deletion strategy is used.
     *
     * @param file  the file to be tracked, not null
     * @param marker  the marker object used to track the file, not null
     * @param deleteStrategy  the strategy to delete the file, null means normal
     * @throws NullPointerException if the file is null
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.325 -0400", hash_original_method = "86C594F1F9E71F35FFEC0A77C084143C", hash_generated_method = "451F8B81BF1B43C8797ECA03377447B6")
    
public void track(File file, Object marker, FileDeleteStrategy deleteStrategy) {
        if (file == null) {
            throw new NullPointerException("The file must not be null");
        }
        addTracker(file.getPath(), marker, deleteStrategy);
    }

    /**
     * Track the specified file, using the provided marker, deleting the file
     * when the marker instance is garbage collected.
     * The {@link FileDeleteStrategy#NORMAL normal} deletion strategy will be used.
     *
     * @param path  the full path to the file to be tracked, not null
     * @param marker  the marker object used to track the file, not null
     * @throws NullPointerException if the path is null
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.326 -0400", hash_original_method = "A3E86DDC0D794AB85A77D2E23B6B45C0", hash_generated_method = "2A6F3ECCBB536761B0EE18A98D670F1B")
    
public void track(String path, Object marker) {
        track(path, marker, (FileDeleteStrategy) null);
    }

    /**
     * Track the specified file, using the provided marker, deleting the file
     * when the marker instance is garbage collected.
     * The speified deletion strategy is used.
     *
     * @param path  the full path to the file to be tracked, not null
     * @param marker  the marker object used to track the file, not null
     * @param deleteStrategy  the strategy to delete the file, null means normal
     * @throws NullPointerException if the path is null
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.326 -0400", hash_original_method = "543B22C2EC07CA4C1AEB003D5BB6B718", hash_generated_method = "F952677652B1D1C01B115CD23A0864CB")
    
public void track(String path, Object marker, FileDeleteStrategy deleteStrategy) {
        if (path == null) {
            throw new NullPointerException("The path must not be null");
        }
        addTracker(path, marker, deleteStrategy);
    }

    /**
     * Adds a tracker to the list of trackers.
     * 
     * @param path  the full path to the file to be tracked, not null
     * @param marker  the marker object used to track the file, not null
     * @param deleteStrategy  the strategy to delete the file, null means normal
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.327 -0400", hash_original_method = "954E11DA9D99B56A3E0C00DDF1274471", hash_generated_method = "ECD28A95C2DD57DE45861ACB0CB555AE")
    
private synchronized void addTracker(String path, Object marker, FileDeleteStrategy deleteStrategy) {
        // synchronized block protects reaper
        if (exitWhenFinished) {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
        if (reaper == null) {
            reaper = new Reaper();
            reaper.start();
        }
        trackers.add(new Tracker(path, deleteStrategy, marker, q));
    }

    //-----------------------------------------------------------------------
    /**
     * Retrieve the number of files currently being tracked, and therefore
     * awaiting deletion.
     *
     * @return the number of files being tracked
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.327 -0400", hash_original_method = "0EFA130573A478F2919BB30F1541B30D", hash_generated_method = "F8484D6AAE9ABBE9333E6292CCA82A75")
    
public int getTrackCount() {
        return trackers.size();
    }

    /**
     * Return the file paths that failed to delete.
     *
     * @return the file paths that failed to delete
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.328 -0400", hash_original_method = "643CA49BD82C37C2D2981C66A57227C8", hash_generated_method = "F8FA693E5216BD1BE2CCC021C98FDD7C")
    
public List<String> getDeleteFailures() {
        return deleteFailures;
    }

    /**
     * Call this method to cause the file cleaner thread to terminate when
     * there are no more objects being tracked for deletion.
     * <p>
     * In a simple environment, you don't need this method as the file cleaner
     * thread will simply exit when the JVM exits. In a more complex environment,
     * with multiple class loaders (such as an application server), you should be
     * aware that the file cleaner thread will continue running even if the class
     * loader it was started from terminates. This can consitute a memory leak.
     * <p>
     * For example, suppose that you have developed a web application, which
     * contains the commons-io jar file in your WEB-INF/lib directory. In other
     * words, the FileCleaner class is loaded through the class loader of your
     * web application. If the web application is terminated, but the servlet
     * container is still running, then the file cleaner thread will still exist,
     * posing a memory leak.
     * <p>
     * This method allows the thread to be terminated. Simply call this method
     * in the resource cleanup code, such as {@link javax.servlet.ServletContextListener#contextDestroyed}.
     * Once called, no new objects can be tracked by the file cleaner.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.328 -0400", hash_original_method = "4DFB4596FA2073A710F42E9B9443E144", hash_generated_method = "C3FBB34989325B690EECF2AF37871121")
    
public synchronized void exitWhenFinished() {
        // synchronized block protects reaper
        exitWhenFinished = true;
        if (reaper != null) {
            synchronized (reaper) {
                reaper.interrupt();
            }
        }
    }

    //-----------------------------------------------------------------------
    /**
     * The reaper thread.
     */
    private final class Reaper extends Thread {
        /** Construct a new Reaper */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.329 -0400", hash_original_method = "8A2C8203FCA0486478B916225D009300", hash_generated_method = "8A2C8203FCA0486478B916225D009300")
        
Reaper() {
            super("File Reaper");
            setPriority(Thread.MAX_PRIORITY);
            setDaemon(true);
        }

        /**
         * Run the reaper thread that will delete files as their associated
         * marker objects are reclaimed by the garbage collector.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.330 -0400", hash_original_method = "63BD1C8F3C17781753BA16C837ECEC6F", hash_generated_method = "E5468C1E2BA5EAE22EA27D6A25B3384C")
        
@Override
        public void run() {
            // thread exits when exitWhenFinished is true and there are no more tracked objects
            while (exitWhenFinished == false || trackers.size() > 0) {
                try {
                    // Wait for a tracker to remove.
                    Tracker tracker = (Tracker) q.remove(); // cannot return null
                    trackers.remove(tracker);
                    if (!tracker.delete()) {
                        deleteFailures.add(tracker.getPath());
                    }
                    tracker.clear();
                } catch (InterruptedException e) {
                    continue;
                }
            }
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Inner class which acts as the reference for a file pending deletion.
     */
    private static final class Tracker extends PhantomReference<Object> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.331 -0400", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

        private  String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.331 -0400", hash_original_field = "6DBF5E9A7EC0C78BEF9C52ED8300A0C0", hash_generated_field = "B4FF12F6828CA41D190DAA3E50AD77C4")

        private  FileDeleteStrategy deleteStrategy;

        /**
         * Constructs an instance of this class from the supplied parameters.
         *
         * @param path  the full path to the file to be tracked, not null
         * @param deleteStrategy  the strategy to delete the file, null means normal
         * @param marker  the marker object used to track the file, not null
         * @param queue  the queue on to which the tracker will be pushed, not null
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.332 -0400", hash_original_method = "D194994672CF72D739AD2FC5B3B2AA56", hash_generated_method = "D194994672CF72D739AD2FC5B3B2AA56")
        
Tracker(String path, FileDeleteStrategy deleteStrategy, Object marker, ReferenceQueue<? super Object> queue) {
            super(marker, queue);
            this.path = path;
            this.deleteStrategy = deleteStrategy == null ? FileDeleteStrategy.NORMAL : deleteStrategy;
        }

        /**
         * Return the path.
         *
         * @return the path
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.332 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "685DA06B3205BF0988B63E7E0C7CEB6C")
        
public String getPath() {
            return path;
        }

        /**
         * Deletes the file associated with this tracker instance.
         *
         * @return {@code true} if the file was deleted successfully;
         *         {@code false} otherwise.
         */
        @DSSpec(DSCat.SPEC_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.333 -0400", hash_original_method = "D48AE50A84087A4C1BFE9CE0B93380B9", hash_generated_method = "4B053211185EA99FD2BC5B2841DAEC8F")
        
public boolean delete() {
            return deleteStrategy.deleteQuietly(new File(path));
        }
    }

}
