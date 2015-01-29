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
import java.io.File;
import java.io.Serializable;

/**
 * {@link FileEntry} represents the state of a file or directory, capturing
 * the following {@link File} attributes at a point in time.
 * <ul>
 *   <li>File Name (see {@link File#getName()})</li>
 *   <li>Exists - whether the file exists or not (see {@link File#exists()})</li>
 *   <li>Directory - whether the file is a directory or not (see {@link File#isDirectory()})</li>
 *   <li>Last Modified Date/Time (see {@link File#lastModified()})</li>
 *   <li>Length (see {@link File#length()}) - directories treated as zero</li>
 *   <li>Children - contents of a directory (see {@link File#listFiles(java.io.FileFilter)})</li>
 * </ul>
 * <p>
 * <h3>Custom Implementations</h3>
 * If the state of additional {@link File} attributes is required then create a custom
 * {@link FileEntry} with properties for those attributes. Override the
 * {@link #newChildInstance(File)} to return a new instance of the appropriate type.
 * You may also want to override the {@link #refresh(File)} method.
 * @see FileAlterationObserver
 * @since 2.0
 */
public class FileEntry implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.740 -0400", hash_original_field = "99B9D06D5538CD5BCDF31A80D6C881EA", hash_generated_field = "F21C6AADF59E9D671ACBE5D672216EEC")

    static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.741 -0400", hash_original_field = "EA64329E46CA63B27AA8C974D8E0AB30", hash_generated_field = "AB8F542161143C49D5F1CBC35DA2FB78")

    private  FileEntry parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.742 -0400", hash_original_field = "F20C4BEB5C7A135252632E9F8E5EB1CC", hash_generated_field = "61D578E413FC2348E3E1154CB71E41C8")

    private FileEntry[] children;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.742 -0400", hash_original_field = "CF0C1CE75EC12E637A82B051B1AA9983", hash_generated_field = "5939D876DBC3E83D21864E039D43CB17")

    private  File file;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.743 -0400", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.743 -0400", hash_original_field = "F881968009A14C23C3E78AAA8652BE2E", hash_generated_field = "505F505B095BB43877BCB3856B231199")

    private boolean exists;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.743 -0400", hash_original_field = "C9EF694414A945820299724929E0EF3F", hash_generated_field = "8ECB8B39ECBB42A822DE1CBA9484C0D7")

    private boolean directory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.744 -0400", hash_original_field = "88D568DF0AF9C48946B4F5AF1AF37E43", hash_generated_field = "7413EEC48F4CDDAF3E1A4FB26C30C26A")

    private long lastModified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.744 -0400", hash_original_field = "D634AAE75ADF86F4EAAC1CC85A8379F4", hash_generated_field = "C62D106264E132930C7955708C9A9CDD")

    private long length;

    /**
     * Construct a new monitor for a specified {@link File}.
     *
     * @param file The file being monitored
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.745 -0400", hash_original_method = "F06723331BD74012E73A257B3AB1A276", hash_generated_method = "AB76613235E732A9B1728926EB7D7ED7")
    
public FileEntry(File file) {
        this((FileEntry)null, file);
    }

    /**
     * Construct a new monitor for a specified {@link File}.
     *
     * @param parent The parent
     * @param file The file being monitored
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.746 -0400", hash_original_method = "1FCFFF4C4B05283E11E5CDF35E8EF21D", hash_generated_method = "FCE3C1A43083907C651EDE9DEC082CBE")
    
public FileEntry(FileEntry parent, File file) {
        if (file == null) {
            throw new IllegalArgumentException("File is missing");
        }
        this.file = file;
        this.parent = parent;
        this.name = file.getName();
    }

    /**
     * Refresh the attributes from the {@link File}, indicating
     * whether the file has changed.
     * <p>
     * This implementation refreshes the <code>name</code>, <code>exists</code>,
     * <code>directory</code>, <code>lastModified</code> and <code>length</code>
     * properties.
     * <p>
     * The <code>exists</code>, <code>directory</code>, <code>lastModified</code>
     * and <code>length</code> properties are compared for changes
     *
     * @param file the file instance to compare to
     * @return {@code true} if the file has changed, otherwise {@code false}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.746 -0400", hash_original_method = "0DE464E0982739533C2F4153E8EF2E0E", hash_generated_method = "CC3ABC6F2912E3B4F81CBE886A2C0459")
    
public boolean refresh(File file) {

        // cache original values
        boolean origExists       = exists;
        long    origLastModified = lastModified;
        boolean origDirectory    = directory;
        long    origLength       = length;

        // refresh the values
        name         = file.getName();
        exists       = file.exists();
        directory    = exists ? file.isDirectory() : false;
        lastModified = exists ? file.lastModified() : 0;
        length       = exists && !directory ? file.length() : 0;

        // Return if there are changes
        return exists != origExists ||
                lastModified != origLastModified ||
                directory != origDirectory ||
                length != origLength;
    }

    /**
     * Create a new child instance.
     * <p>
     * Custom implementations should override this method to return
     * a new instance of the appropriate type.
     *
     * @param file The child file
     * @return a new child instance
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.747 -0400", hash_original_method = "C3CF0DDAA6E3B0E070C32CB96AD599A3", hash_generated_method = "68AE37DE768F793EE88EDB4E916798EC")
    
public FileEntry newChildInstance(File file) {
        return new FileEntry(this, file);
    }

    /**
     * Return the parent entry.
     *
     * @return the parent entry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.747 -0400", hash_original_method = "E901EC28060B8CBB43FD892C561AF89D", hash_generated_method = "1C1727C2532B60835F0B615752F9B63F")
    
public FileEntry getParent() {
        return parent;
    }

    /**
     * Return the level
     *
     * @return the level
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.748 -0400", hash_original_method = "413C128DCD3997E04683C45E9C65F6CD", hash_generated_method = "4ACFECCCCB28E6AC8F690792B6DBD90D")
    
public int getLevel() {
        return parent == null ? 0 : parent.getLevel() + 1;
    }

    /**
     * Return the directory's files.
     *
     * @return This directory's files or an empty
     * array if the file is not a directory or the
     * directory is empty
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.748 -0400", hash_original_method = "ACDB7EF7822C47BD2D0D3497DD2FEBDF", hash_generated_method = "A79DA402818C74475B5430AC88E274F2")
    
public FileEntry[] getChildren() {
        return children != null ? children : EMPTY_ENTRIES;
    }

    /**
     * Set the directory's files.
     *
     * @param children This directory's files, may be null
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.749 -0400", hash_original_method = "587FA5041C73C3087DE3CB88D2A7F1CB", hash_generated_method = "20676D761FD13D5929EF684D4EF1DBB2")
    
public void setChildren(FileEntry[] children) {
        this.children = children;
    }

    /**
     * Return the file being monitored.
     *
     * @return the file being monitored
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.749 -0400", hash_original_method = "254E9EB55B544E07E2A606FED2225F70", hash_generated_method = "6388AE15EA030E1BF94C33E0A56E1C22")
    
public File getFile() {
        return file;
    }

    /**
     * Return the file name.
     *
     * @return the file name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.750 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Set the file name.
     *
     * @param name the file name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.750 -0400", hash_original_method = "4E95676967FCA987BCDC250B6108BD3E", hash_generated_method = "B382AAD6F5F1AA14659F3000D797B03A")
    
public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the last modified time from the last time it
     * was checked.
     *
     * @return the last modified time
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.751 -0400", hash_original_method = "48BC8D6785D5FA81609A53C9AB85BFFF", hash_generated_method = "37F5B4CAFB72D4C105BDCD63F79C513D")
    
public long getLastModified() {
        return lastModified;
    }

    /**
     * Return the last modified time from the last time it
     * was checked.
     *
     * @param lastModified The last modified time
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.751 -0400", hash_original_method = "4769525BF69184C943BEA4470C0C150B", hash_generated_method = "3D3257D356F2B412F675BA3398A3FBBB")
    
public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Return the length.
     *
     * @return the length
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.752 -0400", hash_original_method = "6D7E57BF471A54D84FC53DAB447C1A65", hash_generated_method = "09EF3FC411E213D94FD28B2C816A6CC2")
    
public long getLength() {
        return length;
    }

    /**
     * Set the length.
     *
     * @param length the length
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.752 -0400", hash_original_method = "D2825C543F9D9C1BBCF7888DEA8DC401", hash_generated_method = "87143D2A79B84A093B804F55DBC2B318")
    
public void setLength(long length) {
        this.length = length;
    }

    /**
     * Indicate whether the file existed the last time it
     * was checked.
     *
     * @return whether the file existed
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.752 -0400", hash_original_method = "6F66D971E54163B78A2414F4E7CCFEB2", hash_generated_method = "011ADAE59111CF5825D22375957FD7F1")
    
public boolean isExists() {
        return exists;
    }

    /**
     * Set whether the file existed the last time it
     * was checked.
     *
     * @param exists whether the file exists or not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.753 -0400", hash_original_method = "DBCCE2A0E67E546A8F9C08600E25706B", hash_generated_method = "595B5A0E348D1528F1564A274498E14A")
    
public void setExists(boolean exists) {
        this.exists = exists;
    }

    /**
     * Indicate whether the file is a directory or not.
     *
     * @return whether the file is a directory or not
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.753 -0400", hash_original_method = "D7E00245883AF8971102F357EED1C8FA", hash_generated_method = "496630CDD93B4DF59D5DA17D1C21876F")
    
public boolean isDirectory() {
        return directory;
    }

    /**
     * Set whether the file is a directory or not.
     *
     * @param directory whether the file is a directory or not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.754 -0400", hash_original_method = "519AC241C832EFA564E71C1E0C949985", hash_generated_method = "EED54873A584393DA2669017DB28AB24")
    
public void setDirectory(boolean directory) {
        this.directory = directory;
    }
}
