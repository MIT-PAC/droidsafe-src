package android.net.wifi.p2p;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class WifiP2pInfo implements Parcelable {
    public boolean groupFormed;
    public boolean isGroupOwner;
    public InetAddress groupOwnerAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.789 -0400", hash_original_method = "F3F0ABA121ED75F0A34990BB87685D5A", hash_generated_method = "8D8A828B3FE364068776E0C23F2C39D1")
    @DSModeled(DSC.SAFE)
    public WifiP2pInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.789 -0400", hash_original_method = "B6AB4762A9FFB2E56B17CB04649CE702", hash_generated_method = "7B1379BD80E4FFDCCC2581C5A10A9CE0")
    @DSModeled(DSC.SAFE)
    public WifiP2pInfo(WifiP2pInfo source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.789 -0400", hash_original_method = "D5529C8AE8D596D7C37EDA99E72A8446", hash_generated_method = "B21C4CEB6951A32B984613E5BE0B1D52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuffer sbuf;
        sbuf = new StringBuffer();
        sbuf.append("groupFormed: ").append(groupFormed)
            .append("isGroupOwner: ").append(isGroupOwner)
            .append("groupOwnerAddress: ").append(groupOwnerAddress);
        String var0826C75FB1499484A6621049C9E9DB4E_808048880 = (sbuf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer sbuf = new StringBuffer();
        //sbuf.append("groupFormed: ").append(groupFormed)
            //.append("isGroupOwner: ").append(isGroupOwner)
            //.append("groupOwnerAddress: ").append(groupOwnerAddress);
        //return sbuf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.789 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.790 -0400", hash_original_method = "FB185B7C2F06925C4BFCD27CA8D3CCFA", hash_generated_method = "9F9B58E1CD17BF8B819302D2746726A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeByte(groupFormed ? (byte)1 : (byte)0);
        dest.writeByte(isGroupOwner ? (byte)1 : (byte)0);
        {
            dest.writeByte((byte)1);
            dest.writeByteArray(groupOwnerAddress.getAddress());
        } //End block
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

    
    public static final Creator<WifiP2pInfo> CREATOR = new Creator<WifiP2pInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.790 -0400", hash_original_method = "495509163C5863569FB618FB24832814", hash_generated_method = "121414D4DE53776DA66724B7EDA59CDC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiP2pInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            WifiP2pInfo info;
            info = new WifiP2pInfo();
            info.groupFormed = (in.readByte() == 1);
            info.isGroupOwner = (in.readByte() == 1);
            {
                boolean varA34511E23A7BE70AFB33ABE4FC1AF4E2_1826525539 = (in.readByte() == 1);
                {
                    try 
                    {
                        info.groupOwnerAddress = InetAddress.getByAddress(in.createByteArray());
                    } //End block
                    catch (UnknownHostException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            return (WifiP2pInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //WifiP2pInfo info = new WifiP2pInfo();
            //info.groupFormed = (in.readByte() == 1);
            //info.isGroupOwner = (in.readByte() == 1);
            //if (in.readByte() == 1) {
                    //try {
                        //info.groupOwnerAddress = InetAddress.getByAddress(in.createByteArray());
                    //} catch (UnknownHostException e) {}
                //}
            //return info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.791 -0400", hash_original_method = "C513089B1326226F967748E0B8CB823D", hash_generated_method = "830F89ECD87A3E458BF5EA460668F1D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiP2pInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            WifiP2pInfo[] varE6FABE7F8AC98D6CAC675864207940D5_380939743 = (new WifiP2pInfo[size]);
            return (WifiP2pInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WifiP2pInfo[size];
        }

        
}; //Transformed anonymous class
}

