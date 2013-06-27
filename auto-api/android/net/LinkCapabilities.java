package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkCapabilities implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.977 -0400", hash_original_field = "CC010D636843DF8CC2B8C35E93302C15", hash_generated_field = "6D2F490064193A394308FD52EAD2F213")

    private HashMap<Integer, String> mCapabilities;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.983 -0400", hash_original_method = "8AC97A1FCCB5728EBAB2151990B61507", hash_generated_method = "5CABA04E7070710949FB09D336670A02")
    public  LinkCapabilities() {
        mCapabilities = new HashMap<Integer, String>();
        // ---------- Original Method ----------
        //mCapabilities = new HashMap<Integer, String>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.993 -0400", hash_original_method = "B89651C5D9CFDB434612BD816E092144", hash_generated_method = "88D9D73B8E23D9084FD9236FEA47B28E")
    public  LinkCapabilities(LinkCapabilities source) {
        {
            mCapabilities = new HashMap<Integer, String>(source.mCapabilities);
        } //End block
        {
            mCapabilities = new HashMap<Integer, String>();
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //mCapabilities = new HashMap<Integer, String>(source.mCapabilities);
        //} else {
            //mCapabilities = new HashMap<Integer, String>();
        //}
    }

    
        public static LinkCapabilities createNeedsMap(String applicationRole) {
        if (DBG) log("createNeededCapabilities(applicationRole) EX");
        return new LinkCapabilities();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.994 -0400", hash_original_method = "65569EBD49455AAF0883C4D69A42B604", hash_generated_method = "4F70271EFC86EA6CB157AC698C1F121C")
    public void clear() {
        mCapabilities.clear();
        // ---------- Original Method ----------
        //mCapabilities.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.994 -0400", hash_original_method = "50DA395E2AF302C1CC5EAE713D0D4EBB", hash_generated_method = "FD3B09AD2D5C4C62730F08EDEAF6B5AE")
    public boolean isEmpty() {
        boolean var0AB62632F8DACDAA086C74AE9CF55487_1623306097 = (mCapabilities.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_508084498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_508084498;
        // ---------- Original Method ----------
        //return mCapabilities.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.995 -0400", hash_original_method = "32A53E9BB0DE153D2975EBB6ECC5F512", hash_generated_method = "021485E20F89997CF334A930F175B464")
    public int size() {
        int varF04A2E6865D36C1C25034ADF82AC4C31_2083469322 = (mCapabilities.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611642515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611642515;
        // ---------- Original Method ----------
        //return mCapabilities.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.014 -0400", hash_original_method = "568005AD4EF2A886FBB9B820A5E2167C", hash_generated_method = "10EA5CCDC38C40545D3BCB354DBB9D7B")
    public String get(int key) {
        String varB4EAC82CA7396A68D541C85D26508E83_848943121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_848943121 = mCapabilities.get(key);
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_848943121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_848943121;
        // ---------- Original Method ----------
        //return mCapabilities.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.015 -0400", hash_original_method = "126A86B00CA0552F526F15B68A83F2ED", hash_generated_method = "1FA50A081B2F6AEA9E8C36C779A24024")
    public void put(int key, String value) {
        mCapabilities.put(key, value);
        addTaint(key);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //mCapabilities.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.016 -0400", hash_original_method = "C1A26B01C735E97490E02BBFBAC6A09E", hash_generated_method = "85A9ED795590C5F86559BAC154601DF4")
    public boolean containsKey(int key) {
        boolean varABC5146107DE4075BF365D69BCA34608_911074746 = (mCapabilities.containsKey(key));
        addTaint(key);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547056637 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_547056637;
        // ---------- Original Method ----------
        //return mCapabilities.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.016 -0400", hash_original_method = "05E28527AC6BDB7F8BDD1968A304DADF", hash_generated_method = "0043F6F7EE901A7E4AFF1C59C1EB263B")
    public boolean containsValue(String value) {
        boolean varB5018B44702834F3CA2D27A9BCC40B26_1409851075 = (mCapabilities.containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1911701457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1911701457;
        // ---------- Original Method ----------
        //return mCapabilities.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.017 -0400", hash_original_method = "9F2F3F77DD27B21E35B683D345FC2FEC", hash_generated_method = "7D772EE606961600EA79D4502CF5A90B")
    public Set<Entry<Integer, String>> entrySet() {
        Set<Entry<Integer, String>> varB4EAC82CA7396A68D541C85D26508E83_905287749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_905287749 = mCapabilities.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_905287749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_905287749;
        // ---------- Original Method ----------
        //return mCapabilities.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.018 -0400", hash_original_method = "9EFA80A4731E36F41CEC9CDBD3C0FD66", hash_generated_method = "B5841927DBCFA2E0B19E850DC1DA4E8A")
    public Set<Integer> keySet() {
        Set<Integer> varB4EAC82CA7396A68D541C85D26508E83_2078931583 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2078931583 = mCapabilities.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_2078931583.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2078931583;
        // ---------- Original Method ----------
        //return mCapabilities.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.106 -0400", hash_original_method = "3BC9717E7FFAE02D41102E4F5DA33838", hash_generated_method = "E656375E444CD7D370A7BE6AAEA8785C")
    public Collection<String> values() {
        Collection<String> varB4EAC82CA7396A68D541C85D26508E83_102324807 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_102324807 = mCapabilities.values();
        varB4EAC82CA7396A68D541C85D26508E83_102324807.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_102324807;
        // ---------- Original Method ----------
        //return mCapabilities.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.107 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C8504504E265DC2B340BE870FF3C1C9B")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_48000224 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_48000224;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.173 -0400", hash_original_method = "A28D232247661B92586D4FEECBA4E0AF", hash_generated_method = "046FAC848DA0123EFC142F2270835C64")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_770187615 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_529716674 = null; //Variable for return #2
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("{");
        boolean firstTime;
        firstTime = true;
        {
            Iterator<Entry<Integer, String>> varCD231903806A4BEC6B520ADDF02CD668_1734121105 = (mCapabilities.entrySet()).iterator();
            varCD231903806A4BEC6B520ADDF02CD668_1734121105.hasNext();
            Entry<Integer, String> entry = varCD231903806A4BEC6B520ADDF02CD668_1734121105.next();
            {
                {
                    firstTime = false;
                } //End block
                {
                    sb.append(",");
                } //End block
                sb.append(entry.getKey());
                sb.append(":\"");
                sb.append(entry.getValue());
                sb.append("\"");
                varB4EAC82CA7396A68D541C85D26508E83_770187615 = mCapabilities.toString();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_529716674 = sb.toString();
        String varA7E53CE21691AB073D9660D615818899_62152134; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_62152134 = varB4EAC82CA7396A68D541C85D26508E83_770187615;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_62152134 = varB4EAC82CA7396A68D541C85D26508E83_529716674;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_62152134.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_62152134;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("{");
        //boolean firstTime = true;
        //for (Entry<Integer, String> entry : mCapabilities.entrySet()) {
            //if (firstTime) {
                //firstTime = false;
            //} else {
                //sb.append(",");
            //}
            //sb.append(entry.getKey());
            //sb.append(":\"");
            //sb.append(entry.getValue());
            //sb.append("\"");
            //return mCapabilities.toString();
        //}
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.245 -0400", hash_original_method = "76DC40F01B1B28CF1F7E32C3EB72CACA", hash_generated_method = "18B4645BF3F528382D0D158A5CE315E2")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCapabilities.size());
        {
            Iterator<Entry<Integer, String>> varCD231903806A4BEC6B520ADDF02CD668_48201826 = (mCapabilities.entrySet()).iterator();
            varCD231903806A4BEC6B520ADDF02CD668_48201826.hasNext();
            Entry<Integer, String> entry = varCD231903806A4BEC6B520ADDF02CD668_48201826.next();
            {
                dest.writeInt(entry.getKey().intValue());
                dest.writeString(entry.getValue());
            } //End block
        } //End collapsed parenthetic
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mCapabilities.size());
        //for (Entry<Integer, String> entry : mCapabilities.entrySet()) {
            //dest.writeInt(entry.getKey().intValue());
            //dest.writeString(entry.getValue());
        //}
    }

    
        protected static void log(String s) {
        Log.d(TAG, s);
    }

    
    public static final class Key {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.246 -0400", hash_original_method = "63943B74C3B7537BF21BF313857C8294", hash_generated_method = "9111A328D08351EAFE3972B5E48A468B")
        private  Key() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.246 -0400", hash_original_field = "31D9B8593143FF77B1D3FDBE79892069", hash_generated_field = "55E505A35A68C51C32DD8BDD97ADD9B0")

        public final static int RO_NETWORK_TYPE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.246 -0400", hash_original_field = "59496ABAFABDA68B9A3521E6069B9843", hash_generated_field = "0AC1B312664003BD34F4455A13DBB769")

        public final static int RW_DESIRED_FWD_BW = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.246 -0400", hash_original_field = "1786A41AFCC43C94754E85F29EC4AFE9", hash_generated_field = "5A7787D9FED23FFC9069D08E91F0338D")

        public final static int RW_REQUIRED_FWD_BW = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.247 -0400", hash_original_field = "4159A771D99F93BFB7EB19BBA0A1C069", hash_generated_field = "EADE11CE71524B0FCE546A4CC13C6539")

        public final static int RO_AVAILABLE_FWD_BW = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.247 -0400", hash_original_field = "C691AF94B98E7E63B0E0706F0B5618CC", hash_generated_field = "798ECDF7ACC28C0C80BB118D4F98C9EC")

        public final static int RW_DESIRED_REV_BW = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.247 -0400", hash_original_field = "B09901875D028D3F0F9F03962346F827", hash_generated_field = "3BF306EE2F96FDA154DD648A809061BD")

        public final static int RW_REQUIRED_REV_BW = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.247 -0400", hash_original_field = "0DDB381AEE639068E7AAC58CE0E83052", hash_generated_field = "A720D19B3CCA6FE85AE8128876ACAD59")

        public final static int RO_AVAILABLE_REV_BW = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.247 -0400", hash_original_field = "F5C72913DF74CAD9000CCEC5C70F8F77", hash_generated_field = "3F33F0C47B54048BC0FC0B3A88D0EEEB")

        public final static int RW_MAX_ALLOWED_LATENCY = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.247 -0400", hash_original_field = "D03612416093DFEC707AC15E383B3088", hash_generated_field = "3477642B3F38F4F32B7F16C1F5E19DC2")

        public final static int RO_BOUND_INTERFACE = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.247 -0400", hash_original_field = "69D753F6C8B75BB343D44AB1904F7C9E", hash_generated_field = "7C84ACC0DE5244183CCDA7A00856BD83")

        public final static int RO_PHYSICAL_INTERFACE = 10;
    }


    
    public static final class Role {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.248 -0400", hash_original_method = "B6871343D9E854D112856D815CFF5530", hash_generated_method = "78F599F7713B91E62A6511F5FC9496CD")
        private  Role() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.248 -0400", hash_original_field = "9BC1C40E9686713042CC90D9C1CF2549", hash_generated_field = "F63B5D132462C904C78266EF26BFF05F")

        public static final String DEFAULT = "default";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.265 -0400", hash_original_field = "EA7BB0CB41452D90D7D5EDBE2973212D", hash_generated_field = "96A741C4F469B69BA10EEB799EC008A3")

        public static final String BULK_DOWNLOAD = "bulk.download";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.265 -0400", hash_original_field = "1465C6A37B219587B64CDB64D5140CF9", hash_generated_field = "34F02A32AB1949293FE186C9597A3656")

        public static final String BULK_UPLOAD = "bulk.upload";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.265 -0400", hash_original_field = "4369238233371A31849D5B0A186DB1EC", hash_generated_field = "9A988D14E1E791EC8457542EBF469B81")

        public static final String VOIP_24KBPS = "voip.24k";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.265 -0400", hash_original_field = "053A1E02F00A659703BC09867238E7E7", hash_generated_field = "B7A966A9B689435B48F84A7562F005E9")

        public static final String VOIP_32KBPS = "voip.32k";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.265 -0400", hash_original_field = "D6C3D6A3A16E909D238EC7C1BBF95785", hash_generated_field = "0D56ABC4CDA6FD96229C5B44A6DB3E3E")

        public static final String VIDEO_STREAMING_480P = "video.streaming.480p";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.265 -0400", hash_original_field = "ACA5F2ABB47789B99BC9A285FB9603A4", hash_generated_field = "01E2D3B0EF6C11725E1E1DCE9732A07A")

        public static final String VIDEO_STREAMING_720I = "video.streaming.720i";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.265 -0400", hash_original_field = "172B9F5B65B13181CAAA1DF8E25F38BB", hash_generated_field = "2BCCE7D924690F2A06AFF84D40F83D67")

        public static final String VIDEO_CHAT_360P = "video.chat.360p";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.265 -0400", hash_original_field = "F9663989360BDA4185C55D7735D8DD0E", hash_generated_field = "8DECC40EEE8A771AAC08864DDB2E0C94")

        public static final String VIDEO_CHAT_480P = "video.chat.480i";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.266 -0400", hash_original_field = "21751F54B4817BF046E75DDB1848AC16", hash_generated_field = "947E19593DB9ED10CC0CBEDC61EE8188")

    private static String TAG = "LinkCapabilities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.266 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.266 -0400", hash_original_field = "C032CB84B2CEFE05F1B0EAA754FB9455", hash_generated_field = "844C01C5C8649D904242274D94DCF977")

    public static final Creator<LinkCapabilities> CREATOR =
        new Creator<LinkCapabilities>() {
            public LinkCapabilities createFromParcel(Parcel in) {
                LinkCapabilities capabilities = new LinkCapabilities();
                int size = in.readInt();
                while (size-- != 0) {
                    int key = in.readInt();
                    String value = in.readString();
                    capabilities.mCapabilities.put(key, value);
                }
                return capabilities;
            }

            public LinkCapabilities[] newArray(int size) {
                return new LinkCapabilities[size];
            }
        };
}

