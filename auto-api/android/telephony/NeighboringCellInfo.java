package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private int mRssi;
    private int mCid;
    private int mLac;
    private int mPsc;
    private int mNetworkType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.376 -0400", hash_original_method = "BD76A3213F8AC49348CAF06FA32CACCC", hash_generated_method = "8998E5B0F109CED8D6A58E23270AEBB9")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public NeighboringCellInfo() {
        mRssi = UNKNOWN_RSSI;
        mLac = UNKNOWN_CID;
        mCid = UNKNOWN_CID;
        mPsc = UNKNOWN_CID;
        mNetworkType = NETWORK_TYPE_UNKNOWN;
        // ---------- Original Method ----------
        //mRssi = UNKNOWN_RSSI;
        //mLac = UNKNOWN_CID;
        //mCid = UNKNOWN_CID;
        //mPsc = UNKNOWN_CID;
        //mNetworkType = NETWORK_TYPE_UNKNOWN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.376 -0400", hash_original_method = "19B23EA98615F51662865132429A9393", hash_generated_method = "9E38440F6AC47C47842F044D8BC215DD")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public NeighboringCellInfo(int rssi, int cid) {
        dsTaint.addTaint(rssi);
        dsTaint.addTaint(cid);
        // ---------- Original Method ----------
        //mRssi = rssi;
        //mCid = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.376 -0400", hash_original_method = "F57F6CF0E582113B7CF21CF2AAAD28CD", hash_generated_method = "D113F455883D851882589D262CE26CFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NeighboringCellInfo(int rssi, String location, int radioType) {
        dsTaint.addTaint(radioType);
        dsTaint.addTaint(location);
        dsTaint.addTaint(rssi);
        mNetworkType = NETWORK_TYPE_UNKNOWN;
        mPsc = UNKNOWN_CID;
        mLac = UNKNOWN_CID;
        mCid = UNKNOWN_CID;
        int l;
        l = location.length();
        {
            {
                int i;
                i = 0;
                {
                    location = "0" + location;
                } //End block
            } //End collapsed parenthetic
        } //End block
        try 
        {
            //Begin case NETWORK_TYPE_GPRS NETWORK_TYPE_EDGE 
            {
                boolean var69B59DE7F30475B3F92AD5E13EA650DF_1367067830 = (!location.equalsIgnoreCase("FFFFFFFF"));
                {
                    mCid = Integer.valueOf(location.substring(4), 16);
                    mLac = Integer.valueOf(location.substring(0, 4), 16);
                } //End block
            } //End collapsed parenthetic
            //End case NETWORK_TYPE_GPRS NETWORK_TYPE_EDGE 
            //Begin case NETWORK_TYPE_UMTS NETWORK_TYPE_HSDPA NETWORK_TYPE_HSUPA NETWORK_TYPE_HSPA 
            mPsc = Integer.valueOf(location, 16);
            //End case NETWORK_TYPE_UMTS NETWORK_TYPE_HSDPA NETWORK_TYPE_HSUPA NETWORK_TYPE_HSPA 
        } //End block
        catch (NumberFormatException e)
        {
            mPsc = UNKNOWN_CID;
            mLac = UNKNOWN_CID;
            mCid = UNKNOWN_CID;
            mNetworkType = NETWORK_TYPE_UNKNOWN;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.377 -0400", hash_original_method = "17FDCF259E4D17E2ACC4CF1446DF5669", hash_generated_method = "1B8B3E2D115E0BAAADD0F13165A2A3A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NeighboringCellInfo(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mRssi = in.readInt();
        mLac = in.readInt();
        mCid = in.readInt();
        mPsc = in.readInt();
        mNetworkType = in.readInt();
        // ---------- Original Method ----------
        //mRssi = in.readInt();
        //mLac = in.readInt();
        //mCid = in.readInt();
        //mPsc = in.readInt();
        //mNetworkType = in.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.377 -0400", hash_original_method = "EAA2EB56C456A75F6A36236287457095", hash_generated_method = "081F05199A2C71EF0BEBC21C99B1D30F")
    @DSModeled(DSC.SAFE)
    public int getRssi() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRssi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.377 -0400", hash_original_method = "9D27DA83295DE88E54D1A14DE01D13B2", hash_generated_method = "31F966061BC352DBD246C1AFA076CE12")
    @DSModeled(DSC.SAFE)
    public int getLac() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.378 -0400", hash_original_method = "03F3B6133F275A943C2D43BD3469FDB7", hash_generated_method = "7DD277FA79EC9AB2362BF784406D1A21")
    @DSModeled(DSC.SAFE)
    public int getCid() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.378 -0400", hash_original_method = "0E29DC7205E312820087B8B417C09B13", hash_generated_method = "F05582F11BB788BADDB3833E437C2DC6")
    @DSModeled(DSC.SAFE)
    public int getPsc() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPsc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.378 -0400", hash_original_method = "BA8FF13D9B34325771E51CDF8D4F958D", hash_generated_method = "643341927349B48510322056ECA1F323")
    @DSModeled(DSC.SAFE)
    public int getNetworkType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNetworkType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.378 -0400", hash_original_method = "6316D6CF1176EA8E415E44B17DEEB68F", hash_generated_method = "F902997A655584D3B996104E8222013E")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setCid(int cid) {
        dsTaint.addTaint(cid);
        // ---------- Original Method ----------
        //mCid = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.378 -0400", hash_original_method = "DC61695B2550927FEF6924BD6DCCD37F", hash_generated_method = "407EA8E2D8A5D72500C0C63EAB12252E")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setRssi(int rssi) {
        dsTaint.addTaint(rssi);
        // ---------- Original Method ----------
        //mRssi = rssi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.379 -0400", hash_original_method = "8F5318BC3FCF7BF30F83B998176BAD1B", hash_generated_method = "903F0FE17D3ADFB6FCC5B9665870274C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("[");
        {
            sb.append(Integer.toHexString(mPsc))
                    .append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        } //End block
        {
            sb.append(Integer.toHexString(mLac))
                    .append(Integer.toHexString(mCid))
                    .append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        } //End block
        sb.append("]");
        String var806458D832AB974D230FEE4CBBDBD390_853669637 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("[");
        //if (mPsc != UNKNOWN_CID) {
            //sb.append(Integer.toHexString(mPsc))
                    //.append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        //} else if(mLac != UNKNOWN_CID && mCid != UNKNOWN_CID) {
            //sb.append(Integer.toHexString(mLac))
                    //.append(Integer.toHexString(mCid))
                    //.append("@").append(((mRssi == UNKNOWN_RSSI)? "-" : mRssi));
        //}
        //sb.append("]");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.379 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.379 -0400", hash_original_method = "1E78D18C8DE0132253C9C6F62415E5D0", hash_generated_method = "6BE38AE7AC45E9CCE94C816D3D914B4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mRssi);
        dest.writeInt(mLac);
        dest.writeInt(mCid);
        dest.writeInt(mPsc);
        dest.writeInt(mNetworkType);
        // ---------- Original Method ----------
        //dest.writeInt(mRssi);
        //dest.writeInt(mLac);
        //dest.writeInt(mCid);
        //dest.writeInt(mPsc);
        //dest.writeInt(mNetworkType);
    }

    
    static final public int UNKNOWN_RSSI = 99;
    static final public int UNKNOWN_CID = -1;
    public static final Parcelable.Creator<NeighboringCellInfo> CREATOR = new Parcelable.Creator<NeighboringCellInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.380 -0400", hash_original_method = "4C52218844DBE15F12DBE2E4C66F708D", hash_generated_method = "B10CFB5862C98C3AEEDD0E384A8CDA55")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NeighboringCellInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            NeighboringCellInfo var1C2ADAEBABFE7D174E8C5D3128C22A69_1498426125 = (new NeighboringCellInfo(in));
            return (NeighboringCellInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NeighboringCellInfo(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.380 -0400", hash_original_method = "95F5832CD053ACEB785D83B20718CEE6", hash_generated_method = "F83DEB13A6D8557E08BE996D108CA9E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NeighboringCellInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            NeighboringCellInfo[] var96B08AA4101C1DD518A55D981C1127F0_1076755396 = (new NeighboringCellInfo[size]);
            return (NeighboringCellInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NeighboringCellInfo[size];
        }

        
}; //Transformed anonymous class
}

