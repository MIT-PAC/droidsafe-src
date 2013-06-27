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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.463 -0400", hash_original_field = "BF2C63393DC4B17F2F6428EBE8608DDC", hash_generated_field = "885FC2B59F698305A2C8A7BD5CC3FE18")

    protected String entityTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.464 -0400", hash_original_method = "BAC01810EAA501495132ECB89EEE2B88", hash_generated_method = "5AAB108C68C33BB6DA943351B9383C7C")
    public  SIPETag() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.464 -0400", hash_original_method = "85BBFA4AA70935C1ADD9E51D03FF73BB", hash_generated_method = "9734D15357285B4E1526E2A2B0490DB9")
    public  SIPETag( String tag ) throws ParseException {
        this();
        this.setETag( tag );
        addTaint(tag.getTaint());
        // ---------- Original Method ----------
        //this.setETag( tag );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.473 -0400", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "B365F7658A14340557E92297372FF85F")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1249145186 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1249145186 = entityTag;
        varB4EAC82CA7396A68D541C85D26508E83_1249145186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1249145186;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.474 -0400", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "E52B0B89824BA0B7A607C0793957CDA1")
    public String getETag() {
        String varB4EAC82CA7396A68D541C85D26508E83_396626155 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_396626155 = entityTag;
        varB4EAC82CA7396A68D541C85D26508E83_396626155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_396626155;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.475 -0400", hash_original_method = "3B3373A48DF283BBF1E69590D4AF600C", hash_generated_method = "31A72CA55A29C4B27AE3F8EB83238042")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.476 -0400", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "7DD11F493A7299AABB7E7F1CBD69148E")
    public void setValue(String value) throws ParseException {
        this.setETag(value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //this.setETag(value);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.476 -0400", hash_original_field = "3D8EC3476CBB37E2927F46568F68EF12", hash_generated_field = "0ACCB148F242BE49E4172613391D4248")

    private static long serialVersionUID = 3837543366074322107L;
}

