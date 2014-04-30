package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.Parcel;
import android.os.Parcelable;

public class WifiP2pInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.728 -0400", hash_original_field = "AB83BB5FED9FC57A40F7F74C050C8CCC", hash_generated_field = "F2557F2DCFADCE7DD4ED006ED74D08D1")

    public static final Creator<WifiP2pInfo> CREATOR =
        new Creator<WifiP2pInfo>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.382 -0500", hash_original_method = "495509163C5863569FB618FB24832814", hash_generated_method = "B41D7DA78EFFE4B989128A612A0EC681")
        
public WifiP2pInfo createFromParcel(Parcel in) {
                WifiP2pInfo info = new WifiP2pInfo();
                info.groupFormed = (in.readByte() == 1);
                info.isGroupOwner = (in.readByte() == 1);
                if (in.readByte() == 1) {
                    try {
                        info.groupOwnerAddress = InetAddress.getByAddress(in.createByteArray());
                    } catch (UnknownHostException e) {}
                }
                return info;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.385 -0500", hash_original_method = "C513089B1326226F967748E0B8CB823D", hash_generated_method = "337F5A76703E63AB06A7F6E63456DBFB")
        
public WifiP2pInfo[] newArray(int size) {
                return new WifiP2pInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.363 -0500", hash_original_field = "E28A7A0FC5A8D6E8322E2D7849EEB56C", hash_generated_field = "AC4DD7321028D187B95846163AF3D483")

    public boolean groupFormed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.365 -0500", hash_original_field = "3C5F4332E834665E71D37D23C7BAB635", hash_generated_field = "390E841B6F43D1667192DD5E95B6133C")

    public boolean isGroupOwner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.367 -0500", hash_original_field = "CD95B6A96458D990C98F8B29F61F4A9D", hash_generated_field = "C10FF4BA92C149BB7C2E75B0A14FBF4A")

    public InetAddress groupOwnerAddress;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.369 -0500", hash_original_method = "F3F0ABA121ED75F0A34990BB87685D5A", hash_generated_method = "4A17C2D8D9E71E4775DCF43CBC69EFE4")
    
public WifiP2pInfo() {
    }

    /** copy constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.377 -0500", hash_original_method = "B6AB4762A9FFB2E56B17CB04649CE702", hash_generated_method = "A674E475D00223BC14DFC58DB2846669")
    
public WifiP2pInfo(WifiP2pInfo source) {
        if (source != null) {
            groupFormed = source.groupFormed;
            isGroupOwner = source.isGroupOwner;
            groupOwnerAddress = source.groupOwnerAddress;
       }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.372 -0500", hash_original_method = "D5529C8AE8D596D7C37EDA99E72A8446", hash_generated_method = "4462C98277D0907E61D3E2D1AB20C097")
    
public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("groupFormed: ").append(groupFormed)
            .append("isGroupOwner: ").append(isGroupOwner)
            .append("groupOwnerAddress: ").append(groupOwnerAddress);
        return sbuf.toString();
    }

    /** Implement the Parcelable interface */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.373 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:02.379 -0500", hash_original_method = "FB185B7C2F06925C4BFCD27CA8D3CCFA", hash_generated_method = "54EA4035BADA299A0CB903894C3D5048")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(groupFormed ? (byte)1 : (byte)0);
        dest.writeByte(isGroupOwner ? (byte)1 : (byte)0);

        if (groupOwnerAddress != null) {
            dest.writeByte((byte)1);
            dest.writeByteArray(groupOwnerAddress.getAddress());
        } else {
            dest.writeByte((byte)0);
        }
    }
    // orphaned legacy method
    public WifiP2pInfo createFromParcel(Parcel in) {
                WifiP2pInfo info = new WifiP2pInfo();
                info.groupFormed = (in.readByte() == 1);
                info.isGroupOwner = (in.readByte() == 1);
                if (in.readByte() == 1) {
                    try {
                        info.groupOwnerAddress = InetAddress.getByAddress(in.createByteArray());
                    } catch (UnknownHostException e) {}
                }
                return info;
            }
    
    // orphaned legacy method
    public WifiP2pInfo[] newArray(int size) {
                return new WifiP2pInfo[size];
            }
    
}

