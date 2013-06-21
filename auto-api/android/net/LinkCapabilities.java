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
    private HashMap<Integer, String> mCapabilities;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.811 -0400", hash_original_method = "8AC97A1FCCB5728EBAB2151990B61507", hash_generated_method = "5CABA04E7070710949FB09D336670A02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkCapabilities() {
        mCapabilities = new HashMap<Integer, String>();
        // ---------- Original Method ----------
        //mCapabilities = new HashMap<Integer, String>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.811 -0400", hash_original_method = "B89651C5D9CFDB434612BD816E092144", hash_generated_method = "9DD3915F1F86D9FD18BEC5C268E7A19B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkCapabilities(LinkCapabilities source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.812 -0400", hash_original_method = "65569EBD49455AAF0883C4D69A42B604", hash_generated_method = "4F70271EFC86EA6CB157AC698C1F121C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        mCapabilities.clear();
        // ---------- Original Method ----------
        //mCapabilities.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.812 -0400", hash_original_method = "50DA395E2AF302C1CC5EAE713D0D4EBB", hash_generated_method = "8A2C706FB33264D217063DA378980419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var0AB62632F8DACDAA086C74AE9CF55487_1434111679 = (mCapabilities.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCapabilities.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.812 -0400", hash_original_method = "32A53E9BB0DE153D2975EBB6ECC5F512", hash_generated_method = "7473C0E95D18B43D2447A4852C31A550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varF04A2E6865D36C1C25034ADF82AC4C31_523360726 = (mCapabilities.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCapabilities.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.812 -0400", hash_original_method = "568005AD4EF2A886FBB9B820A5E2167C", hash_generated_method = "1BA6A638895F09C053BB2E889501D1C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String get(int key) {
        dsTaint.addTaint(key);
        String var936E23ED28DD76575BECF04EEA9245E8_1678494369 = (mCapabilities.get(key));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCapabilities.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.813 -0400", hash_original_method = "126A86B00CA0552F526F15B68A83F2ED", hash_generated_method = "C658D6E2E5DD7A318BC56B1A6B2CCBFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(int key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        mCapabilities.put(key, value);
        // ---------- Original Method ----------
        //mCapabilities.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.813 -0400", hash_original_method = "C1A26B01C735E97490E02BBFBAC6A09E", hash_generated_method = "929804F2773E180FE622906C34D02661")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(int key) {
        dsTaint.addTaint(key);
        boolean varABC5146107DE4075BF365D69BCA34608_1698588873 = (mCapabilities.containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCapabilities.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.813 -0400", hash_original_method = "05E28527AC6BDB7F8BDD1968A304DADF", hash_generated_method = "B006163AF1103D260C02B813935A4952")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(String value) {
        dsTaint.addTaint(value);
        boolean varB5018B44702834F3CA2D27A9BCC40B26_511894015 = (mCapabilities.containsValue(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCapabilities.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.813 -0400", hash_original_method = "9F2F3F77DD27B21E35B683D345FC2FEC", hash_generated_method = "6D0F841AE3392B9C79EBE593B6D06E3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Entry<Integer, String>> entrySet() {
        Set<Entry<Integer, String>> var33F6DC44E62BBD2801B9DB5A0553A340_1026898967 = (mCapabilities.entrySet());
        return (Set<Entry<Integer, String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCapabilities.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.814 -0400", hash_original_method = "9EFA80A4731E36F41CEC9CDBD3C0FD66", hash_generated_method = "6025F0360CC7D0544EA368A00640937B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Integer> keySet() {
        Set<Integer> var70C21E85421680142870010281DC0794_1117452692 = (mCapabilities.keySet());
        return (Set<Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCapabilities.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.814 -0400", hash_original_method = "3BC9717E7FFAE02D41102E4F5DA33838", hash_generated_method = "D2A2F136262BF61EF2AD6203F105A313")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<String> values() {
        Collection<String> var107C2CB23B1E8286836DFFA3FF886C98_1757821141 = (mCapabilities.values());
        return (Collection<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCapabilities.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.814 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.819 -0400", hash_original_method = "A28D232247661B92586D4FEECBA4E0AF", hash_generated_method = "1B3A21B13D8B1931A2C9975BB5DCC1A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("{");
        boolean firstTime;
        firstTime = true;
        {
            Iterator<Entry<Integer, String>> varCD231903806A4BEC6B520ADDF02CD668_1690675349 = (mCapabilities.entrySet()).iterator();
            varCD231903806A4BEC6B520ADDF02CD668_1690675349.hasNext();
            Entry<Integer, String> entry = varCD231903806A4BEC6B520ADDF02CD668_1690675349.next();
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
                String var034F9C90B8C36679F68C1FC6D71F3183_317536727 = (mCapabilities.toString());
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_1078863701 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.824 -0400", hash_original_method = "76DC40F01B1B28CF1F7E32C3EB72CACA", hash_generated_method = "3CA6666EE3715A49B53FD6F196536790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mCapabilities.size());
        {
            Iterator<Entry<Integer, String>> varCD231903806A4BEC6B520ADDF02CD668_295563364 = (mCapabilities.entrySet()).iterator();
            varCD231903806A4BEC6B520ADDF02CD668_295563364.hasNext();
            Entry<Integer, String> entry = varCD231903806A4BEC6B520ADDF02CD668_295563364.next();
            {
                dest.writeInt(entry.getKey().intValue());
                dest.writeString(entry.getValue());
            } //End block
        } //End collapsed parenthetic
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.824 -0400", hash_original_method = "63943B74C3B7537BF21BF313857C8294", hash_generated_method = "9111A328D08351EAFE3972B5E48A468B")
        @DSModeled(DSC.SAFE)
        private Key() {
            // ---------- Original Method ----------
        }

        
        public final static int RO_NETWORK_TYPE = 1;
        public final static int RW_DESIRED_FWD_BW = 2;
        public final static int RW_REQUIRED_FWD_BW = 3;
        public final static int RO_AVAILABLE_FWD_BW = 4;
        public final static int RW_DESIRED_REV_BW = 5;
        public final static int RW_REQUIRED_REV_BW = 6;
        public final static int RO_AVAILABLE_REV_BW = 7;
        public final static int RW_MAX_ALLOWED_LATENCY = 8;
        public final static int RO_BOUND_INTERFACE = 9;
        public final static int RO_PHYSICAL_INTERFACE = 10;
    }


    
    public static final class Role {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.825 -0400", hash_original_method = "B6871343D9E854D112856D815CFF5530", hash_generated_method = "78F599F7713B91E62A6511F5FC9496CD")
        @DSModeled(DSC.SAFE)
        private Role() {
            // ---------- Original Method ----------
        }

        
        public static final String DEFAULT = "default";
        public static final String BULK_DOWNLOAD = "bulk.download";
        public static final String BULK_UPLOAD = "bulk.upload";
        public static final String VOIP_24KBPS = "voip.24k";
        public static final String VOIP_32KBPS = "voip.32k";
        public static final String VIDEO_STREAMING_480P = "video.streaming.480p";
        public static final String VIDEO_STREAMING_720I = "video.streaming.720i";
        public static final String VIDEO_CHAT_360P = "video.chat.360p";
        public static final String VIDEO_CHAT_480P = "video.chat.480i";
    }


    
    private static final String TAG = "LinkCapabilities";
    private static final boolean DBG = false;
    public static final Creator<LinkCapabilities> CREATOR = new Creator<LinkCapabilities>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.825 -0400", hash_original_method = "EE10B5AF562143A35856727EE7786CE8", hash_generated_method = "5042C14F222E52AAF17AFA63A468D010")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LinkCapabilities createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            LinkCapabilities capabilities;
            capabilities = new LinkCapabilities();
            int size;
            size = in.readInt();
            {
                int key;
                key = in.readInt();
                String value;
                value = in.readString();
                capabilities.mCapabilities.put(key, value);
            } //End block
            return (LinkCapabilities)dsTaint.getTaint();
            // ---------- Original Method ----------
            //LinkCapabilities capabilities = new LinkCapabilities();
            //int size = in.readInt();
            //while (size-- != 0) {
                    //int key = in.readInt();
                    //String value = in.readString();
                    //capabilities.mCapabilities.put(key, value);
                //}
            //return capabilities;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.825 -0400", hash_original_method = "DA3D851B4F425B625596A4EBE0CE616D", hash_generated_method = "6499A574045EC9BC2848210F24FA49C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public LinkCapabilities[] newArray(int size) {
            dsTaint.addTaint(size);
            LinkCapabilities[] var19E681D5D249BD4C56609FFB17F165B7_890106936 = (new LinkCapabilities[size]);
            return (LinkCapabilities[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LinkCapabilities[size];
        }

        
}; //Transformed anonymous class
}

