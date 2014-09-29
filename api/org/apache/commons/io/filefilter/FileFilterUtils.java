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
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOCase;

/**
 * Useful utilities for working with file filters. It provides access to all
 * file filter implementations in this package so you don't have to import
 * every class you use.
 * 
 * @since 1.0
 * @version $Id: FileFilterUtils.java 1307459 2012-03-30 15:11:44Z ggregory $
 */
public class FileFilterUtils {

    //-----------------------------------------------------------------------

    /**
     * <p>
     * Applies an {@link IOFileFilter} to the provided {@link File} 
     * objects. The resulting array is a subset of the original file list that 
     * matches the provided filter.
     * </p>
     * 
     * <p>
     * The {@link Set} returned by this method is not guaranteed to be thread safe.
     * </p>
     * 
     * <pre>
     * Set&lt;File&gt; allFiles = ...
     * Set&lt;File&gt; javaFiles = FileFilterUtils.filterSet(allFiles,
     *     FileFilterUtils.suffixFileFilter(".java"));
     * </pre>
     * @param filter the filter to apply to the set of files.
     * @param files the array of files to apply the filter to.
     * 
     * @return a subset of <code>files</code> that is accepted by the 
     *         file filter.
     * @throws IllegalArgumentException if the filter is {@code null} 
     *         or <code>files</code> contains a {@code null} value. 
     * 
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.864 -0400", hash_original_method = "A8E8FF499B26F30A7AD9BD8A02ED630C", hash_generated_method = "A6C7A9F31EF5371018CE196D9A9EE1BF")
    
public static File[] filter(IOFileFilter filter, File... files) {
        if (filter == null) {
            throw new IllegalArgumentException("file filter is null");
        }
        if (files == null) {
            return new File[0];
        }
        List<File> acceptedFiles = new ArrayList<File>();
        for (File file : files) {
            if (file == null) {
                throw new IllegalArgumentException("file array contains null");
            }
            if (filter.accept(file)) {
                acceptedFiles.add(file);
            }
        }
        return acceptedFiles.toArray(new File[acceptedFiles.size()]);
    }

    /**
     * <p>
     * Applies an {@link IOFileFilter} to the provided {@link File} 
     * objects. The resulting array is a subset of the original file list that 
     * matches the provided filter.
     * </p>
     * 
     * <p>
     * The {@link Set} returned by this method is not guaranteed to be thread safe.
     * </p>
     * 
     * <pre>
     * Set&lt;File&gt; allFiles = ...
     * Set&lt;File&gt; javaFiles = FileFilterUtils.filterSet(allFiles,
     *     FileFilterUtils.suffixFileFilter(".java"));
     * </pre>
     * @param filter the filter to apply to the set of files.
     * @param files the array of files to apply the filter to.
     * 
     * @return a subset of <code>files</code> that is accepted by the 
     *         file filter.
     * @throws IllegalArgumentException if the filter is {@code null} 
     *         or <code>files</code> contains a {@code null} value. 
     * 
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.865 -0400", hash_original_method = "8582EE7341DF9449A238DD2AE8C481BF", hash_generated_method = "75A4E540880D451D1C5884189A9D7E22")
    
public static File[] filter(IOFileFilter filter, Iterable<File> files) {
        List<File> acceptedFiles = filterList(filter, files);
        return acceptedFiles.toArray(new File[acceptedFiles.size()]);
    }

    /**
     * <p>
     * Applies an {@link IOFileFilter} to the provided {@link File} 
     * objects. The resulting list is a subset of the original files that 
     * matches the provided filter.
     * </p>
     * 
     * <p>
     * The {@link List} returned by this method is not guaranteed to be thread safe.
     * </p>
     * 
     * <pre>
     * List&lt;File&gt; filesAndDirectories = ...
     * List&lt;File&gt; directories = FileFilterUtils.filterList(filesAndDirectories,
     *     FileFilterUtils.directoryFileFilter());
     * </pre>
     * @param filter the filter to apply to each files in the list.
     * @param files the collection of files to apply the filter to.
     * 
     * @return a subset of <code>files</code> that is accepted by the 
     *         file filter.
     * @throws IllegalArgumentException if the filter is {@code null} 
     *         or <code>files</code> contains a {@code null} value. 
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.865 -0400", hash_original_method = "299D153268C4B9CA717774AFA30078F3", hash_generated_method = "BDFD905E69FBAD3C0856625421DE690B")
    
public static List<File> filterList(IOFileFilter filter, Iterable<File> files) {
        return filter(filter, files, new ArrayList<File>());
    }

    /**
     * <p>
     * Applies an {@link IOFileFilter} to the provided {@link File} 
     * objects. The resulting list is a subset of the original files that 
     * matches the provided filter.
     * </p>
     * 
     * <p>
     * The {@link List} returned by this method is not guaranteed to be thread safe.
     * </p>
     * 
     * <pre>
     * List&lt;File&gt; filesAndDirectories = ...
     * List&lt;File&gt; directories = FileFilterUtils.filterList(filesAndDirectories,
     *     FileFilterUtils.directoryFileFilter());
     * </pre>
     * @param filter the filter to apply to each files in the list.
     * @param files the collection of files to apply the filter to.
     * 
     * @return a subset of <code>files</code> that is accepted by the 
     *         file filter.
     * @throws IllegalArgumentException if the filter is {@code null} 
     *         or <code>files</code> contains a {@code null} value. 
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.866 -0400", hash_original_method = "A82F449242BF2022D0871D0F4E2983CD", hash_generated_method = "61F93F0925555631E7444D54EEEEB298")
    
public static List<File> filterList(IOFileFilter filter, File... files) {
        File[] acceptedFiles = filter(filter, files);
        return Arrays.asList(acceptedFiles);
    }

    /**
     * <p>
     * Applies an {@link IOFileFilter} to the provided {@link File} 
     * objects. The resulting set is a subset of the original file list that 
     * matches the provided filter.
     * </p>
     * 
     * <p>
     * The {@link Set} returned by this method is not guaranteed to be thread safe.
     * </p>
     * 
     * <pre>
     * Set&lt;File&gt; allFiles = ...
     * Set&lt;File&gt; javaFiles = FileFilterUtils.filterSet(allFiles,
     *     FileFilterUtils.suffixFileFilter(".java"));
     * </pre>
     * @param filter the filter to apply to the set of files.
     * @param files the collection of files to apply the filter to.
     * 
     * @return a subset of <code>files</code> that is accepted by the 
     *         file filter.
     * @throws IllegalArgumentException if the filter is {@code null} 
     *         or <code>files</code> contains a {@code null} value. 
     * 
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.867 -0400", hash_original_method = "F56FD5380012D34D68CA53690C18D7FD", hash_generated_method = "A6142FA12E31E3B0FB331E2273C2C0FD")
    
public static Set<File> filterSet(IOFileFilter filter, File... files) {
        File[] acceptedFiles = filter(filter, files);
        return new HashSet<File>(Arrays.asList(acceptedFiles));
    }

    /**
     * <p>
     * Applies an {@link IOFileFilter} to the provided {@link File} 
     * objects. The resulting set is a subset of the original file list that 
     * matches the provided filter.
     * </p>
     * 
     * <p>
     * The {@link Set} returned by this method is not guaranteed to be thread safe.
     * </p>
     * 
     * <pre>
     * Set&lt;File&gt; allFiles = ...
     * Set&lt;File&gt; javaFiles = FileFilterUtils.filterSet(allFiles,
     *     FileFilterUtils.suffixFileFilter(".java"));
     * </pre>
     * @param filter the filter to apply to the set of files.
     * @param files the collection of files to apply the filter to.
     * 
     * @return a subset of <code>files</code> that is accepted by the 
     *         file filter.
     * @throws IllegalArgumentException if the filter is {@code null} 
     *         or <code>files</code> contains a {@code null} value. 
     * 
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.867 -0400", hash_original_method = "3D61D5D19861CA2698D59A4E24B12C4A", hash_generated_method = "C0A68568C23337E52C9F0CF103954F9B")
    
public static Set<File> filterSet(IOFileFilter filter, Iterable<File> files) {
        return filter(filter, files, new HashSet<File>());
    }

    /**
     * <p>
     * Applies an {@link IOFileFilter} to the provided {@link File} 
     * objects and appends the accepted files to the other supplied collection. 
     * </p>
     * 
     * <pre>
     * List&lt;File&gt; files = ...
     * List&lt;File&gt; directories = FileFilterUtils.filterList(files,
     *     FileFilterUtils.sizeFileFilter(FileUtils.FIFTY_MB), 
     *         new ArrayList&lt;File&gt;());
     * </pre>
     * @param filter the filter to apply to the collection of files.
     * @param files the collection of files to apply the filter to.
     * @param acceptedFiles the list of files to add accepted files to.
     * 
     * @param <T> the type of the file collection.
     * @return a subset of <code>files</code> that is accepted by the 
     *         file filter.
     * @throws IllegalArgumentException if the filter is {@code null} 
     *         or <code>files</code> contains a {@code null} value. 
     */
    @DSBan(DSCat.PRIVATE_METHOD)
    private static <T extends Collection<File>> T filter(IOFileFilter filter,
            Iterable<File> files, T acceptedFiles) {
        if (filter == null) {
            throw new IllegalArgumentException("file filter is null");
        }
        if (files != null) {
            for (File file : files) {
                if (file == null) {
                    throw new IllegalArgumentException("file collection contains null");
                }
                if (filter.accept(file)) {
                    acceptedFiles.add(file);
                }
            }
        }
        return acceptedFiles;
    }

