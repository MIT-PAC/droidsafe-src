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

/**
 * Monitors a thread, interrupting it of it reaches the specified timout.
 * <p>
 * This works by sleeping until the specified timout amount and then
 * interrupting the thread being monitored. If the thread being monitored
 * completes its work before being interrupted, it should <code>interrupt()<code>
 * the <i>monitor</i> thread.
 * <p>
 * 
 * <pre>
 *       long timeoutInMillis = 1000;
 *       try {
 *           Thread monitor = ThreadMonitor.start(timeoutInMillis);
 *           // do some work here
 *           ThreadMonitor.stop(monitor);
 *       } catch (InterruptedException e) {
 *           // timed amount was reached
 *       }
 * </pre>
 *
 * @version  $Id: ThreadMonitor.java 1307459 2012-03-30 15:11:44Z ggregory $
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
class ThreadMonitor implements Runnable {

    /**
     * Start monitoring the current thread.
     *
     * @param timeout The timout amount in milliseconds
     * or no timeout if the value is zero or less
     * @return The monitor thread or {@code null}
     * if the timout amount is not greater than zero
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.586 -0400", hash_original_method = "7C6E04592353FCD39AE43BAC80FC89F3", hash_generated_method = "FBC2392DE9BFB96CFE30E428C34214D9")
    
public static Thread start(long timeout) {
        return start(Thread.currentThread(), timeout);
    }

    /**
     * Start monitoring the specified thread.
     *
     * @param thread The thread The thread to monitor
     * @param timeout The timout amount in milliseconds
     * or no timeout if the value is zero or less
     * @return The monitor thread or {@code null}
     * if the timout amount is not greater than zero
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.587 -0400", hash_original_method = "D44D3BD1C996D71F3A5411E7F03049D1", hash_generated_method = "44C2A17845AF6CAAB64453C0D8C21AEE")
    
public static Thread start(Thread thread, long timeout) {
        Thread monitor = null;
        if (timeout > 0) {
            ThreadMonitor timout = new ThreadMonitor(thread, timeout);
            monitor = new Thread(timout, ThreadMonitor.class.getSimpleName());
            monitor.setDaemon(true);
            monitor.start();
        }
        return monitor;
    }

    /**
     * Stop monitoring the specified thread.
     *
     * @param thread The monitor thread, may be {@code null}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.587 -0400", hash_original_method = "5CB320D98B5CDF9E326E7FB31FA59258", hash_generated_method = "57CCD40328DCF1B5FA521799A47F88E6")
    
public static void stop(Thread thread) {
        if (thread != null) {
            thread.interrupt();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.584 -0400", hash_original_field = "AB87C4F6E5547EBD7483F34732EA576D", hash_generated_field = "3B3F78C77D023C4AC9933B933AD9AFEC")

    private  Thread thread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.585 -0400", hash_original_field = "13BEC42AF8DBEFB8594075D5454CC50F", hash_generated_field = "83CDA9988365E91179262582D25947DB")

    private  long timeout;

    /**
     * Construct and new monitor.
     *
     * @param thread The thread to monitor
     * @param timeout The timout amount in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.588 -0400", hash_original_method = "F053058678CE408C06156A1232B98617", hash_generated_method = "EE747F857EBFFF02FA6FA68C1F4F79C6")
    
private ThreadMonitor(Thread thread, long timeout) {
        this.thread = thread;
        this.timeout = timeout;
    }

    /**
     * Sleep until the specified timout amount and then
     * interrupt the thread being monitored.
     *
     * @see Runnable#run()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.588 -0400", hash_original_method = "D59462ADF236F9BB2B2797E094BBD843", hash_generated_method = "917B382B3C67AEF69FC9055FD2505276")
    
public void run() {
        try {
            Thread.sleep(timeout);
            thread.interrupt();
        } catch (InterruptedException e) {
            // timeout not reached
        }
    }
}