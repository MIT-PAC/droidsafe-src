package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import java.net.InetAddress;

public class DhcpInfo implements Parcelable {
    public int ipAddress;
    public int gateway;
    public int netmask;
    public int dns1;
    public int dns2;
    public int serverAddress;
    public int leaseDuration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.549 -0400", hash_original_method = "C1DF7E5F229CB04932AB2C91464EDDF1", hash_generated_method = "529F08EF9721051414135D71EEC80E9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DhcpInfo() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.549 -0400", hash_original_method = "39B86796FD777927684A932467EC8639", hash_generated_method = "CA7F047FBBD18AB1ED8EB98236DAAB8B")
    @DSModeled(DSC.SAFE)
    public DhcpInfo(DhcpInfo source) {
        dsTaint.addTaint(source.dsTaint);
        {
            ipAddress = source.ipAddress;
            gateway = source.gateway;
            netmask = source.netmask;
            dns1 = source.dns1;
            dns2 = source.dns2;
            serverAddress = source.serverAddress;
            leaseDuration = source.leaseDuration;
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //ipAddress = source.ipAddress;
            //gateway = source.gateway;
            //netmask = source.netmask;
            //dns1 = source.dns1;
            //dns2 = source.dns2;
            //serverAddress = source.serverAddress;
            //leaseDuration = source.leaseDuration;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.550 -0400", hash_original_method = "8D7B8EC19D16628B2975B72E53B9E8C8", hash_generated_method = "0E96BDCA2804E2FDBBF0853BA6740713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuffer str;
        str = new StringBuffer();
        str.append("ipaddr ");
        putAddress(str, ipAddress);
        str.append(" gateway ");
        putAddress(str, gateway);
        str.append(" netmask ");
        putAddress(str, netmask);
        str.append(" dns1 ");
        putAddress(str, dns1);
        str.append(" dns2 ");
        putAddress(str, dns2);
        str.append(" DHCP server ");
        putAddress(str, serverAddress);
        str.append(" lease ").append(leaseDuration).append(" seconds");
        String varCDF926920844FBB113EB20FEB0C3BED9_1293305685 = (str.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer str = new StringBuffer();
        //str.append("ipaddr ");
        //putAddress(str, ipAddress);
        //str.append(" gateway ");
        //putAddress(str, gateway);
        //str.append(" netmask ");
        //putAddress(str, netmask);
        //str.append(" dns1 ");
        //putAddress(str, dns1);
        //str.append(" dns2 ");
        //putAddress(str, dns2);
        //str.append(" DHCP server ");
        //putAddress(str, serverAddress);
        //str.append(" lease ").append(leaseDuration).append(" seconds");
        //return str.toString();
    }

    
        private static void putAddress(StringBuffer buf, int addr) {
        buf.append(NetworkUtils.intToInetAddress(addr).getHostAddress());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.551 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.551 -0400", hash_original_method = "EAB5EBBB3C53B9EB39B520A9586CC73F", hash_generated_method = "5B551E391B024E0E7667415C8D8BB553")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(ipAddress);
        dest.writeInt(gateway);
        dest.writeInt(netmask);
        dest.writeInt(dns1);
        dest.writeInt(dns2);
        dest.writeInt(serverAddress);
        dest.writeInt(leaseDuration);
        // ---------- Original Method ----------
        //dest.writeInt(ipAddress);
        //dest.writeInt(gateway);
        //dest.writeInt(netmask);
        //dest.writeInt(dns1);
        //dest.writeInt(dns2);
        //dest.writeInt(serverAddress);
        //dest.writeInt(leaseDuration);
    }

    
    public static final Creator<DhcpInfo> CREATOR = new Creator<DhcpInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.553 -0400", hash_original_method = "F44837DFDE4E00511933DFB4D7F0040E", hash_generated_method = "5F97D55755F233EB24E39BA1D5C48EAC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DhcpInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            DhcpInfo info;
            info = new DhcpInfo();
            info.ipAddress = in.readInt();
            info.gateway = in.readInt();
            info.netmask = in.readInt();
            info.dns1 = in.readInt();
            info.dns2 = in.readInt();
            info.serverAddress = in.readInt();
            info.leaseDuration = in.readInt();
            return (DhcpInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //DhcpInfo info = new DhcpInfo();
            //info.ipAddress = in.readInt();
            //info.gateway = in.readInt();
            //info.netmask = in.readInt();
            //info.dns1 = in.readInt();
            //info.dns2 = in.readInt();
            //info.serverAddress = in.readInt();
            //info.leaseDuration = in.readInt();
            //return info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.556 -0400", hash_original_method = "807ED57C7D32921184285C1BE9B084C4", hash_generated_method = "A1B9869FCB225E02F55CE3E0F96E53D7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DhcpInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            DhcpInfo[] var025B8E96467F6687B8F475AC4F271E0A_772939000 = (new DhcpInfo[size]);
            return (DhcpInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new DhcpInfo[size];
        }

        
}; //Transformed anonymous class
}

