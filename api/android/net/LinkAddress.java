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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.312 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "220CE3F94E98B4B531A4938FAFF932C0")

    private InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.312 -0400", hash_original_field = "66E8BBB112C8BE88E6A5CE871B315D9D", hash_generated_field = "084C50C9B5174447084CD13D800A5566")

    private int prefixLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.313 -0400", hash_original_method = "E18970F19EA2BD1962AA6C76D20344B4", hash_generated_method = "3C9CF9D47F25B21D75FDA6413D163133")
    public  LinkAddress(InetAddress address, int prefixLength) {
    if(address == null || prefixLength < 0 ||
                ((address instanceof Inet4Address) && prefixLength > 32) ||
                (prefixLength > 128))        
        {
            IllegalArgumentException varCD0EDD8E397B2945CA5520577BC12570_817406597 = new IllegalArgumentException("Bad LinkAddress params " + address +
                    prefixLength);
            varCD0EDD8E397B2945CA5520577BC12570_817406597.addTaint(taint);
            throw varCD0EDD8E397B2945CA5520577BC12570_817406597;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.314 -0400", hash_original_method = "C1B2B41E8E3046D397247308090C2940", hash_generated_method = "74560F72D0A34A93BE2A8D4EDBFC2F02")
    public  LinkAddress(InterfaceAddress interfaceAddress) {
        this.address = interfaceAddress.getAddress();
        this.prefixLength = interfaceAddress.getNetworkPrefixLength();
        // ---------- Original Method ----------
        //this.address = interfaceAddress.getAddress();
        //this.prefixLength = interfaceAddress.getNetworkPrefixLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.314 -0400", hash_original_method = "5FAB79F8CDEEE71CFB15A1270E373FE2", hash_generated_method = "77E909FCE65F2426A4C61BA568F85F76")
    @Override
    public String toString() {
String var36CF141E9317AA4912392021807AA049_2146540309 =         (address == null ? "" : (address.getHostAddress() + "/" + prefixLength));
        var36CF141E9317AA4912392021807AA049_2146540309.addTaint(taint);
        return var36CF141E9317AA4912392021807AA049_2146540309;
        // ---------- Original Method ----------
        //return (address == null ? "" : (address.getHostAddress() + "/" + prefixLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.315 -0400", hash_original_method = "22B797A588843480EFDE3E6D1B46B555", hash_generated_method = "6C7755CC98D3EE80F32A23E8CE755B73")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(!(obj instanceof LinkAddress))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2070374238 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732583243 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_732583243;
        } //End block
        LinkAddress linkAddress = (LinkAddress) obj;
        boolean var777DD3D3302E266CDD204939BA47C302_1584274402 = (this.address.equals(linkAddress.address) &&
            this.prefixLength == linkAddress.prefixLength);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670555913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670555913;
        // ---------- Original Method ----------
        //if (!(obj instanceof LinkAddress)) {
            //return false;
        //}
        //LinkAddress linkAddress = (LinkAddress) obj;
        //return this.address.equals(linkAddress.address) &&
            //this.prefixLength == linkAddress.prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.315 -0400", hash_original_method = "9EA21E5C93FB30EF49C5DDE7580A80C1", hash_generated_method = "AD961B7D6DF44691E8DCD3B80FDE69F8")
    @Override
    public int hashCode() {
        int var4744153A221296483C601A9AE924B644_1102042776 = (((null == address) ? 0 : address.hashCode()) + prefixLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531558254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531558254;
        // ---------- Original Method ----------
        //return ((null == address) ? 0 : address.hashCode()) + prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.316 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "330A72BAEDBA17286D4F80DF4376B3F4")
    public InetAddress getAddress() {
InetAddress var814577DDD37BAFB17E08CBEFDB411BAE_1503227868 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_1503227868.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_1503227868;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.316 -0400", hash_original_method = "2E2106DAF5193DB540436A7E1AE68959", hash_generated_method = "F66E73EB9E094DE2C1983C66EA19DB79")
    public int getNetworkPrefixLength() {
        int var66E8BBB112C8BE88E6A5CE871B315D9D_748351198 = (prefixLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921862119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1921862119;
        // ---------- Original Method ----------
        //return prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.317 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A9E1693C690FD4AC21A5503C86B48663")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_663378027 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834859596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834859596;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.317 -0400", hash_original_method = "977238F2CE06FE4C6D167170C229C693", hash_generated_method = "CFF927D3C0069B2A6F317B886C322057")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.318 -0400", hash_original_field = "B0BE06D5C388ED18692D43797B3D4462", hash_generated_field = "8FA213B8981AE83560DF995BD24C9D6A")

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

