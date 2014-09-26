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
import java.io.FileFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.NameFileComparator;

/**
 * FileAlterationObserver represents the state of files below a root directory,
 * checking the filesystem and notifying listeners of create, change or
 * delete events.
 * <p>
 * To use this implementation:
 * <ul>
 *   <li>Create {@link FileAlterationListener} implementation(s) that process
 *      the file/directory create, change and delete events</li>
 *   <li>Register the listener(s) with a {@link FileAlterationObserver} for
 *       the appropriate directory.</li>
 *   <li>Either register the observer(s) with a {@link FileAlterationMonitor} or
 *       run manually.</li>
 * </ul>
 *
 * <h2>Basic Usage</h2>
 * Create a {@link FileAlterationObserver} for the directory and register the listeners:
 * <pre>
 *      File directory = new File(new File("."), "src");
 *      FileAlterationObserver observer = new FileAlterationObserver(directory);
 *      observer.addListener(...);
 *      observer.addListener(...);
 * </pre>
 * To manually observe a directory, initialize the observer and invoked the
 * {@link #checkAndNotify()} method as required:
 * <pre>
 *      // intialize
 *      observer.init();
 *      ...
 *      // invoke as required
 *      observer.checkAndNotify();
 *      ...
 *      observer.checkAndNotify();
 *      ...
 *      // finished
 *      observer.finish();
 * </pre>
 * Alternatively, register the oberver(s) with a {@link FileAlterationMonitor},
 * which creates a new thread, invoking the observer at the specified interval:
 * <pre>
 *      long interval = ...
 *      FileAlterationMonitor monitor = new FileAlterationMonitor(interval);
 *      monitor.addObserver(observer);
 *      monitor.start();
 *      ...
 *      monitor.stop();
 * </pre>
 *
 * <h2>File Filters</h2>
 * This implementation can monitor portions of the file system
 * by using {@link FileFilter}s to observe only the files and/or directories
 * that are of interest. This makes it more efficient and reduces the
 * noise from <i>unwanted</i> file system events.
 * <p>
 * <a href="http://commons.apache.org/io/">Commons IO</a> has a good range of
 * useful, ready made 
 * <a href="../filefilter/package-summary.html">File Filter</a>
 * implementations for this purpose.
 * <p>
 * For example, to only observe 1) visible directories and 2) files with a ".java" suffix
 * in a root directory called "src" you could set up a {@link FileAlterationObserver} in the following
 * way:
 * <pre>
 *      // Create a FileFilter
 *      IOFileFilter directories = FileFilterUtils.and(
 *                                      FileFilterUtils.directoryFileFilter(),
 *                                      HiddenFileFilter.VISIBLE);
 *      IOFileFilter files       = FileFilterUtils.and(
 *                                      FileFilterUtils.fileFileFilter(),
 *                                      FileFilterUtils.suffixFileFilter(".java"));
 *      IOFileFilter filter = FileFilterUtils.or(directories, files);
 *
 *      // Create the File system observer and register File Listeners
 *      FileAlterationObserver observer = new FileAlterationObserver(new File("src"), filter);
 *      observer.addListener(...);
 *      observer.addListener(...);
 * </pre>
 *
 * <h2>FileEntry</h2>
 * {@link FileEntry} represents the state of a file or directory, capturing
 * {@link File} attributes at a point in time. Custom implementations of
 * {@link FileEntry} can be used to capture additional properties that the
 * basic implementation does not support. The {@link FileEntry#refresh(File)}
 * method is used to determine if a file or directory has changed since the last
 * check and stores the current state of the {@link File}'s properties.
 *
 * @see FileAlterationListener
 * @see FileAlterationMonitor
 * @version $Id: FileAlterationObserver.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @since 2.0
 */
