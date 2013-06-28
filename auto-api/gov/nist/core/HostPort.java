package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.*;

public final class HostPort extends GenericObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.542 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "3F747A9CA45D9CE9ECDEEB5F7454A2D3")

    protected Host host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.542 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.542 -0400", hash_original_method = "53C1CBAC5F64E6F014615AADE272B0C0", hash_generated_method = "A8DA055BA683C65FA6DCC1F530F578DA")
    public  HostPort() {
        host = null;
        port = -1;
        // ---------- Original Method ----------
        //host = null;
        //port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.543 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "0402C62C4F4B197F91AE7929E364CAFA")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_2104381785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2104381785 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_2104381785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2104381785;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.543 -0400", hash_original_method = "9895EDF602B81195878A0876FA0B4C29", hash_generated_method = "C0CECE724BA06F2AB39171CD9D32B40E")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1450654773 = null; //Variable for return #1
        host.encode(buffer);
        buffer.append(COLON).append(port);
        varB4EAC82CA7396A68D541C85D26508E83_1450654773 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1450654773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1450654773;
        // ---------- Original Method ----------
        //host.encode(buffer);
        //if (port != -1)
            //buffer.append(COLON).append(port);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.544 -0400", hash_original_method = "86C54BFDD185E9407C74F8F297BEF1D3", hash_generated_method = "B2D2EB967887AA6C519EE0D0FFAC5EDA")
    public boolean equals(Object other) {
        {
            boolean var877A20298FB5E9D29EBE53EB7125AC7B_890738605 = (getClass () != other.getClass ());
        } //End collapsed parenthetic
        HostPort that = (HostPort) other;
        boolean varAD6C8C9FD0C6E51369F7190B1BF287BD_973286024 = (port == that.port && host.equals(that.host));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_341083610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_341083610;
        // ---------- Original Method ----------
        //if (other == null) return false;
        //if (getClass () != other.getClass ()) {
            //return false;
        //}
        //HostPort that = (HostPort) other;
        //return port == that.port && host.equals(that.host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.544 -0400", hash_original_method = "46CD61CB12D2C2108CCC2BF62B36641B", hash_generated_method = "A2A100D50C4C3C2AEC985F6986E49F2B")
    public Host getHost() {
        Host varB4EAC82CA7396A68D541C85D26508E83_1981536243 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1981536243 = host;
        varB4EAC82CA7396A68D541C85D26508E83_1981536243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1981536243;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.544 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "310C04C45CB2973BB2611AE9093D55DE")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937626789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937626789;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.544 -0400", hash_original_method = "B050407BAA043C3F798F83BEFE766D07", hash_generated_method = "DFF3CA5EB67CCBA887566D8D96E1DE0A")
    public boolean hasPort() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020254390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020254390;
        // ---------- Original Method ----------
        //return port != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.545 -0400", hash_original_method = "7FD66A68FF224A3837669EDD9AB43DAE", hash_generated_method = "A49641C3828C7BB69086DC31891642EB")
    public void removePort() {
        port = -1;
        // ---------- Original Method ----------
        //port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.545 -0400", hash_original_method = "7261FADCCAAD2D84DAF8700A574E33AD", hash_generated_method = "249F4BE40025E097F2B0AD1D7907074A")
    public void setHost(Host h) {
        host = h;
        // ---------- Original Method ----------
        //host = h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.545 -0400", hash_original_method = "77F84B839458179E7DBAF505404F4852", hash_generated_method = "5F6FC0322C192F3D12450D7AA899E4D1")
    public void setPort(int p) {
        port = p;
        // ---------- Original Method ----------
        //port = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.546 -0400", hash_original_method = "1454562F409CD451F70F3E17F975E5B5", hash_generated_method = "C0B6ACD07A34F0ABD0DE72A31F92E35E")
    public InetAddress getInetAddress() throws java.net.UnknownHostException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1897938072 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_221484596 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1897938072 = null;
        varB4EAC82CA7396A68D541C85D26508E83_221484596 = host.getInetAddress();
        InetAddress varA7E53CE21691AB073D9660D615818899_668002359; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_668002359 = varB4EAC82CA7396A68D541C85D26508E83_1897938072;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_668002359 = varB4EAC82CA7396A68D541C85D26508E83_221484596;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_668002359.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_668002359;
        // ---------- Original Method ----------
        //if (host == null)
            //return null;
        //else
            //return host.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.547 -0400", hash_original_method = "02B5610089173D5B9ACA58E6AEBD3C51", hash_generated_method = "67F08BBEB2D69FCC9160A91AA6EE373F")
    public void merge(Object mergeObject) {
        super.merge (mergeObject);
        port = ((HostPort) mergeObject).port;
        // ---------- Original Method ----------
        //super.merge (mergeObject);
        //if (port == -1)
            //port = ((HostPort) mergeObject).port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.547 -0400", hash_original_method = "723102D689B5DB9C81F9B317715D80D3", hash_generated_method = "9935070D91D79F4BF81E387032E82B78")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_431266384 = null; //Variable for return #1
        HostPort retval = (HostPort) super.clone();
        retval.host = (Host) this.host.clone();
        varB4EAC82CA7396A68D541C85D26508E83_431266384 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_431266384.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_431266384;
        // ---------- Original Method ----------
        //HostPort retval = (HostPort) super.clone();
        //if (this.host != null)
            //retval.host = (Host) this.host.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.548 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "07BBE31817E8A5F177F3CA3A7C700F3D")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_925637996 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_925637996 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_925637996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_925637996;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.548 -0400", hash_original_method = "576865B2F50CE751C00A8F417860D16A", hash_generated_method = "1AFAF38EDDB61028A70593D7A0DEB3A5")
    @Override
    public int hashCode() {
        int var14E0AE1CC7FA6DD48510DA0394F19DF9_212438687 = (this.host.hashCode() + this.port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1151206770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1151206770;
        // ---------- Original Method ----------
        //return this.host.hashCode() + this.port;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.548 -0400", hash_original_field = "781BF342E6E71829A1551C1951B9151A", hash_generated_field = "7CD9CF316407E65EA07641A462BD6002")

    private static final long serialVersionUID = -7103412227431884523L;
}

