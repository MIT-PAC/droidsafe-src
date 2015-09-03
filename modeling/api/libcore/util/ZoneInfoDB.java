/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package libcore.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
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

    /**
     * Reads the file indicating the database version in use.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.734 -0500", hash_original_method = "20BE396DAB95918DA62C140FCD4BD874", hash_generated_method = "28C47D9E2EBF624C6615213B8BB557A5")
    
private static String readVersion() {
        try {
            byte[] bytes = IoUtils.readFileAsByteArray(ZONE_DIRECTORY_NAME + "zoneinfo.version");
            return new String(bytes, 0, bytes.length, Charsets.ISO_8859_1).trim();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.737 -0500", hash_original_method = "603C00D789F9F2C664CA8CF3ACA627B8", hash_generated_method = "8A7D1A6F2D2F629E94B107C6F9D7F7CC")
    
private static MemoryMappedFile mapData() {
        try {
            return MemoryMappedFile.mmapRO(ZONE_FILE_NAME);
        } catch (ErrnoException errnoException) {
            throw new AssertionError(errnoException);
        }
    }

    /**
     * Traditionally, Unix systems have one file per time zone. We have one big data file, which
     * is just a concatenation of regular time zone files. To allow random access into this big
     * data file, we also have an index. We read the index at startup, and keep it in memory so
     * we can binary search by id when we need time zone data.
     *
     * The format of this file is, I believe, Android's own, and undocumented.
     *
     * All this code assumes strings are US-ASCII.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.740 -0500", hash_original_method = "880C6B6FFD6476FB4BC9E8F8AE296E97", hash_generated_method = "3770FEFFBAC67FD1905A83F293D6AE9F")
    
private static void readIndex() {
       /* MemoryMappedFile mappedFile = null;
        try {
            mappedFile = MemoryMappedFile.mmapRO(INDEX_FILE_NAME);
            readIndex(mappedFile);
        } catch (Exception ex) {
            throw new AssertionError(ex);
        } finally {
            IoUtils.closeQuietly(mappedFile);
        }*/
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.744 -0500", hash_original_method = "8ADB7A707EA8ED75C4748B3AFCE85217", hash_generated_method = "55DA8CCF299EFDB37DDD4013334EE5E9")
    
