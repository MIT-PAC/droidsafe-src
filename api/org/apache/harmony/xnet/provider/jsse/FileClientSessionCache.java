package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.net.ssl.SSLSession;

import libcore.io.IoUtils;

public class FileClientSessionCache {

    /**
     * Returns a cache backed by the given directory. Creates the directory
     * (including parent directories) if necessary. This cache should have
     * exclusive access to the given directory.
     *
     * @param directory to store files in
     * @return a cache backed by the given directory
     * @throws IOException if the file exists and is not a directory or if
     *  creating the directories fails
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.700 -0500", hash_original_method = "05C617D461D77195B2E85EFC82E4058C", hash_generated_method = "77B835C846B7732D948F8F13965F7191")
    
public static synchronized SSLClientSessionCache usingDirectory(
            File directory) throws IOException {
        FileClientSessionCache.Impl cache = caches.get(directory);
        if (cache == null) {
            cache = new FileClientSessionCache.Impl(directory);
            caches.put(directory, cache);
        }
        return cache;
    }

    /** For testing. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.702 -0500", hash_original_method = "8C25F325A70D0FB77E33A1A14917611A", hash_generated_method = "7B323461C536F7A06E8BB12E6EBDC73D")
    
static synchronized void reset() {
        caches.clear();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.652 -0500", hash_original_field = "B9CF3F368199AEFAAFEB125B3B92D9DE", hash_generated_field = "7AE276D1B1BAA9C4B56D319F3FED4FD0")

    public static final int MAX_SIZE = 12;
    
    static class Impl implements SSLClientSessionCache {

        /**
         * Creates a new access-ordered linked hash map.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.670 -0500", hash_original_method = "DFC79029E1119A3D48A14DE1B9564947", hash_generated_method = "609DA5A8C24051423EB44DD6C80C5A5C")
        
private static Map<String, File> newAccessOrder() {
            return new LinkedHashMap<String, File>(
                    MAX_SIZE, 0.75f, true /* access order */);
        }

        /**
         * Gets the file name for the given host and port.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.673 -0500", hash_original_method = "02E1DD31485C74A947A1C6B3E3A51D41", hash_generated_method = "808B79FDE09C8AF6033F843984DFE08A")
        
private static String fileName(String host, int port) {
            if (host == null) {
                throw new NullPointerException("host");
            }
            return host + "." + port;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.678 -0500", hash_original_method = "8F7D3CFEACAE77FF29CE1B570D2B4071", hash_generated_method = "960A2F165C31F892AF7F89F517CF82C9")
        
static void logReadError(String host, File file, Throwable t) {
            System.logW("Error reading session data for " + host + " from " + file + ".", t);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.692 -0500", hash_original_method = "DC029A48DFA4AB0F9DF91B47975AC42D", hash_generated_method = "92399B485FABE21F96F9151A2040821B")
        
static void logWriteError(String host, File file, Throwable t) {
            System.logW("Error writing session data for " + host + " to " + file + ".", t);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.657 -0500", hash_original_field = "FAF68CC60E35257A66D284E0CBAD8965", hash_generated_field = "FAF68CC60E35257A66D284E0CBAD8965")

         File directory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.660 -0500", hash_original_field = "70BE4BEA17B6A634AB67825F984FA451", hash_generated_field = "70BE4BEA17B6A634AB67825F984FA451")

        Map<String, File> accessOrder = newAccessOrder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.662 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

        int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.664 -0500", hash_original_field = "0D96909FBFD5140BBB4470806FA63A38", hash_generated_field = "0D96909FBFD5140BBB4470806FA63A38")

        String[] initialFiles;

        /**
         * Constructs a new cache backed by the given directory.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.668 -0500", hash_original_method = "666C086AB9DBFD99FFC100F4BBE01D6D", hash_generated_method = "3F628D0222C9A381116CFF161912E138")
        
Impl(File directory) throws IOException {
            boolean exists = directory.exists();
            if (exists && !directory.isDirectory()) {
                throw new IOException(directory + " exists but is not a directory.");
            }

            if (exists) {
                // Read and sort initial list of files. We defer adding
                // information about these files to accessOrder until necessary
                // (see indexFiles()). Sorting the list enables us to detect
                // cache misses in getSessionData().
                // Note: Sorting an array here was faster than creating a
                // HashSet on Dalvik.
                initialFiles = directory.list();
                if (initialFiles == null) {
                    // File.list() will return null in error cases without throwing IOException
                    // http://b/3363561
                    throw new IOException(directory + " exists but cannot list contents.");
                }
                Arrays.sort(initialFiles);
                size = initialFiles.length;
            } else {
                // Create directory.
                if (!directory.mkdirs()) {
                    throw new IOException("Creation of " + directory + " directory failed.");
                }
                size = 0;
            }

            this.directory = directory;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.676 -0500", hash_original_method = "6735B81487DB1A41BA0188585FC9CDB0", hash_generated_method = "FFDD09C226A3DECE8B07C0E621B21081")
        
public synchronized byte[] getSessionData(String host, int port) {
            /*
             * Note: This method is only called when the in-memory cache
             * in SSLSessionContext misses, so it would be unnecessarily
             * redundant for this cache to store data in memory.
             */

            String name = fileName(host, port);
            File file = accessOrder.get(name);

            if (file == null) {
                // File wasn't in access order. Check initialFiles...
                if (initialFiles == null) {
                    // All files are in accessOrder, so it doesn't exist.
                    return null;
                }

                // Look in initialFiles.
                if (Arrays.binarySearch(initialFiles, name) < 0) {
                    // Not found.
                    return null;
                }

                // The file is on disk but not in accessOrder yet.
                file = new File(directory, name);
                accessOrder.put(name, file);
            }

            FileInputStream in;
            try {
                in = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                logReadError(host, file, e);
                return null;
            }
            try {
                int size = (int) file.length();
                byte[] data = new byte[size];
                new DataInputStream(in).readFully(data);
                return data;
            } catch (IOException e) {
                logReadError(host, file, e);
                return null;
            } finally {
                IoUtils.closeQuietly(in);
            }
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.681 -0500", hash_original_method = "5132AE8CDA034691D0864F8896105224", hash_generated_method = "D5F28A47CA22A82A576E3F38A4593C40")
        
