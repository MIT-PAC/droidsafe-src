package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import org.apache.http.util.CharArrayBuffer;

public class ProtocolVersion implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.633 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")

    protected String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.633 -0400", hash_original_field = "F1425DA40A9F2D21AB702A1C7FEAE026", hash_generated_field = "EDC0F11B2D64C18E21D8E887AA05CC69")

    protected int major;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.633 -0400", hash_original_field = "AB846C0E3717A3E7D14AF45CAB70B44A", hash_generated_field = "8AE4F35AB0D6332ACFC096368CCFD796")

    protected int minor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.634 -0400", hash_original_method = "487CD3731F38F990825B550D79A7F010", hash_generated_method = "2B0F84AAA60FD0767295B2E0F2F87E39")
    public  ProtocolVersion(String protocol, int major, int minor) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol name must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol major version number must not be negative.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol minor version number may not be negative");
        } //End block
        this.protocol = protocol;
        this.major = major;
        this.minor = minor;
        // ---------- Original Method ----------
        //if (protocol == null) {
            //throw new IllegalArgumentException
                //("Protocol name must not be null.");
        //}
        //if (major < 0) {
            //throw new IllegalArgumentException
                //("Protocol major version number must not be negative.");
        //}
        //if (minor < 0) {
            //throw new IllegalArgumentException
                //("Protocol minor version number may not be negative");
        //}
        //this.protocol = protocol;
        //this.major = major;
        //this.minor = minor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.635 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "0142D455B42E205829D2E09686C18FFB")
    public final String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_474879850 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_474879850 = protocol;
        varB4EAC82CA7396A68D541C85D26508E83_474879850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_474879850;
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.635 -0400", hash_original_method = "6CE35F73F8CF79D6A880BDE227F0BCAD", hash_generated_method = "C92513B5C1078F6A77762B33700F9366")
    public final int getMajor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1467617208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1467617208;
        // ---------- Original Method ----------
        //return major;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.635 -0400", hash_original_method = "413E8CB9D527E60B72E0CF611B418433", hash_generated_method = "D681D717B34779D662C4D1F9CAAB29AB")
    public final int getMinor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136861900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136861900;
        // ---------- Original Method ----------
        //return minor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.639 -0400", hash_original_method = "B388FCA8F9FE298631CFCA77574E3195", hash_generated_method = "ED6750A6D89FE4DD9F0C0A563F3FA79D")
    public ProtocolVersion forVersion(int major, int minor) {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_564199026 = null; //Variable for return #1
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1438357859 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_564199026 = this;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1438357859 = new ProtocolVersion(this.protocol, major, minor);
        addTaint(major);
        addTaint(minor);
        ProtocolVersion varA7E53CE21691AB073D9660D615818899_1102633651; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1102633651 = varB4EAC82CA7396A68D541C85D26508E83_564199026;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1102633651 = varB4EAC82CA7396A68D541C85D26508E83_1438357859;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1102633651.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1102633651;
        // ---------- Original Method ----------
        //if ((major == this.major) && (minor == this.minor)) {
            //return this;
        //}
        //return new ProtocolVersion(this.protocol, major, minor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.640 -0400", hash_original_method = "A7F4A91DFB541B4D61B848B18DDC1A50", hash_generated_method = "AEFF863232DE48923177DCD0E70369B5")
    public final int hashCode() {
        int var7960C382AF6881ABBE4F27C3A0F9F4F6_2059517629 = (this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159199478 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159199478;
        // ---------- Original Method ----------
        //return this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.640 -0400", hash_original_method = "316EA3FE02F120244DD49AEBA8B051C7", hash_generated_method = "2D48AF09A36A6FD0365D00A5EEA33B41")
    public final boolean equals(Object obj) {
        ProtocolVersion that;
        that = (ProtocolVersion) obj;
        boolean varA99FB561E36904DD97AE6936D3CCFDB6_1668692927 = (((this.protocol.equals(that.protocol)) &&
                (this.major == that.major) &&
                (this.minor == that.minor)));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933953322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_933953322;
        // ---------- Original Method ----------
        //if (this == obj) {
            //return true;
        //}
        //if (!(obj instanceof ProtocolVersion)) {
            //return false;
        //}
        //ProtocolVersion that = (ProtocolVersion) obj;
        //return ((this.protocol.equals(that.protocol)) &&
                //(this.major == that.major) &&
                //(this.minor == that.minor));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.641 -0400", hash_original_method = "D2B2F5148427A04314DDBDF38EFDB134", hash_generated_method = "CA5404BB297F90807A9FAE072216008C")
    public boolean isComparable(ProtocolVersion that) {
        boolean var14E8D7DEAC434FF70B1BBCDD1014727A_1605789259 = ((that != null) && this.protocol.equals(that.protocol));
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983830768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983830768;
        // ---------- Original Method ----------
        //return (that != null) && this.protocol.equals(that.protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.641 -0400", hash_original_method = "3ABC84C7DCB5005CDC448A9D130CFC4F", hash_generated_method = "A6770472A220ABFEE5E09C07EDE64FE4")
    public int compareToVersion(ProtocolVersion that) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol version must not be null.");
        } //End block
        {
            boolean var53AD0993A9E2AF175B8A2D2E160FC405_325182322 = (!this.protocol.equals(that.protocol));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Versions for different protocols cannot be compared. " +
                 this + " " + that);
            } //End block
        } //End collapsed parenthetic
        int delta;
        delta = getMajor() - that.getMajor();
        {
            delta = getMinor() - that.getMinor();
        } //End block
        addTaint(that.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272705598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272705598;
        // ---------- Original Method ----------
        //if (that == null) {
            //throw new IllegalArgumentException
                //("Protocol version must not be null."); 
        //}
        //if (!this.protocol.equals(that.protocol)) {
            //throw new IllegalArgumentException
                //("Versions for different protocols cannot be compared. " +
                 //this + " " + that);
        //}
        //int delta = getMajor() - that.getMajor();
        //if (delta == 0) {
            //delta = getMinor() - that.getMinor();
        //}
        //return delta;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.652 -0400", hash_original_method = "7494058829006BF7A7CEB593562FC10D", hash_generated_method = "8F6EA7B636DC1204BE464D57AAFFAEC6")
    public final boolean greaterEquals(ProtocolVersion version) {
        boolean var6466652691AAF8E2162CE91100AA7703_1043896929 = (isComparable(version) && (compareToVersion(version) >= 0));
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130666251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130666251;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) >= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.652 -0400", hash_original_method = "251CBAD879CC81CB8B0B43DA249F7406", hash_generated_method = "4CD39B2EEC84D3431AB990B7928C1683")
    public final boolean lessEquals(ProtocolVersion version) {
        boolean varB024BA600DC3C9A21BAE4D1AEE43DA56_1046884223 = (isComparable(version) && (compareToVersion(version) <= 0));
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971992133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971992133;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) <= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.653 -0400", hash_original_method = "1AC3EEF7BC77C90C94CB72A8DD95F4D1", hash_generated_method = "F822295B57147AD4A3DECBFA16ED9DBF")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_739406080 = null; //Variable for return #1
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(16);
        buffer.append(this.protocol);
        buffer.append('/');
        buffer.append(Integer.toString(this.major));
        buffer.append('.');
        buffer.append(Integer.toString(this.minor));
        varB4EAC82CA7396A68D541C85D26508E83_739406080 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_739406080.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_739406080;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(16);
        //buffer.append(this.protocol);
        //buffer.append('/');
        //buffer.append(Integer.toString(this.major));
        //buffer.append('.');
        //buffer.append(Integer.toString(this.minor));
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.654 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "41143DC5D89892B4DF4D009DDE10F40B")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2147166682 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2147166682 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2147166682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2147166682;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.654 -0400", hash_original_field = "7C2995A0D26187A1D1CE429F2724E2FB", hash_generated_field = "6158A8DB41FA82F5B7050D7BF3CD5713")

    private static long serialVersionUID = 8950662842175091068L;
}

