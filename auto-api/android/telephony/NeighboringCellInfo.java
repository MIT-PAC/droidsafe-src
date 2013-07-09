package android.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.438 -0400", hash_original_field = "367DEE652AE08B1E7A6DD8CD03A62B84", hash_generated_field = "6944DD992E34997F099DF17CBFD1CEA4")

    private int mRssi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.438 -0400", hash_original_field = "47909A4A63C9D0DF4D400D36305EA002", hash_generated_field = "6613038ECFEA58ECF70AB91998D5EB03")

    private int mCid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.438 -0400", hash_original_field = "B2F9C701F6B9FA98A906A1D27571667E", hash_generated_field = "E1DF72766EAA7700CC09E2EF71762BF7")

    private int mLac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.438 -0400", hash_original_field = "865B7932A3A776B1F3AFFD84DFC3DDFF", hash_generated_field = "EC9E5D02BA114935D10D39D2FABA270A")

    private int mPsc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.438 -0400", hash_original_field = "9761905E68D80D41E55047BFA13A52C2", hash_generated_field = "60BE94F590B2B55E7F16606AE64523A2")

    private int mNetworkType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.439 -0400", hash_original_method = "BD76A3213F8AC49348CAF06FA32CACCC", hash_generated_method = "8998E5B0F109CED8D6A58E23270AEBB9")
    @Deprecated
    public  NeighboringCellInfo() {
        mRssi = UNKNOWN_RSSI;
        mLac = UNKNOWN_CID;
        mCid = UNKNOWN_CID;
        mPsc = UNKNOWN_CID;
        mNetworkType = NETWORK_TYPE_UNKNOWN;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.439 -0400", hash_original_method = "19B23EA98615F51662865132429A9393", hash_generated_method = "1E061B23AF443E35C2DB8FFD1015E187")
    @Deprecated
    public  NeighboringCellInfo(int rssi, int cid) {
        mRssi = rssi;
        mCid = cid;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.439 -0400", hash_original_method = "F57F6CF0E582113B7CF21CF2AAAD28CD", hash_generated_method = "097E465D40CC716C82CD3B738475F5EB")
    public  NeighboringCellInfo(int rssi, String location, int radioType) {
        mRssi = rssi;
        mNetworkType = NETWORK_TYPE_UNKNOWN;
        mPsc = UNKNOWN_CID;
        mLac = UNKNOWN_CID;
        mCid = UNKNOWN_CID;
        int l = location.length();
        {
            {
                int i = 0;
                {
                    location = "0" + location;
                } 
            } 
        } 
        try 
        {
            
            mNetworkType = radioType;
            
            
            {
                boolean var69B59DE7F30475B3F92AD5E13EA650DF_458138417 = (!location.equalsIgnoreCase("FFFFFFFF"));
                {
                    mCid = Integer.valueOf(location.substring(4), 16);
                    mLac = Integer.valueOf(location.substring(0, 4), 16);
                } 
            } 
            
            
            mNetworkType = radioType;
            
            
            mPsc = Integer.valueOf(location, 16);
            
        } 
        catch (NumberFormatException e)
        {
            mPsc = UNKNOWN_CID;
            mLac = UNKNOWN_CID;
            mCid = UNKNOWN_CID;
            mNetworkType = NETWORK_TYPE_UNKNOWN;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.440 -0400", hash_original_method = "17FDCF259E4D17E2ACC4CF1446DF5669", hash_generated_method = "6630B7089771F571BDC033EC7FF2D880")
    public  NeighboringCellInfo(Parcel in) {
        mRssi = in.readInt();
        mLac = in.readInt();
        mCid = in.readInt();
        mPsc = in.readInt();
        mNetworkType = in.readInt();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.441 -0400", hash_original_method = "EAA2EB56C456A75F6A36236287457095", hash_generated_method = "0EEFDA4CDBDFFC7B80AC3EC7A591DC11")
    public int getRssi() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126705208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126705208;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.441 -0400", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "DBF219C52ECED7F90795799A89DECD69")
    public int getLac() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489756530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489756530;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.442 -0400", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "1820564E075D2DEC0D49CE200CE1065E")
    public int getCid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650670349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650670349;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.442 -0400", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "326BD6F4BAC0D61BD4CC5A4D6DB753EB")
    public int getPsc() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253757157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253757157;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.442 -0400", hash_original_method = "BA8FF13D9B34325771E51CDF8D4F958D", hash_generated_method = "945252BB79E4F873B2D9E30B4B2893D1")
    public int getNetworkType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166494144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166494144;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.443 -0400", hash_original_method = "6316D6CF1176EA8E415E44B17DEEB68F", hash_generated_method = "797F050B3EBE62F935630D664E238E38")
    @Deprecated
    public void setCid(int cid) {
        mCid = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.443 -0400", hash_original_method = "DC61695B2550927FEF6924BD6DCCD37F", hash_generated_method = "0E2A4B21AE2C4AC464A8CE307DEBA552")
    @Deprecated
    public void setRssi(int rssi) {
        mRssi = rssi;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.444 -0400", hash_original_method = "8F5318BC3FCF7BF30F83B998176BAD1B", hash_generated_method = "60B911B5D7074739EC7711CD1275E764")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_696198407 = null; 
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        {
            sb.append(Integer.toHexString(mPsc))
                    .append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        } 
        {
            sb.append(Integer.toHexString(mLac))
                    .append(Integer.toHexString(mCid))
                    .append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        } 
        sb.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_696198407 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_696198407.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_696198407;
        
        
        
        
            
                    
        
            
                    
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.444 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FE072517594D6B67A0C6DF396FBAE482")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350922717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350922717;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.444 -0400", hash_original_method = "1E78D18C8DE0132253C9C6F62415E5D0", hash_generated_method = "DB5C6C04B34A2A832081689AF97AA0BA")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mRssi);
        dest.writeInt(mLac);
        dest.writeInt(mCid);
        dest.writeInt(mPsc);
        dest.writeInt(mNetworkType);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.445 -0400", hash_original_field = "8BFE34C4000F650130C4963445C4E1B6", hash_generated_field = "F6EDBF72ECD8A61081441E4AC3C870CD")

    static final public int UNKNOWN_RSSI = 99;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.445 -0400", hash_original_field = "00D8CC585DE5942E790D0B6DBE5EE9C9", hash_generated_field = "D9FCCDBBA982AD41A39B7F3CA7D935CF")

    static final public int UNKNOWN_CID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.445 -0400", hash_original_field = "DE988715B069DAB2E1B83C6FB9A3EF2B", hash_generated_field = "C13A3537973EEEB5EAFEC3144DEB5B69")

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

