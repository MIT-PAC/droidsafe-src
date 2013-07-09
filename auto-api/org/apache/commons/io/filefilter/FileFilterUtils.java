package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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

public class FileFilterUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.793 -0400", hash_original_method = "258D2A85E3ECF820EDC9682F6EE3C0F9", hash_generated_method = "CA9F53CC4FA02CAE301E64D9C1DC0F50")
    public  FileFilterUtils() {
        
    }

    
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

    
    @DSModeled(DSC.SAFE)
    public static File[] filter(IOFileFilter filter, Iterable<File> files) {
        List<File> acceptedFiles = filterList(filter, files);
        return acceptedFiles.toArray(new File[acceptedFiles.size()]);
    }

    
    @DSModeled(DSC.SAFE)
    public static List<File> filterList(IOFileFilter filter, Iterable<File> files) {
        return filter(filter, files, new ArrayList<File>());
    }

    
    public static List<File> filterList(IOFileFilter filter, File... files) {
        File[] acceptedFiles = filter(filter, files);
        return Arrays.asList(acceptedFiles);
    }

    
    public static Set<File> filterSet(IOFileFilter filter, File... files) {
        File[] acceptedFiles = filter(filter, files);
        return new HashSet<File>(Arrays.asList(acceptedFiles));
    }

    
    @DSModeled(DSC.SAFE)
    public static Set<File> filterSet(IOFileFilter filter, Iterable<File> files) {
        return filter(filter, files, new HashSet<File>());
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter prefixFileFilter(String prefix) {
        return new PrefixFileFilter(prefix);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter prefixFileFilter(String prefix, IOCase caseSensitivity) {
        return new PrefixFileFilter(prefix, caseSensitivity);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter suffixFileFilter(String suffix) {
        return new SuffixFileFilter(suffix);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter suffixFileFilter(String suffix, IOCase caseSensitivity) {
        return new SuffixFileFilter(suffix, caseSensitivity);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter nameFileFilter(String name) {
        return new NameFileFilter(name);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter nameFileFilter(String name, IOCase caseSensitivity) {
        return new NameFileFilter(name, caseSensitivity);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter directoryFileFilter() {
        return DirectoryFileFilter.DIRECTORY;
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter fileFileFilter() {
        return FileFileFilter.FILE;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static IOFileFilter andFileFilter(IOFileFilter filter1, IOFileFilter filter2) {
        return new AndFileFilter(filter1, filter2);
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static IOFileFilter orFileFilter(IOFileFilter filter1, IOFileFilter filter2) {
        return new OrFileFilter(filter1, filter2);
    }

    
    public static IOFileFilter and(IOFileFilter... filters) {
        return new AndFileFilter(toList(filters));
    }

    
    public static IOFileFilter or(IOFileFilter... filters) {
        return new OrFileFilter(toList(filters));
    }

    
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

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter notFileFilter(IOFileFilter filter) {
        return new NotFileFilter(filter);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter trueFileFilter() {
        return TrueFileFilter.TRUE;
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter falseFileFilter() {
        return FalseFileFilter.FALSE;
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter asFileFilter(FileFilter filter) {
        return new DelegateFileFilter(filter);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter asFileFilter(FilenameFilter filter) {
        return new DelegateFileFilter(filter);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter ageFileFilter(long cutoff) {
        return new AgeFileFilter(cutoff);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter ageFileFilter(long cutoff, boolean acceptOlder) {
        return new AgeFileFilter(cutoff, acceptOlder);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter ageFileFilter(Date cutoffDate) {
        return new AgeFileFilter(cutoffDate);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter ageFileFilter(Date cutoffDate, boolean acceptOlder) {
        return new AgeFileFilter(cutoffDate, acceptOlder);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter ageFileFilter(File cutoffReference) {
        return new AgeFileFilter(cutoffReference);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter ageFileFilter(File cutoffReference, boolean acceptOlder) {
        return new AgeFileFilter(cutoffReference, acceptOlder);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter sizeFileFilter(long threshold) {
        return new SizeFileFilter(threshold);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter sizeFileFilter(long threshold, boolean acceptLarger) {
        return new SizeFileFilter(threshold, acceptLarger);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter sizeRangeFileFilter(long minSizeInclusive, long maxSizeInclusive ) {
        IOFileFilter minimumFilter = new SizeFileFilter(minSizeInclusive, true);
        IOFileFilter maximumFilter = new SizeFileFilter(maxSizeInclusive + 1L, false);
        return new AndFileFilter(minimumFilter, maximumFilter);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter magicNumberFileFilter(String magicNumber) {
        return new MagicNumberFileFilter(magicNumber);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter magicNumberFileFilter(String magicNumber, long offset) {
        return new MagicNumberFileFilter(magicNumber, offset);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter magicNumberFileFilter(byte[] magicNumber) {
        return new MagicNumberFileFilter(magicNumber);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter magicNumberFileFilter(byte[] magicNumber, long offset) {
        return new MagicNumberFileFilter(magicNumber, offset);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter makeCVSAware(IOFileFilter filter) {
        if (filter == null) {
            return cvsFilter;
        } else {
            return and(filter, cvsFilter);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter makeSVNAware(IOFileFilter filter) {
        if (filter == null) {
            return svnFilter;
        } else {
            return and(filter, svnFilter);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter makeDirectoryOnly(IOFileFilter filter) {
        if (filter == null) {
            return DirectoryFileFilter.DIRECTORY;
        }
        return new AndFileFilter(DirectoryFileFilter.DIRECTORY, filter);
    }

    
    @DSModeled(DSC.SAFE)
    public static IOFileFilter makeFileOnly(IOFileFilter filter) {
        if (filter == null) {
            return FileFileFilter.FILE;
        }
        return new AndFileFilter(FileFileFilter.FILE, filter);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.799 -0400", hash_original_field = "35F1508C0FD3636D3837A9E1B3DD7AEC", hash_generated_field = "9CA3BCF7641131B48124CF381AF25265")

    private static final IOFileFilter cvsFilter = notFileFilter(
            and(directoryFileFilter(), nameFileFilter("CVS")));
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.799 -0400", hash_original_field = "6A23038387ACAE6FED24CDD901D90206", hash_generated_field = "A15BB13988DB098518B43E8CDD23955C")

    private static final IOFileFilter svnFilter = notFileFilter(
            and(directoryFileFilter(), nameFileFilter(".svn")));
}

