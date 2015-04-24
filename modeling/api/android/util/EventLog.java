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


package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import droidsafe.helpers.DSUtils;

public class EventLog {
    
    public static int writeEvent(int tag, int value) {
        return (tag + value);
    }
    
    public static int writeEvent(int tag, long value) {
        return (int)(tag + value);
    }
    
    public static int writeEvent(int tag, String str) {
        return (tag + str.getTaintInt());
    }
    
    public static int writeEvent(int tag, Object... list) {
        return (list.getTaintInt() + tag);
    }
    
    public static void readEvents(int[] tags, Collection<Event> output) throws IOException {
    }

    /**
     * Get the name associated with an event type tag code.
     * @param tag code to look up
     * @return the name of the tag, or null if no tag has that number
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.125 -0500", hash_original_method = "0174D1EFCDD533F8825A3612A3EF7C46", hash_generated_method = "D3EC0610E6DAE7C7CAA4131645980B8D")
    
public static String getTagName(int tag) {
        readTagsFile();
        return sTagNames.get(tag);
    }

    /**
     * Get the event type tag code associated with an event name.
     * @param name of event to look up
     * @return the tag code, or -1 if no tag has that name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.127 -0500", hash_original_method = "64FE1472AE07DE7D4E762120B0BAE1ED", hash_generated_method = "E1A52AA65125993A67C924076F7E272C")
    
public static int getTagCode(String name) {
        readTagsFile();
        Integer code = sTagCodes.get(name);
        return code != null ? code : -1;
    }

    /**
     * Read TAGS_FILE, populating sTagCodes and sTagNames, if not already done.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.130 -0500", hash_original_method = "AFAE197FB851905387419AFB7B96BE3D", hash_generated_method = "021B766E7D2435C8BD1B563E57AFC62F")
    
private static synchronized void readTagsFile() {
        if (sTagCodes != null && sTagNames != null) return;

        sTagCodes = new HashMap<String, Integer>();
        sTagNames = new HashMap<Integer, String>();

        Pattern comment = Pattern.compile(COMMENT_PATTERN);
        Pattern tag = Pattern.compile(TAG_PATTERN);
        BufferedReader reader = null;
        String line;

        try {
            reader = new BufferedReader(new FileReader(TAGS_FILE), 256);
            while ((line = reader.readLine()) != null) {
                if (comment.matcher(line).matches()) continue;

                Matcher m = tag.matcher(line);
                if (!m.matches()) {
                    Log.wtf(TAG, "Bad entry in " + TAGS_FILE + ": " + line);
                    continue;
                }

                try {
                    int num = Integer.parseInt(m.group(1));
                    String name = m.group(2);
                    sTagCodes.put(name, num);
                    sTagNames.put(num, name);
                } catch (NumberFormatException e) {
                    Log.wtf(TAG, "Error in " + TAGS_FILE + ": " + line, e);
                }
            }
        } catch (IOException e) {
            Log.wtf(TAG, "Error reading " + TAGS_FILE, e);
            // Leave the maps existing but unpopulated
        } finally {
            try { if (reader != null) reader.close(); } catch (IOException e) {}
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.039 -0500", hash_original_field = "662231DFFFA9D09E53289EFEDAC9B83D", hash_generated_field = "DB25E28C44FF4AB3A8E349B062479A96")

    private static final String TAG = "EventLog";
    
    public static final class Event {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.056 -0500", hash_original_field = "14CD9DF7E7D1E41029226B0C7C19B7A1", hash_generated_field = "4E9207C020D4BC18685FE64EF1B701ED")

        private static final int LENGTH_OFFSET = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.058 -0500", hash_original_field = "5D285E8A20D96AC71B625C1BDB3AE54D", hash_generated_field = "E3159715193D4B91B22E77BCBE14DF77")

        private static final int PROCESS_OFFSET = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.060 -0500", hash_original_field = "E362B0511FA3D79664D1878AC8E6A1F1", hash_generated_field = "C82447906A1E2ABB1F3BE3DDB5735023")

        private static final int THREAD_OFFSET = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.063 -0500", hash_original_field = "5288E892C22BAFAC7CFFFC8A55C27860", hash_generated_field = "E49B4EA011D0CB63BF3691C839E09C3E")

        private static final int SECONDS_OFFSET = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.065 -0500", hash_original_field = "55BF8CFF251ECB298E081C9F07DBBCFD", hash_generated_field = "C5563766F0BD16F7E0C604F669223D9D")

        private static final int NANOSECONDS_OFFSET = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.068 -0500", hash_original_field = "896A28DA2CBCBBE4ADFC99AFA03FD254", hash_generated_field = "D38325D4D2ABA5BC474228D155C874ED")

        private static final int PAYLOAD_START = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.071 -0500", hash_original_field = "293ED38A1626E543061B9A6C35235F6C", hash_generated_field = "61B24A61947EBA00F5F66CA42990D87B")

        private static final int TAG_OFFSET = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.073 -0500", hash_original_field = "39D7FEC3301AA48B7A5DB3B2DC361F61", hash_generated_field = "32B83A7E80D0C8C5744209DAAAFC71EA")

        private static final int DATA_START = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.076 -0500", hash_original_field = "BB7A9F38794A7729D60110028EA594B1", hash_generated_field = "90607B1CECA591A7D57C2F3D4FE312C5")

        private static final byte INT_TYPE    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.078 -0500", hash_original_field = "D2EAC7BE1D393389706B84E4059BE247", hash_generated_field = "BDF743648047E78C2EB377A8FBB611C3")

        private static final byte LONG_TYPE   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.081 -0500", hash_original_field = "AF3404044EB70ACE02DBE99761F92270", hash_generated_field = "CE17CF24D6536F55DC5D2C562B69DDE0")

        private static final byte STRING_TYPE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.083 -0500", hash_original_field = "5FD80718C09C34DCFEE5E0A980ADA8A1", hash_generated_field = "3E3F6D5EA3820F4968BE8D121B14CB23")

        private static final byte LIST_TYPE   = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.053 -0500", hash_original_field = "FB05545F4651BAFFFA13E88DBDCA5C94", hash_generated_field = "FABD0AE272C28D49511B5C6B44D8F85C")

        private  ByteBuffer mBuffer;

        /** @param data containing event, read from the system */
        /*package*/ @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.086 -0500", hash_original_method = "FACE593E138E02D29B65D04F3AFD5558", hash_generated_method = "FACE593E138E02D29B65D04F3AFD5558")
        
Event(byte[] data) {
            mBuffer = ByteBuffer.wrap(data);
            mBuffer.order(ByteOrder.nativeOrder());
        }

