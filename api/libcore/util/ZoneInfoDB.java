package libcore.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import libcore.io.BufferIterator;
import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.MemoryMappedFile;
import org.apache.harmony.luni.internal.util.TimezoneGetter;

public final class ZoneInfoDB {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.206 -0400", hash_original_method = "6AD30DC678AA79198B9A535BC6352D82", hash_generated_method = "F186C26C76B663EC1F34BF428D4B8EAF")
    private  ZoneInfoDB() {
        
    }

    
        private static String readVersion() {
        try {
            byte[] bytes = IoUtils.readFileAsByteArray(ZONE_DIRECTORY_NAME + "zoneinfo.version");
            return new String(bytes, 0, bytes.length, Charsets.ISO_8859_1).trim();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    
        private static MemoryMappedFile mapData() {
        try {
            return MemoryMappedFile.mmapRO(ZONE_FILE_NAME);
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
    }

    
        private static void readIndex() {
        MemoryMappedFile mappedFile = null;
        try {
            mappedFile = MemoryMappedFile.mmapRO(INDEX_FILE_NAME);
            readIndex(mappedFile);
        } catch (Exception ex) {
            throw new AssertionError(ex);
        } finally {
            IoUtils.closeQuietly(mappedFile);
        }
    }

    
        private static void readIndex(MemoryMappedFile mappedFile) throws ErrnoException, IOException {
        BufferIterator it = mappedFile.bigEndianIterator();
        final int SIZEOF_TZNAME = 40;
        final int SIZEOF_TZINT = 4;
        byte[] idBytes = new byte[SIZEOF_TZNAME];
        int numEntries = (int) mappedFile.size() / (SIZEOF_TZNAME + 3*SIZEOF_TZINT);
        char[] idChars = new char[numEntries * SIZEOF_TZNAME];
        int[] idEnd = new int[numEntries];
        int idOffset = 0;
        byteOffsets = new int[numEntries];
        rawUtcOffsets = new int[numEntries];
        for (int i = 0; i < numEntries; i++) {
            it.readByteArray(idBytes, 0, idBytes.length);
            byteOffsets[i] = it.readInt();
            int length = it.readInt();
            if (length < 44) {
                throw new AssertionError("length in index file < sizeof(tzhead)");
            }
            rawUtcOffsets[i] = it.readInt();
            int len = idBytes.length;
            for (int j = 0; j < len; j++) {
                if (idBytes[j] == 0) {
                    break;
                }
                idChars[idOffset++] = (char) (idBytes[j] & 0xFF);
            }
            idEnd[i] = idOffset;
        }
        String allIds = new String(idChars, 0, idOffset);
        ids = new String[numEntries];
        for (int i = 0; i < numEntries; i++) {
            ids[i] = allIds.substring(i == 0 ? 0 : idEnd[i - 1], idEnd[i]);
        }
    }

    
        private static TimeZone makeTimeZone(String id) throws IOException {
        int index = Arrays.binarySearch(ids, id);
        if (index < 0) {
            return null;
        }
        BufferIterator data = ALL_ZONE_DATA.bigEndianIterator();
        data.skip(byteOffsets[index]);
        if (data.readInt() != 0x545a6966) { 
            return null;
        }
        data.skip(28);
        int tzh_timecnt = data.readInt();
        int tzh_typecnt = data.readInt();
        data.skip(4);
        int[] transitions = new int[tzh_timecnt];
        data.readIntArray(transitions, 0, transitions.length);
        byte[] type = new byte[tzh_timecnt];
        data.readByteArray(type, 0, type.length);
        int[] gmtOffsets = new int[tzh_typecnt];
        byte[] isDsts = new byte[tzh_typecnt];
        for (int i = 0; i < tzh_typecnt; ++i) {
            gmtOffsets[i] = data.readInt();
            isDsts[i] = data.readByte();
            data.skip(1);
        }
        return new ZoneInfo(id, transitions, type, gmtOffsets, isDsts);
    }

    
        public static String[] getAvailableIDs() {
        return ids.clone();
    }

    
        public static String[] getAvailableIDs(int rawOffset) {
        List<String> matches = new ArrayList<String>();
        for (int i = 0, end = rawUtcOffsets.length; i < end; i++) {
            if (rawUtcOffsets[i] == rawOffset) {
                matches.add(ids[i]);
            }
        }
        return matches.toArray(new String[matches.size()]);
    }

    
        public static TimeZone getSystemDefault() {
        synchronized (LOCK) {
            TimezoneGetter tzGetter = TimezoneGetter.getInstance();
            String zoneName = tzGetter != null ? tzGetter.getId() : null;
            if (zoneName != null) {
                zoneName = zoneName.trim();
            }
            if (zoneName == null || zoneName.isEmpty()) {
                zoneName = "localtime";
            }
            return TimeZone.getTimeZone(zoneName);
        }
    }

    
        public static TimeZone getTimeZone(String id) {
        if (id == null) {
            return null;
        }
        try {
            return makeTimeZone(id);
        } catch (IOException ignored) {
            return null;
        }
    }

    
        @DSModeled(DSC.SAFE)
    public static String getVersion() {
        return VERSION;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.208 -0400", hash_original_field = "495280464DE95B6FD090B57B9860D1B3", hash_generated_field = "49C9C23C9B258E6AEE8FF33EFFF6AFCA")

    private static final String ZONE_DIRECTORY_NAME = System.getenv("ANDROID_ROOT") + "/usr/share/zoneinfo/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.208 -0400", hash_original_field = "D224DE24E4599FFCC9CC6AC941AF9ECB", hash_generated_field = "A85D935C13B0C5A5348159650F09B6E9")

    private static final String ZONE_FILE_NAME = ZONE_DIRECTORY_NAME + "zoneinfo.dat";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.209 -0400", hash_original_field = "C180D7A84402C7C9DDB79A2F8AD72779", hash_generated_field = "466D82FF903CFF65EF00654F896B6CB1")

    private static final String INDEX_FILE_NAME = ZONE_DIRECTORY_NAME + "zoneinfo.idx";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.209 -0400", hash_original_field = "6DCE3A5BA4E0A2B19B31D4590131918D", hash_generated_field = "74DA88035CA3F88FC209C28C65A412F9")

    private static final Object LOCK = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.209 -0400", hash_original_field = "992AE5CB06690900DF9C6CA45B709E13", hash_generated_field = "14C7FABB4A49B8997B9A7A85BB588B5F")

    private static final String VERSION = readVersion();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.209 -0400", hash_original_field = "92D1D1CAF5C4DCC1C9B0D9AF21FAA3AF", hash_generated_field = "8F51E99D7858B694EBA77A8D099C5E8A")

    private static final MemoryMappedFile ALL_ZONE_DATA = mapData();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.209 -0400", hash_original_field = "BF516925BB37A8544C8EE19A24E15C05", hash_generated_field = "32AE8609238F038B3D4A7AF42E97A34A")

    private static String[] ids;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.209 -0400", hash_original_field = "F8BB994A20520FB0F32A470ADC90A8C2", hash_generated_field = "BBB14D36BADD097A53587E02DEE74F4B")

    private static int[] byteOffsets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.209 -0400", hash_original_field = "A7127A22FF559E8CC7C8FA34C2639B63", hash_generated_field = "11E6859EA7C3A97FDEE418858A2BF997")

    private static int[] rawUtcOffsets;
    static {
        readIndex();
    }
    
}