private static void readIndex(MemoryMappedFile mappedFile) throws ErrnoException, IOException {
        BufferIterator it = mappedFile.bigEndianIterator();

        // The database reserves 40 bytes for each id.
        final int SIZEOF_TZNAME = 40;
        // The database uses 32-bit (4 byte) integers.
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

            // Don't include null chars in the String
            int len = idBytes.length;
            for (int j = 0; j < len; j++) {
                if (idBytes[j] == 0) {
                    break;
                }
                idChars[idOffset++] = (char) (idBytes[j] & 0xFF);
            }

            idEnd[i] = idOffset;
        }

        // We create one string containing all the ids, and then break that into substrings.
        // This way, all ids share a single char[] on the heap.
        String allIds = new String(idChars, 0, idOffset);
        ids = new String[numEntries];
        for (int i = 0; i < numEntries; i++) {
            ids[i] = allIds.substring(i == 0 ? 0 : idEnd[i - 1], idEnd[i]);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.747 -0500", hash_original_method = "A9F0A2BED5BA3B6592EEADCCDFB17984", hash_generated_method = "E39079190DC539FF1ACAE60F8F633B16")
    
private static TimeZone makeTimeZone(String id) throws IOException {
        // Work out where in the big data file this time zone is.
        int index = Arrays.binarySearch(ids, id);
        if (index < 0) {
            return null;
        }

        BufferIterator data = ALL_ZONE_DATA.bigEndianIterator();
        data.skip(byteOffsets[index]);

        // Variable names beginning tzh_ correspond to those in "tzfile.h".
        // Check tzh_magic.
        if (data.readInt() != 0x545a6966) { // "TZif"
            return null;
        }

        // Skip the uninteresting part of the header.
        data.skip(28);

        // Read the sizes of the arrays we're about to read.
        int tzh_timecnt = data.readInt();
        int tzh_typecnt = data.readInt();

        data.skip(4); // Skip tzh_charcnt.

        int[] transitions = new int[tzh_timecnt];
        data.readIntArray(transitions, 0, transitions.length);

        byte[] type = new byte[tzh_timecnt];
        data.readByteArray(type, 0, type.length);

        int[] gmtOffsets = new int[tzh_typecnt];
        byte[] isDsts = new byte[tzh_typecnt];
        for (int i = 0; i < tzh_typecnt; ++i) {
            gmtOffsets[i] = data.readInt();
            isDsts[i] = data.readByte();
            // We skip the abbreviation index. This would let us provide historically-accurate
            // time zone abbreviations (such as "AHST", "YST", and "AKST" for standard time in
            // America/Anchorage in 1982, 1983, and 1984 respectively). ICU only knows the current
            // names, though, so even if we did use this data to provide the correct abbreviations
            // for en_US, we wouldn't be able to provide correct abbreviations for other locales,
            // nor would we be able to provide correct long forms (such as "Yukon Standard Time")
            // for any locale. (The RI doesn't do any better than us here either.)
            data.skip(1);
        }

        return new ZoneInfo(id, transitions, type, gmtOffsets, isDsts);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.750 -0500", hash_original_method = "659D0293BDF51E54E117CD011B6D5569", hash_generated_method = "4E4D93DDC3024AC09E6B60611D266549")
    
    public static String[] getAvailableIDs() {
        return getAvailableIDs(0);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.752 -0500", hash_original_method = "91B44B1DD587FF59D37E00614C5C4739", hash_generated_method = "B9911AE44E980EDBB56D169BD081B9A3")
    
public static String[] getAvailableIDs(int rawOffset) {
       /* List<String> matches = new ArrayList<String>();
        for (int i = 0, end = rawUtcOffsets.length; i < end; i++) {
            if (rawUtcOffsets[i] == rawOffset) {
                matches.add(ids[i]);
            }
        }
        return matches.toArray(new String[matches.size()]);*/
        if (ids == null) {
            ids = new String[1];
            ids[0] = new String("<zone-id>");
        }
        ids[0].addTaint(rawOffset);
        return ids;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.755 -0500", hash_original_method = "AF44A55E6688F7315D6A27422073E89E", hash_generated_method = "FDDDE13339454F68759F52C88F9D59B8")
    
public static TimeZone getSystemDefault() {
       /* synchronized (LOCK) {
            TimezoneGetter tzGetter = TimezoneGetter.getInstance();
            String zoneName = tzGetter != null ? tzGetter.getId() : null;
            if (zoneName != null) {
                zoneName = zoneName.trim();
            }
            if (zoneName == null || zoneName.isEmpty()) {
                // use localtime for the simulator
                // TODO: what does that correspond to?
                zoneName = "localtime";
            }
            return TimeZone.getTimeZone(zoneName);
        }*/
        return new ZoneInfo(DSOnlyType.DONTCARE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.757 -0500", hash_original_method = "8DE7908FF133C8748934019B6455568E", hash_generated_method = "F221F71F3E58C301D3AEAAEE17106F8E")
    
public static TimeZone getTimeZone(String id) {
      /*  if (id == null) {
            return null;
        }
        try {
            return makeTimeZone(id);
        } catch (IOException ignored) {
            return null;
        }*/

        TimeZone tz = new ZoneInfo(DSOnlyType.DONTCARE);
        tz.addTaint(id.getTaint());
        return tz;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.760 -0500", hash_original_method = "6B53A6B84DE76124A7D6E4541A96BDC2", hash_generated_method = "C17ED04FA3DE2D235A10F84B36CF8827")
    
public static String getVersion() {
        return VERSION;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.708 -0500", hash_original_field = "97C1EDE550098D2F933B57040BF84EB8", hash_generated_field = "49C9C23C9B258E6AEE8FF33EFFF6AFCA")

    private static final String ZONE_DIRECTORY_NAME =
            System.getenv("ANDROID_ROOT") + "/usr/share/zoneinfo/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.711 -0500", hash_original_field = "AD32EF9AA783B9B400D0C7B433091C9C", hash_generated_field = "A85D935C13B0C5A5348159650F09B6E9")

    private static final String ZONE_FILE_NAME = ZONE_DIRECTORY_NAME + "zoneinfo.dat";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.714 -0500", hash_original_field = "B7C1C412D7C1AC01120B57511B68429D", hash_generated_field = "466D82FF903CFF65EF00654F896B6CB1")

    private static final String INDEX_FILE_NAME = ZONE_DIRECTORY_NAME + "zoneinfo.idx";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.716 -0500", hash_original_field = "D74064F1D3C26A0EAAF918907141DE73", hash_generated_field = "74DA88035CA3F88FC209C28C65A412F9")

    private static final Object LOCK = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.719 -0500", hash_original_field = "4DD44DF12EC46BFBF873E89F996D361D", hash_generated_field = "14C7FABB4A49B8997B9A7A85BB588B5F")

    private static final String VERSION = readVersion();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.722 -0500", hash_original_field = "904CF02D60C2F852BA2909B4024131BC", hash_generated_field = "8F51E99D7858B694EBA77A8D099C5E8A")

    private static final MemoryMappedFile ALL_ZONE_DATA = mapData();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.724 -0500", hash_original_field = "46357F5F50E8370D8C2E58985F53C30A", hash_generated_field = "32AE8609238F038B3D4A7AF42E97A34A")

    private static String[] ids;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.726 -0500", hash_original_field = "8D1B0318FD06B82E1FD7A3AA87035715", hash_generated_field = "BBB14D36BADD097A53587E02DEE74F4B")

    private static int[] byteOffsets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.729 -0500", hash_original_field = "555308CE4E457FEEDD70B63F753E9C09", hash_generated_field = "11E6859EA7C3A97FDEE418858A2BF997")

    private static int[] rawUtcOffsets;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:29.732 -0500", hash_original_method = "6AD30DC678AA79198B9A535BC6352D82", hash_generated_method = "AD9962427B97AE7A53554E3AAB13AE6D")
    
private ZoneInfoDB() {
    }
    static {
        readIndex();
    }
    
}

