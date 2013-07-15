package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public class Protocol extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.698 -0400", hash_original_field = "0AACAAD803286A486455DA9B0035B980", hash_generated_field = "C766D4C5CA44A223EF8697E2A0C74072")

    protected String protocolName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.698 -0400", hash_original_field = "E5EB1B1AE3E23C45B744E3125FC5B3E7", hash_generated_field = "D5DF73E283251EA2D1226355FFEB1D1C")

    protected String protocolVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.698 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.699 -0400", hash_original_method = "B029C737A70A786967A2F293EBAB35D1", hash_generated_method = "DEE5EC031EDC612478B0E1C953847222")
    public  Protocol() {
        protocolName = "SIP";
        protocolVersion = "2.0";
        transport = "UDP";
        // ---------- Original Method ----------
        //protocolName = "SIP";
        //protocolVersion = "2.0";
        //transport = "UDP";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.699 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "E6A5DFDEF2AF3E0179E136FD67828BB8")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1894247659 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1894247659.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1894247659;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.700 -0400", hash_original_method = "5917804CC8541DAC2CA5A0DEC050E620", hash_generated_method = "07C87E7DA4B0DE6BCF4419DDBBE687AA")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(protocolName.toUpperCase())
                .append(SLASH)
                .append(protocolVersion)
                .append(SLASH)
                .append(transport.toUpperCase());
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_178975308 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_178975308.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_178975308;
        // ---------- Original Method ----------
        //buffer.append(protocolName.toUpperCase())
                //.append(SLASH)
                //.append(protocolVersion)
                //.append(SLASH)
                //.append(transport.toUpperCase());
        //return buffer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.700 -0400", hash_original_method = "0EA6E7D3A9B59E59CEEBB8D3EE9D071C", hash_generated_method = "7EAD8E6F0D81F7248061DC95BE0A3F0C")
    public String getProtocolName() {
String var45474CC388B4F52DAFE20A4369F8BE7C_966387181 =         protocolName;
        var45474CC388B4F52DAFE20A4369F8BE7C_966387181.addTaint(taint);
        return var45474CC388B4F52DAFE20A4369F8BE7C_966387181;
        // ---------- Original Method ----------
        //return protocolName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.700 -0400", hash_original_method = "B8FA221EC0DA8944EFD0CEB861346936", hash_generated_method = "E6285770BE9717653FC54537B4A5518C")
    public String getProtocolVersion() {
String var3CDE05F2C7D524E8DF5DB73F2146C98E_1787358583 =         protocolVersion;
        var3CDE05F2C7D524E8DF5DB73F2146C98E_1787358583.addTaint(taint);
        return var3CDE05F2C7D524E8DF5DB73F2146C98E_1787358583;
        // ---------- Original Method ----------
        //return protocolVersion;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.700 -0400", hash_original_method = "3E5201C0CB5C46DC512CD40707A0CB06", hash_generated_method = "F50E1184E1ED6150D44328290977D52B")
    public String getProtocol() {
String var8E89C14E271D89CD67AFB79E2F47F729_569119124 =         protocolName + '/' + protocolVersion;
        var8E89C14E271D89CD67AFB79E2F47F729_569119124.addTaint(taint);
        return var8E89C14E271D89CD67AFB79E2F47F729_569119124;
        // ---------- Original Method ----------
        //return protocolName + '/' + protocolVersion;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.701 -0400", hash_original_method = "095B78DD27D74EBF49777967A681F20E", hash_generated_method = "F045626F70C647007945D04160E0C987")
    public void setProtocol( String name_and_version ) throws ParseException {
        int slash = name_and_version.indexOf('/');
    if(slash>0)        
        {
            this.protocolName = name_and_version.substring(0,slash);
            this.protocolVersion = name_and_version.substring( slash+1 );
        } //End block
        else
        {
        ParseException varD02F6018221BD0D886CD8F0C0CCE6E8B_957408328 = new ParseException( "Missing '/' in protocol", 0 );
        varD02F6018221BD0D886CD8F0C0CCE6E8B_957408328.addTaint(taint);
        throw varD02F6018221BD0D886CD8F0C0CCE6E8B_957408328;
        }
        // ---------- Original Method ----------
        //int slash = name_and_version.indexOf('/');
        //if (slash>0) {
            //this.protocolName = name_and_version.substring(0,slash);
            //this.protocolVersion = name_and_version.substring( slash+1 );
        //} else throw new ParseException( "Missing '/' in protocol", 0 );
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.702 -0400", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "D08F2EEDC8D2B2AFB29206837B219371")
    public String getTransport() {
String var6D37A12806110C538EDC9272068F264D_1209570334 =         transport;
        var6D37A12806110C538EDC9272068F264D_1209570334.addTaint(taint);
        return var6D37A12806110C538EDC9272068F264D_1209570334;
        // ---------- Original Method ----------
        //return transport;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.702 -0400", hash_original_method = "D424701D0BAFF5CEC55A80344E30BD30", hash_generated_method = "B4D21ACCA657B794F87AC481BEFA63A6")
    public void setProtocolName(String p) {
        protocolName = p;
        // ---------- Original Method ----------
        //protocolName = p;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.703 -0400", hash_original_method = "2A792840748FAB978DAA68C8F2495344", hash_generated_method = "3746DD0FB723CD5F349A9341429551FC")
    public void setProtocolVersion(String p) {
        protocolVersion = p;
        // ---------- Original Method ----------
        //protocolVersion = p;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.703 -0400", hash_original_method = "2F1F81EB1D8D9B12E2B4CE0AEE6CB155", hash_generated_method = "6E2B7DAB33C44857128202FB176B4870")
    public void setTransport(String t) {
        transport = t;
        // ---------- Original Method ----------
        //transport = t;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.703 -0400", hash_original_field = "0425D558ED819B68833B3D1A2F581952", hash_generated_field = "51FBF3C81D0285A3EC2B590DCDB910C8")

    private static final long serialVersionUID = 2216758055974073280L;
}

