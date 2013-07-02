package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class InterfaceAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.362 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "220CE3F94E98B4B531A4938FAFF932C0")

    private InetAddress address;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.362 -0400", hash_original_field = "56E381C3954FC3FF7DB3E92DA33AD137", hash_generated_field = "7567F98825AE2C855E0ED195DA10645B")

    private InetAddress broadcastAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.362 -0400", hash_original_field = "66E8BBB112C8BE88E6A5CE871B315D9D", hash_generated_field = "70DE7742499AEA0A92EA72A6919A370C")

    private short prefixLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.363 -0400", hash_original_method = "A47E632924417AF09C6FD6A35089DC11", hash_generated_method = "6C7401FF4356D724F85FF65FCAB96BE1")
      InterfaceAddress(Inet4Address address, Inet4Address broadcastAddress, Inet4Address mask) {
        this.address = address;
        this.broadcastAddress = broadcastAddress;
        this.prefixLength = countPrefixLength(mask);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.363 -0400", hash_original_method = "48C591F4E78B8661DAF333100DFF1834", hash_generated_method = "D149CCD7CE2B4038970F458D9B70116C")
      InterfaceAddress(Inet6Address address, short prefixLength) {
        this.address = address;
        this.broadcastAddress = null;
        this.prefixLength = prefixLength;
        
        
        
        
    }

    
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.364 -0400", hash_original_method = "C2F63B53807D79A96FCD6544A2D6E3D6", hash_generated_method = "E9B0C33FDD2BA3ACA136704B66F524B2")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_9526316 = (obj == this);
        } 
        InterfaceAddress rhs = (InterfaceAddress) obj;
        boolean varCD50253B938630268FE23FE3AAE7B570_1014973125 = (((address == null) ? rhs.address == null : address.equals(rhs.address)) &&
                (rhs.prefixLength == prefixLength) &&
                ((broadcastAddress == null) ? rhs.broadcastAddress == null : broadcastAddress.equals(rhs.broadcastAddress))); 
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891620704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_891620704;
        
        
            
        
        
            
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.365 -0400", hash_original_method = "2A9C5EEED856061F72C9734D5432AB47", hash_generated_method = "27BE10A6A59A471928B4602CD8242453")
    @Override
    public int hashCode() {
        int hashCode;
        hashCode = 0;
        hashCode = -address.hashCode();
        hashCode += broadcastAddress == null ? 0 : broadcastAddress.hashCode();
        hashCode += prefixLength;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217653113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217653113;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.366 -0400", hash_original_method = "1F9308CDA843BEB3E12C5EE04150EA0F", hash_generated_method = "DC5329D71FB7DA7D8E0C169F6846334C")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1247443296 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1247443296 = address + "/" + prefixLength + " [" + broadcastAddress + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1247443296.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1247443296;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.367 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "96E84BC58DEE1BEB86EA8C45D6BAC6D1")
    public InetAddress getAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1270619002 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1270619002 = address;
        varB4EAC82CA7396A68D541C85D26508E83_1270619002.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1270619002;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.369 -0400", hash_original_method = "CFDC66E7DE04051E5606E381D802784E", hash_generated_method = "F8B550F96E95B050441F593F7E029696")
    public InetAddress getBroadcast() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1263960205 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1263960205 = broadcastAddress;
        varB4EAC82CA7396A68D541C85D26508E83_1263960205.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1263960205;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.370 -0400", hash_original_method = "D89613E4F9F0153F2E4A2BF9077CFCE5", hash_generated_method = "AA5BCBCDC5CAFCE7DC3AA05D4B401E78")
    public short getNetworkPrefixLength() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_74084845 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_74084845;
        
        
    }

    
}

