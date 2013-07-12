package android.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UNKNOWN;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EDGE;
import static android.telephony.TelephonyManager.NETWORK_TYPE_GPRS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UMTS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSDPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSUPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSPA;

public class NeighboringCellInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.647 -0400", hash_original_field = "367DEE652AE08B1E7A6DD8CD03A62B84", hash_generated_field = "6944DD992E34997F099DF17CBFD1CEA4")

    private int mRssi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.647 -0400", hash_original_field = "47909A4A63C9D0DF4D400D36305EA002", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

    private int mCid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.647 -0400", hash_original_field = "B2F9C701F6B9FA98A906A1D27571667E", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

    private int mLac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.648 -0400", hash_original_field = "865B7932A3A776B1F3AFFD84DFC3DDFF", hash_generated_field = "EC9E5D02BA114935D10D39D2FABA270A")

    private int mPsc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.648 -0400", hash_original_field = "9761905E68D80D41E55047BFA13A52C2", hash_generated_field = "60BE94F590B2B55E7F16606AE64523A2")

    private int mNetworkType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.648 -0400", hash_original_method = "BD76A3213F8AC49348CAF06FA32CACCC", hash_generated_method = "8998E5B0F109CED8D6A58E23270AEBB9")
    @Deprecated
    public  NeighboringCellInfo() {
        mRssi = UNKNOWN_RSSI;
        mLac = UNKNOWN_CID;
        mCid = UNKNOWN_CID;
        mPsc = UNKNOWN_CID;
        mNetworkType = NETWORK_TYPE_UNKNOWN;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.649 -0400", hash_original_method = "19B23EA98615F51662865132429A9393", hash_generated_method = "1E061B23AF443E35C2DB8FFD1015E187")
    @Deprecated
    public  NeighboringCellInfo(int rssi, int cid) {
        mRssi = rssi;
        mCid = cid;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.651 -0400", hash_original_method = "F57F6CF0E582113B7CF21CF2AAAD28CD", hash_generated_method = "ADE3B4D50248FE9E96E5F042CC0D9EF1")
    public  NeighboringCellInfo(int rssi, String location, int radioType) {
        mRssi = rssi;
        mNetworkType = NETWORK_TYPE_UNKNOWN;
        mPsc = UNKNOWN_CID;
        mLac = UNKNOWN_CID;
        mCid = UNKNOWN_CID;
        int l = location.length();
    if(l > 8)        
        return;
    if(l < 8)        
        {
for(int i = 0;i < (8-l);i++)
            {
                location = "0" + location;
            } 
        } 
        try 
        {
switch(radioType){
            case NETWORK_TYPE_GPRS:
            case NETWORK_TYPE_EDGE:
            mNetworkType = radioType;
    if(!location.equalsIgnoreCase("FFFFFFFF"))            
            {
                mCid = Integer.valueOf(location.substring(4), 16);
                mLac = Integer.valueOf(location.substring(0, 4), 16);
            } 
            break;
            case NETWORK_TYPE_UMTS:
            case NETWORK_TYPE_HSDPA:
            case NETWORK_TYPE_HSUPA:
            case NETWORK_TYPE_HSPA:
            mNetworkType = radioType;
            mPsc = Integer.valueOf(location, 16);
            break;
}
        } 
        catch (NumberFormatException e)
        {
            mPsc = UNKNOWN_CID;
            mLac = UNKNOWN_CID;
            mCid = UNKNOWN_CID;
            mNetworkType = NETWORK_TYPE_UNKNOWN;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.653 -0400", hash_original_method = "17FDCF259E4D17E2ACC4CF1446DF5669", hash_generated_method = "6630B7089771F571BDC033EC7FF2D880")
    public  NeighboringCellInfo(Parcel in) {
        mRssi = in.readInt();
        mLac = in.readInt();
        mCid = in.readInt();
        mPsc = in.readInt();
        mNetworkType = in.readInt();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.653 -0400", hash_original_method = "EAA2EB56C456A75F6A36236287457095", hash_generated_method = "A3848F3DB898F61715B75999BC0817F8")
    public int getRssi() {
        int var367DEE652AE08B1E7A6DD8CD03A62B84_398368108 = (mRssi);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122300113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122300113;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.653 -0400", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "29310542B0201E480A521E20DE57CA10")
    public int getLac() {
        int varB2F9C701F6B9FA98A906A1D27571667E_1191748897 = (mLac);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050258273 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050258273;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.654 -0400", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "B7F964FF4C0C712FA21B6ABB0D32E56E")
    public int getCid() {
        int var47909A4A63C9D0DF4D400D36305EA002_951383483 = (mCid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278261327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278261327;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.654 -0400", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "E232EA26358728A7C2DFC883581E4B84")
    public int getPsc() {
        int var865B7932A3A776B1F3AFFD84DFC3DDFF_185231135 = (mPsc);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96250584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_96250584;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.654 -0400", hash_original_method = "BA8FF13D9B34325771E51CDF8D4F958D", hash_generated_method = "6496FFC75C1F8527851435A97B50FBBB")
    public int getNetworkType() {
        int var9761905E68D80D41E55047BFA13A52C2_1025803599 = (mNetworkType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934379014 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934379014;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.654 -0400", hash_original_method = "6316D6CF1176EA8E415E44B17DEEB68F", hash_generated_method = "797F050B3EBE62F935630D664E238E38")
    @Deprecated
    public void setCid(int cid) {
        mCid = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.655 -0400", hash_original_method = "DC61695B2550927FEF6924BD6DCCD37F", hash_generated_method = "0E2A4B21AE2C4AC464A8CE307DEBA552")
    @Deprecated
    public void setRssi(int rssi) {
        mRssi = rssi;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.655 -0400", hash_original_method = "8F5318BC3FCF7BF30F83B998176BAD1B", hash_generated_method = "ED4F3A1A04505D36619A0295DF85933B")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
    if(mPsc != UNKNOWN_CID)        
        {
            sb.append(Integer.toHexString(mPsc))
                    .append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        } 
        else
    if(mLac != UNKNOWN_CID && mCid != UNKNOWN_CID)        
        {
            sb.append(Integer.toHexString(mLac))
                    .append(Integer.toHexString(mCid))
                    .append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        } 
        sb.append("]");
String var2460B846747F8B22185AD8BE722266A5_1168421261 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1168421261.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1168421261;
        
        
        
        
            
                    
        
            
                    
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.656 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "508EC0CC7A01F7F2A86E9B55F39759FC")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1039423245 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693694340 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693694340;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.656 -0400", hash_original_method = "1E78D18C8DE0132253C9C6F62415E5D0", hash_generated_method = "FA1CAB9206E178F89040B282ADC106B2")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mRssi);
        dest.writeInt(mLac);
        dest.writeInt(mCid);
        dest.writeInt(mPsc);
        dest.writeInt(mNetworkType);
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.656 -0400", hash_original_field = "8BFE34C4000F650130C4963445C4E1B6", hash_generated_field = "F6EDBF72ECD8A61081441E4AC3C870CD")

    static final public int UNKNOWN_RSSI = 99;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.656 -0400", hash_original_field = "00D8CC585DE5942E790D0B6DBE5EE9C9", hash_generated_field = "D9FCCDBBA982AD41A39B7F3CA7D935CF")

    static final public int UNKNOWN_CID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:40.656 -0400", hash_original_field = "DE988715B069DAB2E1B83C6FB9A3EF2B", hash_generated_field = "C13A3537973EEEB5EAFEC3144DEB5B69")

    public static final Parcelable.Creator<NeighboringCellInfo> CREATOR
    = new Parcelable.Creator<NeighboringCellInfo>() {
        public NeighboringCellInfo createFromParcel(Parcel in) {
            return new NeighboringCellInfo(in);
        }

        public NeighboringCellInfo[] newArray(int size) {
            return new NeighboringCellInfo[size];
        }
    };
    
    public NeighboringCellInfo createFromParcel(Parcel in) {
            return new NeighboringCellInfo(in);
        }
    
    
    public NeighboringCellInfo[] newArray(int size) {
            return new NeighboringCellInfo[size];
        }
    
}

