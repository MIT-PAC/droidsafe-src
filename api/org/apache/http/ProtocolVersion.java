package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;

import org.apache.http.util.CharArrayBuffer;






public class ProtocolVersion implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.208 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")

    protected String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.208 -0400", hash_original_field = "F1425DA40A9F2D21AB702A1C7FEAE026", hash_generated_field = "EDC0F11B2D64C18E21D8E887AA05CC69")

    protected int major;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.209 -0400", hash_original_field = "AB846C0E3717A3E7D14AF45CAB70B44A", hash_generated_field = "8AE4F35AB0D6332ACFC096368CCFD796")

    protected int minor;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.211 -0400", hash_original_method = "487CD3731F38F990825B550D79A7F010", hash_generated_method = "F6BF09776FBA402BEDE198CFEC853CB6")
    public  ProtocolVersion(String protocol, int major, int minor) {
        if(protocol == null)        
        {
            IllegalArgumentException var89E03E0C3AA6B5FF759E230A76A67CE2_1423639030 = new IllegalArgumentException
                ("Protocol name must not be null.");
            var89E03E0C3AA6B5FF759E230A76A67CE2_1423639030.addTaint(taint);
            throw var89E03E0C3AA6B5FF759E230A76A67CE2_1423639030;
        } //End block
        if(major < 0)        
        {
            IllegalArgumentException var0DB524F997D14F270E2B4389BE6B1606_1865388741 = new IllegalArgumentException
                ("Protocol major version number must not be negative.");
            var0DB524F997D14F270E2B4389BE6B1606_1865388741.addTaint(taint);
            throw var0DB524F997D14F270E2B4389BE6B1606_1865388741;
        } //End block
        if(minor < 0)        
        {
            IllegalArgumentException var772F431E821A2063ECC79E95083DF8B5_787258226 = new IllegalArgumentException
                ("Protocol minor version number may not be negative");
            var772F431E821A2063ECC79E95083DF8B5_787258226.addTaint(taint);
            throw var772F431E821A2063ECC79E95083DF8B5_787258226;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.211 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "29E1DD86E71A41C4F0D85A9F413F44D5")
    public final String getProtocol() {
String varDD56EE388A0FA5696BF9686AC14D2DB9_569888432 =         protocol;
        varDD56EE388A0FA5696BF9686AC14D2DB9_569888432.addTaint(taint);
        return varDD56EE388A0FA5696BF9686AC14D2DB9_569888432;
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.212 -0400", hash_original_method = "6CE35F73F8CF79D6A880BDE227F0BCAD", hash_generated_method = "648C1B4B0DE24179D9FBB1D6D1D6C983")
    public final int getMajor() {
        int varF1425DA40A9F2D21AB702A1C7FEAE026_22310044 = (major);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360501133 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360501133;
        // ---------- Original Method ----------
        //return major;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.212 -0400", hash_original_method = "413E8CB9D527E60B72E0CF611B418433", hash_generated_method = "940B1B9C02317CD2F4BAD8A2C5643A2B")
    public final int getMinor() {
        int varAB846C0E3717A3E7D14AF45CAB70B44A_652284564 = (minor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703428985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703428985;
        // ---------- Original Method ----------
        //return minor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.213 -0400", hash_original_method = "B388FCA8F9FE298631CFCA77574E3195", hash_generated_method = "0579DC2780A6B8110286567320C87D4C")
    public ProtocolVersion forVersion(int major, int minor) {
        addTaint(minor);
        addTaint(major);
        if((major == this.major) && (minor == this.minor))        
        {
ProtocolVersion var72A74007B2BE62B849F475C7BDA4658B_1394418025 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1394418025.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1394418025;
        } //End block
ProtocolVersion varD2924DB4DA2F5F9ABE6F7D208A34A0F0_1426086785 =         new ProtocolVersion(this.protocol, major, minor);
        varD2924DB4DA2F5F9ABE6F7D208A34A0F0_1426086785.addTaint(taint);
        return varD2924DB4DA2F5F9ABE6F7D208A34A0F0_1426086785;
        // ---------- Original Method ----------
        //if ((major == this.major) && (minor == this.minor)) {
            //return this;
        //}
        //return new ProtocolVersion(this.protocol, major, minor);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.214 -0400", hash_original_method = "A7F4A91DFB541B4D61B848B18DDC1A50", hash_generated_method = "916F208B023C5AC5102A3F1ABF0B063E")
    public final int hashCode() {
        int varD183A6D7752C69C399F68A158B5DFDD4_1104332375 = (this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035975582 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035975582;
        // ---------- Original Method ----------
        //return this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.214 -0400", hash_original_method = "316EA3FE02F120244DD49AEBA8B051C7", hash_generated_method = "06814D925C2DD8881F71E6486F6763B9")
    public final boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_2102799032 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591699262 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_591699262;
        } //End block
        if(!(obj instanceof ProtocolVersion))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2009329301 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_886279770 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_886279770;
        } //End block
        ProtocolVersion that = (ProtocolVersion) obj;
        boolean var951746293E8EAE5EA594637D66F71308_1805366868 = (((this.protocol.equals(that.protocol)) &&
                (this.major == that.major) &&
                (this.minor == that.minor)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829506749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829506749;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.215 -0400", hash_original_method = "D2B2F5148427A04314DDBDF38EFDB134", hash_generated_method = "0D59E7F427868203CD220FDDD52673FC")
    public boolean isComparable(ProtocolVersion that) {
        addTaint(that.getTaint());
        boolean var68437857B2D69CBBD43E93F3FE545E7F_400593009 = ((that != null) && this.protocol.equals(that.protocol));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_411610731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_411610731;
        // ---------- Original Method ----------
        //return (that != null) && this.protocol.equals(that.protocol);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.215 -0400", hash_original_method = "3ABC84C7DCB5005CDC448A9D130CFC4F", hash_generated_method = "26717D5AB2340A41BD8F35AAF3C7D8D7")
    public int compareToVersion(ProtocolVersion that) {
        addTaint(that.getTaint());
        if(that == null)        
        {
            IllegalArgumentException varED1AFF25625857E84D7E852ADCFA2EED_1216806758 = new IllegalArgumentException
                ("Protocol version must not be null.");
            varED1AFF25625857E84D7E852ADCFA2EED_1216806758.addTaint(taint);
            throw varED1AFF25625857E84D7E852ADCFA2EED_1216806758;
        } //End block
        if(!this.protocol.equals(that.protocol))        
        {
            IllegalArgumentException var071CECA53444181C82DDEB2010EF8CED_1070724936 = new IllegalArgumentException
                ("Versions for different protocols cannot be compared. " +
                 this + " " + that);
            var071CECA53444181C82DDEB2010EF8CED_1070724936.addTaint(taint);
            throw var071CECA53444181C82DDEB2010EF8CED_1070724936;
        } //End block
        int delta = getMajor() - that.getMajor();
        if(delta == 0)        
        {
            delta = getMinor() - that.getMinor();
        } //End block
        int var63BCABF86A9A991864777C631C5B7617_2014018370 = (delta);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426337147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426337147;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.216 -0400", hash_original_method = "7494058829006BF7A7CEB593562FC10D", hash_generated_method = "2E2CCF220B7F85C71DEA8C4B83BE5A93")
    public final boolean greaterEquals(ProtocolVersion version) {
        addTaint(version.getTaint());
        boolean var23277FDBC4CF36663C280085EC8D17D0_2033612208 = (isComparable(version) && (compareToVersion(version) >= 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592775199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_592775199;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) >= 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.216 -0400", hash_original_method = "251CBAD879CC81CB8B0B43DA249F7406", hash_generated_method = "958366AB91502D66C5F9347508410CD9")
    public final boolean lessEquals(ProtocolVersion version) {
        addTaint(version.getTaint());
        boolean var61752013E44BB28B8057AA614DEDE534_1390981108 = (isComparable(version) && (compareToVersion(version) <= 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_219112780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_219112780;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) <= 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.216 -0400", hash_original_method = "1AC3EEF7BC77C90C94CB72A8DD95F4D1", hash_generated_method = "440288EFFB29E404298682A9CFA7DD14")
    public String toString() {
        CharArrayBuffer buffer = new CharArrayBuffer(16);
        buffer.append(this.protocol);
        buffer.append('/');
        buffer.append(Integer.toString(this.major));
        buffer.append('.');
        buffer.append(Integer.toString(this.minor));
String varD03843288D33B9E1D3062E25339ECF6D_1484060417 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1484060417.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1484060417;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(16);
        //buffer.append(this.protocol);
        //buffer.append('/');
        //buffer.append(Integer.toString(this.major));
        //buffer.append('.');
        //buffer.append(Integer.toString(this.minor));
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.217 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "578563DF67D67E1786B7AFCA861081F4")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_566177888 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_566177888.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_566177888;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.217 -0400", hash_original_field = "7C2995A0D26187A1D1CE429F2724E2FB", hash_generated_field = "2E5C9D3BADDF86EB2D1874D5612C1631")

    private static final long serialVersionUID = 8950662842175091068L;
}

