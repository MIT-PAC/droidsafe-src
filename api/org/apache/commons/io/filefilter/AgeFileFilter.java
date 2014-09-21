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
package org.apache.commons.io.filefilter;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.io.FileUtils;

/**
 * Filters files based on a cutoff time, can filter either newer
 * files or files equal to or older.
 * <p>
 * For example, to print all files and directories in the
 * current directory older than one day:
 *
 * <pre>
 * File dir = new File(".");
 * // We are interested in files older than one day
 * long cutoff = System.currentTimeMillis() - (24 * 60 * 60 * 1000);
 * String[] files = dir.list( new AgeFileFilter(cutoff) );
 * for ( int i = 0; i &lt; files.length; i++ ) {
 *     System.out.println(files[i]);
 * }
 * </pre>
 *
 * @version $Id: AgeFileFilter.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @see FileFilterUtils#ageFileFilter(Date)
 * @see FileFilterUtils#ageFileFilter(File)
 * @see FileFilterUtils#ageFileFilter(long)
 * @see FileFilterUtils#ageFileFilter(Date, boolean)
 * @see FileFilterUtils#ageFileFilter(File, boolean)
 * @see FileFilterUtils#ageFileFilter(long, boolean)
 * @since 1.2
 */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.630 -0400", hash_original_field = "E1D79ABEE7D99024B42B538261DFA2C4", hash_generated_field = "81965751CDEA420A369B1B538289676A")

    private  long cutoff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.631 -0400", hash_original_field = "ABCBA67ED2144B5040D88E107931E53B", hash_generated_field = "576CD9DEAB435A89864055E3BE928DA3")

    private  boolean acceptOlder;

    /**
     * Constructs a new age file filter for files equal to or older than
     * a certain cutoff
     *
     * @param cutoff  the threshold age of the files
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.631 -0400", hash_original_method = "92F5494CF4D9D109324ADFB75FCABD0E", hash_generated_method = "743547C659F4AEF6D23A61E94065CC20")
    
public AgeFileFilter(long cutoff) {
        this(cutoff, true);
    }

    /**
     * Constructs a new age file filter for files on any one side
     * of a certain cutoff.
     *
     * @param cutoff  the threshold age of the files
     * @param acceptOlder  if true, older files (at or before the cutoff)
     * are accepted, else newer ones (after the cutoff).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.632 -0400", hash_original_method = "831674657A405FDE7D8847FE1F919007", hash_generated_method = "D380B7AFFB08D691DE8B27F632863A35")
    
public AgeFileFilter(long cutoff, boolean acceptOlder) {
        this.acceptOlder = acceptOlder;
        this.cutoff = cutoff;
    }

    /**
     * Constructs a new age file filter for files older than (at or before)
     * a certain cutoff date.
     *
     * @param cutoffDate  the threshold age of the files
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.632 -0400", hash_original_method = "D8BC969A867ECF7BB5F00F6D0F678B06", hash_generated_method = "16614BB96A796C74F5854FA518F9FE5B")
    
public AgeFileFilter(Date cutoffDate) {
        this(cutoffDate, true);
    }

    /**
     * Constructs a new age file filter for files on any one side
     * of a certain cutoff date.
     *
     * @param cutoffDate  the threshold age of the files
     * @param acceptOlder  if true, older files (at or before the cutoff)
     * are accepted, else newer ones (after the cutoff).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.633 -0400", hash_original_method = "E5B19505EE022DF11F6B87B3BEA51BB3", hash_generated_method = "38000AD25D7D054B6AD160C50838191E")
    
public AgeFileFilter(Date cutoffDate, boolean acceptOlder) {
        this(cutoffDate.getTime(), acceptOlder);
    }

    /**
     * Constructs a new age file filter for files older than (at or before)
     * a certain File (whose last modification time will be used as reference).
     *
     * @param cutoffReference  the file whose last modification
     *        time is usesd as the threshold age of the files
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.633 -0400", hash_original_method = "FE76F52B20D2DBCABA13ACBB8614BB4C", hash_generated_method = "627EDEF17B98C63D09AAAC452528F09B")
    
public AgeFileFilter(File cutoffReference) {
        this(cutoffReference, true);
    }

    /**
     * Constructs a new age file filter for files on any one side
     * of a certain File (whose last modification time will be used as
     * reference).
     *
     * @param cutoffReference  the file whose last modification
     *        time is usesd as the threshold age of the files
     * @param acceptOlder  if true, older files (at or before the cutoff)
     * are accepted, else newer ones (after the cutoff).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.634 -0400", hash_original_method = "FE81CA629F548A2360BBC608169A9827", hash_generated_method = "EBA2D632EC8A90AB1633D730AB27A639")
    
public AgeFileFilter(File cutoffReference, boolean acceptOlder) {
        this(cutoffReference.lastModified(), acceptOlder);
    }

    //-----------------------------------------------------------------------
    /**
     * Checks to see if the last modification of the file matches cutoff
     * favorably.
     * <p>
     * If last modification time equals cutoff and newer files are required,
     * file <b>IS NOT</b> selected.
     * If last modification time equals cutoff and older files are required,
     * file <b>IS</b> selected.
     *
     * @param file  the File to check
     * @return true if the filename matches
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.634 -0400", hash_original_method = "C00DF150BD7A81B8538F88231B296818", hash_generated_method = "E5738BF70A323531E51144F65A827633")
    
@Override
    public boolean accept(File file) {
        boolean newer = FileUtils.isFileNewer(file, cutoff);
        return acceptOlder ? !newer : newer;
    }

    /**
     * Provide a String representaion of this file filter.
     *
     * @return a String representaion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.635 -0400", hash_original_method = "99B5BE3867B40B3085E3122FEC15BA27", hash_generated_method = "B3E6CCF07FE265E91C2AB6D3E799467C")
    
@Override
    public String toString() {
        String condition = acceptOlder ? "<=" : ">";
        return super.toString() + "(" + condition + cutoff + ")";
    }
}
