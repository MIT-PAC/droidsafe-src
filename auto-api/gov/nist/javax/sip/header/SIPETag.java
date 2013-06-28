package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;

public class SIPETag extends SIPHeader implements SIPETagHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.283 -0400", hash_original_field = "BF2C63393DC4B17F2F6428EBE8608DDC", hash_generated_field = "885FC2B59F698305A2C8A7BD5CC3FE18")

    protected String entityTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.283 -0400", hash_original_method = "BAC01810EAA501495132ECB89EEE2B88", hash_generated_method = "5AAB108C68C33BB6DA943351B9383C7C")
    public  SIPETag() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.284 -0400", hash_original_method = "85BBFA4AA70935C1ADD9E51D03FF73BB", hash_generated_method = "9734D15357285B4E1526E2A2B0490DB9")
    public  SIPETag( String tag ) throws ParseException {
        this();
        this.setETag( tag );
        addTaint(tag.getTaint());
        // ---------- Original Method ----------
        //this.setETag( tag );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.284 -0400", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "E5608824EE5212D7B191CAD6754532EA")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1519203257 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1519203257 = entityTag;
        varB4EAC82CA7396A68D541C85D26508E83_1519203257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1519203257;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.285 -0400", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "0290A5AB195A7336152161014BF3FE6A")
    public String getETag() {
        String varB4EAC82CA7396A68D541C85D26508E83_961225449 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_961225449 = entityTag;
        varB4EAC82CA7396A68D541C85D26508E83_961225449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_961225449;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.286 -0400", hash_original_method = "3B3373A48DF283BBF1E69590D4AF600C", hash_generated_method = "31A72CA55A29C4B27AE3F8EB83238042")
    public void setETag(String etag) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "SIP-ETag, setETag(), the etag parameter is null");
        this.entityTag = etag;
        // ---------- Original Method ----------
        //if (etag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "SIP-ETag, setETag(), the etag parameter is null");
        //this.entityTag = etag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.286 -0400", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "7DD11F493A7299AABB7E7F1CBD69148E")
    public void setValue(String value) throws ParseException {
        this.setETag(value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.setETag(value);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.286 -0400", hash_original_field = "3D8EC3476CBB37E2927F46568F68EF12", hash_generated_field = "75F9A7A2BBA768EF1EE411D5045B2982")

    private static final long serialVersionUID = 3837543366074322107L;
}

