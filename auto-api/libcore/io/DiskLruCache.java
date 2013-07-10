package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class DiskLruCache implements Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.967 -0400", hash_original_field = "5F8F22B8CDBAEEE8CF857673A9B6BA20", hash_generated_field = "8B0860249151DE823C54467CC9BADB3F")

    private File directory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.967 -0400", hash_original_field = "3C3C73781D3DE0858A20A84F8FE7A498", hash_generated_field = "C3DAA1E42AD1B9E8800013507C6A05F9")

    private File journalFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.967 -0400", hash_original_field = "BBEFE2C36653C86E334A0DB0A7D1D2DE", hash_generated_field = "E459709269D427C9CB1CBD686B5A13E5")

    private File journalFileTmp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.967 -0400", hash_original_field = "B64C136408BBB80DFA6717A62D239726", hash_generated_field = "DEE2522BB7DF04F0B0954F3014F259F5")

    private int appVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.967 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "736713EBDB43EC0678FF4084C276D4A3")

    private long maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.968 -0400", hash_original_field = "A30C57CC28770178EAB167BF0B932032", hash_generated_field = "37330B5F0FE12E195B061FFDF29F478E")

    private int valueCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.968 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "93F7705D696C1DC0669B611BBCDF6959")

    private long size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.968 -0400", hash_original_field = "9CB65621E620C7F32CB54AA3C3BED0D0", hash_generated_field = "6BA9D6A677DAD8E6F256134E2B68A280")

    private Writer journalWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.968 -0400", hash_original_field = "FBBC54FAC485F995EAA3AEC039F91CB6", hash_generated_field = "D4AEF12769A5EC9F5F72F388FEBC72A2")

    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<String, Entry>(0, 0.75f, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.968 -0400", hash_original_field = "ACF4170A74586A81D52591B8F18C89F4", hash_generated_field = "6E19F0863A5F1F61C505FBB71E78DAA1")

    private int redundantOpCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.968 -0400", hash_original_field = "7893561B06784847101FF1A4FE94844D", hash_generated_field = "D542EB48AB8E08A6131DD420815BF0BD")

    private final ExecutorService executorService = new ThreadPoolExecutor(0, 1,
            60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.969 -0400", hash_original_field = "0AB759F1EA2680D4F36A63BC7BD4683F", hash_generated_field = "02934D3CC46F9AC5549E543E7FEE2593")

    private final Callable<Void> cleanupCallable = new Callable<Void>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.969 -0400", hash_original_method = "60CB515F13FCF39FB25B426074E3001D", hash_generated_method = "657EDDA2627FCB4772B1A28CA5D1F2C0")
        @Override
        public Void call() throws Exception {
            Void varB4EAC82CA7396A68D541C85D26508E83_908756601 = null; 
            Void varB4EAC82CA7396A68D541C85D26508E83_1282687766 = null; 
            {
                Object varD933D409C8362D8AB4EAAFB238C186FA_2025849265 = (DiskLruCache.this);
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_908756601 = null;
                    } 
                    trimToSize();
                    {
                        boolean varAE772B6A2261513DC630DDE920DDFCB8_1747341119 = (journalRebuildRequired());
                        {
                            rebuildJournal();
                            redundantOpCount = 0;
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1282687766 = null;
            Void varA7E53CE21691AB073D9660D615818899_309578625; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_309578625 = varB4EAC82CA7396A68D541C85D26508E83_908756601;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_309578625 = varB4EAC82CA7396A68D541C85D26508E83_1282687766;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_309578625.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_309578625;
            
            
                
                    
                
                
                
                    
                    
                
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.969 -0400", hash_original_method = "F7C5B739E468E97586605C521F3C2B42", hash_generated_method = "72D38F4B2DCD8001D35CBA47221BB3AF")
    private  DiskLruCache(File directory, int appVersion, int valueCount, long maxSize) {
        this.directory = directory;
        this.appVersion = appVersion;
        this.journalFile = new File(directory, JOURNAL_FILE);
        this.journalFileTmp = new File(directory, JOURNAL_FILE_TMP);
        this.valueCount = valueCount;
        this.maxSize = maxSize;
        
        
        
        
        
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static DiskLruCache open(File directory, int appVersion, int valueCount, long maxSize) throws IOException {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (valueCount <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        DiskLruCache cache = new DiskLruCache(directory, appVersion, valueCount, maxSize);
        if (cache.journalFile.exists()) {
            try {
                cache.readJournal();
                cache.processJournal();
                cache.journalWriter = new BufferedWriter(new FileWriter(cache.journalFile, true));
                return cache;
            } catch (IOException journalIsCorrupt) {
                System.logW("DiskLruCache " + directory + " is corrupt: "
                        + journalIsCorrupt.getMessage() + ", removing");
                cache.delete();
            }
        }
        directory.mkdirs();
        cache = new DiskLruCache(directory, appVersion, valueCount, maxSize);
        cache.rebuildJournal();
        return cache;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.970 -0400", hash_original_method = "D80881F7E6F2A63F9AF02A98171F075C", hash_generated_method = "716309904C20418F213E58B35131B072")
    private void readJournal() throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(journalFile));
        try 
        {
            String magic = Streams.readAsciiLine(in);
            String version = Streams.readAsciiLine(in);
            String appVersionString = Streams.readAsciiLine(in);
            String valueCountString = Streams.readAsciiLine(in);
            String blank = Streams.readAsciiLine(in);
            {
                boolean var3B415B63A46B05254C7463316DBFFFC4_1462502954 = (!MAGIC.equals(magic)
                    || !VERSION_1.equals(version)
                    || !Integer.toString(appVersion).equals(appVersionString)
                    || !Integer.toString(valueCount).equals(valueCountString)
                    || !"".equals(blank));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal header: ["
                        + magic + ", " + version + ", " + valueCountString + ", " + blank + "]");
                } 
            } 
            {
                try 
                {
                    readJournalLine(Streams.readAsciiLine(in));
                } 
                catch (EOFException endOfJournal)
                { }
            } 
        } 
        finally 
        {
            IoUtils.closeQuietly(in);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.971 -0400", hash_original_method = "B93033832384BE0A8F735535A303EB51", hash_generated_method = "6DB1A8AED675AD5F31B28ABAD8F865B6")
    private void readJournalLine(String line) throws IOException {
        String[] parts = line.split(" ");
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal line: " + line);
        } 
        String key = parts[1];
        {
            boolean varAEADAED980A3E2CE65A0FB2D397AC4EF_1686760113 = (parts[0].equals(REMOVE) && parts.length == 2);
            {
                lruEntries.remove(key);
            } 
        } 
        Entry entry = lruEntries.get(key);
        {
            entry = new Entry(key);
            lruEntries.put(key, entry);
        } 
        {
            boolean var98DA74BB3A0D1D55A0A2F6F4FB097B6E_497444052 = (parts[0].equals(CLEAN) && parts.length == 2 + valueCount);
            {
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(Arrays.copyOfRange(parts, 2, parts.length));
            } 
            {
                boolean var1A74343163BF8B3C2F48DFA8E158DAA9_1537950080 = (parts[0].equals(DIRTY) && parts.length == 2);
                {
                    entry.currentEditor = new Editor(entry);
                } 
                {
                    boolean var1B34DE325BCE96DBE7D78DC7688F24C9_1811012793 = (parts[0].equals(READ) && parts.length == 2);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal line: " + line);
                    } 
                } 
            } 
        } 
        addTaint(line.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.972 -0400", hash_original_method = "BF29FD79336E7D0F2752A5C16F704FCA", hash_generated_method = "24B640361FFBB23EA04097BB59B679CC")
    private void processJournal() throws IOException {
        deleteIfExists(journalFileTmp);
        {
            Iterator<Entry> i = lruEntries.values().iterator();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_49652207 = (i.hasNext());
            {
                Entry entry = i.next();
                {
                    {
                        int t = 0;
                        {
                            size += entry.lengths[t];
                        } 
                    } 
                } 
                {
                    entry.currentEditor = null;
                    {
                        int t = 0;
                        {
                            deleteIfExists(entry.getCleanFile(t));
                            deleteIfExists(entry.getDirtyFile(t));
                        } 
                    } 
                    i.remove();
                } 
            } 
        } 
        
        
        
            
            
                
                    
                
            
                
                
                    
                    
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.978 -0400", hash_original_method = "CAFF8A7D35D4FC2C6D20C8D2E31B18B9", hash_generated_method = "FCF7068065FB23B199D32864A5514808")
    private synchronized void rebuildJournal() throws IOException {
        {
            journalWriter.close();
        } 
        Writer writer = new BufferedWriter(new FileWriter(journalFileTmp));
        writer.write(MAGIC);
        writer.write("\n");
        writer.write(VERSION_1);
        writer.write("\n");
        writer.write(Integer.toString(appVersion));
        writer.write("\n");
        writer.write(Integer.toString(valueCount));
        writer.write("\n");
        writer.write("\n");
        {
            Iterator<Entry> var3FF52ED4E313724F3C65EC6A81752D91_598448891 = (lruEntries.values()).iterator();
            var3FF52ED4E313724F3C65EC6A81752D91_598448891.hasNext();
            Entry entry = var3FF52ED4E313724F3C65EC6A81752D91_598448891.next();
            {
                {
                    writer.write(DIRTY + ' ' + entry.key + '\n');
                } 
                {
                    writer.write(CLEAN + ' ' + entry.key + entry.getLengths() + '\n');
                } 
            } 
        } 
        writer.close();
        journalFileTmp.renameTo(journalFile);
        journalWriter = new BufferedWriter(new FileWriter(journalFile, true));
        
        
    }

    
        @DSModeled(DSC.SAFE)
    private static void deleteIfExists(File file) throws IOException {
        try {
            Libcore.os.remove(file.getPath());
        } catch (ErrnoException errnoException) {
            if (errnoException.errno != OsConstants.ENOENT) {
                throw errnoException.rethrowAsIOException();
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.979 -0400", hash_original_method = "8CCA333E37F6F5C0426A3FC5CE5D4B2E", hash_generated_method = "E4F802011C5B118F213ECAE4A1F8E572")
    public synchronized Snapshot get(String key) throws IOException {
        Snapshot varB4EAC82CA7396A68D541C85D26508E83_1542281905 = null; 
        Snapshot varB4EAC82CA7396A68D541C85D26508E83_1899025608 = null; 
        Snapshot varB4EAC82CA7396A68D541C85D26508E83_1784822624 = null; 
        Snapshot varB4EAC82CA7396A68D541C85D26508E83_1607100392 = null; 
        checkNotClosed();
        validateKey(key);
        Entry entry = lruEntries.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1542281905 = null;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1899025608 = null;
        } 
        InputStream[] ins = new InputStream[valueCount];
        try 
        {
            {
                int i = 0;
                {
                    ins[i] = new FileInputStream(entry.getCleanFile(i));
                } 
            } 
        } 
        catch (FileNotFoundException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1784822624 = null;
        } 
        journalWriter.append(READ + ' ' + key + '\n');
        {
            boolean varE9BCC6F78EB13BE042B748E2FA1C8B0F_204035347 = (journalRebuildRequired());
            {
                executorService.submit(cleanupCallable);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1607100392 = new Snapshot(ins);
        addTaint(key.getTaint());
        Snapshot varA7E53CE21691AB073D9660D615818899_2135112251; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2135112251 = varB4EAC82CA7396A68D541C85D26508E83_1542281905;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2135112251 = varB4EAC82CA7396A68D541C85D26508E83_1899025608;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_2135112251 = varB4EAC82CA7396A68D541C85D26508E83_1784822624;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2135112251 = varB4EAC82CA7396A68D541C85D26508E83_1607100392;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2135112251.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2135112251;
        
        
        
        
        
            
        
        
            
        
        
        
            
                
            
        
            
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.980 -0400", hash_original_method = "1C8B92160DB309C26801458073B88259", hash_generated_method = "94AA21B99E6D69B025B858037BEF0290")
    public synchronized Editor edit(String key) throws IOException {
        Editor varB4EAC82CA7396A68D541C85D26508E83_1832644645 = null; 
        Editor varB4EAC82CA7396A68D541C85D26508E83_500077972 = null; 
        checkNotClosed();
        validateKey(key);
        Entry entry = lruEntries.get(key);
        {
            entry = new Entry(key);
            lruEntries.put(key, entry);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1832644645 = null;
        } 
        Editor editor = new Editor(entry);
        entry.currentEditor = editor;
        journalWriter.write(DIRTY + ' ' + key + '\n');
        journalWriter.flush();
        varB4EAC82CA7396A68D541C85D26508E83_500077972 = editor;
        addTaint(key.getTaint());
        Editor varA7E53CE21691AB073D9660D615818899_533561562; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_533561562 = varB4EAC82CA7396A68D541C85D26508E83_1832644645;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_533561562 = varB4EAC82CA7396A68D541C85D26508E83_500077972;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_533561562.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_533561562;
        
        
        
        
        
            
            
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.981 -0400", hash_original_method = "0F452AFCA1F8F7ACF1A711B33CB47BDA", hash_generated_method = "C746A836EDEB50EA8B204649418BED6F")
    public File getDirectory() {
        File varB4EAC82CA7396A68D541C85D26508E83_1786673281 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1786673281 = directory;
        varB4EAC82CA7396A68D541C85D26508E83_1786673281.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1786673281;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.981 -0400", hash_original_method = "4A03A0F188DC0124026C9315925210D3", hash_generated_method = "EC4B8DA7249674B272A06C1803CF7E80")
    public long maxSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1680974984 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1680974984;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.981 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "5B7973FE2D28A79131E5A1778E5157AE")
    public synchronized long size() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_48763410 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_48763410;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.982 -0400", hash_original_method = "E3B5F5B6DB82C9D68E2AD58524FD46D2", hash_generated_method = "4C9BD1C4FD25263CAEB860AED9C11695")
    private synchronized void completeEdit(Editor editor, boolean success) throws IOException {
        Entry entry = editor.entry;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } 
        {
            {
                int i = 0;
                {
                    {
                        boolean varFFE5A3C862451CA99201ACFA8DB76116_1670332836 = (!entry.getDirtyFile(i).exists());
                        {
                            editor.abort();
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("edit didn't create file " + i);
                        } 
                    } 
                } 
            } 
        } 
        {
            int i = 0;
            {
                File dirty = entry.getDirtyFile(i);
                {
                    {
                        boolean var6FE72A42168775380AEE51AF827532B3_415935253 = (dirty.exists());
                        {
                            File clean = entry.getCleanFile(i);
                            dirty.renameTo(clean);
                            long oldLength = entry.lengths[i];
                            long newLength = clean.length();
                            entry.lengths[i] = newLength;
                            size = size - oldLength + newLength;
                        } 
                    } 
                } 
                {
                    deleteIfExists(dirty);
                } 
            } 
        } 
        entry.currentEditor = null;
        {
            entry.readable = true;
            journalWriter.write(CLEAN + ' ' + entry.key + entry.getLengths() + '\n');
        } 
        {
            lruEntries.remove(entry.key);
            journalWriter.write(REMOVE + ' ' + entry.key + '\n');
        } 
        {
            boolean var776EDFAB12D0A0A4A863963ED3C1C602_1372921571 = (size > maxSize || journalRebuildRequired());
            {
                executorService.submit(cleanupCallable);
            } 
        } 
        addTaint(editor.getTaint());
        addTaint(success);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.983 -0400", hash_original_method = "BD0CD0940E277CB89BD11D972CAF1EC0", hash_generated_method = "A464779CFE102AA6E61AE8C8DA7E4622")
    private boolean journalRebuildRequired() {
        final int REDUNDANT_OP_COMPACT_THRESHOLD = 2000;
        boolean varA8B170D68A257FCB088E560C51B41F6B_800945562 = (redundantOpCount >= REDUNDANT_OP_COMPACT_THRESHOLD
                && redundantOpCount >= lruEntries.size());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351248065 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351248065;
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.985 -0400", hash_original_method = "EADC8C19CC119124A893E81F5BBBE260", hash_generated_method = "C6C8B8E4680D80560EBD406A83AD8DE6")
    public synchronized boolean remove(String key) throws IOException {
        checkNotClosed();
        validateKey(key);
        Entry entry = lruEntries.get(key);
        {
            int i = 0;
            {
                File file = entry.getCleanFile(i);
                {
                    boolean var662432ADDD39E82511D634813D6392A6_31304521 = (!file.delete());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("failed to delete " + file);
                    } 
                } 
                size -= entry.lengths[i];
                entry.lengths[i] = 0;
            } 
        } 
        journalWriter.append(REMOVE + ' ' + key + '\n');
        lruEntries.remove(key);
        {
            boolean varE9BCC6F78EB13BE042B748E2FA1C8B0F_1663365809 = (journalRebuildRequired());
            {
                executorService.submit(cleanupCallable);
            } 
        } 
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_493550984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_493550984;
        
        
        
        
        
            
        
        
            
            
                
            
            
            
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.986 -0400", hash_original_method = "DD17EBB3E7F8098B41E8CF3D3DB045E0", hash_generated_method = "8FF21DC45ECC4839B2AE697B49D7889C")
    public boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316621409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316621409;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.987 -0400", hash_original_method = "8ED19EB33A6AB2822DDF1831EB4A2E5C", hash_generated_method = "563F58E3136896F1891C3E5166D27E9A")
    private void checkNotClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("cache is closed");
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.987 -0400", hash_original_method = "329F096E2383A78FF3370B422D55028D", hash_generated_method = "365B35FA4F8864C12CD2EC6688A56CBE")
    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        journalWriter.flush();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.994 -0400", hash_original_method = "99CE1AB60FDF93828647C541E1949F71", hash_generated_method = "7BE527FDA4B839A7ABCDF9ABFFB25AEF")
    public synchronized void close() throws IOException {
        {
            Iterator<Entry> varA079903352D454BE94CBDC004A76A873_1279085761 = (new ArrayList<Entry>(lruEntries.values())).iterator();
            varA079903352D454BE94CBDC004A76A873_1279085761.hasNext();
            Entry entry = varA079903352D454BE94CBDC004A76A873_1279085761.next();
            {
                {
                    entry.currentEditor.abort();
                } 
            } 
        } 
        trimToSize();
        journalWriter.close();
        journalWriter = null;
        
        
            
        
        
            
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.994 -0400", hash_original_method = "52FB98FFFDCED62623018A96063CC5F4", hash_generated_method = "56A9888541E62A6F53EADFDC157B470F")
    private void trimToSize() throws IOException {
        {
            Map.Entry<String, Entry> toEvict = lruEntries.eldest();
            remove(toEvict.getKey());
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.995 -0400", hash_original_method = "E0DF0E5E95BB69DC7E72889656D60AB7", hash_generated_method = "40601D48395A0FDE4DC088AFE1B7872C")
    public void delete() throws IOException {
        close();
        IoUtils.deleteContents(directory);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.995 -0400", hash_original_method = "A6AB05B3A3783BAC84CED8DCEEB398D1", hash_generated_method = "8F430ECFABD203F3067335388636C6B3")
    private void validateKey(String key) {
        {
            boolean var8C530715B845FC3D79AD68AB30B9FD1A_1572595113 = (key.contains(" ") || key.contains("\n") || key.contains("\r"));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "keys must not contain spaces or newlines: \"" + key + "\"");
            } 
        } 
        addTaint(key.getTaint());
        
        
            
                    
        
    }

    
        @DSModeled(DSC.SAFE)
    private static String inputStreamToString(InputStream in) throws IOException {
        return Streams.readFully(new InputStreamReader(in, Charsets.UTF_8));
    }

    
    public static final class Snapshot implements Closeable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.995 -0400", hash_original_field = "CDF1E220D89C2DCD2E000C3D105BF93E", hash_generated_field = "464EF7B473F9CC85C5904899BBCD6B8E")

        private InputStream[] ins;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.996 -0400", hash_original_method = "4874F99779A0A237419F7A04515D002C", hash_generated_method = "6FEE8A1DE88E19521460185A59EEAE25")
        private  Snapshot(InputStream[] ins) {
            this.ins = ins;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.997 -0400", hash_original_method = "1265F3570693D55B3F128D89D3B629D2", hash_generated_method = "D0CD27AEAB006C8CAFFE8DF88D956C6C")
        public InputStream getInputStream(int index) {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_39208850 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_39208850 = ins[index];
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_39208850.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_39208850;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.997 -0400", hash_original_method = "CEACA6862DFE49E3BCD1DEF39CCE35B7", hash_generated_method = "AAA395A56355113524B934ACEB7EBB0B")
        public String getString(int index) throws IOException {
            String varB4EAC82CA7396A68D541C85D26508E83_335806471 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_335806471 = inputStreamToString(getInputStream(index));
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_335806471.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_335806471;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.999 -0400", hash_original_method = "ECD6C2B86E4C6B719F1F8B8AE3B1A8FC", hash_generated_method = "C91429C439AEEC0914768F877120DF3F")
        @Override
        public void close() {
            {
                InputStream in = ins[0];
                {
                    IoUtils.closeQuietly(in);
                } 
            } 
            
            
                
            
        }

        
    }


    
    public final class Editor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.999 -0400", hash_original_field = "1043BFC77FEBE75FAFEC0C4309FACCF1", hash_generated_field = "70C4CB2BDA836A091A18885840DD6AFF")

        private Entry entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:27.999 -0400", hash_original_field = "9308EF711245F4213A779903B194F396", hash_generated_field = "801DA5B7CFF4CA64DD2686B1718833F3")

        private boolean hasErrors;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.000 -0400", hash_original_method = "DB0A9ACC8813DA2FB44F6FFEC09E8772", hash_generated_method = "9D5F2E1BFEBBC34BED7AEE5B243CB69C")
        private  Editor(Entry entry) {
            this.entry = entry;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.001 -0400", hash_original_method = "E20ADC2C4905CE726058A12470A98795", hash_generated_method = "4EF7EF6EC63FD7C9634E16D305734DF9")
        public InputStream newInputStream(int index) throws IOException {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1443277585 = null; 
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1242536438 = null; 
            {
                Object varD933D409C8362D8AB4EAAFB238C186FA_1515158380 = (DiskLruCache.this);
                {
                    {
                        boolean var573C982FD8CE38C80E849A01EADDA5C3_404551086 = (entry.currentEditor != this);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                        } 
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1443277585 = null;
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_1242536438 = new FileInputStream(entry.getCleanFile(index));
                } 
            } 
            addTaint(index);
            InputStream varA7E53CE21691AB073D9660D615818899_677277829; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_677277829 = varB4EAC82CA7396A68D541C85D26508E83_1443277585;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_677277829 = varB4EAC82CA7396A68D541C85D26508E83_1242536438;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_677277829.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_677277829;
            
            
                
                    
                
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.002 -0400", hash_original_method = "84B73985D87B7C97991726C0644B80BD", hash_generated_method = "615F1536DDCCC9ED59276DDD1D8BBBB9")
        public String getString(int index) throws IOException {
            String varB4EAC82CA7396A68D541C85D26508E83_1923658831 = null; 
            InputStream in = newInputStream(index);
            varB4EAC82CA7396A68D541C85D26508E83_1923658831 = in != null ? inputStreamToString(in) : null;
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1923658831.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1923658831;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.003 -0400", hash_original_method = "F4B649129433C613B63F53B88A8B2BF4", hash_generated_method = "933C0141C63F9DF544BD8DDE35445539")
        public OutputStream newOutputStream(int index) throws IOException {
            OutputStream varB4EAC82CA7396A68D541C85D26508E83_787789898 = null; 
            {
                Object varD933D409C8362D8AB4EAAFB238C186FA_2003913935 = (DiskLruCache.this);
                {
                    {
                        boolean var573C982FD8CE38C80E849A01EADDA5C3_110122017 = (entry.currentEditor != this);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_787789898 = new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(index)));
                } 
            } 
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_787789898.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_787789898;
            
            
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.003 -0400", hash_original_method = "988F125F60B3C088ADDC82562F362884", hash_generated_method = "24AECEBE0C4CC2BF3E6225D06739D04F")
        public void set(int index, String value) throws IOException {
            Writer writer = null;
            try 
            {
                writer = new OutputStreamWriter(newOutputStream(index), Charsets.UTF_8);
                writer.write(value);
            } 
            finally 
            {
                IoUtils.closeQuietly(writer);
            } 
            addTaint(index);
            addTaint(value.getTaint());
            
            
            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.004 -0400", hash_original_method = "14AFCFFFD18B711043FB34122FCD5951", hash_generated_method = "9EED671ED7A999D502C1B859DCAC2D08")
        public void commit() throws IOException {
            {
                completeEdit(this, false);
                remove(entry.key);
            } 
            {
                completeEdit(this, true);
            } 
            
            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.004 -0400", hash_original_method = "805CDF65FA82242C2D4B7EB4CBDDF0ED", hash_generated_method = "18E9660C4426C8AA96D2D812955FA89C")
        public void abort() throws IOException {
            completeEdit(this, false);
            
            
        }

        
        private class FaultHidingOutputStream extends FilterOutputStream {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.005 -0400", hash_original_method = "C9ADDA2E4F72C2E9295822BCBAC6927F", hash_generated_method = "F98AAD1DAF9C62BF5BF1780FA95F6862")
            private  FaultHidingOutputStream(OutputStream out) {
                super(out);
                addTaint(out.getTaint());
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.005 -0400", hash_original_method = "99CEE7897D6B59DCCBF2A9FD6D32C932", hash_generated_method = "E6417635BE2B5EFEB4355F91D7AAE6D0")
            @Override
            public void write(int oneByte) {
                try 
                {
                    out.write(oneByte);
                } 
                catch (IOException e)
                {
                    hasErrors = true;
                } 
                addTaint(oneByte);
                
                
                    
                
                    
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.006 -0400", hash_original_method = "192A1A5EAAE398CB5AAE810F931045A8", hash_generated_method = "EC6CD5E768BDBC7F8E25C9FCF8999B57")
            @Override
            public void write(byte[] buffer, int offset, int length) {
                try 
                {
                    out.write(buffer, offset, length);
                } 
                catch (IOException e)
                {
                    hasErrors = true;
                } 
                addTaint(buffer[0]);
                addTaint(offset);
                addTaint(length);
                
                
                    
                
                    
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.007 -0400", hash_original_method = "F955A307858660E97C305258EF6CF319", hash_generated_method = "F2133F1077411290DFB38A2C3168295F")
            @Override
            public void close() {
                try 
                {
                    out.close();
                } 
                catch (IOException e)
                {
                    hasErrors = true;
                } 
                
                
                    
                
                    
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.007 -0400", hash_original_method = "A7144C313F2BBCA14DD174D533CF0C30", hash_generated_method = "23B6E4BC95BEBC7C193269573D6E6B52")
            @Override
            public void flush() {
                try 
                {
                    out.flush();
                } 
                catch (IOException e)
                {
                    hasErrors = true;
                } 
                
                
                    
                
                    
                
            }

            
        }


        
    }


    
    private final class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.008 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")

        private String key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.008 -0400", hash_original_field = "1E3F5C7322090A6DD464EC8E7BF19C04", hash_generated_field = "47E38F001ED3E4E2BB8D4D488C8C03FF")

        private long[] lengths;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.008 -0400", hash_original_field = "500F1C435067A26384C6B38F464DA461", hash_generated_field = "1948B1A97D5C03C3163AE2F5DE57C5D5")

        private boolean readable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.008 -0400", hash_original_field = "98A0346B30924377CBA028D7A3002904", hash_generated_field = "42500C0BD0D534C6B3B5904249FFA61F")

        private Editor currentEditor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.008 -0400", hash_original_method = "A48AD7F9473C4832EA43939DE55B0830", hash_generated_method = "05E015F56AEE62FCB3C094123AFDB03C")
        private  Entry(String key) {
            this.key = key;
            this.lengths = new long[valueCount];
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.014 -0400", hash_original_method = "5393AA568299AD2184B5004B9545BCCA", hash_generated_method = "2C106F860D1DA54837178FB3CDE55D44")
        public String getLengths() throws IOException {
            String varB4EAC82CA7396A68D541C85D26508E83_1875756394 = null; 
            StringBuilder result = new StringBuilder();
            {
                long size = lengths[0];
                {
                    result.append(' ').append(size);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1875756394 = result.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1875756394.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1875756394;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.015 -0400", hash_original_method = "38ABC3E1459516CB332E39C8B303294B", hash_generated_method = "EF3AD5A5929D11F76067CACEBF7B647E")
        private void setLengths(String[] strings) throws IOException {
            {
                if (DroidSafeAndroidRuntime.control) throw invalidLengths(strings);
            } 
            try 
            {
                {
                    int i = 0;
                    {
                        lengths[i] = Long.parseLong(strings[i]);
                    } 
                } 
            } 
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw invalidLengths(strings);
            } 
            
            
                
            
            
                
                    
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.017 -0400", hash_original_method = "0EB1B022FC0EF6548A3015E3FEB332B5", hash_generated_method = "D6244078B0DF0446716611B264ECFCE5")
        private IOException invalidLengths(String[] strings) throws IOException {
        	throw new IOException("unexpected journal line: " + Arrays.toString(strings));
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.018 -0400", hash_original_method = "C9A2E947DD05DC3D51A797932ED86E55", hash_generated_method = "2AC9E43CB25E464DFEC2EFE58E0C48FB")
        public File getCleanFile(int i) {
            File varB4EAC82CA7396A68D541C85D26508E83_1177683028 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1177683028 = new File(directory, key + "." + i);
            addTaint(i);
            varB4EAC82CA7396A68D541C85D26508E83_1177683028.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1177683028;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.020 -0400", hash_original_method = "7E5BF4AC0CC24327CE09DE834205313B", hash_generated_method = "4CF6A1464E95DB71AADA82E42F265679")
        public File getDirtyFile(int i) {
            File varB4EAC82CA7396A68D541C85D26508E83_894510302 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_894510302 = new File(directory, key + "." + i + ".tmp");
            addTaint(i);
            varB4EAC82CA7396A68D541C85D26508E83_894510302.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_894510302;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.020 -0400", hash_original_field = "146ED4CC80494753D64EC5514BA90594", hash_generated_field = "4A1FFB11CFC6DEB101BE09CC3B4A0541")

    static final String JOURNAL_FILE = "journal";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.020 -0400", hash_original_field = "C27E2248B4DB333CA96F806C864197D7", hash_generated_field = "034EDD0C46E4A8371CCBF6D7FC648A4E")

    static final String JOURNAL_FILE_TMP = "journal.tmp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.020 -0400", hash_original_field = "DCC6B9D3CD10ED22CE2DA8E60C5BBFAD", hash_generated_field = "7D7E4E3F80D7739D5851F7B7CC9C9753")

    static final String MAGIC = "libcore.io.DiskLruCache";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.020 -0400", hash_original_field = "9124F0C1C3587C09E0039D7D03AD14E2", hash_generated_field = "E6DA46912A3A699E1E1BB91060E2E20A")

    static final String VERSION_1 = "1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.020 -0400", hash_original_field = "3B53DD8A00AAB81F06315EA2FA729D53", hash_generated_field = "399C7FB289276D622822E90E2F5602EA")

    private static final String CLEAN = "CLEAN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.020 -0400", hash_original_field = "0C80AB04C9B771FF3F039B09E1467C17", hash_generated_field = "C6523E18AE66B1D3E17A856E3BCCD799")

    private static final String DIRTY = "DIRTY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.020 -0400", hash_original_field = "AAB7977E77FA1610AC8C247D28DD545D", hash_generated_field = "E0988763D8BB4983637AED5C39DA025C")

    private static final String REMOVE = "REMOVE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.020 -0400", hash_original_field = "01B61ABD16813F4E0DA1FA6793E11958", hash_generated_field = "EDF0809706A7034445A48D4182705933")

    private static final String READ = "READ";
}

