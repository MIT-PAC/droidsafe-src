package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

public class LinkAddress implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.986 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "220CE3F94E98B4B531A4938FAFF932C0")

    private InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.986 -0400", hash_original_field = "66E8BBB112C8BE88E6A5CE871B315D9D", hash_generated_field = "084C50C9B5174447084CD13D800A5566")

    private int prefixLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.988 -0400", hash_original_method = "E18970F19EA2BD1962AA6C76D20344B4", hash_generated_method = "397016D1D2AA1EFEE4D9841005050136")
    public  LinkAddress(InetAddress address, int prefixLength) {
        if(address == null || prefixLength < 0 ||
                ((address instanceof Inet4Address) && prefixLength > 32) ||
                (prefixLength > 128))        
        {
            IllegalArgumentException varCD0EDD8E397B2945CA5520577BC12570_1225459930 = new IllegalArgumentException("Bad LinkAddress params " + address +
                    prefixLength);
            varCD0EDD8E397B2945CA5520577BC12570_1225459930.addTaint(taint);
            throw varCD0EDD8E397B2945CA5520577BC12570_1225459930;
        } //End block
        this.address = address;
        this.prefixLength = prefixLength;
        // ---------- Original Method ----------
        //if (address == null || prefixLength < 0 ||
                //((address instanceof Inet4Address) && prefixLength > 32) ||
                //(prefixLength > 128)) {
            //throw new IllegalArgumentException("Bad LinkAddress params " + address +
                    //prefixLength);
        //}
        //this.address = address;
        //this.prefixLength = prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.990 -0400", hash_original_method = "C1B2B41E8E3046D397247308090C2940", hash_generated_method = "74560F72D0A34A93BE2A8D4EDBFC2F02")
    public  LinkAddress(InterfaceAddress interfaceAddress) {
        this.address = interfaceAddress.getAddress();
        this.prefixLength = interfaceAddress.getNetworkPrefixLength();
        // ---------- Original Method ----------
        //this.address = interfaceAddress.getAddress();
        //this.prefixLength = interfaceAddress.getNetworkPrefixLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.991 -0400", hash_original_method = "5FAB79F8CDEEE71CFB15A1270E373FE2", hash_generated_method = "11BE33745447B5BF61BCE8895560B3DD")
    @Override
    public String toString() {
String var36CF141E9317AA4912392021807AA049_508228217 =         (address == null ? "" : (address.getHostAddress() + "/" + prefixLength));
        var36CF141E9317AA4912392021807AA049_508228217.addTaint(taint);
        return var36CF141E9317AA4912392021807AA049_508228217;
        // ---------- Original Method ----------
        //return (address == null ? "" : (address.getHostAddress() + "/" + prefixLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.993 -0400", hash_original_method = "22B797A588843480EFDE3E6D1B46B555", hash_generated_method = "FD3AE0B99D46492A8F801FF3BCC28B54")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(!(obj instanceof LinkAddress))        
        {
            boolean var68934A3E9455FA72420237EB05902327_692735346 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92268150 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_92268150;
        } //End block
        LinkAddress linkAddress = (LinkAddress) obj;
        boolean var777DD3D3302E266CDD204939BA47C302_1213832635 = (this.address.equals(linkAddress.address) &&
            this.prefixLength == linkAddress.prefixLength);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_948541772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_948541772;
        // ---------- Original Method ----------
        //if (!(obj instanceof LinkAddress)) {
            //return false;
        //}
        //LinkAddress linkAddress = (LinkAddress) obj;
        //return this.address.equals(linkAddress.address) &&
            //this.prefixLength == linkAddress.prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.994 -0400", hash_original_method = "9EA21E5C93FB30EF49C5DDE7580A80C1", hash_generated_method = "9FAFF30D5E912583CADEBDDACF969E30")
    @Override
    public int hashCode() {
        int var4744153A221296483C601A9AE924B644_1378775637 = (((null == address) ? 0 : address.hashCode()) + prefixLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2116805103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2116805103;
        // ---------- Original Method ----------
        //return ((null == address) ? 0 : address.hashCode()) + prefixLength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.994 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "7390D050E2331152984A8AC91558B538")
    public InetAddress getAddress() {
InetAddress var814577DDD37BAFB17E08CBEFDB411BAE_2079745846 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_2079745846.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_2079745846;
        // ---------- Original Method ----------
        //return address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.995 -0400", hash_original_method = "2E2106DAF5193DB540436A7E1AE68959", hash_generated_method = "2EC097B6E4171E65730F098195F507BB")
    public int getNetworkPrefixLength() {
        int var66E8BBB112C8BE88E6A5CE871B315D9D_129254996 = (prefixLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233819146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233819146;
        // ---------- Original Method ----------
        //return prefixLength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.997 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BC9C34ED57A90C5EB314EC9C645F8E10")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_492951255 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459134702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_459134702;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.998 -0400", hash_original_method = "977238F2CE06FE4C6D167170C229C693", hash_generated_method = "CFF927D3C0069B2A6F317B886C322057")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        if(address != null)        
        {
            dest.writeByte((byte)1);
            dest.writeByteArray(address.getAddress());
            dest.writeInt(prefixLength);
        } //End block
        else
        {
            dest.writeByte((byte)0);
        } //End block
        // ---------- Original Method ----------
        //if (address != null) {
            //dest.writeByte((byte)1);
            //dest.writeByteArray(address.getAddress());
            //dest.writeInt(prefixLength);
        //} else {
            //dest.writeByte((byte)0);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.999 -0400", hash_original_field = "B0BE06D5C388ED18692D43797B3D4462", hash_generated_field = "8FA213B8981AE83560DF995BD24C9D6A")

    public static final Creator<LinkAddress> CREATOR =
        new Creator<LinkAddress>() {
            public LinkAddress createFromParcel(Parcel in) {
                InetAddress address = null;
                int prefixLength = 0;
                if (in.readByte() == 1) {
                    try {
                        address = InetAddress.getByAddress(in.createByteArray());
                        prefixLength = in.readInt();
                    } catch (UnknownHostException e) { }
                }
                return new LinkAddress(address, prefixLength);
            }

            public LinkAddress[] newArray(int size) {
                return new LinkAddress[size];
            }
        };
    // orphaned legacy method
    public LinkAddress createFromParcel(Parcel in) {
                InetAddress address = null;
                int prefixLength = 0;
                if (in.readByte() == 1) {
                    try {
                        address = InetAddress.getByAddress(in.createByteArray());
                        prefixLength = in.readInt();
                    } catch (UnknownHostException e) { }
                }
                return new LinkAddress(address, prefixLength);
            }
    
    // orphaned legacy method
    public LinkAddress[] newArray(int size) {
                return new LinkAddress[size];
            }
    
}