public class FileAlterationObserver implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.971 -0400", hash_original_field = "D89371632A594E9868CE5734F8BA23A5", hash_generated_field = "436A14A63A25ADE4D46FD57CDC506FA0")

    private final List<FileAlterationListener> listeners = new CopyOnWriteArrayList<FileAlterationListener>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.971 -0400", hash_original_field = "0830D15C0C1C91A3ACC9A4A564151BE2", hash_generated_field = "D4E9B8247C7F7B78EC9C2DA270FD3257")

    private  FileEntry rootEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.972 -0400", hash_original_field = "E261F1A7BA60970EC32C0101727C4798", hash_generated_field = "C458D0AE68C90865AFA5E634223F0231")

    private  FileFilter fileFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.972 -0400", hash_original_field = "890D92BD20451C7342E2D1F84D52B316", hash_generated_field = "FC15902F9B4E6313D228A429CAFF0464")

    private  Comparator<File> comparator;

    /**
     * Construct an observer for the specified directory.
     *
     * @param directoryName the name of the directory to observe
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.973 -0400", hash_original_method = "85142D2E9E15EB93CC97B3004876EC03", hash_generated_method = "57EBD7EEA30AC5594D23024CA2FA7FFF")
    
public FileAlterationObserver(String directoryName) {
        this(new File(directoryName));
    }

    /**
     * Construct an observer for the specified directory and file filter.
     *
     * @param directoryName the name of the directory to observe
     * @param fileFilter The file filter or null if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.973 -0400", hash_original_method = "F892F249392A40C312747AD59BC47A28", hash_generated_method = "6E34DDC4D732A9732C387B06C7143C16")
    
public FileAlterationObserver(String directoryName, FileFilter fileFilter) {
        this(new File(directoryName), fileFilter);
    }

    /**
     * Construct an observer for the specified directory, file filter and
     * file comparator.
     *
     * @param directoryName the name of the directory to observe
     * @param fileFilter The file filter or null if none
     * @param caseSensitivity  what case sensitivity to use comparing file names, null means system sensitive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.974 -0400", hash_original_method = "9E22246A2C5798ECAD21C20531550DBC", hash_generated_method = "E7734C2066D9709C95136379B8B43B15")
    
public FileAlterationObserver(String directoryName, FileFilter fileFilter, IOCase caseSensitivity) {
        this(new File(directoryName), fileFilter, caseSensitivity);
    }

    /**
     * Construct an observer for the specified directory.
     *
     * @param directory the directory to observe
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.975 -0400", hash_original_method = "DEF389DDBAFE974EA51118829F85145D", hash_generated_method = "AEA5D6CD76934A39A91E97F49B3ACAD2")
    
public FileAlterationObserver(File directory) {
        this(directory, (FileFilter)null);
    }

    /**
     * Construct an observer for the specified directory and file filter.
     *
     * @param directory the directory to observe
     * @param fileFilter The file filter or null if none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.975 -0400", hash_original_method = "02DF7858712779AF42E2C656508DDF5D", hash_generated_method = "F7B23F63F4E29E693FDDE5E24F5F24A7")
    
public FileAlterationObserver(File directory, FileFilter fileFilter) {
        this(directory, fileFilter, (IOCase)null);
    }

    /**
     * Construct an observer for the specified directory, file filter and
     * file comparator.
     *
     * @param directory the directory to observe
     * @param fileFilter The file filter or null if none
     * @param caseSensitivity  what case sensitivity to use comparing file names, null means system sensitive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.976 -0400", hash_original_method = "333A7F04CF3A5003336C33F84636E75C", hash_generated_method = "A7D097E660BDE50719F2B8F0F95F3690")
    
public FileAlterationObserver(File directory, FileFilter fileFilter, IOCase caseSensitivity) {
        this(new FileEntry(directory), fileFilter, caseSensitivity);
    }

    /**
     * Construct an observer for the specified directory, file filter and
     * file comparator.
     *
     * @param rootEntry the root directory to observe
     * @param fileFilter The file filter or null if none
     * @param caseSensitivity  what case sensitivity to use comparing file names, null means system sensitive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.977 -0400", hash_original_method = "70863C8791AB5339C3CC7588D2279663", hash_generated_method = "547BCE8CF58E174576D9C3FDC0ADF440")
    
protected FileAlterationObserver(FileEntry rootEntry, FileFilter fileFilter, IOCase caseSensitivity) {
        if (rootEntry == null) {
            throw new IllegalArgumentException("Root entry is missing");
        }
        if (rootEntry.getFile() == null) {
            throw new IllegalArgumentException("Root directory is missing");
        }
        this.rootEntry = rootEntry;
        this.fileFilter = fileFilter;
        if (caseSensitivity == null || caseSensitivity.equals(IOCase.SYSTEM)) {
            this.comparator = NameFileComparator.NAME_SYSTEM_COMPARATOR;
        } else if (caseSensitivity.equals(IOCase.INSENSITIVE)) {
            this.comparator = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
        } else {
            this.comparator = NameFileComparator.NAME_COMPARATOR;
        }
    }

    /**
     * Return the directory being observed.
     *
     * @return the directory being observed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.977 -0400", hash_original_method = "F73AEFE1AB5323ED9772F8703FAEA777", hash_generated_method = "CE31151AB46D0FB824EE6B711428C7EA")
    
public File getDirectory() {
        return rootEntry.getFile();
    }

    /**
     * Return the fileFilter.
     *
     * @return the fileFilter
     * @since 2.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.978 -0400", hash_original_method = "43FBDA01B5178A1D9F1E040192C2235F", hash_generated_method = "704469C2C768570AF59EF7EB1349D9C3")
    
public FileFilter getFileFilter() {
        return fileFilter;
    }

    /**
     * Add a file system listener.
     *
     * @param listener The file system listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.978 -0400", hash_original_method = "73C8C648F9EEF7928CF4A988A690F21C", hash_generated_method = "BA6EE605B0E118C9B3337E11B2D7A1D2")
    
public void addListener(final FileAlterationListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    /**
     * Remove a file system listener.
     *
     * @param listener The file system listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.979 -0400", hash_original_method = "337F97E355478FB0C577C0667066B06F", hash_generated_method = "AA30881DAF5C0D6E696D41EA88870FC2")
    
public void removeListener(final FileAlterationListener listener) {
        if (listener != null) {
            while (listeners.remove(listener)) {
            }
        }
    }

    /**
     * Returns the set of registered file system listeners.
     *
     * @return The file system listeners
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.979 -0400", hash_original_method = "741BFB949D17995C1AB7AD1C5062B240", hash_generated_method = "A5ED81D254F68BFA979C01CFFE0B2F8B")
    
public Iterable<FileAlterationListener> getListeners() {
        return listeners;
    }

    /**
     * Initialize the observer.
     *
     * @throws Exception if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.980 -0400", hash_original_method = "65389FBCC8B0D4443CC183F594B0559D", hash_generated_method = "87DA10DB5FCA1C7EADC80C693A617DDA")
    
public void initialize() throws Exception {
        rootEntry.refresh(rootEntry.getFile());
        File[] files = listFiles(rootEntry.getFile());
        FileEntry[] children = files.length > 0 ? new FileEntry[files.length] : FileEntry.EMPTY_ENTRIES;
        for (int i = 0; i < files.length; i++) {
            children[i] = createFileEntry(rootEntry, files[i]);
        }
        rootEntry.setChildren(children);
    }

    /**
     * Final processing.
     *
     * @throws Exception if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.980 -0400", hash_original_method = "19B94458987093A18E35F94275820DB1", hash_generated_method = "09175B3ECFF2547DB2C90323773BEC19")
    
public void destroy() throws Exception {
    }

    /**
     * Check whether the file and its chlidren have been created, modified or deleted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.981 -0400", hash_original_method = "28C4BDB6A5F83B4A2D726F32ED4863B2", hash_generated_method = "E32BFE1A45F547A449DD6FA2E38BCE1D")
    
public void checkAndNotify() {

        /* fire onStart() */
        for (FileAlterationListener listener : listeners) {
            listener.onStart(this);
        }

        /* fire directory/file events */
        File rootFile = rootEntry.getFile();
        if (rootFile.exists()) {
            checkAndNotify(rootEntry, rootEntry.getChildren(), listFiles(rootFile));
        } else if (rootEntry.isExists()) {
            checkAndNotify(rootEntry, rootEntry.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
        } else {
            // Didn't exist and still doesn't
        }

        /* fire onStop() */
        for (FileAlterationListener listener : listeners) {
            listener.onStop(this);
        }
    }

    /**
     * Compare two file lists for files which have been created, modified or deleted.
     *
     * @param parent The parent entry
     * @param previous The original list of files
     * @param files  The current list of files
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.982 -0400", hash_original_method = "14229043FF7E6DA90FB3DBFED2A622C0", hash_generated_method = "C79FA1001550868C2AE9DDDD308C961F")
    
private void checkAndNotify(FileEntry parent, FileEntry[] previous, File[] files) {
        int c = 0;
        FileEntry[] current = files.length > 0 ? new FileEntry[files.length] : FileEntry.EMPTY_ENTRIES;
        for (FileEntry entry : previous) {
            while (c < files.length && comparator.compare(entry.getFile(), files[c]) > 0) {
                current[c] = createFileEntry(parent, files[c]);
                doCreate(current[c]);
                c++;
            }
            if (c < files.length && comparator.compare(entry.getFile(), files[c]) == 0) {
                doMatch(entry, files[c]);
                checkAndNotify(entry, entry.getChildren(), listFiles(files[c]));
                current[c] = entry;
                c++;
            } else {
                checkAndNotify(entry, entry.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
                doDelete(entry);
            }
        }
        for (; c < files.length; c++) {
            current[c] = createFileEntry(parent, files[c]);
            doCreate(current[c]);
        }
        parent.setChildren(current);
    }

    /**
     * Create a new file entry for the specified file.
     *
     * @param parent The parent file entry
     * @param file The file to create an entry for
     * @return A new file entry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.983 -0400", hash_original_method = "9FB34A64AFD23F37DE49FF2A86984A48", hash_generated_method = "3D95C44EB6A9227F514528AC80794E40")
    
private FileEntry createFileEntry(FileEntry parent, File file) {
        FileEntry entry = parent.newChildInstance(file);
        entry.refresh(file);
        File[] files = listFiles(file);
        FileEntry[] children = files.length > 0 ? new FileEntry[files.length] : FileEntry.EMPTY_ENTRIES;
        for (int i = 0; i < files.length; i++) {
            children[i] = createFileEntry(entry, files[i]);
        }
        entry.setChildren(children);
        return entry;
    }

    /**
     * Fire directory/file created events to the registered listeners.
     *
     * @param entry The file entry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.983 -0400", hash_original_method = "C0CBB028B302FA13274EDDF227B1F519", hash_generated_method = "35C9FC921E493168D2F7BA1612BAA8DC")
    
private void doCreate(FileEntry entry) {
        for (FileAlterationListener listener : listeners) {
            if (entry.isDirectory()) {
                listener.onDirectoryCreate(entry.getFile());
            } else {
                listener.onFileCreate(entry.getFile());
            }
        }
        FileEntry[] children = entry.getChildren();
        for (FileEntry aChildren : children) {
            doCreate(aChildren);
        }
    }

    /**
     * Fire directory/file change events to the registered listeners.
     *
     * @param entry The previous file system entry
     * @param file The current file
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.984 -0400", hash_original_method = "D3512EAF0EBFD0769AB6296F9B118176", hash_generated_method = "D98A5D385C30A54F80AAD2ECE392572E")
    
private void doMatch(FileEntry entry, File file) {
        if (entry.refresh(file)) {
            for (FileAlterationListener listener : listeners) {
                if (entry.isDirectory()) {
                    listener.onDirectoryChange(file);
                } else {
                    listener.onFileChange(file);
                }
            }
        }
    }

    /**
     * Fire directory/file delete events to the registered listeners.
     *
     * @param entry The file entry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.985 -0400", hash_original_method = "DDAF62E14AD15FA9537A3140BB7EB191", hash_generated_method = "7D38428E89D3D1CE85DCE6C9EC3906E3")
    
private void doDelete(FileEntry entry) {
        for (FileAlterationListener listener : listeners) {
            if (entry.isDirectory()) {
                listener.onDirectoryDelete(entry.getFile());
            } else {
                listener.onFileDelete(entry.getFile());
            }
        }
    }

    /**
     * List the contents of a directory
     *
     * @param file The file to list the contents of
     * @return the directory contents or a zero length array if
     * the empty or the file is not a directory
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.985 -0400", hash_original_method = "0F27C92B37DFB10D975FFB8810CF21BD", hash_generated_method = "633FD3877549CAE012C10A750FE665EF")
    
private File[] listFiles(File file) {
        File[] children = null;
        if (file.isDirectory()) {
            children = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        }
        if (children == null) {
            children = FileUtils.EMPTY_FILE_ARRAY;
        }
        if (comparator != null && children.length > 1) {
            Arrays.sort(children, comparator);
        }
        return children;
    }

    /**
     * Provide a String representation of this observer.
     *
     * @return a String representation of this observer
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.986 -0400", hash_original_method = "B829940FDDA83108C12ADCFE12967B77", hash_generated_method = "D5922C7B6EFBC5FF2512DF05DCDEF26B")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append("[file='");
        builder.append(getDirectory().getPath());
        builder.append('\'');
        if (fileFilter != null) {
            builder.append(", ");
            builder.append(fileFilter.toString());
        }
        builder.append(", listeners=");
        builder.append(listeners.size());
        builder.append("]");
        return builder.toString();
    }

}
