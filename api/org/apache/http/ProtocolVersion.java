package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import org.apache.http.util.CharArrayBuffer;

public class ProtocolVersion implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.977 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")

    protected String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.977 -0400", hash_original_field = "F1425DA40A9F2D21AB702A1C7FEAE026", hash_generated_field = "EDC0F11B2D64C18E21D8E887AA05CC69")

    protected int major;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.977 -0400", hash_original_field = "AB846C0E3717A3E7D14AF45CAB70B44A", hash_generated_field = "8AE4F35AB0D6332ACFC096368CCFD796")

    protected int minor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.978 -0400", hash_original_method = "487CD3731F38F990825B550D79A7F010", hash_generated_method = "5FB203743A5EC015C5FA0A161F606A27")
    public  ProtocolVersion(String protocol, int major, int minor) {
    if(protocol == null)        
        {
            IllegalArgumentException var89E03E0C3AA6B5FF759E230A76A67CE2_1725773799 = new IllegalArgumentException
                ("Protocol name must not be null.");
            var89E03E0C3AA6B5FF759E230A76A67CE2_1725773799.addTaint(taint);
            throw var89E03E0C3AA6B5FF759E230A76A67CE2_1725773799;
        } //End block
    if(major < 0)        
        {
            IllegalArgumentException var0DB524F997D14F270E2B4389BE6B1606_209469475 = new IllegalArgumentException
                ("Protocol major version number must not be negative.");
            var0DB524F997D14F270E2B4389BE6B1606_209469475.addTaint(taint);
            throw var0DB524F997D14F270E2B4389BE6B1606_209469475;
        } //End block
    if(minor < 0)        
        {
            IllegalArgumentException var772F431E821A2063ECC79E95083DF8B5_57229166 = new IllegalArgumentException
                ("Protocol minor version number may not be negative");
            var772F431E821A2063ECC79E95083DF8B5_57229166.addTaint(taint);
            throw var772F431E821A2063ECC79E95083DF8B5_57229166;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.979 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "8AA75717B0393F372FEFE5B62FE689B1")
    public final String getProtocol() {
String varDD56EE388A0FA5696BF9686AC14D2DB9_833527765 =         protocol;
        varDD56EE388A0FA5696BF9686AC14D2DB9_833527765.addTaint(taint);
        return varDD56EE388A0FA5696BF9686AC14D2DB9_833527765;
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.979 -0400", hash_original_method = "6CE35F73F8CF79D6A880BDE227F0BCAD", hash_generated_method = "A7C706664F69B9E0351E4BE38066FA07")
    public final int getMajor() {
        int varF1425DA40A9F2D21AB702A1C7FEAE026_1201252242 = (major);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472834772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472834772;
        // ---------- Original Method ----------
        //return major;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.979 -0400", hash_original_method = "413E8CB9D527E60B72E0CF611B418433", hash_generated_method = "12E6E40268700A0012E29794428E7A81")
    public final int getMinor() {
        int varAB846C0E3717A3E7D14AF45CAB70B44A_1160905546 = (minor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324382866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324382866;
        // ---------- Original Method ----------
        //return minor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.980 -0400", hash_original_method = "B388FCA8F9FE298631CFCA77574E3195", hash_generated_method = "CCFD2C8D128E8A6ABA83C1492223F185")
    public ProtocolVersion forVersion(int major, int minor) {
        addTaint(minor);
        addTaint(major);
    if((major == this.major) && (minor == this.minor))        
        {
ProtocolVersion var72A74007B2BE62B849F475C7BDA4658B_1834633673 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1834633673.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1834633673;
        } //End block
ProtocolVersion varD2924DB4DA2F5F9ABE6F7D208A34A0F0_749017440 =         new ProtocolVersion(this.protocol, major, minor);
        varD2924DB4DA2F5F9ABE6F7D208A34A0F0_749017440.addTaint(taint);
        return varD2924DB4DA2F5F9ABE6F7D208A34A0F0_749017440;
        // ---------- Original Method ----------
        //if ((major == this.major) && (minor == this.minor)) {
            //return this;
        //}
        //return new ProtocolVersion(this.protocol, major, minor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.980 -0400", hash_original_method = "A7F4A91DFB541B4D61B848B18DDC1A50", hash_generated_method = "3C2DD473580DEC6F65BEE7091E785CEC")
    public final int hashCode() {
        int varD183A6D7752C69C399F68A158B5DFDD4_1526363479 = (this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717963322 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717963322;
        // ---------- Original Method ----------
        //return this.protocol.hashCode() ^ (this.major * 100000) ^ this.minor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.981 -0400", hash_original_method = "316EA3FE02F120244DD49AEBA8B051C7", hash_generated_method = "A37ABA1B209A0B68389EBADAC715E265")
    public final boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1216374771 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394459220 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_394459220;
        } //End block
    if(!(obj instanceof ProtocolVersion))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1499834828 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1562095245 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1562095245;
        } //End block
        ProtocolVersion that = (ProtocolVersion) obj;
        boolean var951746293E8EAE5EA594637D66F71308_1739625583 = (((this.protocol.equals(that.protocol)) &&
                (this.major == that.major) &&
                (this.minor == that.minor)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814347337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814347337;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.981 -0400", hash_original_method = "D2B2F5148427A04314DDBDF38EFDB134", hash_generated_method = "BB05DF136F0C92ACEDA282AE2B51ABAA")
    public boolean isComparable(ProtocolVersion that) {
        addTaint(that.getTaint());
        boolean var68437857B2D69CBBD43E93F3FE545E7F_1773750806 = ((that != null) && this.protocol.equals(that.protocol));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339007602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339007602;
        // ---------- Original Method ----------
        //return (that != null) && this.protocol.equals(that.protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.983 -0400", hash_original_method = "3ABC84C7DCB5005CDC448A9D130CFC4F", hash_generated_method = "6105748554D3D3528390C0364DDCA819")
    public int compareToVersion(ProtocolVersion that) {
        addTaint(that.getTaint());
    if(that == null)        
        {
            IllegalArgumentException varED1AFF25625857E84D7E852ADCFA2EED_1020435022 = new IllegalArgumentException
                ("Protocol version must not be null.");
            varED1AFF25625857E84D7E852ADCFA2EED_1020435022.addTaint(taint);
            throw varED1AFF25625857E84D7E852ADCFA2EED_1020435022;
        } //End block
    if(!this.protocol.equals(that.protocol))        
        {
            IllegalArgumentException var071CECA53444181C82DDEB2010EF8CED_711847131 = new IllegalArgumentException
                ("Versions for different protocols cannot be compared. " +
                 this + " " + that);
            var071CECA53444181C82DDEB2010EF8CED_711847131.addTaint(taint);
            throw var071CECA53444181C82DDEB2010EF8CED_711847131;
        } //End block
        int delta = getMajor() - that.getMajor();
    if(delta == 0)        
        {
            delta = getMinor() - that.getMinor();
        } //End block
        int var63BCABF86A9A991864777C631C5B7617_1743122218 = (delta);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987324444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987324444;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.984 -0400", hash_original_method = "7494058829006BF7A7CEB593562FC10D", hash_generated_method = "8197C5EA46E25CD047CEE830B80E5020")
    public final boolean greaterEquals(ProtocolVersion version) {
        addTaint(version.getTaint());
        boolean var23277FDBC4CF36663C280085EC8D17D0_1429449482 = (isComparable(version) && (compareToVersion(version) >= 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036445870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036445870;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) >= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.985 -0400", hash_original_method = "251CBAD879CC81CB8B0B43DA249F7406", hash_generated_method = "7E5F30FA2D43C2651CB0C97F5151001F")
    public final boolean lessEquals(ProtocolVersion version) {
        addTaint(version.getTaint());
        boolean var61752013E44BB28B8057AA614DEDE534_1512766985 = (isComparable(version) && (compareToVersion(version) <= 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680485134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680485134;
        // ---------- Original Method ----------
        //return isComparable(version) && (compareToVersion(version) <= 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.986 -0400", hash_original_method = "1AC3EEF7BC77C90C94CB72A8DD95F4D1", hash_generated_method = "E132B971E743FEC5CE7584E8A6722A84")
    public String toString() {
        CharArrayBuffer buffer = new CharArrayBuffer(16);
        buffer.append(this.protocol);
        buffer.append('/');
        buffer.append(Integer.toString(this.major));
        buffer.append('.');
        buffer.append(Integer.toString(this.minor));
String varD03843288D33B9E1D3062E25339ECF6D_1346181174 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_1346181174.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_1346181174;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(16);
        //buffer.append(this.protocol);
        //buffer.append('/');
        //buffer.append(Integer.toString(this.major));
        //buffer.append('.');
        //buffer.append(Integer.toString(this.minor));
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.986 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "2A8ADE7AE974972D4293AB5DC782C466")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_1165549061 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1165549061.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1165549061;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.986 -0400", hash_original_field = "7C2995A0D26187A1D1CE429F2724E2FB", hash_generated_field = "2E5C9D3BADDF86EB2D1874D5612C1631")

    private static final long serialVersionUID = 8950662842175091068L;
}

