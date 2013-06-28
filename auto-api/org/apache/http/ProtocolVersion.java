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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.519 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")

    protected String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.519 -0400", hash_original_field = "F1425DA40A9F2D21AB702A1C7FEAE026", hash_generated_field = "EDC0F11B2D64C18E21D8E887AA05CC69")

    protected int major;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.519 -0400", hash_original_field = "AB846C0E3717A3E7D14AF45CAB70B44A", hash_generated_field = "8AE4F35AB0D6332ACFC096368CCFD796")

    protected int minor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.520 -0400", hash_original_method = "487CD3731F38F990825B550D79A7F010", hash_generated_method = "2B0F84AAA60FD0767295B2E0F2F87E39")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.520 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "31DDCD6D4D1F4A745ED82920A222630A")
    public final String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1063921996 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1063921996 = protocol;
        varB4EAC82CA7396A68D541C85D26508E83_1063921996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1063921996;
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.521 -0400", hash_original_method = "6CE35F73F8CF79D6A880BDE227F0BCAD", hash_generated_method = "03CE071031EE5FA445CE9BAC3DD39A51")
    public final int getMajor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070757134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070757134;
        // ---------- Original Method ----------
        //return major;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.521 -0400", hash_original_method = "413E8CB9D527E60B72E0CF611B418433", hash_generated_method = "39F91FE0EC9C0903E6B9E30CD171D96D")
    public final int getMinor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108953390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108953390;
        // ---------- Original Method ----------
        //return minor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.522 -0400", hash_original_method = "B388FCA8F9FE298631CFCA77574E3195", hash_generated_method = "558A8A823E204B3AF51D43005ED6124E")
    public ProtocolVersion forVersion(int major, int minor) {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_614068264 = null; //Variable for return #1
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1199911455 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_614068264 = this;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1199911455 = new ProtocolVersion(this.protocol, major, minor);
        addTaint(major);
        addTaint(minor);
        ProtocolVersion varA7E53CE21691AB073D9660D615818899_856889944; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_856889944 = varB4EAC82CA7396A68D541C85D26508E83_614068264;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_856889944 = varB4EAC82CA7396A68D541C85D26508E83_1199911455;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_856889944.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_856889944;
        // ---------- Original Method ----------
        //if ((major == this.major) && (minor == this.minor)) {
            //return this;
        //}
        //return new ProtocolVersion(this.protocol, major, minor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.522 -0400", hash_original_method = "A7F4A91DFB541B4D61B848B18DDC1A50", hash_generated_method = "C949ACC43BB640974BF04D9C935C9833")
    public final int hashCode() {
        int var7960C382AF6881ABBE4F27C3A0F9F4F6_2037900145 = (this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1944892444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1944892444;
        // ---------- Original Method ----------
        //return this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.523 -0400", hash_original_method = "316EA3FE02F120244DD49AEBA8B051C7", hash_generated_method = "FB8915EEF5544ABB7C182DE739A8BD6B")
    public final boolean equals(Object obj) {
        ProtocolVersion that = (ProtocolVersion) obj;
        boolean varA99FB561E36904DD97AE6936D3CCFDB6_1067508441 = (((this.protocol.equals(that.protocol)) &&
                (this.major == that.major) &&
                (this.minor == that.minor)));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785007159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785007159;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.523 -0400", hash_original_method = "D2B2F5148427A04314DDBDF38EFDB134", hash_generated_method = "6F603C0E4FEC94A18E8450356D9A5E54")
    public boolean isComparable(ProtocolVersion that) {
        boolean var14E8D7DEAC434FF70B1BBCDD1014727A_1110993337 = ((that != null) && this.protocol.equals(that.protocol));
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_233079239 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_233079239;
        // ---------- Original Method ----------
        //return (that != null) && this.protocol.equals(that.protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.524 -0400", hash_original_method = "3ABC84C7DCB5005CDC448A9D130CFC4F", hash_generated_method = "E16F905F0A4847632AF390423A860056")
    public int compareToVersion(ProtocolVersion that) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol version must not be null.");
        } //End block
        {
            boolean var53AD0993A9E2AF175B8A2D2E160FC405_1117112401 = (!this.protocol.equals(that.protocol));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Versions for different protocols cannot be compared. " +
                 this + " " + that);
            } //End block
        } //End collapsed parenthetic
        int delta = getMajor() - that.getMajor();
        {
            delta = getMinor() - that.getMinor();
        } //End block
        addTaint(that.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007716484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007716484;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.524 -0400", hash_original_method = "7494058829006BF7A7CEB593562FC10D", hash_generated_method = "DEAC86A1E40E7F14F16C2CC6C73BFCCE")
    public final boolean greaterEquals(ProtocolVersion version) {
        boolean var6466652691AAF8E2162CE91100AA7703_1256551763 = (isComparable(version) && (compareToVersion(version) >= 0));
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647777064 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647777064;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) >= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.525 -0400", hash_original_method = "251CBAD879CC81CB8B0B43DA249F7406", hash_generated_method = "0BEDB2E920717DC7B3133410BFA5E903")
    public final boolean lessEquals(ProtocolVersion version) {
        boolean varB024BA600DC3C9A21BAE4D1AEE43DA56_1791680559 = (isComparable(version) && (compareToVersion(version) <= 0));
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1808490088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1808490088;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) <= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.525 -0400", hash_original_method = "1AC3EEF7BC77C90C94CB72A8DD95F4D1", hash_generated_method = "7C9335296A09AEB396053B02A11F2A66")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_162642820 = null; //Variable for return #1
        CharArrayBuffer buffer = new CharArrayBuffer(16);
        buffer.append(this.protocol);
        buffer.append('/');
        buffer.append(Integer.toString(this.major));
        buffer.append('.');
        buffer.append(Integer.toString(this.minor));
        varB4EAC82CA7396A68D541C85D26508E83_162642820 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_162642820.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_162642820;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(16);
        //buffer.append(this.protocol);
        //buffer.append('/');
        //buffer.append(Integer.toString(this.major));
        //buffer.append('.');
        //buffer.append(Integer.toString(this.minor));
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.526 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "51EF1FE2A819CC6DEAFF48EAAD1C3DD7")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_467884692 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_467884692 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_467884692.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_467884692;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.526 -0400", hash_original_field = "7C2995A0D26187A1D1CE429F2724E2FB", hash_generated_field = "2E5C9D3BADDF86EB2D1874D5612C1631")

    private static final long serialVersionUID = 8950662842175091068L;
}

