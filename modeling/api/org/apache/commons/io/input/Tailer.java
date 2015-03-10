/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * Simple implementation of the unix "tail -f" functionality.
 * <p>
 * <h2>1. Create a TailerListener implementation</h3>
 * <p>
 * First you need to create a {@link TailerListener} implementation
 * ({@link TailerListenerAdapter} is provided for convenience so that you don't have to
 * implement every method).
 * </p>
 *
 * <p>For example:</p>
 * <pre>
 *  public class MyTailerListener extends TailerListenerAdapter {
 *      public void handle(String line) {
 *          System.out.println(line);
 *      }
 *  }
 * </pre>
 * 
 * <h2>2. Using a Tailer</h2>
 *
 * You can create and use a Tailer in one of three ways:
 * <ul>
 *   <li>Using one of the static helper methods:
 *     <ul>
 *       <li>{@link Tailer#create(File, TailerListener)}</li>
 *       <li>{@link Tailer#create(File, TailerListener, long)}</li>
 *       <li>{@link Tailer#create(File, TailerListener, long, boolean)}</li>
 *     </ul>
 *   </li>
 *   <li>Using an {@link java.util.concurrent.Executor}</li>
 *   <li>Using an {@link Thread}</li>
 * </ul>
 *
 * An example of each of these is shown below.
 * 
 * <h3>2.1 Using the static helper method</h3>
 *
 * <pre>
 *      TailerListener listener = new MyTailerListener();
 *      Tailer tailer = Tailer.create(file, listener, delay);
 * </pre>
 *      
 * <h3>2.2 Use an Executor</h3>
 * 
 * <pre>
 *      TailerListener listener = new MyTailerListener();
 *      Tailer tailer = new Tailer(file, listener, delay);
 *
 *      // stupid executor impl. for demo purposes
 *      Executor executor = new Executor() {
 *          public void execute(Runnable command) {
 *              command.run();
 *           }
 *      };
 *
 *      executor.execute(tailer);
 * </pre>
 *      
 *      
 * <h3>2.3 Use a Thread</h3>
 * <pre>
 *      TailerListener listener = new MyTailerListener();
 *      Tailer tailer = new Tailer(file, listener, delay);
 *      Thread thread = new Thread(tailer);
 *      thread.setDaemon(true); // optional
 *      thread.start();
 * </pre>
 *
 * <h2>3. Stop Tailing</h3>
 * <p>Remember to stop the tailer when you have done with it:</p>
 * <pre>
 *      tailer.stop();
 * </pre>
 *
 * @see TailerListener
 * @see TailerListenerAdapter
 * @version $Id: Tailer.java 1348698 2012-06-11 01:09:58Z ggregory $
 * @since 2.0
 */
public class Tailer implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.542 -0400", hash_original_field = "725226EF0E8701AA984C45A48F6E7744", hash_generated_field = "25A43ED8FCAD6FC6197CB411C25B79C3")

    private static final int DEFAULT_DELAY_MILLIS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.542 -0400", hash_original_field = "7A837E6F702D57E688BDB1C746400802", hash_generated_field = "1F30A13CE739B7AF28D6138EBA46FC76")

    private static final String RAF_MODE = "r";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.543 -0400", hash_original_field = "578731048DAF50D19374D7BF701F5369", hash_generated_field = "31C29F459B60D87A94E429FA9A8599CD")

    private static final int DEFAULT_BUFSIZE = 4096;
    
    /**
     * Creates and starts a Tailer for the given file.
     * 
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     * @param end Set to true to tail from the end of the file, false to tail from the beginning of the file.
     * @param bufSize buffer size.
     * @return The new tailer
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.551 -0400", hash_original_method = "C216811775A6723BB41E0D3A835823FC", hash_generated_method = "2E1788EBA86DBE00B0A103790D8375CB")
    
public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, int bufSize) {
        Tailer tailer = new Tailer(file, listener, delayMillis, end, bufSize);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    /**
     * Creates and starts a Tailer for the given file.
     * 
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     * @param end Set to true to tail from the end of the file, false to tail from the beginning of the file.
     * @param reOpen whether to close/reopen the file between chunks
     * @param bufSize buffer size.
     * @return The new tailer
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.552 -0400", hash_original_method = "77CB7B14C0920E2315B4EAFBAD54E6D3", hash_generated_method = "25A400C91FDB6DE244445ADCA4231F0E")
    
public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen, 
            int bufSize) {
        Tailer tailer = new Tailer(file, listener, delayMillis, end, reOpen, bufSize);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    /**
     * Creates and starts a Tailer for the given file with default buffer size.
     * 
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     * @param end Set to true to tail from the end of the file, false to tail from the beginning of the file.
     * @return The new tailer
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.553 -0400", hash_original_method = "E6DE67B17B1FA33B29D27621C538E66B", hash_generated_method = "D6EBAA38BAAAD9B840A522F8810F5649")
    
public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end) {
        return create(file, listener, delayMillis, end, DEFAULT_BUFSIZE);
    }

    /**
     * Creates and starts a Tailer for the given file with default buffer size.
     * 
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     * @param end Set to true to tail from the end of the file, false to tail from the beginning of the file.
     * @param reOpen whether to close/reopen the file between chunks
     * @return The new tailer
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.553 -0400", hash_original_method = "7C746AA13415E8E0AE7778068EA348B5", hash_generated_method = "833FB290FD68776643CC40816924356F")
    
public static Tailer create(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen) {
        return create(file, listener, delayMillis, end, reOpen, DEFAULT_BUFSIZE);
    }

    /**
     * Creates and starts a Tailer for the given file, starting at the beginning of the file
     * 
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     * @return The new tailer
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.554 -0400", hash_original_method = "010EB4E68D4169840D612501A178DC5A", hash_generated_method = "BF88707516C13A89332BB74417756DF5")
    
public static Tailer create(File file, TailerListener listener, long delayMillis) {
        return create(file, listener, delayMillis, false);
    }

    /**
     * Creates and starts a Tailer for the given file, starting at the beginning of the file
     * with the default delay of 1.0s
     * 
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @return The new tailer
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.554 -0400", hash_original_method = "384D8F40DBB3390AC47A6D604F80EC3E", hash_generated_method = "66965F1F6AC5BAF8A8FD7A6B45E8FED9")
    
public static Tailer create(File file, TailerListener listener) {
        return create(file, listener, DEFAULT_DELAY_MILLIS, false);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.544 -0400", hash_original_field = "28206FAEDF0F92E5608B32AAFC54A7B4", hash_generated_field = "4FA79A157E51B91A8E83AD7C4AB74E2F")

    private  byte inbuf[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.544 -0400", hash_original_field = "CF0C1CE75EC12E637A82B051B1AA9983", hash_generated_field = "5939D876DBC3E83D21864E039D43CB17")

    private  File file;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.545 -0400", hash_original_field = "5B9A4989E18337FA5EBDCD66E384719B", hash_generated_field = "BB9E3CEB5FC6C48F33AA1AB56B3738AC")

    private  long delayMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.546 -0400", hash_original_field = "1187F31E0927BF6D9F8C8D3BF7AA3DB1", hash_generated_field = "165EBAA3E49FF2963DF3E0842864DDEA")

    private  boolean end;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.546 -0400", hash_original_field = "82BEBC699D42295804921A4AD60B36C4", hash_generated_field = "E048D6C9CDAD7DC027FC8CB2A005BA02")

    private  TailerListener listener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.547 -0400", hash_original_field = "558BB09D9461A0A7CEA6EFF261BC0EE8", hash_generated_field = "47FDC46191A53245A20DE62B2429C99D")

    private  boolean reOpen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.547 -0400", hash_original_field = "BFBA22BF61BCE79ED09724E5342CE49D", hash_generated_field = "17FB020FBEF0F1CE3E941B0D1BC9976A")

    private volatile boolean run = true;

    /**
     * Creates a Tailer for the given file, starting from the beginning, with the default delay of 1.0s.
     * @param file The file to follow.
     * @param listener the TailerListener to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.548 -0400", hash_original_method = "A2F044E1F91B3619E7A224DE41EBBC75", hash_generated_method = "A078683376BE211FE938BE2561E5A6DF")
    
public Tailer(File file, TailerListener listener) {
        this(file, listener, DEFAULT_DELAY_MILLIS);
    }

    /**
     * Creates a Tailer for the given file, starting from the beginning.
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.548 -0400", hash_original_method = "C5D886AD22E328503E0353CA28EDA453", hash_generated_method = "731DBBFBD966B892D1B6CE90D69AC2A3")
    
public Tailer(File file, TailerListener listener, long delayMillis) {
        this(file, listener, delayMillis, false);
    }

    /**
     * Creates a Tailer for the given file, with a delay other than the default 1.0s.
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     * @param end Set to true to tail from the end of the file, false to tail from the beginning of the file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.549 -0400", hash_original_method = "9AA6A50D6F693D552F5EA103BA14E042", hash_generated_method = "3B8D83A7B8EDE60FE1BC8087E0DD852D")
    
public Tailer(File file, TailerListener listener, long delayMillis, boolean end) {
        this(file, listener, delayMillis, end, DEFAULT_BUFSIZE);
    }
    
    /**
     * Creates a Tailer for the given file, with a delay other than the default 1.0s.
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     * @param end Set to true to tail from the end of the file, false to tail from the beginning of the file.
     * @param reOpen if true, close and reopen the file between reading chunks 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.549 -0400", hash_original_method = "397BCE7F7F1AA9D4B191595A6D0C7181", hash_generated_method = "9490FE5D34789655FFB9EDB16CB9A84D")
    
public Tailer(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen) {
        this(file, listener, delayMillis, end, reOpen, DEFAULT_BUFSIZE);
    }
    
    /**
     * Creates a Tailer for the given file, with a specified buffer size.
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     * @param end Set to true to tail from the end of the file, false to tail from the beginning of the file.
     * @param bufSize Buffer size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.550 -0400", hash_original_method = "64379275E477684BC8BE083C929F3957", hash_generated_method = "870C99CBACE0EF64545C61597D41ABD6")
    
public Tailer(File file, TailerListener listener, long delayMillis, boolean end, int bufSize) {
        this(file, listener, delayMillis, end, false, bufSize);
    }
    
    /**
     * Creates a Tailer for the given file, with a specified buffer size.
     * @param file the file to follow.
     * @param listener the TailerListener to use.
     * @param delayMillis the delay between checks of the file for new content in milliseconds.
     * @param end Set to true to tail from the end of the file, false to tail from the beginning of the file.
     * @param reOpen if true, close and reopen the file between reading chunks 
     * @param bufSize Buffer size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.551 -0400", hash_original_method = "4BA394E13A782A88CA2C4709DA19FD56", hash_generated_method = "0F91443D3028D068758F69EFC3E34AE0")
    
public Tailer(File file, TailerListener listener, long delayMillis, boolean end, boolean reOpen, int bufSize) {
        this.file = file;
        this.delayMillis = delayMillis;
        this.end = end;
        
        this.inbuf = new byte[bufSize];

        // Save and prepare the listener
        this.listener = listener;
        listener.init(this);
        listener.fileNotFound();
        listener.fileRotated();
        listener.handle(new Exception());
        listener.handle(DSUtils.FAKE_STRING);
        this.reOpen = reOpen;
        
    }

    /**
     * Return the file.
     *
     * @return the file
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.555 -0400", hash_original_method = "254E9EB55B544E07E2A606FED2225F70", hash_generated_method = "6388AE15EA030E1BF94C33E0A56E1C22")
    
public File getFile() {
        return file;
    }

    /**
     * Return the delay in milliseconds.
     *
     * @return the delay in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.555 -0400", hash_original_method = "585B2EFA3032D4C482695ACE1752FB74", hash_generated_method = "16A0BDFF668CFE4E84321517C486F636")
    
public long getDelay() {
        return delayMillis;
    }

    /**
     * Follows changes in the file, calling the TailerListener's handle method for each new line.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.557 -0400", hash_original_method = "FBA32DA5B44CA2DA8EFD603946A54B03", hash_generated_method = "0909D638497257790797F5B7F015DB0A")
    
public void run() {
        RandomAccessFile reader = null;
        try {
            long last = 0; // The last time the file was checked for changes
            long position = 0; // position within the file
            // Open the file
            while (run && reader == null) {
                try {
                    reader = new RandomAccessFile(file, RAF_MODE);
                } catch (FileNotFoundException e) {
                    listener.fileNotFound();
                }

                if (reader == null) {
                    try {
                        Thread.sleep(delayMillis);
                    } catch (InterruptedException e) {
                    }
                } else {
                    // The current position in the file
                    position = end ? file.length() : 0;
                    last = System.currentTimeMillis();
                    reader.seek(position);
                }
            }

            while (run) {

                boolean newer = FileUtils.isFileNewer(file, last); // IO-279, must be done first

                // Check the file length to see if it was rotated
                long length = file.length();

                if (length < position) {

                    // File was rotated
                    listener.fileRotated();

                    // Reopen the reader after rotation
                    try {
                        // Ensure that the old file is closed iff we re-open it successfully
                        RandomAccessFile save = reader;
                        reader = new RandomAccessFile(file, RAF_MODE);
                        position = 0;
                        // close old file explicitly rather than relying on GC picking up previous RAF
                        IOUtils.closeQuietly(save);
                    } catch (FileNotFoundException e) {
                        // in this case we continue to use the previous reader and position values
                        listener.fileNotFound();
                    }
                    continue;
                } else {

                    // File was not rotated

                    // See if the file needs to be read again
                    if (length > position) {

                        // The file has more content than it did last time
                        position = readLines(reader);
                        last = System.currentTimeMillis();

                    } else if (newer) {

                        /*
                         * This can happen if the file is truncated or overwritten with the exact same length of
                         * information. In cases like this, the file position needs to be reset
                         */
                        position = 0;
                        reader.seek(position); // cannot be null here

                        // Now we can read new lines
                        position = readLines(reader);
                        last = System.currentTimeMillis();
                    }
                }
                if (reOpen) {
                    IOUtils.closeQuietly(reader);
                }
                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException e) {
                }
                if (run && reOpen) {
                    reader = new RandomAccessFile(file, RAF_MODE);
                    reader.seek(position);
                }
            }

        } catch (Exception e) {

            listener.handle(e);

        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    /**
     * Allows the tailer to complete its current loop and return.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.558 -0400", hash_original_method = "51D98BC23EDBD98D3C1A640CAE368CF4", hash_generated_method = "1632425B4BDCADE76DD082B000ECC42C")
    
public void stop() {
        this.run = false;
    }

    /**
     * Read new lines.
     *
     * @param reader The file to read
     * @return The new position after the lines have been read
     * @throws java.io.IOException if an I/O error occurs.
     */
    @DSSource({DSSourceKind.IO})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.559 -0400", hash_original_method = "BAA3ED875E19911C3E75F2F82717033E", hash_generated_method = "EA1346BDE73EBCB5A920CE6AC9ADD2FD")
    
private long readLines(RandomAccessFile reader) throws IOException {
        StringBuilder sb = new StringBuilder();

        long pos = reader.getFilePointer();
        long rePos = pos; // position to re-read

        int num;
        boolean seenCR = false;
        while (run && ((num = reader.read(inbuf)) != -1)) {
            for (int i = 0; i < num; i++) {
                byte ch = inbuf[i];
                switch (ch) {
                case '\n':
                    seenCR = false; // swallow CR before LF
                    listener.handle(sb.toString());
                    sb.setLength(0);
                    rePos = pos + i + 1;
                    break;
                case '\r':
                    if (seenCR) {
                        sb.append('\r');
                    }
                    seenCR = true;
                    break;
                default:
                    if (seenCR) {
                        seenCR = false; // swallow final CR
                        listener.handle(sb.toString());
                        sb.setLength(0);
                        rePos = pos + i + 1;
                    }
                    sb.append((char) ch); // add character, not its ascii value
                }
            }

            pos = reader.getFilePointer();
        }

        reader.seek(rePos); // Ensure we can re-read if necessary
        return rePos;
    }

}
