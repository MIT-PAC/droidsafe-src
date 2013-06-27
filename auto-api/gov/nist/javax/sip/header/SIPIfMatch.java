package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;

public class SIPIfMatch extends SIPHeader implements SIPIfMatchHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.573 -0400", hash_original_field = "BF2C63393DC4B17F2F6428EBE8608DDC", hash_generated_field = "885FC2B59F698305A2C8A7BD5CC3FE18")

    protected String entityTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.573 -0400", hash_original_method = "BAD2DC814CD45D5939615C62F83835FA", hash_generated_method = "BC1325341205D047D33E2F234910D97F")
    public  SIPIfMatch() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.574 -0400", hash_original_method = "3D0893288CE2D1B79B07387D603E62DB", hash_generated_method = "C2B817AF0BFED883E169B2CFF5E393C0")
    public  SIPIfMatch(String etag) throws ParseException {
        this();
        this.setETag( etag );
        addTaint(etag.getTaint());
        // ---------- Original Method ----------
        //this.setETag( etag );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.574 -0400", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "4B0DF235BCD84F0047C8D52E10B72D0E")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_219808830 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_219808830 = entityTag;
        varB4EAC82CA7396A68D541C85D26508E83_219808830.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_219808830;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.574 -0400", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "EA7EB8F14B9AB7C26CC4273006503320")
    public String getETag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1426561590 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1426561590 = entityTag;
        varB4EAC82CA7396A68D541C85D26508E83_1426561590.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1426561590;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.575 -0400", hash_original_method = "FF09F62ACDB51364A1C119FC09E0694A", hash_generated_method = "F7E6519A391EB1412E3F2E8FA4C17DA3")
    public void setETag(String etag) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "SIP-If-Match, setETag(), the etag parameter is null");
        this.entityTag = etag;
        // ---------- Original Method ----------
        //if (etag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "SIP-If-Match, setETag(), the etag parameter is null");
        //this.entityTag = etag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.575 -0400", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "7DD11F493A7299AABB7E7F1CBD69148E")
    public void setValue(String value) throws ParseException {
        this.setETag(value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.setETag(value);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.575 -0400", hash_original_field = "54B1BEC1DAECBE024DEB1918FCD60093", hash_generated_field = "3A132D0A07F86761277C4E6758FA1593")

    private static long serialVersionUID = 3833745477828359730L;
}

