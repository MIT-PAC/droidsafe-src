package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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

public class EventLog {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.192 -0400", hash_original_method = "F2F67500BFF17861178525A826A9D5EF", hash_generated_method = "53C7EDD75DD3FA6552B96F6BC591B81D")
    @DSModeled(DSC.SAFE)
    public EventLog() {
        // ---------- Original Method ----------
    }

    
        public static int writeEvent(int tag, int value) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int writeEvent(int tag, long value) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int writeEvent(int tag, String str) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int writeEvent(int tag, Object... list) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void readEvents(int[] tags, Collection<Event> output) throws IOException {
    }

    
        public static String getTagName(int tag) {
        readTagsFile();
        return sTagNames.get(tag);
    }

    
        public static int getTagCode(String name) {
        readTagsFile();
        Integer code = sTagCodes.get(name);
        return code != null ? code : -1;
    }

    
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
        } finally {
            try { if (reader != null) reader.close(); } catch (IOException e) {}
        }
    }

    
    public static final class Event {
        private ByteBuffer mBuffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.194 -0400", hash_original_method = "FACE593E138E02D29B65D04F3AFD5558", hash_generated_method = "739AE72394F20F4EDF7EF4132FFFBA55")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Event(byte[] data) {
            dsTaint.addTaint(data[0]);
            mBuffer = ByteBuffer.wrap(data);
            mBuffer.order(ByteOrder.nativeOrder());
            // ---------- Original Method ----------
            //mBuffer = ByteBuffer.wrap(data);
            //mBuffer.order(ByteOrder.nativeOrder());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.194 -0400", hash_original_method = "C727D17C1ABE4CA2F41D8D2314B99577", hash_generated_method = "DDB675567A7BEF8F501CA44A6B78579C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getProcessId() {
            int var74E2E058DA7FA6DFE349A6FD89345E32_1692889771 = (mBuffer.getInt(PROCESS_OFFSET));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mBuffer.getInt(PROCESS_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.195 -0400", hash_original_method = "5C1055DF8325BC493282A721B537C094", hash_generated_method = "407CCC78055E7603DC15655BA2112B87")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getThreadId() {
            int varD37A372EE6D3AE184547870BC2768F10_2067673034 = (mBuffer.getInt(THREAD_OFFSET));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mBuffer.getInt(THREAD_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.195 -0400", hash_original_method = "8DE4962A92E5344AF237DA513A746866", hash_generated_method = "9BDA03261B74F3A5862762E7ACFB3F78")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long getTimeNanos() {
            long var4ADE84CBB53AEA0E013A6EF7194CC4A3_1382007830 = (mBuffer.getInt(SECONDS_OFFSET) * 1000000000l
                    + mBuffer.getInt(NANOSECONDS_OFFSET));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return mBuffer.getInt(SECONDS_OFFSET) * 1000000000l
                    //+ mBuffer.getInt(NANOSECONDS_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.195 -0400", hash_original_method = "E731C73BB2559185B3FCAA3365113EC6", hash_generated_method = "8A42898F3A54B370B7FF89C99C51A940")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getTag() {
            int varD454B3BD90192CEEB24FF33DEA85D100_1324775567 = (mBuffer.getInt(TAG_OFFSET));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mBuffer.getInt(TAG_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.195 -0400", hash_original_method = "87D859F946E538D2E12E387EABE85774", hash_generated_method = "A0EFAA787B7930356E3BBBF471F43ADB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized Object getData() {
            try 
            {
                mBuffer.limit(PAYLOAD_START + mBuffer.getShort(LENGTH_OFFSET));
                mBuffer.position(DATA_START);
                Object var5CE189447800F5DBFD458DEC6F9CBC89_1720761064 = (decodeObject());
            } //End block
            catch (IllegalArgumentException e)
            {
                Log.wtf(TAG, "Illegal entry payload: tag=" + getTag(), e);
            } //End block
            catch (BufferUnderflowException e)
            {
                Log.wtf(TAG, "Truncated entry payload: tag=" + getTag(), e);
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //mBuffer.limit(PAYLOAD_START + mBuffer.getShort(LENGTH_OFFSET));
                //mBuffer.position(DATA_START);  
                //return decodeObject();
            //} catch (IllegalArgumentException e) {
                //Log.wtf(TAG, "Illegal entry payload: tag=" + getTag(), e);
                //return null;
            //} catch (BufferUnderflowException e) {
                //Log.wtf(TAG, "Truncated entry payload: tag=" + getTag(), e);
                //return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.196 -0400", hash_original_method = "153DDF284ABF68138956B6F9D94EE6B9", hash_generated_method = "B365B5D7FDCFD548576016D2047B3A05")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Object decodeObject() {
            byte type;
            type = mBuffer.get();
            //Begin case INT_TYPE 
            Object var5D12675610D924F893F22D56263B7649_1949801988 = ((Integer) mBuffer.getInt());
            //End case INT_TYPE 
            //Begin case LONG_TYPE 
            Object var4B8E8CAFD264682769CF0607A233AE8E_808004535 = ((Long) mBuffer.getLong());
            //End case LONG_TYPE 
            //Begin case STRING_TYPE 
            try 
            {
                int length;
                length = mBuffer.getInt();
                int start;
                start = mBuffer.position();
                mBuffer.position(start + length);
                Object varA16B5560955B24E5F58DCA84AFB486C3_1691398119 = (new String(mBuffer.array(), start, length, "UTF-8"));
            } //End block
            catch (UnsupportedEncodingException e)
            {
                Log.wtf(TAG, "UTF-8 is not supported", e);
            } //End block
            //End case STRING_TYPE 
            //Begin case LIST_TYPE 
            int length;
            length = mBuffer.get();
            //End case LIST_TYPE 
            //Begin case LIST_TYPE 
            length += 256;
            //End case LIST_TYPE 
            //Begin case LIST_TYPE 
            Object[] array;
            array = new Object[length];
            //End case LIST_TYPE 
            //Begin case LIST_TYPE 
            {
                int i;
                i = 0;
                array[i] = decodeObject();
            } //End collapsed parenthetic
            //End case LIST_TYPE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown entry type: " + type);
            //End case default 
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final int LENGTH_OFFSET = 0;
        private static final int PROCESS_OFFSET = 4;
        private static final int THREAD_OFFSET = 8;
        private static final int SECONDS_OFFSET = 12;
        private static final int NANOSECONDS_OFFSET = 16;
        private static final int PAYLOAD_START = 20;
        private static final int TAG_OFFSET = 20;
        private static final int DATA_START = 24;
        private static final byte INT_TYPE    = 0;
        private static final byte LONG_TYPE   = 1;
        private static final byte STRING_TYPE = 2;
        private static final byte LIST_TYPE   = 3;
    }


    
    private static final String TAG = "EventLog";
    private static final String TAGS_FILE = "/system/etc/event-log-tags";
    private static final String COMMENT_PATTERN = "^\\s*(#.*)?$";
    private static final String TAG_PATTERN = "^\\s*(\\d+)\\s+(\\w+)\\s*(\\(.*\\))?\\s*$";
    private static HashMap<String, Integer> sTagCodes = null;
    private static HashMap<Integer, String> sTagNames = null;
}

