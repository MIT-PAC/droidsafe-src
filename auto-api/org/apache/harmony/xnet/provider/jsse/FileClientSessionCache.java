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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.040 -0400", hash_original_method = "EB2573B5E8F417FAB0EF293234CCCD0D", hash_generated_method = "828492362A3CD17C2E63D720E59E71D4")
    private  FileClientSessionCache() {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.047 -0400", hash_original_field = "5F8F22B8CDBAEEE8CF857673A9B6BA20", hash_generated_field = "FAF68CC60E35257A66D284E0CBAD8965")

        File directory;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.047 -0400", hash_original_field = "E15323109448CCC034C48D49F5C88039", hash_generated_field = "70BE4BEA17B6A634AB67825F984FA451")

        Map<String, File> accessOrder = newAccessOrder();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.047 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

        int size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.047 -0400", hash_original_field = "51CCA2A324929C6DF681D0AB86E41ED8", hash_generated_field = "0D96909FBFD5140BBB4470806FA63A38")

        String[] initialFiles;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.047 -0400", hash_original_method = "666C086AB9DBFD99FFC100F4BBE01D6D", hash_generated_method = "08E84F557F7D8911106D5BBE5161DB37")
          Impl(File directory) throws IOException {
            boolean exists;
            exists = directory.exists();
            {
                boolean var73C4E23BD2650D97D73D42200156D21F_133291232 = (exists && !directory.isDirectory());
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
                    boolean var2324C192F1E4F75429015A88EB6318D9_1830988083 = (!directory.mkdirs());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Creation of " + directory + " directory failed.");
                    } //End block
                } //End collapsed parenthetic
                size = 0;
            } //End block
            this.directory = directory;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.060 -0400", hash_original_method = "6735B81487DB1A41BA0188585FC9CDB0", hash_generated_method = "B52C47B718B0E2FE715D55401962E2AD")
        public synchronized byte[] getSessionData(String host, int port) {
            String name;
            name = fileName(host, port);
            File file;
            file = accessOrder.get(name);
            {
                {
                    boolean var2DF810EE573D64C563CF5A897E317302_196653041 = (Arrays.binarySearch(initialFiles, name) < 0);
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
            addTaint(host.getTaint());
            addTaint(port);
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_473600167 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_473600167;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                static void logReadError(String host, File file, Throwable t) {
            System.logW("Error reading session data for " + host + " from " + file + ".", t);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.061 -0400", hash_original_method = "5132AE8CDA034691D0864F8896105224", hash_generated_method = "93F76DEDF6620849F00396E2DE82FDDA")
        public synchronized void putSessionData(SSLSession session,
                byte[] sessionData) {
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
            addTaint(session.getTaint());
            addTaint(sessionData[0]);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.061 -0400", hash_original_method = "FF4C7212103FFBD9D2780D404E5A05FB", hash_generated_method = "4DBEB23312EF2D9255139F3043D1DE06")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.104 -0400", hash_original_method = "F581C713CF99D0BA42CA770E334518CE", hash_generated_method = "41F67CF12379DF3A5B88D675856F32CF")
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
                            boolean var5E8117B16347BFDDCD9CD10B568DF592_1008784058 = (!accessOrder.containsKey(name));
                            {
                                diskOnly.add(new CacheFile(directory, name));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varEA32EBD94358505B87B79D39083CDBCC_1270001982 = (!diskOnly.isEmpty());
                    {
                        Map<String, File> newOrder;
                        newOrder = newAccessOrder();
                        {
                            Iterator<CacheFile> varE81EBE9AA5DA88EBDD7EA73A78CB2D37_1555772477 = (diskOnly).iterator();
                            varE81EBE9AA5DA88EBDD7EA73A78CB2D37_1555772477.hasNext();
                            CacheFile cacheFile = varE81EBE9AA5DA88EBDD7EA73A78CB2D37_1555772477.next();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.105 -0400", hash_original_method = "DB4D1632DEDA59F34618884D114D9227", hash_generated_method = "D71CB08684FD96C6C767D57E4F3605A3")
        @SuppressWarnings("ThrowableInstanceNeverThrown")
        private void delete(File file) {
            {
                boolean var8E645B401E2BCD688DAA316F70EFD21B_2081360569 = (!file.delete());
                {
                    System.logW("Failed to delete " + file + ".", new IOException());
                } //End block
            } //End collapsed parenthetic
            addTaint(file.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.105 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.105 -0400", hash_original_field = "1E65905B55C5FDFCEDE87E2147EF83D4", hash_generated_field = "C57F295716CFF89C00CC3061FA79AC83")

        long lastModified = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.106 -0400", hash_original_method = "2568A503B31BE5D3BE6A0CE416CE2454", hash_generated_method = "ED6CF5E11786ED0C87045B1E7DFDB32E")
          CacheFile(File dir, String name) {
            super(dir, name);
            this.name = name;
            addTaint(dir.getTaint());
            // ---------- Original Method ----------
            //this.name = name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.106 -0400", hash_original_method = "3C0BB5E42CA61BE7C548B702B5AC04C2", hash_generated_method = "F22391E3772B79EC6587CD4F30D22117")
        @Override
        public long lastModified() {
            long lastModified;
            lastModified = this.lastModified;
            {
                lastModified = this.lastModified = super.lastModified();
            } //End block
            long var0F5264038205EDFB1AC05FBB0E8C5E94_475613208 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_475613208;
            // ---------- Original Method ----------
            //long lastModified = this.lastModified;
            //if (lastModified == -1) {
                //lastModified = this.lastModified = super.lastModified();
            //}
            //return lastModified;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.106 -0400", hash_original_method = "D50DE30B99FDC8E45DF3D781BD6CEC46", hash_generated_method = "1B10F4DFB4D3EA73A9FFC22015AA87F6")
        @Override
        public int compareTo(File another) {
            long result;
            result = lastModified() - another.lastModified();
            {
                int varC3D5FFF0272B837F0C4D18E324DDD548_363676019 = (super.compareTo(another));
            } //End block
            addTaint(another.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322223425 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322223425;
            // ---------- Original Method ----------
            //long result = lastModified() - another.lastModified();
            //if (result == 0) {
                //return super.compareTo(another);
            //}
            //return result < 0 ? -1 : 1;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.106 -0400", hash_original_field = "8BFAA797717AD5B2AFB838BCEE45D4AC", hash_generated_field = "7AE276D1B1BAA9C4B56D319F3FED4FD0")

    public static final int MAX_SIZE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.106 -0400", hash_original_field = "31316EB4685E561416C6D827CB9AE60C", hash_generated_field = "F915975B29834E0D95D457416C281D85")

    static Map<File, FileClientSessionCache.Impl> caches = new HashMap<File, FileClientSessionCache.Impl>();
}

