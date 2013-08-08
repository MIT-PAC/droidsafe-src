package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.Parcel;
import android.os.Parcelable;





public class WifiP2pInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.725 -0400", hash_original_field = "1740B1E1D57405A515A6DBBC32594257", hash_generated_field = "AC4DD7321028D187B95846163AF3D483")

    public boolean groupFormed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.725 -0400", hash_original_field = "E7FF43348C972BE9FE21440703EC050C", hash_generated_field = "390E841B6F43D1667192DD5E95B6133C")

    public boolean isGroupOwner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.725 -0400", hash_original_field = "83640593734C51A71A44985C60A44CD6", hash_generated_field = "C10FF4BA92C149BB7C2E75B0A14FBF4A")

    public InetAddress groupOwnerAddress;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.725 -0400", hash_original_method = "F3F0ABA121ED75F0A34990BB87685D5A", hash_generated_method = "8D8A828B3FE364068776E0C23F2C39D1")
    public  WifiP2pInfo() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.726 -0400", hash_original_method = "B6AB4762A9FFB2E56B17CB04649CE702", hash_generated_method = "E32609BDA8BE2120C63377FC7E0FF44F")
    public  WifiP2pInfo(WifiP2pInfo source) {
        if(source != null)        
        {
            groupFormed = source.groupFormed;
            isGroupOwner = source.isGroupOwner;
            groupOwnerAddress = source.groupOwnerAddress;
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //groupFormed = source.groupFormed;
            //isGroupOwner = source.isGroupOwner;
            //groupOwnerAddress = source.groupOwnerAddress;
       //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.727 -0400", hash_original_method = "D5529C8AE8D596D7C37EDA99E72A8446", hash_generated_method = "0F75B902AAAA8B8A8A20D42A44BA7599")
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("groupFormed: ").append(groupFormed)
            .append("isGroupOwner: ").append(isGroupOwner)
            .append("groupOwnerAddress: ").append(groupOwnerAddress);
String var69222FFA45D1268AEE1923C5558B0BD5_1635168046 =         sbuf.toString();
        var69222FFA45D1268AEE1923C5558B0BD5_1635168046.addTaint(taint);
        return var69222FFA45D1268AEE1923C5558B0BD5_1635168046;
        // ---------- Original Method ----------
        //StringBuffer sbuf = new StringBuffer();
        //sbuf.append("groupFormed: ").append(groupFormed)
            //.append("isGroupOwner: ").append(isGroupOwner)
            //.append("groupOwnerAddress: ").append(groupOwnerAddress);
        //return sbuf.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.727 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "50986A87FA687373D5A7DB041C6856EA")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_229067708 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2011080176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2011080176;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.728 -0400", hash_original_method = "FB185B7C2F06925C4BFCD27CA8D3CCFA", hash_generated_method = "E9D8979270555CBE4D1DBA2BD57956B2")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeByte(groupFormed ? (byte)1 : (byte)0);
        dest.writeByte(isGroupOwner ? (byte)1 : (byte)0);
        if(groupOwnerAddress != null)        
        {
            dest.writeByte((byte)1);
            dest.writeByteArray(groupOwnerAddress.getAddress());
        } //End block
        else
        {
            dest.writeByte((byte)0);
        } //End block
        // ---------- Original Method ----------
        //dest.writeByte(groupFormed ? (byte)1 : (byte)0);
        //dest.writeByte(isGroupOwner ? (byte)1 : (byte)0);
        //if (groupOwnerAddress != null) {
            //dest.writeByte((byte)1);
            //dest.writeByteArray(groupOwnerAddress.getAddress());
        //} else {
            //dest.writeByte((byte)0);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.728 -0400", hash_original_field = "AB83BB5FED9FC57A40F7F74C050C8CCC", hash_generated_field = "F2557F2DCFADCE7DD4ED006ED74D08D1")

    public static final Creator<WifiP2pInfo> CREATOR =
        new Creator<WifiP2pInfo>() {
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

            @DSModeled(DSC.SAFE)
        public WifiP2pInfo[] newArray(int size) {
                return new WifiP2pInfo[size];
            }
        };
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

