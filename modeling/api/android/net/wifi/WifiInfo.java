package android.net.wifi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.EnumMap;

import android.net.NetworkInfo.DetailedState;
import android.net.NetworkUtils;
import android.os.Parcel;
import android.os.Parcelable;

public class WifiInfo implements Parcelable {

   /**
     * Map a supplicant state into a fine-grained network connectivity state.
     * @param suppState the supplicant state
     * @return the corresponding {@link DetailedState}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.740 -0500", hash_original_method = "F542C355F3242469ACCE35220DDFDBE5", hash_generated_method = "2558B6D0BB0DACBA2DD75CD86516BDE5")
    
public static DetailedState getDetailedStateOf(SupplicantState suppState) {
        return stateMap.get(suppState);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.744 -0500", hash_original_method = "27D623BE4A455BD5783DEE25FF79A268", hash_generated_method = "FC3B36B122A00923EDD6563B18D75E70")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.667 -0500", hash_original_field = "1C215056D7D361323FD53AB2D005D9C0", hash_generated_field = "04518B14ED2821E0DD5F3A27EFB1369C")

    private static final EnumMap<SupplicantState, DetailedState> stateMap =
        new EnumMap<SupplicantState, DetailedState>(SupplicantState.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.682 -0500", hash_original_field = "E610F2A671A905CF7760F337B5BDB0B2", hash_generated_field = "ABAFD2EF3023F1403E0A2BE381C4FBB6")

    public static final String LINK_SPEED_UNITS = "Mbps";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.307 -0400", hash_original_field = "377CD1781B3B021A8514603282CD1326", hash_generated_field = "1B405BAB9AF1675AAD98451A10C8598C")

    public static final Creator<WifiInfo> CREATOR =
        new Creator<WifiInfo>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.756 -0500", hash_original_method = "183B79FF3465A6A1D81809AF2517D75A", hash_generated_method = "FEE6D34A91D680B8284076E3D708A954")
        
public WifiInfo createFromParcel(Parcel in) {
                WifiInfo info = new WifiInfo();
                info.setNetworkId(in.readInt());
                info.setRssi(in.readInt());
                info.setLinkSpeed(in.readInt());
                if (in.readByte() == 1) {
                    try {
                        info.setInetAddress(InetAddress.getByAddress(in.createByteArray()));
                    } catch (UnknownHostException e) {}
                }
                info.setSSID(in.readString());
                info.mBSSID = in.readString();
                info.mMacAddress = in.readString();
                info.mExplicitConnect = in.readByte() == 1 ? true : false;
                info.mSupplicantState = SupplicantState.CREATOR.createFromParcel(in);
                return info;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.758 -0500", hash_original_method = "204078EBB7721EC13904260949AFA2E0", hash_generated_method = "C3DD56EBD04E7636B7FEB4FC8C76C3C5")
        
public WifiInfo[] newArray(int size) {
                return new WifiInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.669 -0500", hash_original_field = "71E5F11C6C6A357B17335AC29ACEB806", hash_generated_field = "53C0C50586977D30F50A38A02FF5AA68")

    private SupplicantState mSupplicantState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.671 -0500", hash_original_field = "BA4C35C052E8004F528E30414F0190E7", hash_generated_field = "8B037BB299AA86EC9205CCC26093C407")

    private String mBSSID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.673 -0500", hash_original_field = "6DAB9F118B414EF660FCCD6C60045754", hash_generated_field = "2B2BE2BFB640EA8BAB57AED2C4B7FB28")

    private String mSSID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.676 -0500", hash_original_field = "35D9C3886ADE4E969F0372275377C2D8", hash_generated_field = "7A5A39D03C1616F994D4D06922BB67CA")

    private int mNetworkId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.678 -0500", hash_original_field = "A5033717735A5E3D071C9C5ED12CF77E", hash_generated_field = "E44F3137D11F225B15705595FA8A88CF")

    private boolean mHiddenSSID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.680 -0500", hash_original_field = "099A808424BA5E503C844DE262FD5F84", hash_generated_field = "6944DD992E34997F099DF17CBFD1CEA4")

    private int mRssi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.684 -0500", hash_original_field = "D5EC3C2A06D55B9DB627DA02B554D7FC", hash_generated_field = "43B3DE4173B552748C6B7489CCBEC17C")

    private int mLinkSpeed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.687 -0500", hash_original_field = "E9098950DB44B340A14FFBDC4B14A5D7", hash_generated_field = "8748C1AB2EADB5D1897B9503B257BEA4")

    private InetAddress mIpAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.689 -0500", hash_original_field = "682CA38497F79919D68D1CB6E724CEC5", hash_generated_field = "3901352E95CA91998F9C2F8294C84B42")

    private String mMacAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.691 -0500", hash_original_field = "1C7D754ADACBB7D4690B7B15CB851C7B", hash_generated_field = "8A066F33F6CB5BC95F526BC987310751")

    private boolean mExplicitConnect;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.693 -0500", hash_original_method = "3BA330D18DA6D0534E844B32F499A548", hash_generated_method = "3BA330D18DA6D0534E844B32F499A548")
    
WifiInfo() {
        mSSID = null;
        mBSSID = null;
        mNetworkId = -1;
        mSupplicantState = SupplicantState.UNINITIALIZED;
        mRssi = -9999;
        mLinkSpeed = -1;
        mHiddenSSID = false;
        mExplicitConnect = false;
    }

    /**
     * Copy constructor
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.696 -0500", hash_original_method = "405CB5D945A11DFB599C76C83B7C3513", hash_generated_method = "9B2FB230902F3CA0C739F517EF4FA11A")
    
public WifiInfo(WifiInfo source) {
        if (source != null) {
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
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.698 -0500", hash_original_method = "89967329215A273EB27CD79E5BB8124F", hash_generated_method = "E565F1268544A2F6A10C838FAA2F15C2")
    
void setSSID(String SSID) {
        mSSID = SSID;
        // network is considered not hidden by default
        mHiddenSSID = false;
    }

    /**
     * Returns the service set identifier (SSID) of the current 802.11 network.
     * If the SSID is an ASCII string, it will be returned surrounded by double
     * quotation marks.Otherwise, it is returned as a string of hex digits. The
     * SSID may be {@code null} if there is no network currently connected.
     * @return the SSID
     */
    @DSComment("Wifi subsystem")
    @DSSpec(DSCat.WIFI)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.701 -0500", hash_original_method = "79B89773022C9616E7A28BB8F338ADFD", hash_generated_method = "C2EEA641DC127571BADAA8674E69F26A")
    
public String getSSID() {
        return mSSID;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.703 -0500", hash_original_method = "66D619B3A9C00436F0EA6225848F76E2", hash_generated_method = "66D619B3A9C00436F0EA6225848F76E2")
    
void setBSSID(String BSSID) {
        mBSSID = BSSID;
    }

    /**
     * Return the basic service set identifier (BSSID) of the current access point.
     * The BSSID may be {@code null} if there is no network currently connected.
     * @return the BSSID, in the form of a six-byte MAC address: {@code XX:XX:XX:XX:XX:XX}
     */
    @DSComment("Wifi subsystem")
    @DSSpec(DSCat.WIFI)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.705 -0500", hash_original_method = "4164893247FD5E84E98B26376E6216D7", hash_generated_method = "33D3B695984FE58097D7766F3B30F4EB")
    
public String getBSSID() {
        return mBSSID;
    }

    /**
     * Returns the received signal strength indicator of the current 802.11
     * network.
     * <p><strong>This is not normalized, but should be!</strong></p>
     * @return the RSSI, in the range ??? to ???
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.707 -0500", hash_original_method = "EAA2EB56C456A75F6A36236287457095", hash_generated_method = "941E5DA09E96558F6267EFA8918B8C44")
    
public int getRssi() {
        return mRssi;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.709 -0500", hash_original_method = "DC61695B2550927FEF6924BD6DCCD37F", hash_generated_method = "DC61695B2550927FEF6924BD6DCCD37F")
    
void setRssi(int rssi) {
        mRssi = rssi;
    }

    /**
     * Returns the current link speed in {@link #LINK_SPEED_UNITS}.
     * @return the link speed.
     * @see #LINK_SPEED_UNITS
     */
    @DSComment("Wifi subsystem")
    @DSSpec(DSCat.WIFI)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.711 -0500", hash_original_method = "78D01A80334309441C41F6B9CC957D2A", hash_generated_method = "1A12703182C96635CEB77DEB614A9A91")
    
public int getLinkSpeed() {
        return mLinkSpeed;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.713 -0500", hash_original_method = "BE3FF818F2C5FDEDBAE4E9D0AB590378", hash_generated_method = "BE3FF818F2C5FDEDBAE4E9D0AB590378")
    
void setLinkSpeed(int linkSpeed) {
        this.mLinkSpeed = linkSpeed;
    }

    /**
     * Record the MAC address of the WLAN interface
     * @param macAddress the MAC address in {@code XX:XX:XX:XX:XX:XX} form
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.715 -0500", hash_original_method = "D01D60678F7B1D8F273F61CB3F3E57D7", hash_generated_method = "D01D60678F7B1D8F273F61CB3F3E57D7")
    
void setMacAddress(String macAddress) {
        this.mMacAddress = macAddress;
    }

    @DSComment("Wifi subsystem")
    @DSSpec(DSCat.WIFI)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.717 -0500", hash_original_method = "3C8E67358ACD99AD783D244CA0276ACD", hash_generated_method = "2DFC50A3778FC48D626A671E77081C38")
    
public String getMacAddress() {
        return mMacAddress;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.719 -0500", hash_original_method = "9EA9BCBB38651D2FFE57E5088D2224E9", hash_generated_method = "9EA9BCBB38651D2FFE57E5088D2224E9")
    
void setNetworkId(int id) {
        mNetworkId = id;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.721 -0500", hash_original_method = "1123FC1D4BB4576127DCFBEFE95B45B2", hash_generated_method = "C1A94F7C907482061E07C36F1D6DBD25")
    
public boolean isExplicitConnect() {
        return mExplicitConnect;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.723 -0500", hash_original_method = "3A4A87F80F04538D566E1F3D87FB9121", hash_generated_method = "380B9A447E55F7DE3D89C846638CAAF2")
    
public void setExplicitConnect(boolean explicitConnect) {
        this.mExplicitConnect = explicitConnect;
    }

    /**
     * Each configured network has a unique small integer ID, used to identify
     * the network when performing operations on the supplicant. This method
     * returns the ID for the currently connected network.
     * @return the network ID, or -1 if there is no currently connected network
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.725 -0500", hash_original_method = "B76AAD80CE4B08426894CE7F5D58A537", hash_generated_method = "637E6B0E5E1D730FCF7E33D5A0BB3D16")
    
public int getNetworkId() {
        return mNetworkId;
    }

    /**
     * Return the detailed state of the supplicant's negotiation with an
     * access point, in the form of a {@link SupplicantState SupplicantState} object.
     * @return the current {@link SupplicantState SupplicantState}
     */
    @DSComment("Wifi subsystem")
    @DSSpec(DSCat.WIFI)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.727 -0500", hash_original_method = "8E3F1F3B329B69F39A487C61B59EF2C9", hash_generated_method = "D2362E116557988672F965102DAA1533")
    
public SupplicantState getSupplicantState() {
        return mSupplicantState;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.729 -0500", hash_original_method = "D88102438CF5144569D4601488BE4027", hash_generated_method = "D88102438CF5144569D4601488BE4027")
    
void setSupplicantState(SupplicantState state) {
        mSupplicantState = state;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.732 -0500", hash_original_method = "34F62DC8D94CF645975CE5993EA04307", hash_generated_method = "34F62DC8D94CF645975CE5993EA04307")
    
void setInetAddress(InetAddress address) {
        mIpAddress = address;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.734 -0500", hash_original_method = "B90838B740ABA91EEFFDC5A9A5E25B34", hash_generated_method = "E78FF920665B00C85E06520C31C73BB6")
    
public int getIpAddress() {
        if (mIpAddress == null || mIpAddress instanceof Inet6Address) return 0;
        return NetworkUtils.inetAddressToInt(mIpAddress);
    }

    /**
     * @return {@code true} if this network does not broadcast its SSID, so an
     * SSID-specific probe request must be used for scans.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.736 -0500", hash_original_method = "C4A754B6DCF0E16A6381A21399FCB1B9", hash_generated_method = "E77E70F9E868C52B9C3502A000851180")
    
public boolean getHiddenSSID() {
        return mHiddenSSID;
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.738 -0500", hash_original_method = "FC84BEFBD9B7D8BF135E20B2EE1BDB16", hash_generated_method = "C8B31465D382D4BD5391975A226B69CC")
    
public void setHiddenSSID(boolean hiddenSSID) {
        mHiddenSSID = hiddenSSID;
    }

    /**
     * Set the <code>SupplicantState</code> from the string name
     * of the state.
     * @param stateName the name of the state, as a <code>String</code> returned
     * in an event sent by {@code wpa_supplicant}.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.742 -0500", hash_original_method = "C2C24AA87816421D7C3613D024B55B7F", hash_generated_method = "C2C24AA87816421D7C3613D024B55B7F")
    
void setSupplicantState(String stateName) {
        mSupplicantState = valueOf(stateName);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.748 -0500", hash_original_method = "E7F8A705E19A9ABF8AEEB72FBC5B6139", hash_generated_method = "DE0D69B9FB95AB6E04C486EE9BBEF739")
    
@Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String none = "<none>";

        sb.append("SSID: ").append(mSSID == null ? none : mSSID).
            append(", BSSID: ").append(mBSSID == null ? none : mBSSID).
            append(", MAC: ").append(mMacAddress == null ? none : mMacAddress).
            append(", Supplicant state: ").
            append(mSupplicantState == null ? none : mSupplicantState).
            append(", RSSI: ").append(mRssi).
            append(", Link speed: ").append(mLinkSpeed).
            append(", Net ID: ").append(mNetworkId).
            append(", Explicit connect: ").append(mExplicitConnect);

        return sb.toString();
    }
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

    /** Implement the Parcelable interface {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.750 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface {@hide} */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.752 -0500", hash_original_method = "D24857F81D2FD5D48ED12D74EE96B85F", hash_generated_method = "944E3B9651FC8E61BF18728C60B359E3")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNetworkId);
        dest.writeInt(mRssi);
        dest.writeInt(mLinkSpeed);
        if (mIpAddress != null) {
            dest.writeByte((byte)1);
            dest.writeByteArray(mIpAddress.getAddress());
        } else {
            dest.writeByte((byte)0);
        }
        dest.writeString(getSSID());
        dest.writeString(mBSSID);
        dest.writeString(mMacAddress);
        dest.writeByte(mExplicitConnect ? (byte)1 : (byte)0);
        mSupplicantState.writeToParcel(dest, flags);
    }
    // orphaned legacy method
    public WifiInfo createFromParcel(Parcel in) {
                WifiInfo info = new WifiInfo();
                info.setNetworkId(in.readInt());
                info.setRssi(in.readInt());
                info.setLinkSpeed(in.readInt());
                if (in.readByte() == 1) {
                    try {
                        info.setInetAddress(InetAddress.getByAddress(in.createByteArray()));
                    } catch (UnknownHostException e) {}
                }
                info.setSSID(in.readString());
                info.mBSSID = in.readString();
                info.mMacAddress = in.readString();
                info.mExplicitConnect = in.readByte() == 1 ? true : false;
                info.mSupplicantState = SupplicantState.CREATOR.createFromParcel(in);
                return info;
            }
    
    // orphaned legacy method
    public WifiInfo[] newArray(int size) {
                return new WifiInfo[size];
            }
    
}

