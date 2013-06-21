package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private File directory;
    private File journalFile;
    private File journalFileTmp;
    private int appVersion;
    private long maxSize;
    private int valueCount;
    private long size = 0;
    private Writer journalWriter;
    private LinkedHashMap<String, Entry> lruEntries
            = new LinkedHashMap<String, Entry>(0, 0.75f, true);
    private int redundantOpCount;
    private ExecutorService executorService = new ThreadPoolExecutor(0, 1,
            60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    private final Callable<Void> cleanupCallable = new Callable<Void>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.841 -0400", hash_original_method = "60CB515F13FCF39FB25B426074E3001D", hash_generated_method = "5BF0E807289F1703ACEAB98AAF98500F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Void call() throws Exception {
            {
                Object varD933D409C8362D8AB4EAAFB238C186FA_2089841871 = (DiskLruCache.this);
                {
                    trimToSize();
                    {
                        boolean varAE772B6A2261513DC630DDE920DDFCB8_1813349129 = (journalRebuildRequired());
                        {
                            rebuildJournal();
                            redundantOpCount = 0;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return (Void)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (DiskLruCache.this) {
                //if (journalWriter == null) {
                    //return null; 
                //}
                //trimToSize();
                //if (journalRebuildRequired()) {
                    //rebuildJournal();
                    //redundantOpCount = 0;
                //}
            //}
            //return null;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.842 -0400", hash_original_method = "F7C5B739E468E97586605C521F3C2B42", hash_generated_method = "2FC7ECB6A536FB27CF12EFFCC36CD708")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DiskLruCache(File directory, int appVersion, int valueCount, long maxSize) {
        dsTaint.addTaint(appVersion);
        dsTaint.addTaint(directory.dsTaint);
        dsTaint.addTaint(maxSize);
        dsTaint.addTaint(valueCount);
        this.journalFile = new File(directory, JOURNAL_FILE);
        this.journalFileTmp = new File(directory, JOURNAL_FILE_TMP);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.843 -0400", hash_original_method = "D80881F7E6F2A63F9AF02A98171F075C", hash_generated_method = "1324A0A7ED8792B8B255A54C801BA13D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readJournal() throws IOException {
        InputStream in;
        in = new BufferedInputStream(new FileInputStream(journalFile));
        try 
        {
            String magic;
            magic = Streams.readAsciiLine(in);
            String version;
            version = Streams.readAsciiLine(in);
            String appVersionString;
            appVersionString = Streams.readAsciiLine(in);
            String valueCountString;
            valueCountString = Streams.readAsciiLine(in);
            String blank;
            blank = Streams.readAsciiLine(in);
            {
                boolean var3B415B63A46B05254C7463316DBFFFC4_806744755 = (!MAGIC.equals(magic)
                    || !VERSION_1.equals(version)
                    || !Integer.toString(appVersion).equals(appVersionString)
                    || !Integer.toString(valueCount).equals(valueCountString)
                    || !"".equals(blank));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal header: ["
                        + magic + ", " + version + ", " + valueCountString + ", " + blank + "]");
                } //End block
            } //End collapsed parenthetic
            {
                try 
                {
                    readJournalLine(Streams.readAsciiLine(in));
                } //End block
                catch (EOFException endOfJournal)
                { }
            } //End block
        } //End block
        finally 
        {
            IoUtils.closeQuietly(in);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.844 -0400", hash_original_method = "B93033832384BE0A8F735535A303EB51", hash_generated_method = "409C8FFFE1AAF8F6AA4C0B816D3B5E1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readJournalLine(String line) throws IOException {
        dsTaint.addTaint(line);
        String[] parts;
        parts = line.split(" ");
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal line: " + line);
        } //End block
        String key;
        key = parts[1];
        {
            boolean varAEADAED980A3E2CE65A0FB2D397AC4EF_765318215 = (parts[0].equals(REMOVE) && parts.length == 2);
            {
                lruEntries.remove(key);
            } //End block
        } //End collapsed parenthetic
        Entry entry;
        entry = lruEntries.get(key);
        {
            entry = new Entry(key);
            lruEntries.put(key, entry);
        } //End block
        {
            boolean var98DA74BB3A0D1D55A0A2F6F4FB097B6E_1641811650 = (parts[0].equals(CLEAN) && parts.length == 2 + valueCount);
            {
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(Arrays.copyOfRange(parts, 2, parts.length));
            } //End block
            {
                boolean var1A74343163BF8B3C2F48DFA8E158DAA9_43280023 = (parts[0].equals(DIRTY) && parts.length == 2);
                {
                    entry.currentEditor = new Editor(entry);
                } //End block
                {
                    boolean var1B34DE325BCE96DBE7D78DC7688F24C9_1773360384 = (parts[0].equals(READ) && parts.length == 2);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal line: " + line);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.844 -0400", hash_original_method = "BF29FD79336E7D0F2752A5C16F704FCA", hash_generated_method = "3F94AC5FE98DB1E26D39DB15421CA64D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processJournal() throws IOException {
        deleteIfExists(journalFileTmp);
        {
            Iterator<Entry> i;
            i = lruEntries.values().iterator();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_395507913 = (i.hasNext());
            {
                Entry entry;
                entry = i.next();
                {
                    {
                        int t;
                        t = 0;
                        {
                            size += entry.lengths[t];
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    entry.currentEditor = null;
                    {
                        int t;
                        t = 0;
                        {
                            deleteIfExists(entry.getCleanFile(t));
                            deleteIfExists(entry.getDirtyFile(t));
                        } //End block
                    } //End collapsed parenthetic
                    i.remove();
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.850 -0400", hash_original_method = "CAFF8A7D35D4FC2C6D20C8D2E31B18B9", hash_generated_method = "D867505B3A9A6C06319794721E6FBF53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void rebuildJournal() throws IOException {
        {
            journalWriter.close();
        } //End block
        Writer writer;
        writer = new BufferedWriter(new FileWriter(journalFileTmp));
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
            Iterator<Entry> var3FF52ED4E313724F3C65EC6A81752D91_974238509 = (lruEntries.values()).iterator();
            var3FF52ED4E313724F3C65EC6A81752D91_974238509.hasNext();
            Entry entry = var3FF52ED4E313724F3C65EC6A81752D91_974238509.next();
            {
                {
                    writer.write(DIRTY + ' ' + entry.key + '\n');
                } //End block
                {
                    writer.write(CLEAN + ' ' + entry.key + entry.getLengths() + '\n');
                } //End block
            } //End block
        } //End collapsed parenthetic
        writer.close();
        journalFileTmp.renameTo(journalFile);
        journalWriter = new BufferedWriter(new FileWriter(journalFile, true));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void deleteIfExists(File file) throws IOException {
        try {
            Libcore.os.remove(file.getPath());
        } catch (ErrnoException errnoException) {
            if (errnoException.errno != OsConstants.ENOENT) {
                throw errnoException.rethrowAsIOException();
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.851 -0400", hash_original_method = "8CCA333E37F6F5C0426A3FC5CE5D4B2E", hash_generated_method = "B68BFE3D86B7A30EEC743991AA1003B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Snapshot get(String key) throws IOException {
        dsTaint.addTaint(key);
        checkNotClosed();
        validateKey(key);
        Entry entry;
        entry = lruEntries.get(key);
        InputStream[] ins;
        ins = new InputStream[valueCount];
        try 
        {
            {
                int i;
                i = 0;
                {
                    ins[i] = new FileInputStream(entry.getCleanFile(i));
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (FileNotFoundException e)
        { }
        journalWriter.append(READ + ' ' + key + '\n');
        {
            boolean varE9BCC6F78EB13BE042B748E2FA1C8B0F_1275575173 = (journalRebuildRequired());
            {
                executorService.submit(cleanupCallable);
            } //End block
        } //End collapsed parenthetic
        Snapshot var12CB8F7D1AB8CA6DBD2E7F0861BDF8C2_1852843766 = (new Snapshot(ins));
        return (Snapshot)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.851 -0400", hash_original_method = "1C8B92160DB309C26801458073B88259", hash_generated_method = "0BCEF27C75F18723C3ECB5857EADD78B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized Editor edit(String key) throws IOException {
        dsTaint.addTaint(key);
        checkNotClosed();
        validateKey(key);
        Entry entry;
        entry = lruEntries.get(key);
        {
            entry = new Entry(key);
            lruEntries.put(key, entry);
        } //End block
        Editor editor;
        editor = new Editor(entry);
        entry.currentEditor = editor;
        journalWriter.write(DIRTY + ' ' + key + '\n');
        journalWriter.flush();
        return (Editor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.852 -0400", hash_original_method = "0F452AFCA1F8F7ACF1A711B33CB47BDA", hash_generated_method = "8173EE726EE422F04A78ABB1B596F4FF")
    @DSModeled(DSC.SAFE)
    public File getDirectory() {
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return directory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.852 -0400", hash_original_method = "4A03A0F188DC0124026C9315925210D3", hash_generated_method = "C3FE8114DAA2C7A8163741A043DCA9C0")
    @DSModeled(DSC.SAFE)
    public long maxSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return maxSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.852 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "BA2207D3C4A0D7C6B7EE0FBBD4BB2A13")
    @DSModeled(DSC.SAFE)
    public synchronized long size() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.852 -0400", hash_original_method = "E3B5F5B6DB82C9D68E2AD58524FD46D2", hash_generated_method = "C31F2D8349F08FD28A532D82452F82FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void completeEdit(Editor editor, boolean success) throws IOException {
        dsTaint.addTaint(editor.dsTaint);
        dsTaint.addTaint(success);
        Entry entry;
        entry = editor.entry;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    {
                        boolean varFFE5A3C862451CA99201ACFA8DB76116_72978461 = (!entry.getDirtyFile(i).exists());
                        {
                            editor.abort();
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("edit didn't create file " + i);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int i;
            i = 0;
            {
                File dirty;
                dirty = entry.getDirtyFile(i);
                {
                    {
                        boolean var6FE72A42168775380AEE51AF827532B3_1497165165 = (dirty.exists());
                        {
                            File clean;
                            clean = entry.getCleanFile(i);
                            dirty.renameTo(clean);
                            long oldLength;
                            oldLength = entry.lengths[i];
                            long newLength;
                            newLength = clean.length();
                            entry.lengths[i] = newLength;
                            size = size - oldLength + newLength;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    deleteIfExists(dirty);
                } //End block
            } //End block
        } //End collapsed parenthetic
        entry.currentEditor = null;
        {
            entry.readable = true;
            journalWriter.write(CLEAN + ' ' + entry.key + entry.getLengths() + '\n');
        } //End block
        {
            lruEntries.remove(entry.key);
            journalWriter.write(REMOVE + ' ' + entry.key + '\n');
        } //End block
        {
            boolean var776EDFAB12D0A0A4A863963ED3C1C602_1658524985 = (size > maxSize || journalRebuildRequired());
            {
                executorService.submit(cleanupCallable);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.853 -0400", hash_original_method = "BD0CD0940E277CB89BD11D972CAF1EC0", hash_generated_method = "82A3BBD40E78F9AA6DFF0242B54D0D6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean journalRebuildRequired() {
        int REDUNDANT_OP_COMPACT_THRESHOLD;
        REDUNDANT_OP_COMPACT_THRESHOLD = 2000;
        boolean varA8B170D68A257FCB088E560C51B41F6B_756922234 = (redundantOpCount >= REDUNDANT_OP_COMPACT_THRESHOLD
                && redundantOpCount >= lruEntries.size());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int REDUNDANT_OP_COMPACT_THRESHOLD = 2000;
        //return redundantOpCount >= REDUNDANT_OP_COMPACT_THRESHOLD
                //&& redundantOpCount >= lruEntries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.853 -0400", hash_original_method = "EADC8C19CC119124A893E81F5BBBE260", hash_generated_method = "B9070BD6A5F3502C1CE303D25D3B2C75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean remove(String key) throws IOException {
        dsTaint.addTaint(key);
        checkNotClosed();
        validateKey(key);
        Entry entry;
        entry = lruEntries.get(key);
        {
            int i;
            i = 0;
            {
                File file;
                file = entry.getCleanFile(i);
                {
                    boolean var662432ADDD39E82511D634813D6392A6_1666701910 = (!file.delete());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("failed to delete " + file);
                    } //End block
                } //End collapsed parenthetic
                size -= entry.lengths[i];
                entry.lengths[i] = 0;
            } //End block
        } //End collapsed parenthetic
        journalWriter.append(REMOVE + ' ' + key + '\n');
        lruEntries.remove(key);
        {
            boolean varE9BCC6F78EB13BE042B748E2FA1C8B0F_2023102240 = (journalRebuildRequired());
            {
                executorService.submit(cleanupCallable);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.853 -0400", hash_original_method = "DD17EBB3E7F8098B41E8CF3D3DB045E0", hash_generated_method = "3F9AC66227A3629697E26258B1F2139E")
    @DSModeled(DSC.SAFE)
    public boolean isClosed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return journalWriter == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.853 -0400", hash_original_method = "8ED19EB33A6AB2822DDF1831EB4A2E5C", hash_generated_method = "563F58E3136896F1891C3E5166D27E9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("cache is closed");
        } //End block
        // ---------- Original Method ----------
        //if (journalWriter == null) {
            //throw new IllegalStateException("cache is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.854 -0400", hash_original_method = "329F096E2383A78FF3370B422D55028D", hash_generated_method = "365B35FA4F8864C12CD2EC6688A56CBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        journalWriter.flush();
        // ---------- Original Method ----------
        //checkNotClosed();
        //trimToSize();
        //journalWriter.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.856 -0400", hash_original_method = "99CE1AB60FDF93828647C541E1949F71", hash_generated_method = "468B8BEDC308FD1483C957CDF505906A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void close() throws IOException {
        {
            Iterator<Entry> varA079903352D454BE94CBDC004A76A873_1342322922 = (new ArrayList<Entry>(lruEntries.values())).iterator();
            varA079903352D454BE94CBDC004A76A873_1342322922.hasNext();
            Entry entry = varA079903352D454BE94CBDC004A76A873_1342322922.next();
            {
                {
                    entry.currentEditor.abort();
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.857 -0400", hash_original_method = "52FB98FFFDCED62623018A96063CC5F4", hash_generated_method = "EFE2DBF6BEF52CA87CD9CFD0A6216A15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void trimToSize() throws IOException {
        {
            Map.Entry<String, Entry> toEvict;
            toEvict = lruEntries.eldest();
            remove(toEvict.getKey());
        } //End block
        // ---------- Original Method ----------
        //while (size > maxSize) {
            //Map.Entry<String, Entry> toEvict = lruEntries.eldest();
            //remove(toEvict.getKey());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.857 -0400", hash_original_method = "E0DF0E5E95BB69DC7E72889656D60AB7", hash_generated_method = "40601D48395A0FDE4DC088AFE1B7872C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void delete() throws IOException {
        close();
        IoUtils.deleteContents(directory);
        // ---------- Original Method ----------
        //close();
        //IoUtils.deleteContents(directory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.857 -0400", hash_original_method = "A6AB05B3A3783BAC84CED8DCEEB398D1", hash_generated_method = "857E70BBD5B0B0502EEF2A2C9B912016")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void validateKey(String key) {
        dsTaint.addTaint(key);
        {
            boolean var8C530715B845FC3D79AD68AB30B9FD1A_621617582 = (key.contains(" ") || key.contains("\n") || key.contains("\r"));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "keys must not contain spaces or newlines: \"" + key + "\"");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (key.contains(" ") || key.contains("\n") || key.contains("\r")) {
            //throw new IllegalArgumentException(
                    //"keys must not contain spaces or newlines: \"" + key + "\"");
        //}
    }

    
        private static String inputStreamToString(InputStream in) throws IOException {
        return Streams.readFully(new InputStreamReader(in, Charsets.UTF_8));
    }

    
    public static final class Snapshot implements Closeable {
        private InputStream[] ins;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.857 -0400", hash_original_method = "4874F99779A0A237419F7A04515D002C", hash_generated_method = "05DA22AD82A3A8EDB03F3369C46385C8")
        @DSModeled(DSC.SAFE)
        private Snapshot(InputStream[] ins) {
            dsTaint.addTaint(ins[0].dsTaint);
            // ---------- Original Method ----------
            //this.ins = ins;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.857 -0400", hash_original_method = "1265F3570693D55B3F128D89D3B629D2", hash_generated_method = "414A60B80FE4F402F65EED7967CA6E6F")
        @DSModeled(DSC.SAFE)
        public InputStream getInputStream(int index) {
            dsTaint.addTaint(index);
            return (InputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ins[index];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.858 -0400", hash_original_method = "CEACA6862DFE49E3BCD1DEF39CCE35B7", hash_generated_method = "24CA2C0708DCB774FF53D8C466E46630")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getString(int index) throws IOException {
            dsTaint.addTaint(index);
            String varD9D3E00744989128224729451F9E5570_1106706282 = (inputStreamToString(getInputStream(index)));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return inputStreamToString(getInputStream(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.859 -0400", hash_original_method = "ECD6C2B86E4C6B719F1F8B8AE3B1A8FC", hash_generated_method = "A779C24A2F020752D5F61844458A21BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() {
            {
                InputStream in = ins[0];
                {
                    IoUtils.closeQuietly(in);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (InputStream in : ins) {
                //IoUtils.closeQuietly(in);
            //}
        }

        
    }


    
    public final class Editor {
        private Entry entry;
        private boolean hasErrors;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.860 -0400", hash_original_method = "DB0A9ACC8813DA2FB44F6FFEC09E8772", hash_generated_method = "FC6743A64A2D8A52BE12C3F148AB5723")
        @DSModeled(DSC.SAFE)
        private Editor(Entry entry) {
            dsTaint.addTaint(entry.dsTaint);
            // ---------- Original Method ----------
            //this.entry = entry;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.860 -0400", hash_original_method = "E20ADC2C4905CE726058A12470A98795", hash_generated_method = "B4AEAECC9D53FF11EDABC8A66D806CBE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputStream newInputStream(int index) throws IOException {
            dsTaint.addTaint(index);
            {
                Object varD933D409C8362D8AB4EAAFB238C186FA_1863436819 = (DiskLruCache.this);
                {
                    {
                        boolean var573C982FD8CE38C80E849A01EADDA5C3_1326723735 = (entry.currentEditor != this);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                        } //End block
                    } //End collapsed parenthetic
                    InputStream var148F85FF651052C81A85FA1DA12DF70A_598916005 = (new FileInputStream(entry.getCleanFile(index)));
                } //End block
            } //End collapsed parenthetic
            return (InputStream)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.860 -0400", hash_original_method = "84B73985D87B7C97991726C0644B80BD", hash_generated_method = "F767B9F3054FB7CE6C9278A29730E55D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getString(int index) throws IOException {
            dsTaint.addTaint(index);
            InputStream in;
            in = newInputStream(index);
            {
                Object var52398940B1BDD464FFA232F092D26D4B_604073782 = (inputStreamToString(in));
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //InputStream in = newInputStream(index);
            //return in != null ? inputStreamToString(in) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.860 -0400", hash_original_method = "F4B649129433C613B63F53B88A8B2BF4", hash_generated_method = "C6C5B9D346990AE2D91CB7B9ECAAE16C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OutputStream newOutputStream(int index) throws IOException {
            dsTaint.addTaint(index);
            {
                Object varD933D409C8362D8AB4EAAFB238C186FA_629561436 = (DiskLruCache.this);
                {
                    {
                        boolean var573C982FD8CE38C80E849A01EADDA5C3_544043314 = (entry.currentEditor != this);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                        } //End block
                    } //End collapsed parenthetic
                    OutputStream var0CA0BAA5B32BC45BAD8B7E38390D3D17_749870968 = (new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(index))));
                } //End block
            } //End collapsed parenthetic
            return (OutputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (DiskLruCache.this) {
                //if (entry.currentEditor != this) {
                    //throw new IllegalStateException();
                //}
                //return new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(index)));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.861 -0400", hash_original_method = "988F125F60B3C088ADDC82562F362884", hash_generated_method = "26556DA4732DBB01FC2AEA1E3F748025")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void set(int index, String value) throws IOException {
            dsTaint.addTaint(index);
            dsTaint.addTaint(value);
            Writer writer;
            writer = null;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.861 -0400", hash_original_method = "14AFCFFFD18B711043FB34122FCD5951", hash_generated_method = "9EED671ED7A999D502C1B859DCAC2D08")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void commit() throws IOException {
            {
                completeEdit(this, false);
                remove(entry.key);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.861 -0400", hash_original_method = "805CDF65FA82242C2D4B7EB4CBDDF0ED", hash_generated_method = "18E9660C4426C8AA96D2D812955FA89C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void abort() throws IOException {
            completeEdit(this, false);
            // ---------- Original Method ----------
            //completeEdit(this, false);
        }

        
        private class FaultHidingOutputStream extends FilterOutputStream {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.861 -0400", hash_original_method = "C9ADDA2E4F72C2E9295822BCBAC6927F", hash_generated_method = "08974E509C0EA60CFFC60644010FEA63")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            private FaultHidingOutputStream(OutputStream out) {
                super(out);
                dsTaint.addTaint(out.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.861 -0400", hash_original_method = "99CEE7897D6B59DCCBF2A9FD6D32C932", hash_generated_method = "7659CB941563EDC647076940B58F4C62")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void write(int oneByte) {
                dsTaint.addTaint(oneByte);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.862 -0400", hash_original_method = "192A1A5EAAE398CB5AAE810F931045A8", hash_generated_method = "65B1A1C66770097FCA4BF081E0FCAE6D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void write(byte[] buffer, int offset, int length) {
                dsTaint.addTaint(buffer[0]);
                dsTaint.addTaint(length);
                dsTaint.addTaint(offset);
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.862 -0400", hash_original_method = "F955A307858660E97C305258EF6CF319", hash_generated_method = "F2133F1077411290DFB38A2C3168295F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.862 -0400", hash_original_method = "A7144C313F2BBCA14DD174D533CF0C30", hash_generated_method = "23B6E4BC95BEBC7C193269573D6E6B52")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private String key;
        private long[] lengths;
        private boolean readable;
        private Editor currentEditor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.862 -0400", hash_original_method = "A48AD7F9473C4832EA43939DE55B0830", hash_generated_method = "23682E7A8CD5D2AD363E47C3B361E6CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Entry(String key) {
            dsTaint.addTaint(key);
            this.lengths = new long[valueCount];
            // ---------- Original Method ----------
            //this.key = key;
            //this.lengths = new long[valueCount];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.864 -0400", hash_original_method = "5393AA568299AD2184B5004B9545BCCA", hash_generated_method = "7A816C97B7B5D028CA7A4FB91E840B0E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String getLengths() throws IOException {
            StringBuilder result;
            result = new StringBuilder();
            {
                long size = lengths[0];
                {
                    result.append(' ').append(size);
                } //End block
            } //End collapsed parenthetic
            String varEC2CAD6F4392C35EA2158E6C5520B613_185041106 = (result.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //StringBuilder result = new StringBuilder();
            //for (long size : lengths) {
                //result.append(' ').append(size);
            //}
            //return result.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.865 -0400", hash_original_method = "38ABC3E1459516CB332E39C8B303294B", hash_generated_method = "1DE60FDE63C3D94669A936671FEBA829")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void setLengths(String[] strings) throws IOException {
            dsTaint.addTaint(strings[0]);
            {
                if (DroidSafeAndroidRuntime.control) throw invalidLengths(strings);
            } //End block
            try 
            {
                {
                    int i;
                    i = 0;
                    {
                        lengths[i] = Long.parseLong(strings[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (NumberFormatException e)
            {
                if (DroidSafeAndroidRuntime.control) throw invalidLengths(strings);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.865 -0400", hash_original_method = "0EB1B022FC0EF6548A3015E3FEB332B5", hash_generated_method = "FA8C187FA88CC26F63B5FD27C391A085")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private IOException invalidLengths(String[] strings) throws IOException {
            dsTaint.addTaint(strings[0]);
            if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal line: " + Arrays.toString(strings));
            return (IOException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new IOException("unexpected journal line: " + Arrays.toString(strings));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.865 -0400", hash_original_method = "C9A2E947DD05DC3D51A797932ED86E55", hash_generated_method = "01FFDD9BA9C16A409CABB6ECBE1F93A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public File getCleanFile(int i) {
            dsTaint.addTaint(i);
            File var03AAD6BBDBDC7C61674FE62E0AEE4AF7_1134850159 = (new File(directory, key + "." + i));
            return (File)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new File(directory, key + "." + i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.865 -0400", hash_original_method = "7E5BF4AC0CC24327CE09DE834205313B", hash_generated_method = "ED820696A75641FF79A57DCA5677A7B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public File getDirtyFile(int i) {
            dsTaint.addTaint(i);
            File varED4E8A028B86452FD0B30BA5233F11D9_260935587 = (new File(directory, key + "." + i + ".tmp"));
            return (File)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new File(directory, key + "." + i + ".tmp");
        }

        
    }


    
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_TMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    static final String VERSION_1 = "1";
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    private static final String REMOVE = "REMOVE";
    private static final String READ = "READ";
}

