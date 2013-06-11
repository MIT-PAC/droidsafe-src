package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG = "LinkCapabilities";
    private static final boolean DBG = false;
    private HashMap<Integer, String> mCapabilities;
    public static final Creator<LinkCapabilities> CREATOR = new Creator<LinkCapabilities>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.110 -0400", hash_original_method = "EE10B5AF562143A35856727EE7786CE8", hash_generated_method = "C1634FC9518CC7C611197D37CC632BBE")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.110 -0400", hash_original_method = "DA3D851B4F425B625596A4EBE0CE616D", hash_generated_method = "5C4D92C81B535CB43CCE5A79BDA77802")
        @DSModeled(DSC.SAFE)
        public LinkCapabilities[] newArray(int size) {
            dsTaint.addTaint(size);
            return (LinkCapabilities[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LinkCapabilities[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.110 -0400", hash_original_method = "8AC97A1FCCB5728EBAB2151990B61507", hash_generated_method = "8BD0B5AA3DAACA57CB9B17311716B242")
    @DSModeled(DSC.SAFE)
    public LinkCapabilities() {
        mCapabilities = new HashMap<Integer, String>();
        // ---------- Original Method ----------
        //mCapabilities = new HashMap<Integer, String>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.111 -0400", hash_original_method = "B89651C5D9CFDB434612BD816E092144", hash_generated_method = "C3C08D849925E06822196485399C0F38")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.111 -0400", hash_original_method = "EC660E8DCF1E74439F3C9EC2FA6F7AC7", hash_generated_method = "98E2E44001F98BC1DE011135CEE9A8D2")
    public static LinkCapabilities createNeedsMap(String applicationRole) {
        if (DBG) log("createNeededCapabilities(applicationRole) EX");
        return new LinkCapabilities();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.111 -0400", hash_original_method = "65569EBD49455AAF0883C4D69A42B604", hash_generated_method = "D157B2E08B33147B71C748EE70C4BC31")
    @DSModeled(DSC.SAFE)
    public void clear() {
        mCapabilities.clear();
        // ---------- Original Method ----------
        //mCapabilities.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.111 -0400", hash_original_method = "50DA395E2AF302C1CC5EAE713D0D4EBB", hash_generated_method = "5CDE25160BC4006DE5F90E874EA8F268")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var0AB62632F8DACDAA086C74AE9CF55487_1069574768 = (mCapabilities.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCapabilities.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.111 -0400", hash_original_method = "32A53E9BB0DE153D2975EBB6ECC5F512", hash_generated_method = "F08345EC949F38E6637F27CBE235B983")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varF04A2E6865D36C1C25034ADF82AC4C31_2072448754 = (mCapabilities.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCapabilities.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.111 -0400", hash_original_method = "568005AD4EF2A886FBB9B820A5E2167C", hash_generated_method = "A5B0D19F410C4AC172FED507048672CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String get(int key) {
        dsTaint.addTaint(key);
        String var936E23ED28DD76575BECF04EEA9245E8_1054203048 = (mCapabilities.get(key));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCapabilities.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.111 -0400", hash_original_method = "126A86B00CA0552F526F15B68A83F2ED", hash_generated_method = "E2899D8C92BFB60799555376D5F6F8AE")
    @DSModeled(DSC.SAFE)
    public void put(int key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        mCapabilities.put(key, value);
        // ---------- Original Method ----------
        //mCapabilities.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.111 -0400", hash_original_method = "C1A26B01C735E97490E02BBFBAC6A09E", hash_generated_method = "1C76116849CEEC155E92010A327B3D4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(int key) {
        dsTaint.addTaint(key);
        boolean varABC5146107DE4075BF365D69BCA34608_900672525 = (mCapabilities.containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCapabilities.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.112 -0400", hash_original_method = "05E28527AC6BDB7F8BDD1968A304DADF", hash_generated_method = "84A1B1B15A6AF69A13F0BDDD05E438C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(String value) {
        dsTaint.addTaint(value);
        boolean varB5018B44702834F3CA2D27A9BCC40B26_153795512 = (mCapabilities.containsValue(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCapabilities.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.112 -0400", hash_original_method = "9F2F3F77DD27B21E35B683D345FC2FEC", hash_generated_method = "B52081087D0CEA3A44342C015F6FAAF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Entry<Integer, String>> entrySet() {
        Set<Entry<Integer, String>> var33F6DC44E62BBD2801B9DB5A0553A340_424561646 = (mCapabilities.entrySet());
        return (Set<Entry<Integer, String>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCapabilities.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.112 -0400", hash_original_method = "9EFA80A4731E36F41CEC9CDBD3C0FD66", hash_generated_method = "657F23DD6E8CAE78D63E682F9511A4F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Integer> keySet() {
        Set<Integer> var70C21E85421680142870010281DC0794_1205454658 = (mCapabilities.keySet());
        return (Set<Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCapabilities.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.112 -0400", hash_original_method = "3BC9717E7FFAE02D41102E4F5DA33838", hash_generated_method = "B617603696792C3AA06D98B539A63C84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<String> values() {
        Collection<String> var107C2CB23B1E8286836DFFA3FF886C98_809571812 = (mCapabilities.values());
        return (Collection<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCapabilities.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.112 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.112 -0400", hash_original_method = "A28D232247661B92586D4FEECBA4E0AF", hash_generated_method = "971924E12DA54E7A5A4CC6B83B7A6481")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("{");
        boolean firstTime;
        firstTime = true;
        {
            Iterator<Entry<Integer, String>> seatecAstronomy42 = mCapabilities.entrySet().iterator();
            seatecAstronomy42.hasNext();
            Entry<Integer, String> entry = seatecAstronomy42.next();
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
                String var034F9C90B8C36679F68C1FC6D71F3183_1190717998 = (mCapabilities.toString());
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_709055489 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.112 -0400", hash_original_method = "76DC40F01B1B28CF1F7E32C3EB72CACA", hash_generated_method = "1B6268FD1C61733C88E646A75B615E04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mCapabilities.size());
        {
            Iterator<Entry<Integer, String>> seatecAstronomy42 = mCapabilities.entrySet().iterator();
            seatecAstronomy42.hasNext();
            Entry<Integer, String> entry = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.112 -0400", hash_original_method = "B9AF8185F4B8412B9E80F317F384108E", hash_generated_method = "9425F6BBE5A615832A85DEB7FCBE8AFE")
    protected static void log(String s) {
        Log.d(TAG, s);
    }

    
    public static final class Key {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.113 -0400", hash_original_method = "63943B74C3B7537BF21BF313857C8294", hash_generated_method = "67E293488C320AAB78333269EC53A0F3")
        @DSModeled(DSC.SAFE)
        private Key() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class Role {
        public static final String DEFAULT = "default";
        public static final String BULK_DOWNLOAD = "bulk.download";
        public static final String BULK_UPLOAD = "bulk.upload";
        public static final String VOIP_24KBPS = "voip.24k";
        public static final String VOIP_32KBPS = "voip.32k";
        public static final String VIDEO_STREAMING_480P = "video.streaming.480p";
        public static final String VIDEO_STREAMING_720I = "video.streaming.720i";
        public static final String VIDEO_CHAT_360P = "video.chat.360p";
        public static final String VIDEO_CHAT_480P = "video.chat.480i";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.113 -0400", hash_original_method = "B6871343D9E854D112856D815CFF5530", hash_generated_method = "7DED2615721F23C2E73B42A150D950E6")
        @DSModeled(DSC.SAFE)
        private Role() {
            // ---------- Original Method ----------
        }

        
    }


    
}


