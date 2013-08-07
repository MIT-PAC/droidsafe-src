package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.ExtensionHeader;
import javax.sip.header.SIPETagHeader;






public class SIPETag extends SIPHeader implements SIPETagHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.157 -0400", hash_original_field = "BF2C63393DC4B17F2F6428EBE8608DDC", hash_generated_field = "885FC2B59F698305A2C8A7BD5CC3FE18")

    protected String entityTag;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.157 -0400", hash_original_method = "BAC01810EAA501495132ECB89EEE2B88", hash_generated_method = "5AAB108C68C33BB6DA943351B9383C7C")
    public  SIPETag() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.158 -0400", hash_original_method = "85BBFA4AA70935C1ADD9E51D03FF73BB", hash_generated_method = "C6A7745E5CB45C52A4FD10CF9FC79528")
    public  SIPETag( String tag ) throws ParseException {
        this();
        addTaint(tag.getTaint());
        this.setETag( tag );
        // ---------- Original Method ----------
        //this.setETag( tag );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.158 -0400", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "FA8774E5880A9D0BD78EBC1D79B119B7")
    public String encodeBody() {
String var6F841ECF197400A993B46628101FE372_2010298401 =         entityTag;
        var6F841ECF197400A993B46628101FE372_2010298401.addTaint(taint);
        return var6F841ECF197400A993B46628101FE372_2010298401;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.158 -0400", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "3E343381547DC94E591FC05E8446FDF0")
    public String getETag() {
String var6F841ECF197400A993B46628101FE372_1551770237 =         entityTag;
        var6F841ECF197400A993B46628101FE372_1551770237.addTaint(taint);
        return var6F841ECF197400A993B46628101FE372_1551770237;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.159 -0400", hash_original_method = "3B3373A48DF283BBF1E69590D4AF600C", hash_generated_method = "D15CB404483D1051126652BF4CA77365")
    public void setETag(String etag) throws ParseException {
        if(etag == null)        
        {
        NullPointerException var9D499767AB2ACFAA821A1A3F3CD5B1ED_896135497 = new NullPointerException(
                "JAIN-SIP Exception,"
                    + "SIP-ETag, setETag(), the etag parameter is null");
        var9D499767AB2ACFAA821A1A3F3CD5B1ED_896135497.addTaint(taint);
        throw var9D499767AB2ACFAA821A1A3F3CD5B1ED_896135497;
        }
        this.entityTag = etag;
        // ---------- Original Method ----------
        //if (etag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "SIP-ETag, setETag(), the etag parameter is null");
        //this.entityTag = etag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.159 -0400", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "A8A2B2114609A7D3128BB34B68EE199C")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        this.setETag(value);
        // ---------- Original Method ----------
        //this.setETag(value);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.159 -0400", hash_original_field = "3D8EC3476CBB37E2927F46568F68EF12", hash_generated_field = "75F9A7A2BBA768EF1EE411D5045B2982")

    private static final long serialVersionUID = 3837543366074322107L;
}

