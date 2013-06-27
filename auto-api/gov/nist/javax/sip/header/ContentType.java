package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.ContentTypeHeader;
import java.text.ParseException;

public class ContentType extends ParametersHeader implements javax.sip.header.ContentTypeHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.950 -0400", hash_original_field = "658105D0D44EEADF22FE9B4C6C740531", hash_generated_field = "FE54B36640417CD311E956ED780B7202")

    protected MediaRange mediaRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.950 -0400", hash_original_method = "DFB0ACA07F1EF34999053FFFBC3153AF", hash_generated_method = "D69CDBB6EDF548FF307DB3C54F1E561D")
    public  ContentType() {
        super(CONTENT_TYPE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.960 -0400", hash_original_method = "97EC00F8B2220E42E6B0126E7CC0F3E7", hash_generated_method = "86207ABBEC84EF02BBB88B8E1E0958C0")
    public  ContentType(String contentType, String contentSubtype) {
        this();
        this.setContentType(contentType, contentSubtype);
        addTaint(contentType.getTaint());
        addTaint(contentSubtype.getTaint());
        // ---------- Original Method ----------
        //this.setContentType(contentType, contentSubtype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.963 -0400", hash_original_method = "2022581A914A53DEAB486C7C21721639", hash_generated_method = "934D3BB6F34145922A557006EF04DAB5")
    public int compareMediaRange(String media) {
        int var31BD664D906CC223AB49E1F3E17406AD_1741654784 = ((
            mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            media));
        addTaint(media.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158375487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158375487;
        // ---------- Original Method ----------
        //return (
            //mediaRange.type + "/" + mediaRange.subtype).compareToIgnoreCase(
            //media);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.965 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "6652B033EF1DD73B27C6000F35E03866")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1562605991 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1562605991 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1562605991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1562605991;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.965 -0400", hash_original_method = "2667754E6FC706178FFA281551626F8E", hash_generated_method = "9ADC31CB7F72EF4B2BF6EF28FD54E536")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1315205257 = null; //Variable for return #1
        mediaRange.encode(buffer);
        {
            boolean var866376E1CB223B1F9654A217121E1D39_830010724 = (hasParameters());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1315205257 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1315205257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1315205257;
        // ---------- Original Method ----------
        //mediaRange.encode(buffer);
        //if (hasParameters()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.969 -0400", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "F27A218DEA2B9912482455B5CA21D02E")
    public MediaRange getMediaRange() {
        MediaRange varB4EAC82CA7396A68D541C85D26508E83_1943135010 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1943135010 = mediaRange;
        varB4EAC82CA7396A68D541C85D26508E83_1943135010.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1943135010;
        // ---------- Original Method ----------
        //return mediaRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.969 -0400", hash_original_method = "71A8EC95A25C2B8732F46A6E9FE1A552", hash_generated_method = "FF738299568EE5C23A38E135F0E59A77")
    public String getMediaType() {
        String varB4EAC82CA7396A68D541C85D26508E83_935118428 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_935118428 = mediaRange.type;
        varB4EAC82CA7396A68D541C85D26508E83_935118428.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_935118428;
        // ---------- Original Method ----------
        //return mediaRange.type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.970 -0400", hash_original_method = "EEE1854610A538C776591DF3242D2F30", hash_generated_method = "0223B5663F43CA735D8A007A5C666977")
    public String getMediaSubType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1011885847 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1011885847 = mediaRange.subtype;
        varB4EAC82CA7396A68D541C85D26508E83_1011885847.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1011885847;
        // ---------- Original Method ----------
        //return mediaRange.subtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.976 -0400", hash_original_method = "8BA245F79ADA117CDC825C68939B2C5E", hash_generated_method = "BFCB21B95415E54E2B28D6ADC4CDE0DB")
    public String getContentSubType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1586984798 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1586984798 = mediaRange == null ? null : mediaRange.getSubtype();
        varB4EAC82CA7396A68D541C85D26508E83_1586984798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1586984798;
        // ---------- Original Method ----------
        //return mediaRange == null ? null : mediaRange.getSubtype();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.977 -0400", hash_original_method = "13593DF0637733E8B4FF50555F8020B8", hash_generated_method = "1D4F706F1D921A7260655BE548E63783")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1497228098 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1497228098 = mediaRange == null ? null : mediaRange.getType();
        varB4EAC82CA7396A68D541C85D26508E83_1497228098.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1497228098;
        // ---------- Original Method ----------
        //return mediaRange == null ? null : mediaRange.getType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.980 -0400", hash_original_method = "706F14B8E3FC5B0A8E41E785E1C48F47", hash_generated_method = "9FB5D34F92A0E7D135AE0FD76D12330E")
    public String getCharset() {
        String varB4EAC82CA7396A68D541C85D26508E83_368371999 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_368371999 = this.getParameter("charset");
        varB4EAC82CA7396A68D541C85D26508E83_368371999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_368371999;
        // ---------- Original Method ----------
        //return this.getParameter("charset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.981 -0400", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "D4B8159947A4E1D723FD3764612CBB21")
    public void setMediaRange(MediaRange m) {
        mediaRange = m;
        // ---------- Original Method ----------
        //mediaRange = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.981 -0400", hash_original_method = "255C5DEA7C1BA0115D227FF364F117E1", hash_generated_method = "EBFDDF745E83CABF77C90F6B8FE5952E")
    public void setContentType(String contentType, String contentSubType) {
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        mediaRange.setSubtype(contentSubType);
        addTaint(contentType.getTaint());
        addTaint(contentSubType.getTaint());
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(contentType);
        //mediaRange.setSubtype(contentSubType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.981 -0400", hash_original_method = "D590DDC03635869B8BF7D8A74B8AFC87", hash_generated_method = "B0DBAED4DC7BE314DF6A6E676B859217")
    public void setContentType(String contentType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        mediaRange = new MediaRange();
        mediaRange.setType(contentType);
        addTaint(contentType.getTaint());
        // ---------- Original Method ----------
        //if (contentType == null)
            //throw new NullPointerException("null arg");
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(contentType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.989 -0400", hash_original_method = "0B1F5B2677CEADEDD2A1902A7B2F0CE3", hash_generated_method = "11C51D08A662385FB0CA20E9C93988EC")
    public void setContentSubType(String contentType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        mediaRange = new MediaRange();
        mediaRange.setSubtype(contentType);
        addTaint(contentType.getTaint());
        // ---------- Original Method ----------
        //if (contentType == null)
            //throw new NullPointerException("null arg");
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setSubtype(contentType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.991 -0400", hash_original_method = "EAF7A0BAA68C7F455EB82B27B83B3C3F", hash_generated_method = "14F23737747ECC2267D3993ECCBD263D")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1044839198 = null; //Variable for return #1
        ContentType retval;
        retval = (ContentType) super.clone();
        retval.mediaRange = (MediaRange) this.mediaRange.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1044839198 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1044839198.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1044839198;
        // ---------- Original Method ----------
        //ContentType retval = (ContentType) super.clone();
        //if (this.mediaRange != null)
            //retval.mediaRange = (MediaRange) this.mediaRange.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.992 -0400", hash_original_method = "34166B5115AC7B46D5451CCD077A72C8", hash_generated_method = "DE207782E642A59AE2C0FFC8B0A7C63B")
    public boolean equals(Object other) {
        {
            ContentTypeHeader o;
            o = (ContentTypeHeader) other;
            boolean varD4B944F37DAA43CBA4FEF8DB5969C12E_249950310 = (this.getContentType().equalsIgnoreCase( o.getContentType() )
                && this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                && equalParameters( o ));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118719592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118719592;
        // ---------- Original Method ----------
        //if (other instanceof ContentTypeHeader) {
            //final ContentTypeHeader o = (ContentTypeHeader) other;
            //return this.getContentType().equalsIgnoreCase( o.getContentType() )
                //&& this.getContentSubType().equalsIgnoreCase( o.getContentSubType() )
                //&& equalParameters( o );
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.992 -0400", hash_original_field = "7EC829A2BDD9F0C20CFC8BC464500A23", hash_generated_field = "88288C690EF97502D73CA158A39907C5")

    private static long serialVersionUID = 8475682204373446610L;
}

