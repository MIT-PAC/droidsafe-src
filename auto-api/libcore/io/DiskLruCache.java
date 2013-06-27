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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.287 -0400", hash_original_field = "5F8F22B8CDBAEEE8CF857673A9B6BA20", hash_generated_field = "8B0860249151DE823C54467CC9BADB3F")

    private File directory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.287 -0400", hash_original_field = "3C3C73781D3DE0858A20A84F8FE7A498", hash_generated_field = "C3DAA1E42AD1B9E8800013507C6A05F9")

    private File journalFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.287 -0400", hash_original_field = "BBEFE2C36653C86E334A0DB0A7D1D2DE", hash_generated_field = "E459709269D427C9CB1CBD686B5A13E5")

    private File journalFileTmp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.288 -0400", hash_original_field = "B64C136408BBB80DFA6717A62D239726", hash_generated_field = "DEE2522BB7DF04F0B0954F3014F259F5")

    private int appVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.288 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "736713EBDB43EC0678FF4084C276D4A3")

    private long maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.288 -0400", hash_original_field = "A30C57CC28770178EAB167BF0B932032", hash_generated_field = "37330B5F0FE12E195B061FFDF29F478E")

    private int valueCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.288 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "93F7705D696C1DC0669B611BBCDF6959")

    private long size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.288 -0400", hash_original_field = "9CB65621E620C7F32CB54AA3C3BED0D0", hash_generated_field = "6BA9D6A677DAD8E6F256134E2B68A280")

    private Writer journalWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.288 -0400", hash_original_field = "FBBC54FAC485F995EAA3AEC039F91CB6", hash_generated_field = "D7C31A3E475E9BC38B6E0D538E339E92")

    private LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<String, Entry>(0, 0.75f, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.288 -0400", hash_original_field = "ACF4170A74586A81D52591B8F18C89F4", hash_generated_field = "6E19F0863A5F1F61C505FBB71E78DAA1")

    private int redundantOpCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.288 -0400", hash_original_field = "7893561B06784847101FF1A4FE94844D", hash_generated_field = "DCB6514DF5952028B45A832A87F6BC54")

    private ExecutorService executorService = new ThreadPoolExecutor(0, 1,
            60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.293 -0400", hash_original_field = "0AB759F1EA2680D4F36A63BC7BD4683F", hash_generated_field = "3E5B0481E06622267785DFB3571F17F2")

    private Callable<Void> cleanupCallable = new Callable<Void>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.293 -0400", hash_original_method = "60CB515F13FCF39FB25B426074E3001D", hash_generated_method = "2F534C69BDBDD34730D9A3100F36C5A2")
        @Override
        public Void call() throws Exception {
            Void varB4EAC82CA7396A68D541C85D26508E83_145025309 = null; //Variable for return #1
            Void varB4EAC82CA7396A68D541C85D26508E83_1061984257 = null; //Variable for return #2
            {
                Object varD933D409C8362D8AB4EAAFB238C186FA_1787012373 = (DiskLruCache.this);
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_145025309 = null;
                    } //End block
                    trimToSize();
                    {
                        boolean varAE772B6A2261513DC630DDE920DDFCB8_1047357081 = (journalRebuildRequired());
                        {
                            rebuildJournal();
                            redundantOpCount = 0;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1061984257 = null;
            Void varA7E53CE21691AB073D9660D615818899_2049980587; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2049980587 = varB4EAC82CA7396A68D541C85D26508E83_145025309;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2049980587 = varB4EAC82CA7396A68D541C85D26508E83_1061984257;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2049980587.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2049980587;
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

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.294 -0400", hash_original_method = "F7C5B739E468E97586605C521F3C2B42", hash_generated_method = "72D38F4B2DCD8001D35CBA47221BB3AF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.295 -0400", hash_original_method = "D80881F7E6F2A63F9AF02A98171F075C", hash_generated_method = "274991D9A7606C8D6EF3CFB88433B6FE")
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
                boolean var3B415B63A46B05254C7463316DBFFFC4_620250473 = (!MAGIC.equals(magic)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.297 -0400", hash_original_method = "B93033832384BE0A8F735535A303EB51", hash_generated_method = "2EFC5148EA5B24762B9D3AD9BE4F7E7B")
    private void readJournalLine(String line) throws IOException {
        String[] parts;
        parts = line.split(" ");
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal line: " + line);
        } //End block
        String key;
        key = parts[1];
        {
            boolean varAEADAED980A3E2CE65A0FB2D397AC4EF_107114794 = (parts[0].equals(REMOVE) && parts.length == 2);
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
            boolean var98DA74BB3A0D1D55A0A2F6F4FB097B6E_1604149982 = (parts[0].equals(CLEAN) && parts.length == 2 + valueCount);
            {
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(Arrays.copyOfRange(parts, 2, parts.length));
            } //End block
            {
                boolean var1A74343163BF8B3C2F48DFA8E158DAA9_1268926028 = (parts[0].equals(DIRTY) && parts.length == 2);
                {
                    entry.currentEditor = new Editor(entry);
                } //End block
                {
                    boolean var1B34DE325BCE96DBE7D78DC7688F24C9_873118667 = (parts[0].equals(READ) && parts.length == 2);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal line: " + line);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(line.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.326 -0400", hash_original_method = "BF29FD79336E7D0F2752A5C16F704FCA", hash_generated_method = "2BECE7B46F79575743750B532484AB0A")
    private void processJournal() throws IOException {
        deleteIfExists(journalFileTmp);
        {
            Iterator<Entry> i;
            i = lruEntries.values().iterator();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_430957997 = (i.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.363 -0400", hash_original_method = "CAFF8A7D35D4FC2C6D20C8D2E31B18B9", hash_generated_method = "248D2806F13CAC79C5D7FB79FF0B352F")
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
            Iterator<Entry> var3FF52ED4E313724F3C65EC6A81752D91_1768964309 = (lruEntries.values()).iterator();
            var3FF52ED4E313724F3C65EC6A81752D91_1768964309.hasNext();
            Entry entry = var3FF52ED4E313724F3C65EC6A81752D91_1768964309.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.371 -0400", hash_original_method = "8CCA333E37F6F5C0426A3FC5CE5D4B2E", hash_generated_method = "8B05D80130278847F6FC74339220E05B")
    public synchronized Snapshot get(String key) throws IOException {
        Snapshot varB4EAC82CA7396A68D541C85D26508E83_689139081 = null; //Variable for return #1
        Snapshot varB4EAC82CA7396A68D541C85D26508E83_1408632249 = null; //Variable for return #2
        Snapshot varB4EAC82CA7396A68D541C85D26508E83_862340921 = null; //Variable for return #3
        Snapshot varB4EAC82CA7396A68D541C85D26508E83_1087912525 = null; //Variable for return #4
        checkNotClosed();
        validateKey(key);
        Entry entry;
        entry = lruEntries.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_689139081 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1408632249 = null;
        } //End block
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_862340921 = null;
        } //End block
        journalWriter.append(READ + ' ' + key + '\n');
        {
            boolean varE9BCC6F78EB13BE042B748E2FA1C8B0F_826788979 = (journalRebuildRequired());
            {
                executorService.submit(cleanupCallable);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1087912525 = new Snapshot(ins);
        addTaint(key.getTaint());
        Snapshot varA7E53CE21691AB073D9660D615818899_753657269; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_753657269 = varB4EAC82CA7396A68D541C85D26508E83_689139081;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_753657269 = varB4EAC82CA7396A68D541C85D26508E83_1408632249;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_753657269 = varB4EAC82CA7396A68D541C85D26508E83_862340921;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_753657269 = varB4EAC82CA7396A68D541C85D26508E83_1087912525;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_753657269.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_753657269;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.380 -0400", hash_original_method = "1C8B92160DB309C26801458073B88259", hash_generated_method = "CC577BE8EBB482AE2FC7B3EBE8A6E64A")
    public synchronized Editor edit(String key) throws IOException {
        Editor varB4EAC82CA7396A68D541C85D26508E83_546740684 = null; //Variable for return #1
        Editor varB4EAC82CA7396A68D541C85D26508E83_1643712721 = null; //Variable for return #2
        checkNotClosed();
        validateKey(key);
        Entry entry;
        entry = lruEntries.get(key);
        {
            entry = new Entry(key);
            lruEntries.put(key, entry);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_546740684 = null;
        } //End block
        Editor editor;
        editor = new Editor(entry);
        entry.currentEditor = editor;
        journalWriter.write(DIRTY + ' ' + key + '\n');
        journalWriter.flush();
        varB4EAC82CA7396A68D541C85D26508E83_1643712721 = editor;
        addTaint(key.getTaint());
        Editor varA7E53CE21691AB073D9660D615818899_1671010781; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1671010781 = varB4EAC82CA7396A68D541C85D26508E83_546740684;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1671010781 = varB4EAC82CA7396A68D541C85D26508E83_1643712721;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1671010781.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1671010781;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.381 -0400", hash_original_method = "0F452AFCA1F8F7ACF1A711B33CB47BDA", hash_generated_method = "FFD54170AB256BAF5E8B5C66F04B3FEF")
    public File getDirectory() {
        File varB4EAC82CA7396A68D541C85D26508E83_1362921907 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1362921907 = directory;
        varB4EAC82CA7396A68D541C85D26508E83_1362921907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1362921907;
        // ---------- Original Method ----------
        //return directory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.381 -0400", hash_original_method = "4A03A0F188DC0124026C9315925210D3", hash_generated_method = "E134896F0825D1E3B1217458B9850E61")
    public long maxSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_693541412 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_693541412;
        // ---------- Original Method ----------
        //return maxSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.382 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "07D056E0866E252F677321787F97E641")
    public synchronized long size() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_394722637 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_394722637;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.383 -0400", hash_original_method = "E3B5F5B6DB82C9D68E2AD58524FD46D2", hash_generated_method = "FB7FF5FBFE8102951685C6AB237839A9")
    private synchronized void completeEdit(Editor editor, boolean success) throws IOException {
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
                        boolean varFFE5A3C862451CA99201ACFA8DB76116_1595852337 = (!entry.getDirtyFile(i).exists());
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
                        boolean var6FE72A42168775380AEE51AF827532B3_1953901464 = (dirty.exists());
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
            boolean var776EDFAB12D0A0A4A863963ED3C1C602_1225367871 = (size > maxSize || journalRebuildRequired());
            {
                executorService.submit(cleanupCallable);
            } //End block
        } //End collapsed parenthetic
        addTaint(editor.getTaint());
        addTaint(success);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.387 -0400", hash_original_method = "BD0CD0940E277CB89BD11D972CAF1EC0", hash_generated_method = "5B80E5895ADCAA083E4740883CDD0A67")
    private boolean journalRebuildRequired() {
        int REDUNDANT_OP_COMPACT_THRESHOLD;
        REDUNDANT_OP_COMPACT_THRESHOLD = 2000;
        boolean varA8B170D68A257FCB088E560C51B41F6B_781091036 = (redundantOpCount >= REDUNDANT_OP_COMPACT_THRESHOLD
                && redundantOpCount >= lruEntries.size());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822379792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822379792;
        // ---------- Original Method ----------
        //final int REDUNDANT_OP_COMPACT_THRESHOLD = 2000;
        //return redundantOpCount >= REDUNDANT_OP_COMPACT_THRESHOLD
                //&& redundantOpCount >= lruEntries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.396 -0400", hash_original_method = "EADC8C19CC119124A893E81F5BBBE260", hash_generated_method = "4CFC6A1FB547CF7AE49C4221FF395E3E")
    public synchronized boolean remove(String key) throws IOException {
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
                    boolean var662432ADDD39E82511D634813D6392A6_1017670672 = (!file.delete());
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
            boolean varE9BCC6F78EB13BE042B748E2FA1C8B0F_1299985219 = (journalRebuildRequired());
            {
                executorService.submit(cleanupCallable);
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1137530158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1137530158;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.409 -0400", hash_original_method = "DD17EBB3E7F8098B41E8CF3D3DB045E0", hash_generated_method = "37E0EA841829882B18DC81BE28785D2F")
    public boolean isClosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1615864346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1615864346;
        // ---------- Original Method ----------
        //return journalWriter == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.409 -0400", hash_original_method = "8ED19EB33A6AB2822DDF1831EB4A2E5C", hash_generated_method = "563F58E3136896F1891C3E5166D27E9A")
    private void checkNotClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("cache is closed");
        } //End block
        // ---------- Original Method ----------
        //if (journalWriter == null) {
            //throw new IllegalStateException("cache is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.409 -0400", hash_original_method = "329F096E2383A78FF3370B422D55028D", hash_generated_method = "365B35FA4F8864C12CD2EC6688A56CBE")
    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        journalWriter.flush();
        // ---------- Original Method ----------
        //checkNotClosed();
        //trimToSize();
        //journalWriter.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.426 -0400", hash_original_method = "99CE1AB60FDF93828647C541E1949F71", hash_generated_method = "561F73E66318236AF12D88701DA189B4")
    public synchronized void close() throws IOException {
        {
            Iterator<Entry> varA079903352D454BE94CBDC004A76A873_2104620614 = (new ArrayList<Entry>(lruEntries.values())).iterator();
            varA079903352D454BE94CBDC004A76A873_2104620614.hasNext();
            Entry entry = varA079903352D454BE94CBDC004A76A873_2104620614.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.426 -0400", hash_original_method = "52FB98FFFDCED62623018A96063CC5F4", hash_generated_method = "EFE2DBF6BEF52CA87CD9CFD0A6216A15")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.426 -0400", hash_original_method = "E0DF0E5E95BB69DC7E72889656D60AB7", hash_generated_method = "40601D48395A0FDE4DC088AFE1B7872C")
    public void delete() throws IOException {
        close();
        IoUtils.deleteContents(directory);
        // ---------- Original Method ----------
        //close();
        //IoUtils.deleteContents(directory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.427 -0400", hash_original_method = "A6AB05B3A3783BAC84CED8DCEEB398D1", hash_generated_method = "252584279F23BC4833C348343A28195C")
    private void validateKey(String key) {
        {
            boolean var8C530715B845FC3D79AD68AB30B9FD1A_1761947675 = (key.contains(" ") || key.contains("\n") || key.contains("\r"));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "keys must not contain spaces or newlines: \"" + key + "\"");
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.427 -0400", hash_original_field = "CDF1E220D89C2DCD2E000C3D105BF93E", hash_generated_field = "464EF7B473F9CC85C5904899BBCD6B8E")

        private InputStream[] ins;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.427 -0400", hash_original_method = "4874F99779A0A237419F7A04515D002C", hash_generated_method = "6FEE8A1DE88E19521460185A59EEAE25")
        private  Snapshot(InputStream[] ins) {
            this.ins = ins;
            // ---------- Original Method ----------
            //this.ins = ins;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.428 -0400", hash_original_method = "1265F3570693D55B3F128D89D3B629D2", hash_generated_method = "F3413F7C8D0B27D3D0C482A84FAC27F3")
        public InputStream getInputStream(int index) {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1315349011 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1315349011 = ins[index];
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1315349011.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1315349011;
            // ---------- Original Method ----------
            //return ins[index];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.433 -0400", hash_original_method = "CEACA6862DFE49E3BCD1DEF39CCE35B7", hash_generated_method = "93B3DC780C787766A4CA08C8AA997EA7")
        public String getString(int index) throws IOException {
            String varB4EAC82CA7396A68D541C85D26508E83_239321143 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_239321143 = inputStreamToString(getInputStream(index));
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_239321143.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_239321143;
            // ---------- Original Method ----------
            //return inputStreamToString(getInputStream(index));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.445 -0400", hash_original_method = "ECD6C2B86E4C6B719F1F8B8AE3B1A8FC", hash_generated_method = "A779C24A2F020752D5F61844458A21BB")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.446 -0400", hash_original_field = "1043BFC77FEBE75FAFEC0C4309FACCF1", hash_generated_field = "70C4CB2BDA836A091A18885840DD6AFF")

        private Entry entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.451 -0400", hash_original_field = "9308EF711245F4213A779903B194F396", hash_generated_field = "801DA5B7CFF4CA64DD2686B1718833F3")

        private boolean hasErrors;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.453 -0400", hash_original_method = "DB0A9ACC8813DA2FB44F6FFEC09E8772", hash_generated_method = "9D5F2E1BFEBBC34BED7AEE5B243CB69C")
        private  Editor(Entry entry) {
            this.entry = entry;
            // ---------- Original Method ----------
            //this.entry = entry;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.453 -0400", hash_original_method = "E20ADC2C4905CE726058A12470A98795", hash_generated_method = "6EA1F31C1D6AA684992E640166BFF398")
        public InputStream newInputStream(int index) throws IOException {
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1277105293 = null; //Variable for return #1
            InputStream varB4EAC82CA7396A68D541C85D26508E83_1766883755 = null; //Variable for return #2
            {
                Object varD933D409C8362D8AB4EAAFB238C186FA_1059113 = (DiskLruCache.this);
                {
                    {
                        boolean var573C982FD8CE38C80E849A01EADDA5C3_2116264927 = (entry.currentEditor != this);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1277105293 = null;
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_1766883755 = new FileInputStream(entry.getCleanFile(index));
                } //End block
            } //End collapsed parenthetic
            addTaint(index);
            InputStream varA7E53CE21691AB073D9660D615818899_503308425; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_503308425 = varB4EAC82CA7396A68D541C85D26508E83_1277105293;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_503308425 = varB4EAC82CA7396A68D541C85D26508E83_1766883755;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_503308425.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_503308425;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.455 -0400", hash_original_method = "84B73985D87B7C97991726C0644B80BD", hash_generated_method = "D3435F4CE7FB3BFEE09736AD9081ABF5")
        public String getString(int index) throws IOException {
            String varB4EAC82CA7396A68D541C85D26508E83_2020664252 = null; //Variable for return #1
            InputStream in;
            in = newInputStream(index);
            varB4EAC82CA7396A68D541C85D26508E83_2020664252 = in != null ? inputStreamToString(in) : null;
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2020664252.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2020664252;
            // ---------- Original Method ----------
            //InputStream in = newInputStream(index);
            //return in != null ? inputStreamToString(in) : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.455 -0400", hash_original_method = "F4B649129433C613B63F53B88A8B2BF4", hash_generated_method = "D642D8EF142EA953C5D2927B0F0FB821")
        public OutputStream newOutputStream(int index) throws IOException {
            OutputStream varB4EAC82CA7396A68D541C85D26508E83_2080400907 = null; //Variable for return #1
            {
                Object varD933D409C8362D8AB4EAAFB238C186FA_118053254 = (DiskLruCache.this);
                {
                    {
                        boolean var573C982FD8CE38C80E849A01EADDA5C3_884723508 = (entry.currentEditor != this);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_2080400907 = new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(index)));
                } //End block
            } //End collapsed parenthetic
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2080400907.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2080400907;
            // ---------- Original Method ----------
            //synchronized (DiskLruCache.this) {
                //if (entry.currentEditor != this) {
                    //throw new IllegalStateException();
                //}
                //return new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(index)));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.457 -0400", hash_original_method = "988F125F60B3C088ADDC82562F362884", hash_generated_method = "D4E8A212F410B6CAE6B3C60DDCE0BC9F")
        public void set(int index, String value) throws IOException {
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
            addTaint(index);
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //Writer writer = null;
            //try {
                //writer = new OutputStreamWriter(newOutputStream(index), Charsets.UTF_8);
                //writer.write(value);
            //} finally {
                //IoUtils.closeQuietly(writer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.457 -0400", hash_original_method = "14AFCFFFD18B711043FB34122FCD5951", hash_generated_method = "9EED671ED7A999D502C1B859DCAC2D08")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.457 -0400", hash_original_method = "805CDF65FA82242C2D4B7EB4CBDDF0ED", hash_generated_method = "18E9660C4426C8AA96D2D812955FA89C")
        public void abort() throws IOException {
            completeEdit(this, false);
            // ---------- Original Method ----------
            //completeEdit(this, false);
        }

        
        private class FaultHidingOutputStream extends FilterOutputStream {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.463 -0400", hash_original_method = "C9ADDA2E4F72C2E9295822BCBAC6927F", hash_generated_method = "F98AAD1DAF9C62BF5BF1780FA95F6862")
            private  FaultHidingOutputStream(OutputStream out) {
                super(out);
                addTaint(out.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.463 -0400", hash_original_method = "99CEE7897D6B59DCCBF2A9FD6D32C932", hash_generated_method = "E6417635BE2B5EFEB4355F91D7AAE6D0")
            @Override
            public void write(int oneByte) {
                try 
                {
                    out.write(oneByte);
                } //End block
                catch (IOException e)
                {
                    hasErrors = true;
                } //End block
                addTaint(oneByte);
                // ---------- Original Method ----------
                //try {
                    //out.write(oneByte);
                //} catch (IOException e) {
                    //hasErrors = true;
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.463 -0400", hash_original_method = "192A1A5EAAE398CB5AAE810F931045A8", hash_generated_method = "EC6CD5E768BDBC7F8E25C9FCF8999B57")
            @Override
            public void write(byte[] buffer, int offset, int length) {
                try 
                {
                    out.write(buffer, offset, length);
                } //End block
                catch (IOException e)
                {
                    hasErrors = true;
                } //End block
                addTaint(buffer[0]);
                addTaint(offset);
                addTaint(length);
                // ---------- Original Method ----------
                //try {
                    //out.write(buffer, offset, length);
                //} catch (IOException e) {
                    //hasErrors = true;
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.465 -0400", hash_original_method = "F955A307858660E97C305258EF6CF319", hash_generated_method = "F2133F1077411290DFB38A2C3168295F")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.465 -0400", hash_original_method = "A7144C313F2BBCA14DD174D533CF0C30", hash_generated_method = "23B6E4BC95BEBC7C193269573D6E6B52")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.465 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")

        private String key;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.471 -0400", hash_original_field = "1E3F5C7322090A6DD464EC8E7BF19C04", hash_generated_field = "47E38F001ED3E4E2BB8D4D488C8C03FF")

        private long[] lengths;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.471 -0400", hash_original_field = "500F1C435067A26384C6B38F464DA461", hash_generated_field = "1948B1A97D5C03C3163AE2F5DE57C5D5")

        private boolean readable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.471 -0400", hash_original_field = "98A0346B30924377CBA028D7A3002904", hash_generated_field = "42500C0BD0D534C6B3B5904249FFA61F")

        private Editor currentEditor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.472 -0400", hash_original_method = "A48AD7F9473C4832EA43939DE55B0830", hash_generated_method = "05E015F56AEE62FCB3C094123AFDB03C")
        private  Entry(String key) {
            this.key = key;
            this.lengths = new long[valueCount];
            // ---------- Original Method ----------
            //this.key = key;
            //this.lengths = new long[valueCount];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.491 -0400", hash_original_method = "5393AA568299AD2184B5004B9545BCCA", hash_generated_method = "522FC35785519DFA0AC92021BFDE3BD8")
        public String getLengths() throws IOException {
            String varB4EAC82CA7396A68D541C85D26508E83_1110637477 = null; //Variable for return #1
            StringBuilder result;
            result = new StringBuilder();
            {
                long size = lengths[0];
                {
                    result.append(' ').append(size);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1110637477 = result.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1110637477.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1110637477;
            // ---------- Original Method ----------
            //StringBuilder result = new StringBuilder();
            //for (long size : lengths) {
                //result.append(' ').append(size);
            //}
            //return result.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.491 -0400", hash_original_method = "38ABC3E1459516CB332E39C8B303294B", hash_generated_method = "6874D7C9D3D80C202DCC303244363E56")
        private void setLengths(String[] strings) throws IOException {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.493 -0400", hash_original_method = "0EB1B022FC0EF6548A3015E3FEB332B5", hash_generated_method = "D6244078B0DF0446716611B264ECFCE5")
        private IOException invalidLengths(String[] strings) throws IOException {
            if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected journal line: " + Arrays.toString(strings));
            addTaint(strings[0].getTaint());
            // ---------- Original Method ----------
            //throw new IOException("unexpected journal line: " + Arrays.toString(strings));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.493 -0400", hash_original_method = "C9A2E947DD05DC3D51A797932ED86E55", hash_generated_method = "24C9508BB0AC2A46FACE989CD524B6C1")
        public File getCleanFile(int i) {
            File varB4EAC82CA7396A68D541C85D26508E83_811816742 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_811816742 = new File(directory, key + "." + i);
            addTaint(i);
            varB4EAC82CA7396A68D541C85D26508E83_811816742.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_811816742;
            // ---------- Original Method ----------
            //return new File(directory, key + "." + i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_method = "7E5BF4AC0CC24327CE09DE834205313B", hash_generated_method = "1E74A78C90870A0B9DFCDE895572342B")
        public File getDirtyFile(int i) {
            File varB4EAC82CA7396A68D541C85D26508E83_651848007 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_651848007 = new File(directory, key + "." + i + ".tmp");
            addTaint(i);
            varB4EAC82CA7396A68D541C85D26508E83_651848007.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_651848007;
            // ---------- Original Method ----------
            //return new File(directory, key + "." + i + ".tmp");
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_field = "146ED4CC80494753D64EC5514BA90594", hash_generated_field = "7C1D26C84C6738F50BF26000CA0572F2")

    static String JOURNAL_FILE = "journal";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_field = "C27E2248B4DB333CA96F806C864197D7", hash_generated_field = "B0CFDDCA93CFC23D22A9E4C1D40ED512")

    static String JOURNAL_FILE_TMP = "journal.tmp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_field = "DCC6B9D3CD10ED22CE2DA8E60C5BBFAD", hash_generated_field = "A0284F6144F3152A83BCD565E6E2458E")

    static String MAGIC = "libcore.io.DiskLruCache";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_field = "9124F0C1C3587C09E0039D7D03AD14E2", hash_generated_field = "13C799B5E4058755F059530C80D9F85E")

    static String VERSION_1 = "1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_field = "3B53DD8A00AAB81F06315EA2FA729D53", hash_generated_field = "2744E43C7AB14167DB082F99D4EDB232")

    private static String CLEAN = "CLEAN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_field = "0C80AB04C9B771FF3F039B09E1467C17", hash_generated_field = "11EAB93E7397D1D504EDF8D6C17D6D9E")

    private static String DIRTY = "DIRTY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_field = "AAB7977E77FA1610AC8C247D28DD545D", hash_generated_field = "1C446FD8353E744DFFCDDF7ACF64D0E1")

    private static String REMOVE = "REMOVE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_field = "01B61ABD16813F4E0DA1FA6793E11958", hash_generated_field = "638A8383F04AB848F2943D1E221012FE")

    private static String READ = "READ";
}

