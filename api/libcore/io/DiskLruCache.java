package libcore.io;

// Droidsafe Imports
import droidsafe.annotations.*;
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





import droidsafe.runtime.DroidSafeAndroidRuntime;

public final class DiskLruCache implements Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.117 -0400", hash_original_field = "5F8F22B8CDBAEEE8CF857673A9B6BA20", hash_generated_field = "8B0860249151DE823C54467CC9BADB3F")

    private File directory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.117 -0400", hash_original_field = "3C3C73781D3DE0858A20A84F8FE7A498", hash_generated_field = "C3DAA1E42AD1B9E8800013507C6A05F9")

    private File journalFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.118 -0400", hash_original_field = "BBEFE2C36653C86E334A0DB0A7D1D2DE", hash_generated_field = "E459709269D427C9CB1CBD686B5A13E5")

    private File journalFileTmp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.118 -0400", hash_original_field = "B64C136408BBB80DFA6717A62D239726", hash_generated_field = "DEE2522BB7DF04F0B0954F3014F259F5")

    private int appVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.118 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "736713EBDB43EC0678FF4084C276D4A3")

    private long maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.118 -0400", hash_original_field = "A30C57CC28770178EAB167BF0B932032", hash_generated_field = "37330B5F0FE12E195B061FFDF29F478E")

    private int valueCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.118 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "93F7705D696C1DC0669B611BBCDF6959")

    private long size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.118 -0400", hash_original_field = "9CB65621E620C7F32CB54AA3C3BED0D0", hash_generated_field = "6BA9D6A677DAD8E6F256134E2B68A280")

    private Writer journalWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.118 -0400", hash_original_field = "FBBC54FAC485F995EAA3AEC039F91CB6", hash_generated_field = "D4AEF12769A5EC9F5F72F388FEBC72A2")

    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<String, Entry>(0, 0.75f, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.118 -0400", hash_original_field = "ACF4170A74586A81D52591B8F18C89F4", hash_generated_field = "6E19F0863A5F1F61C505FBB71E78DAA1")

    private int redundantOpCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.118 -0400", hash_original_field = "7893561B06784847101FF1A4FE94844D", hash_generated_field = "D542EB48AB8E08A6131DD420815BF0BD")

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
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.119 -0400", hash_original_method = "F7C5B739E468E97586605C521F3C2B42", hash_generated_method = "72D38F4B2DCD8001D35CBA47221BB3AF")
    private  DiskLruCache(File directory, int appVersion, int valueCount, long maxSize) {
        this.directory = directory;
        this.appVersion = appVersion;
        this.journalFile = new File(directory, JOURNAL_FILE);
        this.journalFileTmp = new File(directory, JOURNAL_FILE_TMP);
        this.valueCount = valueCount;
        this.maxSize = maxSize;
        // ---------- Original Method ----------
        //this.directory = directory;
        //this.appVersion = appVersion;
        //this.journalFile = new File(directory, JOURNAL_FILE);
        //this.journalFileTmp = new File(directory, JOURNAL_FILE_TMP);
        //this.valueCount = valueCount;
        //this.maxSize = maxSize;
    }

    
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.120 -0400", hash_original_method = "D80881F7E6F2A63F9AF02A98171F075C", hash_generated_method = "6ACED7D538ACA2E9CC18E83658E9CA99")
    private void readJournal() throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(journalFile));
        try 
        {
            String magic = Streams.readAsciiLine(in);
            String version = Streams.readAsciiLine(in);
            String appVersionString = Streams.readAsciiLine(in);
            String valueCountString = Streams.readAsciiLine(in);
            String blank = Streams.readAsciiLine(in);
            if(!MAGIC.equals(magic)
                    || !VERSION_1.equals(version)
                    || !Integer.toString(appVersion).equals(appVersionString)
                    || !Integer.toString(valueCount).equals(valueCountString)
                    || !"".equals(blank))            
            {
                IOException varC35D68F5D6D27CE14683BFD393F15A76_1854036857 = new IOException("unexpected journal header: ["
                        + magic + ", " + version + ", " + valueCountString + ", " + blank + "]");
                varC35D68F5D6D27CE14683BFD393F15A76_1854036857.addTaint(taint);
                throw varC35D68F5D6D27CE14683BFD393F15A76_1854036857;
            } //End block
            while
(true)            
            {
                try 
                {
                    readJournalLine(Streams.readAsciiLine(in));
                } //End block
                catch (EOFException endOfJournal)
                {
                    break;
                } //End block
            } //End block
        } //End block
        finally 
        {
            IoUtils.closeQuietly(in);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.121 -0400", hash_original_method = "B93033832384BE0A8F735535A303EB51", hash_generated_method = "A16073A35CB5D7C41F36C5F959E27A66")
    private void readJournalLine(String line) throws IOException {
        addTaint(line.getTaint());
        String[] parts = line.split(" ");
        if(parts.length < 2)        
        {
            IOException varC3F04662EE0ABADDB170B82F1DEA0AED_1882570368 = new IOException("unexpected journal line: " + line);
            varC3F04662EE0ABADDB170B82F1DEA0AED_1882570368.addTaint(taint);
            throw varC3F04662EE0ABADDB170B82F1DEA0AED_1882570368;
        } //End block
        String key = parts[1];
        if(parts[0].equals(REMOVE) && parts.length == 2)        
        {
            lruEntries.remove(key);
            return;
        } //End block
        Entry entry = lruEntries.get(key);
        if(entry == null)        
        {
            entry = new Entry(key);
            lruEntries.put(key, entry);
        } //End block
        if(parts[0].equals(CLEAN) && parts.length == 2 + valueCount)        
        {
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(Arrays.copyOfRange(parts, 2, parts.length));
        } //End block
        else
        if(parts[0].equals(DIRTY) && parts.length == 2)        
        {
            entry.currentEditor = new Editor(entry);
        } //End block
        else
        if(parts[0].equals(READ) && parts.length == 2)        
        {
        } //End block
        else
        {
            IOException varC3F04662EE0ABADDB170B82F1DEA0AED_1082348578 = new IOException("unexpected journal line: " + line);
            varC3F04662EE0ABADDB170B82F1DEA0AED_1082348578.addTaint(taint);
            throw varC3F04662EE0ABADDB170B82F1DEA0AED_1082348578;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.122 -0400", hash_original_method = "BF29FD79336E7D0F2752A5C16F704FCA", hash_generated_method = "406736370DCD549C6608698821B70623")
    private void processJournal() throws IOException {
        deleteIfExists(journalFileTmp);
for(Iterator<Entry> i = lruEntries.values().iterator();i.hasNext();)
        {
            Entry entry = i.next();
            if(entry.currentEditor == null)            
            {
for(int t = 0;t < valueCount;t++)
                {
                    size += entry.lengths[t];
                } //End block
            } //End block
            else
            {
                entry.currentEditor = null;
for(int t = 0;t < valueCount;t++)
                {
                    deleteIfExists(entry.getCleanFile(t));
                    deleteIfExists(entry.getDirtyFile(t));
                } //End block
                i.remove();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //deleteIfExists(journalFileTmp);
        //for (Iterator<Entry> i = lruEntries.values().iterator(); i.hasNext(); ) {
            //Entry entry = i.next();
            //if (entry.currentEditor == null) {
                //for (int t = 0; t < valueCount; t++) {
                    //size += entry.lengths[t];
                //}
            //} else {
                //entry.currentEditor = null;
                //for (int t = 0; t < valueCount; t++) {
                    //deleteIfExists(entry.getCleanFile(t));
                    //deleteIfExists(entry.getDirtyFile(t));
                //}
                //i.remove();
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.123 -0400", hash_original_method = "CAFF8A7D35D4FC2C6D20C8D2E31B18B9", hash_generated_method = "B9C5FE85B5B7C2C1B3BA383723B89C20")
    private synchronized void rebuildJournal() throws IOException {
        if(journalWriter != null)        
        {
            journalWriter.close();
        } //End block
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
for(Entry entry : lruEntries.values())
        {
            if(entry.currentEditor != null)            
            {
                writer.write(DIRTY + ' ' + entry.key + '\n');
            } //End block
            else
            {
                writer.write(CLEAN + ' ' + entry.key + entry.getLengths() + '\n');
            } //End block
        } //End block
        writer.close();
        journalFileTmp.renameTo(journalFile);
        journalWriter = new BufferedWriter(new FileWriter(journalFile, true));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    private static void deleteIfExists(File file) throws IOException {
        try {
            Libcore.os.remove(file.getPath());
        } catch (ErrnoException errnoException) {
            if (errnoException.errno != OsConstants.ENOENT) {
                throw errnoException.rethrowAsIOException();
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.124 -0400", hash_original_method = "8CCA333E37F6F5C0426A3FC5CE5D4B2E", hash_generated_method = "6DE8EB2F024CA1759D4597D16E98476C")
    public synchronized Snapshot get(String key) throws IOException {
        addTaint(key.getTaint());
        checkNotClosed();
        validateKey(key);
        Entry entry = lruEntries.get(key);
        if(entry == null)        
        {
Snapshot var540C13E9E156B687226421B24F2DF178_2107094803 =             null;
            var540C13E9E156B687226421B24F2DF178_2107094803.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2107094803;
        } //End block
        if(!entry.readable)        
        {
Snapshot var540C13E9E156B687226421B24F2DF178_1065497727 =             null;
            var540C13E9E156B687226421B24F2DF178_1065497727.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1065497727;
        } //End block
        InputStream[] ins = new InputStream[valueCount];
        try 
        {
for(int i = 0;i < valueCount;i++)
            {
                ins[i] = new FileInputStream(entry.getCleanFile(i));
            } //End block
        } //End block
        catch (FileNotFoundException e)
        {
Snapshot var540C13E9E156B687226421B24F2DF178_1791536189 =             null;
            var540C13E9E156B687226421B24F2DF178_1791536189.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1791536189;
        } //End block
        redundantOpCount++;
        journalWriter.append(READ + ' ' + key + '\n');
        if(journalRebuildRequired())        
        {
            executorService.submit(cleanupCallable);
        } //End block
Snapshot var2E6A24A5A6783496DE3A5FF2F4E2D6B9_587946527 =         new Snapshot(ins);
        var2E6A24A5A6783496DE3A5FF2F4E2D6B9_587946527.addTaint(taint);
        return var2E6A24A5A6783496DE3A5FF2F4E2D6B9_587946527;
        // ---------- Original Method ----------
        //checkNotClosed();
        //validateKey(key);
        //Entry entry = lruEntries.get(key);
        //if (entry == null) {
            //return null;
        //}
        //if (!entry.readable) {
            //return null;
        //}
        //InputStream[] ins = new InputStream[valueCount];
        //try {
            //for (int i = 0; i < valueCount; i++) {
                //ins[i] = new FileInputStream(entry.getCleanFile(i));
            //}
        //} catch (FileNotFoundException e) {
            //return null;
        //}
        //redundantOpCount++;
        //journalWriter.append(READ + ' ' + key + '\n');
        //if (journalRebuildRequired()) {
            //executorService.submit(cleanupCallable);
        //}
        //return new Snapshot(ins);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.125 -0400", hash_original_method = "1C8B92160DB309C26801458073B88259", hash_generated_method = "B8E160815B469B78D6D196D40811F474")
    public synchronized Editor edit(String key) throws IOException {
        addTaint(key.getTaint());
        checkNotClosed();
        validateKey(key);
        Entry entry = lruEntries.get(key);
        if(entry == null)        
        {
            entry = new Entry(key);
            lruEntries.put(key, entry);
        } //End block
        else
        if(entry.currentEditor != null)        
        {
Editor var540C13E9E156B687226421B24F2DF178_913070363 =             null;
            var540C13E9E156B687226421B24F2DF178_913070363.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_913070363;
        } //End block
        Editor editor = new Editor(entry);
        entry.currentEditor = editor;
        journalWriter.write(DIRTY + ' ' + key + '\n');
        journalWriter.flush();
Editor varED224B1BF4EAE660E8B6808A4D079108_493951281 =         editor;
        varED224B1BF4EAE660E8B6808A4D079108_493951281.addTaint(taint);
        return varED224B1BF4EAE660E8B6808A4D079108_493951281;
        // ---------- Original Method ----------
        //checkNotClosed();
        //validateKey(key);
        //Entry entry = lruEntries.get(key);
        //if (entry == null) {
            //entry = new Entry(key);
            //lruEntries.put(key, entry);
        //} else if (entry.currentEditor != null) {
            //return null;
        //}
        //Editor editor = new Editor(entry);
        //entry.currentEditor = editor;
        //journalWriter.write(DIRTY + ' ' + key + '\n');
        //journalWriter.flush();
        //return editor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.126 -0400", hash_original_method = "0F452AFCA1F8F7ACF1A711B33CB47BDA", hash_generated_method = "12391213987B690640A8786AFDE08B94")
    public File getDirectory() {
File varC39D8F3C6A92AA6D50DA32871B590FE5_1151946875 =         directory;
        varC39D8F3C6A92AA6D50DA32871B590FE5_1151946875.addTaint(taint);
        return varC39D8F3C6A92AA6D50DA32871B590FE5_1151946875;
        // ---------- Original Method ----------
        //return directory;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.126 -0400", hash_original_method = "4A03A0F188DC0124026C9315925210D3", hash_generated_method = "856C189775A3BB1F3C63623CBD50B836")
    public long maxSize() {
        long varB78E1120B12ABD7215D67324FE9476FF_1642698007 = (maxSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_375479961 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_375479961;
        // ---------- Original Method ----------
        //return maxSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.126 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "C0E4A8D5CCB3F2874B866E5416D3B76E")
    public synchronized long size() {
        long varF7BD60B75B29D79B660A2859395C1A24_1615008408 = (size);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1990401498 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1990401498;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.127 -0400", hash_original_method = "E3B5F5B6DB82C9D68E2AD58524FD46D2", hash_generated_method = "A54FB696560B72B8131E9B6721B15E86")
    private synchronized void completeEdit(Editor editor, boolean success) throws IOException {
        addTaint(success);
        addTaint(editor.getTaint());
        Entry entry = editor.entry;
        if(entry.currentEditor != editor)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_612892388 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_612892388.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_612892388;
        } //End block
        if(success && !entry.readable)        
        {
for(int i = 0;i < valueCount;i++)
            {
                if(!entry.getDirtyFile(i).exists())                
                {
                    editor.abort();
                    IllegalStateException var4B857C66166436824D960C1259A1506D_658803976 = new IllegalStateException("edit didn't create file " + i);
                    var4B857C66166436824D960C1259A1506D_658803976.addTaint(taint);
                    throw var4B857C66166436824D960C1259A1506D_658803976;
                } //End block
            } //End block
        } //End block
for(int i = 0;i < valueCount;i++)
        {
            File dirty = entry.getDirtyFile(i);
            if(success)            
            {
                if(dirty.exists())                
                {
                    File clean = entry.getCleanFile(i);
                    dirty.renameTo(clean);
                    long oldLength = entry.lengths[i];
                    long newLength = clean.length();
                    entry.lengths[i] = newLength;
                    size = size - oldLength + newLength;
                } //End block
            } //End block
            else
            {
                deleteIfExists(dirty);
            } //End block
        } //End block
        redundantOpCount++;
        entry.currentEditor = null;
        if(entry.readable | success)        
        {
            entry.readable = true;
            journalWriter.write(CLEAN + ' ' + entry.key + entry.getLengths() + '\n');
        } //End block
        else
        {
            lruEntries.remove(entry.key);
            journalWriter.write(REMOVE + ' ' + entry.key + '\n');
        } //End block
        if(size > maxSize || journalRebuildRequired())        
        {
            executorService.submit(cleanupCallable);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.128 -0400", hash_original_method = "BD0CD0940E277CB89BD11D972CAF1EC0", hash_generated_method = "7AF9C2C5DFB6F21C3660A5FAA400910C")
    private boolean journalRebuildRequired() {
        final int REDUNDANT_OP_COMPACT_THRESHOLD = 2000;
        boolean var21E7B7FAFE04F2F7966AE9BDD94DEAEF_1670443134 = (redundantOpCount >= REDUNDANT_OP_COMPACT_THRESHOLD
                && redundantOpCount >= lruEntries.size());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179033314 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_179033314;
        // ---------- Original Method ----------
        //final int REDUNDANT_OP_COMPACT_THRESHOLD = 2000;
        //return redundantOpCount >= REDUNDANT_OP_COMPACT_THRESHOLD
                //&& redundantOpCount >= lruEntries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.129 -0400", hash_original_method = "EADC8C19CC119124A893E81F5BBBE260", hash_generated_method = "7783B9BCB05DD027E2636DA30A8E444A")
    public synchronized boolean remove(String key) throws IOException {
        addTaint(key.getTaint());
        checkNotClosed();
        validateKey(key);
        Entry entry = lruEntries.get(key);
        if(entry == null || entry.currentEditor != null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1486081608 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583306360 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_583306360;
        } //End block
for(int i = 0;i < valueCount;i++)
        {
            File file = entry.getCleanFile(i);
            if(!file.delete())            
            {
                IOException varC14CC3D34FCD5B2EBA65BAA3A90CE992_1813668264 = new IOException("failed to delete " + file);
                varC14CC3D34FCD5B2EBA65BAA3A90CE992_1813668264.addTaint(taint);
                throw varC14CC3D34FCD5B2EBA65BAA3A90CE992_1813668264;
            } //End block
            size -= entry.lengths[i];
            entry.lengths[i] = 0;
        } //End block
        redundantOpCount++;
        journalWriter.append(REMOVE + ' ' + key + '\n');
        lruEntries.remove(key);
        if(journalRebuildRequired())        
        {
            executorService.submit(cleanupCallable);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1607202403 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1552808261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1552808261;
        // ---------- Original Method ----------
        //checkNotClosed();
        //validateKey(key);
        //Entry entry = lruEntries.get(key);
        //if (entry == null || entry.currentEditor != null) {
            //return false;
        //}
        //for (int i = 0; i < valueCount; i++) {
            //File file = entry.getCleanFile(i);
            //if (!file.delete()) {
                //throw new IOException("failed to delete " + file);
            //}
            //size -= entry.lengths[i];
            //entry.lengths[i] = 0;
        //}
        //redundantOpCount++;
        //journalWriter.append(REMOVE + ' ' + key + '\n');
        //lruEntries.remove(key);
        //if (journalRebuildRequired()) {
            //executorService.submit(cleanupCallable);
        //}
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.129 -0400", hash_original_method = "DD17EBB3E7F8098B41E8CF3D3DB045E0", hash_generated_method = "754D88A06C3C7B2ED9F298B430D6380A")
    public boolean isClosed() {
        boolean var3949878E9780388AD98891E1C4F733E8_1397890187 = (journalWriter == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573798823 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_573798823;
        // ---------- Original Method ----------
        //return journalWriter == null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.130 -0400", hash_original_method = "8ED19EB33A6AB2822DDF1831EB4A2E5C", hash_generated_method = "9D1085ED3074E14EF36377742E37F68E")
    private void checkNotClosed() {
        if(journalWriter == null)        
        {
            IllegalStateException var81363B0B86AC9F3301E01A021D394B25_581746068 = new IllegalStateException("cache is closed");
            var81363B0B86AC9F3301E01A021D394B25_581746068.addTaint(taint);
            throw var81363B0B86AC9F3301E01A021D394B25_581746068;
        } //End block
        // ---------- Original Method ----------
        //if (journalWriter == null) {
            //throw new IllegalStateException("cache is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.130 -0400", hash_original_method = "329F096E2383A78FF3370B422D55028D", hash_generated_method = "365B35FA4F8864C12CD2EC6688A56CBE")
    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        journalWriter.flush();
        // ---------- Original Method ----------
        //checkNotClosed();
        //trimToSize();
        //journalWriter.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.130 -0400", hash_original_method = "99CE1AB60FDF93828647C541E1949F71", hash_generated_method = "A222B13FE28773C94093F5384EA144CA")
    public synchronized void close() throws IOException {
        if(journalWriter == null)        
        {
            return;
        } //End block
for(Entry entry : new ArrayList<Entry>(lruEntries.values()))
        {
            if(entry.currentEditor != null)            
            {
                entry.currentEditor.abort();
            } //End block
        } //End block
        trimToSize();
        journalWriter.close();
        journalWriter = null;
        // ---------- Original Method ----------
        //if (journalWriter == null) {
            //return; 
        //}
        //for (Entry entry : new ArrayList<Entry>(lruEntries.values())) {
            //if (entry.currentEditor != null) {
                //entry.currentEditor.abort();
            //}
        //}
        //trimToSize();
        //journalWriter.close();
        //journalWriter = null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.130 -0400", hash_original_method = "52FB98FFFDCED62623018A96063CC5F4", hash_generated_method = "A2A58E9D063E53AD305845CB909F34E7")
    private void trimToSize() throws IOException {
        while
(size > maxSize)        
        {
            Map.Entry<String, Entry> toEvict = lruEntries.eldest();
            remove(toEvict.getKey());
        } //End block
        // ---------- Original Method ----------
        //while (size > maxSize) {
            //Map.Entry<String, Entry> toEvict = lruEntries.eldest();
            //remove(toEvict.getKey());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.131 -0400", hash_original_method = "E0DF0E5E95BB69DC7E72889656D60AB7", hash_generated_method = "40601D48395A0FDE4DC088AFE1B7872C")
    public void delete() throws IOException {
        close();
        IoUtils.deleteContents(directory);
        // ---------- Original Method ----------
        //close();
        //IoUtils.deleteContents(directory);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.131 -0400", hash_original_method = "A6AB05B3A3783BAC84CED8DCEEB398D1", hash_generated_method = "58087C611631064837E6C57FEDEDA6C1")
    private void validateKey(String key) {
        addTaint(key.getTaint());
        if(key.contains(" ") || key.contains("\n") || key.contains("\r"))        
        {
            IllegalArgumentException varC927715DFE1C8EC965D5482F3ED0DC97_513795888 = new IllegalArgumentException(
                    "keys must not contain spaces or newlines: \"" + key + "\"");
            varC927715DFE1C8EC965D5482F3ED0DC97_513795888.addTaint(taint);
            throw varC927715DFE1C8EC965D5482F3ED0DC97_513795888;
        } //End block
        // ---------- Original Method ----------
        //if (key.contains(" ") || key.contains("\n") || key.contains("\r")) {
            //throw new IllegalArgumentException(
                    //"keys must not contain spaces or newlines: \"" + key + "\"");
        //}
    }

    
    @DSModeled(DSC.BAN)
    private static String inputStreamToString(InputStream in) throws IOException {
        return Streams.readFully(new InputStreamReader(in, Charsets.UTF_8));
    }

    
    public static final class Snapshot implements Closeable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.131 -0400", hash_original_field = "CDF1E220D89C2DCD2E000C3D105BF93E", hash_generated_field = "464EF7B473F9CC85C5904899BBCD6B8E")

        private InputStream[] ins;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.132 -0400", hash_original_method = "4874F99779A0A237419F7A04515D002C", hash_generated_method = "6FEE8A1DE88E19521460185A59EEAE25")
        private  Snapshot(InputStream[] ins) {
            this.ins = ins;
            // ---------- Original Method ----------
            //this.ins = ins;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.132 -0400", hash_original_method = "1265F3570693D55B3F128D89D3B629D2", hash_generated_method = "6C7998E3BC3317B4B6D1AA82E0A2A63C")
        public InputStream getInputStream(int index) {
            addTaint(index);
InputStream varC45F03A74031CF4889702A14392A5C83_610970306 =             ins[index];
            varC45F03A74031CF4889702A14392A5C83_610970306.addTaint(taint);
            return varC45F03A74031CF4889702A14392A5C83_610970306;
            // ---------- Original Method ----------
            //return ins[index];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.132 -0400", hash_original_method = "CEACA6862DFE49E3BCD1DEF39CCE35B7", hash_generated_method = "5F366E77E90663344BFDD4EF4BBDAEA3")
        public String getString(int index) throws IOException {
            addTaint(index);
String varE654D4C5349C8662FD22088D3274B26B_343760868 =             inputStreamToString(getInputStream(index));
            varE654D4C5349C8662FD22088D3274B26B_343760868.addTaint(taint);
            return varE654D4C5349C8662FD22088D3274B26B_343760868;
            // ---------- Original Method ----------
            //return inputStreamToString(getInputStream(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.132 -0400", hash_original_method = "ECD6C2B86E4C6B719F1F8B8AE3B1A8FC", hash_generated_method = "7642E67ABB1D1A421EC2BD66ABE043D5")
        @Override
        public void close() {
for(InputStream in : ins)
            {
                IoUtils.closeQuietly(in);
            } //End block
            // ---------- Original Method ----------
            //for (InputStream in : ins) {
                //IoUtils.closeQuietly(in);
            //}
        }

        
    }


    
    public final class Editor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.133 -0400", hash_original_field = "1043BFC77FEBE75FAFEC0C4309FACCF1", hash_generated_field = "70C4CB2BDA836A091A18885840DD6AFF")

        private Entry entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.133 -0400", hash_original_field = "9308EF711245F4213A779903B194F396", hash_generated_field = "801DA5B7CFF4CA64DD2686B1718833F3")

        private boolean hasErrors;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.133 -0400", hash_original_method = "DB0A9ACC8813DA2FB44F6FFEC09E8772", hash_generated_method = "9D5F2E1BFEBBC34BED7AEE5B243CB69C")
        private  Editor(Entry entry) {
            this.entry = entry;
            // ---------- Original Method ----------
            //this.entry = entry;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.134 -0400", hash_original_method = "E20ADC2C4905CE726058A12470A98795", hash_generated_method = "6DB8C8BE6FA668BC489E3671B323612E")
        public InputStream newInputStream(int index) throws IOException {
            addTaint(index);
            synchronized
(DiskLruCache.this)            {
                if(entry.currentEditor != this)                
                {
                    IllegalStateException varC311A989A119B96A6232C22ABFE87C25_7720879 = new IllegalStateException();
                    varC311A989A119B96A6232C22ABFE87C25_7720879.addTaint(taint);
                    throw varC311A989A119B96A6232C22ABFE87C25_7720879;
                } //End block
                if(!entry.readable)                
                {
InputStream var540C13E9E156B687226421B24F2DF178_1030976554 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1030976554.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1030976554;
                } //End block
InputStream var975B4CCB8B52229009977C881C3B9BC4_1363929824 =                 new FileInputStream(entry.getCleanFile(index));
                var975B4CCB8B52229009977C881C3B9BC4_1363929824.addTaint(taint);
                return var975B4CCB8B52229009977C881C3B9BC4_1363929824;
            } //End block
            // ---------- Original Method ----------
            //synchronized (DiskLruCache.this) {
                //if (entry.currentEditor != this) {
                    //throw new IllegalStateException();
                //}
                //if (!entry.readable) {
                    //return null;
                //}
                //return new FileInputStream(entry.getCleanFile(index));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.135 -0400", hash_original_method = "84B73985D87B7C97991726C0644B80BD", hash_generated_method = "360C78055BAFA9E5AD56AAC09F114CF1")
        public String getString(int index) throws IOException {
            addTaint(index);
            InputStream in = newInputStream(index);
String var47389769C317BA546AE73EC662DDC910_364607937 =             in != null ? inputStreamToString(in) : null;
            var47389769C317BA546AE73EC662DDC910_364607937.addTaint(taint);
            return var47389769C317BA546AE73EC662DDC910_364607937;
            // ---------- Original Method ----------
            //InputStream in = newInputStream(index);
            //return in != null ? inputStreamToString(in) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.135 -0400", hash_original_method = "F4B649129433C613B63F53B88A8B2BF4", hash_generated_method = "449C5A78C8C558BCADB5C2BB260991CE")
        public OutputStream newOutputStream(int index) throws IOException {
            addTaint(index);
            synchronized
(DiskLruCache.this)            {
                if(entry.currentEditor != this)                
                {
                    IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1261661015 = new IllegalStateException();
                    varC311A989A119B96A6232C22ABFE87C25_1261661015.addTaint(taint);
                    throw varC311A989A119B96A6232C22ABFE87C25_1261661015;
                } //End block
OutputStream varFEF8625C9D868CFC33D7262DD51E8F60_1135161712 =                 new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(index)));
                varFEF8625C9D868CFC33D7262DD51E8F60_1135161712.addTaint(taint);
                return varFEF8625C9D868CFC33D7262DD51E8F60_1135161712;
            } //End block
            // ---------- Original Method ----------
            //synchronized (DiskLruCache.this) {
                //if (entry.currentEditor != this) {
                    //throw new IllegalStateException();
                //}
                //return new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(index)));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.136 -0400", hash_original_method = "988F125F60B3C088ADDC82562F362884", hash_generated_method = "05A987E9B9AE834E405844CB57C71937")
        public void set(int index, String value) throws IOException {
            addTaint(value.getTaint());
            addTaint(index);
            Writer writer = null;
            try 
            {
                writer = new OutputStreamWriter(newOutputStream(index), Charsets.UTF_8);
                writer.write(value);
            } //End block
            finally 
            {
                IoUtils.closeQuietly(writer);
            } //End block
            // ---------- Original Method ----------
            //Writer writer = null;
            //try {
                //writer = new OutputStreamWriter(newOutputStream(index), Charsets.UTF_8);
                //writer.write(value);
            //} finally {
                //IoUtils.closeQuietly(writer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.137 -0400", hash_original_method = "14AFCFFFD18B711043FB34122FCD5951", hash_generated_method = "DF8B68DE7D97A85A6069AEF7EBD6D851")
        public void commit() throws IOException {
            if(hasErrors)            
            {
                completeEdit(this, false);
                remove(entry.key);
            } //End block
            else
            {
                completeEdit(this, true);
            } //End block
            // ---------- Original Method ----------
            //if (hasErrors) {
                //completeEdit(this, false);
                //remove(entry.key); 
            //} else {
                //completeEdit(this, true);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.137 -0400", hash_original_method = "805CDF65FA82242C2D4B7EB4CBDDF0ED", hash_generated_method = "18E9660C4426C8AA96D2D812955FA89C")
        public void abort() throws IOException {
            completeEdit(this, false);
            // ---------- Original Method ----------
            //completeEdit(this, false);
        }

        
        private class FaultHidingOutputStream extends FilterOutputStream {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.137 -0400", hash_original_method = "C9ADDA2E4F72C2E9295822BCBAC6927F", hash_generated_method = "F98AAD1DAF9C62BF5BF1780FA95F6862")
            private  FaultHidingOutputStream(OutputStream out) {
                super(out);
                addTaint(out.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.137 -0400", hash_original_method = "99CEE7897D6B59DCCBF2A9FD6D32C932", hash_generated_method = "DE19E823FA6CCC761385FD460C2684C6")
            @Override
            public void write(int oneByte) {
                addTaint(oneByte);
                try 
                {
                    out.write(oneByte);
                } //End block
                catch (IOException e)
                {
                    hasErrors = true;
                } //End block
                // ---------- Original Method ----------
                //try {
                    //out.write(oneByte);
                //} catch (IOException e) {
                    //hasErrors = true;
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.138 -0400", hash_original_method = "192A1A5EAAE398CB5AAE810F931045A8", hash_generated_method = "12D1BF532D80010F5DC64C8AE15D6599")
            @Override
            public void write(byte[] buffer, int offset, int length) {
                addTaint(length);
                addTaint(offset);
                addTaint(buffer[0]);
                try 
                {
                    out.write(buffer, offset, length);
                } //End block
                catch (IOException e)
                {
                    hasErrors = true;
                } //End block
                // ---------- Original Method ----------
                //try {
                    //out.write(buffer, offset, length);
                //} catch (IOException e) {
                    //hasErrors = true;
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.138 -0400", hash_original_method = "F955A307858660E97C305258EF6CF319", hash_generated_method = "F2133F1077411290DFB38A2C3168295F")
            @Override
            public void close() {
                try 
                {
                    out.close();
                } //End block
                catch (IOException e)
                {
                    hasErrors = true;
                } //End block
                // ---------- Original Method ----------
                //try {
                    //out.close();
                //} catch (IOException e) {
                    //hasErrors = true;
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.138 -0400", hash_original_method = "A7144C313F2BBCA14DD174D533CF0C30", hash_generated_method = "23B6E4BC95BEBC7C193269573D6E6B52")
            @Override
            public void flush() {
                try 
                {
                    out.flush();
                } //End block
                catch (IOException e)
                {
                    hasErrors = true;
                } //End block
                // ---------- Original Method ----------
                //try {
                    //out.flush();
                //} catch (IOException e) {
                    //hasErrors = true;
                //}
            }

            
        }


        
    }


    
    private final class Entry {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.139 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")

        private String key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.139 -0400", hash_original_field = "1E3F5C7322090A6DD464EC8E7BF19C04", hash_generated_field = "47E38F001ED3E4E2BB8D4D488C8C03FF")

        private long[] lengths;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.139 -0400", hash_original_field = "500F1C435067A26384C6B38F464DA461", hash_generated_field = "1948B1A97D5C03C3163AE2F5DE57C5D5")

        private boolean readable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.140 -0400", hash_original_field = "98A0346B30924377CBA028D7A3002904", hash_generated_field = "42500C0BD0D534C6B3B5904249FFA61F")

        private Editor currentEditor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.141 -0400", hash_original_method = "A48AD7F9473C4832EA43939DE55B0830", hash_generated_method = "05E015F56AEE62FCB3C094123AFDB03C")
        private  Entry(String key) {
            this.key = key;
            this.lengths = new long[valueCount];
            // ---------- Original Method ----------
            //this.key = key;
            //this.lengths = new long[valueCount];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.141 -0400", hash_original_method = "5393AA568299AD2184B5004B9545BCCA", hash_generated_method = "66D9618FEDEA66B5933A9743BAE48B06")
        public String getLengths() throws IOException {
            StringBuilder result = new StringBuilder();
for(long size : lengths)
            {
                result.append(' ').append(size);
            } //End block
String varE65B3A02759122992CB82C0E651AD408_1661039038 =             result.toString();
            varE65B3A02759122992CB82C0E651AD408_1661039038.addTaint(taint);
            return varE65B3A02759122992CB82C0E651AD408_1661039038;
            // ---------- Original Method ----------
            //StringBuilder result = new StringBuilder();
            //for (long size : lengths) {
                //result.append(' ').append(size);
            //}
            //return result.toString();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_method = "38ABC3E1459516CB332E39C8B303294B", hash_generated_method = "B0527B792D02482E1708E3F5AE275694")
        private void setLengths(String[] strings) throws IOException {
            if(strings.length != valueCount)            
            {
                java.io.IOException var4527E569A10E43BC1C82DF62A65C0C38_1561408604 = invalidLengths(strings);
                var4527E569A10E43BC1C82DF62A65C0C38_1561408604.addTaint(taint);
                throw var4527E569A10E43BC1C82DF62A65C0C38_1561408604;
            } //End block
            try 
            {
for(int i = 0;i < strings.length;i++)
                {
                    lengths[i] = Long.parseLong(strings[i]);
                } //End block
            } //End block
            catch (NumberFormatException e)
            {
                java.io.IOException var4527E569A10E43BC1C82DF62A65C0C38_1196791231 = invalidLengths(strings);
                var4527E569A10E43BC1C82DF62A65C0C38_1196791231.addTaint(taint);
                throw var4527E569A10E43BC1C82DF62A65C0C38_1196791231;
            } //End block
            // ---------- Original Method ----------
            //if (strings.length != valueCount) {
                //throw invalidLengths(strings);
            //}
            //try {
                //for (int i = 0; i < strings.length; i++) {
                    //lengths[i] = Long.parseLong(strings[i]);
                //}
            //} catch (NumberFormatException e) {
                //throw invalidLengths(strings);
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_method = "0EB1B022FC0EF6548A3015E3FEB332B5", hash_generated_method = "2427E83A0AEB9FEAA8868981718D0A26")
        private IOException invalidLengths(String[] strings) throws IOException {
            addTaint(strings[0].getTaint());
            IOException varEAFD5D8215C36EB816E02163DD374B42_686394809 = new IOException("unexpected journal line: " + Arrays.toString(strings));
            varEAFD5D8215C36EB816E02163DD374B42_686394809.addTaint(taint);
            throw varEAFD5D8215C36EB816E02163DD374B42_686394809;
            // ---------- Original Method ----------
            //throw new IOException("unexpected journal line: " + Arrays.toString(strings));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_method = "C9A2E947DD05DC3D51A797932ED86E55", hash_generated_method = "40F802729F5FF000C59A5692EF3BE1FC")
        public File getCleanFile(int i) {
            addTaint(i);
File var8503B144813FCE392AB3D105B5D1F2B4_1144039771 =             new File(directory, key + "." + i);
            var8503B144813FCE392AB3D105B5D1F2B4_1144039771.addTaint(taint);
            return var8503B144813FCE392AB3D105B5D1F2B4_1144039771;
            // ---------- Original Method ----------
            //return new File(directory, key + "." + i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_method = "7E5BF4AC0CC24327CE09DE834205313B", hash_generated_method = "08CE048F03CD05E5DA62EAD4473C7693")
        public File getDirtyFile(int i) {
            addTaint(i);
File var4B7CD92DA74EBFDCC21EBA188ED9577D_622731316 =             new File(directory, key + "." + i + ".tmp");
            var4B7CD92DA74EBFDCC21EBA188ED9577D_622731316.addTaint(taint);
            return var4B7CD92DA74EBFDCC21EBA188ED9577D_622731316;
            // ---------- Original Method ----------
            //return new File(directory, key + "." + i + ".tmp");
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_field = "146ED4CC80494753D64EC5514BA90594", hash_generated_field = "4A1FFB11CFC6DEB101BE09CC3B4A0541")

    static final String JOURNAL_FILE = "journal";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_field = "C27E2248B4DB333CA96F806C864197D7", hash_generated_field = "034EDD0C46E4A8371CCBF6D7FC648A4E")

    static final String JOURNAL_FILE_TMP = "journal.tmp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_field = "DCC6B9D3CD10ED22CE2DA8E60C5BBFAD", hash_generated_field = "7D7E4E3F80D7739D5851F7B7CC9C9753")

    static final String MAGIC = "libcore.io.DiskLruCache";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_field = "9124F0C1C3587C09E0039D7D03AD14E2", hash_generated_field = "E6DA46912A3A699E1E1BB91060E2E20A")

    static final String VERSION_1 = "1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_field = "3B53DD8A00AAB81F06315EA2FA729D53", hash_generated_field = "399C7FB289276D622822E90E2F5602EA")

    private static final String CLEAN = "CLEAN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_field = "0C80AB04C9B771FF3F039B09E1467C17", hash_generated_field = "C6523E18AE66B1D3E17A856E3BCCD799")

    private static final String DIRTY = "DIRTY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_field = "AAB7977E77FA1610AC8C247D28DD545D", hash_generated_field = "E0988763D8BB4983637AED5C39DA025C")

    private static final String REMOVE = "REMOVE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.152 -0400", hash_original_field = "01B61ABD16813F4E0DA1FA6793E11958", hash_generated_field = "EDF0809706A7034445A48D4182705933")

    private static final String READ = "READ";
}

