package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * Opens the cache in {@code directory}, creating a cache if none exists
     * there.
     *
     * @param directory a writable directory
     * @param appVersion
     * @param valueCount the number of values per cache entry. Must be positive.
     * @param maxSize the maximum number of bytes this cache should use to store
     * @throws IOException if reading or writing the cache directory fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.542 -0500", hash_original_method = "C6262A38E14202513F9F6CF1961CE108", hash_generated_method = "57E3C1E98BBC7FB9779A1C8A3ECA6FC9")
    public static DiskLruCache open(File directory, int appVersion, int valueCount, long maxSize)
            throws IOException {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (valueCount <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }

        // prefer to pick up where we left off
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

        // create a new empty cache
        directory.mkdirs();
        cache = new DiskLruCache(directory, appVersion, valueCount, maxSize);
        cache.rebuildJournal();
        return cache;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.547 -0500", hash_original_method = "A55E7F0201C0F280790862CD26778798", hash_generated_method = "28951C4690DEC49C9E731BE208E1F25E")
    private static void deleteIfExists(File file) throws IOException {
        try {
            Libcore.os.remove(file.getPath());
        } catch (ErrnoException errnoException) {
            if (errnoException.errno != OsConstants.ENOENT) {
                throw errnoException.rethrowAsIOException();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.561 -0500", hash_original_method = "FCB1F7A536BE92A38023570683A10CE6", hash_generated_method = "53E15E45851C670F2D5EBA02266231AE")
    private static String inputStreamToString(InputStream in) throws IOException {
        return Streams.readFully(new InputStreamReader(in, Charsets.UTF_8));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.523 -0500", hash_original_field = "C4FDD76BA6004F05F21618928C4CEB8F", hash_generated_field = "4A1FFB11CFC6DEB101BE09CC3B4A0541")

    static final String JOURNAL_FILE = "journal";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.524 -0500", hash_original_field = "D36C43DB626F450C609A1F851F84BDF9", hash_generated_field = "034EDD0C46E4A8371CCBF6D7FC648A4E")

    static final String JOURNAL_FILE_TMP = "journal.tmp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.524 -0500", hash_original_field = "0AAB9D26DC138FE3119CE57D47255EA7", hash_generated_field = "7D7E4E3F80D7739D5851F7B7CC9C9753")

    static final String MAGIC = "libcore.io.DiskLruCache";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.525 -0500", hash_original_field = "385ABDC2E5141868A55F8BF5F054C31E", hash_generated_field = "E6DA46912A3A699E1E1BB91060E2E20A")

    static final String VERSION_1 = "1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.526 -0500", hash_original_field = "D8D15B49731FA2CA1004A95FCA4A7E15", hash_generated_field = "399C7FB289276D622822E90E2F5602EA")

    private static final String CLEAN = "CLEAN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.527 -0500", hash_original_field = "24847A7309B5ED359B3569A8008BF986", hash_generated_field = "C6523E18AE66B1D3E17A856E3BCCD799")

    private static final String DIRTY = "DIRTY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.528 -0500", hash_original_field = "3049B6D1B6D514EFADA91313657F85C3", hash_generated_field = "E0988763D8BB4983637AED5C39DA025C")

    private static final String REMOVE = "REMOVE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.529 -0500", hash_original_field = "CD03BEF7CD7085C6B902DEB3C4EE1520", hash_generated_field = "EDF0809706A7034445A48D4182705933")

    private static final String READ = "READ";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.529 -0500", hash_original_field = "FAF68CC60E35257A66D284E0CBAD8965", hash_generated_field = "8B0860249151DE823C54467CC9BADB3F")


    private  File directory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.530 -0500", hash_original_field = "8FB46FEB9C38A6CBE5C3158AB2D42DF5", hash_generated_field = "C3DAA1E42AD1B9E8800013507C6A05F9")

    private  File journalFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.531 -0500", hash_original_field = "92FD65AA6758A7DD90B535DCB9CBE3C3", hash_generated_field = "E459709269D427C9CB1CBD686B5A13E5")

    private  File journalFileTmp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.532 -0500", hash_original_field = "988A50EE0ACD9DDEF61D18883D666C22", hash_generated_field = "DEE2522BB7DF04F0B0954F3014F259F5")

    private  int appVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.533 -0500", hash_original_field = "9C0C31D58DF73FE342D2A8C5DB6543DD", hash_generated_field = "736713EBDB43EC0678FF4084C276D4A3")

    private  long maxSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.534 -0500", hash_original_field = "07C2C106F1F0FB950E1F709AD077E8CF", hash_generated_field = "37330B5F0FE12E195B061FFDF29F478E")

    private  int valueCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.534 -0500", hash_original_field = "F0EDCD0574019A8BA77C60F9B7139E1D", hash_generated_field = "93F7705D696C1DC0669B611BBCDF6959")

    private long size = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.536 -0500", hash_original_field = "F38630DCBAF4D49EB305899CD48B8907", hash_generated_field = "6BA9D6A677DAD8E6F256134E2B68A280")

    private Writer journalWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.536 -0500", hash_original_field = "2405772E8F4C16E08D41A75A75F4F4F1", hash_generated_field = "D4AEF12769A5EC9F5F72F388FEBC72A2")

    private final LinkedHashMap<String, Entry> lruEntries
            = new LinkedHashMap<String, Entry>(0, 0.75f, true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.537 -0500", hash_original_field = "457384E4739CA832E5CE964C8D36F4A8", hash_generated_field = "6E19F0863A5F1F61C505FBB71E78DAA1")

    private int redundantOpCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.538 -0500", hash_original_field = "1CDD7D1343A830C977B8F2390867C384", hash_generated_field = "D542EB48AB8E08A6131DD420815BF0BD")

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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.541 -0500", hash_original_method = "F7C5B739E468E97586605C521F3C2B42", hash_generated_method = "7DD89103BDA236A723429D2497EEF55C")
    private DiskLruCache(File directory, int appVersion, int valueCount, long maxSize) {
        this.directory = directory;
        this.appVersion = appVersion;
        this.journalFile = new File(directory, JOURNAL_FILE);
        this.journalFileTmp = new File(directory, JOURNAL_FILE_TMP);
        this.valueCount = valueCount;
        this.maxSize = maxSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.543 -0500", hash_original_method = "D80881F7E6F2A63F9AF02A98171F075C", hash_generated_method = "C51F0864E9860170832C4164DC428F27")
    private void readJournal() throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(journalFile));
        try {
            String magic = Streams.readAsciiLine(in);
            String version = Streams.readAsciiLine(in);
            String appVersionString = Streams.readAsciiLine(in);
            String valueCountString = Streams.readAsciiLine(in);
            String blank = Streams.readAsciiLine(in);
            if (!MAGIC.equals(magic)
                    || !VERSION_1.equals(version)
                    || !Integer.toString(appVersion).equals(appVersionString)
                    || !Integer.toString(valueCount).equals(valueCountString)
                    || !"".equals(blank)) {
                throw new IOException("unexpected journal header: ["
                        + magic + ", " + version + ", " + valueCountString + ", " + blank + "]");
            }

            while (true) {
                try {
                    readJournalLine(Streams.readAsciiLine(in));
                } catch (EOFException endOfJournal) {
                    break;
                }
            }
        } finally {
            IoUtils.closeQuietly(in);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.544 -0500", hash_original_method = "B93033832384BE0A8F735535A303EB51", hash_generated_method = "330ADCE299FEE034B9BDE5E43980FB43")
    private void readJournalLine(String line) throws IOException {
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            throw new IOException("unexpected journal line: " + line);
        }

        String key = parts[1];
        if (parts[0].equals(REMOVE) && parts.length == 2) {
            lruEntries.remove(key);
            return;
        }

        Entry entry = lruEntries.get(key);
        if (entry == null) {
            entry = new Entry(key);
            lruEntries.put(key, entry);
        }

        if (parts[0].equals(CLEAN) && parts.length == 2 + valueCount) {
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(Arrays.copyOfRange(parts, 2, parts.length));
        } else if (parts[0].equals(DIRTY) && parts.length == 2) {
            entry.currentEditor = new Editor(entry);
        } else if (parts[0].equals(READ) && parts.length == 2) {
            // this work was already done by calling lruEntries.get()
        } else {
            throw new IOException("unexpected journal line: " + line);
        }
    }

    /**
     * Computes the initial size and collects garbage as a part of opening the
     * cache. Dirty entries are assumed to be inconsistent and will be deleted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.545 -0500", hash_original_method = "BF29FD79336E7D0F2752A5C16F704FCA", hash_generated_method = "8DDF8BEFAF7D0B9E356C822FFE084B0A")
    private void processJournal() throws IOException {
        deleteIfExists(journalFileTmp);
        for (Iterator<Entry> i = lruEntries.values().iterator(); i.hasNext(); ) {
            Entry entry = i.next();
            if (entry.currentEditor == null) {
                for (int t = 0; t < valueCount; t++) {
                    size += entry.lengths[t];
                }
            } else {
                entry.currentEditor = null;
                for (int t = 0; t < valueCount; t++) {
                    deleteIfExists(entry.getCleanFile(t));
                    deleteIfExists(entry.getDirtyFile(t));
                }
                i.remove();
            }
        }
    }

    /**
     * Creates a new journal that omits redundant information. This replaces the
     * current journal if it exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.546 -0500", hash_original_method = "CAFF8A7D35D4FC2C6D20C8D2E31B18B9", hash_generated_method = "760BDC582D3BA1C5073D44DAFD85B3FA")
    private synchronized void rebuildJournal() throws IOException {
        if (journalWriter != null) {
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

        for (Entry entry : lruEntries.values()) {
            if (entry.currentEditor != null) {
                writer.write(DIRTY + ' ' + entry.key + '\n');
            } else {
                writer.write(CLEAN + ' ' + entry.key + entry.getLengths() + '\n');
            }
        }

        writer.close();
        journalFileTmp.renameTo(journalFile);
        journalWriter = new BufferedWriter(new FileWriter(journalFile, true));
    }

    /**
     * Returns a snapshot of the entry named {@code key}, or null if it doesn't
     * exist is not currently readable. If a value is returned, it is moved to
     * the head of the LRU queue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.547 -0500", hash_original_method = "8CCA333E37F6F5C0426A3FC5CE5D4B2E", hash_generated_method = "7EDDC753216FEB27E3D8DEC49A3F19FC")
    public synchronized Snapshot get(String key) throws IOException {
        checkNotClosed();
        validateKey(key);
        Entry entry = lruEntries.get(key);
        if (entry == null) {
            return null;
        }

        if (!entry.readable) {
            return null;
        }

        /*
         * Open all streams eagerly to guarantee that we see a single published
         * snapshot. If we opened streams lazily then the streams could come
         * from different edits.
         */
        InputStream[] ins = new InputStream[valueCount];
        try {
            for (int i = 0; i < valueCount; i++) {
                ins[i] = new FileInputStream(entry.getCleanFile(i));
            }
        } catch (FileNotFoundException e) {
            // a file must have been deleted manually!
            return null;
        }

        redundantOpCount++;
        journalWriter.append(READ + ' ' + key + '\n');
        if (journalRebuildRequired()) {
            executorService.submit(cleanupCallable);
        }

        return new Snapshot(ins);
    }

    /**
     * Returns an editor for the entry named {@code key}, or null if it cannot
     * currently be edited.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.548 -0500", hash_original_method = "1C8B92160DB309C26801458073B88259", hash_generated_method = "26E2DA0618884B92B356CE856F7387A5")
    public synchronized Editor edit(String key) throws IOException {
        checkNotClosed();
        validateKey(key);
        Entry entry = lruEntries.get(key);
        if (entry == null) {
            entry = new Entry(key);
            lruEntries.put(key, entry);
        } else if (entry.currentEditor != null) {
            return null;
        }

        Editor editor = new Editor(entry);
        entry.currentEditor = editor;

        // flush the journal before creating files to prevent file leaks
        journalWriter.write(DIRTY + ' ' + key + '\n');
        journalWriter.flush();
        return editor;
    }

    /**
     * Returns the directory where this cache stores its data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.549 -0500", hash_original_method = "0F452AFCA1F8F7ACF1A711B33CB47BDA", hash_generated_method = "E3D7C690CEE54731B9E99C2D1CE490BD")
    public File getDirectory() {
        return directory;
    }

    /**
     * Returns the maximum number of bytes that this cache should use to store
     * its data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.551 -0500", hash_original_method = "4A03A0F188DC0124026C9315925210D3", hash_generated_method = "233BE800A7C23A3ED7DFE85855390800")
    public long maxSize() {
        return maxSize;
    }

    /**
     * Returns the number of bytes currently being used to store the values in
     * this cache. This may be greater than the max size if a background
     * deletion is pending.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.551 -0500", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "90D204205C81CFABA73CE61129C7B480")
    public synchronized long size() {
        return size;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.552 -0500", hash_original_method = "E3B5F5B6DB82C9D68E2AD58524FD46D2", hash_generated_method = "7521FE7FA40B8FCEBE2BB6C930585EA4")
    private synchronized void completeEdit(Editor editor, boolean success) throws IOException {
        Entry entry = editor.entry;
        if (entry.currentEditor != editor) {
            throw new IllegalStateException();
        }

        // if this edit is creating the entry for the first time, every index must have a value
        if (success && !entry.readable) {
            for (int i = 0; i < valueCount; i++) {
                if (!entry.getDirtyFile(i).exists()) {
                    editor.abort();
                    throw new IllegalStateException("edit didn't create file " + i);
                }
            }
        }

        for (int i = 0; i < valueCount; i++) {
            File dirty = entry.getDirtyFile(i);
            if (success) {
                if (dirty.exists()) {
                    File clean = entry.getCleanFile(i);
                    dirty.renameTo(clean);
                    long oldLength = entry.lengths[i];
                    long newLength = clean.length();
                    entry.lengths[i] = newLength;
                    size = size - oldLength + newLength;
                }
            } else {
                deleteIfExists(dirty);
            }
        }

        redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable | success) {
            entry.readable = true;
            journalWriter.write(CLEAN + ' ' + entry.key + entry.getLengths() + '\n');
        } else {
            lruEntries.remove(entry.key);
            journalWriter.write(REMOVE + ' ' + entry.key + '\n');
        }

        if (size > maxSize || journalRebuildRequired()) {
            executorService.submit(cleanupCallable);
        }
    }

    /**
     * We only rebuild the journal when it will halve the size of the journal
     * and eliminate at least 2000 ops.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.553 -0500", hash_original_method = "BD0CD0940E277CB89BD11D972CAF1EC0", hash_generated_method = "6CB8AA358C5F4EA765EF80B119362FFA")
    private boolean journalRebuildRequired() {
        final int REDUNDANT_OP_COMPACT_THRESHOLD = 2000;
        return redundantOpCount >= REDUNDANT_OP_COMPACT_THRESHOLD
                && redundantOpCount >= lruEntries.size();
    }

    
    public static final class Snapshot implements Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.562 -0500", hash_original_field = "C22F1E6E9A57B1C138FFFD0C3B57C88E", hash_generated_field = "464EF7B473F9CC85C5904899BBCD6B8E")

        private  InputStream[] ins;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.563 -0500", hash_original_method = "4874F99779A0A237419F7A04515D002C", hash_generated_method = "934833C6A4EE653724527981EF873A46")
        private Snapshot(InputStream[] ins) {
            this.ins = ins;
        }

        /**
         * Returns the unbuffered stream with the value for {@code index}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.564 -0500", hash_original_method = "1265F3570693D55B3F128D89D3B629D2", hash_generated_method = "66AAB758601A82AC29796C0E5B0371C8")
        public InputStream getInputStream(int index) {
            return ins[index];
        }

        /**
         * Returns the string value for {@code index}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.565 -0500", hash_original_method = "CEACA6862DFE49E3BCD1DEF39CCE35B7", hash_generated_method = "4357A096317B01FDEE80AE1B0EA39D9B")
        public String getString(int index) throws IOException {
            return inputStreamToString(getInputStream(index));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.565 -0500", hash_original_method = "ECD6C2B86E4C6B719F1F8B8AE3B1A8FC", hash_generated_method = "B328862B1CDD3DD77DC537487BB637F1")
        @Override
public void close() {
            for (InputStream in : ins) {
                IoUtils.closeQuietly(in);
            }
        }

        
    }


    
    public final class Editor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.567 -0500", hash_original_field = "37335DA26DA5FD3B79F548D93188F88C", hash_generated_field = "70C4CB2BDA836A091A18885840DD6AFF")

        private  Entry entry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.568 -0500", hash_original_field = "03A7E2C039E8BE1D8CE9DACFDBDBEF86", hash_generated_field = "801DA5B7CFF4CA64DD2686B1718833F3")

        private boolean hasErrors;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.569 -0500", hash_original_method = "DB0A9ACC8813DA2FB44F6FFEC09E8772", hash_generated_method = "50D51F5C8A1DDD05ECD916E5C95501D2")
        private Editor(Entry entry) {
            this.entry = entry;
        }

        /**
         * Returns an unbuffered input stream to read the last committed value,
         * or null if no value has been committed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.570 -0500", hash_original_method = "E20ADC2C4905CE726058A12470A98795", hash_generated_method = "89150ACEFDB3E162E03A77897901F3E9")
        public InputStream newInputStream(int index) throws IOException {
            synchronized (DiskLruCache.this) {
                if (entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!entry.readable) {
                    return null;
                }
                return new FileInputStream(entry.getCleanFile(index));
            }
        }

        /**
         * Returns the last committed value as a string, or null if no value
         * has been committed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.571 -0500", hash_original_method = "84B73985D87B7C97991726C0644B80BD", hash_generated_method = "AEF1EF3A1DC3499A14E59AC23BD204F4")
        public String getString(int index) throws IOException {
            InputStream in = newInputStream(index);
            return in != null ? inputStreamToString(in) : null;
        }

        /**
         * Returns a new unbuffered output stream to write the value at
         * {@code index}. If the underlying output stream encounters errors
         * when writing to the filesystem, this edit will be aborted when
         * {@link #commit} is called. The returned output stream does not throw
         * IOExceptions.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.572 -0500", hash_original_method = "F4B649129433C613B63F53B88A8B2BF4", hash_generated_method = "455E1DB8273EE360391E172260C2EC7D")
        public OutputStream newOutputStream(int index) throws IOException {
            synchronized (DiskLruCache.this) {
                if (entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                return new FaultHidingOutputStream(new FileOutputStream(entry.getDirtyFile(index)));
            }
        }

        /**
         * Sets the value at {@code index} to {@code value}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.573 -0500", hash_original_method = "988F125F60B3C088ADDC82562F362884", hash_generated_method = "5C6D3BE01436F4745C5A22D0A3D631D7")
        public void set(int index, String value) throws IOException {
            Writer writer = null;
            try {
                writer = new OutputStreamWriter(newOutputStream(index), Charsets.UTF_8);
                writer.write(value);
            } finally {
                IoUtils.closeQuietly(writer);
            }
        }

        /**
         * Commits this edit so it is visible to readers.  This releases the
         * edit lock so another edit may be started on the same key.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.574 -0500", hash_original_method = "14AFCFFFD18B711043FB34122FCD5951", hash_generated_method = "3253F34376B5F4E1DAE5391E2C045908")
        public void commit() throws IOException {
            if (hasErrors) {
                completeEdit(this, false);
                remove(entry.key); // the previous entry is stale
            } else {
                completeEdit(this, true);
            }
        }

        /**
         * Aborts this edit. This releases the edit lock so another edit may be
         * started on the same key.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.574 -0500", hash_original_method = "805CDF65FA82242C2D4B7EB4CBDDF0ED", hash_generated_method = "9E8F62F096B91DECF20E03A28B8895A2")
        public void abort() throws IOException {
            completeEdit(this, false);
        }

        
        private class FaultHidingOutputStream extends FilterOutputStream {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.576 -0500", hash_original_method = "C9ADDA2E4F72C2E9295822BCBAC6927F", hash_generated_method = "3AAF07AFF495EF6B8165E58FA620149D")
            private FaultHidingOutputStream(OutputStream out) {
                super(out);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.577 -0500", hash_original_method = "99CEE7897D6B59DCCBF2A9FD6D32C932", hash_generated_method = "6C39B0CF2DD4ABCCAD25CFF7FF28C502")
            @Override
public void write(int oneByte) {
                try {
                    out.write(oneByte);
                } catch (IOException e) {
                    hasErrors = true;
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.577 -0500", hash_original_method = "192A1A5EAAE398CB5AAE810F931045A8", hash_generated_method = "8D7E9EA8033D80E37AF251DE45A28EFE")
            @Override
public void write(byte[] buffer, int offset, int length) {
                try {
                    out.write(buffer, offset, length);
                } catch (IOException e) {
                    hasErrors = true;
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.578 -0500", hash_original_method = "F955A307858660E97C305258EF6CF319", hash_generated_method = "214AD174D924F08694AA0C872FA681FC")
            @Override
public void close() {
                try {
                    out.close();
                } catch (IOException e) {
                    hasErrors = true;
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.579 -0500", hash_original_method = "A7144C313F2BBCA14DD174D533CF0C30", hash_generated_method = "3F11936379CA62A858501A5B371F8665")
            @Override
public void flush() {
                try {
                    out.flush();
                } catch (IOException e) {
                    hasErrors = true;
                }
            }

            
        }


        
    }


    
    private final class Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.582 -0500", hash_original_field = "FFE7EE17DFA37A68070A0F0495753B29", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")

        private  String key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.583 -0500", hash_original_field = "24B7249375BB123C96570B196EC6FE40", hash_generated_field = "47E38F001ED3E4E2BB8D4D488C8C03FF")

        private  long[] lengths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.584 -0500", hash_original_field = "1C01055F9B12BC464399BBCE2DA8DF05", hash_generated_field = "1948B1A97D5C03C3163AE2F5DE57C5D5")

        private boolean readable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.584 -0500", hash_original_field = "72797F35411682FC83A65A9C68DF6C6D", hash_generated_field = "42500C0BD0D534C6B3B5904249FFA61F")

        private Editor currentEditor;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.585 -0500", hash_original_method = "A48AD7F9473C4832EA43939DE55B0830", hash_generated_method = "28E8729E8B6A75F70CC7FCBEDCF9513B")
        private Entry(String key) {
            this.key = key;
            this.lengths = new long[valueCount];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.586 -0500", hash_original_method = "5393AA568299AD2184B5004B9545BCCA", hash_generated_method = "03647AEDC344996F8A5B2BD648922FE8")
        public String getLengths() throws IOException {
            StringBuilder result = new StringBuilder();
            for (long size : lengths) {
                result.append(' ').append(size);
            }
            return result.toString();
        }

        /**
         * Set lengths using decimal numbers like "10123".
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.587 -0500", hash_original_method = "38ABC3E1459516CB332E39C8B303294B", hash_generated_method = "070BD6C8709437C82E9BFA929CA9E8F0")
        private void setLengths(String[] strings) throws IOException {
            if (strings.length != valueCount) {
                throw invalidLengths(strings);
            }

            try {
                for (int i = 0; i < strings.length; i++) {
                    lengths[i] = Long.parseLong(strings[i]);
                }
            } catch (NumberFormatException e) {
                throw invalidLengths(strings);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.588 -0500", hash_original_method = "0EB1B022FC0EF6548A3015E3FEB332B5", hash_generated_method = "2F5E58135766278DA89920E448D545D8")
        private IOException invalidLengths(String[] strings) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strings));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.589 -0500", hash_original_method = "C9A2E947DD05DC3D51A797932ED86E55", hash_generated_method = "FC7E5242FBCD23B3B5486AC0EC99986A")
        public File getCleanFile(int i) {
            return new File(directory, key + "." + i);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.590 -0500", hash_original_method = "7E5BF4AC0CC24327CE09DE834205313B", hash_generated_method = "1A38E92C1D82B1CF974DA2CF845467BB")
        public File getDirtyFile(int i) {
            return new File(directory, key + "." + i + ".tmp");
        }

        
    }

    /**
     * Drops the entry for {@code key} if it exists and can be removed. Entries
     * actively being edited cannot be removed.
     *
     * @return true if an entry was removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.554 -0500", hash_original_method = "EADC8C19CC119124A893E81F5BBBE260", hash_generated_method = "C30DD03D42B9454A502C47D4F052FDE1")
    public synchronized boolean remove(String key) throws IOException {
        checkNotClosed();
        validateKey(key);
        Entry entry = lruEntries.get(key);
        if (entry == null || entry.currentEditor != null) {
            return false;
        }

        for (int i = 0; i < valueCount; i++) {
            File file = entry.getCleanFile(i);
            if (!file.delete()) {
                throw new IOException("failed to delete " + file);
            }
            size -= entry.lengths[i];
            entry.lengths[i] = 0;
        }

        redundantOpCount++;
        journalWriter.append(REMOVE + ' ' + key + '\n');
        lruEntries.remove(key);

        if (journalRebuildRequired()) {
            executorService.submit(cleanupCallable);
        }

        return true;
    }

    /**
     * Returns true if this cache has been closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.555 -0500", hash_original_method = "DD17EBB3E7F8098B41E8CF3D3DB045E0", hash_generated_method = "9933F4305E908D89F92091D2D46F8CDB")
    public boolean isClosed() {
        return journalWriter == null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.556 -0500", hash_original_method = "8ED19EB33A6AB2822DDF1831EB4A2E5C", hash_generated_method = "98226437BAFFFCF9D555D1F518B4CC99")
    private void checkNotClosed() {
        if (journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /**
     * Force buffered operations to the filesystem.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.557 -0500", hash_original_method = "329F096E2383A78FF3370B422D55028D", hash_generated_method = "ADD1FDEA2659698689B0866898AF2F6A")
    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        journalWriter.flush();
    }

    /**
     * Closes this cache. Stored values will remain on the filesystem.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.558 -0500", hash_original_method = "99CE1AB60FDF93828647C541E1949F71", hash_generated_method = "5DFCE93F99CC30C5C7222F42DC2D6BD3")
    public synchronized void close() throws IOException {
        if (journalWriter == null) {
            return; // already closed
        }
        for (Entry entry : new ArrayList<Entry>(lruEntries.values())) {
            if (entry.currentEditor != null) {
                entry.currentEditor.abort();
            }
        }
        trimToSize();
        journalWriter.close();
        journalWriter = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.559 -0500", hash_original_method = "52FB98FFFDCED62623018A96063CC5F4", hash_generated_method = "CCACECABD0734F4B95C4E0FA921B1A33")
    private void trimToSize() throws IOException {
        while (size > maxSize) {
            Map.Entry<String, Entry> toEvict = lruEntries.eldest();
            remove(toEvict.getKey());
        }
    }

    /**
     * Closes the cache and deletes all of its stored values. This will delete
     * all files in the cache directory including files that weren't created by
     * the cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.559 -0500", hash_original_method = "E0DF0E5E95BB69DC7E72889656D60AB7", hash_generated_method = "160F3AEDF71F294F3E46D3510750FE44")
    public void delete() throws IOException {
        close();
        IoUtils.deleteContents(directory);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.560 -0500", hash_original_method = "A6AB05B3A3783BAC84CED8DCEEB398D1", hash_generated_method = "8517A566F0CE10EF13C4AF4DD9A9CE90")
    private void validateKey(String key) {
        if (key.contains(" ") || key.contains("\n") || key.contains("\r")) {
            throw new IllegalArgumentException(
                    "keys must not contain spaces or newlines: \"" + key + "\"");
        }
    }
}

