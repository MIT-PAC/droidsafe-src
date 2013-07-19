package java.net;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class InterfaceAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.724 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "220CE3F94E98B4B531A4938FAFF932C0")

    private InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.725 -0400", hash_original_field = "56E381C3954FC3FF7DB3E92DA33AD137", hash_generated_field = "7567F98825AE2C855E0ED195DA10645B")

    private InetAddress broadcastAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.725 -0400", hash_original_field = "66E8BBB112C8BE88E6A5CE871B315D9D", hash_generated_field = "70DE7742499AEA0A92EA72A6919A370C")

    private short prefixLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.726 -0400", hash_original_method = "A47E632924417AF09C6FD6A35089DC11", hash_generated_method = "6C7401FF4356D724F85FF65FCAB96BE1")
      InterfaceAddress(Inet4Address address, Inet4Address broadcastAddress, Inet4Address mask) {
        this.address = address;
        this.broadcastAddress = broadcastAddress;
        this.prefixLength = countPrefixLength(mask);
        // ---------- Original Method ----------
        //this.address = address;
        //this.broadcastAddress = broadcastAddress;
        //this.prefixLength = countPrefixLength(mask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.727 -0400", hash_original_method = "48C591F4E78B8661DAF333100DFF1834", hash_generated_method = "D149CCD7CE2B4038970F458D9B70116C")
      InterfaceAddress(Inet6Address address, short prefixLength) {
        this.address = address;
        this.broadcastAddress = null;
        this.prefixLength = prefixLength;
        // ---------- Original Method ----------
        //this.address = address;
        //this.broadcastAddress = null;
        //this.prefixLength = prefixLength;
    }

    
    @DSModeled(DSC.SAFE)
    private static short countPrefixLength(Inet4Address mask) {
        short count = 0;
        for (byte b : mask.ipaddress) {
            for (int i = 0; i < 8; ++i) {
                if ((b & (1 << i)) != 0) {
                    ++count;
                }
            }
        }
        return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.729 -0400", hash_original_method = "C2F63B53807D79A96FCD6544A2D6E3D6", hash_generated_method = "AA0B42F70246EA8181C46121635B206F")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_831053112 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927128025 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927128025;
        } //End block
        if(!(obj instanceof InterfaceAddress))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1849035189 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737567897 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737567897;
        } //End block
        InterfaceAddress rhs = (InterfaceAddress) obj;
        boolean var433225E5F3672F8A92E0BC4781C28D2B_1085320877 = (((address == null) ? rhs.address == null : address.equals(rhs.address)) &&
                (rhs.prefixLength == prefixLength) &&
                ((broadcastAddress == null) ? rhs.broadcastAddress == null : broadcastAddress.equals(rhs.broadcastAddress)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206988371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206988371;
        // ---------- Original Method ----------
        //if (obj == this){
            //return true;
        //}
        //if (!(obj instanceof InterfaceAddress)) {
            //return false;
        //}
        //InterfaceAddress rhs = (InterfaceAddress) obj;
        //return ((address == null) ? rhs.address == null : address.equals(rhs.address)) &&
                //(rhs.prefixLength == prefixLength) &&
                //((broadcastAddress == null) ? rhs.broadcastAddress == null : broadcastAddress.equals(rhs.broadcastAddress));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.730 -0400", hash_original_method = "2A9C5EEED856061F72C9734D5432AB47", hash_generated_method = "ADCBD5CD8D152C1A33EF2E40DC2030FC")
    @Override
    public int hashCode() {
        int hashCode = address == null ? 0 : -address.hashCode();
        hashCode += broadcastAddress == null ? 0 : broadcastAddress.hashCode();
        hashCode += prefixLength;
        int var550D1CC054A1B23A411DDDA46FD64811_1719740722 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098469339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098469339;
        // ---------- Original Method ----------
        //int hashCode = address == null ? 0 : -address.hashCode();
        //hashCode += broadcastAddress == null ? 0 : broadcastAddress.hashCode();
        //hashCode += prefixLength;
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.730 -0400", hash_original_method = "1F9308CDA843BEB3E12C5EE04150EA0F", hash_generated_method = "F384F67343B6AC6DAA273255DCFFE17B")
    @Override
    public String toString() {
String varB4AC98B78928509CD00779ABDF2F15A5_1465794166 =         address + "/" + prefixLength + " [" + broadcastAddress + "]";
        varB4AC98B78928509CD00779ABDF2F15A5_1465794166.addTaint(taint);
        return varB4AC98B78928509CD00779ABDF2F15A5_1465794166;
        // ---------- Original Method ----------
        //return address + "/" + prefixLength + " [" + broadcastAddress + "]";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.731 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "038916CAE60CC64637D38B5E4BBB9EC1")
    public InetAddress getAddress() {
InetAddress var814577DDD37BAFB17E08CBEFDB411BAE_32545852 =         address;
        var814577DDD37BAFB17E08CBEFDB411BAE_32545852.addTaint(taint);
        return var814577DDD37BAFB17E08CBEFDB411BAE_32545852;
        // ---------- Original Method ----------
        //return address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.731 -0400", hash_original_method = "CFDC66E7DE04051E5606E381D802784E", hash_generated_method = "27B81933DDF4E840B20A13E4CF12B21E")
    public InetAddress getBroadcast() {
InetAddress var2E663694B670997E584545D6213E4BAD_429191835 =         broadcastAddress;
        var2E663694B670997E584545D6213E4BAD_429191835.addTaint(taint);
        return var2E663694B670997E584545D6213E4BAD_429191835;
        // ---------- Original Method ----------
        //return broadcastAddress;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.731 -0400", hash_original_method = "D89613E4F9F0153F2E4A2BF9077CFCE5", hash_generated_method = "3C5CB2B8C6672207DEBDF33AFCF35779")
    public short getNetworkPrefixLength() {
        short var66E8BBB112C8BE88E6A5CE871B315D9D_501980525 = (prefixLength);
                short var4F09DAA9D95BCB166A302407A0E0BABE_426232510 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_426232510;
        // ---------- Original Method ----------
        //return prefixLength;
    }

    
}

