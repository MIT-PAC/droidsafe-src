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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.286 -0400", hash_original_method = "F2F67500BFF17861178525A826A9D5EF", hash_generated_method = "53C7EDD75DD3FA6552B96F6BC591B81D")
    public  EventLog() {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.287 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "FABD0AE272C28D49511B5C6B44D8F85C")

        private ByteBuffer mBuffer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.288 -0400", hash_original_method = "FACE593E138E02D29B65D04F3AFD5558", hash_generated_method = "E0900EF0CA86DF0294B98701D594D6E5")
          Event(byte[] data) {
            mBuffer = ByteBuffer.wrap(data);
            mBuffer.order(ByteOrder.nativeOrder());
            // ---------- Original Method ----------
            //mBuffer = ByteBuffer.wrap(data);
            //mBuffer.order(ByteOrder.nativeOrder());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.288 -0400", hash_original_method = "C727D17C1ABE4CA2F41D8D2314B99577", hash_generated_method = "A14D5CC30694E233FC6DD4600BCE982E")
        public int getProcessId() {
            int var74E2E058DA7FA6DFE349A6FD89345E32_164000910 = (mBuffer.getInt(PROCESS_OFFSET));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962184516 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962184516;
            // ---------- Original Method ----------
            //return mBuffer.getInt(PROCESS_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.289 -0400", hash_original_method = "5C1055DF8325BC493282A721B537C094", hash_generated_method = "8996E9B8BF79A32FA726D7122C4BC8DB")
        public int getThreadId() {
            int varD37A372EE6D3AE184547870BC2768F10_207458612 = (mBuffer.getInt(THREAD_OFFSET));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905678293 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905678293;
            // ---------- Original Method ----------
            //return mBuffer.getInt(THREAD_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.289 -0400", hash_original_method = "8DE4962A92E5344AF237DA513A746866", hash_generated_method = "AF5FCC05DF07ABA4BB592949B3179B88")
        public long getTimeNanos() {
            long var4ADE84CBB53AEA0E013A6EF7194CC4A3_333680631 = (mBuffer.getInt(SECONDS_OFFSET) * 1000000000l
                    + mBuffer.getInt(NANOSECONDS_OFFSET));
            long var0F5264038205EDFB1AC05FBB0E8C5E94_2057240877 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2057240877;
            // ---------- Original Method ----------
            //return mBuffer.getInt(SECONDS_OFFSET) * 1000000000l
                    //+ mBuffer.getInt(NANOSECONDS_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.290 -0400", hash_original_method = "E731C73BB2559185B3FCAA3365113EC6", hash_generated_method = "0DF1AB1E15FF39065944C415083467DF")
        public int getTag() {
            int varD454B3BD90192CEEB24FF33DEA85D100_1119740813 = (mBuffer.getInt(TAG_OFFSET));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223284126 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223284126;
            // ---------- Original Method ----------
            //return mBuffer.getInt(TAG_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.291 -0400", hash_original_method = "87D859F946E538D2E12E387EABE85774", hash_generated_method = "140E338FB63AB4432D686A3D08151C7E")
        public synchronized Object getData() {
            Object varB4EAC82CA7396A68D541C85D26508E83_906400024 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_319892673 = null; //Variable for return #2
            Object varB4EAC82CA7396A68D541C85D26508E83_961052011 = null; //Variable for return #3
            try 
            {
                mBuffer.limit(PAYLOAD_START + mBuffer.getShort(LENGTH_OFFSET));
                mBuffer.position(DATA_START);
                varB4EAC82CA7396A68D541C85D26508E83_906400024 = decodeObject();
            } //End block
            catch (IllegalArgumentException e)
            {
                Log.wtf(TAG, "Illegal entry payload: tag=" + getTag(), e);
                varB4EAC82CA7396A68D541C85D26508E83_319892673 = null;
            } //End block
            catch (BufferUnderflowException e)
            {
                Log.wtf(TAG, "Truncated entry payload: tag=" + getTag(), e);
                varB4EAC82CA7396A68D541C85D26508E83_961052011 = null;
            } //End block
            Object varA7E53CE21691AB073D9660D615818899_986669359; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_986669359 = varB4EAC82CA7396A68D541C85D26508E83_906400024;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_986669359 = varB4EAC82CA7396A68D541C85D26508E83_319892673;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_986669359 = varB4EAC82CA7396A68D541C85D26508E83_961052011;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_986669359.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_986669359;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_method = "153DDF284ABF68138956B6F9D94EE6B9", hash_generated_method = "B5122F0E4C98F86A6BBBDE897C9A67C9")
        private Object decodeObject() {
            Object varB4EAC82CA7396A68D541C85D26508E83_1806779217 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_3123160 = null; //Variable for return #2
            Object varB4EAC82CA7396A68D541C85D26508E83_1435420051 = null; //Variable for return #3
            Object varB4EAC82CA7396A68D541C85D26508E83_287010367 = null; //Variable for return #4
            Object varB4EAC82CA7396A68D541C85D26508E83_2124836482 = null; //Variable for return #5
            byte type = mBuffer.get();
            //Begin case INT_TYPE 
            varB4EAC82CA7396A68D541C85D26508E83_1806779217 = (Integer) mBuffer.getInt();
            //End case INT_TYPE 
            //Begin case LONG_TYPE 
            varB4EAC82CA7396A68D541C85D26508E83_3123160 = (Long) mBuffer.getLong();
            //End case LONG_TYPE 
            //Begin case STRING_TYPE 
            try 
            {
                int length = mBuffer.getInt();
                int start = mBuffer.position();
                mBuffer.position(start + length);
                varB4EAC82CA7396A68D541C85D26508E83_1435420051 = new String(mBuffer.array(), start, length, "UTF-8");
            } //End block
            catch (UnsupportedEncodingException e)
            {
                Log.wtf(TAG, "UTF-8 is not supported", e);
                varB4EAC82CA7396A68D541C85D26508E83_287010367 = null;
            } //End block
            //End case STRING_TYPE 
            //Begin case LIST_TYPE 
            int length = mBuffer.get();
            //End case LIST_TYPE 
            //Begin case LIST_TYPE 
            length += 256;
            //End case LIST_TYPE 
            //Begin case LIST_TYPE 
            Object[] array = new Object[length];
            //End case LIST_TYPE 
            //Begin case LIST_TYPE 
            {
                int i = 0;
                array[i] = decodeObject();
            } //End collapsed parenthetic
            //End case LIST_TYPE 
            //Begin case LIST_TYPE 
            varB4EAC82CA7396A68D541C85D26508E83_2124836482 = array;
            //End case LIST_TYPE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown entry type: " + type);
            //End case default 
            Object varA7E53CE21691AB073D9660D615818899_721882794; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_721882794 = varB4EAC82CA7396A68D541C85D26508E83_1806779217;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_721882794 = varB4EAC82CA7396A68D541C85D26508E83_3123160;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_721882794 = varB4EAC82CA7396A68D541C85D26508E83_1435420051;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_721882794 = varB4EAC82CA7396A68D541C85D26508E83_287010367;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_721882794 = varB4EAC82CA7396A68D541C85D26508E83_2124836482;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_721882794.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_721882794;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "80B3FD0B58B3754B2BDFC5F12A99F40B", hash_generated_field = "4E9207C020D4BC18685FE64EF1B701ED")

        private static final int LENGTH_OFFSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "9BD30F4C7A585738DA62188782619446", hash_generated_field = "E3159715193D4B91B22E77BCBE14DF77")

        private static final int PROCESS_OFFSET = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "257D0F6459298F6BA2FD1AA26B61FC0C", hash_generated_field = "C82447906A1E2ABB1F3BE3DDB5735023")

        private static final int THREAD_OFFSET = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "5FD07F266CFCE24B8DB4F95E837F0E66", hash_generated_field = "E49B4EA011D0CB63BF3691C839E09C3E")

        private static final int SECONDS_OFFSET = 12;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "9718E9E6B51AE558695672CDEAB5E25B", hash_generated_field = "C5563766F0BD16F7E0C604F669223D9D")

        private static final int NANOSECONDS_OFFSET = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "D2077F80AF082E298081A95C4E720171", hash_generated_field = "D38325D4D2ABA5BC474228D155C874ED")

        private static final int PAYLOAD_START = 20;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "813E39662121D658635D5F7BB6F211A7", hash_generated_field = "61B24A61947EBA00F5F66CA42990D87B")

        private static final int TAG_OFFSET = 20;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "9DC6F87DB9C558702D3B8517F5539BE2", hash_generated_field = "32B83A7E80D0C8C5744209DAAAFC71EA")

        private static final int DATA_START = 24;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "218E1D494FAAD7DD9751A9A7478842AC", hash_generated_field = "90607B1CECA591A7D57C2F3D4FE312C5")

        private static final byte INT_TYPE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "2BAF8EC802111AC0438538F55F31F80A", hash_generated_field = "BDF743648047E78C2EB377A8FBB611C3")

        private static final byte LONG_TYPE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "9863EBBAAF289CCA17B73A267E956FB0", hash_generated_field = "CE17CF24D6536F55DC5D2C562B69DDE0")

        private static final byte STRING_TYPE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "ADA0928AF08928E7D7B32EF4A81B36F8", hash_generated_field = "3E3F6D5EA3820F4968BE8D121B14CB23")

        private static final byte LIST_TYPE = 3;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "21E431B2895768531D883F7DA442A53B", hash_generated_field = "DB25E28C44FF4AB3A8E349B062479A96")

    private static final String TAG = "EventLog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "E5E26945EECAFA047881271E28400B21", hash_generated_field = "0B4C2C031E06758D5179435B0B36BCEB")

    private static final String TAGS_FILE = "/system/etc/event-log-tags";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "EA4A2608FFD6E7B098BB472A9A20EC70", hash_generated_field = "48AFCC2BBA5F6385F51E6182D6069D57")

    private static final String COMMENT_PATTERN = "^\\s*(#.*)?$";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "B710FA3365CF0FC71E89CCD2CE401E27", hash_generated_field = "14FEF2C8C8D8463E6A4C7C29D61977B8")

    private static final String TAG_PATTERN = "^\\s*(\\d+)\\s+(\\w+)\\s*(\\(.*\\))?\\s*$";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "AE20014216751B1EBE33D03D625F67B7", hash_generated_field = "2B10BF81841A39E2BC7FDE536FF9284C")

    private static HashMap<String, Integer> sTagCodes = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.292 -0400", hash_original_field = "A72A626C5606938865EA6B32E5C33BDF", hash_generated_field = "CEA5978C366D6C8CA48AD139365847FD")

    private static HashMap<Integer, String> sTagNames = null;
}

