package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class InterfaceAddress {
    private final InetAddress address;
    private final InetAddress broadcastAddress;
    private final short prefixLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:42:03.315 -0400", hash_original_method = "A47E632924417AF09C6FD6A35089DC11", hash_generated_method = "AECBE17E18AD2DFB9169D9A0BC9B9A00")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:42:03.320 -0400", hash_original_method = "48C591F4E78B8661DAF333100DFF1834", hash_generated_method = "42494D2C87C619CD48BB4749542A6067")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:42:03.322 -0400", hash_original_method = "5E42B457EFC972934681320D52288B28", hash_generated_method = "CC498109EDA786AF03805FD940E7B974")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:42:03.336 -0400", hash_original_method = "C2F63B53807D79A96FCD6544A2D6E3D6", hash_generated_method = "70F0E521C0F1C20AB44AB4009277DD61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        InterfaceAddress rhs;
        rhs = (InterfaceAddress) obj;
        boolean varCD50253B938630268FE23FE3AAE7B570_2085933770 = (((address == null) ? rhs.address == null : address.equals(rhs.address)) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:42:03.356 -0400", hash_original_method = "2A9C5EEED856061F72C9734D5432AB47", hash_generated_method = "186274121F82D4BCE432E1C432E02E7A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:42:03.364 -0400", hash_original_method = "1F9308CDA843BEB3E12C5EE04150EA0F", hash_generated_method = "779DB86A8C6ECC2CF12286BD8C7929D0")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return address + "/" + prefixLength + " [" + broadcastAddress + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:42:03.366 -0400", hash_original_method = "F0319BA9B19AC93124B00C2891893A52", hash_generated_method = "F969AA9DC137AA0CC2CBDFD0B5D5DCB7")
    @DSModeled(DSC.SAFE)
    public InetAddress getAddress() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:42:03.368 -0400", hash_original_method = "CFDC66E7DE04051E5606E381D802784E", hash_generated_method = "34D5BFFEA4B955B23AF197B720D7D315")
    @DSModeled(DSC.SAFE)
    public InetAddress getBroadcast() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return broadcastAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:42:03.370 -0400", hash_original_method = "D89613E4F9F0153F2E4A2BF9077CFCE5", hash_generated_method = "4DF21898E7535EBCFD09B20C8B7F7448")
    @DSModeled(DSC.SAFE)
    public short getNetworkPrefixLength() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return prefixLength;
    }

    
}


