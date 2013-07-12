package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.368 -0400", hash_original_method = "EB2573B5E8F417FAB0EF293234CCCD0D", hash_generated_method = "828492362A3CD17C2E63D720E59E71D4")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.369 -0400", hash_original_field = "5F8F22B8CDBAEEE8CF857673A9B6BA20", hash_generated_field = "FAF68CC60E35257A66D284E0CBAD8965")

        File directory;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.369 -0400", hash_original_field = "E15323109448CCC034C48D49F5C88039", hash_generated_field = "70BE4BEA17B6A634AB67825F984FA451")

        Map<String, File> accessOrder = newAccessOrder();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.369 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

        int size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.369 -0400", hash_original_field = "51CCA2A324929C6DF681D0AB86E41ED8", hash_generated_field = "0D96909FBFD5140BBB4470806FA63A38")

        String[] initialFiles;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.370 -0400", hash_original_method = "666C086AB9DBFD99FFC100F4BBE01D6D", hash_generated_method = "A41D0C446CB9B68B03171AEFFCEC17EF")
          Impl(File directory) throws IOException {
            boolean exists = directory.exists();
    if(exists && !directory.isDirectory())            
            {
                IOException varCA908EABAF1A77616F2980FB9EC17A74_2067237049 = new IOException(directory + " exists but is not a directory.");
                varCA908EABAF1A77616F2980FB9EC17A74_2067237049.addTaint(taint);
                throw varCA908EABAF1A77616F2980FB9EC17A74_2067237049;
            } //End block
    if(exists)            
            {
                initialFiles = directory.list();
    if(initialFiles == null)                
                {
                    IOException var240033CDD4AAF078253733FC3E0DB8F5_232074231 = new IOException(directory + " exists but cannot list contents.");
                    var240033CDD4AAF078253733FC3E0DB8F5_232074231.addTaint(taint);
                    throw var240033CDD4AAF078253733FC3E0DB8F5_232074231;
                } //End block
                Arrays.sort(initialFiles);
                size = initialFiles.length;
            } //End block
            else
            {
    if(!directory.mkdirs())                
                {
                    IOException var68FF09276BABB13126C6873B15728CCD_1801660629 = new IOException("Creation of " + directory + " directory failed.");
                    var68FF09276BABB13126C6873B15728CCD_1801660629.addTaint(taint);
                    throw var68FF09276BABB13126C6873B15728CCD_1801660629;
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.373 -0400", hash_original_method = "6735B81487DB1A41BA0188585FC9CDB0", hash_generated_method = "F2E5F1EE7EF9DD7125BA345370CE1CF2")
        public synchronized byte[] getSessionData(String host, int port) {
            addTaint(port);
            addTaint(host.getTaint());
            String name = fileName(host, port);
            File file = accessOrder.get(name);
    if(file == null)            
            {
    if(initialFiles == null)                
                {
                    byte[] var37A6259CC0C1DAE299A7866489DFF0BD_615189257 = (null);
                                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1867649510 = {getTaintByte()};
                    return var2F9C81BC6E497382285CD6B7A7E33DE1_1867649510;
                } //End block
    if(Arrays.binarySearch(initialFiles, name) < 0)                
                {
                    byte[] var37A6259CC0C1DAE299A7866489DFF0BD_2063621427 = (null);
                                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_71746956 = {getTaintByte()};
                    return var2F9C81BC6E497382285CD6B7A7E33DE1_71746956;
                } //End block
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
                byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1578496540 = (null);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2136260048 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_2136260048;
            } //End block
            try 
            {
                int size = (int) file.length();
                byte[] data = new byte[size];
                new DataInputStream(in).readFully(data);
                byte[] var8D777F385D3DFEC8815D20F7496026DC_1468469874 = (data);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1994141514 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_1994141514;
            } //End block
            catch (IOException e)
            {
                logReadError(host, file, e);
                byte[] var37A6259CC0C1DAE299A7866489DFF0BD_2106956275 = (null);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_116221364 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_116221364;
            } //End block
            finally 
            {
                IoUtils.closeQuietly(in);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                static void logReadError(String host, File file, Throwable t) {
            System.logW("Error reading session data for " + host + " from " + file + ".", t);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.376 -0400", hash_original_method = "5132AE8CDA034691D0864F8896105224", hash_generated_method = "0DFCD4FB05C39E4A8700BC538E67212B")
        public synchronized void putSessionData(SSLSession session,
                byte[] sessionData) {
            addTaint(sessionData[0]);
            addTaint(session.getTaint());
            String host = session.getPeerHost();
    if(sessionData == null)            
            {
                NullPointerException varB0CFDC853DE7DD0027E86BF1E560C555_1081451586 = new NullPointerException("sessionData");
                varB0CFDC853DE7DD0027E86BF1E560C555_1081451586.addTaint(taint);
                throw varB0CFDC853DE7DD0027E86BF1E560C555_1081451586;
            } //End block
            String name = fileName(host, session.getPeerPort());
            File file = new File(directory, name);
            boolean existedBefore = file.exists();
            FileOutputStream out;
            try 
            {
                out = new FileOutputStream(file);
            } //End block
            catch (FileNotFoundException e)
            {
                logWriteError(host, file, e);
                return;
            } //End block
    if(!existedBefore)            
            {
                size++;
                makeRoom();
            } //End block
            boolean writeSuccessful = false;
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
                boolean closeSuccessful = false;
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
    if(!writeSuccessful || !closeSuccessful)                    
                    {
                        delete(file);
                    } //End block
                    else
                    {
                        accessOrder.put(name, file);
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.377 -0400", hash_original_method = "FF4C7212103FFBD9D2780D404E5A05FB", hash_generated_method = "1F3BA25F80B5624C4DF0E7A926595A56")
        private void makeRoom() {
    if(size <= MAX_SIZE)            
            {
                return;
            } //End block
            indexFiles();
            int removals = size - MAX_SIZE;
            Iterator<File> i = accessOrder.values().iterator();
            do {
                {
                    delete(i.next());
                    i.remove();
                } //End block
} while (--removals > 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.377 -0400", hash_original_method = "F581C713CF99D0BA42CA770E334518CE", hash_generated_method = "20D26B69789961BA9BD556E8EB956AF3")
        private void indexFiles() {
            String[] initialFiles = this.initialFiles;
    if(initialFiles != null)            
            {
                this.initialFiles = null;
                Set<CacheFile> diskOnly = new TreeSet<CacheFile>();
for(String name : initialFiles)
                {
    if(!accessOrder.containsKey(name))                    
                    {
                        diskOnly.add(new CacheFile(directory, name));
                    } //End block
                } //End block
    if(!diskOnly.isEmpty())                
                {
                    Map<String, File> newOrder = newAccessOrder();
for(CacheFile cacheFile : diskOnly)
                    {
                        newOrder.put(cacheFile.name, cacheFile);
                    } //End block
                    newOrder.putAll(accessOrder);
                    this.accessOrder = newOrder;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.378 -0400", hash_original_method = "DB4D1632DEDA59F34618884D114D9227", hash_generated_method = "543E3F2CCD14B3C79B5EABF2220F3F4A")
        @SuppressWarnings("ThrowableInstanceNeverThrown")
        private void delete(File file) {
            addTaint(file.getTaint());
    if(!file.delete())            
            {
                System.logW("Failed to delete " + file + ".", new IOException());
            } //End block
            size--;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.379 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.379 -0400", hash_original_field = "1E65905B55C5FDFCEDE87E2147EF83D4", hash_generated_field = "C57F295716CFF89C00CC3061FA79AC83")

        long lastModified = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.380 -0400", hash_original_method = "2568A503B31BE5D3BE6A0CE416CE2454", hash_generated_method = "DD0D09E9FE4DE7B98618C520776A5376")
          CacheFile(File dir, String name) {
            super(dir, name);
            addTaint(dir.getTaint());
            this.name = name;
            // ---------- Original Method ----------
            //this.name = name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.381 -0400", hash_original_method = "3C0BB5E42CA61BE7C548B702B5AC04C2", hash_generated_method = "C54D7575446EFD6D9B32F65FC81EE0FB")
        @Override
        public long lastModified() {
            long lastModified = this.lastModified;
    if(lastModified == -1)            
            {
                lastModified = this.lastModified = super.lastModified();
            } //End block
            long var56D4CE3ADDD9E0185B21EB938EA5BC79_793679393 = (lastModified);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_551526532 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_551526532;
            // ---------- Original Method ----------
            //long lastModified = this.lastModified;
            //if (lastModified == -1) {
                //lastModified = this.lastModified = super.lastModified();
            //}
            //return lastModified;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.381 -0400", hash_original_method = "D50DE30B99FDC8E45DF3D781BD6CEC46", hash_generated_method = "0FB46900A3E8A9D31BFC2B1422807676")
        @Override
        public int compareTo(File another) {
            addTaint(another.getTaint());
            long result = lastModified() - another.lastModified();
    if(result == 0)            
            {
                int varFF312826F736316A102585272714A9D5_667189932 = (super.compareTo(another));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134150648 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_134150648;
            } //End block
            int var0FF13776863362E2ACEFA19819A1FF38_173650398 = (result < 0 ? -1 : 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380411637 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380411637;
            // ---------- Original Method ----------
            //long result = lastModified() - another.lastModified();
            //if (result == 0) {
                //return super.compareTo(another);
            //}
            //return result < 0 ? -1 : 1;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.381 -0400", hash_original_field = "8BFAA797717AD5B2AFB838BCEE45D4AC", hash_generated_field = "7AE276D1B1BAA9C4B56D319F3FED4FD0")

    public static final int MAX_SIZE = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.381 -0400", hash_original_field = "31316EB4685E561416C6D827CB9AE60C", hash_generated_field = "C5D99E3CF4DB28197153FDE2D1C47755")

    static final Map<File, FileClientSessionCache.Impl> caches = new HashMap<File, FileClientSessionCache.Impl>();
}

