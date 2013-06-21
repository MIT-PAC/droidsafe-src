package android.net.wifi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import android.net.NetworkInfo.DetailedState;
import android.net.NetworkUtils;
import java.net.InetAddress;
import java.net.Inet6Address;
import java.net.UnknownHostException;
import java.util.EnumMap;

public class WifiInfo implements Parcelable {
    private SupplicantState mSupplicantState;
    private String mBSSID;
    private String mSSID;
    private int mNetworkId;
    private boolean mHiddenSSID;
    private int mRssi;
    private int mLinkSpeed;
    private InetAddress mIpAddress;
    private String mMacAddress;
    private boolean mExplicitConnect;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.635 -0400", hash_original_method = "3BA330D18DA6D0534E844B32F499A548", hash_generated_method = "283DC6763562F72F36B3A0DB544BF2E3")
    @DSModeled(DSC.SAFE)
     WifiInfo() {
        mSSID = null;
        mBSSID = null;
        mNetworkId = -1;
        mSupplicantState = SupplicantState.UNINITIALIZED;
        mRssi = -9999;
        mLinkSpeed = -1;
        mHiddenSSID = false;
        mExplicitConnect = false;
        // ---------- Original Method ----------
        //mSSID = null;
        //mBSSID = null;
        //mNetworkId = -1;
        //mSupplicantState = SupplicantState.UNINITIALIZED;
        //mRssi = -9999;
        //mLinkSpeed = -1;
        //mHiddenSSID = false;
        //mExplicitConnect = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.635 -0400", hash_original_method = "405CB5D945A11DFB599C76C83B7C3513", hash_generated_method = "AE5E86475792C476196186C66643BE42")
    @DSModeled(DSC.SAFE)
    public WifiInfo(WifiInfo source) {
        dsTaint.addTaint(source.dsTaint);
        {
            mSupplicantState = source.mSupplicantState;
            mBSSID = source.mBSSID;
            mSSID = source.mSSID;
            mNetworkId = source.mNetworkId;
            mHiddenSSID = source.mHiddenSSID;
            mRssi = source.mRssi;
            mLinkSpeed = source.mLinkSpeed;
            mIpAddress = source.mIpAddress;
            mMacAddress = source.mMacAddress;
            mExplicitConnect = source.mExplicitConnect;
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //mSupplicantState = source.mSupplicantState;
            //mBSSID = source.mBSSID;
            //mSSID = source.mSSID;
            //mNetworkId = source.mNetworkId;
            //mHiddenSSID = source.mHiddenSSID;
            //mRssi = source.mRssi;
            //mLinkSpeed = source.mLinkSpeed;
            //mIpAddress = source.mIpAddress;
            //mMacAddress = source.mMacAddress;
            //mExplicitConnect = source.mExplicitConnect;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.636 -0400", hash_original_method = "89967329215A273EB27CD79E5BB8124F", hash_generated_method = "91A03148FD60CF342FE4D7A443544DE0")
    @DSModeled(DSC.SAFE)
     void setSSID(String SSID) {
        dsTaint.addTaint(SSID);
        mHiddenSSID = false;
        // ---------- Original Method ----------
        //mSSID = SSID;
        //mHiddenSSID = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.636 -0400", hash_original_method = "79B89773022C9616E7A28BB8F338ADFD", hash_generated_method = "300C4CA4EADA3A819734DFAFBD041E20")
    @DSModeled(DSC.SAFE)
    public String getSSID() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSSID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.637 -0400", hash_original_method = "66D619B3A9C00436F0EA6225848F76E2", hash_generated_method = "50F312A9D9E28C2E3F422E31D4B6BBC5")
    @DSModeled(DSC.SAFE)
     void setBSSID(String BSSID) {
        dsTaint.addTaint(BSSID);
        // ---------- Original Method ----------
        //mBSSID = BSSID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.637 -0400", hash_original_method = "4164893247FD5E84E98B26376E6216D7", hash_generated_method = "30786FAA51F6AD4F120CE2C9C9A516DA")
    @DSModeled(DSC.SAFE)
    public String getBSSID() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mBSSID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.637 -0400", hash_original_method = "EAA2EB56C456A75F6A36236287457095", hash_generated_method = "081F05199A2C71EF0BEBC21C99B1D30F")
    @DSModeled(DSC.SAFE)
    public int getRssi() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRssi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.637 -0400", hash_original_method = "DC61695B2550927FEF6924BD6DCCD37F", hash_generated_method = "63C1A0784D1BDB02DAC812EBA0E4194C")
    @DSModeled(DSC.SAFE)
     void setRssi(int rssi) {
        dsTaint.addTaint(rssi);
        // ---------- Original Method ----------
        //mRssi = rssi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.638 -0400", hash_original_method = "78D01A80334309441C41F6B9CC957D2A", hash_generated_method = "CD570A067D83673517C68AF6CF4FE9E3")
    @DSModeled(DSC.SAFE)
    public int getLinkSpeed() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLinkSpeed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.638 -0400", hash_original_method = "BE3FF818F2C5FDEDBAE4E9D0AB590378", hash_generated_method = "C5C0533D2894C4A248F6230742333C0D")
    @DSModeled(DSC.SAFE)
     void setLinkSpeed(int linkSpeed) {
        dsTaint.addTaint(linkSpeed);
        // ---------- Original Method ----------
        //this.mLinkSpeed = linkSpeed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.639 -0400", hash_original_method = "D01D60678F7B1D8F273F61CB3F3E57D7", hash_generated_method = "AB978C440E63E1C383F12EA158747E5E")
    @DSModeled(DSC.SAFE)
     void setMacAddress(String macAddress) {
        dsTaint.addTaint(macAddress);
        // ---------- Original Method ----------
        //this.mMacAddress = macAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.640 -0400", hash_original_method = "3C8E67358ACD99AD783D244CA0276ACD", hash_generated_method = "1236105EAA537F0A2F01DA5468D3A8E5")
    @DSModeled(DSC.SAFE)
    public String getMacAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMacAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.640 -0400", hash_original_method = "9EA9BCBB38651D2FFE57E5088D2224E9", hash_generated_method = "E5291D7A942CA2C1C14739623C7B2B68")
    @DSModeled(DSC.SAFE)
     void setNetworkId(int id) {
        dsTaint.addTaint(id);
        // ---------- Original Method ----------
        //mNetworkId = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.640 -0400", hash_original_method = "1123FC1D4BB4576127DCFBEFE95B45B2", hash_generated_method = "BBEA02C13F8355FFD3900C5F1C5B5294")
    @DSModeled(DSC.SAFE)
    public boolean isExplicitConnect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mExplicitConnect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.640 -0400", hash_original_method = "3A4A87F80F04538D566E1F3D87FB9121", hash_generated_method = "F2271987DF9E2E33BBD692FEBB8D90D6")
    @DSModeled(DSC.SAFE)
    public void setExplicitConnect(boolean explicitConnect) {
        dsTaint.addTaint(explicitConnect);
        // ---------- Original Method ----------
        //this.mExplicitConnect = explicitConnect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.640 -0400", hash_original_method = "B76AAD80CE4B08426894CE7F5D58A537", hash_generated_method = "5AC719E4D59B0E814BAC3E2BECE5D6D8")
    @DSModeled(DSC.SAFE)
    public int getNetworkId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNetworkId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.641 -0400", hash_original_method = "8E3F1F3B329B69F39A487C61B59EF2C9", hash_generated_method = "EA12DCFAFAEE9AD526625CD57C6C9790")
    @DSModeled(DSC.SAFE)
    public SupplicantState getSupplicantState() {
        return (SupplicantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSupplicantState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.641 -0400", hash_original_method = "D88102438CF5144569D4601488BE4027", hash_generated_method = "5638211F990435BEA977100532FDB0D9")
    @DSModeled(DSC.SAFE)
     void setSupplicantState(SupplicantState state) {
        dsTaint.addTaint(state.dsTaint);
        // ---------- Original Method ----------
        //mSupplicantState = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.641 -0400", hash_original_method = "34F62DC8D94CF645975CE5993EA04307", hash_generated_method = "483E222805C5CFF074127ADE6E38C100")
    @DSModeled(DSC.SAFE)
     void setInetAddress(InetAddress address) {
        dsTaint.addTaint(address.dsTaint);
        // ---------- Original Method ----------
        //mIpAddress = address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.641 -0400", hash_original_method = "B90838B740ABA91EEFFDC5A9A5E25B34", hash_generated_method = "A8ACC974A58A3C959764CD06885A7930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIpAddress() {
        int varBCEEF5AE8C416DD5DB7F7A6563440778_1874488044 = (NetworkUtils.inetAddressToInt(mIpAddress));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mIpAddress == null || mIpAddress instanceof Inet6Address) return 0;
        //return NetworkUtils.inetAddressToInt(mIpAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.641 -0400", hash_original_method = "C4A754B6DCF0E16A6381A21399FCB1B9", hash_generated_method = "B0D6C95A7F4C1E518EFBC87FC3EA5A01")
    @DSModeled(DSC.SAFE)
    public boolean getHiddenSSID() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHiddenSSID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.642 -0400", hash_original_method = "FC84BEFBD9B7D8BF135E20B2EE1BDB16", hash_generated_method = "CC9BAAE34D661AA1AE20B7FDEDD1A733")
    @DSModeled(DSC.SAFE)
    public void setHiddenSSID(boolean hiddenSSID) {
        dsTaint.addTaint(hiddenSSID);
        // ---------- Original Method ----------
        //mHiddenSSID = hiddenSSID;
    }

    
        public static DetailedState getDetailedStateOf(SupplicantState suppState) {
        return stateMap.get(suppState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.642 -0400", hash_original_method = "C2C24AA87816421D7C3613D024B55B7F", hash_generated_method = "0E2F9C4ED64B50A0210FDE960FBBD6D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setSupplicantState(String stateName) {
        dsTaint.addTaint(stateName);
        mSupplicantState = valueOf(stateName);
        // ---------- Original Method ----------
        //mSupplicantState = valueOf(stateName);
    }

    
        static SupplicantState valueOf(String stateName) {
        if ("4WAY_HANDSHAKE".equalsIgnoreCase(stateName))
            return SupplicantState.FOUR_WAY_HANDSHAKE;
        else {
            try {
                return SupplicantState.valueOf(stateName.toUpperCase());
            } catch (IllegalArgumentException e) {
                return SupplicantState.INVALID;
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.643 -0400", hash_original_method = "E7F8A705E19A9ABF8AEEB72FBC5B6139", hash_generated_method = "671AB8181494AE224D8C54605841565E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuffer sb;
        sb = new StringBuffer();
        String none;
        none = "<none>";
        sb.append("SSID: ").append(mSSID == null ? none : mSSID).
            append(", BSSID: ").append(mBSSID == null ? none : mBSSID).
            append(", MAC: ").append(mMacAddress == null ? none : mMacAddress).
            append(", Supplicant state: ").
            append(mSupplicantState == null ? none : mSupplicantState).
            append(", RSSI: ").append(mRssi).
            append(", Link speed: ").append(mLinkSpeed).
            append(", Net ID: ").append(mNetworkId).
            append(", Explicit connect: ").append(mExplicitConnect);
        String var806458D832AB974D230FEE4CBBDBD390_813978267 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer sb = new StringBuffer();
        //String none = "<none>";
        //sb.append("SSID: ").append(mSSID == null ? none : mSSID).
            //append(", BSSID: ").append(mBSSID == null ? none : mBSSID).
            //append(", MAC: ").append(mMacAddress == null ? none : mMacAddress).
            //append(", Supplicant state: ").
            //append(mSupplicantState == null ? none : mSupplicantState).
            //append(", RSSI: ").append(mRssi).
            //append(", Link speed: ").append(mLinkSpeed).
            //append(", Net ID: ").append(mNetworkId).
            //append(", Explicit connect: ").append(mExplicitConnect);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.643 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.644 -0400", hash_original_method = "D24857F81D2FD5D48ED12D74EE96B85F", hash_generated_method = "252BFA9C25ECD53F9CF090D25DC20A6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mNetworkId);
        dest.writeInt(mRssi);
        dest.writeInt(mLinkSpeed);
        {
            dest.writeByte((byte)1);
            dest.writeByteArray(mIpAddress.getAddress());
        } //End block
        {
            dest.writeByte((byte)0);
        } //End block
        dest.writeString(getSSID());
        dest.writeString(mBSSID);
        dest.writeString(mMacAddress);
        dest.writeByte(mExplicitConnect ? (byte)1 : (byte)0);
        mSupplicantState.writeToParcel(dest, flags);
        // ---------- Original Method ----------
        //dest.writeInt(mNetworkId);
        //dest.writeInt(mRssi);
        //dest.writeInt(mLinkSpeed);
        //if (mIpAddress != null) {
            //dest.writeByte((byte)1);
            //dest.writeByteArray(mIpAddress.getAddress());
        //} else {
            //dest.writeByte((byte)0);
        //}
        //dest.writeString(getSSID());
        //dest.writeString(mBSSID);
        //dest.writeString(mMacAddress);
        //dest.writeByte(mExplicitConnect ? (byte)1 : (byte)0);
        //mSupplicantState.writeToParcel(dest, flags);
    }

    
    private static final EnumMap<SupplicantState, DetailedState> stateMap =
        new EnumMap<SupplicantState, DetailedState>(SupplicantState.class);
    static {
        stateMap.put(SupplicantState.DISCONNECTED, DetailedState.DISCONNECTED);
        stateMap.put(SupplicantState.INTERFACE_DISABLED, DetailedState.DISCONNECTED);
        stateMap.put(SupplicantState.INACTIVE, DetailedState.IDLE);
        stateMap.put(SupplicantState.SCANNING, DetailedState.SCANNING);
        stateMap.put(SupplicantState.AUTHENTICATING, DetailedState.CONNECTING);
        stateMap.put(SupplicantState.ASSOCIATING, DetailedState.CONNECTING);
        stateMap.put(SupplicantState.ASSOCIATED, DetailedState.CONNECTING);
        stateMap.put(SupplicantState.FOUR_WAY_HANDSHAKE, DetailedState.AUTHENTICATING);
        stateMap.put(SupplicantState.GROUP_HANDSHAKE, DetailedState.AUTHENTICATING);
        stateMap.put(SupplicantState.COMPLETED, DetailedState.OBTAINING_IPADDR);
        stateMap.put(SupplicantState.DORMANT, DetailedState.DISCONNECTED);
        stateMap.put(SupplicantState.UNINITIALIZED, DetailedState.IDLE);
        stateMap.put(SupplicantState.INVALID, DetailedState.FAILED);
    }
    
    public static final String LINK_SPEED_UNITS = "Mbps";
    public static final Creator<WifiInfo> CREATOR = new Creator<WifiInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.644 -0400", hash_original_method = "183B79FF3465A6A1D81809AF2517D75A", hash_generated_method = "190E1C72F044525E171A81D79CCDEC7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            WifiInfo info;
            info = new WifiInfo();
            info.setNetworkId(in.readInt());
            info.setRssi(in.readInt());
            info.setLinkSpeed(in.readInt());
            {
                boolean varA34511E23A7BE70AFB33ABE4FC1AF4E2_182341289 = (in.readByte() == 1);
                {
                    try 
                    {
                        info.setInetAddress(InetAddress.getByAddress(in.createByteArray()));
                    } //End block
                    catch (UnknownHostException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            info.setSSID(in.readString());
            info.mBSSID = in.readString();
            info.mMacAddress = in.readString();
            info.mExplicitConnect = in.readByte() == 1 ? true : false;
            info.mSupplicantState = SupplicantState.CREATOR.createFromParcel(in);
            return (WifiInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //WifiInfo info = new WifiInfo();
            //info.setNetworkId(in.readInt());
            //info.setRssi(in.readInt());
            //info.setLinkSpeed(in.readInt());
            //if (in.readByte() == 1) {
                    //try {
                        //info.setInetAddress(InetAddress.getByAddress(in.createByteArray()));
                    //} catch (UnknownHostException e) {}
                //}
            //info.setSSID(in.readString());
            //info.mBSSID = in.readString();
            //info.mMacAddress = in.readString();
            //info.mExplicitConnect = in.readByte() == 1 ? true : false;
            //info.mSupplicantState = SupplicantState.CREATOR.createFromParcel(in);
            //return info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.644 -0400", hash_original_method = "204078EBB7721EC13904260949AFA2E0", hash_generated_method = "D890CD2519FECDF120CAD250A7221BED")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            WifiInfo[] var1C0DEB749548B05D5E9792470EB37997_204521380 = (new WifiInfo[size]);
            return (WifiInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WifiInfo[size];
        }

        
}; //Transformed anonymous class
}