        /** @return the process ID which wrote the log entry */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.088 -0500", hash_original_method = "C727D17C1ABE4CA2F41D8D2314B99577", hash_generated_method = "FDD1482CDC79BC1B40E4331B4D7E9867")
        
public int getProcessId() {
            return mBuffer.getInt(PROCESS_OFFSET);
        }

        /** @return the thread ID which wrote the log entry */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.090 -0500", hash_original_method = "5C1055DF8325BC493282A721B537C094", hash_generated_method = "08F8DF8CC740175CED8E1D8B0FDA240C")
        
public int getThreadId() {
            return mBuffer.getInt(THREAD_OFFSET);
        }

        /** @return the wall clock time when the entry was written */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.093 -0500", hash_original_method = "8DE4962A92E5344AF237DA513A746866", hash_generated_method = "5B0DCDF8FE42BF1B397F4D82DDFB0A1E")
        
public long getTimeNanos() {
            return mBuffer.getInt(SECONDS_OFFSET) * 1000000000l
                    + mBuffer.getInt(NANOSECONDS_OFFSET);
        }

        /** @return the type tag code of the entry */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.096 -0500", hash_original_method = "E731C73BB2559185B3FCAA3365113EC6", hash_generated_method = "FFCDF33F86204EE3A499675592AC033F")
        
public int getTag() {
            return mBuffer.getInt(TAG_OFFSET);
        }

        /** @return one of Integer, Long, String, null, or Object[] of same. */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.098 -0500", hash_original_method = "87D859F946E538D2E12E387EABE85774", hash_generated_method = "EC5AEE6DEFB579A24EA8C831D0FD9321")
        
public synchronized Object getData() {
            try {
                mBuffer.limit(PAYLOAD_START + mBuffer.getShort(LENGTH_OFFSET));
                mBuffer.position(DATA_START);  // Just after the tag.
                return decodeObject();
            } catch (IllegalArgumentException e) {
                Log.wtf(TAG, "Illegal entry payload: tag=" + getTag(), e);
                return null;
            } catch (BufferUnderflowException e) {
                Log.wtf(TAG, "Truncated entry payload: tag=" + getTag(), e);
                return null;
            }
        }

        /** @return the loggable item at the current position in mBuffer. */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.101 -0500", hash_original_method = "153DDF284ABF68138956B6F9D94EE6B9", hash_generated_method = "8C1B54AAE8A0937EC032905EE1B51BB1")
        
private Object decodeObject() {
            byte type = mBuffer.get();
            switch (type) {
            case INT_TYPE:
                return (Integer) mBuffer.getInt();

            case LONG_TYPE:
                return (Long) mBuffer.getLong();

            case STRING_TYPE:
                try {
                    int length = mBuffer.getInt();
                    int start = mBuffer.position();
                    mBuffer.position(start + length);
                    return new String(mBuffer.array(), start, length, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    Log.wtf(TAG, "UTF-8 is not supported", e);
                    return null;
                }

            case LIST_TYPE:
                int length = mBuffer.get();
                if (length < 0) length += 256;  // treat as signed byte
                Object[] array = new Object[length];
                for (int i = 0; i < length; ++i) array[i] = decodeObject();
                return array;

            default:
                throw new IllegalArgumentException("Unknown entry type: " + type);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.041 -0500", hash_original_field = "C049034F8AEAD3BF2798F83997FBAB95", hash_generated_field = "0B4C2C031E06758D5179435B0B36BCEB")

    private static final String TAGS_FILE = "/system/etc/event-log-tags";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.043 -0500", hash_original_field = "09D2159057C7400DFB72AFE18B0F43F5", hash_generated_field = "48AFCC2BBA5F6385F51E6182D6069D57")

    private static final String COMMENT_PATTERN = "^\\s*(#.*)?$";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.045 -0500", hash_original_field = "A22EC6052F882B184191DBC11009A505", hash_generated_field = "14FEF2C8C8D8463E6A4C7C29D61977B8")

    private static final String TAG_PATTERN = "^\\s*(\\d+)\\s+(\\w+)\\s*(\\(.*\\))?\\s*$";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.048 -0500", hash_original_field = "02AFEB9B1BC5169B863E7AEB2FC6FF92", hash_generated_field = "2B10BF81841A39E2BC7FDE536FF9284C")

    private static HashMap<String, Integer> sTagCodes = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.050 -0500", hash_original_field = "39E0092CD8E52E82EAEEDF9A3B1DCB9A", hash_generated_field = "CEA5978C366D6C8CA48AD139365847FD")

    private static HashMap<Integer, String> sTagNames = null;
    /** @hide */ @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.036 -0500", hash_original_method = "F2F67500BFF17861178525A826A9D5EF", hash_generated_method = "4FB5F007601D335E5DA571D7EA402053")
    
public EventLog() {}
}