    /**
     * Returns a filter that returns true if the filename starts with the specified text.
     * 
     * @param prefix  the filename prefix
     * @return a prefix checking filter
     * @see PrefixFileFilter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.868 -0400", hash_original_method = "516D11BB827757AD8F5587BDBEAF4E8D", hash_generated_method = "58B45512843C4AF42CDD4A9D2C256B17")
    
public static IOFileFilter prefixFileFilter(String prefix) {
        return new PrefixFileFilter(prefix);
    }

    /**
     * Returns a filter that returns true if the filename starts with the specified text.
     * 
     * @param prefix  the filename prefix
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @return a prefix checking filter
     * @see PrefixFileFilter
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.869 -0400", hash_original_method = "48B0AC99E6E43892210E9D31CA5A86DE", hash_generated_method = "EE1A34A3FF19C1D2A20777E27A943D8A")
    
public static IOFileFilter prefixFileFilter(String prefix, IOCase caseSensitivity) {
        return new PrefixFileFilter(prefix, caseSensitivity);
    }

    /**
     * Returns a filter that returns true if the filename ends with the specified text.
     * 
     * @param suffix  the filename suffix
     * @return a suffix checking filter
     * @see SuffixFileFilter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.869 -0400", hash_original_method = "3A8CB74DE4DC3CEA9C672A9C00607FF1", hash_generated_method = "7AD30FF30CDD6B8CEAD94B576867F0ED")
    
public static IOFileFilter suffixFileFilter(String suffix) {
        return new SuffixFileFilter(suffix);
    }

    /**
     * Returns a filter that returns true if the filename ends with the specified text.
     * 
     * @param suffix  the filename suffix
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @return a suffix checking filter
     * @see SuffixFileFilter
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.870 -0400", hash_original_method = "F7590EA8797F8DD95DFA23DD2455DA0E", hash_generated_method = "73A45AF74478191B794C3EC4838AF81C")
    
public static IOFileFilter suffixFileFilter(String suffix, IOCase caseSensitivity) {
        return new SuffixFileFilter(suffix, caseSensitivity);
    }

    /**
     * Returns a filter that returns true if the filename matches the specified text.
     * 
     * @param name  the filename
     * @return a name checking filter
     * @see NameFileFilter
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.870 -0400", hash_original_method = "4A5BBE95AA88C5704ABBACA3A9164E73", hash_generated_method = "A1433B2D7C0B436DA90DF75973B3A7F9")
    
public static IOFileFilter nameFileFilter(String name) {
        return new NameFileFilter(name);
    }

    /**
     * Returns a filter that returns true if the filename matches the specified text.
     * 
     * @param name  the filename
     * @param caseSensitivity  how to handle case sensitivity, null means case-sensitive
     * @return a name checking filter
     * @see NameFileFilter
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.871 -0400", hash_original_method = "C9DEC901D489056B6C33764CD8784603", hash_generated_method = "6CA4A88AF085C82DDE910B54F344F663")
    
public static IOFileFilter nameFileFilter(String name, IOCase caseSensitivity) {
        return new NameFileFilter(name, caseSensitivity);
    }

    /**
     * Returns a filter that checks if the file is a directory.
     * 
     * @return file filter that accepts only directories and not files
     * @see DirectoryFileFilter#DIRECTORY
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.871 -0400", hash_original_method = "EB113DC613E865F1731A88848A368345", hash_generated_method = "86FD479F44CA5E7D8023B9B1142C4511")
    
public static IOFileFilter directoryFileFilter() {
        return DirectoryFileFilter.DIRECTORY;
    }

    /**
     * Returns a filter that checks if the file is a file (and not a directory).
     * 
     * @return file filter that accepts only files and not directories
     * @see FileFileFilter#FILE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.872 -0400", hash_original_method = "088DF8F7AE1AF0A6FC6325953692637E", hash_generated_method = "6C3FECB1746D0A1C9DB670D415174D67")

    @DSSafe(DSCat.SAFE_LIST)  
public static IOFileFilter fileFileFilter() {
        return FileFileFilter.FILE;
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a filter that ANDs the two specified filters.
     * 
     * @param filter1  the first filter
     * @param filter2  the second filter
     * @return a filter that ANDs the two specified filters
     * @see #and(IOFileFilter...)
     * @see AndFileFilter
     * @deprecated use {@link #and(IOFileFilter...)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.872 -0400", hash_original_method = "C366AABFB464B05ADB50C836A40C4BAE", hash_generated_method = "5A0462484410C7D0FF9FB0F000ABDD57")

    @DSSafe(DSCat.SAFE_LIST)  
@Deprecated
    public static IOFileFilter andFileFilter(IOFileFilter filter1, IOFileFilter filter2) {
        return new AndFileFilter(filter1, filter2);
    }

    /**
     * Returns a filter that ORs the two specified filters.
     * 
     * @param filter1  the first filter
     * @param filter2  the second filter
     * @return a filter that ORs the two specified filters
     * @see #or(IOFileFilter...)
     * @see OrFileFilter
     * @deprecated use {@link #or(IOFileFilter...)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.873 -0400", hash_original_method = "9315C2581CF2931FD314CE0DD09752F7", hash_generated_method = "14B4431922B0597712A05D186921B79D")

    @DSSafe(DSCat.SAFE_LIST)  
@Deprecated
    public static IOFileFilter orFileFilter(IOFileFilter filter1, IOFileFilter filter2) {
        return new OrFileFilter(filter1, filter2);
    }

    /**
     * Returns a filter that ANDs the specified filters.
     * 
     * @param filters the IOFileFilters that will be ANDed together.
     * @return a filter that ANDs the specified filters
     * 
     * @throws IllegalArgumentException if the filters are null or contain a 
     *         null value.
     * @see AndFileFilter
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.874 -0400", hash_original_method = "0A51AA436E84FC1839627DBD91C415A7", hash_generated_method = "A0CB6D6463B2DF102D642EA511770E72")
    
public static IOFileFilter and(IOFileFilter... filters) {
        return new AndFileFilter(toList(filters));
    }

    /**
     * Returns a filter that ORs the specified filters.
     * 
     * @param filters the IOFileFilters that will be ORed together.
     * @return a filter that ORs the specified filters
     * 
     * @throws IllegalArgumentException if the filters are null or contain a 
     *         null value.
     * @see OrFileFilter
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.874 -0400", hash_original_method = "B64EF0C9C53C2B8E1037A43848D2E008", hash_generated_method = "DBCE7A953E02A2949C6911887A619ADA")
    
public static IOFileFilter or(IOFileFilter... filters) {
        return new OrFileFilter(toList(filters));
    }

    /**
     * Create a List of file filters.
     *
     * @param filters The file filters
     * @return The list of file filters
     * @throws IllegalArgumentException if the filters are null or contain a 
     *         null value.
     * @since 2.0
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.875 -0400", hash_original_method = "B92A5D5411F17E788E19D12E602D51DB", hash_generated_method = "8F0275C0DB8FB8DDB36E0D0B06918D34")
    
public static List<IOFileFilter> toList(IOFileFilter... filters) {
        if (filters == null) {
            throw new IllegalArgumentException("The filters must not be null");
        }
        List<IOFileFilter> list = new ArrayList<IOFileFilter>(filters.length);
        for (int i = 0; i < filters.length; i++) {
            if (filters[i] == null) {
                throw new IllegalArgumentException("The filter[" + i + "] is null");
            }
            list.add(filters[i]);
        }
        return list;
    }

    /**
     * Returns a filter that NOTs the specified filter.
     * 
     * @param filter  the filter to invert
     * @return a filter that NOTs the specified filter
     * @see NotFileFilter
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.875 -0400", hash_original_method = "842F06004C71964D73C76D585C53C035", hash_generated_method = "2269A8644752FBCC6369CC307F232B1E")
    
public static IOFileFilter notFileFilter(IOFileFilter filter) {
        return new NotFileFilter(filter);
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a filter that always returns true.
     * 
     * @return a true filter
     * @see TrueFileFilter#TRUE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.876 -0400", hash_original_method = "BFDD0D81442D584539DB6A0045123B22", hash_generated_method = "5AD3DAC277D6EF26CECBD27F6EF627C5")
    
public static IOFileFilter trueFileFilter() {
        return TrueFileFilter.TRUE;
    }

    /**
     * Returns a filter that always returns false.
     * 
     * @return a false filter
     * @see FalseFileFilter#FALSE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.876 -0400", hash_original_method = "F5C83CF250DCCF28D9ECDE5C9BEDB4A9", hash_generated_method = "C3F6099E3ABAC199B76C8718A61CACE3")
    
public static IOFileFilter falseFileFilter() {
        return FalseFileFilter.FALSE;
    }
    
    //-----------------------------------------------------------------------
    /**
     * Returns an <code>IOFileFilter</code> that wraps the
     * <code>FileFilter</code> instance.
     * 
     * @param filter  the filter to be wrapped
     * @return a new filter that implements IOFileFilter
     * @see DelegateFileFilter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.877 -0400", hash_original_method = "2EB2F7E1142D1CB5BA89628A74895621", hash_generated_method = "97B936CA93A748D93235A5B1430D80DF")
    
public static IOFileFilter asFileFilter(FileFilter filter) {
        return new DelegateFileFilter(filter);
    }

    /**
     * Returns an <code>IOFileFilter</code> that wraps the
     * <code>FilenameFilter</code> instance.
     * 
     * @param filter  the filter to be wrapped
     * @return a new filter that implements IOFileFilter
     * @see DelegateFileFilter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.877 -0400", hash_original_method = "C4ABC201E55DEBFDD8CAB3CEFF58A52D", hash_generated_method = "F5B892B890450DB62CBA403E87AD0284")
    
public static IOFileFilter asFileFilter(FilenameFilter filter) {
        return new DelegateFileFilter(filter);
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a filter that returns true if the file was last modified after
     * the specified cutoff time.
     *
     * @param cutoff  the time threshold
     * @return an appropriately configured age file filter
     * @see AgeFileFilter
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.878 -0400", hash_original_method = "028254B5788FE35C5559294819B2BDF5", hash_generated_method = "AA47099D6C20923CDC4857478D78175E")
    
public static IOFileFilter ageFileFilter(long cutoff) {
        return new AgeFileFilter(cutoff);
    }

    /**
     * Returns a filter that filters files based on a cutoff time.
     *
     * @param cutoff  the time threshold
     * @param acceptOlder  if true, older files get accepted, if false, newer
     * @return an appropriately configured age file filter
     * @see AgeFileFilter
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.878 -0400", hash_original_method = "97926AE4C4ACB895751E90265D82F8AC", hash_generated_method = "DC790AC300F10892844B48C5365EFCFD")
    
public static IOFileFilter ageFileFilter(long cutoff, boolean acceptOlder) {
        return new AgeFileFilter(cutoff, acceptOlder);
    }

    /**
     * Returns a filter that returns true if the file was last modified after
     * the specified cutoff date.
     *
     * @param cutoffDate  the time threshold
     * @return an appropriately configured age file filter
     * @see AgeFileFilter
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.879 -0400", hash_original_method = "51A78070894F00FFC1985168C56115B2", hash_generated_method = "F0E6CAAB5A99A7246EB3AD55400150E5")
    
public static IOFileFilter ageFileFilter(Date cutoffDate) {
        return new AgeFileFilter(cutoffDate);
    }

    /**
     * Returns a filter that filters files based on a cutoff date.
     *
     * @param cutoffDate  the time threshold
     * @param acceptOlder  if true, older files get accepted, if false, newer
     * @return an appropriately configured age file filter
     * @see AgeFileFilter
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.879 -0400", hash_original_method = "47354C26538F258C78E4A849697295D5", hash_generated_method = "E05071016999648EF49EC2C942E47BB4")
    
public static IOFileFilter ageFileFilter(Date cutoffDate, boolean acceptOlder) {
        return new AgeFileFilter(cutoffDate, acceptOlder);
    }

    /**
     * Returns a filter that returns true if the file was last modified after
     * the specified reference file.
     *
     * @param cutoffReference  the file whose last modification
     *        time is usesd as the threshold age of the files
     * @return an appropriately configured age file filter
     * @see AgeFileFilter
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.880 -0400", hash_original_method = "797C9DAFF8FEBFCA67D357CAB83D21E2", hash_generated_method = "8E0E2496963D4E8D95078A01B73CF783")
    
public static IOFileFilter ageFileFilter(File cutoffReference) {
        return new AgeFileFilter(cutoffReference);
    }

    /**
     * Returns a filter that filters files based on a cutoff reference file.
     *
     * @param cutoffReference  the file whose last modification
     *        time is usesd as the threshold age of the files
     * @param acceptOlder  if true, older files get accepted, if false, newer
     * @return an appropriately configured age file filter
     * @see AgeFileFilter
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.881 -0400", hash_original_method = "994C69F88466BB47F9A8EB3CD8F01375", hash_generated_method = "B7ED5D9BD28F162D5BC9560B072F418F")
    
public static IOFileFilter ageFileFilter(File cutoffReference, boolean acceptOlder) {
        return new AgeFileFilter(cutoffReference, acceptOlder);
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a filter that returns true if the file is bigger than a certain size.
     *
     * @param threshold  the file size threshold
     * @return an appropriately configured SizeFileFilter
     * @see SizeFileFilter
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.881 -0400", hash_original_method = "ED7F8CC35E60516DF5221BEEDE06BA88", hash_generated_method = "DAAF26093CE09E2EDB6820D67577A1F8")
    
public static IOFileFilter sizeFileFilter(long threshold) {
        return new SizeFileFilter(threshold);
    }

    /**
     * Returns a filter that filters based on file size.
     *
     * @param threshold  the file size threshold
     * @param acceptLarger  if true, larger files get accepted, if false, smaller
     * @return an appropriately configured SizeFileFilter
     * @see SizeFileFilter
     * @since 1.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.882 -0400", hash_original_method = "FD5A39B36982792EEF1A803F6631F17B", hash_generated_method = "822B63CAD49D3B1E46C60C099810924B")
    
public static IOFileFilter sizeFileFilter(long threshold, boolean acceptLarger) {
        return new SizeFileFilter(threshold, acceptLarger);
    }

    /**
     * Returns a filter that accepts files whose size is &gt;= minimum size
     * and &lt;= maximum size.
     *
     * @param minSizeInclusive the minimum file size (inclusive)
     * @param maxSizeInclusive the maximum file size (inclusive)
     * @return an appropriately configured IOFileFilter
     * @see SizeFileFilter
     * @since 1.3
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.882 -0400", hash_original_method = "FF8F0C2386839E04CA9A4F5B5DAFF53D", hash_generated_method = "E650BB0D76E023F97A3B86724FA751F7")
    
public static IOFileFilter sizeRangeFileFilter(long minSizeInclusive, long maxSizeInclusive ) {
        IOFileFilter minimumFilter = new SizeFileFilter(minSizeInclusive, true);
        IOFileFilter maximumFilter = new SizeFileFilter(maxSizeInclusive + 1L, false);
        return new AndFileFilter(minimumFilter, maximumFilter);
    }
    
    /**
     * Returns a filter that accepts files that begin with the provided magic
     * number.
     * 
     * @param magicNumber the magic number (byte sequence) to match at the 
     *        beginning of each file.
     * 
     * @return an IOFileFilter that accepts files beginning with the provided
     *         magic number.
     *         
     * @throws IllegalArgumentException if <code>magicNumber</code> is 
     *         {@code null} or the empty String.
     * @see MagicNumberFileFilter
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.883 -0400", hash_original_method = "A2E72EB00086C962A248F7B09D4CAB08", hash_generated_method = "E603A35B874788089D482F7930493722")
    
public static IOFileFilter magicNumberFileFilter(String magicNumber) {
        return new MagicNumberFileFilter(magicNumber);
    }
    
    /**
     * Returns a filter that accepts files that contains the provided magic
     * number at a specified offset within the file.
     * 
     * @param magicNumber the magic number (byte sequence) to match at the 
     *        provided offset in each file.
     * @param offset the offset within the files to look for the magic number.
     * 
     * @return an IOFileFilter that accepts files containing the magic number
     *         at the specified offset.
     *         
     * @throws IllegalArgumentException if <code>magicNumber</code> is 
     *         {@code null} or the empty String, or if offset is a 
     *         negative number.
     * @see MagicNumberFileFilter
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.883 -0400", hash_original_method = "3BD8DE3008375A571DA60BEB46AD0165", hash_generated_method = "651258AEEC35B19DC42DDC2BB9A3E97E")
    
public static IOFileFilter magicNumberFileFilter(String magicNumber, long offset) {
        return new MagicNumberFileFilter(magicNumber, offset);
    }
    
    /**
     * Returns a filter that accepts files that begin with the provided magic
     * number.
     * 
     * @param magicNumber the magic number (byte sequence) to match at the 
     *        beginning of each file.
     * 
     * @return an IOFileFilter that accepts files beginning with the provided
     *         magic number.
     *         
     * @throws IllegalArgumentException if <code>magicNumber</code> is 
     *         {@code null} or is of length zero.
     * @see MagicNumberFileFilter
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.884 -0400", hash_original_method = "EDA7EDCED2EBE3E83E19BD32EAD8E742", hash_generated_method = "0DA517C7BC55E33B6AE94223A6AF362B")
    
public static IOFileFilter magicNumberFileFilter(byte[] magicNumber) {
        return new MagicNumberFileFilter(magicNumber);
    }
    
    /**
     * Returns a filter that accepts files that contains the provided magic
     * number at a specified offset within the file.
     * 
     * @param magicNumber the magic number (byte sequence) to match at the 
     *        provided offset in each file.
     * @param offset the offset within the files to look for the magic number.
     * 
     * @return an IOFileFilter that accepts files containing the magic number
     *         at the specified offset.
     *         
     * @throws IllegalArgumentException if <code>magicNumber</code> is 
     *         {@code null}, or contains no bytes, or <code>offset</code> 
     *         is a negative number.
     * @see MagicNumberFileFilter
     * @since 2.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.885 -0400", hash_original_method = "E8BF2980C2AE9F97BC40AD9BD64230F5", hash_generated_method = "332D7CF4AFFBB9DC362C5899EF1D09F7")
    
public static IOFileFilter magicNumberFileFilter(byte[] magicNumber, long offset) {
        return new MagicNumberFileFilter(magicNumber, offset);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.885 -0400", hash_original_field = "67053E71FB317E4ECA54D452ACDBAB50", hash_generated_field = "6CF58F9AC7022FD6D0745E89B73A8AF7")

    /* Constructed on demand and then cached */
    private static final IOFileFilter cvsFilter = notFileFilter(
            and(directoryFileFilter(), nameFileFilter("CVS")));
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.886 -0400", hash_original_field = "89AA977C3DA2B9EF72D13B777AAC045E", hash_generated_field = "A15BB13988DB098518B43E8CDD23955C")

