package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;

public class SIPIfMatch extends SIPHeader implements SIPIfMatchHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.518 -0400", hash_original_field = "BF2C63393DC4B17F2F6428EBE8608DDC", hash_generated_field = "885FC2B59F698305A2C8A7BD5CC3FE18")

    protected String entityTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.519 -0400", hash_original_method = "BAD2DC814CD45D5939615C62F83835FA", hash_generated_method = "BC1325341205D047D33E2F234910D97F")
    public  SIPIfMatch() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.519 -0400", hash_original_method = "3D0893288CE2D1B79B07387D603E62DB", hash_generated_method = "C2B817AF0BFED883E169B2CFF5E393C0")
    public  SIPIfMatch(String etag) throws ParseException {
        this();
        this.setETag( etag );
        addTaint(etag.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.519 -0400", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "FB892F017D6B3B228CA16114B7D3B0A7")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1341785774 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1341785774 = entityTag;
        varB4EAC82CA7396A68D541C85D26508E83_1341785774.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1341785774;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.520 -0400", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "354685B29C17620B27508CF5F7855B93")
    public String getETag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1131914147 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1131914147 = entityTag;
        varB4EAC82CA7396A68D541C85D26508E83_1131914147.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1131914147;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.520 -0400", hash_original_method = "FF09F62ACDB51364A1C119FC09E0694A", hash_generated_method = "F7E6519A391EB1412E3F2E8FA4C17DA3")
    public void setETag(String etag) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "SIP-If-Match, setETag(), the etag parameter is null");
        this.entityTag = etag;
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.520 -0400", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "7DD11F493A7299AABB7E7F1CBD69148E")
    public void setValue(String value) throws ParseException {
        this.setETag(value);
        addTaint(value.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.520 -0400", hash_original_field = "54B1BEC1DAECBE024DEB1918FCD60093", hash_generated_field = "F99AB9EB7E164B071039EF12AA230274")

    private static final long serialVersionUID = 3833745477828359730L;
}