public synchronized void putSessionData(SSLSession session,
                byte[] sessionData) {
            String host = session.getPeerHost();
            if (sessionData == null) {
                throw new NullPointerException("sessionData");
            }

            String name = fileName(host, session.getPeerPort());
            File file = new File(directory, name);

            // Used to keep track of whether or not we're expanding the cache.
            boolean existedBefore = file.exists();

            FileOutputStream out;
            try {
                out = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                // We can't write to the file.
                logWriteError(host, file, e);
                return;
            }

            // If we expanded the cache (by creating a new file)...
            if (!existedBefore) {
                size++;

                // Delete an old file if necessary.
                makeRoom();
            }

            boolean writeSuccessful = false;
            try {
                out.write(sessionData);
                writeSuccessful = true;
            } catch (IOException e) {
                logWriteError(host, file, e);
            } finally {
                boolean closeSuccessful = false;
                try {
                    out.close();
                    closeSuccessful = true;
                } catch (IOException e) {
                    logWriteError(host, file, e);
                } finally {
                    if (!writeSuccessful || !closeSuccessful) {
                        // Storage failed. Clean up.
                        delete(file);
                    } else {
                        // Success!
                        accessOrder.put(name, file);
                    }
                }
            }
        }

        /**
         * Deletes old files if necessary.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.684 -0500", hash_original_method = "FF4C7212103FFBD9D2780D404E5A05FB", hash_generated_method = "7BF91F071252BD0D49C93659143BB712")
        
private void makeRoom() {
            if (size <= MAX_SIZE) {
                return;
            }

            indexFiles();

            // Delete LRUed files.
            int removals = size - MAX_SIZE;
            Iterator<File> i = accessOrder.values().iterator();
            do {
                delete(i.next());
                i.remove();
            } while (--removals > 0);
        }

        /**
         * Lazily updates accessOrder to know about all files as opposed to
         * just the files accessed since this process started.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.686 -0500", hash_original_method = "F581C713CF99D0BA42CA770E334518CE", hash_generated_method = "7F77BD1CD1FB490660CE5D1D562D6B90")
        
private void indexFiles() {
            String[] initialFiles = this.initialFiles;
            if (initialFiles != null) {
                this.initialFiles = null;

                // Files on disk only, sorted by last modified time.
                // TODO: Use last access time.
                Set<CacheFile> diskOnly = new TreeSet<CacheFile>();
                for (String name : initialFiles) {
                    // If the file hasn't been accessed in this process...
                    if (!accessOrder.containsKey(name)) {
                        diskOnly.add(new CacheFile(directory, name));
                    }
                }

                if (!diskOnly.isEmpty()) {
                    // Add files not accessed in this process to the beginning
                    // of accessOrder.
                    Map<String, File> newOrder = newAccessOrder();
                    for (CacheFile cacheFile : diskOnly) {
                        newOrder.put(cacheFile.name, cacheFile);
                    }
                    newOrder.putAll(accessOrder);

                    this.accessOrder = newOrder;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.689 -0500", hash_original_method = "DB4D1632DEDA59F34618884D114D9227", hash_generated_method = "CC234686820E190C041CC0B1D70B3B4F")
        
@SuppressWarnings("ThrowableInstanceNeverThrown")
        private void delete(File file) {
            if (!file.delete()) {
                System.logW("Failed to delete " + file + ".", new IOException());
            }
            size--;
        }
        
    }
    
    static class CacheFile extends File {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.706 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

         String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.710 -0500", hash_original_field = "C57F295716CFF89C00CC3061FA79AC83", hash_generated_field = "C57F295716CFF89C00CC3061FA79AC83")

        long lastModified = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.708 -0500", hash_original_method = "2568A503B31BE5D3BE6A0CE416CE2454", hash_generated_method = "2568A503B31BE5D3BE6A0CE416CE2454")
        
CacheFile(File dir, String name) {
            super(dir, name);
            this.name = name;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.713 -0500", hash_original_method = "3C0BB5E42CA61BE7C548B702B5AC04C2", hash_generated_method = "BB642944A143182340C96B18EBC6A665")
        
@Override
        public long lastModified() {
            long lastModified = this.lastModified;
            if (lastModified == -1) {
                lastModified = this.lastModified = super.lastModified();
            }
            return lastModified;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.716 -0500", hash_original_method = "D50DE30B99FDC8E45DF3D781BD6CEC46", hash_generated_method = "3C576BB7C770E964C0DFDBFD5D138C15")
        
@Override
        public int compareTo(File another) {
            // Sort by last modified time.
            long result = lastModified() - another.lastModified();
            if (result == 0) {
                return super.compareTo(another);
            }
            return result < 0 ? -1 : 1;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.698 -0500", hash_original_field = "F8AFAF8A637439051EBBAD7E7F81D41B", hash_generated_field = "C5D99E3CF4DB28197153FDE2D1C47755")

    static final Map<File, FileClientSessionCache.Impl> caches
            = new HashMap<File, FileClientSessionCache.Impl>(); // ~72k

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.655 -0500", hash_original_method = "EB2573B5E8F417FAB0EF293234CCCD0D", hash_generated_method = "8B73A1F119778642A645D343B51FC647")
    
private FileClientSessionCache() {}
}

