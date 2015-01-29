package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class WifiP2pGroup implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.700 -0400", hash_original_field = "2D4DFD124864C66F2F83797BE326D45F", hash_generated_field = "32E89BB9B9BA18A350DF4B63B27D02B5")

    public static final Creator<WifiP2pGroup> CREATOR =
        new Creator<WifiP2pGroup>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.796 -0500", hash_original_method = "6F43542D9464653EF7252A408A904124", hash_generated_method = "0AAFC31AEF32EE74BA32C1723C5B55A3")
        
public WifiP2pGroup createFromParcel(Parcel in) {
                WifiP2pGroup group = new WifiP2pGroup();
                group.setNetworkName(in.readString());
                group.setOwner((WifiP2pDevice)in.readParcelable(null));
                group.setIsGroupOwner(in.readByte() == (byte)1);
                int clientCount = in.readInt();
                for (int i=0; i<clientCount; i++) {
                    group.addClient((WifiP2pDevice) in.readParcelable(null));
                }
                group.setPassphrase(in.readString());
                group.setInterface(in.readString());
                return group;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.798 -0500", hash_original_method = "839A08DA63AA08BCC51725CBC0D012F5", hash_generated_method = "D42B1C48976796C6089A4299882CFC2A")
        
public WifiP2pGroup[] newArray(int size) {
                return new WifiP2pGroup[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.732 -0500", hash_original_field = "4356708624754D6A036248C9D516A427", hash_generated_field = "2CC664DA8BE6E5F03767811BA72227AE")

    private String mNetworkName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.734 -0500", hash_original_field = "BB0BEFBB0157AC1AAA4CA58CE511A880", hash_generated_field = "C79230C01ABFDB08C1FB6B4E9FE29F22")

    private WifiP2pDevice mOwner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.736 -0500", hash_original_field = "0341559909D8DC109E87D272E3B61A90", hash_generated_field = "046456A515A3EA867E61CF2C37A5861B")

    private boolean mIsGroupOwner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.739 -0500", hash_original_field = "506316AC6B6E0DA76508CC76E960BEE2", hash_generated_field = "2084A80652A9E120D7E9DEC5FAD3BB40")

    private List<WifiP2pDevice> mClients = new ArrayList<WifiP2pDevice>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.741 -0500", hash_original_field = "7EFCF6C93BBB5E3CC194609ADC6CA924", hash_generated_field = "86AD418EF42EB24608144FE3538B1AA2")

    private String mPassphrase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.743 -0500", hash_original_field = "184B1D198467B8AE4B7F05E082D0D094", hash_generated_field = "5F89B7D413C8E14947C0E11B080C408D")

    private String mInterface;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.745 -0500", hash_original_method = "BC18BEC489FA7E8F37CA54A3CD540A78", hash_generated_method = "50BE05574BAFE54B42B3583E008D5D2E")
    
public WifiP2pGroup() {
    }

    /**
     * @param supplicantEvent formats supported include
     *
     *  P2P-GROUP-STARTED p2p-wlan0-0 [client|GO] ssid="DIRECT-W8" freq=2437
     *  [psk=2182b2e50e53f260d04f3c7b25ef33c965a3291b9b36b455a82d77fd82ca15bc|
     *  passphrase="fKG4jMe3"] go_dev_addr=fa:7b:7a:42:02:13
     *
     *  P2P-GROUP-REMOVED p2p-wlan0-0 [client|GO] reason=REQUESTED
     *
     *  P2P-INVITATION-RECEIVED sa=fa:7b:7a:42:02:13 go_dev_addr=f8:7b:7a:42:02:13
     *  bssid=fa:7b:7a:42:82:13 unknown-network
     *
     *  Note: The events formats can be looked up in the wpa_supplicant code
     *  @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.748 -0500", hash_original_method = "67A4D14BE9A5BB5A5FDEDC963A5F293B", hash_generated_method = "34DAF45DE8B51FEE7336D86BA49D96B6")
    
public WifiP2pGroup(String supplicantEvent) throws IllegalArgumentException {

        String[] tokens = supplicantEvent.split(" ");

        if (tokens.length < 3) {
            throw new IllegalArgumentException("Malformed supplicant event");
        }

        if (tokens[0].startsWith("P2P-GROUP")) {
            mInterface = tokens[1];
            mIsGroupOwner = tokens[2].equals("GO");

            for (String token : tokens) {
                String[] nameValue = token.split("=");
                if (nameValue.length != 2) continue;

                if (nameValue[0].equals("ssid")) {
                    mNetworkName = nameValue[1];
                    continue;
                }

                if (nameValue[0].equals("passphrase")) {
                    mPassphrase = nameValue[1];
                    continue;
                }

                if (nameValue[0].equals("go_dev_addr")) {
                    mOwner = new WifiP2pDevice(nameValue[1]);
                }
            }
        } else if (tokens[0].equals("P2P-INVITATION-RECEIVED")) {
            for (String token : tokens) {
                String[] nameValue = token.split("=");
                if (nameValue.length != 2) continue;

                if (nameValue[0].equals("go_dev_addr")) {
                    mOwner = new WifiP2pDevice(nameValue[1]);
                    continue;
                }
            }
        } else {
            throw new IllegalArgumentException("Malformed supplicant event");
        }
    }

    /** copy constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.790 -0500", hash_original_method = "5122EA1190FB8645A8F414458A4E6688", hash_generated_method = "5F3ADF9E1375D7B348637FA1C7634210")
    
public WifiP2pGroup(WifiP2pGroup source) {
        if (source != null) {
            mNetworkName = source.getNetworkName();
            mOwner = new WifiP2pDevice(source.getOwner());
            mIsGroupOwner = source.mIsGroupOwner;
            for (WifiP2pDevice d : source.getClientList()) mClients.add(d);
            mPassphrase = source.getPassphrase();
            mInterface = source.getInterface();
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.750 -0500", hash_original_method = "1F3206015C0D7A4CBD5E705EF1C23A0F", hash_generated_method = "7E1B968CCB171A8CC591FB0EAD50AEC9")
    
public void setNetworkName(String networkName) {
        mNetworkName = networkName;
    }

    /**
     * Get the network name (SSID) of the group. Legacy Wi-Fi clients will discover
     * the p2p group using the network name.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.752 -0500", hash_original_method = "32FF89F2A0087E1C62BF10B34EF6D932", hash_generated_method = "DC64C8129674BFBBF94D2E6D1D3FC601")
    
public String getNetworkName() {
        return mNetworkName;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.755 -0500", hash_original_method = "389E55BA9756949E35517D77609F8AC0", hash_generated_method = "6359BB9CB90D1992DA66C3E22F953A45")
    
public void setIsGroupOwner(boolean isGo) {
        mIsGroupOwner = isGo;
    }

    /** Check whether this device is the group owner of the created p2p group */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.758 -0500", hash_original_method = "9599D1040188F59722C5FA5110991675", hash_generated_method = "A081EA0AA099270013DF221F7CC39B44")
    
public boolean isGroupOwner() {
        return mIsGroupOwner;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.760 -0500", hash_original_method = "3B8BEB5DE992C10464B29BB370E6A4AC", hash_generated_method = "C35A15CC0B8193F4B6F2047C34970869")
    
public void setOwner(WifiP2pDevice device) {
        mOwner = device;
    }

    /** Get the details of the group owner as a {@link WifiP2pDevice} object */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.761 -0500", hash_original_method = "64A8053D0F0646F5E4AC8BED59B588ED", hash_generated_method = "5357633E58BC1D89A5BD0F82B8A9A91C")
    
public WifiP2pDevice getOwner() {
        return mOwner;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.763 -0500", hash_original_method = "DBE7A809671EFF433B1C312D5019CC64", hash_generated_method = "CA72FF7B3F1D65CBCBA9B942C49D96AE")
    
public void addClient(String address) {
        addClient(new WifiP2pDevice(address));
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.765 -0500", hash_original_method = "79E27749F3AC38AE959779DE4B42A054", hash_generated_method = "560ADC68C34B218024F2AED583ECA1FF")
    
public void addClient(WifiP2pDevice device) {
        for (WifiP2pDevice client : mClients) {
            if (client.equals(device)) return;
        }
        mClients.add(device);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.767 -0500", hash_original_method = "1526E375B4DF8BACD06805B33A5DCA8C", hash_generated_method = "D02FABC199CA5426E364048036FC66AD")
    
public boolean removeClient(String address) {
        return mClients.remove(new WifiP2pDevice(address));
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.769 -0500", hash_original_method = "EDE2AC4ED1045F1449D193D9276A4C02", hash_generated_method = "DA6B51AE4F3B7D012A4CBE6DC98DD680")
    
public boolean removeClient(WifiP2pDevice device) {
        return mClients.remove(device);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.772 -0500", hash_original_method = "FBB5E028AB398AA4DEEB45B59F22DD8A", hash_generated_method = "3D9D8BA6CE8E0E342F185719AA6CB009")
    
public boolean isClientListEmpty() {
        return mClients.size() == 0;
    }

    /** Get the list of clients currently part of the p2p group */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.774 -0500", hash_original_method = "31A1E7A8626C889DB764B143F0123BF3", hash_generated_method = "9B9852E3DA294D7B9EA8E681DC06519D")
    
public Collection<WifiP2pDevice> getClientList() {
        return Collections.unmodifiableCollection(mClients);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.776 -0500", hash_original_method = "073EE8049BAF41A715DB20DDA5E00101", hash_generated_method = "32A06AB7594510A25B30281BCC6455ED")
    
public void setPassphrase(String passphrase) {
        mPassphrase = passphrase;
    }

    /**
     * Get the passphrase of the group. This function will return a valid passphrase only
     * at the group owner. Legacy Wi-Fi clients will need this passphrase alongside
     * network name obtained from {@link #getNetworkName()} to join the group
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.778 -0500", hash_original_method = "5EB5F9BABC374AD0DE2453D35DFCC36C", hash_generated_method = "082E499D0A06290331D523961E75BF62")
    
public String getPassphrase() {
        return mPassphrase;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.780 -0500", hash_original_method = "1BDFB331CB7F44520C6251E3C44B9A62", hash_generated_method = "14B30D0E69B38C072B99E121B9058232")
    
public void setInterface(String intf) {
        mInterface = intf;
    }

    /** Get the interface name on which the group is created */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.782 -0500", hash_original_method = "3F43528BD183AE40A353AE75903024B0", hash_generated_method = "F000FE7FD11E62E37DE291D24E00E4C3")
    
public String getInterface() {
        return mInterface;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.784 -0500", hash_original_method = "D6A6710E4962EEBC5AEB834D1EC25D10", hash_generated_method = "F4BF3F9DFD7D7D3763DCFD756F3D2542")
    
public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("network: ").append(mNetworkName);
        sbuf.append("\n isGO: ").append(mIsGroupOwner);
        sbuf.append("\n GO: ").append(mOwner);
        for (WifiP2pDevice client : mClients) {
            sbuf.append("\n Client: ").append(client);
        }
        sbuf.append("\n interface: ").append(mInterface);
        return sbuf.toString();
    }

    /** Implement the Parcelable interface */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.787 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:00.792 -0500", hash_original_method = "1E901056DDD7FF66FB9A75FE788910FD", hash_generated_method = "DDFCE07975622A7FED462B730D2753CC")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mNetworkName);
        dest.writeParcelable(mOwner, flags);
        dest.writeByte(mIsGroupOwner ? (byte) 1: (byte) 0);
        dest.writeInt(mClients.size());
        for (WifiP2pDevice client : mClients) {
            dest.writeParcelable(client, flags);
        }
        dest.writeString(mPassphrase);
        dest.writeString(mInterface);
    }
    // orphaned legacy method
    public WifiP2pGroup createFromParcel(Parcel in) {
                WifiP2pGroup group = new WifiP2pGroup();
                group.setNetworkName(in.readString());
                group.setOwner((WifiP2pDevice)in.readParcelable(null));
                group.setIsGroupOwner(in.readByte() == (byte)1);
                int clientCount = in.readInt();
                for (int i=0; i<clientCount; i++) {
                    group.addClient((WifiP2pDevice) in.readParcelable(null));
                }
                group.setPassphrase(in.readString());
                group.setInterface(in.readString());
                return group;
            }
    
    // orphaned legacy method
    public WifiP2pGroup[] newArray(int size) {
                return new WifiP2pGroup[size];
            }
    
}

