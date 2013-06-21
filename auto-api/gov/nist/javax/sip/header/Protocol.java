package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public class Protocol extends SIPObject {
    protected String protocolName;
    protected String protocolVersion;
    protected String transport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.072 -0400", hash_original_method = "B029C737A70A786967A2F293EBAB35D1", hash_generated_method = "DEE5EC031EDC612478B0E1C953847222")
    @DSModeled(DSC.SAFE)
    public Protocol() {
        protocolName = "SIP";
        protocolVersion = "2.0";
        transport = "UDP";
        // ---------- Original Method ----------
        //protocolName = "SIP";
        //protocolVersion = "2.0";
        //transport = "UDP";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.072 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "045724D9D584956965CCE5F546BA64B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_529114237 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.073 -0400", hash_original_method = "5917804CC8541DAC2CA5A0DEC050E620", hash_generated_method = "2E7572062869F1FAE58F1E166DF5323A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append(protocolName.toUpperCase())
                .append(SLASH)
                .append(protocolVersion)
                .append(SLASH)
                .append(transport.toUpperCase());
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //buffer.append(protocolName.toUpperCase())
                //.append(SLASH)
                //.append(protocolVersion)
                //.append(SLASH)
                //.append(transport.toUpperCase());
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.073 -0400", hash_original_method = "0EA6E7D3A9B59E59CEEBB8D3EE9D071C", hash_generated_method = "E9896D8BF2556D1592C28724DDC433E8")
    @DSModeled(DSC.SAFE)
    public String getProtocolName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return protocolName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.073 -0400", hash_original_method = "B8FA221EC0DA8944EFD0CEB861346936", hash_generated_method = "69BBB3A4E8D06AA859C1071FE4CF429F")
    @DSModeled(DSC.SAFE)
    public String getProtocolVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return protocolVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.073 -0400", hash_original_method = "3E5201C0CB5C46DC512CD40707A0CB06", hash_generated_method = "16E3757CC9BE6A5032DA2ED61F224B76")
    @DSModeled(DSC.SAFE)
    public String getProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return protocolName + '/' + protocolVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.074 -0400", hash_original_method = "095B78DD27D74EBF49777967A681F20E", hash_generated_method = "A01C31957BDA8CB30CEC2A9ECE9D7EAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProtocol( String name_and_version ) throws ParseException {
        dsTaint.addTaint(name_and_version);
        int slash;
        slash = name_and_version.indexOf('/');
        {
            this.protocolName = name_and_version.substring(0,slash);
            this.protocolVersion = name_and_version.substring( slash+1 );
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new ParseException( "Missing '/' in protocol", 0 );
        // ---------- Original Method ----------
        //int slash = name_and_version.indexOf('/');
        //if (slash>0) {
            //this.protocolName = name_and_version.substring(0,slash);
            //this.protocolVersion = name_and_version.substring( slash+1 );
        //} else throw new ParseException( "Missing '/' in protocol", 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.074 -0400", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "A383C7CD7096907044A0294560B62BAB")
    @DSModeled(DSC.SAFE)
    public String getTransport() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.074 -0400", hash_original_method = "D424701D0BAFF5CEC55A80344E30BD30", hash_generated_method = "CF9C198E619BB90BD50D4669C01B6ADE")
    @DSModeled(DSC.SAFE)
    public void setProtocolName(String p) {
        dsTaint.addTaint(p);
        // ---------- Original Method ----------
        //protocolName = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.074 -0400", hash_original_method = "2A792840748FAB978DAA68C8F2495344", hash_generated_method = "0AD3E2DF52CD0D2B0CBC6BCEC056EDE1")
    @DSModeled(DSC.SAFE)
    public void setProtocolVersion(String p) {
        dsTaint.addTaint(p);
        // ---------- Original Method ----------
        //protocolVersion = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.074 -0400", hash_original_method = "2F1F81EB1D8D9B12E2B4CE0AEE6CB155", hash_generated_method = "7D2A4769205898B34CA1CA4015A5863B")
    @DSModeled(DSC.SAFE)
    public void setTransport(String t) {
        dsTaint.addTaint(t);
        // ---------- Original Method ----------
        //transport = t;
    }

    
    private static final long serialVersionUID = 2216758055974073280L;
}

