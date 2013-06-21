package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.756 -0400", hash_original_method = "EB2573B5E8F417FAB0EF293234CCCD0D", hash_generated_method = "828492362A3CD17C2E63D720E59E71D4")
    @DSModeled(DSC.SAFE)
    private FileClientSessionCache() {
        // ---------- Original Method ----------
    }

    
        public static synchronized SSLClientSessionCache usingDirectory(
            File directory) throws IOException {
        FileClientSessionCache.Impl cache = caches.get(directory);
        if (cache == null) {
            cache = new FileClientSessionCache.Impl(directory);
            caches.put(directory, cache);
        }
        return cache;
    }

    
        static synchronized void reset() {
        caches.clear();
    }

    
    static class Impl implements SSLClientSessionCache {
        File directory;
        Map<String, File> accessOrder = newAccessOrder();
        int size;
        String[] initialFiles;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.757 -0400", hash_original_method = "666C086AB9DBFD99FFC100F4BBE01D6D", hash_generated_method = "3010EF37C11687E5817F33A14B1C2FA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Impl(File directory) throws IOException {
            dsTaint.addTaint(directory.dsTaint);
            boolean exists;
            exists = directory.exists();
            {
                boolean var73C4E23BD2650D97D73D42200156D21F_571922404 = (exists && !directory.isDirectory());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException(directory + " exists but is not a directory.");
                } //End block
            } //End collapsed parenthetic
            {
                initialFiles = directory.list();
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException(directory + " exists but cannot list contents.");
                } //End block
                Arrays.sort(initialFiles);
                size = initialFiles.length;
            } //End block
            {
                {
                    boolean var2324C192F1E4F75429015A88EB6318D9_1917159249 = (!directory.mkdirs());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Creation of " + directory + " directory failed.");
                    } //End block
                } //End collapsed parenthetic
                size = 0;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                private static Map<String, File> newAccessOrder() {
            return new LinkedHashMap<String, File>(
                    MAX_SIZE, 0.75f, true );
        }

        
                private static String fileName(String host, int port) {
            if (host == null) {
                throw new NullPointerException("host");
            }
            return host + "." + port;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.758 -0400", hash_original_method = "6735B81487DB1A41BA0188585FC9CDB0", hash_generated_method = "D53592B83EFC6E0FFB26538A0FD68A20")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized byte[] getSessionData(String host, int port) {
            dsTaint.addTaint(port);
            dsTaint.addTaint(host);
            String name;
            name = fileName(host, port);
            File file;
            file = accessOrder.get(name);
            {
                {
                    boolean var2DF810EE573D64C563CF5A897E317302_621546477 = (Arrays.binarySearch(initialFiles, name) < 0);
                } //End collapsed parenthetic
                file = new File(directory, name);
                accessOrder.put(name, file);
            } //End block
            FileInputStream in;
            try 
            {
                in = new FileInputStream(file);
            } //End block
            catch (FileNotFoundException e)
            {
                logReadError(host, file, e);
            } //End block
            try 
            {
                int size;
                size = (int) file.length();
                byte[] data;
                data = new byte[size];
                new DataInputStream(in).readFully(data);
            } //End block
            catch (IOException e)
            {
                logReadError(host, file, e);
            } //End block
            finally 
            {
                IoUtils.closeQuietly(in);
            } //End block
            byte[] retVal = new byte[1];
            retVal[0] = (byte)dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                static void logReadError(String host, File file, Throwable t) {
            System.logW("Error reading session data for " + host + " from " + file + ".", t);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.759 -0400", hash_original_method = "5132AE8CDA034691D0864F8896105224", hash_generated_method = "6C7C293E2533623C76F36744294251A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void putSessionData(SSLSession session,
                byte[] sessionData) {
            dsTaint.addTaint(sessionData[0]);
            dsTaint.addTaint(session.dsTaint);
            String host;
            host = session.getPeerHost();
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("sessionData");
            } //End block
            String name;
            name = fileName(host, session.getPeerPort());
            File file;
            file = new File(directory, name);
            boolean existedBefore;
            existedBefore = file.exists();
            FileOutputStream out;
            try 
            {
                out = new FileOutputStream(file);
            } //End block
            catch (FileNotFoundException e)
            {
                logWriteError(host, file, e);
            } //End block
            {
                makeRoom();
            } //End block
            boolean writeSuccessful;
            writeSuccessful = false;
            try 
            {
                out.write(sessionData);
                writeSuccessful = true;
            } //End block
            catch (IOException e)
            {
                logWriteError(host, file, e);
            } //End block
            finally 
            {
                boolean closeSuccessful;
                closeSuccessful = false;
                try 
                {
                    out.close();
                    closeSuccessful = true;
                } //End block
                catch (IOException e)
                {
                    logWriteError(host, file, e);
                } //End block
                finally 
                {
                    {
                        delete(file);
                    } //End block
                    {
                        accessOrder.put(name, file);
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.759 -0400", hash_original_method = "FF4C7212103FFBD9D2780D404E5A05FB", hash_generated_method = "4DBEB23312EF2D9255139F3043D1DE06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void makeRoom() {
            indexFiles();
            int removals;
            removals = size - MAX_SIZE;
            Iterator<File> i;
            i = accessOrder.values().iterator();
            {
                delete(i.next());
                i.remove();
            } //End block
            // ---------- Original Method ----------
            //if (size <= MAX_SIZE) {
                //return;
            //}
            //indexFiles();
            //int removals = size - MAX_SIZE;
            //Iterator<File> i = accessOrder.values().iterator();
            //do {
                //delete(i.next());
                //i.remove();
            //} while (--removals > 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.765 -0400", hash_original_method = "F581C713CF99D0BA42CA770E334518CE", hash_generated_method = "63043DF28EDEAA0BFF05AE2D657A845C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void indexFiles() {
            String[] initialFiles;
            initialFiles = this.initialFiles;
            {
                this.initialFiles = null;
                Set<CacheFile> diskOnly;
                diskOnly = new TreeSet<CacheFile>();
                {
                    String name = initialFiles[0];
                    {
                        {
                            boolean var5E8117B16347BFDDCD9CD10B568DF592_2013116609 = (!accessOrder.containsKey(name));
                            {
                                diskOnly.add(new CacheFile(directory, name));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varEA32EBD94358505B87B79D39083CDBCC_1625128111 = (!diskOnly.isEmpty());
                    {
                        Map<String, File> newOrder;
                        newOrder = newAccessOrder();
                        {
                            Iterator<CacheFile> varE81EBE9AA5DA88EBDD7EA73A78CB2D37_1305297980 = (diskOnly).iterator();
                            varE81EBE9AA5DA88EBDD7EA73A78CB2D37_1305297980.hasNext();
                            CacheFile cacheFile = varE81EBE9AA5DA88EBDD7EA73A78CB2D37_1305297980.next();
                            {
                                newOrder.put(cacheFile.name, cacheFile);
                            } //End block
                        } //End collapsed parenthetic
                        newOrder.putAll(accessOrder);
                        this.accessOrder = newOrder;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.765 -0400", hash_original_method = "DB4D1632DEDA59F34618884D114D9227", hash_generated_method = "64DCAA4011FC12CFE5C6C9EE87C61B84")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("ThrowableInstanceNeverThrown")
        private void delete(File file) {
            dsTaint.addTaint(file.dsTaint);
            {
                boolean var8E645B401E2BCD688DAA316F70EFD21B_959930543 = (!file.delete());
                {
                    System.logW("Failed to delete " + file + ".", new IOException());
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (!file.delete()) {
                //System.logW("Failed to delete " + file + ".", new IOException());
            //}
            //size--;
        }

        
                static void logWriteError(String host, File file, Throwable t) {
            System.logW("Error writing session data for " + host + " to " + file + ".", t);
        }

        
    }


    
    static class CacheFile extends File {
        String name;
        long lastModified = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.766 -0400", hash_original_method = "2568A503B31BE5D3BE6A0CE416CE2454", hash_generated_method = "5440DD56D0AAE4CE6AC9FE7C67D6DA26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         CacheFile(File dir, String name) {
            super(dir, name);
            dsTaint.addTaint(dir.dsTaint);
            dsTaint.addTaint(name);
            // ---------- Original Method ----------
            //this.name = name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.766 -0400", hash_original_method = "3C0BB5E42CA61BE7C548B702B5AC04C2", hash_generated_method = "3F67B973EBCDC1D12BC80CE7EEEEC102")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public long lastModified() {
            long lastModified;
            lastModified = this.lastModified;
            {
                lastModified = this.lastModified = super.lastModified();
            } //End block
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //long lastModified = this.lastModified;
            //if (lastModified == -1) {
                //lastModified = this.lastModified = super.lastModified();
            //}
            //return lastModified;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.766 -0400", hash_original_method = "D50DE30B99FDC8E45DF3D781BD6CEC46", hash_generated_method = "FF72C1514CEB37768C2C12D8B89DD286")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int compareTo(File another) {
            dsTaint.addTaint(another.dsTaint);
            long result;
            result = lastModified() - another.lastModified();
            {
                int varC3D5FFF0272B837F0C4D18E324DDD548_1759940636 = (super.compareTo(another));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //long result = lastModified() - another.lastModified();
            //if (result == 0) {
                //return super.compareTo(another);
            //}
            //return result < 0 ? -1 : 1;
        }

        
    }


    
    public static final int MAX_SIZE = 12;
    static final Map<File, FileClientSessionCache.Impl> caches
            = new HashMap<File, FileClientSessionCache.Impl>();
}

