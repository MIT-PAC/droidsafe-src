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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.680 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")

    protected String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.680 -0400", hash_original_field = "F1425DA40A9F2D21AB702A1C7FEAE026", hash_generated_field = "EDC0F11B2D64C18E21D8E887AA05CC69")

    protected int major;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.680 -0400", hash_original_field = "AB846C0E3717A3E7D14AF45CAB70B44A", hash_generated_field = "8AE4F35AB0D6332ACFC096368CCFD796")

    protected int minor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.681 -0400", hash_original_method = "487CD3731F38F990825B550D79A7F010", hash_generated_method = "2B0F84AAA60FD0767295B2E0F2F87E39")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.693 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "5953095D4C62328F86B793BBEA0C4DA0")
    public final String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_771199829 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_771199829 = protocol;
        varB4EAC82CA7396A68D541C85D26508E83_771199829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_771199829;
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.693 -0400", hash_original_method = "6CE35F73F8CF79D6A880BDE227F0BCAD", hash_generated_method = "E9B05A65F0390631AD041AADA02D6366")
    public final int getMajor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384764283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384764283;
        // ---------- Original Method ----------
        //return major;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.696 -0400", hash_original_method = "413E8CB9D527E60B72E0CF611B418433", hash_generated_method = "F8429E3C54840F49B44BBA13D42ACF2B")
    public final int getMinor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042803190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042803190;
        // ---------- Original Method ----------
        //return minor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.697 -0400", hash_original_method = "B388FCA8F9FE298631CFCA77574E3195", hash_generated_method = "B27D176338CF384EFFB23EFD4F1059C3")
    public ProtocolVersion forVersion(int major, int minor) {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_439017711 = null; //Variable for return #1
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1158914474 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_439017711 = this;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1158914474 = new ProtocolVersion(this.protocol, major, minor);
        addTaint(major);
        addTaint(minor);
        ProtocolVersion varA7E53CE21691AB073D9660D615818899_317268235; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_317268235 = varB4EAC82CA7396A68D541C85D26508E83_439017711;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_317268235 = varB4EAC82CA7396A68D541C85D26508E83_1158914474;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_317268235.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_317268235;
        // ---------- Original Method ----------
        //if ((major == this.major) && (minor == this.minor)) {
            //return this;
        //}
        //return new ProtocolVersion(this.protocol, major, minor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.697 -0400", hash_original_method = "A7F4A91DFB541B4D61B848B18DDC1A50", hash_generated_method = "7F8A61C8258148697AE585C804200AF5")
    public final int hashCode() {
        int var7960C382AF6881ABBE4F27C3A0F9F4F6_1335111176 = (this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261077968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261077968;
        // ---------- Original Method ----------
        //return this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.723 -0400", hash_original_method = "316EA3FE02F120244DD49AEBA8B051C7", hash_generated_method = "53643685BA57A86C8D870FE025C83FBE")
    public final boolean equals(Object obj) {
        ProtocolVersion that;
        that = (ProtocolVersion) obj;
        boolean varA99FB561E36904DD97AE6936D3CCFDB6_562334957 = (((this.protocol.equals(that.protocol)) &&
                (this.major == that.major) &&
                (this.minor == that.minor)));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1345402260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1345402260;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.723 -0400", hash_original_method = "D2B2F5148427A04314DDBDF38EFDB134", hash_generated_method = "E0E727BD12707FB1ACF57FF341B5142F")
    public boolean isComparable(ProtocolVersion that) {
        boolean var14E8D7DEAC434FF70B1BBCDD1014727A_429084372 = ((that != null) && this.protocol.equals(that.protocol));
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1489950300 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1489950300;
        // ---------- Original Method ----------
        //return (that != null) && this.protocol.equals(that.protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.724 -0400", hash_original_method = "3ABC84C7DCB5005CDC448A9D130CFC4F", hash_generated_method = "23CEA6A362910C8C660EABD3074053B1")
    public int compareToVersion(ProtocolVersion that) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol version must not be null.");
        } //End block
        {
            boolean var53AD0993A9E2AF175B8A2D2E160FC405_443723631 = (!this.protocol.equals(that.protocol));
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239866881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_239866881;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.724 -0400", hash_original_method = "7494058829006BF7A7CEB593562FC10D", hash_generated_method = "30FEA95281AA43B93FFB287E1C3F7358")
    public final boolean greaterEquals(ProtocolVersion version) {
        boolean var6466652691AAF8E2162CE91100AA7703_2134179257 = (isComparable(version) && (compareToVersion(version) >= 0));
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051293640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051293640;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) >= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.725 -0400", hash_original_method = "251CBAD879CC81CB8B0B43DA249F7406", hash_generated_method = "259BD280CB097A0880915E7A215540DF")
    public final boolean lessEquals(ProtocolVersion version) {
        boolean varB024BA600DC3C9A21BAE4D1AEE43DA56_516841255 = (isComparable(version) && (compareToVersion(version) <= 0));
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830659696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_830659696;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) <= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.727 -0400", hash_original_method = "1AC3EEF7BC77C90C94CB72A8DD95F4D1", hash_generated_method = "65F0EFBAA4713E965E11D4C95A4012E7")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1295175719 = null; //Variable for return #1
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(16);
        buffer.append(this.protocol);
        buffer.append('/');
        buffer.append(Integer.toString(this.major));
        buffer.append('.');
        buffer.append(Integer.toString(this.minor));
        varB4EAC82CA7396A68D541C85D26508E83_1295175719 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1295175719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1295175719;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(16);
        //buffer.append(this.protocol);
        //buffer.append('/');
        //buffer.append(Integer.toString(this.major));
        //buffer.append('.');
        //buffer.append(Integer.toString(this.minor));
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.727 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "059EE11F3936B570A1A868BF23300E81")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_362530725 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_362530725 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_362530725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_362530725;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.727 -0400", hash_original_field = "7C2995A0D26187A1D1CE429F2724E2FB", hash_generated_field = "6158A8DB41FA82F5B7050D7BF3CD5713")

    private static long serialVersionUID = 8950662842175091068L;
}

