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
package org.apache.commons.io.monitor;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

/**
 * A runnable that spawns a monitoring thread triggering any
 * registered {@link FileAlterationObserver} at a specified interval.
 * 
 * @see FileAlterationObserver
 * @version $Id: FileAlterationMonitor.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 2.0
 */
public final class FileAlterationMonitor implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.049 -0400", hash_original_field = "848F9DFF1502BD12C449CA1D6F930427", hash_generated_field = "A187678ED22D20A3185A905AC22BB781")

    private  long interval;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.050 -0400", hash_original_field = "C560C5243470AE65617A70DF2EF8555B", hash_generated_field = "F3F34EF7C4EBDAADEFCB2334220A3BDA")

    private final List<FileAlterationObserver> observers = new CopyOnWriteArrayList<FileAlterationObserver>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.050 -0400", hash_original_field = "3CD3F29DEDCBA5BD1998C6761CF02A86", hash_generated_field = "80520562B1904B351F5B26D98691BDBB")

    private Thread thread = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.051 -0400", hash_original_field = "234E41C0185E0FF5F9C803B6B6AE98E4", hash_generated_field = "6AD968703BFB4237698E73F59CC7657E")

    private ThreadFactory threadFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.051 -0400", hash_original_field = "19791EFF28CC59AFB265FAF1180BA713", hash_generated_field = "D887AB93EC2149E2D4A25BFD1C4FE163")

    private volatile boolean running = false;

    /**
     * Construct a monitor with a default interval of 10 seconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.052 -0400", hash_original_method = "5732859DDEB3B1715451D21A81461EDA", hash_generated_method = "51DDD2668DA05CF2A67DD1DD32351FEC")
    
public FileAlterationMonitor() {
        this(10000);
    }

    /**
     * Construct a monitor with the specified interval.
     *
     * @param interval The amount of time in miliseconds to wait between
     * checks of the file system
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.052 -0400", hash_original_method = "53CA0D043E68099722661EEB7F58526A", hash_generated_method = "B835A170ADB5AF71D4480D31E173BD72")
    
public FileAlterationMonitor(long interval) {
        this.interval = interval;
    }

    /**
     * Construct a monitor with the specified interval and set of observers.
     *
     * @param interval The amount of time in miliseconds to wait between
     * checks of the file system
     * @param observers The set of observers to add to the monitor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.053 -0400", hash_original_method = "A414A772722097FFAFAD59FE99FA8E24", hash_generated_method = "9C04B2D139C7D4E0858CA23C00FAE7AB")
    
public FileAlterationMonitor(long interval, FileAlterationObserver... observers) {
        this(interval);
        if (observers != null) {
            for (FileAlterationObserver observer : observers) {
                addObserver(observer);
            }
        }
    }

    /**
     * Return the interval.
     *
     * @return the interval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.053 -0400", hash_original_method = "8CAC42DB459590AAD476B56FC6D4D691", hash_generated_method = "E67FF152803801BFA2AB41BED284C3F8")
    
public long getInterval() {
        return interval;
    }

    /**
     * Set the thread factory.
     *
     * @param threadFactory the thread factory
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.054 -0400", hash_original_method = "7BE8A8BA046629FAE448DADF48A43E2C", hash_generated_method = "A635551E0EC6814B768957D56FFB5E8A")
    
public synchronized void setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    /**
     * Add a file system observer to this monitor.
     *
     * @param observer The file system observer to add
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.054 -0400", hash_original_method = "2582EB9761FBC4039D57C08A2BAB7EC6", hash_generated_method = "337196F58DBFF1B0EFF866951B08E77A")
    
public void addObserver(final FileAlterationObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    /**
     * Remove a file system observer from this monitor.
     *
     * @param observer The file system observer to remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.055 -0400", hash_original_method = "F32D89C4D68A9F884EB414FBF4D51576", hash_generated_method = "49922040A4CE20A615BB17697EE3B720")
    
public void removeObserver(final FileAlterationObserver observer) {
        if (observer != null) {
            while (observers.remove(observer)) {
            }
        }
    }

    /**
     * Returns the set of {@link FileAlterationObserver} registered with
     * this monitor. 
     *
     * @return The set of {@link FileAlterationObserver}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.055 -0400", hash_original_method = "BF717E48FF5F91E5BF5689DA8A1B6D0C", hash_generated_method = "189EFAAB1682B6C29DB96FE2271665BE")
    
public Iterable<FileAlterationObserver> getObservers() {
        return observers;
    }

    /**
     * Start monitoring.
     *
     * @throws Exception if an error occurs initializing the observer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.056 -0400", hash_original_method = "B61D151163EA402642536A8375DC60A2", hash_generated_method = "5A991771D3878B22A70220CDCF44E2AD")
    
public synchronized void start() throws Exception {
        if (running) {
            throw new IllegalStateException("Monitor is already running");
        }
        for (FileAlterationObserver observer : observers) {
            observer.initialize();
        }
        running = true;
        if (threadFactory != null) {
            thread = threadFactory.newThread(this);
        } else {
            thread = new Thread(this);
        }
        thread.start();
    }

    /**
     * Stop monitoring.
     *
     * @throws Exception if an error occurs initializing the observer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.056 -0400", hash_original_method = "6C2BF33BEAB4575B1BB326C79611D3DD", hash_generated_method = "F8CEBBB4F4E001B68D1DBED8D292752B")
    
public synchronized void stop() throws Exception {
        stop(interval);
    }

    /**
     * Stop monitoring.
     *
     * @param stopInterval the amount of time in milliseconds to wait for the thread to finish.
     * A value of zero will wait until the thread is finished (see {@link Thread#join(long)}).
     * @throws Exception if an error occurs initializing the observer
     * @since 2.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.058 -0400", hash_original_method = "847744E50C0F667B1CC040D26B6B22E8", hash_generated_method = "9393EBDE2371CD541CA28FEDE3778976")
    
public synchronized void stop(long stopInterval) throws Exception {
        if (running == false) {
            throw new IllegalStateException("Monitor is not running");
        }
        running = false;
        try {
            thread.join(stopInterval);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        for (FileAlterationObserver observer : observers) {
            observer.destroy();
        }
    }

    /**
     * Run.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.058 -0400", hash_original_method = "24024F5BBB220303415536AF43C72777", hash_generated_method = "C9C14AF8B45AE808D2F5B91FC17F05C9")
    
public void run() {
        while (running) {
            for (FileAlterationObserver observer : observers) {
                observer.checkAndNotify();
            }
            if (!running) {
                break;
            }
            try {
                Thread.sleep(interval);
            } catch (final InterruptedException ignored) {
            }
        }
    }
}