    private static final IOFileFilter svnFilter = notFileFilter(
            and(directoryFileFilter(), nameFileFilter(".svn")));

    /**
     * Decorates a filter to make it ignore CVS directories.
     * Passing in {@code null} will return a filter that accepts everything
     * except CVS directories.
     * 
     * @param filter  the filter to decorate, null means an unrestricted filter
     * @return the decorated filter, never null
     * @since 1.1 (method existed but had bug in 1.0)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.886 -0400", hash_original_method = "F93F81867A282DBEA38F24B5E266C01A", hash_generated_method = "F18B40531C676A01D59202F4C6825756")
    
public static IOFileFilter makeCVSAware(IOFileFilter filter) {
        if (filter == null) {
            return cvsFilter;
        } else {
            return and(filter, cvsFilter);
        }
    }

    /**
     * Decorates a filter to make it ignore SVN directories.
     * Passing in {@code null} will return a filter that accepts everything
     * except SVN directories.
     * 
     * @param filter  the filter to decorate, null means an unrestricted filter
     * @return the decorated filter, never null
     * @since 1.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.887 -0400", hash_original_method = "9E5920EB9B875231E855103B93F23F5C", hash_generated_method = "D9E58287C623829705F4AFA4B527874A")
    
public static IOFileFilter makeSVNAware(IOFileFilter filter) {
        if (filter == null) {
            return svnFilter;
        } else {
            return and(filter, svnFilter);
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Decorates a filter so that it only applies to directories and not to files.
     * 
     * @param filter  the filter to decorate, null means an unrestricted filter
     * @return the decorated filter, never null
     * @see DirectoryFileFilter#DIRECTORY
     * @since 1.3
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.888 -0400", hash_original_method = "C583E738065B40E214C664AD56CC21CE", hash_generated_method = "5F3B8072603ACB325A709E1A3F57BE59")
    
public static IOFileFilter makeDirectoryOnly(IOFileFilter filter) {
        if (filter == null) {
            return DirectoryFileFilter.DIRECTORY;
        }
        return new AndFileFilter(DirectoryFileFilter.DIRECTORY, filter);
    }

    /**
     * Decorates a filter so that it only applies to files and not to directories.
     * 
     * @param filter  the filter to decorate, null means an unrestricted filter
     * @return the decorated filter, never null
     * @see FileFileFilter#FILE
     * @since 1.3
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.888 -0400", hash_original_method = "4F3E4875B5D995F245642A033A3E9859", hash_generated_method = "34877BF524E2DB7C2C78FF9F429235F5")
    
public static IOFileFilter makeFileOnly(IOFileFilter filter) {
        if (filter == null) {
            return FileFileFilter.FILE;
        }
        return new AndFileFilter(FileFileFilter.FILE, filter);
    }
    
    /**
     * FileFilterUtils is not normally instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.863 -0400", hash_original_method = "258D2A85E3ECF820EDC9682F6EE3C0F9", hash_generated_method = "881EC7E1EDF187DA88DFBDACA02CE183")
    
public FileFilterUtils() {
    }

}
