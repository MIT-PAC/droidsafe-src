package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InterfaceAddress {
    private InetAddress address;
    private InetAddress broadcastAddress;
    private short prefixLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.919 -0400", hash_original_method = "A47E632924417AF09C6FD6A35089DC11", hash_generated_method = "ADDCE9CBBFE509605456EA3A43ACB864")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InterfaceAddress(Inet4Address address, Inet4Address broadcastAddress, Inet4Address mask) {
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(mask.dsTaint);
        dsTaint.addTaint(broadcastAddress.dsTaint);
        this.prefixLength = countPrefixLength(mask);
        // ---------- Original Method ----------
        //this.address = address;
        //this.broadcastAddress = broadcastAddress;
        //this.prefixLength = countPrefixLength(mask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.920 -0400", hash_original_method = "48C591F4E78B8661DAF333100DFF1834", hash_generated_method = "589E9BB6E578F2ACC735C7CC52EAB25C")
    @DSModeled(DSC.SAFE)
     InterfaceAddress(Inet6Address address, short prefixLength) {
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(prefixLength);
        this.broadcastAddress = null;
        // ---------- Original Method ----------
        //this.address = address;
        //this.broadcastAddress = null;
        //this.prefixLength = prefixLength;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.923 -0400", hash_original_method = "C2F63B53807D79A96FCD6544A2D6E3D6", hash_generated_method = "49C6EB17E6E6C4555BFB145BF2528906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_519727842 = (obj == this);
        } //End collapsed parenthetic
        InterfaceAddress rhs;
        rhs = (InterfaceAddress) obj;
        boolean varCD50253B938630268FE23FE3AAE7B570_2012956155 = (((address == null) ? rhs.address == null : address.equals(rhs.address)) &&
                (rhs.prefixLength == prefixLength) &&
                ((broadcastAddress == null) ? rhs.broadcastAddress == null : broadcastAddress.equals(rhs.broadcastAddress))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.924 -0400", hash_original_method = "2A9C5EEED856061F72C9734D5432AB47", hash_generated_method = "661922B2BBC500507042592471A20BB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int hashCode;
        hashCode = 0;
        hashCode = -address.hashCode();
        hashCode += broadcastAddress == null ? 0 : broadcastAddress.hashCode();
        hashCode += prefixLength;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int hashCode = address == null ? 0 : -address.hashCode();
        //hashCode += broadcastAddress == null ? 0 : broadcastAddress.hashCode();
        //hashCode += prefixLength;
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.924 -0400", hash_original_method = "1F9308CDA843BEB3E12C5EE04150EA0F", hash_generated_method = "03300CA289DEEFB4C8D6CB45B2A21C7E")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return address + "/" + prefixLength + " [" + broadcastAddress + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.924 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "FC5E46BCF945F23313A97C581817054D")
    @DSModeled(DSC.SAFE)
    public InetAddress getAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.924 -0400", hash_original_method = "CFDC66E7DE04051E5606E381D802784E", hash_generated_method = "2DA262A47C0238263378EBB7F9DF2198")
    @DSModeled(DSC.SAFE)
    public InetAddress getBroadcast() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return broadcastAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.924 -0400", hash_original_method = "D89613E4F9F0153F2E4A2BF9077CFCE5", hash_generated_method = "9867EF324C63BA7DDA95989AA5A8545E")
    @DSModeled(DSC.SAFE)
    public short getNetworkPrefixLength() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return prefixLength;
    }

    
}

