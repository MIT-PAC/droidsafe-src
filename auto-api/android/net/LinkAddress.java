package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

public class LinkAddress implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.686 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "220CE3F94E98B4B531A4938FAFF932C0")

    private InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.686 -0400", hash_original_field = "66E8BBB112C8BE88E6A5CE871B315D9D", hash_generated_field = "084C50C9B5174447084CD13D800A5566")

    private int prefixLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.687 -0400", hash_original_method = "E18970F19EA2BD1962AA6C76D20344B4", hash_generated_method = "3BEF60B604ED7811C02CB0E532C2373C")
    public  LinkAddress(InetAddress address, int prefixLength) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad LinkAddress params " + address +
                    prefixLength);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.695 -0400", hash_original_method = "C1B2B41E8E3046D397247308090C2940", hash_generated_method = "74560F72D0A34A93BE2A8D4EDBFC2F02")
    public  LinkAddress(InterfaceAddress interfaceAddress) {
        this.address = interfaceAddress.getAddress();
        this.prefixLength = interfaceAddress.getNetworkPrefixLength();
        // ---------- Original Method ----------
        //this.address = interfaceAddress.getAddress();
        //this.prefixLength = interfaceAddress.getNetworkPrefixLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.710 -0400", hash_original_method = "5FAB79F8CDEEE71CFB15A1270E373FE2", hash_generated_method = "EB6E5BBA04278C1A610F6806E6092714")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1372027048 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1372027048 = (address == null ? "" : (address.getHostAddress() + "/" + prefixLength));
        varB4EAC82CA7396A68D541C85D26508E83_1372027048.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1372027048;
        // ---------- Original Method ----------
        //return (address == null ? "" : (address.getHostAddress() + "/" + prefixLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.711 -0400", hash_original_method = "22B797A588843480EFDE3E6D1B46B555", hash_generated_method = "AE1C562737672CAD5C8859B1296FD692")
    @Override
    public boolean equals(Object obj) {
        LinkAddress linkAddress;
        linkAddress = (LinkAddress) obj;
        boolean var195E25D4C8453452BE01B1BC7E2B7999_1434881007 = (this.address.equals(linkAddress.address) &&
            this.prefixLength == linkAddress.prefixLength);
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796714805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_796714805;
        // ---------- Original Method ----------
        //if (!(obj instanceof LinkAddress)) {
            //return false;
        //}
        //LinkAddress linkAddress = (LinkAddress) obj;
        //return this.address.equals(linkAddress.address) &&
            //this.prefixLength == linkAddress.prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.712 -0400", hash_original_method = "9EA21E5C93FB30EF49C5DDE7580A80C1", hash_generated_method = "576131C272814AF1D017AD4F8986D8E5")
    @Override
    public int hashCode() {
        int var53C32C44D1879E92E4FF52253C962024_947216565 = (((null == address) ? 0 : address.hashCode()) + prefixLength); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923278628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923278628;
        // ---------- Original Method ----------
        //return ((null == address) ? 0 : address.hashCode()) + prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.726 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "3D57258B2F38F823DA3FC731C00C3A49")
    public InetAddress getAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2031777947 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2031777947 = address;
        varB4EAC82CA7396A68D541C85D26508E83_2031777947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2031777947;
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.727 -0400", hash_original_method = "2E2106DAF5193DB540436A7E1AE68959", hash_generated_method = "EE6F124806D4AF1CEE71723B5D109672")
    public int getNetworkPrefixLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963434076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963434076;
        // ---------- Original Method ----------
        //return prefixLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.729 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "AB2A8F298C040F04F2A5F3D78F16C216")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121130013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121130013;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.741 -0400", hash_original_method = "977238F2CE06FE4C6D167170C229C693", hash_generated_method = "8D92E6CD9284B089EFA5A1B8C439D328")
    public void writeToParcel(Parcel dest, int flags) {
        {
            dest.writeByte((byte)1);
            dest.writeByteArray(address.getAddress());
            dest.writeInt(prefixLength);
        } //End block
        {
            dest.writeByte((byte)0);
        } //End block
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //if (address != null) {
            //dest.writeByte((byte)1);
            //dest.writeByteArray(address.getAddress());
            //dest.writeInt(prefixLength);
        //} else {
            //dest.writeByte((byte)0);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:20.741 -0400", hash_original_field = "B0BE06D5C388ED18692D43797B3D4462", hash_generated_field = "8FA213B8981AE83560DF995BD24C9D6A")

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
}

