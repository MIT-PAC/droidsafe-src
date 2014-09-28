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
import java.io.IOException;

/**
 * Strategy for deleting files.
 * <p>
 * There is more than one way to delete a file.
 * You may want to limit access to certain directories, to only delete
 * directories if they are empty, or maybe to force deletion.
 * <p>
 * This class captures the strategy to use and is designed for user subclassing.
 *
 * @version $Id: FileDeleteStrategy.java 1307461 2012-03-30 15:12:29Z ggregory $
 * @since 1.3
 */
public class FileDeleteStrategy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.668 -0400", hash_original_field = "EF12BEEF9B656EB617C51DFD8D663987", hash_generated_field = "FD915F51B853AEB745551E70D65F83D2")

    public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.668 -0400", hash_original_field = "4828CDC570CAD9751AD213FE1E8109B7", hash_generated_field = "4CDC2D9057B7D8764CC3724A06FBA2A6")

    public static final FileDeleteStrategy FORCE = new ForceFileDeleteStrategy();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.669 -0400", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;

    //-----------------------------------------------------------------------
    /**
     * Restricted constructor.
     *
     * @param name  the name by which the strategy is known
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.669 -0400", hash_original_method = "B0EB7295797B434E427BAD2BC120E135", hash_generated_method = "E73F79DD933401F8DCAB380E8B1DAB7F")
    
protected FileDeleteStrategy(String name) {
        this.name = name;
    }

    //-----------------------------------------------------------------------
    /**
     * Deletes the file object, which may be a file or a directory.
     * All <code>IOException</code>s are caught and false returned instead.
     * If the file does not exist or is null, true is returned.
     * <p>
     * Subclass writers should override {@link #doDelete(File)}, not this method.
     *
     * @param fileToDelete  the file to delete, null returns true
     * @return true if the file was deleted, or there was no such file
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.670 -0400", hash_original_method = "EFE9EDBED2D379E86C4936EFD5742135", hash_generated_method = "B7BDF83F19C6F2D5DED390CC73A637A3")
    
public boolean deleteQuietly(File fileToDelete) {
        if (fileToDelete == null || fileToDelete.exists() == false) {
            return true;
        }
        try {
            return doDelete(fileToDelete);
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Deletes the file object, which may be a file or a directory.
     * If the file does not exist, the method just returns.
     * <p>
     * Subclass writers should override {@link #doDelete(File)}, not this method.
     *
     * @param fileToDelete  the file to delete, not null
     * @throws NullPointerException if the file is null
     * @throws IOException if an error occurs during file deletion
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.670 -0400", hash_original_method = "15784F6E602EC7190D496957E6C6E920", hash_generated_method = "D06533A9D272F731376A648C2C557325")
    
public void delete(File fileToDelete) throws IOException {
        if (fileToDelete.exists() && doDelete(fileToDelete) == false) {
            throw new IOException("Deletion failed: " + fileToDelete);
        }
    }

    /**
     * Actually deletes the file object, which may be a file or a directory.
     * <p>
     * This method is designed for subclasses to override.
     * The implementation may return either false or an <code>IOException</code>
     * when deletion fails. The {@link #delete(File)} and {@link #deleteQuietly(File)}
     * methods will handle either response appropriately.
     * A check has been made to ensure that the file will exist.
     * <p>
     * This implementation uses {@link File#delete()}.
     *
     * @param fileToDelete  the file to delete, exists, not null
     * @return true if the file was deleteds
     * @throws NullPointerException if the file is null
     * @throws IOException if an error occurs during file deletion
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.671 -0400", hash_original_method = "57E67E4626031877680FBBC8B7FC5113", hash_generated_method = "A9ECD11D5F0A4E6E316CE167F0F2B13B")
    
protected boolean doDelete(File fileToDelete) throws IOException {
        return fileToDelete.delete();
    }

    //-----------------------------------------------------------------------
    /**
     * Gets a string describing the delete strategy.
     *
     * @return a string describing the delete strategy
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.671 -0400", hash_original_method = "0D94F3DF71E8C7CC6D64706F8523FAA4", hash_generated_method = "6ACDB602BAFE9AA1288324277FD88CA1")
    
@Override
    public String toString() {
        return "FileDeleteStrategy[" + name + "]";
    }

    //-----------------------------------------------------------------------
    /**
     * Force file deletion strategy.
     */
    static class ForceFileDeleteStrategy extends FileDeleteStrategy {
        /** Default Constructor */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.672 -0400", hash_original_method = "94D227408D8CEC1DBDAAF9B0F3D58F8D", hash_generated_method = "94D227408D8CEC1DBDAAF9B0F3D58F8D")
        
ForceFileDeleteStrategy() {
            super("Force");
        }

        /**
         * Deletes the file object.
         * <p>
         * This implementation uses <code>FileUtils.forceDelete() <code>
         * if the file exists.
         *
         * @param fileToDelete  the file to delete, not null
         * @return Always returns {@code true}
         * @throws NullPointerException if the file is null
         * @throws IOException if an error occurs during file deletion
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.672 -0400", hash_original_method = "36CC05EFC6FFF5A71EED967857A4B132", hash_generated_method = "74518A42848100A4BDB9D86EE55B7F92")
        
@Override
        protected boolean doDelete(File fileToDelete) throws IOException {
            FileUtils.forceDelete(fileToDelete);
            return true;
        }
    }

}
