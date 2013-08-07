package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class DhcpInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.462 -0400", hash_original_field = "9D0DE3EE8DA929F164DA3D6942A26C0E", hash_generated_field = "C724F9C20BA29ABA1B784CD7B6F790AC")

    public int ipAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.462 -0400", hash_original_field = "3E21AB62FB17400301D9F0156B6C3031", hash_generated_field = "4A25F063CFF1A08AFBDF399724369996")

    public int gateway;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.462 -0400", hash_original_field = "3F5C8ADFE42894248788EF03028CCA0B", hash_generated_field = "425E646BC1F92E2E3580929E14D019CB")

    public int netmask;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.462 -0400", hash_original_field = "EA7A64692946A5F46EC886328D133D7D", hash_generated_field = "257F82C9AA70827B0BA2B4E037775503")

    public int dns1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.462 -0400", hash_original_field = "A831E6BCC55C70D2AE9E7E84ADC9028D", hash_generated_field = "BC9DD1C3178F0AAF32A5A79882B2C471")

    public int dns2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.463 -0400", hash_original_field = "836C673259E51101A01E755A34F97359", hash_generated_field = "955CDA6770D7F45900D23A25A1E286DF")

    public int serverAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.463 -0400", hash_original_field = "EFDB6D9EA18998638D28A31554B9189B", hash_generated_field = "7EE02913D8BA0209DD0BF7B47A6FCC6D")

    public int leaseDuration;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.463 -0400", hash_original_method = "C1DF7E5F229CB04932AB2C91464EDDF1", hash_generated_method = "529F08EF9721051414135D71EEC80E9A")
    public  DhcpInfo() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.464 -0400", hash_original_method = "39B86796FD777927684A932467EC8639", hash_generated_method = "B9F609EF229BB81C3D684FFBA5D41A88")
    public  DhcpInfo(DhcpInfo source) {
        if(source != null)        
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.465 -0400", hash_original_method = "8D7B8EC19D16628B2975B72E53B9E8C8", hash_generated_method = "92403EE712B2AB671919354669E66117")
    public String toString() {
        StringBuffer str = new StringBuffer();
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
String var24D7484D779E22452A6C5FBC9AEC25FA_1611793050 =         str.toString();
        var24D7484D779E22452A6C5FBC9AEC25FA_1611793050.addTaint(taint);
        return var24D7484D779E22452A6C5FBC9AEC25FA_1611793050;
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

    
    @DSModeled(DSC.BAN)
    private static void putAddress(StringBuffer buf, int addr) {
        buf.append(NetworkUtils.intToInetAddress(addr).getHostAddress());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.465 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5AA35666D4BE217DF54C792BC7129116")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1811279466 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764871919 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764871919;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.466 -0400", hash_original_method = "EAB5EBBB3C53B9EB39B520A9586CC73F", hash_generated_method = "F87B62B9FC8B7BB277B51C26D6B492CB")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.466 -0400", hash_original_field = "9856C027FECDC0A66630F7DFB04D7434", hash_generated_field = "89C286478D97EE5D122EFDEA836E1240")

    public static final Creator<DhcpInfo> CREATOR =
        new Creator<DhcpInfo>() {
            public DhcpInfo createFromParcel(Parcel in) {
                DhcpInfo info = new DhcpInfo();
                info.ipAddress = in.readInt();
                info.gateway = in.readInt();
                info.netmask = in.readInt();
                info.dns1 = in.readInt();
                info.dns2 = in.readInt();
                info.serverAddress = in.readInt();
                info.leaseDuration = in.readInt();
                return info;
            }

            public DhcpInfo[] newArray(int size) {
                return new DhcpInfo[size];
            }
        };
    // orphaned legacy method
    public DhcpInfo createFromParcel(Parcel in) {
                DhcpInfo info = new DhcpInfo();
                info.ipAddress = in.readInt();
                info.gateway = in.readInt();
                info.netmask = in.readInt();
                info.dns1 = in.readInt();
                info.dns2 = in.readInt();
                info.serverAddress = in.readInt();
                info.leaseDuration = in.readInt();
                return info;
            }
    
    // orphaned legacy method
    public DhcpInfo[] newArray(int size) {
                return new DhcpInfo[size];
            }
    
}

