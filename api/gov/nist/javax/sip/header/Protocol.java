package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;






public class Protocol extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.715 -0400", hash_original_field = "0AACAAD803286A486455DA9B0035B980", hash_generated_field = "C766D4C5CA44A223EF8697E2A0C74072")

    protected String protocolName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.715 -0400", hash_original_field = "E5EB1B1AE3E23C45B744E3125FC5B3E7", hash_generated_field = "D5DF73E283251EA2D1226355FFEB1D1C")

    protected String protocolVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.715 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.716 -0400", hash_original_method = "B029C737A70A786967A2F293EBAB35D1", hash_generated_method = "DEE5EC031EDC612478B0E1C953847222")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.716 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "87D759CB7A30E85AF8AD339442C0276C")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1069459528 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1069459528.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1069459528;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.716 -0400", hash_original_method = "5917804CC8541DAC2CA5A0DEC050E620", hash_generated_method = "3099A7A1EB6955148AA44AEAFE56CF5A")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(protocolName.toUpperCase())
                .append(SLASH)
                .append(protocolVersion)
                .append(SLASH)
                .append(transport.toUpperCase());
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_468305709 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_468305709.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_468305709;
        // ---------- Original Method ----------
        //buffer.append(protocolName.toUpperCase())
                //.append(SLASH)
                //.append(protocolVersion)
                //.append(SLASH)
                //.append(transport.toUpperCase());
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.717 -0400", hash_original_method = "0EA6E7D3A9B59E59CEEBB8D3EE9D071C", hash_generated_method = "4182F301CD1D7298B97FD51D5FB7B42E")
    public String getProtocolName() {
String var45474CC388B4F52DAFE20A4369F8BE7C_643176479 =         protocolName;
        var45474CC388B4F52DAFE20A4369F8BE7C_643176479.addTaint(taint);
        return var45474CC388B4F52DAFE20A4369F8BE7C_643176479;
        // ---------- Original Method ----------
        //return protocolName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.717 -0400", hash_original_method = "B8FA221EC0DA8944EFD0CEB861346936", hash_generated_method = "8D20E7389648D510EE9CB4AFD2B8E4CA")
    public String getProtocolVersion() {
String var3CDE05F2C7D524E8DF5DB73F2146C98E_372115808 =         protocolVersion;
        var3CDE05F2C7D524E8DF5DB73F2146C98E_372115808.addTaint(taint);
        return var3CDE05F2C7D524E8DF5DB73F2146C98E_372115808;
        // ---------- Original Method ----------
        //return protocolVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.717 -0400", hash_original_method = "3E5201C0CB5C46DC512CD40707A0CB06", hash_generated_method = "A4ED2D5D8D7830B0795BA0F8D83FC6FB")
    public String getProtocol() {
String var8E89C14E271D89CD67AFB79E2F47F729_1180137627 =         protocolName + '/' + protocolVersion;
        var8E89C14E271D89CD67AFB79E2F47F729_1180137627.addTaint(taint);
        return var8E89C14E271D89CD67AFB79E2F47F729_1180137627;
        // ---------- Original Method ----------
        //return protocolName + '/' + protocolVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.718 -0400", hash_original_method = "095B78DD27D74EBF49777967A681F20E", hash_generated_method = "D7D59B8E50157A0CB1DB35198F01DBFE")
    public void setProtocol( String name_and_version ) throws ParseException {
        int slash = name_and_version.indexOf('/');
        if(slash>0)        
        {
            this.protocolName = name_and_version.substring(0,slash);
            this.protocolVersion = name_and_version.substring( slash+1 );
        } //End block
        else
        {
        ParseException varD02F6018221BD0D886CD8F0C0CCE6E8B_1484294893 = new ParseException( "Missing '/' in protocol", 0 );
        varD02F6018221BD0D886CD8F0C0CCE6E8B_1484294893.addTaint(taint);
        throw varD02F6018221BD0D886CD8F0C0CCE6E8B_1484294893;
        }
        // ---------- Original Method ----------
        //int slash = name_and_version.indexOf('/');
        //if (slash>0) {
            //this.protocolName = name_and_version.substring(0,slash);
            //this.protocolVersion = name_and_version.substring( slash+1 );
        //} else throw new ParseException( "Missing '/' in protocol", 0 );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.718 -0400", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "C2724F28C4189EF8031CAC1E33BA7B4D")
    public String getTransport() {
String var6D37A12806110C538EDC9272068F264D_1511462008 =         transport;
        var6D37A12806110C538EDC9272068F264D_1511462008.addTaint(taint);
        return var6D37A12806110C538EDC9272068F264D_1511462008;
        // ---------- Original Method ----------
        //return transport;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.718 -0400", hash_original_method = "D424701D0BAFF5CEC55A80344E30BD30", hash_generated_method = "B4D21ACCA657B794F87AC481BEFA63A6")
    public void setProtocolName(String p) {
        protocolName = p;
        // ---------- Original Method ----------
        //protocolName = p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.718 -0400", hash_original_method = "2A792840748FAB978DAA68C8F2495344", hash_generated_method = "3746DD0FB723CD5F349A9341429551FC")
    public void setProtocolVersion(String p) {
        protocolVersion = p;
        // ---------- Original Method ----------
        //protocolVersion = p;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.719 -0400", hash_original_method = "2F1F81EB1D8D9B12E2B4CE0AEE6CB155", hash_generated_method = "6E2B7DAB33C44857128202FB176B4870")
    public void setTransport(String t) {
        transport = t;
        // ---------- Original Method ----------
        //transport = t;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.740 -0400", hash_original_field = "0425D558ED819B68833B3D1A2F581952", hash_generated_field = "51FBF3C81D0285A3EC2B590DCDB910C8")

    private static final long serialVersionUID = 2216758055974073280L;
}

