package android.util;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
// import Iterator to deal with enhanced for loop translation
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class EventLog {
    private static final String TAG = "EventLog";
    private static final String TAGS_FILE = "/system/etc/event-log-tags";
    private static final String COMMENT_PATTERN = "^\\s*(#.*)?$";
    private static final String TAG_PATTERN = "^\\s*(\\d+)\\s+(\\w+)\\s*(\\(.*\\))?\\s*$";
    private static HashMap<String, Integer> sTagCodes = null;
    private static HashMap<Integer, String> sTagNames = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "F2F67500BFF17861178525A826A9D5EF", hash_generated_method = "3D5A4B22472E1C5E63700A9AF776E73C")
    @DSModeled(DSC.SAFE)
    public EventLog() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "5F6A2310CBF2D6994F937F25B432B847", hash_generated_method = "04689FE206C8BE3B2C38283EA52974A6")
    public static int writeEvent(int tag, int value) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "7ED9CDD6AF8DD7F54C1DDAB3342D7417", hash_generated_method = "727D1AF88EF2B0B1BABEE210264F18DA")
    public static int writeEvent(int tag, long value) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "2A2EEFCE77942E21DB981FA6E5628F8C", hash_generated_method = "028DA9E7E932718254CD27C134ECE019")
    public static int writeEvent(int tag, String str) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "C0A88C027337FCE481F2EB6028E68083", hash_generated_method = "9710AF8BD2D8CE7688C6D0FDAB5E4302")
    public static int writeEvent(int tag, Object... list) {
        return DSUtils.UNKNOWN_INT;

    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "83359F8BE5A95C876DE0A2EAAB7DF3E6", hash_generated_method = "DCD61B74D60802C09EB83230063BF481")
    public static void readEvents(int[] tags, Collection<Event> output) throws IOException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "0174D1EFCDD533F8825A3612A3EF7C46", hash_generated_method = "D3EC0610E6DAE7C7CAA4131645980B8D")
    public static String getTagName(int tag) {
        readTagsFile();
        return sTagNames.get(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "64FE1472AE07DE7D4E762120B0BAE1ED", hash_generated_method = "E1A52AA65125993A67C924076F7E272C")
    public static int getTagCode(String name) {
        readTagsFile();
        Integer code = sTagCodes.get(name);
        return code != null ? code : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "AFAE197FB851905387419AFB7B96BE3D", hash_generated_method = "F63C5C81E431293B599378D10B210C76")
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
        private final ByteBuffer mBuffer;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "FACE593E138E02D29B65D04F3AFD5558", hash_generated_method = "9E7C42312DDE864B34989BD734BF1FBF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Event(byte[] data) {
            dsTaint.addTaint(data);
            mBuffer = ByteBuffer.wrap(data);
            mBuffer.order(ByteOrder.nativeOrder());
            // ---------- Original Method ----------
            //mBuffer = ByteBuffer.wrap(data);
            //mBuffer.order(ByteOrder.nativeOrder());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.604 -0400", hash_original_method = "C727D17C1ABE4CA2F41D8D2314B99577", hash_generated_method = "0500992A42743BD7ECA40C10AE18D315")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getProcessId() {
            int var74E2E058DA7FA6DFE349A6FD89345E32_112121565 = (mBuffer.getInt(PROCESS_OFFSET));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mBuffer.getInt(PROCESS_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.605 -0400", hash_original_method = "5C1055DF8325BC493282A721B537C094", hash_generated_method = "2AB66A31394558E6F77B68D37BEFFD3D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getThreadId() {
            int varD37A372EE6D3AE184547870BC2768F10_1518755864 = (mBuffer.getInt(THREAD_OFFSET));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mBuffer.getInt(THREAD_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.605 -0400", hash_original_method = "8DE4962A92E5344AF237DA513A746866", hash_generated_method = "0DFC8FC8FD3939A67C09780950C93C1F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long getTimeNanos() {
            long var4ADE84CBB53AEA0E013A6EF7194CC4A3_962649547 = (mBuffer.getInt(SECONDS_OFFSET) * 1000000000l
                    + mBuffer.getInt(NANOSECONDS_OFFSET));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return mBuffer.getInt(SECONDS_OFFSET) * 1000000000l
                    //+ mBuffer.getInt(NANOSECONDS_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.605 -0400", hash_original_method = "E731C73BB2559185B3FCAA3365113EC6", hash_generated_method = "87D68E51A913330484FE5E6671A7F5C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getTag() {
            int varD454B3BD90192CEEB24FF33DEA85D100_1900845036 = (mBuffer.getInt(TAG_OFFSET));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mBuffer.getInt(TAG_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.605 -0400", hash_original_method = "87D859F946E538D2E12E387EABE85774", hash_generated_method = "26867ED708D9F8990F63696F47393579")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized Object getData() {
            try 
            {
                mBuffer.limit(PAYLOAD_START + mBuffer.getShort(LENGTH_OFFSET));
                mBuffer.position(DATA_START);
                Object var5CE189447800F5DBFD458DEC6F9CBC89_1832580634 = (decodeObject());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.605 -0400", hash_original_method = "153DDF284ABF68138956B6F9D94EE6B9", hash_generated_method = "9029938C8A0768C5100A65DF5CA5B407")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Object decodeObject() {
            byte type;
            type = mBuffer.get();
            //Begin case INT_TYPE 
            Object var5D12675610D924F893F22D56263B7649_1142519374 = ((Integer) mBuffer.getInt());
            //End case INT_TYPE 
            //Begin case LONG_TYPE 
            Object var4B8E8CAFD264682769CF0607A233AE8E_424872014 = ((Long) mBuffer.getLong());
            //End case LONG_TYPE 
            //Begin case STRING_TYPE 
            try 
            {
                int length;
                length = mBuffer.getInt();
                int start;
                start = mBuffer.position();
                mBuffer.position(start + length);
                Object varA16B5560955B24E5F58DCA84AFB486C3_1750230445 = (new String(mBuffer.array(), start, length, "UTF-8"));
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

        
    }


    
}


